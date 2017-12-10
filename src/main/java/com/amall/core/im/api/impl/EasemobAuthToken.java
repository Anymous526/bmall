package com.amall.core.im.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amall.core.im.api.AuthTokenAPI;
import com.amall.core.im.api.EasemobRestAPI;
import com.amall.core.im.comm.wrapper.BodyWrapper;
import com.amall.core.im.comm.constant.HTTPMethod;
import com.amall.core.im.comm.helper.HeaderHelper;
import com.amall.core.im.comm.wrapper.HeaderWrapper;
import com.amall.core.im.comm.body.AuthTokenBody;

public class EasemobAuthToken extends EasemobRestAPI implements AuthTokenAPI{
	
	public static final String ROOT_URI = "/token";
	
	private static final Logger log = LoggerFactory.getLogger(EasemobAuthToken.class);
	
	@Override
	public String getResourceRootURI() {
		return ROOT_URI;
	}

	public Object getAuthToken(String clientId, String clientSecret) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
		BodyWrapper body = new AuthTokenBody(clientId, clientSecret);
		HeaderWrapper header = HeaderHelper.getDefaultHeader();
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
	}
}
