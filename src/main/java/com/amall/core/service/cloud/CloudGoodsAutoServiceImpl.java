package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import com.amall.core.dao.CloudGoodsAutoMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudGoodsAutoServiceImpl implements ICloudGoodsAutoService {

	@Resource 
	private CloudGoodsAutoMapper cloudGoodsAutoDao;

	public Long add(CloudGoodsAuto example) {
		
		return cloudGoodsAutoDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudGoodsAuto getByKey(Long id) {
		
		return cloudGoodsAutoDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudGoodsAutoDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudGoodsAutoExample example) {
		
		return cloudGoodsAutoDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudGoodsAuto record) {
		
		return cloudGoodsAutoDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudGoodsAutoExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudGoodsAutoDao.countByExample(example));
		p.setList(cloudGoodsAutoDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudGoodsAuto> getObjectList(CloudGoodsAutoExample example) {
		
		return cloudGoodsAutoDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudGoodsAutoExample example) {
		
		return cloudGoodsAutoDao.countByExample(example);
	}

}
