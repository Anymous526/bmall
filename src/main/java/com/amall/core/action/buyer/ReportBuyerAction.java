package com.amall.core.action.buyer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Report;
import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportSubject;
import com.amall.core.bean.ReportSubjectExample;
import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;
import com.amall.core.bean.ReportWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.report.IReportService;
import com.amall.core.service.report.IReportSubjectService;
import com.amall.core.service.report.IReportTypeService;
import com.amall.core.service.store.IStoreService;
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
 * Title: ReportBuyerAction
 * </p>
 * <p>
 * Description: 卖家举报 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月25日下午7:26:26
 * @version 1.0
 */
@Controller
public class ReportBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IReportTypeService reportTypeService;

	@Autowired
	private IReportSubjectService reportSubjectService;

	@Autowired
	private IReportService reportService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@SecurityMapping(title = "买家举报商品列表" , value = "/buyer/report.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report.htm" })
	public ModelAndView report (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ReportExample reportExample = new ReportExample ();
			reportExample.clear ();
			reportExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			reportExample.setOrderByClause (Pagination.cst (null , null));
			reportExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStoreIdIsNull ();
			Pagination pList = reportService.getObjectListWithPage (reportExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * @Title: ReportBuyerAction
	 * @Description: 买家在商品详情页举报商品
	 * @return mv
	 * @author xpy
	 * @date 2015年8月13日 20:10
	 */
	@SecurityMapping(title = "买家举报商品" , value = "/buyer/shop_report.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/shop_report.htm" })
	public ModelAndView shopReport (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/shop_report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (user.getReport () == -1)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您因为恶意举报已被禁止举报，请与商城管理员联系");
				mv.addObject ("url" , CommUtil.getURL (request) + "/goods.htm?id=" + id);
			}
			else
			{
				ReportExample reportExample = new ReportExample ();
				reportExample.clear ();
				reportExample.createCriteria ().andGoodsIdEqualTo (CommUtil.null2Long (id)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStatusEqualTo (Integer.valueOf (0));
				List <ReportWithBLOBs> reports = reportService.getObjectList (reportExample);
				if (reports.size () == 0)
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					Store store = this.storeService.getByKey (goods.getGoodsStoreId ());
					User storeUser=null;
					if (null != store && null != store.getUserId ())
					{
						storeUser= this.userService.getByKey (store.getUserId ());
					}
					if (store != null && storeUser != null)
					{
						store.setUser (storeUser);
						goods.setGoodsStore (store);
					}
					mv.addObject ("goods" , goods);
					ReportTypeExample reportTypeExample = new ReportTypeExample ();
					reportTypeExample.clear ();
					reportTypeExample.setOrderByClause ("addTime desc");
					List <ReportType> types = reportTypeService.getObjectList (reportTypeExample);
					mv.addObject ("types" , types);
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您已经举报该商品，且尚未得到商城处理");
					mv.addObject ("url" , CommUtil.getURL (request) + "/goods.htm?id=" + id);
				}
			}
			return mv;
		}

	@SecurityMapping(title = "买家举报商品" , value = "/buyer/report_add.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report_add.htm" })
	public ModelAndView report_add (HttpServletRequest request , HttpServletResponse response , String goods_id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (user.getReport () == -1)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您因为恶意举报已被禁止举报，请与商城管理员联系");
				mv.addObject ("url" , CommUtil.getURL (request) + "/goods_" + goods_id + ".htm");
			}
			else
			{
				ReportExample reportExample = new ReportExample ();
				reportExample.clear ();
				reportExample.createCriteria ().andGoodsIdEqualTo (CommUtil.null2Long (goods_id)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStatusEqualTo (Integer.valueOf (0));
				List <ReportWithBLOBs> reports = reportService.getObjectList (reportExample);
				if (reports.size () == 0)
				{
					Goods goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
					mv.addObject ("goods" , goods);
					ReportTypeExample reportTypeExample = new ReportTypeExample ();
					reportTypeExample.clear ();
					reportTypeExample.setOrderByClause ("addTime desc");
					List <ReportType> types = reportTypeService.getObjectList (reportTypeExample);
					mv.addObject ("types" , types);
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您已经举报该商品，且尚未得到商城处理");
					mv.addObject ("url" , CommUtil.getURL (request) + "/goods_" + goods_id + ".htm");
				}
			}
			return mv;
		}

	@SecurityMapping(title = "保存买家举报商品和店铺" , value = "/buyer/report_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report_save.htm" })
	public ModelAndView report_save (HttpServletRequest request , HttpServletResponse response , String goods_id , String subjectId , String storeId)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			WebForm wf = new WebForm ();
			ReportWithBLOBs report = (ReportWithBLOBs) wf.toPo (request , ReportWithBLOBs.class);
			report.setAddtime (new Date ());
			report.setUser (SecurityUserHolder.getCurrentUser ());
			// 用来判断是商品举报还是店铺举报
			if (goods_id != null && !"".equals (goods_id))
			{
				GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
				report.setGoods (goods);
			}
			else
			{
				StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (storeId));
				report.setStore (store);
			}
			ReportSubject subject = this.reportSubjectService.getByKey (CommUtil.null2Long (subjectId));
			report.setSubject (subject);
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "report";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				map = CommUtil.saveFileToServer (request , "img1" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory acc1 = new Accessory ();
					acc1.setName (CommUtil.null2String (map.get ("fileName")));
					acc1.setExt (CommUtil.null2String (map.get ("mime")));
					acc1.setSize (CommUtil.null2Float (map.get ("fileSize")));
					acc1.setPath (uploadFilePath + "/report");
					acc1.setWidth (CommUtil.null2Int (map.get ("width")));
					acc1.setHeight (CommUtil.null2Int (map.get ("height")));
					acc1.setAddtime (new Date ());
					this.accessoryService.add (acc1);
					report.setAcc1 (acc1);
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img2" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory acc2 = new Accessory ();
					acc2.setName (CommUtil.null2String (map.get ("fileName")));
					acc2.setExt (CommUtil.null2String (map.get ("mime")));
					acc2.setSize (CommUtil.null2Float (map.get ("fileSize")));
					acc2.setPath (uploadFilePath + "/report");
					acc2.setWidth (CommUtil.null2Int (map.get ("width")));
					acc2.setHeight (CommUtil.null2Int (map.get ("height")));
					acc2.setAddtime (new Date ());
					this.accessoryService.add (acc2);
					report.setAcc2 (acc2);
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img3" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory acc3 = new Accessory ();
					acc3.setName (CommUtil.null2String (map.get ("fileName")));
					acc3.setExt (CommUtil.null2String (map.get ("mime")));
					acc3.setSize (CommUtil.null2Float (map.get ("fileSize")));
					acc3.setPath (uploadFilePath + "/report");
					acc3.setWidth (CommUtil.null2Int (map.get ("width")));
					acc3.setHeight (CommUtil.null2Int (map.get ("height")));
					acc3.setAddtime (new Date ());
					this.accessoryService.add (acc3);
					report.setAcc3 (acc3);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.reportService.add (report);
			if (goods_id != null && !"".equals (goods_id))
			{
				mv.addObject ("op_title" , "举报商品成功");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/report.htm");
			}
			else
			{
				mv.addObject ("op_title" , "举报店铺成功");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/reportStore.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家举报详情" , value = "/buyer/report_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report_view.htm" })
	public ModelAndView report_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Report obj = this.reportService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			return mv;
		}

	@SecurityMapping(title = "买家举报店铺详情" , value = "/buyer/report_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report_view_store.htm" })
	public ModelAndView report_view_store (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Report obj = this.reportService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("reportType" , "reportStore");
			mv.addObject ("obj" , obj);
			return mv;
		}

	@SecurityMapping(title = "买家取消举报" , value = "/buyer/report_cancel.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/report_cancel.htm" })
	public String report_cancel (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String reportType)
		{
			ReportWithBLOBs obj = this.reportService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (-1);
			this.reportService.updateByObject (obj);
			if ("1".equals (reportType))
			{
				return "redirect:reportStore.htm?currentPage=" + currentPage;
			}
			else
			{
				return "redirect:report.htm?currentPage=" + currentPage;
			}
		}

	@RequestMapping({ "/buyer/report_subject_load.htm" })
	public void report_subject_load (HttpServletRequest request , HttpServletResponse response , String type_id)
		{
			ReportSubjectExample reportSubjectExample = new ReportSubjectExample ();
			reportSubjectExample.clear ();
			reportSubjectExample.createCriteria ().andTypeIdEqualTo (CommUtil.null2Long (type_id));
			List <ReportSubject> rss = reportSubjectService.getObjectList (reportSubjectExample);
			List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
			for (ReportSubject rs : rss)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("id" , rs.getId ());
				map.put ("title" , rs.getTitle ());
				list.add (map);
			}
			String temp = Json.toJson (list , JsonFormat.compact ());
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (temp);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 进入举报店铺编辑页
	 * <p>
	 * Title: reportStore
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @return
	 */
	@RequestMapping({ "/buyer/store_report.htm" })
	public ModelAndView reportStore (HttpServletRequest request , HttpServletResponse response , String storeId)
		{
			ModelAndView mv = new JModelAndView ("buyer/stor_report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * User user = this.userService.getByKey(SecurityUserHolder
			 * .getCurrentUser().getId());
			 */
			ReportExample reportExample = new ReportExample ();
			reportExample.clear ();
			reportExample.createCriteria ().andStoreIdEqualTo (CommUtil.null2Long (storeId)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStatusNotEqualTo (-1).andStatusNotEqualTo (1).andStatusIsNotNull ();
			List <ReportWithBLOBs> reports = reportService.getObjectList (reportExample);
			if (reports == null || reports.size () == 0)
			{
				Store store = this.storeService.getByKey (CommUtil.null2Long (storeId));
				mv.addObject ("store" , store);
				// 获取被举报的人
				User user = this.userService.getByKey (store.getUserId ());
				ReportTypeExample reportTypeExample = new ReportTypeExample ();
				reportTypeExample.clear ();
				reportTypeExample.setOrderByClause ("addTime desc");
				List <ReportType> types = reportTypeService.getObjectList (reportTypeExample);
				ReportSubjectExample reportSubjectExample = new ReportSubjectExample ();
				reportSubjectExample.clear ();
				reportSubjectExample.setOrderByClause ("addTime desc");
				List <ReportSubject> subjects = reportSubjectService.getObjectList (reportSubjectExample);
				mv.addObject ("subjects" , subjects);
				mv.addObject ("user" , user);
				mv.addObject ("types" , types);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您已经举报该店铺");
				mv.addObject ("url" , CommUtil.getURL (request) + "/store_" + storeId + ".htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家举报店铺列表" , value = "/buyer/report.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/reportStore.htm" })
	public ModelAndView reportStoreList (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ReportExample reportExample = new ReportExample ();
			reportExample.clear ();
			reportExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			reportExample.setOrderByClause (Pagination.cst (null , null));
			reportExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			reportExample.createCriteria ().andStoreIdIsNotNull ();
			Pagination pList = reportService.getObjectListWithPage (reportExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("reportType" , "reportStore");
			return mv;
		}
}
