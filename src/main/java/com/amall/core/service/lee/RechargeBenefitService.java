package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.RechargeBenefit;
import com.amall.core.bean.RechargeBenefitExample;
import com.amall.core.dao.RechargeBenefitMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RechargeBenefitService implements IRechargeBenefitService {

	@Resource
	private RechargeBenefitMapper rechargeBenefitDAO;

	public Long add(RechargeBenefit example)
	{
		return rechargeBenefitDAO.insertSelective(example);
	}

	public RechargeBenefit getByKey(Long id)
	{
		return rechargeBenefitDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return rechargeBenefitDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(RechargeBenefitExample example)
	{
		return rechargeBenefitDAO.deleteByExample(example);
	}

	public Integer updateByObject(RechargeBenefit record)
	{
		return rechargeBenefitDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(RechargeBenefitExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),rechargeBenefitDAO.countByExample(example));
		p.setList(rechargeBenefitDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<RechargeBenefit> getObjectList(RechargeBenefitExample example)
	{
		return rechargeBenefitDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(RechargeBenefitExample example)
	{
		return rechargeBenefitDAO.countByExample(example);
	}
	
	
}
