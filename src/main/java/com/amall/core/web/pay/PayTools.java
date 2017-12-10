package com.amall.core.web.pay;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.CommonValues;
import com.amall.common.constant.Globals;
import com.amall.common.tools.Json;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPaper;
import com.amall.core.bean.Refund;
import com.amall.core.bean.User;
import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.lee.LeeConfig;
import com.amall.core.lee.LeeConfigurationBuilder;
import com.amall.core.lee.LeeService;
import com.amall.core.lee.LeeUtil;
import com.amall.core.push.jpush.JPush;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.IRedPackgeService;
import com.amall.core.service.IRedPaperService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVipActiveService;
import com.amall.core.web.pay.alipay.AlipayConfig;
import com.amall.core.web.pay.alipay.AlipayService;
import com.amall.core.web.pay.alipay.AlipaySubmit;
import com.amall.core.web.pay.tencent.WXPay;
import com.amall.core.web.pay.tencent.common.Signature;
import com.amall.core.web.pay.tencent.common.Util;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayReqData;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayResData;
import com.amall.core.web.pay.tencent.protocol.refund_protocol.RefundReqData;
import com.amall.core.web.pay.tencent.protocol.refund_protocol.RefundResData;
import com.amall.core.web.pay.unionpay.UnionPayConfig;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.PromoteTools;
import com.amall.core.web.tools.SystemMsgTools;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKUtil;


@Component
public class PayTools {

	static Logger log = Logger.getLogger(PayTools.class);
	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IAlipayOrderService alipayOrderService;// 多个订单对应新生成的订单
	
	@Autowired
    private LeeService leeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired 
	private IOrderFormService orderFormService;
	
	@Autowired
	private IOrderFormItemService itemService;
	
	@Autowired
	private IOrderFormLogService logService;
	
	@Autowired
    private PromoteTools promoteTools;

	@Autowired
	private IUserVipActiveService userVipActiveService;
	
	@Autowired
	private IRedPaperService redPaperService;
	
	@Autowired
	private IRedPackgeService redPackgeService;
	
	@Autowired
	private IGoldRecordService goldRecordService;
	
	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;
	
	/**
	 * @Title: genericAlipay
	 * @Description: 支付宝即时支付信息设置
	 * @param url
	 * @param alipayOrderId 支付信息id
	 * @param type
	 * @param id
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年9月1日 下午3:36:12
	 */
	public String genericAlipay(String url, String alipayOrderId, String type) {
		
		AlipayOrder of = null;//多个订单对应新生成的订单
		
		of = this.alipayOrderService.getByKey(CommUtil.null2Long(alipayOrderId));

		AlipayConfig config = new AlipayConfig();
		
		url = checkUrl(url);
		
		config.setNotify_url(url + "alipay_notify.htm");// 返回的响应的页面
		config.setReturn_url(url + "aplipay_return.htm");// 返回的响应的页面

		String out_trade_no = of.getOrderId();// 订单号，传给支付宝的订单号

		String subject = of.getOrderId();// 商品名称，传给支付宝的商品名称

		String body = type;// 

		// TODO 支付测试价格
		//String total_fee = CommUtil.null2String("0.01");// 支付总金额
		String total_fee = of.getTotalFee().toString();

		String paymethod = "";

		String defaultbank = "";

		String anti_phishing_key = "";

		String exter_invoke_ip = "";

		String extra_common_param = type;

		String buyer_email = "";

		String show_url = "";

		/* 打包请求参数Map */
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("body", body);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("paymethod", paymethod);
		sParaTemp.put("defaultbank", defaultbank);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		sParaTemp.put("extra_common_param", extra_common_param);
		sParaTemp.put("buyer_email", buyer_email);
		sParaTemp.put("service", "create_direct_pay_by_user");

		return AlipayService.create_direct_pay_by_user(config, sParaTemp);
	}
	
