package com.amall.core.web.express.kuaidi100;

import java.util.HashMap;

import org.nutz.json.Json;

public class PostOrder {

	public static void main(String[] args){
		JsonRequest req = new JsonRequest();
		req.setCompany("yuantong");
		req.setFrom("广东省东莞市");
		req.setTo("北京市海淀区");
		req.setNumber("700074134800");
		try {
			String ret = Kuaidi100HttpRequest.getInstance().postData(req, null);
			System.out.println(ret);
			JsonResponse resp = Json.fromJson(JsonResponse.class, ret);
			if(resp.getResult()==true){
				System.out.println("订阅成功");
			}else{
				System.out.println("订阅失败");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
