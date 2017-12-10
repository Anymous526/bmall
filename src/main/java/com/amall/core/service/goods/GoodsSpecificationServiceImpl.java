package com.amall.core.service.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsSpecificationExample;
import com.amall.core.dao.GoodsSpecificationMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsSpecificationServiceImpl implements IGoodsSpecificationService
{

	@Resource
	private GoodsSpecificationMapper goodsSpecificationDao;

	public Long add (GoodsSpecification example)
		{
			return goodsSpecificationDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public GoodsSpecification getByKey (Long id)
		{
			return goodsSpecificationDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return goodsSpecificationDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (GoodsSpecificationExample example)
		{
			return goodsSpecificationDao.deleteByExample (example);
		}

	public Integer updateByObject (GoodsSpecification record)
		{
			return goodsSpecificationDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (GoodsSpecificationExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , goodsSpecificationDao.countByExample (example));
			p.setList (goodsSpecificationDao.selectByExampleWithPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <GoodsSpecification> getObjectList (GoodsSpecificationExample example)
		{
			return goodsSpecificationDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (GoodsSpecificationExample example)
		{
			return goodsSpecificationDao.countByExample (example);
		}

	@Transactional(readOnly = true)
	public List <GoodsSpecification> selectGoodsSpecification (Map map)
		{
			return goodsSpecificationDao.selectGoodsSpecification (map);
		}

	@Transactional(readOnly = true)
	public List <GoodsSpecification> selectSpec (HashMap map)
		{
			return goodsSpecificationDao.selectSpec (map);
		}

	@Transactional(readOnly = true)
	public List <GoodsSpecProperty> selectSpecAll (HashMap map)
		{
			return goodsSpecificationDao.selectSpecAll (map);
		}
}
