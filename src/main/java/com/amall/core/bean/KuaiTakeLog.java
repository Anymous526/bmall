package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class KuaiTakeLog implements Serializable {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private String kuaidinum;

    private String company;

    private String state;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKuaidinum() {
        return kuaidinum;
    }

    public void setKuaidinum(String kuaidinum) {
        this.kuaidinum = kuaidinum == null ? null : kuaidinum.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}