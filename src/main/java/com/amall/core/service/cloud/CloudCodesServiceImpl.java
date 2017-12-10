package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudCodesExample;
import com.amall.core.dao.CloudCodesMapper;

@Service
@Transactional
public class CloudCodesServiceImpl implements ICloudCodesService {

	@Resource 
	private CloudCodesMapper cloudCodesDao;

	public void add(List<CloudCodes> CloudCodesList) {
		
		cloudCodesDao.batchSave(CloudCodesList);
	}

	public Integer deleteByExample(CloudCodesExample example) {
		
		return cloudCodesDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<CloudCodes> getObjectList(long goodsId, int count) {
		CloudCodesExample example = new CloudCodesExample();
		example.setOrderByClause("cloud_Goods_id limit 0," + count);
		example.createCriteria().andCloudGoodsIdEqualTo(goodsId);
		return cloudCodesDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudCodesExample example) {
		
		return cloudCodesDao.countByExample(example);
	}

}
