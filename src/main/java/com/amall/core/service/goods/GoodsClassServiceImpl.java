package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsSpecial;
import com.amall.core.dao.GoodsClassMapper;
import com.amall.core.web.page.Pagination;
/**
 * 
 * <p>Title: GoodsClassServiceImpl</p>
 * <p>Description: 商品类型管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:35:10
 * @version 1.0
 */
@Service
@Transactional
public class GoodsClassServiceImpl implements IGoodsClassService {

	@Resource 
	private GoodsClassMapper  goodsClassDao;

	public Long add(GoodsClassWithBLOBs example) {
		return goodsClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsClassWithBLOBs getByKey(Long id) {
		return goodsClassDao.selectByPrimaryKey(id);
	}
	
	public Integer deleteByKey(Long id) {
		return goodsClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsClassExample example) {
		return goodsClassDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsClassWithBLOBs record) {
		return goodsClassDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsClassDao.countByExample(example));
		p.setList(goodsClassDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsClassWithBLOBs> getObjectList(GoodsClassExample example) {
		return goodsClassDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsClassExample example) {
		return goodsClassDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<GoodsSpecial> selectClass(Integer id) {
		
		return goodsClassDao.selectClass(id);
	}
	
	
}
