package com.amall.core.service.bargain;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.dao.BargainMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class BargainServiceImpl implements IBargainService {

	@Resource
	private BargainMapper bargainDao;

	public Long add(Bargain example) {
		return bargainDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Bargain getByKey(Long id) {
		return bargainDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return bargainDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(BargainExample example) {
		return bargainDao.deleteByExample(example);
	}

	public Integer updateByObject(Bargain record) {
		return bargainDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(BargainExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),bargainDao.countByExample(example));
		p.setList(bargainDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Bargain> getObjectList(BargainExample example) {
		return bargainDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(BargainExample example) {
		return bargainDao.countByExample(example);
	}

	
}
