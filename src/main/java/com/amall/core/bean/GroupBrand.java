package com.amall.core.bean;

public class GroupBrand {
    private Long id;

    private Long groupId;//团购表Group的Id号

    private Long brandId;//商品品牌表amall_goodsbrand的Id号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    
    
    private Group group;//团购
    private GoodsBrand goodsBrand;//商品品牌

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public GoodsBrand getGoodsBrand() {
		return goodsBrand;
	}

	public void setGoodsBrand(GoodsBrand goodsBrand) {
		this.goodsBrand = goodsBrand;
	}
    
    
    
    
    
}