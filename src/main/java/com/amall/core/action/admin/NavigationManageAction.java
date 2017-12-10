package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.Activity;
import com.amall.core.bean.ActivityExample;
import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.service.INavigationService;
import com.amall.core.service.activity.IActivityService;
import com.amall.core.service.article.IArticleClassService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: _NavigationManageAction
 * </p>
 * <p>
 * Description: 免费兑换页面导航crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午10:39:46
 * @version 1.0
 */
@Controller
public class NavigationManageAction
{
	private Logger log=Logger.getLogger (NavigationManageAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private INavigationService navigationService;

	@Autowired
	private IArticleClassService articleClassService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IActivityService activityService;

	@SecurityMapping(title = "页面导航列表" , value = "/admin/navigation_list.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String title)
		{
			ModelAndView mv = new JModelAndView ("admin/navigation_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			NavigationExample navigationExample = new NavigationExample ();
			navigationExample.clear ();
			navigationExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			navigationExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			NavigationExample.Criteria navigationCriteria = navigationExample.createCriteria ();
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , Navigation.class , mv);
			if (!CommUtil.null2String (title).equals (""))
				navigationCriteria.andTitleLike ("%" + title + "%");
			Pagination pList = navigationService.getObjectListWithPage (navigationExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/navigation_list.htm" , "" , params , pList , mv);
			mv.addObject ("title" , title);
			return mv;
		}

	@SecurityMapping(title = "页面导航添加" , value = "/admin/navigation_add.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/navigation_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			Navigation obj = new Navigation ();
			obj.setDisplay (true);
			obj.setType ("diy");
			obj.setNewWin (1);
			obj.setLocation (0);
			mv.addObject ("obj" , obj);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("gcs" , gcs);
			return mv;
		}

	@SecurityMapping(title = "页面导航编辑" , value = "/admin/navigation_edit.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/navigation_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Navigation navigation = this.navigationService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.createCriteria ().andParentIdIsNull ();
				List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (goodsClassExample);
				/*
				 * .query("select obj from GoodsClass obj where obj.parent.id is null",
				 * null, -1, -1);
				 */
				ArticleClassExample articleClassExample = new ArticleClassExample ();
				articleClassExample.createCriteria ().andParentIdIsNull ();
				articleClassExample.setOrderByClause ("sequence asc");
				List <ArticleClass> acs = this.articleClassService.getObjectList (articleClassExample);
				/*
				 * .query(
				 * "select obj from ArticleClass obj where obj.parent is null order by obj.sequence asc"
				 * ,
				 * null, -1, -1);
				 */
				ActivityExample activityExample = new ActivityExample ();
				activityExample.setOrderByClause ("addTime desc");
				List <Activity> activitys = activityService.getObjectList (activityExample);
				/*
				 * List activitys = this.activityService.query(
				 * "select obj from Activity obj order by obj.addTime desc",
				 * null, -1, -1);
				 */
				mv.addObject ("gcs" , gcs);
				mv.addObject ("acs" , acs);
				mv.addObject ("activitys" , activitys);
				mv.addObject ("obj" , navigation);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "页面导航保存" , value = "/admin/navigation_add.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url , String goodsclass_id)
		{
			WebForm wf = new WebForm ();
			Navigation nav = null;
			if (id.equals (""))
			{
				nav = (Navigation) wf.toPo (request , Navigation.class);
				nav.setAddtime (new Date ());
			}
			else
			{
				Navigation obj = this.navigationService.getByKey (Long.valueOf (Long.parseLong (id)));
				nav = (Navigation) wf.toPo (request , obj);
			}
			nav.setOriginalUrl (nav.getUrl ());
			if (nav.getType ().equals ("goodsclass"))
			{
				nav.setTypeId (CommUtil.null2Long (goodsclass_id));
				nav.setUrl ("store_goods_list_" + goodsclass_id + ".htm");
				nav.setOriginalUrl ("store_goods_list.htm?gc_id=" + goodsclass_id);
			}
			if (id.equals (""))
				this.navigationService.add (nav);
			else
				this.navigationService.updateByObject (nav);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存页面导航成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "页面导航删除" , value = "/admin/navigation_del.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_del.htm" })
	public String delete (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					Navigation navigation = this.navigationService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.navigationService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:navigation_list.htm";
		}

	@SecurityMapping(title = "页面导航AJAX更新" , value = "/admin/navigation_ajax.htm*" , rtype = "admin" , rname = "页面导航" ,
						rcode = "nav_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/navigation_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			Navigation obj = this.navigationService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val=null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (Navigation.class,obj,fieldName,value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());

			}
			this.navigationService.updateByObject (obj);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (val.toString ());
			}
			catch (IOException e)
			{
				log.error (e.getMessage ());
			}
		}
}
