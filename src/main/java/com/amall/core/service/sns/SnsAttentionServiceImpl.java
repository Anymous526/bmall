package com.amall.core.service.sns;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SnsAttention;
import com.amall.core.bean.SnsAttentionExample;
import com.amall.core.dao.SnsAttentionMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SnsAttentionServiceImpl implements ISnsAttentionService {

	@Resource
	private SnsAttentionMapper snsAttentionDao;

	public Long add(SnsAttention example) {
		return snsAttentionDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SnsAttention getByKey(Long id) {
		return snsAttentionDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return snsAttentionDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SnsAttentionExample example) {
		return snsAttentionDao.deleteByExample(example);
	}

	public Integer updateByObject(SnsAttention record) {
		return snsAttentionDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SnsAttentionExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),snsAttentionDao.countByExample(example));
		p.setList(snsAttentionDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SnsAttention> getObjectList(SnsAttentionExample example) {
		return snsAttentionDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SnsAttentionExample example) {
		return snsAttentionDao.countByExample(example);
	}


	
}
