package com.amall.core.action.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.constant.CommonValues;
import com.amall.common.constant.Globals;
import com.amall.common.tools.Json;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.PlatformBenefitDetail;
import com.amall.core.bean.RechargeLog;
import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPaper;
import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.bean.doulog;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.lee.LeeConfig;
import com.amall.core.lee.LeeConfigurationBuilder;
import com.amall.core.lee.LeeService;
import com.amall.core.lee.LeeUtil;
import com.amall.core.push.jpush.JPush;
import com.amall.core.service.ICashDepositService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.IRedPackgeService;
import com.amall.core.service.IRedPaperService;
import com.amall.core.service.IRefundService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.lee.IPlatformBenefitDetailService;
import com.amall.core.service.lee.IRechargeLogService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.predeposit.IPredepositLogService;
import com.amall.core.service.predeposit.IPredepositService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVipActiveService;
import com.amall.core.web.pay.PayTools;
import com.amall.core.web.pay.tencent.common.Signature;
import com.amall.core.web.pay.tencent.common.Util;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayResData;
import com.amall.core.web.pay.tencent.protocol.refund_protocol.RefundResData;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.PromoteTools;
import com.amall.core.web.tools.SystemMsgTools;
import com.amall.core.web.tools.sms.SendSMS;
import com.amall.core.web.virtual.JModelAndView;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConstants;
import com.unionpay.acp.sdk.SDKUtil;

@Controller
public class PayViewAction {

	static Logger log = Logger.getLogger(PayViewAction.class);
	
	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	
	@Autowired
	private IRedPackgeService redPackgeService;
	   
	@Autowired
	private IRedPaperService redPaperService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IPredepositService predepositService;

	@Autowired
	private IPredepositLogService predepositLogService;

	@Autowired
	private IGoldRecordService goldRecordService;
	
	@Autowired
	private ICashDepositService cashDepositService;

	@Autowired
	private IGoldLogService goldLogService;

	@Autowired
	private IPlatformBenefitDetailService platformBenefitDetailService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private MsgTools msgTools;
	
	@Autowired
	private PayTools payTools;
	
	@Autowired
	private IStoreService storeService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IRefundService refundService;
	
	@Autowired
	private IUserVipActiveService userVipActiveService;
	
	@Autowired
	private SystemMsgTools sysMsgTools;
	
	@Autowired
	private SendSMS sendSMS;
	
	
	@Autowired
	private LeeService leeService;
	
	@Autowired
	private IRechargeLogService rechargeLogService;
	
	@Autowired
    private PromoteTools promoteTools;
	
	@Autowired
	private IDoulogService doulogService;
	
	/**
	 * @Title: aplipay_return
	 * @Description: 支付宝支付后调用的同步交易,这里不改变状态，状态在异步那里修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年9月1日 下午5:01:30
	 */
	@RequestMapping({ "/aplipay_return.htm" })
	public ModelAndView aplipay_return(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = null;

		/* 订单号 */
		String out_trade_no = request.getParameter("out_trade_no");
		/* 返回内容 */
		String type = CommUtil.null2String(request.getParameter("body")).trim();
		/* 支付交易状态 */
		String trade_status = request.getParameter("trade_status");
		
		//TODO 签名验证
		/* 验证是否交易成功 */
		if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
			if (type.equals("goods")) 
			{
				AlipayOrder order = getAlipayOrderOfOrderId(out_trade_no.trim());
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria();
				orderFormCriteria.andAlipayorderIdEqualTo(order.getId());
				List<OrderFormWithBLOBs> orders = this.orderFormService.getObjectList(orderFormExample);
				if(orders != null && !orders.isEmpty())
				{
					mv = new JModelAndView("order_finish.html", this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request, response);
					mv.addObject("payment", order.getTotalFee());
				}
				
			}
			
			if(type.equals("cash_deposit"))
			{
					mv = new ModelAndView("redirect:seller/seller_index.htm");
			}
			
			if(type.equals("service"))
			{
				mv = new JModelAndView("pay_success.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
			}
			
			if(type.equals("UpGradeVip"))
			{
					
					mv = new JModelAndView("buyer/active_appliaction_sccuess.html", this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request, response);
					AlipayOrder order = getAlipayOrderOfOrderId(out_trade_no.trim());
					mv.addObject("payment", order.getPayment());
			}
			
			if(type.equals("Recharge"))
			{
					
					mv = new JModelAndView("buyer/active_appliaction_sccuess.html", this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request, response);
					AlipayOrder order = getAlipayOrderOfOrderId(out_trade_no.trim());
					mv.addObject("payment", order.getPayment());
			}

		} else {
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			mv.addObject("op_title", "支付回调失败！");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		return mv;
	}

	/**
	 * @Title: alipay_notify
	 * @Description: 支付宝交易后调用的异步交易
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return void
	 * @author tangxiang
	 * @date 2015年9月1日 下午5:01:57
	 */
	@RequestMapping({ "/alipay_notify.htm" })
	public void alipay_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 支付宝交易流水号 */
		String trade_no = request.getParameter("trade_no");
		/* 订单号 */
		String out_trade_no = request.getParameter("out_trade_no");
		/* 订单支付金额 */
		String total_fee = request.getParameter("total_fee");
		/* 商品名称 */
		String subject = request.getParameter("subject");
		/* 支付宝买家的帐号，手机或者邮箱 */
		String buyer_email = request.getParameter("buyer_email");
		/* 支付宝买家的帐号 */
		String buyerId = request.getParameter("buyer_id");
		/* 返回内容 */
		String type = CommUtil.null2String(request.getParameter("body")).trim();
		/* 支付交易状态 */
		String trade_status = request.getParameter("trade_status");

		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = valueStr + values[i] + ",";
			}

			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		Payment shop_payment = getPayType("alipay");

		// TODO 内容验证要在1分钟内才有效，签名验证与加密方式，参数编码顺序等有关
		// boolean verify_result = AlipayNotify.verify(params, config);

		AlipayOrder order = getAlipayOrderOfOrderId(out_trade_no.trim());
		
		
		if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS"))) {
			if (type.equals("goods")) 
			{
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria();
				orderFormCriteria.andAlipayorderIdEqualTo(order.getId()).andOrderStatusEqualTo(Globals.WAIT_PAYMENT_ORDER);
				List<OrderFormWithBLOBs> orders = this.orderFormService.getObjectList(orderFormExample);
				
				if(!orders.isEmpty())
				{
				    if(orders.get(0).getOrderStatus().intValue() == Globals.WAIT_PAYMENT_ORDER)
	                {
	                    order.setBankSerialNum(trade_no);
	                    order.setUserId(orders.get(0).getUserId());
	                    order.setPayCardId(buyerId);
	                    order.setPaymentId(shop_payment.getId());
	                    order.setPayType(shop_payment.getName());
	                    order.setIsRefund(false);
	                    order.setTxnTime(new Date());
	                    this.alipayOrderService.updateByObject(order);
	                }
	                
	                updateOrderStaus(orders, shop_payment.getName());
				}
				
			}
			
