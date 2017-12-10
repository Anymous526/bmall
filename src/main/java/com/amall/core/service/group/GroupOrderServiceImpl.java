package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupOrder;
import com.amall.core.bean.GroupOrderExample;
import com.amall.core.dao.GroupOrderMapper;
import com.amall.core.web.page.Pagination;


@Service
@Transactional
public class GroupOrderServiceImpl implements IGroupOrderService {

	@Resource
	private GroupOrderMapper groupOrderDao;
	
	public Long add(GroupOrder example) {
		// TODO Auto-generated method stub
		return groupOrderDao.insertSelective(example);
	}
    @Transactional(readOnly=true)
	public GroupOrder getByKey(Long id) {
		// TODO Auto-generated method stub
		return groupOrderDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		// TODO Auto-generated method stub
		return groupOrderDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupOrderExample example) {
		// TODO Auto-generated method stub
		return groupOrderDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupOrder record) {
		// TODO Auto-generated method stub
		return groupOrderDao.updateByPrimaryKeySelective(record);
	}
    @Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupOrderExample example) {
		// TODO Auto-generated method stub
    	Pagination p=new Pagination(example.getPageNo(),example.getPageSize(),groupOrderDao.countByExample(example));
    	p.setList(groupOrderDao.selectByExampleAndPage(example));
		return null;
	}
    @Transactional(readOnly=true)
	public List<GroupOrder> getObjectList(GroupOrderExample example) {
		// TODO Auto-generated method stub
		return groupOrderDao.selectByExample(example);
	}
    @Transactional(readOnly=true)
	public Integer getObjectListCount(GroupOrderExample example) {
		// TODO Auto-generated method stub
		return groupOrderDao.countByExample(example);
	}

}
