package com.amall.core.web.tools.sms;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tangxiang
 *
 */
public class HttpRequest
{

	public interface ResultListener
	{

		public void onConnectionPoolTimeoutError();

	}

	private static Logger log = Logger.getLogger(HttpRequest.class);

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

	public HttpRequest() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException, IOException
	{
		init();
	}

	private void init() throws IOException
	{

		httpClient = HttpClients.createDefault();

		// 根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();

		hasInit = true;
	}

	/**
	 * 通过Http post json数据
	 *
	 * @param url
	 *            API地址
	 * @param vo
	 *            要提交的vo数据对象
	 * @return API回包的实际数据
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */

	public String sendGet(String url, Map<String, Object> map) throws IOException, KeyStoreException,
			UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException
	{

		if (!hasInit)
		{
			init();
		}

		String result = null;

		// 得指明使用UTF-8编码，否则到服务器的中文不能被成功识别
		List<NameValuePair> params = new ArrayList<>();

		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			if (!"".equals(entry.getValue()))
			{
				params.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
			}
		}

		String requestStr = url + URLEncodedUtils.format(params, HTTP.UTF_8);

		System.out.println(requestStr);

		HttpGet httpGet = new HttpGet(requestStr);

		// 设置请求器的配置
		httpGet.setConfig(requestConfig);

		log.debug("executing request" + httpGet.getRequestLine());

		try
		{
			HttpResponse response = httpClient.execute(httpGet);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

		} catch (ConnectionPoolTimeoutException e)
		{
			log.error("http get throw ConnectionPoolTimeoutException(wait time out)");

		} catch (ConnectTimeoutException e)
		{
			log.error("http get throw ConnectTimeoutException");

		} catch (SocketTimeoutException e)
		{
			log.error("http get throw SocketTimeoutException");

		} catch (Exception e)
		{
			log.error("http get throw Exception");

		} finally
		{
			httpGet.abort();
		}

		return result;
	}

	public String sendPost(String url, Map<String, Object> map) throws IOException, KeyStoreException,
			UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException
	{

		if (!hasInit)
		{
			init();
		}

		String result = null;

		// 得指明使用UTF-8编码，否则到服务器的中文不能被成功识别
		List<NameValuePair> params = new ArrayList<>();

		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			if (!"".equals(entry.getValue()))
			{
				params.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
			}
		}

		HttpPost httpPost = new HttpPost(url);
		
		// 设置请求器的配置
		httpPost.setConfig(requestConfig);
		httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

		log.debug("executing request" + httpPost.getRequestLine());

		try
		{
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

		} catch (ConnectionPoolTimeoutException e)
		{
			log.error("http get throw ConnectionPoolTimeoutException(wait time out)");

		} catch (ConnectTimeoutException e)
		{
			log.error("http get throw ConnectTimeoutException");

		} catch (SocketTimeoutException e)
		{
			log.error("http get throw SocketTimeoutException");

		} catch (Exception e)
		{
			log.error("http get throw Exception");

		} finally
		{
			httpPost.abort();
		}

		return result;
	}

	/**
	 * 设置连接超时时间
	 *
	 * @param socketTimeout
	 *            连接时长，默认10秒
	 */
	public void setSocketTimeout(int newSocketTimeout)
	{
		socketTimeout = newSocketTimeout;
		resetRequestConfig();
	}

	/**
	 * 设置传输超时时间
	 *
	 * @param connectTimeout
	 *            传输时长，默认30秒
	 */
	public void setConnectTimeout(int newConnectTimeout)
	{
		connectTimeout = newConnectTimeout;
		resetRequestConfig();
	}

	private void resetRequestConfig()
	{
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();
	}

	/**
	 * 允许做更高级更复杂的请求器配置
	 *
	 * @param requestConfig
	 *            设置HttpsRequest的请求器配置
	 */
	public void setRequestConfig(RequestConfig newRequestConfig)
	{
		requestConfig = newRequestConfig;
	}
}
