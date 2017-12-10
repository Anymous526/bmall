package com.amall.core.web.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Area;
import com.amall.core.service.address.IAreaService;

/**
 * 
 * <p>Title: AreaViewTools</p>
 * <p>Description: 获得本级地址和上级地址的组合信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:18:55
 * @version 1.0
 */
@Component
public class AreaViewTools {

	@Autowired
	private IAreaService areaService;
	/**
	 * 
	 * <p>Title: generic_area_info</p>
	 * <p>Description: 根据本级地址id，获得上级地址和本级地址 组合的字符串</p>
	 * @param area_id 地址id
	 * @return String 
	 */
	public String generic_area_info(String area_id) {
		String area_info = "";
		Area area = this.areaService.getByKey(CommUtil.null2Long(area_id));
		if (area != null) {
			area_info = area.getAreaname() + " ";
			if (area.getParentId() != null) {
				String info = generic_area_info(area.getParentId()
						.toString());
				area_info = info + area_info;
			}
		}
		return area_info;
	}
	
	/** 
	* @Title: getProvince 
	* @Description: 获取指定级别名字
	* @param area_id
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年9月18日
	*/
	public String getLevelName(Long area_id, int level)
	{
		String retStr = null;
		Area area = this.areaService.getByKey(area_id);
		if (area != null) 
		{
			if(area.getLevel() == level)
			{
				return area.getAreaname();
			}
			else
			{
				if(area.getParentId() != null)
				{
					retStr = getLevelName(area.getParentId(), level);
				}
			}
			
			
		}
		
		return retStr;
	}
	
	/** 
	* @Title: getProvince 
	* @Description: 获取省
	* @param area_id
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年9月18日
	*/
	public String getProvince(Long area_id)
	{
		return getLevelName(area_id, 1);
	}
	
	/** 
	* @Title: getCity 
	* @Description: 获取市
	* @param area_id
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年9月18日
	*/
	public String getCity(Long area_id)
	{
		return getLevelName(area_id, 2);
	}
}
