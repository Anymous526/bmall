package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.bean.StoreGradeLog;
import com.amall.core.bean.StoreSlide;
import com.amall.core.bean.StoreSlideExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreGradeLogService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.IStoreSlideService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.QRCodeEncoderHandler;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreSellerAction
 * </p>
 * <p>
 * Description: 店铺的申请、升级、主题等
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月17日下午1:57:53
 * @version 1.0
 */
@Controller
public class StoreSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IStoreGradeLogService storeGradeLogService;

	@Autowired
	private IStoreSlideService storeSlideService;

	@Autowired
	private StoreViewTools storeTools;

	@Autowired
	private AreaViewTools areaViewTools;

	@RequestMapping({ "/seller/store_validation.htm" })
	public @ResponseBody String store_validation (HttpServletRequest request , HttpServletResponse response , String storeName , String storeOwerCard , String telephone)
		{
			int i = this.storeService.getStoreValidation (storeName , storeOwerCard , telephone);
			if (i > 0)
			{
				return Globals.RETURN_TRUE;
			}
			return Globals.RETURN_FALSE;
		}

	@RequestMapping({ "/seller/seller_goods_count.htm" })
	public ModelAndView seller_goods_count (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_goods_count.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/seller/store_validation1.htm" })
	public @ResponseBody String store_validation1 (HttpServletRequest request , HttpServletResponse response , String storeName , String storeOwerCard , String telephone)
		{
			StoreWithBLOBs store = this.storeService.getStoreValidation1 (storeName , storeOwerCard , telephone);
			if (store != null && store.getStoreStatus () != -1)
			{
				return Globals.RETURN_TRUE;
			}
			return Globals.RETURN_FALSE;
		}

	@SecurityMapping(title = "申请店铺第一步" , value = "/seller/store_create_first_one.htm*" , rtype = "buyer" ,
						rname = "申请店铺" , rcode = "create_store" , rgroup = "申请店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_create_first_one.htm" })
	public ModelAndView store_create_first (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			int store_status = 0;
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = this.storeService.getByKey (user.getStoreId ());
			if (store != null)
			{
				store_status = store.getStoreStatus ();
			}
			if (this.configService.getSysConfig ().getStoreAllow ())
			{
				if (store_status == 0)
				{
					mv = new JModelAndView ("seller/store_create_first_one.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					StoreGradeExample storeGradeExample = new StoreGradeExample ();
					storeGradeExample.clear ();
					storeGradeExample.setOrderByClause ("sequence asc");
					List <StoreGrade> sgs = storeGradeService.getObjectList (storeGradeExample);
					mv.addObject ("sgs" , sgs);
					mv.addObject ("storeTools" , this.storeTools);
				}
				if (store_status == 1)
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您的店铺正在审核中");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
				}
				if (store_status == 2)
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您已经开通店铺");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
				}
				if (store_status == 3)
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您的店铺已经被关闭");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统暂时关闭了申请店铺");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
			}
			return mv;
		}

	/**
	 * @Title: store_create_second
	 * @Description: 卖家申请开店第二步
	 * @param request
	 * @param response
	 * @param grade_id
	 *            店铺级别
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月13日
	 */
	@SecurityMapping(title = "申请店铺第二步" , value = "/seller/store_create_second.htm*" , rtype = "buyer" , rname = "申请店铺" ,
						rcode = "create_store" , rgroup = "申请店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_create_second.htm" })
	public ModelAndView store_create_second (HttpServletRequest request , HttpServletResponse response , String grade_id)
		{
			ModelAndView mv = null;
			/* 正常流程 */
			StoreWithBLOBs store = this.storeService.getByKey (SecurityUserHolder.getCurrentUser ().getStoreId ());
			int store_status = store == null ? 0 : store.getStoreStatus ();
			if (this.configService.getSysConfig ().getStoreAllow ())
			{
				if ((grade_id == null) || (grade_id.equals ("")))
				{
					mv = new JModelAndView ("seller/store_create_first_one.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					StoreGradeExample storeGradeExample = new StoreGradeExample ();
					storeGradeExample.clear ();
					storeGradeExample.setOrderByClause ("sequence asc");
					List <StoreGrade> sgs = storeGradeService.getObjectList (storeGradeExample);
					mv.addObject ("sgs" , sgs);
					mv.addObject ("storeTools" , this.storeTools);
				}
				else
				{
					// 当用户尚未开店或者之前开店被审核拒绝之后，都可以申请或者重新开店
					if (store_status == 0 || store_status == -1)
					{
						mv = new JModelAndView ("seller/store_create_second_one.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						AreaExample areaExample = new AreaExample ();
						areaExample.clear ();
						areaExample.createCriteria ().andParentIdIsNull ();
						List <Area> areas = areaService.getObjectList (areaExample);
						StoreClassExample storeClassExample = new StoreClassExample ();
						storeClassExample.clear ();
						storeClassExample.createCriteria ().andParentIdIsNull ();
						List <StoreClass> scs = storeClassService.getObjectList (storeClassExample);
						String store_create_session = CommUtil.randomString (32);
						request.getSession (false).setAttribute ("store_create_session" , store_create_session);
						mv.addObject ("store_create_session" , store_create_session);
						mv.addObject ("scs" , scs);
						mv.addObject ("areas" , areas);
						mv.addObject ("grade_id" , grade_id);
					}
					if (store_status == 1)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您的店铺正在审核中");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
					if (store_status == 2)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您已经开通店铺");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
					if (store_status == 3)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您的店铺已经被关闭");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统暂时关闭了申请店铺");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "申请店铺第三步" , value = "/seller/store_create_apply_finish.htm*" , rtype = "buyer" ,
						rname = "申请店铺" , rcode = "create_store" , rgroup = "申请店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_create_apply_finish.htm" })
	public ModelAndView store_create_apply_finish (HttpServletRequest request , HttpServletResponse response , String grade_id)
		{
			ModelAndView mv = null;
			mv = new JModelAndView ("seller/store_create_apply_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@SecurityMapping(title = "申请店铺完成" , value = "/seller/store_create_finish.htm*" , rtype = "buyer" , rname = "申请店铺" ,
						rcode = "create_store" , rgroup = "申请店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_create_finish.htm" })
	public ModelAndView store_create_finish (HttpServletRequest request , HttpServletResponse response , String scId , String grade_id , String areaId , String store_create_session , String lng , String lat)
		{
			ModelAndView mv = new JModelAndView ("seller/store_create_apply_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String store_create_session1 = CommUtil.null2String (request.getSession (false).getAttribute ("store_create_session"));
			if ((!store_create_session1.equals ("")) && (store_create_session1.equals (store_create_session)))
			{
				User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
				List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
				StoreWithBLOBs user_store = null;
				if (null != stores && stores.size () > 0)
					user_store = stores.get (0);
				int store_status = user_store == null ? 0 : user_store.getStoreStatus ();
				if (store_status == 0 || store_status == -1)
				{
					WebForm wf = new WebForm ();
					StoreWithBLOBs store = (StoreWithBLOBs) wf.toPo (request , StoreWithBLOBs.class);
					StoreClass sc = this.storeClassService.getByKey (Long.valueOf (Long.parseLong (scId)));
					
					
					if(StringUtils.isNotEmpty(lat)){
						Double lats = Double.valueOf(lat);
						System.out.println(lats);
						BigDecimal big = BigDecimal.valueOf(lats);
						store.setStoreLat(big);
					}
					if(StringUtils.isNotEmpty(lng)){
						Double lngs = Double.valueOf(lng);
						BigDecimal big = BigDecimal.valueOf(lngs);
						System.out.println(lngs);
						store.setStoreLng(big);
					}
					
					
					store.setSc (sc);
					StoreGrade grade = this.storeGradeService.getByKey (Long.valueOf (Long.parseLong (grade_id)));
					store.setGrade (grade);
					store.setUser (user);// 设置UserId设进来
					Area area = this.areaService.getByKey (Long.valueOf (Long.parseLong (areaId)));
					store.setArea (area);
					store.setTemplate ("default");
					store.setAddtime (new Date ());
					store.setStoreSecondDomain ("shop" + SecurityUserHolder.getCurrentUser ().getId ().toString ());
					store.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
					if (user_store == null)
					{
						// 店铺名
						int storeNameCount = this.storeService.getStoreNameValidation (store.getStoreName ());
						// 身份证号
						int storeOwerCardCount = this.storeService.getStoreOwerCardValidation (store.getStoreOwerCard ());
						// 联系号码
						int storeTelephone = this.storeService.getStoreTelephoneValidation (store.getStoreTelephone ());
						if (storeNameCount > 0)
						{
							mv.addObject ("code" , "0");
							mv.addObject ("op_title" , "店铺名称已存在  - 不正常操作");
							return mv;
						}
						else if (storeOwerCardCount > 0)
						{
							mv.addObject ("code" , "0");
							mv.addObject ("op_title" , "身份证号已存在  - 不正常操作");
							return mv;
						}
						else if (storeTelephone > 0)
						{
							mv.addObject ("code" , "0");
							mv.addObject ("op_title" , "手机号码已存在  - 不正常操作");
							return mv;
						}
						else
						{
							this.storeService.add (store);
						}
					}
					else
					{
						store.setId (Long.valueOf (user_store.getId ()));
						this.storeService.updateByObject (store);
					}
					String path = this.configService.getSysConfig ().getUploadRootPath () + File.separator + "upload" + File.separator + "store" + File.separator + store.getId ();
					CommUtil.createFolder (path);
					String store_url = CommUtil.getURL (request) + "/store_" + store.getId () + ".htm";
					QRCodeEncoderHandler handler = new QRCodeEncoderHandler ();
					handler.encoderQRCode (store_url , path + "/code.png");
					// user.setStore(store);
					if (store.getGrade ().getAudit ())
						store.setStoreStatus (1);
					else
					{
						store.setStoreStatus (2);
					}
					if (user.getUserrole ().equals ("BUYER"))
					{
						user.setUserrole ("BUYER_SELLER");
					}
					if (user.getUserrole ().equals ("ADMIN"))
					{
						user.setUserrole ("ADMIN_BUYER_SELLER");
					}
					RoleExample roleExample = new RoleExample ();
					roleExample.clear ();
					roleExample.createCriteria ().andTypeEqualTo ("SELLER");
					List <Role> roles = roleService.getObjectList (roleExample);
					user.getRoles ().addAll (roles);
					this.userService.updateByObject (user);
					this.storeService.updateByObject (store);
					Authentication authentication = new UsernamePasswordAuthenticationToken (SecurityContextHolder.getContext ().getAuthentication ().getPrincipal () , SecurityContextHolder.getContext ().getAuthentication ().getCredentials () , user.get_common_Authorities ());
					SecurityContextHolder.getContext ().setAuthentication (authentication);
					mv.addObject ("code" , "1");
					mv.addObject ("op_title" , "店铺申请成功");
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					if (store_status == 1)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您的店铺正在审核中");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
					if (store_status == 2)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您已经开通店铺");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
					if (store_status == 3)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您的店铺已经被关闭");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller_index.htm");
					}
				}
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
				request.getSession (false).removeAttribute ("storeCreateSession");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "请重新登录");
				mv.addObject ("url" , CommUtil.getURL (request) + "/user/login.htm");
			}
			return mv;
		}

	@RequestMapping(value = "/store/seller_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String store_upload (HttpServletRequest request , HttpServletResponse response , String width , String height , String isCheckWithHeight) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "group";
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
							gg_img.setPath (uploadFilePath + "/group");
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
						gg_img.setPath (uploadFilePath + "/group");
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

	@SecurityMapping(title = "店铺设置" , value = "/seller/store_set.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_set.htm" })
	public ModelAndView store_set (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getByKey (user.getStoreId ());
			mv.addObject ("store" , store);
			mv.addObject ("areaViewTools" , this.areaViewTools);
			/*
			 * List areas = this.areaService.query(
			 * "select obj from Area obj where obj.parent.id is null", null,
			 * -1, -1);
			 */
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = areaService.getObjectList (areaExample);
			mv.addObject ("areas" , areas);
			return mv;
		}

	@RequestMapping(value = "/store/seller_set_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String store_set_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "store_logo";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imageId = "";
			int reqWidth = CommUtil.null2Int (width);
			int reqHeight = CommUtil.null2Int (height);
			int mapWidth = CommUtil.null2Int (map.get ("width"));
			int mapHeight = CommUtil.null2Int (map.get ("height"));
			String imgPath = "";
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
						gg_img.setPath (uploadFilePath + "/store_logo");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
					}
					imgPath = this.configService.getSysConfig ().getImagewebserver ();
					imgPath = imgPath + "/" + gg_img.getPath () + "/" + gg_img.getName ();
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\",\"imgPath\":\"" + imgPath + "\"}";
				return response_rs;
			}
			else
			{
				imageId = String.valueOf (0);
				response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\",\"imgPath\":\"" + imgPath + "\"}";
				return response_rs;
			}
		}

	@SecurityMapping(title = "店铺设置保存" , value = "/seller/store_set_save.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_set_save.htm" })
	public ModelAndView store_set_save (HttpServletRequest request , HttpServletResponse response , String area_id , String storeLogoId , String storeSecondDomain)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getByKey (user.getStoreId ());
			WebForm wf = new WebForm ();
			wf.toPo (request , store);
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "store_banner";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = store.getStoreBanner () == null ? "" : store.getStoreBanner ().getName ();
				map = CommUtil.saveFileToServer (request , "banner" , saveFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory store_banner = new Accessory ();
						store_banner.setName (CommUtil.null2String (map.get ("fileName")));
						store_banner.setExt (CommUtil.null2String (map.get ("mime")));
						store_banner.setSize (CommUtil.null2Float (map.get ("fileSize")));
						store_banner.setPath (uploadFilePath + "/store_banner");
						store_banner.setWidth (CommUtil.null2Int (map.get ("width")));
						store_banner.setHeight (CommUtil.null2Int (map.get ("height")));
						store_banner.setAddtime (new Date ());
						this.accessoryService.add (store_banner);
						store.setStoreBanner (store_banner);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory store_banner = store.getStoreBanner ();
					store_banner.setName (CommUtil.null2String (map.get ("fileName")));
					store_banner.setExt (CommUtil.null2String (map.get ("mime")));
					store_banner.setSize (CommUtil.null2Float (map.get ("fileSize")));
					store_banner.setPath (uploadFilePath + "/store_banner");
					store_banner.setWidth (CommUtil.null2Int (map.get ("width")));
					store_banner.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (store_banner);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			Area area = this.areaService.getByKey (CommUtil.null2Long (area_id));
			store.setArea (area);
			if (this.configService.getSysConfig ().getSecondDomainOpen ())
			{
				if ((this.configService.getSysConfig ().getDomainAllowCount () > store.getDomainModifyCount ()) && (!CommUtil.null2String (storeSecondDomain).equals ("")))
				{
					if (!storeSecondDomain.equals (store.getStoreSecondDomain ()))
					{
						store.setStoreSecondDomain (storeSecondDomain);
						store.setDomainModifyCount (store.getDomainModifyCount () + 1);
					}
				}
			}
			this.storeService.updateByObject (store);
			mv.addObject ("op_title" , "店铺设置成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/store_set.htm");
			return mv;
		}

	/*
	 * @SecurityMapping(title = "店铺地图", value = "/seller/store_map.htm*", rtype = "seller", rname =
	 * "店铺设置", rcode = "store_set_seller", rgroup = "店铺设置", display = false, rsequence = 0)
	 * @RequestMapping({ "/seller/store_map.htm" })
	 * public ModelAndView store_map(HttpServletRequest request,
	 * HttpServletResponse response, String map_type) {
	 * User user = userService.getByKey(SecurityUserHolder.getCurrentUser().getId());
	 * StoreExample storeExample = new StoreExample();
	 * storeExample.clear();
	 * storeExample.createCriteria().andUserIdEqualTo(user.getId());
	 * List<StoreWithBLOBs> stores = storeService.getObjectList(storeExample);
	 * StoreWithBLOBs store = null;
	 * if(stores.size() >0 && stores != null)
	 * store = stores.get(0);
	 * if (CommUtil.null2String(map_type).equals("")) {
	 * if ((store.getMapType() != null)
	 * && (!store.getMapType().equals("")))
	 * map_type = store.getMapType();
	 * else {
	 * map_type = "baidu";
	 * }
	 * }
	 * ModelAndView mv = new JModelAndView("seller/usercenter/store_"
	 * + map_type + "_map.html", this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request, response);
	 * mv.addObject("store", store);
	 * return mv;
	 * }
	 * @SecurityMapping(title = "店铺地图保存", value = "/seller/store_map_save.htm*", rtype = "seller",
	 * rname = "店铺设置", rcode = "store_set_seller", rgroup = "店铺设置", display = false, rsequence = 0)
	 * @RequestMapping({ "/seller/store_map_save.htm" })
	 * public ModelAndView store_map_save(HttpServletRequest request,
	 * HttpServletResponse response, String store_lat, String store_lng) {
	 * ModelAndView mv = new JModelAndView(
	 * "seller/usercenter/success.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(), 1, request, response);
	 * User user = userService.getByKey(SecurityUserHolder.getCurrentUser().getId());
	 * StoreExample storeExample = new StoreExample();
	 * storeExample.clear();
	 * storeExample.createCriteria().andUserIdEqualTo(user.getId());
	 * List<StoreWithBLOBs> stores = storeService.getObjectList(storeExample);
	 * StoreWithBLOBs store = null;
	 * if(stores.size() >0 && stores != null)
	 * store = stores.get(0);
	 * store.setStoreLat(BigDecimal.valueOf(CommUtil.null2Double(store_lat)));
	 * store.setStoreLng(BigDecimal.valueOf(CommUtil.null2Double(store_lng)));
	 * this.storeService.updateByObject(store);
	 * mv.addObject("op_title", "店铺设置成功");
	 * mv.addObject("url", CommUtil.getURL(request) + "/seller/store_map.htm");
	 * return mv;
	 * }
	 */
	@SecurityMapping(title = "主题设置" , value = "/seller/store_theme.htm*" , rtype = "seller" , rname = "主题设置" ,
						rcode = "store_theme_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_theme.htm" })
	public ModelAndView store_theme (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_theme.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
				store = stores.get (0);
			mv.addObject ("store" , store);
			return mv;
		}

	@SecurityMapping(title = "主题设置" , value = "/seller/store_theme_save.htm*" , rtype = "seller" , rname = "主题设置" ,
						rcode = "store_theme_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_theme_save.htm" })
	public String store_theme_set (HttpServletRequest request , HttpServletResponse response , String theme)
		{
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
			{
				store = stores.get (0);
			}
			if (null != store && store.getTemplate () != null && !store.getTemplate ().equals (theme))
			{
				store.setTemplate (theme);
				this.storeService.updateByObject (store);
			}
			return "redirect:store_theme.htm";
		}

	@SecurityMapping(title = "店铺认证" , value = "/seller/store_approve.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_approve.htm" })
	public ModelAndView store_approve (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_approve.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
			{
				store = stores.get (0);
			}
			mv.addObject ("store" , store);
			return mv;
		}

	@SecurityMapping(title = "店铺认证保存" , value = "/seller/store_approve_save.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_approve_save.htm" })
	public String store_approve_save (HttpServletRequest request , HttpServletResponse response)
		{
//			ModelAndView mv = new JModelAndView ("seller/usercenter/store_approve.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
			{
				store = stores.get (0);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath;
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = null;
				if (null != store)
				{
					fileName = store.getCard () == null ? "" : store.getCard ().getName ();
				}
				map = CommUtil.saveFileToServer (request , "card_img" , saveFilePathName + File.separator + "card" , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory card = new Accessory ();
						card.setName (CommUtil.null2String (map.get ("fileName")));
						card.setExt (CommUtil.null2String (map.get ("mime")));
						card.setSize (CommUtil.null2Float (map.get ("fileSize")));
						card.setPath (uploadFilePath + "/card");
						card.setWidth (CommUtil.null2Int (map.get ("width")));
						card.setHeight (CommUtil.null2Int (map.get ("height")));
						card.setAddtime (new Date ());
						this.accessoryService.add (card);
						store.setCard (card);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory card = store.getCard ();
					card.setName (CommUtil.null2String (map.get ("fileName")));
					card.setExt (CommUtil.null2String (map.get ("mime")));
					card.setSize (CommUtil.null2Float (map.get ("fileSize")));
					card.setPath (uploadFilePath + "/card");
					card.setWidth (CommUtil.null2Int (map.get ("width")));
					card.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (card);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			try
			{
				String fileName=null;
				if (null != store)
				{
					fileName= store.getStoreLicense () == null ? "" : store.getStoreLicense ().getName ();
				}
				map = CommUtil.saveFileToServer (request , "license_img" , saveFilePathName + File.separator + "license" , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory store_license = new Accessory ();
						store_license.setName (CommUtil.null2String (map.get ("fileName")));
						store_license.setExt (CommUtil.null2String (map.get ("mime")));
						store_license.setSize (CommUtil.null2Float (map.get ("fileSize")));
						store_license.setPath (uploadFilePath + "/license");
						store_license.setWidth (CommUtil.null2Int (map.get ("width")));
						store_license.setHeight (CommUtil.null2Int (map.get ("height")));
						store_license.setAddtime (new Date ());
						this.accessoryService.add (store_license);
						store.setStoreLicense (store_license);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory store_license = store.getStoreLicense ();
					store_license.setName (CommUtil.null2String (map.get ("fileName")));
					store_license.setExt (CommUtil.null2String (map.get ("mime")));
					store_license.setSize (CommUtil.null2Float (map.get ("fileSize")));
					store_license.setPath (uploadFilePath + "/license");
					store_license.setWidth (CommUtil.null2Int (map.get ("width")));
					store_license.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (store_license);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.storeService.updateByObject (store);
			return "redirect:store_approve.htm";
		}

	@SecurityMapping(title = "店铺升级" , value = "/seller/store_grade.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_grade.htm" })
	public ModelAndView store_grade (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_grade.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreGrade storeGrade = null;
			if (null != stores && stores.size () > 0)
			{
				storeGrade = stores.get (0).getUpdateGrade ();
			}
			if (null != storeGrade)
			{
				mv = new JModelAndView ("seller/usercenter/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "您的店铺升级正在审核中");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/store_set.htm");
			}
			else
			{
				StoreGradeExample storeGradeExample = new StoreGradeExample ();
				storeGradeExample.clear ();
				storeGradeExample.setOrderByClause ("sequence asc");
				List <StoreGrade> sgs = storeGradeService.getObjectList (storeGradeExample);
				mv.addObject ("sgs" , sgs);
				mv.addObject ("store" , stores.get (0));
			}
			return mv;
		}

	@SecurityMapping(title = "店铺升级申请完成" , value = "/seller/store_grade_finish.htm*" , rtype = "seller" ,
						rname = "店铺设置" , rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_grade_finish.htm" })
	public ModelAndView store_grade_finish (HttpServletRequest request , HttpServletResponse response , String gradeId)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
			{
				store = stores.get (0);
			}
			if (null != gradeId && !gradeId.equals (""))
			{
				store.setUpdateGrade (this.storeGradeService.getByKey (CommUtil.null2Long (gradeId)));
			}
			this.storeService.updateByObject (store);
			StoreGradeLog grade_log = new StoreGradeLog ();
			grade_log.setAddtime (new Date ());
			grade_log.setStore (store);
			this.storeGradeLogService.add (grade_log);
			mv.addObject ("op_title" , "申请提交成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/store_set.htm");
			return mv;
		}

	@SecurityMapping(title = "店铺幻灯" , value = "/seller/store_slide.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_slide.htm" })
	public ModelAndView store_slide (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_slide.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (null != stores && stores.size () > 0)
			{
				store = stores.get (0);
			}
			StoreSlideExample storeSlideExample = new StoreSlideExample ();
			storeSlideExample.clear ();
			if (null != store && null != store.getId ())
			{
				storeSlideExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			}
			List <StoreSlide> storeSlideList = this.storeSlideService.getObjectList (storeSlideExample);
			if (null != storeSlideList && storeSlideList.size () > 0)
			{
				store.setSlides (storeSlideList);
			}
			this.storeService.updateByObject (store);
			mv.addObject ("store" , store);
			return mv;
		}

	@SecurityMapping(title = "店铺幻灯保存" , value = "/seller/store_slide_save.htm*" , rtype = "seller" , rname = "店铺设置" ,
						rcode = "store_set_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_slide_save.htm" })
	public String store_slide_save (HttpServletRequest request , HttpServletResponse response)
		{
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getByKey (user.getStoreId ());
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "store_slide";
			for (int i = 1 ; i <= 3 ; i++)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				String fileName = "";
				StoreSlide slide = null;
				StoreSlideExample storeSlideExample = new StoreSlideExample ();
				storeSlideExample.clear ();
				storeSlideExample.createCriteria ().andStoreIdEqualTo (store.getId ());
				List <StoreSlide> storeSlides = this.storeSlideService.getObjectList (storeSlideExample);
				store.getSlides ().addAll (storeSlides);
				if (storeSlides.size () >= i)
				{
					if (((StoreSlide) store.getSlides ().get (i - 1)).getAcc () != null)
					{
						fileName = ((StoreSlide) store.getSlides ().get (i - 1)).getAcc ().getName ();
					}
					slide = (StoreSlide) store.getSlides ().get (i - 1);
				}
				try
				{
					map = CommUtil.saveFileToServer (request , "acc" + i , saveFilePathName , fileName , null);
					Accessory acc = null;
					if (fileName.equals (""))
					{
						if (!map.get ("fileName").equals (""))
						{
							acc = new Accessory ();
							acc.setName (CommUtil.null2String (map.get ("fileName")));
							acc.setExt (CommUtil.null2String (map.get ("mime")));
							acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
							acc.setPath (uploadFilePath + "/store_slide");
							acc.setWidth (CommUtil.null2Int (map.get ("width")));
							acc.setHeight (CommUtil.null2Int (map.get ("height")));
							acc.setAddtime (new Date ());
							this.accessoryService.add (acc);
							if (slide != null)
							{
								if (slide.getAcc () == null)
								{
									slide.setAccId (acc.getId ());
									slide.setAcc (acc);
								}
							}
						}
					}
					else if (!map.get ("fileName").equals (""))
					{
						acc = slide.getAcc ();
						acc.setName (CommUtil.null2String (map.get ("fileName")));
						acc.setExt (CommUtil.null2String (map.get ("mime")));
						acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
						acc.setPath (uploadFilePath + "/store_slide");
						acc.setWidth (CommUtil.null2Int (map.get ("width")));
						acc.setHeight (CommUtil.null2Int (map.get ("height")));
						acc.setAddtime (new Date ());
						this.accessoryService.updateByObject (acc);
					}
					if (acc != null)
					{
						if (slide == null)
						{
							slide = new StoreSlide ();
							slide.setAcc (acc);
							slide.setAddtime (new Date ());
							slide.setStoreId (store.getId ());
							slide.setStore (store);
						}
						slide.setUrl (request.getParameter ("acc_url" + i));
						if (slide.getId () == null)
						{
							this.storeSlideService.add (slide);
						}
						else
						{
							this.storeSlideService.updateByObject (slide);
						}
					}
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
			/*
			 * StoreSlideExample storeSlideExample = new StoreSlideExample();
			 * storeSlideExample.clear();
			 * storeSlideExample.createCriteria().andStoreIdEqualTo(store.getId());
			 * List<StoreSlide> storeSlides = storeSlideService.getObjectList(storeSlideExample);
			 * if(storeSlides.size()>3){
			 * //删除之前门店的幻灯片的图片
			 * for(int i=3; i<storeSlides.size(); i++ ){
			 * Accessory acc = storeSlides.get(i).getAcc();
			 * AccessoryExample ae = new AccessoryExample();
			 * ae.clear();
			 * ae.createCriteria().andIdEqualTo(acc.getId());
			 * this.accessoryService.deleteByExample(ae);
			 * }
			 * //删除之前门店的幻灯片
			 * //this.storeSlideService.deleteByExample(storeSlideExample);
			 * }
			 */
			return "redirect:/seller/store_slide.htm";
		}

	@RequestMapping({ "/seller/imgAjax.htm" })
	@ResponseBody
	public String imgAjax (HttpServletRequest request , HttpServletResponse response , String imgUrl)
		{
			/*
			 * String uploadPath = this.configService.getSysConfig().getUploadfilepath();
			 * String addFilePathName = this.configService.getSysConfig().getUploadRootPath()
			 * + File.separator
			 * + uploadPath
			 * + File.separator
			 * + "seller";
			 * Map map = null;
			 * Accessory acc = new Accessory();
			 * try {
			 * map = CommUtil.saveFileToServer(request, "img", addFilePathName, "", null);
			 * if(map != null) {
			 * acc.setAddtime(new Date());
			 * acc.setWidth(CommUtil.null2Int(map.get("width")));
			 * acc.setHeight(CommUtil.null2Int(map.get("height")));
			 * acc.setExt(CommUtil.null2String(map.get("mime")));
			 * acc.setPath(uploadPath + "/seller");
			 * acc.setName(CommUtil.null2String(map.get("fileName")));
			 * acc.setSize(CommUtil.null2Float(map.get("fileSize")));
			 * this.accessoryService.add(acc);
			 * }
			 * } catch (IOException e) {
			 * e.printStackTrace();
			 * }
			 * return CommUtil.null2String(acc.getId());
			 * }
			 */
			return CommUtil.null2String (imgUrl);
		}
}
