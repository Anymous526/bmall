package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.ConsultWithBLOBs;
import com.amall.core.dao.ConsultMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ConsultServiceImpl implements IConsultService
{

	@Resource
	private ConsultMapper consultDao;

	public Long add (ConsultWithBLOBs example)
		{
			return consultDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public ConsultWithBLOBs getByKey (Long id)
		{
			return consultDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return consultDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (ConsultExample example)
		{
			return consultDao.deleteByExample (example);
		}

	public Integer updateByObject (ConsultWithBLOBs record)
		{
			return consultDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (ConsultExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , consultDao.countByExample (example));
			p.setList (consultDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <ConsultWithBLOBs> getObjectList (ConsultExample example)
		{
			return consultDao.selectByExampleWithBLOBs (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (ConsultExample example)
		{
			return consultDao.countByExample (example);
		}
}
