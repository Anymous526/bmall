package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.google.common.collect.Lists;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author tangxiang
 *
 */
@Component
public class SearchTools
{
	
	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;
	
	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;
	
	/**
	 * @Title: getGoodsAndGoodsSpcOfGoodsList
	 * @Description: 根据List<GoodsWithBLOBs> 返回对应的规格属性和查询条件信息List
	 * @param searchCondition
	 * @param goodsList
	 * @return
	 * @return SearchGoodsInfo
	 * @author tangxiang
	 * @date 2015年8月20日 下午4:14:14 
	 */
	public List<GoodsSpecification> getGoodsAndGoodsSpcOfGoodsList(List<GoodsWithBLOBs> goodsList)
	{
		
		List<GoodsSpecification> retList = new ArrayList<GoodsSpecification>();
		
		//[{"key":"1","value":"3|5|41"}]
		for(GoodsWithBLOBs goods:goodsList)
		{
			GoodsSpecification specification = null;
			if (goods.getGoodsProperty() != null && !goods.getGoodsProperty().equals("")) 
			{
				JSONArray array = JSONArray.fromObject(goods
						.getGoodsProperty());
				for (int i = 0; i < array.size(); i++) 
				{
					JSONObject obj = array.getJSONObject(i);
					String keyValue = obj.getString("key");
					specification = this.goodsSpecificationService.getByKey(Long.valueOf(keyValue));
					if (specification == null) 
					{
						continue;
					}

					String value = obj.getString("value");
					String[] strArray = value.split("\\|");
					if (strArray == null || strArray.length == Globals.NUBER_ZERO) 
					{
						continue;
					}
					
					List<GoodsSpecProperty> specProperties = getGoodsSpecPropertyS(strArray);
					
					if(!specProperties.isEmpty())
					{
						specification.setProperties(specProperties);
					}
				}
			}
			
			retList.add(specification);
		}
		
		return retList;
	}
	
	/**
	 * @Title: getGoodsSpecPropertyS
	 * @Description:根据属性值ID数组 获取属性值对象, 第一步查询入口
	 * @param strArray
	 * @return
	 * @return List<GoodsSpecProperty>
	 * @author tangxiang
	 * @date 2015年8月20日 下午4:18:51 
	 */
	private List<GoodsSpecProperty> getGoodsSpecPropertyS(String[] strArray)
	{
		List<GoodsSpecProperty> specProperties = new ArrayList<GoodsSpecProperty>();
		for (String strId : strArray) 
		{
			GoodsSpecProperty goodsSpecProperty = this.goodsSpecPropertyService
					.getByKey(Long.valueOf(strId));
			
			if (goodsSpecProperty == null) 
			{
				continue;
			}
			specProperties.add(goodsSpecProperty);
		}
		
		return specProperties;
	}
	
	/**
	 * @Title: searchGoodsOfSpec
	 * @Description: 匹配规格属性，第二步入口
	 * @param specStr
	 * @param goodsList
	 * @return
	 * @return List<GoodsWithBLOBs>
	 * @author tangxiang
	 * @date 2015年8月20日 下午5:16:42 
	 */
	public List<GoodsWithBLOBs> searchGoodsOfSpec(String specStr, List<GoodsWithBLOBs> goodsList)
	{
		List<GoodsWithBLOBs> bloBs = new ArrayList<GoodsWithBLOBs>();
		
		
		for(GoodsWithBLOBs goods:goodsList)
		{
			if (goods.getGoodsProperty() != null && !goods.getGoodsProperty().equals("")) 
			{
				JSONArray array = JSONArray.fromObject(goods
						.getGoodsProperty());
				for (int i = 0; i < array.size(); i++) 
				{
					JSONObject obj = array.getJSONObject(i);

					String value = obj.getString("value");
					String[] strArray = value.split("\\|");
					if (strArray == null || strArray.length == Globals.NUBER_ZERO) 
					{
						continue;
					}
					
					/* 查找到满足条件的就结束循环 */
					if(isContainProperty(specStr, strArray))
					{
						bloBs.add(goods);
						break;
					}
				}
			}
		}
		
		return bloBs;
	}
	
	/**
	 * @Title: isContainProperty
	 * @Description: 判断传入条件属否被完全包含
	 * @param specStr
	 * @param strArray
	 * @return
	 * @return boolean
	 * @author tangxiang
	 * @date 2015年8月20日 下午5:14:55 
	 */
	private boolean isContainProperty(String specStr, String[] strArray)
	{
		String[] searchArray = specStr.split("\\|");
		
		if (searchArray == null || searchArray.length == Globals.NUBER_ZERO) 
		{
			return true;
		}
		
		List<String> oldList = Arrays.asList(strArray);
		List<String> newList = Arrays.asList(searchArray);
		return oldList.containsAll(newList);
	}
}
