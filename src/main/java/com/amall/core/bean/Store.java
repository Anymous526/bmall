package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Store implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean cardApprove;		//实名认证

    private Boolean realstoreApprove;	//实体店铺认证

    private String storeAddress;		//详细地址

    private Integer storeCredit;		//店铺信用值

    private String storeMsn;

    private String storeName;		//店铺名称

    private String storeOwer;		//店主姓名

    private String storeOwerCard;  //店主身份号码

    private String storeQq;   //QQ

    private Boolean storeRecommend;		//是否推荐

    private Date storeRecommendTime;

    private Integer storeStatus;		//店铺状态         0  为开店    1 正在审核     2  正常        3 关闭     

    private String storeTelephone;		//联系电话

    private String storeZip;	//邮政编码

    private String template;		//模板

    private Date validity;		//有效期至

    private Long areaId;

    private Long cardId;

    private Long gradeId;

    private Long scId;

    private Long storeBannerId;

    private Long storeLicenseId;
    
    private Long taxId;		//税务登记证照片id
    
    private Long organizationId;	//组织机构代码证照片id
    
    private Long bankId; 	//银行开户证照片id
    
    private Long tradeMarkId;	//商标注册证照片id
    
    private Long authorizationId;	//独占、品牌、商标使用授权书照片id

	private Long storeLogoId;

    private Long updateGradeId;

    private Integer domainModifyCount;

    private String storeSecondDomain;

    private Integer favoriteCount;		//店铺收藏数

    private BigDecimal storeLat;

    private BigDecimal storeLng;

    private String storeWw;

    private String mapType;

    private Date deliveryBeginTime;

    private Date deliveryEndTime;

    private Date combinBeginTime;

    private Date combinEndTime;

    private Date weixinBeginTime;

    private Date weixinEndTime;

    private Integer weixinStatus;

    private String weixinAppid;

    private String weixinAppsecret;

    private String weixinToken;

    private Long weixinQrImgId;

    private String weixinAccount;

    private Long storeWeixinLogoId;

    private String weixinStoreName;
    
    private Long pointId;//店铺评分信息外键id字段，新增
    
    private Long userId;//User类中的主键字段，新增
    
    private BigDecimal cashAmount; //取现额度
    
    private Long paymentId; //保证金缴纳Id
    
    private Long partnerId; //推荐开店会员id
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getPartnerId()
	{
		return partnerId;
	}

	public void setPartnerId(Long partnerId)
	{
		this.partnerId = partnerId;
	}

	public Long getPaymentId()
	{
		return paymentId;
	}

	public void setPaymentId(Long paymentId)
	{
		this.paymentId = paymentId;
	}

	public Date getAddtime() {
        return addtime;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
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

    public Boolean getCardApprove() {
        return cardApprove;
    }

    public void setCardApprove(Boolean cardApprove) {
        this.cardApprove = cardApprove;
    }

    public Boolean getRealstoreApprove() {
        return realstoreApprove;
    }

    public void setRealstoreApprove(Boolean realstoreApprove) {
        this.realstoreApprove = realstoreApprove;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public Integer getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(Integer storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getStoreMsn() {
        return storeMsn;
    }

    public void setStoreMsn(String storeMsn) {
        this.storeMsn = storeMsn == null ? null : storeMsn.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreOwer() {
        return storeOwer;
    }

    public void setStoreOwer(String storeOwer) {
        this.storeOwer = storeOwer == null ? null : storeOwer.trim();
    }

    public String getStoreOwerCard() {
        return storeOwerCard;
    }

    public void setStoreOwerCard(String storeOwerCard) {
        this.storeOwerCard = storeOwerCard == null ? null : storeOwerCard.trim();
    }

    public String getStoreQq() {
        return storeQq;
    }

    public void setStoreQq(String storeQq) {
        this.storeQq = storeQq == null ? null : storeQq.trim();
    }

    public Boolean getStoreRecommend() {
        return storeRecommend;
    }

    public void setStoreRecommend(Boolean storeRecommend) {
        this.storeRecommend = storeRecommend;
    }

    public Date getStoreRecommendTime() {
        return storeRecommendTime;
    }

    public void setStoreRecommendTime(Date storeRecommendTime) {
        this.storeRecommendTime = storeRecommendTime;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreTelephone() {
        return storeTelephone;
    }

    public void setStoreTelephone(String storeTelephone) {
        this.storeTelephone = storeTelephone == null ? null : storeTelephone.trim();
    }

    public String getStoreZip() {
        return storeZip;
    }

    public void setStoreZip(String storeZip) {
        this.storeZip = storeZip == null ? null : storeZip.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public Long getStoreBannerId() {
        return storeBannerId;
    }

    public void setStoreBannerId(Long storeBannerId) {
        this.storeBannerId = storeBannerId;
    }

    public Long getStoreLicenseId() {
        return storeLicenseId;
    }

    public void setStoreLicenseId(Long storeLicenseId) {
        this.storeLicenseId = storeLicenseId;
    }
    
    public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getTradeMarkId() {
		return tradeMarkId;
	}

	public void setTradeMarkId(Long tradeMarkId) {
		this.tradeMarkId = tradeMarkId;
	}

	public Long getAuthorizationId() {
		return authorizationId;
	}

	public void setAuthorizationId(Long authorizationId) {
		this.authorizationId = authorizationId;
	}
    
    public Long getStoreLogoId() {
        return storeLogoId;
    }

    public void setStoreLogoId(Long storeLogoId) {
        this.storeLogoId = storeLogoId;
    }

    public Long getUpdateGradeId() {
        return updateGradeId;
    }

    public void setUpdateGradeId(Long updateGradeId) {
        this.updateGradeId = updateGradeId;
    }

    public Integer getDomainModifyCount() {
        return domainModifyCount;
    }

    public void setDomainModifyCount(Integer domainModifyCount) {
        this.domainModifyCount = domainModifyCount;
    }

    public String getStoreSecondDomain() {
        return storeSecondDomain;
    }

    public void setStoreSecondDomain(String storeSecondDomain) {
        this.storeSecondDomain = storeSecondDomain == null ? null : storeSecondDomain.trim();
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public BigDecimal getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(BigDecimal storeLat) {
        this.storeLat = storeLat;
    }

    public BigDecimal getStoreLng() {
        return storeLng;
    }

    public void setStoreLng(BigDecimal storeLng) {
        this.storeLng = storeLng;
    }

    public String getStoreWw() {
        return storeWw;
    }

    public void setStoreWw(String storeWw) {
        this.storeWw = storeWw == null ? null : storeWw.trim();
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType == null ? null : mapType.trim();
    }

    public Date getDeliveryBeginTime() {
        return deliveryBeginTime;
    }

    public void setDeliveryBeginTime(Date deliveryBeginTime) {
        this.deliveryBeginTime = deliveryBeginTime;
    }

    public Date getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Date deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public Date getCombinBeginTime() {
        return combinBeginTime;
    }

    public void setCombinBeginTime(Date combinBeginTime) {
        this.combinBeginTime = combinBeginTime;
    }

    public Date getCombinEndTime() {
        return combinEndTime;
    }

    public void setCombinEndTime(Date combinEndTime) {
        this.combinEndTime = combinEndTime;
    }

    public Date getWeixinBeginTime() {
        return weixinBeginTime;
    }

    public void setWeixinBeginTime(Date weixinBeginTime) {
        this.weixinBeginTime = weixinBeginTime;
    }

    public Date getWeixinEndTime() {
        return weixinEndTime;
    }

    public void setWeixinEndTime(Date weixinEndTime) {
        this.weixinEndTime = weixinEndTime;
    }

    public Integer getWeixinStatus() {
        return weixinStatus;
    }

    public void setWeixinStatus(Integer weixinStatus) {
        this.weixinStatus = weixinStatus;
    }

    public String getWeixinAppid() {
        return weixinAppid;
    }

    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid == null ? null : weixinAppid.trim();
    }

    public String getWeixinAppsecret() {
        return weixinAppsecret;
    }

    public void setWeixinAppsecret(String weixinAppsecret) {
        this.weixinAppsecret = weixinAppsecret == null ? null : weixinAppsecret.trim();
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken == null ? null : weixinToken.trim();
    }

    public Long getWeixinQrImgId() {
        return weixinQrImgId;
    }

    public void setWeixinQrImgId(Long weixinQrImgId) {
        this.weixinQrImgId = weixinQrImgId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount == null ? null : weixinAccount.trim();
    }

    public Long getStoreWeixinLogoId() {
        return storeWeixinLogoId;
    }

    public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
        this.storeWeixinLogoId = storeWeixinLogoId;
    }

    public String getWeixinStoreName() {
        return weixinStoreName;
    }

    public void setWeixinStoreName(String weixinStoreName) {
        this.weixinStoreName = weixinStoreName == null ? null : weixinStoreName.trim();
    }
    
    public Long getPointId() {
		return pointId;
	}

	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	private Accessory card;
    private StoreClass sc;
   	private Area area;
   	private AlipayOrder alipayOrder;
	private Accessory storeLogo;
   	private Accessory storeBanner;
   	private StorePoint point;
   	private User user;
   	private StoreGrade grade;
   	private Accessory storeLicense;
   	private Accessory tax;	//税务登记证照片
   	private Accessory organization;	//组织机构代码证照片
   	private Accessory bank;	//银行开户证照片
   	private Accessory tradeMark; //商标注册证照片
   	private Accessory authorization;	//独占、品牌、商标使用授权书照片
   	private List<GoodsWithBLOBs> goodsList = new ArrayList<GoodsWithBLOBs>();
   	private List<StoreSlide> slides = new ArrayList<StoreSlide>();
   	private StoreGrade updateGrade;
   	private List<DeliveryLog> deliveryLogs = new ArrayList<DeliveryLog>();
	private List<GoodsClassStaple> gcss = new ArrayList<GoodsClassStaple>();
	private List<OrderForm> ofs = new ArrayList<OrderForm>();
	private List<Favorite> favs = new ArrayList<Favorite>();
	private List<CombinLog> combinLogs = new ArrayList<CombinLog>();
	
	//2015年6月13日 16:49:37  wsw store 与 storePoint一对一
	private StorePoint storePoint;
	
	
	
   	public StorePoint getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(StorePoint storePoint) {
		this.storePoint = storePoint;
		
	}

	public AlipayOrder getAlipayOrder()
	{
		return alipayOrder;
	}

	public void setAlipayOrder(AlipayOrder alipayOrder)
	{
		this.alipayOrder = alipayOrder;
	}

	public Accessory getCard() {
		return card;
	}

	public void setCard(Accessory card) {
		this.card = card;
		if(card !=null)
			this.cardId = card.getId();
	}

	public StoreClass getSc() {
   		return sc;
   	}

   	public void setSc(StoreClass sc) {
   		this.sc = sc;
   		if(sc!=null){
   			this.setScId(sc.getId());
   		}
   	}

   	public Area getArea() {
   		return area;
   	}

   	public void setArea(Area area) {
   		this.area = area;
   		if(area!=null){
   			this.setAreaId(area.getId());
   		}
   	}

   	public StorePoint getPoint() {
   		return point;
   	}

   	public void setPoint(StorePoint point) {
   		this.point = point;
   		if(point !=null)
   			this.pointId = point.getId();
   	}

   	public User getUser() {
   		return user;
   	}

   	public void setUser(User user) {
   		this.user = user;
   		if (user != null)
   			this.userId = user.getId();
   	}

   	public StoreGrade getGrade() {
   		return grade;
   	}

   	public void setGrade(StoreGrade grade) {
   		this.grade = grade;
   		if(grade !=null)
   			this.gradeId = grade.getId();
   	}

   	public Accessory getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(Accessory storeLogo) {
		this.storeLogo = storeLogo;
		if(storeLogo !=null)
			this.storeLogoId = storeLogo.getId();
	}

	public Accessory getStoreBanner() {
		return storeBanner;
	}

	public void setStoreBanner(Accessory storeBanner) {
		this.storeBanner = storeBanner;
		if(storeBanner != null)
			this.storeBannerId = storeBanner.getId();
	}

	public Accessory getStoreLicense() {
		return storeLicense;
	}

	public void setStoreLicense(Accessory storeLicense) {
		this.storeLicense = storeLicense;
		if(storeLicense != null)
			this.storeLicenseId = storeLicense.getId();
	}
	
	public Accessory getTax() {
		return tax;
	}

	public void setTax(Accessory tax) {
		this.tax = tax;
		if(tax != null){
			this.taxId = tax.getId();
		}
	}

	public Accessory getOrganization() {
		return organization;
	}

	public void setOrganization(Accessory organization) {
		this.organization = organization;
		if(organization != null){
			this.organizationId = organization.getId();
		}
	}

	public Accessory getBank() {
		return bank;
	}

	public void setBank(Accessory bank) {
		this.bank = bank;
		if(bank != null){
			this.bankId = bank.getId();
		}
	}

	public Accessory getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(Accessory tradeMark) {
		this.tradeMark = tradeMark;
		if(tradeMark != null){
			this.tradeMarkId = tradeMark.getId();
		}
	}

	public Accessory getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Accessory authorization) {
		this.authorization = authorization;
		if(authorization != null){
			this.authorizationId = authorization.getId();
		}
	}

   	public List<StoreSlide> getSlides() {
   		return slides;
   	}

   	public void setSlides(List<StoreSlide> slides) {
   		this.slides = slides;
   	}

	public List<GoodsWithBLOBs> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsWithBLOBs> goodsList) {
		this.goodsList = goodsList;
	}

	public StoreGrade getUpdateGrade() {
		return updateGrade;
	}

	public void setUpdateGrade(StoreGrade updateGrade) {
		this.updateGrade = updateGrade;
		if(updateGrade !=null)
			this.updateGradeId = updateGrade.getId();
	}

	public List<DeliveryLog> getDeliveryLogs() {
		return deliveryLogs;
	}

	public void setDeliveryLogs(List<DeliveryLog> deliveryLogs) {
		this.deliveryLogs = deliveryLogs;
	}

	public List<CombinLog> getCombinLogs() {
		return combinLogs;
	}

	public void setCombinLogs(List<CombinLog> combinLogs) {
		this.combinLogs = combinLogs;
	}

	public List<GoodsClassStaple> getGcss() {
		return gcss;
	}

	public void setGcss(List<GoodsClassStaple> gcss) {
		this.gcss = gcss;
	}

	public List<OrderForm> getOfs() {
		return ofs;
	}

	public void setOfs(List<OrderForm> ofs) {
		this.ofs = ofs;
	}

	public List<Favorite> getFavs() {
		return favs;
	}

	public void setFavs(List<Favorite> favs) {
		this.favs = favs;
	}
	
	
}