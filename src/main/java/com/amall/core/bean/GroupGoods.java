package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GroupGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date ggAuditTime;

    private Integer ggCount;//商品总数：

    private Integer ggDefCount;//团购想买人数

    private Integer ggGroupCount;//成团数量

    private Integer ggMaxCount;//限购数量

    private Integer ggMinCount;

    private String ggName;//团购商品名称

    private BigDecimal ggPrice;//团购价格

    private BigDecimal ggRebate;	//折扣

    private Integer ggRecommend;  //推荐

    private Date ggRecommendTime;	//推荐时间

    private Integer ggStatus;		//审核状态   0 待审核    1  审核通过   -1 审核拒绝

    private Integer ggVirCount;//虚拟数量：   //+ggDefCount表示团购已售

    private Long ggGaId;//所属区域：

    private Long ggGcId;//团购类别：

    private Long ggGoodsId;

    private Long ggImgId;//团购图片
    
    private Long ggImgId2;//团购首页图片
    
    private Long ggImgId3; 

    private Long groupId;//团购活动

    private Boolean weixinShopRecommend;

    private Date weixinShopRecommendtime;

    private String ggContent;//团购简介
    
    private String ggPackList; //团购商品清单


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getGgImgId3()
	{
		return ggImgId3;
	}

	public void setGgImgId3(Long ggImgId3)
	{
		this.ggImgId3 = ggImgId3;
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

    public Date getGgAuditTime() {
        return ggAuditTime;
    }

    public void setGgAuditTime(Date ggAuditTime) {
        this.ggAuditTime = ggAuditTime;
    }

    public Integer getGgCount() {
        return ggCount;
    }

    public void setGgCount(Integer ggCount) {
        this.ggCount = ggCount;
    }

    public Integer getGgDefCount() {
        return ggDefCount;
    }

    public void setGgDefCount(Integer ggDefCount) {
        this.ggDefCount = ggDefCount;
    }

    public Integer getGgGroupCount() {
        return ggGroupCount;
    }

    public void setGgGroupCount(Integer ggGroupCount) {
        this.ggGroupCount = ggGroupCount;
    }

    public Integer getGgMaxCount() {
        return ggMaxCount;
    }

    public void setGgMaxCount(Integer ggMaxCount) {
        this.ggMaxCount = ggMaxCount;
    }

    public Integer getGgMinCount() {
        return ggMinCount;
    }

    public void setGgMinCount(Integer ggMinCount) {
        this.ggMinCount = ggMinCount;
    }

    public String getGgName() {
        return ggName;
    }

    public void setGgName(String ggName) {
        this.ggName = ggName == null ? null : ggName.trim();
    }

    public BigDecimal getGgPrice() {
        return ggPrice;
    }

    public void setGgPrice(BigDecimal ggPrice) {
        this.ggPrice = ggPrice;
    }

    public BigDecimal getGgRebate() {
        return ggRebate;
    }

    public void setGgRebate(BigDecimal ggRebate) {
        this.ggRebate = ggRebate;
    }

    public Integer getGgRecommend() {
        return ggRecommend;
    }

    public void setGgRecommend(Integer ggRecommend) {
        this.ggRecommend = ggRecommend;
    }

    public Date getGgRecommendTime() {
        return ggRecommendTime;
    }

    public void setGgRecommendTime(Date ggRecommendTime) {
        this.ggRecommendTime = ggRecommendTime;
    }

    public Integer getGgStatus() {
        return ggStatus;
    }

    public void setGgStatus(Integer ggStatus) {
        this.ggStatus = ggStatus;
    }

    public Integer getGgVirCount() {
        return ggVirCount;
    }

    public void setGgVirCount(Integer ggVirCount) {
        this.ggVirCount = ggVirCount;
    }

    public Long getGgGaId() {
        return ggGaId;
    }

    public void setGgGaId(Long ggGaId) {
        this.ggGaId = ggGaId;
    }

    public Long getGgGcId() {
        return ggGcId;
    }

    public void setGgGcId(Long ggGcId) {
        this.ggGcId = ggGcId;
    }

    public Long getGgGoodsId() {
        return ggGoodsId;
    }

    public void setGgGoodsId(Long ggGoodsId) {
        this.ggGoodsId = ggGoodsId;
    }

    public Long getGgImgId() {
        return ggImgId;
    }

    public void setGgImgId(Long ggImgId) {
        this.ggImgId = ggImgId;
    }
    
    public Long getGgImgId2() {
        return ggImgId2;
    }

    public void setGgImgId2(Long ggImgId2) {
        this.ggImgId2 = ggImgId2;
    }

	public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getWeixinShopRecommend() {
        return weixinShopRecommend;
    }

    public void setWeixinShopRecommend(Boolean weixinShopRecommend) {
        this.weixinShopRecommend = weixinShopRecommend;
    }

    public Date getWeixinShopRecommendtime() {
        return weixinShopRecommendtime;
    }

    public void setWeixinShopRecommendtime(Date weixinShopRecommendtime) {
        this.weixinShopRecommendtime = weixinShopRecommendtime;
    }

    public String getGgContent() {
        return ggContent;
    }

    public void setGgContent(String ggContent) {
        this.ggContent = ggContent == null ? null : ggContent.trim();
    }
    
    public String getGgPackList() {
		return ggPackList;
	}

	public void setGgPackList(String ggPackList) {
		this.ggPackList = ggPackList == null ? null : ggPackList.trim();
	}
    
    
    
    private Group group;
    private GroupClass ggGc;//团购类别：
    private GroupArea ggGa;//所属区域：
    private GoodsWithBLOBs ggGoods;//团购商品：
    private Accessory ggImg;//团购图片
    private Accessory ggImg2;//团购首页图片
    private Accessory ggImg3;//团购首页图片

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
		if(group!=null)
		{
			this.setGroupId(group.getId());
		}
	}

	public GroupClass getGgGc() {
		return ggGc;
	}

	public void setGgGc(GroupClass ggGc) {
		this.ggGc = ggGc;
        if(ggGc!=null){
			this.setGgGcId(ggGc.getId());
		}
	}

	public GroupArea getGgGa() {
		return ggGa;
	}

	public void setGgGa(GroupArea ggGa) {
		this.ggGa = ggGa;
		if(ggGa!=null)
		{
			this.setGgGaId(ggGa.getId());
		}
	}

	public GoodsWithBLOBs getGgGoods() {
		return ggGoods;
	}

	public void setGgGoods(GoodsWithBLOBs ggGoods) {
		this.ggGoods = ggGoods;
		if(ggGoods!=null)
		{
			this.setGgGoodsId(ggGoods.getId());
		}
	}

	public Accessory getGgImg() {
		return ggImg;
	}

	public void setGgImg(Accessory ggImg) {
		this.ggImg = ggImg;
		if(ggImg!=null)
		{
			this.setGgImgId(ggImg.getId());
		}
	}
			
	public Accessory getGgImg2() {
		return ggImg2;
	}

	public void setGgImg2(Accessory ggImg2) {
		this.ggImg2 = ggImg2;
		if(ggImg2!=null)
		{
			this.setGgImgId2(ggImg2.getId());
		}
	}

	public Accessory getGgImg3()
	{
		return ggImg3;
	}

	public void setGgImg3(Accessory ggImg3)
	{
		this.ggImg3 = ggImg3;
	}

}