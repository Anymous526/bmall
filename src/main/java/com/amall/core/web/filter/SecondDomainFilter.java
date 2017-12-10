package com.amall.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.User;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;


/**
 * 
 * <p>Title: SecondDomainFilter</p>
 * <p>Description: </p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015年5月16日下午6:04:10
 * @version 1.0
 */
@Component
public class SecondDomainFilter implements Filter {

	@Autowired
	private IUserService userService;

	@Autowired
	private ISysConfigService configService;

	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (this.configService.getSysConfig().getSecondDomainOpen()) {
			Cookie[] cookies = request.getCookies();
			String id = "";
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("user_session")) {
						id = CommUtil.null2String(cookie.getValue());
					}
				}
				User user = this.userService.getByKey(CommUtil.null2Long(id));
				if (user != null)
					request.getSession(false).setAttribute("user", user);
			}
		}
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}
}
