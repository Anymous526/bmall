package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsAndStoreShow
{
	private String storeId;
	
	private String storeName;
	
	private String storePrice;
	
	private List<GoodsCartShow> goodsList = new ArrayList<GoodsCartShow>();

	public String getStoreId()
	{
		return storeId;
	}

	public void setStoreId(String storeId)
	{
		this.storeId = storeId;
	}

	public String getStoreName()
	{
		return storeName;
	}

	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}

	public List<GoodsCartShow> getGoodsList()
	{
		return goodsList;
	}

	public void setGoodsList(List<GoodsCartShow> goodsList)
	{
		this.goodsList = goodsList;
	}

	public String getStorePrice()
	{
		return storePrice;
	}

	public void setStorePrice(String storePrice)
	{
		this.storePrice = storePrice;
	}
	
	
}
