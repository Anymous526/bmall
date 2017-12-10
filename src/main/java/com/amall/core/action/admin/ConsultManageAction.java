package com.amall.core.action.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
//import com.amall.core.bean.Consult;
import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.IConsultService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ConsultManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IConsultService consultService;

	@Autowired
	private IUserService userService;

	@SecurityMapping(title = "咨询列表" , value = "/admin/consult_list.htm*" , rtype = "admin" , rname = "咨询管理" ,
						rcode = "consult_admin" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/consult_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String consult_user_userName , String consult_content)
		{
			ModelAndView mv = new JModelAndView ("admin/consult_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			// ConsultQueryObject qo = new ConsultQueryObject(currentPage, mv,orderBy, orderType);
			ConsultExample consultExample = new ConsultExample ();
			consultExample.clear ();
			ConsultExample.Criteria consultCriteria = consultExample.createCriteria ();
			consultExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			consultExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			consultExample.setPageSize (Integer.valueOf (1));
			// qo.setPageSize(Integer.valueOf(1));
			if ((consult_user_userName != null) && (!consult_user_userName.equals ("")))
			{
				/*
				 * qo.addQuery("obj.consult_user.userName", new SysMap("userName",
				 * CommUtil.null2String(consult_user_userName).trim()), "=");
				 */
				UserExample userExample = new UserExample ();
				userExample.clear ();
				UserExample.Criteria userCriteria = userExample.createCriteria ();
				userCriteria.andUsernameEqualTo (CommUtil.null2String (consult_user_userName).trim ());
				List <User> userList = this.userService.getObjectList (userExample);
				if (userList != null && userList.size () != 0)
				{
					User consultUser = userList.get (0);
					consultCriteria.andConsultUserIdEqualTo (consultUser.getId ());
				}
				else
				{
					consultCriteria.andConsultUserIdIsNull ();
				}
			}
			if ((consult_content != null) && (!consult_content.equals ("")))
			{
				consultCriteria.andConsultContentLike ("%" + consult_content + "%");
			}
			// IPageList pList = this.consultService.list(qo);
			Pagination pList = this.consultService.getObjectListWithPage (consultExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/consult_list.htm" , "" , params , pList , mv);
			mv.addObject ("consult_user_userName" , consult_user_userName);
			mv.addObject ("consult_content" , consult_content);
			return mv;
		}

	@SecurityMapping(title = "咨询删除" , value = "/admin/consult_del.htm*" , rtype = "admin" , rname = "咨询管理" ,
						rcode = "consult_admin" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/consult_del.htm" })
	public String delete (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					Consult consult = this.consultService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.consultService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:consult_list.htm?currentPage=" + currentPage;
		}
}
