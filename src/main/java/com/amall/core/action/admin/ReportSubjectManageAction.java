package com.amall.core.action.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.ReportSubject;
import com.amall.core.bean.ReportSubjectExample;
import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;
import com.amall.core.service.report.IReportSubjectService;
import com.amall.core.service.report.IReportTypeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ReportSubjectManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IReportSubjectService reportsubjectService;

	@Autowired
	private IReportTypeService reportTypeService;

	@SecurityMapping(title = "举报主题列表" , value = "/admin/reportsubject_list.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reportsubject_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/reportsubject_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			ReportSubjectExample reportSubjectExample = new ReportSubjectExample ();
			reportSubjectExample.clear ();
			ReportSubjectExample.Criteria reportSubjectCriteria = reportSubjectExample.createCriteria ();
			reportSubjectExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			reportSubjectExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			WebForm wf = new WebForm ();
			// wf.toQueryPo(request, qo, ReportSubject.class, mv);
			Map <String, Map <String, Object>> map = wf.toQueryPo (request , ReportSubject.class , mv);
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
				if (key.equals ("title"))
				{
					if (keys.equals ("="))
					{
						reportSubjectCriteria.andTitleEqualTo (String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						reportSubjectCriteria.andTitleLike (String.valueOf (value));
					}
				}
			}
			// IPageList pList = this.reportsubjectService.list(qo);
			Pagination pList = this.reportsubjectService.getObjectListWithPage (reportSubjectExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/reportsubject_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "举报主题增加" , value = "/admin/reportsubject_add.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reportsubject_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/reportsubject_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			// List types =
			// this.reportTypeService.query("select obj from ReportType obj order by obj.addTime desc",null,
			// -1, -1);
			ReportTypeExample reportTypeExample = new ReportTypeExample ();
			reportTypeExample.clear ();
			reportTypeExample.setOrderByClause ("addTime desc");
			List <ReportType> types = this.reportTypeService.getObjectList (reportTypeExample);
			mv.addObject ("types" , types);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "举报主题编辑" , value = "/admin/reportsubject_edit.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reportsubject_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/reportsubject_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				ReportSubject reportsubject = this.reportsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
				// List types =
				// this.reportTypeService.query("select obj from ReportType obj order by obj.addTime desc",null,
				// -1, -1);
				ReportTypeExample reportTypeExample = new ReportTypeExample ();
				reportTypeExample.clear ();
				reportTypeExample.setOrderByClause ("addTime desc");
				List <ReportType> types = this.reportTypeService.getObjectList (reportTypeExample);
				mv.addObject ("types" , types);
				mv.addObject ("obj" , reportsubject);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "举报主题保存" , value = "/admin/reportsubject_save.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reportsubject_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url , String typeId)
		{
			WebForm wf = new WebForm ();
			ReportSubject reportsubject = null;
			if (id.equals (""))
			{
				reportsubject = (ReportSubject) wf.toPo (request , ReportSubject.class);
				reportsubject.setAddtime (new Date ());
			}
			else
			{
				ReportSubject obj = this.reportsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
				reportsubject = (ReportSubject) wf.toPo (request , obj);
			}
			ReportType type = this.reportTypeService.getByKey (CommUtil.null2Long (typeId));
			reportsubject.setType (type);
			if (id.equals (""))
				this.reportsubjectService.add (reportsubject);
			else
				this.reportsubjectService.updateByObject (reportsubject);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存举报主题成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "举报主题删除" , value = "/admin/reportsubject_del.htm*" , rtype = "admin" , rname = "举报管理" ,
						rcode = "report_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/reportsubject_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					ReportSubject reportsubject = this.reportsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.reportsubjectService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:reportsubject_list.htm?currentPage=" + currentPage;
		}
}
