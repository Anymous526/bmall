package com.amall.core.service.activity;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Activity;
import com.amall.core.bean.ActivityExample;
import com.amall.core.dao.ActivityMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ActivityServiceImpl implements IActivityService {

	@Resource
	private ActivityMapper activityDao;

	public Long add(Activity activity) {
		return activityDao.insertSelective(activity);
	}

	@Transactional(readOnly = true)
	public Activity getByKey(Long id) {
		return activityDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return activityDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ActivityExample example) {
		return activityDao.deleteByExample(example);
	}

	public Integer updateByObject(Activity record) {
		return activityDao.updateByPrimaryKeySelective(record);
	}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage(ActivityExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),activityDao.countByExample(example));
		p.setList(activityDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}

	@Transactional(readOnly = true)
	public List<Activity> getObjectList(ActivityExample example) {
		return activityDao.selectByExampleWithBLOBs(example);
	}

	@Transactional(readOnly = true)
	public Integer getObjectListCount(ActivityExample example) {
		return activityDao.countByExample(example);
	}

}
