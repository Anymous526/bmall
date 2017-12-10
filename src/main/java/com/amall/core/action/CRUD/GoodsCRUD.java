package com.amall.core.action.CRUD;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.Globals;
import com.amall.common.tools.CNNumberUtils;
import com.amall.common.tools.Json;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.Goods;
import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.service.goods.IGoods2PhotoService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.image.IAccessoryService;

@Component
public class GoodsCRUD
{

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoods2PhotoService goods2PhotoService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsSpecService goodsSpecService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private CartCRUD cartCRUD;

	@Autowired
	private OrderCRUD orderCRUD;

	/**
	 * @Title: getGoodsClassById
	 * @Description: 根据商品类型ID获取商品类型信息
	 */
	public GoodsWithBLOBs getGoodsById (Long id)
	{
		GoodsWithBLOBs goods = this.goodsService.getByKey (CNNumberUtils.null2Long (id));
		return goods;
	}
	/**
	 * @Title: updateGoods
	 * @Description: 更新商品信息
	 */
	public Integer updateGoods (GoodsWithBLOBs goods)
	{
		return this.goodsService.updateByObject (goods);
	}
	/**
	 * @Title: getGoodsPhotoListByGoodsId
	 * @Description: 根据商品ID获取商图片列表
	 */
	public List <Accessory> getGoodsPhotoListByGoodsId (Long goodsId)
	{
		List <Accessory> accessorys = new ArrayList <Accessory> ();
		// 通过查询中间表获得所有与商品对应的图片，并获取图片的id集合
		Goods2PhotoExample goods2PhotoExample = new Goods2PhotoExample ();
		goods2PhotoExample.createCriteria ().andGoodsIdEqualTo (goodsId);
		List <Goods2Photo> goods2Photolist = this.goods2PhotoService.getObjectList (goods2PhotoExample);
		List <Long> ids = new ArrayList <Long> ();
		for (Goods2Photo g : goods2Photolist)
		{
			ids.add (g.getPhotoId ());
		}
		// 通过id集合查询到图片，并设置到商品的属性中去
		if (ids.size () > 0)
		{
			AccessoryExample accessoryExample = new AccessoryExample ();
			accessoryExample.createCriteria ().andIdIn (ids);
			accessorys = this.accessoryService.getObjectList (accessoryExample);
		}
		return accessorys;
	}
	/**
	 * @Title: getGoodsSpecPropertyListBySpecId
	 * @Description: 根据SpecID获取Property
	 */
	public List <GoodsSpecProperty> getGoodsSpecPropertyListBySpecId (Long specId)
	{
		GoodsSpecPropertyExample goodsSpecPropertyExample = new GoodsSpecPropertyExample ();
		goodsSpecPropertyExample.clear ();
		goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (specId);
		List <GoodsSpecProperty> gps = this.goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
		return gps;
	}
	/**
	 * @Title: getStoreHashSetOfGoodsId
	 * @Description: 根据商品Id List找到店铺
	 * @param ids
	 * @return
	 * @return HashSet<Store>
	 * @author tangxiang
	 * @date 2015年8月11日 下午4:22:05
	 */
	public List <Long> getStoreHashSetOfGoodsId (List <Long> ids)
	{
		List <Long> storeIds = new ArrayList <> ();
		/* 获取店铺ID */
		for (Long id : ids)
		{
			if (!storeIds.contains (id))
			{
				storeIds.add (this.goodsService.getByKey (id).getGoodsStoreId ());
			}
		}
		return storeIds;
	}
	public void fullOrderForm (Goods goods , OrderFormWithBLOBs bloBs , String specInfo , Map <Long, String> shipMap , Long userId , boolean directBuy)
	{
		BigDecimal payment = new BigDecimal (Globals.NUBER_ZERO);
		BigDecimal shipFee = new BigDecimal (Globals.NUBER_ZERO);
		String cartUUID = null;
		OrderFormItem formItem;
		if (!directBuy)
		{
			cartUUID = cartCRUD.isAreadyRecordForCart (userId);
		}
		else
		{
			cartUUID = cartCRUD.getRecordForCartDetail (null , goods.getId () , null , directBuy , false).getGoodsCartId ();
		}
		/* 锁定商品列表信息 */
		CartDetail cartDetail = cartCRUD.getRecordForCartDetail (cartUUID , goods.getId () , specInfo , directBuy , false);
		cartDetail.setDeleteStatus (true);
		cartCRUD.updateCartDetail (cartDetail);
		/* 获取价格 */
		payment = payment.add (cartCRUD.getGoodsPrice (goods.getId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
		/* 获取邮费 */
		if (shipMap.get (goods.getId ()) != null)
		{
			shipFee = shipFee.add (getGoodsTransFee (goods.getId () , shipMap.get (goods.getId ()) , cartDetail.getGoodsCount ()));
		}
		bloBs.setTotalprice (payment.add (shipFee));
		bloBs.setShipPrice (shipFee);
		bloBs.setGoodsAmount (payment);
		this.orderCRUD.addOrderForm (bloBs);
		/* 填充订单详情表 */
		// 根据UUID获得购物车，并取得当中指定id的cartDetail集合，商品id相同的cartDetail可能有多个，因为相同的商品存在规格参数不同
		List <CartDetail> cartDetails = cartCRUD.getRecordForCartDetails (cartUUID , goods.getId () , specInfo , directBuy , true);
		for (CartDetail detail : cartDetails)
		{
			formItem = new OrderFormItem ();
			formItem.setAddTime (new Date ());
			formItem.setDirectBuy (directBuy);
			formItem.setGoodsCount (detail.getGoodsCount ());
			formItem.setGoodsId (goods.getId ());
			formItem.setGoodsName (goods.getGoodsName ());
			formItem.setGoodsPhoto (goods.getGoodsMainPhotoId ());
			if (null != goods.getGc () && null != goods.getGc ().getRate ())
			{
				formItem.setGoodsRate (goods.getGc ().getRate ());
			}
			formItem.setRefundServer (goods.getRefundServerTime ());
			formItem.setGoodsPrice (cartCRUD.getGoodsPrice (goods.getId ()));
			formItem.setSpecInfo (detail.getSpecInfo ());
			formItem.setLeeStatus (false);
			formItem.setOrderId (orderCRUD.getOrderFormOfOrderId (bloBs.getOrderId () , null).getId ());
			this.orderCRUD.addOrderFormItem (formItem);
		}
		/* 生成订单日志记录 */
		OrderFormLog formLog = new OrderFormLog ();
		formLog.setAddtime (new Date ());
		formLog.setLogUserId (bloBs.getUserId ());
		formLog.setStateInfo (bloBs.getOrderStatus ().toString ());
		formLog.setOfId (Long.valueOf (bloBs.getOrderId ()));
		formLog.setLogInfo (Globals.WAIT_PAYMENT_ORDER_NAME);
		orderCRUD.addOrderFormLog (formLog);
	}
	/**
	 * @Title : fullOrderForms
	 * @Deprecated O2O用户生成订单函数
	 * @param goods
	 * @param goodsCounts
	 * @param bloBs
	 * @param specInfo
	 * @param userId
	 * @param directBuy
	 * @author liuguo
	 * @Date 2016/12/15 17:54
	 */
	public void fullOrderForms (Goods goods , String goodsCounts , OrderFormWithBLOBs bloBs , String specInfo , Long userId , boolean directBuy)
	{
		BigDecimal shipFee = new BigDecimal (Globals.NUBER_ZERO);
		OrderFormItem formItem;
		bloBs.setShipPrice (shipFee);
		this.orderCRUD.addOrderForm (bloBs);
		formItem = new OrderFormItem ();
		formItem.setAddTime (new Date ());
		formItem.setDirectBuy (directBuy);
		formItem.setGoodsCount (Integer.valueOf (goodsCounts));
		formItem.setGoodsId (goods.getId ());
		formItem.setGoodsName (goods.getGoodsName ());
		formItem.setGoodsPhoto (goods.getGoodsMainPhotoId ());
		formItem.setGoodsRate (goods.getGc ().getRate ());
		formItem.setRefundServer (goods.getRefundServerTime ());
		formItem.setGoodsPrice (cartCRUD.getGoodsPrice (goods.getId ()));
		if (null != specInfo)
		{
			formItem.setSpecInfo (specInfo);
		}
		formItem.setLeeStatus (false);
		formItem.setOrderId (orderCRUD.getOrderFormOfOrderId (bloBs.getOrderId () , null).getId ());
		this.orderCRUD.addOrderFormItem (formItem);
		/* 生成订单日志记录 */
		OrderFormLog formLog = new OrderFormLog ();
		formLog.setAddtime (new Date ());
		formLog.setLogUserId (bloBs.getUserId ());
		formLog.setStateInfo (bloBs.getOrderStatus ().toString ());
		formLog.setOfId (Long.valueOf (bloBs.getOrderId ()));
		formLog.setLogInfo (Globals.WAIT_PAYMENT_ORDER_NAME);
		orderCRUD.addOrderFormLog (formLog);
	}
	/**
	 * 计算订单内,购买某商品,对应的配送方式,购买的该商品数量,得出的运费
	 * 
	 * @param goodsId
	 *            商品id
	 * @param type
	 *            配送类型
	 * @param count
	 *            商品数量
	 * @return
	 */
	public BigDecimal getGoodsTransFee (Long goodsId , String type , Integer count)
	{
		GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CNNumberUtils.null2Long (goodsId));
		TransportWithBLOBs transportWithBLOBs = goodsWithBLOBs.getTransport ();
		List <Map> list = null;
		if (type.equals ("ems"))
		{
			String emsinfo = transportWithBLOBs.getTransEmsInfo ();
			// json串转object
			list=Json.gson.fromJson (emsinfo , List.class);
			// list = (List) Json.fromJson(List.class, emsinfo);
		}
		if (type.equals ("express"))
		{
			String expressinfo = transportWithBLOBs.getTransExpressInfo ();
			list = Json.gson.fromJson (expressinfo , List.class);
			// list = (List) Json.fromJson(List.class, expressinfo);
		}
		if (type.equals ("mail"))
		{
			String mailinfo = transportWithBLOBs.getTransMailInfo ();
			list = Json.gson.fromJson (mailinfo , List.class);
			// list = (List) Json.fromJson(List.class, mailinfo);
		}
		BigDecimal calFee = BigDecimal.ONE;
		if (list != null)
		{
			Map map = list.get (0);
			BigDecimal transFee = new BigDecimal (map.get ("trans_fee").toString ());
			BigDecimal transAddFee = new BigDecimal (map.get ("trans_add_fee").toString ());
			if (Integer.valueOf (count) > 1)
			{
				calFee = transFee.add (transAddFee.multiply (new BigDecimal ((Integer.valueOf (count) - 1))));
			}
			else
			{
				calFee = transFee;
			}
		}
		return calFee;
	}
	public List <Goods> selectSpecial (GoodsExample example)
	{
		return goodsService.selectByExample (example);
	}
	/**
	 * @Title getClassGoods
	 * @Deprecated 根据 moduleId 获取分类商品
	 * @param moduleId
	 *            楼层ID
	 * @return List<GoodsWithBLOBs>
	 * @author liuguo
	 * @Date 2016/12/09 16:01
	 */
	public List <GoodsWithBLOBs> getClassGoods (Integer moduleId)
	{
		GoodsExample goodsExample = new GoodsExample ();
		goodsExample.clear ();
		goodsExample.createCriteria ().andModuleIdEqualTo (moduleId).andGoodsStatusEqualTo (Globals.NUBER_ZERO);
		List <GoodsWithBLOBs> goodsList = goodsService.getObjectList (goodsExample);
		if (!goodsList.isEmpty ())
		{
			return goodsList;
		}
		else
		{
			return null;
		}
	}
	/**
	 * @Title getGoodsList
	 * @Deprecated 根据storeId 获取该店铺的O2O商品信息
	 * @param storeId
	 * @return List<GoodsWithBLOBs>
	 * @author liuguo
	 * @Date 2016/12/09 16:34
	 */
	public List <GoodsWithBLOBs> getGoodsList (Long storeId)
	{
		GoodsExample goodsExample = new GoodsExample ();
		goodsExample.clear ();
		goodsExample.createCriteria ().andGoodsStoreIdEqualTo (storeId).andModuleIdBetween (1008 , 1015).andGoodsStatusEqualTo (0);
		List <GoodsWithBLOBs> goodsList = goodsService.getObjectList (goodsExample);
		if (!goodsList.isEmpty ())
		{
			return goodsList;
		}
		else
		{
			return null;
		}
	}
}
