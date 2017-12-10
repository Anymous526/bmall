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
import com.amall.core.bean.Article;
import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;
import com.amall.core.bean.ArticleExample;
import com.amall.core.service.article.IArticleClassService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ArticleManageAction
{

	private Logger log = Logger.getLogger (ArticleManageAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IArticleService articleService;

	@Autowired
	private IArticleClassService articleClassService;

	@SecurityMapping(title = "文章列表" , value = "/admin/article_list.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/article_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			ArticleExample articleExample = new ArticleExample ();
			articleExample.clear ();
			articleExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			articleExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			/*
			 * ArticleQueryObject qo = new ArticleQueryObject(currentPage, mv,
			 * orderBy, orderType);
			 */
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , Article.class , mv);
			// IPageList pList = this.articleService.list(qo);
			Pagination pList = articleService.getObjectListWithPage (articleExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/article_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "文章添加" , value = "/admin/article_add.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage , String class_id)
		{
			ModelAndView mv = new JModelAndView ("admin/article_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.clear ();
			articleClassExample.createCriteria ().andParentIdIsNull ();
			articleClassExample.setOrderByClause ("sequence asc");
			List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
			/*
			 * List acs = this.articleClassService
			 * .query(
			 * "select obj from ArticleClass obj where obj.parent.id is null order by obj.sequence asc"
			 * ,
			 * null, -1, -1);
			 */
			Article obj = new Article ();
			obj.setDisplay (true);
			if ((class_id != null) && (!class_id.equals ("")))
				obj.setArticleClass (this.articleClassService.getByKey (Long.valueOf (Long.parseLong (class_id))));
			mv.addObject ("obj" , obj);
			mv.addObject ("acs" , acs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "文章编辑" , value = "/admin/article_edit.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/article_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Article article = this.articleService.getByKey (Long.valueOf (Long.parseLong (id)));
				ArticleClassExample articleClassExample = new ArticleClassExample ();
				articleClassExample.clear ();
				articleClassExample.createCriteria ().andParentIdIsNull ();
				articleClassExample.setOrderByClause ("sequence asc");
				List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
				/*
				 * List acs = this.articleClassService
				 * .query(
				 * "select obj from ArticleClass obj where obj.parent.id is null order by obj.sequence asc"
				 * ,
				 * null, -1, -1);
				 */
				mv.addObject ("acs" , acs);
				mv.addObject ("obj" , article);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "文章保存" , value = "/admin/article_save.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url , String class_id , String content)
		{
			WebForm wf = new WebForm ();
			Article article = null;
			if (id.equals (""))
			{
				article = (Article) wf.toPo (request , Article.class);
				article.setAddtime (new Date ());
			}
			else
			{
				Article obj = this.articleService.getByKey (Long.valueOf (Long.parseLong (id)));
				article = (Article) wf.toPo (request , obj);
			}
			article.setArticleClass (this.articleClassService.getByKey (Long.valueOf (Long.parseLong (class_id))));
			if (id.equals (""))
				this.articleService.add (article);
			else
				this.articleService.updateByObject (article);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存文章成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage + "&class_id=" + class_id);
			}
			return mv;
		}

	@SecurityMapping(title = "文章删除" , value = "/admin/article_del.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_del.htm" })
	public String delete (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					// Article article = this.articleService.getByKey (Long.valueOf (Long.parseLong
					// (id)));
					this.articleService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:article_list.htm";
		}

	@SecurityMapping(title = "文章AJAX更新" , value = "/admin/article_ajax.htm*" , rtype = "admin" , rname = "文章管理" ,
						rcode = "article" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/article_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			Article obj = this.articleService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (Article.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，" + e1.getMessage ());
			}
			this.articleService.updateByObject (obj);
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
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/admin/article_mark.htm" })
	public void article_mark (HttpServletRequest request , HttpServletResponse response , String mark , String id)
		{
			ArticleExample articleExample = new ArticleExample ();
			articleExample.clear ();
			articleExample.createCriteria ().andMarkEqualTo (mark.trim ()).andIdEqualTo (CommUtil.null2Long (id));
			List <Article> arts = articleService.getObjectList (articleExample);
			/*
			 * Map params = new HashMap();
			 * params.put("mark", mark.trim());
			 * params.put("id", CommUtil.null2Long(id));
			 * List arts = this.articleService
			 * .query("select obj from Article obj where obj.mark=:mark and obj.id!=:id",
			 * params, -1, -1);
			 */
			boolean ret = true;
			if (arts.size () > 0)
			{
				ret = false;
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
}
