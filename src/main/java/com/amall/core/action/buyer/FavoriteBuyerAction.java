package com.amall.core.action.buyer;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : FavoriteBuyerAction
 *
 * Description : 用户关注
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:44:07
 *
 */
@Controller
@RequestMapping({ "/buyer" })
public class FavoriteBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IFavoriteService favoriteService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IAccessoryService accessoryService;

	/**
	 * 
	 * @todo 用户商品收藏列表
	 * @author wsw
	 * @date 2015年7月15日 上午10:45:20
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "用户商品收藏" , value = "/buyer/buyer_favorite_goods.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer_favorite_goods.htm" })
	public ModelAndView favorite_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_favorite_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.clear ();
			favoriteExample.setPageSize (8);
			favoriteExample.setPageNo (CommUtil.null2Int (currentPage));
			favoriteExample.setOrderByClause ("addTime desc");
			favoriteExample.createCriteria ().andTypeEqualTo (Integer.valueOf (0)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStoreIdIsNotNull ().andGoodsIdIsNotNull ();
			Pagination pList = this.favoriteService.getObjectListWithPage (favoriteExample);
			for (Favorite fav : ((List <Favorite>) (pList.getList ())))
			{
				StoreWithBLOBs store = this.storeService.getByKey (fav.getStoreId ());
				GoodsWithBLOBs goods = this.goodsService.getByKey (fav.getGoodsId ());
				if (store != null)
				{
					store.setStoreLogo (this.accessoryService.getByKey (store.getStoreLogoId ()));
					fav.setStore (store);
				}
				if (goods != null)
				{
					goods.setGoodsMainPhoto (this.accessoryService.getByKey (goods.getGoodsMainPhotoId ()));
					fav.setGoods (goods);
				}
			}
			CommUtil.addIPageList2ModelAndView (url + "/buyer/buyer_favorite_goods.htm" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * @todo 用户收藏店铺列表
	 * @author wsw
	 * @date 2015年7月15日 上午10:45:39
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "用户店铺收藏显示" , value = "/buyer/buyer_favorite_store.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer_favorite_store.htm" })
	public ModelAndView favorite_store (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_favorite_store.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.clear ();
			if (orderBy != null && orderType != null)
			{
				favoriteExample.setOrderByClause (orderBy + " " + orderType);
			}
			favoriteExample.setPageSize (8);
			favoriteExample.setPageNo (CommUtil.null2Int (currentPage));
			favoriteExample.createCriteria ().andTypeEqualTo (Integer.valueOf (1)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStoreIdIsNotNull ().andGoodsIdIsNull ();	// 收藏店铺的时候,并没有收藏商品,所以这里使用store_id不为空,而goodsId为空的条件进行过滤
			Pagination pList = this.favoriteService.getObjectListWithPage (favoriteExample);
			for (Favorite fav : ((List <Favorite>) (pList.getList ())))
			{
				StoreWithBLOBs store = this.storeService.getByKey (fav.getStoreId ());
				// 反向设置store对象进入 对应的 favorite对象中
				if (store != null)
				{
					store.setStoreLogo (this.accessoryService.getByKey (store.getStoreLogoId ()));
					fav.setStore (store);
				}
			}
			CommUtil.addIPageList2ModelAndView (url + "/buyer/buyer_favorite_store.htm" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * @todo 根据传入的favorite的id数组,批量删除用户的收藏
	 * @author wsw
	 * @date 2015年7月15日 上午10:47:10
	 * @return String
	 * @param request
	 * @param response
	 * @param mulitId
	 * @param currentPage
	 * @param type
	 * @return
	 */
	@SecurityMapping(title = "用户收藏删除" , value = "/buyer/buyer_favorite_del.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer_favorite_del.htm" })
	public String favorite_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage , int type)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					Favorite favorite = this.favoriteService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.favoriteService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			if (type == 0)
			{	// type = 0 时 , 为收藏商品 , 所以重定向到收藏商品页面
				return "redirect:buyer_favorite_goods.htm?currentPage=" + currentPage;
			}
			// type != 0 为收藏的店铺页面 , 重定向到店铺收藏页面
			return "redirect:buyer_favorite_store.htm?currentPage=" + currentPage;
		}

	/**
	 * 
	 * @todo 收藏的商品的搜索
	 * @author wsw
	 * @date 2015年7月15日 上午10:59:38
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param searchContent
	 * @return
	 */
	@RequestMapping({ "/buyer_favorite_goodsSearch.htm" })
	public ModelAndView favorite_search (HttpServletRequest request , HttpServletResponse response , String currentPage , String searchContent)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_favorite_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.setOrderByClause ("addTime desc");
			favoriteExample.setPageNo (CommUtil.null2Int (currentPage));
			favoriteExample.setPageSize (8);
			favoriteExample.clear ();
			FavoriteExample.Criteria fCriteria = favoriteExample.createCriteria ();
			fCriteria.andTypeEqualTo (Integer.valueOf (0));
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsNameLike ("%" + searchContent + "%");
			List <GoodsWithBLOBs> goodsWithBLOBs = this.goodsService.getObjectList (goodsExample);
			for (GoodsWithBLOBs g : goodsWithBLOBs)
			{
				fCriteria.andGoodsIdEqualTo (g.getId ());
			}
			Pagination pList = this.favoriteService.getObjectListWithPage (favoriteExample);
			CommUtil.addIPageList2ModelAndView (url + "/buyer/buyer_favorite_goods.htm" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * @todo 收藏的店铺搜索
	 * @author wsw
	 * @date 2015年7月15日 上午10:59:51
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param searchContent
	 * @return
	 */
	@RequestMapping({ "/buyer_favorite_storeSearch.htm" })
	public ModelAndView favorite_storeSearch (HttpServletRequest request , HttpServletResponse response , String currentPage , String searchContent)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_favorite_store.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.setOrderByClause ("addTime desc");
			favoriteExample.setPageNo (CommUtil.null2Int (currentPage));
			favoriteExample.setPageSize (8);
			favoriteExample.clear ();
			FavoriteExample.Criteria fCriteria = favoriteExample.createCriteria ();
			fCriteria.andTypeEqualTo (Integer.valueOf (1));
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andStoreNameLike ("%" + searchContent + "%");
			List <StoreWithBLOBs> storeWithBLOBs = this.storeService.getObjectList (storeExample);
			for (StoreWithBLOBs s : storeWithBLOBs)
			{
				fCriteria.andStoreIdEqualTo (s.getId ());
			}
			Pagination pList = this.favoriteService.getObjectListWithPage (favoriteExample);
			CommUtil.addIPageList2ModelAndView (url + "/buyer/buyer_favorite_store.htm" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * @todo 用户添加收藏店铺 , 通过异步ajax返回字符串.
	 * @author wsw
	 * @date 2015年6月23日 下午2:19:11
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param store_id
	 * @return
	 */
	@RequestMapping({ "/buyer_favorite_store_add" })
	@ResponseBody
	public String buyer_favorite_store_add (HttpServletRequest request , HttpServletResponse response , String store_id)
		{
			String result = "";
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return "notLogin";	// 用户未登录
			}
			if (store_id != null && !store_id.equals (""))
			{
				// 当前用户已经登录
				FavoriteExample favoriteExample = new FavoriteExample ();
				favoriteExample.clear ();
				// 收藏了店铺,但是不一定会收藏商品
				favoriteExample.createCriteria ().andUserIdEqualTo (user.getId ()).andStoreIdEqualTo (CommUtil.null2Long (store_id)).andGoodsIdIsNull ();
				List <Favorite> favorites = this.favoriteService.getObjectList (favoriteExample);
				if (favorites != null && favorites.size () > 0)
				{
					// 用户已经收藏了该店铺
					return "already";
				}
				StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (store_id));
				if (store.getUserId ().equals (user.getId ()))
				{
					result = "owner";	// 该用户为店主 , 返回owner到前台,提示无法收藏自己店铺
				}
				Favorite fav = new Favorite ();
				fav.setAddtime (new Date ());
				fav.setStore (this.storeService.getByKey (CommUtil.null2Long (store_id)));
				fav.setStoreId (CommUtil.null2Long (store_id));
				fav.setUserId (user.getId ());
				fav.setType (Integer.valueOf (1));
				this.favoriteService.add (fav);
				result = "success";
			}
			return result;
		}

	/**
	 * 
	 * @todo 用户添加收藏商品 , 通过异步ajax返回字符串. 暂时未用
	 * @author wsw
	 * @date 2015年6月23日 下午2:19:11
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param store_id
	 * @return
	 */
	@RequestMapping({ "/buyer_favorite_goods_add" })
	@ResponseBody
	public String buyer_favorite_goods_add (HttpServletRequest request , HttpServletResponse response , String goods_id)
		{
			String result = "";
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return "notLogin";	// 用户未登录
			}
			if (goods_id != null && !goods_id.equals (""))
			{
				// 当前用户已经登录
				FavoriteExample favoriteExample = new FavoriteExample ();
				favoriteExample.clear ();
				// 收藏商品,会顺带将店铺也进行收藏
				favoriteExample.createCriteria ().andUserIdEqualTo (user.getId ()).andGoodsIdEqualTo (CommUtil.null2Long (goods_id));
				List <Favorite> favorites = this.favoriteService.getObjectList (favoriteExample);
				if (favorites != null && favorites.size () > 0)
				{
					// 用户已经收藏了该商品
					return "already";
				}
				StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (goods_id));
				if (store.getUserId ().equals (user.getId ()))
				{
					result = "owner";
				}
				Favorite fav = new Favorite ();
				fav.setAddtime (new Date ());
				fav.setStore (this.storeService.getByKey (this.goodsService.getByKey (CommUtil.null2Long (goods_id)).getGoodsStoreId ()));
				fav.setStoreId (fav.getStore ().getId ());
				fav.setGoodsId (CommUtil.null2Long (goods_id));
				fav.setGoods (this.goodsService.getByKey (CommUtil.null2Long (goods_id)));
				fav.setUserId (user.getId ());
				fav.setType (Integer.valueOf (0));
				this.favoriteService.add (fav);
				result = "success";
			}
			return result;
		}
}
