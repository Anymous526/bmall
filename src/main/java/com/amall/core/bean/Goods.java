package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Title: Goods</p>
 * <p>Description: 商品信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月24日下午7:39:43
 * @version 1.0
 */
public class Goods implements Serializable
{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private Integer goodsClick = 0;

	private String goodsFee;		// 商品价格

	private Integer goodsInventory;		// 商品库存

	private String goodsName;		// 商品名称

	private BigDecimal goodsPrice;// 商品原价

	private Boolean goodsRecommend;	// 是否是推荐商品

	private Integer goodsSalenum = 0;// 销量

	private Date goodsSellerTime;

	private String goodsSerial;		// 商品货号

	private Integer goodsStatus = 0;	// 商品状态 0 立即发布， 1 放入仓库,-2:表示商品下架
										// ,未通过审核的商品3 ,正在审核的商品4

	private Integer goodsTransfee = 0;			// 运费 // 1 包邮 0 买家承担运费

	private BigDecimal goodsWeight;		// 商品重量 千克(Kg)

	private String inventoryType;		// 库存配置 all 全局配置 spec规格配置

	private String seoKeywords;		// 搜索关键字

	private BigDecimal storePrice;// 商品的 店铺价格

	private Boolean storeRecommend;  // 是否特别推荐

	private Date storeRecommendTime;

	private Date ztcApplyTime;

	private Date ztcBeginTime;

	private Integer ztcClickNum;

	private Integer ztcDredgePrice;

	private Integer ztcGold;

	private Integer ztcPayStatus = 0;

	private Integer ztcPrice;

	private Integer ztcStatus;

	private Long gcId;				// 商品类型外键id

	private Long goodsBrandId;		// 商品品牌外键id

	private Long goodsMainPhotoId;  // 商品主图片外键id

	private Long goodsStoreId;		// 商品所属店铺外键id

	private Long ztcAdminId;

	private Integer goodsCollect;	// 收藏数

	private Integer refundServerTime;  // 售后期限

	/**
	 * order_view.html中
	 *  #if($!{gs.group_buy}==2) <span style="color:#F00">(团购)</span> #end
	 *  groupBuy=2是团购
	 */
	private Integer groupBuy;	// 是否是团购

	private Integer goodsChoiceType;	// 商品类型 实物 0或虚拟 1

	private Long groupId;

	private Integer activityStatus = 0;// 包邮，活动 状态 当是2时表示是活动

	/**
	 *  order_view.html中
	 *  #if($!{gs.bargainStatus}==2) <span style="color:#F00">(特价)</span> #end
	 */
	private Integer bargainStatus = 0;	// 特价状态 0待审核 1 审核通过 -1 拒绝通过

	/**
	 * order_view.html中
	 * #if($!{gs.deliveryStatus}==2) <span style="color:#F00">[买就送]</span> #end
	 */
	private Integer deliveryStatus = 0;// 返利

	private BigDecimal goodsCurrentPrice;		// 商品的当前价格

	private BigDecimal goodsVolume;		// 商品体积 立方米

	private BigDecimal emsTransFee;		// EMS运费

	private BigDecimal expressTransFee;		// 快递运费

	private BigDecimal mailTransFee;		// 平邮 运费

	private Long transportId;

	private Integer combinStatus = 0;			// 组合销售审核状态

	private Date combinBeginTime;			// 组合销售审核开始时间

	private Date combinEndTime;				// 组合销售审核结束时间

	private BigDecimal combinPrice;			// 组合销售价格

	private BigDecimal descriptionEvaluate;

	private Boolean weixinShopHot;

	private Date weixinShopHottime;

	private Boolean weixinShopRecommend;

	private Date weixinShopRecommendtime;

	private String salesPromotion;// 促销信息,longtext类型

	private String wenxinTip; // 温馨提示，longtext类型

	private String goodsInfo;   // 商品信息描述 显示在商品详情页 商品名称下方

	private Long storeNavId;   // 店铺导航表外键StoreNav

	private Integer moduleId; // 商品模块楼层表amall_goodsmodulefloor的外键

	private BigDecimal goodsRate;// 商品分利利率

	private Boolean acceptBean;

	private BigDecimal beanRate; // 感恩豆利率


