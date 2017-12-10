package com.amall.core.service.cart;

import java.util.List;

import com.amall.core.bean.Cart2Gsp;
import com.amall.core.bean.Cart2GspExample;

public interface ICart2GspService {
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Integer add(Cart2Gsp example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(Cart2GspExample example);
	
	
	public List<Cart2Gsp> getObjectList(Cart2GspExample example);
	
	public Integer getObjectListCount(Cart2GspExample example);
}
