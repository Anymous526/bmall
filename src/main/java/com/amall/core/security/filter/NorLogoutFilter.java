package com.amall.core.security.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.ui.logout.LogoutFilter;
import org.springframework.security.ui.logout.LogoutHandler;
import com.amall.core.bean.LoginSessionExample;
import com.amall.core.bean.SysLog;
import com.amall.core.bean.User;
import com.amall.core.service.loginsession.ILoginSessionService;
import com.amall.core.service.system.ISysLogService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;

public class NorLogoutFilter extends LogoutFilter
{

	@Autowired
	private ISysLogService sysLogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ILoginSessionService loginSessionService;

	public void saveLog (HttpServletRequest request)
		{
			HttpSession session = request.getSession (false);
			User u = (User) session.getAttribute ("user");
			if (u != null)
			{
				User user = this.userService.getByKey (u.getId ());
				user.setLastlogindate ((Date) session.getAttribute ("lastLoginDate"));
				user.setLastloginip ((String) session.getAttribute ("loginIp"));
				this.userService.updateByObject (user);
				SysLog log = new SysLog ();
				log.setAddtime (new Date ());
				log.setContent (user.getTruename () + "于" + CommUtil.formatTime ("yyyy-MM-dd HH:mm:ss" , new Date ()) + "退出系统");
				log.setTitle ("用户退出");
				log.setType (0);
				log.setUser (user);
				log.setIp (CommUtil.getIpAddr (request));
				this.sysLogService.add (log);
			}
		}

	/**
	 * @Title: loginSessionTableDel
	 * @Description: 用户退出时删除loginsession表记录
	 * @param request
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月11日
	 */
	private void loginSessionTableDel (HttpServletRequest request)
		{
			HttpSession session = request.getSession (false);
			User u = (User) session.getAttribute ("user");
			if (u != null)
			{
				LoginSessionExample example = new LoginSessionExample ();
				example.createCriteria ().andUsernameEqualTo (u.getUsername ()).andSystemTypeEqualTo ("amall_PC");
				loginSessionService.deleteByExample (example);
			}
		}

	public NorLogoutFilter (String logoutSuccessUrl , LogoutHandler [ ] handlers)
	{
		super (logoutSuccessUrl , handlers);
	}

	public void doFilterHttp (HttpServletRequest request , HttpServletResponse response , FilterChain chain) throws IOException , ServletException
		{
			if (requiresLogout (request , response))
			{
				HttpSession session = request.getSession (false);
				if (session != null)
				{
					saveLog (request);
					// loginSessionTableDel(request);
				}
			}
			super.doFilterHttp (request , response , chain);
		}

	protected boolean requiresLogout (HttpServletRequest request , HttpServletResponse response)
		{
			return super.requiresLogout (request , response);
		}

	protected String determineTargetUrl (HttpServletRequest request , HttpServletResponse response)
		{
			return super.determineTargetUrl (request , response);
		}

	protected void sendRedirect (HttpServletRequest request , HttpServletResponse response , String url) throws IOException
		{
			super.sendRedirect (request , response , url);
		}

	public void setFilterProcessesUrl (String filterProcessesUrl)
		{
			super.setFilterProcessesUrl (filterProcessesUrl);
		}

	protected String getLogoutSuccessUrl ( )
		{
			return super.getLogoutSuccessUrl ();
		}

	protected String getFilterProcessesUrl ( )
		{
			return super.getFilterProcessesUrl ();
		}

	public void setUseRelativeContext (boolean useRelativeContext)
		{
			super.setUseRelativeContext (useRelativeContext);
		}

	public int getOrder ( )
		{
			return super.getOrder ();
		}
}
