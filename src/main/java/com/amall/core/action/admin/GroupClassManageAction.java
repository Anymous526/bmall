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
import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.service.group.IGroupClassService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class GroupClassManageAction
{
	private Logger logger=Logger.getLogger (GroupClassManageAction.class);
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGroupClassService groupclassService;

	@Autowired
	private IGroupGoodsService groupgoodsService;

	@SecurityMapping(title = "团购分类列表" , value = "/admin/group_class_list.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/group_class_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			GroupClassExample.Criteria groupClassCriteria = groupClassExample.createCriteria ();
			groupClassExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			groupClassExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			groupClassCriteria.andParentIdIsNull ();
			Pagination pList = groupclassService.getObjectListWithPage (groupClassExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/group_class_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "团购分类增加" , value = "/admin/group_class_add.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/group_class_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			groupClassExample.createCriteria ().andParentIdIsNull ();
			List <GroupClass> gcs = this.groupclassService.getObjectList (groupClassExample);
			GroupClass parent = this.groupclassService.getByKey (CommUtil.null2Long (pid));
			GroupClass obj = new GroupClass ();
			if (parent != null)
				obj.setParent (parent);
			mv.addObject ("obj" , obj);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购分类编辑" , value = "/admin/group_class_edit.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_class_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GroupClass groupclass = this.groupclassService.getByKey (Long.valueOf (Long.parseLong (id)));
				GroupClassExample groupClassExample = new GroupClassExample ();
				groupClassExample.clear ();
				groupClassExample.createCriteria ().andParentIdIsNull ();
				List <GroupClass> gcs = groupclassService.getObjectList (groupClassExample);
				mv.addObject ("gcs" , gcs);
				mv.addObject ("obj" , groupclass);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "团购分类保存" , value = "/admin/group_class_save.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String pid)
		{
			WebForm wf = new WebForm ();
			GroupClass groupclass = null;
			if (id.equals (""))
			{
				groupclass = (GroupClass) wf.toPo (request , GroupClass.class);
				groupclass.setAddtime (new Date ());
			}
			else
			{
				GroupClass obj = this.groupclassService.getByKey (Long.valueOf (Long.parseLong (id)));
				groupclass = (GroupClass) wf.toPo (request , obj);
			}
			GroupClass parent = this.groupclassService.getByKey (CommUtil.null2Long (pid));
			if (parent != null)
			{
				groupclass.setParent (parent);
				groupclass.setGcLevel (parent.getGcLevel () + 1);
			}
			if (id.equals (""))
				this.groupclassService.add (groupclass);
			else
				this.groupclassService.updateByObject (groupclass);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/group_class_list.htm");
			mv.addObject ("op_title" , "保存团购分类成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/group_class_add.htm" + "?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购分类删除" , value = "/admin/group_class_del.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GroupClass groupclass = this.groupclassService.getByKey (Long.valueOf (Long.parseLong (id)));
					for (GroupGoods gg : groupclass.getGgs ())
					{
						if (gg != null)
						{
							gg.setGgGc (null);
							this.groupgoodsService.updateByObject (gg);
						}
					}
					this.groupclassService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:group_class_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购分类Ajax更新" , value = "/admin/group_class_ajax.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			GroupClass obj = this.groupclassService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val=null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (GroupClass.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				logger.error (e1.getMessage ());
			}
			this.groupclassService.updateByObject (obj);
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
				logger.error (e.getMessage ());
			}
		}

	@SecurityMapping(title = "团购分类下级加载" , value = "/admin/group_class_data.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_class_data.htm" })
	public ModelAndView group_class_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_class_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			groupClassExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (pid));
			List <GroupClass> gcs = groupclassService.getObjectList (groupClassExample);
			/*
			 * Map map = new HashMap();
			 * map.put("pid", CommUtil.null2Long(pid));
			 * List gcs = this.groupclassService.query(
			 * "select obj from GroupClass obj where obj.parent.id =:pid",
			 * map, -1, -1);
			 */
			mv.addObject ("gcs" , gcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@RequestMapping({ "/admin/group_class_verify.htm" })
	public void group_class_verify (HttpServletRequest request , HttpServletResponse response , String gc_name , String id , String pid)
		{
			boolean ret = true;
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			groupClassExample.createCriteria ().andGcNameEqualTo (gc_name).andIdEqualTo (CommUtil.null2Long (id)).andParentIdEqualTo (CommUtil.null2Long (pid));
			List <GroupClass> gcs = groupclassService.getObjectList (groupClassExample);
			/*
			 * Map params = new HashMap();
			 * params.put("gc_name", gc_name);
			 * params.put("id", CommUtil.null2Long(id));
			 * params.put("pid", CommUtil.null2Long(pid));
			 * List gcs = this.groupclassService
			 * .query(
			 * "select obj from GroupClass obj where obj.gc_name=:gc_name and obj.id!=:id and obj.parent.id =:pid"
			 * ,
			 * params, -1, -1);
			 */
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
				logger.error (e.getMessage ());
			}
		}
}
