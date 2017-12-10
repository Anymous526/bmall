package com.amall.common.constant;

import java.math.BigDecimal;

/**
 * 
 * <p>Title: Globals</p>
 * <p>Description: 网站全局固定参数</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午5:13:15
 * @version 1.0
 */
public class Globals {
	public static final String DEFAULT_SYSTEM_TITLE = "Amall多用户精品商城系统";
	public static final String GOODS_CART_ID_NAME = "amall_shop_cart";
	public static final String COOKIE_KEY_NAME = "amall_username";//保存在cookie中的name
	public static final boolean SSO_SIGN = true;
	public static final int DEFAULT_SHOP_VERSION = 20140301;
	public static final String DEFAULT_SHOP_OUT_VERSION = "V1.0";
	public static final String DEFAULT_WBESITE_NAME = "AMALL";
	public static final String DEFAULT_CLOSE_REASON = "系统维护中...";
	public static final String DEFAULT_THEME = "default";
	public static final String DERAULT_USER_TEMPLATE = "user_templates";
	public static final String UPLOAD_FILE_PATH = "upload";
	public static final String UPLOAD_ROOT_FILE_PATH = "/data/uploadfiles/amall/";
	public static final String DEFAULT_SYSTEM_LANGUAGE = "zh_cn";
	public static final String DEFAULT_SYSTEM_PAGE_ROOT = "WEB-INF/templates/";
	public static final String SYSTEM_MANAGE_PAGE_PATH = "WEB-INF/templates/zh_cn/system/";
	public static final String SYSTEM_FORNT_PAGE_PATH = "WEB-INF/templates/zh_cn/shop/";
	public static final String SYSTEM_DATA_BACKUP_PATH = "data";
	public static final String SMS_VERIFICATION_CODE = "1";
	public static final int ANGEL_COIN_EXCHANGE_INTEGRAL = 1000; //1000积分兑换一个礼品金
	public static final String RETURN_FALSE = "0";
	public static final String RETURN_TRUE = "1";
	public static final String RETURN_NULL = "0";
	public static final Long RETURN_FAIL = -1l;
	public static final String NULL_PHONE = "0";
	public static final String EXIST_PHONE = "1";
	public static final String Exceed_MAX_NUMBER = "2";
	public static final String IN_INTERVAL = "3";
	public static final String SEND_SMS_ERROR = "4";
	public static final String SEND_SMS_SUCCESSFULLY = "5";
	public static final String SEND_PHONE_IS_NULL = "6";
	public static final String SEND_SMS = "sms";
	public static final String SMS_CODE = "sms_code";
	public static final String SMS_CODE_TIME = "sms_send_time";
	public static final Boolean SYSTEM_UPDATE = Boolean.valueOf(true);
	public static final boolean SAVE_LOG = false;
	public static final String SECURITY_CODE_TYPE = "normal";
	public static final boolean STORE_ALLOW = true;
	public static final boolean EAMIL_ENABLE = true;
	public static final String DEFAULT_IMAGESAVETYPE = "sidImg";
	public static final int DEFAULT_IMAGE_SIZE = 1024;
	public static final int REG_ANGEL_COIN = 10;
	public static final int SHARE_ANGEL_COIN = 3;
	public static final BigDecimal Store_LEE_PRICE = new BigDecimal(0.125);
	public static final int PROMOTE_RANK = 5; //推广的前多少名
    public static final String PROMOTE_RANK_RATE = "0.05"; //推广的前多少名
	
    public static final Double DOU_RATE = 0.1; //出售感恩豆比例
	public static final BigDecimal AMALL_RATE = new BigDecimal(0.9); //卖出感恩豆公司抽取百分之10手续费，卖家收入百分之90；
	
	public static final BigDecimal COMMON_BENIFIT_RATE = new BigDecimal("0.2"); //普通商品分红比例
	public static final BigDecimal SPECIAL_BENIFIT_RATE = new BigDecimal("0.5"); //特卖商品分红比例，已废弃
	
	/* session 相关变量 */
	public static final int SESSION_EXCEED = 3600; //session失效时间
	
