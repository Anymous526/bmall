package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.MutualBenefitExample;
import com.amall.core.dao.MutualBenefitMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class MutualBenefitService implements IMutualBenefitService {

	@Resource
	private MutualBenefitMapper mutualBenefitDAO;

	public Long add(MutualBenefit example)
	{
		return mutualBenefitDAO.insertSelective(example);
	}

	public MutualBenefit getByKey(Long id)
	{
		return mutualBenefitDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return mutualBenefitDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(MutualBenefitExample example)
	{
		return mutualBenefitDAO.deleteByExample(example);
	}

	public Integer updateByObject(MutualBenefit record)
	{
		return mutualBenefitDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(MutualBenefitExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),mutualBenefitDAO.countByExample(example));
		p.setList(mutualBenefitDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<MutualBenefit> getObjectList(MutualBenefitExample example)
	{
		return mutualBenefitDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(MutualBenefitExample example)
	{
		return mutualBenefitDAO.countByExample(example);
	}
	
	
}
