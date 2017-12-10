package com.amall.core.security.support;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//
//import com.amall.core.bean.LoginSessionExample;
//import com.amall.core.bean.User;
//import com.amall.core.service.loginsession.ILoginSessionService;
//import com.amall.core.web.tools.ServiceLocator;

public class SessionListener implements HttpSessionListener
{
	
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
//		loginSessionTableDel((User)se.getSession().getAttribute("user"));
	}
}