	/**
	 * @Title: genericRefundAlipay
	 * @Description: 支付宝即时退款
	 * @param url 服务器地址
	 * @param paymentId 支付方式ID
	 * @param refund 退款对象
	 * @param alipayOrder 订单质保保存对象
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年9月1日 下午4:01:05 
	 */
	public String genericRefundAlipay(String url, Long paymentId, Refund refund, AlipayOrder alipayOrder) {
		
		url = checkUrl(url);
		
		//服务器异步通知页面路径
		String notify_url = url + "alipay_refund_notify.htm";

		//卖家支付宝帐户
		String seller_email = AlipayConfig.seller_email;
		//必填

		//退款当天日期
		String refund_date = CommUtil.formatLongDate(new Date());
		//必填，格式：年[4位]-月[2位]-日[2位] 小时[2位 24小时制]:分[2位]:秒[2位]，如：2007-10-01 13:13:13

		//批次号
		String batch_no = CommUtil.formatDate(new Date()) + refund.getOf().getOrderId();
		//必填，格式：当天日期[8位]+序列号[3至24位]，如：201008010000001

		//退款笔数 暂时支持单笔退款
		String batch_num = "1";
		//必填，参数detail_data的值中，“#”字符出现的数量加1，最大支持1000笔（即“#”字符出现的数量999个）

		//退款详细数据
		String detail_data = alipayOrder.getBankSerialNum() + "^" + refund.getRefund().toString() + "^"
				+ (refund.getRefundItem() != null ? refund.getRefundItem().getName() : "退款");
		
		//把请求参数打包成Map
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "refund_fastpay_by_platform_pwd");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("refund_date", refund_date);
		sParaTemp.put("batch_no", batch_no);
		sParaTemp.put("batch_num", batch_num);
		sParaTemp.put("detail_data", detail_data);
		log.info("alipay refund map : " + sParaTemp);
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		
		return sHtmlText;
	}

	/** 
	* @Title: genericChinaBank 
	* @Description: 银联支付 
	* @param url
	* @param alipayOrderId 订单支付信息对象ID
	* @param type
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年9月22日
	*/
	public String genericChinaBank(String url, String alipayOrderId, String type) 
	{
		SDKConfig.getConfig().loadProperties(UnionPayConfig.propertis);
		
		AlipayOrder alipayOrder = null;
		alipayOrder = this.alipayOrderService.getByKey(CommUtil.null2Long(alipayOrderId));
		
		/* 获取银联的支付方式信息 */
		PaymentExample pe = new PaymentExample();
		pe.clear();
		pe.createCriteria().andMarkEqualTo("Unionpay");
		Payment payment = this.paymentService.getObjectList(pe).get(0);
		
		/* 支付的金钱，单位为分 */
		int fee = alipayOrder.getTotalFee().multiply(new BigDecimal(100)).intValue(); 
		//String fee = "1";
		
		/**
		 * 组装请求报文
		 */
		Map<String, String> requestData = new HashMap<String, String>();
		
		/***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
		requestData.put("version", UnionPayConfig.VERSION);   //版本号 全渠道默认值
		requestData.put("encoding", UnionPayConfig.ENCODING); //字符集编码 可以使用UTF-8,GBK两种方式
		requestData.put("signMethod", UnionPayConfig.ALGORITHM); //签名方法 目前只支持01：RSA方式证书加密
		requestData.put("txnType", UnionPayConfig.CONSUME_TXNTYPE); //交易类型 01：消费，02：预授权
		requestData.put("txnSubType", UnionPayConfig.SELF_TXNSUBTYPE); //交易子类型 01：自助消费，03：分期付款
		requestData.put("bizType", UnionPayConfig.E_BANK_PAY_TYPE);  //业务类型 B2C网关支付，手机wap支付
		requestData.put("channelType", UnionPayConfig.PC_CHANNEL_TYPE); //渠道类型 07：PC,08：移动端
		
		/***商户接入参数***/
		requestData.put("merId", payment.getChinabankAccount());    //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
		requestData.put("accessType", UnionPayConfig.SHOP_ACCESS_TYPE); //接入类型，商户接入填0 ，不需修改（0：直连商户， 1： 收单机构 2：平台商户）
		requestData.put("orderId", alipayOrder.getOrderId()); //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则		
		requestData.put("txnTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
		requestData.put("currencyCode", UnionPayConfig.CURRENCY_CODE); //交易币种（境内商户一般是156 人民币）		
		requestData.put("txnAmt", String.valueOf(fee));              //交易金额，单位分，不要带小数点
//		requestData.put("txnAmt", fee); 
		requestData.put("reqReserved", type);        //请求方保留域，透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节		
		
		//前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
		//如果想要实现过几秒中自动跳转回商户页面权限，需联系银联业务申请开通自动返回商户权限
		//异步通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
		
		url = checkUrl(url);
			
		requestData.put("frontUrl", url + "unionpay_result.htm");
		
		//后台通知地址（需设置为外网能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
		//后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
		//注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码 
		//    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200或302，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
		//    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
		requestData.put("backUrl", url + "unionpay_back_notify.htm");
		
		String html = UnionPayConfig.createHtml(SDKConfig.getConfig().getFrontRequestUrl(), UnionPayConfig.signData(requestData));
		log.info("打印请求HTML，此为请求报文，为联调排查问题的依据："+html);
		return html;
	}

	
	
	/** 
	* @Title: unionpayRefund 
	* @Description: 银联退款
	* @param url 服务器地址
    * @param paymentId 支付方式ID
    * @param refund 退款对象
    * @param alipayOrder 订单质保保存对象
	* @return
	* @throws InterruptedException
	* @throws 
	* @author tangxiang
	* @date 2015年9月23日
	*/
	public boolean unionpayRefund(String url, Long paymentId, Refund refund, AlipayOrder alipayOrder) throws InterruptedException {
		
		SDKConfig.getConfig().loadProperties(UnionPayConfig.propertis);
		
		/* 获取银联的支付方式信息 */
		Payment payment = this.paymentService.getByKey(paymentId);
		
		url = checkUrl(url);
//		String fee = "1";
		String fee = refund.getRefund().multiply(BigDecimal.valueOf(100)).intValue() + "";
		/**
		 * 组装请求报文 , 银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改
		 */
		Map<String, String> data = new HashMap<String, String>();
		
		/***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
		data.put("version", UnionPayConfig.VERSION); //版本号
		data.put("encoding", UnionPayConfig.ENCODING); //字符集编码 可以使用UTF-8,GBK两种方式
		data.put("signMethod", UnionPayConfig.ALGORITHM); //签名方法 目前只支持01-RSA方式证书加密
		data.put("txnType", UnionPayConfig.REFUND_TYPE); //交易类型 4-退货		
		data.put("txnSubType", UnionPayConfig.REFUND_TXNSUBTYPE); //交易子类型  默认00		
		data.put("bizType", UnionPayConfig.E_BANK_PAY_TYPE); // 	
		data.put("channelType", UnionPayConfig.PC_CHANNEL_TYPE); //渠道类型，07-PC，08-手机		
		
		/***商户接入参数***/
		data.put("merId", payment.getChinabankAccount()); //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
		data.put("accessType", UnionPayConfig.SHOP_ACCESS_TYPE); //接入类型，商户接入固定填0，不需修改		
		data.put("orderId", refund.getOf().getOrderId());          //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则，重新产生，不同于原消费		
		data.put("txnTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));  //订单发送时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效		
		data.put("txnAmt", fee); //****退货金额，单位分，不要带小数点。退货金额小于等于原消费金额，当小于的时候可以多次退货至退货累计金额等于原消费金额		
		data.put("backUrl", url + "unionpay_cancel_back_notify.htm"); //后台通知地址，后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 退货交易 商户通知,其他说明同消费交易的后台通知
		
		/***要调通交易以下字段必须修改***/
		data.put("origQryId", alipayOrder.getBankSerialNum()); //****原消费交易返回的的queryId，可以从消费交易后台通知接口中或者交易状态查询接口中获取
		
		Map<String, String> submitFromData = UnionPayConfig.filterBlank(data);

		// 交易请求url 从配置文件读取
		String requestBackUrl = SDKConfig.getConfig().getBackRequestUrl();
		System.out.println("requestBackUrl="+requestBackUrl);
		//如果这里通讯读超时（30秒），需发起交易状态查询交易
		String resultStr = UnionPayConfig.submitUrl(submitFromData, requestBackUrl);
		
		/* 处理返回报文 */
		Map<String, String> resmap = new HashMap<String, String>();
		
		/**
		 * 验证签名
		 */
		if (null != resultStr && !"".equals(resultStr)) 
		{
			// 将返回结果转换为map
			resmap = SDKUtil.convertResultStringToMap(resultStr);
			System.out.println("resmap="+resmap.get("respCode"));
			if (SDKUtil.validate(resmap, UnionPayConfig.ENCODING)) {
				
				//应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
				if(resmap.get("respCode").equals("00"))
				{
					//交易已受理，等待接收后台通知更新订单状态,也可以主动发起 查询交易确定交易状态。
					return true;
				}else if(resmap.get("respCode").equals("03") || 
						 resmap.get("respCode").equals("04") ||
						 resmap.get("respCode").equals("05")){
					//后续需发起交易状态查询交易确定交易状态
					return true;
				}else{
					//其他应答码为失败请排查原因
					return false;
				}
				
			} else {
				return false;
			}
		}
			
		return false;
	}
	
	/** 
	* @Title: genericWXPay 
	* @Description: 微信支付
	* @param id
	* @param goodsName
	* @param type
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月18日
	*/
	public String genericWXPay(String url, Long id, String goodsName, String type) {
	
		AlipayOrder of = null;//多个订单对应新生成的订单
		
		url = checkUrl(url);
		
		of = this.alipayOrderService.getByKey(id);

		String outTradeNo = of.getOrderId();// 订单号，传给微信的订单号

		String body = goodsName;

		// TODO 支付测试价格
		//int totalFee = 1;
		int totalFee = of.getTotalFee().multiply(new BigDecimal(100)).intValue(); // 支付总金额

		/* 透传信息 */
		String attach = type;

		ScanPayReqData scanPayReqData = new ScanPayReqData(body, attach, outTradeNo, totalFee, url);
		
		try
		{
			String payServiceResponseString = WXPay.requestScanPayService(scanPayReqData);
			
			//将从API返回的XML数据映射到Java对象
	        ScanPayResData scanPayResData = (ScanPayResData) Util.getObjectFromXML(payServiceResponseString, ScanPayResData.class);
	        
	        if (scanPayResData == null || scanPayResData.getReturn_code() == null) {
	        	log.info("【支付失败】支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
	            return null;
	        }
	        
	        //验证服务器签名
	        if (!Signature.checkIsSignValidFromResponseString(payServiceResponseString)) {
	        	log.info("【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了");
                return null;
            }
	        

	        if (scanPayResData.getReturn_code().equals("FAIL")) {
	            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
	        	log.info("【支付失败】支付API系统返回失败，请检测Post给API的数据是否规范合法");
	            return null;
	        }
	        
	        if (scanPayResData.getResult_code().equals("FAIL")) {
	            //注意：一般这里返回FAIL的情况一般是订单信息错误,如订单号重复等
	        	log.info("【支付失败】支付API商户信息错误");
	            return scanPayResData.getErr_code_des();
	        }
	        
	        else 
	        {

	            if (scanPayResData.getResult_code().equals("SUCCESS")) 
	            {

	                //--------------------------------------------------------------------
	                //1)直接扣款成功
	                //--------------------------------------------------------------------

	            	return scanPayResData.getCode_url();
	            }
	        }
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	
		return null;
	}
	
	/** 
	* @Title: wxpayRefund 
	* @Description: 微信支付退款
	* @param paymentId
	* @param refund
	* @param alipayOrder
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月17日
	*/
	public RefundResData wxpayRefund(Payment paymentId, Refund refund, AlipayOrder alipayOrder) 
	{
		/* 单位分 */
		int totalFee = alipayOrder.getTotalFee().multiply(new BigDecimal(100)).intValue();
		
		int cashFee = refund.getRefund().multiply(new BigDecimal(100)).intValue();
		
		RefundReqData refundReqData = new RefundReqData(alipayOrder.getBankSerialNum(), alipayOrder.getOrderId(), refund.getId().toString(), totalFee, cashFee, refund.getOf().getOrderId());
		
		try
		{
			String refundServiceResponseString = WXPay.requestRefundService(refundReqData);
			
			if (!Signature.checkIsSignValidFromResponseString(refundServiceResponseString)) {
                log.info("Case3:退款请求API返回的数据签名验证失败，有可能数据被篡改了");
                return null;
            }
			 //将从API返回的XML数据映射到Java对象
	        RefundResData refundResData = (RefundResData) Util.getObjectFromXML(refundServiceResponseString, RefundResData.class);

	        return refundResData;
	        
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 微信支付app退款
	 * @param paymentId
	 * @param refund
	 * @param alipayOrder
	 * @return
	 */
	public RefundResData wxpayRefundApp(Payment paymentId, Refund refund, AlipayOrder alipayOrder) 
    {
        /* 单位分 */
        int totalFee = alipayOrder.getTotalFee().multiply(new BigDecimal(100)).intValue();
        
        int cashFee = refund.getRefund().multiply(new BigDecimal(100)).intValue();
        
        RefundReqData refundReqData = new RefundReqData(alipayOrder.getBankSerialNum(), alipayOrder.getOrderId(), refund.getId().toString(), totalFee, cashFee, refund.getOf().getOrderId(), true);
        
        try
        {
            String refundServiceResponseString = WXPay.requestRefundServiceApp(refundReqData);
            
            if (!Signature.checkIsSignValidFromResponseString(refundServiceResponseString)) {
                log.info("Case3:退款请求API返回的数据签名验证失败，有可能数据被篡改了");
                return null;
            }
             //将从API返回的XML数据映射到Java对象
            RefundResData refundResData = (RefundResData) Util.getObjectFromXML(refundServiceResponseString, RefundResData.class);

            return refundResData;
            
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
	
	public String genericAGPay(String url, Long id, String goodsName, String type) {
		
		AlipayOrder of = null;//多个订单对应新生成的订单
		User user = SecurityUserHolder.getCurrentUser();
		System.out.println(user.getId());
		url = checkUrl(url);
		String body = null;
		
		/* 可提现金额 */
	    BigDecimal depositCurrency = leeService.getAllowWithdrawDeposit(user);
	    
	    /*当前金额*/
		BigDecimal currentMoney = user.getCurrentFee();
		
		//add by 田
	    if(depositCurrency == null || depositCurrency==BigDecimal.ZERO || currentMoney == null || currentMoney==BigDecimal.ZERO)return body;
		
		//剩余的20%
		BigDecimal SurplusMoney= user.getManageMoney();
		/*BigDecimal SurplusMoney= currentMoney.subtract(depositCurrency);	*/
		of = this.alipayOrderService.getByKey(id);

		String outTradeNo = of.getOrderId();// 订单号
		
		int SurplusMoneys = 0;
		int money=0;
		// TODO 支付测试价格
		//int totalFee = 10;// 支付总金额
		int totalFee = of.getTotalFee().multiply(new BigDecimal(100)).intValue(); 
		int Withdraw=depositCurrency.multiply(new BigDecimal(100)).intValue();
		
		if(SurplusMoney != null){
			SurplusMoneys = SurplusMoney.multiply(new BigDecimal(100)).intValue();	//剩余20%
		}
		
		if(currentMoney!=null){
			money=currentMoney.multiply(new BigDecimal(100)).intValue();
		}
		int moneyPays=money-totalFee;
		int Surplus=SurplusMoneys-totalFee;		//20
		int ktx = Withdraw-totalFee;				//80
		try
		{
			
			
			if(type=="goods"){
				 if (moneyPays>=0) {
					 log.info("支付成功!");
			        	body="1";
			        	//扣除
			        	
			        	BigDecimal subManage =  user.getManageMoney().subtract(new BigDecimal(totalFee/100));
			        	userMoneyDetail detail = new userMoneyDetail();
			        	
			        	if(subManage.compareTo(BigDecimal.ZERO) >= 0)
			        	{
			        		user.setManageMoney(subManage);
			        		
			        		detail.setCanCarry(user.getCanCarry ());
			        		detail.setManageMoney(subManage);
			        	}else
			        	{
			        		user.setManageMoney(BigDecimal.ZERO);
			        		user.setCanCarry(user.getCanCarry().add(subManage));
			        		
			        		detail.setCanCarry(user.getCanCarry().add(subManage));
			        		detail.setManageMoney(BigDecimal.ZERO);
			        	}
						detail.setAddTime(new Date());
						detail.setDetailFee(BigDecimal.ZERO.subtract(new BigDecimal(totalFee/100)));
						detail.setDetailTx(12);
						detail.setRemark("余额支付商品扣除");
						detail.setUserId(user.getId());
						this.userMoneyDetailService.add(detail);
			        	
			        	user.setCurrentFee(new BigDecimal(moneyPays/100));
			        	user.setId(user.getId());
			        	userService.updateByObject(user);
			        	AGPay_refund_notify(type,outTradeNo,"1");
			        	return body;
		            } else {
						log.info("支付失败，余额不足已支付");
			        }
			}else if(ktx>=0){
				body="1";
				 
				userMoneyDetail detail = new userMoneyDetail();
				detail.setAddTime(new Date());
				detail.setCanCarry(user.getCanCarry().subtract(new BigDecimal(totalFee/100)));
				detail.setDetailFee(BigDecimal.ZERO.subtract(new BigDecimal(totalFee/100)));
				detail.setDetailTx(13);
				detail.setManageMoney(user.getManageMoney());
				detail.setRemark("余额支付代升级扣除");
				detail.setUserId(user.getId());
				this.userMoneyDetailService.add(detail);
				
				user.setCanCarry(user.getCanCarry().subtract(new BigDecimal(totalFee/100)));
				user.setCurrentFee(new BigDecimal(moneyPays/100));
	        	user.setId(user.getId());
	        	userService.updateByObject(user);
	        	AGPay_refund_notify(type,outTradeNo,"2");
	        	return body;
				
			}/*else if(SurplusMoneys >=totalFee ){
				if(Surplus >= 0){
					 log.info("剩余20%支付成功!");
					 body="1";
					 user.setManageMoney(user.getManageMoney().subtract(new BigDecimal(totalFee/100)));
					 user.setCurrentFee(new BigDecimal(moneyPays/100));
			        	user.setId(user.getId());
			        	userService.updateByObject(user);
			        	AGPay_refund_notify(type,outTradeNo,"3");
			        	return body;
				}
			}*/else{
				log.info("支付失败,余额中可提现金额不足");
			} 
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	
		return body;
	}
	
	private String checkUrl(String url)
	{
		if(!"/".equals(url.substring(url.length() - 1)))
		{
			url += "/";
		}	
		
		return url;
	}
	
	/**
	 * 天使余额支付
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void AGPay_refund_notify(String type,String orderId ,String identify ) throws Exception {
		 /* 获取支付类型 */
		User users = SecurityUserHolder.getCurrentUser();
		Payment payment = getPayType("AGPay");
		AlipayOrder order = getAlipayOrderOfOrderId(orderId.trim());
		if (type.equals("goods")) {
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				OrderFormExample.Criteria orderFormCriteria = orderFormExample.createCriteria();
				orderFormCriteria.andAlipayorderIdEqualTo(order.getId()).andOrderStatusEqualTo(Globals.WAIT_PAYMENT_ORDER);
				List<OrderFormWithBLOBs> orders = this.orderFormService.getObjectList(orderFormExample);
				if(orders != null && !orders.isEmpty() && orders.get(0).getOrderStatus().intValue() == Globals.WAIT_PAYMENT_ORDER){
					order.setUserId(orders.get(0).getUserId());
					order.setSellerUserId(users.getId());
					order.setPaymentId(payment.getId());
					order.setPayType(payment.getName());
					order.setIsRefund(false);
					order.setCardType("2");
					order.setTxnTime(new Date());
					this.alipayOrderService.updateByObject(order);
				}
				
				updateOrderStaus(orders, payment.getName());
				
		}else if(identify.equals("2")){
			if(StringUtils.isEmpty(order.getBankSerialNum())){
				log.info("会员升级成功,保存信息到订单支付表");
				// 保存信息到订单支付表 
				order.setPaymentId(payment.getId());
				order.setPayType(payment.getName());
				order.setIsRefund(false);
				order.setCardType("1");//用天使余额升级会员会有此标识；
				order.setTxnTime(new Date());
				order.setSellerUserId(users.getId());
			
				this.alipayOrderService.updateByObject(order);
				
				User user = this.userService.getByKey(order.getUserId());
				//1.更新AMALL会员等级 ,并发送短信通知和站内信
				//2.保存用户升级的支付记录 
				//3.互助奖(直接,间接,三级现金返点,保存每个会员的可提现，可消费) 
				
				try{
					saveAndSynchronizationActiveVip(user,order);
					
					// 系统app发红包 
                   // examineRedPaper(order);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/***
	 * 获取支付方式
	 * @param type
	 * @return
	 */
	private Payment getPayType(String type){
		PaymentExample paymentExample = new PaymentExample();
		paymentExample.clear();
		paymentExample.createCriteria().andMarkEqualTo(type);
		List<PaymentWithBLOBs> payments = paymentService.getObjectList(paymentExample);
		return (Payment) payments.get(Globals.NUBER_ZERO);
	}

	/***
	 * 获取对应订单的信息
	 * @param orderId
	 * @return
	 */
	private AlipayOrder getAlipayOrderOfOrderId(String orderId)
	{
		AlipayOrderExample example = new AlipayOrderExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return this.alipayOrderService.getObjectList(example).get(Globals.NUBER_ZERO);
	}
	
	/**
	 * 成功后，修改订单状态
	 * @param orders
	 * @param payName
	 */
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
	    return itemService.getObjectListCount(example) > 0 ? true : false;
	    
	}
	
	private void createOrderLog(String info, String status, Long orderId, Long userId) {
		OrderFormLog orderLog = new OrderFormLog();
		orderLog.setAddtime(new Date());
		orderLog.setLogInfo(info);
		orderLog.setLogUserId(userId);
		orderLog.setDeletestatus(false);
		orderLog.setStateInfo(status);
		orderLog.setOfId(orderId);
		this.logService.add(orderLog);
	}
	
	public void saveAndSynchronizationActiveVip(User user, AlipayOrder alipayOrder)
	{
		log.info("会员: "+user.getUsername()+" 升级,更新会员等级和礼品金：开始");
		/*会员升级描述*/
		String content = "";
		Integer gold = 0;
		int FinancialGold = 0;
		BigDecimal payAmount = alipayOrder.getTotalFee();
		LeeConfig leeConfig = LeeConfigurationBuilder.getInstance().parseConfiguration();
		if(payAmount.compareTo(leeConfig.getV_five().getAmount()) == Globals.NUBER_ZERO){
			content = LeeUtil.getVipInstance(user.getLevelAngel()).getName()+" 升级成为 "+LeeUtil.getVipInstance(Globals.NUBER_FIFTY).getName();
			user.setLevelAngel(Globals.NUBER_FIVE);
			gold = leeConfig.getV_five().getGold();
		}else if(payAmount.compareTo(leeConfig.getV_seven().getAmount()) == Globals.NUBER_ZERO){
			FinancialGold = Globals.FinancialGold;
			content = LeeUtil.getVipInstance(user.getLevelAngel()).getName()+" 升级成为 "+LeeUtil.getVipInstance(Globals.NUBER_SEVEN).getName();
			user.setLevelAngel(Globals.NUBER_SEVEN);
			gold = leeConfig.getV_seven().getGold();
			userMoneyDetail userMoneyDetail = new userMoneyDetail();
			if(user.getManageMoney()!=null){
				user.setManageMoney(user.getManageMoney().add(new BigDecimal(Globals.FinancialGold)));
				userMoneyDetail.setCanCarry(user.getCanCarry());
				userMoneyDetail.setManageMoney(user.getManageMoney().add(new BigDecimal(Globals.FinancialGold)));
			}else{
				user.setManageMoney(new BigDecimal(Globals.FinancialGold));
				userMoneyDetail.setCanCarry(user.getCanCarry());
				userMoneyDetail.setManageMoney(new BigDecimal(Globals.FinancialGold));
			}
			
			userMoneyDetail.setAddTime(new Date());
			userMoneyDetail.setDetailFee(new BigDecimal(Globals.FinancialGold));
			userMoneyDetail.setDetailTx(19);
			userMoneyDetail.setRemark("升级超级联盟商赠送感恩金");
			userMoneyDetail.setUserId(user.getId());
			this.userMoneyDetailService.add(userMoneyDetail);
			
			if(user.getHistoryFee()!=null){
				user.setHistoryFee(user.getHistoryFee().add(new BigDecimal(Globals.FinancialGold)));
			}else {
				user.setHistoryFee(new BigDecimal(Globals.FinancialGold));
			}
			if(user.getCurrentFee() != null)
			{
				user.setCurrentFee(user.getCurrentFee().add(new BigDecimal(Globals.FinancialGold)));
				System.out.println("不为空"+user.getCurrentFee());
			}else{
				user.setCurrentFee(new BigDecimal(Globals.FinancialGold));
				System.out.println("空"+user.getCurrentFee());
			}
			/*该用户刚升级超级合伙人，未领取礼品状态*/
			user.setStatus(8000);
		}else{
			FinancialGold = Globals.FinancialGoldFIVE;
			content = LeeUtil.getVipInstance(user.getLevelAngel()).getName()+" 升级成为 "+LeeUtil.getVipInstance(Globals.NUBER_THREE).getName();
			if(user.getManageMoney()!=null){
				user.setManageMoney(user.getManageMoney().add(new BigDecimal(Globals.FinancialGoldFIVE)));
			}else{
				user.setManageMoney(new BigDecimal(Globals.FinancialGoldFIVE));
			}
			if(user.getHistoryFee()!=null){
				user.setHistoryFee(user.getHistoryFee().add(new BigDecimal(Globals.FinancialGoldFIVE)));
			}else {
				user.setHistoryFee(new BigDecimal(Globals.FinancialGoldFIVE));
			}
			if(user.getCurrentFee() != null)
			{
				user.setCurrentFee(user.getCurrentFee().add(new BigDecimal(Globals.FinancialGoldFIVE)));
				System.out.println("不为空"+user.getCurrentFee());
			}else{
				user.setCurrentFee(new BigDecimal(Globals.FinancialGoldFIVE));
				System.out.println("空"+user.getCurrentFee());
			}
			user.setLevelAngel(Globals.NUBER_THREE);
			user.setStatus(8000);
		}
		log.info(content);
		  
		/*用户升级合伙人送礼品金*/
		/*user.setGold(user.getGold() + gold);*/
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
		vipActiveLog.setAddtime(new Date());
		vipActiveLog.setPayUserId(user.getId());
		vipActiveLog.setFinancialGold(FinancialGold);
		userVipActiveService.updateByObject(vipActiveLog);
		log.info("保存会员升级记录：结束");
		
		//保存会员升级支付记录
		createOrderLog(content, String.valueOf(Globals.HAVE_PAYMENT), 
				Long.valueOf(alipayOrder.getOrderId()), alipayOrder.getUserId());
	
		/**
		 * 互助奖分红
		 */
		log.info("互助奖分红：开始");
		leeService.hzLee(user, payAmount);
		log.info("互助奖分红：结束");
		/* 保存推广记录 */
		promoteTools.savePromoteInfo(user, payAmount);
		
	
		
		log.info("发送系统消息和短信消息,知会用户升级成功：开始");
        /**
         * 发送升级V2短信通知和站内信
         */
        if(user.getLevelAngel() == Globals.NUBER_FIVE){
            /*告知升级成为高级合伙人*/
            /*this.sendSMS.sendActiveVip2SuccessMessage(user.getUsername(), user.getTruename());
            sysMsgTools.sendMsg(user.getId(), SystemMsgTools.VIP_2);*/
            
            Map<String, Object> msgMap = new HashMap<String, Object>();
            msgMap.put("userId", user.getId());
            msgMap.put("content", "恭喜您升级为天使商城高级联盟商家");
            msgMap.put("vipLevel", SystemMsgTools.VIP_2);
            JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),"angelVip"+user.getId());
        }else if(user.getLevelAngel() == Globals.NUBER_SEVEN){
            /*告知升级成为初级合伙人*/
            /*this.sendSMS.sendActiveVip1SuccessMessage(user.getUsername(), user.getTruename());
            sysMsgTools.sendMsg(user.getId(), SystemMsgTools.VIP_1);*/
            
            Map<String, Object> msgMap = new HashMap<String, Object>();
            msgMap.put("userId", user.getId());
            msgMap.put("content", "恭喜您升级为天使商城超级联盟商家");
            msgMap.put("vipLevel", SystemMsgTools.VIP_3);
            JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),"angelVip"+user.getId());
        }else{
        	  Map<String, Object> msgMap = new HashMap<String, Object>();
              msgMap.put("userId", user.getId());
              msgMap.put("content", "恭喜您升级为天使商城联盟商家");
              msgMap.put("vipLevel", SystemMsgTools.VIP_1);
              JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),"angelVip"+user.getId());
        }
        log.info("发送系统消息和短信消息,知会用户升级成功：结束");
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
}
