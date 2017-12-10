package com.amall.core.service.complaint;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ComplaintGoods;
import com.amall.core.bean.ComplaintGoodsExample;
import com.amall.core.dao.ComplaintGoodsMapper;
import com.amall.core.web.page.Pagination;


@Service
@Transactional
public class ComplaintGoodServiceImpl implements IComplaintGoodService {

	@Resource
	private ComplaintGoodsMapper complaintGoodsDao;
	
	public Long add(ComplaintGoods example) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.insertSelective(example);
	}
    @Transactional(readOnly=true)
	public ComplaintGoods getByKey(Long id) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ComplaintGoodsExample example) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(ComplaintGoods record) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ComplaintGoodsExample example) {
		// TODO Auto-generated method stub
		Pagination p=new Pagination(example.getPageNo(),example.getPageSize(),complaintGoodsDao.countByExample(example));
		p.setList(complaintGoodsDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ComplaintGoods> getObjectList(ComplaintGoodsExample example) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ComplaintGoodsExample example) {
		// TODO Auto-generated method stub
		return complaintGoodsDao.countByExample(example);
	}

}
