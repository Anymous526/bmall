package com.amall.core.service.delivery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.DeliveryLog;
import com.amall.core.bean.DeliveryLogExample;
import com.amall.core.dao.DeliveryLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DeliveryLogServiceImpl implements IDeliveryLogService {

	@Resource
	private DeliveryLogMapper deliveryLogDao;

	public Long add(DeliveryLog example) {
		return deliveryLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public DeliveryLog getByKey(Long id) {
		return deliveryLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return deliveryLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DeliveryLogExample example) {
		return deliveryLogDao.deleteByExample(example);
	}

	public Integer updateByObject(DeliveryLog record) {
		return deliveryLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DeliveryLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),deliveryLogDao.countByExample(example));
		p.setList(deliveryLogDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<DeliveryLog> getObjectList(DeliveryLogExample example) {
		return deliveryLogDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DeliveryLogExample example) {
		return deliveryLogDao.countByExample(example);
	}

	
	
}
