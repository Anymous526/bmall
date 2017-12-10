package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;
import com.amall.core.service.article.IArticleClassService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: ArticleClassManageAction
 * </p>
 * <p>
 * Description: 文章分类crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年7月9日下午2:52:10
 * @version 1.0
 */
@Controller
public class ArticleClassManageAction
{

	private Logger log=Logger.getLogger (ArticleClassManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IArticleClassService articleClassService;

	@SecurityMapping(title = "文章分类列表" , value = "/admin/articleclass_list.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/articleclass_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.clear ();
			articleClassExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			articleClassExample.setPageSize (5);
			articleClassExample.setOrderByClause ("sequence asc");
			articleClassExample.createCriteria ().andParentIdIsNull ();
			Pagination pList = articleClassService.getObjectListWithPage (articleClassExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "文章分类添加" , value = "/admin/articleclass_add.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/articleclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.clear ();
			articleClassExample.createCriteria ().andParentIdIsNull ();
			articleClassExample.setOrderByClause ("sequence asc");
			List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
			if ((pid != null) && (!pid.equals ("")))
			{
				ArticleClass obj = new ArticleClass ();
				obj.setParent (this.articleClassService.getByKey (Long.valueOf (Long.parseLong (pid))));
				mv.addObject ("obj" , obj);
			}
			mv.addObject ("acs" , acs);
			return mv;
		}

	@SecurityMapping(title = "文章分类编辑" , value = "/admin/articleclass_edit.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/articleclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				ArticleClass articleClass = this.articleClassService.getByKey (Long.valueOf (Long.parseLong (id)));
				ArticleClassExample articleClassExample = new ArticleClassExample ();
				articleClassExample.clear ();
				articleClassExample.createCriteria ().andParentIdIsNull ();
				articleClassExample.setOrderByClause ("sequence asc");
				List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
				mv.addObject ("acs" , acs);
				mv.addObject ("obj" , articleClass);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "文章分类保存" , value = "/admin/articleclass_save.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String pid , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			ArticleClass articleClass = null;
			if (id.equals (""))
			{
				articleClass = (ArticleClass) wf.toPo (request , ArticleClass.class);
				articleClass.setAddtime (new Date ());
			}
			else
			{
				ArticleClass obj = this.articleClassService.getByKey (Long.valueOf (Long.parseLong (id)));
				articleClass = (ArticleClass) wf.toPo (request , obj);
			}
			if ((pid != null) && (!pid.equals ("")))
			{
				ArticleClass parent = this.articleClassService.getByKey (Long.valueOf (Long.parseLong (pid)));
				articleClass.setParent (parent);
			}
			if (id.equals (""))
				this.articleClassService.add (articleClass);
			else
				this.articleClassService.updateByObject (articleClass);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage);
			mv.addObject ("op_title" , "保存文章分类成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?pid=" + pid);
			}
			return mv;
		}

	private List <Long> genericIds (ArticleClass ac)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (ac.getId ());
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.clear ();
			articleClassExample.createCriteria ().andParentIdEqualTo (ac.getId ());
			List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
			ac.setChilds (acs);
			for (ArticleClass child : ac.getChilds ())
			{
				List <Long> cids = genericIds (child);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
				ids.add (child.getId ());
			}
			return ids;
		}

	/**
	 * 
	 * <p>
	 * Title: delete
	 * </p>
	 * <p>
	 * Description: 文章分类删除
	 * </p>
	 * 
	 * @param request
	 * @param mulitId
	 *            文章信息的ID
	 * @return
	 */
	@SecurityMapping(title = "文章分类删除" , value = "/admin/articleclass_del.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_del.htm" })
	public String delete (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					List <Long> list = genericIds (this.articleClassService.getByKey (Long.valueOf (Long.parseLong (id))));
					ArticleClassExample articleClassExample = new ArticleClassExample ();
					articleClassExample.clear ();
					articleClassExample.createCriteria ().andIdIn (list);
					articleClassExample.setOrderByClause ("level desc");
					List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
					for (ArticleClass ac : acs)
					{
						ac.setParentId (Long.valueOf (-1));      // 设置上级外键id 为-1 表示删除
						this.articleClassService.deleteByKey (ac.getId ());
					}
				}
			}
			return "redirect:articleclass_list.htm";
		}

	@SecurityMapping(title = "文章下级分类" , value = "/admin/articleclass_data.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_data.htm" })
	public ModelAndView articleclass_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/articleclass_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.createCriteria ().andParentIdEqualTo (Long.valueOf (Long.parseLong (pid)));
			List <ArticleClass> acs = articleClassService.getObjectList (articleClassExample);
			/*
			 * Map map = new HashMap();
			 * map.put("pid", Long.valueOf(Long.parseLong(pid)));
			 * List acs = this.articleClassService.query(
			 * "select obj from ArticleClass obj where obj.parent.id =:pid",
			 * map, -1, -1);
			 */
			mv.addObject ("acs" , acs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "文章分类AJAX更新" , value = "/admin/articleclass_ajax.htm*" , rtype = "admin" , rname = "文章分类" ,
						rcode = "article_class" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/articleclass_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			ArticleClass ac = this.articleClassService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val=CreateBeanWrapperUtil.createBeanWrapper (ArticleClass.class , ac , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());
			}
			this.articleClassService.updateByObject (ac);
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

	/**
	 * 
	 * <p>
	 * Title: articleclass_verify
	 * </p>
	 * <p>
	 * Description: 文章分类名称ajax验证是否存在
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param className
	 * @param id
	 */
	@RequestMapping({ "/admin/articleclass_verify.htm" })
	public void articleclass_verify (HttpServletRequest request , HttpServletResponse response , String className , String id)
		{
			boolean ret = true;
			ArticleClassExample articleClassExample = new ArticleClassExample ();
			articleClassExample.createCriteria ().andClassnameEqualTo (className).andIdEqualTo (CommUtil.null2Long (id));
			List <ArticleClass> gcs = articleClassService.getObjectList (articleClassExample);
			if ((gcs != null) && (gcs.size () > 0))
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
