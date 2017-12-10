package com.amall.core.action.CRUD;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.core.bean.DeviceInfo;
import com.amall.core.bean.DeviceInfoExample;
import com.amall.core.service.IDeviceInfoService;

@Component
public class DeviceInfoCRUD
{

	@Autowired
	private IDeviceInfoService deviceInfoService;

	/**
	 * @Title :  getDeviceInfoByUserId
	 * @Deprecated :   根据userId 获取deviceInfo 
	 * @param userId
	 * @return  : DeviceInfo
	 * @author ： liuguo
	 * @Date : 2017/05/04   13:15 
	 */
	public DeviceInfo getDeviceInfoByUserId (Long userId)
		{
			DeviceInfoExample example = new DeviceInfoExample ();
			example.clear ();
			example.createCriteria ().andUserIdEqualTo (userId);
			List <DeviceInfo> deviceInfoList = this.deviceInfoService.getObjectList (example);
			DeviceInfo deviceInfos = null;
			if (deviceInfoList != null && deviceInfoList.size () > 0)
			{
				deviceInfos = deviceInfoList.get (0);
			}
			return deviceInfos;
		}
	
	
	/**
	 * @Title :  addDeviceInfo
	 * @author ： liuguo
	 * @Date : 2017/05/04   13:15 
	 */
	public void addDeviceInfo (DeviceInfo example)
		{
			 this.deviceInfoService.add (example);
		}
	
	
	/**
	 * @TItle :  updateDeviceInfo
	 * @param record
	 * @author : liuguo
	 * @Date : 2017/05/04   13:15 
	 */
	public Integer updateDeviceInfo (DeviceInfo record)
		{
			 return this.deviceInfoService.updateByObject (record);
		}
}
