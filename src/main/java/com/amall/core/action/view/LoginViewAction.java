package com.amall.core.action.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.CommonValues;
import com.amall.common.constant.Globals;
import com.amall.common.constant.WxLoginUtil;
import com.amall.core.bean.Album;
import com.amall.core.bean.EasemobUser;
import com.amall.core.bean.GoldRecordWithBLOBs;
import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;
import com.amall.core.bean.SmsVerification;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.lee.LeeUtil;
// import com.amall.core.jms.producer.ProducerAmallUser;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEasemobUserService;
import com.amall.core.service.ISmsVerificationService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.loginsession.ILoginSessionService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.ISellerAccountService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.HttpRequest;
import com.amall.core.web.tools.ImageViewTools;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.SendSMSVerification;
import com.amall.core.web.tools.SystemMsgTools;
import com.amall.core.web.tools.sms.SendSMS;
import com.amall.core.web.tools.sms.SendSMSOfMengWang;
import com.amall.core.web.ucapi.UCTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class LoginViewAction
{

	Logger logger = Logger.getLogger (LoginViewAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private IGoldRecordService goldRecordService;

	@Autowired
	private ILoginSessionService loginSessionService;

	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private ImageViewTools imageViewTools;

	@Autowired
	private UCTools ucTools;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private SendSMSVerification sendSMSVerification;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreCartService storeCartService;

	@Autowired
	private ISmsVerificationService verificationService;

	@Autowired
	private SendSMS sendSMS;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private SendSMSOfMengWang sendSMSOfMengWang;

	@Autowired
	private CartAndOrderFormViewAction cartAndOrderFormViewAction;

	@Autowired
	private SystemMsgTools sysMsgTools;

	@Autowired
	private ISellerAccountService sellerAccountService;

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	@Autowired
	private IEasemobUserService easemobUserService;


	/**
	 * 用户登陆
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
	@RequestMapping({ "/user/login.htm" })
	public ModelAndView login (	HttpServletRequest request , HttpServletResponse response , String url)
		{
			ModelAndView mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			request.getSession (false).removeAttribute ("verify_code");
			boolean domain_error = CommUtil.null2Boolean (request.getSession (false).getAttribute ("domain_error"));
			if ((url != null) && (!url.equals ("")))
			{
				request.getSession (false).setAttribute ("refererUrl" , url);
			}
			else
			{
				String receive_url = request.getParameter ("url");
				if (receive_url != null && !receive_url.equals (""))
				{
					request.getSession (false).setAttribute ("refererUrl" , receive_url);
				}
			}
			if (domain_error)
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			else
			{
				mv.addObject ("imageViewTools" , this.imageViewTools);
			}
			mv.addObject ("uc_logout_js" , request.getSession (false).getAttribute ("uc_logout_js"));
			return mv;
		}


	/**
	 * <p>
	 * Title: register
	 * </p>
	 * <p>
	 * Description: 注册
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping({ "/register.htm" })
	public ModelAndView register (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("register.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			request.getSession (false).removeAttribute ("verify_code");
			return mv;
		}


	/**
	 * 手机验证码发送验证
	 * 
	 * @param request
	 * @param response
	 * @param phoneNum
	 * @return
	 */
	@RequestMapping({ "/send_sms.htm" })
	public @ResponseBody String send_sms (	HttpServletRequest request , HttpServletResponse response ,
											String phoneNum , String forgot , String codes , String code_name)
		{
			boolean existExample = true; // 是否存在实例
			// 1情况,有codes+verify_code，2情况，有forgot=true，并且phoneNum必须注册
			HttpSession session = request.getSession (false);
			String verify_code = "";
			if (CommUtil.null2String (code_name).equals (""))
				verify_code = (String) session.getAttribute ("verify_code");
			else
			{
				verify_code = (String) session.getAttribute (code_name);
			}
			if ((codes == null || codes.equals ("") || verify_code == null || verify_code.equals ("")) && !forgot.equals ("true"))
			{
				return Globals.SEND_SMS_ERROR;
			}
			System.out.println ("verify_code(Login)= : " + verify_code + ",codes=" + codes + ",forgot=" + forgot + ",phone=" + phoneNum);
			if ((codes != null) && (!codes.equals ("")) && (!CommUtil.null2String (codes.toUpperCase ()).equals (verify_code)))
			{
				return Globals.NULL_PHONE;
			}
			if (phoneNum == null || phoneNum.trim ().equals (""))
			{
				return Globals.NULL_PHONE;
			}
			if (forgot != null && forgot.equals ("true"))
			{
				if (!this.sendSMSVerification.isExistPhoneInUser (phoneNum.trim ()))
				{
					return Globals.SEND_PHONE_IS_NULL;
				}
			}
			// 判断该手机号是否存在注册成功用户中
			if (this.sendSMSVerification.isExistPhoneInUser (phoneNum.trim ()) && (forgot == null || !forgot.equals ("true")))
			{
				return Globals.EXIST_PHONE;
			}
			SmsVerification smsVerification = null;
			// 判断该手机是否有发送记录
			smsVerification = this.sendSMSVerification.isExistPhoneInVerification (phoneNum);
			if (smsVerification != null)
			{
				// 判断是否超出最大发送条数限制
				if (this.sendSMSVerification.isExceedMaxSmsNum (smsVerification))
				{
					return Globals.Exceed_MAX_NUMBER;
				}
				// 判断两次发送是否在间隔内
				if (this.sendSMSVerification.isSendInterval (smsVerification))
				{
					return Globals.IN_INTERVAL;
				}
			}
			// 再次获取记录，考虑两次发送天数不同会清空发送次数
			smsVerification = this.sendSMSVerification.isExistPhoneInVerification (phoneNum);
			if (smsVerification == null)
			{
				smsVerification = new SmsVerification ();
				existExample = false;
			}
			// 生成短信记录
			smsVerification.setSmsCreateDate (String.valueOf (System.currentTimeMillis ()));
			// 生成随机验证码
			String length = this.configService.getSysConfig ().getVerificationCodeLength ();
			String code = CommUtil.randomNumberString (Integer.valueOf (length));
			String validTime = this.configService.getSysConfig ().getSmsExceedTime ();
			smsVerification.setSmsPhone (phoneNum);
			if (smsVerification.getSmsCount () != null)
			{
				smsVerification.setSmsCount (smsVerification.getSmsCount () + Globals.NUBER_ONE);
			}
			else
			{
				smsVerification.setSmsCount (Globals.NUBER_ONE);
			}
			if (existExample)
			{
				this.verificationService.updateByObject (smsVerification);
			}
			else
			{
				this.verificationService.add (smsVerification);
			}
			// 发送短信【天使商城】验证码：{变量}，有效时间为5分钟，祝您在天使商城购物愉快！
			// if(this.msgTools.sendValidateCodeOfSMS(phoneNum, code))
			System.out.println ("code -> " + code);
			if (this.sendSMS.sendMessage (phoneNum , code , Integer.valueOf (validTime)))
			{
				System.out.println ("到这里短信发送成功； verify_code ： " + (verify_code == null ? null : verify_code.toString ()));
				// 保存验证码到session,保存发送时间到session
				request.getSession ().setAttribute (Globals.SMS_CODE , code);
				request.getSession ().setAttribute (Globals.SMS_CODE_TIME , smsVerification.getSmsCreateDate ());
				return Globals.SEND_SMS_SUCCESSFULLY;
			}
			else
			{
				// 短信验证码应急措施
				/*
				 * request.getSession().setAttribute(Globals.SMS_CODE,
				 * code);
				 * request.getSession().setAttribute(Globals.SMS_CODE_TIME
				 * ,
				 * smsVerification.getSmsCreateDate());
				 * return Globals.SEND_SMS_SUCCESSFULLY;
				 */
				return Globals.SEND_SMS_ERROR;
			}
		}


	@RequestMapping({ "/seller_account_sms.htm" })
	public @ResponseBody String seller_account_sms (HttpServletRequest request , HttpServletResponse response ,
													String phoneNum , String forgot)
		{
			return Globals.SEND_SMS_ERROR;
			/*
			 * boolean existExample = true; // 是否存在实例
			 * if (phoneNum == null || phoneNum.trim().equals("")) {
			 * return Globals.NULL_PHONE;
			 * }
			 * SmsVerification smsVerification = null;
			 * // 判断该手机是否有发送记录
			 * smsVerification = this.sendSMSVerification
			 * .isExistPhoneInVerification(phoneNum);
			 * if (smsVerification != null) {
			 * // 判断是否超出最大发送条数限制
			 * if
			 * (this.sendSMSVerification.isExceedMaxSmsNum(smsVerification
			 * )) {
			 * return Globals.Exceed_MAX_NUMBER;
			 * }
			 * // 判断两次发送是否在间隔内
			 * if
			 * (this.sendSMSVerification.isSendInterval(smsVerification
			 * )) {
			 * return Globals.IN_INTERVAL;
			 * }
			 * }
			 * // 再次获取记录，考虑两次发送天数不同会清空发送次数
			 * smsVerification = this.sendSMSVerification
			 * .isExistPhoneInVerification(phoneNum);
			 * if (smsVerification == null) {
			 * smsVerification = new SmsVerification();
			 * existExample = false;
			 * }
			 * // 生成短信记录
			 * smsVerification.setSmsCreateDate(String.valueOf(System
			 * .currentTimeMillis()));
			 * // 生成随机验证码
			 * String length = this.configService.getSysConfig()
			 * .getVerificationCodeLength();
			 * String code =
			 * CommUtil.randomNumberString(Integer.valueOf(length));
			 * String validTime =
			 * this.configService.getSysConfig().getSmsExceedTime();
			 * smsVerification.setSmsPhone(phoneNum);
			 * if (smsVerification.getSmsCount() != null) {
			 * smsVerification.setSmsCount(smsVerification.getSmsCount(
			 * )
			 * + Globals.NUBER_ONE);
			 * } else {
			 * smsVerification.setSmsCount(Globals.NUBER_ONE);
			 * }
			 * if (existExample) {
			 * this.verificationService.updateByObject(smsVerification)
			 * ;
			 * } else {
			 * this.verificationService.add(smsVerification);
			 * }
			 * // 发送短信【天使商城】验证码：{变量}，有效时间为5分钟，祝您在天使商城购物愉快！
			 * // if(this.msgTools.sendValidateCodeOfSMS(phoneNum,
			 * code))
			 * System.out.println("code -> " + code);
			 * if (this.sendSMS.sendMessage(phoneNum, code,
			 * Integer.valueOf(validTime))) {
			 * System.out.println("到这里短信发送成功； ：seller_account_sms.htm "
			 * );
			 * // 保存验证码到session,保存发送时间到session
			 * request.getSession().setAttribute(Globals.SMS_CODE,
			 * code);
			 * request.getSession().setAttribute(Globals.SMS_CODE_TIME,
			 * smsVerification.getSmsCreateDate());
			 * return Globals.SEND_SMS_SUCCESSFULLY;
			 * } else {
			 * // //短信验证码应急措施
			 * //request.getSession().setAttribute(Globals.SMS_CODE,
			 * code);
			 * //request.getSession().setAttribute(Globals.SMS_CODE_TIME
			 * ,
			 * // smsVerification.getSmsCreateDate());
			 * //return Globals.SEND_SMS_SUCCESSFULLY;
			 * return Globals.SEND_SMS_ERROR;
			 * }
			 */
		}


	@RequestMapping({ "/register_finish.htm" })
	public String register_finish (	HttpServletRequest request , HttpServletResponse response , String userName ,
									String password , String trueName , String code , String smsFlag , String smscode) throws HttpException , IOException
		{
			boolean reg = true;
			String codes = null;
			String validate = null;
			if ((code != null) && (!code.equals ("")))
			{
				code = CommUtil.filterHTML (code);
			}
			if (password == null || password.equals ("") || password.length () < 6)
			{
				reg = false;
				codes = "3";
			}
			if (this.configService.getSysConfig ().getSecuritycoderegister ())
			{
				String verifyCode = (String) request.getSession (false).getAttribute ("verify_code");
				if (verifyCode != null && !verifyCode.equals (code))
				{
					reg = false;
				}
			}
			// 判断短信是否过期和匹配
			String sessionCode = (String) request.getSession (false).getAttribute (Globals.SMS_CODE);
			String oldTime = (String) request.getSession (false).getAttribute (Globals.SMS_CODE_TIME);
			if (sessionCode == null || oldTime == null)
			{
				reg = false;
			}
			else
			{
				long interval = CommUtil.getTimeInterval (oldTime , String.valueOf (System.currentTimeMillis ()));
				int exceedTime = Integer.valueOf (this.configService.getSysConfig ().getSmsExceedTime ());
				long temp = exceedTime * Globals.SECOND_TO_MINUTE;
				if (!sessionCode.equals (smscode) || temp < interval)
				{
					reg = false;
				}
				// 释放验证码session
				request.getSession ().removeAttribute (Globals.SMS_CODE);
				request.getSession ().removeAttribute (Globals.SMS_CODE_TIME);
			}
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = this.userService.getObjectList (userExample);
			if ((users != null) && (users.size () > 0))
			{
				reg = false;
				codes = "1";
			}
			if (reg)
			{
				// 注册成功!
				User user = register (userName , trueName , password , null , null , false , request);
				System.out.println ("用户id" + user.getId ());
				logger.info ("用户id" + user.getId ());
				/*
				 * User Users = new User();
				 * Users.setGold(CommonValues.
				 * SYSTEM_SEND_REDPAPER_ZENGSONG_GLOD_FIVE);
				 * Users.setId(user.getId());
				 * userService.updateUsers(Users);
				 */
				request.getSession (false).removeAttribute ("verify_code");
				return "redirect:amall_login.htm?username=" + CommUtil.encode (userName) + "&password=" + password + "&encode=true";
			}
			return "redirect:user_login_success.htm";
		}


	/**
	 * @Title: register_zhibo
	 * @Description: 直播注册后再推送到这里进行商城注册
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author sstian
	 * @date 2016年8月
	 */
	@RequestMapping({ "/register_zhibo.htm" })
	@ResponseBody
	public String register_zhibo (	HttpServletRequest request , HttpServletResponse response , String userName ,
									String password , String trueName , String validate) throws HttpException , IOException
		{
			boolean reg = true;
			String codes = null;
			if (userName == null || userName.equals (""))
			{
				reg = false;
				codes = "4";
			}
			if (password == null || password.equals ("") || password.length () < 6)
			{
				reg = false;
				codes = "3";
			}
			if (validate == null || validate.equals (""))
			{
				reg = false;
				codes = "5";
			}
			if (trueName == null || trueName.equals (""))
				trueName = "zhibo_user";
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = this.userService.getObjectList (userExample);
			if ((users != null) && (users.size () > 0))
			{
				reg = false;
				codes = "1";
			}
			if (reg)
			{
				register (userName , trueName , password , null , null , true , request);
				return "{code:\"0\",msg:\"\"}";
			}
			return "{code:\"" + codes + "\",msg:\"\"}";
		}


	/**
	 * @Title: wx_login
	 * @Description: 微信登陆
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年5月27日
	 */
	@RequestMapping({ "/wx_login.htm" })
	public ModelAndView wx_login (	HttpServletRequest request , HttpServletResponse response , String code)
		{
			if (StringUtils.isEmpty (code))
			{
				return new ModelAndView ("redirect:user/login.htm");
			}
			String result = WxLoginUtil.getAccessTokenResult (code);
			if (StringUtils.isEmpty (result))
			{
				return new ModelAndView ("redirect:user/login.htm");
			}
			String token = WxLoginUtil.getValueOfJsonStr ("access_token" , result);
			String openid = WxLoginUtil.getValueOfJsonStr ("openid" , result);
			String userInfo = WxLoginUtil.getUserInfo (token , openid);
			String unionID = WxLoginUtil.getValueOfJsonStr ("unionid" , userInfo);
			if (StringUtils.isEmpty (unionID))
			{
				return new ModelAndView ("redirect:user/login.htm");
			}
			UserExample example = new UserExample ();
			example.createCriteria ().andWxOpenidEqualTo (unionID);
			List <User> users = userService.getObjectList (example);
			User user = null;
			if (!users.isEmpty ())
			{
				user = users.get (0);
			}
			else
			{
				ModelAndView mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				String nickname = WxLoginUtil.getValueOfJsonStr ("nickname" , userInfo);
				mv.addObject ("nickname" , nickname);
				mv.addObject ("openid" , unionID);
				return mv;
			}
			request.getSession (false).removeAttribute ("verify_code");
			String url = "redirect:amall_login.htm?username=" + CommUtil.encode (user.getUsername ()) + "&password=" + user.getPassword () + "&encode=true";
			return new ModelAndView (url);
		}


	@RequestMapping({ "/wx_user_check.htm" })
	@ResponseBody
	public String wx_user_check (	HttpServletRequest request , HttpServletResponse response , String username)
		{
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (username);
			return userService.getObjectListCount (example) > 0 ? "1" : "0";
		}


	@RequestMapping({ "/wx_user_bind.htm" })
	public String wx_user_bind (HttpServletRequest request , HttpServletResponse response , String username ,
								String openid)
		{
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (username);
			List <User> list = userService.getObjectList (example);
			User user = null;
			if (!list.isEmpty ())
			{
				user = list.get (0);
				user.setWxOpenid (openid);
				userService.updateByObject (user);
				request.getSession (false).removeAttribute ("verify_code");
				return "redirect:amall_login.htm?username=" + CommUtil.encode (username) + "&password=" + user.getPassword () + "&encode=true" + "&type=wx";
			}
			return "redirect:user/login.htm";
		}


	@RequestMapping({ "/wx_register.htm" })
	public String wx_register (	HttpServletRequest request , HttpServletResponse response , String trueName1 ,
								String userName1 , String password1 , String openid)
		{
			if (StringUtils.isEmpty (trueName1) || StringUtils.isEmpty (userName1) || StringUtils.isEmpty (password1) || StringUtils.isEmpty (openid))
			{
				return "redirect:user/login.htm";
			}
			register (userName1 , trueName1 , password1 , null , openid , false , request);
			request.getSession (false).removeAttribute ("verify_code");
			return "redirect:amall_login.htm?username=" + CommUtil.encode (userName1) + "&password=" + password1 + "&encode=true";
		}


	/*
	 * 欢迎页
	 */
	@RequestMapping({ "/welcome.htm" })
	public ModelAndView welcome (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("welcome.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("goodsClassList");
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			return mv;
		}


	@RequestMapping({ "/user_login_success.htm" })
	public String user_login_success (	HttpServletRequest request , HttpServletResponse response , String url)
		{
			User user = null;
			HttpSession session = request.getSession (false);
			/* 登录成功判断是否选择自动登录，选择自动登录则保存cookie */
			user = SecurityUserHolder.getCurrentUser ();
			if (user == null || user.getDeletestatus ())
			{
				return "redirect:/amall_logout.htm";
			}
			String isAutoLogin = (String) session.getAttribute ("autologin");
			if (user != null && isAutoLogin != null && isAutoLogin.equals ("true"))
			{
				autoLoginSaveCookie (user.getUsername () , response);
				session.removeAttribute ("autologin");
			}
			/* 同步购物车cookie信息 */
			this.cartAndOrderFormViewAction.synchronizationDBCartAndCookieCart (user.getId () , request , response);
			/* 微信登录判断 */
			String type = (String) session.getAttribute ("type");
			if (StringUtils.isNotEmpty (type))
			{
				session.removeAttribute ("type");
				if ("wx".equals (type))
				{
					return "redirect:/index.htm";
				}
			}
			/* 刚注册的欢迎页 */
			Date nowTime = new Date ();
			if (CommUtil.getTimeInterval (String.valueOf (user.getAddtime ().getTime ()) , String.valueOf (nowTime.getTime ())) < 10)
			{
				return "redirect:/welcome.htm";
			}
			String local = (String) session.getAttribute ("refererUrl");
			if (!StringUtils.isEmpty (local))
			{
				session.removeAttribute ("refererUrl");
				return "redirect:" + local;
			}
			String uri = (String) session.getAttribute ("uri");
			String parameter = (String) session.getAttribute ("parameter");
			return "redirect:" + uri + parameter;
		}


	/**
	 * 自动登录保存cookie 不安全方案：用户ID保存到cookie，时间周期设置为1周 其中
	 * 
	 * @param userId
	 * @param random
	 */
	public void autoLoginSaveCookie (	String username , HttpServletResponse response)
		{
			try
			{
				CommUtil.addCookie (Globals.COOKIE_KEY_NAME , URLEncoder.encode (username , "UTF-8") , Globals.WEEK , response);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
		}


	@RequestMapping({ "/user_dialog_login.htm" })
	public ModelAndView user_dialog_login (	HttpServletRequest request , HttpServletResponse response , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("user_dialog_login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("conf" , this.configService.getSysConfig ());
			mv.addObject ("goodsId" , goodsId);
			return mv;
		}


	@RequestMapping({ "/login_block.htm" })
	public ModelAndView login_block (	HttpServletRequest request , HttpServletResponse response , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("login_block.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	@RequestMapping({ "/client_order.htm" })
	public String client_order (HttpServletRequest request , HttpServletResponse response)
		{
			/* 判断是否是客户端查看 */
			String client = request.getParameter ("client");
			if (client != null && client.trim ().equals ("true"))
			{
				String username = request.getParameter ("username");
				String pwd = request.getParameter ("password");
				if (username == null || username.equals ("") || pwd == null || pwd.equals (""))
				{
					return "redirect:/login_error.htm";
				}
				else
				{
					return "redirect:amall_login.htm?username=" + CommUtil.encode (username) + "&password=" + pwd + "&client=true";
				}
			}
			return "redirect:/login_error.htm";
		}


	@RequestMapping({ "/check_phone.htm" })
	public @ResponseBody String check_phone (	HttpServletRequest request , HttpServletResponse response ,
												String phoneNum) throws HttpException , IOException
		{
			if (StringUtils.isEmpty (phoneNum))
			{
				return Globals.RETURN_FALSE;
			}
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (phoneNum);
			if (this.userService.getObjectListCount (example) > 0)
			{
				return Globals.RETURN_TRUE;
			}
			return Globals.RETURN_FALSE;
		}


	@RequestMapping({ "/share_register.htm" })
	public String share_register (	HttpServletRequest request , HttpServletResponse response , String trueName ,
									String userName , String password , String smscode , String pid , String did ,
									String redno) throws HttpException , IOException
		{
			if (userName == null || userName.equals ("") || password == null || password.equals ("") || smscode == null || smscode.equals (""))
			{
				return "redirect:register.htm";
			}
			if (did.equals (""))
			{
				return "redirect:register.htm";
			}
			/* 判断链接是否已经推广满了,满了则直接跳转到普通注册 */
			User user3 = checkdirectUser (Long.valueOf (did));
			if (user3 == null)
			{
				return "redirect:register.htm";
			}
			boolean reg = false;
			// 判断短信是否过期和匹配
			String sessionCode = (String) request.getSession (false).getAttribute (Globals.SMS_CODE);
			/* 判断是否有发短信 */
			if (sessionCode == null || sessionCode.equals (""))
			{
				return "redirect:register.htm";
			}
			String oldTime = (String) request.getSession (false).getAttribute (Globals.SMS_CODE_TIME);
			long interval = CommUtil.getTimeInterval (oldTime , String.valueOf (System.currentTimeMillis ()));
			int exceedTime = Integer.valueOf (this.configService.getSysConfig ().getSmsExceedTime ());
			long temp = exceedTime * Globals.SECOND_TO_MINUTE;
			if (!sessionCode.equals (smscode) || temp < interval)
			{
				return "redirect:register.htm";
			}
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = this.userService.getObjectList (userExample);
			if (users == null || users.isEmpty ())
			{
				reg = true;
			}
			if (reg)
			{
				User user = register (userName , trueName , password , user3.getId () , null , false , request);
				System.out.println ("用户id" + user.getId ());
				logger.info ("用户id" + user.getId ());
				/*
				 * User Users = new User();
				 * Users.setGold(5);
				 * Users.setId(user.getId());
				 * userService.updateUsers(Users);
				 */
				request.getSession (false).removeAttribute ("verify_code");
				if (user3.getLevelAngel () >= Globals.NUBER_THREE)
				{
					// 限制高级会员推广时作假
					UserExample userExample2 = new UserExample ();
					userExample2.createCriteria ().andDirectReferEqualTo (user3.getId ());
					// 总计直接推广人数
					Integer VipCount = this.userService.getObjectListCount (userExample2);
					// 直接推广人中升级的高级会员数
					Integer Vip2Count = getVip2UserCount (userExample2);
					// 推广奖励限制数
					Integer astrictCount = (Vip2Count * CommonValues.GENERALIZE_INCREASE_VALUE) + CommonValues.GENERALIZE_INITIAL_VALUE;
					if (VipCount <= astrictCount)
					{
						logger.info ("高级会员推广分红奖励开始-------");
						if (user3.getCurrentFee () == null)
						{
							user3.setCurrentFee (new BigDecimal (0.0));
						}
						if (user3.getHistoryFee () == null)
						{
							user3.setHistoryFee (new BigDecimal (0.0));
						}
						logger.info ("修改前历史总金额：" + user3.getHistoryFee ());
						logger.info ("修改前当前总金额：" + user3.getCurrentFee ());
						BigDecimal rate = LeeUtil.getConfigInstance ().getBenefitRate ();
						BigDecimal rate2 = (new BigDecimal (1)).subtract (rate);
						userMoneyDetail detail = new userMoneyDetail ();
						detail.setAddTime (new Date ());
						detail.setCanCarry (user3.getCanCarry () != null ? user3.getCanCarry ().add (CommonValues.REWAEDS_PROMOTION.multiply (rate)) : CommonValues.REWAEDS_PROMOTION.multiply (rate));
						detail.setDetailFee (CommonValues.REWAEDS_PROMOTION);
						detail.setDetailTx (11);
						detail.setManageMoney (user3.getManageMoney () != null ? user3.getManageMoney ().add (CommonValues.REWAEDS_PROMOTION.multiply (rate2)) : CommonValues.REWAEDS_PROMOTION.multiply (rate2));
						detail.setRemark ("高级会员推广分红");
						detail.setUserId (user3.getId ());
						this.userMoneyDetailService.add (detail);
						user3.setCanCarry (user3.getCanCarry () != null ? user3.getCanCarry ().add (CommonValues.REWAEDS_PROMOTION.multiply (rate)) : CommonValues.REWAEDS_PROMOTION.multiply (rate));
						user3.setManageMoney (user3.getManageMoney () != null ? user3.getManageMoney ().add (CommonValues.REWAEDS_PROMOTION.multiply (rate2)) : CommonValues.REWAEDS_PROMOTION.multiply (rate2));
						user3.setCurrentFee (user3.getCurrentFee ().add (CommonValues.REWAEDS_PROMOTION));
						user3.setHistoryFee (user3.getHistoryFee ().add (CommonValues.REWAEDS_PROMOTION));
						this.userService.updateByObject (user3);
						logger.info ("修改后历史总金额：" + user3.getHistoryFee ());
						logger.info ("修改后当前总金额：" + user3.getCurrentFee ());
						MutualBenefit benefit = new MutualBenefit ();
						benefit.setAddTime (new Date ());
						benefit.setGetUserId (user3.getId ());
						benefit.setGiveUserId (user.getId ());
						BigDecimal fee = CommonValues.REWAEDS_PROMOTION;
						benefit.setMutualFee (fee);
						this.mutualBenefitService.add (benefit);
						logger.info ("高级会员推广分红奖励结束-------");
					}
					else
					{
						logger.info ("高级会员推广限制奖励开始-------");
						Integer user3Gold = user3.getGold ();
						if (user3Gold == null)
						{
							user3Gold = 0;
						}
						user3.setGold (user3Gold + CommonValues.COMMON_GOLD);
						this.userService.updateByObject (user3);
						// 保存赠送礼品金信息到goldRecord表里面；
						GoldRecordWithBLOBs goldRecord = new GoldRecordWithBLOBs ();
						goldRecord.setAddtime (new Date ());
						goldRecord.setGoldCount (CommonValues.COMMON_GOLD);
						goldRecord.setGoldUserId (user3.getId ());
						goldRecord.setGoldPayment ("高级会员达到推广限制后奖励礼品金");
						goldRecord.setGoldSn ("share");
						this.goldRecordService.add (goldRecord);
						logger.info ("高级会员推广限制奖励结束-------");
					}
				}
				else
				{
					Integer user3Gold = user3.getGold ();
					if (user3Gold == null)
					{
						user3Gold = 0;
					}
					user3.setGold (user3Gold + CommonValues.COMMON_GOLD);
					this.userService.updateByObject (user3);
					// 保存赠送礼品金信息到goldRecord表里面；
					GoldRecordWithBLOBs goldRecord = new GoldRecordWithBLOBs ();
					goldRecord.setAddtime (new Date ());
					goldRecord.setGoldCount (CommonValues.COMMON_GOLD);
					goldRecord.setGoldUserId (user3.getId ());
					goldRecord.setGoldPayment ("普通会员推广奖励礼品金");
					goldRecord.setGoldSn ("share");
					this.goldRecordService.add (goldRecord);
				}
			}
			return "redirect:amall_login.htm?username=" + CommUtil.encode (userName) + "&password=" + password + "&encode=true";
		}


	private Integer getVip2UserCount (	UserExample userExample2)
		{
			List <User> list = this.userService.getObjectList (userExample2);
			Integer count = 0;
			if (list != null)
			{
				for (User user : list)
				{
					if (user.getLevelAngel () == 2)
					{
						count += 1;
					}
				}
			}
			return count;
		}


	@RequestMapping({ "/checkdirectUserValid.htm" })
	@ResponseBody
	public String checkdirectUserValid (HttpServletRequest request , HttpServletResponse response , String did)
		{
			Long id = Long.valueOf (did);
			if (id != null)
			{
				if (checkdirectUser (id) != null)
				{
					return "1";
				}
			}
			return "0";
		}


	/**
	 * @Title: checkdirectUser
	 * @Description: 检查推荐人是否还可以再次推荐
	 * @param id
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月19日
	 */
	public User checkdirectUser (	Long id)
		{
			User user = this.userService.getByKey (id);
			if (user == null)
			{
				return null;
			}
			return user;
		}


	/**
	 * 检查用户是否存在
	 * 
	 * @param request
	 * @param response
	 * @param uname
	 * @param upwd
	 * @return
	 */
	@RequestMapping({ "/checkexist.htm" })
	@ResponseBody
	public String checkexist (	HttpServletRequest request , HttpServletResponse response , String uname , String upwd ,
								String code)
		{
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (uname).andPasswordEqualTo (upwd).andDeletestatusEqualTo (false);
			List <User> users = this.userService.getObjectList (userExample);
			String msg = "";
			HttpSession session = request.getSession ();
			String _code = session.getAttribute ("verify_code").toString ();
			if (users.isEmpty ())
			{
				msg = "用户名或密码错误";
				return "{\"pass\":\"0\",\"msg\":\"" + msg + "\"}";
			}
			code = code.toUpperCase ();
			if (!code.equals (_code))
			{
				msg = "验证码错误";
				return "{\"pass\":\"0\",\"msg\":\"" + msg + "\"}";
			}
			else
			{
				return "{\"pass\":\"1\",\"msg\":\"" + msg + "\"}";
			}
		}


	/**
	 * 商家子账号的判断
	 * 
	 * @Title: checkexist2
	 * @Description: TODO
	 * @param @param request
	 * @param @param response
	 * @param @param uname
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping({ "/checkexist2.htm" })
	@ResponseBody
	public String checkexist2 (	HttpServletRequest request , HttpServletResponse response , String uname)
		{
			User user1 = SecurityUserHolder.getCurrentUser ();
			if (user1 == null)
			{
				return "redirect:/amall_logout.htm";
			}
			else
			{
				user1 = this.userService.getByKey (user1.getId ());
			}
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (uname).andDeletestatusEqualTo (false);
			List <User> users = this.userService.getObjectList (userExample);
			String msg = "";
			if (!users.isEmpty ())
			{
				User user = users.get (Globals.NUBER_ZERO);
				// 1.是梦想会员,V2，或者是商家自己,或者已经是商家账号,都不能成子账号
				// 2.在子账号表里已经存在了(不能重复保存子账号),并且一个子账号不能属于多个商家
				SellerAccountExample sellerAccountExample = new SellerAccountExample ();
				sellerAccountExample.createCriteria ().andUserIdEqualTo (user.getId ()).andTypeEqualTo (Globals.SELLER_ACCOUNT_TYPE_PC);
				List <SellerAccount> list2 = this.sellerAccountService.getObjectList (sellerAccountExample);
				boolean isV2 = false;
				if (user.getLevelAngel () != null)
				{
					if (user.getLevelAngel () == 2)
					{
						isV2 = true;
					}
				}
				if (isV2 || uname.equalsIgnoreCase (user1.getUsername ()) || user.getUserrole ().equals ("BUYER_SELLER") || (!list2.isEmpty ()))
				{
					return "{\"pass\":\"0\",\"msg\":\"" + msg + "\"}";
				}
				else
				{
					msg = user.getTruename ();
					return "{\"pass\":\"1\",\"msg\":\"" + msg + "\"}";
				}
			}
			else
			{
				msg = "";
				return "{\"pass\":\"2\",\"msg\":\"" + msg + "\"}";
			}
		}


	/**
	 * 分红系统更改会员推荐关系,更新原推荐人和新推荐人的礼品金
	 * 
	 * @Title: updateUserGold2
	 * @Description: TODO
	 * @param @param request
	 * @param @param response
	 * @param @param oldDirect
	 * @param @param newDirect
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping({ "/updateUserGold2.htm" })
	@ResponseBody
	public String updateUserGold2 (	HttpServletRequest request , HttpServletResponse response , String oldDirect ,
									String newDirect)
		{
			try
			{
				UserExample userExample = new UserExample ();
				List <User> users = null;
				if (StringUtils.isNotEmpty (oldDirect))
				{
					userExample.createCriteria ().andIdEqualTo (Long.valueOf (oldDirect));
					users = this.userService.getObjectList (userExample);
					if (!users.isEmpty ())
					{
						User user = users.get (0);
						// 礼品金要大5,不能出现负数,如果礼品金已消费
						if (user.getGold () > Globals.shareGold)
						{
							user.setGold (user.getGold () - Globals.shareGold);
							userService.updateByObject (user);
							logger.info ("updateUserGold : 更改推荐人关系,原推荐人礼品金减5");
						}
					}
				}
				userExample.clear ();
				userExample.createCriteria ().andIdEqualTo (Long.valueOf (newDirect));
				users = this.userService.getObjectList (userExample);
				if (!users.isEmpty ())
				{
					User user = users.get (0);
					user.setGold (user.getGold () + Globals.shareGold);
					userService.updateByObject (user);
					logger.info ("updateUserGold : 更改推荐人关系,新推荐人礼品金+5");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return "fail";
			}
			return "ok";
		}


	@RequestMapping({ "/easemobUser.htm" })
	@ResponseBody
	public String easemobUser (	HttpServletRequest request , HttpServletResponse response , String userid)
		{
			EasemobUser user = easemobUserService.getUser (Long.parseLong (userid));
			return Json.toJson (user);
		}


	@RequestMapping({ "/easemobLogin.htm" })
	public ModelAndView easemobLogin (	HttpServletRequest request , HttpServletResponse response , String singleUserId)
		{
			ModelAndView mv = new JModelAndView ("im/newindex.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (null == user)
			{
				return new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			EasemobUser euser = easemobUserService.getUser (user.getId ());
			mv.addObject ("obj" , euser);
			return mv;
		}


	public User register (	String userName , String trueName , String password , Long DirectReferUserId ,
							String openid , boolean fromZhibo , HttpServletRequest request)
		{
			/* 先查询是否有用户，没有再创建 */
			User user = new User ();
			user.setTruename (trueName);
			user.setUsername (userName);
			user.setUserrole ("BUYER");
			user.setSex (-1);
			user.setLoginip (CommUtil.getIpAddr (request));
			/*
			 * user.setGold(CommonValues.
			 * SYSTEM_SEND_REDPAPER_ZENGSONG_GLOD_FIVE);
			 */
			user.setAddtime (new Date ());
			user.setTelephone (userName);
			user.setPassword (password);
			user.setWxOpenid (openid);
			// 设置分享注册的直接推荐人
			user.setDirectRefer (DirectReferUserId);
			// 分享注册用户,天使会员,v0
			user.setLevelAngel (Globals.NUBER_ZERO);
			RoleExample example = new RoleExample ();
			example.createCriteria ().andTypeEqualTo ("BUYER");
			List <Role> roles = this.roleService.getObjectList (example);
			user.getRoles ().addAll (roles);
			User user2 = null;
			if (this.configService.getSysConfig ().getIntegral ())
			{
				/* user.setIntegral(Globals.NUBER_FIFTY); */
				Long id = this.userService.add (user);
				System.out.println ("id=" + id);
				UserExample userExample2 = new UserExample ();
				UserExample.Criteria userCriteria = userExample2.createCriteria ();
				userCriteria.andUsernameEqualTo (userName);
				user2 = userService.getObjectList (userExample2).get (0);
				user.setId (user2.getId ());
				Iterator <Role> roles2 = user.getRoles ().iterator ();
				while (roles2.hasNext ())
				{
					Role role = roles2.next ();
					Map map = new HashMap ();
					map.put ("userId" , user2.getId ());
					map.put ("roleId" , role.getId ());
					this.userService.insertUserRole (map);
				}
				/*
				 * IntegralLog log = new IntegralLog();
				 * log.setAddtime(new Date());
				 * log.setContent("用户注册增加"
				 * + Globals.NUBER_FIFTY
				 * + "代金券");
				 * log.setIntegral(this.configService.getSysConfig()
				 * .getMemberregister());
				 * log.setDeletestatus(user2.getDeletestatus());
				 * log.setIntegralUserId(user2.getId());
				 * log.setType("reg");
				 * this.integralLogService.add(log);
				 */
			}
			else
			{
				this.userService.add (user);
				UserExample userExample2 = new UserExample ();
				UserExample.Criteria userCriteria = userExample2.createCriteria ();
				userCriteria.andUsernameEqualTo (userName);
				user2 = userService.getObjectList (userExample2).get (0);
				Iterator <Role> roles2 = user.getRoles ().iterator ();
				while (roles2.hasNext ())
				{
					Role role = roles2.next ();
					Map map = new HashMap ();
					map.put ("userId" , user2.getId ());
					map.put ("roleId" , role.getId ());
					this.userService.insertUserRole (map);
				}
			}
			Album album = new Album ();
			album.setAddtime (new Date ());
			album.setAlbumDefault (true);
			album.setAlbumName ("默认相册");
			album.setAlbumSequence (-10000);
			album.setUserId (user2.getId ());
			album.setDeletestatus (user2.getDeletestatus ());
			this.albumService.add (album);
			// 保存赠送礼品金信息到goldRecord表里面；
			// GoldRecordWithBLOBs goldRecord = new
			// GoldRecordWithBLOBs();
			// goldRecord.setAddtime(new Date());
			// /*goldRecord.setGoldCount(CommonValues.SYSTEM_SEND_REDPAPER_ZENGSONG_GLOD_FIVE);*/
			// goldRecord.setGoldUserId(user.getId());
			// System.out.println("yyyy="+user.getId());
			// goldRecord.setGoldPayment("新用户注册系统赠送礼品金");
			// goldRecord.setGoldSn("reg");
			// this.goldRecordService.add(goldRecord);
			/* 注册成功,发送短信知会用户 */
			this.sendSMS.sendActiveVip0SuccessMessage (user.getUsername () , user.getTruename ());
			/* 发送注册成功系统消息 */
			sysMsgTools.sendMsg (user2.getId () , SystemMsgTools.VIP_1);
			if (!fromZhibo)
			{
				String result = null;
				try
				{
					Map <String, String> map = new HashMap <String, String> ();
					map.put ("username" , URLEncoder.encode (userName));
					map.put ("password" , URLEncoder.encode (password));
					map.put ("validate" , "1");
					result = HttpRequest.postData ("http://zhibo.amall.com/index.php/Passport/doreg" , map , "UTF-8");
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
				System.out.println ("直播推送返回数据:" + result);
			}
			return user;
		}
}
