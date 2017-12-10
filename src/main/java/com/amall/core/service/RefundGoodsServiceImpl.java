package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amall.core.bean.RefundGoods;
import com.amall.core.bean.RefundGoodsExample;
import com.amall.core.dao.RefundGoodsMapper;
@Service
public class RefundGoodsServiceImpl implements IRefundGoodsService {

	@Resource
	RefundGoodsMapper dao;
	
	@Override
	public int countByExample(RefundGoodsExample example) {
		// TODO Auto-generated method stub
		return dao.countByExample(example);
	}

	@Override
	public int deleteByExample(RefundGoodsExample example) {
		// TODO Auto-generated method stub
		return dao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RefundGoods record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(RefundGoods record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public List<RefundGoods> selectByExample(RefundGoodsExample example) {
		// TODO Auto-generated method stub
		return dao.selectByExample(example);
	}

	@Override
	public RefundGoods selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RefundGoods record, RefundGoodsExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RefundGoods record, RefundGoodsExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RefundGoods record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RefundGoods record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public RefundGoods getObjectByOrderIdAndGooodsId(Long orderId, Long goodsId) {
		RefundGoodsExample exa = new RefundGoodsExample();
		exa.clear();
		exa.createCriteria().andOfIdEqualTo(orderId).andGoodsIdEqualTo(goodsId);
		List<RefundGoods> rgs  =dao.selectByExample(exa);
		if(rgs!=null && rgs.size()>0){
			return rgs.get(0);
		}
		return null;
	}

}
