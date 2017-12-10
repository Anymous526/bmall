package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsProperty implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	//属性的值
    private String proValue;

    private BigDecimal proPrice;//属性价格

    private Long specId;//amall_goodsspec的主键Id，对应GoodsSpec的Id.即对应GoodsSpec实体类中的Id字段，多对一
    
    private Long inventory;//库存

    public Long getInventory() {
		return inventory;
	}

	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProValue() {
        return proValue;
    }

    public void setProValue(String proValue) {
        this.proValue = proValue == null ? null : proValue.trim();
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
    
    private GoodsSpec spec;

	public GoodsSpec getSpec() {
		return spec;
	}

	public void setSpec(GoodsSpec spec) {
		this.spec = spec;
	}
    
    
    
}