package com.amall.core.web.loader;

import com.amall.core.security.SecurityManager;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * <p>Title: ServletContextLoaderListener</p>
 * <p>Description:  自定义的ServletContext 加载监听器 ，将当前的所有URL放入上下文中</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27上午12:45:23
 * @version 1.0
 */
public class ServletContextLoaderListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		SecurityManager securityManager = getSecurityManager(servletContext);
		@SuppressWarnings("rawtypes")
		Map urlAuthorities = securityManager.loadUrlAuthorities();
		servletContext.setAttribute("urlAuthorities", urlAuthorities);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().removeAttribute(
				"urlAuthorities");
	}

	protected SecurityManager getSecurityManager(ServletContext servletContext) {
		return (SecurityManager) WebApplicationContextUtils
				.getWebApplicationContext(servletContext).getBean(
						"securityManager");
	}
}
