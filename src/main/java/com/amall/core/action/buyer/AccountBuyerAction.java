package com.amall.core.action.buyer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.MobileVerifyCode;
import com.amall.core.bean.MobileVerifyCodeExample;
import com.amall.core.bean.SmsVerificationExample;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserCashDepositLog;
import com.amall.core.bean.UserCashDepositLogExample;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.Verify;
import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.lee.LeeConfig;
import com.amall.core.lee.LeeConfigurationBuilder;
import com.amall.core.lee.LeeService;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IMobileVerifyCodeService;
import com.amall.core.service.ISmsVerificationService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.lee.IUserCashDepositLogService;
import com.amall.core.service.sns.ISnsFriendService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVerifyService;
import com.amall.core.service.user.IUserVipActiveService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.pay.PayTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.ucapi.UCClient;
import com.amall.core.web.virtual.JModelAndView;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 * 
 * Title : AccountBuyerAction
 *
 * Description : 用户个人信息设置
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:43:32
 *
 */
@Controller
public class AccountBuyerAction
{

	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMobileVerifyCodeService mobileverifycodeService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private ISnsFriendService sndFriendService;

	@Autowired
	private LeeService leeService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IUserVerifyService userVerifyService;

	@Autowired
	private IUserCashDepositLogService cashDepositLogService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private PayTools payTools;

	@Autowired
	private IUserVipActiveService userVipActiveService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private ISmsVerificationService verificationService;

	private static final String DEFAULT_AVATAR_FILE_EXT = ".jpg";

	private static BASE64Decoder _decoder = new BASE64Decoder ();

	public static final String OPERATE_RESULT_CODE_SUCCESS = "200";

