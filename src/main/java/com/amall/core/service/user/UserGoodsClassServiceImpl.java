package com.amall.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.dao.UserGoodsClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserGoodsClassServiceImpl implements IUserGoodsClassService {

	@Resource 
	private UserGoodsClassMapper  userGoodsClassDao;

	public Long add(UserGoodsClass example) {
		return userGoodsClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public UserGoodsClass getByKey(Long id) {
		return userGoodsClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return userGoodsClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(UserGoodsClassExample example) {
		return userGoodsClassDao.deleteByExample(example);
	}

	public Integer updateByObject(UserGoodsClass record) {
		return userGoodsClassDao.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(UserGoodsClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),userGoodsClassDao.countByExample(example));
		p.setList(userGoodsClassDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Transactional(readOnly=true)
	public List<UserGoodsClass> getObjectList(UserGoodsClassExample example) {
		return userGoodsClassDao.selectByExample(example);
	}
	
	@Transactional(readOnly=true)
	public Integer getObjectListCount(UserGoodsClassExample example) {
		return userGoodsClassDao.countByExample(example);
	}
	

}
