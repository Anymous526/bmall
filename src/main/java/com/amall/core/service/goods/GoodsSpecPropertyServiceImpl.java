package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.dao.GoodsSpecPropertyMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsSpecPropertyServiceImpl implements IGoodsSpecPropertyService {

	@Resource
	private GoodsSpecPropertyMapper goodsSpecPropertyDao;

	public Long add(GoodsSpecProperty example) {
		
		return goodsSpecPropertyDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsSpecProperty getByKey(Long id) {
		
		return goodsSpecPropertyDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsSpecPropertyDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsSpecPropertyExample example) {
		
		return goodsSpecPropertyDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsSpecProperty record) {
		
		return goodsSpecPropertyDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsSpecPropertyExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsSpecPropertyDao.countByExample(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsSpecProperty> getObjectList(
			GoodsSpecPropertyExample example) {
		
		return goodsSpecPropertyDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsSpecPropertyExample example) {
		
		return goodsSpecPropertyDao.countByExample(example);
	}
	public List<GoodsSpecProperty> selectGoodsPropertyByLeftJoinSpecAndGoodsId(
			long id) {
		return goodsSpecPropertyDao.selectGoodsPropertyByLeftJoinSpecAndGoodsId(id);
	}


}
