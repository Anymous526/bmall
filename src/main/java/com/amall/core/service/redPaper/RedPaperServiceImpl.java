package com.amall.core.service.redPaper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.RedPaper;
import com.amall.core.bean.RedPaperExample;
import com.amall.core.dao.RedPaperMapper;
import com.amall.core.service.IRedPaperService;

@Service
@Transactional
public class RedPaperServiceImpl implements IRedPaperService {

	@Resource
	private RedPaperMapper redPaperDao;
	
	@Override
	public Integer add(RedPaper example) {
		return this.redPaperDao.insertSelective(example);
	}
	
	@Transactional(readOnly=true)
	@Override
	public RedPaper getByKey(Long id) {
		return this.redPaperDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer deleteByKey(Long id) {
		return this.redPaperDao.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByExample(RedPaperExample example) {
		return this.redPaperDao.deleteByExample(example);
	}

	@Override
	public Integer updateByObject(RedPaper record) {
		return this.redPaperDao.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<RedPaper> getObjectList(RedPaperExample example) {
		return this.redPaperDao.selectByExample(example);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Integer getObjectListCount(RedPaperExample example) {
		return this.redPaperDao.countByExample(example);
	}
}
