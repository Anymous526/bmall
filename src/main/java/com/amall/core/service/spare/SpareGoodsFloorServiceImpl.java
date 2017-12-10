package com.amall.core.service.spare;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SpareGoodsFloor;
import com.amall.core.bean.SpareGoodsFloorExample;
import com.amall.core.dao.SpareGoodsFloorMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SpareGoodsFloorServiceImpl implements ISpareGoodsFloorService {

	@Resource
	private SpareGoodsFloorMapper spareGoodsFloorDao;

	public Long add(SpareGoodsFloor example) {
		
		return spareGoodsFloorDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SpareGoodsFloor getByKey(Long id) {
		
		return spareGoodsFloorDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return spareGoodsFloorDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SpareGoodsFloorExample example) {
		
		return spareGoodsFloorDao.deleteByExample(example);
	}

	public Integer updateByObject(SpareGoodsFloor record) {
		
		return spareGoodsFloorDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SpareGoodsFloorExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),spareGoodsFloorDao.countByExample(example));
		p.setList(spareGoodsFloorDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SpareGoodsFloor> getObjectList(SpareGoodsFloorExample example) {
		
		return spareGoodsFloorDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SpareGoodsFloorExample example) {
		
		return spareGoodsFloorDao.countByExample(example);
	}


}
