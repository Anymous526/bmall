package com.amall.core.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Report;
import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.lucene.LuceneUtil;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.report.IReportService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;


/**
 * 举报处理 crud
 * @author ljx
 *
 */
@Controller
public class ReportManageAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IReportService reportService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IStoreService storeService;

	@SecurityMapping(title = "未处理商品举报列表", value = "/admin/report_list.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_list.htm" })
	public ModelAndView report_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goodsName, String userName) {
		ModelAndView mv = new JModelAndView("admin/report_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		String params = "";
		
		ReportExample reportExample = new ReportExample();
		reportExample.clear();
		reportExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		reportExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		ReportExample.Criteria reportCriteria = reportExample.createCriteria();
		
		/*ReportQueryObject qo = new ReportQueryObject(currentPage, mv, orderBy,
				orderType);*/
		
		if (!CommUtil.null2String(goodsName).equals("")) {
			GoodsExample goodsExample = new GoodsExample();
			goodsExample.clear();
			goodsExample.createCriteria().andGoodsNameLike("%"+goodsName+"%");
			List<GoodsWithBLOBs> goodsList = goodsService.getObjectList(goodsExample);
			List<Long> goodsIds = new ArrayList<Long>();
			for (Goods goods : goodsList) {
				goodsIds.add(goods.getId());
			}
			if(goodsIds.size()>0 && goodsIds != null ){
				reportCriteria.andGoodsIdIn(goodsIds);
			}else{
				reportCriteria.andGoodsIdIsNull();
			}
			
			mv.addObject("goods_name", goodsName);
		}
		if (!CommUtil.null2String(userName).equals("")) {
			
			UserExample userExample = new UserExample();
			userExample.clear();
			userExample.createCriteria().andUsernameEqualTo(userName);
			if(userService.getObjectList(userExample)!=null&&userService.getObjectList(userExample).size()!=0)
			{
				User user = userService.getObjectList(userExample).get(0);
				reportCriteria.andUserIdEqualTo(user.getId());
			}else{
				reportCriteria.andUserIdIsNull();
			}
			
			mv.addObject("userName", userName);
			
		}
		reportCriteria.andStatusEqualTo(Integer.valueOf(0)).andStoreIdIsNull();
		Pagination pList = reportService.getObjectListWithPage(reportExample);
		
		CommUtil.addIPageList2ModelAndView(url + "/admin/report_list.htm", "",
				params, pList, mv);
		return mv;
	}

	@SecurityMapping(title = "已处理商品举报列表", value = "/admin/report_handle_list.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_handle_list.htm" })
	public ModelAndView report_handle_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goods_name, String userName) {
		ModelAndView mv = new JModelAndView(
				"admin/report_handle_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		String params = "";
		ReportExample reportExample = new ReportExample();
		reportExample.clear();
		reportExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		reportExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		ReportExample.Criteria reportCriteria = reportExample.createCriteria();
		
		
		//ReportQueryObject qo = new ReportQueryObject(currentPage, mv, orderBy,orderType);
		if (!CommUtil.null2String(goods_name).equals("")) {
			/*qo.addQuery("obj.goods.goods_name", new SysMap("goods_name", "%"
					+ goods_name + "%"), "like");*/
			GoodsExample goodsExample = new GoodsExample();
			goodsExample.clear();
			goodsExample.createCriteria().andGoodsNameLike("%"+goods_name+"%");
			List<GoodsWithBLOBs> goodsList = goodsService.getObjectList(goodsExample);
			List<Long> goodsIds = new ArrayList<Long>();
			for (Goods goods : goodsList) {
				goodsIds.add(goods.getId());
			}
			if(goodsIds.size()>0 && goodsIds != null){
				reportCriteria.andGoodsIdIn(goodsIds);
			}else{
				reportCriteria.andGoodsIdIsNull();
			}
			
			mv.addObject("goods_name", goods_name);
		}
		if (!CommUtil.null2String(userName).equals("")) {
			/*qo.addQuery("obj.user.userName", new SysMap("userName", userName),
					"=");*/
			UserExample userExample = new UserExample();
			userExample.clear();
			userExample.createCriteria().andUsernameEqualTo(userName);
			if(userService.getObjectList(userExample)!=null&&userService.getObjectList(userExample).size()!=0)
			{
				User user = userService.getObjectList(userExample).get(0);
				reportCriteria.andUserIdEqualTo(user.getId());
			}else{
				reportCriteria.andUserIdIsNull();
			}
			
			mv.addObject("userName", userName);
		}
		/*qo.addQuery("obj.status", new SysMap("status", Integer.valueOf(1)), "=");
		IPageList pList = this.reportService.list(qo);*/
		
		reportCriteria.andStatusEqualTo(Integer.valueOf(1)).andStoreIdIsNull();
		Pagination pList = reportService.getObjectListWithPage(reportExample);
		CommUtil.addIPageList2ModelAndView(url + "/admin/report_list.htm", "",
				params, pList, mv);
		return mv;
	}

	@SecurityMapping(title = "举报处理", value = "/admin/report_handle.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_handle.htm" })
	public ModelAndView report_handle(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,String type) {
		ModelAndView mv = null;
		Report obj =null;
			if(type!= null && !"".equals(type)){
				mv = new JModelAndView("admin/report_handle_store.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 0, request, response);
				obj = this.reportService.getByKey(CommUtil.null2Long(id));
			}else{
				mv = new JModelAndView("admin/report_handle.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 0, request, response);
				obj = this.reportService.getByKey(CommUtil.null2Long(id));
			}
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "举报处理", value = "/admin/report_handle_save.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_handle_save.htm" })
	public ModelAndView report_handle_save(HttpServletRequest request,
			HttpServletResponse response, String id, int result,
			String handle_info, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/success.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		ReportWithBLOBs obj = this.reportService.getByKey(CommUtil.null2Long(id));
		obj.setResult(result);
		obj.setStatus(1);
		obj.setHandleInfo(handle_info);
		obj.setHandleTime(new Date());
		this.reportService.updateByObject(obj);
		if (obj.getResult() == 1) {
			GoodsWithBLOBs goods = obj.getGoods();
			goods.setGoodsStatus(-3);
			this.goodsService.updateByObject(goods);

			String goods_lucene_path = System.getProperty("user.dir")
					+ File.separator + "luence" + File.separator + "goods";
			File file = new File(goods_lucene_path);
			if (!file.exists()) {
				CommUtil.createFolder(goods_lucene_path);
			}
			LuceneUtil lucene = LuceneUtil.instance();
			LuceneUtil.setIndex_path(goods_lucene_path);
			lucene.delete_index(CommUtil.null2String(goods.getId()));
		}
		if (obj.getResult() == -2) {
			User user = obj.getUser();
			user.setReport(-1);
			this.userService.updateByObject(user);
		}
		mv.addObject("op_title", "处理举报成功");
		mv.addObject("list_url", CommUtil.getURL(request)
				+ "/admin/report_list.htm?currentPage=" + currentPage);
		return mv;
	}
	
	@SecurityMapping(title = "未处理店铺举报列表", value = "/admin/report_store_list.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_store_list1.htm" })
	public ModelAndView reportStoreList1(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String storeName, String userName) {

		ModelAndView mv = new JModelAndView(
				"admin/report_list_store.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		String params = "";
		ReportExample reportExample = new ReportExample();
		reportExample.clear();
		reportExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		reportExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		
		ReportExample.Criteria reportCriteria = reportExample.createCriteria();
		
		if (!CommUtil.null2String(storeName).equals("")) {
			StoreExample storeExample = new StoreExample();
			storeExample.clear();
			storeExample.createCriteria().andStoreNameLike("%"+storeName+"%");
			List<StoreWithBLOBs> storeList = storeService.getObjectList(storeExample);
			List<Long> storeIds = new ArrayList<Long>();
			for (StoreWithBLOBs store : storeList) {
				storeIds.add(store.getId());
			}
			if(storeIds.size()!=0&& storeIds != null){
				reportCriteria.andStoreIdIn(storeIds);
			}else{
				reportCriteria.andStoreIdIsNull();
			}
			
			mv.addObject("storeName", storeName);
		}
		if (!CommUtil.null2String(userName).equals("")) {
			UserExample userExample = new UserExample();
			userExample.clear();
			userExample.createCriteria().andUsernameEqualTo(userName);
			if(userService.getObjectList(userExample)!=null&&userService.getObjectList(userExample).size()!=0)
			{
				User user = userService.getObjectList(userExample).get(0);
				reportCriteria.andUserIdEqualTo(user.getId());
			}else{
				reportCriteria.andUserIdIsNull();
			}
			
			mv.addObject("userName", userName);
		}
		
		reportCriteria.andStatusEqualTo(Integer.valueOf(0));	
		reportCriteria.andStoreIdIsNotNull();
		
		Pagination pList = reportService.getObjectListWithPage(reportExample);
		CommUtil.addIPageList2ModelAndView(url + "/admin/report_list_store.htm", "",
				params, pList, mv);
		return mv;
	}
	
	@SecurityMapping(title = "已经处理店铺举报列表", value = "/admin/report_store_list.htm*", rtype = "admin", rname = "举报管理", rcode = "report_manage", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/report_store_list2.htm" })
	public ModelAndView reportStoreList2(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String storeName, String userName) {
		ModelAndView mv = new JModelAndView(
					"admin/report_handle_list_store.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 0, request, response);
			
		String url = this.configService.getSysConfig().getAddress();
		String params = "";
		ReportExample reportExample = new ReportExample();
		reportExample.clear();
		reportExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		reportExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		/*reportExample.createCriteria().andStoreIdIsNotNull();*/
		ReportExample.Criteria reportCriteria = reportExample.createCriteria();
		
		if (!CommUtil.null2String(storeName).equals("")) {
			StoreExample storeExample = new StoreExample();
			storeExample.clear();
			storeExample.createCriteria().andStoreNameLike("%"+storeName+"%");
			List<StoreWithBLOBs> storeList = storeService.getObjectList(storeExample);
			List<Long> storeIds = new ArrayList<Long>();
			for (StoreWithBLOBs store : storeList) {
				storeIds.add(store.getId());
			}
			if(storeIds.size()!=0&& storeIds != null){
				reportCriteria.andStoreIdIn(storeIds);
			}else{
				reportCriteria.andStoreIdIsNull();
			}
			mv.addObject("storeName", storeName);
		}
		if (!CommUtil.null2String(userName).equals("")) {
			UserExample userExample = new UserExample();
			userExample.clear();
			userExample.createCriteria().andUsernameEqualTo(userName);
			if(userService.getObjectList(userExample)!=null&&userService.getObjectList(userExample).size()!=0)
			{
				User user = userService.getObjectList(userExample).get(0);
				reportCriteria.andUserIdEqualTo(user.getId());
			}else{
				reportCriteria.andUserIdIsNull();
			}
			
			mv.addObject("userName", userName);
		}
		
		reportCriteria.andStatusEqualTo(Integer.valueOf(1));	
		reportCriteria.andStoreIdIsNotNull();
		
		Pagination pList = reportService.getObjectListWithPage(reportExample);
		CommUtil.addIPageList2ModelAndView(url + "/admin/report_list_store.htm", "",
				params, pList, mv);
		return mv;
	}
	/**
	 * 处理举报店铺
	 * <p>Title: report_handle_store_save</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @param id
	 * @param result
	 * @param handle_info
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/admin/report_handle_store_save.htm" })
	public ModelAndView report_handle_store_save(HttpServletRequest request,
			HttpServletResponse response, String id, int result,
			String handle_info, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/success.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		ReportWithBLOBs obj = this.reportService.getByKey(CommUtil.null2Long(id));
		obj.setResult(result);
		obj.setStatus(1);
		obj.setHandleInfo(handle_info);
		obj.setHandleTime(new Date());
		this.reportService.updateByObject(obj);
		mv.addObject("op_title", "处理举报成功");
		mv.addObject("list_url", CommUtil.getURL(request)
				+ "/admin/report_store_list1.htm?currentPage=" + currentPage);
		return mv;
	}
}