	public BigDecimal getBeanRate ( )
		{
			return beanRate;
		}


	public void setBeanRate (	BigDecimal beanRate)
		{
			this.beanRate = beanRate;
		}


	public Boolean getAcceptBean ( )
		{
			return acceptBean;
		}


	public void setAcceptBean (	Boolean acceptBean)
		{
			this.acceptBean = acceptBean;
		}


	public Integer getModuleId ( )
		{
			return moduleId;
		}


	public void setModuleId (	Integer moduleId)
		{
			this.moduleId = moduleId;
		}


	public Long getId ( )
		{
			return id;
		}


	public void setId (	Long id)
		{
			this.id = id;
		}


	public Date getAddtime ( )
		{
			return addtime;
		}


	public void setAddtime (Date addtime)
		{
			this.addtime = addtime;
		}


	public Boolean getDeletestatus ( )
		{
			return deletestatus;
		}


	public void setDeletestatus (	Boolean deletestatus)
		{
			this.deletestatus = deletestatus;
		}


	public Integer getGoodsClick ( )
		{
			return goodsClick;
		}


	public void setGoodsClick (	Integer goodsClick)
		{
			this.goodsClick = goodsClick;
		}


	public String getGoodsFee ( )
		{
			return goodsFee;
		}


	public void setGoodsFee (	String goodsFee)
		{
			this.goodsFee = goodsFee == null ? null : goodsFee.trim ();
		}


	public Integer getGoodsInventory ( )
		{
			return goodsInventory;
		}


	public void setGoodsInventory (	Integer goodsInventory)
		{
			this.goodsInventory = goodsInventory;
		}


	public String getGoodsName ( )
		{
			return goodsName;
		}


	public void setGoodsName (	String goodsName)
		{
			this.goodsName = goodsName == null ? null : goodsName.trim ();
		}


	public BigDecimal getGoodsPrice ( )
		{
			return goodsPrice;
		}


	public void setGoodsPrice (	BigDecimal goodsPrice)
		{
			this.goodsPrice = goodsPrice;
		}


	public Boolean getGoodsRecommend ( )
		{
			return goodsRecommend;
		}


	public void setGoodsRecommend (	Boolean goodsRecommend)
		{
			this.goodsRecommend = goodsRecommend;
		}


	public Integer getGoodsSalenum ( )
		{
			return goodsSalenum;
		}


	public void setGoodsSalenum (	Integer goodsSalenum)
		{
			this.goodsSalenum = goodsSalenum;
		}


	public Date getGoodsSellerTime ( )
		{
			return goodsSellerTime;
		}


	public void setGoodsSellerTime (Date goodsSellerTime)
		{
			this.goodsSellerTime = goodsSellerTime;
		}


	public String getGoodsSerial ( )
		{
			return goodsSerial;
		}


	public void setGoodsSerial (String goodsSerial)
		{
			this.goodsSerial = goodsSerial == null ? null : goodsSerial.trim ();
		}


	public Integer getGoodsStatus ( )
		{
			return goodsStatus;
		}


	public void setGoodsStatus (Integer goodsStatus)
		{
			this.goodsStatus = goodsStatus;
		}


	public Integer getGoodsTransfee ( )
		{
			return goodsTransfee;
		}


	public void setGoodsTransfee (	Integer goodsTransfee)
		{
			this.goodsTransfee = goodsTransfee;
		}


	public BigDecimal getGoodsWeight ( )
		{
			return goodsWeight;
		}


	public void setGoodsWeight (BigDecimal goodsWeight)
		{
			this.goodsWeight = goodsWeight;
		}


	public String getInventoryType ( )
		{
			return inventoryType;
		}


	public void setInventoryType (	String inventoryType)
		{
			this.inventoryType = inventoryType == null ? null : inventoryType.trim ();
		}


	public String getSeoKeywords ( )
		{
			return seoKeywords;
		}


	public void setSeoKeywords (String seoKeywords)
		{
			this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim ();
		}


	public BigDecimal getStorePrice ( )
		{
			return storePrice;
		}


	public void setStorePrice (	BigDecimal storePrice)
		{
			this.storePrice = storePrice;
		}


	public Boolean getStoreRecommend ( )
		{
			return storeRecommend;
		}


