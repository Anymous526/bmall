package com.amall.core.im.comm.body;

import com.amall.core.im.comm.constant.MsgType;
import com.fasterxml.jackson.databind.node.ContainerNode;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class TextMessageBody extends MessageBody {
	private String msg;

	/**
	 * 扩展属性，由app自己定义。可以没有这个字段，但是如果有，值不能是“ext:null“这种形式，否则出错。
	 * 
	 * @param targetType
	 * @param targets
	 * @param from
	 * @param ext
	 * @param msg
	 */
	public TextMessageBody(String targetType, String[] targets, String from,
			Map<String, String> ext, String msg) {
		super(targetType, targets, from, ext);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public ContainerNode<?> getBody() {
		if (!isInit()) {
			this.getMsgBody().put("type", MsgType.TEXT);
			this.getMsgBody().put("msg", msg);
			this.setInit(true);
		}

		return this.getMsgBody();
	}

	public Boolean validate() {
		return super.validate() && StringUtils.isNotBlank(msg);
	}
}
