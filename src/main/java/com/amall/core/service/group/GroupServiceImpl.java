package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;
import com.amall.core.dao.GroupMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GroupServiceImpl implements IGroupService {

	@Resource
	private GroupMapper groupDao;

	public Long add(Group example) {
		return groupDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Group getByKey(Long id) {
		return groupDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return groupDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupExample example) {
		return groupDao.deleteByExample(example);
	}

	public Integer updateByObject(Group record) {
		return groupDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),groupDao.countByExample(example));
		p.setList(groupDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Group> getObjectList(GroupExample example) {
		return groupDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupExample example) {
		return groupDao.countByExample(example);
	}


}
