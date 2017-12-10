package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudBuyCodes;
import com.amall.core.bean.CloudBuyCodesExample;
import com.amall.core.dao.CloudBuyCodesMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudBuyCodesServiceImpl implements ICloudBuyCodesService {

	@Resource 
	private CloudBuyCodesMapper cloudBuyCodesDao;

	public Integer add(CloudBuyCodes example) {
		
		return cloudBuyCodesDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudBuyCodes getByKey(Long id) {
		
		return cloudBuyCodesDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudBuyCodesDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudBuyCodesExample example) {
		
		return cloudBuyCodesDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudBuyCodes record) {
		
		return cloudBuyCodesDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudBuyCodesExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudBuyCodesDao.countByExample(example));
		p.setList(cloudBuyCodesDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudBuyCodes> getObjectList(CloudBuyCodesExample example) {
		
		return cloudBuyCodesDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudBuyCodesExample example) {
		
		return cloudBuyCodesDao.countByExample(example);
	}
	@Override
	public List<CloudBuyCodes> getCloudBuyCodesOfCloudGoodsIdAndUserId(long goodsId, long userId)
	{
		CloudBuyCodesExample example = new CloudBuyCodesExample();
		example.createCriteria().andUserIdEqualTo(userId).andCloudGoodsIdEqualTo(goodsId);
		return getObjectList(example);
	}
	@Override
	public List<CloudBuyCodes> getCloudBuyCodesOfCloudGoodsId(long goodsId)
	{
		CloudBuyCodesExample example = new CloudBuyCodesExample();
		example.createCriteria().andCloudGoodsIdEqualTo(goodsId);
		return getObjectList(example);
	}
	@Override
	public List<CloudBuyCodes> getCloudBuyCodesOfUserId(long userId)
	{
		CloudBuyCodesExample example = new CloudBuyCodesExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return getObjectList(example);
	}

}
