package com.amall.core.action.admin;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Coupon;
import com.amall.core.bean.CouponExample;
import com.amall.core.bean.CouponInfo;
import com.amall.core.bean.CouponInfoExample;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.coupon.ICouponInfoService;
import com.amall.core.service.coupon.ICouponService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
public class CouponManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ICouponService couponService;

	@Autowired
	private ICouponInfoService couponinfoService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IOrderFormService orderFormService;

	@SecurityMapping(title = "优惠券列表" , value = "/admin/coupon_list.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_list.htm" })
	public ModelAndView coupon_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String couponName , String couponBeginTime , String couponEndTime)
		{
			ModelAndView mv = new JModelAndView ("admin/coupon_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			CouponExample couponExample = new CouponExample ();
			couponExample.clear ();
			CouponExample.Criteria couponCriteria = couponExample.createCriteria ();
			couponExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			couponExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			if (!CommUtil.null2String (couponName).equals (""))
			{
				couponCriteria.andCouponNameLike ("%" + couponName + "%");
			}
			if (!CommUtil.null2String (couponBeginTime).equals (""))
			{
				couponCriteria.andCouponBeginTimeGreaterThanOrEqualTo (CommUtil.formatDate (couponBeginTime));
			}
			if (!CommUtil.null2String (couponEndTime).equals (""))
			{
				couponCriteria.andCouponEndTimeLessThanOrEqualTo (CommUtil.formatDate (couponEndTime));
			}
			Pagination pList = this.couponService.getObjectListWithPage (couponExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/coupon_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "优惠券添加" , value = "/admin/coupon_add.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_add.htm" })
	public ModelAndView coupon_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/coupon_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "优惠券保存" , value = "/admin/coupon_save.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_save.htm" })
	public String coupon_save (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			WebForm wf = new WebForm ();
			Coupon coupon = (Coupon) wf.toPo (request , Coupon.class);
			coupon.setAddtime (new Date ());
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "coupon";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				map = CommUtil.saveFileToServer (request , "coupon_img" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory coupon_acc = new Accessory ();
					coupon_acc.setName (CommUtil.null2String (map.get ("fileName")));
					coupon_acc.setExt ((String) map.get ("mime"));
					coupon_acc.setSize (((Float) map.get ("fileSize")).floatValue ());
					coupon_acc.setPath (uploadFilePath + "/coupon");
					coupon_acc.setWidth (CommUtil.null2Int (map.get ("width")));
					coupon_acc.setHeight (CommUtil.null2Int (map.get ("height")));
					coupon_acc.setAddtime (new Date ());
					this.accessoryService.add (coupon_acc);
					String pressImg = saveFilePathName + File.separator + coupon_acc.getName ();
					String targetImg = saveFilePathName + File.separator + coupon_acc.getName () + "." + coupon_acc.getExt ();
					if (!CommUtil.fileExist (saveFilePathName))
						CommUtil.createFolder (saveFilePathName);
					try
					{
						Font font = new Font ("Garamond" , 1 , 75);
						waterMarkWithText (pressImg , targetImg , this.configService.getSysConfig ().getCurrencyCode () + coupon.getCouponAmount () , "#FF7455" , font , 24 , 75 , 1.0F);
						font = new Font ("宋体" , 0 , 15);
						waterMarkWithText (targetImg , targetImg , "满 " + coupon.getCouponOrderAmount () + " 减" , "#726960" , font , 95 , 90 , 1.0F);
					}
					catch (Exception localException)
					{
					}
					coupon.setCouponAccId (coupon_acc.getId ());
				}
				else
				{
					String pressImg = request.getSession ().getServletContext ().getRealPath ("") + File.separator + "resources" + File.separator + "style" + File.separator + "common" + File.separator + "template" + File.separator + "coupon_template.jpg";
					String targetImgPath = request.getSession ().getServletContext ().getRealPath ("") + File.separator + uploadFilePath + File.separator + "coupon" + File.separator;
					if (!CommUtil.fileExist (targetImgPath))
					{
						CommUtil.createFolder (targetImgPath);
					}
					String targetImgName = UUID.randomUUID ().toString () + ".jpg";
					try
					{
						Font font = new Font ("Garamond" , 1 , 75);
						waterMarkWithText (pressImg , targetImgPath + targetImgName , this.configService.getSysConfig ().getCurrencyCode () + coupon.getCouponAmount () , "#FF7455" , font , 24 , 75 , 1.0F);
						font = new Font ("宋体" , 0 , 15);
						waterMarkWithText (targetImgPath + targetImgName , targetImgPath + targetImgName , "满 " + coupon.getCouponOrderAmount () + " 减" , "#726960" , font , 95 , 90 , 1.0F);
					}
					catch (Exception localException1)
					{
					}
					Accessory coupon_acc = new Accessory ();
					coupon_acc.setName (targetImgName);
					coupon_acc.setExt ("jpg");
					coupon_acc.setPath (uploadFilePath + "/coupon");
					coupon_acc.setAddtime (new Date ());
					this.accessoryService.add (coupon_acc);
					coupon.setCouponAccId (coupon_acc.getId ());
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.couponService.add (coupon);
			return "redirect:coupon_success.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "优惠券保存成功" , value = "/admin/coupon_success.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_success.htm" })
	public ModelAndView coupon_success (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/coupon_list.htm");
			mv.addObject ("op_title" , "优惠券保存成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/coupon_add.htm" + "?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "优惠券发放" , value = "/admin/coupon_send.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_send.htm" })
	public ModelAndView coupon_send (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/coupon_send.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreGradeExample storeGradeExample = new StoreGradeExample ();
			storeGradeExample.setOrderByClause (Pagination.cst ("sequence" , "asc"));
			List <StoreGrade> grades = this.storeGradeService.getObjectList (storeGradeExample);
			mv.addObject ("grades" , grades);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("obj" , this.couponService.getByKey (CommUtil.null2Long (id)));
			return mv;
		}

	@SecurityMapping(title = "优惠券发放保存" , value = "/admin/coupon_send_save.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_send_save.htm" })
	public ModelAndView coupon_send_save (HttpServletRequest request , HttpServletResponse response , String id , String type , String users , String grades , String order_amount) throws IOException
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <User> user_list = new ArrayList <User> ();
			if (type.equals ("all_user"))
			{
				UserExample userExample = new UserExample ();
				userExample.clear ();
				UserExample.Criteria userCriteria = userExample.createCriteria ();
				userExample.setOrderByClause (Pagination.cst ("addTime" , "desc"));
				userCriteria.andUserroleNotEqualTo ("ADMIN");
				user_list = this.userService.getObjectList (userExample);
			}
			User user = null;
			UserExample userExample = new UserExample ();
			if (type.equals ("the_user"))
			{
				List <String> user_names = CommUtil.str2list (users);
				for (String user_name : user_names)
				{
					userExample.clear ();
					UserExample.Criteria userCriteria = userExample.createCriteria ();
					userCriteria.andUsernameEqualTo (user_name);
					List <User> users2 = this.userService.getObjectList (userExample);
					if (null != users2 && users2.size () > 0)
						user = users2.get (0);
					// user = this.userService.getObjByProperty("userName", user_name);
					user_list.add (user);
				}
			}
			if (type.equals ("all_store"))
			{
				userExample.clear ();
				userExample.setOrderByClause ("addTime desc");
				userExample.createCriteria ().andStoreIdIsNotNull ();
				user_list = userService.getObjectList (userExample);
			}
			if (type.equals ("the_store"))
			{
				List <Long> store_ids = new ArrayList <Long> ();
				if (grades != null && !grades.equals (""))
				{
					String [ ] arrayOfString = grades.split (",");
					for (int i = 0 ; i < arrayOfString.length ; i++)
					{
						{
							String grade = arrayOfString[i];
							store_ids.add (Long.valueOf (Long.parseLong (grade)));
						}
					}
				}
				userExample.clear ();
				userExample.createCriteria ().andStoreIdIn (store_ids);
				user_list = userService.getObjectList (userExample);
			}
			if (type.equals ("the_order"))
			{
				/*
				 * List list = this.queryService
				 * .query(
				 * "select obj.user.id,sum(obj.totalPrice) from OrderForm obj where obj.order_status>=:order_status group by obj.user.id"
				 * ,
				 * params1, -1, -1);
				 */
				OrderFormExample orderFormExample = new OrderFormExample ();
				orderFormExample.clear ();
				orderFormExample.createCriteria ().andOrderStatusGreaterThan (Integer.valueOf (50));
				// List <OrderFormWithBLOBs> ofs = orderFormService.getObjectList
				// (orderFormExample);
				orderFormExample.clear ();
				orderFormExample.createCriteria ().andOrderStatusGreaterThanOrEqualTo (Integer.valueOf (50));
				List <OrderFormWithBLOBs> list = orderFormService.getUserAndPrice (orderFormExample);
				for (int i = 0 ; i < list.size () ; i++)
				{
					OrderFormWithBLOBs orderForm =list.get (i);
					Long user_id = CommUtil.null2Long (orderForm.getUserId ());
					double order_total_amount = CommUtil.null2Double (orderForm.getTotalprice ());
					if (order_total_amount > CommUtil.null2Double (order_amount))
					{
						User user2 = this.userService.getByKey (user_id);
						user_list.add (user2);
					}
				}
			}
			Coupon coupon = this.couponService.getByKey (CommUtil.null2Long (id));
			for (int i = 0 ; i < user_list.size () ; i++)
			{
				if (coupon.getCouponCount () > 0)
				{
					if (i >= coupon.getCouponCount ())
						break;
					CouponInfo info = new CouponInfo ();
					info.setAddtime (new Date ());
					info.setCouponId (coupon.getId ());
					info.setCouponSn (UUID.randomUUID ().toString ());
					User user2 = (User) user_list.get (i);
					info.setUserId (user2.getId ());
					this.couponinfoService.add (info);
				}
				else
				{
					CouponInfo info = new CouponInfo ();
					info.setAddtime (new Date ());
					info.setCouponId (coupon.getId ());
					info.setCouponSn (UUID.randomUUID ().toString ());
					User user2 = (User) user_list.get (i);
					info.setUserId (user2.getId ());
					this.couponinfoService.add (info);
				}
			}
			mv.addObject ("op_title" , "优惠券发放成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/coupon_list.htm");
			return mv;
		}

	@SecurityMapping(title = "优惠券AJAX更新" , value = "/admin/coupon_ajax.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_ajax.htm" })
	public void coupon_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			Coupon obj = this.couponService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = Coupon.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			Object val = null;
			for (Field field : fields)
			{
				if (field.getName ().equals (fieldName))
				{
					Class <?> clz = Class.forName ("java.lang.String");
					if (field.getType ().getName ().equals ("int"))
					{
						clz = Class.forName ("java.lang.Integer");
					}
					if (field.getType ().getName ().equals ("boolean"))
					{
						clz = Class.forName ("java.lang.Boolean");
					}
					if (!value.equals (""))
						val = BeanUtils.convertType (value , clz);
					else
					{
						val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
					}
					wrapper.setPropertyValue (fieldName , val);
				}
			}
			this.couponService.updateByObject (obj);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (val.toString ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "优惠券详细信息" , value = "/admin/coupon_ajax.htm*" , rtype = "admin" , rname = "优惠券管理" ,
						rcode = "coupon_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/coupon_info_list.htm" })
	public ModelAndView coupon_info_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String coupon_id)
		{
			ModelAndView mv = new JModelAndView ("admin/blue/coupon_info_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			CouponInfoExample couponInfoExample = new CouponInfoExample ();
			couponInfoExample.clear ();
			CouponInfoExample.Criteria couponInfoCriteria = couponInfoExample.createCriteria ();
			couponInfoExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			couponInfoExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			couponInfoCriteria.andCouponIdEqualTo (CommUtil.null2Long (coupon_id));
			Pagination pList = couponinfoService.getObjectListWithPage (couponInfoExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , params , pList , mv);
			mv.addObject ("coupon_id" , coupon_id);
			return mv;
		}

	@SuppressWarnings("restriction")
	private static boolean waterMarkWithText (String filePath , String outPath , String text , String markContentColor , Font font , int left , int top , float qualNum)
		{
			ImageIcon imgIcon = new ImageIcon (filePath);
			Image theImg = imgIcon.getImage ();
			int width = theImg.getWidth (null);
			int height = theImg.getHeight (null);
			BufferedImage bimage = new BufferedImage (width , height , 1);
			Graphics2D g = bimage.createGraphics ();
			if (font == null)
			{
				font = new Font ("宋体" , 1 , 20);
				g.setFont (font);
			}
			else
			{
				g.setFont (font);
			}
			g.setColor (CommUtil.getColor (markContentColor));
			g.setComposite (AlphaComposite.getInstance (10 , 1.0F));
			g.drawImage (theImg , 0 , 0 , null);
			g.drawString (text , left , top);
			g.dispose ();
			try
			{
				FileOutputStream out = new FileOutputStream (outPath);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder (out);
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam (bimage);
				param.setQuality (qualNum , true);
				encoder.encode (bimage , param);
				out.close ();
			}
			catch (Exception e)
			{
				return false;
			}
			return true;
		}
}
