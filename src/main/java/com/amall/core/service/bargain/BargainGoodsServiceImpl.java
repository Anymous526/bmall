package com.amall.core.service.bargain;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.dao.BargainGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class BargainGoodsServiceImpl implements IBargainGoodsService {

	@Resource
	private BargainGoodsMapper bargainGoodsDao;

	public Long add(BargainGoods example) {
		return bargainGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public BargainGoods getByKey(Long id) {
		return bargainGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return bargainGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(BargainGoodsExample example) {
		return bargainGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(BargainGoods record) {
		return bargainGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(BargainGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),bargainGoodsDao.countByExample(example));
		p.setList(bargainGoodsDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<BargainGoods> getObjectList(
			BargainGoodsExample example) {
		return bargainGoodsDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(BargainGoodsExample example) {
		return bargainGoodsDao.countByExample(example);
	}

	
	
}
