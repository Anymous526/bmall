package com.amall.core.action.admin;

import java.io.File;
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
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;
import net.sf.ehcache.CacheManager;

/**
 * 
 * <p>
 * Title: _AreaManageAction
 * </p>
 * <p>
 * Description: 地区crud 和导入
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午11:04:58
 * @version 1.0
 */
@Controller
public class AreaManageAction
{

	private Logger log=Logger.getLogger (AreaManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private DatabaseTools databaseTools;

	@SecurityMapping(title = "地区列表" , value = "/admin/area_list.htm*" , rtype = "admin" , rname = "常用地区" ,
						rcode = "admin_area_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/area_list.htm" })
	public ModelAndView area_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/area_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			AreaExample areaExample = new AreaExample ();
			if ((pid == null) || (pid.equals ("")))
			{
				areaExample.clear ();
				areaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				areaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				areaExample.createCriteria ().andParentIdIsNull ();
			}
			else
			{
				areaExample.clear ();
				areaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				areaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				areaExample.createCriteria ().andParentIdEqualTo (Long.parseLong (pid));
				params = "&pid=" + pid;
				Area parent = this.areaService.getByKey (Long.valueOf (Long.parseLong (pid)));
				mv.addObject ("parent" , parent);
				if (parent.getLevel () == 0)
				{
					areaExample.createCriteria ().andParentIdEqualTo (parent.getId ());
					List <Area> seconds = areaService.getObjectList (areaExample);
					mv.addObject ("seconds" , seconds);
					mv.addObject ("first" , parent);
				}
				if (parent.getLevel () == 1)
				{
					areaExample.createCriteria ().andParentIdEqualTo (parent.getId ());
					List <Area> thirds = areaService.getObjectList (areaExample);
					Long secondId = parent.getParentId ();
					Area second = areaService.getByKey (secondId);
					areaExample.createCriteria ().andParentIdEqualTo (second.getId ());
					List <Area> seconds = areaService.getObjectList (areaExample);
					Area first = areaService.getByKey (parent.getId ());
					mv.addObject ("thirds" , thirds);
					mv.addObject ("seconds" , seconds);
					mv.addObject ("second" , parent);
					mv.addObject ("first" , first);
				}
				if (parent.getLevel () == 2)
				{
					Long secondId = parent.getParentId ();
					Area second = areaService.getByKey (secondId);
					areaExample.createCriteria ().andParentIdEqualTo (second.getId ());
					List <Area> thirds = areaService.getObjectList (areaExample);
					Area first = areaService.getByKey (second.getParentId ());
					areaExample.createCriteria ().andParentIdEqualTo (first.getId ());
					List <Area> seconds = areaService.getObjectList (areaExample);
					mv.addObject ("thirds" , thirds);
					mv.addObject ("seconds" , seconds);
					mv.addObject ("third" , parent);
					mv.addObject ("second" , second);
					mv.addObject ("first" , first);
				}
			}
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , Area.class , mv);
			Pagination pList = areaService.getObjectListWithPage (areaExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/area_list.htm" , "" , params , pList , mv);
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = areaService.getObjectList (areaExample);
			mv.addObject ("areas" , areas);
			return mv;
		}

	@SecurityMapping(title = "地区保存" , value = "/admin/area_add.htm*" , rtype = "admin" , rname = "常用地区" ,
						rcode = "admin_area_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/area_add.htm" })
	public ModelAndView area_add (HttpServletRequest request , HttpServletResponse response , String areaId , String pid , String count , String list_url , String currentPage)
		{
			if (areaId != null)
			{
				String [ ] ids = areaId.split (",");
				int i = 1;
				for (String id : ids)
				{
					String areaName = request.getParameter ("areaName_" + i);
					Area area = this.areaService.getByKey (Long.valueOf (Long.parseLong (request.getParameter ("id_" + i))));
					area.setAreaname (areaName);
					area.setSequence (CommUtil.null2Int (request.getParameter ("sequence_" + i)));
					this.areaService.updateByObject (area);
					i++;
				}
			}
			Area parent = null;
			if (!pid.equals (""))
				parent = this.areaService.getByKey (Long.valueOf (Long.parseLong (pid)));
			for (int i = 1 ; i <= CommUtil.null2Int (count) ; i++)
			{
				Area area = new Area ();
				area.setAddtime (new Date ());
				String areaName = request.getParameter ("new_areaName_" + i);
				int sequence = CommUtil.null2Int (request.getParameter ("new_sequence_" + i));
				if (parent != null)
				{
					area.setLevel (parent.getLevel () + 1);
					area.setParent (parent);
				}
				area.setAreaname (areaName);
				area.setSequence (sequence);
				this.areaService.add (area);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "更新区域成功");
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage + "&pid=" + pid);
			return mv;
		}

	private List <Long> genericIds (Area obj)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (obj.getId ());
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdEqualTo (obj.getId ());
			List <Area> areas = areaService.getObjectList (areaExample);
			obj.setChilds (areas);
			for (Area child : obj.getChilds ())
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

	@SecurityMapping(title = "地区删除" , value = "/admin/area_del.htm*" , rtype = "admin" , rname = "常用地区" ,
						rcode = "admin_area_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/area_del.htm" })
	public String area_del (HttpServletRequest request , String mulitId , String currentPage , String pid)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					List <Long> list = genericIds (this.areaService.getByKey (Long.valueOf (Long.parseLong (id))));
					AreaExample areaExample = new AreaExample ();
					areaExample.clear ();
					areaExample.createCriteria ().andIdIn (list);
					List <Area> objs = areaService.getObjectList (areaExample);
					for (Area obj : objs)
					{
						obj.setParent (null);
						this.areaService.deleteByKey (obj.getId ());
					}
				}
			}
			return "redirect:area_list.htm?pid=" + pid + "&currentPage=" + currentPage;
		}

	@SecurityMapping(title = "地区导入" , value = "/admin/area_import.htm*" , rtype = "admin" , rname = "常用地区" ,
						rcode = "admin_area_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/area_import.htm" })
	public ModelAndView area_import (HttpServletRequest request , HttpServletResponse response , String list_url) throws Exception
		{
			ModelAndView mv = null;
			this.databaseTools.execute ("update amall_store set area_id=null");
			this.databaseTools.execute ("update amall_address set area_id=null");
			this.databaseTools.execute ("update amall_area set parent_id=null");
			this.databaseTools.execute ("delete from amall_area");
			String filePath = this.configService.getSysConfig ().getUploadRootPath () + "resources/data/area.sql";
			File file = new File (filePath);
			boolean ret = true;
			if (file.exists ())
				ret = this.databaseTools.executSqlScript (filePath);
			else
			{
				ret = false;
			}
			if (ret)
			{
				mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				CacheManager manager = CacheManager.create ();
				manager.clearAll ();
				mv.addObject ("op_title" , "数据导入成功");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "数据导入失败");
			}
			mv.addObject ("list_url" , list_url);
			return mv;
		}

	@RequestMapping({ "/admin/area_export.htm" })
	public ModelAndView area_export (HttpServletRequest request , HttpServletResponse response) throws Exception
		{
			ModelAndView mv = null;
			String path = this.configService.getSysConfig ().getUploadRootPath () + "resources" + File.separator + "data" + File.separator + "base.sql";
			String tables = "amall_accessory,amall_adv_pos,amall_advert,amall_articleclass,amall_article,amall_document,amall_navigation,amall_template,amall_sysconfig";
			boolean ret = this.databaseTools.export (tables , path);
			if (ret)
			{
				mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				CacheManager manager = CacheManager.create ();
				manager.clearAll ();
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			}
			mv.addObject ("op_title" , "数据导出");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/area_list.htm");
			return mv;
		}

	@SecurityMapping(title = "地区Ajax编辑" , value = "/admin/area_ajax.htm*" , rtype = "admin" , rname = "常用地区" ,
						rcode = "admin_area_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/area_ajax.htm" })
	public void area_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			Area obj = this.areaService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val=	CreateBeanWrapperUtil.createBeanWrapper (Area.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());
			}
			this.areaService.updateByObject (obj);
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
