package com.amall.core.web.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import com.amall.core.service.group.IGroupBrandService;


@Component
public class GroupBrandTools {

	@Autowired
	private IGroupBrandService groupBrandService;
	
	/**
	 * 
	 * <p>Title: getGroupBrand</p>
	 * <p>Description: 每一个groupId唯一对应一个brandId，拿到GroupBrand就可以得到Brand</p>
	 * @param groupId
	 * @return
	 */
	public GroupBrand getGroupBrand(Long groupId)
	{
		GroupBrandExample groupBrandExample=new GroupBrandExample();
		groupBrandExample.clear();
		GroupBrandExample.Criteria groupBrandCriteria=groupBrandExample.createCriteria();
		groupBrandCriteria.andGroupIdEqualTo(groupId);
		List<GroupBrand> list=this.groupBrandService.getObjectList(groupBrandExample);
		GroupBrand groupBrand=new GroupBrand();
		if(list.size()!=0)
		{
			groupBrand=list.get(0);
		}
		return groupBrand;
	}
	
	
	
	
	
	
	
	
	
}
