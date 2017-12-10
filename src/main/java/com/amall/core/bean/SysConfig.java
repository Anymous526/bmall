package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SysConfig implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String address; // 网站网址

	private Integer bigheight;		//商品大图高

	private Integer bigwidth;		//商品大图宽

	private Integer complaintTime;

	private Integer consumptionratio; // 赠送购物积分 数量

	private String copyright;

	private Integer cartCountMax;   //购物车最大存放数量
	
	private Boolean deposit; // 是否启用预存款

	private String description;		//网站描述，出现在前台页面头部的 Meta 标签中，用于记录该页面的概要与描述

	private Boolean emailenable; // 邮件功能开启

	private String emailhost; // SMTP邮件服务器 服务器

	private Integer emailport; // STMP邮件服务器 端口 常见默认为25

	private String emailpws; // 发件人邮箱登录密码

	private String emailtest; // 邮件发送测试

	private String emailuser; // 发件人邮件账号

	private String emailusername; // 邮件发件人名称

	private Integer everyindentlimit; // 积分上限

	private Boolean gold; // 是否开启金币兑换

	private Integer goldmarketvalue; // 一元可以兑换的金币数量

	private Boolean groupbuy; // 是否开启团购

	private String hotsearch; // 热门搜索     显示在搜索框下面

	private Integer imagefilesize; // 图片文件大小

	private String imagesavetype; // 图片存放类型

	private String imagesuffix; // 图片的扩展名

	private Integer indentcomment; // 订单商品评论

	private Boolean integral; // 是否启用积分

	private Integer integralrate;

	private Boolean integralstore; // 是否启用积分商城

	private String keywords; // 网站搜索关键字  出现在前台页面头部的 Meta 标签中，用于记录该页面的关键字

	private Integer memberdaylogin;

	private Integer memberregister;

	private Integer middleheight;	//商品中图高

	private Integer middlewidth;	//商品中图宽

	private Boolean securitycodeconsult; // 商品咨询是否使用验证码

	private Boolean securitycodelogin; // 前台登陆是否使用验证码

	private Boolean securitycoderegister; // 前台注册是否使用验证码

	private String securitycodetype; // 验证码类型

	private Integer smallheight; // 商品小图尺寸 高

	private Integer smallwidth; // 商品小图尺寸 宽

	private Boolean smsenbale; // 是否短信功能开启

	private String smsAuthToken; // 短信平台口令

	private String smsPort; // 短信平台端口

	private String smsUrl; // 短信平台地址

	private String smsAccountSid; // 短信平台用户名
	
    private String smsAppId; //短信App的Id
    
    private String smsExceedTime;  //短信过期时间 单位分
    
    private Integer smsSendInterval; //短信发送周期 单位秒
    
    private Integer smsMaxNumber;  //每日每个用户最大发送短信条数

    private String verificationCodeLength; //短信验证码长度
    
	private Boolean storeAllow;	//是否允许开店

	private String syslanguage; // 默认语言

	private String title;		// 将显示在浏览器标题等位置

	private String uploadfilepath;	//图片上传路径

	private String uploadRootPath; // 如 ： /data/uploadfiles/amall
	
	private Boolean visitorconsult; // 是否允许游客咨询

	private Boolean voucher;

	private String websitename; // 网站名称  将显示在前台顶部欢迎等位置

	private Boolean websitestate;

	private Integer ztcPrice; // 直通车起价

	private Boolean ztcStatus; // 直通车开通状态

	private Long goodsimageId;

	private Long membericonId;

	private Long storeimageId;

	private Long websitelogoId;		//网站LOGO  外键id

	private Integer domainAllowCount;  //卖家修改店铺二级域名次数

	private Boolean secondDomainOpen;  //是否开启二级域名

	private Boolean qqLogin; // 是否启用qq互联功能

	private String qqLoginId; // 应用标识

	private String qqLoginKey; // 应用密钥

	private Boolean sinaLogin;

	private String sinaLoginId;

	private String sinaLoginKey;

	private String imagewebserver; // 图片服务器

	private Date luceneUpdate;	//lucene索引更新时间

	/**
	 * 为1时表示系统平台管理员提供的支付方式;为0时表示卖家商户的支付方式
	 */
	private Integer alipayFenrun;  //支付宝分润

	private Integer balanceFenrun;   //预存款分润

	private Integer autoOrderConfirm;	//自动确认收货时长

	private Integer autoOrderNotice;	//自动收货提醒时长

	private Integer bargainMaximum;		//特价最多商品数

	private BigDecimal bargainRebate;		//特价折扣

	private Integer bargainStatus;		//特价状态

	private String bargainTitle;		//特价页标题

	private Integer sysDeliveryMaximum;

	private Boolean ucBbs;

	private String ucApi;

	private String ucAppid;

	private String ucDatabase;

	private String ucDatabasePort;

	private String ucDatabasePws;

	private String ucDatabaseUrl;

	private String ucDatabaseUsername;

	private String ucIp;

	private String ucKey;

	private String ucTablePreffix;

	private String currencyCode;	//运费计量单位

	private Integer bargainValidity;	//特价商品申请有效期

	private Integer deliveryAmount;		//卖家支付对应金币后才可以发布买就送商品

	private Integer deliveryStatus;		//买就送状态

	private String deliveryTitle;		//买就送标题

	private String websitecss; // 站点样式

	private Integer combinAmount;

	private Integer combinCount;

	private Integer ztcGoodsView;

	private Integer autoOrderEvaluate;	//订单可评价有效时长

	private Integer autoOrderReturn;	//买家申请退货有效时长

	private Boolean weixinStore;

	private Integer weixinAmount;

	/**
	 * 为0时，使用卖家商户店铺的支付状态；为1时，表示使用本平台管理员的支付宝账号
	 */
	private Integer configPaymentType;   //系统支付状态

	private String weixinAccount;

	private String weixinAppid;

	private String weixinAppsecret;

	private String weixinToken;

	private Long storeWeixinLogoId;

	private Long weixinQrImgId;
	
	private Integer goodsClassCount;	//免费兑换商品类型数量,在前台免费兑换处使用
	
    private Integer maxFrequencyWeek;

    private Integer maxNumberWeek;

    private BigDecimal maxPrice;

    private BigDecimal minPricce;
	
	public String getSmsAuthToken() {
        return smsAuthToken;
    }

    public void setSmsAuthToken(String smsAuthToken) {
        this.smsAuthToken = smsAuthToken == null ? null : smsAuthToken.trim();
    }

    public String getSmsPort() {
        return smsPort;
    }

    public void setSmsPort(String smsPort) {
        this.smsPort = smsPort == null ? null : smsPort.trim();
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl == null ? null : smsUrl.trim();
    }

    public String getSmsAccountSid() {
        return smsAccountSid;
    }

    public void setSmsAccountSid(String smsAccountSid) {
        this.smsAccountSid = smsAccountSid == null ? null : smsAccountSid.trim();
    }

	public String getSmsAppId() {
	        return smsAppId;
    }

    public void setSmsAppId(String smsAppId) {
        this.smsAppId = smsAppId == null ? null : smsAppId.trim();
    }

    public String getSmsExceedTime() {
        return smsExceedTime;
    }

    public void setSmsExceedTime(String smsExceedTime) {
        this.smsExceedTime = smsExceedTime == null ? null : smsExceedTime.trim();
    }
    
    public Integer getSmsSendInterval() {
        return smsSendInterval;
    }

    public void setSmsSendInterval(Integer smsSendInterval) {
        this.smsSendInterval = smsSendInterval;
    }

    public String getVerificationCodeLength() {
        return verificationCodeLength;
    }

    public void setVerificationCodeLength(String verificationCodeLength) {
        this.verificationCodeLength = verificationCodeLength == null ? null : verificationCodeLength.trim();
    }

    public Integer getSmsMaxNumber() {
        return smsMaxNumber;
    }

    public void setSmsMaxNumber(Integer smsMaxNumber) {
        this.smsMaxNumber = smsMaxNumber;
    }
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getGoodsClassCount() {
		return goodsClassCount;
	}

	public void setGoodsClassCount(Integer goodsClassCount) {
		this.goodsClassCount = goodsClassCount;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getBigheight() {
		return bigheight;
	}

	public void setBigheight(Integer bigheight) {
		this.bigheight = bigheight;
	}

	public Integer getBigwidth() {
		return bigwidth;
	}

	public void setBigwidth(Integer bigwidth) {
		this.bigwidth = bigwidth;
	}

	public Integer getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Integer complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Integer getConsumptionratio() {
		return consumptionratio;
	}

	public void setConsumptionratio(Integer consumptionratio) {
		this.consumptionratio = consumptionratio;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright == null ? null : copyright.trim();
	}

	public Boolean getDeposit() {
		return deposit;
	}

	public void setDeposit(Boolean deposit) {
		this.deposit = deposit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Boolean getEmailenable() {
		return emailenable;
	}

	public void setEmailenable(Boolean emailenable) {
		this.emailenable = emailenable;
	}

	public String getEmailhost() {
		return emailhost;
	}

	public void setEmailhost(String emailhost) {
		this.emailhost = emailhost == null ? null : emailhost.trim();
	}
	
	public Integer getCartCountMax()
	{
		return cartCountMax;
	}

	public void setCartCountMax(Integer cartCountMax)
	{
		this.cartCountMax = cartCountMax;
	}

	public Integer getEmailport() {
		return emailport;
	}

	public void setEmailport(Integer emailport) {
		this.emailport = emailport;
	}

	public String getEmailpws() {
		return emailpws;
	}

	public void setEmailpws(String emailpws) {
		this.emailpws = emailpws == null ? null : emailpws.trim();
	}

	public String getEmailtest() {
		return emailtest;
	}

	public void setEmailtest(String emailtest) {
		this.emailtest = emailtest == null ? null : emailtest.trim();
	}

	public String getEmailuser() {
		return emailuser;
	}

	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser == null ? null : emailuser.trim();
	}

	public String getEmailusername() {
		return emailusername;
	}

	public void setEmailusername(String emailusername) {
		this.emailusername = emailusername == null ? null : emailusername
				.trim();
	}

	public Integer getEveryindentlimit() {
		return everyindentlimit;
	}

	public void setEveryindentlimit(Integer everyindentlimit) {
		this.everyindentlimit = everyindentlimit;
	}

	public Boolean getGold() {
		return gold;
	}

	public void setGold(Boolean gold) {
		this.gold = gold;
	}

	public Integer getGoldmarketvalue() {
		return goldmarketvalue;
	}

	public void setGoldmarketvalue(Integer goldmarketvalue) {
		this.goldmarketvalue = goldmarketvalue;
	}

	public Boolean getGroupbuy() {
		return groupbuy;
	}

	public void setGroupbuy(Boolean groupbuy) {
		this.groupbuy = groupbuy;
	}

	public String getHotsearch() {
		return hotsearch;
	}

	public void setHotsearch(String hotsearch) {
		this.hotsearch = hotsearch == null ? null : hotsearch.trim();
	}

	public Integer getImagefilesize() {
		return imagefilesize;
	}

	public void setImagefilesize(Integer imagefilesize) {
		this.imagefilesize = imagefilesize;
	}

	public String getImagesavetype() {
		return imagesavetype;
	}

	public void setImagesavetype(String imagesavetype) {
		this.imagesavetype = imagesavetype == null ? null : imagesavetype
				.trim();
	}

	public String getImagesuffix() {
		return imagesuffix;
	}

	public void setImagesuffix(String imagesuffix) {
		this.imagesuffix = imagesuffix == null ? null : imagesuffix.trim();
	}

	public Integer getIndentcomment() {
		return indentcomment;
	}

	public void setIndentcomment(Integer indentcomment) {
		this.indentcomment = indentcomment;
	}

	public Boolean getIntegral() {
		return integral;
	}

	public void setIntegral(Boolean integral) {
		this.integral = integral;
	}

	public Integer getIntegralrate() {
		return integralrate;
	}

	public void setIntegralrate(Integer integralrate) {
		this.integralrate = integralrate;
	}

	public Boolean getIntegralstore() {
		return integralstore;
	}

	public void setIntegralstore(Boolean integralstore) {
		this.integralstore = integralstore;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords == null ? null : keywords.trim();
	}

	public Integer getMemberdaylogin() {
		return memberdaylogin;
	}

	public void setMemberdaylogin(Integer memberdaylogin) {
		this.memberdaylogin = memberdaylogin;
	}

	public Integer getMemberregister() {
		return memberregister;
	}

	public void setMemberregister(Integer memberregister) {
		this.memberregister = memberregister;
	}

	public Integer getMiddleheight() {
		return middleheight;
	}

	public void setMiddleheight(Integer middleheight) {
		this.middleheight = middleheight;
	}

	public Integer getMiddlewidth() {
		return middlewidth;
	}

	public void setMiddlewidth(Integer middlewidth) {
		this.middlewidth = middlewidth;
	}

	public Boolean getSecuritycodeconsult() {
		return securitycodeconsult;
	}

	public void setSecuritycodeconsult(Boolean securitycodeconsult) {
		this.securitycodeconsult = securitycodeconsult;
	}

	public Boolean getSecuritycodelogin() {
		return securitycodelogin;
	}

	public void setSecuritycodelogin(Boolean securitycodelogin) {
		this.securitycodelogin = securitycodelogin;
	}

	public Boolean getSecuritycoderegister() {
		return securitycoderegister;
	}

	public void setSecuritycoderegister(Boolean securitycoderegister) {
		this.securitycoderegister = securitycoderegister;
	}

	public String getSecuritycodetype() {
		return securitycodetype;
	}

	public void setSecuritycodetype(String securitycodetype) {
		this.securitycodetype = securitycodetype == null ? null
				: securitycodetype.trim();
	}

	public Integer getSmallheight() {
		return smallheight;
	}

	public void setSmallheight(Integer smallheight) {
		this.smallheight = smallheight;
	}

	public Integer getSmallwidth() {
		return smallwidth;
	}

	public void setSmallwidth(Integer smallwidth) {
		this.smallwidth = smallwidth;
	}

	public Boolean getSmsenbale() {
		return smsenbale;
	}

	public void setSmsenbale(Boolean smsenbale) {
		this.smsenbale = smsenbale;
	}


	public Boolean getStoreAllow() {
		return storeAllow;
	}

	public void setStoreAllow(Boolean storeAllow) {
		this.storeAllow = storeAllow;
	}

	public String getSyslanguage() {
		return syslanguage;
	}

	public void setSyslanguage(String syslanguage) {
		this.syslanguage = syslanguage == null ? null : syslanguage.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getUploadfilepath() {
		return uploadfilepath;
	}

	public void setUploadfilepath(String uploadfilepath) {
		this.uploadfilepath = uploadfilepath == null ? null : uploadfilepath
				.trim();
	}

	public Boolean getVisitorconsult() {
		return visitorconsult;
	}

	public void setVisitorconsult(Boolean visitorconsult) {
		this.visitorconsult = visitorconsult;
	}

	public Boolean getVoucher() {
		return voucher;
	}

	public void setVoucher(Boolean voucher) {
		this.voucher = voucher;
	}

	public String getWebsitename() {
		return websitename;
	}

	public void setWebsitename(String websitename) {
		this.websitename = websitename == null ? null : websitename.trim();
	}

	public Boolean getWebsitestate() {
		return websitestate;
	}

	public void setWebsitestate(Boolean websitestate) {
		this.websitestate = websitestate;
	}

	public Integer getZtcPrice() {
		return ztcPrice;
	}

	public void setZtcPrice(Integer ztcPrice) {
		this.ztcPrice = ztcPrice;
	}

	public Boolean getZtcStatus() {
		return ztcStatus;
	}

	public void setZtcStatus(Boolean ztcStatus) {
		this.ztcStatus = ztcStatus;
	}

	public Long getGoodsimageId() {
		return goodsimageId;
	}

	public void setGoodsimageId(Long goodsimageId) {
		this.goodsimageId = goodsimageId;
	}

	public Long getMembericonId() {
		return membericonId;
	}

	public void setMembericonId(Long membericonId) {
		this.membericonId = membericonId;
	}

	public Long getStoreimageId() {
		return storeimageId;
	}

	public void setStoreimageId(Long storeimageId) {
		this.storeimageId = storeimageId;
	}

	public Long getWebsitelogoId() {
		return websitelogoId;
	}

	public void setWebsitelogoId(Long websitelogoId) {
		this.websitelogoId = websitelogoId;
	}

	public Integer getDomainAllowCount() {
		return domainAllowCount;
	}

	public void setDomainAllowCount(Integer domainAllowCount) {
		this.domainAllowCount = domainAllowCount;
	}

	public Boolean getSecondDomainOpen() {
		return secondDomainOpen;
	}

	public void setSecondDomainOpen(Boolean secondDomainOpen) {
		this.secondDomainOpen = secondDomainOpen;
	}

	public Boolean getQqLogin() {
		return qqLogin;
	}

	public void setQqLogin(Boolean qqLogin) {
		this.qqLogin = qqLogin;
	}

	public String getQqLoginId() {
		return qqLoginId;
	}

	public void setQqLoginId(String qqLoginId) {
		this.qqLoginId = qqLoginId == null ? null : qqLoginId.trim();
	}

	public String getQqLoginKey() {
		return qqLoginKey;
	}

	public void setQqLoginKey(String qqLoginKey) {
		this.qqLoginKey = qqLoginKey == null ? null : qqLoginKey.trim();
	}

	public Boolean getSinaLogin() {
		return sinaLogin;
	}

	public void setSinaLogin(Boolean sinaLogin) {
		this.sinaLogin = sinaLogin;
	}

	public String getSinaLoginId() {
		return sinaLoginId;
	}

	public void setSinaLoginId(String sinaLoginId) {
		this.sinaLoginId = sinaLoginId == null ? null : sinaLoginId.trim();
	}

	public String getSinaLoginKey() {
		return sinaLoginKey;
	}

	public void setSinaLoginKey(String sinaLoginKey) {
		this.sinaLoginKey = sinaLoginKey == null ? null : sinaLoginKey.trim();
	}

	public String getImagewebserver() {
		return imagewebserver;
	}

	public void setImagewebserver(String imagewebserver) {
		this.imagewebserver = imagewebserver == null ? null : imagewebserver
				.trim();
	}

	public Date getLuceneUpdate() {
		return luceneUpdate;
	}

	public void setLuceneUpdate(Date luceneUpdate) {
		this.luceneUpdate = luceneUpdate;
	}

	public Integer getAlipayFenrun() {
		return alipayFenrun;
	}

	public void setAlipayFenrun(Integer alipayFenrun) {
		this.alipayFenrun = alipayFenrun;
	}

	public Integer getBalanceFenrun() {
		return balanceFenrun;
	}

	public void setBalanceFenrun(Integer balanceFenrun) {
		this.balanceFenrun = balanceFenrun;
	}

	public Integer getAutoOrderConfirm() {
		return autoOrderConfirm;
	}

	public void setAutoOrderConfirm(Integer autoOrderConfirm) {
		this.autoOrderConfirm = autoOrderConfirm;
	}

	public Integer getAutoOrderNotice() {
		return autoOrderNotice;
	}

	public void setAutoOrderNotice(Integer autoOrderNotice) {
		this.autoOrderNotice = autoOrderNotice;
	}

	public Integer getBargainMaximum() {
		return bargainMaximum;
	}

	public void setBargainMaximum(Integer bargainMaximum) {
		this.bargainMaximum = bargainMaximum;
	}

	public BigDecimal getBargainRebate() {
		return bargainRebate;
	}

	public void setBargainRebate(BigDecimal bargainRebate) {
		this.bargainRebate = bargainRebate;
	}

	public Integer getBargainStatus() {
		return bargainStatus;
	}

	public void setBargainStatus(Integer bargainStatus) {
		this.bargainStatus = bargainStatus;
	}

	public String getBargainTitle() {
		return bargainTitle;
	}

	public void setBargainTitle(String bargainTitle) {
		this.bargainTitle = bargainTitle == null ? null : bargainTitle.trim();
	}

	public Integer getSysDeliveryMaximum() {
		return sysDeliveryMaximum;
	}

	public void setSysDeliveryMaximum(Integer sysDeliveryMaximum) {
		this.sysDeliveryMaximum = sysDeliveryMaximum;
	}

	public Boolean getUcBbs() {
		return ucBbs;
	}

	public void setUcBbs(Boolean ucBbs) {
		this.ucBbs = ucBbs;
	}

	public String getUcApi() {
		return ucApi;
	}

	public void setUcApi(String ucApi) {
		this.ucApi = ucApi == null ? null : ucApi.trim();
	}

	public String getUcAppid() {
		return ucAppid;
	}

	public void setUcAppid(String ucAppid) {
		this.ucAppid = ucAppid == null ? null : ucAppid.trim();
	}

	public String getUcDatabase() {
		return ucDatabase;
	}

	public void setUcDatabase(String ucDatabase) {
		this.ucDatabase = ucDatabase == null ? null : ucDatabase.trim();
	}

	public String getUcDatabasePort() {
		return ucDatabasePort;
	}

	public void setUcDatabasePort(String ucDatabasePort) {
		this.ucDatabasePort = ucDatabasePort == null ? null : ucDatabasePort
				.trim();
	}

	public String getUcDatabasePws() {
		return ucDatabasePws;
	}

	public void setUcDatabasePws(String ucDatabasePws) {
		this.ucDatabasePws = ucDatabasePws == null ? null : ucDatabasePws
				.trim();
	}

	public String getUcDatabaseUrl() {
		return ucDatabaseUrl;
	}

	public void setUcDatabaseUrl(String ucDatabaseUrl) {
		this.ucDatabaseUrl = ucDatabaseUrl == null ? null : ucDatabaseUrl
				.trim();
	}

	public String getUcDatabaseUsername() {
		return ucDatabaseUsername;
	}

	public void setUcDatabaseUsername(String ucDatabaseUsername) {
		this.ucDatabaseUsername = ucDatabaseUsername == null ? null
				: ucDatabaseUsername.trim();
	}

	public String getUcIp() {
		return ucIp;
	}

	public void setUcIp(String ucIp) {
		this.ucIp = ucIp == null ? null : ucIp.trim();
	}

	public String getUcKey() {
		return ucKey;
	}

	public void setUcKey(String ucKey) {
		this.ucKey = ucKey == null ? null : ucKey.trim();
	}

	public String getUcTablePreffix() {
		return ucTablePreffix;
	}

	public void setUcTablePreffix(String ucTablePreffix) {
		this.ucTablePreffix = ucTablePreffix == null ? null : ucTablePreffix
				.trim();
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode == null ? null : currencyCode.trim();
	}

	public Integer getBargainValidity() {
		return bargainValidity;
	}

	public void setBargainValidity(Integer bargainValidity) {
		this.bargainValidity = bargainValidity;
	}

	public Integer getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(Integer deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryTitle() {
		return deliveryTitle;
	}

	public void setDeliveryTitle(String deliveryTitle) {
		this.deliveryTitle = deliveryTitle == null ? null : deliveryTitle
				.trim();
	}

	public String getWebsitecss() {
		return websitecss;
	}

	public void setWebsitecss(String websitecss) {
		this.websitecss = websitecss == null ? null : websitecss.trim();
	}

	public Integer getCombinAmount() {
		return combinAmount;
	}

	public void setCombinAmount(Integer combinAmount) {
		this.combinAmount = combinAmount;
	}

	public Integer getCombinCount() {
		return combinCount;
	}

	public void setCombinCount(Integer combinCount) {
		this.combinCount = combinCount;
	}

	public Integer getZtcGoodsView() {
		return ztcGoodsView;
	}

	public void setZtcGoodsView(Integer ztcGoodsView) {
		this.ztcGoodsView = ztcGoodsView;
	}

	public Integer getAutoOrderEvaluate() {
		return autoOrderEvaluate;
	}

	public void setAutoOrderEvaluate(Integer autoOrderEvaluate) {
		this.autoOrderEvaluate = autoOrderEvaluate;
	}

	public Integer getAutoOrderReturn() {
		return autoOrderReturn;
	}

	public void setAutoOrderReturn(Integer autoOrderReturn) {
		this.autoOrderReturn = autoOrderReturn;
	}

	public Boolean getWeixinStore() {
		return weixinStore;
	}

	public void setWeixinStore(Boolean weixinStore) {
		this.weixinStore = weixinStore;
	}

	public Integer getWeixinAmount() {
		return weixinAmount;
	}

	public void setWeixinAmount(Integer weixinAmount) {
		this.weixinAmount = weixinAmount;
	}

	public Integer getConfigPaymentType() {
		return configPaymentType;
	}

	public void setConfigPaymentType(Integer configPaymentType) {
		this.configPaymentType = configPaymentType;
	}

	public String getWeixinAccount() {
		return weixinAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount == null ? null : weixinAccount
				.trim();
	}

	public String getWeixinAppid() {
		return weixinAppid;
	}
	
	public String getUploadRootPath() {
        return uploadRootPath;
    }

    public void setUploadRootPath(String uploadRootPath) {
        this.uploadRootPath = uploadRootPath == null ? null : uploadRootPath.trim();
    }

	public void setWeixinAppid(String weixinAppid) {
		this.weixinAppid = weixinAppid == null ? null : weixinAppid.trim();
	}

	public String getWeixinAppsecret() {
		return weixinAppsecret;
	}

	public void setWeixinAppsecret(String weixinAppsecret) {
		this.weixinAppsecret = weixinAppsecret == null ? null : weixinAppsecret
				.trim();
	}

	public String getWeixinToken() {
		return weixinToken;
	}

	public void setWeixinToken(String weixinToken) {
		this.weixinToken = weixinToken == null ? null : weixinToken.trim();
	}

	public Long getStoreWeixinLogoId() {
		return storeWeixinLogoId;
	}

	public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
		this.storeWeixinLogoId = storeWeixinLogoId;
	}

	public Long getWeixinQrImgId() {
		return weixinQrImgId;
	}

	public void setWeixinQrImgId(Long weixinQrImgId) {
		this.weixinQrImgId = weixinQrImgId;
	}

	
	
	
	
	
	
	

	

	public Integer getMaxFrequencyWeek() {
		return maxFrequencyWeek;
	}

	public void setMaxFrequencyWeek(Integer maxFrequencyWeek) {
		this.maxFrequencyWeek = maxFrequencyWeek;
	}

	public Integer getMaxNumberWeek() {
		return maxNumberWeek;
	}

	public void setMaxNumberWeek(Integer maxNumberWeek) {
		this.maxNumberWeek = maxNumberWeek;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPricce() {
		return minPricce;
	}

	public void setMinPricce(BigDecimal minPricce) {
		this.minPricce = minPricce;
	}








	// BLOBS
	private String closereason;

	private String codestat; // 第三方流量统计代码

	private String creditrule;	//

	private String shareCode;	//百度分享代码

	private String storePayment;

	private String templates;

	private String userCreditrule;

	private String sysDomain;   //系统保留二级域名  卖家不可使用

	private String qqDomainCode; // 域名验证信息

	private String sinaDomainCode;

	private String bargainState;	//特价说明

	private String serviceQqList; // 平台客服QQ

	private String serviceTelphoneList; // 平台客服电话

	private String kuaidiId;   //快递100授权Key

	private String weixinWelecomeContent;  //微信欢迎内容

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
		this.userCreditrule = userCreditrule == null ? null : userCreditrule
				.trim();
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
		this.sinaDomainCode = sinaDomainCode == null ? null : sinaDomainCode
				.trim();
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
		this.serviceQqList = serviceQqList == null ? null : serviceQqList
				.trim();
	}

	public String getServiceTelphoneList() {
		return serviceTelphoneList;
	}

	public void setServiceTelphoneList(String serviceTelphoneList) {
		this.serviceTelphoneList = serviceTelphoneList == null ? null
				: serviceTelphoneList.trim();
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
		this.weixinWelecomeContent = weixinWelecomeContent == null ? null
				: weixinWelecomeContent.trim();
	}


	private List<Accessory> loginImgs;   // 用户前台登录页左侧图片
	private Accessory memberIcon;
	private Accessory goodsImage;
	private Accessory storeImage;
	private Accessory websiteLogo;

	public List<Accessory> getLoginImgs() {
		return loginImgs;
	}

	public void setLoginImgs(List<Accessory> loginImgs) {
		this.loginImgs = loginImgs;
	}
	
	public Accessory getMemberIcon() {
		return memberIcon;
	}

	public void setMemberIcon(Accessory memberIcon) {
		this.memberIcon = memberIcon;
		if(memberIcon!=null){
			this.membericonId = memberIcon.getId();
		}
	}

	public Accessory getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(Accessory goodsImage) {
		this.goodsImage = goodsImage;
		if(goodsImage!=null)
		{
			this.goodsimageId = goodsImage.getId();
		}
	}

	public Accessory getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(Accessory storeImage) {
		this.storeImage = storeImage;
		if(storeImage!=null)
		{
			this.storeimageId = storeImage.getId();
		}
	}

	public Accessory getWebsiteLogo() {
		return websiteLogo;
	}

	public void setWebsiteLogo(Accessory websiteLogo) {
		this.websiteLogo = websiteLogo;
		if(websiteLogo!=null)
		{
			this.websitelogoId = websiteLogo.getId();
		}
	}
}