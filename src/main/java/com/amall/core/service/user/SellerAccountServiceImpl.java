package com.amall.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;
import com.amall.core.dao.SellerAccountMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SellerAccountServiceImpl implements ISellerAccountService {

	@Resource
	private SellerAccountMapper sellerAccountDao;

	public Integer add(SellerAccount SellerAccount) {
		return sellerAccountDao.insertSelective(SellerAccount);
	}

	@Transactional(readOnly = true)
	public SellerAccount getByKey(Long id) {
		return sellerAccountDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return sellerAccountDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SellerAccountExample example) {
		return sellerAccountDao.deleteByExample(example);
	}

	@Transactional(readOnly = true)
	public List<SellerAccount> getObjectList(SellerAccountExample example) {
		return sellerAccountDao.selectByExample(example);
	}

	@Transactional(readOnly = true)
	public Integer getObjectListCount(SellerAccountExample example) {
		return sellerAccountDao.countByExample(example);
	}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage(SellerAccountExample example) {
		Pagination p = new Pagination(example.getPageNo(), example.getPageSize(),
				sellerAccountDao.countByExample(example));
		p.setList(sellerAccountDao.selectByExampleWithPage(example));
		return p;
	}

	@Override
	public Integer updateByObject(SellerAccount record) {
		return sellerAccountDao.updateByPrimaryKeySelective(record);
	}

}
