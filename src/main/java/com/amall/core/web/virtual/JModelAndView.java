package com.amall.core.web.virtual;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.SysConfig;
import com.amall.core.bean.UserConfig;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.HttpInclude;

public class JModelAndView extends ModelAndView {
	public JModelAndView(String viewName) {
		super.setViewName(viewName);
	}

	public final static String LOGIN_VIEW = "login.html";

	public final static String URI = "uri";

	public final static String PARAMETER = "parameter";

	// 设置站点域名
	public JModelAndView(String viewName, SysConfig config, UserConfig uconfig,
			HttpServletRequest request, HttpServletResponse response) {
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		String webPath = CommUtil.getURL(request);
		String port = ":"
				+ CommUtil.null2Int(Integer.valueOf(request.getServerPort()));
		if ((config.getSecondDomainOpen())
				&& (!CommUtil.generic_domain(request).equals("localhost"))) {
			webPath = "http://www." + CommUtil.generic_domain(request) + port
					+ contextPath;
		}
		super.setViewName(viewName);
		super.addObject("domainPath", CommUtil.generic_domain(request));
		// 判断图片服务器路径是否为空，不为空则设置为图片服务器，为空则设置为当前项目路径
		if ((config.getImagewebserver() != null)
				&& (!config.getImagewebserver().equals("")))
			super.addObject("imageWebServer", config.getImagewebserver());
		else {
			super.addObject("imageWebServer", webPath);
		}
		super.addObject("webPath", webPath);
		super.addObject("config", config);
		super.addObject("uconfig", uconfig);
		super.addObject("user", SecurityUserHolder.getCurrentUser());
		super.addObject("httpInclude", new HttpInclude(request, response));
		String query_url = "";
		if ((request.getQueryString() != null)
				&& (!request.getQueryString().equals(""))) {
			query_url = "?" + request.getQueryString();
		}
		super.addObject("current_url", request.getRequestURI() + query_url);
		boolean second_domain_view = false;
		String serverName = request.getServerName().toLowerCase();
		if ((serverName.indexOf("www.") < 0) && (serverName.indexOf(".") >= 0)
				&& (serverName.indexOf(".") != serverName.lastIndexOf("."))
				&& (config.getSecondDomainOpen())) {
			String secondDomain = serverName.substring(0,
					serverName.indexOf("."));
			second_domain_view = true;
			super.addObject("secondDomain", secondDomain);
		}
		super.addObject("second_domain_view",
				Boolean.valueOf(second_domain_view));
	}

	/**
	 * 
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 根据传入的不同数值 判断后 进行路径的不同设置，同时设置站点域名
	 * </p>
	 * 
	 * @param viewName
	 *            页面地址
	 * @param config
	 *            系统参数
	 * @param uconfig
	 *            用户信息
	 * @param type
	 *            指定参数设置不同的视图路径
	 * @param request
	 * @param response
	 */
	public JModelAndView(String viewName, SysConfig config, UserConfig uconfig,
			int type, HttpServletRequest request, HttpServletResponse response) {
		if (config.getSyslanguage() != null) {
			if (config.getSyslanguage().equals("zh_cn")) {
				// 根据传入的不同数值 判断后 进行路径的不同设置
				if (type == 0) {
					super.setViewName("templates/system/" + viewName);
				}
				if (type == 1) {
					super.setViewName("templates/shop/" + viewName);
				}
				if (type > 1)
					super.setViewName(viewName);
			} else {
				if (type == 0) {
					super.setViewName("/templates/" + config.getSyslanguage()
							+ "/system/" + viewName);
				}
				if (type == 1) {
					super.setViewName("/templates/" + config.getSyslanguage()
							+ "/shop/" + viewName);
				}
				if (type > 1)
					super.setViewName(viewName);
			}
		} else {
			super.setViewName(viewName);

		}
		super.addObject("CommUtil", new CommUtil());
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		String webPath = CommUtil.getURL(request); // 设置页面请求路径
		String port = ":"
				+ CommUtil.null2Int(Integer.valueOf(request.getServerPort()));
		if ((config.getSecondDomainOpen())
				&& (!CommUtil.generic_domain(request).equals("localhost"))) {
			webPath = "http://www." + CommUtil.generic_domain(request) + port
					+ contextPath;
		}
		super.addObject("domainPath", CommUtil.generic_domain(request));
		super.addObject("webPath", webPath);
		if ((config.getImagewebserver() != null) // 设置图片服务器
				&& (!config.getImagewebserver().equals("")))
			super.addObject("imageWebServer", config.getImagewebserver());
		else {
			super.addObject("imageWebServer", webPath);
		}
		super.addObject("config", config);
		super.addObject("uconfig", uconfig);
		super.addObject("user", SecurityUserHolder.getCurrentUser());
		super.addObject("httpInclude", new HttpInclude(request, response));
		String query_url = "";
		if ((request.getQueryString() != null)
				&& (!request.getQueryString().equals(""))) {
			query_url = "?" + request.getQueryString();
		}
		super.addObject("current_url", request.getRequestURI() + query_url);
		boolean second_domain_view = false; // 设置第二域名
		String serverName = request.getServerName().toLowerCase();
		if ((serverName.indexOf("www.") < 0) && (serverName.indexOf(".") >= 0)
				&& (serverName.indexOf(".") != serverName.lastIndexOf("."))
				&& (config.getSecondDomainOpen())) {
			String secondDomain = serverName.substring(0,
					serverName.indexOf("."));
			second_domain_view = true;
			super.addObject("secondDomain", secondDomain);
		}
		super.addObject("second_domain_view",
				Boolean.valueOf(second_domain_view));

		// 路径存储返回地址 。访问index.html 保存请求地址 。便于登陆后返回
		if (viewName.equals(LOGIN_VIEW)) {
			HttpSession session = request.getSession();
			session.setAttribute(URI, request.getRequestURL().toString());
			session.setAttribute(PARAMETER,
					parameters(request.getParameterMap()));
		}
	}

	private static String parameters(Map<String, String[]> para) {
		StringBuffer sb = new StringBuffer();
		if (null != para && null != para.keySet() && para.keySet().size() > 0) {
			sb.append("?");
			Set<String> keys = para.keySet();
			int size = keys.size();
			int index = 0;
			for (String key : keys) {
				sb.append(key);
				sb.append("=");
				sb.append(para.get(key)[0]);
				++index;
				if (index < size) {
					sb.append("&");
				}
			}
		}
		return sb.toString().replaceAll(" ","%20");
	}

	private static String url(String requestURI) {
		int i = requestURI.indexOf("/", 2);
		return requestURI.substring(i);
	}

}