	public static final String DEFAULT_IMAGE_SUFFIX = "gif|jpg|jpeg|bmp|png|tbi";
	public static final int NUBER_ONE = 1; //数字1
	public static final int NUBER_TWO = 2; //数字2
	public static final int NUBER_THREE = 3; //数字3
	public static final int NUBER_FOUR = 4; //数字4
	public static final int NUBER_FIVE = 5; //数字5
	public static final int NUBER_SEVEN = 7; //数字4
	public static final int NUBER_FIFTY = 50; //数字50
	public static final int COOKIE_MAX_NUMBER = 5; //购物车最大购买商品数量
	public static final int MILLISECOND_TO_SECOND = 1000; // 毫秒转换成秒
	public static final int SECOND_TO_MINUTE = 60; // 秒转换成分
	public static final int NUBER_ZERO = 0; //数字0
	public static final int NUBER_ORDER_MAX = 9999; // 订单流水最大数
	public static final int PHONE_LENGTH = 11; //手机号码长度
	public static final int DEFAULT_IMAGE_SMALL_WIDTH = 160; //图片默认最小宽度
	public static final int DEFAULT_IMAGE_SMALL_HEIGH = 160; //图片默认最小高度
	public static final int DEFAULT_IMAGE_MIDDLE_WIDTH = 300; //图片默认中等宽度
	public static final int DEFAULT_IMAGE_MIDDLE_HEIGH = 300; //图片默认中等高度
	public static final int DEFAULT_IMAGE_BIG_WIDTH = 1024;  //图片默认最大宽度
	public static final int DEFAULT_IMAGE_BIG_HEIGH = 1024; //图片默认最大高度
	public static final int DEFAULT_COMPLAINT_TIME = 30;
	public static final int HOUR = 60 * 60;   //一小时
	public static final int DAY = 1;  //一天
	public static final int MONTH = 30;   //一月
	public static final int YEAR = 365;   //一年
	public static final int HALF_MONTH = 15;   //半月
	public static final int WEEK = 7;   //一周
	public static final String DEFAULT_TABLE_SUFFIX = "amall_";  //默认的表前缀
	public static final String THIRD_ACCOUNT_LOGIN = "amall_thid_login_";//xxshop_thid_login_
	public static final String DEFAULT_SMS_URL = "http://service.winic.org/sys_port/gateway/";
	public static final String DEFAULT_BIND_DOMAIN_CODE = "126A11D4BB76663E85078487393AB64897B9DCE99C5934CD589CFE4E769668CB";
	public static final int shareGold = 5; //分享人分享成功增加的礼品金
	public static final int inDirectShareGold = 5; //分享人分享成功，该分享人的直接推荐人增加的礼品金
	public static final int beshareGold = 5;//分享注册新增加的礼品金
	public static final Integer FinancialGold = 12000;//感恩金
	public static final Integer FinancialGoldFIVE = 3000;	//感恩金
	/* 商品详情展示框大小350 x 350 */
	public static final int FRAME_WIDTH = 350;
	public static final int FRAME_HEIGHT = 350;
	
	/* 推广人数配置 */
	public static final int V1_PROMOTION  = 10;
	
	/*商家子账号类型,PC,android,ios 子账号的资源权限模块不同 */
	public static final String SELLER_ACCOUNT_TYPE_PC = "PC";
	public static final String SELLER_ACCOUNT_TYPE_ANDROID = "ANDROID";
	public static final String SELLER_ACCOUNT_TYPE_IOS = "IOS";
	//一个商家最多有5个子账号
	public static final int SELLER_ACCOUNT_COUNT = 5;
	
	public static final long user_verify_success = 1;//实名认证审核成功
	public static final long user_verify_fail = 0;//实名认证审核不通过
	public static final long user_verify_prepare = -1;//实名认证待审核
	
	public static final int ACTIVE_VIP_2_AMOUNT = 3000; //V2升级,网络技术服务费
	
	public static final int EXCEED_ORDER = HOUR * 24; //订单过期时间
	public static final int EXCEED_NEWORDER = HOUR * 360; //新订单过期时间
	
	//普通会员分享链接
	public static final String vipshareurl_pre = "http://www.amall196.amall.com";  
	
	//WAP普通会员分享链接
	public static final String wapvipshareurl_pre = "http://m196.amall.com";  
	
	//会员申请链接
	public static final String partnerurl_pre = "http://partner196.amall.com";  
	
	public static final String NOT_NICK_NAME="亲，您还未设置昵称！";
	
	public static final String NOT_TRUE_NAME="亲，您还未设置真实姓名！";
	
	
	/**
	 * 感恩金比例
	 */									
	
	public static final String FINANCIAL_GOLD_RATE_TWO ="0.2"; 
	public static final String FINANCIAL_GOLD_RATE_THREE ="0.3";
	public static final String FINANCIAL_GOLD_RATE_FOUR ="0.4";
	public static final String FINANCIAL_GOLD_RATE_FIVE ="0.5";
	
	
	/**
	 *商品状态
	 */
	public static final int GOODS_SELLING= 0; //出售中
	public static final int GOODS_COMMON_SHELVE= 1; //普通下架
	public static final int  GOODS_VIOLATION_SHELVE= -2; //违规下架
	public static final int GOODS_AUDIT_NOTPASS = 3; //未通过审核
	public static final int GOODS_WAIT_AUDIT = 4; //待审核
	
	
	
	/********************订单类型***********************/
	
	/**
	 * O2O创富订单
	 */
	public static final String ORDER_TYPE_O2O="2000";
	
	
	/**********************************************************
	 * 订单状态
	 **********************************************************/
	/**
	 * orders have been canceled 订单已经取消
	 */
	public static final int CANCELLED_ORDER = 0; 
	public static final String CANCELLED_ORDER_NAME = "订单已经取消";
	
