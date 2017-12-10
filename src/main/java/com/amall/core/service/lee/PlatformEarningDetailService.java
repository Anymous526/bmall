package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PlatformEarningDetail;
import com.amall.core.bean.PlatformEarningDetailExample;
import com.amall.core.dao.PlatformEarningDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PlatformEarningDetailService implements IPlatformEarningDetailService {

	@Resource
	private PlatformEarningDetailMapper platformEarningDetailDAO;

	public Long add(PlatformEarningDetail example)
	{
		return platformEarningDetailDAO.insertSelective(example);
	}

	public PlatformEarningDetail getByKey(Long id)
	{
		return platformEarningDetailDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return platformEarningDetailDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PlatformEarningDetailExample example)
	{
		return platformEarningDetailDAO.deleteByExample(example);
	}

	public Integer updateByObject(PlatformEarningDetail record)
	{
		return platformEarningDetailDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PlatformEarningDetailExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),platformEarningDetailDAO.countByExample(example));
		p.setList(platformEarningDetailDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<PlatformEarningDetail> getObjectList(PlatformEarningDetailExample example)
	{
		return platformEarningDetailDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PlatformEarningDetailExample example)
	{
		return platformEarningDetailDAO.countByExample(example);
	}
	
	
}
