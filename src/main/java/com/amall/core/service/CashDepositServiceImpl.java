package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.dao.CashDepositMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CashDepositServiceImpl implements ICashDepositService {

	@Resource 
	private CashDepositMapper CashDepositDao;

	public Integer add(CashDeposit example) {
		
		return CashDepositDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CashDeposit getByKey(Long id) {
		
		return CashDepositDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return CashDepositDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CashDepositExample example) {
		
		return CashDepositDao.deleteByExample(example);
	}

	public Integer updateByObject(CashDeposit record) {
		
		return CashDepositDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CashDepositExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),CashDepositDao.countByExample(example));
		p.setList(CashDepositDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CashDeposit> getObjectList(CashDepositExample example) {
		
		return CashDepositDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CashDepositExample example) {
		
		return CashDepositDao.countByExample(example);
	}


}
