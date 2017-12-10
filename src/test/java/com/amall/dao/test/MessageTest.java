package com.amall.dao.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.Message;
import com.amall.core.dao.MessageMapper;


public class MessageTest extends SpringJunitTest{
	@Autowired
	private MessageMapper messageMapper;
	@Test
	public void testAdd() {
		Message message = new Message();
		message.setId(2L);
		message.setAddtime(new Date());
		message.setContent("测试描述");
		message.setDeletestatus(false);
		message.setStatus(0);
		message.setType(0);
		messageMapper.insertSelective(message);
	}
}
