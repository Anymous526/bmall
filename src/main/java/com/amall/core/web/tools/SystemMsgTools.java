package com.amall.core.web.tools;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.SystemMsg;
import com.amall.core.bean.SystemMsgExample;
import com.amall.core.bean.SystemMsgRecord;
import com.amall.core.bean.SystemMsgRecordExample;
import com.amall.core.service.systemmsg.ISystemMsgService;
import com.amall.core.service.systemmsgrecord.ISystemMsgRecordService;

@Component
public class SystemMsgTools {
	
	public static final int VIP_0 = 1;
	
	public static final int VIP_1 = 2;
	
	public static final int VIP_2 = 3;
	
	public static final int VIP_3 = 4;
	
	public static final int SEND_GOODS = 3;
	
	public static final int HAVE_ORDER = 4;

	@Autowired
	private ISystemMsgRecordService recordService;
	
	@Autowired
	private ISystemMsgService msgService;
	
	/** 
	* @Title: sendMsg 
	* @Description: 发送一条消息到用户系统消息
	* @param level 发送类型
	* @throws 
	* @author tangxiang
	* @date 2015年10月28日
	*/
	public void sendMsg(Long userId, Integer level)
	{
		SystemMsg msg = getSystemMsg(level);
		
		if(msg != null)
		{
			SystemMsgRecord record = new SystemMsgRecord();
			
			record.setUserId(userId);
			record.setAddTime(new Date());
			record.setMsgId(msg.getId());
			record.setReadStatus(false);
			recordService.add(record);
		}
			
	}
	
	/** 
	* @Title: isUnreadMsg 
	* @Description: 判断是否存在未读消息
	* @param userId
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月28日
	*/
	public Boolean isUnreadMsg(Long userId)
	{
		SystemMsgRecordExample example = new SystemMsgRecordExample();
		example.createCriteria().andUserIdEqualTo(userId).andReadStatusEqualTo(false);
		
		List list = recordService.getObjectList(example);
		
		if(list != null && !list.isEmpty()) return true;
		
		return false;
	}
	
	private SystemMsg getSystemMsg(Integer level)
	{
		SystemMsgExample example = new SystemMsgExample();
		example.createCriteria().andSequenceEqualTo(level);
		
		List<SystemMsg> list = msgService.getObjectList(example);
		
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}
	
}
