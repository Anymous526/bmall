package com.amall.core.service.cart;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.dao.CartDetailMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CartDetailServiceImpl implements ICartDetailService {

	@Resource
	private CartDetailMapper cartDetailDao;

	public Long add(CartDetail example) {
		return (long) cartDetailDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CartDetail getByKey(Long id) {
		return cartDetailDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return cartDetailDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CartDetailExample example) {
		return cartDetailDao.deleteByExample(example);
	}

	public Integer updateByObject(CartDetail record) {
		return cartDetailDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CartDetailExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),cartDetailDao.countByExample(example));
		p.setList(cartDetailDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	
	@Transactional(readOnly=true)
	public List<CartDetail> getObjectList(CartDetailExample example) {
		return cartDetailDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CartDetailExample example) {
		return cartDetailDao.countByExample(example);
	}


	
}
