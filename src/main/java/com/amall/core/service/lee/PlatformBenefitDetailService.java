package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PlatformBenefitDetail;
import com.amall.core.bean.PlatformBenefitDetailExample;
import com.amall.core.dao.PlatformBenefitDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PlatformBenefitDetailService implements IPlatformBenefitDetailService {

	@Resource
	private PlatformBenefitDetailMapper platformBenefitDetailDAO;

	public Long add(PlatformBenefitDetail example)
	{
		return platformBenefitDetailDAO.insertSelective(example);
	}

	public PlatformBenefitDetail getByKey(Long id)
	{
		return platformBenefitDetailDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return platformBenefitDetailDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PlatformBenefitDetailExample example)
	{
		return platformBenefitDetailDAO.deleteByExample(example);
	}

	public Integer updateByObject(PlatformBenefitDetail record)
	{
		return platformBenefitDetailDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PlatformBenefitDetailExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),platformBenefitDetailDAO.countByExample(example));
		p.setList(platformBenefitDetailDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<PlatformBenefitDetail> getObjectList(PlatformBenefitDetailExample example)
	{
		return platformBenefitDetailDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PlatformBenefitDetailExample example)
	{
		return platformBenefitDetailDAO.countByExample(example);
	}
	
	
}
