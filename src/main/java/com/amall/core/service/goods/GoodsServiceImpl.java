package com.amall.core.service.goods;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecial;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.dao.GoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsServiceImpl implements IGoodsService {

	@Resource
	private GoodsMapper  goodsDao;

	public Long add(GoodsWithBLOBs example) {
		return goodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsWithBLOBs getByKey(Long id) {
		return goodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsExample example) {
		return goodsDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsWithBLOBs record) {
		return goodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsDao.countByExample(example));
		p.setList(goodsDao.selectByExampleWithBLOBsAndPage(example));
/*		int count = goodsDao.countByExample(example);
		System.out.println("count="+count);
		System.err.println(goodsDao.selectByExampleWithBLOBsAndPage(example));*/
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsWithBLOBs> getObjectList(GoodsExample example) {
		return goodsDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsExample example) {
		return goodsDao.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<GoodsWithBLOBs> selectGoodsCombin(Map map) {
		return goodsDao.selectGoodsCombin(map);
	}
	@Transactional(readOnly=true)
	public List<GoodsWithBLOBs> selectByExampleWithBLOBsAndPage(
			GoodsExample example) {
		return goodsDao.selectByExampleWithBLOBsAndPage(example);
	}
	
	@Transactional(readOnly=true)
	public List<GoodsSpecial> selectGoodsSpecial(Long id) {
		
		return goodsDao.selectGoodsSpecial(id);
	}
	@Transactional(readOnly=true)
	public List<Goods> selectByExample(GoodsExample example) {
		
		return goodsDao.selectByExample(example);
	}



}
