package com.amall.core.service.coupon;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Coupon;
import com.amall.core.bean.CouponExample;
import com.amall.core.dao.CouponMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CouponServiceImpl implements ICouponService {

	@Resource
	private CouponMapper couponDao;

	public Long add(Coupon example) {
		return couponDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Coupon getByKey(Long id) {
		return couponDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return couponDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CouponExample example) {
		return couponDao.deleteByExample(example);
	}

	public Integer updateByObject(Coupon record) {
		return couponDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CouponExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),couponDao.countByExample(example));
		p.setList(couponDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Coupon> getObjectList(CouponExample example) {
		return couponDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CouponExample example) {
		return couponDao.countByExample(example);
	}


}
