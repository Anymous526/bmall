package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.dao.GoodsFloorMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsFloorServiceImpl implements IGoodsFloorService {

	@Resource 
	private GoodsFloorMapper  goodsFloorDao;

	public Long add(GoodsFloorWithBLOBs example) {
		return goodsFloorDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsFloorWithBLOBs getByKey(Long id) {
		return goodsFloorDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsFloorDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsFloorExample example) {
		return goodsFloorDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsFloorWithBLOBs record) {
		return goodsFloorDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsFloorExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsFloorDao.countByExample(example));
		p.setList(goodsFloorDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsFloorWithBLOBs> getObjectList(GoodsFloorExample example) {
		return goodsFloorDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsFloorExample example) {
		return goodsFloorDao.countByExample(example);
	}
	public List<GoodsFloorWithBLOBs> selectChildsByInnerJoin(Long id) {
		return goodsFloorDao.selectChildsByInnerJoin(id);
	}


}
