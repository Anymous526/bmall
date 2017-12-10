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
import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;
import com.amall.core.service.complaint.IComplaintSubjectService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ComplaintSubjectManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IComplaintSubjectService complaintsubjectService;

	@SecurityMapping(title = "投诉主题列表" , value = "/admin/complaintsubject_list.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaintsubject_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/complaintsubject_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			ComplaintSubjectExample cSubjectExample = new ComplaintSubjectExample ();
			cSubjectExample.clear ();
			ComplaintSubjectExample.Criteria cSubjectCriteria = cSubjectExample.createCriteria ();
			cSubjectExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			cSubjectExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			/*
			 * ComplaintSubjectQueryObject qo = new ComplaintSubjectQueryObject(
			 * currentPage, mv, orderBy, orderType);
			 */
			WebForm wf = new WebForm ();
			// wf.toQueryPo(request, ComplaintSubject.class, mv);
			/**
			 * 第一个String表示字段名，Map<String，Object>中String表示=或者like条件,Object表示字段值
			 * 
			 */
			Map <String, Map <String, Object>> map = wf.toQueryPo (request , ComplaintSubject.class , mv);
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
				if (key.equals ("type"))
				{
					if (keys.equals ("="))
					{
						cSubjectCriteria.andTypeEqualTo (String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						cSubjectCriteria.andTypeLike (String.valueOf (value));
					}
				}
			}
			Pagination pList = complaintsubjectService.getObjectListWithPage (cSubjectExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/complaintsubject_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "投诉主题添加" , value = "/admin/complaintsubject_add.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaintsubject_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/complaintsubject_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "投诉主题编辑" , value = "/admin/complaintsubject_edit.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaintsubject_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/complaintsubject_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				ComplaintSubject complaintsubject = this.complaintsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , complaintsubject);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "投诉主题保存" , value = "/admin/complaintsubject_save.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaintsubject_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			ComplaintSubject complaintsubject = null;
			if (id.equals (""))
			{
				complaintsubject = (ComplaintSubject) wf.toPo (request , ComplaintSubject.class);
				complaintsubject.setAddtime (new Date ());
			}
			else
			{
				ComplaintSubject obj = this.complaintsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
				complaintsubject = (ComplaintSubject) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.complaintsubjectService.add (complaintsubject);
			else
				this.complaintsubjectService.updateByObject (complaintsubject);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存投诉主题成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "投诉主题删除" , value = "/admin/complaintsubject_del.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaintsubject_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					ComplaintSubject complaintsubject = this.complaintsubjectService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.complaintsubjectService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:complaintsubject_list.htm?currentPage=" + currentPage;
		}
}
