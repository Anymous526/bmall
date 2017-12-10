package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dynamic implements Serializable
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private Integer discussnum;

	private Integer praisenum;

	private Integer turnnum;

	private Long dissparentId;

	private Long goodsId;

	private Long turnparentId;

	private Long userId;

	private Boolean locked;

	private Long imgId;

	private Long storeId;

	private Boolean display;

	private String content;

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

	public Integer getDiscussnum ( )
		{
			return discussnum;
		}

	public void setDiscussnum (Integer discussnum)
		{
			this.discussnum = discussnum;
		}

	public Integer getPraisenum ( )
		{
			return praisenum;
		}

	public void setPraisenum (Integer praisenum)
		{
			this.praisenum = praisenum;
		}

	public Integer getTurnnum ( )
		{
			return turnnum;
		}

	public void setTurnnum (Integer turnnum)
		{
			this.turnnum = turnnum;
		}

	public Long getDissparentId ( )
		{
			return dissparentId;
		}

	public void setDissparentId (Long dissparentId)
		{
			this.dissparentId = dissparentId;
		}

	public Long getGoodsId ( )
		{
			return goodsId;
		}

	public void setGoodsId (Long goodsId)
		{
			this.goodsId = goodsId;
		}

	public Long getTurnparentId ( )
		{
			return turnparentId;
		}

	public void setTurnparentId (Long turnparentId)
		{
			this.turnparentId = turnparentId;
		}

	public Long getUserId ( )
		{
			return userId;
		}

	public void setUserId (Long userId)
		{
			this.userId = userId;
		}

	public Boolean getLocked ( )
		{
			return locked;
		}

	public void setLocked (Boolean locked)
		{
			this.locked = locked;
		}

	public Long getImgId ( )
		{
			return imgId;
		}

	public void setImgId (Long imgId)
		{
			this.imgId = imgId;
		}

	public Long getStoreId ( )
		{
			return storeId;
		}

	public void setStoreId (Long storeId)
		{
			this.storeId = storeId;
		}

	public Boolean getDisplay ( )
		{
			return display;
		}

	public void setDisplay (Boolean display)
		{
			this.display = display;
		}

	public String getContent ( )
		{
			return content;
		}

	public void setContent (String content)
		{
			this.content = content == null ? null : content.trim ();
		}

	private Goods goods;

	private User user;

	private Store store;

	List <Dynamic> childs = new ArrayList <Dynamic> ();// dissParent_id

	public Goods getGoods ( )
		{
			return goods;
		}

	public void setGoods (Goods goods)
		{
			this.goods = goods;
		}

	public User getUser ( )
		{
			return user;
		}

	public void setUser (User user)
		{
			this.user = user;
		}

	public List <Dynamic> getChilds ( )
		{
			return childs;
		}

	public void setChilds (List <Dynamic> childs)
		{
			this.childs = childs;
		}

	public Store getStore ( )
		{
			return store;
		}

	public void setStore (Store store)
		{
			this.store = store;
		}
}