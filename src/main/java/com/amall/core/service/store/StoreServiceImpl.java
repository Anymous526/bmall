package com.amall.core.service.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.dao.StoreMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreServiceImpl implements IStoreService
{

	@Resource
	private StoreMapper storeDao;

	public Long add (StoreWithBLOBs example)
		{
			return storeDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public StoreWithBLOBs getByKey (Long id)
		{
			return storeDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return storeDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (StoreExample example)
		{
			return storeDao.deleteByExample (example);
		}

	public Integer updateByObject (StoreWithBLOBs record)
		{
			return storeDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (StoreExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , storeDao.countByExample (example));
			p.setList (storeDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <StoreWithBLOBs> getObjectList (StoreExample example)
		{
			return storeDao.selectByExampleWithBLOBs (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (StoreExample example)
		{
			return storeDao.countByExample (example);
		}

	@Override
	public int getStoreValidation (String storeName , String storeOwerCard , String telephone)
		{
			Map map = new HashMap <> ();
			map.put ("storeName" , storeName);
			map.put ("storeOwerCard" , storeOwerCard);
			map.put ("telephone" , telephone);
			return this.storeDao.getStoreValidation (map);
		}

	@Override
	public StoreWithBLOBs getStoreValidation1 (String storeName , String storeOwerCard , String telephone)
		{
			Map map = new HashMap <> ();
			map.put ("storeName" , storeName);
			map.put ("storeOwerCard" , storeOwerCard);
			map.put ("telephone" , telephone);
			return this.storeDao.getStoreValidation1 (map);
		}

	@Override
	public int getStoreNameValidation (String storeName)
		{
			return this.storeDao.getStoreNameValidation (storeName);
		}

	@Override
	public int getStoreOwerCardValidation (String storeOwerCard)
		{
			return this.storeDao.getStoreOwerCardValidation (storeOwerCard);
		}

	@Override
	public int getStoreTelephoneValidation (String storeTelpehone)
		{
			return this.storeDao.getStoreTelephoneValidation (storeTelpehone);
		}
}