	public void setStoreRecommend (	Boolean storeRecommend)
		{
			this.storeRecommend = storeRecommend;
		}


	public Date getStoreRecommendTime ( )
		{
			return storeRecommendTime;
		}


	public void setStoreRecommendTime (	Date storeRecommendTime)
		{
			this.storeRecommendTime = storeRecommendTime;
		}


	public Date getZtcApplyTime ( )
		{
			return ztcApplyTime;
		}


	public void setZtcApplyTime (	Date ztcApplyTime)
		{
			this.ztcApplyTime = ztcApplyTime;
		}


	public Date getZtcBeginTime ( )
		{
			return ztcBeginTime;
		}


	public void setZtcBeginTime (	Date ztcBeginTime)
		{
			this.ztcBeginTime = ztcBeginTime;
		}


	public Integer getZtcClickNum ( )
		{
			return ztcClickNum;
		}


	public void setZtcClickNum (Integer ztcClickNum)
		{
			this.ztcClickNum = ztcClickNum;
		}


	public Integer getZtcDredgePrice ( )
		{
			return ztcDredgePrice;
		}


	public void setZtcDredgePrice (	Integer ztcDredgePrice)
		{
			this.ztcDredgePrice = ztcDredgePrice;
		}


	public Integer getZtcGold ( )
		{
			return ztcGold;
		}


	public void setZtcGold (Integer ztcGold)
		{
			this.ztcGold = ztcGold;
		}


	public Integer getZtcPayStatus ( )
		{
			return ztcPayStatus;
		}


	public void setZtcPayStatus (	Integer ztcPayStatus)
		{
			this.ztcPayStatus = ztcPayStatus;
		}


	public Integer getZtcPrice ( )
		{
			return ztcPrice;
		}


	public void setZtcPrice (	Integer ztcPrice)
		{
			this.ztcPrice = ztcPrice;
		}


	public Integer getZtcStatus ( )
		{
			return ztcStatus;
		}


	public void setZtcStatus (	Integer ztcStatus)
		{
			this.ztcStatus = ztcStatus;
		}


	public Long getGcId ( )
		{
			return gcId;
		}


	public void setGcId (	Long gcId)
		{
			this.gcId = gcId;
		}


	public Long getGoodsBrandId ( )
		{
			return goodsBrandId;
		}


	public void setGoodsBrandId (	Long goodsBrandId)
		{
			this.goodsBrandId = goodsBrandId;
		}


	public Long getGoodsMainPhotoId ( )
		{
			return goodsMainPhotoId;
		}


	public void setGoodsMainPhotoId (	Long goodsMainPhotoId)
		{
			this.goodsMainPhotoId = goodsMainPhotoId;
		}


	public Long getGoodsStoreId ( )
		{
			return goodsStoreId;
		}


	public void setGoodsStoreId (	Long goodsStoreId)
		{
			this.goodsStoreId = goodsStoreId;
		}


	public Long getZtcAdminId ( )
		{
			return ztcAdminId;
		}


	public void setZtcAdminId (	Long ztcAdminId)
		{
			this.ztcAdminId = ztcAdminId;
		}


	public Integer getGoodsCollect ( )
		{
			return goodsCollect;
		}


	public void setGoodsCollect (	Integer goodsCollect)
		{
			this.goodsCollect = goodsCollect;
		}


	public Integer getGroupBuy ( )
		{
			return groupBuy;
		}


	public void setGroupBuy (	Integer groupBuy)
		{
			this.groupBuy = groupBuy;
		}


	public Integer getGoodsChoiceType ( )
		{
			return goodsChoiceType;
		}


	public void setGoodsChoiceType (Integer goodsChoiceType)
		{
			this.goodsChoiceType = goodsChoiceType;
		}


	public Long getGroupId ( )
		{
			return groupId;
		}


	public void setGroupId (Long groupId)
		{
			this.groupId = groupId;
		}


	public Integer getActivityStatus ( )
		{
			return activityStatus;
		}


	public void setActivityStatus (	Integer activityStatus)
		{
			this.activityStatus = activityStatus;
		}


	public Integer getBargainStatus ( )
		{
			return bargainStatus;
		}


	public void setBargainStatus (	Integer bargainStatus)
		{
			this.bargainStatus = bargainStatus;
		}


