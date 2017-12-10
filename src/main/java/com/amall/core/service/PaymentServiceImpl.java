package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.dao.PaymentMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Resource 
	private PaymentMapper  paymentDao;

	public Long add(PaymentWithBLOBs example) {
		return paymentDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public PaymentWithBLOBs getByKey(Long id) {
		return paymentDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return paymentDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PaymentExample example) {
		return paymentDao.deleteByExample(example);
	}

	public Integer updateByObject(PaymentWithBLOBs record) {
		return paymentDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PaymentExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),paymentDao.countByExample(example));
		p.setList(paymentDao.selectByExampleWithPage(example));
		return null;
	}
	@Transactional(readOnly=true)
	public List<PaymentWithBLOBs> getObjectList(PaymentExample example) {
		return paymentDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PaymentExample example) {
		return paymentDao.countByExample(example);
	}


}
