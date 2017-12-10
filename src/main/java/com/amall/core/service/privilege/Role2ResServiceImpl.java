package com.amall.core.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Role2Res;
import com.amall.core.bean.Role2ResExample;
import com.amall.core.dao.Role2ResMapper;

@Service
@Transactional
public class Role2ResServiceImpl implements IRole2ResService {

	@Resource
	private Role2ResMapper role2ResMapper;
	
	public Long add(Role2Res example) {
		return role2ResMapper.insertSelective(example);
	}

	public Integer deleteByExample(Role2ResExample example) {
		return role2ResMapper.deleteByExample(example);
	}
	
	public Integer updateByObject(Role2Res record) {
		return null;
	}
	@Transactional(readOnly = true)
	public List<Role2Res> getObjectList(Role2ResExample example) {
		return role2ResMapper.selectByExample(example);
	}
	@Transactional(readOnly = true)
	public Integer getObjectListCount(Role2ResExample example) {
		return role2ResMapper.countByExample(example);
	}

}
