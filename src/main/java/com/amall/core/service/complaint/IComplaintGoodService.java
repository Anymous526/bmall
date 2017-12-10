package com.amall.core.service.complaint;

import java.util.List;

import com.amall.core.bean.ComplaintGoods;
import com.amall.core.bean.ComplaintGoodsExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IComplaintGoodService</p>
 * <p>Description: 投诉商品ComplaintGood</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  李越
 * @date	2015年8月1日下午3:07:05
 * @version 1.0
 */
public abstract interface IComplaintGoodService {

	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param example
	 * @return
	 */
	public Long add(ComplaintGoods example);
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ComplaintGoods getByKey(Long id);
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
	public Integer deleteByExample(ComplaintGoodsExample example);
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ComplaintGoods record);
	/**
	 * 
	 * <p>Title: getObjectListWithPage</p>
	 * <p>Description: 分页</p>
	 * @param example
	 * @return
	 */
	public Pagination getObjectListWithPage(ComplaintGoodsExample example);
	
    public List<ComplaintGoods> getObjectList(ComplaintGoodsExample example);
    
    public Integer getObjectListCount(ComplaintGoodsExample example);
	
	
}
