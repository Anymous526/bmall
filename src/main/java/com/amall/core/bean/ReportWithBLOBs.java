package com.amall.core.bean;

public class ReportWithBLOBs extends Report {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String content;

    private String handleInfo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHandleInfo() {
        return handleInfo;
    }

    public void setHandleInfo(String handleInfo) {
        this.handleInfo = handleInfo == null ? null : handleInfo.trim();
    }
}