package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import com.amall.core.dao.GroupClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GroupClassServiceImpl implements IGroupClassService {

	@Resource
	private GroupClassMapper groupClassDao;

	public Long add(GroupClass example) {
		
		return groupClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GroupClass getByKey(Long id) {
		
		return groupClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return groupClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupClassExample example) {
		
		return groupClassDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupClass record) {
		
		return groupClassDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),groupClassDao.countByExample(example));
		p.setList(groupClassDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GroupClass> getObjectList(GroupClassExample example) {
		
		return groupClassDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupClassExample example) {
		
		return groupClassDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<GroupClass> selectByExampleWithPage(GroupClassExample example) {
		return groupClassDao.selectByExampleWithPage(example);
	}


	
	
	
}
