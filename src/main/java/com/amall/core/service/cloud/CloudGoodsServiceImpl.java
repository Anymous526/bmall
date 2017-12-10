package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsExample;
import com.amall.core.dao.CloudGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudGoodsServiceImpl implements ICloudGoodsService {

	@Resource 
	private CloudGoodsMapper cloudGoodsDao;

	public Integer add(CloudGoods example) {
		
		return cloudGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudGoods getByKey(Long id) {
		
		return cloudGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudGoodsExample example) {
		
		return cloudGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudGoods record) {
		
		return cloudGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudGoodsDao.countByExample(example));
		p.setList(cloudGoodsDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudGoods> getObjectList(CloudGoodsExample example) {
		
		return cloudGoodsDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudGoodsExample example) {
		
		return cloudGoodsDao.countByExample(example);
	}

}
