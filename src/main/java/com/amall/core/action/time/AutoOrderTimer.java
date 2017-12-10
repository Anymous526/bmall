package com.amall.core.action.time;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.common.tools.CNDateUtils;
import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.doulog;
import com.amall.core.bean.OrderFormExample.Criteria;
import com.amall.core.service.ICashDepositService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IRefundService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;

@Component("autoOrder_job")
public class AutoOrderTimer 
{

	Logger log = Logger.getLogger (AutoOrderTimer.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICashDepositService cashDepositService;

	@Autowired
	private IRefundService refundService;

	@Autowired
	private ISysConfigService sysConfigService;
	
	@Autowired
	private IDoulogService doulogService;
	
	public void execute ( ) throws ParseException
		{
			try
			{
				/* 处理老数据字段缺失数据问题 */
				processOldDate ();
				/* 检查未支付订单是否过期,过期的取消订单 */
				checkOrderExpired ();
				/* 检查未发货买家已经申请退款的订单，满足条件的自动退款 */
				checkRefundOrder ();
				/* 扫描满足自动收货订单 */
				scanAndUpdateAutoConfirm ();
				/* 扫描满足自动评价的订单 */
				scanAndAutoEvaluationOrder ();
			}
			catch (Exception e)
			{
				log.error (e.getMessage ());
				e.printStackTrace ();
			}
		}

	/**
	 * 扫描满足自动收货订单
	 */
	private void scanAndUpdateAutoConfirm ( )
		{
			/**
			 * 1.获取配置信息
			 * 2.从订单表获取满足条件的数据
			 * 3.更新订单状态
			 */
			/* 1 start */
			SysConfigWithBLOBs sysConfig = getSysConfig ();
			int autoConfirm = sysConfig.getAutoOrderConfirm ();
			/* 1 end */
			/* 2 start */
			Date date = CNDateUtils.subtractHour (new Date () , autoConfirm);
			OrderFormExample example = new OrderFormExample ();
			example.createCriteria ().andOrderStatusEqualTo (Globals.HAVE_SEND_OUT_GOOD).andShiptimeLessThanOrEqualTo (date);
			List <OrderFormWithBLOBs> list = orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return;
			}
			/* 2 end */
			/* 3 start */
			log.info ("需要自动收货订单数量 ： " + list.size ());
			for (OrderFormWithBLOBs bloBs : list)
			{
				log.info ("自动收货订单号 ： " + bloBs.getOrderId ());
				bloBs.setOrderStatus (Globals.HAVE_RECEIVED_GOOD);
				bloBs.setFinishtime (new Date ());
				orderFormService.updateByObject (bloBs);
				createOrderLog (bloBs.getUserId () , "系统自动收货" , Globals.HAVE_RECEIVED_GOOD , bloBs.getId ());
			}
			/* 3 end */
		}

