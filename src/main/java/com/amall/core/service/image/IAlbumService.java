package com.amall.core.service.image;

import java.util.List;

import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IAlbumService</p>
 * <p>Description: 相册管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午11:36:06
 * @version 1.0
 */
public abstract interface IAlbumService{
	public Album getDefaultAlbum(Long id);
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Album
	 * @return
	 */
	public Long add(Album example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Album getByKey(Long id);
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
	public Integer deleteByExample(AlbumExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Album record);
	
	public Pagination getObjectListWithPage(AlbumExample example);
	
	public List<Album> getObjectList(AlbumExample example);
	
	public Integer getObjectListCount(AlbumExample example);
}
