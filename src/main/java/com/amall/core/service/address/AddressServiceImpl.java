package com.amall.core.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Address;
import com.amall.core.bean.AddressExample;
import com.amall.core.dao.AddressMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Resource
	private AddressMapper addressDao;

	public Long add(Address example) {
		return addressDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Address getByKey(Long id) {
		return addressDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return addressDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AddressExample example) {
		return addressDao.deleteByExample(example);
	}

	public Integer updateByObject(Address record) {
		return addressDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(AddressExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),addressDao.countByExample(example));
		p.setList(addressDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Address> getObjectList(AddressExample example) {
		return addressDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(AddressExample example) {
		return addressDao.countByExample(example);
	}


	
}
