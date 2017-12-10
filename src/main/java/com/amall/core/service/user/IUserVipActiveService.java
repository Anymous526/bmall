package com.amall.core.service.user;

import java.util.List;

import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.web.page.Pagination;
/**
 * VIP升级记录
* @ClassName: IUserVipActiveService 
* @Description: TODO
* @author lx
* @date 2015年12月18日 上午10:37:03 
*
 */
public interface IUserVipActiveService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param User
	 * @return
	 */
	public int add(VipActiveLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public VipActiveLog getByKey(Long id);
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
	public Integer deleteByExample(VipActiveLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(VipActiveLog record);
	
	public Pagination getObjectListWithPage(VipActiveLogExample example);
	
	public List<VipActiveLog> getObjectList(VipActiveLogExample example);
	
	public Integer getObjectListCount(VipActiveLogExample example);

}
