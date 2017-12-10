package com.amall.core.service.delivery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.DeliveryGoods;
import com.amall.core.bean.DeliveryGoodsExample;
import com.amall.core.dao.DeliveryGoodsMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DeliveryGoodsServiceImpl implements IDeliveryGoodsService {

	@Resource
	private DeliveryGoodsMapper deliveryGoodsDao;

	public Long add(DeliveryGoods example) {
		return deliveryGoodsDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public DeliveryGoods getByKey(Long id) {
		return deliveryGoodsDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return deliveryGoodsDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DeliveryGoodsExample example) {
		return deliveryGoodsDao.deleteByExample(example);
	}

	public Integer updateByObject(DeliveryGoods record) {
		return deliveryGoodsDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DeliveryGoodsExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),deliveryGoodsDao.countByExample(example));
		p.setList(deliveryGoodsDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<DeliveryGoods> getObjectList(DeliveryGoodsExample example) {
		return deliveryGoodsDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DeliveryGoodsExample example) {
		return deliveryGoodsDao.countByExample(example);
	}


	
}
