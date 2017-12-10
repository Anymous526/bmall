package com.amall.core.service.systemmsgrecord;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SystemMsgRecord;
import com.amall.core.bean.SystemMsgRecordExample;
import com.amall.core.dao.SystemMsgRecordMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SystemRecordServiceImpl implements ISystemMsgRecordService {

	@Resource
	private SystemMsgRecordMapper systemMsgRecordDao;

	public Integer add(SystemMsgRecord example) {
		return systemMsgRecordDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SystemMsgRecord getByKey(Long id) {
		return systemMsgRecordDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return systemMsgRecordDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SystemMsgRecordExample example) {
		return systemMsgRecordDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<SystemMsgRecord> getObjectList(SystemMsgRecordExample example) {
		return systemMsgRecordDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SystemMsgRecordExample example) {
		return systemMsgRecordDao.countByExample(example);
	}

	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SystemMsgRecordExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),systemMsgRecordDao.countByExample(example));
		p.setList(systemMsgRecordDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Override
	public Integer updateByObject(SystemMsgRecord record)
	{
		return systemMsgRecordDao.updateByPrimaryKeySelective(record);
	}
	
}