	/**
	 * Waiting for payment 等待支付
	 */
	public static final int WAIT_PAYMENT_ORDER = 10;
	public static final String WAIT_PAYMENT_ORDER_NAME = "等待支付";
	/**
	 * 线下支付待审核
	 */
	public static final int PEND_PAYMENT_OF_OFF_LINE = 15;
	public static final String PEND_PAYMENT_OF_OFF_LINE_NAME = "线下支付待审核";
	/**
	 * 货到付款待发货
	 */
	public static final int SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD = 16;
	public static final String SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD_NAME = "货到付款待发货";
	/**
	 * hava payment 已付款
	 */
	public static final int HAVE_PAYMENT = 20;
	public static final String HAVE_PAYMENT_NAME = "已付款";
	/**
	 * hava send out good 已发货
	 */
	public static final int HAVE_SEND_OUT_GOOD = 30;
	public static final String HAVE_SEND_OUT_GOOD_NAME = "已发货";
	/**
	 * good have been received 已收货
	 */
	public static final int HAVE_RECEIVED_GOOD = 40;
	public static final String HAVE_RECEIVED_GOOD_NAME = "已收货";
	
	/**
	 * Waiting for refund 等待退款
	 */
	public static final int WAIT_REFUND = 41;
	public static final String WAIT_REFUND_NAME = "等待退款";
	
	/**
	 * 卖家同意申请退款
	 */
	public static final int OK_HAVE_RECEIVED_MOENY = 42;
	public static final String OK_HAVE_RECEIVED_MOENY_NAME = "卖家同意申请退款";
	
	/**
	 * 卖家拒绝申请退款
	 */
	public static final int NO_HAVE_RECEIVED_MOENY = 43;
	public static final String NO_HAVE_RECEIVED_MOENY_NAME = "卖家拒绝申请退款";
	
	/**
	 * 买家申请退款
	 */
	public static final int HAVE_RECEIVED_MOENY = 44;
	public static final String HAVE_RECEIVED_MOENY_NAME = "买家申请退款";
	
	/**
	 * buyer apply for return good 买家申请退货
	 */
	public static final int BUYER_APPLY_RETURN_GOOD = 45;
	public static final String BUYER_APPLY_RETURN_GOOD_NAME = "买家申请退货";
	/**
	 * returning good 退货中
	 */
	public static final int RETURN_GOOD = 46;
	public static final String RETURN_GOOD_NAME = "卖家同意退货";
	/**
	 * end of return good 退货结束
	 */
	public static final int RETURN_GOOD_END = 47;
	public static final String RETURN_GOOD_END_NAME = "退货结束";
	/**
	 * seller refuse return good 卖家拒绝退货
	 */
	public static final int SELLER_REFUSE_RETURN_GOOD = 48;
	public static final String SELLER_REFUSE_RETURN_GOOD_NAME = "卖家拒绝退货";
	/**
	 * return good fail 退货失败
	 */
	public static final int RETURN_GOODS_FAIL = 49;
	public static final String RETURN_GOODS_FAIL_NAME = "退货失败";
	/**
	 * It has been completed and have been evaluated 已经完成订单，已评价
	 */
	public static final int COMPLETED_AND_EVALUATED = 50;
	public static final String COMPLETED_AND_EVALUATED_NAME = "已经完成订单, 已评价";
	
	/**
	 * have refund 已退款
	 */
	public static final int HAVE_REFUND = 51;
	public static final String HAVE_REFUND_NAME = "已退款";
	/**
	 * finish 结束
	 */
	public static final int FINISH = 60;
	public static final String FINISH_NAME = "结束";
	/**
	 * finish and can not be evaluated 结束，不能评价
	 */
	public static final int FINISH_AND_NOT_EVALUATED = 65;
	public static final String FINISH_AND_NOT_EVALUATED_NAME = "结束, 不能评价";

	/**
	 * 不可退货
	 */
	public static final int REFUND_SERVER_TIME_0 = 100;
	public static final String REFUND_SERVER_TIME_NO_NAME = "不可退货";
	
	/**
	 * 7天可退货
	 */
	public static final int REFUND_SERVER_TIME_7 = 101;
	public static final String REFUND_SERVER_TIME_7_NAME = "7天售后期";
	
	/**
	 * 15天可退货
	 */
	public static final int REFUND_SERVER_TIME_15 = 102;
	public static final String REFUND_SERVER_TIME_102_NAME = "15天售后期";
	
	/**
	 * 30天可退货
	 */
	public static final int REFUND_SERVER_TIME_30 = 103;
	public static final String REFUND_SERVER_TIME_30_NAME = "30天售后期";
	
	/**
	 * 卖家申请退款
	 */
	public static final int APPLY_REFUND_SELLER = 0;
	
	/**
	 * 卖家申请退款,退款成功
	 */
	public static final int APPLY_REFUND_SELLER_SUCCEED = 1;
	
	/**
	 * 卖家申请退款,退款失败
	 */
	public static final int APPLY_REFUND_SELLER_FAIL = 2;
	
	/**
	 * 推送消息最大字符限制
	 */
	public static final int PUSH_MESSAGE_MAX_NUMBER = 400;
	
	/**
	 * 消费商推荐超级赠送感恩金
	 */
	public static final int financialGoldOne = 1000;

}
