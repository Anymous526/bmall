package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.ArticleExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.lucene.LuceneThread;
import com.amall.core.lucene.LuceneVo;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: _LuceneManageAction
 * </p>
 * <p>
 * Description: 全文检索cru 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午10:40:36
 * @version 1.0
 */
@Controller
public class LuceneManageAction
{
	private Logger  log=Logger.getLogger (LuceneManageAction.class);
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IArticleService articleService;

	@SecurityMapping(title = "全文检索设置" , value = "/admin/lucene.htm*" , rtype = "admin" , rname = "全文检索" ,
						rcode = "luence_manage" , rgroup = "工具" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/lucene.htm" })
	public ModelAndView lucene (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/lucene.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String path = System.getProperty ("user.dir") + File.separator + "luence";
			File file = new File (path);
			if (!file.exists ())
			{
				CommUtil.createFolder (path);
			}
			mv.addObject ("lucene_disk_size" , Double.valueOf (CommUtil.fileSize (file)));
			mv.addObject ("lucene_disk_path" , path);
			return mv;
		}

	@SecurityMapping(title = "全文检索关键字保存" , value = "/admin/lucene_hot_save.htm*" , rtype = "admin" , rname = "全文检索" ,
						rcode = "luence_manage" , rgroup = "工具" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/lucene_hot_save.htm" })
	@ResponseBody
	public void lucene_hot_add (HttpServletRequest request , HttpServletResponse response , String id , String hotSearch)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			boolean ret = false;
			if (id.equals (""))
			{
				obj.setHotsearch (hotSearch);
				obj.setAddtime (new Date ());
				this.configService.add (obj);
				ret = true;
			}
			else
			{
				obj.setHotsearch (hotSearch);
				this.configService.updateByObject (obj);
				ret = true;
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
				log.error (e.getMessage ());
			}
		}

	@SecurityMapping(title = "全文检索更新" , value = "/admin/lucene_update.htm*" , rtype = "admin" , rname = "全文检索" ,
						rcode = "luence_manage" , rgroup = "工具" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/lucene_update.htm" })
	public void lucene_update (HttpServletRequest request , HttpServletResponse response , String id , String hotSearch)
		{
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			List <GoodsWithBLOBs> goods_list = goodsService.getObjectList (goodsExample);
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andStoreStatusEqualTo (Integer.valueOf (2));
			List <StoreWithBLOBs> store_list = storeService.getObjectList (storeExample);
			/*
			 * params.clear();
			 * params.put("store_status", Integer.valueOf(2));
			 * List<Store> store_list = this.storeService
			 * .query("select obj from Store obj where obj.store_status=:store_status",
			 * params, -1, -1);
			 */
			/*
			 * params.clear();
			 * params.put("display", Boolean.valueOf(true));
			 * List article_list = this.articleService.query(
			 * "select obj from Article obj where obj.display=:display",
			 * params, -1, -1);
			 */
			ArticleExample articleExample = new ArticleExample ();
			articleExample.clear ();
			articleExample.createCriteria ().andDisplayEqualTo (Boolean.valueOf (true));
//			List <Article> article_list = articleService.getObjectList (articleExample);
			String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
			String store_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "store";
			File file = new File (goods_lucene_path);
			if (!file.exists ())
			{
				CommUtil.createFolder (goods_lucene_path);
			}
			file = new File (store_lucene_path);
			if (!file.exists ())
			{
				CommUtil.createFolder (store_lucene_path);
			}
			List <LuceneVo> goods_vo_list = new ArrayList <LuceneVo> ();
			for (GoodsWithBLOBs goods : goods_list)
			{
				LuceneVo vo = new LuceneVo ();
				vo.setVo_id (goods.getId ());
				vo.setVo_title (goods.getGoodsName ());
				vo.setVo_content (goods.getGoodsDetails ());
				vo.setVo_type ("goods");
				vo.setVo_store_price (CommUtil.null2Double (goods.getStorePrice ()));
				vo.setVo_add_time (goods.getAddtime ().getTime ());
				vo.setVo_goods_salenum (goods.getGoodsSalenum ());
				goods_vo_list.add (vo);
			}
			List <LuceneVo> store_vo_list = new ArrayList <LuceneVo> ();
			for (StoreWithBLOBs store : store_list)
			{
				LuceneVo vo = new LuceneVo ();
				vo.setVo_id (store.getId ());
				vo.setVo_title (store.getStoreName ());
				vo.setVo_content (store.getStoreAddress () + store.getStoreSeoDescription () + store.getStoreSeoKeywords () + store.getStoreInfo ());
				store_vo_list.add (vo);
			}
			LuceneThread goods_thread = new LuceneThread (goods_lucene_path , goods_vo_list);
			LuceneThread store_thread = new LuceneThread (store_lucene_path , goods_vo_list);
			Date d1 = new Date ();
			goods_thread.run ();
			store_thread.run ();
			Date d2 = new Date ();
			String path = System.getProperty ("user.dir") + File.separator + "luence";
			Map <String, Object> map = new HashMap <String, Object> ();
			map.put ("run_time" , Long.valueOf (d2.getTime () - d1.getTime ()));
			map.put ("file_size" , Double.valueOf (CommUtil.fileSize (new File (path))));
			map.put ("update_time" , CommUtil.formatLongDate (new Date ()));
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			config.setLuceneUpdate (new Date ());
			this.configService.updateByObject (config);
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
				log.error (e.getMessage ());
			}
		}
}
