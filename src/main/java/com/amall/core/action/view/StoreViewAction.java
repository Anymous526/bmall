package com.amall.core.action.view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.EasemobUser;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;
import com.amall.core.bean.StoreSlide;
import com.amall.core.bean.StoreSlideExample;
import com.amall.core.bean.StoreVisit;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEasemobUserService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreNavigationService;
import com.amall.core.service.store.IStorePartnerService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.IStoreSlideService;
import com.amall.core.service.storevisit.IStoreVisitService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreViewAction
 * </p>
 * <p>
 * Description: 店铺显示
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年7月1日下午3:12:54
 * @version 1.0
 */
@Controller
public class StoreViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IStoreVisitService storeVisitService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IStoreNavigationService storenavigationService;

	@Autowired
	private IStorePartnerService storepartnerService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IOrderFormService ofService;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IStoreSlideService storeSlideService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IFavoriteService favoriteService;

	@Autowired
	private IEasemobUserService easmobUserService;

	/**
	 * <p>
	 * Title: store
	 * </p>
	 * <p>
	 * Description: 品牌店铺商品主页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/store.htm" })
	public ModelAndView store (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			String serverName = request.getServerName ().toLowerCase ();
			User user = SecurityUserHolder.getCurrentUser ();
			StoreWithBLOBs store = null;
			if (id == null && (serverName.indexOf (".") >= 0) && (serverName.indexOf (".") != serverName.lastIndexOf (".")) && (this.configService.getSysConfig ().getSecondDomainOpen ()))
			{
				String secondDomain = serverName.substring (0 , serverName.indexOf ("."));
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
				storeCriteria.andStoreSecondDomainEqualTo (secondDomain);
				store = this.storeService.getObjectList (storeExample).get (0);
			}
			else
			{
				store = this.storeService.getByKey (CommUtil.null2Long (id));
			}
			if (store == null)
			{
				ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "不存在该店铺信息");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				return mv;
			}
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (store.getStoreStatus () == 2)
			{
				add_store_common_info (mv , store);
				mv.addObject ("store" , store);
				mv.addObject ("nav_id" , "store_index");
				// 添加店铺访问记录
				StoreVisit storeVisit = new StoreVisit ();
				storeVisit.setVisitTime (new Date ());
				storeVisit.setStoreId (store.getId ());
				storeVisit.setUserIp (CommUtil.getIpAddr (request));
				if (user != null)
				{
					storeVisit.setUserId (user.getId ());
				}
				this.storeVisitService.add (storeVisit);
			}
			else if (store.getStoreStatus () == 3)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "店铺因违规而被关闭，违规原因：" + store.getViolationReseaon ());
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			else if (store.getStoreStatus () == -1)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "店铺开通申请被拒绝，拒绝原因：" + store.getRefuseReason ());
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "店铺尚未开通");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			generic_evaluate (store , mv);
			return mv;
		}

	@RequestMapping({ "/store_all_goods.htm" })
	public ModelAndView store_all_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String id , String storeNavId , String order)
		{
			String serverName = request.getServerName ().toLowerCase ();
			StoreWithBLOBs store = null;
			if (id == null && (serverName.indexOf (".") >= 0) && (serverName.indexOf (".") != serverName.lastIndexOf (".")) && (this.configService.getSysConfig ().getSecondDomainOpen ()))
			{
				String secondDomain = serverName.substring (0 , serverName.indexOf ("."));
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andStoreSecondDomainEqualTo (secondDomain);
				store = this.storeService.getObjectList (storeExample).get (0);
			}
			else
			{
				store = this.storeService.getByKey (CommUtil.null2Long (id));
			}
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_all_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// add_store_common_info(mv, store);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setPageSize (9);
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			if ("".equals (CommUtil.null2String (order)))
			{ // 判断是否为null
				goodsExample.setOrderByClause ("addTime desc");
			}
			else if (CommUtil.null2String (order).equals ("sele"))
			{
				goodsExample.setOrderByClause ("goods_salenum desc");
			}
			if (storeNavId == null || "".equals (storeNavId))
			{
			}
			else
			{
				goodsCriteria.andStoreNavIdEqualTo (Long.parseLong (storeNavId));
			}
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			String url1 = CommUtil.getURL (request);
			Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
			String params = "&id=" + id + "&order=" + order;
			CommUtil.addIPageList2ModelAndView (url1 + "/store_all_goods.htm" , "" , params , pList , mv);
			mv.addObject ("store" , store);
			mv.addObject ("storeNavId" , storeNavId);
			return mv;
		}

	@RequestMapping({ "/store_nav_goods.htm" })
	public ModelAndView store_nav_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String id , String storeNavId)
		{
			String serverName = request.getServerName ().toLowerCase ();
			StoreWithBLOBs store = null;
			if (id == null && (serverName.indexOf (".") >= 0) && (serverName.indexOf (".") != serverName.lastIndexOf (".")) && (this.configService.getSysConfig ().getSecondDomainOpen ()))
			{
				String secondDomain = serverName.substring (0 , serverName.indexOf ("."));
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
				storeCriteria.andStoreSecondDomainEqualTo (secondDomain);
				store = this.storeService.getObjectList (storeExample).get (0);
			}
			else
			{
				store = this.storeService.getByKey (CommUtil.null2Long (id));
			}
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_nav_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("addTime desc");
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setPageSize (9);
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			if (storeNavId == null || "".equals (storeNavId))
			{
			}
			else
			{
				goodsCriteria.andStoreNavIdEqualTo (Long.parseLong (storeNavId));
			}
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			String url1 = CommUtil.getURL (request);
			Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
			String parms = "&id=" + id + "&storeNavId=" + storeNavId;
			CommUtil.addIPageList2ModelAndView (url1 + "/store_nav_goods.htm" , "" , parms , pList , mv);
			mv.addObject ("store" , store);
			mv.addObject ("storeNavId" , storeNavId);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: brandshop_left
	 * </p>
	 * <p>
	 * Description: 品牌店铺主页左菜单
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/store_left.htm" })
	public ModelAndView store_left (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (request.getAttribute ("id")));
			String template = "default";
			if ((store != null) && (store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			mv = new JModelAndView (template + "/store_left.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("goods_salenum desc");
			if (null != store && null != store.getId ())
			{
				goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ()).andGoodsStatusEqualTo (Integer.valueOf (0)).andDeletestatusEqualTo (false);
			}
			List <GoodsWithBLOBs> goodsSaleList = this.goodsService.getObjectList (goodsExample);
			mv.addObject ("goodsSaleList" , goodsSaleList);
			mv.addObject ("store" , store);
			mv.addObject ("goodsViewTools" , this.goodsViewTools);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: brandshop_menu
	 * </p>
	 * <p>
	 * Description: 品牌店铺菜单
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/store_banner.htm" })
	public ModelAndView store_banner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (request.getAttribute ("id")));
			/*
			 * String template = "default"; if ((store != null) &&
			 * (store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
			 * template = store.getTemplate(); }
			 */
			StoreSlideExample storeSlideExample = new StoreSlideExample ();
			storeSlideExample.clear ();
			storeSlideExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			List <StoreSlide> storeSlides = storeSlideService.getObjectList (storeSlideExample);
			store.setSlides (storeSlides);
			mv = new JModelAndView ("default/store_banner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("store" , store);
			return mv;
		}

	@RequestMapping({ "/store_nav.htm" })
	public ModelAndView store_nav (HttpServletRequest request , HttpServletResponse response)
		{
			Long id = CommUtil.null2Long (request.getAttribute ("id"));
			Store store = this.storeService.getByKey (id);
			String template = "default";
			if ((store.getTemplate () != null) && (!"".equals (store.getTemplate ())))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (store.getStoreStatus () == 2)
			{
				StoreNavigationExample storeNavigationExample = new StoreNavigationExample ();
				storeNavigationExample.clear ();
				storeNavigationExample.setOrderByClause ("sequence asc");
				storeNavigationExample.createCriteria ().andStoreIdEqualTo (store.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
				List <StoreNavigation> navs = storenavigationService.getObjectList (storeNavigationExample);
				mv.addObject ("navs" , navs);
				mv.addObject ("store" , store);
				String goods_view = CommUtil.null2String (request.getAttribute ("goods_view"));
				mv.addObject ("goods_view" , Boolean.valueOf (CommUtil.null2Boolean (goods_view)));
				mv.addObject ("goods_id" , CommUtil.null2String (request.getAttribute ("goods_id")));
				mv.addObject ("goods_list" , Boolean.valueOf (CommUtil.null2Boolean (request.getAttribute ("goods_list"))));
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "店铺信息错误");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			return mv;
		}

	@RequestMapping({ "/store_credit.htm" })
	public ModelAndView store_credit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			Store store = this.storeService.getByKey (CommUtil.null2Long (id));
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_credit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (store.getStoreStatus () == 2)
			{
				OrderFormExample ofExample = new OrderFormExample ();
				ofExample.clear ();
				ofExample.createCriteria ().andStoreIdEqualTo (store.getId ());
				OrderFormWithBLOBs of = ofService.getObjectList (ofExample).get (0);
				EvaluateExample evaluateExample = new EvaluateExample ();
				evaluateExample.clear ();
				evaluateExample.setPageNo (Integer.valueOf (1));
				evaluateExample.setOrderByClause ("addTime desc");
				evaluateExample.createCriteria ().andOfIdEqualTo (of.getId ());
				Pagination pList = evaluateService.getObjectListWithPage (evaluateExample);
				CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/store_eva.htm" , "" , "" , pList , mv);
				mv.addObject ("store" , store);
				mv.addObject ("nav_id" , "store_credit");
				mv.addObject ("storeViewTools" , this.storeViewTools);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "店铺信息错误");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			return mv;
		}

	@RequestMapping({ "/store_url.htm" })
	public ModelAndView store_url (HttpServletRequest request , HttpServletResponse response , String id)
		{
			StoreNavigation nav = this.storenavigationService.getByKey (CommUtil.null2Long (id));
			String template = "default";
			if ((nav.getStore ().getTemplate () != null) && (!nav.getStore ().getTemplate ().equals ("")))
			{
				template = nav.getStore ().getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_url.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("store" , nav.getStore ());
			mv.addObject ("nav" , nav);
			mv.addObject ("nav_id" , nav.getId ());
			return mv;
		}

	private void add_store_common_info (ModelAndView mv , Store store)
		{
			UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
			userGoodsClassExample.clear ();
			userGoodsClassExample.setOrderByClause ("sequence asc");
			userGoodsClassExample.createCriteria ().andUserIdEqualTo (store.getUserId ()).andDisplayEqualTo (Boolean.valueOf (true)).andParentIdIsNull ();
			List <UserGoodsClass> ugcs = userGoodsClassService.getObjectList (userGoodsClassExample);
			if (null != ugcs && ugcs.size () > 0)
			{
				mv.addObject ("ugcs" , ugcs);
			}
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("addTime desc");
			goodsExample.createCriteria ().andGoodsRecommendEqualTo (Boolean.valueOf (true)).andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			// goodsExample.setStartRow(0);
			// goodsExample.setPageSize(5);
			List <GoodsWithBLOBs> goods_recommend = this.goodsService.getObjectList (goodsExample);
			if (null != goods_recommend && goods_recommend.size () > 0)
			{
				mv.addObject ("goods_recommend1" , goods_recommend.get (0));
				mv.addObject ("goods_recommend" , goods_recommend);
			}
			goodsExample.clear ();
			goodsExample.setOrderByClause ("addTime desc");
			goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ()).andGoodsStatusEqualTo (Integer.valueOf (0)).andDeletestatusEqualTo (false);
			// goodsExample.setStartRow(0);
			// goodsExample.setPageSize(5);
			List <GoodsWithBLOBs> goods_new = this.goodsService.getObjectList (goodsExample);
			if (null != goods_new && goods_new.size () > 0)
			{
				mv.addObject ("goods_new1" , goods_new.get (0));
				mv.addObject ("goods_new" , goods_new);
			}
			mv.addObject ("goodsViewTools" , this.goodsViewTools);
			mv.addObject ("storeViewTools" , this.storeViewTools);
			mv.addObject ("areaViewTools" , this.areaViewTools);
		}

	/**
	 * 
	 * <p>
	 * Title: store_list
	 * </p>
	 * <p>
	 * Description:品牌店铺商品列表
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/store_list.htm" })
	public ModelAndView store_list (HttpServletRequest request , HttpServletResponse response , String id , String sc_id , String currentPage , String orderType , String store_name , String store_ower , String type)
		{
			StoreWithBLOBs store = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: store_goods_search
	 * </p>
	 * <p>
	 * Description: 店铺商品查询
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param keyword
	 * @param store_id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/store_goods_search.htm" })
	public ModelAndView store_goods_search (HttpServletRequest request , HttpServletResponse response , String keyword , String store_id , String currentPage , String priceStart , String priceEnd)
		{
			StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (store_id));
			String template = "default";
			if ((store.getTemplate () != null) && (!store.getTemplate ().equals ("")))
			{
				template = store.getTemplate ();
			}
			ModelAndView mv = new JModelAndView (template + "/store_all_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setPageSize (Integer.valueOf (12));
			goodsExample.setOrderByClause ("addTime desc");
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsCriteria.andGoodsStoreIdEqualTo (CommUtil.null2Long (store_id)).andGoodsStatusEqualTo (Integer.valueOf (0)).andDeletestatusEqualTo (false);
			if (null != keyword && !keyword.equals (""))
			{
				goodsCriteria.andGoodsNameLike ("%" + CommUtil.decode (keyword) + "%");
			}
			if (null != priceStart && !priceStart.equals (""))
			{
				goodsCriteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (priceStart)));
			}
			if (null != priceEnd && !priceEnd.equals (""))
			{
				goodsCriteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (priceEnd)));
			}
			Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
			// String params = "&store_id="+store_id+"&keyword="+keyword;
			String url = CommUtil.getURL (request);
			CommUtil.addIPageList2ModelAndView (url + "/store_goods_search.htm" , "" , "" , pList , mv);
			mv.addObject ("keyword" , keyword);
			mv.addObject ("store" , store);
			mv.addObject ("priceStart" , priceStart);
			mv.addObject ("priceEnd" , priceEnd);
			mv.addObject ("store" , store);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: brandshop_head
	 * </p>
	 * <p>
	 * Description: 品牌店head部分
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/store_head.htm" })
	public ModelAndView store_head (HttpServletRequest request , HttpServletResponse response , String id)
		{
			StoreWithBLOBs store = null;
			if (id == null)
			{
				store = this.storeService.getByKey (CommUtil.null2Long (request.getAttribute ("id")));
			}
			else
			{
				store = this.storeService.getByKey (CommUtil.null2Long (request.getAttribute ("id")));
			}
			ModelAndView mv = new JModelAndView ("default/store_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User currentUser = SecurityUserHolder.getCurrentUser ();
			User user = null;
			if (currentUser != null)
			{
				user = this.userService.getByKey (currentUser.getId ());
			}
			generic_evaluate (store , mv);
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.clear ();
			favoriteExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			Integer favoriteCount = favoriteService.getObjectListCount (favoriteExample);
			mv.addObject ("favoriteCount" , favoriteCount);
			mv.addObject ("store" , store);
			mv.addObject ("user" , user);
			return mv;
		}

	private void generic_evaluate (StoreWithBLOBs store , ModelAndView mv)
		{
			double description_result = 0.0D;
			double service_result = 0.0D;
			double ship_result = 0.0D;
			if ((store != null) && (store.getSc () != null) && (store.getPoint () != null))
			{
				StoreClass sc = this.storeClassService.getByKey (store.getSc ().getId ());
				float description_evaluate = CommUtil.null2Float (sc.getDescriptionEvaluate ());
				float service_evaluate = CommUtil.null2Float (sc.getServiceEvaluate ());
				float ship_evaluate = CommUtil.null2Float (sc.getShipEvaluate ());
				float store_description_evaluate = CommUtil.null2Float (store.getPoint ().getDescriptionEvaluate ());
				float store_service_evaluate = CommUtil.null2Float (store.getPoint ().getServiceEvaluate ());
				float store_ship_evaluate = CommUtil.null2Float (store.getPoint ().getShipEvaluate ());
				description_result = CommUtil.div (Float.valueOf (store_description_evaluate - description_evaluate) , Float.valueOf (description_evaluate));
				service_result = CommUtil.div (Float.valueOf (store_service_evaluate - service_evaluate) , Float.valueOf (service_evaluate));
				ship_result = CommUtil.div (Float.valueOf (store_ship_evaluate - ship_evaluate) , Float.valueOf (ship_evaluate));
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

	/**
	 * 咨询店家
	 * 
	 * @param request
	 * @param response
	 * @param storeId
	 * @param goodsId
	 * @return
	 */
	@RequestMapping({ "/store/shopConsultation.htm" })
	public ModelAndView shopConsultation (HttpServletRequest request , HttpServletResponse response , String storeUserId , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("im/advisory.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 游客功能在此开发
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			if (StringUtils.isEmpty (storeUserId))
			{
				return new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			GoodsWithBLOBs gw = goodsService.getByKey (Long.parseLong (goodsId));
			if (null == gw)
			{
				return null;
			}
			EasemobUser currentEUser = easmobUserService.getUser (user.getId ());
			EasemobUser storeUser = easmobUserService.getUser (Long.parseLong (storeUserId));
			mv.addObject ("goods" , gw);
			mv.addObject ("storeUserId" , storeUser.getusername ());
			mv.addObject ("obj" , currentEUser);
			return mv;
		}
}
