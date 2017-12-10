package com.amall.core.service.loginsession;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.LoginSession;
import com.amall.core.bean.LoginSessionExample;
import com.amall.core.dao.LoginSessionMapper;

@Service
@Transactional
public class LoginSessionServiceImpl implements ILoginSessionService {

	@Resource
	private LoginSessionMapper loginSessionDao;

	public Integer add(LoginSession example) {
		return loginSessionDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public LoginSession getByKey(Long id) {
		return loginSessionDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return loginSessionDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(LoginSessionExample example) {
		return loginSessionDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<LoginSession> getObjectList(LoginSessionExample example) {
		return loginSessionDao.selectByExample(example);
	}
	
	@Transactional(readOnly=true)
	public Integer getObjectListCount(LoginSessionExample example) {
		return loginSessionDao.countByExample(example);
	}
	
	@Override
	public Integer updateByObject(LoginSession record)
	{
		return loginSessionDao.updateByPrimaryKey(record);
	}
	
	@Override
	public LoginSession getLoginSessionOfUsername(String username)
	{
		LoginSessionExample example = new LoginSessionExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<LoginSession> LoginSessions = getObjectList(example);
		
		if(LoginSessions != null && !LoginSessions.isEmpty())
		{
			return LoginSessions.get(0);
		}
		
		return null;
	}

	
	
}
