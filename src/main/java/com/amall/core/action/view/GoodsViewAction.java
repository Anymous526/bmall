package com.amall.core.action.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.ConsultWithBLOBs;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsCart;
import com.amall.core.bean.GoodsCartExample;
import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.bean.GoodsProperty;
import com.amall.core.bean.GoodsPropertyExample;
import com.amall.core.bean.GoodsSpec;
import com.amall.core.bean.GoodsSpecExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IConsultService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IGoodsClass2SpecService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoods2PhotoService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.goods.IGoodsTypePropertyService;
import com.amall.core.service.goods.IGoodsTypeService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CartGoodsCountTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.IpAddress;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.TransportTools;
import com.amall.core.web.tools.UserTools;
import com.amall.core.web.virtual.JModelAndView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * <p>
 * Title: GoodsViewAction
 * </p>
 * <p>
 * Description: 商品展示管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28上午11:09:49
 * @version 1.0
 */
@SuppressWarnings({ "unchecked" , "rawtypes" })
@Controller
public class GoodsViewAction
{

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IConsultService consultService;

	@Autowired
	private IGoodsBrandService brandService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsTypePropertyService goodsTypePropertyService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private UserTools userTools;

	@Autowired
	private TransportTools transportTools;

	@Autowired
	private IGoods2SpecService goods2SpecService;

	@Autowired
	private IGoodsClass2SpecService goodsClass2SpecService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsTypeService goodsTypeService;

	@Autowired
	private IGoodsSpecService goodsSpecService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	ICartService cartService;

	@Autowired
	private IGoods2PhotoService goods2PhotoService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IGroupGoodsService groupGoodsSerice;

	@Autowired
	private CartGoodsCountTools cartGoodsCountTools;

	@Autowired
	private IAdvertService advertService;

