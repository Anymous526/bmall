package com.amall.core.action.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;
import com.amall.core.service.report.IReportTypeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ReportTypeManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IReportTypeService reporttypeService;

	@SecurityMapping(title = "举报类型列表" , value = "/admin/reporttype_list.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reporttype_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/reporttype_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			ReportTypeExample reportTypeExample = new ReportTypeExample ();
			reportTypeExample.clear ();
			ReportTypeExample.Criteria reportTypeCriteria = reportTypeExample.createCriteria ();
			reportTypeExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			reportTypeExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			/*
			 * ReportTypeQueryObject qo = new ReportTypeQueryObject(currentPage, mv,
			 * orderBy, orderType);
			 */
			WebForm wf = new WebForm ();
			// wf.toQueryPo(request, qo, ReportType.class, mv);
			Map <String, Map <String, Object>> map = wf.toQueryPo (request , ReportType.class , mv);
			Iterator <String> it = map.keySet ().iterator ();
			while (it.hasNext ())
			{
				String key = it.next ().toString ();// 字段名
				Map <String, Object> map2 = map.get (key);
				Iterator <String> it2 = map2.keySet ().iterator ();
				String keys = "";// =或者like
				Object value = null;// 字段值
				if (it2.hasNext ())
				{
					keys = it2.next ().toString ();
					value = map2.get (keys);
				}
				if (key.equals ("name"))
				{
					if (keys.equals ("="))
					{
						reportTypeCriteria.andNameEqualTo (String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						reportTypeCriteria.andNameLike (String.valueOf (value));
					}
				}
			}
			Pagination pList = this.reporttypeService.getObjectListWithPage (reportTypeExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/reporttype_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "举报类型增加" , value = "/admin/reporttype_add.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reporttype_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/reporttype_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "举报类型编辑" , value = "/admin/reporttype_edit.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reporttype_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/reporttype_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				ReportType reporttype = this.reporttypeService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , reporttype);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "举报类型保存" , value = "/admin/reporttype_save.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reporttype_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			ReportType reporttype = null;
			if (id.equals (""))
			{
				reporttype = (ReportType) wf.toPo (request , ReportType.class);
				reporttype.setAddtime (new Date ());
			}
			else
			{
				ReportType obj = this.reporttypeService.getByKey (Long.valueOf (Long.parseLong (id)));
				reporttype = (ReportType) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.reporttypeService.add (reporttype);
			else
				this.reporttypeService.updateByObject (reporttype);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存举报类型成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "举报类型删除" , value = "/admin/reporttype_del.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reporttype_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					ReportType reporttype = this.reporttypeService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.reporttypeService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:reporttype_list.htm?currentPage=" + currentPage;
		}
}
