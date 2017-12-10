package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import cn.jpush.api.push.PushResult;
import com.amall.common.annotation.Log;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.common.tools.DateUtils;
import com.amall.core.action.CRUD.DeviceInfoCRUD;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.DeviceInfo;
import com.amall.core.bean.Role;
import com.amall.core.bean.StoreStat;
import com.amall.core.bean.StoreStatExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.SysLog;
import com.amall.core.bean.User;
import com.amall.core.push.jpush.JPush;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.IStoreStatService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.system.ISysLogService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.StatTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.ucapi.UCClient;
import com.amall.core.web.virtual.JModelAndView;
import com.amall.core.web.virtual.LogType;

/**
 * 
 * <p>
 * Title: BaseManageAction
 * </p>
 * <p>
 * Description: 商城后台管理入口
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午7:21:11
 * @version 1.0
 */
@Controller
public class BaseManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private IStoreStatService storeStatService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private StatTools statTools;

	@Autowired
	private ISysLogService isysLogService;

	@Autowired
	private DeviceInfoCRUD deviceInfoCRUD;

	@Log(title = "用户登陆" , type = LogType.LOGIN , description = "" , entityName = "" , ip = "")
	@RequestMapping({ "/login_success.htm" })
	public void login_success (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				if ((this.configService.getSysConfig ().getIntegral ()) && ((user.getLogindate () == null) || (user.getLogindate ().before (CommUtil.formatDate (CommUtil.formatShortDate (new Date ()))))))
				{
					/*
					 * user.setIntegral (user.getIntegral () + this.configService.getSysConfig
					 * ().getMemberdaylogin ());
					 * IntegralLog log = new IntegralLog ();
					 * log.setAddtime (new Date ());
					 * log.setContent ("用户" + CommUtil.formatLongDate (new Date ()) + "登录增加" +
					 * this.configService.getSysConfig ().getMemberdaylogin () + "分");
					 * log.setIntegral (this.configService.getSysConfig ().getMemberdaylogin ());
					 * log.setIntegralUser (user);
					 * log.setType ("login");
					 * this.integralLogService.add (log);
					 */
				}
				DeviceInfo deviceInfo = this.deviceInfoCRUD.getDeviceInfoByUserId (user.getId ());
				// app 、pc同时在线，推动通知信息给APP
				if (deviceInfo != null)
				{
					Map <String, String> msgMap = new HashMap <String, String> ();
					msgMap.put ("userId" , user.getId ().toString ());
					msgMap.put ("date" , DateUtils.formatTime (new Date ()));
					msgMap.put ("deviceType" , "你的账号在电脑登入");
					msgMap.put ("key" , "login");
					// 根据极光注册唯一标识ID,实行点对点推送
					PushResult pushResult = JPush.sendMessageUnique (msgMap , deviceInfo.getDeviceType () , deviceInfo.getRegistrationId ());
					if (pushResult != null)
					{
						DeviceInfo device = new DeviceInfo ();
						device.setAddTime (DateUtils.formatTime (new Date ()));
						device.setDeviceType ("PC");
						device.setUserId (user.getId ());
						this.deviceInfoCRUD.addDeviceInfo (device);
					}
				}
				user.setLogindate (new Date ());
				user.setLoginip (CommUtil.getIpAddr (request));
				user.setLogincount (user.getLogincount () + 1);
				this.userService.updateByObject (user);
				SysLog sysLog = new SysLog ();
				sysLog.setAddtime (new Date ());
				sysLog.setContent ("" + user.getUsername () + "于" + (new Date ()) + "登陆系统");
				sysLog.setIp (CommUtil.getIpAddr (request));
				sysLog.setTitle ("用户登陆");
				sysLog.setUserId (user.getId ());
				isysLogService.add (sysLog);
				HttpSession session = request.getSession (false);
				session.setAttribute ("user" , user);
				session.setAttribute ("lastLoginDate" , new Date ());
				session.setAttribute ("loginIp" , CommUtil.getIpAddr (request));
				session.setAttribute ("login" , Boolean.valueOf (true));
				String role = user.getUserrole ();
				String url = CommUtil.getURL (request) + "/user_login_success.htm";
				String login_role = (String) session.getAttribute ("login_role");
				// if(true){
				if (this.configService.getSysConfig ().getSecondDomainOpen ())
				{
					Cookie user_session = new Cookie ("user_session" , user.getId ().toString ());
					user_session.setDomain (CommUtil.generic_domain (request));
					response.addCookie (user_session);
				}
				boolean ajax_login = CommUtil.null2Boolean (session.getAttribute ("ajax_login"));
				if (ajax_login)
				{
					response.setContentType ("text/plain");
					response.setHeader ("Cache-Control" , "no-cache");
					response.setCharacterEncoding ("UTF-8");
					try
					{
						PrintWriter writer = response.getWriter ();
						writer.print ("success");
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
				}
				else
				{
					if ((login_role.equals ("admin")) && (role.indexOf ("ADMIN") >= 0))
					{
						url = CommUtil.getURL (request) + "/admin/index.htm";
						request.getSession (false).setAttribute ("admin_login" , Boolean.valueOf (true));
					}
					response.sendRedirect (url);
				}
			}
			else
			{
				String url = CommUtil.getURL (request) + "/user/login.htm";
				response.sendRedirect (url);
			}
		}

	
	@RequestMapping({ "/logout_success.htm" })
	public void logout_success (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			HttpSession session = request.getSession (false);
			String targetUrl = CommUtil.getURL (request) + "/user/login.htm";
			session.removeAttribute ("user");
			session.removeAttribute ("login");
			session.removeAttribute ("role");
			session.removeAttribute ("cart");
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes ()).getRequest ().getSession (false).removeAttribute ("user");
			if (this.configService.getSysConfig ().getSecondDomainOpen ())
			{
				Cookie [ ] cookies = request.getCookies ();
				for (Cookie cookie : cookies)
				{
					if (cookie.getName ().equals ("user_session"))
					{
						cookie.setMaxAge (0);
						cookie.setValue ("");
						cookie.setDomain (CommUtil.generic_domain (request));
						response.addCookie (cookie);
					}
				}
			}
			if (this.configService.getSysConfig ().getUcBbs ())
			{
				UCClient uc = new UCClient ();
				String uc_logout_js = uc.uc_user_synlogout ();
				request.getSession (false).setAttribute ("uc_logout_js" , uc_logout_js);
			}
			response.sendRedirect (targetUrl);
		}

	@RequestMapping({ "/login_error.htm" })
	public ModelAndView login_error (HttpServletRequest request , HttpServletResponse response)
		{
			String login_role = (String) request.getSession (false).getAttribute ("login_role");
			ModelAndView mv = null;
			// String view_type = CommUtil.null2String (request.getSession (false).getAttribute
			// ("amall_view_type"));
			if (login_role == null)
				login_role = "user";
			if (login_role.equals ("admin"))
			{
				mv = new JModelAndView ("admin/login_error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("url" , CommUtil.getURL (request) + "/user/login.htm");
			}
			// }
			/* 登录失败则删除本地保存的自动登录cookie */
			Cookie cook = CommUtil.getCookieValue (Globals.COOKIE_KEY_NAME , request.getCookies ());
			if (cook != null)
			{
				CommUtil.removeCookie (Globals.COOKIE_KEY_NAME , cook , response);
			}
			mv.addObject ("op_title" , "账号或密码错误");
			return mv;
		}

	@RequestMapping({ "/admin/login.htm" })
	public ModelAndView login (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv.addObject ("user" , user);
			}
			return mv;
		}

	@SecurityMapping(title = "商城后台管理" , value = "/admin/index.htm*" , rtype = "admin" , rname = "商城后台管理" ,
						rcode = "admin_index" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/index.htm" })
	public ModelAndView manage (HttpServletRequest request , HttpServletResponse response)
		{
			SysConfigWithBLOBs sysConfig = this.configService.getSysConfig ();
			ModelAndView mv = new JModelAndView ("admin/manage.html" , sysConfig , this.userConfigService.getUserConfig () , 0 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv.addObject ("user" , user);
			}
			if (sysConfig.getUcBbs ())
			{
				String uc_login_js = CommUtil.null2String (request.getSession (false).getAttribute ("uc_login_js"));
				mv.addObject ("uc_login_js" , uc_login_js);
			}
			return mv;
		}

	@SecurityMapping(title = "欢迎页面" , value = "/admin/welcome.htm*" , rtype = "admin" , rname = "欢迎页面" ,
						rcode = "admin_index" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/welcome.htm" })
	public ModelAndView welcome (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/welcome.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Properties props = System.getProperties ();
			mv.addObject ("os" , props.getProperty ("os.name"));
			mv.addObject ("java_version" , props.getProperty ("java.version"));
			mv.addObject ("shop_version" , Integer.valueOf (20150701));
			mv.addObject ("database_version" , this.databaseTools.queryDatabaseVersion ());
			mv.addObject ("web_server_version" , request.getSession (false).getServletContext ().getServerInfo ());
			List <StoreStat> stats = storeStatService.getObjectList (new StoreStatExample ());
			/*
			 * List stats = this.storeStatService.query(
			 * "select obj from StoreStat obj", null, -1, -1);
			 */
			StoreStat stat = null;
			if (stats.size () > 0)
				stat = (StoreStat) stats.get (0);
			else
			{
				stat = new StoreStat ();
			}
			mv.addObject ("stat" , stat);
			return mv;
		}

	@SecurityMapping(title = "关于我们" , value = "/admin/aboutus.htm*" , rtype = "admin" , rname = "关于我们" ,
						rcode = "admin_index" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/aboutus.htm" })
	public ModelAndView aboutus (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/aboutus.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "站点设置" , value = "/admin/set_site.htm*" , rtype = "admin" , rname = "站点设置" ,
						rcode = "admin_set_site" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_site.htm" })
	public ModelAndView site_set (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_site_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "上传设置" , value = "/admin/set_image.htm*" , rtype = "admin" , rname = "上传设置" ,
						rcode = "admin_set_image" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_image.htm" })
	public ModelAndView set_image (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_image_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "保存商城配置" , value = "/admin/sys_config_save.htm*" , rtype = "admin" , rname = "保存商城配置" ,
						rcode = "admin_config_add" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sys_config_save.htm" })
	public ModelAndView sys_config_save (HttpServletRequest request , HttpServletResponse response , String id , String list_url , String op_title)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs sysConfig = null;
			if (id.equals (""))
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , SysConfigWithBLOBs.class);
				sysConfig.setAddtime (new Date ());
			}
			else
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "system";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = this.configService.getSysConfig ().getWebsiteLogo () == null ? "" : this.configService.getSysConfig ().getWebsiteLogo ().getName ();
				map = CommUtil.saveFileToServer (request , "websiteLogo" , addFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory logo = new Accessory ();
						logo.setName (CommUtil.null2String (map.get ("fileName")));
						logo.setExt ((String) map.get ("mime"));
						logo.setSize (((Float) map.get ("fileSize")).floatValue ());
						logo.setPath (uploadFilePath + "/system");
						logo.setWidth (((Integer) map.get ("width")).intValue ());
						logo.setHeight (((Integer) map.get ("height")).intValue ());
						logo.setAddtime (new Date ());
						sysConfig.setWebsiteLogo (logo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory logo = sysConfig.getWebsiteLogo ();
					logo.setName (CommUtil.null2String (map.get ("fileName")));
					logo.setExt (CommUtil.null2String (map.get ("mime")));
					logo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					logo.setPath (uploadFilePath + "/system");
					logo.setWidth (CommUtil.null2Int (map.get ("width")));
					logo.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (logo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			map.clear ();
			try
			{
				map = CommUtil.saveFileToServer (request , "goodsImage" , addFilePathName , null , null);
				Accessory acc = sysConfig.getGoodsImage ();
				String fileName = "";
				if (acc != null)
					fileName = acc.getName ();
				if (fileName == null || fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName (CommUtil.null2String (map.get ("fileName")));
						photo.setExt (CommUtil.null2String (map.get ("mime")));
						photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
						photo.setPath (uploadFilePath);
						photo.setWidth (CommUtil.null2Int (map.get ("width")));
						photo.setHeight (CommUtil.null2Int (map.get ("height")));
						photo.setAddtime (new Date ());
						sysConfig.setGoodsImage (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = sysConfig.getGoodsImage ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/system");
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			map.clear ();
			try
			{
				map = CommUtil.saveFileToServer (request , "storeImage" , addFilePathName , null , null);
				Accessory acc = sysConfig.getStoreImage ();
				String fileName = "";
				if (acc != null && acc.getName () != null)
					fileName = acc.getName ();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName ((String) map.get ("fileName"));
						photo.setExt ((String) map.get ("mime"));
						photo.setSize (((Float) map.get ("fileSize")).floatValue ());
						photo.setPath (uploadFilePath);
						photo.setWidth (((Integer) map.get ("width")).intValue ());
						photo.setHeight (((Integer) map.get ("height")).intValue ());
						photo.setAddtime (new Date ());
						sysConfig.setStoreImage (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = sysConfig.getStoreImage ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/system");
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			map.clear ();
			try
			{
				map = CommUtil.saveFileToServer (request , "memberIcon" , addFilePathName , null , null);
				Accessory acc = sysConfig.getMemberIcon ();
				String fileName = "";
				if (acc != null && acc.getName () != null)
					fileName = acc.getName ();
				// String fileName = sysConfig.getMemberIcon().getName();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName ((String) map.get ("fileName"));
						photo.setExt ((String) map.get ("mime"));
						photo.setSize (((Float) map.get ("fileSize")).floatValue ());
						photo.setPath (uploadFilePath);
						photo.setWidth (((Integer) map.get ("width")).intValue ());
						photo.setHeight (((Integer) map.get ("height")).intValue ());
						photo.setAddtime (new Date ());
						this.accessoryService.add (photo);
						sysConfig.setMemberIcon (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = sysConfig.getMemberIcon ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/system");
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			if (id.equals (""))
				this.configService.add (sysConfig);
			else
			{
				this.configService.updateByObject (sysConfig);
			}
			for (int i = 0 ; i < 4 ; i++)
			{
				try
				{
					map.clear ();
					String fileName = "";
					if (sysConfig.getLoginImgs () != null && sysConfig.getLoginImgs ().size () > 0)
					{
						if (sysConfig.getLoginImgs ().size () > i)
						{
							fileName = ((Accessory) sysConfig.getLoginImgs ().get (i)).getName ();
						}
					}
					map = CommUtil.saveFileToServer (request , "img" + i , addFilePathName , fileName , null);
					if (fileName.equals (""))
					{
						if (!map.get ("fileName").equals (""))
						{
							Accessory img = new Accessory ();
							img.setName (CommUtil.null2String (map.get ("fileName")));
							img.setExt ((String) map.get ("mime"));
							img.setSize (((Float) map.get ("fileSize")).floatValue ());
							img.setPath (uploadFilePath + "/system");
							img.setWidth (((Integer) map.get ("width")).intValue ());
							img.setHeight (((Integer) map.get ("height")).intValue ());
							img.setAddtime (new Date ());
							img.setConfig (sysConfig);
							this.accessoryService.add (img);
						}
					}
					else if (!map.get ("fileName").equals (""))
					{
						Accessory img = (Accessory) sysConfig.getLoginImgs ().get (i);
						img.setName (CommUtil.null2String (map.get ("fileName")));
						img.setExt (CommUtil.null2String (map.get ("mime")));
						img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						img.setPath (uploadFilePath + "/system");
						img.setWidth (CommUtil.null2Int (map.get ("width")));
						img.setHeight (CommUtil.null2Int (map.get ("height")));
						img.setConfig (sysConfig);
						this.accessoryService.updateByObject (img);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , op_title);
			mv.addObject ("list_url" , list_url);
			return mv;
		}

	@SecurityMapping(title = "Email设置" , value = "/admin/set_email.htm*" , rtype = "admin" , rname = "Email设置" ,
						rcode = "admin_set_email" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_email.htm" })
	public ModelAndView set_email (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_email_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "短信设置" , value = "/admin/set_sms.htm*" , rtype = "admin" , rname = "短信设置" ,
						rcode = "admin_set_sms" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_sms.htm" })
	public ModelAndView set_sms (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_sms_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "SEO设置" , value = "/admin/set_seo.htm*" , rtype = "admin" , rname = "SEO设置" ,
						rcode = "admin_set_seo" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_seo.htm" })
	public ModelAndView set_seo (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_seo_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "二级域名设置" , value = "/admin/set_second_domain.htm*" , rtype = "admin" , rname = "二级域名设置" ,
						rcode = "admin_set_second_domain" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_second_domain.htm" })
	public ModelAndView set_second_domain (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_second_domain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "二级域名设置保存" , value = "/admin/set_second_domain_add.htm*" , rtype = "admin" ,
						rname = "二级域名设置" , rcode = "admin_set_second_domain" , rgroup = "设置" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/set_second_domain_add.htm" })
	public ModelAndView set_second_domain_add (HttpServletRequest request , HttpServletResponse response , String id , String domain_allow_count , String sys_domain , String second_domain_open)
		{
			String serverName = request.getServerName ().toLowerCase ();
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (serverName.indexOf (".") > 0)
			{
				SysConfigWithBLOBs config = this.configService.getSysConfig ();
				config.setDomainAllowCount (CommUtil.null2Int (domain_allow_count));
				config.setSysDomain (sys_domain);
				config.setSecondDomainOpen (CommUtil.null2Boolean (second_domain_open));
				if (id.equals (""))
					this.configService.add (config);
				else
					this.configService.updateByObject (config);
				mv.addObject ("op_title" , "二级域名保存成功");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/set_second_domain.htm");
			}
			else
			{
				SysConfigWithBLOBs config = this.configService.getSysConfig ();
				config.setDomainAllowCount (CommUtil.null2Int (domain_allow_count));
				config.setSysDomain (sys_domain);
				config.setSecondDomainOpen (false);
				if (id.equals (""))
					this.configService.add (config);
				else
					this.configService.updateByObject (config);
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "当前网站无法开启二级域名");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/set_second_domain.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "QQ互联登录" , value = "/admin/set_site_qq.htm*" , rtype = "admin" , rname = "二级域名设置" ,
						rcode = "admin_set_second_domain" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_site_qq.htm" })
	public ModelAndView set_site_qq (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_second_domain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "分润设置" , value = "/admin/set_fenrun.htm*" , rtype = "admin" , rname = "分润管理" ,
						rcode = "admin_set_fenrun" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_fenrun.htm" })
	public ModelAndView set_fenrun (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_fenrun.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "保存分润设置" , value = "/admin/set_fenrun_save.htm*" , rtype = "admin" , rname = "分润管理" ,
						rcode = "admin_set_fenrun" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_fenrun_save.htm" })
	public ModelAndView set_fenrun_save (HttpServletRequest request , HttpServletResponse response , String id , String alipayFenrun , String balanceFenrun)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs config = null;
			if (id.equals (""))
			{
				config = (SysConfigWithBLOBs) wf.toPo (request , SysConfigWithBLOBs.class);
				config.setAddtime (new Date ());
			}
			else
			{
				config = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			config.setAlipayFenrun (CommUtil.null2Int (alipayFenrun));
			config.setBalanceFenrun (CommUtil.null2Int (balanceFenrun));
			if (id.equals (""))
				this.configService.add (config);
			else
			{
				this.configService.updateByObject (config);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "分润设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/set_fenrun.htm");
			return mv;
		}

	@RequestMapping({ "/admin/logout.htm" })
	public ModelAndView logout (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				Map <String, Long> map = new HashMap <String, Long> ();
				map.put ("id" , user.getId ());
				List <Role> rolelist = userService.findRoleByUserId (map);
				user.setRoles (rolelist);
				Authentication authentication = new UsernamePasswordAuthenticationToken (SecurityContextHolder.getContext ().getAuthentication ().getPrincipal () , SecurityContextHolder.getContext ().getAuthentication ().getCredentials () , user.get_common_Authorities ());
				SecurityContextHolder.getContext ().setAuthentication (authentication);
			}
			return mv;
		}

	@RequestMapping({ "/success.htm" })
	public ModelAndView success (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , request.getSession (false).getAttribute ("op_title"));
			mv.addObject ("url" , request.getSession (false).getAttribute ("url"));
			request.getSession (false).removeAttribute ("op_title");
			request.getSession (false).removeAttribute ("url");
			return mv;
		}

	@RequestMapping({ "/error.htm" })
	public ModelAndView error (HttpServletRequest request , HttpServletResponse response)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((user != null) && (user.getUserrole ().equalsIgnoreCase ("ADMIN")))
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			}
			mv.addObject ("op_title" , request.getSession (false).getAttribute ("op_title"));
			mv.addObject ("list_url" , request.getSession (false).getAttribute ("url"));
			mv.addObject ("url" , request.getSession (false).getAttribute ("url"));
			request.getSession (false).removeAttribute ("op_title");
			request.getSession (false).removeAttribute ("url");
			return mv;
		}

	@RequestMapping({ "/exception.htm" })
	public ModelAndView exception (HttpServletRequest request , HttpServletResponse response)
		{
			User user = (User) request.getSession ().getAttribute ("user");
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((user != null) && (user.getUserrole ().equalsIgnoreCase ("ADMIN")))
			{
				mv = new JModelAndView ("admin/exception.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			}
			else
			{
				mv.addObject ("op_title" , "系统出现异常");
				mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			}
			return mv;
		}

	@RequestMapping({ "/authority.htm" })
	public ModelAndView authority (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/authority.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			boolean domain_error = CommUtil.null2Boolean (request.getSession (false).getAttribute ("domain_error"));
			if (domain_error)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "域名绑定错误，请与http://www.hg-sem.com联系");
			}
			return mv;
		}

	@RequestMapping({ "/voice.htm" })
	public ModelAndView voice (HttpServletRequest request , HttpServletResponse response)
		{
			return new JModelAndView ("include/flash/soundPlayer.swf" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , request , response);
		}

	@RequestMapping({ "/getCode.htm" })
	public void getCode (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			HttpSession session = request.getSession (false);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			PrintWriter writer = response.getWriter ();
			writer.print ("result=true&code=" + (String) session.getAttribute ("verify_code"));
		}

	@RequestMapping({ "/editor.htm" })
	public ModelAndView editor (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/editor_test.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SuppressWarnings("unchecked")
	@RequestMapping({ "/upload.htm" })
	public void upload (HttpServletRequest request , HttpServletResponse response) throws ClassNotFoundException
		{
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + this.configService.getSysConfig ().getUploadfilepath () + File.separator + "common";
			String webPath = request.getContextPath ().equals ("/") ? "" : request.getContextPath ();
			if ((this.configService.getSysConfig ().getAddress () != null) && (!this.configService.getSysConfig ().getAddress ().equals ("")))
			{
				webPath = this.configService.getSysConfig ().getAddress () + webPath;
			}
			JSONObject obj = new JSONObject ();
			try
			{
				Map <String, Object> map = CommUtil.saveFileToServer (request , "imgFile" , addFilePathName , null , null);
				String url = this.configService.getSysConfig ().getImagewebserver () + "/" + this.configService.getSysConfig ().getUploadfilepath () + "/common/" + map.get ("fileName");
				obj.put ("error" , Integer.valueOf (0));
				obj.put ("url" , url);
			}
			catch (IOException e)
			{
				obj.put ("error" , Integer.valueOf (1));
				obj.put ("message" , e.getMessage ());
				e.printStackTrace ();
			}
			response.setContentType ("text/html");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (obj.toJSONString ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/js.htm" })
	public ModelAndView js (HttpServletRequest request , HttpServletResponse response , String js)
		{
			ModelAndView mv = new JModelAndView ("resources/js/" + js + ".js" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 2 , request , response);
			return mv;
		}

	@RequestMapping({ "/admin/test_mail.htm" })
	public void test_email (HttpServletResponse response , String email)
		{
			String subject = this.configService.getSysConfig ().getTitle () + "测试邮件";
			boolean ret = this.msgTools.sendEmail (email , subject , subject);
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

	@RequestMapping({ "/admin/test_sms.htm" })
	public void test_sms (HttpServletResponse response , String mobile) throws UnsupportedEncodingException
		{
			String content = this.configService.getSysConfig ().getTitle () + "测试短信,如果您收到短信，说明发送成功！";
			boolean ret = this.msgTools.sendSMS (mobile , content);
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

	@RequestMapping({ "/admin/user_msg_add.htm" })
	public void user_msg_add (HttpServletResponse response , String msg) throws HttpException , IOException
		{
			HttpClient client = new HttpClient ();
			PostMethod method = new PostMethod ("http://www.amall.com/user_msg.htm");
			method.addParameter ("msg" , msg);
			int status = client.executeMethod (method);
			boolean ret = false;
			if (status == 200)
			{
				ret = true;
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
	/*
	 * @SecurityMapping(title = "websiteCss设置", value = "/admin/set_websiteCss.htm*", rtype =
	 * "admin", rname = "Email设置", rcode = "admin_set_websiteCss", rgroup = "设置", display = false,
	 * rsequence = 0)
	 * @RequestMapping({ "/admin/set_websiteCss.htm" })
	 * public void set_websiteCss(HttpServletRequest request,
	 * HttpServletResponse response, String webcss) {
	 * SysConfigWithBLOBs obj = this.configService.getSysConfig();
	 * if ((!webcss.equals("blue")) && (!webcss.equals("black"))) {
	 * webcss = "blue";
	 * }
	 * obj.setWebsitecss(webcss);
	 * this.configService.updateByObject(obj);
	 * }
	 */
}