	public Integer getDeliveryStatus ( )
		{
			return deliveryStatus;
		}


	public void setDeliveryStatus (	Integer deliveryStatus)
		{
			this.deliveryStatus = deliveryStatus;
		}


	public BigDecimal getGoodsCurrentPrice ( )
		{
			return goodsCurrentPrice;
		}


	public void setGoodsCurrentPrice (	BigDecimal goodsCurrentPrice)
		{
			this.goodsCurrentPrice = goodsCurrentPrice;
		}


	public BigDecimal getGoodsVolume ( )
		{
			return goodsVolume;
		}


	public void setGoodsVolume (BigDecimal goodsVolume)
		{
			this.goodsVolume = goodsVolume;
		}


	public BigDecimal getEmsTransFee ( )
		{
			return emsTransFee;
		}


	public void setEmsTransFee (BigDecimal emsTransFee)
		{
			this.emsTransFee = emsTransFee;
		}


	public BigDecimal getExpressTransFee ( )
		{
			return expressTransFee;
		}


	public void setExpressTransFee (BigDecimal expressTransFee)
		{
			this.expressTransFee = expressTransFee;
		}


	public BigDecimal getMailTransFee ( )
		{
			return mailTransFee;
		}


	public void setMailTransFee (	BigDecimal mailTransFee)
		{
			this.mailTransFee = mailTransFee;
		}


	public Long getTransportId ( )
		{
			return transportId;
		}


	public void setTransportId (Long transportId)
		{
			this.transportId = transportId;
		}


	public Integer getCombinStatus ( )
		{
			return combinStatus;
		}


	public void setCombinStatus (	Integer combinStatus)
		{
			this.combinStatus = combinStatus;
		}


	public Date getCombinBeginTime ( )
		{
			return combinBeginTime;
		}


	public void setCombinBeginTime (Date combinBeginTime)
		{
			this.combinBeginTime = combinBeginTime;
		}


	public Date getCombinEndTime ( )
		{
			return combinEndTime;
		}


	public void setCombinEndTime (	Date combinEndTime)
		{
			this.combinEndTime = combinEndTime;
		}


	public BigDecimal getCombinPrice ( )
		{
			return combinPrice;
		}


	public void setCombinPrice (BigDecimal combinPrice)
		{
			this.combinPrice = combinPrice;
		}


	public BigDecimal getDescriptionEvaluate ( )
		{
			return descriptionEvaluate;
		}


	public void setDescriptionEvaluate (BigDecimal descriptionEvaluate)
		{
			this.descriptionEvaluate = descriptionEvaluate;
		}


	public Boolean getWeixinShopHot ( )
		{
			return weixinShopHot;
		}


	public void setWeixinShopHot (	Boolean weixinShopHot)
		{
			this.weixinShopHot = weixinShopHot;
		}


	public Date getWeixinShopHottime ( )
		{
			return weixinShopHottime;
		}


	public void setWeixinShopHottime (	Date weixinShopHottime)
		{
			this.weixinShopHottime = weixinShopHottime;
		}


	public Boolean getWeixinShopRecommend ( )
		{
			return weixinShopRecommend;
		}


	public void setWeixinShopRecommend (Boolean weixinShopRecommend)
		{
			this.weixinShopRecommend = weixinShopRecommend;
		}


	public Date getWeixinShopRecommendtime ( )
		{
			return weixinShopRecommendtime;
		}


	public void setWeixinShopRecommendtime (Date weixinShopRecommendtime)
		{
			this.weixinShopRecommendtime = weixinShopRecommendtime;
		}


	public String getSalesPromotion ( )
		{
			return salesPromotion;
		}


	public void setSalesPromotion (	String salesPromotion)
		{
			this.salesPromotion = salesPromotion;
		}


	public String getWenxinTip ( )
		{
			return wenxinTip;
		}


	public void setWenxinTip (	String wenxinTip)
		{
			this.wenxinTip = wenxinTip == null ? null : wenxinTip.trim ();
		}


	public String getGoodsInfo ( )
		{
			return goodsInfo;
		}


	public void setGoodsInfo (	String goodsInfo)
		{
			this.goodsInfo = goodsInfo;
		}


	public Long getStoreNavId ( )
		{
			return storeNavId;
		}


