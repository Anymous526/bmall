package com.amall.core.action.admin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.encryption.EncryptionTools;
import com.amall.core.action.buyer.BaseBuyerAction;
import com.amall.core.action.seller.BaseSellerAction;
import com.amall.core.action.view.CartAndOrderFormViewAction;
import com.amall.core.bean.Res;
import com.amall.core.bean.ResExample;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.RoleGroup;
import com.amall.core.bean.RoleGroupExample;
import com.amall.core.bean.SysLogExample;
import com.amall.core.bean.User;
import com.amall.core.bean.User2Role;
import com.amall.core.bean.User2RoleExample;
import com.amall.core.bean.UserExample;
import com.amall.core.security.SecurityManager;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEasemobUserService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.privilege.IResService;
import com.amall.core.service.privilege.IRoleGroupService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.privilege.IUser2RoleService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.system.ISysLogService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.Md5Encrypt;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: AdminManageAction
 * </p>
 * <p>
 * Description: 管理员crud 及密码修改和保存管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午11:06:22
 * @version 1.0
 */
@Controller
public class AdminManageAction implements ServletContextAware
{

	private ServletContext servletContext;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IRoleGroupService roleGroupService;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	SecurityManager securityManager;

	@Autowired
	private IResService resService;

	@Autowired
	private ISysLogService sysLogService;

	@Autowired
	private IUser2RoleService user2RoleService;

	@Autowired
	private IEasemobUserService easemobUserService;

	@SecurityMapping(title = "管理员列表" , value = "/admin/admin_list.htm*" , rtype = "admin" , rname = "管理员管理" ,
						rcode = "admin_manage" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_list.htm" })
	public ModelAndView admin_list (String currentPage , String orderBy , String orderType , HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/admin_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			userExample.setPageSize (8);
			userExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , User.class , mv);
			UserExample.Criteria userCriteria1 = userExample.createCriteria ();
			UserExample.Criteria userCriteria2 = userExample.createCriteria ();
			userCriteria1.andUserroleEqualTo ("ADMIN");
			userCriteria2.andUserroleEqualTo ("ADMIN_BUYER_SELLER");
			userExample.or (userCriteria2);
			Pagination pList = userService.getObjectListWithPage (userExample);
			/*
			 * uqo.addQuery("obj.userRole", new SysMap("userRole", "ADMIN"), "=");
			 * uqo.addQuery("obj.userRole", new SysMap("userRole1",
			 * "ADMIN_BUYER_SELLER"), "=", "or"); IPageList pList =
			 * this.userService.list(uqo);
			 */
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/admin/admin_list.htm" , "" , "" , pList , mv);
			mv.addObject ("userRole" , "ADMIN");
			return mv;
		}

	@SecurityMapping(title = "管理员添加" , value = "/admin/admin_add.htm*" , rtype = "admin" , rname = "管理员管理" ,
						rcode = "admin_manage" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_add.htm" })
	public ModelAndView admin_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/admin_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			RoleGroupExample roleGroupExample = new RoleGroupExample ();
			roleGroupExample.clear ();
			roleGroupExample.createCriteria ().andTypeEqualTo ("ADMIN");
			roleGroupExample.setOrderByClause ("sequence asc");
			List <RoleGroup> rgs = roleGroupService.getObjectList (roleGroupExample);
			RoleExample roleExample = new RoleExample ();
			for (RoleGroup roleGroup : rgs)
			{
				roleExample.clear ();
				roleExample.createCriteria ().andRgIdEqualTo (roleGroup.getId ());
				List <Role> roles = roleService.getObjectList (roleExample);
				roleGroup.setRoles (roles);
			}
			mv.addObject ("rgs" , rgs);
			mv.addObject ("op" , "admin_add");
			return mv;
		}

