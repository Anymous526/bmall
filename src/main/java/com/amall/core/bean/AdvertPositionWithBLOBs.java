package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class AdvertPositionWithBLOBs extends AdvertPosition {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String apCode;

    private String apContent;

    public String getApCode() {
        return apCode;
    }

    public void setApCode(String apCode) {
        this.apCode = apCode == null ? null : apCode.trim();
    }

    public String getApContent() {
        return apContent;
    }

    public void setApContent(String apContent) {
        this.apContent = apContent == null ? null : apContent.trim();
    }
    
    
    private List<Advert> advs = new ArrayList<Advert>();
    private String advId;
	public List<Advert> getAdvs() {
		return advs;
	}

	public void setAdvs(List<Advert> advs) {
		this.advs = advs;
	}

	public String getAdvId() {
		return advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}

}