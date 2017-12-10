package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.RechargeLog;
import com.amall.core.bean.RechargeLogExample;
import com.amall.core.dao.RechargeLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RechargeLogService implements IRechargeLogService {

	@Resource
	private RechargeLogMapper rechargeLogDAO;

	public Long add(RechargeLog example)
	{
		return rechargeLogDAO.insertSelective(example);
	}
	
	public int addGold(RechargeLog log)
	{
		return rechargeLogDAO.insert(log);
	}

	public RechargeLog getByKey(Long id)
	{
		return rechargeLogDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return rechargeLogDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(RechargeLogExample example)
	{
		return rechargeLogDAO.deleteByExample(example);
	}

	public Integer updateByObject(RechargeLog record)
	{
		return rechargeLogDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(RechargeLogExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),rechargeLogDAO.countByExample(example));
		p.setList(rechargeLogDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<RechargeLog> getObjectList(RechargeLogExample example)
	{
		return rechargeLogDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(RechargeLogExample example)
	{
		return rechargeLogDAO.countByExample(example);
	}
	
	
}
