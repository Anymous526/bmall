package com.amall.core.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.dao.RoleMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Resource 
	private RoleMapper  roleDAO;

	public Long add(Role example) {
		
		return roleDAO.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Role getByKey(Long id) {
		
		return roleDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return roleDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(RoleExample example) {
		
		return roleDAO.deleteByExample(example);
	}

	public Integer updateByObject(Role record) {
		
		return roleDAO.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(RoleExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),roleDAO.countByExample(example));
		p.setList(roleDAO.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Role> getObjectList(RoleExample example) {
		
		return roleDAO.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(RoleExample example) {
		
		return roleDAO.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<Role> getRolesToUserByUserIdAndDisplay(long id) {
		return roleDAO.getRolesToUserByUserIdAndDisplay(id);
	}
	
}
