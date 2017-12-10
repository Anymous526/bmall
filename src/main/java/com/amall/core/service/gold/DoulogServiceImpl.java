package com.amall.core.service.gold;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.doulog;
import com.amall.core.bean.doulogExample;
import com.amall.core.dao.doulogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DoulogServiceImpl implements IDoulogService
{

	@Resource
	private doulogMapper doulogDao;

	public int add (doulog example)
		{
			return doulogDao.insertSelective (example);
		}

	public doulog getByKey (Long id)
		{
			return doulogDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return doulogDao.deleteByPrimaryKey (id);
		}

	public int deleteByExample (doulogExample example)
		{
			return doulogDao.deleteByExample (example);
		}

	public Integer updateByObject (doulog record)
		{
			return doulogDao.updateByPrimaryKeySelective (record);
		}

	public Integer getObjectListCount (doulogExample example)
		{
			return doulogDao.countByExample (example);
		}

	@Override
	public List <doulog> getObjectList (doulogExample example)
		{
			return doulogDao.selectByExample (example);
		}

	public Pagination page (doulogExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , doulogDao.countByExample (example));
			p.setList (doulogDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}
}
