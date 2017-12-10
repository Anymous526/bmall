package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsCart;
import com.amall.core.bean.GoodsCartExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsCartService</p>
 * <p>Description: 购物车service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:23:45
 * @version 1.0
 */
public abstract interface IGoodsCartService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsCart
	 * @return
	 */
	public Long add(GoodsCart example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsCart getByKey(Long id);
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
	public Integer deleteByExample(GoodsCartExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsCart record);
	
	public Pagination getObjectListWithPage(GoodsCartExample example);
	
	public List<GoodsCart> getObjectList(GoodsCartExample example);
	
	public Integer getObjectListCount(GoodsCartExample example);
}
