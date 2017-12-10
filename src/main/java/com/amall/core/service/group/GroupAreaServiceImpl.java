package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupArea;
import com.amall.core.bean.GroupAreaExample;
import com.amall.core.dao.GroupAreaMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GroupAreaServiceImpl implements IGroupAreaService {

	@Resource
	private GroupAreaMapper groupAreaDao;

	public Long add(GroupArea example) {
		return groupAreaDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GroupArea getByKey(Long id) {
		
		return groupAreaDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return groupAreaDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupAreaExample example) {
		
		return groupAreaDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupArea record) {
		
		return groupAreaDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupAreaExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),groupAreaDao.countByExample(example));
		p.setList(groupAreaDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GroupArea> getObjectList(GroupAreaExample example) {
		
		return groupAreaDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupAreaExample example) {
		
		return groupAreaDao.countByExample(example);
	}


}
