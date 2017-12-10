package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: Group</p>
 * <p>Description: 团购信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日下午5:03:54
 * @version 1.0
 */
public class Group implements Serializable{
	
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;  

    private Boolean deletestatus;

    private Date begintime;  //团购开始时间

    private Date endtime;	//结束时间

    private String groupName;	//团购名称

    private Date joinendtime;   //报名截止时间

    private Integer status;    //开启状态(0:正常,-1:关闭,-2:已结束,1:未开始)
    
    private Integer isBrand;  //区分是单品团，还是品牌团。为1表示品牌团，为0表示单品团
    
    private Long goodsClassId;

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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getJoinendtime() {
        return joinendtime;
    }

    public void setJoinendtime(Date joinendtime) {
        this.joinendtime = joinendtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getIsBrand() {
		return isBrand;
	}

	public void setIsBrand(Integer isBrand) {
		this.isBrand = isBrand;
	}










	public Long getGoodsClassId() {
		return goodsClassId;
	}

	public void setGoodsClassId(Long goodsClassId) {
		this.goodsClassId = goodsClassId;
	}












	private List<GoodsWithBLOBs> goods_list = new ArrayList<GoodsWithBLOBs>();
    private List<GroupGoods> gg_list = new ArrayList<GroupGoods>();
    private List<OrderFormWithBLOBs> order_list = new ArrayList<OrderFormWithBLOBs>();
    private GoodsClass goodsClass;//团购分类
    

	public List<OrderFormWithBLOBs> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<OrderFormWithBLOBs> order_list) {
		this.order_list = order_list;
	}

	public List<GoodsWithBLOBs> getGoods_list() {
		return goods_list;
	}

	public void setGoods_list(List<GoodsWithBLOBs> goods_list) {
		this.goods_list = goods_list;
	}

	public List<GroupGoods> getGg_list() {
		return gg_list;
	}

	public void setGg_list(List<GroupGoods> gg_list) {
		this.gg_list = gg_list;
	}


	public GoodsClass getGoodsClass() {
		return goodsClass;
	}

	public void setGoodsClass(GoodsClass goodsClass) {
		this.goodsClass = goodsClass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}