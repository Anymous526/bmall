package com.amall.core.action.view;

import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 店铺和商品收藏
 * 
 * @author
 *
 */
@Controller
public class FavoriteViewAction
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

	/**
	 * 
	 * @todo 用户点击收藏商品到我的收藏
	 * @author xpy
	 * @date 2015年8月7日 下午18:50:37
	 * @return void
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/add_goods_favorite.htm" })
	public void add_goods_favorite (HttpServletResponse response , String id)
		{
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.clear ();
			favoriteExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andGoodsIdEqualTo (Long.valueOf (Long.parseLong (id)));
			List <Favorite> list = this.favoriteService.getObjectList (favoriteExample);
			int ret = 0;
			if (list.size () == 0)
			{
				GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (id));
				Store store = this.storeService.getByKey (CommUtil.null2Long (goods.getGoodsStoreId ()));
				Favorite obj = new Favorite ();
				obj.setAddtime (new Date ());
				obj.setType (0);
				obj.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
				obj.setGoods (goods);
				obj.setGoodsId (Long.valueOf (Long.parseLong (id)));
				obj.setStore (store);
				obj.setStoreId (goods.getGoodsStoreId ());
				this.favoriteService.add (obj);
				goods.setGoodsCollect (goods.getGoodsCollect () + 1);		// 被收藏的商品，商品收藏数加1
				this.goodsService.updateByObject (goods);
			}
			else
			{
				ret = 1;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 店铺收藏
	 * <p>
	 * Title: add_store_favorite
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param response
	 * @param storeId
	 */
	@RequestMapping({ "/add_store_favorite.htm" })
	public void add_store_favorite (HttpServletResponse response , String storeId)
		{
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.clear ();
			favoriteExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStoreIdEqualTo (Long.valueOf (Long.parseLong (storeId)));
			List <Favorite> list = this.favoriteService.getObjectList (favoriteExample);
			Integer returns = 0;
			if (list != null && list.size () != 0)
			{
				returns = 1;
			}
			else
			{
				StoreWithBLOBs store = this.storeService.getByKey (Long.valueOf (storeId));
				Favorite favprote = new Favorite ();
				favprote.setAddtime (new Date ());
				favprote.setType (1);
				favprote.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
				favprote.setStoreId (Long.valueOf (storeId));
				this.favoriteService.add (favprote);
				store.setFavoriteCount (store.getFavoriteCount () + 1);	// 被收藏的店铺，店铺收藏数加1
				this.storeService.updateByObject (store);
				returns = 0;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (returns);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
}
