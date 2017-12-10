package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsSpec implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String specName;//规格名字

    private Long goodsId;//商品Id
    
    private BigDecimal goodsPrice;

    private Integer goodsRepository;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    
    private Goods goods;
    
    private List<GoodsProperty> properties = new ArrayList<GoodsProperty>();

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<GoodsProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsProperty> properties) {
		this.properties = properties;
	}

	public BigDecimal getGoodsPrice()
	{
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice)
	{
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsRepository()
	{
		return goodsRepository;
	}

	public void setGoodsRepository(Integer goodsRepository)
	{
		this.goodsRepository = goodsRepository;
	}
    
    
}