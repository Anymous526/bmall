package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amall.core.bean.RefundItem;
import com.amall.core.bean.RefundItemExample;
import com.amall.core.dao.RefundItemMapper;
@Service
public class RefundItemServiceImpl implements IRefundItemSerivce{

	@Resource
	RefundItemMapper refundDao; 
	
	@Override
	public List<RefundItem> selectByExample(RefundItemExample item) {
		// TODO Auto-generated method stub
		return refundDao.selectByExample(item);
	}

	@Override
	public RefundItem selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return refundDao.selectByPrimaryKey(id);
	}

}
