package com.amall.core.service.promote;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteVipHistory;
import com.amall.core.bean.PromoteVipHistoryExample;
import com.amall.core.dao.PromoteVipHistoryMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PromoteVipHistoryService implements IPromoteVipHistoryService {

	@Resource
	private PromoteVipHistoryMapper promoteVipHistoryDAO;

	public Integer add(PromoteVipHistory example)
	{
		return promoteVipHistoryDAO.insertSelective(example);
	}

	public PromoteVipHistory getByKey(Long id)
	{
		return promoteVipHistoryDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return promoteVipHistoryDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteVipHistoryExample example)
	{
		return promoteVipHistoryDAO.deleteByExample(example);
	}

	public Integer updateByObject(PromoteVipHistory record)
	{
		return promoteVipHistoryDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PromoteVipHistoryExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),promoteVipHistoryDAO.countByExample(example));
		p.setList(promoteVipHistoryDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<PromoteVipHistory> getObjectList(PromoteVipHistoryExample example)
	{
		return promoteVipHistoryDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteVipHistoryExample example)
	{
		return promoteVipHistoryDAO.countByExample(example);
	}
	
	
}
