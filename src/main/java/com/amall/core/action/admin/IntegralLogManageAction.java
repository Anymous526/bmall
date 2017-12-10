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
import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.IntegralLogExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class IntegralLogManageAction
{
	private Logger logger=Logger.getLogger (IntegralLogManageAction.class);
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IIntegralLogService integrallogService;

	@Autowired
	private IUserService userService;

	@SecurityMapping(title = "积分明细" , value = "/admin/integrallog_list.htm*" , rtype = "admin" , rname = "积分明细" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integrallog_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String userName)
		{
			ModelAndView mv = new JModelAndView ("admin/integrallog_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			IntegralLogExample integralLogExample = new IntegralLogExample ();
			integralLogExample.clear ();
			IntegralLogExample.Criteria integralLogCriteria = integralLogExample.createCriteria ();
			integralLogExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			integralLogExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			UserExample userExample = new UserExample ();
			userExample.clear ();
			if ((userName != null) && (!userName.equals ("")))
				userExample.createCriteria ().andUsernameLike ("%" + userName + "%");
			List <User> users = userService.getObjectList (userExample);
			List <Long> userIds = new ArrayList <Long> ();
			for (User user2 : users)
			{
				userIds.add (user2.getId ());
			}
			if (userIds != null && userIds.size () > 0)
			{
				integralLogCriteria.andIntegralUserIdIn (userIds);
			}
			else
			{
				integralLogCriteria.andIntegralUserIdIsNull ();
			}
			Pagination pList = this.integrallogService.getObjectListWithPage (integralLogExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/integrallog_list.htm" , "" , "&userName=" + CommUtil.null2String (userName) , pList , mv);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: user_integral
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "积分管理" , value = "/admin/user_integral.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_integral.htm" })
	public ModelAndView user_integral (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/user_integral.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			if (!config.getIntegral ())
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分功能，设置失败");
				mv.addObject ("open_url" , "admin/operation_base_set.htm");
				mv.addObject ("open_op" , "积分开启");
				mv.addObject ("open_mark" , "operation_base_op");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/welcome.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "积分动态获取" , value = "/admin/verify_user_integral.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/verify_user_integral.htm" })
	public void verify_user_integral (HttpServletRequest request , HttpServletResponse response , String userName)
		{
			User user = null;
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = userService.getObjectList (userExample);
			if (users != null && users.size () > 0)
				user = users.get (0);
			int ret = -1;
			if (user != null)
			{
				ret = user.getIntegral ();
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

	@SecurityMapping(title = "积分管理保存" , value = "/admin/user_integral_save.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_integral_save.htm" })
	public ModelAndView user_integral_save (HttpServletRequest request , HttpServletResponse response , String userName , String operate_type , String integral , String content)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = userService.getObjectList (userExample);
			User user = null;
			if (users != null && users.size () > 0)
			{
				user = users.get (0);
			}
			if (user != null)
			{
				if (operate_type.equals ("add"))
				{
					user.setIntegral (user.getIntegral () + CommUtil.null2Int (integral));
				}
				else if (user.getIntegral () > CommUtil.null2Int (integral))
					user.setIntegral (user.getIntegral () - CommUtil.null2Int (integral));
				else
				{
					user.setIntegral (0);
				}
				this.userService.updateByObject (user);
				IntegralLog log = new IntegralLog ();
				log.setAddtime (new Date ());
				log.setContent (content);
				if (operate_type.equals ("add"))
					log.setIntegral (CommUtil.null2Int (integral));
				else
				{
					log.setIntegral (-CommUtil.null2Int (integral));
				}
				// log.setOperate_user(SecurityUserHolder.getCurrentUser());
				// log.setIntegral_user(user);
				log.setOperateUserId (SecurityUserHolder.getCurrentUser ().getId ());
				log.setIntegralUserId (user.getId ());
				log.setType ("system");
				this.integrallogService.add (log);
				mv.addObject ("op_title" , "操作用户积分成功");
			}
			else
			{
				mv.addObject ("op_title" , "操作用户积分失败，会员" + userName + "不存在");
			}
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/user_integral.htm");
			return mv;
		}
}
