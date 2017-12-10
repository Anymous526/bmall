package com.amall.core.action.time;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.Globals;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Revenue;
import com.amall.core.service.IRevenservice;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormService;

@Component("automonthlyRoseOrderDetial_job")
public class AutoMonthOrderDetailsTime
{

	Logger log = Logger.getLogger (AutoMonthOrderDetailsTime.class);

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IRevenservice revenservice;

	public void execute ( )
		{
			orderIncomeDetails ();
		}

	public void orderIncomeDetails ( )
		{
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			Calendar c = Calendar.getInstance ();
			c.add (Calendar.MONTH , 0);
			c.set (Calendar.DAY_OF_MONTH , 1);// 设置为1号,当前日期既为本月第一天
			String first = format.format (c.getTime ());
			System.out.println ("===============first:" + first);
			Date dates = null;
			try
			{
				dates = format.parse (first);
				System.out.println ("转换=" + dates);
			}
			catch (ParseException r)
			{
				r.printStackTrace ();
			}
			// 获取Calendar
			Calendar calendar = Calendar.getInstance ();
			calendar.set (Calendar.DATE , calendar.getActualMaximum (Calendar.DATE));
			// 打印
			SimpleDateFormat formats = new SimpleDateFormat ("yyyy-MM-dd");
			System.out.println ("这个月的最后一天" + formats.format (calendar.getTime ()));
			Date datee = null;
			try
			{
				String sd = formats.format (calendar.getTime ());
				datee = formats.parse (sd);
				System.out.println ("转换后=" + datee);
			}
			catch (ParseException t)
			{
				t.printStackTrace ();
			}
			List <Integer> statusIds = new ArrayList <Integer> ();
			/* statusIds.add(20); */
			statusIds.add (50);
			statusIds.add (40);
			OrderFormExample example = new OrderFormExample ();
			example.createCriteria ().andOrderStatusIn (statusIds).andAddtimeBetween (dates , datee);
			List <OrderFormWithBLOBs> list = orderFormService.getObjectList (example);
			for (int i = 0 ; i < list.size () ; i++)
			{
				if (list.get (i).getStoreId () != null)
				{
					System.out.println ("循环次数=" + i);
					statisticaData (list.get (i).getStoreId () , list.get (i).getId () , dates , datee);
				}
			}
		}

	public void statisticaData (Long stroeId , Long orderId , Date dates , Date datee)
		{
			Long storeIds = stroeId;
//			Long orderIds = orderId;
			OrderFormItemExample example = new OrderFormItemExample ();
			example.createCriteria ().andOrderIdEqualTo (orderId).andAddTimeBetween (dates , datee);
			List <OrderFormItem> orderFormItems = orderFormItemService.getObjectList (example);
			for (int i = 0 ; i < orderFormItems.size () ; i++)
			{
				System.out.println ("下面循环=" + i);
				Revenue revenue = new Revenue ();
				revenue.setAccountTime (new Date ());
				revenue.setGoodsName (orderFormItems.get (i).getGoodsName ());
				revenue.setStoreId (storeIds);
				revenue.setOrderId (orderFormItems.get (i).getOrderId ());
				revenue.setStoreIncome (orderFormItems.get (i).getGoodsPrice ());
				if (orderFormItems.get (i).getGoodsRate () == null)
				{
					revenue.setRate (new BigDecimal (0.00));
				}
				else
				{
					revenue.setRate (orderFormItems.get (i).getGoodsRate ());
				}
				if (orderFormItems.get (i).getGoodsRate () == null)
				{
					revenue.setLeePrice (orderFormItems.get (i).getGoodsPrice ().multiply (Globals.Store_LEE_PRICE));
				}
				else
				{
					revenue.setLeePrice (orderFormItems.get (i).getGoodsPrice ().multiply (orderFormItems.get (i).getGoodsRate ()).multiply (Globals.Store_LEE_PRICE));
				}
				revenservice.add (revenue);
			}
		}
}
