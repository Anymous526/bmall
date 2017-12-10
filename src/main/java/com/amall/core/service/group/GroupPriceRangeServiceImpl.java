package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupPriceRange;
import com.amall.core.bean.GroupPriceRangeExample;
import com.amall.core.dao.GroupPriceRangeMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GroupPriceRangeServiceImpl implements IGroupPriceRangeService {

	@Resource
	private GroupPriceRangeMapper groupPriceRangeDao;

	public Long add(GroupPriceRange example) {
		
		return groupPriceRangeDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GroupPriceRange getByKey(Long id) {
		
		return groupPriceRangeDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return groupPriceRangeDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupPriceRangeExample example) {
		
		return groupPriceRangeDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupPriceRange record) {
		
		return groupPriceRangeDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupPriceRangeExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),groupPriceRangeDao.countByExample(example));
		p.setList(groupPriceRangeDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GroupPriceRange> getObjectList(GroupPriceRangeExample example) {
		
		return groupPriceRangeDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupPriceRangeExample example) {
		
		return groupPriceRangeDao.countByExample(example);
	}

}
