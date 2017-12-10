package com.amall.core.web.tools;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class PopupAuthenticator extends Authenticator {
	private String username;
	private String password;

	public PopupAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * <p>Title: getPasswordAuthentication</p>
	 * <p>Description: 重新初始化验证器</p>
	 * @return
	 */
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.username, this.password);
	}
}
