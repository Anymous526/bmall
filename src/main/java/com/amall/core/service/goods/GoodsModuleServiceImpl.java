package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleExample;
import com.amall.core.dao.GoodsModuleMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsModuleServiceImpl implements IGoodsModuleService {

	@Resource 
	private GoodsModuleMapper  goodsModuleDao;

	public Long add(GoodsModule example) {
		return goodsModuleDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsModule getByKey(Long id) {
		return goodsModuleDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsModuleDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsModuleExample example) {
		return goodsModuleDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsModule record) {
		return goodsModuleDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<GoodsModule> getObjectList(GoodsModuleExample example) {
		return goodsModuleDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsModuleExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsModuleDao.countByExample(example));
		p.setList(goodsModuleDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsModuleExample example) {
		return goodsModuleDao.countByExample(example);
	}
	
}
