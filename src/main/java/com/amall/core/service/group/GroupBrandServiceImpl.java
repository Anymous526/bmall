package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import com.amall.core.dao.GroupBrandMapper;
import com.amall.core.web.page.Pagination;


@Service
@Transactional
public class GroupBrandServiceImpl implements IGroupBrandService {

	@Resource
	private GroupBrandMapper groupBrandDao;
	
	public Long add(GroupBrand example) {
		return groupBrandDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GroupBrand getByKey(Long id) {
		return groupBrandDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return groupBrandDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupBrandExample example) {
		return groupBrandDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupBrand record) {
		return groupBrandDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupBrandExample example) {
		Pagination p=new Pagination(example.getPageNo(),example.getPageSize(),groupBrandDao.countByExample(example));
		p.setList(groupBrandDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GroupBrand> getObjectList(GroupBrandExample example) {
		return groupBrandDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupBrandExample example) {
		return groupBrandDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<GroupBrand> selectByExampleWithPage(GroupBrandExample example) {
		return groupBrandDao.selectByExampleWithPage(example);
	}

}
