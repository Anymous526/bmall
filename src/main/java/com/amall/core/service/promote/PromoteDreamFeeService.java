package com.amall.core.service.promote;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteDreamFee;
import com.amall.core.bean.PromoteDreamFeeExample;
import com.amall.core.dao.PromoteDreamFeeMapper;

@Service
@Transactional
public class PromoteDreamFeeService implements IPromoteDreamFeeService {

	@Resource
	private PromoteDreamFeeMapper PromoteDreamFeeDAO;

	public Integer add(PromoteDreamFee example)
	{
		return PromoteDreamFeeDAO.insertSelective(example);
	}

	public PromoteDreamFee getByKey(Long id)
	{
		return PromoteDreamFeeDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return PromoteDreamFeeDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteDreamFeeExample example)
	{
		return PromoteDreamFeeDAO.deleteByExample(example);
	}

	public Integer updateByObject(PromoteDreamFee record)
	{
		return PromoteDreamFeeDAO.updateByPrimaryKeySelective(record);
	}

	@Transactional(readOnly=true)
	public List<PromoteDreamFee> getObjectList(PromoteDreamFeeExample example)
	{
		return PromoteDreamFeeDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteDreamFeeExample example)
	{
		return PromoteDreamFeeDAO.countByExample(example);
	}
	
	
}
