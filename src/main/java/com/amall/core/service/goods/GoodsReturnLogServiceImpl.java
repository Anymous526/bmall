package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsReturnLog;
import com.amall.core.bean.GoodsReturnLogExample;
import com.amall.core.dao.GoodsReturnLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsReturnLogServiceImpl implements IGoodsReturnLogService {

	@Resource
	private GoodsReturnLogMapper  goodsReturnLogDao;

	public Long add(GoodsReturnLog example) {
		
		return goodsReturnLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsReturnLog getByKey(Long id) {
		
		return goodsReturnLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return goodsReturnLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsReturnLogExample example) {
		
		return goodsReturnLogDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsReturnLog record) {
		
		return goodsReturnLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsReturnLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsReturnLogDao.countByExample(example));
		p.setList(goodsReturnLogDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsReturnLog> getObjectList(GoodsReturnLogExample example) {
		
		return goodsReturnLogDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsReturnLogExample example) {
		
		return goodsReturnLogDao.countByExample(example);
	}


}
