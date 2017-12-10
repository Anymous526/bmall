package com.amall.core.service.integral;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.dao.IntegralGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class IntegralGoodsServiceImpl implements IIntegralGoodsService {

	@Resource 
	private IntegralGoodsMapper integralGoodsDao;

	public Long add(IntegralGoods example) {
		
		return integralGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public IntegralGoods getByKey(Long id) {
		
		return integralGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return integralGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(IntegralGoodsExample example) {
		
		return integralGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(IntegralGoods record) {
		
		return integralGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(IntegralGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),integralGoodsDao.countByExample(example));
		p.setList(integralGoodsDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<IntegralGoods> getObjectList(IntegralGoodsExample example) {
		
		return integralGoodsDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(IntegralGoodsExample example) {
		
		return integralGoodsDao.countByExample(example);
	}
	public List<IntegralGoods> selectGoodsClassNameByGcIdAndTimeDesc(int max) {
		IntegralGoodsExample example = new IntegralGoodsExample();
		example.setOrderByClause("addTime desc limit 0," + max);
		return integralGoodsDao.selectByExample(example);
	}


}
