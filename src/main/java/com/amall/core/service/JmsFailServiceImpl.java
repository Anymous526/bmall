package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.JmsFail;
import com.amall.core.bean.JmsFailExample;
import com.amall.core.dao.JmsFailMapper;

@Service
@Transactional
public class JmsFailServiceImpl implements IJmsFailService
{

	@Resource
	private JmsFailMapper jmsDao;

	public Integer add (JmsFail example)
		{
			return jmsDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public JmsFail getByKey (Long id)
		{
			return jmsDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return jmsDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (JmsFailExample example)
		{
			return jmsDao.deleteByExample (example);
		}

	public Integer updateByObject (JmsFail record)
		{
			return jmsDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public List <JmsFail> getObjectList (JmsFailExample example)
		{
			return jmsDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (JmsFailExample example)
		{
			return jmsDao.countByExample (example);
		}
}
