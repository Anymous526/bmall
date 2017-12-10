  package com.amall.core.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.common.encryption.EncryptionTools;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.AddressExample;
import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;
import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Message;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.User2Role;
import com.amall.core.bean.User2RoleExample;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.Verify;
import com.amall.core.bean.VerifyExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IMessageService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.dreampartner.IDreamPartnerService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.predeposit.IPredepositService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.privilege.IUser2RoleService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVerifyService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.sms.SendSMS;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: _UserManageAction
 * </p>
 * <p>
 * Description: 会员crud， 会员通知，会员信用管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午9:13:44
 * @version 1.0
 */
@Controller
public class UserManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private IPredepositService predepositService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private StoreTools storeTools;

	@Autowired
	private IDreamPartnerService dreamPartnerService;

	@Autowired
	private IUserVerifyService userVerifyService;

	@Autowired
	private IUser2RoleService user2RoleService;

	@Autowired
	private SendSMS sendSMS;

	@SecurityMapping(title = "会员添加" , value = "/admin/user_add.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_add.htm" })
	public ModelAndView user_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/user_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "会员编辑" , value = "/admin/user_edit.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_edit.htm" })
	public ModelAndView user_edit (HttpServletRequest request , HttpServletResponse response , String id , String op)
		{
			ModelAndView mv = new JModelAndView ("admin/user_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("obj" , this.userService.getByKey (Long.valueOf (Long.parseLong (id))));
			mv.addObject ("edit" , Boolean.valueOf (true));
			return mv;
		}

	@SecurityMapping(title = "会员列表" , value = "/admin/user_list.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_list.htm" })
	public ModelAndView user_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String condition , String value)
		{
			ModelAndView mv = new JModelAndView ("admin/user_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample userExample = new UserExample ();
			userExample.clear ();
			UserExample.Criteria userCriteria = userExample.createCriteria ();
			userExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			userExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			String params = "";
//			WebForm wf = new WebForm ();
//			Map <String, Map <String, Object>> map = wf.toQueryPo (request , User.class , mv);
//			Iterator <String> it = map.keySet ().iterator ();
//			while (it.hasNext ())
//			{
//				String key = it.next ().toString ();// 字段名
//				Map <String, Object> map2 = map.get (key);
//				Iterator <String> it2 = map2.keySet ().iterator ();
//				String keys = "";// =或者like
//				Object Objvalue = null;// 字段值
//				if (it2.hasNext ())
//				{
//					keys = it2.next ().toString ();
//					Objvalue = map2.get (keys);
//				}
//			}
			userCriteria.andUserroleNotEqualTo ("ADMIN");
			if (condition != null)
			{
				if (condition.equals ("username"))
				{
					userCriteria.andUsernameEqualTo (value);
				}
				if (condition.equals ("email"))
				{
					userCriteria.andEmailEqualTo (value);
				}
				if (condition.equals ("truename"))
				{
					userCriteria.andTruenameEqualTo (value);
				}
			}
			userCriteria.andDeletestatusEqualTo (false);
			userCriteria.andParentIdIsNull ();
			Pagination pList = this.userService.getObjectListWithPage (userExample);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/admin/user_list.htm" , "" , params , pList , mv);
			mv.addObject ("userRole" , "USER");
			mv.addObject ("storeTools" , this.storeTools);
			return mv;
		}

	/**
	 * 实名认证列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param userId
	 * @return
	 */
	@RequestMapping({ "/admin/user_verify_list.htm" })
	public ModelAndView user_verify_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String condition , String searchText)
		{
			ModelAndView mv = new JModelAndView ("admin/user_verify_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			VerifyExample verifyExample = new VerifyExample ();
			if (StringUtils.isNotEmpty (condition) && StringUtils.isNotEmpty (searchText))
			{
				UserExample userExample = new UserExample ();
				UserExample.Criteria userCriteria = userExample.createCriteria ();
				if (condition.equals ("username"))
				{
					userCriteria.andUsernameEqualTo (searchText);
				}
				List <User> listUser = this.userService.getObjectList (userExample);
				if (!listUser.isEmpty ())
				{
					User user = listUser.get (Globals.NUBER_ZERO);
					verifyExample.createCriteria ().andUserIdEqualTo (user.getId ());
				}
			}
			verifyExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			verifyExample.setOrderByClause ("id desc");
			verifyExample.setPageSize (10);
			Pagination pList = this.userVerifyService.getObjectListWithPage (verifyExample);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/admin/user_verify_list.htm" , "" , "" , pList , mv);
			return mv;
		}

	@RequestMapping({ "/admin/user_verify_edit.htm" })
	public ModelAndView user_verify_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/user_verify_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Verify verify = this.userVerifyService.getByKey (Long.valueOf (id));
			mv.addObject ("verify" , verify);
			return mv;
		}

	@RequestMapping({ "/admin/user_verify_upd.htm" })
	public ModelAndView user_verify_upd (HttpServletRequest request , HttpServletResponse response , String id , String verifyStatus , String verifyRemark)
		{
			Verify verify = this.userVerifyService.getByKey (Long.valueOf (id));
			verify.setVerifyStatus (Long.valueOf (verifyStatus));
			verify.setVerifyRemark (verifyRemark);
			this.userVerifyService.updateByObject (verify);
			ModelAndView mv = new ModelAndView ("redirect:user_verify_list.htm");
			return mv;
		}

	@RequestMapping({ "/admin/user_verify_delete.htm" })
	public ModelAndView user_verify_delete (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String condition , String searchText)
		{
			ModelAndView mv = new ModelAndView ("redirect:user_verify_list.htm");
			return mv;
		}

	/**
	 * @Title: dream_partner_list
	 * @Description: 梦想会员列表
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param value
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月3日
	 */
	@RequestMapping({ "/admin/dream_partner_list.htm" })
	public ModelAndView dream_partner_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String status , String value)
		{
			ModelAndView mv = new JModelAndView ("admin/dream_partner_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			DreamPartnerExample example = new DreamPartnerExample ();
			DreamPartnerExample.Criteria criteria = example.createCriteria ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			if (status != null)
			{
				if ("1".equals (status)) // 通过
				{
					criteria.andApproveStatusEqualTo (true);
				}
				else if ("0".equals (status)) // 未通过
				{
					criteria.andApproveStatusNotEqualTo (true);
				}
				mv.addObject ("status" , status);
			}
			if (value != null)
			{
				UserExample userExample = new UserExample ();
				UserExample.Criteria userCriteria = userExample.createCriteria ();
				userCriteria.andUserroleNotEqualTo ("ADMIN");
				userCriteria.andDeletestatusEqualTo (false);
				userCriteria.andUsernameEqualTo (value);
				List <User> list = this.userService.getObjectList (userExample);
				if (list != null && !list.isEmpty ())
				{
					criteria.andApplyUserIdEqualTo (list.get (0).getId ());
				}
			}
			Pagination pList = this.dreamPartnerService.getObjectListWithPage (example);
			String url = this.configService.getSysConfig ().getAddress ();
			if (url == null || url.equals (""))
			{
				url = CommUtil.getURL (request);
			}
			/* 获取所有梦想会员计数 */
			example.clear ();
			int totalPartner = this.dreamPartnerService.countByExample (example);
			/* 获取所有审核通过梦想会员计数 */
			example.createCriteria ().andApproveStatusEqualTo (true);
			int approvePartner = this.dreamPartnerService.countByExample (example);
			mv.addObject ("totalPartner" , totalPartner);
			mv.addObject ("approvePartner" , approvePartner);
			CommUtil.addIPageList2ModelAndView (url + "/admin/dream_partner_list.htm" , "" , null , pList , mv);
			return mv;
		}

	@RequestMapping({ "/admin/dream_partner_edit.htm" })
	public ModelAndView dream_partner_edit (HttpServletRequest request , HttpServletResponse response , Long id)
		{
			ModelAndView mv = null;
			if (id == null)
			{
				mv = new ModelAndView ("redirect:dream_partner_list.htm");
				return mv;
			}
			DreamPartner dreamPartner = this.dreamPartnerService.getByKey (id);
			if (dreamPartner == null)
			{
				mv = new ModelAndView ("redirect:dream_partner_list.htm");
				return mv;
			}
			mv = new JModelAndView ("admin/dream_partner_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("obj" , dreamPartner);
			return mv;
		}

	@RequestMapping({ "/admin/dream_partner_save.htm" })
	public ModelAndView dream_partner_save (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			String id = request.getParameter ("id");
			/* 审批通过 */
			if (id != null && !id.equals (""))
			{
				DreamPartner dreamPartner = this.dreamPartnerService.getByKey (Long.valueOf (id));
				dreamPartner.setApproveStatus (true);
				dreamPartner.setApproveTime (new Date ());
				this.dreamPartnerService.updateByObject (dreamPartner);
				User applyUser = dreamPartner.getApplyUser ();
				applyUser.setDreamPartnerId (dreamPartner.getId ());
				this.userService.updateByObject (applyUser);
				this.sendSMS.sendDreamSuccessMessage (applyUser.getUsername () , applyUser.getTruename ());
			}
			mv = new ModelAndView ("redirect:dream_partner_list.htm");
			return mv;
		}

	@RequestMapping({ "/admin/dream_partner_del.htm" })
	public ModelAndView dream_partner_del (HttpServletRequest request , HttpServletResponse response , Long id)
		{
			ModelAndView mv = null;
			if (id != null)
			{
				DreamPartner dreamPartner = this.dreamPartnerService.getByKey (id);
				User user = dreamPartner.getApplyUser ();
				user.setDreamPartnerId (null);
				this.userService.updateByObject (user);
				this.dreamPartnerService.deleteByKey (id);
			}
			mv = new ModelAndView ("redirect:dream_partner_list.htm");
			return mv;
		}

	@SecurityMapping(title = "会员保存" , value = "/admin/user_save.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_save.htm" })
	public ModelAndView user_save (HttpServletRequest request , HttpServletResponse response , String id , String role_ids , String list_url , String add_url , String password , String username)
		{
			WebForm wf = new WebForm ();
			User user = null;
			
			if (id.equals (""))
			{
				user = userService.getUserOfUserName(username);
				if(user != null){
					ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
					mv.addObject ("list_url" , list_url);
					mv.addObject ("op_title" , "用户名重复,请重新填写");
					return mv;
				}
				
				user = (User) wf.toPo (request , User.class);
				user.setAddtime (new Date ());
				user.setTelephone(username);
			}
			else
			{
				User u = this.userService.getByKey (Long.valueOf (Long.parseLong (id)));
				user = (User) wf.toPo (request , u);
			}
			if ((password != null) && (!password.equals ("")))
			{
				user.setPassword (EncryptionTools.pwdSHA2Sign ((password)));
			}
			if (id.equals (""))
			{
				user.setUserrole ("BUYER");
				user.getRoles ().clear ();
				RoleExample roleExample = new RoleExample ();
				roleExample.createCriteria ().andTypeEqualTo ("BUYER");
				List <Role> roles = roleService.getObjectList (roleExample);
				/*
				 * Map params = new HashMap();
				 * params.put("type", "BUYER");
				 * List roles = this.roleService.query(
				 * "select obj from Role obj where obj.type=:type", params,
				 * -1, -1);
				 */
				// 权限 查询 中间表关联
				user.getRoles ().addAll (roles);
				this.userService.add (user);
				for (Role role : roles)
				{
					/*
					 * Map map=new HashMap();
					 * map.put("userId", user2.getId());
					 * map.put("roleId", role.getId());
					 * this.userService.insertUserRole(map);
					 */
					User2Role u2r = new User2Role ();
					u2r.setUserId (user.getId ());
					u2r.setRoleId (role.getId ());
					user2RoleService.add (u2r);
				}
				Album album = new Album ();
				album.setAddtime (new Date ());
				album.setAlbumDefault (true);
				album.setAlbumName ("默认相册");
				album.setAlbumSequence (-10000);
				album.setUser (user);
				album.setUserId (user.getId ());
				this.albumService.add (album);
			}
			else
			{
				this.userService.updateByObject (user);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存用户成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "会员删除" , value = "/admin/user_del.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_del.htm" })
	public String user_del (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					User parent = this.userService.getByKey (Long.valueOf (Long.parseLong (id)));
					/* 如果存在店铺则不允许删除，需要先删除店铺 */
					if (parent.getStore () != null)
					{
						return "redirect:user_list.htm?currentPage=" + currentPage;
					}
					UserExample userExample = new UserExample ();
					userExample.clear ();
					UserExample.Criteria userCriteria = userExample.createCriteria ();
					userCriteria.andParentIdEqualTo (parent.getId ());
					List <User> childs = this.userService.getObjectList (userExample);
					parent.getChilds ().addAll (childs);
					if (!parent.getUsername ().equals ("admin"))
					{
						for (User user : parent.getChilds ())
						{
							user.getRoles ().clear ();
							if (user.getStore () != null)
							{
								for (GoodsWithBLOBs goods : user.getStore ().getGoodsList ())
								{
									List <EvaluateWithBLOBs> evaluates = goods.getEvaluates ();
									for (Evaluate e : evaluates)
									{
										this.evaluateService.deleteByKey (e.getId ());
									}
									goods.getGoodsUgcs ().clear ();
									this.goodsService.deleteByKey (goods.getId ());
								}
							}
							/* 不做物理删除，修改状态为删除状态 */
							user.setDeletestatus (true);
							this.userService.updateByObject (user);
						}
						parent.getRoles ().clear ();
						if (parent.getStore () != null)
						{
							for (GoodsWithBLOBs goods : parent.getStore ().getGoodsList ())
							{
								List <EvaluateWithBLOBs> evaluates = goods.getEvaluates ();
								for (Evaluate e : evaluates)
								{
									this.evaluateService.deleteByKey (e.getId ());
								}
								goods.getGoodsUgcs ().clear ();
								this.goodsService.deleteByKey (goods.getId ());
							}
						}
						AlbumExample albumExample = new AlbumExample ();
						albumExample.clear ();
						albumExample.createCriteria ().andUserIdEqualTo (parent.getId ());
						albumService.deleteByExample (albumExample);
						/* 删除图片和地址 */
						AddressExample addressExample = new AddressExample ();
						addressExample.clear ();
						addressExample.createCriteria ().andUserIdEqualTo (parent.getId ());
						this.addressService.deleteByExample (addressExample);
						AccessoryExample accessoryExample = new AccessoryExample ();
						accessoryExample.clear ();
						accessoryExample.createCriteria ().andUserIdEqualTo (parent.getId ());
						this.accessoryService.deleteByExample (accessoryExample);
						/* 不做物理删除，修改状态为删除状态 */
						parent.setDeletestatus (true);
						parent.setLevelAngel (null);
						this.userService.updateByObject (parent);
					}
					/* 删除对应用户权限 */
					User2RoleExample example = new User2RoleExample ();
					example.clear ();
					example.createCriteria ().andUserIdEqualTo (Long.valueOf (id));
					this.user2RoleService.deleteByExample (example);
				}
			}
			return "redirect:user_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "会员通知" , value = "/admin/user_msg.htm*" , rtype = "admin" , rname = "会员通知" ,
						rcode = "user_msg" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_msg.htm" })
	public ModelAndView user_msg (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/user_msg.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreGradeExample storeGradeExample = new StoreGradeExample ();
			storeGradeExample.clear ();
			storeGradeExample.setOrderByClause ("sequence asc");
			List <StoreGrade> grades = storeGradeService.getObjectList (storeGradeExample);
			mv.addObject ("grades" , grades);
			return mv;
		}

	@SecurityMapping(title = "会员通知发送" , value = "/admin/user_msg_send.htm*" , rtype = "admin" , rname = "会员通知" ,
						rcode = "user_msg" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_msg_send.htm" })
	public ModelAndView user_msg_send (HttpServletRequest request , HttpServletResponse response , String type , String list_url , String users , String grades , String content) throws IOException
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <User> user_list = new ArrayList <User> ();
			UserExample userExample = new UserExample ();
			if (type.equals ("all_user"))
			{
				userExample.clear ();
				userExample.createCriteria ().andUserroleEqualTo ("ADMIN");
				userExample.setOrderByClause ("addTime desc");
				user_list = userService.getObjectList (userExample);
			}
			if (type.equals ("the_user"))
			{
				List <String> user_names = CommUtil.str2list (users);
				userExample.clear ();
				userExample.createCriteria ().andUsernameIn (user_names);
				user_list = userService.getObjectList (userExample);
				/*
				 * for (String user_name : user_names) {
				 * user = this.userService.getObjByProperty("userName", user_name);
				 * user_list.add(user);
				 * }
				 */
			}
			if (type.equals ("all_store"))
			{
				userExample.clear ();
				userExample.createCriteria ().andStoreIdIsNotNull ();
				userExample.setOrderByClause ("addTime desc");
				user_list = userService.getObjectList (userExample);
			}
			List <Long> store_ids;
			if (type.equals ("the_store"))
			{
				store_ids = new ArrayList <Long> ();
				String [ ] arrayOfString = grades.split (",");
				for (int i = 0 ; i < arrayOfString.length ; i++)
				{
					String grade = arrayOfString[i];
					store_ids.add (Long.valueOf (Long.parseLong (grade)));
				}
				userExample.clear ();
				userExample.createCriteria ().andStoreIdIn (store_ids);
				user_list = userService.getObjectList (userExample);
			}
			for (User user1 : user_list)
			{
				Message msg = new Message ();
				msg.setAddtime (new Date ());
				msg.setContent (content);
				msg.setFromUser (SecurityUserHolder.getCurrentUser ());
				msg.setToUser (user1);
				msg.setDeletestatus (user1.getDeletestatus ());
				msg.setStatus (user1.getStatus ());
				this.messageService.add (msg);
			}
			mv.addObject ("op_title" , "会员通知发送成功");
			mv.addObject ("list_url" , list_url);
			return mv;
		}

	@SecurityMapping(title = "会员信用" , value = "/admin/user_creditrule.htm*" , rtype = "admin" , rname = "会员信用" ,
						rcode = "user_creditrule" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_creditrule.htm" })
	public ModelAndView user_creditrule (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/user_creditrule.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "买家信用保存" , value = "/admin/user_creditrule_save.htm*" , rtype = "admin" , rname = "会员信用" ,
						rcode = "user_creditrule" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_creditrule_save.htm" })
	public ModelAndView user_creditrule_add (HttpServletRequest request , HttpServletResponse response , String id , String list_url)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs sc = this.configService.getSysConfig ();
			Map <Object, Integer> map = new HashMap <Object, Integer> ();
			for (int i = 0 ; i <= 29 ; i++)
			{
				map.put ("creditrule" + i , Integer.valueOf (CommUtil.null2Int (request.getParameter ("creditrule" + i))));
			}
			String user_creditrule = Json.toJson (map , JsonFormat.compact ());
			sc.setUserCreditrule (user_creditrule);
			if (id.equals (""))
				this.configService.add (sc);
			else
				this.configService.updateByObject (sc);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存会员信用成功");
			return mv;
		}
}
