package com.amall.core.bean;

import java.io.Serializable;

/**
 * IM user
 * 
 * @author dinglei
 *
 */
public class EasemobUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 当前系统用户ID，必填
	 */
	private Long userId;

	private String username;

	private String nickname;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getusername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
