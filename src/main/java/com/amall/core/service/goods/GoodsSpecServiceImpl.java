package com.amall.core.service.goods;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.GoodsSpec;
import com.amall.core.bean.GoodsSpecExample;
import com.amall.core.dao.GoodsSpecMapper;

@Service
@Transactional
public class GoodsSpecServiceImpl implements IGoodsSpecService
{

	@Resource
	private GoodsSpecMapper goodsSpecDao;

	@Transactional(readOnly = true)
	public int countByExample (GoodsSpecExample example)
		{
			return goodsSpecDao.countByExample (example);
		}

	public int deleteByExample (GoodsSpecExample example)
		{
			return goodsSpecDao.deleteByExample (example);
		}

	public int deleteByPrimaryKey (Long id)
		{
			return goodsSpecDao.deleteByPrimaryKey (id);
		}

	public int insert (GoodsSpec record)
		{
			return goodsSpecDao.insert (record);
		}

	public int insertSelective (GoodsSpec record)
		{
			return goodsSpecDao.insertSelective (record);
		}

	@Transactional(readOnly = true)
	public List <GoodsSpec> selectByExample (GoodsSpecExample example)
		{
			return goodsSpecDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public GoodsSpec selectByPrimaryKey (Long id)
		{
			return goodsSpecDao.selectByPrimaryKey (id);
		}

	public int updateByExample (GoodsSpec record)
		{
			return goodsSpecDao.updateByPrimaryKeySelective (record);
		}

	public int updateByPrimaryKey (GoodsSpec record)
		{
			return goodsSpecDao.updateByPrimaryKey (record);
		}
}
