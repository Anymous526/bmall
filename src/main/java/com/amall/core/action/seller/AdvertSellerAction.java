package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: AdvertSellerAction
 * </p>
 * <p>
 * Description: 卖家广告相关 crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月18日下午6:22:45
 * @version 1.0
 */
@Controller
public class AdvertSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoldLogService goldLogService;

	@SecurityMapping(title = "广告列表" , value = "/seller/advert_list.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_list.htm" })
	public ModelAndView advert_list (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/advert_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertPositionExample.setPageSize (Integer.valueOf (30));
			advertPositionExample.setOrderByClause ("addTime desc");
			advertPositionExample.createCriteria ().andApStatusEqualTo (Integer.valueOf (1)).andApUseStatusEqualTo (Integer.valueOf (1));
			Pagination pList = advertPositionService.getObjectListWithPage (advertPositionExample);
			/*
			 * AdvertExample advertExample = new AdvertExample();
			 * advertExample.clear();
			 * advertExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
			 * advertExample.setPageSize(Integer.valueOf(15));
			 * advertExample.setOrderByClause("addTime desc");
			 * advertExample.createCriteria().andAdStatusEqualTo(Integer.valueOf(1));
			 * Pagination pList = advertService.getObjectListWithPage(advertExample);
			 */
			String url = CommUtil.getURL (request) + "/seller/advert_list.htm";
			CommUtil.addIPageList2ModelAndView (url , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "广告购买" , value = "/seller/advert_apply.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_apply.htm" })
	public ModelAndView advert_apply (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/advert_apply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AdvertPosition ap = this.advertPositionService.getByKey (CommUtil.null2Long (id));
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (ap.getApPrice () * 10 > user.getGold ())
			{ // 将购买价格折算为人民币进行比较
				mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "金币不足，不能申请");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_list.htm");
			}
			else
			{
				String ap_session = CommUtil.randomString (32);
				request.getSession (false).setAttribute ("ap_session" , ap_session);
				mv.addObject ("ap_session" , ap_session);
				mv.addObject ("ap" , ap);
				mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			}
			return mv;
		}

	@RequestMapping({ "/seller/advert_vefity.htm" })
	public void advert_vefity (HttpServletRequest request , HttpServletResponse response , String month , String ap_id)
		{
			boolean ret = true;
			AdvertPosition ap = this.advertPositionService.getByKey (CommUtil.null2Long (ap_id));
			int total_price = ap.getApPrice () * CommUtil.null2Int (month);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (total_price > user.getGold ())
			{
				ret = false;
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

	@SecurityMapping(title = "广告购买保存" , value = "/seller/advert_apply_save.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_apply_save.htm" })
	public ModelAndView advert_apply_save (HttpServletRequest request , HttpServletResponse response , String id , String ap_id , String ad_begin_time , String month , String ap_session)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String ap_session1 = CommUtil.null2String (request.getSession (false).getAttribute ("ap_session"));
			if (ap_session1.equals (""))
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "禁止表单重复提交");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_list.htm");
			}
			else
			{
				request.getSession (false).removeAttribute ("ap_session");
				Advert advert = null;
				WebForm wf = new WebForm ();
				if (id.equals (""))
				{
					advert = (Advert) wf.toPo (request , Advert.class);
					advert.setAddtime (new Date ());
					AdvertPositionWithBLOBs ap = this.advertPositionService.getByKey (CommUtil.null2Long (ap_id));
					advert.setAdAp (ap);
					advert.setAdBeginTime (CommUtil.formatDate (ad_begin_time));
					Calendar cal = Calendar.getInstance ();
					cal.add (2 , CommUtil.null2Int (month));
					advert.setAdEndTime (cal.getTime ());
					advert.setAdUser (SecurityUserHolder.getCurrentUser ());
					advert.setAdGold (ap.getApPrice () * CommUtil.null2Int (month));
				}
				else
				{
					Advert obj = this.advertService.getByKey (CommUtil.null2Long (id));
					advert = (Advert) wf.toPo (request , obj);
				}
				if (!advert.getAdAp ().getApType ().equals ("text"))
				{
					String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
					String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "mvert";
					Map <String, Object> map = new HashMap <String, Object> ();
					String fileName = "";
					if (advert.getAdAcc () != null)
						fileName = advert.getAdAcc ().getName ();
					try
					{
						map = CommUtil.saveFileToServer (request , "acc" , saveFilePathName , fileName , null);
						Accessory acc = null;
						if (fileName.equals (""))
						{
							if (!map.get ("fileName").equals (""))
							{
								acc = new Accessory ();
								acc.setName (CommUtil.null2String (map.get ("fileName")));
								acc.setExt (CommUtil.null2String (map.get ("mime")));
								acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
								acc.setPath (uploadFilePath + "/mvert");
								acc.setWidth (CommUtil.null2Int (map.get ("width")));
								acc.setHeight (CommUtil.null2Int (map.get ("height")));
								acc.setAddtime (new Date ());
								this.accessoryService.add (acc);
								advert.setAdAcc (acc);
							}
						}
						else if (!map.get ("fileName").equals (""))
						{
							acc = advert.getAdAcc ();
							acc.setName (CommUtil.null2String (map.get ("fileName")));
							acc.setExt (CommUtil.null2String (map.get ("mime")));
							acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
							acc.setPath (uploadFilePath + "/mvert");
							acc.setWidth (CommUtil.null2Int (map.get ("width")));
							acc.setHeight (CommUtil.null2Int (map.get ("height")));
							acc.setAddtime (new Date ());
							this.accessoryService.updateByObject (acc);
						}
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
				}
				if (id.equals (""))
				{
					this.advertService.add (advert);
					User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
					user.setGold (user.getGold () - advert.getAdGold ());
					this.userService.updateByObject (user);
					GoldLogWithBLOBs log = new GoldLogWithBLOBs ();
					log.setAddtime (new Date ());
					log.setGlContent ("购买广告扣除金币");
					log.setGlCount (advert.getAdGold ());
					log.setGlUser (user);
					log.setGlType (-1);
					this.goldLogService.add (log);
				}
				else
				{
					this.advertService.updateByObject (advert);
				}
				mv.addObject ("op_title" , "广告申请成功");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_my.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "广告编辑" , value = "/seller/advert_apply_edit.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_apply_edit.htm" })
	public ModelAndView advert_apply_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/advert_apply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Advert obj = this.advertService.getByKey (CommUtil.null2Long (id));
			String ap_session = CommUtil.randomString (32);
			request.getSession (false).setAttribute ("ap_session" , ap_session);
			mv.addObject ("ap_session" , ap_session);
			mv.addObject ("ap" , obj.getAdAp ());
			mv.addObject ("obj" , obj);
			mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			return mv;
		}

	@SecurityMapping(title = "我的广告" , value = "/seller/advert_my.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_my.htm" })
	public ModelAndView advert_my (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/advert_my.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AdvertExample advertExample = new AdvertExample ();
			advertExample.clear ();
			advertExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertExample.setOrderByClause ("addTime desc");
			advertExample.createCriteria ().andAdUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			Pagination pList = advertService.getObjectListWithPage (advertExample);
			String url = CommUtil.getURL (request) + "/seller/advert_my.htm";
			CommUtil.addIPageList2ModelAndView (url , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "广告延时" , value = "/seller/advert_delay.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_delay.htm" })
	public ModelAndView advert_delay (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/advert_delay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Advert obj = this.advertService.getByKey (CommUtil.null2Long (id));
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (obj.getAdAp ().getApPrice () > user.getGold ())
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "金币不足，不能申请");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_list.htm");
			}
			else
			{
				String delay_session = CommUtil.randomString (32);
				request.getSession (false).setAttribute ("delay_session" , delay_session);
				mv.addObject ("delay_session" , delay_session);
				mv.addObject ("obj" , obj);
				mv.addObject ("ap" , obj.getAdAp ());
				mv.addObject ("user" , this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()));
			}
			return mv;
		}

	@SecurityMapping(title = "广告购买保存" , value = "/seller/advert_delay_save.htm*" , rtype = "seller" , rname = "广告管理" ,
						rcode = "advert_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/advert_delay_save.htm" })
	public ModelAndView advert_delay_save (HttpServletRequest request , HttpServletResponse response , String id , String month , String delay_session)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String delay_session1 = CommUtil.null2String (request.getSession (false).getAttribute ("delay_session"));
			if (delay_session1.equals (""))
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "禁止表单重复提交");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_list.htm");
			}
			else
			{
				request.getSession (false).removeAttribute ("delay_session");
				Advert advert = this.advertService.getByKey (CommUtil.null2Long (id));
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				int total_gold = advert.getAdAp ().getApPrice () * CommUtil.null2Int (month);
				if (total_gold < user.getGold ())
				{
					Calendar cal = Calendar.getInstance ();
					cal.setTime (advert.getAdEndTime ());
					cal.add (2 , CommUtil.null2Int (month));
					advert.setAdEndTime (cal.getTime ());
					advert.setAdGold (advert.getAdGold () + total_gold);
					this.advertService.updateByObject (advert);
					user.setGold (user.getGold () - total_gold);
					this.userService.updateByObject (user);
					GoldLogWithBLOBs log = new GoldLogWithBLOBs ();
					log.setAddtime (new Date ());
					log.setGlContent ("广告延时扣除金币");
					log.setGlCount (advert.getAdGold ());
					log.setGlUser (user);
					log.setGlType (-1);
					this.goldLogService.add (log);
					mv.addObject ("op_title" , "广告延时成功");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_my.htm");
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "金币不足，不能延时");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/advert_delay.htm?id=" + id);
				}
			}
			return mv;
		}
}
