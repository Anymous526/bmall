package com.amall.core.service.integral;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.dao.IntegralGoodsOrderMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class IntegralGoodsOrderServiceImpl implements
		IIntegralGoodsOrderService {
	
	@Resource 
	private IntegralGoodsOrderMapper integralGoodsOrderDao;

	public Long add(IntegralGoodsOrderWithBLOBs example) {
		
		return integralGoodsOrderDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public IntegralGoodsOrderWithBLOBs getByKey(Long id) {
		
		return integralGoodsOrderDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return integralGoodsOrderDao.deleteByPrimaryKey(id);
	}
	
	public Integer deleteByExample(IntegralGoodsOrderExample example) {
		return integralGoodsOrderDao.deleteByExample(example);
	}

	public Integer updateByObject(IntegralGoodsOrderWithBLOBs record) {
		
		return integralGoodsOrderDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(IntegralGoodsOrderExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),integralGoodsOrderDao.countByExample(example));
		p.setList(integralGoodsOrderDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<IntegralGoodsOrderWithBLOBs> getObjectList(IntegralGoodsOrderExample example) {
		return integralGoodsOrderDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(IntegralGoodsOrderExample example) {
		return integralGoodsOrderDao.countByExample(example);
	}


}
