package com.amall.core.web.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Area;
import com.amall.core.service.address.IAreaService;

/**
 * 
 * <p>Title: AreaManageTools</p>
 * <p>Description: 获得区域地址详细信息工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-24下午4:20:07
 * @version 1.0
 */
@Component
public class AreaManageTools {

	@Autowired
	private IAreaService areaService;
	/**
	 * 
	 * <p>Title: generic_area_info</p>
	 * <p>Description: 根据传入的区域类，递归遍历获得区域地址的详细信息</p>
	 * @param area  区域信息描述类
	 * @return String  区域地址的详细信息
	 */
	public String generic_area_info(Area area) {
		String area_info = "";
		if (area != null) {
			area_info = area.getAreaname() + " ";
			if (area.getParent() != null) {
				String info = generic_area_info(area.getParent());
				area_info = info + area_info;
			}
		}
		return area_info;
	}
}
