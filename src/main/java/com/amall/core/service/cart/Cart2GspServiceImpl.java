package com.amall.core.service.cart;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Cart2Gsp;
import com.amall.core.bean.Cart2GspExample;
import com.amall.core.dao.Cart2GspMapper;

@Service
@Transactional
public class Cart2GspServiceImpl implements ICart2GspService {
	
	@Resource
	private Cart2GspMapper cart2GspDao;
	
	public Integer add(Cart2Gsp example) {
		return cart2GspDao.insertSelective(example);
	}

	public Integer deleteByExample(Cart2GspExample example) {
		return cart2GspDao.deleteByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Cart2Gsp> getObjectList(Cart2GspExample example) {
		return cart2GspDao.selectByExample(example);
	}
	@Transactional(readOnly = true)
	public Integer getObjectListCount(Cart2GspExample example) {
		return cart2GspDao.countByExample(example);
	}

}
