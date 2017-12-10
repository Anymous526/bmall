package com.amall.core.service.gold;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.GoldRecordWithBLOBs;
import com.amall.core.dao.GoldRecordMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoldRecordServiceImpl implements IGoldRecordService {

	@Resource 
	private GoldRecordMapper  goldRecordDao;

	public Long add(GoldRecordWithBLOBs example) {
		return goldRecordDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoldRecordWithBLOBs getByKey(Long id) {
		return goldRecordDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goldRecordDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoldRecordExample example) {
		return goldRecordDao.deleteByExample(example);
	}

	public Integer updateByObject(GoldRecordWithBLOBs record) {
		return goldRecordDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoldRecordExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goldRecordDao.countByExample(example));
		p.setList(goldRecordDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoldRecordWithBLOBs> getObjectList(GoldRecordExample example) {
		return goldRecordDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoldRecordExample example) {
		return goldRecordDao.countByExample(example);
	}


}
