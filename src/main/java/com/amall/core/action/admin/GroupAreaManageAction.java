package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GroupArea;
import com.amall.core.bean.GroupAreaExample;
import com.amall.core.service.group.IGroupAreaService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

@Controller
public class GroupAreaManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGroupAreaService groupareaService;

	@SecurityMapping(title = "团购区域列表" , value = "/admin/group_area_list.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/group_area_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			groupAreaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			groupAreaExample.createCriteria ().andParentIdIsNull ();
			Pagination pList = groupareaService.getObjectListWithPage (groupAreaExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/group_area_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "团购区域增加" , value = "/admin/group_area_add.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/group_area_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GroupArea parent = this.groupareaService.getByKey (CommUtil.null2Long (pid));
			GroupArea obj = new GroupArea ();
			if (parent != null)
				obj.setParent (parent);
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.createCriteria ().andParentIdIsNull ();
			List <GroupArea> gas = groupareaService.getObjectList (groupAreaExample);
			List <Long> ids = new ArrayList <Long> ();
			for (GroupArea ga : gas)
			{
				ids = genericGaIds (ga);
				groupAreaExample.clear ();
				groupAreaExample.createCriteria ().andParentIdIn (ids);
				ga.setChilds (groupareaService.getObjectList (groupAreaExample));
			}
			mv.addObject ("gas" , gas);
			mv.addObject ("obj" , obj);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购区域编辑" , value = "/admin/group_area_edit.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_area_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GroupArea grouparea = this.groupareaService.getByKey (Long.valueOf (Long.parseLong (id)));
				GroupAreaExample groupAreaExample = new GroupAreaExample ();
				groupAreaExample.clear ();
				groupAreaExample.createCriteria ().andParentIdIsNull ();
				List <GroupArea> gas = groupareaService.getObjectList (groupAreaExample);
				mv.addObject ("gas" , gas);
				mv.addObject ("obj" , grouparea);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "团购区域保存" , value = "/admin/group_area_save.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String pid)
		{
			WebForm wf = new WebForm ();
			GroupArea grouparea = null;
			if (id.equals (""))
			{
				grouparea = (GroupArea) wf.toPo (request , GroupArea.class);
				grouparea.setAddtime (new Date ());
			}
			else
			{
				GroupArea obj = this.groupareaService.getByKey (Long.valueOf (Long.parseLong (id)));
				grouparea = (GroupArea) wf.toPo (request , obj);
			}
			GroupArea parent = this.groupareaService.getByKey (CommUtil.null2Long (pid));
			if (parent != null)
			{
				grouparea.setParent (parent);
				grouparea.setGaLevel (parent.getGaLevel () + 1);
			}
			if (id.equals (""))
				this.groupareaService.add (grouparea);
			else
				this.groupareaService.updateByObject (grouparea);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/group_area_list.htm");
			mv.addObject ("op_title" , "保存团购区域成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/group_area_add.htm" + "?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购区域删除" , value = "/admin/group_area_del.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					GroupArea grouparea = this.groupareaService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.groupareaService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:group_area_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购区域Ajax更新" , value = "/admin/group_area_ajax.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GroupArea obj = this.groupareaService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GroupArea.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			Object val = null;
			for (Field field : fields)
			{
				if (field.getName ().equals (fieldName))
				{
					Class <?> clz = Class.forName ("java.lang.String");
					if (field.getType ().getName ().equals ("int"))
					{
						clz = Class.forName ("java.lang.Integer");
					}
					if (field.getType ().getName ().equals ("boolean"))
					{
						clz = Class.forName ("java.lang.Boolean");
					}
					if (!value.equals (""))
						val = BeanUtils.convertType (value , clz);
					else
					{
						val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
					}
					wrapper.setPropertyValue (fieldName , val);
				}
			}
			this.groupareaService.updateByObject (obj);
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

	@SecurityMapping(title = "团购区域下级加载" , value = "/admin/group_area_data.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_area_data.htm" })
	public ModelAndView group_area_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_area_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (pid));
			List <GroupArea> gas = groupareaService.getObjectList (groupAreaExample);
			mv.addObject ("gas" , gas);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@RequestMapping({ "/admin/group_area_verify.htm" })
	public void group_area_verify (HttpServletRequest request , HttpServletResponse response , String ga_name , String id , String pid)
		{
			boolean ret = true;
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (pid)).andIdEqualTo (CommUtil.null2Long (id)).andGaNameEqualTo (ga_name);
			List <GroupArea> gcs = groupareaService.getObjectList (groupAreaExample);
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
				e.printStackTrace ();
			}
		}

	/**
	 * @todo 获取一个团购区域的id以及该区域下面的所有子孙区域的id
	 * @author xpy
	 * @param gc
	 * @return
	 */
	private List <Long> genericGaIds (GroupArea ga)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (ga.getId ());
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			GroupAreaExample.Criteria groupAreaCriteria = groupAreaExample.createCriteria ();
			groupAreaCriteria.andParentIdEqualTo (ga.getId ());
			List <GroupArea> list = groupareaService.getObjectList (groupAreaExample);
			if (list != null && !list.isEmpty ())
			{
				ga.getChilds ().addAll (list);
				for (GroupArea child : ga.getChilds ())
				{
					List <Long> cids = genericIds (child);
					for (Long cid : cids)
					{
						ids.add (cid);
					}
					ids.add (child.getId ());
				}
			}
			return ids;
		}

	private List <Long> genericIds (GroupArea ga)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (ga.getId ());
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.createCriteria ().andParentIdEqualTo (ga.getId ());
			List <GroupArea> gas = groupareaService.getObjectList (groupAreaExample);
			ga.getChilds ().addAll (gas);
			for (GroupArea child : ga.getChilds ())
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
}
