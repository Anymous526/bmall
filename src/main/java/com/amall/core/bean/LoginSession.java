package com.amall.core.bean;

import java.io.Serializable;

public class LoginSession implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private String username;

    private String systemType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }
}