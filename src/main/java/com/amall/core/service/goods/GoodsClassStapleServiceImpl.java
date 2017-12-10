package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsClassStaple;
import com.amall.core.bean.GoodsClassStapleExample;
import com.amall.core.dao.GoodsClassStapleMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsClassStapleServiceImpl implements IGoodsClassStapleService {

	@Resource 
	private GoodsClassStapleMapper  goodsClassStapleDao;

	public Long add(GoodsClassStaple example) {
		return goodsClassStapleDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsClassStaple getByKey(Long id) {
		return goodsClassStapleDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsClassStapleDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsClassStapleExample example) {
		return goodsClassStapleDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsClassStaple record) {
		return goodsClassStapleDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsClassStapleExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsClassStapleDao.countByExample(example));
		p.setList(goodsClassStapleDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsClassStaple> getObjectList(GoodsClassStapleExample example) {
		return goodsClassStapleDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsClassStapleExample example) {
		return goodsClassStapleDao.countByExample(example);
	}


}
