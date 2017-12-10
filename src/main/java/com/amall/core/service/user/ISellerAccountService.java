package com.amall.core.service.user;

import java.util.List;

import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;
import com.amall.core.web.page.Pagination;

public interface ISellerAccountService {
	/**
	 * 
	 * <p>
	 * Title: add
	 * </p>
	 * <p>
	 * Description: 添加
	 * </p>
	 * 
	 * @param DreamPartner
	 * @return
	 */
	public Integer add(SellerAccount SellerAccount);

	/**
	 * 
	 * <p>
	 * Title: getByKey
	 * </p>
	 * <p>
	 * Description: 根据id查询单个对象
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public SellerAccount getByKey(Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByKey
	 * </p>
	 * <p>
	 * Description: 根据id单个删除
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByExample
	 * </p>
	 * <p>
	 * Description: 根据条件删除
	 * </p>
	 * 
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(SellerAccountExample example);

	public List<SellerAccount> getObjectList(SellerAccountExample example);

	public Integer getObjectListCount(SellerAccountExample example);

	public Pagination getObjectListWithPage(SellerAccountExample example);

	public Integer updateByObject(SellerAccount SellerAccount);

}