	public void setStoreNavId (	Long storeNavId)
		{
			this.storeNavId = storeNavId;
		}

	private Long pointId;   // 商品评分信息外键id


	public Long getPointId ( )
		{
			return pointId;
		}


	public void setPointId (Long pointId)
		{
			this.pointId = pointId;
		}

	private GoodsBrand goodsBrand;

	private Group group;

	private GoodsClassWithBLOBs gc;

	private Store goodsStore;

	private User ztcAdmin;

	private TransportWithBLOBs transport;

	private StoreNavigation storeNav;

	private DeliveryGoods dMainGoods;

	private GoodsReturnItem gri;

	private Accessory goodsMainPhoto;// 商品照片

	private GoodsPoint point;

	private GoodsModuleFloor floor;

	private GoodsModuleFloorNext floorNext;

	private List <Dynamic> dynamics = new ArrayList <Dynamic> ();

	private List <BargainGoods> bargainGoodsList = new ArrayList <BargainGoods> ();

	private List <DeliveryGoods> dGoodsList = new ArrayList <DeliveryGoods> ();

	private List <ActivityGoods> agGoodsList = new ArrayList <ActivityGoods> ();

	private List <GoodsSpecProperty> goodsSpecs = new ArrayList <GoodsSpecProperty> ();

	private List <ConsultWithBLOBs> consults = new ArrayList <ConsultWithBLOBs> ();

	private List <Favorite> favs = new ArrayList <Favorite> ();

	private List <GroupGoods> groupGoodsList = new ArrayList <GroupGoods> ();

	private List <GoodsWithBLOBs> combinGoods = new ArrayList <GoodsWithBLOBs> ();

	private List <EvaluateWithBLOBs> evaluates = new ArrayList <EvaluateWithBLOBs> ();// 商品评论，评价

	private List <Accessory> goodsPhotos = new ArrayList <Accessory> ();

	private List <UserGoodsClass> goodsUgcs = new ArrayList <UserGoodsClass> ();

	// 商品属性集合
	private List <GoodsSpec> specs = new ArrayList <GoodsSpec> ();


	public List <GoodsSpec> getSpecs ( )
		{
			return specs;
		}


	public void setSpecs (	List <GoodsSpec> specs)
		{
			this.specs = specs;
		}


	public Group getGroup ( )
		{
			return group;
		}


	public void setGroup (	Group group)
		{
			this.group = group;
			if (group != null)
			{
				this.groupId = group.getId ();
			}
		}


	public GoodsPoint getPoint ( )
		{
			return point;
		}


	public void setPoint (	GoodsPoint point)
		{
			this.point = point;
			if (point != null)
				this.pointId = point.getId ();
		}


	public GoodsClassWithBLOBs getGc ( )
		{
			return gc;
		}


	public void setGc (	GoodsClassWithBLOBs gc)
		{
			this.gc = gc;
			if (gc != null)
				this.gcId = gc.getId ();
		}


	public TransportWithBLOBs getTransport ( )
		{
			return transport;
		}


	public void setTransport (	TransportWithBLOBs transport)
		{
			this.transport = transport;
			if (transport != null)
				this.transportId = transport.getId ();
		}


	public GoodsModuleFloor getFloor ( )
		{
			return floor;
		}


	public void setFloor (	GoodsModuleFloor floor)
		{
			this.floor = floor;
		}


	public StoreNavigation getStoreNav ( )
		{
			return storeNav;
		}


	public void setStoreNav (	StoreNavigation storeNav)
		{
			this.storeNav = storeNav;
			if (storeNav != null)
				this.storeNavId = storeNav.getId ();
		}


	public List <Dynamic> getDynamics ( )
		{
			return dynamics;
		}


	public void setDynamics (	List <Dynamic> dynamics)
		{
			this.dynamics = dynamics;
		}


	public List <BargainGoods> getBargainGoodsList ( )
		{
			return bargainGoodsList;
		}


	public void setBargainGoodsList (	List <BargainGoods> bargainGoodsList)
		{
			this.bargainGoodsList = bargainGoodsList;
		}


	public List <GoodsWithBLOBs> getCombinGoods ( )
		{
			return combinGoods;
		}


