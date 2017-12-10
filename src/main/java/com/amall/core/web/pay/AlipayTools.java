package com.amall.core.web.pay;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.orderForm.IOrderFormService;



@Component
public class AlipayTools {//根据多个订单号，支付时生成一个新的订单的工具

	@Autowired
	private IOrderFormService orderFormService;
	
	@Autowired
	private IAlipayOrderService alipayOrderService;
	
	public Long getApilayOrderId(List<String> orderList)
	{
		OrderFormExample orderFormExample=new OrderFormExample();
		orderFormExample.clear();
		OrderFormExample.Criteria orderFormCriteria=orderFormExample.createCriteria();
		orderFormCriteria.andOrderIdIn(orderList);
		List<OrderFormWithBLOBs> orderForms=this.orderFormService.getObjectList(orderFormExample);
		BigDecimal totalFee=new BigDecimal(0.0);
		String orderIds="";
		if(orderForms!=null&&orderForms.size()!=0)
		{
			for(OrderFormWithBLOBs orderForm:orderForms)
			{
				if(orderForm.getOrderStatus()==10)//订单状态为10才能完成支付
				{
					totalFee=totalFee.add(orderForm.getTotalprice());
					orderIds=orderIds+orderForm.getOrderId().substring(0, 4);
				}
				
			}
		}
		AlipayOrder alipayorder=new AlipayOrder();
		alipayorder.setTotalFee(totalFee);
		alipayorder.setOrderId(orderIds);
		this.alipayOrderService.add(alipayorder);
		if(orderForms!=null&&orderForms.size()!=0)
		{
			for(OrderFormWithBLOBs orderForm:orderForms)
			{
				if(orderForm.getOrderStatus()==10)//必须是订单状态为10的订单
				{
					orderForm.setAlipayorderId(alipayorder.getId());
					this.orderFormService.updateByObject(orderForm);
				}
			}
		}
		return alipayorder.getId();
	}
	
	
	
	
}
