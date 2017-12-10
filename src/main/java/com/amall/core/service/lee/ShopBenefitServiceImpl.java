package com.amall.core.service.lee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ShopBenefit;
import com.amall.core.bean.ShopBenefitExample;
import com.amall.core.dao.ShopBenefitMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ShopBenefitServiceImpl implements IShopBenefitService {

	@Resource
	private ShopBenefitMapper shopBenefitDAO;

	public Long add(ShopBenefit example)
	{
		return shopBenefitDAO.insertSelective(example);
	}

	public ShopBenefit getByKey(Long id)
	{
		return shopBenefitDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return shopBenefitDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ShopBenefitExample example)
	{
		return shopBenefitDAO.deleteByExample(example);
	}

	public Integer updateByObject(ShopBenefit record)
	{
		return shopBenefitDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ShopBenefitExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),shopBenefitDAO.countByExample(example));
		p.setList(shopBenefitDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<ShopBenefit> getObjectList(ShopBenefitExample example)
	{
		return shopBenefitDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(ShopBenefitExample example)
	{
		return shopBenefitDAO.countByExample(example);
	}
	
	
}
