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
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.TransArea;
import com.amall.core.bean.TransAreaExample;
import com.amall.core.service.ITransAreaService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class TransAreaManageAction
{

	private Logger log =Logger.getLogger (TransAreaManageAction.class);
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ITransAreaService transareaService;

	@SecurityMapping(title = "运费地区列表" , value = "/admin/trans_area_list.htm*" , rtype = "admin" , rname = "运费区域" ,
						rcode = "admin_trans_area" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/trans_area_list.htm" })
	public ModelAndView trans_area_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/trans_area_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			AreaExample areaExample = new AreaExample ();
			TransAreaExample transAreaExample = new TransAreaExample ();
			// AreaQueryObject qo = null;
			if ((pid == null) || (pid.equals ("")))
			{
				areaExample.clear ();
				areaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				areaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				transAreaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				transAreaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				// qo = new AreaQueryObject(currentPage, mv, orderBy, orderType);
				// qo.addQuery("obj.parent.id is null", null);
			}
			else
			{
				areaExample.clear ();
				areaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				areaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				/*
				 * qo = new AreaQueryObject(currentPage, mv, orderBy, orderType);
				 * qo.addQuery("obj.parent.id",
				 * new SysMap("pid", Long.valueOf(Long.parseLong(pid))), "=");
				 */
				areaExample.createCriteria ().andParentIdEqualTo (Long.valueOf (Long.parseLong (pid)));
				params = "&pid=" + pid;
				TransArea parent = this.transareaService.getByKey (Long.valueOf (Long.parseLong (pid)));
				mv.addObject ("parent" , parent);
				if (parent.getLevel () == 0)
				{
					transAreaExample.createCriteria ().andParentIdEqualTo (parent.getId ());
					transAreaExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
					transAreaExample.setOrderByClause (Pagination.cst (orderBy , orderType));
					List <TransArea> seconds = transareaService.getObjectList (transAreaExample);
					/*
					 * Map map = new HashMap();
					 * map.put("pid", parent.getId());
					 * List seconds = this.transareaService
					 * .query("select obj from TransArea obj where obj.parent.id=:pid",
					 * map, -1, -1);
					 */
					mv.addObject ("seconds" , seconds);
					mv.addObject ("first" , parent);
				}
				if (parent.getLevel () == 1)
				{
					transAreaExample.createCriteria ().andParentIdEqualTo (parent.getId ());
					List <TransArea> thirds = transareaService.getObjectList (transAreaExample);
					/*
					 * Map map = new HashMap();
					 * map.put("pid", parent.getId());
					 * List thirds = this.transareaService
					 * .query("select obj from TransArea obj where obj.parent.id=:pid",
					 * map, -1, -1);
					 */
					/*
					 * map.clear();
					 * map.put("pid", parent.getParent().getId());
					 * List seconds = this.transareaService
					 * .query("select obj from TransArea obj where obj.parent.id=:pid",
					 * map, -1, -1);
					 */
					transAreaExample.createCriteria ().andParentIdEqualTo (parent.getParent ().getId ());
					List <TransArea> seconds = transareaService.getObjectList (transAreaExample);
					mv.addObject ("thirds" , thirds);
					mv.addObject ("seconds" , seconds);
					mv.addObject ("second" , parent);
					mv.addObject ("first" , parent.getParent ());
				}
				if (parent.getLevel () == 2)
				{
					/*
					 * Map map = new HashMap();
					 * map.put("pid", parent.getParent().getId());
					 * List thirds = this.transareaService
					 * .query("select obj from TransArea obj where obj.parent.id=:pid",
					 * map, -1, -1);
					 */
					transAreaExample.createCriteria ().andParentIdEqualTo (parent.getParent ().getId ());
					List <TransArea> thirds = transareaService.getObjectList (transAreaExample);
					/*
					 * map.clear();
					 * map.put("pid", parent.getParent().getParent().getId());
					 * List seconds = this.transareaService
					 * .query("select obj from TransArea obj where obj.parent.id=:pid",
					 * map, -1, -1);
					 */
					transAreaExample.createCriteria ().andParentIdEqualTo (parent.getParent ().getParent ().getId ());
					List <TransArea> seconds = transareaService.getObjectList (transAreaExample);
					TransArea second = transareaService.getByKey (parent.getParentId ());
					TransArea first = transareaService.getByKey (second.getParentId ());
					mv.addObject ("thirds" , thirds);
					mv.addObject ("seconds" , seconds);
					mv.addObject ("third" , parent);
					mv.addObject ("second" , second);
					mv.addObject ("first" , first);
				}
			}
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , TransArea.class , mv);
			// IPageList pList = this.transareaService.list(qo);
			Pagination pList = transareaService.getObjectListWithPage (transAreaExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/trans_area_list.htm" , "" , params , pList , mv);
			// areaExample.clear();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <TransArea> areas = transareaService.getObjectList (transAreaExample);
			/*
			 * List areas = this.transareaService.query(
			 * "select obj from TransArea obj where obj.parent.id is null",
			 * null, -1, -1);
			 */
			mv.addObject ("areas" , areas);
			return mv;
		}

	@SecurityMapping(title = "运费地区保存" , value = "/admin/trans_area_save.htm*" , rtype = "admin" , rname = "运费区域" ,
						rcode = "admin_trans_area" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/trans_area_save.htm" })
	public ModelAndView trans_area_save (HttpServletRequest request , HttpServletResponse response , String areaId , String pid , String count , String list_url , String currentPage)
		{
			if (areaId != null)
			{
				String [ ] ids = areaId.split (",");
				int i = 1;
				for (String id : ids)
				{
					String areaName = request.getParameter ("areaName_" + i);
					TransArea area = this.transareaService.getByKey (Long.valueOf (Long.parseLong (request.getParameter ("id_" + i))));
					area.setAreaname (areaName);
					area.setSequence (CommUtil.null2Int (request.getParameter ("sequence_" + i)));
					this.transareaService.updateByObject (area);
					i++;
				}
			}
			TransArea parent = null;
			if (!pid.equals (""))
				parent = this.transareaService.getByKey (Long.valueOf (Long.parseLong (pid)));
			for (int i = 1 ; i <= CommUtil.null2Int (count) ; i++)
			{
				TransArea area = new TransArea ();
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
				this.transareaService.add (area);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "更新配送区域成功");
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage + "&pid=" + pid);
			return mv;
		}

	private List <Long> genericIds (TransArea obj)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (obj.getId ());
			TransAreaExample transAreaExample = new TransAreaExample ();
			transAreaExample.clear ();
			transAreaExample.createCriteria ().andParentIdEqualTo (obj.getId ());
			List <TransArea> tas = transareaService.getObjectList (transAreaExample);
			obj.getChilds ().addAll (tas);
			for (TransArea child : obj.getChilds ())
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

	@SecurityMapping(title = "运费地区删除" , value = "/admin/trans_area_del.htm*" , rtype = "admin" , rname = "运费区域" ,
						rcode = "admin_trans_area" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/trans_area_del.htm" })
	public String trans_area_del (HttpServletRequest request , String mulitId , String currentPage , String pid)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					List <Long> list = genericIds (this.transareaService.getByKey (Long.valueOf (Long.parseLong (id))));
					TransAreaExample areaExample = new TransAreaExample ();
					areaExample.clear ();
					areaExample.createCriteria ().andIdIn (list);
					List <TransArea> objs = transareaService.getObjectList (areaExample);
					/*
					 * Map params = new HashMap();
					 * params.put("ids", list);
					 * List<TransArea> objs = this.transareaService.query(
					 * "select obj from TransArea obj where obj.id in (:ids)",
					 * params, -1, -1);
					 */
					for (TransArea obj : objs)
					{
						obj.setParent (null);
						this.transareaService.deleteByKey (obj.getId ());
					}
				}
			}
			return "redirect:trans_area_list.htm?pid=" + pid + "&currentPage=" + currentPage;
		}

	@SecurityMapping(title = "运费地区Ajax更新" , value = "/admin/trans_area_ajax.htm*" , rtype = "admin" , rname = "运费区域" ,
						rcode = "admin_trans_area" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/trans_area_ajax.htm" })
	public void trans_area_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			TransArea obj = this.transareaService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val=CreateBeanWrapperUtil.createBeanWrapper (TransArea.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());
			}
			this.transareaService.updateByObject (obj);
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
