package com.amall.core.action.buyer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jpush.api.utils.StringUtils;

import com.amall.common.constant.Globals;
import com.amall.core.bean.OrderExportEntity;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ExcelExport;

@Controller
public class StoreOrderAction {
	
	@Autowired
	private IOrderFormService orderFormService;
	
	/***
	 * 订单导出
	 * 
	 * @param request
	 * @param response
	 * @param order_status
	 * @param type
	 * @param type_data
	 * @param payment
	 * @param beginTime
	 * @param endTime
	 * @param begin_price
	 * @param end_price
	 * @param currentPage
	 */
	@RequestMapping({ "StorerechargeLogExport.htm" })
	public void RechargeLogExport (HttpServletRequest request , HttpServletResponse response , String order_status , String type , String type_data , String payment , String beginTime , String endTime , String begin_price , String end_price , String currentPage)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			String excelName = "订单";
			try
			{
				OutputStream outputStream = response.getOutputStream ();		// 输出流
				responseSetting (response , excelName);
				List <String> list = new ArrayList <String> ();
				list.add ("店铺名称");
				list.add ("商品名称");
				list.add ("订单号");
				list.add ("买家名称");
				list.add ("下单时间");
				list.add ("订单总额");
				list.add("使用的感恩豆数量");
				list.add("感恩豆金额");
				list.add ("订单状态");
				list.add ("收货地址");
				list.add ("详细地址");
				List <List <Object>> values = new ArrayList <List <Object>> ();
				List <Object> ls = null;
				System.out.println("店铺id="+user.getStoreId());
				List <OrderExportEntity> orderExportEntities = orderFormService.selectStoreOrderExpot (user.getStoreId());
				for (int i = 0 ; i < orderExportEntities.size () ; i++)
				{
					ls = new ArrayList <Object> ();
					ls.add (orderExportEntities.get (i).getStroeName ());
					ls.add (orderExportEntities.get (i).getGoodsName ());
					ls.add (orderExportEntities.get (i).getOrderId ());
					ls.add (orderExportEntities.get (i).getTrueName ());
					ls.add (orderExportEntities.get (i).getAddTime ());
					ls.add (orderExportEntities.get (i).getTotalPrice ());
					if(StringUtils.isNotEmpty(orderExportEntities.get(i).getBeanNum())){
						ls.add(orderExportEntities.get(i).getBeanNum());
					}else{
						ls.add("未使用");
					}
					
					if(StringUtils.isNotEmpty(orderExportEntities.get(i).getBeanAmout())){
						ls.add(orderExportEntities.get(i).getBeanAmout());
					}else{
						ls.add("未使用");
					}
					
					
					if (orderExportEntities.get (i).getStatus () == Globals.WAIT_PAYMENT_ORDER)
					{
						ls.add ("待支付");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.HAVE_PAYMENT)
					{
						ls.add ("已付款");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.HAVE_SEND_OUT_GOOD)
					{
						ls.add ("已发货");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.HAVE_RECEIVED_GOOD)
					{
						ls.add ("已收货");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.FINISH_AND_NOT_EVALUATED)
					{
						ls.add ("已完成");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.CANCELLED_ORDER)
					{
						ls.add ("已取消");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.HAVE_REFUND)
					{
						ls.add ("已退款");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.COMPLETED_AND_EVALUATED)
					{
						ls.add ("已评价");
					}
					else if (orderExportEntities.get (i).getStatus () == Globals.SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD)
					{
						ls.add ("货到付款待发货");
					}
					else
					{
						ls.add ("该订单没毛病！");
						System.err.println (orderExportEntities.get (i).getStatus ());
					}
					ls.add (orderExportEntities.get (i).getProvince () + " " + orderExportEntities.get (i).getCity () + "" + orderExportEntities.get (i).getArea ());
					
					ls.add (orderExportEntities.get (i).getInfo ());
					values.add (ls);
				}
				ExcelExport exporr = new ExcelExport ();
				exporr.export ("订单统计" , list , values , outputStream);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
	
	/**
	 * 设置response 导出属性值
	 * 
	 * @param response
	 * @param excelName
	 *            文件标题前缀
	 */
	private void responseSetting (HttpServletResponse response , String excelName)
		{
			response.setContentType ("application/vnd.ms-excel");		//设置导出属性值
			response.setHeader ("Content-Disposition" , "attachment;filename=" + getExcelFileName (excelName) + ""); //设置头部标题，以及提示是否下载或者直接打开
		}
	
	/**
	 * 获取文件名称
	 * 
	 * @param title
	 *            文件前缀
	 * @return
	 */
	private static String getExcelFileName (String title)
		{
			StringBuffer sb = new StringBuffer ();
			sb.append (title);
			sb.append (CommUtil.formatDate (new Date () , "yyyyMMddHHmmss"));
			sb.append (".xls");
			return CommUtil.encode (sb.toString ());
		}

}
