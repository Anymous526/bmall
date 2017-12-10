package com.amall.core.bean;


public class SysConfigWithBLOBs extends SysConfig {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String closereason;

    private String codestat;

    private String creditrule;

    private String shareCode;

    private String storePayment;

    private String templates;

    private String userCreditrule;

    private String sysDomain;

    private String qqDomainCode;

    private String sinaDomainCode;

    private String bargainState;

    private String serviceQqList;

    private String serviceTelphoneList;

    private String kuaidiId;

    private String weixinWelecomeContent;

    public String getClosereason() {
        return closereason;
    }

    public void setClosereason(String closereason) {
        this.closereason = closereason == null ? null : closereason.trim();
    }

    public String getCodestat() {
        return codestat;
    }

    public void setCodestat(String codestat) {
        this.codestat = codestat == null ? null : codestat.trim();
    }

    public String getCreditrule() {
        return creditrule;
    }

    public void setCreditrule(String creditrule) {
        this.creditrule = creditrule == null ? null : creditrule.trim();
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode == null ? null : shareCode.trim();
    }

    public String getStorePayment() {
        return storePayment;
    }

    public void setStorePayment(String storePayment) {
        this.storePayment = storePayment == null ? null : storePayment.trim();
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates == null ? null : templates.trim();
    }

    public String getUserCreditrule() {
        return userCreditrule;
    }

    public void setUserCreditrule(String userCreditrule) {
        this.userCreditrule = userCreditrule == null ? null : userCreditrule.trim();
    }

    public String getSysDomain() {
        return sysDomain;
    }

    public void setSysDomain(String sysDomain) {
        this.sysDomain = sysDomain == null ? null : sysDomain.trim();
    }

    public String getQqDomainCode() {
        return qqDomainCode;
    }

    public void setQqDomainCode(String qqDomainCode) {
        this.qqDomainCode = qqDomainCode == null ? null : qqDomainCode.trim();
    }

    public String getSinaDomainCode() {
        return sinaDomainCode;
    }

    public void setSinaDomainCode(String sinaDomainCode) {
        this.sinaDomainCode = sinaDomainCode == null ? null : sinaDomainCode.trim();
    }

    public String getBargainState() {
        return bargainState;
    }

    public void setBargainState(String bargainState) {
        this.bargainState = bargainState == null ? null : bargainState.trim();
    }

    public String getServiceQqList() {
        return serviceQqList;
    }

    public void setServiceQqList(String serviceQqList) {
        this.serviceQqList = serviceQqList == null ? null : serviceQqList.trim();
    }

    public String getServiceTelphoneList() {
        return serviceTelphoneList;
    }

    public void setServiceTelphoneList(String serviceTelphoneList) {
        this.serviceTelphoneList = serviceTelphoneList == null ? null : serviceTelphoneList.trim();
    }

    public String getKuaidiId() {
        return kuaidiId;
    }

    public void setKuaidiId(String kuaidiId) {
        this.kuaidiId = kuaidiId == null ? null : kuaidiId.trim();
    }

    public String getWeixinWelecomeContent() {
        return weixinWelecomeContent;
    }

    public void setWeixinWelecomeContent(String weixinWelecomeContent) {
        this.weixinWelecomeContent = weixinWelecomeContent == null ? null : weixinWelecomeContent.trim();
    }
    
	
}