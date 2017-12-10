package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsFloorWithBLOBs extends GoodsFloor {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String gfGcGoods;

    private String gfGcList;

    private String gfLeftAdv;

    private String gfListGoods;

    private String gfRightAdv;

    private String gfBrandList;
    

    public String getGfGcGoods() {
        return gfGcGoods;
    }

    public void setGfGcGoods(String gfGcGoods) {
        this.gfGcGoods = gfGcGoods == null ? null : gfGcGoods.trim();
    }

    public String getGfGcList() {
        return gfGcList;
    }

    public void setGfGcList(String gfGcList) {
        this.gfGcList = gfGcList == null ? null : gfGcList.trim();
    }

    public String getGfLeftAdv() {
        return gfLeftAdv;
    }

    public void setGfLeftAdv(String gfLeftAdv) {
        this.gfLeftAdv = gfLeftAdv == null ? null : gfLeftAdv.trim();
    }

    public String getGfListGoods() {
        return gfListGoods;
    }

    public void setGfListGoods(String gfListGoods) {
        this.gfListGoods = gfListGoods == null ? null : gfListGoods.trim();
    }

    public String getGfRightAdv() {
        return gfRightAdv;
    }

    public void setGfRightAdv(String gfRightAdv) {
        this.gfRightAdv = gfRightAdv == null ? null : gfRightAdv.trim();
    }

    public String getGfBrandList() {
        return gfBrandList;
    }

    public void setGfBrandList(String gfBrandList) {
        this.gfBrandList = gfBrandList == null ? null : gfBrandList.trim();
    }
    
    
    private List<GoodsFloorWithBLOBs> childs = new ArrayList<GoodsFloorWithBLOBs>();
    private GoodsFloor parent;
    
    private List<GoodsClassWithBLOBs> gcs = new ArrayList<GoodsClassWithBLOBs>();
    
    private List<GoodsBrand> brands = new ArrayList<GoodsBrand>();
    
    private String gfMainPhoto;
    
    private List<GoodsClassWithBLOBs> leftGcs = new ArrayList<GoodsClassWithBLOBs>();
    
    
    

 
	public List<GoodsClassWithBLOBs> getLeftGcs() {
		return leftGcs;
	}

	public void setLeftGcs(List<GoodsClassWithBLOBs> leftGcs) {
		this.leftGcs = leftGcs;
	}

	public List<GoodsClassWithBLOBs> getGcs() {
		return gcs;
	}

	public void setGcs(List<GoodsClassWithBLOBs> gcs) {
		this.gcs = gcs;
	}

	public List<GoodsBrand> getBrands() {
		return brands;
	}

	public void setBrands(List<GoodsBrand> brands) {
		this.brands = brands;
	}



	public String getGfMainPhoto() {
		return gfMainPhoto;
	}

	public void setGfMainPhoto(String gfMainPhoto) {
		this.gfMainPhoto = gfMainPhoto;
	}

	public List<GoodsFloorWithBLOBs> getChilds() {
		return childs;
	}

	public void setChilds(List<GoodsFloorWithBLOBs> childs) {
		this.childs = childs;
	}

	public GoodsFloor getParent() {
		return parent;
	}

	public void setParent(GoodsFloor parent) {
		this.parent = parent;
	}
	
	
    
}