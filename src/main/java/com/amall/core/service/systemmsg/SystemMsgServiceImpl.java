package com.amall.core.service.systemmsg;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SystemMsg;
import com.amall.core.bean.SystemMsgExample;
import com.amall.core.dao.SystemMsgMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SystemMsgServiceImpl implements ISystemMsgService {

	@Resource
	private SystemMsgMapper systemMsgDao;

	public Integer add(SystemMsg example) {
		return systemMsgDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SystemMsg getByKey(Long id) {
		return systemMsgDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return systemMsgDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SystemMsgExample example) {
		return systemMsgDao.deleteByExample(example);
	}

	public Integer updateByObject(SystemMsg record) {
		return systemMsgDao.updateByPrimaryKeyWithBLOBs(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SystemMsgExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),systemMsgDao.countByExample(example));
		p.setList(systemMsgDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SystemMsg> getObjectList(SystemMsgExample example) {
		return systemMsgDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SystemMsgExample example) {
		return systemMsgDao.countByExample(example);
	}

	
	
}
