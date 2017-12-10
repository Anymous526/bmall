package com.amall.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Verify;
import com.amall.core.bean.VerifyExample;
import com.amall.core.dao.VerifyMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserVerifyServiceImpl implements IUserVerifyService {
	
	@Resource
	private VerifyMapper verifyDao;
	
	public Integer add(Verify verify) {
		return verifyDao.insertSelective(verify);
	}
	@Transactional(readOnly=true)
	public Verify getByKey(Long id) {
		return verifyDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return verifyDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(VerifyExample example) {
		return verifyDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<Verify> getObjectList(VerifyExample example) {
		return verifyDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(VerifyExample example) {
		return verifyDao.countByExample(example);
	}

	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(VerifyExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),verifyDao.countByExample(example));
		p.setList(verifyDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Override
	public Integer updateByObject(Verify record)
	{
		return verifyDao.updateByPrimaryKeySelective(record);
	}

}
