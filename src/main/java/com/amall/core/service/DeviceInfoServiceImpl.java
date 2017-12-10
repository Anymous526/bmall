package com.amall.core.service;

import java.util.List; 
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.DeviceInfo;
import com.amall.core.bean.DeviceInfoExample;
import com.amall.core.dao.DeviceInfoMapper;

@Service
@Transactional
public class DeviceInfoServiceImpl implements IDeviceInfoService {

	@Resource 
	private DeviceInfoMapper  deviceInfoDao;

	public int add(DeviceInfo example) {
		return deviceInfoDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public DeviceInfo getByKey(Long id) {
		return deviceInfoDao.selectByPrimaryKey(id);
	}
	
	public Integer deleteByKey(Long id) {
		return deviceInfoDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DeviceInfoExample example) {
		return deviceInfoDao.deleteByExample(example);
	}

	public Integer updateByObject(DeviceInfo record) {
		return deviceInfoDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<DeviceInfo> getObjectList(DeviceInfoExample example) {
		return deviceInfoDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DeviceInfoExample example) {
		return deviceInfoDao.countByExample(example);
	}
	
	
}
