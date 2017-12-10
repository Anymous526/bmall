package com.amall.core.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.sms.SendSMS;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class SMSSendAction
{

	@Autowired
	private SendSMS sendSMS;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@RequestMapping({ "/admin/send_dream_partner.htm" })
	@ResponseBody
	public String sendDreamPartner (HttpServletRequest request , HttpServletResponse response , String phone , String name)
		{
			if (StringUtils.isEmpty (phone) || StringUtils.isEmpty (name))
			{
				return "fail";
			}
			if (this.sendSMS.sendDreamRegMessage (phone , name))
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}

	@RequestMapping({ "/admin/send_sms.htm" })
	public ModelAndView send_sms (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/send_sms.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}
}
