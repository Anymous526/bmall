package com.amall.core.service.dreampartnercash;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.DreamPartnerCash;
import com.amall.core.bean.DreamPartnerCashExample;
import com.amall.core.dao.DreamPartnerCashMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DreamPartnerCashServiceImpl implements IDreamPartnerCashService {

	@Resource
	private DreamPartnerCashMapper dreamPartnerCashDao;

	public Integer add(DreamPartnerCash example) {
		return dreamPartnerCashDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public DreamPartnerCash getByKey(Long id) {
		return dreamPartnerCashDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return dreamPartnerCashDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DreamPartnerCashExample example) {
		return dreamPartnerCashDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<DreamPartnerCash> getObjectList(DreamPartnerCashExample example) {
		return dreamPartnerCashDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DreamPartnerCashExample example) {
		return dreamPartnerCashDao.countByExample(example);
	}

	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DreamPartnerCashExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),dreamPartnerCashDao.countByExample(example));
		p.setList(dreamPartnerCashDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Override
	public Integer updateByObject(DreamPartnerCash record)
	{
		return dreamPartnerCashDao.updateByPrimaryKeySelective(record);
	}
	
}