	/* 检查未发货买家已经申请退款的订单，满足条件的自动退款 */
	private void checkRefundOrder ( )
		{
			SysConfigWithBLOBs sysConfig = getSysConfig ();
			int autoReturn = sysConfig.getAutoOrderReturn ();
			Date date = CNDateUtils.subtractHour (new Date () , autoReturn);
			OrderFormExample example = new OrderFormExample ();
			example.createCriteria ().andOrderStatusEqualTo (Globals.HAVE_PAYMENT).andShiptimeIsNull ().andPaytimeLessThanOrEqualTo (date);
			List <OrderFormWithBLOBs> list = orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return;
			}
			/* 获取退款信息 */
			for (OrderFormWithBLOBs bloBs : list)
			{
				Refund refund = getRefund (bloBs.getId () , date , bloBs.getGoodsAmount ());
				if (refund != null)
				{
					saveApplyCashDeposit (refund.getId () , storeService.getByKey (bloBs.getStoreId ()).getUserId () , bloBs.getAlipayorderId ());
				}
			}
		}

	private void saveApplyCashDeposit (Long refundId , Long userId , Long payId)
		{
			CashDepositExample example = new CashDepositExample ();
			example.createCriteria ().andCashStatusEqualTo (Globals.APPLY_REFUND_SELLER).andRefundIdEqualTo (refundId);
			List <CashDeposit> deposits = this.cashDepositService.getObjectList (example);
			CashDeposit cashDeposit = null;
			if (!deposits.isEmpty ())
			{
				cashDeposit = deposits.get (0);
				cashDeposit.setPayOrderId (payId);
				cashDeposit.setCreateTime (new Date ());
				cashDeposit.setRefundId (refundId);
				cashDeposit.setSellerUserId (userId);
				cashDeposit.setCashStatus (Globals.APPLY_REFUND_SELLER);
				this.cashDepositService.updateByObject (cashDeposit);
			}
			else
			{
				cashDeposit = new CashDeposit ();
				cashDeposit.setPayOrderId (payId);
				cashDeposit.setCashStatus (Globals.APPLY_REFUND_SELLER);
				cashDeposit.setCreateTime (new Date ());
				cashDeposit.setRefundId (refundId);
				cashDeposit.setSellerUserId (userId);
				this.cashDepositService.add (cashDeposit);
			}
		}

	private Refund getRefund (Long ofid , Date date , BigDecimal fee)
		{
			RefundExample refundExample = new RefundExample ();
			refundExample.createCriteria ().andOfIdEqualTo (ofid).andStatusEqualTo (Globals.HAVE_RECEIVED_MOENY).andAddtimeLessThanOrEqualTo (date);
			List <Refund> list = refundService.getObjectList (refundExample);
			if (list.isEmpty ())
			{
				return null;
			}
			Refund refund = list.get (0);
			refund.setStatus (Globals.WAIT_REFUND);  // 等待退款
			refund.setFactRefund (fee);
			this.refundService.updateByObject (refund);
			OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (ofid , refund.getGoodsId ());
			item.setRefund (Globals.WAIT_REFUND);
			this.orderFormItemService.updateByObject (item);
			return refund;
		}

	/**
	 * 扫描满足自动评价的订单
	 * 评价是针对具体商品的所以需要查找订单详情表
	 */
	private void scanAndAutoEvaluationOrder ( )
		{
			/**
			 * 1.获取自动评价配置信息
			 * 2.获取满足自动评价的订单
			 * 3.自动评价，并更新店铺评分
			 */
			/* 1 start */
			SysConfigWithBLOBs sysConfig = getSysConfig ();
			int autoEvaluate = sysConfig.getAutoOrderEvaluate ();
			/* 1 end */
			/* 2 start */
			Date date = CNDateUtils.subtractHour (new Date () , autoEvaluate);
			OrderFormExample example = new OrderFormExample ();
			example.createCriteria ().andOrderStatusEqualTo (Globals.HAVE_RECEIVED_GOOD).andOrderTypeIsNull().andFinishtimeLessThanOrEqualTo(CommUtil.getIntervalSecondDate (new Date() , Globals.EXCEED_NEWORDER));  //原来的andFinishtimeBetween (CNDateUtils.subtractDay (date , 60) ,date)
			List <OrderFormWithBLOBs> list = orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return;
			}
			/* 2 end */
			/* 3 start */
			log.info ("需要自动评价订单数量 ： " + list.size ());
			for (OrderFormWithBLOBs bloBs : list)
			{
				log.info ("自动评价订单号 ： " + bloBs.getOrderId ());
				List <OrderFormItem> temp = getOrderItems (bloBs.getId ());
				if (!temp.isEmpty ())
				{
					log.info ("自动评价订单的详情 ： " + bloBs.getOrderId ());
					for (OrderFormItem item : temp)
					{
						if (item.getItemStatus () == null || !item.getItemStatus ())
						{
							log.info ("自动评价商品名称 ： " + item.getGoodsName ());
							evaluationOrder (item , bloBs.getStoreId ());
						}
					}
					bloBs.setOrderStatus (Globals.COMPLETED_AND_EVALUATED);
					orderFormService.updateByObject (bloBs);
					createOrderLog (bloBs.getUserId () , "系统自动好评" , Globals.COMPLETED_AND_EVALUATED , bloBs.getId ());
				}
			}
			/* 3 end */
		}

	// 生成订单日志
	private void createOrderLog (Long userId , String info , Integer status , Long orderId)
		{
			OrderFormLog orderLog = new OrderFormLog ();
			orderLog.setAddtime (new Date ());
			orderLog.setLogInfo (info);
			orderLog.setLogUserId (userId);
			orderLog.setDeletestatus (false);
			orderLog.setStateInfo (status.toString ());
			orderLog.setOfId (orderId);
			this.orderFormLogService.add (orderLog);
		}

	private SysConfigWithBLOBs getSysConfig ( )
		{
			return configService.getSysConfig ();
		}

	private List <OrderFormItem> getOrderItems (Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.createCriteria ().andOrderIdEqualTo (orderId).andItemStatusIsNull ();
			return orderFormItemService.getObjectList (example);
		}

	/**
	 * 评价订单并更新店铺积分
	 * 
	 * @param item
	 */
	private void evaluationOrder (OrderFormItem item , Long storeId)
		{
			/**
			 * 1.刷新店铺评价
			 * 2.更新订单详情评价状态
			 */
			/* 1 start */
			List <EvaluateWithBLOBs> evas = this.evaluateService.selectByOfLeftJoinStoreId (storeId);
			double store_evaluate1 = 0.0D;
			double store_evaluate1_total = 0.0D;
			double description_evaluate = 0.0D;
			double description_evaluate_total = 0.0D;
			double service_evaluate = 0.0D;
			double service_evaluate_total = 0.0D;
			double ship_evaluate = 0.0D;
			double ship_evaluate_total = 0.0D;
			DecimalFormat df = new DecimalFormat ("0.0");
			for (Evaluate eva1 : evas)
			{
				// 店铺总评论分
				store_evaluate1_total = store_evaluate1_total + eva1.getEvaluateBuyerVal ();
				// 商品描述总评论分
				description_evaluate_total = description_evaluate_total + CommUtil.null2Double (eva1.getDescriptionEvaluate ());
				// 服务总评论分
				service_evaluate_total = service_evaluate_total + CommUtil.null2Double (eva1.getServiceEvaluate ());
				// 物流总评论分
				ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double (eva1.getShipEvaluate ());
			}
			int size = 0;
			if (!evas.isEmpty ())
			{
				size = evas.size ();
			}
			// 店铺评分 : 店铺总评论分 / 评论条数
			store_evaluate1 = CommUtil.null2Double (df.format (store_evaluate1_total + 1));
			// 商品评分: 总评论分 / 评论条数
			description_evaluate = CommUtil.null2Double (df.format ((description_evaluate_total + 5) / (size + 1)));
			// 服务评分 : 服务总评论分 / 总评论数
			service_evaluate = CommUtil.null2Double (df.format ((service_evaluate_total + 5) / (size + 1)));
			ship_evaluate = CommUtil.null2Double (df.format ((ship_evaluate_total + 5) / (size + 1)));
			StoreWithBLOBs store = this.storeService.getByKey (storeId);
			// 将用户评价的得分记入店铺总信用度
			if (store.getStoreCredit () == null)
			{
				store.setStoreCredit (0);
			}
			store.setStoreCredit (store.getStoreCredit () + 1);
			StorePointExample storePointExample = new StorePointExample ();
			storePointExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			List <StorePoint> sps = this.storePointService.getObjectList (storePointExample);
			StorePoint point = null;
			if (!sps.isEmpty ())
			{
				point = sps.get (0);
			}
			else
			{
				point = new StorePoint ();
			}
			point.setAddtime (new Date ());
			point.setStoreId (store.getId ());
			point.setDescriptionEvaluate (BigDecimal.valueOf (description_evaluate));
			point.setServiceEvaluate (BigDecimal.valueOf (service_evaluate));
			point.setShipEvaluate (BigDecimal.valueOf (ship_evaluate));
			point.setStoreEvaluate1 (BigDecimal.valueOf (store_evaluate1));
			if (!sps.isEmpty ())
				this.storePointService.updateByObject (point);
			else
			{
				this.storePointService.add (point);
			}
			store.setPointId (point.getId ());
			store.setPoint (point);
			this.storeService.updateByObject (store);
			EvaluateWithBLOBs eva = new EvaluateWithBLOBs (); // 评论
			eva.setAddtime (new Date ());
			eva.setEvaluateGoodsId (item.getGoodsId ());
			eva.setEvaluateBuyerVal (1);
			eva.setDescriptionEvaluate (BigDecimal.valueOf (5));
			eva.setServiceEvaluate (BigDecimal.valueOf (5));
			eva.setShipEvaluate (BigDecimal.valueOf (5));
			eva.setEvaluateType ("goods");
			eva.setEvaluateSellerUserId (store.getUserId ());
			eva.setEvaluateUserId (item.getOrderForm ().getUserId ());
			eva.setOfId (item.getOrderId ());
			eva.setGoodsSpec (item.getSpecInfo ());
			this.evaluateService.add (eva);
			/* 1 end */
			/* 2 start */
			item.setItemStatus (true);
			this.orderFormItemService.updateByObject (item);
			/* 2 end */
		}

	/**
	 * @Title: checkOrderExpired
	 * @Description: 检查未支付订单是否过期,过期的取消订单
	 * @return void
	 * @author tangxiang
	 * @date 2015年9月6日 上午11:41:31
	 */
	private void checkOrderExpired ( )
		{
			Date beginDate = new Date ();
			OrderFormExample example = new OrderFormExample ();
			Criteria criteria = example.createCriteria ();
			criteria.andAddtimeLessThanOrEqualTo (CommUtil.getIntervalSecondDate (beginDate , Globals.EXCEED_ORDER));
			criteria.andOrderStatusEqualTo (Globals.WAIT_PAYMENT_ORDER);
			List <OrderFormWithBLOBs> orderForms = this.orderFormService.getObjectList (example);
			if (orderForms == null || orderForms.isEmpty ())
			{
				/* 结束同步 */
				return;
			}
			/* 取消订单 */
			for (OrderFormWithBLOBs form : orderForms)
			{
				/* 返还商品 */
				List <OrderFormItem> formItems = getOrderItems (form.getId ());
				if (formItems != null)
				{
					for (OrderFormItem formItem : formItems)
					{
						addRepository (formItem.getGoodsId () , formItem.getGoodsCount ());
						User user = new User();
						if (null != form.getAutoConfirmSms()
								&& form.getAutoConfirmSms() == true) {
							System.out.println("进来返还");

							if (null != form.getBeanNum()) {

								user = userService.getByKey(form.getUserId());
								if (null != user.getId()) {
									
									if (null != user) {
										if (null == user.getDou()) {
											user.setDou(0);
										}
										user.setDou(user.getDou()
												+ form.getBeanNum().intValue());
										userService.updateUsers(user);
									}
								}
							}
							SysConfigWithBLOBs config = sysConfigService.getSysConfig();
							doulog log = new doulog();
							log.setId((long) Integer.parseInt(form.getOutOrderId()));
							// log.setAddtime (new Date ());
							log.setDealtime(new Date());
							// log.setDealUserId (Integer.valueOf (userId
							// + ""));
							// log.setUserId (Long.valueOf (1));
							log.setType((short)0);
							log.setTotalDouNum(0);
							log.setDealDouNum(0);
							// log.setPrice (config.getMinPricce ());
							doulogService.updateByObject(log);
						}
						// 订单发生改动，将日志记入到订单日志内
						OrderFormLog ofl = new OrderFormLog();
						ofl.setAddtime(new Date());
						ofl.setLogInfo("超时系统自动取消！");
						ofl.setLogUserId(Long.valueOf(form.getUserId()));
						ofl.setOfId(form.getId());
						orderFormLogService.add(ofl);
					}
				}
				form.setOrderStatus (Globals.CANCELLED_ORDER);
				this.orderFormService.updateByObject (form);
				// 订单发生改动，将日志记入到订单日志内
			/*	createOrderLog (form.getUserId () , "取消订单" , Globals.CANCELLED_ORDER , form.getId ());*/
			
			}
		}

	/**
	 * @Title: addRepository
	 * @Description: 增加库存
	 * @param goodsId
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月12日 下午8:27:28
	 */
	private void addRepository (Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			if (goods != null)
			{
				addGoodsRepository (goods , count);
			}
		}

	/**
	 * @Title: addGoodsRepository
	 * @Description: 增加商品表库存
	 * @param goodsId
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月12日 下午8:17:35
	 */
	private void addGoodsRepository (GoodsWithBLOBs goods , Integer count)
		{
			/* 修改DBA数量 */
			count = count == null ? 0 : count;
			if (goods.getGoodsInventory () == null)
			{
				goods.setGoodsInventory (0);
			}
			goods.setGoodsInventory (goods.getGoodsInventory () + count);
			this.goodsService.updateByObject (goods);
		}

	private void processOldDate ( )
		{
			/* 已收货，已评价，结束， */
			List <Integer> inStatus = new ArrayList <Integer> ();
			inStatus.add (Globals.COMPLETED_AND_EVALUATED);
			inStatus.add (Globals.FINISH);
			inStatus.add (Globals.FINISH_AND_NOT_EVALUATED);
			inStatus.add (Globals.HAVE_RECEIVED_GOOD);
			OrderFormExample example = new OrderFormExample ();
			Criteria criteria = example.createCriteria ();
			criteria.andOrderStatusIn (inStatus);
			criteria.andFinishtimeIsNull ();
			List <OrderFormWithBLOBs> list = orderFormService.getObjectList (example);
			for (OrderFormWithBLOBs bloBs : list)
			{//此处有点乱，统统改为收货后0天，注：结束时间不是分红时间，分红为结束后再过可退货期限后。见 synchronizationSet
				if (bloBs.getShiptime () == null)
				{
					//bloBs.setFinishtime (CNDateUtils.addDays (bloBs.getAddtime () , 3));
					bloBs.setFinishtime (CNDateUtils.addDays (new Date() , 0));
					
				}
				else
				{
					//bloBs.setFinishtime (CNDateUtils.addDays (bloBs.getShiptime () , 2));
					bloBs.setFinishtime (CNDateUtils.addDays (new Date() , 0));
				}
				orderFormService.updateByObject (bloBs);
			}
			/* 处理老用户存在3级的情况 */
			/*
			 * UserExample userExample = new UserExample();
			 * userExample.createCriteria().andLevelAngelEqualTo(3);
			 * List<User> users = userService.getObjectList(userExample);
			 * for(User user:users)
			 * {
			 * user.setLevelAngel(2);
			 * userService.updateByObject(user);
			 * }
			 */
		}
}
