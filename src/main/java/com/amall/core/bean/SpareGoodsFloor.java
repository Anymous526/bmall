package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SpareGoodsFloor implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String adverId;

    private Integer sequence;

    private String title;//楼层标题

    private Integer visable;

    private Long sgcId;

    private Integer adverType;

    private String advertUrl;

    private Long advertId;

    private Long advertImgId;

    private Boolean display;

    private Long adpId;

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

    public String getAdverId() {
        return adverId;
    }

    public void setAdverId(String adverId) {
        this.adverId = adverId == null ? null : adverId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getVisable() {
        return visable;
    }

    public void setVisable(Integer visable) {
        this.visable = visable;
    }

    public Long getSgcId() {
        return sgcId;
    }

    public void setSgcId(Long sgcId) {
        this.sgcId = sgcId;
    }

    public Integer getAdverType() {
        return adverType;
    }

    public void setAdverType(Integer adverType) {
        this.adverType = adverType;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public Long getAdvertImgId() {
        return advertImgId;
    }

    public void setAdvertImgId(Long advertImgId) {
        this.advertImgId = advertImgId;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Long getAdpId() {
        return adpId;
    }

    public void setAdpId(Long adpId) {
        this.adpId = adpId;
    }
    
    private List<SpareGoodsWithBLOBs> sgs;
    private SpareGoodsClass sgc;
    private Accessory advert_img;
    private String advert_url;
    private AdvertPosition adp;

	public List<SpareGoodsWithBLOBs> getSgs() {
		return sgs;
	}

	public void setSgs(List<SpareGoodsWithBLOBs> sgs) {
		this.sgs = sgs;
	}

	public SpareGoodsClass getSgc() {
		return sgc;
	}

	public void setSgc(SpareGoodsClass sgc) {
		this.sgc = sgc;
		if(sgc!=null)
		{
			this.setSgcId(sgc.getId());
		}
	}

	public Accessory getAdvert_img() {
		return advert_img;
	}

	public void setAdvert_img(Accessory advert_img) {
		this.advert_img = advert_img;
		if(advert_img!=null)
		{
			this.setAdvertImgId(advert_img.getId());
		}
	}

	public String getAdvert_url() {
		return advert_url;
	}

	public void setAdvert_url(String advert_url) {
		this.advert_url = advert_url;
	}

	public AdvertPosition getAdp() {
		return adp;
	}

	public void setAdp(AdvertPosition adp) {
		this.adp = adp;
		if(adp!=null)
		{
			this.setAdpId(adp.getId());
		}
	}
    
    
    
}