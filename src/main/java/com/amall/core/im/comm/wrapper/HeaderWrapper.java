package com.amall.core.im.comm.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HeaderWrapper {

	private static final String HEADER_CONTENT_TYPE = "Content-Type";

	private static final String HEADER_AUTH = "Authorization";

	private static final String RESTRICT_ACCESS = "restrict-access";

	private static final String THUMBNAIL = "thumbnail";

	private static final String SHARE_SECRET = "share-secret";

	private static final String ACCEPT = "Accept";

	// NameValuePair 简单名称对应值数据集合 。用于Post 请求较多
	private List<NameValuePair> headers = new ArrayList<NameValuePair>();

	public static HeaderWrapper newInstance() {
		return new HeaderWrapper();
	}

	public HeaderWrapper addHeader(String key, String value) {
		if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
			return this;
		}

		headers.add(new BasicNameValuePair(key, value));
		return this;
	}

	public HeaderWrapper addJsonContentHeader() {
		return addHeader(HEADER_CONTENT_TYPE, MediaType.APPLICATION_JSON);
	}

	/**
	 * tonken 添加
	 * 
	 * @param token
	 * @return
	 */
	public HeaderWrapper addAuthorization(String token) {
		return addHeader(HEADER_AUTH, "Bearer " + token);
	}

	/**
	 * 访问限制添加
	 * 
	 * @return
	 */
	public HeaderWrapper addRestrictAccess() {
		return addHeader(RESTRICT_ACCESS, "true");
	}

	/**
	 * 缩略图限制
	 * 
	 * @return
	 */
	public HeaderWrapper addThumbnail() {
		return addHeader(THUMBNAIL, "true");
	}

	/**
	 * 共享
	 * 
	 * @param secret
	 * @return
	 */
	public HeaderWrapper addShareSecret(String secret) {
		return addHeader(SHARE_SECRET, secret);
	}

	/**
	 * 设置接受流类型
	 * 
	 * @return
	 */
	public HeaderWrapper addMediaAccept() {
		return addHeader(ACCEPT, "application/octet-stream");
	}

	public List<NameValuePair> getHeaders() {
		return headers;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (NameValuePair header : headers) {
			sb.append("[").append(header.getName()).append(":")
					.append(header.getValue()).append("] ");
		}

		return sb.toString();
	}

}
