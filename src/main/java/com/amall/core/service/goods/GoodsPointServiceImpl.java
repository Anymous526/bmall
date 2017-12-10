package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsPoint;
import com.amall.core.bean.GoodsPointExample;
import com.amall.core.dao.GoodsPointMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsPointServiceImpl implements IGoodsPointService {

	@Resource 
	private GoodsPointMapper  goodsPointDao;

	public Long add(GoodsPoint example) {
		return goodsPointDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsPoint getByKey(Long id) {
		return goodsPointDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsPointDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsPointExample example) {
		return goodsPointDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsPoint record) {
		return goodsPointDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsPointExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsPointDao.countByExample(example));
		p.setList(goodsPointDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsPoint> getObjectList(GoodsPointExample example) {
		return goodsPointDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsPointExample example) {
		return goodsPointDao.countByExample(example);
	}


}
