package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;
import com.amall.core.dao.GoodsModuleFloorNextMapper;

@Service
@Transactional
public class GoodsModuleFloorNextServiceImpl implements IGoodsModuleFloorNextService {

	@Resource 
	private GoodsModuleFloorNextMapper  GoodsModuleFloorNextDao;

	public Long add(GoodsModuleFloorNext example) {
		return GoodsModuleFloorNextDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsModuleFloorNext getByKey(Long id) {
		return GoodsModuleFloorNextDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return GoodsModuleFloorNextDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsModuleFloorNextExample example) {
		return GoodsModuleFloorNextDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsModuleFloorNext record) {
		return GoodsModuleFloorNextDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<GoodsModuleFloorNext> getObjectList(GoodsModuleFloorNextExample example) {
		return GoodsModuleFloorNextDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsModuleFloorNextExample example) {
		return GoodsModuleFloorNextDao.countByExample(example);
	}

}
