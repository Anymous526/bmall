package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudShowOrder;
import com.amall.core.bean.CloudShowOrderExample;
import com.amall.core.dao.CloudShowOrderMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudShowOrderServiceImpl implements ICloudShowOrderService {

	@Resource 
	private CloudShowOrderMapper cloudShowOrderDao;

	public Integer add(CloudShowOrder example) {
		
		return cloudShowOrderDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudShowOrder getByKey(Long id) {
		
		return cloudShowOrderDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudShowOrderDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudShowOrderExample example) {
		
		return cloudShowOrderDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudShowOrder record) {
		
		return cloudShowOrderDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudShowOrderExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudShowOrderDao.countByExample(example));
		p.setList(cloudShowOrderDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudShowOrder> getObjectList(CloudShowOrderExample example) {
		
		return cloudShowOrderDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudShowOrderExample example) {
		
		return cloudShowOrderDao.countByExample(example);
	}

}
