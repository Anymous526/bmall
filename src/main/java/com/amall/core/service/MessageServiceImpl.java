package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Message;
import com.amall.core.bean.MessageExample;
import com.amall.core.dao.MessageMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

	@Resource 
	private MessageMapper  messageDao;

	public Long add(Message example) {
		
		return messageDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Message getByKey(Long id) {
		
		return messageDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return messageDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(MessageExample example) {
		return messageDao.deleteByExample(example);
	}

	public Integer updateByObject(Message record) {
		return messageDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(MessageExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),messageDao.countByExample(example));
		p.setList(messageDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Message> getObjectList(MessageExample example) {
		return messageDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(MessageExample example) {
		return messageDao.countByExample(example);
	}


}
