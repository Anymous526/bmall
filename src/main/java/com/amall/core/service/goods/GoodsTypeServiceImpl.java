package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsTypeExample;
import com.amall.core.dao.GoodsTypeMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsTypeServiceImpl implements IGoodsTypeService {

	@Resource 
	private GoodsTypeMapper  goodsTypeDao;

	public Long add(GoodsType example) {
		
		return goodsTypeDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsType getByKey(Long id) {
		
		return goodsTypeDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsTypeDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsTypeExample example) {
		
		return goodsTypeDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsType record) {
		
		return goodsTypeDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsTypeExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsTypeDao.countByExample(example));
		p.setList(goodsTypeDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsType> getObjectList(GoodsTypeExample example) {
		
		return goodsTypeDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsTypeExample example) {
		
		return goodsTypeDao.countByExample(example);
	}
	public List<GoodsBrand> selectGoodsBrandRightJoinByGoodsTypeId(long id) {
		return goodsTypeDao.selectGoodsBrandRightJoinByGoodsTypeId(id);
	}


}
