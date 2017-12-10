package com.amall.core.bean;

public class ConsultWithBLOBs extends Consult {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String consultContent;

    private String consultReply;

    public String getConsultContent() {
        return consultContent;
    }

    public void setConsultContent(String consultContent) {
        this.consultContent = consultContent == null ? null : consultContent.trim();
    }

    public String getConsultReply() {
        return consultReply;
    }

    public void setConsultReply(String consultReply) {
        this.consultReply = consultReply == null ? null : consultReply.trim();
    }
}