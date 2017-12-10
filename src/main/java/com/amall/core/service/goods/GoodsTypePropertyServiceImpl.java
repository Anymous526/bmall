package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsTypeProperty;
import com.amall.core.bean.GoodsTypePropertyExample;
import com.amall.core.dao.GoodsTypePropertyMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsTypePropertyServiceImpl implements IGoodsTypePropertyService {

	@Resource 
	private GoodsTypePropertyMapper  goodsTypePropertyDao;

	public Long add(GoodsTypeProperty example) {
		
		return goodsTypePropertyDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsTypeProperty getByKey(Long id) {
		
		return goodsTypePropertyDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsTypePropertyDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsTypePropertyExample example) {
		
		return goodsTypePropertyDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsTypeProperty record) {
		
		return goodsTypePropertyDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsTypePropertyExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsTypePropertyDao.countByExample(example));
		p.setList(goodsTypePropertyDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsTypeProperty> getObjectList(
			GoodsTypePropertyExample example) {
		
		return goodsTypePropertyDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsTypePropertyExample example) {
		
		return goodsTypePropertyDao.countByExample(example);
	}


}
