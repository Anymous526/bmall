package com.amall.core.service.image;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;
import com.amall.core.bean.User;
import com.amall.core.dao.AlbumMapper;
import com.amall.core.dao.UserMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AlbumServiceImpl implements IAlbumService
{

	@Resource
	private AlbumMapper albumDao;

	@Resource
	private UserMapper userDAO;

	public Album getDefaultAlbum (Long id)
		{
			User user = (User) this.userDAO.selectByPrimaryKey (id);
			if (user.getParentId () == null)
			{
				AlbumExample example = new AlbumExample ();
				example.createCriteria ().andUserIdEqualTo (id).andAlbumDefaultEqualTo (Boolean.valueOf (true));
				List <Album> list = this.albumDao.selectByExampleWithBLOBs (example);
				if (list.size () > 0)
				{
					return (Album) list.get (0);
				}
				return null;
			}
			AlbumExample example = new AlbumExample ();
			example.createCriteria ().andUserIdEqualTo (id).andAlbumDefaultEqualTo (Boolean.valueOf (true));
			List <Album> list = this.albumDao.selectByExampleWithBLOBs (example);
			if (list.size () > 0)
			{
				return (Album) list.get (0);
			}
			return null;
		}

	public Long add (Album example)
		{
			return albumDao.insertSelective (example);
		}

	public Album getByKey (Long id)
		{
			return albumDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return albumDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (AlbumExample example)
		{
			return albumDao.deleteByExample (example);
		}

	public Integer updateByObject (Album record)
		{
			return albumDao.updateByPrimaryKeySelective (record);
		}

	public Pagination getObjectListWithPage (AlbumExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , albumDao.countByExample (example));
			p.setList (albumDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}

	public List <Album> getObjectList (AlbumExample example)
		{
			return albumDao.selectByExampleWithBLOBs (example);
		}

	public Integer getObjectListCount (AlbumExample example)
		{
			return albumDao.countByExample (example);
		}
}
