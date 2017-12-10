package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: StoreGrade</p>
 * <p>Description: 店铺等级</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日上午11:58:02
 * @version 1.0
 */
public class StoreGrade implements Serializable{
	
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String addFunciton;

    private Boolean audit;   //是否已审核

    private Integer goodscount;  //商品总数

    private Integer gradelevel;  //等级

    private String gradename;   //等级名称

    private String price;     //价格

    private Integer sequence;  //序号

    private Float spacesize;//店铺附件空间

    private Boolean sysgrade;//

    private String templates;

    private Integer acountNum;//允许子账户个数

    private String content;//申请说明

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

    public String getAddFunciton() {
        return addFunciton;
    }

    public void setAddFunciton(String addFunciton) {
        this.addFunciton = addFunciton == null ? null : addFunciton.trim();
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    public Integer getGradelevel() {
        return gradelevel;
    }

    public void setGradelevel(Integer gradelevel) {
        this.gradelevel = gradelevel;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Float getSpacesize() {
        return spacesize;
    }

    public void setSpacesize(Float spacesize) {
        this.spacesize = spacesize;
    }

    public Boolean getSysgrade() {
        return sysgrade;
    }

    public void setSysgrade(Boolean sysgrade) {
        this.sysgrade = sysgrade;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates == null ? null : templates.trim();
    }

    public Integer getAcountNum() {
        return acountNum;
    }

    public void setAcountNum(Integer acountNum) {
        this.acountNum = acountNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}