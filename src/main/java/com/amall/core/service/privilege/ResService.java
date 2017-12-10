package com.amall.core.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Res;
import com.amall.core.bean.ResExample;
import com.amall.core.dao.ResMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ResService implements IResService {

	@Resource 
	private ResMapper  resDAO;

	public Long add(Res example) {
		
		return resDAO.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Res getByKey(Long id) {
		
		return resDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return resDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ResExample example) {
		
		return resDAO.deleteByExample(example);
	}

	public Integer updateByObject(Res record) {
		
		return resDAO.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ResExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),resDAO.countByExample(example));
		p.setList(resDAO.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Res> getObjectList(ResExample example) {
		
		return resDAO.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ResExample example) {
		
		return resDAO.countByExample(example);
	}

}
