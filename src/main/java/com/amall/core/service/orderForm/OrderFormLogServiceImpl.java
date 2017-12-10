package com.amall.core.service.orderForm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;
import com.amall.core.dao.OrderFormLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class OrderFormLogServiceImpl implements IOrderFormLogService {

	@Resource 
	private OrderFormLogMapper  orderFormLogDao;

	public Long add(OrderFormLog example) {
		return orderFormLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public OrderFormLog getByKey(Long id) {
		return orderFormLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return orderFormLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(OrderFormLogExample example) {
		return orderFormLogDao.deleteByExample(example);
	}

	public Integer updateByObject(OrderFormLog record) {
		return orderFormLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(OrderFormLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),orderFormLogDao.countByExample(example));
		p.setList(orderFormLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<OrderFormLog> getObjectList(OrderFormLogExample example) {
		return orderFormLogDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(OrderFormLogExample example) {
		return orderFormLogDao.countByExample(example);
	}


}
