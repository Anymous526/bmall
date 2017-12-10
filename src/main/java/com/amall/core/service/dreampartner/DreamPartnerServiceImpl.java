package com.amall.core.service.dreampartner;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerExample;
import com.amall.core.dao.DreamPartnerMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DreamPartnerServiceImpl implements IDreamPartnerService {

	@Resource
	private DreamPartnerMapper dreamPartnerDao;

	public Integer add(DreamPartner example) {
		return dreamPartnerDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public DreamPartner getByKey(Long id) {
		return dreamPartnerDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return dreamPartnerDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DreamPartnerExample example) {
		return dreamPartnerDao.deleteByExample(example);
	}

	@Transactional(readOnly=true)
	public List<DreamPartner> getObjectList(DreamPartnerExample example) {
		return dreamPartnerDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DreamPartnerExample example) {
		return dreamPartnerDao.countByExample(example);
	}

	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DreamPartnerExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),dreamPartnerDao.countByExample(example));
		p.setList(dreamPartnerDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Override
	public Integer updateByObject(DreamPartner record)
	{
		return dreamPartnerDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public int countByExample(DreamPartnerExample example)
	{
		return dreamPartnerDao.countByExample(example);
	}
	
}
