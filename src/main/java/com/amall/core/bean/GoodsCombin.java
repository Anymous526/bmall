package com.amall.core.bean;

import java.io.Serializable;

public class GoodsCombin implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long amall_goods_id;
	private Long combin_goods_id;

	public Long getAmall_goods_id() {
		return amall_goods_id;
	}

	public void setAmall_goods_id(Long amall_goods_id) {
		this.amall_goods_id = amall_goods_id;
	}

	public Long getCombin_goods_id() {
		return combin_goods_id;
	}

	public void setCombin_goods_id(Long combin_goods_id) {
		this.combin_goods_id = combin_goods_id;
	}

}
