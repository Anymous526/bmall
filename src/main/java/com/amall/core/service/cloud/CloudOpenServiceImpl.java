package com.amall.core.service.cloud;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CloudOpen;
import com.amall.core.bean.CloudOpenExample;
import com.amall.core.dao.CloudOpenMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudOpenServiceImpl implements ICloudOpenService {

	@Resource 
	private CloudOpenMapper cloudOpenDao;

	public Integer add(CloudOpen example) {
		
		return cloudOpenDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CloudOpen getByKey(Long id) {
		
		return cloudOpenDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return cloudOpenDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CloudOpenExample example) {
		
		return cloudOpenDao.deleteByExample(example);
	}

	public Integer updateByObject(CloudOpen record) {
		
		return cloudOpenDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CloudOpenExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cloudOpenDao.countByExample(example));
		p.setList(cloudOpenDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CloudOpen> getObjectList(CloudOpenExample example) {
		
		return cloudOpenDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CloudOpenExample example) {
		
		return cloudOpenDao.countByExample(example);
	}
	@Override
	public CloudOpen getCloudOpen(long goodsId)
	{
		CloudOpenExample cloudOpenExample = new CloudOpenExample();
		cloudOpenExample.createCriteria().andCloudGoodsIdEqualTo(goodsId);
		
		return getObjectList(cloudOpenExample).get(0);
	}

}
