package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsType2Spec;
import com.amall.core.bean.GoodsType2SpecExample;
import com.amall.core.dao.GoodsType2SpecMapper;

@Service
@Transactional
public class GoodsType2SpecServiceImpl implements IGoodsType2SpecService {

	@Resource
	private GoodsType2SpecMapper goodsType2SpecDao;
	
	@Override
	public Integer add(GoodsType2Spec example) {
		return goodsType2SpecDao.insertSelective(example);
	}

	@Override
	public Integer deleteByExample(GoodsType2SpecExample example) {
		return goodsType2SpecDao.deleteByExample(example);
	}

	@Override
	public Integer updateByObject(GoodsType2Spec record) {
		return null;
	}

	@Transactional(readOnly=true)
	public List<GoodsType2Spec> getObjectList(GoodsType2SpecExample example) {
		return goodsType2SpecDao.selectByExample(example);
	}

	@Override
	public Integer getObjectListCount(GoodsType2SpecExample example) {
		return null;
	}

}