	public void setCombinGoods (List <GoodsWithBLOBs> combinGoods)
		{
			this.combinGoods = combinGoods;
		}


	public GoodsReturnItem getGri ( )
		{
			return gri;
		}


	public void setGri (GoodsReturnItem gri)
		{
			this.gri = gri;
		}


	public GoodsBrand getGoodsBrand ( )
		{
			return goodsBrand;
		}


	public void setGoodsBrand (	GoodsBrand goodsBrand)
		{
			this.goodsBrand = goodsBrand;
			if (goodsBrand != null)
				this.goodsBrandId = goodsBrand.getId ();
		}


	public Store getGoodsStore ( )
		{
			return goodsStore;
		}


	public void setGoodsStore (	Store goodsStore)
		{
			this.goodsStore = goodsStore;
			if (goodsStore != null)
				this.goodsStoreId = goodsStore.getId ();
		}


	public User getZtcAdmin ( )
		{
			return ztcAdmin;
		}


	public void setZtcAdmin (	User ztcAdmin)
		{
			this.ztcAdmin = ztcAdmin;
		}


	public DeliveryGoods getdMainGoods ( )
		{
			return dMainGoods;
		}


	public void setdMainGoods (	DeliveryGoods dMainGoods)
		{
			this.dMainGoods = dMainGoods;
		}


	public Accessory getGoodsMainPhoto ( )
		{
			return goodsMainPhoto;
		}


	public void setGoodsMainPhoto (	Accessory goodsMainPhoto)
		{
			this.goodsMainPhoto = goodsMainPhoto;
		}


	public List <DeliveryGoods> getdGoodsList ( )
		{
			return dGoodsList;
		}


	public void setdGoodsList (	List <DeliveryGoods> dGoodsList)
		{
			this.dGoodsList = dGoodsList;
		}


	public List <ActivityGoods> getAgGoodsList ( )
		{
			return agGoodsList;
		}


	public void setAgGoodsList (List <ActivityGoods> agGoodsList)
		{
			this.agGoodsList = agGoodsList;
		}


	public List <GroupGoods> getGroupGoodsList ( )
		{
			return groupGoodsList;
		}


	public void setGroupGoodsList (	List <GroupGoods> groupGoodsList)
		{
			this.groupGoodsList = groupGoodsList;
		}


	public List <ConsultWithBLOBs> getConsults ( )
		{
			return consults;
		}


	public void setConsults (	List <ConsultWithBLOBs> consults)
		{
			this.consults = consults;
		}


	public List <EvaluateWithBLOBs> getEvaluates ( )
		{
			return evaluates;
		}


	public void setEvaluates (	List <EvaluateWithBLOBs> evaluates)
		{
			this.evaluates = evaluates;
		}


	public List <Favorite> getFavs ( )
		{
			return favs;
		}


	public void setFavs (	List <Favorite> favs)
		{
			this.favs = favs;
		}


	public List <GoodsSpecProperty> getGoodsSpecs ( )
		{
			return goodsSpecs;
		}


	public void setGoodsSpecs (	List <GoodsSpecProperty> goodsSpecs)
		{
			this.goodsSpecs = goodsSpecs;
		}


	public List <Accessory> getGoodsPhotos ( )
		{
			return goodsPhotos;
		}


	public void setGoodsPhotos (List <Accessory> goodsPhotos)
		{
			this.goodsPhotos = goodsPhotos;
		}


	public List <UserGoodsClass> getGoodsUgcs ( )
		{
			return goodsUgcs;
		}


	public void setGoodsUgcs (	List <UserGoodsClass> goodsUgcs)
		{
			this.goodsUgcs = goodsUgcs;
		}


	public Integer getRefundServerTime ( )
		{
			return refundServerTime;
		}


	public void setRefundServerTime (	Integer refundServerTime)
		{
			this.refundServerTime = refundServerTime;
		}


	public GoodsModuleFloorNext getFloorNext ( )
		{
			return floorNext;
		}


	public void setFloorNext (	GoodsModuleFloorNext floorNext)
		{
			this.floorNext = floorNext;
		}


	public BigDecimal getGoodsRate ( )
		{
			return goodsRate;
		}


	public void setGoodsRate (	BigDecimal goodsRate)
		{
			this.goodsRate = goodsRate;
		}
}