package com.amall.core.service.cloud;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.CloudStatisticsExample;
import com.amall.core.dao.CloudStatisticsMapper;

@Service
@Transactional
public class CloudStatisticsServiceImpl implements ICloudStatisticsService
{

	@Resource
	private CloudStatisticsMapper cloudStatisticsDao;

	public Integer add (CloudStatistics example)
		{
			return cloudStatisticsDao.insertSelective (example);
		}

	public Integer deleteByKey (Long id)
		{
			return cloudStatisticsDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (CloudStatisticsExample example)
		{
			return cloudStatisticsDao.deleteByExample (example);
		}

	public Integer updateByObject (CloudStatistics record)
		{
			return cloudStatisticsDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public List <CloudStatistics> getObjectList (CloudStatisticsExample example)
		{
			return cloudStatisticsDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (CloudStatisticsExample example)
		{
			return cloudStatisticsDao.countByExample (example);
		}

	@Override
	public CloudStatistics getCloudStatistics ( )
		{
			List <CloudStatistics> list = getObjectList (new CloudStatisticsExample ());
			if (list.isEmpty ())
			{
				return null;
			}
			return list.get (0);
		}
}
