package com.amall.core.action.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class UserViewAction
{

	Logger logger = Logger.getLogger (UserViewAction.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	/***
	 * 修改密码，找回密码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/modifypwd.htm" })
	public ModelAndView modify (HttpServletRequest request , HttpServletResponse response , String set_compwd , String oldPwd)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			ModelAndView mv = null;
			if (oldPwd != null && !oldPwd.equals (""))
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				// 进入修改密码判断
				String decryptionPassword = oldPwd;
				String pwds = user.getPayPassword ();
				if (!decryptionPassword.equals (pwds))
				{
					mv.addObject ("op_title" , "原始密码错误");	// 密码不一致
					mv.addObject ("url" , CommUtil.getURL (request));
					return mv;
				}
			}
			else
			{
				mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				User user2 = new User ();
				user2.setId (user.getId ());
				String newPassword = set_compwd;
				user2.setPayPassword (newPassword);
				userService.updateUsers (user2);
				mv.addObject ("op_title" , "密码设置成功");	// 密码设置成功
				mv.addObject ("url" , CommUtil.getURL (request));
				return mv;
			}
			return mv;
		}
}
