package com.amall.core.action.time;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.common.tools.CNDateUtils;
import com.amall.common.tools.DateUtils;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormExample.Criteria;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.StoreCount;
import com.amall.core.bean.StoreCountExample;
import com.amall.core.bean.StoreEarningDetail;
import com.amall.core.bean.StoreVisitExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.lee.LeeService;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreCountService;
import com.amall.core.service.store.IStoreEarningDetailService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.storevisit.IStoreVisitService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.PromoteTools;

@Component("shop_job")
public class JobManageAction 
{

	Logger log = Logger.getLogger (JobManageAction.class);

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeServeice;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private LeeService leeService;

	@Autowired
	private IStoreEarningDetailService earningDetailService;

	@Autowired
	private IStoreVisitService storeVisitService;

	@Autowired
	private IStoreCountService storeCountService;

	@Autowired
	private PromoteTools promoteTools;

	@Autowired
	private IUserService userService;


	public void execute ( )	
		{
			try
			{
				/* 每月一号检查是否有推广分利 */
				// 取消
				// checkPromoteBenefit ();
				/* 检查退货退款超期的订单，满足条件的同步到分利系统 */
				checkOrderRefundExpired ();
			}
			catch (Exception e)
			{
				log.error (e.getMessage ());
				e.printStackTrace ();
			}
		}


	/**
	 * 推广分利
	 */
	private void checkPromoteBenefit ( )
		{
			Calendar calendar = Calendar.getInstance ();
			calendar.setTime (new Date ());
			if (calendar.get (Calendar.DAY_OF_MONTH) == 4)
			{
				promoteTools.processPromoteBenefit ();
			}
		}


	/**
	 * @Title: checkOrderRefundExpired
	 * @Description: 检查退货退款过期的订单，满足条件的同步到分利系统
	 *               1.按时间点获取完成订单
	 *               2.找到订单对应所有商品
	 *               3.查找对应的过期时间
	 *               4.满足条件的就调用分利同步接口
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月28日 上午9:29:05
	 */
	private void checkOrderRefundExpired ( )
		{
			/* 当前时间点 */
			Date nowDate = new Date ();
			OrderFormExample example = new OrderFormExample ();
			Criteria criteria = example.createCriteria ();
			/* 为了拿到老数据，后面取消 * 3 */
			// 改为 2周，
			criteria.andFinishtimeBetween (CNDateUtils.subtractDay (nowDate , Globals.HALF_MONTH) , nowDate);
			criteria.andOrderTypeIsNull ();
			/* 已收货，已评价，结束， */
			List <Integer> inStatus = new ArrayList <Integer> ();
			inStatus.add (Globals.COMPLETED_AND_EVALUATED);
			inStatus.add (Globals.FINISH);
			inStatus.add (Globals.FINISH_AND_NOT_EVALUATED);
			inStatus.add (Globals.HAVE_RECEIVED_GOOD);
			criteria.andOrderStatusIn (inStatus);
			List <OrderFormWithBLOBs> orderForms = this.orderFormService.getObjectList (example);
			// System.out.println("普通商品分利及店铺销售额增加循环："+new
			// Date()+","+(orderForms==null?"null":orderForms.size()));
			/* 升级消费商，已停止 */
			//upgradeConsumerBusiness ();
			if (orderForms == null || orderForms.isEmpty ())
			{
				/* 结束同步 */
				return;
			}
			/* 同步交易到分利系统 */
			synchronizationLee (orderForms , nowDate);
		}


	/**
	 * @Title: synchronizationLee
	 * @Description: 同步到分利系统
	 * @param orderForms
	 * @param nowDate
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月28日 上午11:39:29
	 */
	private void synchronizationLee (	List <OrderFormWithBLOBs> orderForms , Date nowDate)
		{
			/* 获取订单商品列表信息 */
			List <OrderFormItem> formItems = new ArrayList <OrderFormItem> ();
			for (OrderFormWithBLOBs bloBs : orderForms)
			{
				if (bloBs.getId () == 1404 || bloBs.getId ().equals (1404))
				{
					System.out.println (11);
				}
				OrderFormItemExample example = new OrderFormItemExample ();
				example.createCriteria ().andOrderIdEqualTo (bloBs.getId ()).andLeeStatusEqualTo (false);
				formItems.addAll (this.orderFormItemService.getObjectList (example));
			}
			/* 填充同步信息 */
			List <List <OrderFormItem>> list = synchronizationSet (formItems , nowDate);
			/* 同步结束 */
			if (list.isEmpty ())
			{
				System.out.println ("OrderFormItemisEmpty");
				return;
			}
			/* 开始同步 */
			// System.out.println("开始同步商品分利");
			for (List <OrderFormItem> l : list)
			{
				/* 增加商品销量 */
				// 订单支付完毕，订单中商品的销量相应的增加
				addGoodsSalenum (l);
				/* 同步到分利系统 */
				System.out.println ("开始循环每个商品分利");
				
				startSynchronizationData (l);
			}
		}


