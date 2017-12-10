package com.amall.core.bean;

public class PredepositWithBLOBs extends Predeposit {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String pdAdminInfo;//操作备注

    private String pdRemittanceInfo;//预存款备注

    public String getPdAdminInfo() {
        return pdAdminInfo;
    }

    public void setPdAdminInfo(String pdAdminInfo) {
        this.pdAdminInfo = pdAdminInfo == null ? null : pdAdminInfo.trim();
    }

    public String getPdRemittanceInfo() {
        return pdRemittanceInfo;
    }

    public void setPdRemittanceInfo(String pdRemittanceInfo) {
        this.pdRemittanceInfo = pdRemittanceInfo == null ? null : pdRemittanceInfo.trim();
    }
}