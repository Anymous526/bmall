package com.amall.core.service.promote;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteDreamSet;
import com.amall.core.bean.PromoteDreamSetExample;
import com.amall.core.dao.PromoteDreamSetMapper;

@Service
@Transactional
public class PromoteDreamSetService implements IPromoteDreamSetService {

	@Resource
	private PromoteDreamSetMapper PromoteDreamSetDAO;

	public Integer add(PromoteDreamSet example)
	{
		return PromoteDreamSetDAO.insertSelective(example);
	}

	public PromoteDreamSet getByKey(Long id)
	{
		return PromoteDreamSetDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return PromoteDreamSetDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteDreamSetExample example)
	{
		return PromoteDreamSetDAO.deleteByExample(example);
	}

	public Integer updateByObject(PromoteDreamSet record)
	{
		return PromoteDreamSetDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public List<PromoteDreamSet> getObjectList(PromoteDreamSetExample example)
	{
		return PromoteDreamSetDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteDreamSetExample example)
	{
		return PromoteDreamSetDAO.countByExample(example);
	}

    @Override
    public BigDecimal getRate()
    {
        return PromoteDreamSetDAO.selectByExample(null).get(0).getRate();
    }

	
}
