package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: GoodsBrand</p>
 * <p>Description: 商品品牌信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月3日下午7:01:25
 * @version 1.0
 */
public class GoodsBrand implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer audit;		//审核状态     0 待审核   1  通过审核  2审核拒绝

    private String name;		//品牌名称

    private Boolean recommend;		//是否推荐

    private Integer sequence;		//序号

    private Long brandlogoId;		//品牌图片外键id

    private Long categoryId;

    private Integer userstatus;

    private Long userId;

    private Boolean weixinShopRecommend;

    private Date weixinShopRecommendtime;

    private String firstWord;		//首字母

    private String remark;
    
    

    public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getBrandlogoId() {
        return brandlogoId;
    }

    public void setBrandlogoId(Long brandlogoId) {
        this.brandlogoId = brandlogoId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord == null ? null : firstWord.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    
    private List<GoodsWithBLOBs> goodsList = new ArrayList<GoodsWithBLOBs>();
    private List<GoodsType> types = new ArrayList<GoodsType>();
    private GoodsBrandCategory category;
    private User user;
    private Accessory brandLogo;
    
    
    
	public List<GoodsWithBLOBs> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsWithBLOBs> goodsList) {
		this.goodsList = goodsList;
	}

	public GoodsBrandCategory getCategory() {
		return category;
	}

	public void setCategory(GoodsBrandCategory category) {
		this.category = category;
		if(category !=null)
			this.categoryId = category.getId();
	}

	public List<GoodsType> getTypes() {
		return types;
	}

	public void setTypes(List<GoodsType> types) {
		this.types = types;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user != null)
			this.userId = user.getId();
	}

	public Accessory getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(Accessory brandLogo) {
		this.brandLogo = brandLogo;
		if(brandLogo != null){
			this.brandlogoId = brandLogo.getId();
		}
	}
    
    
}