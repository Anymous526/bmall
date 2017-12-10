package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.dao.OrderFormItemMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class OrderFormItemServiceImpl implements IOrderFormItemService {

	@Resource 
	private OrderFormItemMapper  orderFormItemDao;

	public Integer add(OrderFormItem example) {
		return orderFormItemDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public OrderFormItem getByKey(Long id) {
		return orderFormItemDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return orderFormItemDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(OrderFormItemExample example) {
		return orderFormItemDao.deleteByExample(example);
	}

	public Integer updateByObject(OrderFormItem record) {
		return orderFormItemDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(OrderFormItemExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),orderFormItemDao.countByExample(example));
		p.setList(orderFormItemDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<OrderFormItem> getObjectList(OrderFormItemExample example) {
		return orderFormItemDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(OrderFormItemExample example) {
		return orderFormItemDao.countByExample(example);
	}

	public OrderFormItem getObjectByOrderIdAndGoodsId(Long orderId,Long goodsId){
		OrderFormItemExample ofie = new OrderFormItemExample();
		ofie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderFormItem> items = this.orderFormItemDao.selectByExampleWithBLOBs(ofie);
		if(items.size()>0){
			return items.get(0);
		}
		return null;
	}

}
