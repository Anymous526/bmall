package com.amall.core.service.orderForm;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.OrderExportEntity;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.dao.OrderFormMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class OrderFormServiceImpl implements IOrderFormService
{

	@Resource
	private OrderFormMapper orderFormDao;

	public Long add (OrderFormWithBLOBs example)
		{
			return orderFormDao.insertSelective (example);
		}

	@Transactional(readOnly = true)
	public OrderFormWithBLOBs getByKey (Long id)
		{
			return orderFormDao.selectByPrimaryKey (id);
		}

	public Integer deleteByKey (Long id)
		{
			return orderFormDao.deleteByPrimaryKey (id);
		}

	public Integer deleteByExample (OrderFormExample example)
		{
			return orderFormDao.deleteByExample (example);
		}

	public Integer updateByObject (OrderFormWithBLOBs record)
		{
			return orderFormDao.updateByPrimaryKeySelective (record);
		}

	@Transactional(readOnly = true)
	public Pagination getObjectListWithPage (OrderFormExample example)
		{
			Pagination p = new Pagination (example.getPageNo () , example.getPageSize () , orderFormDao.countByExample (example));
			p.setList (orderFormDao.selectByExampleWithBLOBsAndPage (example));
			return p;
		}

	@Transactional(readOnly = true)
	public List <OrderFormWithBLOBs> getObjectList (OrderFormExample example)
		{
			return orderFormDao.selectByExampleWithBLOBs (example);
		}

	@Transactional(readOnly = true)
	public Integer getObjectListCount (OrderFormExample example)
		{
			return orderFormDao.countByExample (example);
		}

	@Transactional(readOnly = true)
	public List <OrderFormWithBLOBs> getUserAndPrice (OrderFormExample example)
		{
			return orderFormDao.getUserAndPrice (example);
		}

	public List <OrderFormWithBLOBs> selectOfByGoodsNameLike (String condition)
		{
			return orderFormDao.selectOfByGoodsNameLike (condition);
		}

	@Override
	public List <OrderForm> selectOrderForms (com.amall.core.bean.OrderFormExample example)
		{
			return orderFormDao.selectByExample (example);
		}

	@Override
	public List <OrderExportEntity> selectOrderExport ( )
		{
			return orderFormDao.selectOrderExport ();
		}

	@Override
	public List<OrderExportEntity> selectO2OOrderExpot() {
		
		return orderFormDao.selectOtowOOrderExport();
	}

	@Override
	public List<OrderExportEntity> selectStoreOrderExpot(long storeId) {
		
		return orderFormDao.selectStoreOrderExport(storeId);
	}
}
