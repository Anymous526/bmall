package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.RefundItem;
import com.amall.core.bean.RefundItemExample;

public interface IRefundItemSerivce {

	List<RefundItem> selectByExample(RefundItemExample item);
	
	RefundItem selectByPrimaryKey(Long id);
}
