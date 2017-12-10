package com.amall.core.action.CRUD;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.amall.common.constant.Globals;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormExample.Criteria;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.IRefundService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.web.tools.CommUtil;

@Component
public class OrderCRUD
{

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private IFavoriteService favoriteService;

	@Autowired
	private Kuaidi100CRUD kuaidi100crud;

	@Autowired
	private CartCRUD cartCRUD;

	@Autowired
	private IRefundService refundService;

	/**
	 * @Title: updateCartDetail
	 * @Description:
	 */
	public Long addOrderForm (OrderFormWithBLOBs example)
		{
			return this.orderFormService.add (example);
		}

	/**
	 * @Title: addOrderFormItem
	 * @Description:
	 */
	public Integer addOrderFormItem (OrderFormItem example)
		{
			return this.orderFormItemService.add (example);
		}

	/**
	 * @Title: addOrderFormItem
	 * @Description:
	 */
	public Long addOrderFormLog (OrderFormLog example)
		{
			return this.orderFormLogService.add (example);
		}

	/**
	 * @Title: getObjectListByUserIdAndOrderStatus
	 * @Description: 根据UserId和订单状态获取订单
	 */
	public List <OrderFormWithBLOBs> getObjectListByUserIdAndOrderStatus (Long userId , String orderStatus)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.setOrderByClause ("addTime desc");
			OrderFormExample.Criteria orderCriteria = orderFormExample.createCriteria ().andUserIdEqualTo (userId).andDeletestatusEqualTo (false).andOrderTypeIsNull ();
			if (!StringUtils.isEmpty (orderStatus))
			{
				System.out.println (orderStatus);
				if (Integer.valueOf (orderStatus) == 70)
				{
					List <Integer> statuses = new ArrayList <Integer> ();
					statuses.add (40);
					statuses.add (50);
					orderCriteria.andOrderStatusIn (statuses);
				}
				else
				{
					orderCriteria.andOrderStatusEqualTo (Integer.valueOf (orderStatus));
				}
			}
			List <OrderFormWithBLOBs> list = this.orderFormService.getObjectList (orderFormExample);
			List <OrderFormWithBLOBs> newList = new ArrayList <OrderFormWithBLOBs> ();
			System.out.println ("size=" + list.size ());
			for (OrderFormWithBLOBs bloBs : list)
			{
				if (bloBs.getRefundId () == null || bloBs.getOrderStatus () == 30 || bloBs.getOrderStatus () == 40)
				{
					OrderFormItem item = orderFormItemService.getObjectByOrderIdAndGoodsId (bloBs.getId () , null);
					if (item != null)
					{
						/*
						 * System.out.println("goodsName="+item.getGoodsName());
						 * System.out.println("拒绝退款="+item.getRefund());
						 * System.out.println("pp="+bloBs.getOrderStatus());
						 * System.out.println(bloBs.getRefundId());
						 */
						if (item.getRefund () == null || item.getRefund ().equals (43) || bloBs.getOrderStatus () == 30 || bloBs.getOrderStatus () == 40)
						{
							System.out.println ("goodsnames=" + item.getGoodsName ());
							newList.add (bloBs);
						}
					}
				}
			}
			return newList;
		}

	/**
	 * @Title: getObjectItemListByOrderId
	 * @Description: 根据订单ID获取订单
	 */
	public List <OrderFormItem> getObjectItemListByOrderId (Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			return this.orderFormItemService.getObjectList (example);
		}

	/**
	 * @Title: getOrderFormItemList
	 * @Description: 获取订单详情表
	 */
	public List <OrderFormItem> getOrderFormItemList (Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			List <OrderFormItem> list = this.orderFormItemService.getObjectList (example);
			if (list == null || list.isEmpty ())
			{
				return null;
			}
			return list;
		}

	/**
	 * @Title: getOrderFormLogListByOrderId
	 * @Description: 根据订单获取订单日志表
	 */
	public List <OrderFormLog> getOrderFormLogListByOrderId (Long orderId)
		{
			OrderFormLogExample orderFormLogExample = new OrderFormLogExample ();
			orderFormLogExample.createCriteria ().andOfIdEqualTo (orderId);
			List <OrderFormLog> orderFormLogs = this.orderFormLogService.getObjectList (orderFormLogExample);
			return orderFormLogs;
		}

	/**
	 * @Title: getUserOrderCountByUserIdAndOrderStatus
	 * @Description: 根据UserId和订单状态订单获取订单数量
	 */
	public Integer getUserOrderCountByUserIdAndOrderStatus (Long userId , Integer orderStatus , String orderType)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			Criteria criteria = orderFormExample.createCriteria ();
			criteria.andOrderStatusEqualTo (orderStatus).andUserIdEqualTo (userId);
			if (null != orderType && !orderType.equals (" "))
			{
				criteria.andOrderTypeEqualTo (orderType);
			}
			else
			{
				criteria.andOrderTypeIsNull ();
			}
			List <OrderFormWithBLOBs> ofs = orderFormService.getObjectList (orderFormExample);
			if (ofs == null)
			{
				return 0;
			}
			else
			{
				if (orderStatus == Globals.HAVE_RECEIVED_GOOD || orderStatus == Globals.HAVE_PAYMENT)
				{
					int size = 0;
					for (OrderFormWithBLOBs bs : ofs)
					{
						List <OrderFormItem> items = getItems (bs.getId ());
						if (items != null)
						{
							for (OrderFormItem item : items)
							{
								if (item.getRefund () == null && (item.getItemStatus () == null || !item.getItemStatus ()))// 未评价
								{
									size++;
								}
							}
						}
					}
					return size;
				}
				return ofs.size ();
			}
		}

	/**
	 * @Title: getOrderFormOfOrderId
	 * @Description: 根据订单ID获取订单对象
	 * @param orderId
	 * @return
	 * @return OrderFormWithBLOBs
	 * @author tangxiang
	 * @date 2015年8月11日 下午6:07:37
	 */
	public OrderFormWithBLOBs getOrderFormOfOrderId (String orderId , String orderStatus)
		{
			List <OrderFormWithBLOBs> list = new ArrayList <OrderFormWithBLOBs> ();
			OrderFormExample example = new OrderFormExample ();
			example.clear ();
			com.amall.core.bean.OrderFormExample.Criteria criteria = example.createCriteria ();
			criteria.andOrderIdEqualTo (orderId);
			if (orderStatus != null)
			{
				criteria.andOrderStatusEqualTo (Integer.valueOf (orderStatus));
			}
			list = this.orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return null;
			}
			return list.get (0);
		}

	/**
	 * @Title: getItems
	 * @Description: 根据订单ID获取订单列表
	 */
	private List <OrderFormItem> getItems (Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			return this.orderFormItemService.getObjectList (example);
		}

	/**
	 * @Title: addRepository
	 * @Description: 增加库存
	 */
	public void addRepository (Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			addGoodsRepository (goods , count);
		}

	/**
	 * @Title: addGoodsRepository
	 * @Description: 增加商品表库存
	 */
	private void addGoodsRepository (GoodsWithBLOBs goods , Integer count)
		{
			/* 修改DBA数量 */
			goods.setGoodsInventory (goods.getGoodsInventory () + count);
			this.goodsService.updateByObject (goods);
		}

	/**
	 * @Title: getOrderById
	 * @Description: 根据订单ID获取订单信息
	 */
	public OrderFormWithBLOBs getOrderById (Long id)
		{
			return this.orderFormService.getByKey (id);
		}

	/**
	 * @Title: getOrderByAliPayId
	 * @Description: 根据支付订单ID获取订单信息
	 */
	public List <OrderFormWithBLOBs> getOrderByAliPayId (Long id)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria ();
			orderFormCriteria.andAlipayorderIdEqualTo (id).andOrderStatusEqualTo (Globals.WAIT_PAYMENT_ORDER);
			List <OrderFormWithBLOBs> orders = orderFormService.getObjectList (orderFormExample);
			return orders;
		}

	/**
	 * @Title: updateOrder
	 * @Description: 修改订单信息
	 */
	public Integer updateOrder (OrderFormWithBLOBs record)
		{
			return this.orderFormService.updateByObject (record);
		}

	public void saveAlipayOrder (AlipayOrder record)
		{
			record.setAppPay (true);
			this.alipayOrderService.add (record);
		}

	/**
	 * @Title: updateAlipayOrder
	 * @Description: 修改支付订单信息
	 */
	public Integer updateAlipayOrder (AlipayOrder record)
		{
			return this.alipayOrderService.updateByObject (record);
		}

	public AlipayOrder getAlipayOrderId (Long id)
		{
			return this.alipayOrderService.getByKey (id);
		}

	/**
	 * @Title: deleteOrderById
	 * @Description: 根据订单ID删除订单
	 */
	public Integer deleteOrderById (Long id)
		{
			return this.orderFormService.deleteByKey (id);
		}

	/**
	 * @Title: orderFormLogAdd
	 * @Description: 添加订单ID日志
	 */
	public Long orderFormLogAdd (OrderFormLog ofl)
		{
			return this.orderFormLogService.add (ofl);
		}

	/**
	 * @Title: getOrderGoodsPrice
	 * @Description: 获取订单商品总价格
	 * @param cartId
	 * @param directBuy
	 * @return
	 * @throws @author tangxiang
	 * @date 2015年9月28日
	 */
	public BigDecimal getOrderGoodsPrice (Long cartId , boolean directBuy)
		{
			BigDecimal price = new BigDecimal (0);
			List <CartDetail> list = cartCRUD.getRecordForCartDetail (null , directBuy , true , cartId);
			if (!list.isEmpty ())
			{
				for (CartDetail cartDetail : list)
				{
					price = price.add (cartCRUD.getGoodsPrice (cartDetail.getGoodsId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
				}
			}
			return price;
		}

	/**
	 * @Title: getDirectBuyGoodsPrice
	 * @Description: 获取直接购买商品的总价格
	 * @param cartId
	 *            ,id
	 * @param directBuy
	 * @return
	 * @throws @author xpy
	 * @date 2015年10月14日
	 */
	public BigDecimal getDirectBuyGoodsPrice (Long cartId , Long id , boolean directBuy)
		{
			BigDecimal price = new BigDecimal (0);
			List <CartDetail> list = cartCRUD.getRecordForCartDetail (null , directBuy , true , cartId);
			if (!list.isEmpty ())
			{
				for (CartDetail cartDetail : list)
				{
					if (cartDetail.getGoodsId ().equals (id))
					{
						price = price.add (cartCRUD.getGoodsPrice (cartDetail.getGoodsId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
					}
				}
			}
			return price;
		}

	/**
	 * @Title: isExistAlipayOrder
	 * @Description: 查找是否在订单中已经存在支付订单号
	 * @param orderId
	 * @return
	 * @return AlipayOrder
	 * @author tangxiang
	 * @date 2015年8月19日 下午3:25:36
	 */
	public AlipayOrder isExistAlipayOrder (String orderId)
		{
			AlipayOrder alipayOrder = null;
			OrderFormWithBLOBs bloBs = getOrderFormOfOrderId (orderId , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
			if (bloBs.getAlipayorderId () != null && bloBs.getAlipayorderId () > Globals.NUBER_ZERO)
			{
				alipayOrder = this.alipayOrderService.getByKey (bloBs.getAlipayorderId ());
			}
			return alipayOrder;
		}

	/**
	 * @Title: deleteAlipayOrderOfOrderFormId
	 * @Description: 根据商品订单号删除支付订单
	 * @param id
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月4日
	 */
	public void deleteAlipayOrderAndUpdateOrderForm (String orderId)
		{
			OrderFormWithBLOBs bloBs = getOrderFormOfOrderId (orderId , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
			alipayOrderService.deleteByKey (bloBs.getAlipayorderId ());
			bloBs.setAlipayorderId (null);
			orderFormService.updateByObject (bloBs);
		}

	/**
	 * @Title: payAddGoodsBuyCount
	 * @Description: 支付订单增加商品销量
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月4日
	 */
	public void payAddGoodsBuyCount (Long id)
		{
			List <OrderFormItem> orderFormItemList = getOrderFormItemList (id);
			for (OrderFormItem orderFormItem : orderFormItemList)
			{
				GoodsWithBLOBs goods = this.goodsService.getByKey (orderFormItem.getGoodsId ());
				int saleSum = goods.getGoodsSalenum () + orderFormItem.getGoodsCount ();
				goods.setGoodsSalenum (saleSum);
				this.goodsService.updateByObject (goods);
			}
		}

	/**
	 * @Title: getPayType
	 * @Description: 获取支付类型
	 * @param type
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月12日
	 */
	public Payment getPayType (String type)
		{
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (type);
			List <PaymentWithBLOBs> payments = paymentService.getObjectList (paymentExample);
			return (Payment) payments.get (Globals.NUBER_ZERO);
		}

	/**
	 * @Title: getOrderGoodsNames
	 * @Description: 获取订单商品名称
	 * @param ofId
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月17日
	 */
	public String getOrderGoodsNames (Long ofId)
		{
			String goodsName = "";
			List <OrderFormItem> list = getOrderFormItemList (ofId);
			goodsName = list.get (0).getGoodsName ();
			if (list.size () > 1)
			{
				goodsName += "等商品";
			}
			return goodsName;
		}

	/**
	 * @Title getObjectListByUserIdAndOrderType
	 * @Deprecated 根据userId、orderType 获取订单列表
	 * @param userId
	 *            订单用户ID
	 * @param orderType
	 *            订单类型
	 * @param orderStatus
	 *            订单状态
	 * @return List<OrderFormWithBLOBs>
	 * @author liuguo
	 * @Date 2016/12/19 11:09
	 */
	public List <OrderFormWithBLOBs> getObjectListByUserIdAndOrderType (Long userId , String orderType , Integer orderStatus)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.setOrderByClause ("addTime desc");
			orderFormExample.createCriteria ().andUserIdEqualTo (userId).andOrderTypeEqualTo (orderType).andOrderStatusEqualTo (orderStatus).andDeletestatusEqualTo (false);
			List <OrderFormWithBLOBs> list = this.orderFormService.getObjectList (orderFormExample);
			if (null != list && list.size () > 0)
			{
				return list;
			}
			else
			{
				return null;
			}
		}

	/**
	 * @Title: searchOrderForm
	 * @Deprecated 根据choices模糊查询当前用户订单
	 * @param currentPage
	 *            当前页
	 * @param choices
	 *            查询条件
	 * @return List <OrderFormWithBLOBs>
	 * @author liuguo
	 * @Date 2017/01/14 15:14
	 */
	public List <OrderFormWithBLOBs> searchOrderForm (String currentPage , String choices)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.setOrderByClause ("addTime desc");
			orderFormExample.setPageNo (CommUtil.null2Int (currentPage));
			orderFormExample.setPageSize (6);
			orderFormExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andDeletestatusEqualTo (false).andOrderIdLike ("%" + choices + "%");
			List <OrderFormWithBLOBs> orderFormList = this.orderFormService.selectOfByGoodsNameLike ("%" + choices + "%");
			if (null != orderFormList && orderFormList.size () > 0)
			{
				return orderFormList;
			}
			else
			{
				return null;
			}
		}

	/**
	 * @Ttile getOrderForm
	 * @Deprecated  
	 * @param list 
	 * @return List <OrderFormWithBLOBs>
	 * @author  liuguo
	 * @Date  2017/01/14   15:33
	 */
	public List <OrderFormWithBLOBs> getOrderForm (List <Long> list)
		{
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria ();
			if (list.size () != 0)
			{
				orderFormCriteria.andCiIdIn (list);
			}
			else
			{
				orderFormCriteria.andCiIdIsNull ();
			}
			List <OrderFormWithBLOBs> orderFormList = this.orderFormService.getObjectList (orderFormExample);
			if (null != orderFormList && orderFormList.size () > 0)
			{
				return orderFormList;
			}
			else
			{
				return null;
			}
		}
}
