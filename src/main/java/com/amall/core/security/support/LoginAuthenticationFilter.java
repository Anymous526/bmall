package com.amall.core.security.support;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;
import org.springframework.security.util.TextUtils;
import com.amall.common.constant.Globals;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.ucapi.UCClient;
import com.amall.core.web.ucapi.XMLHelper;

/**
 * 
 * <p>
 * Title: LoginAuthenticationFilter
 * </p>
 * <p>
 * Description: 自定义的登陆验证过滤器
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28上午10:16:02
 * @version 1.0
 */
public class LoginAuthenticationFilter extends AuthenticationProcessingFilter
{

	@Autowired
	private ISysConfigService configService;

	public Authentication attemptAuthentication (HttpServletRequest request) throws AuthenticationException
		{
			String login_role = request.getParameter ("login_role");   // 获得登录角色
			HttpSession session = request.getSession ();
			String username;
			String type = request.getParameter ("type");
			String cookieName = null;
			boolean flag = true;           // 判断验证码
			boolean autoFlag = false;           // 判断是否自动登录
			String fromzhibo = request.getParameter ("fromzhibo");           // 是否来自直播ajax登录
			if (fromzhibo == null || !fromzhibo.equals ("1"))
				if (session.getAttribute ("verify_code") != null)
				{
					String code = request.getParameter ("code") != null ? request.getParameter ("code").toUpperCase () : "";
					code = code.toUpperCase();
					if (!session.getAttribute ("verify_code").equals (code))
					{
						flag = false;
						System.out.println("code: " + code);
					}
				}
			if (!StringUtils.isEmpty (type))
			{
				if ("wx".equals (type))
				{
					session.setAttribute ("type" , type);
				}
			}
			if ((login_role == null) || (login_role.equals ("")))
			{
				// 设置为user
				login_role = "user";
				username = obtainUsername (request);
			}
			if (!flag)
			{
				username = obtainUsername (request);
				String password = "";
				username = username.trim ();
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken (username , password);
				if ((session != null) || (getAllowSessionCreation ()))
				{
					request.getSession ().setMaxInactiveInterval (Globals.SESSION_EXCEED);// 设置Session会话的超时时间
					request.getSession ().setAttribute ("SPRING_SECURITY_LAST_USERNAME" , TextUtils.escapeEntities (username));
				}
				setDetails (request , authRequest);
				return getAuthenticationManager ().authenticate (authRequest);
			}
			session.setMaxInactiveInterval (Globals.SESSION_EXCEED);// 设置当前Session会话的失效时间
			session.setAttribute ("login_role" , login_role);           // 设置登录角色
			session.setAttribute ("ajax_login" , Boolean.valueOf (CommUtil    // 设置是否是ajax登录
			.null2Boolean (request.getParameter ("ajax_login"))));
			username = "";
			if (CommUtil.null2Boolean (request.getParameter ("encode")))
				username = CommUtil.decode (obtainUsername (request)) + "," + login_role;
			else
				username = obtainUsername (request) + "," + login_role;
			String password = obtainPassword (request);
			if (this.configService.getSysConfig ().getUcBbs ())
			{
				String uc_login_js = uc_Login (CommUtil.decode (obtainUsername (request)) , password);
				request.getSession (false).setAttribute ("uc_login_js" , uc_login_js);
			}
			username = username.trim ();
			// 判断是否是自动登录情况
			if (autoFlag)
			{
				username = cookieName;
				password = " ";
			}
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken (username , password);
			if ((session != null) || (getAllowSessionCreation ()))
			{
				request.getSession ().setMaxInactiveInterval (Globals.SESSION_EXCEED);// 设置Session会话的超时时间
				request.getSession ().setAttribute ("SPRING_SECURITY_LAST_USERNAME" , TextUtils.escapeEntities (username));
			}
			setDetails (request , authRequest);
			return getAuthenticationManager ().authenticate (authRequest);
		}

	protected void onSuccessfulAuthentication (HttpServletRequest request , HttpServletResponse response , Authentication authResult) throws IOException
		{
			request.getSession (false).removeAttribute ("verify_code");
			super.onSuccessfulAuthentication (request , response , authResult);
		}

	protected void onUnsuccessfulAuthentication (HttpServletRequest request , HttpServletResponse response , AuthenticationException failed) throws IOException
		{
//			String uri = request.getRequestURI ();
			super.onUnsuccessfulAuthentication (request , response , failed);
		}

	/**
	 * 
	 * <p>
	 * Title: uc_Login
	 * </p>
	 * <p>
	 * Description: 设置和获得用户中心网站所有头部内容
	 * </p>
	 * 
	 * @param username
	 * @param pws
	 * @return
	 */
	private static String uc_Login (String username , String pws)
		{
			String ucsynlogin = "";
			UCClient e = new UCClient ();
			String result = e.uc_user_login (username , pws);
			LinkedList <String> rs = XMLHelper.uc_unserialize (result);
			if (rs.size () > 0)
			{
				int uid = Integer.parseInt ((String) rs.get (0));  // 用户id
//				String uname = (String) rs.get (1);  // 用户名
//				String password = (String) rs.get (2);  // 用户密码
//				String email = (String) rs.get (3);   // email
				if (uid > 0)
				{
					ucsynlogin = e.uc_user_synlogin (uid);    // 将用户id放入 网站头中， 并获得头所有头部内容
				}
				else if (uid == -1)
				{
					System.out.println ("用户不存在,或者被删除");
				}
			}
			return ucsynlogin;
		}
}
