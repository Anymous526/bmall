package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: UserGoodsClass</p>
 * <p>Description: 卖家商品自定义分类信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月1日下午5:05:53
 * @version 1.0
 */
public class UserGoodsClass implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;	//分类名称

    private Boolean display;	//显示状态   

    private Integer level;		//级别

    private Integer sequence;   //排序

    private Long parentId;		//父级分类id

    private Long userId;		//用户外键id

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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    
    private UserGoodsClass parent;
    private User user;
    private List<UserGoodsClass> childs = new ArrayList<UserGoodsClass> ();

    
    private List<GoodsWithBLOBs> goodsList = new ArrayList<GoodsWithBLOBs> ();
	
    public UserGoodsClass getParent() {
		return parent;
	}

	public void setParent(UserGoodsClass parent) {
		this.parent = parent;
		if(parent != null)
			this.parentId = parent.getId();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user!=null)
			this.userId = user.getId();
	}

	public List<UserGoodsClass> getChilds() {
		return childs;
	}

	public void setChilds(List<UserGoodsClass> childs) {
		this.childs = childs;
	}

	public List<GoodsWithBLOBs> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsWithBLOBs> goodsList) {
		this.goodsList = goodsList;
	}
    
	
	
}