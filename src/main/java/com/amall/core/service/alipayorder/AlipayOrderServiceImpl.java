package com.amall.core.service.alipayorder;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.dao.AlipayOrderMapper;

@Service
@Transactional
public class AlipayOrderServiceImpl implements IAlipayOrderService
{

	@Resource
	private AlipayOrderMapper alipayOrderDao;

	public Long add (AlipayOrder alipayOrder)
		{
			return alipayOrderDao.insertSelective (alipayOrder);
		}

	@Transactional(readOnly = true)
	public AlipayOrder getByKey (Long id)
		{
			return alipayOrderDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return alipayOrderDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (AlipayOrderExample example)
		{
			return alipayOrderDao.deleteByExample (example);
		}

	public Integer updateByObject (AlipayOrder record)
		{
			return alipayOrderDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public List <AlipayOrder> getObjectList (AlipayOrderExample example)
		{
			return alipayOrderDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (AlipayOrderExample example)
		{
			return alipayOrderDao.countByExample (example);
		}
}
