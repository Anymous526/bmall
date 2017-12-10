package com.amall.core.action.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Goods;
//import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Message;
import com.amall.core.bean.MessageExample;
import com.amall.core.bean.MessageExample.Criteria;
import com.amall.core.bean.Store;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IMessageService;
import com.amall.core.service.INavigationService;
import com.amall.core.service.IPartnerService;
import com.amall.core.service.article.IArticleClassService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.delivery.IDeliveryGoodsService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CartGoodsCountTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsFloorViewTools;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.Md5Encrypt;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: IndexViewAction
 * </p>
 * <p>
 * Description: 前台首页入口，首页商品展示、导航、
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28上午11:05:40
 * @version 1.0
 */
@Controller
public class PublicViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IPartnerService partnerService;     // 合作伙伴

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IArticleClassService articleClassService;

	@Autowired
	private IArticleService articleService;      // 活动信息

	@Autowired
	private IAccessoryService accessoryService;  // 图片管理

	@Autowired
	private IMessageService messageService;     // 消息

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private INavigationService navigationService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGoodsFloorService goodsFloorService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IDeliveryGoodsService deliveryGoodsService;

	@Autowired
	private IStoreCartService storeCartService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private GoodsFloorViewTools gf_tools;

	@Autowired
	private CartGoodsCountTools cartGoodsCountTools;

	@RequestMapping({ "/top.htm" })
	public ModelAndView top (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			ModelAndView mv;
			List <Object> msgs = new ArrayList <Object> ();
//			MessageExample messageExample = new MessageExample ();
//			if (SecurityUserHolder.getCurrentUser () != null)
//			{
				/*
				 * messageExample.clear();
				 * Criteria criteria1 = messageExample.createCriteria();
				 * criteria1.andParentIdIsNull()
				 * .andStatusEqualTo(Integer.valueOf(0))
				 * .andTouserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
				 * Criteria criteria2 = messageExample.createCriteria();
				 * criteria2.andReplyStatusEqualTo(Integer.valueOf(1))
				 * .andFromuserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
				 * messageExample.or(criteria2);
				 * msgs = messageService.getObjectList(messageExample);
				 */
				/*
				 * Map params = new HashMap();
				 * params.put("status", Integer.valueOf(0));
				 * params.put("reply_status", Integer.valueOf(1));
				 * params.put("from_user_id", SecurityUserHolder.getCurrentUser()
				 * .getId());
				 * params.put("to_user_id", SecurityUserHolder.getCurrentUser()
				 * .getId());
				 * msgs = this.messageService
				 * .query("select obj from Message obj where obj.parent.id is null "
				 * + "and (obj.status=:status and obj.toUser.id=:to_user_id)"
				 * + " or (obj.reply_status=:reply_status and obj.fromUser.id=:from_user_id) ",
				 * params, -1, -1);
				 */
//			}
			Store store = null;
			User currentUser = SecurityUserHolder.getCurrentUser ();
			if (currentUser != null)
			{
				currentUser = userService.getByKey (currentUser.getId ());
				store = this.storeService.getByKey (currentUser.getStoreId ());
			}
			mv = new JModelAndView ("top.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("user" , currentUser);
			mv.addObject ("store" , store);
			mv.addObject ("navTools" , this.navTools);
			mv.addObject ("msgs" , msgs);
//			String cart_session_id = "";
//			Cookie [ ] cookies = request.getCookies ();
//			if (cookies != null)
//			{
//				for (Cookie cookie : cookies)
//				{
//					if (cookie.getName ().equals ("cart_session_id"))
//					{
//						cart_session_id = CommUtil.null2String (cookie.getValue ());
//					}
//				}
//			}
			String [ ] hotSearches = this.configService.getSysConfig ().getHotsearch ().split (",");
			mv.addObject ("hotSearches" , hotSearches);
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return (ModelAndView) mv;
		}

	@RequestMapping({ "/top2.htm" })
	public ModelAndView top1 (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			ModelAndView mv;
			List<Message> msgs = new ArrayList <Message> ();
			MessageExample messageExample = new MessageExample ();
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				messageExample.clear ();
				Criteria criteria1 = messageExample.createCriteria ();
				criteria1.andParentIdIsNull ().andStatusEqualTo (Integer.valueOf (0)).andTouserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				Criteria criteria2 = messageExample.createCriteria ();
				criteria2.andReplyStatusEqualTo (Integer.valueOf (1)).andFromuserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				messageExample.or (criteria2);
				msgs = messageService.getObjectList (messageExample);
			}
			Store store = null;
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				store = storeService.getByKey (currentUser.getStoreId ());
			}
			mv = new JModelAndView ("top2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("store" , store);
			mv.addObject ("navTools" , this.navTools);
			mv.addObject ("msgs" , msgs);
//			User user = null;
//			if (SecurityUserHolder.getCurrentUser () != null)
//			{
//				user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
//			}
//			String cart_session_id = "";
//			Cookie [ ] cookies = request.getCookies ();
//			if (cookies != null)
//			{
//				for (Cookie cookie : cookies)
//				{
//					if (cookie.getName ().equals ("cart_session_id"))
//					{
//						cart_session_id = CommUtil.null2String (cookie.getValue ());
//					}
//				}
//			}
			String [ ] hotSearches = this.configService.getSysConfig ().getHotsearch ().split (",");
			mv.addObject ("hotSearches" , hotSearches);
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return (ModelAndView) mv;
		}

	@RequestMapping({ "/top3.htm" })
	public ModelAndView top2 (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			ModelAndView mv;
			List <Message> msgs = new ArrayList <Message> ();
			MessageExample messageExample = new MessageExample ();
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				messageExample.clear ();
				Criteria criteria1 = messageExample.createCriteria ();
				criteria1.andParentIdIsNull ().andStatusEqualTo (Integer.valueOf (0)).andTouserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				Criteria criteria2 = messageExample.createCriteria ();
				criteria2.andReplyStatusEqualTo (Integer.valueOf (1)).andFromuserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				messageExample.or (criteria2);
				msgs = messageService.getObjectList (messageExample);
			}
			Store store = null;
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				store = storeService.getByKey (currentUser.getStoreId ());
			}
			mv = new JModelAndView ("top3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("store" , store);
			mv.addObject ("navTools" , this.navTools);
			mv.addObject ("msgs" , msgs);
//			User user = null;
//			if (SecurityUserHolder.getCurrentUser () != null)
//			{
//				user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
//			}
//			String cart_session_id = "";
//			Cookie [ ] cookies = request.getCookies ();
//			if (cookies != null)
//			{
//				for (Cookie cookie : cookies)
//				{
//					if (cookie.getName ().equals ("cart_session_id"))
//					{
//						cart_session_id = CommUtil.null2String (cookie.getValue ());
//					}
//				}
//			}
			String [ ] hotSearches = this.configService.getSysConfig ().getHotsearch ().split (",");
			mv.addObject ("hotSearches" , hotSearches);
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return (ModelAndView) mv;
		}

	/**
	 * 导航
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/nav.htm" })
	public ModelAndView nav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("navTools" , this.navTools);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setPageSize (9);
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDisplayEqualTo (Boolean.valueOf (true));
			Pagination pList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
			
			for (Object oGc : pList.getList ())
			{
				GoodsClassWithBLOBs gc = (GoodsClassWithBLOBs) oGc;
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
				goodsClassExample.setPageSize (this.goodsClassService.getObjectListCount (goodsClassExample));
				goodsClassExample.setOrderByClause ("sequence asc");
				Pagination gcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
				for (Object oc_gc : gcList.getList ())
				{
					GoodsClassWithBLOBs c_gc = (GoodsClassWithBLOBs) oc_gc;
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (c_gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
					goodsClassExample.setPageSize (this.goodsClassService.getObjectListCount (goodsClassExample));
					goodsClassExample.setOrderByClause ("sequence asc");
					Pagination cGcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
					for (Object obj : cGcList.getList ())
					{
						c_gc.getChilds ().add ((GoodsClassWithBLOBs) obj);
					}
				}
				for (Object o : gcList.getList ())
				{
					gc.getChilds ().add ((GoodsClassWithBLOBs) o);
					gc.setIconAcc (this.accessoryService.getByKey (gc.getIconAccId ()));
				}
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 导航1
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/nav1.htm" })
	public ModelAndView nav1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("nav1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("navTools" , this.navTools);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setPageSize (8);
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDisplayEqualTo (Boolean.valueOf (true));
			Pagination pList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
			for (Object oGc : pList.getList ())
			{
				GoodsClassWithBLOBs gc = (GoodsClassWithBLOBs) oGc;
				goodsClassExample.clear ();
				goodsClassExample.setPageSize (5);
				goodsClassExample.setOrderByClause ("sequence asc");
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
				Pagination gcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
				for (Object oc_gc : gcList.getList ())
				{
					GoodsClassWithBLOBs c_gc = (GoodsClassWithBLOBs) oc_gc;
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (c_gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
					goodsClassExample.setPageSize (8);
					goodsClassExample.setOrderByClause ("sequence asc");
					Pagination cGcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
					for (Object obj : cGcList.getList ())
					{
						c_gc.getChilds ().add ((GoodsClassWithBLOBs) obj);
					}
				}
				for (Object o : gcList.getList ())
				{
					gc.getChilds ().add ((GoodsClassWithBLOBs) o);
					gc.setIconAcc (this.accessoryService.getByKey (gc.getIconAccId ()));
				}
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 导航2
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/nav2.htm" })
	public ModelAndView nav2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("nav2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("navTools" , this.navTools);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setPageSize (8);
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDisplayEqualTo (Boolean.valueOf (true));
			Pagination pList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
			for (Object oGc : pList.getList ())
			{
				GoodsClassWithBLOBs gc = (GoodsClassWithBLOBs) oGc;
				goodsClassExample.clear ();
				goodsClassExample.setPageSize (5);
				goodsClassExample.setOrderByClause ("sequence asc");
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
				Pagination gcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
				for (Object oc_gc : gcList.getList ())
				{
					GoodsClassWithBLOBs c_gc = (GoodsClassWithBLOBs) oc_gc;
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (c_gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
					goodsClassExample.setPageSize (8);
					goodsClassExample.setOrderByClause ("sequence asc");
					Pagination cGcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
					for (Object obj : cGcList.getList ())
					{
						c_gc.getChilds ().add ((GoodsClassWithBLOBs) obj);
					}
				}
				for (Object o : gcList.getList ())
				{
					gc.getChilds ().add ((GoodsClassWithBLOBs) o);
					gc.setIconAcc (this.accessoryService.getByKey (gc.getIconAccId ()));
				}
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@RequestMapping({ "/head.htm" })
	public ModelAndView head (HttpServletRequest request , HttpServletResponse response , String keyword)
		{
			ModelAndView mv = new JModelAndView ("head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String type = CommUtil.null2String (request.getAttribute ("type"));
			mv.addObject ("type" , type.equals ("") ? "goods" : type);
			if (keyword != null && !keyword.equals (""))
			{
				mv.addObject ("keyword" , keyword);
			}
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			/* 购物车数量显示 */
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return mv;
		}

	@RequestMapping({ "/head2.htm" })
	public ModelAndView head2 (HttpServletRequest request , HttpServletResponse response , String keyword)
		{
			ModelAndView mv = new JModelAndView ("head2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String type = CommUtil.null2String (request.getAttribute ("type"));
			mv.addObject ("type" , type.equals ("") ? "goods" : type);
			if (keyword != null && !keyword.equals (""))
			{
				mv.addObject ("keyword" , keyword);
			}
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			/* 购物车数量显示 */
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return mv;
		}

	@RequestMapping({ "/login_head.htm" })
	public ModelAndView login_head (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("login_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 公共的页脚
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/footer.htm" })
	public ModelAndView footer (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("footer.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 公共的页脚
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/footer1.htm" })
	public ModelAndView footer1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("footer1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/404.htm" })
	public ModelAndView error404 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("404.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * String view_type = CommUtil.null2String(request.getSession(false)
			 * .getAttribute("amall_view_type"));
			 * if ((view_type != null) && (!view_type.equals(""))
			 * && (view_type.equals("weixin"))) {
			 * String store_id = CommUtil.null2String(request.getSession(false)
			 * .getAttribute("store_id"));
			 * mv = new JModelAndView("weixin/404.html",
			 * this.configService.getSysConfig(),
			 * this.userConfigService.getUserConfig(), 1, request,
			 * response);
			 * mv.addObject("url", CommUtil.getURL(request)
			 * + "/weixin/index.htm?store_id=" + store_id);
			 * }
			 */
			return mv;
		}

	@RequestMapping({ "/500.htm" })
	public ModelAndView error500 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("500.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * String view_type = CommUtil.null2String(request.getSession(false)
			 * .getAttribute("amall_view_type"));
			 * if ((view_type != null) && (!view_type.equals(""))
			 * && (view_type.equals("weixin"))) {
			 * String store_id = CommUtil.null2String(request.getSession(false)
			 * .getAttribute("store_id"));
			 * mv = new JModelAndView("weixin/500.html",
			 * this.configService.getSysConfig(),
			 * this.userConfigService.getUserConfig(), 1, request,
			 * response);
			 * mv.addObject("url", CommUtil.getURL(request)
			 * + "/weixin/index.htm?store_id=" + store_id);
			 * }
			 */
			return mv;
		}

	/**
	 * 商品类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/goods_class.htm" })
	public ModelAndView goods_class (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("goods_class.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andDisplayEqualTo (Boolean.valueOf (true)).andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClassWithBLOBs gc : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (gc.getId ()));
				List <GoodsClassWithBLOBs> gcChilds = this.goodsClassService.getObjectList (goodsClassExample);
				for (GoodsClassWithBLOBs g : gcChilds)
				{
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (g.getId ());
					List <GoodsClassWithBLOBs> gcsChildsChilds = this.goodsClassService.getObjectList (goodsClassExample);
					g.setChilds (gcsChildsChilds);
				}
				gc.setChilds (gcChilds);
			}
			mv.addObject ("gcs" , gcs);
			return mv;
		}

//	private List <Long> genericIds (GoodsClass gc)
//		{
//			List <Long> ids = new ArrayList <Long> ();
//			ids.add (gc.getId ());
//			GoodsClassExample goodsClassExample = new GoodsClassExample ();
//			goodsClassExample.clear ();
//			goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
//			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
//			gc.setChilds (gcs);
//			for (GoodsClass child : gc.getChilds ())
//			{
//				List <Long> cids = genericIds (child);
//				for (Long cid : cids)
//				{
//					ids.add (cid);
//				}
//				ids.add (child.getId ());
//			}
//			return ids;
//		}

	/**
	 * 
	 * <p>
	 * Title: forget
	 * </p>
	 * <p>
	 * Description: 密码找回失败，给用户提示，之后返回首页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/forget.htm" })
	public ModelAndView forget (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("forget.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			SysConfig config = this.configService.getSysConfig ();
			if (!config.getEmailenable ())
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统关闭邮件功能，不能找回密码");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: forget
	 * </p>
	 * <p>
	 * Description: 密码找回失败，给用户提示，之后返回首页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/forget2.htm" })
	public ModelAndView forget2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("forget2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: find_pws
	 * </p>
	 * <p>
	 * Description: 找回密码功能，更具用户输入的用户名和邮箱，如果输入正确将密码发用到用户邮箱， 如果输入不正确则调用forget.htm 给用户提示
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param userName
	 *            用户名称
	 * @param email
	 *            用户email
	 * @param code
	 * @return
	 */
	@RequestMapping({ "/find_pws.htm" })
	public ModelAndView find_pws (HttpServletRequest request , HttpServletResponse response , String userName , String email , String code)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			HttpSession session = request.getSession (false);
			String verify_code = (String) session.getAttribute ("verify_code");
			if (code.toUpperCase ().equals (verify_code))
			{
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo (userName);
				User user = userService.getObjectList (userExample).get (0);
				/* User user = this.userService.getObjByProperty("userName", userName); */
				if (user.getEmail ().equals (email.trim ()))
				{
					String pws = CommUtil.randomString (6).toLowerCase ();
					String subject = this.configService.getSysConfig ().getTitle () + "密码找回邮件";
					String content = user.getUsername () + ",您好！您通过密码找回功能重置密码，新密码为：" + pws;
					boolean ret = this.msgTools.sendEmail (email , subject , content);
					if (ret)
					{
						user.setPassword (Md5Encrypt.md5 (pws));
						this.userService.updateByObject (user);
						mv.addObject ("op_title" , "新密码已经发送到邮箱:<font color=red>" + email + "</font>，请查收后重新登录");
						mv.addObject ("url" , CommUtil.getURL (request) + "/user/login.htm");
					}
					else
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "邮件发送失败，密码暂未执行重置");
						mv.addObject ("url" , CommUtil.getURL (request) + "/forget.htm");
					}
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "用户名、邮箱不匹配");
					mv.addObject ("url" , CommUtil.getURL (request) + "/forget.htm");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "验证码不正确");
				mv.addObject ("url" , CommUtil.getURL (request) + "/forget.htm");
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: switch_recommend_goods
	 * </p>
	 * <p>
	 * Description: 选择推荐商品
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param recommend_goods_random
	 * @return
	 */
	@RequestMapping({ "/switch_recommend_goods.htm" })
	public ModelAndView switch_recommend_goods (HttpServletRequest request , HttpServletResponse response , int recommend_goods_random)
		{
			ModelAndView mv = new JModelAndView ("switch_recommend_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andStoreRecommendEqualTo (Boolean.valueOf (true)).andGoodsStatusEqualTo (Integer.valueOf (0));
			List <GoodsWithBLOBs> store_reommend_goods_list = goodsService.getObjectList (goodsExample);
			/*
			 * Map params = new HashMap();
			 * params.put("store_recommend", Boolean.valueOf(true));
			 * params.put("goods_status", Integer.valueOf(0));
			 * List store_reommend_goods_list = this.goodsService
			 * .query(
			 * "select obj from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.store_recommend_time desc"
			 * ,
			 * params, -1, -1);
			 */
			List <Goods> store_reommend_goods = new ArrayList <Goods> ();
			int begin = recommend_goods_random * 5;
			if (begin > store_reommend_goods_list.size () - 1)
			{
				begin = 0;
			}
			int max = begin + 5;
			if (max > store_reommend_goods_list.size ())
			{
				begin -= max - store_reommend_goods_list.size ();
				max--;
			}
			for (int i = 0 ; i < store_reommend_goods_list.size () ; i++)
			{
				if ((i >= begin) && (i < max))
				{
					store_reommend_goods.add ((Goods) store_reommend_goods_list.get (i));
				}
			}
			mv.addObject ("store_reommend_goods" , store_reommend_goods);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: outline
	 * </p>
	 * <p>
	 * Description: 单点登陆，系统中同一时间只允许同一个用户在线
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return 给用户提示，调用index.htm首页
	 */
	@RequestMapping({ "/outline.htm" })
	public ModelAndView outline (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "该用户在其他地点登录，您被迫下线！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			return mv;
		}
}
