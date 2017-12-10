package com.amall.core.service.cart;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartExample;
import com.amall.core.dao.CartMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CartServiceImpl implements ICartService
{

	@Resource
	private CartMapper cartDao;

	public Long add (Cart example)
		{
			return (long) cartDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public Cart getByKey (Long id)
		{
			return cartDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return cartDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (CartExample example)
		{
			return cartDao.deleteByExample (example);
		}

	public Integer updateByObject (Cart record)
		{
			return cartDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (CartExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , cartDao.countByExample (example));
			p.setList (cartDao.selectByExampleWithPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <Cart> getObjectList (CartExample example)
		{
			return cartDao.selectByExample (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (CartExample example)
		{
			return cartDao.countByExample (example);
		}
}
