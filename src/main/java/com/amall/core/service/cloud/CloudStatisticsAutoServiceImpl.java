package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsAutoExample;
import com.amall.core.dao.CloudStatisticsAutoMapper;

@Service
@Transactional
public class CloudStatisticsAutoServiceImpl implements ICloudStatisticsAutoService {

	@Resource 
	private CloudStatisticsAutoMapper cloudStatisticsAutoDao;

	public Integer add(CloudStatisticsAuto example) {
		
		return cloudStatisticsAutoDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudStatisticsAuto getByKey(Long id) {
		
		return cloudStatisticsAutoDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudStatisticsAutoDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudStatisticsAutoExample example) {
		
		return cloudStatisticsAutoDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudStatisticsAuto record) {
		
		return cloudStatisticsAutoDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<CloudStatisticsAuto> getObjectList(CloudStatisticsAutoExample example) {
		
		return cloudStatisticsAutoDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudStatisticsAutoExample example) {
		
		return cloudStatisticsAutoDao.countByExample(example);
	}

}
