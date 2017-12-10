package com.amall.core.service.chatting;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ChattingFriend;
import com.amall.core.bean.ChattingFriendExample;
import com.amall.core.dao.ChattingFriendMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ChattingFriendServiceImpl implements IChattingFriendService {

	@Resource
	private ChattingFriendMapper chattingFriendDao;

	public Long add(ChattingFriend example) {
		return chattingFriendDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ChattingFriend getByKey(Long id) {
		return chattingFriendDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return chattingFriendDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ChattingFriendExample example) {
		return chattingFriendDao.deleteByExample(example);
	}

	public Integer updateByObject(ChattingFriend record) {
		return chattingFriendDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ChattingFriendExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),chattingFriendDao.countByExample(example));
		p.setList(chattingFriendDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ChattingFriend> getObjectList(ChattingFriendExample example) {
		return chattingFriendDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ChattingFriendExample example) {
		return chattingFriendDao.countByExample(example);
	}


}
