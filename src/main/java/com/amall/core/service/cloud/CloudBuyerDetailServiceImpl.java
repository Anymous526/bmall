package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudBuyerDetail;
import com.amall.core.bean.CloudBuyerDetailExample;
import com.amall.core.dao.CloudBuyerDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudBuyerDetailServiceImpl implements ICloudBuyerDetailService {

	@Resource 
	private CloudBuyerDetailMapper cloudBuyerDetailDao;

	public Integer add(CloudBuyerDetail example) {
		
		return cloudBuyerDetailDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudBuyerDetail getByKey(Long id) {
		
		return cloudBuyerDetailDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudBuyerDetailDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudBuyerDetailExample example) {
		
		return cloudBuyerDetailDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudBuyerDetail record) {
		
		return cloudBuyerDetailDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudBuyerDetailExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudBuyerDetailDao.countByExample(example));
		p.setList(cloudBuyerDetailDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudBuyerDetail> getObjectList(CloudBuyerDetailExample example) {
		
		return cloudBuyerDetailDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudBuyerDetailExample example) {
		
		return cloudBuyerDetailDao.countByExample(example);
	}
	@Override
	public CloudBuyerDetail getCloudBuyerDetailOfCloudGoodsIdAndUserId(long goodsId, long userId)
	{
		CloudBuyerDetailExample example = new CloudBuyerDetailExample();
		example.createCriteria().andUserIdEqualTo(userId).andCloudGoodsIdEqualTo(goodsId);
		List<CloudBuyerDetail> list = getObjectList(example);
		
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

}