	public static final String OPERATE_RESULT_CODE_FAIL = "400";


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:02:24
	 * @todo 个人信息主页面
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "个人信息" , value = "/buyer/account.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account.htm" })
	public ModelAndView account (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = this.areaService.getObjectList (areaExample);
			user = this.userService.getByKey (user.getId ());
			if (user.getAreaId () != null)
			{
				Area area = this.areaService.getByKey (user.getAreaId ());
				mv.addObject ("userArea" , area);
			}
			mv.addObject ("user" , user);
			mv.addObject ("areas" , areas);
			return mv;
		}


	/**
	 * @TItle: accountUpdateNickName
	 * @Deprecated : 修改昵称
	 * @param request
	 * @param response
	 * @author liuguo
	 * @Date 2017/03/20 10:25
	 */
	@SecurityMapping(title = "昵称修改" , value = "/buyer/buyer_account_updateNickName.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_updateNickName.htm" })
	public ModelAndView accountUpdateNickName (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_updateNickName.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (StringUtils.isEmpty (user.getNickname ()))
			{
				mv.addObject ("nickName" , Globals.NOT_NICK_NAME);
			}
			else
			{
				mv.addObject ("nickName" , user.getNickname ());
			}
			return mv;
		}


	/**
	 * @Title: accountUpdateNickNameSave
	 * @Deprecated : 修改昵称保存
	 * @param request
	 * @param response
	 * @author : liuguo
	 * @Date : 2017/03/20 10:19
	 */
	@SecurityMapping(title = "昵称修改保存" , value = "/buyer/buyer_account_updateNickName_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_updateNickName_save.htm" })
	public ModelAndView accountUpdateNickNameSave (	HttpServletRequest request , HttpServletResponse response ,
													String nickName)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (null != user)
			{
				user.setNickname (nickName);
				this.userService.updateUsers (user);
			}
			mv.addObject ("op_title" , "昵称修改成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_account_updateNickName.htm");
			return mv;
		}


	/**
	 * @TItle: accountUpdateTrueName
	 * @Deprecated : 修改真实姓名
	 * @param request
	 * @param response
	 * @author liuguo
	 * @Date 2017/03/21 10:25
	 */
	@SecurityMapping(title = "真实姓名修改" , value = "/buyer/buyer_account_updateTrueName.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_updateTrueName.htm" })
	public ModelAndView accountUpdateTrueName (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_updateTrueName.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (StringUtils.isEmpty (user.getTruename ()))
			{
				mv.addObject ("trueName" , Globals.NOT_TRUE_NAME);
			}
			else
			{
				mv.addObject ("trueName" , user.getTruename ());
			}
			if (null != user && !StringUtils.isEmpty (user.getChgTruenameTimes ()))
			{
				mv.addObject ("op_title" , user.getChgTruenameTimes ());
			}
			return mv;
		}


	/**
	 * @Title: accountUpdateTrueNameSave
	 * @Deprecated : 修改真实姓名保存
	 * @param request
	 * @param response
	 * @author : liuguo
	 * @Date : 2017/03/21 10:19
	 */
	@SecurityMapping(title = "真实姓名修改保存" , value = "/buyer/buyer_account_updateTrueName_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_updateTrueName_save.htm" })
	public ModelAndView accountUpdateTrueNameSave (	HttpServletRequest request , HttpServletResponse response ,
													String trueName)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (null != user)
			{
				user.setTruename (trueName);
				this.userService.updateUsers (user);
				mv.addObject ("op_title" , "亲，真实姓名修改成功！");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_account_updateTrueName.htm");
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:02:36
	 * @todo 个人信息导航条
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "个人信息导航" , value = "/buyer/buyer_account_nav.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_nav.htm" })
	public ModelAndView account_nav (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String op = CommUtil.null2String (request.getAttribute ("op"));
			mv.addObject ("op" , op);
			mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:02:47
	 * @todo 个人信息修改,异步刷新获取地址
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param parentId
	 * @return
	 */
	@SecurityMapping(title = "个人信息获取下级地区ajax" , value = "/buyer/buyer_account_getAreaChilds.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_getAreaChilds.htm" })
	public ModelAndView account_getAreaChilds (	HttpServletRequest request , HttpServletResponse response ,
												String parentId)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_area_chlids.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (parentId));
			List <Area> childs = this.areaService.getObjectList (areaExample);
			if (childs.size () > 0)
			{
				mv.addObject ("childs" , childs);
			}
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:03:02
	 * @todo 个人信息保存
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param areaId
	 * @param birthday
	 * @return
	 */
	@SecurityMapping(title = "个人信息保存" , value = "/buyer/buyer_account_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_save.htm" })
	public ModelAndView account_save (	HttpServletRequest request , HttpServletResponse response , String areaId ,
										String birthday)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			WebForm wf = new WebForm ();
			User u = SecurityUserHolder.getCurrentUser ();
			User user = (User) wf.toPo (request , u);
			if ((areaId != null) && (!areaId.equals ("")))
			{
				// Area area = this.areaService.getByKey
				// (CommUtil.null2Long (areaId));
				user.setAreaId (CommUtil.null2Long (areaId));
			}
			if ((birthday != null) && (!birthday.equals ("")))
			{
				String [ ] y = birthday.split ("-");
				Calendar calendar = new GregorianCalendar ();
				int years = calendar.get (1) - CommUtil.null2Int (y[0]);
				user.setYears (years);
			}
			this.userService.updateByObject (user);
			mv.addObject ("op_title" , "个人信息修改成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:03:16
	 * @todo 用户密码修改
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "密码修改" , value = "/buyer/buyer_account_password.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_password.htm" })
	public ModelAndView account_password (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_password.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	@SecurityMapping(title = "密码修改保存" , value = "/buyer/buyer_account_password_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_password_save.htm" })
	public ModelAndView account_password_save (	HttpServletRequest request , HttpServletResponse response ,
												String old_password , String new_password) throws Exception
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// WebForm wf = new WebForm ();
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (user.getPassword ().equals (old_password))
			{
				user.setPassword (new_password);
				int ret = this.userService.updateByObject (user);
				if ((ret > 0) && (this.configService.getSysConfig ().getUcBbs ()))
				{
					UCClient uc = new UCClient ();
					uc.uc_user_edit (user.getUsername () , CommUtil.null2String (old_password) , CommUtil.null2String (new_password) , CommUtil.null2String (user.getEmail ()) , 1 , 0 , 0);
				}
				mv.addObject ("op_title" , "密码修改成功");
				send_sms (request , "sms_tobuyer_pws_modify_notify");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "原始密码输入错误，修改失败");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_account_password.htm");
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:03:30
	 * @todo 用户邮箱修改
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "邮箱修改" , value = "/buyer/buyer_account_email.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_email.htm" })
	public ModelAndView account_email (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_email.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/**
	 * 
	 * @todo 用户邮箱修改后保存
	 * @author wsw
	 * @date 2015年7月15日 上午9:48:39
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param password
	 * @param email
	 * @return
	 */
	@SecurityMapping(title = "邮箱修改保存" , value = "/buyer/account_email_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_email_save.htm" })
	public ModelAndView account_email_save (HttpServletRequest request , HttpServletResponse response ,
											String password , String email)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user.getPassword ().equals (password))
			{
				user.setEmail (email);
				this.userService.updateByObject (user);
				mv.addObject ("op_title" , "邮箱修改成功");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "密码输入错误，邮箱修改失败");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_account_email.htm");
			return mv;
		}


	@SecurityMapping(title = "天使等级保存" , value = "/buyer/buyer_level_angel_save*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_level_angel_save.htm" })
	public ModelAndView buyer_level_angel_save (HttpServletRequest request , HttpServletResponse response ,
												String levelId , String levelIntegral)
		{
			ModelAndView mv = null;
			if (levelId == null || levelId.equals ("") || levelIntegral == null || levelIntegral.equals (""))
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "升级信息错误");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
				return mv;
			}
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (user.getGold () >= Integer.valueOf (levelIntegral))
			{
				user.setGold (user.getGold () - Integer.valueOf (levelIntegral));
				user.setLevelAngel (Integer.valueOf (levelId));
				this.userService.updateByObject (user);
				mv = new JModelAndView ("buyer/buyer_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "升级成功");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
				return mv;
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "升级失败");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
				return mv;
			}
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:03:42
	 * @todo 用户头像,图片修改
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "图像修改" , value = "/buyer/buyer_account_avatar.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_avatar.htm" })
	public ModelAndView account_avatar (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_avatar.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			mv.addObject ("url" , CommUtil.getURL (request));
			return mv;
		}


	/**
	 * 
	 * @todo 用户个人原始头像上传
	 * @author wsw
	 * @date 2015年7月15日 上午9:49:17
	 * @return void
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SecurityMapping(title = "图像上传" , value = "/buyer/buyer_upload_avatar.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_upload_avatar.htm" })
	public void upload_avatar (	HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			User user = SecurityUserHolder.getCurrentUser ();
			// 判断是否是上传文件表单
			boolean isMultipart = ServletFileUpload.isMultipartContent (request);
			if (isMultipart)
			{
				// 返回保存的相对路径
				String returnPath = null;
				PrintWriter writer = response.getWriter ();
				String filePath = this.configService.getSysConfig ().getUploadRootPath () + this.configService.getSysConfig ().getUploadfilepath () + File.separator + "avatar" + File.separator;
				String relativePath = "/upload/avatar/";
				File uploadDir = new File (filePath);
				if (!uploadDir.exists ())
				{
					uploadDir.mkdirs ();
				}
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Map <String, MultipartFile> fileMap = multipartRequest.getFileMap ();
				String fileName = null;
				for (Map.Entry <String, MultipartFile> entity : fileMap.entrySet ())
				{
					// 上传文件名
					MultipartFile mf = entity.getValue ();
					fileName = mf.getOriginalFilename ();
					String fileExt = fileName.substring (fileName.lastIndexOf (".") + 1).toLowerCase ();
					if (!fileExt.equals ("jpg") && !fileExt.equals ("png"))
					{
						writer.print (returnPath);
						return;
					}
					String saveName = user.getId () + "-" + UUID.randomUUID ().toString () + "." + fileExt;
					File uploadFile = new File (filePath + saveName);
					try
					{
						FileCopyUtils.copy (mf.getBytes () , uploadFile);
						Accessory photo = new Accessory ();
						if (user.getPhoto () != null)
						{
							photo = user.getPhoto ();
						}
						else
						{
							photo.setAddtime (new Date ());
						}
						photo.setSize ((float) mf.getSize ());
						photo.setName (saveName);
						photo.setExt (fileExt);
						photo.setPath ("/upload/avatar");
						photo.setUserId (user.getId ());
						if (user.getPhoto () == null)
							this.accessoryService.add (photo);
						else
						{
							this.accessoryService.updateByObject (photo);
						}
						returnPath = photo.getId () + "," + relativePath + saveName;
						AccessoryExample example = new AccessoryExample ();
						example.createCriteria ().andNameEqualTo (saveName);
						user.setPhotoId (accessoryService.getObjectList (example).get (0).getId ());
						this.userService.updateByObject (user);
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
					writer.print (returnPath);
				}
			}
		}


	/**
	 * 
	 * @todo 保存用户头像
	 * @author wsw
	 * @date 2015年7月15日 上午9:48:59
	 * @return void
	 * @param filePath
	 * @param imageType
	 * @param avatarContent
	 * @param avatarName
	 * @throws IOException
	 */
	private void saveImage (String filePath , String imageType , String avatarContent , String avatarName) throws IOException
		{
			avatarContent = CommUtil.null2String (avatarContent);
			if (!"".equals (avatarContent))
			{
				if ("".equals (avatarName))
					avatarName = UUID.randomUUID ().toString () + ".jpg";
				else
				{
					avatarName = avatarName + imageType;
				}
				byte [ ] data = _decoder.decodeBuffer (avatarContent);
				File f = new File (filePath + File.separator + avatarName);
				DataOutputStream dos = new DataOutputStream (new FileOutputStream (f));
				dos.write (data);
				dos.flush ();
				dos.close ();
			}
		}


	@RequestMapping({ "/buyer/buyer_account_verify.htm" })
	public ModelAndView buyer_account_verify (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_verify.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				user = this.userService.getByKey (user.getId ());
				mv.addObject ("user" , user);
				mv.addObject ("url" , CommUtil.getURL (request));
				Verify verify = this.userVerifyService.getByKey (user.getVerifyId ());
				String exchangeid = request.getParameter ("exchangeid");
				if (verify == null)
				{
				}
				else
				{
					mv = new JModelAndView ("buyer/buyer_account_sub_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					// String msg = "";
					// 审核通过
					if (verify.getVerifyStatus () == 1)
					{
						mv.addObject ("msg" , "实名认证审核通过!");
					}
					// 审核不通过
					else if (verify.getVerifyStatus () == 0)
					{
						mv = new JModelAndView ("buyer/buyer_account_verify.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("verify" , verify);
						mv.addObject ("msg" , "实名认证审核失败! 原因 : " + verify.getVerifyRemark ());
					}
					// 待审核
					else
					{
						mv.addObject ("msg" , "实名认证资料上传成功,我们会尽快审核,烦请耐心等待...");
					}
				}
				mv.addObject ("exchangeid" , exchangeid);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}


	@RequestMapping(value = "/buyer/buyer_verify_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String buyer_verify_upload (	HttpServletRequest request , HttpServletResponse response , String width ,
										String height , String isCheckWithHeight) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "avatar";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imageId = "";
			String imagePath = "";
			int reqIsCheckWithHeight = CommUtil.null2Int (isCheckWithHeight);
			if (reqIsCheckWithHeight > Globals.NUBER_ZERO)
			{
				// 做宽高验证
				int reqWidth = CommUtil.null2Int (width);
				int reqHeight = CommUtil.null2Int (height);
				int mapWidth = CommUtil.null2Int (map.get ("width"));
				int mapHeight = CommUtil.null2Int (map.get ("height"));
				if ((Math.abs (reqWidth - mapWidth) == 0) && ((Math.abs (reqHeight - mapHeight) == 0)))
				{
					Accessory gg_img = new Accessory ();
					if (fileName.equals (""))
					{
						if (!map.get ("fileName").equals (""))
						{
							gg_img.setName (CommUtil.null2String (map.get ("fileName")));
							gg_img.setExt (CommUtil.null2String (map.get ("mime")));
							gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
							gg_img.setPath (uploadFilePath + "/avatar");
							gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
							gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
							gg_img.setAddtime (new Date ());
							this.accessoryService.add (gg_img);
							imageId = String.valueOf (gg_img.getId ());
							imagePath = String.valueOf (this.configService.getSysConfig ().getImagewebserver () + "/" + gg_img.getPath () + "/" + gg_img.getName ());
						}
					}
					response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\",\"imagePath\":\"" + imagePath + "\"}";
					return response_rs;
				}
				else
				{
					imageId = String.valueOf (0);
					response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\"}";
					return response_rs;
				}
			}
			else
			{
				// 不做宽高验证
				Accessory gg_img = new Accessory ();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						gg_img.setName (CommUtil.null2String (map.get ("fileName")));
						gg_img.setExt (CommUtil.null2String (map.get ("mime")));
						gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						gg_img.setPath (uploadFilePath + "/avatar");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
						imagePath = String.valueOf (this.configService.getSysConfig ().getImagewebserver () + "/" + gg_img.getPath () + "/" + gg_img.getName ());
					}
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\",\"imagePath\":\"" + imagePath + "\"}";
				return response_rs;
			}
		}


	@RequestMapping({ "/buyer/buyer_verify_sub.htm" })
	public ModelAndView buyer_verify_sub (	HttpServletRequest request , HttpServletResponse response ,
											String cardFrontId , String verifyName , String verifyCode ,
											String verifyId , String userId)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_sub_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 验证身份证号是否合法是否真实存在
			String httpUrl = "http://apis.baidu.com/apistore/idservice/id";
			String httpArg = "id=" + verifyCode;
			String jsonResult = checkSF (httpUrl , httpArg);
			JSONObject jsonObj = JSONObject.fromObject (jsonResult);
			String codeResult = jsonObj.get ("retMsg").toString ();
			if (codeResult != null && "success".equals (codeResult))
			{
				if (StringUtils.isEmpty (verifyId))
				{
					// 新增
					Verify verify = new Verify ();
					verify.setPhotoId (Long.valueOf (cardFrontId));
					verify.setVerifyName (verifyName);
					verify.setVerifyCode (verifyCode);
					// 实名认证待审核
					verify.setVerifyStatus (Globals.user_verify_prepare);
					verify.setUserId (Long.valueOf (userId));
					int rs = userVerifyService.add (verify);
					if (rs > 0)
					{
						User user = SecurityUserHolder.getCurrentUser ();
						if (user != null)
						{
							user.setVerifyId (verify.getId ());
							this.userService.updateByObject (user);
						}
					}
				}
				else
				{
					// 修改
					Verify verify = this.userVerifyService.getByKey (Long.valueOf (verifyId));
					verify.setPhotoId (Long.valueOf (cardFrontId));
					verify.setVerifyName (verifyName);
					verify.setVerifyCode (verifyCode);
					// 实名认证待审核
					verify.setVerifyStatus (Globals.user_verify_prepare);
					this.userVerifyService.updateByObject (verify);
				}
				mv.addObject ("exchangeid" , request.getParameter ("exchangeid"));
				mv.addObject ("msg" , "实名认证资料上传成功,我们会尽快审核,烦请耐心等待...");
				mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
				mv.addObject ("url" , CommUtil.getURL (request));
			}
			else
			{
				mv.addObject ("msg" , "身份证信息有误，请认真检查后重新认证!");
				mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
				mv.addObject ("url" , CommUtil.getURL (request));
			}
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:03:59
	 * @todo 用户手机修改
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "手机号码修改" , value = "/buyer/buyer_account_mobile.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_mobile.htm" })
	public ModelAndView account_mobile (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_account_mobile.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("url" , CommUtil.getURL (request));
			return mv;
		}


	@RequestMapping("/check_password.htm")
	@ResponseBody
	public String check_password (	HttpServletRequest request , HttpServletResponse response , String username ,
									String password)
		{
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (username).andPasswordEqualTo (password);
			Integer count = userService.getObjectListCount (userExample);
			if (count > 0)
			{
				return "true";
			}
			else
			{
				return "false";
			}
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:04:23
	 * @todo 用户手机修改保存
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param mobile_verify_code
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "手机号码保存" , value = "/buyer/buyer_account_mobile_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_mobile_save.htm" })
	public ModelAndView account_mobile_save (	HttpServletRequest request , HttpServletResponse response ,
												String mobile , String oldMobile) throws Exception
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			user.setMobile (mobile);
			user.setTelephone (mobile);
			user.setUsername (mobile);
			this.userService.updateByObject (user);
			SmsVerificationExample smsVerificationExample = new SmsVerificationExample ();
			smsVerificationExample.createCriteria ().andSmsPhoneEqualTo (oldMobile);
			verificationService.deleteByExample (smsVerificationExample);
			mv.addObject ("op_title" , "手机绑定成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_account.htm");
			return mv;
		}


	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:04:36
	 * @todo 修改手机,验证信息
	 * @return void
	 * @param request
	 * @param response
	 * @param type
	 * @param mobile
	 * @throws UnsupportedEncodingException
	 */
	@SecurityMapping(title = "手机短信发送" , value = "/buyer/buyer_account_mobile_sms.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_account_mobile_sms.htm" })
	public void account_mobile_sms (HttpServletRequest request , HttpServletResponse response , String type ,
									String mobile) throws UnsupportedEncodingException
		{
			String ret = "100";
			if (type.equals ("mobile_vetify_code"))
			{
				String code = CommUtil.randomString (4).toUpperCase ();
				String content = "尊敬的" + SecurityUserHolder.getCurrentUser ().getUsername () + "您好，您在试图修改" + this.configService.getSysConfig ().getWebsitename () + "用户绑定手机，手机验证码为：" + code + "。[" + this.configService.getSysConfig ().getTitle () + "]";
				if (this.configService.getSysConfig ().getSmsenbale ())
				{
					boolean ret1 = this.msgTools.sendSMS (mobile , content);
					if (ret1)
					{   // 当短信发送成功之后,返回true.
						MobileVerifyCodeExample mobileVerifyCodeExample = new MobileVerifyCodeExample ();
						mobileVerifyCodeExample.clear ();
						mobileVerifyCodeExample.createCriteria ().andMobileEqualTo (mobile);
						List <MobileVerifyCode> mobileVerifyCodes = this.mobileverifycodeService.getObjectList (mobileVerifyCodeExample);
						MobileVerifyCode mvc = null;
						if (null != mobileVerifyCodes && mobileVerifyCodes.size () > 0)
						{
							mvc = mobileVerifyCodes.get (0);
							mvc.setAddtime (new Date ());
							mvc.setCode (code);
							mvc.setMobile (mobile);
							this.mobileverifycodeService.updateByObject (mvc);
						}
						else
						{
							mvc = new MobileVerifyCode ();
							mvc.setAddtime (new Date ());
							mvc.setCode (code);
							mvc.setMobile (mobile);
							this.mobileverifycodeService.add (mvc);
						}
					}
					else
					{
						ret = "200";
					}
				}
				else
				{
					ret = "300";
				}
				response.setContentType ("text/plain");
				response.setHeader ("Cache-Control" , "no-cache");
				response.setCharacterEncoding ("UTF-8");
				try
				{
					PrintWriter writer = response.getWriter ();
					writer.print (ret);
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
		}


	/*
	 * @SecurityMapping(title="好友管理", value="/buyer/friend.htm*",
	 * rtype="buyer", rname="用户中心",
	 * rcode="user_center", rgroup="用户中心", display = false, rsequence
	 * = 0)
	 * @RequestMapping({"/buyer/friend.htm"})
	 * public ModelAndView account_friend(HttpServletRequest request,
	 * HttpServletResponse response,
	 * String currentPage) {
	 * ModelAndView mv = new JModelAndView(
	 * "user/default/usercenter/account_friend.html",
	 * this.configService
	 * .getSysConfig(),
	 * this.userConfigService.getUserConfig(), 0, request, response);
	 * SnsFriendQueryObject qo = new SnsFriendQueryObject(currentPage,
	 * mv,
	 * "addTime", "desc");
	 * qo.addQuery("obj.fromUser.id",
	 * new SysMap("user_id",
	 * SecurityUserHolder.getCurrentUser().getId()), "=");
	 * IPageList pList = this.sndFriendService.list(qo);
	 * CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
	 * return mv;
	 * }
	 * @SecurityMapping(title="好友添加", value="/buyer/friend_add.htm*",
	 * rtype="buyer", rname="用户中心",
	 * rcode="user_center", rgroup="用户中心", display = false, rsequence
	 * = 0)
	 * @RequestMapping({"/buyer/friend_add.htm"})
	 * public ModelAndView friend_add(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * ModelAndView mv = new JModelAndView(
	 * "user/default/usercenter/account_friend_search.html",
	 * this.configService.getSysConfig(), this.userConfigService
	 * .getUserConfig(), 0, request, response);
	 * List areas = this.areaService.query(
	 * "select obj from Area obj where obj.parent.id is null", null,
	 * -1, -1);
	 * mv.addObject("areas", areas);
	 * return mv;
	 * }
	 * @SecurityMapping(title="搜索用户",
	 * value="/buyer/account_friend_search.htm*", rtype="buyer",
	 * rname="用户中心", rcode="user_center", rgroup="用户中心", display =
	 * false, rsequence = 0)
	 * @RequestMapping({"/buyer/account_friend_search.htm"})
	 * public ModelAndView friend_search(HttpServletRequest request,
	 * HttpServletResponse response,
	 * String userName, String area_id, String sex, String years,
	 * String currentPage) {
	 * ModelAndView mv = new JModelAndView(
	 * "user/default/usercenter/account_friend_search.html",
	 * this.configService.getSysConfig(), this.userConfigService
	 * .getUserConfig(), 0, request, response);
	 * UserQueryObject qo = new UserQueryObject(currentPage, mv,
	 * "addTime",
	 * "desc");
	 * qo.addQuery("obj.userRole", new SysMap("userRole", "ADMIN"),
	 * "!=");
	 * if ((userName != null) && (!userName.equals(""))) {
	 * mv.addObject("userName", userName);
	 * qo.addQuery("obj.userName",
	 * new SysMap("userName", "%" + userName +
	 * "%"), "like");
	 * }
	 * if ((years != null) && (!years.equals(""))) {
	 * mv.addObject("years", years);
	 * if (years.equals("18")) {
	 * qo.addQuery("obj.years",
	 * new SysMap("years",
	 * Integer.valueOf(CommUtil.null2Int(years))), "<=");
	 * }
	 * if (years.equals("50")) {
	 * qo.addQuery("obj.years",
	 * new SysMap("years",
	 * Integer.valueOf(CommUtil.null2Int(years))), ">=");
	 * }
	 * if ((!years.equals("18")) && (!years.equals("50"))) {
	 * String[] y = years.split("~");
	 * qo.addQuery("obj.years",
	 * new SysMap("years",
	 * Integer.valueOf(CommUtil.null2Int(y[0]))), ">=");
	 * qo.addQuery("obj.years",
	 * new SysMap("years2",
	 * Integer.valueOf(CommUtil.null2Int(y[1]))), "<=");
	 * }
	 * }
	 * if ((sex != null) && (!sex.equals(""))) {
	 * mv.addObject("sex", sex);
	 * qo.addQuery("obj.sex", new SysMap("sex",
	 * Integer.valueOf(CommUtil.null2Int(sex))),
	 * "=");
	 * }
	 * if ((area_id != null) && (!area_id.equals(""))) {
	 * Area area = this.areaService
	 * .getObjById(CommUtil.null2Long(area_id));
	 * mv.addObject("area", area);
	 * qo.addQuery("obj.area.id",
	 * new SysMap("area_id",
	 * CommUtil.null2Long(area_id)), "=");
	 * }
	 * qo.setPageSize(Integer.valueOf(18));
	 * qo.addQuery("obj.id",
	 * new SysMap("user_id",
	 * SecurityUserHolder.getCurrentUser().getId()), "!=");
	 * IPageList pList = this.userService.list(qo);
	 * CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
	 * List areas = this.areaService.query(
	 * "select obj from Area obj where obj.parent.id is null", null,
	 * -1, -1);
	 * mv.addObject("areas", areas);
	 * return mv;
	 * }
	 * @SecurityMapping(title="好友添加",
	 * value="/buyer/friend_add_save.htm*", rtype="buyer",
	 * rname="用户中心", rcode="user_center", rgroup="用户中心", display =
	 * false, rsequence = 0)
	 * @RequestMapping({"/buyer/friend_add_save.htm"})
	 * public void friend_add_save(HttpServletRequest request,
	 * HttpServletResponse response, String
	 * user_id) {
	 * boolean flag = false;
	 * Map params = new HashMap();
	 * params.put("user_id", CommUtil.null2Long(user_id));
	 * params.put("uid", SecurityUserHolder.getCurrentUser().getId());
	 * List sfs = this.sndFriendService
	 * .query(
	 * "select obj from SnsFriend obj where obj.fromUser.id=:uid and obj.toUser.id=:user_id"
	 * ,
	 * params, -1, -1);
	 * if (sfs.size() == 0) {
	 * SnsFriend friend = new SnsFriend();
	 * friend.setAddTime(new Date());
	 * friend.setFromUser(SecurityUserHolder.getCurrentUser());
	 * friend.setToUser(this.userService.getObjById(
	 * CommUtil.null2Long(user_id)));
	 * flag = this.sndFriendService.save(friend);
	 * }
	 * response.setContentType("text/plain");
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.setCharacterEncoding("UTF-8");
	 * try
	 * {
	 * PrintWriter writer = response.getWriter();
	 * writer.print(flag);
	 * }
	 * catch (IOException e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * @SecurityMapping(title="好友删除", value="/buyer/friend_del.htm*",
	 * rtype="buyer", rname="用户中心",
	 * rcode="user_center", rgroup="用户中心", display = false, rsequence
	 * = 0)
	 * @RequestMapping({"/buyer/friend_del.htm"})
	 * public void friend_del(HttpServletRequest request,
	 * HttpServletResponse response, String id) {
	 * this.sndFriendService.delete(CommUtil.null2Long(id));
	 * response.setContentType("text/plain");
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.setCharacterEncoding("UTF-8");
	 * try
	 * {
	 * PrintWriter writer = response.getWriter();
	 * writer.print(true);
	 * }
	 * catch (IOException e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * @SecurityMapping(title="账号绑定",
	 * value="/buyer/account_bind.htm*", rtype="buyer", rname="用户中心",
	 * rcode="user_center", rgroup="用户中心", display = false, rsequence
	 * = 0)
	 * @RequestMapping({"/buyer/account_bind.htm"})
	 * public ModelAndView account_bind(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * ModelAndView mv = new JModelAndView(
	 * "user/default/usercenter/account_bind.html", this.configService
	 * .getSysConfig(),
	 * this.userConfigService.getUserConfig(), 0, request, response);
	 * User user = this.userService.getObjById(
	 * SecurityUserHolder.getCurrentUser().getId());
	 * mv.addObject("user", user);
	 * return mv;
	 * }
	 * @SecurityMapping(title="账号解除绑定",
	 * value="/buyer/account_bind_cancel.htm*", rtype="buyer",
	 * rname="用户中心", rcode="user_center", rgroup="用户中心", display =
	 * false, rsequence = 0)
	 * @RequestMapping({"/buyer/account_bind_cancel.htm"})
	 * public String account_bind_cancel(HttpServletRequest request,
	 * HttpServletResponse response,
	 * String account) {
	 * ModelAndView mv = new JModelAndView(
	 * "user/default/usercenter/account_bind.html", this.configService
	 * .getSysConfig(),
	 * this.userConfigService.getUserConfig(), 0, request, response);
	 * User user = this.userService.getObjById(
	 * SecurityUserHolder.getCurrentUser().getId());
	 * if (CommUtil.null2String(account).equals("qq")) {
	 * user.setQq_openid(null);
	 * }
	 * if (CommUtil.null2String(account).equals("sina")) {
	 * user.setSina_openid(null);
	 * }
	 * this.userService.update(user);
	 * return "redirect:account_bind.htm";
	 * }
	 */
	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午7:04:55
	 * @todo 发送信息验证
	 * @return void
	 * @param request
	 * @param mark
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	private void send_sms (	HttpServletRequest request , String mark) throws Exception
		{
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templates = this.templateService.getObjectList (templateExample);
			Template template = null;
			if (templates != null && templates.size () > 0)
			{
				template = templates.get (0);
			}
			if ((template != null) && (template.getOpen ()))
			{
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				String mobile = user.getMobile ();
				if ((mobile != null) && (!mobile.equals ("")))
				{
					String path = this.configService.getSysConfig ().getUploadRootPath () + "/vm/";
					PrintWriter pwrite = new PrintWriter (new OutputStreamWriter (new FileOutputStream (path + "msg.vm" , false) , "UTF-8"));
					pwrite.print (template.getContent ());
					pwrite.flush ();
					pwrite.close ();
					Properties p = new Properties ();
					p.setProperty ("file.resource.loader.path" , request.getRealPath ("/") + "vm" + File.separator);
					p.setProperty ("input.encoding" , "UTF-8");
					p.setProperty ("output.encoding" , "UTF-8");
					Velocity.init (p);
					org.apache.velocity.Template blank = Velocity.getTemplate ("msg.vm" , "UTF-8");
					VelocityContext context = new VelocityContext ();
					context.put ("user" , user);
					context.put ("config" , this.configService.getSysConfig ());
					context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
					context.put ("webPath" , CommUtil.getURL (request));
					StringWriter writer = new StringWriter ();
					blank.merge (context , writer);
					String content = writer.toString ();
					this.msgTools.sendSMS (mobile , content);
				}
			}
		}


	/**
	 * @Title: active_application_cash
	 * @Description: 升级V2,支付网络技术服务费
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "buyer/active_appliaction_cash.htm" })
	public ModelAndView active_application_cash (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/active_appliaction_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			/* 获取需要缴纳的保证金 */
			BigDecimal payment = new BigDecimal (Globals.ACTIVE_VIP_2_AMOUNT);
			mv.addObject ("user" , user);
			mv.addObject ("payment" , payment);
			mv.addObject ("orderId" , orderId);
			return mv;
		}


	/**
	 * @Title: active_application_success
	 * @Description: V2升级执行支付请求
	 * @param @param request
	 * @param @param response
	 * @param @param webbankpay
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "buyer/active_application_success.htm" })
	public ModelAndView active_application_success (HttpServletRequest request , HttpServletResponse response ,
													String webbankpay)
		{
			ModelAndView mv = null;
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			/* 获取需要缴纳的保证金 */
			User user = SecurityUserHolder.getCurrentUser ();
			BigDecimal payment = new BigDecimal (Globals.ACTIVE_VIP_2_AMOUNT);
			AlipayOrder order = new AlipayOrder ();
			order.setTotalFee (payment);
			order.setOrderId (orderId);
			order.setUserId (user.getId ());
			this.alipayOrderService.add (order);
			AlipayOrderExample example = new AlipayOrderExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			String payId = this.alipayOrderService.getObjectList (example).get (Globals.NUBER_ZERO).getId ().toString ();
			if (webbankpay.equals ("alipay") || webbankpay.equals ("Unionpay"))
			{
				mv = new JModelAndView ("line_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("payType" , webbankpay);
				mv.addObject ("url" , CommUtil.getURL (request));
				mv.addObject ("payTools" , this.payTools);
				mv.addObject ("type" , "active_vip2");
				mv.addObject ("alipayOrderId" , payId);
			}
			if (webbankpay.equals ("WXPay"))
			{
				String pre_str = null;
				/**
				 * 模式一
				 * String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
				 * Long time_stamp = System.currentTimeMillis() / 1000;
				 * 
				 * pre_str = "weixin://wxpay/bizpayurl?sign=" + WXPay.sign(nonce_str,
				 * time_stamp.toString(), payId.toString())
				 * + "&appid=" + Configure.APP_ID + "&mch_id=" + Configure.MCH_ID
				 * + "&product_id=" + payId + "&time_stamp=" + time_stamp + "&nonce_str=" +
				 * nonce_str;
				 **/
				// 模式二
				String goodsName = "UpGradeVip2";
				String attach = "active_vip2";
				pre_str = payTools.genericWXPay (CommUtil.getURL (request) , Long.valueOf (payId) , goodsName , attach);
				if (pre_str != null)
				{
					mv = new JModelAndView ("wx_pay_pre.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/* 不包含http表示订单号重复了 */
					if (pre_str.contains ("weixin"))
					{
						mv.addObject ("pre_str" , pre_str);
						mv.addObject ("payId" , payId);
					}
					else
					{
						mv.addObject ("message" , pre_str);
					}
				}
			}
			return mv;
		}


	/**
	 * @param urlAll
	 *            :身份证号码验证接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String checkSF (	String httpUrl , String httpArg)
		{
			BufferedReader reader = null;
			String result = null;
			StringBuffer sbf = new StringBuffer ();
			httpUrl = httpUrl + "?" + httpArg;
			try
			{
				URL url = new URL (httpUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
				connection.setRequestMethod ("GET");
				// 填入apikey到HTTP header
				connection.setRequestProperty ("apikey" , "097ce5ee17332e104c5c0ceff7b26117");
				connection.connect ();
				InputStream is = connection.getInputStream ();
				reader = new BufferedReader (new InputStreamReader (is , "UTF-8"));
				String strRead = null;
				while ((strRead = reader.readLine ()) != null)
				{
					sbf.append (strRead);
					sbf.append ("\r\n");
				}
				reader.close ();
				result = sbf.toString ();
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			return result;
		}


	@RequestMapping({ "/buyer/jihuo.htm" })
	public ModelAndView jihuo (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/jihuo.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// User user = SecurityUserHolder.getCurrentUser();
			// if(user.getLevelAngel() > 1)
			// {
			// return new
			// ModelAndView("redirect:/buyer/buyer_index.htm");
			// }
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = SecurityUserHolder.getCurrentUser ();
				currentUser = userService.getByKey (currentUser.getId ());
				System.out.println ("支付密码=" + currentUser.getPayPassword ());
				System.out.println (currentUser.getUsername ());
			}
			LeeConfig leeConfig = LeeConfigurationBuilder.getInstance ().parseConfiguration ();
			BigDecimal v1_amount = leeConfig.getV_three ().getAmount ();
			BigDecimal v2_amount = leeConfig.getV_five ().getAmount ();
			mv.addObject ("v1_amount" , v1_amount);
			mv.addObject ("v2_amount" , v2_amount);
			mv.addObject ("currentUser" , currentUser);
			return mv;
		}


	/**
	 * @Title: recharge_pay
	 * @Description: 升级成为初级会员或者联盟商家
	 * @param request
	 * @param response
	 * @param grade1
	 * @param webbankpay
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "/buyer/upgrade_pay.htm" })
	public ModelAndView upgrade_pay (	HttpServletRequest request , HttpServletResponse response , String grade1 ,
										String webbankpay , String username)
		{
			ModelAndView mv = null;
			if (webbankpay.equals ("AGPay"))
			{
				String pwd = request.getParameter ("payment_pwd");
				System.out.println ("密码=" + pwd);
				User users = SecurityUserHolder.getCurrentUser ();
				User currentUser = SecurityUserHolder.getCurrentUser ();
				if (!pwd.toString ().equals (users.getPayPassword ().toString ()))
				{
					/*
					 * mv = new JModelAndView("error.html",
					 * this.configService.getSysConfig(),
					 * this.userConfigService.getUserConfig(), 1,
					 * request, response);
					 * mv.addObject("op_title", "密码错误");
					 * mv.addObject("url", CommUtil.getURL(request) +
					 * "/buyer/buyer_order.htm");
					 */
					mv = new JModelAndView ("buyer/jihuo.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("msg" , "密码错误");
					mv.addObject ("currentUser" , currentUser);
					return mv;
				}
			}
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			User payUser = SecurityUserHolder.getCurrentUser ();
			User user = null;
			if (!username.trim ().equals (payUser.getUsername ()))
			{
				user = userService.getUserOfUserName (username);
			}
			else
			{
				user = payUser;
			}
			if (user == null)
			{
				return payFail (mv , "没有这个用户" , request , response);
			}
			BigDecimal payment = BigDecimal.ZERO;
			LeeConfig leeConfig = LeeConfigurationBuilder.getInstance ().parseConfiguration ();
			if (grade1.equals (String.valueOf (Globals.NUBER_THREE)))
			{
				/* 已经是初级或高级会员了 */
				if (user.getLevelAngel () >= Globals.NUBER_THREE)
				{
					return payFail (mv , "该会员已经升级过" , request , response);
				}
				payment = leeConfig.getV_three ().getAmount ();
			}
			if (grade1.equals (String.valueOf (Globals.NUBER_FIVE)))
			{
				/* 已经是初级或高级会员了 */
				if (user.getLevelAngel () >= Globals.NUBER_FIVE)
				{
					return payFail (mv , "该会员已经升级过" , request , response);
				}
				payment = leeConfig.getV_five ().getAmount ();
			}
			else if (grade1.equals (String.valueOf (Globals.NUBER_SEVEN)))
			{
				/* 已经是最高级别（超级）会员了,初级可升高级 */
				if (user.getLevelAngel () == Globals.NUBER_FIVE || user.getLevelAngel () == Globals.NUBER_SEVEN)
				{
					return payFail (mv , "该会员已经升级过" , request , response);
				}
				payment = leeConfig.getV_seven ().getAmount ();
			}
			System.err.println ("payment=" + payment);
			/* 清空未完成的会员升级日志 */
			clearVipActiveLog (payUser.getId ());
			/* 保存升级会员日志记录 */
			VipActiveLog vipActiveLog = new VipActiveLog ();
			vipActiveLog.setAddtime (new Date ());
			vipActiveLog.setUserId (user.getId ());
			vipActiveLog.setPayUserId (payUser.getId ());
			userVipActiveService.add (vipActiveLog);
			AlipayOrder order = new AlipayOrder ();
			order.setTotalFee (payment);
			order.setOrderId (orderId);
			order.setUserId (user.getId ());
			this.alipayOrderService.add (order);
			AlipayOrderExample example = new AlipayOrderExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			String payId = this.alipayOrderService.getObjectList (example).get (Globals.NUBER_ZERO).getId ().toString ();
			if (webbankpay.equals ("alipay") || webbankpay.equals ("Unionpay"))
			{
				mv = new JModelAndView ("line_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("payType" , webbankpay);
				mv.addObject ("url" , CommUtil.getURL (request));
				mv.addObject ("payTools" , this.payTools);
				mv.addObject ("type" , "UpGradeVip");
				mv.addObject ("alipayOrderId" , payId);
			}
			if (webbankpay.equals ("WXPay"))
			{
				String pre_str = null;
				/**
				 * 模式一
				 * String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
				 * Long time_stamp = System.currentTimeMillis() / 1000;
				 * 
				 * pre_str = "weixin://wxpay/bizpayurl?sign=" + WXPay.sign(nonce_str,
				 * time_stamp.toString(), payId.toString())
				 * + "&appid=" + Configure.APP_ID + "&mch_id=" + Configure.MCH_ID
				 * + "&product_id=" + payId + "&time_stamp=" + time_stamp + "&nonce_str=" +
				 * nonce_str;
				 **/
				// 模式二
				String goodsName = "";
				if (grade1.equals (String.valueOf (Globals.NUBER_THREE)))
				{
					goodsName = "会员升级联盟商家";
				}
				else if (grade1.equals (String.valueOf (Globals.NUBER_FIVE)))
				{
					goodsName = "会员升级高级联盟商家";
				}
				else if (grade1.equals (Globals.NUBER_SEVEN))
				{
					goodsName = "会员升级超级联盟商家";
					if (user.getLevelAngel () == Globals.NUBER_THREE)
						goodsName = "联盟商家升级超级联盟商家";
				}
				String attach = "UpGradeVip";
				pre_str = payTools.genericWXPay (CommUtil.getURL (request) , Long.valueOf (payId) , goodsName , attach);
				if (pre_str != null)
				{
					mv = new JModelAndView ("wx_pay_pre.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/* 不包含http表示订单号重复了 */
					if (pre_str.contains ("weixin"))
					{
						mv.addObject ("pre_str" , pre_str);
						mv.addObject ("payId" , payId);
					}
					else
					{
						mv.addObject ("message" , pre_str);
					}
				}
			}
			else if (webbankpay.equals ("AGPay"))
			{
				mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				String typeAG = "UpGradeVip";
				String goodsName = "";
				if (grade1.equals (String.valueOf (Globals.NUBER_THREE)))
				{
					goodsName = "会员升级联盟商家";
				}
				else if (grade1.equals (String.valueOf (Globals.NUBER_FIVE)))
				{
					goodsName = "会员升级高级联盟商家";
				}
				else if (grade1.equals (Globals.NUBER_SEVEN))
				{
					goodsName = "会员升级超级联盟商家";
					if (user.getLevelAngel () == Globals.NUBER_THREE)
						goodsName = "联盟商家升级超级联盟商家";
				}
				String str = payTools.genericAGPay (CommUtil.getURL (request) , Long.valueOf (payId) , goodsName , typeAG);
				if (str != null)
				{
					/*
					 * AlipayOrder of = null;//多个订单对应新生成的订单
					 * of = this.alipayOrderService.getByKey(payId);
					 * String outTradeNo = of.getOrderId();// 订单号
					 */mv.addObject ("op_title" , "支付成功");
					mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				}
				else
				{
					mv.addObject ("op_title" , "支付失败，余额不足以支付!");
					mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				}
			}
			return mv;
		}


	@RequestMapping({ "/buyer/recharge_pay.htm" })
	public ModelAndView recharge_pay (	HttpServletRequest request , HttpServletResponse response , String payMent ,
										String webbankpay)
		{
			ModelAndView mv = null;
			BigDecimal rechargeAmount = CommUtil.null2BigDecimal (payMent);
			if (rechargeAmount == null || rechargeAmount.intValue () < 1)
			{
				return payFail (mv , "充值金额小于1元人民币" , request , response);
			}
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			User user = SecurityUserHolder.getCurrentUser ();
			AlipayOrder order = new AlipayOrder ();
			order.setTotalFee (rechargeAmount);
			order.setOrderId (orderId);
			order.setUserId (user.getId ());
			this.alipayOrderService.add (order);
			AlipayOrderExample example = new AlipayOrderExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			String payId = this.alipayOrderService.getObjectList (example).get (Globals.NUBER_ZERO).getId ().toString ();
			if (webbankpay.equals ("alipay") || webbankpay.equals ("Unionpay"))
			{
				mv = new JModelAndView ("line_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("payType" , webbankpay);
				mv.addObject ("url" , CommUtil.getURL (request));
				mv.addObject ("payTools" , this.payTools);
				mv.addObject ("type" , "Recharge");
				mv.addObject ("alipayOrderId" , payId);
			}
			if (webbankpay.equals ("WXPay"))
			{
				String pre_str = null;
				// 模式二
				String goodsName = "会员充值";
				String attach = "Recharge";
				pre_str = payTools.genericWXPay (CommUtil.getURL (request) , Long.valueOf (payId) , goodsName , attach);
				if (pre_str != null)
				{
					mv = new JModelAndView ("wx_pay_pre.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/* 不包含http表示订单号重复了 */
					if (pre_str.contains ("weixin"))
					{
						mv.addObject ("pre_str" , pre_str);
						mv.addObject ("payId" , payId);
					}
					else
					{
						mv.addObject ("message" , pre_str);
					}
				}
			}
			return mv;
		}


	/* 提现 */
	@RequestMapping({ "/buyer/tixian.htm" })
	public ModelAndView tixian (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/tixian.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			BigDecimal fee = this.leeService.getAllowWithdrawDeposit (SecurityUserHolder.getCurrentUser ());
			UserCashDepositLogExample depositLogExample = new UserCashDepositLogExample ();
			depositLogExample.setOrderByClause ("add_time desc");
			depositLogExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <UserCashDepositLog> list = this.cashDepositLogService.getObjectList (depositLogExample);
			UserCashDepositLog userCashDepositLog = null;
			mv.addObject ("fee" , fee);
			if (list != null && list.size () > 0)
			{
				userCashDepositLog = list.get (0);
				// 银行卡提现方式，返回卡号
				if (userCashDepositLog.getCardId () != null && userCashDepositLog.getCardType ().equals ("bank"))
				{
					userCashDepositLog.setCardId (userCashDepositLog.getCardId ().substring (0 , 6) + "******" + userCashDepositLog.getCardId ().substring (userCashDepositLog.getCardId ().length () - 4));
				}
				// 支付宝提现方式，返回支付宝账号
				if (userCashDepositLog.getCardId () != null && userCashDepositLog.getCardType ().equals ("alipay"))
				{
					userCashDepositLog.setCardId (userCashDepositLog.getCardId ());
				}
				mv.addObject ("userCashDepositLog" , userCashDepositLog);
			}
			return mv;
		}


	/* 提现记录 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/buyer/tixian_list.htm" })
	public ModelAndView tixian_list (	HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/tixian_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserCashDepositLogExample depositLogExample = new UserCashDepositLogExample ();
			depositLogExample.createCriteria ().andUserIdEqualTo (user.getId ());
			depositLogExample.setPageNo (CommUtil.null2Int (currentPage));
			depositLogExample.setOrderByClause ("add_time desc");
			Pagination list = this.cashDepositLogService.getObjectListWithPage (depositLogExample);
			List <UserCashDepositLog> lists = new ArrayList <> ();
			if (list.getList () != null && list.getList ().size () > 0)
			{
				for (UserCashDepositLog userCashDepositLog : (List <UserCashDepositLog>) list.getList ())
				{
					if (userCashDepositLog.getCardId () != null)
					{
						userCashDepositLog.setCardId (userCashDepositLog.getCardId ().substring (0 , 6) + "******" + userCashDepositLog.getCardId ().substring (userCashDepositLog.getCardId ().length () - 4));
					}
					lists.add (userCashDepositLog);
				}
			}
			list.setList (lists);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/buyer/tixian_list.htm" , null , "" , list , mv);
			return mv;
		}


	@RequestMapping({ "/apply_cash_deposit.htm" })
	public ModelAndView apply_tixian (	HttpServletRequest request , HttpServletResponse response , String cashFee ,
										String webbankpay , String address , String cardId , String cardId1 ,
										String cardName, String cardCity)
		{
			ModelAndView mv = new JModelAndView ("buyer/tixian_fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null || cardId1 == null || !user.getUsername ().equals (cardId1))
			{
				mv.addObject ("message" , "手机号码必须为此用户手机号");
				return mv;
			}
			BigDecimal fee = new BigDecimal (cashFee);
			if (fee.intValue () < 10)
			{
				mv.addObject ("message" , "最少提现10元");
				return mv;
			}
			if (this.leeService.getAllowWithdrawDeposit (user).compareTo (fee) < 0)
			{
				mv.addObject ("message" , "余额不足");
				return mv;
			}
			UserCashDepositLogExample depositLogExample = new UserCashDepositLogExample ();
			depositLogExample.setOrderByClause ("add_time desc");
			depositLogExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <UserCashDepositLog> list = this.cashDepositLogService.getObjectList (depositLogExample);
			UserCashDepositLog userCashDepositLog = null;
			String str = "";
			if (list != null && list.size () > 0)
			{
				userCashDepositLog = list.get (0);
				if (userCashDepositLog.getCardId () != null)
				{
					str = userCashDepositLog.getCardId ().substring (0 , 6) + "******" + userCashDepositLog.getCardId ().substring (userCashDepositLog.getCardId ().length () - 4);
				}
			}
			/* 提交申请 */
			UserCashDepositLog cashDepositLog = new UserCashDepositLog ();
			cashDepositLog.setAddTime (new Date ());
			cashDepositLog.setAddress (address);
			// 银联支付方式
			if (webbankpay.equals ("unionpay"))
			{
				if (cardId.length () >= 6)
				{
					if (cardId.equals (str))
					{
						cashDepositLog.setCardId (userCashDepositLog.getCardId ());
					}
					else
					{
						cashDepositLog.setCardId (cardId);
					}
				}
				else
				{
					mv.addObject ("message" , "银行卡号不符合要求");
					return mv;
				}
				cashDepositLog.setCardName (user.getTruename ());
			}
			// 支付宝
			else
			{
				cashDepositLog.setCardId (cardId);
				if (cardName.equals (user.getTruename ()))
				{
					cashDepositLog.setCardName (cardName);
				}
				else
				{
					mv.addObject ("message" , "支付宝账号姓名有误");
					return mv;
				}
			}
			cashDepositLog.setCardType (webbankpay);
			cashDepositLog.setFee (fee);
			cashDepositLog.setUserId (user.getId ());
			cashDepositLog.setCardCity(cardCity);
			cashDepositLogService.add (cashDepositLog);
			/* 修改用户金额 */
			userMoneyDetail detail = new userMoneyDetail ();
			detail.setAddTime (new Date ());
			detail.setCanCarry ((user.getCanCarry ().subtract (fee)));
			detail.setDetailFee (BigDecimal.ZERO.subtract (fee));
			detail.setDetailTx (8);
			detail.setManageMoney (user.getManageMoney ());
			detail.setRemark ("申请提现扣除");
			detail.setUserId (user.getId ());
			this.userMoneyDetailService.add (detail);
			user.setCanCarry (user.getCanCarry ().subtract (fee));
			user.setCurrentFee (user.getCurrentFee ().subtract (fee));
			userService.updateByObject (user);
			return new ModelAndView ("redirect:buyer/tixian_list.htm");
		}


	/* 提现成功 */
	@RequestMapping({ "/buyer/tixian_success.htm" })
	public ModelAndView tixian_success (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/tixian_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/* 充值 */
	@RequestMapping({ "/buyer/chongz.htm" })
	public ModelAndView chongz (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/chongz.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/* 代充 */
	@RequestMapping({ "/buyer/duicho.htm" })
	public ModelAndView duicho (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/duicho.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/* 代充成功 */
	@RequestMapping({ "/buyer/duicho_success.htm" })
	public ModelAndView duicho_success (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/duicho_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	private ModelAndView payFail (	ModelAndView mv , String message , HttpServletRequest request ,
									HttpServletResponse response)
		{
			mv = new JModelAndView ("angel_exchange_pay_fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("message" , message);
			return mv;
		}


	/**
	 * 清空旧有会员升级未完成日志
	 * 
	 * @param id
	 */
	private void clearVipActiveLog (Long payUserId)
		{
			VipActiveLogExample example = new VipActiveLogExample ();
			example.createCriteria ().andPayUserIdEqualTo (payUserId).andUpgradeFeeIsNull ().andPayIdIsNull ();
			userVipActiveService.deleteByExample (example);
		}
}
