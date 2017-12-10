package com.amall.core.service.system;

import java.util.List;

import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigExample;
import com.amall.core.bean.SysConfigWithBLOBs;
/**
 * 
 * <p>Title: ISysConfigService</p>
 * <p>Description: 系统配置service接口</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:19:45
 * @version 1.0
 */
public interface ISysConfigService{
	
	/**
	 * 
	 * <p>Title: getSysConfig</p>
	 * <p>Description: 获得系统参数信息</p>
	 * @return  SysConfig
	 */
	public abstract SysConfigWithBLOBs getSysConfig();
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SysConfig
	 * @return
	 */
	public Long add(SysConfigWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SysConfig getByKey(Long id);
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
	public Integer deleteByExample(SysConfigExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SysConfigWithBLOBs record);
	
	public List<SysConfigWithBLOBs> getObjectList(SysConfigExample example);
	
}
