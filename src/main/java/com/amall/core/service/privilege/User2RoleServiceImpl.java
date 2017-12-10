package com.amall.core.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amall.core.bean.User2Role;
import com.amall.core.bean.User2RoleExample;
import com.amall.core.dao.User2RoleMapper;

@Service
public class User2RoleServiceImpl implements IUser2RoleService {

	@Resource
	private User2RoleMapper user2RoleDao;
	
	public Long add(User2Role example) {
		return user2RoleDao.insertSelective(example);
	}

	public Integer deleteByExample(User2RoleExample example) {
		return user2RoleDao.deleteByExample(example);
	}

	public List<User2Role> getObjectList(User2RoleExample example) {
		return user2RoleDao.selectByExample(example);
	}

}
