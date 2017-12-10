package com.amall.core.web.tools;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.web.page.Pagination;

@Component
public class GroupViewTools {

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	public Pagination query_goods(String group_id, int count) {
		Pagination p = new Pagination();
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andGroupIdEqualTo(CommUtil.null2Long(group_id));
		example.setPageNo(1);
		example.setPageSize(count);
		example.setOrderByClause("addTime desc");
		p = this.groupGoodsService.getObjectListWithPage(example);
		return p;
	}
	
	public Long checkTimeDiff(Date newDate)//计算时间差，小时
	{
		Calendar oldCalendar=Calendar.getInstance();
		Calendar newCalendar=Calendar.getInstance();
		oldCalendar.setTime(new Date());//获得当前的时间日期
		newCalendar.setTime(newDate);//获得开团时间
		long l1=oldCalendar.getTimeInMillis();
		long l2=newCalendar.getTimeInMillis();
		//计算相差的小时数
        long times=(l2-l1)/(60*60*1000);
        //System.out.println("相隔的小时数:"+times);
        return times;
	}
	
}