	/**
	 * @Title: synchronizationSet
	 * @Description: 填充同步信息
	 * @param formItems
	 * @param nowDate
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月28日 上午11:40:02
	 */
	private List <List <OrderFormItem>> synchronizationSet (List <OrderFormItem> formItems , Date nowDate)
		{
			// System.out.println("进来了synchronizationSet");
			/* 及时交易 */
			List <OrderFormItem> timelyGoods = new ArrayList <OrderFormItem> ();
			/* 7天交易 */
			List <OrderFormItem> weekGoods = new ArrayList <OrderFormItem> ();
			/* 15天交易 */
			List <OrderFormItem> halfMonthGoods = new ArrayList <OrderFormItem> ();
			/* 30天交易 */
			List <OrderFormItem> monthGoods = new ArrayList <OrderFormItem> ();
			for (OrderFormItem item : formItems)
			{
				// System.out.println("进来了synchronizationSet1");
				if (item.getRefundServer () != null)
				{// System.out.println("进来了synchronizationSet2");
					switch (item.getRefundServer ())
					{
						case Globals.REFUND_SERVER_TIME_0 :
							// System.out.println("进来了synchronizationSet3");
							if (!item.getLeeStatus ())
								timelyGoods.add (item);
							break;
						case Globals.REFUND_SERVER_TIME_7 :
							if (CommUtil.isContainTime (nowDate , item.getOrderForm ().getFinishtime ()) >= Globals.WEEK)
							{
								if (!item.getLeeStatus ())
									weekGoods.add (item);
							}
							break;
						case Globals.REFUND_SERVER_TIME_15 :
							if (CommUtil.isContainTime (nowDate , item.getOrderForm ().getFinishtime ()) >= Globals.HALF_MONTH)
							{
								if (!item.getLeeStatus ())
									halfMonthGoods.add (item);
							}
							break;
						case Globals.REFUND_SERVER_TIME_30 :
							if (CommUtil.isContainTime (nowDate , item.getOrderForm ().getFinishtime ()) >= Globals.MONTH)
							{
								if (!item.getLeeStatus ())
									monthGoods.add (item);
							}
							break;
						default :
							break;
					}
				}
			}
			List <List <OrderFormItem>> list = new ArrayList <> ();
			if (!timelyGoods.isEmpty ())
			{
				list.add (timelyGoods);
			}
			if (!weekGoods.isEmpty ())
			{
				list.add (weekGoods);
			}
			if (!halfMonthGoods.isEmpty ())
			{
				list.add (halfMonthGoods);
			}
			if (!monthGoods.isEmpty ())
			{
				list.add (monthGoods);
			}
			return list;
		}


