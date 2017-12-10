package com.amall.core.service.gold;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoldLogExample;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.dao.GoldLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoldLogServiceImpl implements IGoldLogService {

	@Resource
	private GoldLogMapper goldLogDao;

	public Long add(GoldLogWithBLOBs example) {
		return goldLogDao.insertSelective(example);
	}

	public GoldLogWithBLOBs getByKey(Long id) {
		return goldLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goldLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoldLogExample example) {
		return goldLogDao.deleteByExample(example);
	}

	public Integer updateByObject(GoldLogWithBLOBs record) {
		return goldLogDao.updateByPrimaryKeySelective(record);
	}

	public Pagination getObjectListWithPage(GoldLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goldLogDao.countByExample(example));
		p.setList(goldLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}

	public List<GoldLogWithBLOBs> getObjectList(GoldLogExample example) {
		return goldLogDao.selectByExampleWithBLOBs(example);
	}

	public Integer getObjectListCount(GoldLogExample example) {
		return goldLogDao.countByExample(example);
	}

	
}
