package com.amall.core.im.api.impl;

import com.amall.core.im.api.EasemobRestAPI;
import com.amall.core.im.api.SendMessageAPI;
import com.amall.core.im.comm.constant.HTTPMethod;
import com.amall.core.im.comm.helper.HeaderHelper;
import com.amall.core.im.comm.wrapper.BodyWrapper;
import com.amall.core.im.comm.wrapper.HeaderWrapper;

public class EasemobSendMessage extends EasemobRestAPI implements SendMessageAPI {
    private static final String ROOT_URI = "/messages";

    @Override
    public String getResourceRootURI() {
        return ROOT_URI;
    }

    public Object sendMessage(Object payload) {
        String  url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = HeaderHelper.getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
    }
}
