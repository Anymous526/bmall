package com.amall.core.web.pay.tencent.common;

import java.io.File;

/**
 * @author tangxiang
 *
 */
public class Configure {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

    /*             移动端退款配置                       */
    public static final String APP_KEY = "4jo505y2jg4ttcj3imf0l5j7yc3sy8od";	//4jo505y2jg4ttcj3imf0l5j7yc3sy8od

    public static final String APP_APP_ID = "wx69503053301bd63d";	//wx69503053301bd63d

    public static final String APP_MCH_ID = "1347024901";	//1347024901
    
    public static final String appCertPassword = "1347024901";	//1347024901
    
    public static String appHttpsRequestClassName = "com.amall.core.web.pay.tencent.common.HttpsRequestApp";
    
    /* https证书路径 ，证书仅用于退款或取消订单  */
    public static final String appCertLocalPath = "/data/keys/apiclient_cert_app.p12";		///data/keys/apiclient_cert_app.p12
    
    /*             移动端退款配置结束                   */
    
	public static final String KEY = "4jo505y2jg4ttcj3imf0l5j7yc3sy8od";//5kr6vo715gzuo39to0uj798r4kssn9as

	//微信分配的公众号ID（开通公众号之后可以获取到）
	public static final String APP_ID = "wx69503053301bd63d";//wxba24aad8d5f560c4

	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	public static final String MCH_ID = "1347024901";//1239382202
	
	//受理模式下给子商户分配的子商户号
	public static final String SUB_MCH_ID = "";
	
	public static final String TRADE_TYPE = "NATIVE";
	
	public static final String SPBILL_CREATE_IP = "";
	
	//回调地址
	public static final String NOTIFY_URL = "wxpay_refund_notify.htm";

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;
	
	/* https证书路径    */
	public static final String certLocalPath = "/data/keys/apiclient_cert_app.p12";///data/keys/apiclient_cert.p12
	
	/* https证书密码 */
	public static final String certPassword = "1347024901";//1239382202
	
	/*退款*///REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
	//REFUND_SOURCE_RECHARGE_FUNDS可用餘額退款
	public static final String refund_acount = "REFUND_SOURCE_RECHARGE_FUNDS";
	//以下是几个API的路径：
	//1）统一支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	//2）被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
	
	public static String HttpsRequestClassName = "com.amall.core.web.pay.tencent.common.HttpsRequest";
	
	public static String HttpRequestClassName = "com.amall.core.web.pay.tencent.common.HttpRequest";

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

}
