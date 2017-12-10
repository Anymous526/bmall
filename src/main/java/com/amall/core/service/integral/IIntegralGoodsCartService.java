package com.amall.core.service.integral;

import java.util.List;

import com.amall.core.bean.IntegralGoodsCart;
import com.amall.core.bean.IntegralGoodsCartExample;
import com.amall.core.web.page.Pagination;

public abstract interface IIntegralGoodsCartService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param IntegralGoodsCart
	 * @return
	 */
	public Long add(IntegralGoodsCart example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public IntegralGoodsCart getByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description: 根据id单个删除</p>
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(IntegralGoodsCartExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(IntegralGoodsCart record);
	
	public Pagination getObjectListWithPage(IntegralGoodsCartExample example);
	
	public List<IntegralGoodsCart> getObjectList(IntegralGoodsCartExample example);
	
	public Integer getObjectListCount(IntegralGoodsCartExample example);
}
