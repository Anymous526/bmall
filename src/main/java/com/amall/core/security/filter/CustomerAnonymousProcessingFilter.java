package com.amall.core.security.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.ui.FilterChainOrder;
import org.springframework.security.ui.SpringSecurityFilter;
import org.springframework.security.userdetails.memory.UserAttribute;
import org.springframework.util.Assert;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;

public class CustomerAnonymousProcessingFilter extends SpringSecurityFilter implements InitializingBean
{

	private String key;

	private UserAttribute userAttribute;

	public int getOrder ( )
		{
			return FilterChainOrder.ANONYMOUS_FILTER;
		}

	public void afterPropertiesSet ( ) throws Exception
		{
			Assert.notNull (userAttribute);
			Assert.hasLength (key);
		}

	@Override
	protected void doFilterHttp (HttpServletRequest request , HttpServletResponse response , FilterChain chain) throws IOException , ServletException
		{
			HttpSession session = request.getSession (true);
			User user = SecurityUserHolder.getCurrentUser ();
			String url = request.getRequestURI ();
			if (url.indexOf ("/admin") >= 0)// 如果路径包含/admin
			{
				if (user == null)
				{
					// response.sendRedirect("login.htm");//绝对路径
					request.getRequestDispatcher ("login.htm").forward (request , response);
				}
				else
				{
					if (!user.getUserrole ().equals ("ADMIN") && !user.getUserrole ().equals ("ADMIN_BUYER_SELLER"))// 管理员也可以开店，应该也可以登录
					{
						// response.sendRedirect("login.htm");//绝对路径
						request.getRequestDispatcher ("login.htm").forward (request , response);
					}
					else
					{
						chain.doFilter (request , response);
					}
				}
			}
			else
			{
				chain.doFilter (request , response);
			}
		}

	public String getKey ( )
		{
			return key;
		}

	public void setKey (String key)
		{
			this.key = key;
		}

	public UserAttribute getUserAttribute ( )
		{
			return userAttribute;
		}

	public void setUserAttribute (UserAttribute userAttribute)
		{
			this.userAttribute = userAttribute;
		}
}
