package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车条目表，购物车里面的所有商品信息
 * @author tangxiang
 *
 */
public class CartDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    /**
     * UUID码购物车编号
     */
    private String goodsCartId;

    /**
     * 商品类型，如衣服
     */
    private String type;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 完成商品交易后该状态就为true,这时就该删除该条信息
     */
    private Boolean deleteStatus;

    private Date addTime;

    /**
     * 是否直接购买,false表示是 加购物车  true 表示直接购买
     */
    private Boolean directBuy;

    /**
     * 商品描述，如21寸，蓝色灯
     */
    private String specInfo;

    private Long userId;
    
    /**
     * 商品的具体属性值 , 来获取商品的动态价格
     */
    private String specId;//GoodsProperty的id字段的集合。使用,分隔。对应amall_goods_property中的id，用","分隔连在一起
    
    /**
     * 表示amall_goods_cart这个表的主键Id字段
     * 即Cart类的Id
     */
    private Long cartId;
    
    List<GoodsProperty> properties = new ArrayList<GoodsProperty>();
    
    public List<GoodsProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsProperty> properties) {
		this.properties = properties;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getGoodsCartId() {
        return goodsCartId;
    }

    public void setGoodsCartId(String goodsCartId) {
        this.goodsCartId = goodsCartId == null ? null : goodsCartId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Boolean getDirectBuy() {
        return directBuy;
    }

    public void setDirectBuy(Boolean directBuy) {
        this.directBuy = directBuy;
    }

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo == null ? null : specInfo.trim();
    }
    
    public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}







	/*
     * 与商品一对一
     */
    private GoodsWithBLOBs goods;

	public GoodsWithBLOBs getGoods() {
		return goods;
	}

	public void setGoods(GoodsWithBLOBs goods) {
		this.goods = goods;
	}
    
    
    
    
}