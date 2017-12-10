package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Title: Album</p>
 * <p>Description: 相册</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午7:24:49
 * @version 1.0
 */
public class Album implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean albumDefault;	//是否是默认相册

    private String albumName;	//相册名称

    private Integer albumSequence;	//相册序号

    private Long albumCoverId;

    private Long userId;

    private String alblumInfo;  //相册描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Boolean getAlbumDefault() {
        return albumDefault;
    }

    public void setAlbumDefault(Boolean albumDefault) {
        this.albumDefault = albumDefault;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public Integer getAlbumSequence() {
        return albumSequence;
    }

    public void setAlbumSequence(Integer albumSequence) {
        this.albumSequence = albumSequence;
    }

    public Long getAlbumCoverId() {
        return albumCoverId;
    }

    public void setAlbumCoverId(Long albumCoverId) {
        this.albumCoverId = albumCoverId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAlblumInfo() {
        return alblumInfo;
    }

    public void setAlblumInfo(String alblumInfo) {
        this.alblumInfo = alblumInfo == null ? null : alblumInfo.trim();
    }
    
    
    private User user;
    private List<Accessory> photos = new ArrayList<Accessory>();
    private Accessory albumCover;
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user!=null){
			this.userId = user.getId();
		}
	}

	public List<Accessory> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Accessory> photos) {
		this.photos = photos;
	}

	public Accessory getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(Accessory albumCover) {
		this.albumCover = albumCover;
		if(albumCover!=null){
			this.albumCoverId = albumCover.getId();
		}
	}

	
}