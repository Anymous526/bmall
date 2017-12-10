package com.amall.core.service.storevisit;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.StoreVisit;
import com.amall.core.bean.StoreVisitExample;
import com.amall.core.dao.StoreVisitMapper;

@Service
@Transactional
public class StoreVisitServiceImpl implements IStoreVisitService
{

	@Resource
	private StoreVisitMapper storeVisitDao;

	public Integer add (StoreVisit example)
		{
			return storeVisitDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public StoreVisit getByKey (Long id)
		{
			return storeVisitDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return storeVisitDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (StoreVisitExample example)
		{
			return storeVisitDao.deleteByExample (example);
		}

	@Transactional(readOnly = true)
	public List <StoreVisit> getObjectList (StoreVisitExample example)
		{
			return storeVisitDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (StoreVisitExample example)
		{
			return storeVisitDao.countByExample (example);
		}
}
