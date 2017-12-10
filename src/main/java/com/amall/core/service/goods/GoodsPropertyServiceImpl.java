package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsProperty;
import com.amall.core.bean.GoodsPropertyExample;
import com.amall.core.dao.GoodsPropertyMapper;

@Service
@Transactional
public class GoodsPropertyServiceImpl implements IGoodsPropertyService {
	
	@Resource
	private GoodsPropertyMapper gpDao;


	@Transactional(readOnly=true)
	public int countByExample(GoodsPropertyExample example) {
		return this.gpDao.countByExample(example);
	}

	public int deleteByExample(GoodsPropertyExample example) {
		return this.gpDao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Long id) {
		return this.gpDao.deleteByPrimaryKey(id);
	}

	public int insert(GoodsProperty record) {
		return this.gpDao.insert(record);
	}

	public int insertSelective(GoodsProperty record) {
		return this.gpDao.insertSelective(record);
	}


	@Transactional(readOnly=true)
	public List<GoodsProperty> selectByExample(GoodsPropertyExample example) {
		return this.gpDao.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public GoodsProperty selectByPrimaryKey(Long id) {
		return this.gpDao.selectByPrimaryKey(id);
	}


	public int updateByPrimaryKey(GoodsProperty record) {
		return this.gpDao.updateByPrimaryKey(record);
	}

	public int updateByExample(GoodsProperty record) {
		return this.gpDao.updateByPrimaryKeySelective(record);
	}

}
