package com.amall.core.web.tools;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.complaint.IComplaintService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.report.IReportService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.user.IUserService;


/**
 * 
 * <p>Title: StatTools</p>
 * <p>Description: 店铺相关工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月3日下午12:04:06
 * @version 1.0
 */
@Component
public class StatTools {

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IReportService reportService;

	@Autowired
	private IComplaintService complaintService;
	/**
	 * 
	 * <p>Title: query_store</p>
	 * <p>Description: 查询店铺数量</p>
	 * @param count
	 * @return int
	 */
	public int query_store(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		StoreExample example = new StoreExample();
		example.clear();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime());
		List<StoreWithBLOBs> stores = storeService.getObjectList(example);
		
		return stores.size();
	}
	/**
	 * 
	 * <p>Title: query_user</p>
	 * <p>Description: 查询用户数量</p>
	 * @param count
	 * @return
	 */
	public int query_user(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		
		UserExample example = new UserExample();
		example.clear();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime());
		List<User> users = userService.getObjectList(example);
		
		return users.size();
	}

	public int query_goods(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		GoodsExample example = new GoodsExample();
		example.clear();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime());
		List<GoodsWithBLOBs> goods = goodsService.getObjectList(example);
		
		return goods.size();
	}

	public int query_order(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		OrderFormExample example = new OrderFormExample();
		example.clear();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime());
		List<OrderFormWithBLOBs> orders = orderFormService.getObjectList(example);
		
		
		return orders.size();
	}

	public int query_all_user() {
		UserExample example = new UserExample();
		example.clear();
		example.createCriteria().andUserroleEqualTo("ADMIN");
		List<User> users = userService.getObjectList(example);
		
		return users.size();
	}
	
	/**
	 * 
	 * <p>Title: query_all_goods</p>
	 * <p>Description: 查询所有商品的数量</p>
	 * @return
	 */
	public int query_all_goods() {
		List<GoodsWithBLOBs> goods = goodsService.getObjectList(new GoodsExample());
		
		return goods.size();
	}
	
	/**
	 * 
	 * <p>Title: query_all_store</p>
	 * <p>Description: 查询所有商铺的数量</p>
	 * @return
	 */
	public int query_all_store() {
		List<StoreWithBLOBs> stores = storeService.getObjectList(new StoreExample());
		return stores.size();
	}
	/**
	 * 
	 * <p>Title: query_update_store</p>
	 * <p>Description: 查询所有有等级的商铺数量</p>
	 * @return
	 */
	public int query_update_store() {
		StoreExample example = new StoreExample();
		example.createCriteria().andUpdateGradeIdIsNotNull();
		List<StoreWithBLOBs> stores = storeService.getObjectList(example);
		return stores.size();
	}
	
	/**
	 * 
	 * <p>Title: query_all_amount</p>
	 * <p>Description: 查询总价</p>
	 * @return
	 */
	public double query_all_amount() {
		double price = 0.0D;
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andOrderStatusEqualTo(Integer.valueOf(60));
		List<OrderFormWithBLOBs> ofs = orderFormService.getObjectList(example);
		
		for (OrderFormWithBLOBs of : ofs) {
			price = CommUtil.null2Double(of.getTotalprice()) + price;
		}
		return price;
	}
	/**
	 * 
	 * <p>Title: query_complaint</p>
	 * <p>Description: 查询申诉数量</p>
	 * @param count
	 * @return
	 */
	public int query_complaint(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime()).andStatusEqualTo(Integer.valueOf(0));
		List<ComplaintWithBLOBs> objs = complaintService.getObjectList(example);
		
		return objs.size();
	}

	public int query_report(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(6, count);
		ReportExample example = new ReportExample();
		example.clear();
		example.createCriteria().andAddtimeGreaterThanOrEqualTo(cal.getTime())
					.andStatusEqualTo(Integer.valueOf(0));
		List<ReportWithBLOBs> objs = reportService.getObjectList(example);
		
		return objs.size();
	}
}
