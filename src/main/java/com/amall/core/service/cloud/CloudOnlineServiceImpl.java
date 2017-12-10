package com.amall.core.service.cloud;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.CloudOnline;
import com.amall.core.bean.CloudOnlineExample;
import com.amall.core.dao.CloudOnlineMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CloudOnlineServiceImpl implements ICloudOnlineService
{

	@Resource
	private CloudOnlineMapper cloudOnlineDao;

	public Integer add (CloudOnline example)
		{
			return cloudOnlineDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public CloudOnline getByKey (Long id)
		{
			return cloudOnlineDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return cloudOnlineDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (CloudOnlineExample example)
		{
			return cloudOnlineDao.deleteByExample (example);
		}

	public Integer updateByObject (CloudOnline record)
		{
			return cloudOnlineDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (CloudOnlineExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , cloudOnlineDao.countByExample (example));
			p.setList (cloudOnlineDao.selectByExampleWithPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <CloudOnline> getObjectList (CloudOnlineExample example)
		{
			return cloudOnlineDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (CloudOnlineExample example)
		{
			return cloudOnlineDao.countByExample (example);
		}

	@Override
	public List <CloudOnline> getCloudOnlineOfUserId (long userId)
		{
			CloudOnlineExample example = new CloudOnlineExample ();
			example.createCriteria ().andUserIdEqualTo (userId);
			List <CloudOnline> list = getObjectList (example);
			if (!list.isEmpty ())
			{
				return list;
			}
			return null;
		}

	@Override
	public CloudOnline getCloudOnlineOfUserIdAndGoodsId (long userId , long goodsId)
		{
			CloudOnlineExample example = new CloudOnlineExample ();
			example.createCriteria ().andUserIdEqualTo (userId).andCloudGoodsIdEqualTo (goodsId);
			List <CloudOnline> list = getObjectList (example);
			if (!list.isEmpty ())
			{
				return list.get (0);
			}
			return null;
		}
}
