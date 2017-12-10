package com.amall.core.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.OrderAddress;
import com.amall.core.bean.OrderAddressExample;
import com.amall.core.dao.OrderAddressMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class OrderAddressServiceImpl implements IOrderAddressService {

	@Resource
	private OrderAddressMapper orderAddress;

	public Long add(OrderAddress example) {
		return orderAddress.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public OrderAddress getByKey(Long id) {
		return orderAddress.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return orderAddress.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(OrderAddressExample example) {
		return orderAddress.deleteByExample(example);
	}

	public Integer updateByObject(OrderAddress record) {
		return orderAddress.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(OrderAddressExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),orderAddress.countByExample(example));
		p.setList(orderAddress.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<OrderAddress> getObjectList(OrderAddressExample example) {
		return orderAddress.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(OrderAddressExample example) {
		return orderAddress.countByExample(example);
	}


	
}
