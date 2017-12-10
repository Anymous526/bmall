package com.amall.core.bean;



public class ComplaintWithBLOBs extends Complaint {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String fromUserContent;	//投诉内容

    private String handleContent;   //仲裁意见

    private String talkContent;		//  买卖双方对话详情

    private String toUserContent;	//申诉内容

    public String getFromUserContent() {
        return fromUserContent;
    }

    public void setFromUserContent(String fromUserContent) {
        this.fromUserContent = fromUserContent == null ? null : fromUserContent.trim();
    }

    public String getHandleContent() {
        return handleContent;
    }

    public void setHandleContent(String handleContent) {
        this.handleContent = handleContent == null ? null : handleContent.trim();
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent == null ? null : talkContent.trim();
    }

    public String getToUserContent() {
        return toUserContent;
    }

    public void setToUserContent(String toUserContent) {
        this.toUserContent = toUserContent == null ? null : toUserContent.trim();
    }
    
}