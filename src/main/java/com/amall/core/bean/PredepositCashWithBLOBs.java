package com.amall.core.bean;

public class PredepositCashWithBLOBs extends PredepositCash {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String cashAdminInfo;

    private String cashInfo;//提现备注

    public String getCashAdminInfo() {
        return cashAdminInfo;
    }

    public void setCashAdminInfo(String cashAdminInfo) {
        this.cashAdminInfo = cashAdminInfo == null ? null : cashAdminInfo.trim();
    }

    public String getCashInfo() {
        return cashInfo;
    }

    public void setCashInfo(String cashInfo) {
        this.cashInfo = cashInfo == null ? null : cashInfo.trim();
    }
}