package com.amall.core.service.redPackge;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPackgeExample;
import com.amall.core.dao.RedPackgeMapper;
import com.amall.core.service.IRedPackgeService;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RedPackgeServiceImpl implements IRedPackgeService
{

	@Resource
	private RedPackgeMapper redPackgeDao;

	@Override
	public Integer add (RedPackge example)
		{
			return this.redPackgeDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	@Override
	public RedPackge getByKey (Long id)
		{
			return this.redPackgeDao.selectByPrimaryKey (id);
		}

	@Override
	public Integer deleteByKey (Long id)
		{
			return this.redPackgeDao.deleteByPrimaryKey (id);
		}

	@Override
	public Integer deleteByExample (RedPackgeExample example)
		{
			return this.redPackgeDao.deleteByExample (example);
		}

	@Override
	public Integer updateByObject (RedPackge record)
		{
			return this.redPackgeDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	@Override
	public List <RedPackge> getObjectList (RedPackgeExample example)
		{
			return this.redPackgeDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	@Override
	public Integer getObjectListCount (RedPackgeExample example)
		{
			return this.redPackgeDao.countByExample (example);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (RedPackgeExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , redPackgeDao.countByExample (example));
			p.setList (redPackgeDao.selectByExampleWithPage (example));
			return p;
		}
}
