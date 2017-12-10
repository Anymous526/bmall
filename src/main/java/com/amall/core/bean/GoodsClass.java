package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>
 * Title: GoodsClass
 * </p>
 * <p>
 * Description: 商品一二三级分类
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月22日下午6:44:10
 * @version 1.0
 */
public class GoodsClass implements Serializable
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String classname;// 商品类名

	private Boolean display;

	private Integer level;

	private Boolean recommend;

	private Integer sequence;

	private Long goodstypeId;

	private Long parentId;

	/**
	 * 商品利率
	 */
	private BigDecimal rate;

	private String iconSys;

	private Integer iconType;

	private Long iconAccId;

	private Long firstGcImgId;

	private Long secondGcImgId;

	private Long moduleId;

	public Long getId ( )
		{
			return id;
		}

	public void setId (Long id)
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

	public void setDeletestatus (Boolean deletestatus)
		{
			this.deletestatus = deletestatus;
		}

	public String getClassname ( )
		{
			return classname;
		}

	public void setClassname (String classname)
		{
			this.classname = classname == null ? null : classname.trim ();
		}

	public Boolean getDisplay ( )
		{
			return display;
		}

	public void setDisplay (Boolean display)
		{
			this.display = display;
		}

	public Integer getLevel ( )
		{
			return level;
		}

	public void setLevel (Integer level)
		{
			this.level = level;
		}

	public Boolean getRecommend ( )
		{
			return recommend;
		}

	public void setRecommend (Boolean recommend)
		{
			this.recommend = recommend;
		}

	public Integer getSequence ( )
		{
			return sequence;
		}

	public void setSequence (Integer sequence)
		{
			this.sequence = sequence;
		}

	public Long getGoodstypeId ( )
		{
			return goodstypeId;
		}

	public void setGoodstypeId (Long goodstypeId)
		{
			this.goodstypeId = goodstypeId;
		}

	public BigDecimal getRate ( )
		{
			return rate;
		}

	public void setRate (BigDecimal rate)
		{
			this.rate = rate;
		}

	public Long getParentId ( )
		{
			return parentId;
		}

	public void setParentId (Long parentId)
		{
			this.parentId = parentId;
		}

	public String getIconSys ( )
		{
			return iconSys;
		}

	public void setIconSys (String iconSys)
		{
			this.iconSys = iconSys == null ? null : iconSys.trim ();
		}

	public Integer getIconType ( )
		{
			return iconType;
		}

	public void setIconType (Integer iconType)
		{
			this.iconType = iconType;
		}

	public Long getIconAccId ( )
		{
			return iconAccId;
		}

	public void setIconAccId (Long iconAccId)
		{
			this.iconAccId = iconAccId;
		}

	public Long getFirstGcImgId ( )
		{
			return firstGcImgId;
		}

	public void setFirstGcImgId (Long firstGcImgId)
		{
			this.firstGcImgId = firstGcImgId;
		}

	public Long getSecondGcImgId ( )
		{
			return secondGcImgId;
		}

	public void setSecondGcImgId (Long secondGcImgId)
		{
			this.secondGcImgId = secondGcImgId;
		}

	private BigDecimal descriptionEvaluate;

	private BigDecimal serviceEvaluate;

	private BigDecimal shipEvaluate;

	public BigDecimal getDescriptionEvaluate ( )
		{
			return descriptionEvaluate;
		}

	public void setDescriptionEvaluate (BigDecimal descriptionEvaluate)
		{
			this.descriptionEvaluate = descriptionEvaluate;
		}

	public BigDecimal getServiceEvaluate ( )
		{
			return serviceEvaluate;
		}

	public void setServiceEvaluate (BigDecimal serviceEvaluate)
		{
			this.serviceEvaluate = serviceEvaluate;
		}

	public BigDecimal getShipEvaluate ( )
		{
			return shipEvaluate;
		}

	public void setShipEvaluate (BigDecimal shipEvaluate)
		{
			this.shipEvaluate = shipEvaluate;
		}

	public Long getModuleId ( )
		{
			return moduleId;
		}

	public void setModuleId (Long moduleId)
		{
			this.moduleId = moduleId;
		}

	private Long groupId;

	private GoodsClassWithBLOBs parent;

	private GoodsType goodsType;

	private Accessory iconAcc;

	private Accessory firstGcImg;

	private Accessory secondGcImg;

	private List <GoodsClassWithBLOBs> childs = new ArrayList <GoodsClassWithBLOBs> ();

	private List <GoodsWithBLOBs> goodsList = new ArrayList <GoodsWithBLOBs> ();

	private List <GoodsClassStaple> gcss = new ArrayList <GoodsClassStaple> ();

	private List <Consult> consults = new ArrayList <Consult> ();

	private List <Evaluate> evaluates = new ArrayList <Evaluate> ();

	private List <Favorite> favs = new ArrayList <Favorite> ();

	private Group group;

	public GoodsClassWithBLOBs getParent ( )
		{
			return parent;
		}

	public void setParent (GoodsClassWithBLOBs parent)
		{
			this.parent = parent;
			if (parent != null)
				this.parentId = parent.getId ();
		}

	public GoodsType getGoodsType ( )
		{
			return goodsType;
		}

	public void setGoodsType (GoodsType goodsType)
		{
			this.goodsType = goodsType;
			if (goodsType != null)
				this.goodstypeId = goodsType.getId ();
		}

	public Accessory getIconAcc ( )
		{
			return iconAcc;
		}

	public void setIconAcc (Accessory iconAcc)
		{
			this.iconAcc = iconAcc;
			if (iconAcc != null)
				this.iconAccId = iconAcc.getId ();
		}

	public Accessory getFirstGcImg ( )
		{
			return firstGcImg;
		}

	public void setFirstGcImg (Accessory firstGcImg)
		{
			this.firstGcImg = firstGcImg;
			if (firstGcImg != null)
			{
				this.firstGcImgId = firstGcImg.getId ();
			}
		}

	public Accessory getSecondGcImg ( )
		{
			return secondGcImg;
		}

	public void setSecondGcImg (Accessory secondGcImg)
		{
			this.secondGcImg = secondGcImg;
			if (secondGcImg != null)
			{
				this.secondGcImgId = secondGcImg.getId ();
			}
		}

	public List <GoodsWithBLOBs> getGoodsList ( )
		{
			return goodsList;
		}

	public void setGoods_list (List <GoodsWithBLOBs> goodsList)
		{
			this.goodsList = goodsList;
		}

	public List <GoodsClassStaple> getGcss ( )
		{
			return gcss;
		}

	public void setGcss (List <GoodsClassStaple> gcss)
		{
			this.gcss = gcss;
		}

	public List <Consult> getConsults ( )
		{
			return consults;
		}

	public void setConsults (List <Consult> consults)
		{
			this.consults = consults;
		}

	public List <Evaluate> getEvaluates ( )
		{
			return evaluates;
		}

	public void setEvaluates (List <Evaluate> evaluates)
		{
			this.evaluates = evaluates;
		}

	public List <Favorite> getFavs ( )
		{
			return favs;
		}

	public void setFavs (List <Favorite> favs)
		{
			this.favs = favs;
		}

	public Long getGroupId ( )
		{
			return groupId;
		}

	public void setGroupId (Long groupId)
		{
			this.groupId = groupId;
		}

	public void setGoodsList (List <GoodsWithBLOBs> goodsList)
		{
			this.goodsList = goodsList;
		}

	public Group getGroup ( )
		{
			return group;
		}

	public void setGroup (Group group)
		{
			this.group = group;
			if (group != null)
				this.groupId = group.getId ();
		}

	public List <GoodsClassWithBLOBs> getChilds ( )
		{
			return childs;
		}

	public void setChilds (List <GoodsClassWithBLOBs> childs)
		{
			this.childs = childs;
		}
}