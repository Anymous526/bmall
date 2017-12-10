package com.amall.core.service.goods;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.dao.GoodsBrandMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsBrandServiceImpl implements IGoodsBrandService {

	@Resource 
	private GoodsBrandMapper  goodsBrandDao;

	public Long add(GoodsBrand example) {
		return goodsBrandDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsBrand getByKey(Long id) {
		return goodsBrandDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsBrandDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsBrandExample example) {
		return goodsBrandDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsBrand record) {
		return goodsBrandDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsBrandExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsBrandDao.countByExample(example));
		p.setList(goodsBrandDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsBrand> getObjectList(GoodsBrandExample example) {
		return goodsBrandDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsBrandExample example) {
		return goodsBrandDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<GoodsBrand> selectGoodsBrand(Map map) {
		return goodsBrandDao.selectGoodsBrand(map);
	}
	@Override
	public GoodsBrand getGoodsById(Long id) {
		return goodsBrandDao.getGoodsById(id);
	}

	
	
	

}
