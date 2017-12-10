package com.amall.core.service.spare;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SpareGoodsExample;
import com.amall.core.bean.SpareGoodsWithBLOBs;
import com.amall.core.dao.SpareGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SpareGoodsServiceImpl implements ISpareGoodsService {

	@Resource 
	private SpareGoodsMapper  spareGoodsDao;

	public Long add(SpareGoodsWithBLOBs example) {
		return spareGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SpareGoodsWithBLOBs getByKey(Long id) {
		return spareGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return spareGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SpareGoodsExample example) {
		return spareGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(SpareGoodsWithBLOBs record) {
		return spareGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SpareGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),spareGoodsDao.countByExample(example));
		p.setList(spareGoodsDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SpareGoodsWithBLOBs> getObjectList(SpareGoodsExample example) {
		return spareGoodsDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SpareGoodsExample example) {
		return spareGoodsDao.countByExample(example);
	}


}
