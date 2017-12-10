package com.amall.core.action.seller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreCount;
import com.amall.core.bean.StoreCountExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.lee.LeeConfig;
import com.amall.core.lee.LeeConfigurationBuilder;
import com.amall.core.lee.LeeUtil;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IMessageService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreCountService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.storevisit.IStoreVisitService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.ISellerAccountService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MenuTools;
import com.amall.core.web.tools.OrderViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: BaseSellerAction
 * </p>
 * <p>
 * Description: 卖家中心首页显示
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日上午10:54:00
 * @version 1.0
 */
@Controller
public class BaseSellerAction
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
	private IStoreClassService storeClassService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IStoreVisitService storeVisitService;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IArticleService articleService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private OrderViewTools orderViewTools;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private MenuTools menuTools;

	@Autowired
	private ISellerAccountService sellerAccountService;

	@Autowired
	private IStoreCountService storeCountService;

	/**
	 * @Title: runstore
	 * @Description: 联盟商家才有开店资格,跳转到引导用户升级页面
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "seller/runstore.htm" })
	public ModelAndView runstore (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/runstore.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// User user = SecurityUserHolder.getCurrentUser();
			// if(user.getLevelAngel() > 1)
			// {
			// return new ModelAndView("redirect:/buyer/buyer_index.htm");
			// }
			LeeConfig leeConfig = LeeConfigurationBuilder.getInstance ().parseConfiguration ();
			BigDecimal v1_amount = leeConfig.getV_three().getAmount ();
			BigDecimal v2_amount = leeConfig.getV_seven().getAmount ();
			mv.addObject ("v1_amount" , v1_amount);
			mv.addObject ("v2_amount" , v2_amount);
			return mv;
		}

	@SecurityMapping(title = "卖家中心首页" , value = "/seller/seller_index.htm*" , rtype = "buyer_seller" , rname = "卖家中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_index.htm" })
	public ModelAndView seller_index (HttpServletRequest request , HttpServletResponse response , String uid , String pid)
		{
			ModelAndView mv = null;
			if (SecurityUserHolder.getCurrentUser () == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (user != null)
			{
				/* 首先判断这个会员是否是申请开铺了 */
				if (user.getStoreId () == null || user.getStoreId ().toString ().equals (""))
				{
//					/* 根据用户等级,跳转到相应的页面,只有联盟商家才有开店资格 */
//					Boolean authOPenShop = LeeUtil.getVipInstance (user.getLevelAngel ()).getBeOpenShop ();
//					if (authOPenShop)
//					{
						mv = new ModelAndView ("redirect:/seller/store_create_first_one.htm");
						return mv;
					}
