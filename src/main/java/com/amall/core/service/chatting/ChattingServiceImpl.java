package com.amall.core.service.chatting;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.Chatting;
import com.amall.core.bean.ChattingExample;
import com.amall.core.dao.ChattingMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ChattingServiceImpl implements IChattingService {

	@Resource
	private ChattingMapper chattingDao;

	public Long add(Chatting example) {
		return chattingDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Chatting getByKey(Long id) {
		return chattingDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return chattingDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ChattingExample example) {
		return chattingDao.deleteByExample(example);
	}

	public Integer updateByObject(Chatting record) {
		return chattingDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ChattingExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),chattingDao.countByExample(example));
		p.setList(chattingDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Chatting> getObjectList(ChattingExample example) {
		return chattingDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ChattingExample example) {
		return chattingDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<Chatting> selectChatting(Map<? extends Object,? extends Object> map) {
		return chattingDao.selectChattings(map);
	}


	
	
}
