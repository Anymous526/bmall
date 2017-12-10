package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsReturn;
import com.amall.core.bean.GoodsReturnExample;
import com.amall.core.dao.GoodsReturnMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsReturnServiceImpl implements IGoodsReturnService {

	@Resource 
	private GoodsReturnMapper  goodsReturnDao;

	public Long add(GoodsReturn example) {
		return goodsReturnDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsReturn getByKey(Long id) {
		return goodsReturnDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsReturnDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsReturnExample example) {
		
		return goodsReturnDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsReturn record) {
		
		return goodsReturnDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsReturnExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsReturnDao.countByExample(example));
		p.setList(goodsReturnDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsReturn> getObjectList(GoodsReturnExample example) {
		return goodsReturnDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsReturnExample example) {
		return goodsReturnDao.countByExample(example);
	}


}
