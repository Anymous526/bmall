package com.amall.core.service.activity;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ActivityGoods;
import com.amall.core.bean.ActivityGoodsExample;
import com.amall.core.dao.ActivityGoodsMapper;
import com.amall.core.web.page.Pagination;
@Service
@Transactional
public class ActivityGoodsServiceImpl implements IActivityGoodsService {

	@Resource
	private ActivityGoodsMapper activityGoodsDao;

	public Long add(ActivityGoods example) {
		return activityGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ActivityGoods getByKey(Long id) {
		return activityGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return activityGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ActivityGoodsExample example) {
		return activityGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(ActivityGoods record) {
		return activityGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(
			ActivityGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),activityGoodsDao.countByExample(example));
		p.setList(activityGoodsDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ActivityGoods> getObjectList(
			ActivityGoodsExample example) {
		return activityGoodsDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ActivityGoodsExample example) {
		return activityGoodsDao.countByExample(example);
	}

	
	
}
