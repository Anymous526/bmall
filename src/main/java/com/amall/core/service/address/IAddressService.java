package com.amall.core.service.address;

import java.util.List;

import com.amall.core.bean.Address;
import com.amall.core.bean.AddressExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IAddressService</p>
 * <p>Description: 地址管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:10:15
 * @version 1.0
 */
public abstract interface IAddressService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Address
	 * @return
	 */
	public Long add(Address example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Address getByKey(Long id);
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
	public Integer deleteByExample(AddressExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Address record);
	
	public Pagination getObjectListWithPage(AddressExample example);
	
	public List<Address> getObjectList(AddressExample example);
	
	public Integer getObjectListCount(AddressExample example);
}