	/**
	 * @Title: startSynchronizationData
	 * @Description: 同步数据
	 * @param formItems
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月28日 下午4:19:13
	 */
	private void startSynchronizationData (	final List <OrderFormItem> formItems)
		{
			for (OrderFormItem formItem : formItems)
			{
				/* 分利 */
				synchronized (this) {
					try {
						Thread.sleep((long)2000);
						leeService.fhLee (formItem);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println ("formItem === " + formItem.getId ());
				formItem.setLeeStatus (true);
				orderFormItemService.updateByObject (formItem);
				/* 增加收入记录 */
				setNewStoreEarning (formItem);
			}
			/* 统计访问量和销售量 */
			StoreCount (formItems);
		}


	/* 统计访问量和销售量 */
	private void StoreCount (	final List <OrderFormItem> formItems)
		{
			Long storeId = formItems.get (0).getOrderForm ().getStoreId ();
			StoreCountExample sce = new StoreCountExample ();
			sce.createCriteria ().andStoreIdEqualTo (storeId);
			List <StoreCount> scs = storeCountService.getObjectList (sce);
			StoreCount storeCount;
			if (scs.isEmpty ())
			{
				storeCount = new StoreCount ();
				storeCount.setAddtime (new Date ());
				storeCount.setStoreId (storeId);
				storeCountService.add (storeCount);
				sce.clear ();
				sce.createCriteria ().andStoreIdEqualTo (storeId);
				scs = storeCountService.getObjectList (sce);
			}
			storeCount = scs.get (0);
			if (storeCount.getStoreTime () == null || !checkStoreStaticsDateIsLastWeek (storeCount.getStoreTime ()))
			{
				lastWeekSaleAndVisit (storeId , storeCount);
			}
			int saleCount = 0;
			for (OrderFormItem formItem : formItems)
			{
				saleCount += formItem.getGoodsCount ();
			}
			storeCount.setThisWeekSale (storeCount.getThisWeekSale () + saleCount);
			storeCount.setThisWeekVisit (thisWeekVisit (storeId));
			storeCount.setStoreTime (new Date ());
			storeCountService.updateByObject (storeCount);
		}


	/**
	 * 统计上周的店铺销量和店铺访问量
	 * 
	 * @param user
	 * @return int[]
	 *         xpy
	 */
	private void lastWeekSaleAndVisit (	Long storeId , StoreCount storeCount)
		{
			int lastWeekSale = 0;	// 上周销量统计
			int lastWeekVisit = 0;  // 上周访问量
			OrderFormExample orderFormExample = new OrderFormExample ();
			OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria ();
			orderFormCriteria = orderFormExample.createCriteria ();
			orderFormCriteria.andStoreIdEqualTo (storeId);
			orderFormCriteria.andOrderStatusGreaterThanOrEqualTo (Integer.valueOf (20)).andOrderStatusLessThanOrEqualTo (50);
			StoreVisitExample storeVisitExample = new StoreVisitExample ();
			StoreVisitExample.Criteria storeVisitCriteria = storeVisitExample.createCriteria ();
			storeVisitCriteria.andStoreIdEqualTo (storeId);
			Calendar calendar = Calendar.getInstance ();
			calendar.set (Calendar.DAY_OF_WEEK , 1); // 上周日
			int year = calendar.get (Calendar.YEAR);
			int month = calendar.get (Calendar.MONTH) + 1;
			int day = calendar.get (Calendar.DATE);
			String date2 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 23:59:59";
			SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			try
			{
				Date lastSunday = sf.parse (date2);
				orderFormCriteria.andAddtimeLessThanOrEqualTo (lastSunday);
				storeVisitCriteria.andVisitTimeLessThanOrEqualTo (lastSunday);
			}
			catch (ParseException e)
			{
				e.printStackTrace ();
			}
			calendar.add (Calendar.WEEK_OF_MONTH , -1);
			calendar.set (Calendar.DAY_OF_WEEK , 2); // 上周一
			year = calendar.get (Calendar.YEAR);
			month = calendar.get (Calendar.MONTH) + 1;
			day = calendar.get (Calendar.DATE);
			String date1 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 00:00:00";
			try
			{
				Date lastMonday = sf.parse (date1);
				orderFormCriteria.andAddtimeGreaterThanOrEqualTo (lastMonday);
				storeVisitCriteria.andVisitTimeGreaterThanOrEqualTo (lastMonday);
			}
			catch (ParseException e)
			{
				e.printStackTrace ();
			}
			lastWeekVisit = this.storeVisitService.getObjectListCount (storeVisitExample);
			storeCount.setLastWeekVisit (lastWeekVisit);
			List <OrderFormWithBLOBs> lastWeekOrderForm = this.orderFormService.getObjectList (orderFormExample);
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
			List <Long> ids = new ArrayList <> ();
			for (OrderFormWithBLOBs of : lastWeekOrderForm)
			{
				ids.add (of.getId ());
			}
			orderFormItemExample.createCriteria ().andOrderIdIn (ids);
			List <OrderFormItem> orderFormItemList = this.orderFormItemService.getObjectList (orderFormItemExample);
			for (OrderFormItem ofi : orderFormItemList)
			{
				Integer ofiGoodsCount = ofi.getGoodsCount () == null ? 0 : ofi.getGoodsCount ();
				lastWeekSale += ofiGoodsCount;
			}
			storeCount.setLastWeekSale (lastWeekSale);
		}


	private int thisWeekVisit (	Long storeId)
		{
			int thisWeekVisit = 0; // 本周访问量
			StoreVisitExample storeVisitExample = new StoreVisitExample ();
			StoreVisitExample.Criteria storeVisitCriteria = storeVisitExample.createCriteria ();
			storeVisitCriteria.andStoreIdEqualTo (storeId);
			Calendar calendar = Calendar.getInstance ();
			calendar.set (Calendar.DAY_OF_WEEK , Calendar.MONDAY); // 本周一
			int year = calendar.get (Calendar.YEAR);
			int month = calendar.get (Calendar.MONTH) + 1;
			int day = calendar.get (Calendar.DATE);
			String date1 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 00:00:00";
			SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			try
			{
				Date thisMonday = sf.parse (date1);
				storeVisitCriteria.andVisitTimeGreaterThanOrEqualTo (thisMonday);
			}
			catch (ParseException e)
			{
				e.printStackTrace ();
			}
			calendar.add (Calendar.DATE , 6); // 本周日
			year = calendar.get (Calendar.YEAR);
			month = calendar.get (Calendar.MONTH) + 1;
			day = calendar.get (Calendar.DATE);
			String date2 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " 23:59:59";
			try
			{
				Date thisSunday = sf.parse (date2);
				storeVisitCriteria.andVisitTimeLessThanOrEqualTo (thisSunday);
			}
			catch (ParseException e)
			{
				e.printStackTrace ();
			}
			thisWeekVisit = this.storeVisitService.getObjectListCount (storeVisitExample);
			return thisWeekVisit;
		}


	public boolean checkStoreStaticsDateIsLastWeek (Date d1)
		{
			Calendar cal1 = Calendar.getInstance ();
			Calendar cal2 = Calendar.getInstance ();
			cal1.setTime (d1);
			cal2.setTime (new Date ());
			int subYear = cal1.get (Calendar.YEAR) - cal2.get (Calendar.YEAR);
			int calwoy1 = cal1.get (Calendar.WEEK_OF_YEAR);
			int calwoy2 = cal2.get (Calendar.WEEK_OF_YEAR);
			int caldow1 = cal1.get (Calendar.DAY_OF_WEEK);
			int caldow2 = cal2.get (Calendar.DAY_OF_WEEK);
			// subYear==0,说明是同一年
			if (subYear == 0)
			{
				if (calwoy1 == calwoy2)
				{
					if (caldow1 != 1 && caldow2 != 1)
					{
						return true;
					}
					else if (caldow1 == caldow2)
					{
						return true;
					}
				}
				else if (calwoy1 - calwoy2 == 1)
				{
					if (caldow1 == 1)
					{
						return true;
					}
				}
				else if (calwoy1 - calwoy2 == -1)
				{
					if (caldow2 == 1)
					{
						return true;
					}
				}
			}
			// 例子:cal1是"2005-1-1"，cal2是"2004-12-25"
			else if (subYear == 1 && cal2.get (Calendar.MONTH) == 11)
			{
				if (calwoy1 == calwoy2)
					return true;
			}
			// 例子:cal1是"2004-12-31"，cal2是"2005-1-1"
			else if (subYear == -1 && cal1.get (Calendar.MONTH) == 11)
			{
				if (calwoy1 == calwoy2)
					return true;
			}
			return false;
		}


	/**
	 * @Title: getOrderFormItemList
	 * @Description: 获取订单详情表
	 * @param orderId
	 * @return
	 * @return List<OrderFormItem>
	 * @author tangxiang
	 * @date 2015年8月27日 下午5:23:26
	 */
	public List <OrderFormItem> getOrderFormItemList (	Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			List <OrderFormItem> list = this.orderFormItemService.getObjectList (example);
			if (list == null || list.isEmpty ())
			{
				return null;
			}
			return list;
		}


	/**
	 * @Title: addGoodsSalenum
	 * @Description: 增加商品销量
	 * @param l
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月15日
	 */
	private void addGoodsSalenum (	List <OrderFormItem> l)
		{
			// 订单支付完毕，订单中商品的销量相应的增加
			if (l != null)
			{
				for (OrderFormItem orderFormItem : l)
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (orderFormItem.getGoodsId ());
					if (goods != null)
					{
						if (goods.getGoodsSalenum () == null)
						{
							goods.setGoodsSalenum (0);
						}
						if (orderFormItem.getGoodsCount () == null)
						{
							orderFormItem.setGoodsCount (0);
						}
						int saleSum = goods.getGoodsSalenum () + orderFormItem.getGoodsCount ();
						goods.setGoodsSalenum (saleSum);
						this.goodsService.updateByObject (goods);
					}
					else
					{
						log.info ("goods not exit! id : " + orderFormItem.getGoodsId ());
					}
				}
			}
			else
			{
				System.out.println ("增加销量为空！");
			}
		}


	/**
	 * @Title: setNewStoreEarning
	 * @Description: 增加店铺收入记录
	 * @param formItem
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月3日
	 */
	private void setNewStoreEarning (	OrderFormItem formItem)
		{
			StoreEarningDetail detail = new StoreEarningDetail ();
			StoreWithBLOBs store = new StoreWithBLOBs ();
			BigDecimal totalFee = formItem.getGoodsPrice ().multiply (new BigDecimal (formItem.getGoodsCount ()));
			BigDecimal rate = formItem.getGoodsRate ();
			BigDecimal benefitFee = BigDecimal.ZERO;
			if (rate != null)
			{
				benefitFee = totalFee.multiply (rate).setScale (2 , BigDecimal.ROUND_UP);
				/* 小于1角不分利 */
				if (benefitFee.compareTo (new BigDecimal ("0.1")) < 0)
				{
					benefitFee = BigDecimal.ZERO;
				}
			}
			detail.setAddTime (new Date ());
			detail.setFee (totalFee);
			detail.setBenefitFee (benefitFee);
			detail.setRate (rate);
			detail.setOrderId (formItem.getOrderId ());
			detail.setOrderItemId (formItem.getId ());
			detail.setStoreId (formItem.getOrderForm ().getStoreId ());
			this.earningDetailService.add (detail);
			// 取消跟后面重复。并且此处逻辑不对，不应用明细表金额，有可能修改订单金额
			// store.setCashAmount (totalFee.subtract (benefitFee));
			// this.storeServeice.add (store);
		}


	/**
	 * @Title : upgradeConsumerBusiness
	 * @Deprecated : 升级消费商
	 * @author ： liuguo
	 * @Date : 2017/05/25 12:13
	 */
	private void upgradeConsumerBusiness ( )
		{
			Date nowDate = new Date ();
			
			User currentUser = SecurityUserHolder.getCurrentUser ();
			OrderFormExample example = new OrderFormExample ();
			example.clear ();
			List <Integer> inStatus = new ArrayList <Integer> ();
			inStatus.add (Globals.COMPLETED_AND_EVALUATED);
			inStatus.add (Globals.FINISH);
			inStatus.add (Globals.FINISH_AND_NOT_EVALUATED);
			inStatus.add (Globals.HAVE_RECEIVED_GOOD);
			
			
			Criteria criteria = example.createCriteria ();
			example.createCriteria ().andOrderStatusIn (inStatus);
			criteria.andFinishtimeBetween (CNDateUtils.subtractDay (nowDate , Globals.WEEK) , nowDate);
			
			List <OrderFormWithBLOBs> orderForms = this.orderFormService.getObjectList (example);
			// 年度消费总金额
			BigDecimal consumefee = new BigDecimal (0.00);
			if (!orderForms.isEmpty ())
			{
				for (OrderFormWithBLOBs order : orderForms)
				{
					if (DateUtils.getCurrentFirstDay ().getTime () >= order.getAddtime ().getTime () && order.getAddtime ().getTime () <= DateUtils.getCurrentLastDay ().getTime ())
					{
						if (order.getOrderType () != null && order.getOrderType ().equals (Globals.ORDER_TYPE_O2O))
						{
							consumefee = consumefee.add (order.getGoodsAmount ());
						}
						else
						{
							consumefee = consumefee.add (order.getTotalprice ());
						}
					}
				}
			}
			if (currentUser != null && currentUser.getLevelAngel () == Globals.NUBER_ZERO)
			{
				if (consumefee.compareTo (new BigDecimal (100)) == Globals.NUBER_ZERO || consumefee.compareTo (new BigDecimal (100)) == Globals.NUBER_ONE)
				{
					System.out.println ("开始升级消费商");
					User user = new User ();
					user.setId (currentUser.getId ());
					user.setLevelAngel (Globals.NUBER_TWO); // 更新为消费商 levelAngel 原会员级别 改为0,3,5,7 ，2为消费商
					this.userService.updateByObject (user);
				}
			}
		}
}
