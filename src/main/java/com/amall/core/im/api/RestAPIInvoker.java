package com.amall.core.im.api;

import com.amall.core.im.comm.wrapper.BodyWrapper;
import com.amall.core.im.comm.wrapper.HeaderWrapper;
import com.amall.core.im.comm.wrapper.QueryWrapper;
import com.amall.core.im.comm.wrapper.ResponseWrapper;

import java.io.File;

public interface RestAPIInvoker {
	ResponseWrapper sendRequest(String method, String url, HeaderWrapper header, BodyWrapper body, QueryWrapper query);
	ResponseWrapper uploadFile(String url, HeaderWrapper header, File file);
    ResponseWrapper downloadFile(String url, HeaderWrapper header, QueryWrapper query);
}
