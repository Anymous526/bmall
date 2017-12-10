package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;
import com.amall.core.dao.Goods2PhotoMapper;

@Service
@Transactional
public class Goods2PhotoServiceImpl implements IGoods2PhotoService {

	@Resource
	private Goods2PhotoMapper goods2PhotoMapper;
	
	public Integer add(Goods2Photo example) {
		return goods2PhotoMapper.insertSelective(example);
	}

	public Integer deleteByExample(Goods2PhotoExample example) {
		return goods2PhotoMapper.deleteByExample(example);
	}

	public Integer updateByObject(Goods2Photo record) {
		return null;
	}
	
    @Transactional(readOnly=true)
	public List<Goods2Photo> getObjectList(Goods2PhotoExample example) {
		return goods2PhotoMapper.selectByExample(example);
	}
    
    @Transactional(readOnly=true)
	public Integer getObjectListCount(Goods2PhotoExample example) {
		return goods2PhotoMapper.countByExample(example);
	}

}