	@SecurityMapping(title = "管理员编辑" , value = "/admin/admin_edit.htm*" , rtype = "admin" , rname = "管理员管理" ,
						rcode = "admin_manage" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_edit.htm" })
	public ModelAndView admin_edit (HttpServletRequest request , HttpServletResponse response , String id , String op)
		{
			ModelAndView mv = new JModelAndView ("admin/admin_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			User user = null;
			if ((id != null) && (!id.equals ("")))
			{
				user = this.userService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , user);
				RoleGroupExample roleGroupExample = new RoleGroupExample ();
				roleGroupExample.clear ();
				roleGroupExample.createCriteria ().andTypeEqualTo ("ADMIN");
				roleGroupExample.setOrderByClause ("sequence asc");
				List <RoleGroup> rgs = roleGroupService.getObjectList (roleGroupExample);
				RoleExample roleExample = new RoleExample ();
				for (RoleGroup roleGroup : rgs)
				{
					roleExample.clear ();
					roleExample.createCriteria ().andRgIdEqualTo (roleGroup.getId ());
					List <Role> roles = roleService.getObjectList (roleExample);
					roleGroup.setRoles (roles);
				}
				// 为user设置roles集合
				user.setRoles (this.roleService.getRolesToUserByUserIdAndDisplay (user.getId ()));
				mv.addObject ("rgs" , rgs);
				mv.addObject ("op" , op);
			}
			return mv;
		}

	// id 被编辑的用户id
	@SecurityMapping(title = "管理员保存" , value = "/admin/admin_add.htm*" , rtype = "admin" , rname = "管理员管理" ,
						rcode = "admin_manage" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_save.htm" })
	public ModelAndView admin_save (HttpServletRequest request , HttpServletResponse response , String id , String role_ids , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			User user = null;
			if (id.equals (""))
			{
				user = (User) wf.toPo (request , User.class);
				user.setAddtime (new Date ());
			}
			else
			{
				User u = this.userService.getByKey (Long.valueOf (Long.parseLong (id)));
				user = (User) wf.toPo (request , u);
				User2RoleExample user2RoleExample = new User2RoleExample (); // 根据用户id
																				// 删除中间表权限
				user2RoleExample.clear ();
				user2RoleExample.createCriteria ().andUserIdEqualTo (Long.valueOf (Long.parseLong (id)));
				user2RoleService.deleteByExample (user2RoleExample);
			}
			if ((user.getPassword () == null) || (user.getPassword ().equals ("")))
			{
				user.setPassword ("123456");
				user.setPassword (EncryptionTools.pwdSHA2Sign (user.getPassword ()));
			}
			else if (id.equals (""))
			{
				user.setPassword (user.getPassword ());
			}
			user.getRoles ().clear ();
			List <Role> roles = new ArrayList <Role> ();
			if (user.getUserrole ().equalsIgnoreCase ("ADMIN"))
			{
				RoleExample roleExample = new RoleExample ();
				roleExample.clear ();
				roleExample.createCriteria ().andDisplayEqualTo (Boolean.valueOf (false)).andTypeEqualTo ("ADMIN");
				RoleExample roleExample1 = new RoleExample ();
				roleExample1.clear ();
				RoleExample.Criteria roleCriteria = roleExample1.createCriteria ().andTypeEqualTo ("BUYER");
				roleExample.or (roleCriteria);
				roles = roleService.getObjectList (roleExample);
				user.getRoles ().addAll (roles);
			}
			if (id.equals (""))
			{
				this.userService.add (user);
			}
			else
			{
				this.userService.updateByObject (user);
			}
			String [ ] rids = role_ids.split (",");
			User2Role u2r = new User2Role ();
			for (String rid : rids)
			{ // 添加对应关系到中间表
				if (!rid.equals (""))
				{
					Role role = this.roleService.getByKey (Long.valueOf (Long.parseLong (rid)));
					user.getRoles ().add (role);
					u2r.setUserId (user.getId ());
					u2r.setRoleId (role.getId ());
					user2RoleService.add (u2r);
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存管理员成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "管理员删除" , value = "/admin/admin_del.htm*" , rtype = "admin" , rname = "管理员管理" ,
						rcode = "admin_manage" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_del.htm" })
	public String admin_del (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					User user = this.userService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (!user.getUsername ().equals ("admin"))
					{
						/*
						 * this.databaseTools
						 * .execute("delete from amall_syslog where user_id=" + id);
						 * this.databaseTools.execute(
						 * "delete from amall_user_role where user_id=" + id);
						 */
						SysLogExample sysLogExample = new SysLogExample ();
						sysLogExample.clear ();
						sysLogExample.createCriteria ().andUserIdEqualTo (Long.parseLong (id));
						sysLogService.deleteByExample (sysLogExample);
						User2RoleExample user2RoleExample = new User2RoleExample ();
						user2RoleExample.clear ();
						user2RoleExample.createCriteria ().andUserIdEqualTo (Long.parseLong (id));
						user2RoleService.deleteByExample (user2RoleExample);
						this.userService.deleteByKey (user.getId ());
					}
				}
			}
			return "redirect:admin_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "管理员修改密码" , value = "/admin/admin_pws.htm*" , rtype = "admin" , rname = "商城后台管理" ,
						rcode = "admin_index" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_pws.htm" })
	public ModelAndView admin_pws (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/admin_pws.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			return mv;
		}

	@SecurityMapping(title = "管理员密码保存" , value = "/admin/admin_pws_add.htm*" , rtype = "admin" , rname = "商城后台管理" ,
						rcode = "admin_index" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/admin_pws_add.htm" })
	public ModelAndView admin_pws_add (HttpServletRequest request , HttpServletResponse response , String old_password , String password)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (Md5Encrypt.md5 (old_password).toLowerCase ().equals (user.getPassword ()))
			{
				user.setPassword (Md5Encrypt.md5 (password).toLowerCase ());
				this.userService.updateByObject (user);
				mv.addObject ("op_title" , "修改密码成功");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "原密码错误");
			}
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/admin_pws.htm");
			return mv;
		}

	@RequestMapping({ "/admin/init_role.htm" })
	public String init_role ( )
		{
			User current_user = SecurityUserHolder.getCurrentUser ();
			if ((current_user != null) && (current_user.getUserrole ().indexOf ("ADMIN") >= 0) && (current_user.getUsername ().equals ("admin")))
			{
				RoleExample roleExample = new RoleExample ();
				/*
				 * this.databaseTools.execute("delete from amall_role_res");
				 * this.databaseTools.execute("delete from amall_res");
				 * this.databaseTools.execute("delete from amall_user_role");
				 * this.databaseTools.execute("delete from amall_role");
				 * this.databaseTools.execute("delete from amall_rolegroup");
				 */
				List <Class <? extends Object>> clzs = new ArrayList <Class <? extends Object>> ();
				clzs.add (BaseManageAction.class);
				clzs.add (BaseSellerAction.class);
				clzs.add (BaseBuyerAction.class);
				clzs.add (CartAndOrderFormViewAction.class);
				int sequence = 0;
				Annotation [ ] annotation;
				// Annotation tag;
				for (Class <? extends Object> clz : clzs)
				{
					try
					{
						Method [ ] ms = clz.getMethods ();
						for (Method m : ms)
						{
							annotation = m.getAnnotations ();
							for (Annotation tag1 : annotation)
							{
								if (SecurityMapping.class.isAssignableFrom (tag1.annotationType ()))
								{
									String value = ((SecurityMapping) tag1).value ();
									ResExample resExample = new ResExample ();
									resExample.clear ();
									resExample.createCriteria ().andValueEqualTo (value);
									List <Res> ress = resService.getObjectList (resExample);
									if (ress.size () == 0)
									{
										Res res = new Res ();
										res.setResname (((SecurityMapping) tag1).title ());
										res.setValue (value);
										res.setType ("URL");
										res.setAddtime (new Date ());
										this.resService.add (res);
										// String rname = ((SecurityMapping) tag1).rname ();
										String roleCode = ((SecurityMapping) tag1).rcode ();
										if (roleCode.indexOf ("ROLE_") != 0)
										{
											roleCode = ("ROLE_" + roleCode).toUpperCase ();
										}
										roleExample.clear ();
										roleExample.createCriteria ().andRolecodeEqualTo (roleCode);
										List <Role> roles = roleService.getObjectList (roleExample);
										Role role = null;
										if (roles.size () > 0)
										{
											role = (Role) roles.get (0);
										}
										if (role == null)
										{
											role = new Role ();
											role.setRolename (((SecurityMapping) tag1).rname ());
											role.setRolecode (roleCode.toUpperCase ());
										}
										role.getReses ().add (res);
										res.getRoles ().add (role);
										role.setAddtime (new Date ());
										role.setDisplay (((SecurityMapping) tag1).display ());
										role.setType (((SecurityMapping) tag1).rtype ().toUpperCase ());
										String groupName = ((SecurityMapping) tag1).rgroup ();
										RoleGroupExample roleGroupExample = new RoleGroupExample ();
										roleGroupExample.clear ();
										roleGroupExample.createCriteria ().andNameEqualTo (groupName);
										RoleGroup rg = null;
										List <RoleGroup> rgs = roleGroupService.getObjectList (roleGroupExample);
										if (null != rgs && rgs.size () > 0)
											rg = rgs.get (0);
										if (rg == null)
										{
											rg = new RoleGroup ();
											rg.setAddtime (new Date ());
											rg.setName (groupName);
											rg.setSequence (sequence);
											rg.setType (role.getType ());
											this.roleGroupService.add (rg);
										}
										role.setRg (rg);
										this.roleService.add (role);
									}
								}
							}
						}
					}
					catch (Exception e)
					{
						e.printStackTrace ();
					}
					sequence++;
				}
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo ("admin");
				User user = null;
				List <User> users = userService.getObjectList (userExample);
				if (null != users && users.size () > 0)
					user = users.get (0);
				roleExample.clear ();
				roleExample.setOrderByClause ("addTime desc");
				List <Role> roles = roleService.getObjectList (roleExample);
				if (user == null)
				{
					user = new User ();
					user.setUsername ("admin");
					user.setUserrole ("ADMIN");
					user.setPassword (Md5Encrypt.md5 ("123456").toLowerCase ());
					for (Role role : roles)
					{
						if (!role.getType ().equalsIgnoreCase ("SELLER"))
						{
							user.getRoles ().add (role);
						}
					}
					this.userService.add (user);
				}
				else
				{
					for (Role role : roles)
					{
						if (!role.getType ().equals ("SELLER"))
						{
							System.out.println (role.getRolename () + " " + role.getType () + " " + role.getRolecode ());
							user.getRoles ().add (role);
						}
					}
					this.userService.updateByObject (user);
				}
				roleExample.clear ();
				roleExample.createCriteria ().andDisplayEqualTo (Boolean.valueOf (false)).andTypeEqualTo ("ADMIN");
				List <Role> admin_roles = roleService.getObjectList (roleExample);
				roleExample.clear ();
				roleExample.createCriteria ().andTypeEqualTo ("BUYER");
				List <Role> buyer_roles = roleService.getObjectList (roleExample);
				userExample.clear ();
				userExample.createCriteria ().andUserroleEqualTo ("ADMIN").andUsernameEqualTo ("admin");
				List <User> admins = userService.getObjectList (userExample);
				for (User admin : admins)
				{
					admin.getRoles ().addAll (admin_roles);
					admin.getRoles ().addAll (buyer_roles);
					this.userService.updateByObject (admin);
				}
				userExample.clear ();
				userExample.createCriteria ().andUserroleEqualTo ("BUYER");
				List <User> buyers = userService.getObjectList (userExample);
				for (User buyer : buyers)
				{
					buyer.getRoles ().addAll (buyer_roles);
					this.userService.updateByObject (buyer);
				}
				roleExample.clear ();
				// RoleExample.Criteria roleCriteria1 = roleExample.createCriteria ().andTypeEqualTo
				// ("BUYER");
				RoleExample.Criteria roleCriteria2 = roleExample.createCriteria ().andTypeEqualTo ("SELLER");
				roleExample.or (roleCriteria2);
				List <Role> seller_roles = roleService.getObjectList (roleExample);
				userExample.clear ();
				// UserExample.Criteria userCriteria1 = userExample.createCriteria
				// ().andUsernameEqualTo ("admin");
				UserExample.Criteria userCriteria2 = userExample.createCriteria ().andUserroleEqualTo ("BUYER_SELLER");
				UserExample.Criteria userCriteria3 = userExample.createCriteria ().andUserroleEqualTo ("ADMIN_BUYER_SELLER");
				UserExample.Criteria userCriteria4 = userExample.createCriteria ().andUserroleEqualTo ("ADMIN");
				userExample.or (userCriteria2);
				userExample.or (userCriteria3);
				userExample.or (userCriteria4);
				List <User> sellers = userService.getObjectList (userExample);
				/*
				 * ((Map) params).clear(); ((Map) params).put("userRole1",
				 * "BUYER_SELLER"); ((Map) params).put("userRole2",
				 * "ADMIN_BUYER_SELLER"); ((Map) params).put("userRole3", "ADMIN");
				 * ((Map) params).put("userName", "admin"); List<User> sellers =
				 * this.userService .query(
				 * "select obj from User obj where (obj.userRole=:userRole1 or obj.userRole=:userRole2 or obj.userRole=:userRole3) and obj.userName!=:userName "
				 * , (Map) params, -1, -1);
				 */
				for (User seller : sellers)
				{
					seller.getRoles ().addAll (buyer_roles);
					seller.getRoles ().addAll (seller_roles);
					this.userService.updateByObject (seller);
				}
				Map <String, String> urlAuthorities = this.securityManager.loadUrlAuthorities ();
				this.servletContext.setAttribute ("urlAuthorities" , urlAuthorities);
				return "redirect:admin_list.htm";
			}
			return (String) "redirect:login.htm";
		}

	public void setServletContext (ServletContext servletContext)
		{
			this.servletContext = servletContext;
		}
	// /**
	// * im搜索用户(暂时注释。 后续补上功能)
	// * @param request
	// * @param response
	// * @param username
	// * @return
	// */
	// @RequestMapping(value=
	// "/admin/searchUser.htm",method=org.springframework.web.bind.annotation.RequestMethod.GET)
	// @ResponseBody
	// public String seacrh_User(HttpServletRequest request,
	// HttpServletResponse response, String username) {
	// User current_user = SecurityUserHolder.getCurrentUser();
	// Map<String, Object> message = new HashMap<String, Object>();
	// String messageKey = "message";
	// if (null == current_user) {
	// message.put(messageKey, "当前登录已失效 ,请重新登录!");
	// return Json.toJson(message);
	// }
	// if (StringUtils.isEmpty(username)) {
	// message.put(messageKey, "参数无效");
	// return Json.toJson(message);
	// }
	// UserExample userExample = new UserExample();
	// userExample.createCriteria().andUsernameEqualTo(username);
	// List<User> users = userService.getObjectList(userExample);
	// if (null == users || users.size() == 0) {
	// message.put(messageKey, "没有此用户");
	// return Json.toJson(message);
	// }
	// User user = users.get(0);
	// message.put("truename", user.getTruename());
	// EasemobUser euser = easemobUserService.getUser(user.getId());
	// if (null != euser) {
	// message.put("username", euser.getusername());
	// message.put("nickname", euser.getNickname());
	// }else{
	// message.put(messageKey, "此用户还未注册聊天功能");
	// }
	// return Json.toJson(message);
	// }
}
