package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.dao.GoodsType2BrandMapper;

@Service
@Transactional
public class GoodsType2BrandServiceImpl implements IGoodsType2BrandService {

	@Resource
	private GoodsType2BrandMapper goodsType2BrandDao;
	
	@Override
	public Integer add(GoodsType2Brand example) {
		return goodsType2BrandDao.insertSelective(example);
	}

	@Override
	public Integer deleteByExample(GoodsType2BrandExample example) {
		return goodsType2BrandDao.deleteByExample(example);
	}

	@Override
	public Integer updateByObject(GoodsType2Brand record) {
		return null;
	}

	@Transactional(readOnly=true)
	public List<GoodsType2Brand> getObjectList(GoodsType2BrandExample example) {
		return goodsType2BrandDao.selectByExample(example);
	}

	@Override
	public Integer getObjectListCount(GoodsType2BrandExample example) {
		return null;
	}

}
