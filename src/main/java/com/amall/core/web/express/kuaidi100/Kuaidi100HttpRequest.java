package com.amall.core.web.express.kuaidi100;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.nutz.json.Json;

public class Kuaidi100HttpRequest {
	
	private Kuaidi100HttpRequest(){}
	
	public static Kuaidi100HttpRequest getInstance()
	{
		return new Kuaidi100HttpRequest();
	}
	
	// 表示请求器是否已经做了初始化工作
	private boolean hasInit = false;

	// 连接超时时间，默认10秒
	private int socketTimeout = 10000;

	// 传输超时时间，默认30秒
	private int connectTimeout = 30000;

	// 请求器的配置
	private RequestConfig requestConfig;

	// HTTP请求器
	private CloseableHttpClient httpClient;
	
	private void init() throws IOException
	{

		httpClient = HttpClients.createDefault();

		// 根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();

		hasInit = true;
	}
	
	public String postData(JsonRequest req, String url) throws Exception {

		if (!hasInit)
		{
			init();
		}
		
		req.getParameters().put(Kuadi100Conifg.getSUBSCRIPTION_URL_NAME(), url + Kuadi100Conifg.getCALLBACK_URL());
		req.setKey(Kuadi100Conifg.getKEY());
		
		HashMap<String, String> p = new HashMap<String, String>(); 
		p.put(Kuadi100Conifg.getSCHEMA_NAME(), Kuadi100Conifg.getSCHEMA());
		p.put(Kuadi100Conifg.getPARAM_NAME(), Json.toJson(req));
		
		HttpPost httpPost = new HttpPost(Kuadi100Conifg.getSUBSCRIPTION_URL());
		// 设置请求器的配置
		httpPost.setConfig(requestConfig);
		httpPost.setEntity(new UrlEncodedFormEntity(assembleRequestParams(p), Kuadi100Conifg.getCHARACTER_UTF8()));
		
		String result = "";
		try {
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, Kuadi100Conifg.getCHARACTER_UTF8());
		} catch (Exception e) {
			throw e;
		} 
		return result;
	}

	/**
	 * 组装http请求参数
	 * 
	 * @param params
	 * @param menthod
	 * @return
	 */
	private List<NameValuePair> assembleRequestParams(Map<String, String> data) {
		List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();

		Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			nameValueList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
		}

		return nameValueList;
	}

}
