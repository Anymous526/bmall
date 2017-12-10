package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 积分商品信息
 * @author ljx
 *
 */
public class IntegralGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date igBeginTime;		//积分商品兑换开始时间

    private Integer igClickCount; 	//浏览数

    private String igContent;	//礼品描述
    
    private String igPackList; //礼品包装清单

	private Date igEndTime;		//积分商品兑换结束时间

    private Integer igExchangeCount;  	//已兑换数量

    private Integer igGoodsCount;     //库存数

    private Integer igGoodsIntegral;  //兑换积分

    private String igGoodsName;		//积分商品名称

    private BigDecimal igGoodsPrice;  //礼品原价

    private String igGoodsSn;   //礼品编号

    private String igGoodsTag;		//礼品标签

    private Integer igLimitCount;		//每位会员兑换数量

    private Boolean igLimitType;		//是否限制会员兑换数量

    private Boolean igRecommend;		//是否推荐

    private String igSeoDescription;	//SEO描述

    private String igSeoKeywords;		//SEO关键字

    private Integer igSequence;		//礼品排序

    private Boolean igShow;   //是否上架

    private Boolean igTimeType;		//是否闲置时间

    private BigDecimal igTransfee;	//运费价格

    private Integer igTransfeeType;	//运费承担方式   ：买家 或 卖家

    private Long igGoodsImgId;		//礼品图片外键id
    
    private Long igGcId;    //对应GoodsClassWithBLOBs的id

    public Long getIgGcId() {
		return igGcId;
	}

	public void setIgGcId(Long igGcId) {
		this.igGcId = igGcId;
	}

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

    public Date getIgBeginTime() {
        return igBeginTime;
    }

    public void setIgBeginTime(Date igBeginTime) {
        this.igBeginTime = igBeginTime;
    }

    public Integer getIgClickCount() {
        return igClickCount;
    }

    public void setIgClickCount(Integer igClickCount) {
        this.igClickCount = igClickCount;
    }

    public String getIgContent() {
        return igContent;
    }

    public void setIgContent(String igContent) {
        this.igContent = igContent == null ? null : igContent.trim();
    }
    
	public String getIgPackList() {
		return igPackList;
	}

	public void setIgPackList(String igPackList) {
		this.igPackList = igPackList == null ? null : igPackList.trim();
	}

    public Date getIgEndTime() {
        return igEndTime;
    }

    public void setIgEndTime(Date igEndTime) {
        this.igEndTime = igEndTime;
    }

    public Integer getIgExchangeCount() {
        return igExchangeCount;
    }

    public void setIgExchangeCount(Integer igExchangeCount) {
        this.igExchangeCount = igExchangeCount;
    }

    public Integer getIgGoodsCount() {
        return igGoodsCount;
    }

    public void setIgGoodsCount(Integer igGoodsCount) {
        this.igGoodsCount = igGoodsCount;
    }

    public Integer getIgGoodsIntegral() {
        return igGoodsIntegral;
    }

    public void setIgGoodsIntegral(Integer igGoodsIntegral) {
        this.igGoodsIntegral = igGoodsIntegral;
    }

    public String getIgGoodsName() {
        return igGoodsName;
    }

    public void setIgGoodsName(String igGoodsName) {
        this.igGoodsName = igGoodsName == null ? null : igGoodsName.trim();
    }

    public BigDecimal getIgGoodsPrice() {
        return igGoodsPrice;
    }

    public void setIgGoodsPrice(BigDecimal igGoodsPrice) {
        this.igGoodsPrice = igGoodsPrice;
    }

    public String getIgGoodsSn() {
        return igGoodsSn;
    }

    public void setIgGoodsSn(String igGoodsSn) {
        this.igGoodsSn = igGoodsSn == null ? null : igGoodsSn.trim();
    }

    public String getIgGoodsTag() {
        return igGoodsTag;
    }

    public void setIgGoodsTag(String igGoodsTag) {
        this.igGoodsTag = igGoodsTag == null ? null : igGoodsTag.trim();
    }

    public Integer getIgLimitCount() {
        return igLimitCount;
    }

    public void setIgLimitCount(Integer igLimitCount) {
        this.igLimitCount = igLimitCount;
    }

    public Boolean getIgLimitType() {
        return igLimitType;
    }

    public void setIgLimitType(Boolean igLimitType) {
        this.igLimitType = igLimitType;
    }

    public Boolean getIgRecommend() {
        return igRecommend;
    }

    public void setIgRecommend(Boolean igRecommend) {
        this.igRecommend = igRecommend;
    }

    public String getIgSeoDescription() {
        return igSeoDescription;
    }

    public void setIgSeoDescription(String igSeoDescription) {
        this.igSeoDescription = igSeoDescription == null ? null : igSeoDescription.trim();
    }

    public String getIgSeoKeywords() {
        return igSeoKeywords;
    }

    public void setIgSeoKeywords(String igSeoKeywords) {
        this.igSeoKeywords = igSeoKeywords == null ? null : igSeoKeywords.trim();
    }

    public Integer getIgSequence() {
        return igSequence;
    }

    public void setIgSequence(Integer igSequence) {
        this.igSequence = igSequence;
    }

    public Boolean getIgShow() {
        return igShow;
    }

    public void setIgShow(Boolean igShow) {
        this.igShow = igShow;
    }

    public Boolean getIgTimeType() {
        return igTimeType;
    }

    public void setIgTimeType(Boolean igTimeType) {
        this.igTimeType = igTimeType;
    }

    public BigDecimal getIgTransfee() {
        return igTransfee;
    }

    public void setIgTransfee(BigDecimal igTransfee) {
        this.igTransfee = igTransfee;
    }

    public Integer getIgTransfeeType() {
        return igTransfeeType;
    }

    public void setIgTransfeeType(Integer igTransfeeType) {
        this.igTransfeeType = igTransfeeType;
    }

    public Long getIgGoodsImgId() {
        return igGoodsImgId;
    }

    public void setIgGoodsImgId(Long igGoodsImgId) {
        this.igGoodsImgId = igGoodsImgId;
    }
    
    private Long navigationId;   //免费兑换页导航  一对一外键id
    private Integer igGoodsGoldNum;     //兑换所需金币数
    
    
    public Long getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(Long navigationId) {
		this.navigationId = navigationId;
	}

	public Integer getIgGoodsGoldNum() {
		return igGoodsGoldNum;
	}

	public void setIgGoodsGoldNum(Integer igGoodsGoldNum) {
		this.igGoodsGoldNum = igGoodsGoldNum;
	}

	
	private List<IntegralGoodsCart> gcs ;
    private Accessory igGoodsImg;
    
    private GoodsClassWithBLOBs gc;   //商品类型
    
    private Navigation navigation;
    
   	public GoodsClassWithBLOBs getGc() {
   		return gc;
   	}

   	public void setGc(GoodsClassWithBLOBs gc) {
   		this.gc = gc;
   		if(gc!=null) {
   			gc.setId(this.igGcId);
   		}
   		
   	}

	public List<IntegralGoodsCart> getGcs() {
		return gcs;
	}

	public void setGcs(List<IntegralGoodsCart> gcs) {
		this.gcs = gcs;
	}

	public Accessory getIgGoodsImg() {
		return igGoodsImg;
	}

	public void setIgGoodsImg(Accessory igGoodsImg) {
		this.igGoodsImg = igGoodsImg;
		if(igGoodsImg !=null)
			this.igGoodsImgId = igGoodsImg.getId();
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
		if(navigation != null)
			this.navigationId = navigation.getId();
	}
    
}