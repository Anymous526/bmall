package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Goods2Ugc;
import com.amall.core.bean.Goods2UgcExample;
import com.amall.core.dao.Goods2UgcMapper;

@Service
@Transactional
public class Goods2UserGoodsClassServiceImpl implements
		IGoods2UserGoodsClassService {

	@Resource
	private Goods2UgcMapper g2uDao;
	
	public Integer add(Goods2Ugc example) {
		return g2uDao.insertSelective(example);
	}

	public Integer deleteByExample(Goods2UgcExample example) {
		return g2uDao.deleteByExample(example);
	}

	public Integer updateByObject(Goods2Ugc record) {
		return null;
	}
	@Transactional(readOnly=true)
	public List<Goods2Ugc> getObjectList(Goods2UgcExample example) {
		return g2uDao.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(Goods2UgcExample example) {
		return g2uDao.countByExample(example);
	}

	public void updateByExample(Goods2Ugc record,Goods2UgcExample example) {
		g2uDao.updateByExample(record, example);
	}

}
