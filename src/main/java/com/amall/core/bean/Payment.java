package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String chinabankAccount;	//网银在线商户号

    private String chinabankKey;	//网银在线密钥

    private Boolean install;		//是否启用

    private Integer interfacetype;  //接口类型

    private String mark;   //支付方式

    private String merchantacctid;	//快钱帐户

    private String name;

    private String partner;  //合作者身份ID

    private String pid;		//合作伙伴账户号

    private String rmbkey;		//人民币网关密钥

    private String safekey;   //安全校验码

    private String sellerEmail;	//支付宝账号

    private String spname;		//财付通商户名称

    private String tenpayKey;		//财付通安全密钥

    private String tenpayPartner;	//财付通商户号

    private Integer tradeMode;  //财付通支付方式

    private String type;

    private Long storeId;

    private BigDecimal alipayDivideRate;

    /**
     * 支付的使用，要除以100
     */
    private BigDecimal alipayRate;//单位10，要用的时候除以100

    private BigDecimal balanceDivideRate;

    private String currencyCode;  //支付货币

    private String paypalUserid;  //Paypal账号

    private BigDecimal poundage;

    private String lzbankKey;

    private String lzbankPartner;

    private String lzbankTradeMode;

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

    public String getChinabankAccount() {
        return chinabankAccount;
    }

    public void setChinabankAccount(String chinabankAccount) {
        this.chinabankAccount = chinabankAccount == null ? null : chinabankAccount.trim();
    }

    public String getChinabankKey() {
        return chinabankKey;
    }

    public void setChinabankKey(String chinabankKey) {
        this.chinabankKey = chinabankKey == null ? null : chinabankKey.trim();
    }

    public Boolean getInstall() {
        return install;
    }

    public void setInstall(Boolean install) {
        this.install = install;
    }

    public Integer getInterfacetype() {
        return interfacetype;
    }

    public void setInterfacetype(Integer interfacetype) {
        this.interfacetype = interfacetype;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getMerchantacctid() {
        return merchantacctid;
    }

    public void setMerchantacctid(String merchantacctid) {
        this.merchantacctid = merchantacctid == null ? null : merchantacctid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner == null ? null : partner.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getRmbkey() {
        return rmbkey;
    }

    public void setRmbkey(String rmbkey) {
        this.rmbkey = rmbkey == null ? null : rmbkey.trim();
    }

    public String getSafekey() {
        return safekey;
    }

    public void setSafekey(String safekey) {
        this.safekey = safekey == null ? null : safekey.trim();
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail == null ? null : sellerEmail.trim();
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname == null ? null : spname.trim();
    }

    public String getTenpayKey() {
        return tenpayKey;
    }

    public void setTenpayKey(String tenpayKey) {
        this.tenpayKey = tenpayKey == null ? null : tenpayKey.trim();
    }

    public String getTenpayPartner() {
        return tenpayPartner;
    }

    public void setTenpayPartner(String tenpayPartner) {
        this.tenpayPartner = tenpayPartner == null ? null : tenpayPartner.trim();
    }

    public Integer getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getAlipayDivideRate() {
        return alipayDivideRate;
    }

    public void setAlipayDivideRate(BigDecimal alipayDivideRate) {
        this.alipayDivideRate = alipayDivideRate;
    }

    public BigDecimal getAlipayRate() {
        return alipayRate;
    }

    public void setAlipayRate(BigDecimal alipayRate) {
        this.alipayRate = alipayRate;
    }

    public BigDecimal getBalanceDivideRate() {
        return balanceDivideRate;
    }

    public void setBalanceDivideRate(BigDecimal balanceDivideRate) {
        this.balanceDivideRate = balanceDivideRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public String getPaypalUserid() {
        return paypalUserid;
    }

    public void setPaypalUserid(String paypalUserid) {
        this.paypalUserid = paypalUserid == null ? null : paypalUserid.trim();
    }

    public BigDecimal getPoundage() {
        return poundage;
    }

    public void setPoundage(BigDecimal poundage) {
        this.poundage = poundage;
    }

    public String getLzbankKey() {
        return lzbankKey;
    }

    public void setLzbankKey(String lzbankKey) {
        this.lzbankKey = lzbankKey == null ? null : lzbankKey.trim();
    }

    public String getLzbankPartner() {
        return lzbankPartner;
    }

    public void setLzbankPartner(String lzbankPartner) {
        this.lzbankPartner = lzbankPartner == null ? null : lzbankPartner.trim();
    }

    public String getLzbankTradeMode() {
        return lzbankTradeMode;
    }

    public void setLzbankTradeMode(String lzbankTradeMode) {
        this.lzbankTradeMode = lzbankTradeMode == null ? null : lzbankTradeMode.trim();
    }
    
    
    private Store store;
    private List<OrderFormWithBLOBs> ofs = new ArrayList<OrderFormWithBLOBs>();
    
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.storeId = store.getId();
	}

	public List<OrderFormWithBLOBs> getOfs() {
		return ofs;
	}

	public void setOfs(List<OrderFormWithBLOBs> ofs) {
		this.ofs = ofs;
	}

    
}