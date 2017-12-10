package com.amall.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.dao.VipActiveLogMapper;
import com.amall.core.security.support.SecurityManagerSupport;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserVipActiveServiceImpl implements IUserVipActiveService {

	@Resource
	private VipActiveLogMapper vipActiveLogDAO;

	@Resource
	private SecurityManagerSupport securityManager;

	public int add(VipActiveLog example) {
		return vipActiveLogDAO.insertSelective(example);
	}

	@Transactional(readOnly = true)
	public VipActiveLog getByKey(Long id) {

		return vipActiveLogDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return vipActiveLogDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(VipActiveLogExample example) {
		return vipActiveLogDAO.deleteByExample(example);
	}

	public Integer updateByObject(VipActiveLog record) {
		return vipActiveLogDAO.updateByPrimaryKeyWithBLOBs(record);
	}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage(VipActiveLogExample example) {
		Pagination p = new Pagination(example.getPageNo(), example.getPageSize(),
				vipActiveLogDAO.countByExample(example));
		p.setList(vipActiveLogDAO.selectByExampleWithPage(example));
		return p; 
	}

	@Transactional(readOnly = true)
	public List<VipActiveLog> getObjectList(VipActiveLogExample example) {
		return vipActiveLogDAO.selectByExampleWithBLOBs(example);
	}

	@Transactional(readOnly = true)
	public Integer getObjectListCount(VipActiveLogExample example) {
		return vipActiveLogDAO.countByExample(example);
	}

}
