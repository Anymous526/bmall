package com.amall.core.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.dao.AreaMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AreaServiceImpl implements IAreaService {

	@Resource
	private AreaMapper areaDao;

	public Long add(Area example) {
		return areaDao.insertSelective(example);
	}

	@Transactional(readOnly = true)
	public Area getByKey(Long id) {
		return areaDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return areaDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AreaExample example) {
		return areaDao.deleteByExample(example);
	}

	public Integer updateByObject(Area record) {
		return areaDao.updateByPrimaryKeySelective(record);
	}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage(AreaExample example) {
		Pagination pagination = new Pagination(example.getPageNo(),
				example.getPageSize(), areaDao.countByExample(example));
		pagination.setList(areaDao.selectByExampleWithPage(example));
		return pagination;
	}

	@Transactional(readOnly = true)
	public List<Area> getObjectList(AreaExample example) {
		return areaDao.selectByExample(example);
	}

	@Transactional(readOnly = true)
	public Integer getObjectListCount(AreaExample example) {
		return areaDao.countByExample(example);
	}

}
