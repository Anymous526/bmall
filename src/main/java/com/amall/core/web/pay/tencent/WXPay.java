package com.amall.core.web.pay.tencent;

import java.util.HashMap;
import java.util.Map;

import com.amall.core.web.pay.tencent.business.DownloadBillBusiness;
import com.amall.core.web.pay.tencent.business.RefundBusiness;
import com.amall.core.web.pay.tencent.business.RefundQueryBusiness;
import com.amall.core.web.pay.tencent.business.ScanPayBusiness;
import com.amall.core.web.pay.tencent.common.Configure;
import com.amall.core.web.pay.tencent.common.Signature;
import com.amall.core.web.pay.tencent.protocol.downloadbill_protocol.DownloadBillReqData;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayReqData;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayResData;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPrePayReqData;
import com.amall.core.web.pay.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.amall.core.web.pay.tencent.protocol.refund_protocol.RefundReqData;
import com.amall.core.web.pay.tencent.protocol.refund_query_protocol.RefundQueryReqData;
import com.amall.core.web.pay.tencent.protocol.reverse_protocol.ReverseReqData;
import com.amall.core.web.pay.tencent.service.*;

/**
 * SDK总入口
 */
public abstract class WXPay {

    /**
     * 请求支付服务
     * @param ScanPrePayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public static String requestScanPayService(ScanPayReqData payReqData) throws Exception{
        return new ScanPayService().request(payReqData);
    }

    /**
     * 请求支付服务
     * @param ScanPayResData 通知微信已经收到了信息
     * @return API返回的数据
     * @throws Exception
     */
    public static String returnMsgToService(ScanPayResData payReqData) throws Exception
    {
    	return new ScanPayService().request(payReqData);
    }
    
    /**
     * 请求支付查询服务
     * @param scanPayQueryReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
	public static String requestScanPayQueryService(ScanPayQueryReqData scanPayQueryReqData) throws Exception{
		return new ScanPayQueryService().request(scanPayQueryReqData);
	}

    /**
     * 请求退款服务
     * @param refundReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public static String requestRefundService(RefundReqData refundReqData) throws Exception{
        return new RefundService().request(refundReqData);
    }
    
    /**
     * 请求退款服务APP
     * @param refundReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public static String requestRefundServiceApp(RefundReqData refundReqData) throws Exception{
        return new RefundServiceApp().request(refundReqData);
    }

    /**
     * 请求退款查询服务
     * @param refundQueryReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
	public static String requestRefundQueryService(RefundQueryReqData refundQueryReqData) throws Exception{
		return new RefundQueryService().request(refundQueryReqData);
	}

    /**
     * 请求撤销服务
     * @param reverseReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
	public static String requestReverseService(ReverseReqData reverseReqData) throws Exception{
		return new ReverseService().request(reverseReqData);
	}

    /**
     * 请求对账单下载服务
     * @param downloadBillReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public static String requestDownloadBillService(DownloadBillReqData downloadBillReqData) throws Exception{
        return new DownloadBillService().request(downloadBillReqData);
    }

    /**
     * 直接执行被扫支付业务逻辑（包含最佳实践流程）
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @param resultListener 商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
     * @throws Exception
     */
    public static void doScanPayBusiness(ScanPayReqData scanPayReqData, ScanPayBusiness.ResultListener resultListener) throws Exception {
        new ScanPayBusiness().run(scanPayReqData, resultListener);
    }

    /**
     * 调用退款业务逻辑
     * @param refundReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @param resultListener 业务逻辑可能走到的结果分支，需要商户处理
     * @throws Exception
     */
    public static void doRefundBusiness(RefundReqData refundReqData, RefundBusiness.ResultListener resultListener) throws Exception {
        new RefundBusiness().run(refundReqData,resultListener);
    }

    /**
     * 运行退款查询的业务逻辑
     * @param refundQueryReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @param resultListener 商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
     * @throws Exception
     */
    public static void doRefundQueryBusiness(RefundQueryReqData refundQueryReqData,RefundQueryBusiness.ResultListener resultListener) throws Exception {
        new RefundQueryBusiness().run(refundQueryReqData,resultListener);
    }

    /**
     * 请求对账单下载服务
     * @param downloadBillReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @param resultListener 商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
     * @return API返回的XML数据
     * @throws Exception
     */
    public static void doDownloadBillBusiness(DownloadBillReqData downloadBillReqData,DownloadBillBusiness.ResultListener resultListener) throws Exception {
        new DownloadBillBusiness().run(downloadBillReqData,resultListener);
    }


    /** 
    * @Title: sign 
    * @Description: 二维码信息签名
    * @param nonce_str
    * @param time_stamp
    * @param product_id
    * @return
    * @throws 
    * @author tangxiang
    * @date 2015年12月2日
    */
    public static String sign(String nonce_str, String time_stamp, String product_id)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("appid", Configure.APP_ID);
		map.put("mch_id", Configure.MCH_ID);
		map.put("nonce_str", nonce_str);
		map.put("product_id", product_id);
		map.put("time_stamp", time_stamp);
		
		return Signature.getSign(map);
	}
}