//					else
//					{
//						mv = new ModelAndView ("redirect:/seller/runstore.htm");
//					}
//				}
				StoreWithBLOBs store = storeService.getByKey (user.getStoreId ());
				/* 不是正常营业时跳转到提示页面 */
				if (store.getStoreStatus () != 2)
				{
					mv = new JModelAndView ("seller/store_create_apply_return.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("user" , user);
					mv.addObject ("store" , storeService.getByKey (user.getStoreId ()));
					mv.addObject ("storeViewTools" , this.storeViewTools);
					return mv;
				}
				mv = new JModelAndView ("seller/seller_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("user" , user);
				mv.addObject ("store" , storeService.getByKey (user.getStoreId ()));
				mv.addObject ("storeViewTools" , this.storeViewTools);
				mv.addObject ("orderViewTools" , this.orderViewTools);
				mv.addObject ("areaViewTools" , this.areaViewTools);
				// 判断当前用户是否是子账号,如果是子账号,则获取权限资源
				SellerAccountExample sellerAccountExample = new SellerAccountExample ();
				sellerAccountExample.createCriteria ().andUserIdEqualTo (user.getId ()).andStatusEqualTo (Globals.NUBER_ONE);
				List <SellerAccount> listSellerAccount = this.sellerAccountService.getObjectList (sellerAccountExample);
				// 如果查询出来size大于0,表示当前登录的账号是子账号
				if (listSellerAccount.size () > 0)
				{
					SellerAccount sellerAccount = listSellerAccount.get (Globals.NUBER_ZERO);
					// 设置权限资源
					mv.addObject ("res" , sellerAccount.getResource ());
				}
				Calendar calendar = Calendar.getInstance ();
				OrderFormExample orderFormExample = new OrderFormExample ();
				orderFormExample.clear ();
				OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				calendar.setTime (new Date ());
				int year = calendar.get (Calendar.YEAR);
				int month = calendar.get (Calendar.MONTH) + 1;
				int day = calendar.get (Calendar.DATE);
				String date1 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 00:00:00";
				SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
				try
				{
					Date d1 = sf.parse (date1);
					orderFormCriteria.andAddtimeGreaterThanOrEqualTo (d1);
					mv.addObject ("curTime1" , date1);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
				String date2 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 23:59:59";
				try
				{
					Date d2 = sf.parse (date2);
					orderFormCriteria.andAddtimeLessThanOrEqualTo (d2);
					mv.addObject ("curTime2" , date2);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
				Integer count1 = this.orderFormService.getObjectListCount (orderFormExample);
				mv.addObject ("count1" , count1);// 今日订单
				orderFormExample.clear ();
				orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				calendar.setTime (new Date ());
				calendar.add (Calendar.DATE , -1);// 昨天
				year = calendar.get (Calendar.YEAR);
				month = calendar.get (Calendar.MONTH) + 1;
				day = calendar.get (Calendar.DATE);
				date1 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 00:00:00";
				try
				{
					Date d1 = sf.parse (date1);
					orderFormCriteria.andAddtimeGreaterThanOrEqualTo (d1);
					mv.addObject ("curTime3" , date1);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
				date2 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 23:59:59";
				try
				{
					Date d2 = sf.parse (date2);
					orderFormCriteria.andAddtimeLessThanOrEqualTo (d2);
					mv.addObject ("curTime4" , date2);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
				Integer count2 = this.orderFormService.getObjectListCount (orderFormExample);
				mv.addObject ("count2" , count2);// 昨日订单
				// 统计上周本周访问量和销量
				StoreCountExample sce = new StoreCountExample ();
				sce.createCriteria ().andStoreIdEqualTo (user.getStoreId ());
				List <StoreCount> scs = storeCountService.getObjectList (sce);
				int lastWeekSale = 0 , lastWeekVisit = 0 , thisWeekSale = 0 , thisWeekVisit = 0;
				if (!scs.isEmpty ())
				{
					lastWeekSale = scs.get (0).getLastWeekSale ();
					lastWeekVisit = scs.get (0).getLastWeekVisit ();
					thisWeekSale = scs.get (0).getThisWeekSale ();
					thisWeekVisit = scs.get (0).getThisWeekVisit ();
				}
				mv.addObject ("lastWeekSale" , lastWeekSale);
				mv.addObject ("lastWeekVisit" , lastWeekVisit);
				mv.addObject ("thisWeekSale" , thisWeekSale);
				mv.addObject ("thisWeekVisit" , thisWeekVisit);
				orderFormExample.clear ();
				orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				orderFormCriteria.andOrderStatusEqualTo (Globals.HAVE_PAYMENT);// 待发货
				Integer count3 = this.orderFormService.getObjectListCount (orderFormExample);
				mv.addObject ("count3" , count3);// 待发货订单
				orderFormExample.clear ();
				orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				orderFormCriteria.andOrderStatusEqualTo(Globals.HAVE_RECEIVED_GOOD);// 待付款，可收款订单
				Integer count4 = this.orderFormService.getObjectListCount (orderFormExample);
				mv.addObject ("count4" , count4);// 可收款订单
				orderFormExample.clear ();
				orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				List <OrderFormWithBLOBs> ofList = this.orderFormService.getObjectList (orderFormExample);
				List <OrderFormWithBLOBs> list = new ArrayList <OrderFormWithBLOBs> ();
				for (OrderFormWithBLOBs of : ofList)
				{
					if (of.getRefundId () != null && !of.getRefundId ().toString ().equals (""))
					{
						list.add (of);
					}
				}
				Integer count5 = list.size ();
				mv.addObject ("count5" , count5);// 退换货订单
				orderFormExample.clear ();
				orderFormCriteria = orderFormExample.createCriteria ();
				orderFormCriteria.andStoreIdEqualTo (user.getStoreId ());
				// orderFormCriteria.andUserIdEqualTo(user.getId());
				orderFormCriteria.andOrderStatusEqualTo (Globals.HAVE_RECEIVED_GOOD);// 评论订单
				List <OrderFormWithBLOBs> orderFormList = this.orderFormService.getObjectList (orderFormExample);
				List <OrderFormWithBLOBs> recommandList = new ArrayList <OrderFormWithBLOBs> ();
				for (OrderFormWithBLOBs of : orderFormList)
				{
					OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
					orderFormItemExample.clear ();
					orderFormItemExample.createCriteria ().andOrderIdEqualTo (of.getId ());
					List <OrderFormItem> orderFormItemList = this.orderFormItemService.getObjectList (orderFormItemExample);
					for (OrderFormItem orderFormItem : orderFormItemList)
					{
						if (orderFormItem.getItemStatus () != null && orderFormItem.getItemStatus () == true)
						{
							recommandList.add (of);
						}
					}
				}
				Integer count6 = recommandList.size ();
				mv.addObject ("count6" , count6);// 评论订单
			}
			else
			{
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
				{
					url = CommUtil.getURL (request);
				}
				url = url + "/seller/seller_index.htm";
				request.getSession (false).setAttribute ("refererUrl" , url);
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	@SecurityMapping(title = "卖家中心导航" , value = "/seller/seller_nav.htm*" , rtype = "buyer" , rname = "卖家中心导航" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_nav.htm" })
	public ModelAndView seller_nav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			int store_status = 0;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				user = userService.getByKey (user.getId ());
				Store store = null;
				if (user != null)
					store = this.storeService.getByKey (user.getStoreId ());
				if (store != null)
				{
					store_status = store.getStoreStatus ();
				}
				String op = CommUtil.null2String (request.getAttribute ("op"));
				if (null != store && store.getPaymentId () != null)
				{
					mv.addObject ("cashDeposit" , store.getPaymentId ());
				}
				// 判断当前用户是否是子账号,如果是子账号,则获取权限资源
				SellerAccountExample sellerAccountExample = new SellerAccountExample ();
				if (null!=user && null != user.getId ())
				{
					sellerAccountExample.createCriteria ().andUserIdEqualTo (user.getId ()).andStatusEqualTo (Globals.NUBER_ONE);
				}
				List <SellerAccount> listSellerAccount = this.sellerAccountService.getObjectList (sellerAccountExample);
				// 如果查询出来size大于0,表示当前登录的账号是子账号
				if (listSellerAccount.size () > 0)
				{
					SellerAccount sellerAccount = listSellerAccount.get (Globals.NUBER_ZERO);
					// 设置权限资源
					mv.addObject ("res" , sellerAccount.getResource ());
				}
				mv.addObject ("op" , op);
				mv.addObject ("store_status" , Integer.valueOf (store_status));
				mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	@RequestMapping({ "/seller/seller_head.htm" })
	public ModelAndView seller_head (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User currentUser = SecurityUserHolder.getCurrentUser ();
			User user = null;
			if (currentUser != null)
				user = this.userService.getByKey (currentUser.getId ());
			String type = CommUtil.null2String (request.getAttribute ("type"));
			mv.addObject ("type" , type.equals ("") ? "goods" : type);
			mv.addObject ("menuTools" , this.menuTools);
			mv.addObject ("user" , user);
			return mv;
		}

	@RequestMapping({ "/seller/seller_footer.htm" })
	public ModelAndView seller_footer (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("footer.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@SecurityMapping(title = "卖家中心快捷功能设置" , value = "/seller/store_quick_menu.htm*" , rtype = "seller" ,
						rname = "用户中心" , rcode = "user_center_seller" , rgroup = "用户中心" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/store_quick_menu.htm" })
	public ModelAndView store_quick_menu (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("user/default/usercenter/store_quick_menu.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@SecurityMapping(title = "卖家中心快捷功能设置保存" , value = "/seller/store_quick_menu_save.htm*" , rtype = "seller" ,
						rname = "用户中心" , rcode = "user_center_seller" , rgroup = "用户中心" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/store_quick_menu_save.htm" })
	public ModelAndView store_quick_menu_save (HttpServletRequest request , HttpServletResponse response , String menus)
		{
			String [ ] menu_navs = menus.split (",");
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			List <Map <String, String>> list = new ArrayList <Map <String, String>> ();
			for (String menu_nav : menu_navs)
			{
				if (!menu_nav.equals (""))
				{
					String [ ] infos = menu_nav.split ("\\|");
					Map <String, String> map = new HashMap <String, String> ();
					map.put ("menu_url" , infos[0]);
					map.put ("menu_name" , infos[1]);
					list.add (map);
				}
			}
			user.setStoreQuickMenu (Json.toJson (list , JsonFormat.compact ()));
			this.userService.updateByObject (user);
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_quick_menu_info.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("user" , user);
			mv.addObject ("menuTools" , this.menuTools);
			return mv;
		}
}
