package com.amall.core.web.pay.tencent.protocol.pay_protocol;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.amall.core.web.pay.tencent.common.Configure;
import com.amall.core.web.pay.tencent.common.RandomStringGenerator;
import com.amall.core.web.pay.tencent.common.Signature;

/**
 * 请求被扫支付API需要提交的数据
 */
public class ScanPrePayReqData {

    private String prepay_id = "";
    private String return_code = "SUCCESS";
    private String result_code = "SUCCESS";

    public ScanPrePayReqData(String prepay_id){
        
        //微信预交易ID
        setPrepay_id(prepay_id);
        

    }

    public String getPrepay_id()
   	{
   		return prepay_id;
   	}


   	public void setPrepay_id(String prepay_id)
   	{
   		this.prepay_id = prepay_id;
   	}
  

	public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
