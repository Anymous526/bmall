package com.amall.core.service.goods;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Goods2Spec;
import com.amall.core.bean.Goods2SpecExample;
import com.amall.core.dao.Goods2SpecMapper;


@Service
@Transactional
public class Goods2SpecServiceImpl implements IGoods2SpecService {

	
	@Resource
	private Goods2SpecMapper goods2SpecMapper;
	
	public Integer add(Goods2Spec example) {
		return goods2SpecMapper.insertSelective(example);
	}

	public Integer deleteByExample(Goods2SpecExample example) {
		return goods2SpecMapper.deleteByExample(example);
	}

	public Integer updateByObject(Goods2Spec record) {
		return null;
	}

	@Transactional(readOnly=true)
	public List<Goods2Spec> getObjectList(Goods2SpecExample example) {
		return goods2SpecMapper.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(Goods2SpecExample example) {
		return goods2SpecMapper.countByExample(example);
	}

}
