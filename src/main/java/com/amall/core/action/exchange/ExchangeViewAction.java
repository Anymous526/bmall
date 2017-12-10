package com.amall.core.action.exchange;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Address;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.bean.OrderAddress;
import com.amall.core.bean.User;
import com.amall.core.bean.Verify;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IMessageService;
import com.amall.core.service.INavigationService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IOrderAddressService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVerifyService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MenuTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.tools.OrderViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ExchangeViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IArticleService articleService;

	@Autowired
	private IOrderAddressService orderAddressService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private OrderViewTools orderViewTools;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private MenuTools menuTools;

	@Autowired
	private IStoreCartService storeCartService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userservice;

	@Autowired
	private INavigationService navigationService;

	@Autowired
	private IGoldRecordService goldRecordService;

	@Autowired
	private IGoldLogService goldLogService;

	@Autowired
	private IGoldRecordService goldrecordService;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private IUserVerifyService userVerifyService;

	/**
	 * 
	 * <p>
	 * Title: exchange_index
	 * </p>
	 * <p>
	 * Description: 免费兑换类型主页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_index.htm" })
	public ModelAndView exchange_index (HttpServletRequest request , HttpServletResponse response , String currentPage , String navId , String criteria , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("exchange/exchange_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			NavigationExample example = new NavigationExample ();
			example.clear ();
			example.setOrderByClause ("sequence asc");
			List <Navigation> navigations = navigationService.getObjectList (example);
			mv.addObject ("navigations" , navigations);
			IntegralGoodsExample integralGoodsExample = new IntegralGoodsExample ();
			/*
			 * if(criteria==null){
			 * criteria ="igClickCount";
			 * }
			 * if(criteria.equals("igClickCount"))
			 * {
			 * integralGoodsExample.setOrderByClause("ig_click_count desc");
			 * }else if(criteria.equals("addTime")){
			 * integralGoodsExample.setOrderByClause("addTime desc");
			 * }else if(criteria.equals("igGoodsGoldNum")){
			 * integralGoodsExample.setOrderByClause("igGoodsGoldNum asc");
			 * }
			 */
			if (orderBy != null)
			{
				integralGoodsExample.setOrderByClause (orderBy + " " + orderType);
			}
			else
			{
				integralGoodsExample.setOrderByClause ("ig_click_count desc");
			}
			integralGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			integralGoodsExample.setPageSize (8);
			IntegralGoodsExample.Criteria integralGoodsCriteria = integralGoodsExample.createCriteria ();
			integralGoodsCriteria.andIgShowEqualTo (true);
			if (navId == null || "".equals (navId))
			{
				integralGoodsCriteria.andNavigationIdIsNull ();
			}
			else
			{
				integralGoodsCriteria.andNavigationIdEqualTo (Long.parseLong (navId));
			}
			String url = this.configService.getSysConfig ().getAddress ();
			Pagination pList = this.integralGoodsService.getObjectListWithPage (integralGoodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/exchange/exchange_index.htm" , "" , "" , pList , mv);
			mv.addObject ("navId" , navId);
			mv.addObject ("criteria" , criteria);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: exchange_view
	 * </p>
	 * <p>
	 * Description: 兑换商品详情页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_view.htm" })
	public ModelAndView exchange_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			IntegralGoods integralGoods = this.integralGoodsService.getByKey (CommUtil.null2Long (id));
			/* 没有查询到对应商品则返回免费兑换首页 */
			if (integralGoods == null)
			{
				mv = new JModelAndView ("exchange/exchange_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return returnExchangeIndex (mv);
			}
			Accessory igGoodsImg = this.accessoryService.getByKey (integralGoods.getIgGoodsImgId ());
			if (igGoodsImg != null)
			{
				integralGoods.setIgGoodsImg (igGoodsImg);
			}
			/* 免费兑换商品推荐列表 */
			IntegralGoodsExample integralGoodsExample = new IntegralGoodsExample ();
			integralGoodsExample.clear ();
			integralGoodsExample.setOrderByClause ("ig_exchange_count desc");
			integralGoodsExample.createCriteria ().andIgShowEqualTo (true);
			// integralGoodsExample.createCriteria().andIgGcIdEqualTo(integralGoods.getIgGcId());
			List <IntegralGoods> List = this.integralGoodsService.getObjectList (integralGoodsExample);
			List <IntegralGoods> recommandGoodsList = null;
			if (List.size () > 7)
			{
				recommandGoodsList = List.subList (0 , 7);
			}
			else
			{
				recommandGoodsList = List;
			}
			if (recommandGoodsList.size () > 0)
			{
				for (IntegralGoods ig : recommandGoodsList)
				{
					Accessory image = this.accessoryService.getByKey (ig.getIgGoodsImgId ());
					ig.setIgGoodsImg (image);
				}
			}
			mv = new JModelAndView ("exchange/exchange_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			integralGoods.setIgClickCount (integralGoods.getIgClickCount () + 1);
			this.integralGoodsService.updateByObject (integralGoods);
			Accessory photo = this.accessoryService.getByKey (integralGoods.getIgGoodsImgId ());
			NavigationExample example = new NavigationExample ();
			example.clear ();
			example.setOrderByClause ("sequence asc");
			List <Navigation> navigations = navigationService.getObjectList (example);
			mv.addObject ("navigations" , navigations);
			mv.addObject ("photo" , photo);
			mv.addObject ("obj" , integralGoods);
			mv.addObject ("recommandGoodsList" , recommandGoodsList);
			mv.addObject ("user" , user);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: exchange_view
	 * </p>
	 * <p>
	 * Description: 兑换商品详情页
	 * </p>
	 * 
	 * @author xpy
	 * @date 2015年8月17日 20:30
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_datail_view.htm" })
	public ModelAndView exchange_detail_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			Long goodsId = CommUtil.null2Long (id);
			IntegralGoods integralGoods = this.integralGoodsService.getByKey (goodsId);
			Accessory igGoodsImg = null;
			if (null != integralGoods && null != integralGoods.getIgGoodsImgId ())
			{
				igGoodsImg = this.accessoryService.getByKey (integralGoods.getIgGoodsImgId ());
			}
			if (igGoodsImg != null)
			{
				integralGoods.setIgGoodsImg (igGoodsImg);
			}
			/* 没有查询到对应商品则返回免费兑换首页 */
			if (integralGoods == null)
			{
				mv = new JModelAndView ("exchange/exchange_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return returnExchangeIndex (mv);
			}
			mv = new JModelAndView ("exchange/exchange_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			integralGoods.setIgClickCount (integralGoods.getIgClickCount () + 1);
			this.integralGoodsService.updateByObject (integralGoods);
			Accessory photo = this.accessoryService.getByKey (integralGoods.getIgGoodsImgId ());
			NavigationExample example = new NavigationExample ();
			example.clear ();
			example.setOrderByClause ("sequence asc");
			List <Navigation> navigations = navigationService.getObjectList (example);
			mv.addObject ("navigations" , navigations);
			mv.addObject ("photo" , photo);
			mv.addObject ("obj" , integralGoods);
			mv.addObject ("user" , user);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: exchange_order
	 * </p>
	 * <p>
	 * Description: 免费兑换订单生成页面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 *            礼品金兑换商品id
	 * @param exchange_count
	 *            兑换数量
	 * @param igGoodsPrice
	 * @param igGoodsGoldNum
	 *            单件商品礼品金
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_order.htm" })
	public ModelAndView exchange_order (HttpServletRequest request , HttpServletResponse response , String id , String exchangeCount , String igGoodsPrice , String igGoodsGoldNum)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			IntegralGoods integralGoods = this.integralGoodsService.getByKey (CommUtil.null2Long (id));
			/* 用户未登录 */
			if (user == null)
			{
				return returnExchangeIndex (mv);
			}
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = SecurityUserHolder.getCurrentUser ();
				currentUser = userService.getByKey (currentUser.getId ());
				System.out.println ("支付密码=" + currentUser.getPayPassword ());
				System.out.println (currentUser.getUsername ());
			}
			/* 商品不存在 */
			if (integralGoods == null)
			{
				return returnExchangeIndex (mv);
			}
			/* 兑换数量超出最大许可数量或者库存数 */
			if (integralGoods.getIgLimitCount () < CommUtil.null2Int (exchangeCount) || integralGoods.getIgGoodsCount () < CommUtil.null2Int (exchangeCount))
			{
				return returnExchangeIndex (mv);
			}
			/* 　用户积分不够　 */
			/*
			 * if (user.getIntegral() < integralGoods.getIgGoodsIntegral()
			 * CommUtil.null2Int(exchangeCount)) {
			 * return returnExchangeIndex(mv);
			 * }
			 */
			List <IntegralGoods> goods = this.integralGoodsService.selectGoodsClassNameByGcIdAndTimeDesc (this.configService.getSysConfig ().getGoodsClassCount ());
			// for (IntegralGoods ig : goods) {
			// ig.setGc(this.goodsClassService.getByKey(ig.getIgGcId()));
			// }
			// 此表不再存储兑换信息 edit by 田
			// GoldRecordWithBLOBs gol=new GoldRecordWithBLOBs();
			// gol.setAddtime(new Date());
			// gol.setGoldCount(Integer.valueOf(igGoodsGoldNum));
			// gol.setGoldSn("login");
			// gol.setGoldUserId(user.getId());
			// gol.setGoldPayment(CommUtil.formatLongDate(new
			// Date())+"用"+Integer.valueOf(igGoodsGoldNum)
			// *Integer.valueOf(exchangeCount)+"礼品金，兑换了"+exchangeCount+"件商品");
			// this.goldrecordService.add(gol);
			/*
			 * GoldLogWithBLOBs gl = new GoldLogWithBLOBs();
			 * gl.setAddtime(new Date());
			 * gl.setGlUser(user);
			 * gl.setGlContent(CommUtil.formatLongDate(new
			 * Date())+"用"+Integer.valueOf(igGoodsGoldNum)
			 * Integer.valueOf(exchangeCount)+"礼品金，兑换"+integralGoods.getIgGoodsName()+exchangeCount+
			 * "件商品");
			 */
			mv = new JModelAndView ("exchange/exchange_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// integralGoods.setIgGoodsCount(integralGoods.getIgGoodsCount()-Integer.parseInt(exchangeCount));
			// //库存减少
			this.integralGoodsService.updateByObject (integralGoods);
			mv.addObject ("currentUser" , currentUser);
			mv.addObject ("igs" , goods);
			mv.addObject ("obj" , integralGoods);
			mv.addObject ("exchangeCount" , exchangeCount);
			mv.addObject ("totalPrice" , integralGoods.getIgGoodsGoldNum () * CommUtil.null2Int (exchangeCount));
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: exchange_order_view
	 * </p>
	 * <p>
	 * Description: 兑换订单完成确认
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param count
	 * @param addressId
	 * @param msg
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_order_view.htm" })
	public ModelAndView exchange_order_view (HttpServletRequest request , HttpServletResponse response , String id , String count , String addressId , String msg)
		{
			ModelAndView mv = null;
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			IntegralGoods integralGoods = this.integralGoodsService.getByKey (CommUtil.null2Long (id));
			int totalCost=0;
			if (null != integralGoods && null != integralGoods.getIgGoodsGoldNum () && null != count && !count.equals (""))
			{
				totalCost = integralGoods.getIgGoodsGoldNum () * CommUtil.null2Int (count);
			}
			/* 用户未登录 */
			if (user == null)
			{
				return returnExchangeIndex (mv);
			}
			/* 商品不存在 */
			if (integralGoods == null)
			{
				return returnExchangeIndex (mv);
			}
			/* 密码有误 */
			if (user != null)
			{
				String pay = request.getParameter ("payment_pwd");
				if (!pay.equals (user.getPayPassword ()))
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "密码错误");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm");
					return mv;
				}
			}
			/* 兑换数量超出最大许可数量或者最大值 */
			if (integralGoods.getIgLimitCount () < CommUtil.null2Int (count) || integralGoods.getIgGoodsCount () < CommUtil.null2Int (count))
			{
				return returnExchangeIndex (mv);
			}
			/* 判断当前礼品金是否足够支付，优先支付分红所得礼品金 */
			int remainCoin = user.getGold () - totalCost;
			/* 当礼品金不足时 */
			if (remainCoin < 0)
			{
				return returnExchangeIndex (mv);
			}
			/* 当分红礼品金足够支付时 */
			if (remainCoin >= 0)
			{
				user.setGold (user.getGold () - totalCost);
				this.userService.updateByObject (user);
			}
			/* 生成订单 */
			IntegralGoodsOrderWithBLOBs integralGoodsOrder = new IntegralGoodsOrderWithBLOBs ();
//			BigDecimal transFee = integralGoods.getIgTransfee ();
			integralGoodsOrder.setAddtime (new Date ());
			integralGoodsOrder.setIgoAddrId (createOrderAddress (Long.valueOf (addressId)));
			integralGoodsOrder.setIgoMsg (msg);
			integralGoodsOrder.setIgoOrderSn ("igo" + CommUtil.formatTime ("yyyyMMddHHmmss" , new Date ()) + user.getId ());
			integralGoodsOrder.setIgoUserId (user.getId ());
			integralGoodsOrder.setIgoTransFee (integralGoods.getIgTransfee ());
			integralGoodsOrder.setIgoTotalIntegral (CommUtil.null2Int (count));  // 记录兑换商品件数
			integralGoodsOrder.setIgoTotalGold (totalCost);
			integralGoodsOrder.setIg (integralGoods);
			/*
			 * if (transFee.compareTo(new BigDecimal(0)) == 0) {
			 * integralGoodsOrder.setIgoStatus(20);
			 * integralGoodsOrder.setIgoPayTime(new Date());
			 * integralGoodsOrder.setIgoPayment("no_fee");
			 * } else {
			 * integralGoodsOrder.setIgoStatus(0);
			 * }
			 */
			// 积分商品的运费采取货到付款的方式，此处不考虑运费
			integralGoodsOrder.setIgoStatus (20);
			integralGoodsOrder.setIgoPayTime (new Date ());
			integralGoodsOrder.setIgoPayment ("no_fee");
			integralGoodsOrder.setIg (integralGoods);
			integralGoods.setIgExchangeCount (integralGoods.getIgExchangeCount () + CommUtil.null2Int (count));
			integralGoods.setIgGoodsCount (integralGoods.getIgGoodsCount () - CommUtil.null2Int (count));
			this.integralGoodsService.updateByObject (integralGoods);
			this.integralGoodsOrderService.add (integralGoodsOrder);
			GoldLogWithBLOBs goldlog = new GoldLogWithBLOBs ();
			goldlog.setAddtime (new Date ());
			goldlog.setGlAdminContent ("用户" + CommUtil.formatLongDate (new Date ()) + "兑换了" + integralGoods.getIgGoodsName ());
			goldlog.setGlCount (totalCost);
			goldlog.setGlUserId (user.getId ());
			this.goldLogService.add (goldlog);
			/*
			 * IntegralLog integralLog = new IntegralLog();
			 * integralLog.setAddtime(new Date());
			 * integralLog.setContent("用户" + CommUtil.formatLongDate(new Date())
			 * + "兑换了" + integralGoods.getIgGoodsName());
			 * integralLog.setIntegral(totalCost);
			 * integralLog.setIntegralUserId(user.getId());
			 * integralLog.setType("exchange");
			 * this.integralLogService.add(integralLog);
			 */
			mv = new JModelAndView ("exchange/exchange_order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			List <IntegralGoods> goods = this.integralGoodsService.selectGoodsClassNameByGcIdAndTimeDesc (this.configService.getSysConfig ().getGoodsClassCount ());
			for (IntegralGoods ig : goods)
			{
				ig.setGc (this.goodsClassService.getByKey (ig.getIgGcId ()));
			}
			mv.addObject ("igo" , integralGoodsOrder);
			mv.addObject ("igs" , goods);
			mv.addObject ("orderID" , integralGoodsOrder.getIgoOrderSn ());
			mv.addObject ("totalCost" , totalCost);
			return mv;
		}

	/**
	 * 
	 * @todo 用户未登录时,跳转登录页面,登录后并返回到当前页面
	 * @author wsw
	 * @date 2015年7月10日 下午3:42:33
	 * @return String
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_login.htm" })
	public String gotoLogin (HttpServletRequest request , HttpServletResponse response , String id)
		{
			String url = this.configService.getSysConfig ().getAddress ();
			if (url == null || url.equals (""))
			{
				url = CommUtil.getURL (request);
			}
			request.getSession (false).setAttribute ("refererUrl" , url + "/exchange/exchange_view.htm?id=" + id);
			return "redirect:/user/login.htm";
		}

	private ModelAndView returnExchangeIndex (ModelAndView mv)
		{
			mv = new ModelAndView ("redirect:/exchange/exchange_index.htm");
			return mv;
		}

	/**
	 * 
	 * @todo 跳转到兑换支付页面
	 * @author tx
	 * @date 2015年7月10日 下午3:42:33
	 * @return String
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/exchange/exchange_pay.htm" })
	public ModelAndView exchange_pay (HttpServletRequest request , HttpServletResponse response , String id , String count)
		{
			ModelAndView mv = null;
			User loginuser = SecurityUserHolder.getCurrentUser ();
			/* 当用户未登录时 */
			if (loginuser == null)
			{
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
				{
					url = CommUtil.getURL (request);
				}
				request.getSession (false).setAttribute ("referURL" , url + "/exchange/exchange_pay.htm");
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			else
			{
				loginuser = this.userservice.getByKey (loginuser.getId ());
			}
			mv = new JModelAndView ("exchange/exchange_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			IntegralGoods igGoods = this.integralGoodsService.getByKey (CommUtil.null2Long (id));
			Accessory igImg = this.accessoryService.getByKey (igGoods.getIgGoodsImgId ());
			igGoods.setIgGoodsImg (igImg);
			BigDecimal payment = igGoods.getIgGoodsPrice ();
			// 兑换数量
			int exchangeCount = CommUtil.null2Int (count);
			/* 获取实名认证状态 */
			Verify verify = this.userVerifyService.getByKey (loginuser.getVerifyId ());
			Long myVerify = Long.valueOf ("-1");
			if (verify == null)
			{
				myVerify = Long.valueOf ("-2");
			}
			else
			{
				myVerify = verify.getVerifyStatus ();
			}
			mv.addObject ("user" , this.userService.getByKey (loginuser.getId ()));
			mv.addObject ("exchangeCount" , exchangeCount);
			mv.addObject ("payment" , payment);
			mv.addObject ("igGoods" , igGoods);
			mv.addObject ("coin" , loginuser.getGold ());
			mv.addObject ("myVerify" , myVerify);
			return mv;
		}

	@RequestMapping(value = "/exchange/search.htm")
	public ModelAndView exchange_search (HttpServletRequest request , HttpServletResponse response , String keyword , String goods_name , String currentPage , String orderBy , String orderType , String gold_begin , String gold_end)
		{
			ModelAndView mv = new JModelAndView ("exchange/search.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			NavigationExample example = new NavigationExample ();
			example.clear ();
			example.setOrderByClause ("sequence asc");
			List <Navigation> navigations = navigationService.getObjectList (example);
			mv.addObject ("navigations" , navigations);
			IntegralGoodsExample goodsExample = new IntegralGoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			IntegralGoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			// goodsCriteria.andIgEndTimeGreaterThan(new Date());
			goodsExample.setPageSize (Integer.valueOf (20));
			if ((gold_begin != null) && (!gold_begin.equals ("")))
			{
				goodsCriteria.andIgGoodsGoldNumGreaterThanOrEqualTo (Integer.parseInt (gold_begin));
				mv.addObject ("gold_begin" , gold_begin);
			}
			if ((gold_end != null) && (!gold_end.equals ("")))
			{
				goodsCriteria.andIgGoodsGoldNumLessThanOrEqualTo (Integer.parseInt (gold_end));
				mv.addObject ("gold_end" , gold_end);
			}
			if ((keyword != null) && (!keyword.equals ("")))
			{
				goodsCriteria.andIgGoodsNameLike ("%" + keyword.trim () + "%");
				mv.addObject ("keyword" , keyword);
			}
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andIgGoodsNameLike ("%" + goods_name.trim () + "%");
				mv.addObject ("goods_name" , goods_name);
			}
			Pagination pList = integralGoodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * @Title: setOrderAddress
	 * @Description: 创建订单地址信息
	 * @param addressId
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年7月29日
	 */
	private Long createOrderAddress (Long addressId)
		{
			OrderAddress orderAddress = new OrderAddress ();
			Address address = addressService.getByKey (addressId);
			orderAddress.setAddtime (new Date ());
			orderAddress.setArea (address.getArea ().getAreaname ());
			orderAddress.setAreaInfo (address.getAreaInfo ());
			orderAddress.setCity (address.getArea ().getParent ().getAreaname ());
			orderAddress.setProvince (address.getArea ().getParent ().getParent ().getAreaname ());
			orderAddress.setTelephone (address.getMobile ());
			orderAddress.setTruename (address.getTruename ());
			orderAddressService.add (orderAddress);
			return orderAddress.getId ();
		}
}
