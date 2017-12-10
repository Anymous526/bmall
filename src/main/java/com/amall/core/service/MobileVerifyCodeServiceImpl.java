package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.MobileVerifyCode;
import com.amall.core.bean.MobileVerifyCodeExample;
import com.amall.core.dao.MobileVerifyCodeMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class MobileVerifyCodeServiceImpl implements IMobileVerifyCodeService {

	@Resource 
	private MobileVerifyCodeMapper  mobileVerifyCodeDao;

	public Long add(MobileVerifyCode example) {
		
		return mobileVerifyCodeDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public MobileVerifyCode getByKey(Long id) {
		
		return mobileVerifyCodeDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return mobileVerifyCodeDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(MobileVerifyCodeExample example) {
		
		return mobileVerifyCodeDao.deleteByExample(example);
	}

	public Integer updateByObject(MobileVerifyCode record) {
		
		return mobileVerifyCodeDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(MobileVerifyCodeExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),mobileVerifyCodeDao.countByExample(example));
		p.setList(mobileVerifyCodeDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<MobileVerifyCode> getObjectList(MobileVerifyCodeExample example) {
		
		return mobileVerifyCodeDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(MobileVerifyCodeExample example) {
		
		return mobileVerifyCodeDao.countByExample(example);
	}


}
