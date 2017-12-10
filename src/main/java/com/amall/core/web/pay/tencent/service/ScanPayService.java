package com.amall.core.web.pay.tencent.service;

import com.amall.core.web.pay.tencent.common.Configure;
import com.amall.core.web.pay.tencent.protocol.pay_protocol.ScanPayReqData;

/**
 * @author tangxiang
 *
 */
public class ScanPayService extends BaseService{ 
    public ScanPayService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.PAY_API);
    }

    /**
     * 请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(Object scanPayReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTP的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(scanPayReqData);

        return responseString;
    }
}
