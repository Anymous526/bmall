package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.dao.ExpressCompanyMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ExpressCompanyServiceImpl implements IExpressCompanyService {

	@Resource
	private ExpressCompanyMapper expressCompanyDao;

	public Long add(ExpressCompany example) {
		return expressCompanyDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ExpressCompany getByKey(Long id) {
		return expressCompanyDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return expressCompanyDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ExpressCompanyExample example) {
		return expressCompanyDao.deleteByExample(example);
	}

	public Integer updateByObject(ExpressCompany record) {
		return expressCompanyDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ExpressCompanyExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),expressCompanyDao.countByExample(example));
		p.setList(expressCompanyDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ExpressCompany> getObjectList(ExpressCompanyExample example) {
		return expressCompanyDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ExpressCompanyExample example) {
		return expressCompanyDao.countByExample(example);
	}

	
}
