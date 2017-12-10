package com.amall.core.service.gold;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.doulog;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.bean.userMoneyDetailExample;
import com.amall.core.dao.userMoneyDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserMoneyDetailServiceImpl implements IUserMoneyDetailService {

	@Resource
	private userMoneyDetailMapper doulogDao;

	public int add(userMoneyDetail example) {
		return doulogDao.insertSelective(example);
	}

	public userMoneyDetail getByKey(Long id) {
		return doulogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return doulogDao.deleteByPrimaryKey(id);
	}

	public int deleteByExample(userMoneyDetailExample example) {
		return doulogDao.deleteByExample(example);
	}

	public Integer updateByObject(userMoneyDetail record) {
		return doulogDao.updateByPrimaryKeySelective(record);
	}

	public Integer getObjectListCount(userMoneyDetailExample example) {
		return doulogDao.countByExample(example);
	}

	@Override
	public Pagination getObjectListWithPage(userMoneyDetailExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),doulogDao.countByExample(example));
		p.setList(doulogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}

	@Override
	public List<userMoneyDetail> getObjectList(userMoneyDetailExample example) {
		return doulogDao.selectByExample(example);
	}


}
