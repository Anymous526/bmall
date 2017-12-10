package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Partner;
import com.amall.core.bean.PartnerExample;
import com.amall.core.dao.PartnerMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PartnerServiceImpl implements IPartnerService {

	@Resource 
	private PartnerMapper  partnerDao;

	public Long add(Partner example) {
		return partnerDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Partner getByKey(Long id) {
		return partnerDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return partnerDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PartnerExample example) {
		return partnerDao.deleteByExample(example);
	}

	public Integer updateByObject(Partner record) {
		return partnerDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PartnerExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),partnerDao.countByExample(example));
		p.setList(partnerDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Partner> getObjectList(PartnerExample example) {
		return partnerDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PartnerExample example) {
		return partnerDao.countByExample(example);
	}


}
