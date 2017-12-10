package com.amall.core.action.admin;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.SystemMsg;
import com.amall.core.bean.SystemMsgExample;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.systemmsg.ISystemMsgService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 系统文章管理 action
 * 
 * @author ljx
 *
 */
@Controller
public class SystemMsgManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ISystemMsgService systemMsgService;

	@SecurityMapping(title = "系统消息列表" , value = "/admin/system_msg_list.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/system_msg_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			SystemMsgExample systemMsgExample = new SystemMsgExample ();
			systemMsgExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			systemMsgExample.setOrderByClause ("sequence asc");
			systemMsgExample.createCriteria ();
			Pagination pList = systemMsgService.getObjectListWithPage (systemMsgExample);
			/*
			 * DocumentQueryObject qo = new DocumentQueryObject(currentPage, mv,
			 * orderBy, orderType);
			 */
			/*
			 * WebForm wf = new WebForm();
			 * wf.toQueryPo(request,SystemMsg.class, mv);
			 * IPageList pList = this.systemMsgService.list(qo);
			 */
			CommUtil.addIPageList2ModelAndView (url + "/admin/system_msg_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "系统消息新增" , value = "/admin/system_msg_add.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/system_msg_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "系统消息编辑" , value = "/admin/system_msg_edit.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/system_msg_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				SystemMsg SystemMsg = this.systemMsgService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , SystemMsg);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "系统消息查看" , value = "/admin/system_msg_content.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_content.htm" })
	public ModelAndView content (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/system_msg_content.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				SystemMsg SystemMsg = this.systemMsgService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , SystemMsg);
			}
			return mv;
		}

	@SecurityMapping(title = "系统消息保存" , value = "/admin/system_msg_save.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			SystemMsg systemMsg = null;
			if (id.equals (""))
			{
				systemMsg = (SystemMsg) wf.toPo (request , SystemMsg.class);
				systemMsg.setAddtime (new Date ());
			}
			else
			{
				SystemMsg obj = this.systemMsgService.getByKey (Long.valueOf (Long.parseLong (id)));
				systemMsg = (SystemMsg) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.systemMsgService.add (systemMsg);
			else
				this.systemMsgService.updateByObject (systemMsg);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存系统消息成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "系统消息删除" , value = "/admin/system_msg_del.htm*" , rtype = "admin" , rname = "系统文章" ,
						rcode = "document_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/system_msg_del.htm" })
	public String delete (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					this.systemMsgService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:system_msg_list.htm";
		}
}
