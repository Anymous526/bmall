package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.WapAdvert;
import com.amall.core.bean.WapAdvertExample;
import com.amall.core.bean.WapAdvertPosition;
import com.amall.core.bean.WapAdvertPositionExample;
import com.amall.core.bean.WapAdvertPositionWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.advert.IWapAdvertPositionService;
import com.amall.core.service.advert.IWapAdvertService;
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
 * Title: AdvertManageAction
 * </p>
 * <p>
 * Description: 广告和广告为crud操作、广告审批 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午7:22:10
 * @version 1.0
 */
@Controller
public class AdvertManageAction
{

	private Logger log=Logger.getLogger (AdvertManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private IWapAdvertService wapAdvertService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IWapAdvertPositionService wapAdvertPositionService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IGoldLogService goldLogService;

	@SecurityMapping(title = "广告列表" , value = "/admin/advert_list.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_list.htm" })
	public ModelAndView advert_list (HttpServletRequest request , HttpServletResponse response , String currentPage [ ] , String orderBy , String orderType , String ad_title)
		{
			ModelAndView mv = new JModelAndView ("admin/advert_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			// 广告管理编辑完提交后，无法翻页。currentPage会为1,2或1,3等等，所以会有如下操作
			String currentPage1 = null;
			if (null != currentPage && currentPage.length != 0)
			{
				if (currentPage.length == 1)
				{
					currentPage1 = currentPage[0];
				}
				else
				{
					currentPage1 = currentPage[1];
				}
			}
			AdvertExample advertExample = new AdvertExample ();
			advertExample.clear ();
			advertExample.setOrderByClause ("ad_ap_id desc");
			advertExample.setPageSize (15);
			advertExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage1)));
			// advertExample.setOrderByClause(Pagination.cst(orderBy, orderType));
			AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
			if (!CommUtil.null2String (ad_title).equals (""))
			{
				advertCriteria.andAdTitleLike ("%" + ad_title.trim () + "%");
			}
			Pagination pList = advertService.getObjectListWithPage (advertExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("ad_title" , ad_title);
			return mv;
		}

	/**
	 * @Title: wap_advert_list
	 * @Description: wap广告管理
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param ad_title
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月11日
	 */
	@RequestMapping({ "/admin/wap_advert_list.htm" })
	public ModelAndView wap_advert_list (HttpServletRequest request , HttpServletResponse response , String currentPage [ ] , String orderBy , String orderType , String ad_title)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_advert_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			// 广告管理编辑完提交后，无法翻页。currentPage会为1,2或1,3等等，所以会有如下操作
			String currentPage1 = null;
			if (null != currentPage && currentPage.length != 0)
			{
				if (currentPage.length == 1)
				{
					currentPage1 = currentPage[0];
				}
				else
				{
					currentPage1 = currentPage[1];
				}
			}
			WapAdvertExample advertExample = new WapAdvertExample ();
			advertExample.clear ();
			advertExample.setOrderByClause ("ad_ap_id desc");
			advertExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage1)));
			// advertExample.setOrderByClause(Pagination.cst(orderBy, orderType));
			WapAdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
			if (!CommUtil.null2String (ad_title).equals (""))
			{
				advertCriteria.andAdTitleLike ("%" + ad_title.trim () + "%");
			}
			Pagination pList = wapAdvertService.getObjectListWithPage (advertExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("ad_title" , ad_title);
			return mv;
		}

	@SecurityMapping(title = "待审批广告列表" , value = "/admin/advert_list_audit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_list_audit.htm" })
	public ModelAndView advert_list_audit (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String adTitle)
		{
			ModelAndView mv = new JModelAndView ("admin/advert_list_audit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			AdvertExample advertExample = new AdvertExample ();
			advertExample.clear ();
			advertExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
			if (!CommUtil.null2String (adTitle).equals (""))
			{
				advertCriteria.andAdTitleLike ("%" + adTitle.trim () + "%");
			}
			advertCriteria.andAdStatusEqualTo (Integer.valueOf (0));
			Pagination pList = advertService.getObjectListWithPage (advertExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("adTitle" , adTitle);
			return mv;
		}

	@SecurityMapping(title = "待审批广告列表" , value = "/admin/advert_list_audit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_advert_list_audit.htm" })
	public ModelAndView wap_advert_list_audit (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String adTitle)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_advert_list_audit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			WapAdvertExample advertExample = new WapAdvertExample ();
			advertExample.clear ();
			advertExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			WapAdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
			if (!CommUtil.null2String (adTitle).equals (""))
			{
				advertCriteria.andAdTitleLike ("%" + adTitle.trim () + "%");
			}
			advertCriteria.andAdStatusEqualTo (Integer.valueOf (0));
			Pagination pList = wapAdvertService.getObjectListWithPage (advertExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("adTitle" , adTitle);
			return mv;
		}

	@SecurityMapping(title = "广告增加" , value = "/admin/advert_add.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_add.htm" })
	public ModelAndView advert_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/advert_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <AdvertPositionWithBLOBs> aps = advertPositionService.getObjectList (new AdvertPositionExample ());
			mv.addObject ("aps" , aps);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "广告增加" , value = "/admin/wap_advert_add.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_advert_add.htm" })
	public ModelAndView wap_advert_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_advert_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <WapAdvertPositionWithBLOBs> aps = wapAdvertPositionService.getObjectList (new WapAdvertPositionExample ());
			mv.addObject ("aps" , aps);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "WAP广告编辑" , value = "/admin/wap_advert_edit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_advert_edit.htm" })
	public ModelAndView wap_advert_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_advert_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				WapAdvert wapAdvert = this.wapAdvertService.getByKey (Long.valueOf (Long.parseLong (id)));
				List <WapAdvertPositionWithBLOBs> aps = wapAdvertPositionService.getObjectList (new WapAdvertPositionExample ());
				System.out.println("lll="+wapAdvert.getAdText());
				mv.addObject ("aps" , aps);
				mv.addObject ("obj" , wapAdvert);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "广告编辑" , value = "/admin/advert_edit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_edit.htm" })
	public ModelAndView advert_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/advert_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Advert advert = this.advertService.getByKey (Long.valueOf (Long.parseLong (id)));
				List <AdvertPositionWithBLOBs> aps = advertPositionService.getObjectList (new AdvertPositionExample ());
				mv.addObject ("aps" , aps);
				mv.addObject ("obj" , advert);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "广告查看" , value = "/admin/advert_view.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_view.htm" })
	public ModelAndView advert_view (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/advert_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Advert advert = this.advertService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , advert);
				mv.addObject ("currentPage" , currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "广告审核" , value = "/admin/advert_audit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_audit.htm" })
	public ModelAndView advert_audit (HttpServletRequest request , HttpServletResponse response , String id , String ad_status , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Advert obj = this.advertService.getByKey (CommUtil.null2Long (id));
			obj.setAdStatus (CommUtil.null2Int (ad_status));
			this.advertService.updateByObject (obj);
			if ((obj.getAdStatus () == 1) && (obj.getAdAp ().getApShowType () == 0))
			{
				AdvertPositionWithBLOBs ap = obj.getAdAp ();
				ap.setApUseStatus (1);
				this.advertPositionService.updateByObject (ap);
			}
			if (obj.getAdStatus () == -1)
			{
				User user = obj.getAdUser ();
				user.setGold (user.getGold () + obj.getAdGold ());
				this.userService.updateByObject (user);
				GoldLogWithBLOBs log = new GoldLogWithBLOBs ();
				log.setAddtime (new Date ());
				log.setGlContent ("广告审核失败，恢复金币");
				log.setGlCount (obj.getAdGold ());
				log.setGlUser (obj.getAdUser ());
				log.setGlType (0);
				this.goldLogService.add (log);
			}
			mv.addObject ("op_title" , "广告审核成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/advert_list_audit.htm?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "广告保存" , value = "/admin/advert_save.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_save.htm" })
	public ModelAndView advert_save (HttpServletRequest request , HttpServletResponse response , String id , String adApId , String currentPage , String adBeginTime , String adEndTime)
		{
			WebForm wf = new WebForm ();
			Advert advert = null;
			if (id.equals (""))
			{
				advert = (Advert) wf.toPo (request , Advert.class);
				advert.setAddtime (new Date ());
				advert.setAdUser (SecurityUserHolder.getCurrentUser ());
			}
			else
			{
				Advert obj = this.advertService.getByKey (Long.valueOf (Long.parseLong (id)));
				advert = (Advert) wf.toPo (request , obj);
			}
			AdvertPositionWithBLOBs ap = this.advertPositionService.getByKey (CommUtil.null2Long (adApId));
			advert.setAdApId (ap.getId ());
			advert.setAdBeginTime (CommUtil.formatDate (adBeginTime));
			advert.setAdEndTime (CommUtil.formatDate (adEndTime));
			advert.setAdClickNum (0);
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "mvert";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			// if (advert.getAdAcc() != null)
			// fileName = advert.getAdAcc().getName();
			try
			{
				map = CommUtil.saveFileToServer (request , "acc" , addFilePathName , fileName , null);
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
			if (id.equals (""))
				this.advertService.add (advert);
			else
				this.advertService.updateByObject (advert);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/advert_list.htm?currentPage=" + currentPage);
			mv.addObject ("op_title" , "保存广告成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/advert_add.htm?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "广告保存" , value = "/admin/wap_advert_save.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_advert_save.htm" })
	public ModelAndView wap_advert_save (HttpServletRequest request , HttpServletResponse response , String id , String adApId , String currentPage , String adBeginTime , String adEndTime , Integer goodsId)
		{
			WebForm wf = new WebForm ();
			WapAdvert advert = null;
			if (id.equals (""))
			{
				advert = (WapAdvert) wf.toPo (request , WapAdvert.class);
				advert.setAddtime (new Date ());
				advert.setAdUser (SecurityUserHolder.getCurrentUser ());
			}
			else
			{
				WapAdvert obj = this.wapAdvertService.getByKey (Long.valueOf (Long.parseLong (id)));
				advert = (WapAdvert) wf.toPo (request , obj);
			}
			if(null != goodsId){
				advert.setAdText(goodsId.toString().trim());
			}
			WapAdvertPositionWithBLOBs ap = this.wapAdvertPositionService.getByKey (CommUtil.null2Long (adApId));
			advert.setAdApId (ap.getId ());
			advert.setAdBeginTime (CommUtil.formatDate (adBeginTime));
			advert.setAdEndTime (CommUtil.formatDate (adEndTime));
			advert.setAdClickNum (0);
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "mvert";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			try
			{
				map = CommUtil.saveFileToServer (request , "acc" , addFilePathName , fileName , null);
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
			if (id.equals (""))
			{
				this.wapAdvertService.add (advert);
			}
			else
			{
				this.wapAdvertService.updateByObject (advert);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/wap_advert_list.htm?currentPage=" + currentPage);
			mv.addObject ("op_title" , "保存广告成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/wap_advert_add.htm?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "广告删除" , value = "/admin/advert_del.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/advert_del.htm" })
	public String advert_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					Advert advert = this.advertService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (advert.getAdStatus () != 1)
					{
						CommUtil.del_acc (request , advert.getAdAcc () , this.configService.getSysConfig ().getUploadRootPath ());
						this.advertService.deleteByKey (Long.valueOf (Long.parseLong (id)));
					}
				}
			}
			return "redirect:advert_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "广告位添加" , value = "/admin/adv_pos_add.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/adv_pos_add.htm" })
	public ModelAndView adv_pos_add (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/adv_pos_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <Advert> advs = advertService.getObjectList (new AdvertExample ());
			/*
			 * List advs = this.advertService.query("select obj from Advert obj",
			 * null, -1, -1);
			 */
			mv.addObject ("advs" , advs);
			return mv;
		}

	@SecurityMapping(title = "广告位添加" , value = "/admin/wap_adv_pos_add.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_adv_pos_add.htm" })
	public ModelAndView wap_adv_pos_add (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_adv_pos_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			List <WapAdvert> advs = wapAdvertService.getObjectList (new WapAdvertExample ());
			/*
			 * List advs = this.advertService.query("select obj from Advert obj",
			 * null, -1, -1);
			 */
			mv.addObject ("advs" , advs);
			return mv;
		}

	@SecurityMapping(title = "广告位保存" , value = "/admin/adv_pos_save.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/adv_pos_save.htm" })
	public ModelAndView adv_pos_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url , String apMark , String sequence)
		{
			WebForm wf = new WebForm ();
			AdvertPositionWithBLOBs ap = null;
			if (id.equals (""))
			{
				ap = (AdvertPositionWithBLOBs) wf.toPo (request , AdvertPositionWithBLOBs.class);
				ap.setAddtime (new Date ());
			}
			else
			{
				AdvertPosition obj = this.advertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
				ap = (AdvertPositionWithBLOBs) wf.toPo (request , obj);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "mvert";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			if (ap.getApAcc () != null)
				fileName = ap.getApAcc ().getName ();
			try
			{
				map = CommUtil.saveFileToServer (request , "acc" , addFilePathName , fileName , null);
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
						ap.setApAcc (acc);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					acc = ap.getApAcc ();
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
			if (null != sequence && !sequence.equals (""))// 如果sequence序列号不为空
			{
				if (null != apMark && !apMark.equals (""))// 如果有标识位置
				{
					ap.setApMark (apMark + sequence);// 格式为index1、index2、groupbuy1、groupbuy2、new1、new2
				}
			}
			else
			{
				if (null != apMark && !apMark.equals (""))// 如果有标识位置
				{
					ap.setApMark (apMark);// 格式为customize、sale、new
				}
			}
			if (id.equals (""))
				this.advertPositionService.add (ap);
			else
				this.advertPositionService.updateByObject (ap);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存广告位成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "广告位保存" , value = "/admin/wap_adv_pos_save.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_adv_pos_save.htm" })
	public ModelAndView wap_adv_pos_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url , String apMark , String sequence)
		{
			WebForm wf = new WebForm ();
			WapAdvertPositionWithBLOBs ap = null;
			if (id.equals (""))
			{
				ap = (WapAdvertPositionWithBLOBs) wf.toPo (request , WapAdvertPositionWithBLOBs.class);
				ap.setAddtime (new Date ());
			}
			else
			{
				WapAdvertPosition obj = this.wapAdvertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
				ap = (WapAdvertPositionWithBLOBs) wf.toPo (request , obj);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "mvert";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			if (ap.getApAcc () != null)
				fileName = ap.getApAcc ().getName ();
			try
			{
				map = CommUtil.saveFileToServer (request , "acc" , addFilePathName , fileName , null);
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
						ap.setApAcc (acc);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					acc = ap.getApAcc ();
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
			if (null != sequence && !sequence.equals (""))// 如果sequence序列号不为空
			{
				if (null != apMark && !apMark.equals (""))// 如果有标识位置
				{
					ap.setApMark (apMark + sequence);// 格式为index1、index2、groupbuy1、groupbuy2、new1、new2
				}
			}
			else
			{
				if (null != apMark && !apMark.equals (""))// 如果有标识位置
				{
					ap.setApMark (apMark);// 格式为customize、sale、new
				}
			}
			if (id.equals (""))
				this.wapAdvertPositionService.add (ap);
			else
				this.wapAdvertPositionService.updateByObject (ap);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存广告位成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "广告位列表" , value = "/admin/adv_pos_list.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/adv_pos_list.htm" })
	public ModelAndView adv_pos_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String ap_title)
		{
			ModelAndView mv = new JModelAndView ("admin/adv_pos_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertPositionExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			/*
			 * AdvertPositionQueryObject qo = new AdvertPositionQueryObject(
			 * currentPage, mv, orderBy, orderType);
			 */
			if (!CommUtil.null2String (ap_title).equals (""))
			{
				advertPositionExample.createCriteria ().andApTitleLike ("%" + ap_title + "%");
				/*
				 * qo.addQuery("obj.ap_title", new SysMap("ap_title", "%" + ap_title
				 * + "%"), "like");
				 */
			}
			Pagination pList = advertPositionService.getObjectListWithPage (advertPositionExample);
			// IPageList pList = this.advertPositionService.list(qo);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("ap_title" , ap_title);
			return mv;
		}

	@SecurityMapping(title = "广告位列表" , value = "/admin/wap_adv_pos_list.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_adv_pos_list.htm" })
	public ModelAndView wap_adv_pos_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String ap_title)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_adv_pos_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			WapAdvertPositionExample advertPositionExample = new WapAdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			advertPositionExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			/*
			 * AdvertPositionQueryObject qo = new AdvertPositionQueryObject(
			 * currentPage, mv, orderBy, orderType);
			 */
			if (!CommUtil.null2String (ap_title).equals (""))
			{
				advertPositionExample.createCriteria ().andApTitleLike ("%" + ap_title + "%");
				/*
				 * qo.addQuery("obj.ap_title", new SysMap("ap_title", "%" + ap_title
				 * + "%"), "like");
				 */
			}
			Pagination pList = wapAdvertPositionService.getObjectListWithPage (advertPositionExample);
			// IPageList pList = this.advertPositionService.list(qo);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("ap_title" , ap_title);
			return mv;
		}

	@SecurityMapping(title = "广告位编辑" , value = "/admin/adv_pos_edit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/adv_pos_edit.htm" })
	public ModelAndView adv_pos_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/adv_pos_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				AdvertPosition obj = this.advertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
				obj.setApAcc (this.accessoryService.getByKey (CommUtil.null2Long (obj.getApAccId ())));
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "广告位编辑" , value = "/admin/wap_adv_pos_edit.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_adv_pos_edit.htm" })
	public ModelAndView wap_adv_pos_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/wap_adv_pos_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				WapAdvertPosition obj = this.wapAdvertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
				obj.setApAcc (this.accessoryService.getByKey (CommUtil.null2Long (obj.getApAccId ())));
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "广告位删除" , value = "/admin/adv_pos_del.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/adv_pos_del.htm" })
	public String adv_pos_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					AdvertPositionWithBLOBs ap = this.advertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
					// 删除Advert表中ApId为Id的记录
					AdvertExample advertExample = new AdvertExample ();
					advertExample.clear ();
					advertExample.createCriteria ().andAdApIdEqualTo (Long.valueOf (id));
					if (ap.getApSysType () != 0)
					{
						CommUtil.del_acc (request , ap.getApAcc () , this.configService.getSysConfig ().getUploadRootPath ());
						this.advertService.deleteByExample (advertExample);
						this.advertPositionService.deleteByKey (Long.valueOf (Long.parseLong (id)));
					}
				}
			}
			return "redirect:adv_pos_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "广告位删除" , value = "/admin/wap_adv_pos_del.htm*" , rtype = "admin" , rname = "广告管理" ,
						rcode = "advert_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/wap_adv_pos_del.htm" })
	public String wap_adv_pos_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					WapAdvertPositionWithBLOBs ap = this.wapAdvertPositionService.getByKey (Long.valueOf (Long.parseLong (id)));
					// 删除Advert表中ApId为Id的记录
					WapAdvertExample advertExample = new WapAdvertExample ();
					advertExample.clear ();
					advertExample.createCriteria ().andAdApIdEqualTo (Long.valueOf (id));
					if (ap.getApSysType () != 0)
					{
						CommUtil.del_acc (request , ap.getApAcc () , this.configService.getSysConfig ().getUploadRootPath ());
						this.wapAdvertService.deleteByExample (advertExample);
						this.wapAdvertPositionService.deleteByKey (Long.valueOf (Long.parseLong (id)));
					}
				}
			}
			return "redirect:wap_adv_pos_list.htm?currentPage=" + currentPage;
		}

	@RequestMapping({ "/admin/advert_ajax.htm" })
	public void advert_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			Advert advert = advertService.getByKey (Long.parseLong (id));
			Object val = null;
			try
			{
				val=CreateBeanWrapperUtil.createBeanWrapper (Advert.class , advert , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());
			}
			this.advertService.updateByObject (advert);
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
				log.error (e.getMessage ());
			}
		}

	@RequestMapping({ "/admin/wap_advert_ajax.htm" })
	public void wap_advert_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			WapAdvert advert = wapAdvertService.getByKey (Long.parseLong (id));
			Object val = null;
			try
				{
					val=CreateBeanWrapperUtil.createBeanWrapper (WapAdvert.class , advert , fieldName , value);
				}
				catch (ClassNotFoundException e1)
				{
					log.error ("javaBean对象执行动作异常，"+e1.getMessage ());
				}
			this.wapAdvertService.updateByObject (advert);
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
				log.error (e.getMessage ());
			}
		}
}
