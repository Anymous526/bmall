package com.amall.core.service.promote;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.PromoteDream;
import com.amall.core.bean.PromoteDreamExample;
import com.amall.core.dao.PromoteDreamMapper;

@Service
@Transactional
public class PromoteDreamService implements IPromoteDreamService
{

	@Resource
	private PromoteDreamMapper PromoteDreamDAO;

	public Integer add (PromoteDream example)
		{
			return PromoteDreamDAO.insertSelective (example);
		}

	public PromoteDream getByKey (Long id)
		{
			return PromoteDreamDAO.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return PromoteDreamDAO.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (PromoteDreamExample example)
		{
			return PromoteDreamDAO.deleteByExample (example);
		}

	public Integer updateByObject (PromoteDream record)
		{
			return PromoteDreamDAO.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public List <PromoteDream> getObjectList (PromoteDreamExample example)
		{
			return PromoteDreamDAO.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (PromoteDreamExample example)
		{
			return PromoteDreamDAO.countByExample (example);
		}
}
