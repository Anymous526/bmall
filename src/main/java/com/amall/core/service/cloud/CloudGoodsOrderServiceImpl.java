package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudGoodsOrder;
import com.amall.core.bean.CloudGoodsOrderExample;
import com.amall.core.dao.CloudGoodsOrderMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudGoodsOrderServiceImpl implements ICloudGoodsOrderService {

	@Resource 
	private CloudGoodsOrderMapper cloudGoodsOrderDao;

	public Long add(CloudGoodsOrder example) {
		
		return cloudGoodsOrderDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudGoodsOrder getByKey(Long id) {
		
		return cloudGoodsOrderDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudGoodsOrderDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudGoodsOrderExample example) {
		
		return cloudGoodsOrderDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudGoodsOrder record) {
		
		return cloudGoodsOrderDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudGoodsOrderExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudGoodsOrderDao.countByExample(example));
		p.setList(cloudGoodsOrderDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudGoodsOrder> getObjectList(CloudGoodsOrderExample example) {
		
		return cloudGoodsOrderDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudGoodsOrderExample example) {
		
		return cloudGoodsOrderDao.countByExample(example);
	}

}