	/**
	 * 
	 * <p>
	 * Title: nav
	 * </p>
	 * <p>
	 * Description: store_goods_list.html中左边部分的页面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/search_list_left.htm" })
	public ModelAndView search_list_left (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("search_list_left.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdIsNull ();
			List <GoodsClassWithBLOBs> goodsClassEs = this.goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("goodClasses" , goodsClassEs);
			Cookie [ ] cookies = request.getCookies ();
			List <Long> idList = new ArrayList <Long> ();
			if (cookies != null)
			{
				for (Cookie c : cookies)
				{
					if (c.getName ().indexOf ("goods_id") != -1)// Cookie以goods_id为前缀
					{
						String goodsId = c.getName ().substring ("goods_id".length () + 1);// 取出ID
						if (goodsId != null && !goodsId.equals (""))
							idList.add (Long.parseLong (goodsId));
					}
				}
			}
			if (idList.size () != 0)
			{
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
				goodsCriteria.andIdIn (idList);
				List <GoodsWithBLOBs> goods = this.goodsService.getObjectList (goodsExample);
				mv.addObject ("goods" , goods);
			}
			return mv;
		}

	/*
	 * @RequestMapping({ "/goods_list.htm" })
	 * public ModelAndView goods_list(HttpServletRequest request,
	 * HttpServletResponse response, String gc_id, String store_id,
	 * String recommend, String currentPage, String orderBy,
	 * String orderType, String begin_price, String end_price) {
	 * UserGoodsClass ugc = this.userGoodsClassService.getByKey(CommUtil
	 * .null2Long(gc_id));
	 * String template = "default";
	 * Store store = this.storeService.getByKey(CommUtil.null2Long(store_id));
	 * if (store != null) {
	 * if ((store.getTemplate() != null)
	 * && (!store.getTemplate().equals(""))) {
	 * template = store.getTemplate();
	 * }
	 * ModelAndView mv = new JModelAndView(template + "/goods_list.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request,
	 * response);
	 * GoodsExample goodsExample = new GoodsExample();
	 * goodsExample.clear();
	 * goodsExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
	 * goodsExample.setOrderByClause(Pagination.cst(orderBy, orderType));
	 * goodsExample.setPageSize(Integer.valueOf(20));
	 * GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria();
	 * goodsCriteria.andGoodsStoreIdEqualTo(store.getId());
	 * if (ugc != null) {
	 * List<Long> ids = genericUserGcIds(ugc);
	 * List ugc_list = new ArrayList();
	 * for (Long g_id : ids) {
	 * UserGoodsClass temp_ugc = this.userGoodsClassService
	 * .getByKey(g_id);
	 * ugc_list.add(temp_ugc);
	 * }
	 * } else {
	 * ugc = new UserGoodsClass();
	 * ugc.setClassname("全部商品");
	 * mv.addObject("ugc", ugc);
	 * }
	 * if ((recommend != null) && (!recommend.equals(""))) {
	 * goodsCriteria.andGoodsRecommendEqualTo(Boolean.valueOf(CommUtil.null2Boolean(recommend)));
	 * }
	 * if ((begin_price != null) && (!begin_price.equals(""))) {
	 * goodsCriteria.andStorePriceGreaterThanOrEqualTo(BigDecimal.valueOf(CommUtil.null2Double(
	 * begin_price)));
	 * }
	 * if ((end_price != null) && (!end_price.equals(""))) {
	 * goodsCriteria.andStorePriceLessThanOrEqualTo(BigDecimal.valueOf(CommUtil.null2Double(end_price
	 * )));
	 * }
	 * Pagination pList = this.goodsService.getObjectListWithPage(goodsExample);
	 * String url = this.configService.getSysConfig().getAddress();
	 * if ((url == null) || (url.equals(""))) {
	 * url = CommUtil.getURL(request);
	 * }
	 * CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
	 * mv.addObject("ugc", ugc);
	 * mv.addObject("store", store);
	 * mv.addObject("recommend", recommend);
	 * mv.addObject("begin_price", begin_price);
	 * mv.addObject("end_price", end_price);
	 * mv.addObject("goodsViewTools", this.goodsViewTools);
	 * mv.addObject("storeViewTools", this.storeViewTools);
	 * mv.addObject("areaViewTools", this.areaViewTools);
	 * return mv;
	 * }
	 * ModelAndView mv = new JModelAndView("error.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request, response);
	 * mv.addObject("op_title", "请求参数错误");
	 * mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	 * return mv;
	 * }
	 * private List<Long> genericUserGcIds(UserGoodsClass ugc) {
	 * List ids = new ArrayList();
	 * ids.add(ugc.getId());
	 * for (UserGoodsClass child : ugc.getChilds()) {
	 * List<Long> cids = genericUserGcIds(child);
	 * for (Long cid : cids) {
	 * ids.add(cid);
	 * }
	 * ids.add(child.getId());
	 * }
	 * return ids;
	 * }
	 */
	/**
	 * 
	 * @author wsw
	 * @date 2015年6月17日 下午1:55:12
	 * @todo 商品详情展示页
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 *            商品id
	 * @return
	 */
	@RequestMapping({ "/goods.htm" })
	public ModelAndView goods (HttpServletRequest request , HttpServletResponse response , String id , String type)
		{
			ModelAndView mv = null;
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			if (goodsWithBLOBs == null || goodsWithBLOBs.getGoodsStatus () != 0 || goodsWithBLOBs.getDeletestatus ())
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "没有这个商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				return mv;
			}
			goodsWithBLOBs.setGoodsStore (this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ()));
			goodsWithBLOBs.setGroup (this.groupService.getByKey (goodsWithBLOBs.getGroupId ()));
			goodsWithBLOBs.setGc (this.goodsClassService.getByKey (goodsWithBLOBs.getGcId ()));
			goodsWithBLOBs.setGoodsBrand (this.brandService.getByKey (goodsWithBLOBs.getGoodsBrandId ()));
			goodsWithBLOBs.setGoodsMainPhoto (this.accessoryService.getByKey (goodsWithBLOBs.getGoodsMainPhotoId ()));
			// 通过查询中间表获得所有与商品对应的图片，并获取图片的id集合
			Goods2PhotoExample goods2PhotoExample = new Goods2PhotoExample ();
			goods2PhotoExample.createCriteria ().andGoodsIdEqualTo (goodsWithBLOBs.getId ());
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
				goodsWithBLOBs.setGoodsPhotos (this.accessoryService.getObjectList (accessoryExample));
			}
			// 商品所在店铺的storePoint
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			StorePoint storePoint = this.storePointService.getByKey (store.getPointId ());
			store.setStorePoint (storePoint);
			goodsWithBLOBs.setGoodsStore (store);
			// 创建cookie,将用户浏览历史存进去
			// Cookie cookie = new Cookie("goods_id" + goodsWithBLOBs.getId(),
			// "goods_id" + goodsWithBLOBs.getId());
			// response.addCookie(cookie);
			GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (goodsWithBLOBs.getGcId ());
			GoodsClassWithBLOBs p_gc = this.goodsClassService.getByKey (gc.getParentId ());
			if (p_gc != null)
			{
				gc.setParent (p_gc);
				GoodsClassWithBLOBs p_pgc = this.goodsClassService.getByKey (p_gc.getParentId ());
				gc.getParent ().setParent (p_pgc);
			}
			goodsWithBLOBs.setGc (gc);
			// 判断商品的状态码,是那种风格的,然后跳入相应风格的页面
			if (goodsWithBLOBs.getGoodsStatus () == 0)
			{
				String template = "default";
				if ((goodsWithBLOBs.getGoodsStore ().getTemplate () != null) && (!goodsWithBLOBs.getGoodsStore ().getTemplate ().equals ("")))
				{
					template = goodsWithBLOBs.getGoodsStore ().getTemplate ();
				}
				// 跳入相应的模版页面
				mv = new JModelAndView (template + "/goods_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				// 商品点击数增加
				goodsWithBLOBs.setGoodsClick (goodsWithBLOBs.getGoodsClick () + 1);
				if (this.configService.getSysConfig ().getZtcStatus () && goodsWithBLOBs.getZtcStatus () == 2)
				{
					goodsWithBLOBs.setZtcClickNum (goodsWithBLOBs.getZtcClickNum () + 1);
				}
				if ((goodsWithBLOBs.getGroup () != null) && (goodsWithBLOBs.getGroupBuy () == 2))
				{
					Group group = goodsWithBLOBs.getGroup ();
					if (group.getEndtime ().before (new Date ()))
					{
						goodsWithBLOBs.setGroup (null);
						goodsWithBLOBs.setGroupBuy (Integer.valueOf (0));
						goodsWithBLOBs.setGoodsCurrentPrice (goodsWithBLOBs.getStorePrice ());
					}
				}
				if (SecurityUserHolder.getCurrentUser () != null)
				{
					mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
				}
				this.goodsService.updateByObject (goodsWithBLOBs);
				if (goodsWithBLOBs.getGoodsStore ().getStoreStatus () == 2)
				{
					GoodsSpecExample goodsSpecExample = new GoodsSpecExample ();
					goodsSpecExample.clear ();
					goodsSpecExample.createCriteria ().andGoodsIdEqualTo (goodsWithBLOBs.getId ());
					List <GoodsSpec> gss = this.goodsSpecService.selectByExample (goodsSpecExample);
					BigDecimal price = new BigDecimal (0);
					for (GoodsSpec gs : gss)
					{
						double temp = 0.0;
						GoodsPropertyExample goodsPropertyExample = new GoodsPropertyExample ();
						goodsPropertyExample.clear ();
						goodsPropertyExample.createCriteria ().andSpecIdEqualTo (gs.getId ());
						List <GoodsProperty> gps = this.goodsPropertyService.selectByExample (goodsPropertyExample);
						gs.setProperties (gps);
						for (GoodsProperty gp : gps)
						{
							if (CommUtil.subtract (temp , gp.getProPrice ()) < 0)
							{// 减法,差
								temp = CommUtil.null2Double (gp.getProPrice ());
							}
						}
						price = BigDecimal.valueOf (CommUtil.add (price , temp));// 加法，和
					}
					goodsWithBLOBs.getSpecs ().addAll (gss);
					mv.addObject ("maxPrice" , BigDecimal.valueOf (CommUtil.add (goodsWithBLOBs.getGoodsPrice () , price)));
					/* 把规格属性ID转变成对应名字 */
					if (goodsWithBLOBs.getGoodsProperty () != null && !goodsWithBLOBs.getGoodsProperty ().equals (""))
					{
						Map <String, String> map = new HashMap <String, String> ();
						JSONArray array = JSONArray.fromObject (goodsWithBLOBs.getGoodsProperty ());
						JSONArray reStr = new JSONArray ();
						for (int i = 0 ; i < array.size () ; i++)
						{
							JSONObject obj = array.getJSONObject (i);
							String keyValue = obj.getString ("key");
							GoodsSpecification goodsSpecification = this.goodsSpecificationService.getByKey (Long.valueOf (keyValue));
							if (goodsSpecification == null)
							{
								continue;
							}
							map.put ("key" , goodsSpecification.getName ());
							String names = "";
							String value = obj.getString ("value");
							String [ ] strArray = value.split ("\\|");
							if (strArray == null || strArray.length == Globals.NUBER_ZERO)
							{
								continue;
							}
							for (String strId : strArray)
							{
								if (CommUtil.isInteger (strId))
								{
									GoodsSpecProperty goodsSpecProperty = this.goodsSpecPropertyService.getByKey (Long.valueOf (strId));
									if (goodsSpecProperty == null)
									{
										continue;
									}
									names = names + goodsSpecProperty.getValue () + "|";
								}
								else
								{
									names = names + strId + "|";
								}
							}
							map.put ("value" , names);
							JSONObject ret = JSONObject.fromObject (map);
							reStr.add (ret);
							map.clear ();
						}
						goodsWithBLOBs.setGoodsProperty (reStr.toString ());
					}
					// 天天特价，价格不同
					if (type != null && !"".equals (type))
					{
						/*
						 * if(type.equals("tiantian")){
						 * BargainGoodsExample bargainGoodsExample=new BargainGoodsExample();
						 * bargainGoodsExample.clear();
						 * BargainGoodsExample.Criteria
						 * bargainGoodsCriteria=bargainGoodsExample.createCriteria();
						 * bargainGoodsCriteria.andBgTimeEqualTo(CommUtil.formatString2Date(CommUtil.
						 * formatShortDate(new Date())))
						 * .andBgEndTimeIsNull(); //查询当天
						 * bargainGoodsCriteria.andBgStatusEqualTo(1);//查询审核通过的
						 * bargainGoodsCriteria.andBgGoodsIdEqualTo(Long.valueOf(id));
						 * List<BargainGoods>
						 * listBargainGoods=this.bargainGoodsService.getObjectList
						 * (bargainGoodsExample);
						 * if(listBargainGoods.size() >0 && listBargainGoods != null){
						 * Double priceH=0.00;
						 * Double zhekou=listBargainGoods.get(0).getBgRebate().doubleValue();
						 * Double yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
						 * priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
						 * //保留两位小数点
						 * BigDecimal b= new BigDecimal(priceH);
						 * BigDecimal price1 = b.setScale(2, BigDecimal.ROUND_HALF_UP);
						 * goodsWithBLOBs.setGoodsPrice(price1);
						 * }
						 * mv.addObject("type", type);
						 * }
						 */
						// 限时特价
						if (type != null && type.equals ("xianshi"))
						{
							BargainExample bargainExample = new BargainExample ();
							bargainExample.clear ();
							BargainExample.Criteria bargainCriteria = bargainExample.createCriteria ();
							List <Date> bargainTime = new ArrayList <Date> ();
							bargainExample.clear ();
							bargainCriteria = bargainExample.createCriteria ();
							bargainCriteria.andMarkEqualTo (1);
							bargainCriteria.andBargainTimeLessThanOrEqualTo (new Date ());// 在当前时间之前开始的特价
							bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo (new Date ());// 在当前时间之后还未结束的限时特价
							List <Bargain> bargains = this.bargainService.getObjectList (bargainExample);
							bargainTime = new ArrayList <Date> ();
							List <Date> bargainEndTime = new ArrayList <Date> ();
							for (Bargain bargain : bargains)
							{
								bargainTime.add (bargain.getBargainTime ());
								bargainEndTime.add (bargain.getBargainEndTime ());
							}
							BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
							bargainGoodsExample.clear ();
							BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
							if (bargainTime.size () > 0)
							{
								bargainGoodsCriteria.andBgTimeIn (bargainTime);
							}
							else
							{
								bargainGoodsCriteria.andBgTimeIsNull ();
							}
							if (bargainEndTime.size () > 0)
							{
								bargainGoodsCriteria.andBgEndTimeIn (bargainEndTime);
							}
							else
							{
								bargainGoodsCriteria.andBgEndTimeIsNull ();
							}
							bargainGoodsCriteria.andBgStatusEqualTo (1);
							bargainGoodsCriteria.andBgGoodsIdEqualTo (Long.valueOf (id));
							// List<BargainGoods>
							// listBargainGoods=this.bargainGoodsService.getObjectList(bargainGoodsExample);
							// if(listBargainGoods.size() >0 && listBargainGoods != null){
							// Double priceH=0.00;
							// Double zhekou=listBargainGoods.get(0).getBgRebate().doubleValue();
							// Double yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
							// priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
							// 保留两位小数点
							// BigDecimal b= new BigDecimal(priceH);
							// BigDecimal price1 = b.setScale(2, BigDecimal.ROUND_HALF_UP);
							// goodsWithBLOBs.setGoodsPrice(price1);
							// goodsWithBLOBs.setGoodsFee(listBargainGoods.get(0).getBgPrice().toString());
							// }
							mv.addObject ("type" , type);
						}
						if (type != null && type.equals ("zhekou"))
						{
							BargainExample bargainExample = new BargainExample ();
							bargainExample.clear ();
							BargainExample.Criteria bargainCriteria = bargainExample.createCriteria ();
							bargainExample.clear ();
							bargainCriteria = bargainExample.createCriteria ();
							bargainCriteria.andMarkEqualTo (2);
							bargainCriteria.andBargainTimeLessThanOrEqualTo (new Date ());// 在当前时间之前开始的特价
							bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo (new Date ());// 在当前时间之后还未结束的折扣特卖
							List <Bargain> bargains = this.bargainService.getObjectList (bargainExample);
							List <Date> bargainTime = new ArrayList <Date> ();
							for (Bargain bargain : bargains)
							{
								bargainTime.add (bargain.getBargainTime ());
							}
							BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
							bargainGoodsExample.clear ();
							BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
							if (bargainTime.size () > 0)
							{
								bargainGoodsCriteria.andBgTimeIn (bargainTime);
							}
							else
							{
								bargainGoodsCriteria.andBgTimeIsNull ();
							}
							bargainGoodsCriteria.andBgStatusEqualTo (1);
							// List<BargainGoods>
							// listBargainGoods=this.bargainGoodsService.getObjectList(bargainGoodsExample);
							// if(listBargainGoods.size() >0 && listBargainGoods != null){
							// Double priceH=0.00;
							// Double zhekou=listBargainGoods.get(0).getBgRebate().doubleValue();
							// Double yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
							// priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
							// 保留两位小数点
							// BigDecimal b= new BigDecimal(priceH);
							// BigDecimal price1 = b.setScale(2, BigDecimal.ROUND_HALF_UP);
							// goodsWithBLOBs.setGoodsPrice(price1);
							// goodsWithBLOBs.setGoodsFee(listBargainGoods.get(0).getBgPrice().toString());
							// }
							mv.addObject ("type" , type);
						}
						// 团购商品，价格不同
						if (type != null && type.equals ("group"))
						{
							GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
							groupGoodsExample.clear ();
							groupGoodsExample.createCriteria ().andGgGoodsIdEqualTo (goodsWithBLOBs.getId ());
							GroupGoods gg = this.groupGoodsSerice.getObjectList (groupGoodsExample).get (0);
							GroupExample groupExample = new GroupExample ();
							groupExample.clear ();
							groupExample.createCriteria ().andIdEqualTo (gg.getGroupId ()).andBegintimeLessThanOrEqualTo (new Date ()).andEndtimeGreaterThanOrEqualTo (new Date ());
							List <Group> groupList = this.groupService.getObjectList (groupExample);
							if (null!=groupList && groupList.size () > 0)
							{
								BigDecimal groupPrice = gg.getGgPrice ();
								goodsWithBLOBs.setGoodsPrice (groupPrice);
								goodsWithBLOBs.setGoodsCurrentPrice (groupPrice);
							}
							mv.addObject ("type" , type);
						}
					}
					generic_evaluate (goodsWithBLOBs , mv);   // 查询商品评分
					/* key放图片地址，value 放图片间隔之间的文字 */
					Map <String, String> imgFontMap = new LinkedHashMap <> ();
					int imgIndex = 0;
					String imgStr = goodsWithBLOBs.getGoodsDetails ();
					String startStr = "src=\"";
					String endStr = "\"";
					String fontEndStr = "<img";
					String imgEndStr = "/>";
					String lastStr = "";
					String firstStr = "";
					for (int i = 0 ; i < imgStr.length () ; i++)
					{
						if (imgIndex == -1)
						{
							break;
						}
						/* 获取开头文字 */
						if (imgIndex == 0)
						{
							int firstFontEnd = imgStr.indexOf (fontEndStr);
							if (firstFontEnd > 0)
							{
								firstStr = imgStr.substring (imgIndex , firstFontEnd);
							}
						}
						int start = imgStr.indexOf (startStr , imgIndex);
						if (start == -1)
						{
							/* 最后的字符串 */
							lastStr = imgStr.substring (imgIndex , imgStr.length () - 1);
							break;
						}
						/* 下标移到地址开始位置 */
						start += startStr.length ();
						int end = imgStr.indexOf (endStr , start);
						if (end == -1)
						{
							break;
						}
						/* 地址 */
						String urdTemp = imgStr.substring (start , end);
						/* 下标移到地址结束位置 */
						int fontStart = end + 1;
						fontStart = imgStr.indexOf (imgEndStr , fontStart);
						int fontEnd = imgStr.indexOf (fontEndStr , fontStart);
						String fontTemp = "";
						/* 若为 -1则表示已到尾了 */
						if (fontEnd != -1)
						{
							/* 图片中间内容 */
							fontTemp = imgStr.substring (fontStart + 2 , fontEnd);
						}
						imgFontMap.put (urdTemp , fontTemp);
						imgIndex = fontEnd;
					}
					if (imgFontMap.size () > 0)
					{
						mv.addObject ("imgs" , imgFontMap);
					}
					mv.addObject ("lastStr" , lastStr);
					mv.addObject ("firstStr" , firstStr);
					mv.addObject ("obj" , goodsWithBLOBs);
					mv.addObject ("store" , goodsWithBLOBs.getGoodsStore ());
					UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
					userGoodsClassExample.clear ();
					userGoodsClassExample.createCriteria ().andUserIdEqualTo (CommUtil.null2Long (goodsWithBLOBs.getGoodsStore ().getUserId ()));
					List <UserGoodsClass> userGoodsClasses = this.userGoodsClassService.getObjectList (userGoodsClassExample);
					mv.addObject ("ugcs" , userGoodsClasses);
					// 推荐商品
					GoodsExample goodsExample = new GoodsExample ();
					goodsExample.clear ();
					goodsExample.setPageSize (Integer.valueOf (4));
					goodsExample.setOrderByClause ("addTime desc");
					goodsExample.createCriteria ().andGoodsStoreIdEqualTo (goodsWithBLOBs.getGoodsStoreId ()).andGoodsRecommendEqualTo (Boolean.valueOf (true)).andIdNotEqualTo (goodsWithBLOBs.getId ()).andGoodsStatusEqualTo (Integer.valueOf (0));
					List <GoodsWithBLOBs> gs = this.goodsService.getObjectList (goodsExample);
					mv.addObject ("goods_recommend_list" , gs);
					// 首次进入商品详情页获取商品评价
					String currentPage = null;
					EvaluateExample evaluateExample = new EvaluateExample ();
					evaluateExample.clear ();
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (goodsWithBLOBs.getId ()).andEvaluateTypeEqualTo ("goods").andEvaluateStatusNotEqualTo (Integer.valueOf (2));
					List <EvaluateWithBLOBs> evaList = this.evaluateService.getObjectList (evaluateExample);
					int goodEvas = 0 , commEvas = 0 , badEvas = 0 , forbiddenEvas = 0;
					// 统计商品的好，中，差评价
					for (EvaluateWithBLOBs e : evaList)
					{
						if (e.getEvaluateBuyerVal () == 1)
						{
							goodEvas++;
							if (e.getEvaluateStatus () == 1)
							{
								goodEvas--;
								forbiddenEvas++;
							}
						}
						else if (e.getEvaluateBuyerVal () == 0)
						{
							commEvas++;
							if (e.getEvaluateStatus () == 1)
							{
								commEvas--;
								forbiddenEvas++;
							}
						}
						else if (e.getEvaluateBuyerVal () == -1)
						{
							badEvas++;
							if (e.getEvaluateStatus () == 1)
							{
								badEvas--;
								forbiddenEvas++;
							}
						}
					}
					// 评价的总数
					mv.addObject ("evaCount" , (evaList.size () - forbiddenEvas));
					evaluateExample.clear ();
					evaluateExample.setOrderByClause ("addTime desc");
					evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					evaluateExample.setPageSize (Integer.valueOf (8));
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (goodsWithBLOBs.getId ()).andEvaluateTypeEqualTo ("goods");
					Pagination pList = this.evaluateService.getObjectListWithPage (evaluateExample);
					// 设置评价用户的photo和用户信用等级
					Gson gson = new Gson ();
					String creditRule = this.configService.getSysConfig ().getCreditrule ();
					Map creditMap = gson.fromJson (creditRule , new TypeToken <Map <String, String>> ()
					{
					}.getType ());
					if (pList.getList ().size () > 0)
					{
						for (int i = 0 ; i < pList.getList ().size () ; i++)
						{
							EvaluateWithBLOBs e = (EvaluateWithBLOBs) pList.getList ().get (i);
							User user = this.userService.getByKey (e.getEvaluateUserId ());
							int level = getCreditLevel (creditMap , user);
							user.setCreditlevel (level);
							if (user.getPhotoId () != null)
							{
								user.setPhoto (this.accessoryService.getByKey (user.getPhotoId ()));
							}
							e.setEvaluate_user (user);
							if (e.getImg1id () != null && !e.getImg1id ().toString ().equals (""))
							{
								e.setImg1 (this.accessoryService.getByKey (e.getImg1id ()));
							}
							if (e.getImg2id () != null && !e.getImg2id ().toString ().equals (""))
							{
								e.setImg2 (this.accessoryService.getByKey (e.getImg2id ()));
							}
							if (e.getImg3id () != null && !e.getImg3id ().toString ().equals (""))
							{
								e.setImg3 (this.accessoryService.getByKey (e.getImg3id ()));
							}
						}
					}
					String url = this.configService.getSysConfig ().getAddress ();
					if ((url == null) || (url.equals ("")))
					{
						url = CommUtil.getURL (request);
					}
					CommUtil.addIPageList2ModelAndView (url + "/evaType.htm" , "" , "" , pList , mv);
					// 查看当前登录用户是否已经购买该商品,给予是否评价的指示
					// 当前用户是否购买过此商品.且评价状态为待评价
					OrderFormExample orderFormExample = new OrderFormExample ();
					orderFormExample.clear ();
					User user = SecurityUserHolder.getCurrentUser ();
					OrderFormExample.Criteria orderForExampleCriteria = orderFormExample.createCriteria ();
					boolean evaStatus = false;
					if (user != null)
					{
						orderForExampleCriteria.andUserIdEqualTo (user.getId ()).andOrderStatusEqualTo (Integer.valueOf (40)).andStoreIdEqualTo (store.getId ());
						List <OrderFormWithBLOBs> order = this.orderFormService.getObjectList (orderFormExample);
						GoodsCartExample goodsCartExample = new GoodsCartExample ();
						for (OrderFormWithBLOBs o : order)
						{
							goodsCartExample.clear ();
							goodsCartExample.createCriteria ().andOfIdEqualTo (o.getId ());
							List <GoodsCart> gcs = this.goodsCartService.getObjectList (goodsCartExample);
							for (GoodsCart gcc : gcs)
							{
								if (gcc.getGoodsId () == goodsWithBLOBs.getId ())
								{
									evaStatus = true;
									mv.addObject ("order" , o);
									break;
								}
							}
						}
					}
					else
					{
						// 用户尚未登录
						evaStatus = false;
					}
					mv.addObject ("user" , user);
					mv.addObject ("totalPages" , pList.getTotalPage ());
					mv.addObject ("currentPage" , CommUtil.null2Int (currentPage));
					mv.addObject ("goodEvas" , goodEvas);
					if (goodEvas == 0)
					{
						mv.addObject ("gep" , goodEvas);
					}
					else
					{
						mv.addObject ("gep" , CommUtil.divide (goodEvas , pList.getTotalCount ()));
					}
					mv.addObject ("badEvas" , badEvas);
					if (badEvas == 0)
					{
						mv.addObject ("bep" , badEvas);
					}
					else
					{
						mv.addObject ("bep" , CommUtil.divide (badEvas , pList.getTotalCount ()));
					}
					mv.addObject ("commEvas" , commEvas);
					int cepPer = 100 - CommUtil.divide (goodEvas , pList.getTotalCount ()) - CommUtil.divide (badEvas , pList.getTotalCount ());
					if (pList.getTotalCount () + goodEvas + commEvas + badEvas == 0)
					{
						cepPer = 0;
					}
					if (commEvas == 0)
					{
						mv.addObject ("cep" , commEvas);
					}
					else
					{
						mv.addObject ("cep" , cepPer);
					}
					mv.addObject ("goodsViewTools" , this.goodsViewTools);
					mv.addObject ("storeViewTools" , this.storeViewTools);
					mv.addObject ("areaViewTools" , this.areaViewTools);
					mv.addObject ("transportTools" , this.transportTools);
					List <GoodsWithBLOBs> user_viewed_goods = (List) request.getSession (false).getAttribute ("user_viewed_goods");
					if (user_viewed_goods == null)
					{
						user_viewed_goods = new ArrayList ();
					}
					boolean add = true;
					for (GoodsWithBLOBs goods : user_viewed_goods)
					{
						if (goods.getId ().equals (goodsWithBLOBs.getId ()))
						{
							add = false;
							break;
						}
					}
					if (add)
					{
						if (user_viewed_goods.size () >= 4)
							user_viewed_goods.set (1 , goodsWithBLOBs);
						else
							user_viewed_goods.add (goodsWithBLOBs);
					}
					request.getSession (false).setAttribute ("user_viewed_goods" , user_viewed_goods);
					IpAddress ipAddr = IpAddress.getInstance ();
					String current_ip = CommUtil.getIpAddr (request);
					String current_city = ipAddr.IpStringToAddress (current_ip);
					if ((current_city == null) || (current_city.equals ("")))
					{
						current_city = "全国";
					}
					mv.addObject ("current_city" , current_city);
					AreaExample areaExample = new AreaExample ();
					areaExample.clear ();
					areaExample.createCriteria ().andParentIdIsNull ();
					areaExample.setOrderByClause ("sequence asc");
					List <Area> areas = this.areaService.getObjectList (areaExample);
					mv.addObject ("areas" , areas);
					// 计算当前行业店铺总分.并显示在页面上
					generic_evaluate (goodsWithBLOBs.getGoodsStore () , mv);
					// 通过goods获取specId , 再之后通过specId获取goodsspecification
					// 的属性,如颜色,尺寸,规格等,
					// 最后通过goodsspecification的id 拿到这些属性的具体值 如红黄蓝绿色
					// List<GoodsSpecProperty> gsps = this.goodsSpecPropertyService
					// .selectGoodsPropertyByLeftJoinSpecAndGoodsId(goodsWithBLOBs
					// .getId());
					//
					// GoodsSpecPropertyExample goodsSpecPropertyExample = new
					// GoodsSpecPropertyExample();
					// Map<String, List<GoodsSpecProperty>> map = new HashMap<String,
					// List<GoodsSpecProperty>>();
					// for (int i = 0; i < gsps.size(); i++) {
					// goodsSpecPropertyExample.clear();
					// goodsSpecPropertyExample.createCriteria().andSpecIdEqualTo(
					// gsps.get(i).getSpecId());
					// map.put(gsps.get(i).getSpec().getName(),
					// this.goodsSpecPropertyService
					// .getObjectList(goodsSpecPropertyExample));
					// }
					// mv.addObject("gsps", map);
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "店铺未能开通，拒绝访问");
					mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "该商品未上架，不允许查看");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			/* 购物车数量显示 */
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return mv;
		}

	/**
	 * 
	 * @todo ajax动态刷新价格
	 * @author wsw
	 * @date 2015年7月15日 下午1:33:58
	 * @return String
	 * @param request
	 * @param response
	 * @param specId
	 * @param goodsId
	 * @return
	 */
	@RequestMapping({ "/flushPrice.htm" })
	@ResponseBody
	public String flushPrice (HttpServletRequest request , HttpServletResponse response , String specId , String goodsId)
		{
			/**
			 * 得到商品的价格。即商品的价格+属性的价格
			 */
			String result = "";
			if (goodsId != null && !goodsId.equals (""))
			{
				BigDecimal price = this.goodsService.getByKey (CommUtil.null2Long (goodsId)).getStorePrice ();
				if (specId != null && !specId.equals (""))
				{
					String [ ] ids = specId.split (",");
					for (String id : ids)
					{
						GoodsProperty prop = this.goodsPropertyService.selectByPrimaryKey (CommUtil.null2Long (id));
						price = BigDecimal.valueOf (CommUtil.add (price , prop.getProPrice ()));
					}
					result = price + "";
				}
				else
				{
					// 当用户没有选择商品价格的时候 , 设置商品的价格为区间价格
					GoodsSpecExample goodsSpecExample = new GoodsSpecExample ();
					goodsSpecExample.clear ();
					goodsSpecExample.createCriteria ().andGoodsIdEqualTo (CommUtil.null2Long (goodsId));
					List <GoodsSpec> gss = this.goodsSpecService.selectByExample (goodsSpecExample);
					BigDecimal temp = new BigDecimal (0);
					for (GoodsSpec gs : gss)
					{
						GoodsPropertyExample goodsPropertyExample = new GoodsPropertyExample ();
						goodsPropertyExample.clear ();
						goodsPropertyExample.createCriteria ().andSpecIdEqualTo (gs.getId ());
						List <GoodsProperty> gps = this.goodsPropertyService.selectByExample (goodsPropertyExample);
						for (GoodsProperty gp : gps)
						{
							if (CommUtil.subtract (temp , gp.getProPrice ()) < 0)
							{
								temp = gp.getProPrice ();
							}
						}
					}
					result = BigDecimal.valueOf (CommUtil.add (price , temp)).toString ();
				}
			}
			return result;
		}

	/**
	 * 
	 * @todo 商品详情页面左下侧 相关商品导航
	 * @author wsw
	 * @date 2015年6月22日 下午4:38:24
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/goods_rep_type.htm" })
	public ModelAndView goods_rep_type (HttpServletRequest request , HttpServletResponse response , String id)
		{
			String template = "default";
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			goodsWithBLOBs.setGoodsStore (store);
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_rep_type.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (goodsWithBLOBs.getGcId ());
			List <Long> ids = genericAllGcIds (gc);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGcIdIn (ids).andGoodsRecommendEqualTo (true).andGoodsStatusEqualTo (Integer.valueOf (0));
			List <GoodsWithBLOBs> goodsList = this.goodsService.getObjectList (goodsExample);
			List <GoodsWithBLOBs> tempList = new ArrayList <GoodsWithBLOBs> ();
			if (goodsList.size () <= 9)
			{
				tempList = goodsList;
			}
			else
			{
				tempList = goodsList.subList (0 , 9);
			}
			for (GoodsWithBLOBs goods : tempList)
			{
				Accessory mainPhoto = this.accessoryService.getByKey (goods.getGoodsMainPhotoId ());
				goods.setGoodsMainPhoto (mainPhoto);
			}
			mv.addObject ("recommends" , tempList);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (goodsWithBLOBs.getGcId ());
			List <GoodsClassWithBLOBs> gcList = this.goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcList);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: store_goods_list
	 * </p>
	 * <p>
	 * Description:展示商品列表页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param gc_id
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param store_price_begin
	 * @param store_price_end
	 * @param brand_ids
	 * @param gs_ids
	 * @param properties
	 * @param op
	 * @param goods_name
	 * @param area_name
	 * @param area_id
	 * @param goods_view
	 * @param all_property_status
	 * @param detail_property_status
	 * @return
	 */
	@RequestMapping({ "/store_goods_list.htm" })
	public ModelAndView store_goods_list (HttpServletRequest request , HttpServletResponse response , String gc_id , String currentPage , String orderBy , String orderType , String store_price_begin , String store_price_end , String brand_ids , String gs_ids , String op , String goods_name , String goods_view , String all_property_status , String detail_property_status)
		{
			ModelAndView mv = new JModelAndView ("store_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (gc_id));
			mv.addObject ("gc" , gc);
			if ((orderBy == null) || (orderBy.equals ("")))
			{
				orderBy = "goods_average";		// 默認綜合排序
				orderType = "desc";
			}
			if ((op != null) && (!op.equals ("")))
			{
				mv.addObject ("op" , op);
			}
			String orderBy1 = orderBy;
			// GoodsQueryObject gqo = new GoodsQueryObject(currentPage, mv, orderBy,
			// orderType);
			// 查询改类商品 规格属性 start
			GoodsClass2SpecExample gc2sExample = new GoodsClass2SpecExample ();
			gc2sExample.clear ();
			gc2sExample.createCriteria ().andClassIdEqualTo (CommUtil.null2Long (gc_id));
			List <GoodsClass2Spec> gc2ses = goodsClass2SpecService.getObjectList (gc2sExample);
			GoodsSpecPropertyExample gspExample = new GoodsSpecPropertyExample ();
			List <GoodsSpecification> gss = new ArrayList <GoodsSpecification> ();
			for (GoodsClass2Spec goodsClass2Spec : gc2ses)
			{
				GoodsSpecification gs = goodsSpecificationService.getByKey (goodsClass2Spec.getSpecificationId ());
				gspExample.clear ();
				gspExample.createCriteria ().andSpecIdEqualTo (goodsClass2Spec.getSpecificationId ());
				List <GoodsSpecProperty> gsps = goodsSpecPropertyService.getObjectList (gspExample);
				gs.setProperties (gsps);
				gss.add (gs);
			}
			mv.addObject ("gss" , gss);
			// 查询改类商品 规格属性 end
			// 根据类型 查询品牌开始
			GoodsType2BrandExample gt2bExample = new GoodsType2BrandExample ();
			gt2bExample.clear ();
			gt2bExample.createCriteria ().andTypeIdEqualTo (gc.getId ());
			List <GoodsType2Brand> gt2bS = goodsType2BrandService.getObjectList (gt2bExample);
			List <GoodsBrand> gbs = new ArrayList <GoodsBrand> ();
			for (GoodsType2Brand goodsType2Brand : gt2bS)
			{
				GoodsBrand gb = goodsBrandService.getByKey (goodsType2Brand.getBrandId ());
				gbs.add (gb);
			}
			mv.addObject ("gbs" , gbs);
			// 根据类型 查询品牌结束
			String orderbys = orderBy + " " + orderType;
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause (orderbys);
			com.amall.core.bean.GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			List <Long> ids = genericIds (gc);
			goodsCriteria.andGcIdIn (ids);
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				goodsCriteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				/*
				 * goodsCriteria.andStorePriceBetween(BigDecimal.valueOf(CommUtil.null2Double(
				 * store_price_begin)), BigDecimal
				 * .valueOf(CommUtil.null2Double(store_price_end)));
				 */
				mv.addObject ("store_price_begin" , store_price_begin);
				/* mv.addObject("store_price_end", store_price_end); */
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				goodsCriteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
				mv.addObject ("goods_name" , goods_name);
			}// 进行了系列的模糊查询规则
			// Pagination cs = goodsService.getObjectListWithPage(goodsExample);;
			// 判断 商品所属的店铺是否处于正常状态
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andStoreStatusEqualTo (Integer.valueOf (2));
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			List <Long> storeIds = new ArrayList <Long> ();
			for (StoreWithBLOBs storeWithBLOBs : stores)
			{
				storeIds.add (storeWithBLOBs.getId ());
			}
			goodsCriteria.andGoodsStoreIdIn (storeIds);
			goodsExample.setPageSize (Integer.valueOf (20));
			List goods_property = new ArrayList ();
			if (!CommUtil.null2String (brand_ids).equals (""))
			{
				String [ ] brand_id_list = brand_ids.substring (1).split ("\\|");
				if (brand_id_list.length == 1)
				{
					String brand_id = brand_id_list[0];
					String [ ] brand_info_list = brand_id.split (",");
					goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
					Map map = new HashMap ();
					GoodsBrand brand = this.brandService.getByKey (CommUtil.null2Long (brand_info_list[0]));
					map.put ("name" , "品牌");
					map.put ("value" , brand.getName ());
					map.put ("type" , "brand");
					map.put ("id" , brand.getId ());
					goods_property.add (map);
				}
				else
				{
					for (int i = 0 ; i < brand_id_list.length ; i++)
					{
						String brand_id = brand_id_list[i];
						if (i == 0)
						{
							String [ ] brand_info_list = brand_id.split (",");
							goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
							Map map = new HashMap ();
							GoodsBrand brand = this.brandService.getByKey (CommUtil.null2Long (brand_info_list[0]));
							map.put ("name" , "品牌");
							map.put ("value" , brand.getName ());
							map.put ("type" , "brand");
							map.put ("id" , brand.getId ());
							goods_property.add (map);
						}
						else if (i == brand_id_list.length - 1)
						{
							String [ ] brand_info_list = brand_id.split (",");
							goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
							Map map = new HashMap ();
							GoodsBrand brand = this.brandService.getByKey (CommUtil.null2Long (brand_info_list[0]));
							map.put ("name" , "品牌");
							map.put ("value" , brand.getName ());
							map.put ("type" , "brand");
							map.put ("id" , brand.getId ());
							goods_property.add (map);
						}
						else
						{
							String [ ] brand_info_list = brand_id.split (",");
							goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
							Map map = new HashMap ();
							GoodsBrand brand = this.brandService.getByKey (CommUtil.null2Long (brand_info_list[0]));
							map.put ("name" , "品牌");
							map.put ("value" , brand.getName ());
							map.put ("type" , "brand");
							map.put ("id" , brand.getId ());
							goods_property.add (map);
						}
					}
				}
				mv.addObject ("brand_ids" , brand_ids);
			}
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (0));
			goodsCriteria.andDeletestatusEqualTo (false);
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			System.err.println (goodsExample.getOrderByClause ());
			/* 如果有筛选条件，就进行筛选 */
			List <GoodsWithBLOBs> goods = (List <GoodsWithBLOBs>) pList.getList ();
			if (gs_ids != null && !gs_ids.equals (""))
			{
				List <GoodsWithBLOBs> newGoods = this.goodsViewTools.searchGoodsOfSpec (gs_ids , goods);
				pList.setList (newGoods);
			}
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/store_goods_list.htm" , "" , "" , pList , mv);
			if (!CommUtil.null2String (gs_ids).equals (""))
			{
				List gsp_lists = generic_gsp (gs_ids);
				for (int j = 0 ; j < gsp_lists.size () ; j++)
				{
					List gsp_list = (List) gsp_lists.get (j);
					if (gsp_list.size () == 1)
					{
						GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (0);
						Map map = new HashMap ();
						map.put ("name" , gsp.getSpec ().getName ());
						map.put ("value" , gsp.getValue ());
						map.put ("type" , "gs");
						map.put ("id" , gsp.getId ());
						goods_property.add (map);
					}
					else
					{
						for (int i = 0 ; i < gsp_list.size () ; i++)
						{
							if (i == 0)
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
							else if (i == gsp_list.size () - 1)
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
							else
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
						}
					}
				}
				mv.addObject ("gs_ids" , gs_ids);
			}
			mv.addObject ("gc" , gc);
			mv.addObject ("orderBy" , orderBy1);
			mv.addObject ("user_viewed_goods" , request.getSession (false).getAttribute ("user_viewed_goods"));
			mv.addObject ("goods_property" , goods_property);
			if (CommUtil.null2String (goods_view).equals ("list"))
				goods_view = "list";
			else
			{
				goods_view = "thumb";
			}
			if ((detail_property_status != null) && (!detail_property_status.equals ("")))
			{
				mv.addObject ("detail_property_status" , detail_property_status);
				String [ ] temp_str = detail_property_status.split (",");
				Map pro_map = new HashMap ();
				List pro_list = new ArrayList ();
				for (String property_status : temp_str)
				{
					if ((property_status != null) && (!property_status.equals ("")))
					{
						String [ ] mark = property_status.split ("_");
						pro_map.put (mark[0] , mark[1]);
						pro_list.add (mark[0]);
					}
				}
				mv.addObject ("pro_list" , pro_list);
				mv.addObject ("pro_map" , pro_map);
			}
			mv.addObject ("goods_view" , goods_view);
			mv.addObject ("all_property_status" , all_property_status);
			return mv;
		}

	private List <List <GoodsSpecProperty>> generic_gsp (String gs_ids)
		{
			List <List <GoodsSpecProperty>> list = new ArrayList <List <GoodsSpecProperty>> ();
			String [ ] gs_id_list = gs_ids.substring (1).split ("\\|");
			for (String gd_id_info : gs_id_list)
			{
				// String[] gs_info_list = gd_id_info.split(",");
				GoodsSpecProperty gsp = this.goodsSpecPropertyService.getByKey (CommUtil.null2Long (gd_id_info));
				boolean create = true;
				for (List <GoodsSpecProperty> gsp_list : list)
				{
					for (GoodsSpecProperty gsp_temp : gsp_list)
					{
						if (gsp_temp.getSpec ().getId ().equals (gsp.getSpec ().getId ()))
						{
							gsp_list.add (gsp);
							create = false;
							break;
						}
					}
				}
				if (create)
				{
					List <GoodsSpecProperty> gsps = new ArrayList <GoodsSpecProperty> ();
					gsps.add (gsp);
					list.add (gsps);
				}
			}
			return list;
		}

	/**
	 * @todo 异步返回商品的评论列表 商品评价
	 * @param request
	 * @param response
	 * @param id
	 * @param goods_id
	 *            商品id
	 * @param currentPage
	 *            当前页号
	 * @return
	 */
	@RequestMapping({ "/goods_evaluation.htm" })
	public ModelAndView goods_evaluation (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			String template = "default";
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			EvaluateExample evaluateExample = new EvaluateExample ();
			evaluateExample.clear ();
			evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			evaluateExample.setOrderByClause ("addTime desc");
			evaluateExample.setPageSize (2);
			evaluateExample.createCriteria ().andEvaluateTypeEqualTo ("goods").andEvaluateGoodsIdEqualTo (CommUtil.null2Long (id));
			// 使用ajax异步刷新评论
			String ajax_url = CommUtil.getURL (request) + "/goods_detail.htm";
			Pagination pList = this.evaluateService.getObjectListWithPage (evaluateExample);
			mv.addObject ("totalPages" , pList.getTotalPage ());
			mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			/*
			 * CommUtil.addIPageList2ModelAndView(CommUtil.getURL(request)+
			 * "/goods_evaluation.htm", "", "", pList, mv);
			 */
			List <EvaluateWithBLOBs> evass = (List <EvaluateWithBLOBs>) pList.getList ();
			for (EvaluateWithBLOBs e : evass)
			{
				User user = this.userService.getByKey (e.getEvaluate_user ().getId ());
				user.setPhoto (this.accessoryService.getByKey (user.getPhotoId ()));
				e.setEvaluate_user (user);
			}
			mv.addObject ("objs" , evass);
			mv.addObject ("storeViewTools" , this.storeViewTools);
			mv.addObject ("store" , store);
			mv.addObject ("goods" , goodsWithBLOBs);
			// 查看当前登录用户是否已经购买该商品,给予是否评价的指示
			// 当前用户是否购买过此商品.且评价状态为待评价
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			User user = SecurityUserHolder.getCurrentUser ();
			OrderFormExample.Criteria criteria = orderFormExample.createCriteria ();
			boolean evaStatus = false;
			if (user != null)
			{
				criteria.andUserIdEqualTo (user.getId ()).andOrderStatusEqualTo (Integer.valueOf (40)).andStoreIdEqualTo (store.getId ());
				List <OrderFormWithBLOBs> order = this.orderFormService.getObjectList (orderFormExample);
				GoodsCartExample goodsCartExample = new GoodsCartExample ();
				for (OrderFormWithBLOBs o : order)
				{
					goodsCartExample.clear ();
					goodsCartExample.createCriteria ().andOfIdEqualTo (o.getId ());
					List <GoodsCart> gcs = this.goodsCartService.getObjectList (goodsCartExample);
					for (GoodsCart gc : gcs)
					{
						if (gc.getGoodsId ().equals (goodsWithBLOBs.getId ()))
						{
							evaStatus = true;
							mv.addObject ("order" , o);
							break;
						}
					}
				}
			}
			else
			{
				// 用户尚未登录
				evaStatus = false;
			}
			mv.addObject ("evaStatus" , evaStatus);
			// 循环计算好评,中评,差评次数
			evaluateExample.clear ();
			evaluateExample.createCriteria ().andEvaluateTypeEqualTo ("goods").andEvaluateGoodsIdEqualTo (CommUtil.null2Long (id));
			List <EvaluateWithBLOBs> evas = this.evaluateService.getObjectList (evaluateExample);
			int goodEvas = 0 , commEvas = 0 , badEvas = 0;
			for (EvaluateWithBLOBs e : evas)
			{
				if (e.getEvaluateBuyerVal () == 1)
				{
					goodEvas++;
				}
				else if (e.getEvaluateBuyerVal () == 0)
				{
					commEvas++;
				}
				else if (e.getEvaluateBuyerVal () == -1)
				{
					badEvas++;
				}
			}
			mv.addObject ("evas" , evas);
			mv.addObject ("goodEvas" , goodEvas);
			mv.addObject ("gep" , CommUtil.divide (goodEvas , evas.size ()));
			mv.addObject ("badEvas" , badEvas);
			mv.addObject ("bep" , CommUtil.divide (badEvas , evas.size ()));
			mv.addObject ("commEvas" , commEvas);
			int cepPer = 100 - CommUtil.divide (goodEvas , evas.size ()) - CommUtil.divide (badEvas , evas.size ());
			if (evas.size () + goodEvas + commEvas + badEvas == 0)
			{
				cepPer = 0;
			}
			mv.addObject ("cep" , cepPer);
			return mv;
		}

	@RequestMapping({ "/evaType.htm" })
	public ModelAndView evaType (HttpServletRequest request , HttpServletResponse response , String evaType , String goodsId , String currentPage)
		{
			String template = "default";
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_evaluation_type.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (evaType == null || evaType.equals (""))
			{
				evaType = "allEva";
			}
			if (evaType != null && !evaType.equals (""))
			{
				Pagination pList = null;
				EvaluateExample evaluateExample = new EvaluateExample ();
				// 全部评价
				if (evaType.equals ("allEva"))
				{
					evaluateExample.clear ();
					evaluateExample.setOrderByClause ("addTime desc");
					evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					evaluateExample.setPageSize (8);
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId)).andEvaluateTypeEqualTo ("goods").andEvaluateStatusNotEqualTo (Integer.valueOf (2));
					// 好评
				}
				else if (evaType.equals ("goodEva"))
				{
					evaluateExample.clear ();
					evaluateExample.setOrderByClause ("addTime desc");
					evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					evaluateExample.setPageSize (8);
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId)).andEvaluateTypeEqualTo ("goods").andEvaluateBuyerValEqualTo (1).andEvaluateStatusEqualTo (Integer.valueOf (0));
					;
					// 中评
				}
				else if (evaType.equals ("commEva"))
				{
					evaluateExample.clear ();
					evaluateExample.setOrderByClause ("addTime desc");
					evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					evaluateExample.setPageSize (8);
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId)).andEvaluateTypeEqualTo ("goods").andEvaluateBuyerValEqualTo (0).andEvaluateStatusEqualTo (Integer.valueOf (0));
					// 差评
				}
				else if (evaType.equals ("badEva"))
				{
					evaluateExample.clear ();
					evaluateExample.setOrderByClause ("addTime desc");
					evaluateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					evaluateExample.setPageSize (8);
					evaluateExample.createCriteria ().andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId)).andEvaluateTypeEqualTo ("goods").andEvaluateBuyerValEqualTo (-1).andEvaluateStatusEqualTo (Integer.valueOf (0));
				}
				pList = this.evaluateService.getObjectListWithPage (evaluateExample);
				Gson gson = new Gson ();
				String creditRule = this.configService.getSysConfig ().getCreditrule ();
				Map creditMap = gson.fromJson (creditRule , new TypeToken <Map <String, String>> ()
				{
				}.getType ());
				for (int i = 0 ; i < pList.getList ().size () ; i++)
				{
					EvaluateWithBLOBs e = (EvaluateWithBLOBs) pList.getList ().get (i);
					User user = this.userService.getByKey (e.getEvaluateUserId ());
					int level = getCreditLevel (creditMap , user);
					user.setCreditlevel (level);
					if (user.getPhotoId () != null)
					{
						user.setPhoto (this.accessoryService.getByKey (user.getPhotoId ()));
					}
					e.setEvaluate_user (user);
				}
				mv.addObject ("objs" , pList.getList ());
				mv.addObject ("eType" , evaType);
				evaluateExample.setPageNo (CommUtil.null2Int (currentPage));
				evaluateExample.setPageSize (5);
				pList = this.evaluateService.getObjectListWithPage (evaluateExample);
				String Ajax_url = CommUtil.getURL (request) + "/evaType.htm";
				mv.addObject ("totalPages" , pList.getTotalPage ());
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (Ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
				mv.addObject ("goods" , goodsWithBLOBs);
				/*
				 * CommUtil.addIPageList2ModelAndView(CommUtil.getURL(request)+"evaType"
				 * , "", "", pList, mv);
				 */
			}
			return mv;
		}

	/**
	 * 
	 * @todo ajax异步刷新商品详情页图片
	 * @author wsw
	 * @date 2015年6月18日 下午5:08:23
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/goods_img_detail.htm" })
	public ModelAndView goods_img_detail (HttpServletRequest request , HttpServletResponse response , String id)
		{
			String template = "default";
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			if (store != null)
			{
				template = store.getTemplate (); // 设置店铺模版
			}
			ModelAndView mv = new JModelAndView (template + "/goods_img_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			List <Accessory> accessories = this.accessoryService.getAccListOfGoodsByPhotoId (CommUtil.null2Long (id));
			goodsWithBLOBs.setGoodsPhotos (accessories);
			mv.addObject ("goods" , goodsWithBLOBs);
			return mv;
		}

	/**
	 * 
	 * @todo aJax异步刷新,返回参数列表
	 * @author wsw
	 * @date 2015年6月18日 下午5:55:43
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/goods_sublist.htm" })
	public ModelAndView goods_sublist (HttpServletRequest request , HttpServletResponse response , String id)
		{
			String template = "default";
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			StoreWithBLOBs store = this.storeService.getByKey (goodsWithBLOBs.getGoodsStoreId ());
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_sublist.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (id != null && !id.equals (""))
			{
				List <GoodsSpecProperty> gsps = this.goodsSpecPropertyService.selectGoodsPropertyByLeftJoinSpecAndGoodsId (CommUtil.null2Long (id));
				mv.addObject ("gsps" , gsps);
			}
			mv.addObject ("store" , store);
			mv.addObject ("goods" , goodsWithBLOBs);
			return mv;
		}

	@RequestMapping({ "/goods_detail.htm" })
	public ModelAndView goods_detail (HttpServletRequest request , HttpServletResponse response , String id , String goods_id)
		{
			String template = "default";
			Store store = this.storeService.getByKey (CommUtil.null2Long (id));
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
			mv.addObject ("obj" , goods);
			generic_evaluate (goods.getGoodsStore () , mv);
			this.userTools.query_user ();
			return mv;
		}

	@RequestMapping({ "/goods_order.htm" })
	public ModelAndView goods_order (HttpServletRequest request , HttpServletResponse response , String id , String goods_id , String currentPage)
		{
			String template = "default";
			Store store = this.storeService.getByKey (CommUtil.null2Long (id));
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.createCriteria ().andOrderStatusGreaterThanOrEqualTo (Integer.valueOf (20));
			List <OrderFormWithBLOBs> orderForms = orderFormService.getObjectList (orderFormExample);
			List <Long> ofIds = new ArrayList <Long> ();
			for (OrderFormWithBLOBs orderFormWithBLOBs : orderForms)
			{
				ofIds.add (orderFormWithBLOBs.getId ());
			}
			GoodsCartExample goodsCartExample = new GoodsCartExample ();
			goodsCartExample.clear ();
			goodsCartExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsCartExample.setOrderByClause ("addTime desc");
			goodsCartExample.setPageSize (Integer.valueOf (8));
			goodsCartExample.createCriteria ().andGoodsIdEqualTo (CommUtil.null2Long (goods_id)).andOfIdIn (ofIds);
			Pagination pList = goodsCartService.getObjectListWithPage (goodsCartExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/goods_order.htm" , "" , "" , pList , mv);
			mv.addObject ("storeViewTools" , this.storeViewTools);
			return mv;
		}

	@RequestMapping({ "/goods_consult.htm" })
	public ModelAndView goods_consult (HttpServletRequest request , HttpServletResponse response , String id , String goods_id , String currentPage)
		{
			String template = "default";
			Store store = this.storeService.getByKey (CommUtil.null2Long (id));
			if (store != null)
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/goods_consult.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ConsultExample consultExample = new ConsultExample ();
			consultExample.clear ();
			consultExample.createCriteria ().andGoodsIdEqualTo (CommUtil.null2Long (goods_id));
			consultExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			consultExample.setOrderByClause ("addTime desc");
			Pagination pList = consultService.getObjectListWithPage (consultExample);
			/*
			 * ConsultQueryObject qo = new ConsultQueryObject(currentPage, mv,
			 * "addTime", "desc"); qo.addQuery("obj.goods.id", new
			 * SysMap("goods_id", CommUtil.null2Long(goods_id)), "="); IPageList
			 * pList = this.consultService.list(qo);
			 */
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/goods_consult.htm" , "" , "" , pList , mv);
			mv.addObject ("storeViewTools" , this.storeViewTools);
			mv.addObject ("goods_id" , goods_id);
			return mv;
		}

	@RequestMapping({ "/goods_consult_add.htm" })
	public ModelAndView goods_consult_add (HttpServletRequest request , HttpServletResponse response , String goods_id , String consult_content , String consult_email , String Anonymous , String consult_code)
		{
			ModelAndView mv = new JModelAndView ("user/default/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String verify_code = CommUtil.null2String (request.getSession (false).getAttribute ("consult_code"));
			boolean visit_consult = true;
			if (!this.configService.getSysConfig ().getVisitorconsult ())
			{
				if (SecurityUserHolder.getCurrentUser () == null)
				{
					visit_consult = false;
				}
				if (CommUtil.null2Boolean (Anonymous))
				{
					visit_consult = false;
				}
			}
			if (visit_consult)
			{
				if (CommUtil.null2String (consult_code).equals (verify_code))
				{
					ConsultWithBLOBs obj = new ConsultWithBLOBs ();
					obj.setAddtime (new Date ());
					obj.setConsultContent (consult_content);
					obj.setConsultEmail (consult_email);
					if (!CommUtil.null2Boolean (Anonymous))
					{
						obj.setConsultUser (SecurityUserHolder.getCurrentUser ());
						mv.addObject ("op_title" , "咨询发布成功");
					}
					/*
					 * obj.setGoods(this.goodsService.getByKey(CommUtil
					 * .null2Long(goods_id)));
					 */
					obj.setGoodsId (CommUtil.null2Long (goods_id));
					this.consultService.add (obj);
					request.getSession (false).removeAttribute ("consult_code");
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "验证码错误，咨询发布失败");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "不允许游客咨询");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/goods_" + goods_id + ".htm");
			return mv;
		}

	@RequestMapping({ "/load_goods_gsp.htm" })
	public void load_goods_gsp (HttpServletRequest request , HttpServletResponse response , String gsp , String id)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (id));
			Map map = new HashMap ();
			int count = 0;
			double price = 0.0D;
			if ((goods.getGroup () != null) && (goods.getGroupBuy () == 2))
			{
				for (GroupGoods gg : goods.getGroupGoodsList ())
					if (gg.getGroup ().getId ().equals (goods.getGroup ().getId ()))
					{
						count = gg.getGgGroupCount () - gg.getGgDefCount ();
						price = CommUtil.null2Double (gg.getGgPrice ());
					}
			}
			else
			{
				count = goods.getGoodsInventory ();
				price = CommUtil.null2Double (goods.getStorePrice ());
				if (goods.getInventoryType ().equals ("spec"))
				{
					List <Map> list = (List) Json.fromJson (ArrayList.class , goods.getGoodsInventoryDetail ());
					String [ ] gsp_ids = gsp.split (",");
					for (Map temp : list)
					{
						String [ ] temp_ids = CommUtil.null2String (temp.get ("id")).split ("_");
						Arrays.sort (gsp_ids);
						Arrays.sort (temp_ids);
						if (Arrays.equals (gsp_ids , temp_ids))
						{
							count = CommUtil.null2Int (temp.get ("count"));
							price = CommUtil.null2Double (temp.get ("price"));
						}
					}
				}
			}
			map.put ("count" , Integer.valueOf (count));
			map.put ("price" , Double.valueOf (price));
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (map , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/trans_fee.htm" })
	public void trans_fee (HttpServletRequest request , HttpServletResponse response , String city_name , String goods_id)
		{
			Map map = new HashMap ();
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
			float mail_fee = 0.0F;
			float express_fee = 0.0F;
			float ems_fee = 0.0F;
			if (goods.getTransport () != null)
			{
				mail_fee = this.transportTools.cal_goods_trans_fee (CommUtil.null2String (goods.getTransport ().getId ()) , "mail" , CommUtil.null2String (goods.getGoodsWeight ()) , CommUtil.null2String (goods.getGoodsVolume ()) , city_name);
				express_fee = this.transportTools.cal_goods_trans_fee (CommUtil.null2String (goods.getTransport ().getId ()) , "express" , CommUtil.null2String (goods.getGoodsWeight ()) , CommUtil.null2String (goods.getGoodsVolume ()) , city_name);
				ems_fee = this.transportTools.cal_goods_trans_fee (CommUtil.null2String (goods.getTransport ().getId ()) , "ems" , CommUtil.null2String (goods.getGoodsWeight ()) , CommUtil.null2String (goods.getGoodsVolume ()) , city_name);
			}
			map.put ("mail_fee" , Float.valueOf (mail_fee));
			map.put ("express_fee" , Float.valueOf (express_fee));
			map.put ("ems_fee" , Float.valueOf (ems_fee));
			map.put ("current_city_info" , CommUtil.substring (city_name , 5));
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (map , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 商品分享
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 *            商品id
	 * @return
	 */
	@RequestMapping({ "/goods_share.htm" })
	public ModelAndView goods_share (HttpServletRequest request , HttpServletResponse response , String goods_id)
		{
			ModelAndView mv = new JModelAndView ("goods_share.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Goods goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
			mv.addObject ("obj" , goods);
			return mv;
		}

	private List <Long> genericIds (GoodsClassWithBLOBs gc)
		{
			List <Long> ids = new ArrayList ();
			ids.add (gc.getId ());
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> list = this.goodsClassService.getObjectList (goodsClassExample);
			gc.getChilds ().addAll (list);
			for (GoodsClassWithBLOBs child : gc.getChilds ())
			{
				List <Long> cids = genericIds (child);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
				ids.add (child.getId ());
			}
			return ids;
		}

	private void generic_evaluate (Store store , ModelAndView mv)
		{
			double description_result = 0.0D;
			double service_result = 0.0D;
			double ship_result = 0.0D;
			float description_evaluate = CommUtil.null2Float (10);
			float service_evaluate = CommUtil.null2Float (10);
			float ship_evaluate = CommUtil.null2Float (10);
			if (store.getSc () != null)
			{
				StoreClass sc = this.storeClassService.getByKey (store.getScId ());
				description_evaluate = CommUtil.null2Float (sc.getDescriptionEvaluate ());
				service_evaluate = CommUtil.null2Float (sc.getServiceEvaluate ());
				ship_evaluate = CommUtil.null2Float (sc.getShipEvaluate ());
				if (store.getPoint () != null)
				{
					float store_description_evaluate = CommUtil.null2Float (store.getPoint ().getDescriptionEvaluate ());
					float store_service_evaluate = CommUtil.null2Float (store.getPoint ().getServiceEvaluate ());
					float store_ship_evaluate = CommUtil.null2Float (store.getPoint ().getShipEvaluate ());
					description_result = CommUtil.subtract (Float.valueOf (store_description_evaluate) , Float.valueOf (description_evaluate));
					service_result = CommUtil.subtract (Float.valueOf (store_service_evaluate) , Float.valueOf (service_evaluate));
					ship_result = CommUtil.subtract (Float.valueOf (store_ship_evaluate) , Float.valueOf (ship_evaluate));
				}
			}
			if (description_result > 0.0D)
			{
				mv.addObject ("description_css" , "better");
				mv.addObject ("description_type" , "高于");
				mv.addObject ("description_result" , CommUtil.null2String (description_evaluate));
			}
			if (description_result == 0.0D)
			{
				mv.addObject ("description_css" , "better");
				mv.addObject ("description_type" , "持平");
				mv.addObject ("description_result" , CommUtil.null2String (description_evaluate));
			}
			if (description_result < 0.0D)
			{
				mv.addObject ("description_css" , "lower");
				mv.addObject ("description_type" , "低于");
				mv.addObject ("description_result" , CommUtil.null2String (description_evaluate));
			}
			if (service_result > 0.0D)
			{
				mv.addObject ("service_css" , "better");
				mv.addObject ("service_type" , "高于");
				mv.addObject ("service_result" , CommUtil.null2String (service_evaluate));
			}
			if (service_result == 0.0D)
			{
				mv.addObject ("service_css" , "better");
				mv.addObject ("service_type" , "持平");
				mv.addObject ("service_result" , CommUtil.null2String (service_evaluate));
			}
			if (service_result < 0.0D)
			{
				mv.addObject ("service_css" , "lower");
				mv.addObject ("service_type" , "低于");
				mv.addObject ("service_result" , CommUtil.null2String (service_evaluate));
			}
			if (ship_result > 0.0D)
			{
				mv.addObject ("ship_css" , "better");
				mv.addObject ("ship_type" , "高于");
				mv.addObject ("ship_result" , CommUtil.null2String (ship_evaluate));
			}
			if (ship_result == 0.0D)
			{
				mv.addObject ("ship_css" , "better");
				mv.addObject ("ship_type" , "持平");
				mv.addObject ("ship_result" , CommUtil.null2String (ship_evaluate));
			}
			if (ship_result < 0.0D)
			{
				mv.addObject ("ship_css" , "lower");
				mv.addObject ("ship_type" , "低于");
				mv.addObject ("ship_result" , CommUtil.null2String (ship_evaluate));
			}
		}

	/**
	 * 
	 * <p>
	 * Title: getCreditLevel
	 * </p>
	 * 
	 * @author xpy
	 * @todo 获取用户的信用等级
	 * @date 2015年8月10日 16:55
	 * @param map
	 * @param user
	 * @return
	 */
	private int getCreditLevel (Map map , User user)
		{
			int level = 1;
			if (user.getIntegral () <= Integer.parseInt (map.get ("creditrule1").toString ()))
			{
				level = 1;
			}
			else if (Integer.parseInt (map.get ("creditrule1").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule2").toString ()))
			{
				level = 2;
			}
			else if (Integer.parseInt (map.get ("creditrule2").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule3").toString ()))
			{
				level = 3;
			}
			else if (Integer.parseInt (map.get ("creditrule3").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule4").toString ()))
			{
				level = 4;
			}
			else if (Integer.parseInt (map.get ("creditrule4").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule5").toString ()))
			{
				level = 5;
			}
			else if (Integer.parseInt (map.get ("creditrule5").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule6").toString ()))
			{
				level = 6;
			}
			else if (Integer.parseInt (map.get ("creditrule6").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule7").toString ()))
			{
				level = 7;
			}
			else if (Integer.parseInt (map.get ("creditrule7").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule8").toString ()))
			{
				level = 8;
			}
			else if (Integer.parseInt (map.get ("creditrule8").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule9").toString ()))
			{
				level = 9;
			}
			else if (Integer.parseInt (map.get ("creditrule9").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule10").toString ()))
			{
				level = 10;
			}
			else if (Integer.parseInt (map.get ("creditrule10").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule11").toString ()))
			{
				level = 11;
			}
			else if (Integer.parseInt (map.get ("creditrule11").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule12").toString ()))
			{
				level = 12;
			}
			else if (Integer.parseInt (map.get ("creditrule12").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule13").toString ()))
			{
				level = 13;
			}
			else if (Integer.parseInt (map.get ("creditrule13").toString ()) < user.getIntegral () && user.getIntegral () <= Integer.parseInt (map.get ("creditrule14").toString ()))
			{
				level = 14;
			}
			else if (Integer.parseInt (map.get ("creditrule14").toString ()) < user.getIntegral ())
			{
				level = 15;
			}
			return level;
		}

	private List <Long> genericAllGcIds (GoodsClassWithBLOBs gc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (gc.getId ());
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> list = this.goodsClassService.getObjectList (goodsClassExample);
			gc.getChilds ().addAll (list);
			for (GoodsClassWithBLOBs child : gc.getChilds ())
			{
				List <Long> cids = genericIds (child);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
				ids.add (child.getId ());
			}
			return ids;
		}

	private void generic_evaluate (GoodsWithBLOBs goods , ModelAndView mv)
		{
			double description_result = 0.0D;
			double service_result = 0.0D;
			double ship_result = 0.0D;
			if ((goods != null) && (goods.getGc () != null) && (goods.getPoint () != null))
			{
				GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (goods.getGc ().getId ());
				float description_evaluate = CommUtil.null2Float (gc.getDescriptionEvaluate ());
				float service_evaluate = CommUtil.null2Float (gc.getServiceEvaluate ());
				float ship_evaluate = CommUtil.null2Float (gc.getShipEvaluate ());
				float goods_description_evaluate = CommUtil.null2Float (goods.getPoint ().getDescriptionEvaluate ());
				float goods_service_evaluate = CommUtil.null2Float (goods.getPoint ().getServiceEvaluate ());
				float goods_ship_evaluate = CommUtil.null2Float (goods.getPoint ().getShipEvaluate ());
				description_result = CommUtil.div (Float.valueOf (goods_description_evaluate - description_evaluate) , Float.valueOf (description_evaluate));
				service_result = CommUtil.div (Float.valueOf (goods_service_evaluate - service_evaluate) , Float.valueOf (service_evaluate));
				ship_result = CommUtil.div (Float.valueOf (goods_ship_evaluate - ship_evaluate) , Float.valueOf (ship_evaluate));
			}
			if (description_result > 0.0D)
			{
				mv.addObject ("description_css" , "better");
				mv.addObject ("description_type" , "高于");
				mv.addObject ("description_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (description_result) , Integer.valueOf (100)) > 100.0D ? 100.0D : CommUtil.mul (Double.valueOf (description_result) , Integer.valueOf (100)))) + "%");
			}
			if (description_result == 0.0D)
			{
				mv.addObject ("description_css" , "better");
				mv.addObject ("description_type" , "持平");
				mv.addObject ("description_result" , "-----");
			}
			if (description_result < 0.0D)
			{
				mv.addObject ("description_css" , "lower");
				mv.addObject ("description_type" , "低于");
				mv.addObject ("description_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (-description_result) , Integer.valueOf (100)))) + "%");
			}
			if (service_result > 0.0D)
			{
				mv.addObject ("service_css" , "better");
				mv.addObject ("service_type" , "高于");
				mv.addObject ("service_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (service_result) , Integer.valueOf (100)))) + "%");
			}
			if (service_result == 0.0D)
			{
				mv.addObject ("service_css" , "better");
				mv.addObject ("service_type" , "持平");
				mv.addObject ("service_result" , "-----");
			}
			if (service_result < 0.0D)
			{
				mv.addObject ("service_css" , "lower");
				mv.addObject ("service_type" , "低于");
				mv.addObject ("service_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (-service_result) , Integer.valueOf (100)))) + "%");
			}
			if (ship_result > 0.0D)
			{
				mv.addObject ("ship_css" , "better");
				mv.addObject ("ship_type" , "高于");
				mv.addObject ("ship_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (ship_result) , Integer.valueOf (100)))) + "%");
			}
			if (ship_result == 0.0D)
			{
				mv.addObject ("ship_css" , "better");
				mv.addObject ("ship_type" , "持平");
				mv.addObject ("ship_result" , "-----");
			}
			if (ship_result < 0.0D)
			{
				mv.addObject ("ship_css" , "lower");
				mv.addObject ("ship_type" , "低于");
				mv.addObject ("ship_result" , CommUtil.null2String (Double.valueOf (CommUtil.mul (Double.valueOf (-ship_result) , Integer.valueOf (100)))) + "%");
			}
		}

	@RequestMapping({ "/getGoodsById.htm" })
	@ResponseBody
	public String getGoodsById (HttpServletRequest request , HttpServletResponse response , String id , String count)
		{
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			int goodsTransfee = goodsWithBLOBs.getGoodsTransfee ();
			String rsGoodsTransfee = "";
			if (goodsTransfee > 0)
			{
				// 卖家承担运费
				rsGoodsTransfee = "配送:    快递免邮 <br>运费: <span id='goodsTransFee_" + id + "'>0.00</span>";
			}
			else
			{
				// 买家承担运费,组装配送方式
				if (goodsWithBLOBs.getTransport () != null)
				{
					String rsGoodsTransfee_start = "配送:    <select id='goodsTransType_" + id + "' onchange='changeTransType(this)'> ";
					rsGoodsTransfee_start += "<option value=''>--请选择--</option>";
					// 配送方式`商品数量`商品id
					if (goodsWithBLOBs.getTransport ().getTransEms ())
					{
						rsGoodsTransfee_start += "<option value='ems`" + count + "`" + id + "'>EMS</option>";
					}
					if (goodsWithBLOBs.getTransport ().getTransExpress ())
					{
						rsGoodsTransfee_start += "<option value='express`" + count + "`" + id + "'>快递</option>";
					}
					if (goodsWithBLOBs.getTransport ().getTransMail ())
					{
						rsGoodsTransfee_start += "<option value='mail`" + count + "`" + id + "'>平邮</option>";
					}
					String rsGoodsTransfee_end = "</select><br><div></div> ";
					rsGoodsTransfee = rsGoodsTransfee_start + rsGoodsTransfee_end;
				}
			}
			return rsGoodsTransfee;
		}

	@RequestMapping({ "/getTranFee.htm" })
	@ResponseBody
	public String getTranFee (HttpServletRequest request , HttpServletResponse response , String type , String count , String id)
		{
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			TransportWithBLOBs transportWithBLOBs = goodsWithBLOBs.getTransport ();
			List <Map> list = null;
			if (type.equals ("ems"))
			{
				String emsinfo = transportWithBLOBs.getTransEmsInfo ();
				// json串转object
				list = (List) Json.fromJson (List.class , emsinfo);
			}
			if (type.equals ("express"))
			{
				String expressinfo = transportWithBLOBs.getTransExpressInfo ();
				list = (List) Json.fromJson (List.class , expressinfo);
			}
			if (type.equals ("mail"))
			{
				String mailinfo = transportWithBLOBs.getTransMailInfo ();
				list = (List) Json.fromJson (List.class , mailinfo);
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
			return "运费: <span id='goodsTransFee_" + id + "'>" + String.valueOf (calFee) + "</span><input type='hidden' id='store" + id + "' value='" + goodsWithBLOBs.getGoodsStoreId () + "'/>";
		}

	/* 特卖场 */
	@RequestMapping({ "/area_sale.htm" })
	public ModelAndView over_purchases (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("area_sale.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "tmc");
			/* 查询所有特卖场楼层开始,查询改楼层商品 只显示8个 */
			Integer id = 9999;// 特卖场模块id为9999
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.setOrderByClause ("sequence");
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
			mv.addObject ("floork" , floorList);		// 商品大类
			// 爆款推荐
			GoodsExample gc = new GoodsExample ();
			List <Goods> goodsLists = null;
			gc.clear ();
			gc.setOrderByClause ("goods_average desc limit 0,15");
			gc.createCriteria ().andModuleIdGreaterThanOrEqualTo (1000).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			goodsLists = goodsService.selectByExample (gc);
			mv.addObject ("goodsList" , goodsLists);
			// 特卖产品
			GoodsExample ge = new GoodsExample ();
			List <GoodsWithBLOBs> goodsList = null;
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				ge.clear ();
				ge.setOrderByClause ("addTime desc limit 0,10");
				ge.createCriteria ().andModuleIdEqualTo (goodsModuleFloor.getId ()).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				goodsList = goodsService.getObjectList (ge);
				goodsModuleFloor.setGoodsList (goodsList);
			}
			mv.addObject ("floorList" , floorList);
			// 查询所有特卖场楼层结束
			return mv;
		}

	/* 特卖场分层 */
	@RequestMapping({ "/area_saleList.htm" })
	public ModelAndView Salefieldpartition (HttpServletRequest request , HttpServletResponse response , String floorId , String currentPage , String store_price_begin , String store_price_end , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("area_saleList.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "tmc");
			/* 顶部导航 */
			Integer id = 9999;// 特卖场模块id为9999
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.clear ();
			gmfe.setOrderByClause ("sequence");
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorLists = goodsModuleFloorService.getObjectList (gmfe);
			mv.addObject ("floorListh" , floorLists);
			/* 商品导航 */
			GoodsModuleFloorExample gmfes = new GoodsModuleFloorExample ();
			gmfes.clear ();
			gmfes.createCriteria ().andIdEqualTo (Integer.parseInt (floorId));
			gmfes.setOrderByClause ("sequence");
			List <GoodsModuleFloor> floorListss = goodsModuleFloorService.getObjectList (gmfes);
			mv.addObject ("floorLists" , floorListss);
			/* 导航结束 */
			GoodsExample ge = new GoodsExample ();
			ge.clear ();
			if (orderBy == null || orderBy.equals (""))
			{
				ge.setOrderByClause ("goods_average desc");	// 默认综合排序
			}
			else
			{
				ge.setOrderByClause (orderBy + " " + orderType);
			}
			if (currentPage == null)
			{
				ge.setPageNo (1);
			}
			else
			{
				ge.setPageNo (Integer.parseInt (currentPage));
			}
			List <Integer> nextId = new ArrayList <Integer> ();
			nextId.add (Integer.parseInt (floorId));
			ge.setPageSize (8);
			GoodsExample.Criteria criteria = ge.createCriteria ();
			criteria.andModuleIdIn (nextId).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				criteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				criteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			floorExample.createCriteria ().andModuleIdEqualTo (Integer.parseInt (floorId));
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			mv.addObject ("floorList" , floorList);
			mv.addObject ("floorId" , floorId);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("orderBy" , orderBy);
			return mv;
		}

	private void banner (ModelAndView mv , String apMark)
		{
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
			advertPositionCriteria.andApMarkEqualTo (apMark);// 首页位置一的广告位
			advertPositionExample.setOrderByClause ("addTime asc");
			List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
			if (advertPositions != null && advertPositions.size () != 0)
			{
				AdvertPositionWithBLOBs advertPosition = advertPositions.get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (advertPosition.getId ());
				// 审核通过的
				advertCriteria.andAdStatusEqualTo (Globals.NUBER_ONE);
				advertExample.setOrderByClause ("ad_slide_sequence asc");
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				if (adverts != null && adverts.size () != 0)
				{
					if (adverts.size () > 8)// 如果广告图片超过了8张，则只显示8张
					{
						List <Advert> adverts2 = new ArrayList <Advert> ();
						for (int i = 0 ; i < 8 ; i++)
						{
							Advert advert = adverts.get (i);
							adverts2.add (advert);
						}
						advertPosition.getAdvs ().addAll (adverts2);
					}
					else
					{// 广告图片少于8张
						advertPosition.getAdvs ().addAll (adverts);
					}
					mv.addObject ("obj" , advertPosition);
				}
			}
		}

	/*
	 * 海外购
	 * @RequestMapping({ "/over_shopping.htm" })
	 * public ModelAndView over_shopping(HttpServletRequest request, HttpServletResponse response) {
	 * ModelAndView mv = new JModelAndView("over_shopping.html", this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request, response);
	 * return mv;
	 * }
	 */
	/*
	 * 海外购
	 * @RequestMapping({ "/over_purchases_more.htm" })
	 * public ModelAndView over_shopping_more(HttpServletRequest request, HttpServletResponse
	 * response,String floorId,String currentPage) {
	 * ModelAndView mv = new JModelAndView("over_purchases_more.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request, response);
	 * banner(mv,"tmc");
	 * GoodsModuleFloor floor = goodsModuleFloorService.getByKey(Long.valueOf(floorId));//获得该楼层信息
	 * GoodsExample ge = new GoodsExample();
	 * ge.setOrderByClause("addTime desc");
	 * ge.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
	 * ge.createCriteria().andModuleIdEqualTo(CommUtil.null2Int(floorId)).andGoodsStatusEqualTo(0).
	 * andDeletestatusEqualTo(false);
	 * ge.setPageSize(8);
	 * Pagination pList = goodsService.getObjectListWithPage(ge);
	 * CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
	 * mv.addObject("floor", floor);
	 * return mv;
	 * }
	 */
	/* 大健康 */
	@RequestMapping({ "/health.htm" })
	public ModelAndView health (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("health.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "tmc");
			/* 查询所有特卖场楼层开始,查询改楼层商品 只显示8个 */
			Integer id = 4;// 特卖场模块id为9999
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.setOrderByClause ("sequence");
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
			mv.addObject ("floork" , floorList);		// 商品大类
			// 爆款推荐
			GoodsExample gc = new GoodsExample ();
			List <GoodsWithBLOBs> goodsLists = null;
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				gc.clear ();
				gc.setOrderByClause ("goods_average desc limit 0,15");
				gc.createCriteria ().andModuleIdEqualTo (goodsModuleFloor.getId ()).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				goodsLists = goodsService.getObjectList (gc);
				System.out.println ("g=" + goodsLists.size ());
				goodsModuleFloor.setGoodsList (goodsLists);
			}
			mv.addObject ("goodsList" , floorList);
			// 大健康产品
			GoodsExample ge = new GoodsExample ();
			List <GoodsWithBLOBs> goodsList = null;
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				ge.clear ();
				ge.setOrderByClause ("addTime desc limit 0,10");
				ge.createCriteria ().andModuleIdEqualTo (goodsModuleFloor.getId ()).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				goodsList = goodsService.getObjectList (ge);
				goodsModuleFloor.setGoodsList (goodsList);
			}
			mv.addObject ("floorList" , floorList);
			// 查询所有大健康楼层结束
			return mv;
		}

	/* 大健康分层 */
	@RequestMapping({ "/health_saleList.htm" })
	public ModelAndView healthList (HttpServletRequest request , HttpServletResponse response , String floorId , String currentPage , String store_price_begin , String store_price_end , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("health_saleList.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "tmc");
			/* 顶部导航 */
			Integer id = 4;// 特卖场模块id为9999
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.clear ();
			gmfe.setOrderByClause ("sequence");
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorLists = goodsModuleFloorService.getObjectList (gmfe);
			mv.addObject ("floorListh" , floorLists);
			/* 商品导航 */
			GoodsModuleFloorExample gmfes = new GoodsModuleFloorExample ();
			gmfes.clear ();
			gmfes.createCriteria ().andIdEqualTo (Integer.parseInt (floorId));
			gmfes.setOrderByClause ("sequence");
			List <GoodsModuleFloor> floorListss = goodsModuleFloorService.getObjectList (gmfes);
			mv.addObject ("floorLists" , floorListss);
			/* 导航结束 */
			GoodsExample ge = new GoodsExample ();
			ge.clear ();
			if (orderBy == null || orderBy.equals (""))
			{
				ge.setOrderByClause ("goods_average desc");	// 默认综合排序
			}
			else
			{
				ge.setOrderByClause (orderBy + " " + orderType);
			}
			if (currentPage == null)
			{
				ge.setPageNo (1);
			}
			else
			{
				ge.setPageNo (Integer.parseInt (currentPage));
			}
			List <Integer> nextId = new ArrayList <Integer> ();
			nextId.add (Integer.parseInt (floorId));
			ge.setPageSize (8);
			GoodsExample.Criteria criteria = ge.createCriteria ();
			criteria.andModuleIdIn (nextId).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				criteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				criteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			floorExample.createCriteria ().andModuleIdEqualTo (Integer.parseInt (floorId));
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			mv.addObject ("floorList" , floorList);
			mv.addObject ("floorId" , floorId);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("orderBy" , orderBy);
			return mv;
		}
}
