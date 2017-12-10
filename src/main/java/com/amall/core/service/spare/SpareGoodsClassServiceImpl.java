package com.amall.core.service.spare;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SpareGoodsClass;
import com.amall.core.bean.SpareGoodsClassExample;
import com.amall.core.dao.SpareGoodsClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SpareGoodsClassServiceImpl implements ISpareGoodsClassService {

	@Resource 
	private SpareGoodsClassMapper spareGoodsClassDao;

	public Long add(SpareGoodsClass example) {
		
		return spareGoodsClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SpareGoodsClass getByKey(Long id) {
		
		return spareGoodsClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return spareGoodsClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SpareGoodsClassExample example) {
		
		return spareGoodsClassDao.deleteByExample(example);
	}

	public Integer updateByObject(SpareGoodsClass record) {
		
		return spareGoodsClassDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SpareGoodsClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),spareGoodsClassDao.countByExample(example));
		p.setList(spareGoodsClassDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SpareGoodsClass> getObjectList(SpareGoodsClassExample example) {
		
		return spareGoodsClassDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SpareGoodsClassExample example) {
		
		return spareGoodsClassDao.countByExample(example);
	}


}
