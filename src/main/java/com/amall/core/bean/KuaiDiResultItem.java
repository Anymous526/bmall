package com.amall.core.bean;

import java.io.Serializable;

public class KuaiDiResultItem implements Serializable {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private String kuaidinum;

    private String context;

    private String time;

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
		this.kuaidinum = kuaidinum;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

   
}