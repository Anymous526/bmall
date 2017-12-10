package com.amall.core.service.group;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.dao.GroupGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GroupGoodsServiceImpl implements IGroupGoodsService {

	@Resource 
	private GroupGoodsMapper groupGoodsDao;

	public Long add(GroupGoods example) {
		return groupGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GroupGoods getByKey(Long id) {
		return groupGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return groupGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GroupGoodsExample example) {
		return groupGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(GroupGoods record) {
		return groupGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GroupGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),groupGoodsDao.countByExample(example));
		p.setList(groupGoodsDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GroupGoods> getObjectList(GroupGoodsExample example) {
		return groupGoodsDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GroupGoodsExample example) {
		return groupGoodsDao.countByExample(example);
	}


}