			if(type.equals("cash_deposit"))
			{
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					StoreWithBLOBs store = this.storeService.getByKey(order.getUser().getStoreId());
					
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(trade_no);
					order.setTxnTime(new Date());
					order.setPayCardId(buyerId);
					order.setPaymentId(shop_payment.getId());
					order.setPayType(shop_payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
					this.alipayOrderService.updateByObject(order);
					
					/* 只同步审核通过状态的 */
					saveAndSynchronizationStore(store, order);
				}
				
			}
			
			if(type.equals("UpGradeVip")){
				
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(trade_no);
					order.setPayCardId(buyerId);
					order.setPaymentId(shop_payment.getId());
					order.setPayType(shop_payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
					this.alipayOrderService.updateByObject(order);
					
					
					User user = this.userService.getByKey(order.getUserId());
					try{
						payTools.saveAndSynchronizationActiveVip(user,order);
						
						/* 系统app发红包 */
                     //   examineRedPaper(order);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			}
			
			if(type.equals("Recharge")){
				
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(trade_no);
					order.setPayCardId(buyerId);
					order.setPaymentId(shop_payment.getId());
					order.setPayType(shop_payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
					this.alipayOrderService.updateByObject(order);
					
					
					User user = this.userService.getByKey(order.getUserId());
					//1.更新会员礼品金 ,保存充值记录
					//2.充值奖 
					try{
						saveAndSynchronizationRechargeLee(user,order);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			}
			
			/* 打印信息告诉支付宝已经收到信息，避免支付宝重复发送信息 */
			PrintWriter write = response.getWriter();
			write.print("success");
		}
		
		
	}

	
	/**
	 * 银联在线前台通知 (不一定会触发) 上线可不用 已后台通知为准
	 * 
	 * @Title: unionpayRetutnResultPage
	 * @Description: TODO
	 * @param mv
	 * @param req
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 * @return ModelAndView
	 * @author guoxiangjun
	 * @date 2015年9月1日 下午4:07:03
	 */
	@RequestMapping({ "/unionpay_result.htm" })
	public ModelAndView unionpay_result(HttpServletRequest req, HttpServletResponse response)
			throws UnsupportedEncodingException {

		LogUtil.writeLog("FrontRcvResponse前台接收报文返回开始");

		ModelAndView mv = null;
		req.setCharacterEncoding("ISO-8859-1");
		String encoding = req.getParameter(SDKConstants.param_encoding);
		LogUtil.writeLog("返回报文中encoding=[" + encoding + "]");
		Map<String, String> respParam = getAllRequestParam(req);

		// 打印请求报文
		LogUtil.printRequestLog(respParam);

		Map<String, String> valideData = null;
		StringBuffer page = new StringBuffer();
		if (null != respParam && !respParam.isEmpty()) {
			Iterator<Entry<String, String>> it = respParam.entrySet().iterator();
			valideData = new HashMap<String, String>(respParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes("ISO-8859-1"), encoding);
				page.append("<tr><td width=\"30%\" align=\"right\">" + key + "(" + key + ")</td><td>" + value
						+ "</td></tr>");
				valideData.put(key, value);
			}
		}
		
		System.out.println("respCode : " + valideData.get("respCode"));
		System.out.println("respMsg : " + valideData.get("respMsg"));
		
		if (!SDKUtil.validate(valideData, encoding)) 
		{
			page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>失败</td></tr>");
			LogUtil.writeLog("验证签名结果[失败].");
			mv = new JModelAndView("/error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, req, response);
			mv.addObject("op_title", "银联在线支付失败！");
			mv.addObject("url", CommUtil.getURL(req) + "/index.htm");
			return mv;
		} 
		page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>成功</td></tr>");
		LogUtil.writeLog("验证签名结果[成功].");
		
		/* success 交易成功 */
		if(valideData.get("respCode").equals("00"))
		{
			if (valideData.get("reqReserved").equals("goods")) 
			{
				mv = new JModelAndView("order_finish.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, req, response);
				mv.addObject("payment", new BigDecimal(valideData.get("txnAmt")).multiply(new BigDecimal("0.1")));
			}
			
			if(valideData.get("reqReserved").equals("cash_deposit"))
			{
				mv = new ModelAndView("redirect:seller/seller_index.htm");
			}
			
			if(valideData.get("reqReserved").equals("UpGradeVip"))
			{
				
				mv = new JModelAndView("buyer/active_appliaction_sccuess.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, req, response);
				mv.addObject("payment", new BigDecimal(valideData.get("txnAmt")).multiply(new BigDecimal("0.1")));
			}
			
			if(valideData.get("reqReserved").equals("Recharge"))
			{
				
				mv = new JModelAndView("buyer/active_appliaction_sccuess.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, req, response);
				mv.addObject("payment", new BigDecimal(valideData.get("txnAmt")).multiply(new BigDecimal("0.1")));
			}
		}
		else
		{
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, req, response);
			mv.addObject("op_title", "银联在线支付失败！");
			mv.addObject("url", CommUtil.getURL(req) + "/index.htm");
		}
			
			
		LogUtil.writeLog("FrontRcvResponse前台接收报文返回结束");
		return mv;
	}

	/**
	 * 银联在线 消费类交易 后台异步通知
	 * 
	 * @Title: unionpayBackNotify
	 * @Description: TODO
	 * @param mv
	 * @param req
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @return ModelAndView
	 * @author guoxiangjun
	 * @date 2015年9月1日 下午4:06:54
	 */
	@RequestMapping({ "/unionpay_back_notify.htm" })
	public void unionpay_back_notify(HttpServletRequest req, HttpServletResponse response) throws UnsupportedEncodingException{
		LogUtil.writeLog("unionpay_back_notify.htm 接收后台通知开始");
		req.setCharacterEncoding("ISO-8859-1");
		String encoding = req.getParameter(SDKConstants.param_encoding);
		// 获取请求参数中所有的信息
		Map<String, String> reqParam = getAllRequestParam(req);
		// 打印请求报文
		LogUtil.printRequestLog(reqParam);

		Map<String, String> valideData = null;
		if (null != reqParam && !reqParam.isEmpty()) {
			Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
			valideData = new HashMap<String, String>(reqParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes("ISO-8859-1"), encoding);
				valideData.put(key, value);
			}
		}
		
		/* 获取支付类型 */
		Payment payment = getPayType("Unionpay");
		
		AlipayOrder alipayOrder = getAlipayOrderOfOrderId(valideData.get("orderId"));
		
		// 验证签名
		if (!SDKUtil.validate(valideData, encoding)) 
		{
			LogUtil.writeLog("验证签名结果[失败].");
			
			/* 记录付款状态 */
			createOrderLog("银联付款失败，签名验证不通过 ", String.valueOf(Globals.HAVE_PAYMENT), 
					Long.valueOf(alipayOrder.getOrderId()), alipayOrder != null ?alipayOrder.getUserId():null);
			return;
		} 
		
		String type = valideData.get("reqReserved");
		
		if(valideData.get("respCode").equals("00")) 
		{
			if(type.equals("goods")) 
			{
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria();
				orderFormCriteria.andAlipayorderIdEqualTo(alipayOrder.getId()).andOrderStatusEqualTo(Globals.WAIT_PAYMENT_ORDER);
				List<OrderFormWithBLOBs> orders = this.orderFormService.getObjectList(orderFormExample);
				if(orders.get(0).getOrderStatus().intValue() == Globals.WAIT_PAYMENT_ORDER)
				{
					alipayOrder.setBankSerialNum(valideData.get("queryId"));
					alipayOrder.setUserId(orders.get(0).getUserId());
					alipayOrder.setPaymentId(payment.getId());
					alipayOrder.setPayType(payment.getName());
					alipayOrder.setTxnTime(new Date());
					alipayOrder.setCardType(valideData.get("payCardType"));
					alipayOrder.setIsRefund(false);
					alipayOrder.setPayCode(Integer.valueOf(valideData.get("respCode")));
					
					this.alipayOrderService.updateByObject(alipayOrder);
					
				}
				
				updateOrderStaus(orders, payment.getName());
			
			}
			
			if(type.equals("cash_deposit"))
			{
				if(StringUtils.isEmpty(alipayOrder.getBankSerialNum())){
					StoreWithBLOBs store = this.storeService.getByKey(alipayOrder.getUser().getStoreId());
					
					/* 保存信息到订单支付表 */
					alipayOrder.setBankSerialNum(valideData.get("queryId"));
					alipayOrder.setUserId(store.getUserId());
					alipayOrder.setPaymentId(payment.getId());
					alipayOrder.setPayType(payment.getName());
					alipayOrder.setTxnTime(new Date());
					alipayOrder.setCardType(valideData.get("payCardType"));
					alipayOrder.setIsRefund(false);
					alipayOrder.setPayCode(Integer.valueOf(valideData.get("respCode")));
					this.alipayOrderService.updateByObject(alipayOrder);
					
					/* 只同步审核通过状态的 */
					saveAndSynchronizationStore(store, alipayOrder);
				}
				
			}
			
			if(type.equals("UpGradeVip")){
				
				if(StringUtils.isEmpty(alipayOrder.getBankSerialNum())){
					/* 保存信息到订单支付表 */
					alipayOrder.setBankSerialNum(valideData.get("queryId"));
					alipayOrder.setPaymentId(payment.getId());
					alipayOrder.setPayType(payment.getName());
					alipayOrder.setTxnTime(new Date());
					alipayOrder.setCardType(valideData.get("payCardType"));
					alipayOrder.setIsRefund(false);
					alipayOrder.setPayCode(Integer.valueOf(valideData.get("respCode")));
					this.alipayOrderService.updateByObject(alipayOrder);
					
					User user = this.userService.getByKey(alipayOrder.getUserId());
					//1.更新AMALL会员等级 ,保存升级记录,并发送短信通知和站内信
					//2.更新分红会员等级 
					//3.分红保存用户升级的支付记录 
					//4.互助奖(直接,间接,三级现金返点,保存每个会员的可提现，可消费) 
					
					try{
						payTools.saveAndSynchronizationActiveVip(user,alipayOrder);
						
						/* 系统app发红包 */
					//	examineRedPaper(alipayOrder);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
			
			if(type.equals("Recharge")){
				
				if(StringUtils.isEmpty(alipayOrder.getBankSerialNum())){
					/* 保存信息到订单支付表 */
					alipayOrder.setBankSerialNum(valideData.get("queryId"));
					alipayOrder.setPaymentId(payment.getId());
					alipayOrder.setPayType(payment.getName());
					alipayOrder.setTxnTime(new Date());
					alipayOrder.setCardType(valideData.get("payCardType"));
					alipayOrder.setIsRefund(false);
					alipayOrder.setPayCode(Integer.valueOf(valideData.get("respCode")));
					this.alipayOrderService.updateByObject(alipayOrder);
					
					User user = this.userService.getByKey(alipayOrder.getUserId());
					
					try{
						saveAndSynchronizationRechargeLee(user,alipayOrder);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
			
		}
		else
		{
			/* 记录付款状态 */
			createOrderLog("银联付款失败 ", String.valueOf(Globals.HAVE_PAYMENT), 
					Long.valueOf(alipayOrder.getOrderId()), alipayOrder != null ?alipayOrder.getUserId():null);
		}
		
		LogUtil.writeLog("unionpay_back_notify.htm 接收后台通知结束");
	}

	/**
	 * @Title: refund_entrance
	 * @Description: 退款入口
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年9月8日 下午2:49:42 
	 */
	@RequestMapping({ "/refund_entrance.htm" })
	public ModelAndView refund_entrance(HttpServletRequest request, 
			HttpServletResponse response, String id,String ofid) throws Exception 
	{
		ModelAndView mv = null;
		CashDeposit cashDeposit = this.cashDepositService.getByKey(Long.valueOf(id));
		OrderForm orderForm=orderFormService.getByKey(Long.valueOf(ofid));
		Payment payment =  cashDeposit.getAlipayOrder().getPayment();
		log.info("支付信息id"+cashDeposit.getAlipayOrder().getId());
		Long aliplayID=cashDeposit.getAlipayOrder().getId();
		/*String orderId=cashDeposit.getAlipayOrder().getOrderId();*/
		BigDecimal total=orderForm.getTotalprice();
		//BigDecimal total=new BigDecimal(20);
		Long userId=cashDeposit.getAlipayOrder().getUserId();
		Refund refund = cashDeposit.getRefund();
		
		/* 支付宝 */ 
		if(payment.getMark().equals("alipay"))
		{
			mv = new JModelAndView("line_pay.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			mv.addObject("type", "refund");
			mv.addObject("url", CommUtil.getURL(request));
			mv.addObject("payType", payment.getMark());
			mv.addObject("paymentId", payment.getId());
			mv.addObject("refund", cashDeposit.getRefund());
			mv.addObject("alipayOrder", cashDeposit.getAlipayOrder());
			mv.addObject("payTools", this.payTools);
			return mv;
		} 
		
		/* 银联 */
		if(payment.getMark().equals("Unionpay"))
		{
			/* 异步回掉退款结果 */
			payTools.unionpayRefund(CommUtil.getURL(request), payment.getId(), refund, cashDeposit.getAlipayOrder());
		}
		
		if(payment.getMark().equals("WXPay"))
		{
		    RefundResData refundResData;
		    
		    if(cashDeposit.getAlipayOrder().getAppPay())
		    {
		        refundResData = payTools.wxpayRefundApp(payment, refund, cashDeposit.getAlipayOrder());
		    }
		    else
		    {
		        refundResData = payTools.wxpayRefund(payment, refund, cashDeposit.getAlipayOrder());
		    }
		    
			
			if (refundResData == null || refundResData.getReturn_code() == null) 
            {
                log.info("Case1:退款API请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
                createOrderLog("微信退款失败 ", "退款API请求逻辑错误", 
                        null, null);
                
            }else if (refundResData.getReturn_code().equals("FAIL")) {
                ///注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
                log.info("Case2:退款API系统返回失败，请检测Post给API的数据是否规范合法");
                createOrderLog("微信退款失败 ", refundResData.getErr_code_des(), 
                        null, null);
            } 
            else 
            {
                if (refundResData.getResult_code().equals("FAIL")) {
                    log.info("Case4:【退款失败】 错误码：" + refundResData.getErr_code() + "     错误信息：" + refundResData.getErr_code_des());
                    //退款失败时再怎么延时查询退款状态都没有意义，这个时间建议要么再手动重试一次，依然失败的话请走投诉渠道进行投诉
                    createOrderLog("微信退款失败 ", refundResData.getErr_code_des(), 
                            null, null);
                } else {
                    //退款成功
                    log.info("Case5:【退款成功】");
                    updateRefundInfo(refundResData.getTransaction_id(), refundResData.getOut_refund_no(), true);
                    /* 记录付款状态 */
                    createOrderLog("微信退款成功 ", String.valueOf(Globals.HAVE_REFUND), 
                            Long.valueOf(refundResData.getOut_refund_no()), null);
                }
            }
		
		}
		
		if(payment.getMark().equals("AGPay")){
			System.err.println("1");
			updateRefundInfos(userId,total,aliplayID, orderForm.getOrderId(), true);
			log.info("退款成功！");
		}
		
		mv = new ModelAndView("redirect:/admin/index.htm");
		return mv;
		
	}
	
	/**
	 * @Title: alipay_refund_notify
	 * @Description: 支付宝退款后的异步调用
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return void
	 * @author tangxiang
	 * @date 2015年9月1日 下午5:03:14
	 */
	@RequestMapping({ "/alipay_refund_notify.htm" })
	public void alipay_refund_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 通知时间 */
		String notify_time = request.getParameter("notify_time");
		/* 通知类型 */
		String notify_type = request.getParameter("notify_type");
		/* 通知校验ID */
		String notify_id = request.getParameter("notify_id");
		/* 签名方式 */
		String sign_type = request.getParameter("sign_type");
		/* 签名 */
		String sign = request.getParameter("sign");
		/* 退款批次号 */
		String batch_no = request.getParameter("batch_no");
		/* 退款成功 总数 */
		String success_num = request.getParameter("success_num");
		/* 退款结果明细 */
		String result_details = request.getParameter("result_details");
		
		//TODO 验证签名
		/* 根据交易流水号获取到退款对应对象 */
		String serialNum = result_details.split("\\^")[Globals.NUBER_ZERO];
		
		/* 前8位为申请日期，后面的才是订单号 */
		String orderId = batch_no.substring(8, batch_no.length());
		
//		 && cashDeposit.getCashStatus() != Globals.APPLY_REFUND_SELLER_SUCCEED
		/* 退款成功 */
        if(result_details.contains("SUCCESS"))
        {
            updateRefundInfo(serialNum, orderId, true);
            
            /* 记录付款状态 */
            createOrderLog("支付宝退款成功 ", String.valueOf(Globals.HAVE_REFUND), 
                    Long.valueOf(orderId), null);
        }
		else
		{
		    updateRefundInfo(serialNum, orderId, false);
			/* 记录付款状态 */
			createOrderLog("支付宝退款失败 ", null, 
					Long.valueOf(orderId), null);
		}

		/* 打印信息告诉支付宝已经收到信息，避免支付宝重复发送信息 */
		PrintWriter write = response.getWriter();
		write.print("success");
	}
	
	
	/**
	 *  银联在线 撤销交易 后台通知
	 * @Title: unionpayRefundBackNotify
	 * @Description: TODO
	 * @param req
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @return void
	 * @author guoxiangjun
	 * @date 2015年9月6日 上午11:43:36
	 */
	@RequestMapping({"/unionpay_cancel_back_notify.htm"})
	public void unionpay_cancel_back_notify(HttpServletRequest req,
			HttpServletResponse response) throws UnsupportedEncodingException
	{
		LogUtil.writeLog("unionpay_cancel_back_notify.htm 接收后台通知开始");
		req.setCharacterEncoding("ISO-8859-1");
		String encoding = req.getParameter(SDKConstants.param_encoding);
		// 获取请求参数中所有的信息
		Map<String, String> reqParam = getAllRequestParam(req);
		// 打印请求报文
		LogUtil.printRequestLog(reqParam);

		Map<String, String> valideData = null;
		if (null != reqParam && !reqParam.isEmpty()) {
			Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
			valideData = new HashMap<String, String>(reqParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes("ISO-8859-1"), encoding);
				valideData.put(key, value);
			}
		}
		
		/* 根据交易流水号获取到退款对应对象 */
        String serialNum = valideData.get("origQryId");
        String orderId = valideData.get("orderId");
		
		AlipayOrderExample aoe = new AlipayOrderExample();
		aoe.clear();
		aoe.createCriteria().andBankSerialNumEqualTo(serialNum);
		AlipayOrder ao = this.alipayOrderService.getObjectList(aoe).get(0);
		ao.setTxnTime(new Date());
		ao.setRefundFee(new BigDecimal(valideData.get("txnAmt")));
		ao.setIsRefund(true);
		this.alipayOrderService.updateByObject(ao);
		
		// 验证签名
		if (!SDKUtil.validate(valideData, encoding)) {
		    
		    updateRefundInfo(serialNum, orderId, false);
			LogUtil.writeLog("银联在线 退货类交易---验证签名结果[失败].");
			createOrderLog("银联在线退款失败 ", null, 
	                Long.valueOf(orderId), null);
			
			/* 记录付款状态 */
			createOrderLog("银联在线退款失败，签名验证不通过 ", String.valueOf(Globals.HAVE_REFUND), 
					Long.valueOf(ao.getOrderId()), ao.getUserId());
			return;
		} 
		LogUtil.writeLog("银联在线 退货类交易---验证签名结果[成功].");
		
		updateRefundInfo(serialNum, orderId, true);
		
		/* 记录付款状态 */
        createOrderLog("银联退款成功 ", String.valueOf(Globals.HAVE_REFUND), 
                Long.valueOf(orderId), null);
		
		LogUtil.writeLog("unionpay_refund_back_notify.htm 接收后台通知结束");
	}

	
	private void updateRefundInfo(String serialNum, String orderId, boolean isSuccess)
    {
	    AlipayOrderExample alipayOrderExample = new AlipayOrderExample();
        alipayOrderExample.createCriteria().andBankSerialNumEqualTo(serialNum.trim());
        List<AlipayOrder> alipayOrders = this.alipayOrderService.getObjectList(alipayOrderExample);
        AlipayOrder alipayOrder = alipayOrders.get(Globals.NUBER_ZERO);
        OrderFormWithBLOBs orderForm = getOrderFormOfOrderId(orderId);
        Refund refund = getRefundOfOrderPk(orderForm.getId());
        
        CashDepositExample cashDepositExample = new CashDepositExample();
        cashDepositExample.createCriteria().andPayOrderIdEqualTo(alipayOrder.getId()).andRefundIdEqualTo(refund.getId());
        CashDeposit cashDeposit = this.cashDepositService.getObjectList(cashDepositExample).get(Globals.NUBER_ZERO);
        
        if(isSuccess)
        {
            /* 退款成功 */
            if(cashDeposit.getCashStatus().intValue() != Globals.APPLY_REFUND_SELLER_SUCCEED)
            {
                cashDeposit.setCashStatus(Globals.APPLY_REFUND_SELLER_SUCCEED);
                cashDeposit.setPaymentTime(new Date());
                this.cashDepositService.updateByObject(cashDeposit);
                
                /* 修改订单详情状态为已退款 */
                if(refund.getStatus().intValue() == Globals.WAIT_REFUND)
                {
                    refund.setStatus(Globals.HAVE_REFUND);
                    this.refundService.updateByObject(refund);
                }
                
                OrderFormItem formItem = this.orderFormItemService.getObjectByOrderIdAndGoodsId(refund.getOfId(), refund.getGoodsId());
                if(formItem.getRefund().intValue() == Globals.WAIT_REFUND)
                {
                    formItem.setRefund(Globals.HAVE_REFUND);
                    this.orderFormItemService.updateByObject(formItem);
                }
                
                orderForm.setOrderStatus(Globals.HAVE_REFUND);
                orderFormService.updateByObject(orderForm);
                AlipayOrder order=new AlipayOrder();
                order.setId(alipayOrder.getId());
                order.setIsRefund(true);
                order.setRefundFee(alipayOrder.getTotalFee());
                alipayOrderService.updateByObject(order);
                
                boolean isdou=orderForm.getAutoConfirmSms();
                Integer bean_num=orderForm.getBeanNum().intValue();
                if(isdou && bean_num>0){
                	
                	Long userId=orderForm.getUserId();
                	//退回用户豆
                	User user = userService.getByKey (userId);
                	user.setDou(user.getDou()==null?bean_num:(user.getDou()+bean_num));
                	this.userService.updateUsers(user);
                	
                	/* 保存豆记录 */
        			doulog dl = new doulog ();
        			dl.setAddtime(new Date ());
        			dl.setDealtime (new Date ());
        			dl.setUserId (Long.valueOf (1));
        			dl.setDealUserId(Integer.valueOf(userId+""));
        			dl.setTotalDouNum(bean_num);
        			dl.setDealDouNum (bean_num);
        			dl.setType ((short)1);
        			this.doulogService.add(dl);
                }
            }
        }
        else
        {
            cashDeposit.setCashStatus(Globals.APPLY_REFUND_SELLER_FAIL);
            cashDeposit.setPaymentTime(new Date());
            this.cashDepositService.updateByObject(cashDeposit);
        }
        
    }
	/**
	 * 天使余额退款
	 * @param serialNum
	 * @param orderId
	 * @param isSuccess
	 */
	private void updateRefundInfos(Long userId,BigDecimal total, Long id, String orderId, boolean isSuccess)
    {
	    AlipayOrderExample alipayOrderExample = new AlipayOrderExample();
        alipayOrderExample.createCriteria().andIdEqualTo(id);
        List<AlipayOrder> alipayOrders = this.alipayOrderService.getObjectList(alipayOrderExample);
        AlipayOrder alipayOrder = alipayOrders.get(Globals.NUBER_ZERO);
        OrderFormWithBLOBs orderForm = getOrderFormOfOrderId(orderId);
        Refund refund = getRefundOfOrderPk(orderForm.getId());
        
        CashDepositExample cashDepositExample = new CashDepositExample();
        cashDepositExample.createCriteria().andPayOrderIdEqualTo(alipayOrder.getId()).andRefundIdEqualTo(refund.getId());
        CashDeposit cashDeposit = this.cashDepositService.getObjectList(cashDepositExample).get(Globals.NUBER_ZERO);
        
        if(isSuccess)
        {
        	
        	
            /* 退款成功 */
            if(cashDeposit.getCashStatus().intValue() != Globals.APPLY_REFUND_SELLER_SUCCEED)
            {
            	/*修改天使金额*/
            	User user = new User();
            	UserExample userExample=new UserExample();
            	userExample.createCriteria().andIdEqualTo(userId);
            	List<User> users=userService.getObjectList(userExample);
            	user=users.get(0);
            	System.err.println(userId);
            	System.err.println(user.getCurrentFee());
            	System.err.println(total);
            	
            	userMoneyDetail detail = new userMoneyDetail();
    			detail.setAddTime(new Date());
    			detail.setCanCarry((user.getCanCarry ()));
    			detail.setDetailFee(total);
    			detail.setDetailTx(14);
    			detail.setManageMoney(user.getManageMoney().add(total));
    			detail.setRemark("余额退款");
    			detail.setUserId(user.getId());
    			this.userMoneyDetailService.add(detail);
            	
            	user.setManageMoney(user.getManageMoney().add(total));
            	user.setCurrentFee(user.getCurrentFee().add(total));
            	user.setId(user.getId());
            	userService.updateByObject(user);
                cashDeposit.setCashStatus(Globals.APPLY_REFUND_SELLER_SUCCEED);
                cashDeposit.setPaymentTime(new Date());
                this.cashDepositService.updateByObject(cashDeposit);
                
              /*  将支付订单中的状态改了，便于提现查询*/
                AlipayOrder order=new AlipayOrder();
                order.setId(alipayOrder.getId());
                order.setIsRefund(true);
                alipayOrderService.updateByObject(order);
                /* 修改订单详情状态为已退款 */
                if(refund.getStatus().intValue() == Globals.WAIT_REFUND)
                {
                    refund.setStatus(Globals.HAVE_REFUND);
                    this.refundService.updateByObject(refund);
                }
                
                OrderFormItem formItem = this.orderFormItemService.getObjectByOrderIdAndGoodsId(refund.getOfId(), refund.getGoodsId());
                if(formItem.getRefund().intValue() == Globals.WAIT_REFUND)
                {
                    formItem.setRefund(Globals.HAVE_REFUND);
                    this.orderFormItemService.updateByObject(formItem);
                }
                
                orderForm.setOrderStatus(Globals.HAVE_REFUND);
                orderFormService.updateByObject(orderForm);
                
                boolean isdou=orderForm.getAutoConfirmSms();
                Integer bean_num=orderForm.getBeanNum().intValue();
                if(isdou && bean_num>0){
                	user.setDou(user.getDou()==null?bean_num:(user.getDou()+bean_num));
                	this.userService.updateUsers(user);
                	
                	/* 保存豆记录 */
        			doulog dl = new doulog ();
        			dl.setAddtime(new Date ());
        			dl.setDealtime (new Date ());
        			dl.setUserId (Long.valueOf (1));
        			dl.setDealUserId(Integer.valueOf(userId+""));
        			dl.setTotalDouNum(bean_num);
        			dl.setDealDouNum (bean_num);
        			dl.setType ((short)1);
        			this.doulogService.add(dl);
                }
            }
        }
        else
        {
            cashDeposit.setCashStatus(Globals.APPLY_REFUND_SELLER_FAIL);
            cashDeposit.setPaymentTime(new Date());
            this.cashDepositService.updateByObject(cashDeposit);
        }
        
    }

    private Refund getRefundOfOrderPk(Long orderPk)
    {
        RefundExample example = new RefundExample();
        example.createCriteria().andOfIdEqualTo(orderPk);
        List<Refund> list = refundService.getObjectList(example);
        return list.get(0);
    }

    private OrderFormWithBLOBs getOrderFormOfOrderId(String orderId)
    {
	    OrderFormExample example = new OrderFormExample();
	    example.createCriteria().andOrderIdEqualTo(orderId);
	    List<OrderFormWithBLOBs> list = orderFormService.getObjectList(example);
        return list.get(0);
    }

    @RequestMapping({ "/wx_pay.htm" })
	public void wx_pay(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String xmlStr = Util.inputStreamToString(request.getInputStream());
		ScanPayResData resData = (ScanPayResData) Util.getObjectFromXML(xmlStr, ScanPayResData.class);
//		payTools.genericWXPay(resData);
	}
	
	@RequestMapping({ "/wxpay_refund_notify.htm" })
	public void wxpay_refund_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String payServiceResponseString = Util.inputStreamToString(request.getInputStream());
		
		//将从API返回的XML数据映射到Java对象
        ScanPayResData scanPayResData = (ScanPayResData) Util.getObjectFromXML(payServiceResponseString, ScanPayResData.class);
		
        /* 验证签名 */
        if (!Signature.checkIsSignValidFromResponseString(payServiceResponseString)) {
        	System.out.println("【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了");
        	return;
        }
        
        /* 处理订单流程 */
        String resultCode = scanPayResData.getResult_code();
        
        String returnCode = scanPayResData.getReturn_code();
        
        String orderId = scanPayResData.getOut_trade_no();
        
        String transactionId = scanPayResData.getTransaction_id();
        
        String openId = scanPayResData.getOpenid();
        
        String type = scanPayResData.getAttach();
        
        /* 获取支付类型 */
		Payment payment = getPayType("WXPay");

		AlipayOrder order = getAlipayOrderOfOrderId(orderId.trim());
		
		if("SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode))
		{
			if (type.equals("goods")) 
			{
					OrderFormExample orderFormExample = new OrderFormExample();
					orderFormExample.clear();
					OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria();
					orderFormCriteria.andAlipayorderIdEqualTo(order.getId()).andOrderStatusEqualTo(Globals.WAIT_PAYMENT_ORDER);
					List<OrderFormWithBLOBs> orders = this.orderFormService.getObjectList(orderFormExample);
					
					if(orders != null && !orders.isEmpty() && orders.get(0).getOrderStatus().intValue() == Globals.WAIT_PAYMENT_ORDER)
					{
						order.setBankSerialNum(transactionId);
						order.setUserId(orders.get(0).getUserId());
						order.setPayCardId(openId);
						order.setPaymentId(payment.getId());
						order.setPayType(payment.getName());
						order.setIsRefund(false);
						order.setTxnTime(new Date());
						this.alipayOrderService.updateByObject(order);
					}
					
					updateOrderStaus(orders, payment.getName());
			}
			
			if(type.equals("cash_deposit"))
			{
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					StoreWithBLOBs store = this.userService.getByKey(order.getUserId()).getStore();
					
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(orderId);
					order.setPayCardId(openId);
					order.setPaymentId(payment.getId());
					order.setPayType(payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
					this.alipayOrderService.updateByObject(order);
					
					/* 只同步审核通过状态的 */
					saveAndSynchronizationStore(store, order);
				}
				
			}
			if (type.equals("UpGradeVip")){
				
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					log.info("会员升级成功,保存信息到订单支付表");
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(orderId);
					order.setPayCardId(openId);
					order.setPaymentId(payment.getId());
					order.setPayType(payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
				
					this.alipayOrderService.updateByObject(order);
					
					User user = this.userService.getByKey(order.getUserId());
					//1.更新AMALL会员等级 ,并发送短信通知和站内信
					//2.保存用户升级的支付记录 
					//3.互助奖(直接,间接,三级现金返点,保存每个会员的可提现，可消费) 
					
					payTools.saveAndSynchronizationActiveVip(user,order);
					
					/* 系统app发红包 */
                   // examineRedPaper(order);
				}
				
			}
			
			if (type.equals("Recharge")){
				
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(orderId);
					order.setPayCardId(openId);
					order.setPaymentId(payment.getId());
					order.setPayType(payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
				
					this.alipayOrderService.updateByObject(order);
					
					User user = this.userService.getByKey(order.getUserId());
					
					try{
						saveAndSynchronizationRechargeLee(user,order);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
			
			if (type.equals("service")){
				
				if(StringUtils.isEmpty(order.getBankSerialNum())){
					/* 保存信息到订单支付表 */
					order.setBankSerialNum(orderId);
					order.setPayCardId(openId);
					order.setPaymentId(payment.getId());
					order.setPayType(payment.getName());
					order.setIsRefund(false);
					order.setTxnTime(new Date());
				
					this.alipayOrderService.updateByObject(order);
					
				}
				
			}
			
			/* 通知服务已经收到信息了 */
	        PrintWriter write = response.getWriter();
	        write.print("SUCCESS");
		}
		
		
		
	}
	
	/*private void saveAndSynchronizationActiveVip(User user, AlipayOrder alipayOrder)
	{
		log.info("会员: "+user.getUsername()+" 升级,更新会员等级和礼品金：开始");
		会员升级描述
		String content = "";
		Integer gold = 0;
		BigDecimal payAmount = alipayOrder.getTotalFee();
		LeeConfig leeConfig = LeeConfigurationBuilder.getInstance().parseConfiguration();
		if(payAmount.compareTo(leeConfig.getV_two().getAmount()) == Globals.NUBER_ZERO){
			content = LeeUtil.getVipInstance(user.getLevelAngel()).getName()+" 升级成为 "+LeeUtil.getVipInstance(Globals.NUBER_TWO).getName();
			user.setLevelAngel(Globals.NUBER_TWO);
			gold = leeConfig.getV_two().getGold();
		}else{
			content = LeeUtil.getVipInstance(user.getLevelAngel()).getName()+" 升级成为 "+LeeUtil.getVipInstance(Globals.NUBER_THREE).getName();
			user.setLevelAngel(Globals.NUBER_THREE);
			gold = leeConfig.getV_three().getGold();
			if(user.getManageMoney()!=null){
				user.setManageMoney(user.getManageMoney().add(new BigDecimal(Globals.FinancialGold)));
			}else{
				user.setManageMoney(new BigDecimal(Globals.FinancialGold));
			}
			if(user.getHistoryFee()!=null){
				user.setHistoryFee(user.getHistoryFee().add(new BigDecimal(Globals.FinancialGold)));
			}else {
				user.setHistoryFee(new BigDecimal(Globals.FinancialGold));
			}
			//把赠送理财金记录写进PlatformBenefitDetail表里面去
			//type == 7 代表是会员升级超级送了理财金
			PlatformBenefitDetail detail = new PlatformBenefitDetail(new Date(), new BigDecimal(Globals.FinancialGold), Globals.NUBER_THREE,7,new Long(1), user.getId());
			platformBenefitDetailService.add(detail);
			该用户刚升级联盟商家，未领取礼品状态
			user.setStatus(8000);
		}
		log.info(content);
		  
		用户升级会员送礼品金
		user.setGold(user.getGold() + gold);
		this.userService.updateByObject(user);
		
		
		log.info("会员升级后,更新会员等级和礼品金：结束");
		
		log.info("保存会员升级记录：开始");
		//保存会员升级记录
		VipActiveLogExample activeLogExample = new VipActiveLogExample();
		activeLogExample.createCriteria().andUserIdEqualTo(user.getId()).andUpgradeFeeIsNull();
		VipActiveLog vipActiveLog = userVipActiveService.getObjectList(activeLogExample).get(0);
		vipActiveLog.setContent(content);
		vipActiveLog.setAngelGold(gold);
		vipActiveLog.setUpgradeFee(payAmount);
		vipActiveLog.setPayId(alipayOrder.getPaymentId());
		vipActiveLog.setPayUserId(user.getId());
		userVipActiveService.updateByObject(vipActiveLog);
		log.info("保存会员升级记录：结束");
		
		//保存会员升级支付记录
		createOrderLog(content, String.valueOf(Globals.HAVE_PAYMENT), 
				Long.valueOf(alipayOrder.getOrderId()), alipayOrder.getUserId());
		
		*//**
		 * 互助奖分红
		 *//*
		log.info("互助奖分红：开始");
		leeService.hzLee(user, payAmount);
		log.info("互助奖分红：结束");
		
		 保存推广记录 
		promoteTools.savePromoteInfo(user, payAmount);
		
		log.info("发送系统消息和短信消息,知会用户升级成功：开始");
        *//**
         * 发送升级V2短信通知和站内信
         *//*
        if(user.getLevelAngel() == Globals.NUBER_TWO){
            告知升级成为联盟商家
            this.sendSMS.sendActiveVip2SuccessMessage(user.getUsername(), user.getTruename());
            sysMsgTools.sendMsg(user.getId(), SystemMsgTools.VIP_2);
            
            Map<String, Object> msgMap = new HashMap<String, Object>();
            msgMap.put("userId", user.getId());
            msgMap.put("content", "恭喜您升级为天使商城联盟商家");
            msgMap.put("vipLevel", SystemMsgTools.VIP_2);
            JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),"angelVip"+user.getId());
        }else{
            告知升级成为初级会员
            this.sendSMS.sendActiveVip1SuccessMessage(user.getUsername(), user.getTruename());
            sysMsgTools.sendMsg(user.getId(), SystemMsgTools.VIP_1);
            
            Map<String, Object> msgMap = new HashMap<String, Object>();
            msgMap.put("userId", user.getId());
            msgMap.put("content", "恭喜您升级为天使商城联盟商家");
            msgMap.put("vipLevel", SystemMsgTools.VIP_3);
            JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),"angelVip"+user.getId());
        }
        log.info("发送系统消息和短信消息,知会用户升级成功：结束");
	}
	*/
	
	private void saveAndSynchronizationRechargeLee(User user, AlipayOrder alipayOrder){
		BigDecimal payAmount = alipayOrder.getTotalFee();
		Integer giveGold = payAmount.multiply(LeeUtil.getConfigInstance().getRecharegeGiveGoldRate()).intValue();
		System.out.println("礼品金="+giveGold);
		/*用户充值送礼品金*/
		user.setGold(user.getGold() + giveGold.intValue());
		/*更新用户礼品金*/
		this.userService.updateByObject(user);
		
		
		/*保存充值记录*/
		RechargeLog rechargeLog = new RechargeLog();
		rechargeLog.setAddTime(new Date());
		rechargeLog.setRechargeFee(payAmount);
		rechargeLog.setUserId(user.getId());
		rechargeLog.setPayType(alipayOrder.getPayType());
		rechargeLog.setPayId(alipayOrder.getPaymentId());
		rechargeLog.setRechargeGold(giveGold);
		rechargeLogService.addGold(rechargeLog);
		

		
		/**
		 * 发送充值成功短信
		 */
		this.sendSMS.sendRechargeSuccessMessage(user.getUsername(), payAmount);
		
		/*充值分红*/
		leeService.rechargeLee(user, payAmount);
	}
	

	public String appendParam(String returnStr, String paramId, String paramValue) {
		if (!returnStr.equals("")) {
			if (!paramValue.equals("")) {
				returnStr = returnStr + "&" + paramId + "=" + paramValue;
			}
		} else if (!paramValue.equals("")) {
			returnStr = paramId + "=" + paramValue;
		}

		return returnStr;
	}


	/**
	 * 获取请求参数中所有的信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				// System.out.println("ServletUtil类247行 temp数据的键=="+en+"
				// 值==="+value);
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}


	private void send_order_email(HttpServletRequest request, OrderForm order, String email, String mark)
			throws Exception {
		Template template = null;
		TemplateExample templateExample = new TemplateExample();
		templateExample.clear();
		templateExample.createCriteria().andMarkEqualTo(mark);
		List<Template> templates = templateService.getObjectList(templateExample);
		if (templates.size() > 0 && templates != null)
			template = templates.get(0);

		if ((template != null) && (template.getOpen())) {
			String subject = template.getTitle();
			String path = this.configService.getSysConfig().getUploadRootPath() + "/vm/";
			PrintWriter pwrite = new PrintWriter(
					new OutputStreamWriter(new FileOutputStream(path + "msg.vm", false), "UTF-8"));
			pwrite.print(template.getContent());
			pwrite.flush();
			pwrite.close();

			Properties p = new Properties();
			p.setProperty("file.resource.loader.path", request.getRealPath("/") + "vm" + File.separator);
			p.setProperty("input.encoding", "UTF-8");
			p.setProperty("output.encoding", "UTF-8");
			Velocity.init(p);
			org.apache.velocity.Template blank = Velocity.getTemplate("msg.vm", "UTF-8");
			VelocityContext context = new VelocityContext();
			context.put("buyer", order.getUser());
			context.put("seller", order.getStore().getUser());
			context.put("config", this.configService.getSysConfig());
			context.put("send_time", CommUtil.formatLongDate(new Date()));
			context.put("webPath", CommUtil.getURL(request));
			context.put("order", order);
			StringWriter writer = new StringWriter();
			blank.merge(context, writer);

			String content = writer.toString();
			this.msgTools.sendEmail(email, subject, content);
		}
	}

	private void send_order_sms(HttpServletRequest request, OrderForm order, String mobile, String mark)
			throws Exception {
		Template template = null;
		TemplateExample templateExample = new TemplateExample();
		templateExample.clear();
		templateExample.createCriteria().andMarkEqualTo(mark);
		List<Template> templates = templateService.getObjectList(templateExample);
		if (templates.size() > 0 && templates != null)
			template = templates.get(0);

		if ((template != null) && (template.getOpen())) {
			String path = this.configService.getSysConfig().getUploadRootPath() + "/vm/";
			PrintWriter pwrite = new PrintWriter(
					new OutputStreamWriter(new FileOutputStream(path + "msg.vm", false), "UTF-8"));
			pwrite.print(template.getContent());
			pwrite.flush();
			pwrite.close();

			Properties p = new Properties();
			p.setProperty("file.resource.loader.path", request.getRealPath("/") + "vm" + File.separator);
			p.setProperty("input.encoding", "UTF-8");
			p.setProperty("output.encoding", "UTF-8");
			Velocity.init(p);
			org.apache.velocity.Template blank = Velocity.getTemplate("msg.vm", "UTF-8");
			VelocityContext context = new VelocityContext();
			context.put("buyer", order.getUser());
			context.put("seller", order.getStore().getUser());
			context.put("config", this.configService.getSysConfig());
			context.put("send_time", CommUtil.formatLongDate(new Date()));
			context.put("webPath", CommUtil.getURL(request));
			context.put("order", order);
			StringWriter writer = new StringWriter();
			blank.merge(context, writer);

			String content = writer.toString();
			this.msgTools.sendSMS(mobile, content);
		}
	}
	
	
	/** 
	* @Title: createOrderLog 
	* @Description: 生成订单日志
	* @param info 操作简述
	* @param status 状态码
	* @param orderId 订单ID
	* @throws 
	* @author tangxiang
	* @date 2015年9月21日
	*/
	private void createOrderLog(String info, String status, Long orderId, Long userId) {
		OrderFormLog orderLog = new OrderFormLog();
		orderLog.setAddtime(new Date());
		orderLog.setLogInfo(info);
		orderLog.setLogUserId(userId);
		orderLog.setDeletestatus(false);
		orderLog.setStateInfo(status);
		orderLog.setOfId(orderId);
		this.orderFormLogService.add(orderLog);
	}
	
	/** 
	* @Title: saveAndSynchronizationStore 
	* @Description: 保存和同步店铺信息
	* @param store
	* @param alipayOrder
	* @throws 
	* @author tangxiang
	* @date 2015年10月12日
	*/
	private void saveAndSynchronizationStore(StoreWithBLOBs store, AlipayOrder alipayOrder)
	{
		if(store.getStoreStatus().intValue() == 4)
		{
			/* 更新店铺缴纳保证金状态 */
			store.setPaymentId(alipayOrder.getId());
			store.setStoreStatus(2);
			this.storeService.updateByObject(store);
			
			/* 记录付款日志 */
			createOrderLog("缴纳开店保证金 ", String.valueOf(Globals.HAVE_PAYMENT), 
					Long.valueOf(alipayOrder.getOrderId()), alipayOrder.getUserId());
			
		}
		else
		{
			/* 记录付款日志 */
			createOrderLog("缴纳开店保证金流程异常,店铺未审核通过。 状态为 ：" + store.getStoreStatus(), String.valueOf(Globals.HAVE_PAYMENT), 
					Long.valueOf(alipayOrder.getOrderId()), alipayOrder.getUserId());
		}
	}
	
	/** 
	* @Title: getPayType 
	* @Description: 获取支付类型 
	* @param type
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月12日
	*/
	private Payment getPayType(String type)
	{
		PaymentExample paymentExample = new PaymentExample();
		paymentExample.clear();
		paymentExample.createCriteria().andMarkEqualTo(type);
		List<PaymentWithBLOBs> payments = paymentService.getObjectList(paymentExample);
		return (Payment) payments.get(Globals.NUBER_ZERO);
	}
	
	/** 
	* @Title: getAlipayOrderOfOrderId 
	* @Description: 根据订单Id获取支付对象
	* @param orderId
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月12日
	*/
	private AlipayOrder getAlipayOrderOfOrderId(String orderId)
	{
		AlipayOrderExample example = new AlipayOrderExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return this.alipayOrderService.getObjectList(example).get(Globals.NUBER_ZERO);
	}
	

	/**
	 * 生成红包
	 * @param sendUserId
	 * @param redNumber
	 * @param sendType
	 * @param redPackgeType
	 * @param upgradeLevel
	 */
	public void examineRedPaper(AlipayOrder order)
	{
		RedPackge redPackge = new RedPackge();
		User sendUser = this.userService.getByKey(order.getUserId());
		if(sendUser != null)
		{
		    /* 发送系统红包 */
		    LeeConfig leeConfig = LeeConfigurationBuilder.getInstance().parseConfiguration();
            int upgradeLevel = 0;
            if(order.getTotalFee().compareTo(leeConfig.getV_three().getAmount()) > Globals.NUBER_ZERO)
            {
                upgradeLevel = 2;
            }else{
                upgradeLevel = 1;
            }
            
            /* 系统发当前订单金额的20%的礼品金红包 */
          
            int totalGold = CommonValues.SYSTEM_SEND_TOTALGOLD;
            int redNumber = CommonValues.SYSTEM_SEND_REDPAPER_TOTALNUM;
            
            
			if(totalGold > 0)
			{
				redPackge.setAddTime(new Date());
				redPackge.setRedNumber(redNumber);
				redPackge.setRedPackgeRemain(redNumber);
				redPackge.setRedPackgeType("1");
				redPackge.setSendType(Globals.NUBER_ZERO);
				
				redPackge.setTotalGold(totalGold);
				redPackge.setUpgradeLevel(upgradeLevel);
				redPackge.setUserId(sendUser.getId());
				this.redPackgeService.add(redPackge);
				
				RedPaper redPaper = null;
				
				
				for (int i = 0; i < CommonValues.SYSTEM_SEND_REDPAPER_NUM_ONE; i++) 
				{
					Random ranSort = new Random();
					int sort = ranSort.nextInt(10) + 1;
				    redPaper = new RedPaper();
					redPaper.setAddtime(new Date());
					redPaper.setGold(CommonValues.SYSTEM_SEND_REDPAPER_GLOD_ONE);
					redPaper.setSort(sort);
					redPaper.setSendUserId(sendUser.getId());
					redPaper.setUserRedPackgeId(redPackge.getId());
					this.redPaperService.add(redPaper);
				}
				
				for (int i = 0; i < CommonValues.SYSTEM_SEND_REDPAPER_NUM_FIVE; i++) 
				{
					Random ranSort = new Random();
					int sort = ranSort.nextInt(10) + 1;
				    redPaper = new RedPaper();
					redPaper.setAddtime(new Date());
					redPaper.setGold(CommonValues.SYSTEM_SEND_REDPAPER_GLOD_FIVE);
					redPaper.setSort(sort);
					redPaper.setSendUserId(sendUser.getId());
					redPaper.setUserRedPackgeId(redPackge.getId());
					this.redPaperService.add(redPaper);
				}
				
				/* 推送红包 */
				Map<String, String> map = new HashMap<>();
				map.put("userId", sendUser.getId().toString());
				map.put("userName", sendUser.getTruename() != null ? sendUser.getTruename() : "匿名");
				map.put("id", redPackge.getId().toString());
				map.put("key", "sendRedPaper");
				JPush.sendMessageWithPassThroughAll(Json.gson.toJson(map),null);
			}
		}
	}
	
	private void updateOrderStaus(List<OrderFormWithBLOBs> orders, String payName)
	{
	    for (OrderFormWithBLOBs order1 : orders) {
            if (order1.getOrderStatus().intValue() == Globals.WAIT_PAYMENT_ORDER) {
                /* 更改状态为已付款 */
                order1.setOrderStatus(Globals.HAVE_PAYMENT);
                order1.setPaytime(new Date());
                
                /* 如果是0天退货商品那么结束时间就是支付时间 */
                if(check0DayItem(order1.getId()))
                {
                    order1.setFinishtime(new Date());
                }
                
                this.orderFormService.updateByObject(order1);

                /* 记录付款日志 */
                createOrderLog(payName, String.valueOf(Globals.HAVE_PAYMENT), 
                        Long.valueOf(order1.getOrderId()), order1.getUserId());


            }
        }
	}
	
	private boolean check0DayItem(Long orderId)
	{
	    OrderFormItemExample example = new OrderFormItemExample();
	    example.createCriteria().andOrderIdEqualTo(orderId).andRefundServerEqualTo(Globals.REFUND_SERVER_TIME_0);
	    return orderFormItemService.getObjectListCount(example) > 0 ? true : false;
	    
	}
	
}
