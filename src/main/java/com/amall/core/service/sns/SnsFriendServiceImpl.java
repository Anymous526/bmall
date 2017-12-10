package com.amall.core.service.sns;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SnsFriend;
import com.amall.core.bean.SnsFriendExample;
import com.amall.core.dao.SnsFriendMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SnsFriendServiceImpl implements ISnsFriendService {

	@Resource 
	private SnsFriendMapper  snsFriendDao;

	public Long add(SnsFriend example) {
		return snsFriendDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SnsFriend getByKey(Long id) {
		return snsFriendDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return snsFriendDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SnsFriendExample example) {
		return snsFriendDao.deleteByExample(example);
	}

	public Integer updateByObject(SnsFriend record) {
		return snsFriendDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SnsFriendExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),snsFriendDao.countByExample(example));
		p.setList(snsFriendDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SnsFriend> getObjectList(SnsFriendExample example) {
		return snsFriendDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SnsFriendExample example) {
		return snsFriendDao.countByExample(example);
	}


}
