package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: ComplaintGoods</p>
 * <p>Description: 被投诉的商品信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月24日下午7:29:37
 * @version 1.0
 */
public class ComplaintGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long complaintId;

    private Long goodsId;

    private String content;  //投诉内容

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

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    
    private Complaint complaint;
    private Goods goods;

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
		if(complaint!=null)
		{
			this.setComplaintId(complaint.getId());
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
    
}