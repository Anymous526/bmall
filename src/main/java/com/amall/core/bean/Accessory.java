package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Accessory implements Serializable
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String ext;

	private Integer height;

	private String info;		// 描述

	private String name;		// 名称

	private String path;		// 路径

	private Float size;

	private Integer width;

	private Long albumId;		// 相册外键id

	private Long userId;		// 用户外键id

	private Long configId;

	private Boolean ismat;

	private byte [ ] opencvmat;

	public Long getId ( )
		{
			return id;
		}

	public void setId (Long id)
		{
			this.id = id;
		}

	public Date getAddtime ( )
		{
			return addtime;
		}

	public void setAddtime (Date addtime)
		{
			this.addtime = addtime;
		}

	public Boolean getDeletestatus ( )
		{
			return deletestatus;
		}

	public void setDeletestatus (Boolean deletestatus)
		{
			this.deletestatus = deletestatus;
		}

	public String getExt ( )
		{
			return ext;
		}

	public void setExt (String ext)
		{
			this.ext = ext == null ? null : ext.trim ();
		}

	public Integer getHeight ( )
		{
			return height;
		}

	public void setHeight (Integer height)
		{
			this.height = height;
		}

	public String getInfo ( )
		{
			return info;
		}

	public void setInfo (String info)
		{
			this.info = info == null ? null : info.trim ();
		}

	public String getName ( )
		{
			return name;
		}

	public void setName (String name)
		{
			this.name = name == null ? null : name.trim ();
		}

	public String getPath ( )
		{
			return path;
		}

	public void setPath (String path)
		{
			this.path = path == null ? null : path.trim ();
		}

	public Float getSize ( )
		{
			return size;
		}

	public void setSize (Float size)
		{
			this.size = size;
		}

	public Integer getWidth ( )
		{
			return width;
		}

	public void setWidth (Integer width)
		{
			this.width = width;
		}

	public Long getAlbumId ( )
		{
			return albumId;
		}

	public void setAlbumId (Long albumId)
		{
			this.albumId = albumId;
		}

	public Long getUserId ( )
		{
			return userId;
		}

	public void setUserId (Long userId)
		{
			this.userId = userId;
		}

	public Long getConfigId ( )
		{
			return configId;
		}

	public void setConfigId (Long configId)
		{
			this.configId = configId;
		}

	private Album cover_album;

	private SysConfig config;

	private Album album;

	private User user;

	private List <GoodsWithBLOBs> goods_list = new ArrayList <GoodsWithBLOBs> ();

	private List <GoodsWithBLOBs> goods_main_list = new ArrayList <GoodsWithBLOBs> ();

	public Album getCover_album ( )
		{
			return cover_album;
		}

	public void setCover_album (Album cover_album)
		{
			this.cover_album = cover_album;
		}

	public SysConfig getConfig ( )
		{
			return config;
		}

	public void setConfig (SysConfig config)
		{
			this.config = config;
		}

	public Album getAlbum ( )
		{
			return album;
		}

	public void setAlbum (Album album)
		{
			this.album = album;
			if (album != null)
			{
				this.albumId = album.getId ();
			}
		}

	public User getUser ( )
		{
			return user;
		}

	public void setUser (User user)
		{
			this.user = user;
		}

	public List <GoodsWithBLOBs> getGoods_list ( )
		{
			return goods_list;
		}

	public void setGoods_list (List <GoodsWithBLOBs> goods_list)
		{
			this.goods_list = goods_list;
		}

	public List <GoodsWithBLOBs> getGoods_main_list ( )
		{
			return goods_main_list;
		}

	public void setGoods_main_list (List <GoodsWithBLOBs> goods_main_list)
		{
			this.goods_main_list = goods_main_list;
		}

	public Boolean getIsmat ( )
		{
			return ismat;
		}

	public void setIsmat (Boolean ismat)
		{
			this.ismat = ismat;
		}

	public byte [ ] getOpencvmat ( )
		{
			return opencvmat;
		}

	public void setOpencvmat (byte [ ] opencvmat)
		{
			this.opencvmat = opencvmat;
		}
}