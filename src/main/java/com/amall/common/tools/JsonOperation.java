package com.amall.common.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonOperation
{
	/** 
	* @Title: votoSortJson 
	* @Description: vo对象转换成一个字典排序json串
	* @param vo
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月8日
	*/
	public static String votoSortJson(Object vo)
	{
		Map<String, Object> map = ObjectReflectTools.toSortMap(vo);
		return Json.gson.toJson(map);
	}
	
	/** 
	* @Title: votoJson 
	* @Description: vo对象转换成一个json串
	* @param vo
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月8日
	*/
	public static String votoJson(Object vo)
	{
		Map<String, Object> map = ObjectReflectTools.toMap(vo);
		return Json.gson.toJson(map);
	}
	
	/** 
	* @Title: getSpecificationMap 
	* @Description: 注意 ： 只使用于读取商品规格属性的解析
	* @param json
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年1月7日
	*/
	@SuppressWarnings({"rawtypes" })
	public static Map<String, String> getSpecificationMap(String json)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		List list = Json.gson.fromJson(json, ArrayList.class);
		
		if(list != null)
		{
			for(int i = 0; i < list.size(); i++)
			{
				Map tempMap = (Map) list.get(i);
				map.put(String.valueOf(tempMap.get("key")), String.valueOf(tempMap.get("value")));
			}
		}
		
		return map;
	}
	
}
