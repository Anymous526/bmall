package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.UserCashDepositLog;
import com.amall.core.bean.UserCashDepositLogExample;
import com.amall.core.dao.UserCashDepositLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserCashDepositLogService implements IUserCashDepositLogService {

	@Resource
	private UserCashDepositLogMapper userCashDepositLog;

	public Integer add(UserCashDepositLog example)
	{
		return userCashDepositLog.insertSelective(example);
	}

	public UserCashDepositLog getByKey(Long id)
	{
		return userCashDepositLog.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return userCashDepositLog.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(UserCashDepositLogExample example)
	{
		return userCashDepositLog.deleteByExample(example);
	}

	public Integer updateByObject(UserCashDepositLog record)
	{
		return userCashDepositLog.updateByPrimaryKeySelective(record);
	}

	@Transactional(readOnly=true)
	public List<UserCashDepositLog> getObjectList(UserCashDepositLogExample example)
	{
		return userCashDepositLog.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(UserCashDepositLogExample example)
	{
		return userCashDepositLog.countByExample(example);
	}

	@Override
	public Pagination getObjectListWithPage(UserCashDepositLogExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),userCashDepositLog.countByExample(example));
		p.setList(userCashDepositLog.selectByExampleAndPage(example));
		return p;
	}
	
	
}
