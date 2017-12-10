package com.amall.core.service.promote;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteVipItem;
import com.amall.core.bean.PromoteVipItemExample;
import com.amall.core.dao.PromoteVipItemMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PromoteVipItemService implements IPromoteVipItemService {

	@Resource
	private PromoteVipItemMapper promoteVipItemDAO;

	public Integer add(PromoteVipItem example)
	{
		return promoteVipItemDAO.insertSelective(example);
	}

	public PromoteVipItem getByKey(Long id)
	{
		return promoteVipItemDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return promoteVipItemDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteVipItemExample example)
	{
		return promoteVipItemDAO.deleteByExample(example);
	}

	public Integer updateByObject(PromoteVipItem record)
	{
		return promoteVipItemDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PromoteVipItemExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),promoteVipItemDAO.countByExample(example));
		p.setList(promoteVipItemDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<PromoteVipItem> getObjectList(PromoteVipItemExample example)
	{
		return promoteVipItemDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteVipItemExample example)
	{
		return promoteVipItemDAO.countByExample(example);
	}
	
	
}
