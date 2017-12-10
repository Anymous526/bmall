package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.dao.EvaluateMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class EvaluateServiceImpl implements IEvaluateService
{

	@Resource
	private EvaluateMapper evaluateDao;

	public Long add (EvaluateWithBLOBs example)
		{
			return evaluateDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public EvaluateWithBLOBs getByKey (Long id)
		{
			return evaluateDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return evaluateDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (EvaluateExample example)
		{
			return evaluateDao.deleteByExample (example);
		}

	public Integer updateByObject (EvaluateWithBLOBs record)
		{
			return evaluateDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (EvaluateExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , evaluateDao.countByExample (example));
			p.setList (evaluateDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <EvaluateWithBLOBs> getObjectList (EvaluateExample example)
		{
			return evaluateDao.selectByExampleWithBLOBs (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (EvaluateExample example)
		{
			return evaluateDao.countByExample (example);
		}

	public List <EvaluateWithBLOBs> selectByOfLeftJoinStoreId (Long id)
		{
			return evaluateDao.selectByOfLeftJoinStoreId (id);
		}

	public List <EvaluateWithBLOBs> selectByDistinctGoods ( )
		{
			return evaluateDao.selectByDistinctGoods ();
		}
}
