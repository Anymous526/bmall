package com.amall.core.bean;

public class TransportWithBLOBs extends Transport {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String transEmsInfo;

    private String transExpressInfo;

    private String transMailInfo;

    public String getTransEmsInfo() {
        return transEmsInfo;
    }

    public void setTransEmsInfo(String transEmsInfo) {
        this.transEmsInfo = transEmsInfo == null ? null : transEmsInfo.trim();
    }

    public String getTransExpressInfo() {
        return transExpressInfo;
    }

    public void setTransExpressInfo(String transExpressInfo) {
        this.transExpressInfo = transExpressInfo == null ? null : transExpressInfo.trim();
    }

    public String getTransMailInfo() {
        return transMailInfo;
    }

    public void setTransMailInfo(String transMailInfo) {
        this.transMailInfo = transMailInfo == null ? null : transMailInfo.trim();
    }
}