package com.amall.core.security.support;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import com.amall.core.bean.Res;
import com.amall.core.bean.ResExample;
import com.amall.core.bean.Role;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.SecurityManager;
import com.amall.core.service.privilege.IResService;
import com.amall.core.service.user.IUserService;

public class SecurityManagerSupport extends SecurityManager implements UserDetailsService
{

	@Autowired
	private IUserService userService;

	@Autowired
	private IResService resService;

	public UserDetails loadUserByUsername (String data) throws UsernameNotFoundException , DataAccessException
		{
			String [ ] list = data.split (",");
			String userName = list[0];
			String loginRole = "user";
			if (list.length == 2)
			{
				loginRole = list[1];
			}
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = userService.getObjectList (userExample);
			if (users.isEmpty ())
			{
				throw new UsernameNotFoundException ("User " + userName + " has no GrantedAuthority");
			}
			User user = (User) users.get (0);
			Set <GrantedAuthority> authorities = new HashSet <GrantedAuthority> ();
			List <Role> roles = null;
			if (user != null)
			{
				Map <String, Long> map = new HashMap <String, Long> ();
				map.put ("id" , user.getId ());
				roles = userService.findRoleByUserId (map);
				for (Role role : roles)
				{
					if (role != null)
					{
						user.getRoles ().add (role);
					}
				}
			}
			if (null!=user && null != user.getRoles () && !user.getRoles ().isEmpty ())
			{
				Iterator <Role> roleIterator = user.getRoles ().iterator ();
				while (roleIterator.hasNext ())
				{
					Role role = (Role) roleIterator.next ();
					if (loginRole.equalsIgnoreCase ("ADMIN"))
					{
						GrantedAuthority grantedAuthority = new GrantedAuthorityImpl (role.getRolecode ().toUpperCase ());
						authorities.add (grantedAuthority);
					}
					else if (!role.getType ().equals ("ADMIN"))
					{
						GrantedAuthority grantedAuthority = new GrantedAuthorityImpl (role.getRolecode ().toUpperCase ());
						authorities.add (grantedAuthority);
					}
				}
			}
			GrantedAuthority [ ] auths = new GrantedAuthority [authorities.size ()];
			user.setAuthorities ((GrantedAuthority [ ]) authorities.toArray (auths));
			return user;
		}

	/**
	 * <p>
	 * Title: loadUrlAuthorities
	 * </p>
	 * <p>
	 * Description: 将URL 类型对应的权限 和 角色放入map集合中
	 * </p>
	 * 
	 * @return
	 */
	public Map <String, String> loadUrlAuthorities ( )
		{
			Map <String, String> urlAuthorities = new HashMap <String, String> ();
			ResExample resExample = new ResExample ();
			resExample.clear ();
			resExample.createCriteria ().andTypeEqualTo ("URL");
			List <Res> urlResources = resService.getObjectList (resExample);
			/*
			 * Map params = new HashMap();
			 * params.put("type", "URL");
			 * List<Res> urlResources = this.resService.query(
			 * "select obj from Res obj where obj.type = :type", params, -1,
			 * -1);
			 */
			for (Res res : urlResources)
			{
				urlAuthorities.put (res.getValue () , res.getRoleAuthorities ());
			}
			return urlAuthorities;
		}
}
