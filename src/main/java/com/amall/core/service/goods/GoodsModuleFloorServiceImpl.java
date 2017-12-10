package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.dao.GoodsModuleFloorMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsModuleFloorServiceImpl implements IGoodsModuleFloorService {

	@Resource 
	private GoodsModuleFloorMapper  goodsModuleFloorDao;

	public Long add(GoodsModuleFloor example) {
		return goodsModuleFloorDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsModuleFloor getByKey(Long id) {
		return goodsModuleFloorDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsModuleFloorDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsModuleFloorExample example) {
		return goodsModuleFloorDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsModuleFloor record) {
		return goodsModuleFloorDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<GoodsModuleFloor> getObjectList(GoodsModuleFloorExample example) {
		return goodsModuleFloorDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsModuleFloorExample example) {
		return goodsModuleFloorDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsModuleFloorExample example) {
		Pagination p = new Pagination(example.getPageNo(), example.getPageSize(),goodsModuleFloorDao.countByExample(example));
		p.setList(goodsModuleFloorDao.selectByExampleWithPage(example));
		return p;
	}


}
