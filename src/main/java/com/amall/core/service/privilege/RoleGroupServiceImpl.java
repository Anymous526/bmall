package com.amall.core.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.RoleGroup;
import com.amall.core.bean.RoleGroupExample;
import com.amall.core.dao.RoleGroupMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RoleGroupServiceImpl implements IRoleGroupService {

	@Resource 
	private RoleGroupMapper  roleGroupDao;

	public Long add(RoleGroup example) {
		
		return roleGroupDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public RoleGroup getByKey(Long id) {
		
		return roleGroupDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return roleGroupDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(RoleGroupExample example) {
		
		return roleGroupDao.deleteByExample(example);
	}

	public Integer updateByObject(RoleGroup record) {
		
		return roleGroupDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(RoleGroupExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),roleGroupDao.countByExample(example));
		p.setList(roleGroupDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<RoleGroup> getObjectList(RoleGroupExample example) {
		
		return roleGroupDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(RoleGroupExample example) {
		
		return roleGroupDao.countByExample(example);
	}
	
}
