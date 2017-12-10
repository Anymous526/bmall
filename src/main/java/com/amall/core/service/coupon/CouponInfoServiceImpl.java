package com.amall.core.service.coupon;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CouponInfo;
import com.amall.core.bean.CouponInfoExample;
import com.amall.core.dao.CouponInfoMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CouponInfoServiceImpl implements ICouponInfoService {

	@Resource
	private CouponInfoMapper couponInfoDao;

	public Long add(CouponInfo example) {
		return couponInfoDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CouponInfo getByKey(Long id) {
		return couponInfoDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return couponInfoDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CouponInfoExample example) {
		return couponInfoDao.deleteByExample(example);
	}

	public Integer updateByObject(CouponInfo record) {
		return couponInfoDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CouponInfoExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),couponInfoDao.countByExample(example));
		p.setList(couponInfoDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CouponInfo> getObjectList(CouponInfoExample example) {
		return couponInfoDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CouponInfoExample example) {
		return couponInfoDao.countByExample(example);
	}

	
}
