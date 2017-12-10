package com.amall.core.service.user;

import java.util.List;

import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.Verify;
import com.amall.core.bean.VerifyExample;
import com.amall.core.web.page.Pagination;

public abstract interface IUserVerifyService {

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
	public Integer add(Verify verify);

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
	public Verify getByKey(Long id);

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
	public Integer deleteByExample(VerifyExample example);

	public List<Verify> getObjectList(VerifyExample example);

	public Integer getObjectListCount(VerifyExample example);

	public Pagination getObjectListWithPage(VerifyExample example);

	public Integer updateByObject(Verify verify);
}
