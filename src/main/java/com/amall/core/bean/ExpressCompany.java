package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 快递公司设置信息
 * @author ljx
 *
 */
public class ExpressCompany implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String companyMark;			//快递代码

    private String companyName;      	// 物流公司，快递名称

    private Integer companyStatus;		//是否显示

    private Integer companySequence;	//快递序号

    private String companyType;			//快递类型

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

    public String getCompanyMark() {
        return companyMark;
    }

    public void setCompanyMark(String companyMark) {
        this.companyMark = companyMark == null ? null : companyMark.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Integer companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Integer getCompanySequence() {
        return companySequence;
    }

    public void setCompanySequence(Integer companySequence) {
        this.companySequence = companySequence;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }
    
    
    private List<OrderFormWithBLOBs> ofs = new ArrayList<OrderFormWithBLOBs>();

	public List<OrderFormWithBLOBs> getOfs() {
		return ofs;
	}

	public void setOfs(List<OrderFormWithBLOBs> ofs) {
		this.ofs = ofs;
	}
    
}