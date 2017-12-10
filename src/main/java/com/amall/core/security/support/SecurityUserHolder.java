package com.amall.core.security.support;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.amall.core.bean.User;
import com.amall.core.dao.UserMapper;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ServiceLocator;

/**
 * 
 * <p>
 * Title: SecurityUserHolder
 * </p>
 * <p>
 * Description: 获取当前用户工具类
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:46:39
 * @version 1.0
 */
public class SecurityUserHolder
{

	/**
	 * 
	 * <p>
	 * Title: getCurrentUser
	 * </p>
	 * <p>
	 * Description: 获得当前用户
	 * </p>
	 * 
	 * @return
	 */
	public static User getCurrentUser ( )
		{
			if (SecurityContextHolder.getContext ().getAuthentication () != null)
			{
				if ((SecurityContextHolder.getContext ().getAuthentication ().getPrincipal () instanceof User))
				{
					User user = (User) SecurityContextHolder.getContext ().getAuthentication ().getPrincipal ();
					UserMapper userMapper = (UserMapper) ServiceLocator.getBean ("userMapper");
					return userMapper.selectByPrimaryKey (user.getId ());
				}
			}
			return null;
		}

	/**
	 * 
	 * <p>
	 * Title: getCurrentUser
	 * </p>
	 * <p>
	 * Description: 获得当前管理员用户
	 * </p>
	 * 
	 * @return
	 */
	public static User getCurrentAdminUser ( )
		{
			if (SecurityContextHolder.getContext ().getAuthentication () != null)
			{
				if ((SecurityContextHolder.getContext ().getAuthentication ().getPrincipal () instanceof User))
				{
					return (User) SecurityContextHolder.getContext ().getAuthentication ().getPrincipal ();
				}
			}
			User user = null;
			if (RequestContextHolder.getRequestAttributes () != null)
			{
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes ()).getRequest ();
				user = request.getSession (false).getAttribute ("adminUser") != null ? (User) request.getSession (false).getAttribute ("adminUser") : null;
				Cookie [ ] cookies = request.getCookies ();
				String id = "";
				if (cookies != null)
				{
					for (Cookie cookie : cookies)
					{
						if (cookie.getName ().equals ("user_session"))
						{
							id = CommUtil.null2String (cookie.getValue ());
						}
					}
				}
				if (id.equals (""))
				{
					user = null;
				}
			}
			return user;
		}
}
