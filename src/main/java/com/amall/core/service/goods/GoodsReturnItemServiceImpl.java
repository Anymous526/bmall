package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsReturnItem;
import com.amall.core.bean.GoodsReturnItemExample;
import com.amall.core.dao.GoodsReturnItemMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsReturnItemServiceImpl implements IGoodsReturnItemService {

	@Resource 
	private GoodsReturnItemMapper  goodsReturnItemDao;

	public Long add(GoodsReturnItem example) {
		
		return goodsReturnItemDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsReturnItem getByKey(Long id) {
		
		return goodsReturnItemDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsReturnItemDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsReturnItemExample example) {
		
		return goodsReturnItemDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsReturnItem record) {
		
		return goodsReturnItemDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsReturnItemExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsReturnItemDao.countByExample(example));
		p.setList(goodsReturnItemDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsReturnItem> getObjectList(GoodsReturnItemExample example) {
		
		return goodsReturnItemDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsReturnItemExample example) {
		
		return goodsReturnItemDao.countByExample(example);
	}


}
