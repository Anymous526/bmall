package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class GoodsReturnItem implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer count;

    private Long goodsId;

    private Long grId;

    private String specInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGrId() {
        return grId;
    }

    public void setGrId(Long grId) {
        this.grId = grId;
    }

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo == null ? null : specInfo.trim();
    }
    
    
    
    
    private GoodsReturn gr;
    
    private Goods goods;
    
    private List<GoodsSpecProperty> gsps = new ArrayList<GoodsSpecProperty>();
    
    private List<GoodsProperty> properties=new ArrayList<GoodsProperty>();

	public GoodsReturn getGr() {
		return gr;
	}

	public void setGr(GoodsReturn gr) {
		this.gr = gr;
		if(gr!=null)
		{
			this.setGrId(gr.getId());
		}
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
		if(goods!=null)
		{
			this.setGoodsId(goods.getId());
		}
	}

	public List<GoodsSpecProperty> getGsps() {
		return gsps;
	}

	public void setGsps(List<GoodsSpecProperty> gsps) {
		this.gsps = gsps;
	}

	public List<GoodsProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsProperty> properties) {
		this.properties = properties;
	}
    
    
}