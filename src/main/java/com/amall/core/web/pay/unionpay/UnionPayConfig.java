package com.amall.core.web.pay.unionpay;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.unionpay.acp.sdk.HttpClient;
import com.unionpay.acp.sdk.SDKUtil;

/**
 * 重要：联调测试时请仔细阅读注释！
 * 
 * 产品：跳转网关支付产品<br>
 * 交易：退货交易：后台资金类交易，有同步应答和后台通知应答<br>
 * 日期： 2015-09<br>
 * 版本： 1.0.0 版权： 中国银联<br>
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己需要，按照技术文档编写。该代码仅供参考，不提供编码性能规范性等方面的保障<br>
 * 该接口参考文档位置：open.unionpay.com帮助中心 下载 产品接口规范 《网关支付产品接口规范》<br>
 * 《平台接入接口规范-第5部分-附录》（内包含应答码接口规范，全渠道平台银行名称-简码对照表）<br>
 * 测试过程中的如果遇到疑问或问题您可以：1）优先在open平台中查找答案： 调试过程中的问题或其他问题请在
 * https://open.unionpay.com/ajweb/help/faq/list 帮助中心 FAQ 搜索解决方案
 * 测试过程中产生的6位应答码问题疑问请在https://open.unionpay.com/ajweb/help/respCode/respCodeList
 * 输入应答码搜索解决方案 2） 咨询在线人工支持： open.unionpay.com注册一个用户并登陆在右上角点击“在线客服”，咨询人工QQ测试支持。
 * 交易说明：
 * 1）以后台通知或交易状态查询交易（Form_6_5_Query）确定交易成功，建议发起查询交易的机制：可查询N次（不超过6次），每次时间间隔2N秒发起,
 * 即间隔1，2，4，8，16，32S查询（查询到03，04，05继续查询，否则终止查询） 2）退货金额不超过总金额，可以进行多次退货
 * 3）退货能对11个月内的消费做（包括当清算日），支持部分退货或全额退货，到账时间较长，一般1-10个清算日（多数发卡行5天内，但工行可能会10天），
 * 所有银行都支持
 */
public class UnionPayConfig
{
	public static final String ENCODING = "UTF-8";

	public static final String VERSION = "5.0.0";

	/**************************************
	 * 交易类型
	 **************************************/
	public static final String CONSUME_TXNTYPE = "01"; // 消费
	public static final String REFUND_TXNTYPE = "31"; // 消费撤销
	public static final String REFUND_TYPE = "04"; // 退货

	/**************************************
	 * 交易子类型
	 **************************************/
	public static final String REFUND_TXNSUBTYPE = "00"; // 退货
	public static final String SELF_TXNSUBTYPE = "01"; // 自助消费
	public static final String ORDER_TXNSUBTYPE = "02"; // 订购消费
	public static final String INSTALLMENT_TXNSUBTYPE = "03"; // 自助消费

	/**************************************
	 * 业务类型
	 **************************************/
	public static final String E_BANK_PAY_TYPE = "000201"; // 网银支付

	/**************************************
	 * 渠道类型
	 **************************************/
	public static final String PC_CHANNEL_TYPE = "07"; // PC支付
	public static final String MOBILE_PHONE_CHANNEL_TYPE = "08"; // 手机支付

	public static final String PLATFORM_ACCESS_TYPE = "2"; // 平台商户
	public static final String SHOP_ACCESS_TYPE = "0"; // 商户
	public static final String CURRENCY_CODE = "156"; // 交易币种，人民币

	public static final String ALGORITHM = "01";

	public String FRONT_URL; // 前台返回
	public String BACK_URL; // 后台返回
	public String REFUND_BACK_URL; // 退货返回
	public String merId; // 商户号码
	public String txnTime; // 支付时间
	public String txnType; // 交易类型
	public String queryId; // 银行流水号
	public String txnAmt = "1"; // 默认的交易金额,单位为分
	public String reqReserved; // 自定义域
	public String orderId; // 订单号

	public static Properties propertis = new Properties();

	static
	{
		try
		{
			propertis.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("properties/acp_sdk.properties"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * java main方法 数据提交 数据组装进行提交 包含签名
	 * 
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static String submitDate(Map<String, ?> contentData, String requestUrl)
	{
		Map<String, String> submitFromData = (Map<String, String>) signData(contentData);
		return submitUrl(submitFromData, requestUrl);
	}

	/**
	 * @param contentData
	 * @return 签名后的map对象
	 */
	public static Map<String, String> signData(Map<String, ?> contentData)
	{
		Entry<String, String> obj = null;
		Map<String, String> submitFromData = new HashMap<String, String>();
		for (Iterator<?> it = contentData.entrySet().iterator(); it.hasNext();)
		{
			obj = (Entry<String, String>) it.next();
			String value = obj.getValue();
			if (StringUtils.isNotBlank(value))
			{
				submitFromData.put(obj.getKey(), value.trim());
			}
		}
		/**
		 * 签名
		 */
		SDKUtil.sign(submitFromData, ENCODING);

		return submitFromData;
	}
	
	/**
	 * 过滤请求报文中的空字符串或者空字符串
	 * @param contentData
	 * @return
	 */
	public static Map<String, String> filterBlank(Map<String, String> contentData){
	
		Map<String, String> submitFromData = new HashMap<String, String>();
		Set<String> keyset = contentData.keySet();
		
		for(String key:keyset){
			String value = contentData.get(key);
			if (StringUtils.isNotBlank(value)) {
				// 对value值进行去除前后空处理
				submitFromData.put(key, value.trim());
			}
		}
		SDKUtil.sign(submitFromData, ENCODING);
		return submitFromData;
	}

	/**
	 * java main方法 数据提交 提交到后台
	 * 
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static String submitUrl(Map<String, String> submitFromData, String requestUrl)
	{
		String resultString = "";
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try
		{
			int status = hc.send(submitFromData, ENCODING);
			if (200 == status)
			{
				resultString = hc.getResult();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return resultString;
	}

	/**
	 * 构造HTTP POST交易表单的方法示例
	 * 
	 * @param action
	 *            表单提交地址
	 * @param hiddens
	 *            以MAP形式存储的表单键值
	 * @return 构造好的HTTP POST交易表单
	 */
	public static String createHtml(String action, Map<String, String> hiddens)
	{
		StringBuffer sf = new StringBuffer();
		sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>");
		sf.append("<form id = \"pay_form\" action=\"" + action + "\" method=\"post\">");
		if (null != hiddens && 0 != hiddens.size())
		{
			Set<Entry<String, String>> set = hiddens.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while (it.hasNext())
			{
				Entry<String, String> ey = it.next();
				String key = ey.getKey();
				String value = ey.getValue();
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + value + "\"/>");
			}
		}
		sf.append("</form>");
		sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		sf.append("document.all.pay_form.submit();");
		sf.append("</script>");
		sf.append("</html>");
		return sf.toString();
	}
}
