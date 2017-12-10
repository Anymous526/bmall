package com.amall.core.service.chatting;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ChattingLog;
import com.amall.core.bean.ChattingLogExample;
import com.amall.core.dao.ChattingLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ChattingLogServiceImpl implements IChattingLogService {

	@Resource
	private ChattingLogMapper chattingLogDao;

	public Long add(ChattingLog example) {
		return chattingLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ChattingLog getByKey(Long id) {
		return chattingLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return chattingLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ChattingLogExample example) {
		return chattingLogDao.deleteByExample(example);
	}

	public Integer updateByObject(ChattingLog record) {
		return chattingLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ChattingLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),chattingLogDao.countByExample(example));
		p.setList(chattingLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ChattingLog> getObjectList(ChattingLogExample example) {
		return chattingLogDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ChattingLogExample example) {
		return chattingLogDao.countByExample(example);
	}
	public List<ChattingLog> selectLogsByMarkAndUser1Id(long user1Id) {
		return chattingLogDao.selectLogsByMarkAndUser1Id(user1Id);
	}

	
	
}
