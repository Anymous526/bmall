package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreEarningDetail;
import com.amall.core.bean.StoreEarningDetailExample;
import com.amall.core.dao.StoreEarningDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreEarningDetailService implements IStoreEarningDetailService {

	@Resource
	private StoreEarningDetailMapper storeEarningDetailDAO;

	public Integer add(StoreEarningDetail example)
	{
		return storeEarningDetailDAO.insertSelective(example);
	}

	public StoreEarningDetail getByKey(Long id)
	{
		return storeEarningDetailDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return storeEarningDetailDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreEarningDetailExample example)
	{
		return storeEarningDetailDAO.deleteByExample(example);
	}

	public Integer updateByObject(StoreEarningDetail record)
	{
		return storeEarningDetailDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreEarningDetailExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeEarningDetailDAO.countByExample(example));
		p.setList(storeEarningDetailDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<StoreEarningDetail> getObjectList(StoreEarningDetailExample example)
	{
		return storeEarningDetailDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreEarningDetailExample example)
	{
		return storeEarningDetailDAO.countByExample(example);
	}
	
	
}
