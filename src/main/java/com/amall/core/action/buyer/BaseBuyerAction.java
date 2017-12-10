package com.amall.core.action.buyer;

import java.math.BigDecimal;
import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
// import com.amall.core.bean.SnsAttention;
// import com.amall.core.bean.SnsFriend;
import com.amall.core.bean.SystemMsgRecordExample;
import com.amall.core.bean.TransportExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IDynamicService;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.IMessageService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.dreampartner.IDreamPartnerService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.home.IHomePageGoodsClassService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.sns.ISnsAttentionService;
import com.amall.core.service.sns.ISnsFriendService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.systemmsgrecord.ISystemMsgRecordService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CartGoodsCountTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.OrderViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.SystemMsgTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : BaseBuyerAction
 *
 * Description : 买家中心
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:43:07
 *
 */
@Controller
public class BaseBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private OrderViewTools orderViewTools;

	@Autowired
	private IDynamicService dynamicService;

	@Autowired
	private ISnsFriendService snsFriendService;

	@Autowired
	private IFavoriteService favService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private ISnsAttentionService SnsAttentionService;

	@Autowired
	private IHomePageGoodsClassService HomeGoodsClassService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IStoreCartService storeCartService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private CartGoodsCountTools cartGoodsCountTools;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private SystemMsgTools sysMsgTools;

	@Autowired
	private IDreamPartnerService dreamPartnerService;

	@Autowired
	private ISystemMsgRecordService recordService;

	/**
	 * @todo 控制权限，跳转到买家中心页面
	 * @author wsw
	 * @date 2015年6月6日 下午6:11:27
	 * @return
	 */
	@SecurityMapping(title = "买家中心" , value = "/buyer/buyer_index.htm*" , rtype = "buyer" , rname = "买家中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_index.htm" })
	public ModelAndView index (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String type)
		{
			ModelAndView mv;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				mv = new JModelAndView ("buyer/buyer_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * @todo 用户中心 头部页面。
	 * @author wsw
	 * @date 2015年6月6日 下午6:12:00
	 */
	@RequestMapping({ "/buyer/buyer_header.htm" })
	public ModelAndView header (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				mv = new JModelAndView ("buyer/buyer_header.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				currentUser = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				mv.addObject ("userid" , currentUser.getId ());
			}
			/* 购物车数量显示 */
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return mv;
		}

	/**
	 * @todo 买家中心 左侧导航条
	 * @author wsw
	 * @date 2015年6月6日 下午6:12:35
	 */
	@RequestMapping({ "/buyer/buyer_left.htm" })
	public ModelAndView left (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_left.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String op = CommUtil.null2String (request.getAttribute ("op"));
			mv.addObject ("op" , op);// ?
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			user = this.userService.getByKey (user.getId ());
			mv.addObject ("userid" , user.getId ());
			// 申请会员的加密链接
			// Map<String, String> map = new HashMap<String, String>();
			// map.put("uname", user.getUsername());
			// String params = EncryptionTools.completeEncrypt(map);
			// mv.addObject("params", params);
			// 会员申请链接
			mv.addObject ("partnerurl_pre" , Globals.partnerurl_pre);
			user = this.userService.getByKey (user.getId ());
			mv.addObject ("user" , user);
			user.setPhoto (this.accessoryService.getByKey (user.getPhotoId ()));
			/* 读取未读系统消息 */
			if (sysMsgTools.isUnreadMsg (user.getId ()))
			{
				mv.addObject ("unread" , true);
			}
			return mv;
		}

	/**
	 * @todo 用户中心 中心主部页面
	 * @author wsw
	 * @date 2015年6月6日 下午6:12:51
	 */
	@RequestMapping({ "/buyer/buyer_center.htm" })
	public ModelAndView center (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_center.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.setOrderByClause ("history_fee desc");
			userExample.setPageSize (10);
			Pagination pList = this.userService.getObjectListWithPage (userExample);
			if (pList.getList () != null && pList.getList ().size () > 0)
			{
				mv.addObject ("pList" , pList.getList ());
			}
			if (user != null)
			{
				user = this.userService.getByKey (user.getId ());
				mv.addObject ("userid" , user.getId ());
				// 申请会员的加密链接
				// Map<String, String> map = new HashMap<String, String>();
				// map.put("uname", user.getUsername());
				// String params = EncryptionTools.completeEncrypt(map);
				// mv.addObject("params", params);
				// 普通会员分享链接
				mv.addObject ("vipshareurl_pre" , Globals.vipshareurl_pre);
				// 会员申请链接
				mv.addObject ("partnerurl_pre" , Globals.partnerurl_pre);
				// 我的物流 我的物流是根据user的id来查找，还是通过商店的 id来查找。 userid在transportion表中不存在。
				OrderFormExample orderFormExample = new OrderFormExample ();
				TransportExample transportExample = new TransportExample ();
				transportExample.clear ();
				user.setPhoto (this.accessoryService.getByKey (user.getPhotoId ()));
				// 待支付订单 用户所有的待支付订单，而每一个订单内都含有多个商品列表。在页面上需要使用双重循环来进行回显
				orderFormExample.clear ();
				orderFormExample.createCriteria ().andOrderStatusEqualTo (Globals.WAIT_PAYMENT_ORDER).andUserIdEqualTo (user.getId ());
				List <OrderFormWithBLOBs> orderFormWithBLOBs = this.orderFormService.getObjectList (orderFormExample);
				for (int i = 0 ; i < orderFormWithBLOBs.size () ; i++)
				{
					CartDetailExample exaple = new CartDetailExample ();
					exaple.clear ();
					if (orderFormWithBLOBs.get (i).getCiId () != null)
					{
						exaple.createCriteria ().andCartIdEqualTo (orderFormWithBLOBs.get (i).getCiId ());
					}
					List <CartDetail> details = this.cartDetailService.getObjectList (exaple);
					List <GoodsWithBLOBs> goodsList = new ArrayList <> ();
					for (CartDetail cd : details)
					{
						goodsList.add (cd.getGoods ());
					}
					Cart cart = new Cart ();
					cart.setGoodslist (goodsList);
					orderFormWithBLOBs.get (i).setCart (cart);
				}
				mv.addObject ("orders" , orderFormWithBLOBs);
				// 待评价订单
				OrderFormExample orderFormExample2 = new OrderFormExample ();
				orderFormExample2.clear ();
				orderFormExample2.createCriteria ().andOrderStatusEqualTo (Integer.valueOf (40)).andUserIdEqualTo (user.getId ());
				List <OrderFormWithBLOBs> orderFormWithBLOBs2 = this.orderFormService.getObjectList (orderFormExample);
				for (int i = 0 ; i < orderFormWithBLOBs2.size () ; i++)
				{
					CartDetailExample exaple = new CartDetailExample ();
					exaple.clear ();
					if (orderFormWithBLOBs.get (i).getCiId () != null)
					{
						exaple.createCriteria ().andCartIdEqualTo (orderFormWithBLOBs.get (i).getCiId ());
					}
					List <CartDetail> details = this.cartDetailService.getObjectList (exaple);
					List <GoodsWithBLOBs> goodsList = new ArrayList <> ();
					for (CartDetail cd : details)
					{
						goodsList.add (cd.getGoods ());
					}
					Cart cart = new Cart ();
					cart.setGoodslist (goodsList);
					orderFormWithBLOBs.get (i).setCart (cart);
				}
				mv.addObject ("receiveOrder" , orderFormWithBLOBs2);
				// 已发货，等待确认收货订单
				orderFormExample.clear ();
				orderFormExample.createCriteria ().andOrderStatusEqualTo (Integer.valueOf (Globals.HAVE_SEND_OUT_GOOD)).andUserIdEqualTo (user.getId ());
				List <OrderFormWithBLOBs> shipOrder = this.orderFormService.getObjectList (orderFormExample);
				for (OrderFormWithBLOBs of : shipOrder)
				{
					OrderFormItemExample orderFormItemExapmle = new OrderFormItemExample ();
					orderFormItemExapmle.clear ();
					orderFormItemExapmle.createCriteria ().andOrderIdEqualTo (of.getId ());
					List <OrderFormItem> orderFormList = this.orderFormItemService.getObjectList (orderFormItemExapmle);
					of.setItems (orderFormList);
				}
				mv.addObject ("shipOrder" , shipOrder);
				// 按收藏查询商品信息
				GoodsExample example = new GoodsExample ();
				example.clear ();
				example.createCriteria ().andGoodsStatusEqualTo (0);
				example.setOrderByClause ("goods_collect desc limit 0,5");
				List <GoodsWithBLOBs> goods = this.goodsService.getObjectList (example);
				mv.addObject ("collectGoods" , goods);
				// 未读消息数量
				SystemMsgRecordExample recordExample = new SystemMsgRecordExample ();
				recordExample.createCriteria ().andReadStatusEqualTo (false).andUserIdEqualTo (user.getId ());
				Integer msgCount = recordService.getObjectListCount (recordExample);
				mv.addObject ("msgCount" , msgCount);
				/**
				 * 查询直接推荐的总数
				 */
				// UserExample userExample = new UserExample();
				userExample.clear ();
				userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
				/* 直接推荐人列表 */
				List <User> listDirectReferUser = userService.getObjectList (userExample);
				Integer directUserCount = listDirectReferUser.size ();
				userExample.clear ();
				/**
				 * 查询间接和三级推荐的总数
				 */
				Integer indirectUserCount = 0;
				Integer superUserCount = 0;
				Integer sumUserCount = 0;
				for (User directRefer : listDirectReferUser)
				{
					userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
					List <User> listIndirectReferUser = userService.getObjectList (userExample);
					Integer indirectTempCount = listIndirectReferUser.size ();
					indirectUserCount = indirectUserCount + indirectTempCount;
					userExample.clear ();
					for (User indirectRefer : listIndirectReferUser)
					{
						userExample.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ());
						Integer superTempCount = userService.getObjectListCount (userExample);
						superUserCount = superUserCount + superTempCount;
						userExample.clear ();
					}
				}
				sumUserCount = directUserCount + indirectUserCount + superUserCount;
				mv.addObject ("directUser" , sumUserCount);
				Integer directShopCount = 0;
				Integer inDirectShopCount = 0;
				Integer superShopCount = 0;
				Integer sumShopCount = 0;
				/**
				 * 查询直接店铺的总数
				 */
				UserExample userExample1 = new UserExample ();
				userExample1.createCriteria ().andDirectReferEqualTo (user.getId ()).andUserroleEqualTo ("BUYER_SELLER");
				/* 直接推荐人列表 */
				List <User> listDirectReferUser1 = userService.getObjectList (userExample1);
				directShopCount = listDirectReferUser1.size ();
				userExample1.clear ();
				/**
				 * 查询间接店铺和三级店铺的总数
				 */
				for (User directRefer : listDirectReferUser1)
				{
					userExample1.createCriteria ().andDirectReferEqualTo (directRefer.getId ()).andUserroleEqualTo ("BUYER_SELLER");
					List <User> listIndirectReferUser1 = userService.getObjectList (userExample1);
					Integer indirectTempCount = listIndirectReferUser1.size ();
					inDirectShopCount = inDirectShopCount + indirectTempCount;
					userExample1.clear ();
					for (User indirectRefer : listIndirectReferUser1)
					{
						userExample1.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ()).andUserroleEqualTo ("BUYER_SELLER");
						Integer superTempCount = userService.getObjectListCount (userExample1);
						superShopCount = superShopCount + superTempCount;
						userExample1.clear ();
					}
				}
				sumShopCount = inDirectShopCount + superShopCount + directShopCount;
				mv.addObject ("directShop" , sumShopCount);
				// 订单查询工具，通过用户id来查询现有的订单状态，在OrderViewTools类里，已经将OrderFormExample
				mv.addObject ("orderViewTools" , this.orderViewTools);
				BigDecimal a = user.getManageMoney () == null ? BigDecimal.ZERO : user.getManageMoney ();
				BigDecimal b = user.getCanCarry () == null ? BigDecimal.ZERO : user.getCanCarry ();
				mv.addObject ("bonus" , a.add (b));
			}
			/* 判断是否是联盟商家，目前规则是只有前100名，1.推广10名高级会员，2.自身是高级会员 */
			// if(user != null && user.getLevelAngel().intValue() == 2)
			// {
			// UserExample example = new UserExample();
			// example.createCriteria().andDirectReferEqualTo(user.getId()).andLevelAngelEqualTo(2);
			//
			// if(userService.getObjectListCount(example) >= 10)
			// {
			// mv.addObject("superUser",true);
			// }
			//
			// }
			return mv;
		}

	// private Set <Long> getSnsAttentionToUserIds (List <SnsAttention> SnsAttentions)
	// {
	// Set ids = new HashSet ();
	// for (SnsAttention attention : SnsAttentions)
	// {
	// ids.add (attention.getTouserId ());
	// }
	// return ids;
	// }
	//
	// private Set <Long> getSnsFriendToUserIds (List <SnsFriend> myfriends)
	// {
	// Set ids = new HashSet ();
	// if (myfriends.size () > 0)
	// {
	// for (SnsFriend friend : myfriends)
	// {
	// ids.add (friend.getTouserId ());
	// }
	// }
	// return ids;
	// }
	@RequestMapping({ "/weichatcode.htm" })
	public ModelAndView weichatcode (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("weichatcode.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
