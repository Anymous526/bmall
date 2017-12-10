package com.amall.core.action.seller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Album;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.ISellerAccountService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 商家子账号管理
 * 
 * @ClassName: AccountSellerAction
 * @Description: 
 * @author lx
 * @date 2015年12月29日 下午3:40:15
 *
 */
@Controller
public class AccountSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISellerAccountService sellerAccountService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private IRoleService roleService;

	/**
	 * 商家子账号列表
	 * 
	 * @Title: seller_account_list
	 * @Description: 
	 * @param @param request
	 * @param @param response
	 * @param @param currentPage
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "/seller/seller_account_list.htm" })
	public ModelAndView seller_account_list (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_account_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				user = this.userService.getByKey (user.getId ());
				SellerAccountExample sellerAccountExample = new SellerAccountExample ();
				sellerAccountExample.createCriteria ().andBelongUserIdEqualTo (user.getId ()).andTypeEqualTo (Globals.SELLER_ACCOUNT_TYPE_PC);
				List <SellerAccount> list = this.sellerAccountService.getObjectList (sellerAccountExample);
				if (list != null && !list.isEmpty ())
				{
					mv.addObject ("objs" , list);
				}
			}
			return mv;
		}

	/**
	 * 子账号编辑页面跳转
	 * 
	 * @Title: seller_account_edit
	 * @Description: 
	 * @param @param request
	 * @param @param response
	 * @param @param id
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "/seller/seller_account_edit.htm" })
	public ModelAndView seller_account_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_account_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				// 如果ID不为空,则是编辑账号
				if (StringUtils.isNotEmpty (id))
				{
					SellerAccount sellerAccount = this.sellerAccountService.getByKey (Long.valueOf (id));
					mv.addObject ("obj" , sellerAccount);
				}
				else
				{
					// 新增账号,每个商家最多可有5个子账号,在每次新增之前统计下,处于正常状态的子账号的个数,如果子账号的个数>=5，则不能添加子账号了
					SellerAccountExample sellerAccountExample = new SellerAccountExample ();
					sellerAccountExample.createCriteria ().andBelongUserIdEqualTo (user.getId ()).andStatusEqualTo (Globals.NUBER_ONE);
					List <SellerAccount> listSellerAccount = this.sellerAccountService.getObjectList (sellerAccountExample);
					if (listSellerAccount != null && !listSellerAccount.isEmpty ())
					{
						int listSize = listSellerAccount.size ();
						if (listSize < Globals.SELLER_ACCOUNT_COUNT)
						{
							mv.addObject ("isAdd" , "1");
						}
						else
						{
							mv.addObject ("isAdd" , "0");
						}
					}
				}
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * 修改子账号状态
	 * 
	 * @Title: seller_account_upd
	 * @Description: 
	 * @param @param request
	 * @param @param response
	 * @param @param id
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "/seller/seller_account_upd.htm" })
	public String seller_account_upd (HttpServletRequest request , HttpServletResponse response , String id , String status)
		{
			if (StringUtils.isNotEmpty (id))
			{
				int statusVal = Integer.parseInt (status);
				SellerAccount sellerAccount = this.sellerAccountService.getByKey (Long.valueOf (id));
				User user = SecurityUserHolder.getCurrentUser ();
				if (user != null)
				{
					// 1.修改子账号属性数据
					User user1 = null;
					if (statusVal > 0)
					{
						// 子账号处于正常状态的总个数只能是5个,在启用子账号之前,要做判断，如果个数小于５，则该操作是允许的.
						SellerAccountExample sellerAccountExample = new SellerAccountExample ();
						sellerAccountExample.createCriteria ().andBelongUserIdEqualTo (user.getId ()).andStatusEqualTo (Globals.NUBER_ONE);
						List <SellerAccount> listSellerAccount = this.sellerAccountService.getObjectList (sellerAccountExample);
						int listSize = listSellerAccount.size ();
						if (listSize < Globals.SELLER_ACCOUNT_COUNT)
						{
							// 启用子账号(拥有商家属性)
							user1 = sellerAccount.getUser ();
							user1.setRoles (user.getRoles ());
							user1.setUserrole (user.getUserrole ());
							user1.setStoreId (user.getStoreId ());
						}
						else
						{
							// 该启用操作是不允许的
							return "redirect:seller_account_list.htm";
						}
					}
					else
					{
						// 禁用子账号(还原成普通会员)
						user1 = sellerAccount.getUser ();
						RoleExample example = new RoleExample ();
						example.createCriteria ().andTypeEqualTo ("BUYER");
						List <Role> roles = this.roleService.getObjectList (example);
						user1.setRoles (roles);
						user1.setUserrole ("BUYER");
						user1.setStoreId (null);
					}
					this.userService.updateByObject (user1);
					// 2.修改子账号状态
					sellerAccount.setStatus (Integer.parseInt (status));
					this.sellerAccountService.updateByObject (sellerAccount);
				}
				else
				{
					return "redirect:/amall_logout.htm";
				}
			}
			return "redirect:seller_account_list.htm";
		}

	/**
	 * 子账号保存
	 * 
	 * @Title: seller_account_save
	 * @Description: 
	 * @param @param request
	 * @param @param response
	 * @param @param id
	 * @param @param uname
	 * @param @param upwd
	 * @param @param res
	 * @param @param smscode
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping({ "/seller/seller_account_save.htm" })
	public String seller_account_save (HttpServletRequest request , HttpServletResponse response , String id , String uname , String upwd , String res , String smscode)
		{
//			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_account_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/* 编辑对象 */
			if (StringUtils.isNotEmpty (id))
			{
				SellerAccount sellerAccount = this.sellerAccountService.getByKey (Long.valueOf (id));
				// 设置新的资源权限
				sellerAccount.setResource (res);
				// 更新子账号资源权限
				this.sellerAccountService.updateByObject (sellerAccount);
			}
			else
			{ /* 新增对象 */
				// 判断短信是否过期和匹配
				String sessionCode = (String) request.getSession (false).getAttribute (Globals.SMS_CODE);
				/* 判断是否有发短信 */
				if (sessionCode == null || sessionCode.equals (""))
				{
					return "redirect:/amall_logout.htm";
				}
				String oldTime = (String) request.getSession (false).getAttribute (Globals.SMS_CODE_TIME);
				long interval = CommUtil.getTimeInterval (oldTime , String.valueOf (System.currentTimeMillis ()));
				int exceedTime = Integer.valueOf (this.configService.getSysConfig ().getSmsExceedTime ());
				long temp = exceedTime * Globals.SECOND_TO_MINUTE;
				if (!sessionCode.equals (smscode) || temp < interval)
				{
					return "redirect:/amall_logout.htm";
				}
				// 获取到当前用户
				User user = SecurityUserHolder.getCurrentUser ();
				if (user != null)
				{
					user = this.userService.getByKey (user.getId ());
					// 查询传递过来的用户名是否存在,如果存在,则直接修改用户状态,否则创建新用户,并且同步用户到分红系统
					UserExample userExample1 = new UserExample ();
					userExample1.createCriteria ().andUsernameEqualTo (uname).andDeletestatusEqualTo (false);
					List <User> list1 = this.userService.getObjectList (userExample1);
					User user1 = null;
					if (list1 != null && !list1.isEmpty ())
					{
						user1 = list1.get (Globals.NUBER_ZERO);
						user1.setRoles (user.getRoles ());
						user1.setUserrole (user.getUserrole ());
						user1.setStoreId (user.getStoreId ());
						this.userService.updateByObject (user1);
					}
					else
					{
						user1 = new User ();
						user1.setUsername (uname);
						user1.setPassword (upwd);
						// 拥有商家属性
						user1.setRoles (user.getRoles ());
						user1.setTruename (uname);
						// 天使会员等级V1
						user1.setLevelAngel (Globals.NUBER_ONE);
						user1.setUserrole (user.getUserrole ());
						user1.setSex (-1);
						user1.setStatus (Globals.NUBER_ZERO);
						// 不给予礼品金
						user1.setGold (Globals.NUBER_ZERO);
						user1.setAddtime (new Date ());
						user1.setStoreId (user.getStoreId ());
						// 先保存子账号
						this.userService.add (user1);
						UserExample userExample = new UserExample ();
						userExample.createCriteria ().andUsernameEqualTo (uname).andDeletestatusEqualTo (false);
						List <User> list = this.userService.getObjectList (userExample);
						if (list != null && !list.isEmpty ())
						{
							user1 = list.get (Globals.NUBER_ZERO);
						}
						Album album = new Album ();
						album.setAddtime (new Date ());
						album.setAlbumDefault (true);
						album.setAlbumName ("默认相册");
						album.setAlbumSequence (-10000);
						album.setUserId (user1.getId ());
						album.setDeletestatus (user1.getDeletestatus ());
						this.albumService.add (album);
						// 账号同步到分红系统
						user1.setParentId (null);
					}
					// 再保存子账号权限资源
					SellerAccount sellerAccount = new SellerAccount ();
					sellerAccount.setAddtime (new Date ());
					sellerAccount.setResource (res);
					sellerAccount.setType (Globals.SELLER_ACCOUNT_TYPE_PC);
					// 获取到商家的店铺
					sellerAccount.setStoreId (user.getStoreId ());
					// 子账号
					sellerAccount.setUser (user1);
					// 子账号所属商家
					sellerAccount.setBelongUser (user);
					// 设置子账号状态为启用
					sellerAccount.setStatus (Globals.NUBER_ONE);
					// 创建子账号
					sellerAccountService.add (sellerAccount);
				}
				else
				{
					return "redirect:/amall_logout.htm";
				}
			}
			return "redirect:seller_account_list.htm";
		}
}
