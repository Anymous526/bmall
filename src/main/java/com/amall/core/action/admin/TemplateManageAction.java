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
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class TemplateManageAction
{
	private Logger log=Logger.getLogger (TemplateManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ITemplateService templateService;

	@SecurityMapping(title = "模板列表" , value = "/admin/template_list.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_list.htm" })
	public ModelAndView template_list (HttpServletRequest request , HttpServletResponse response , String type , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/template_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			templateExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			TemplateExample.Criteria templateCriteria = templateExample.createCriteria ();
			/*
			 * TemplateQueryObject qo = new TemplateQueryObject(currentPage, mv,
			 * orderBy, orderType);
			 */
			if ((type == null) || (type.equals ("")))
				type = "msg";
			/*
			 * qo.addQuery("obj.type", new SysMap("type", type), "=");
			 * IPageList pList = this.templateService.list(qo);
			 */
			templateCriteria.andTypeEqualTo (type);
			Pagination pList = templateService.getObjectListWithPage (templateExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/template_list.htm" , "" , params , pList , mv);
			mv.addObject ("type" , type);
			return mv;
		}

	@SecurityMapping(title = "模板添加" , value = "/admin/template_add.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_add.htm" })
	public ModelAndView template_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/template_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "模板编辑" , value = "/admin/template_edit.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_edit.htm" })
	public ModelAndView template_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/template_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Template template = this.templateService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , template);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "模板保存" , value = "/admin/template_save.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_save.htm" })
	public ModelAndView template_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			Template template = null;
			if (id.equals (""))
			{
				template = (Template) wf.toPo (request , Template.class);
				template.setAddtime (new Date ());
			}
			else
			{
				Template obj = this.templateService.getByKey (Long.valueOf (Long.parseLong (id)));
				template = (Template) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.templateService.add (template);
			else
				this.templateService.updateByObject (template);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url + "?type=" + template.getType ());
			mv.addObject ("op_title" , "保存模板成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "模板AJAX更新" , value = "/admin/template_ajax.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_ajax.htm" })
	public void template_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			Template obj = this.templateService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (Template.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作，"+e1.getMessage ());

			}
			this.templateService.updateByObject (obj);
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

	@SecurityMapping(title = "模板开启" , value = "/admin/template_open.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_open.htm" })
	public String template_open (HttpServletRequest request , String mulitId , String currentPage , String type)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					Template obj = this.templateService.getByKey (Long.valueOf (Long.parseLong (id)));
					obj.setOpen (true);
					this.templateService.updateByObject (obj);
				}
			}
			return "redirect:template_list.htm?currentPage=" + currentPage + "&type=" + type;
		}

	@RequestMapping({ "/template/verify_mark.htm" })
	public void verify_mark (HttpServletRequest request , HttpServletResponse response , String mark , String id)
		{
			boolean ret = true;
			/*
			 * Map params = new HashMap();
			 * params.put("mark", mark);
			 * params.put("id", CommUtil.null2Long(id));
			 * List list = this.templateService
			 * .query("select obj from Template obj where obj.mark=:mark and obj.id!=:id",
			 * params, -1, -1);
			 */
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark).andIdEqualTo (CommUtil.null2Long (id));
			List <Template> list = templateService.getObjectList (templateExample);
			if (list.size () > 0)
				ret = false;
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

	@SecurityMapping(title = "模板编辑" , value = "/admin/template_copy.htm*" , rtype = "admin" , rname = "通知模板" ,
						rcode = "template_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/template_copy.htm" })
	public ModelAndView template_copy (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/template_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Template template = this.templateService.getByKey (Long.valueOf (Long.parseLong (id)));
				template.setId (null);
				mv.addObject ("obj" , template);
				mv.addObject ("currentPage" , currentPage);
			}
			return mv;
		}
}
