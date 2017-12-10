package com.amall.core.action.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.OrderExportEntity;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ExcelExport;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class OrderManageAction
{

	// 导出查询最大条数
	// private final static Integer MAX_EXPORT_SIZE = 50000;
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAlipayOrderService alipayOrderSerivce;

	@SecurityMapping(title = "订单设置" , value = "/admin/set_order_confirm.htm*" , rtype = "admin" , rname = "订单设置" ,
						rcode = "set_order_confirm" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_order_confirm.htm" })
	public ModelAndView set_order_confirm (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/set_order_confirm.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "订单设置保存" , value = "/admin/set_order_confirm_save.htm*" , rtype = "admin" ,
						rname = "订单设置" , rcode = "set_order_confirm" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_order_confirm_save.htm" })
	public ModelAndView set_order_confirm_save (HttpServletRequest request , HttpServletResponse response , String id , String autoOrderConfirm , String autoOrderNotice , String autoOrderReturn , String autoOrderEvaluate)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs config = null;
			if (id.equals (""))
			{
				config = (SysConfigWithBLOBs) wf.toPo (request , SysConfig.class);
				config.setAddtime (new Date ());
			}
			else
			{
				config = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			config.setAutoOrderConfirm (CommUtil.null2Int (autoOrderConfirm));
			config.setAutoOrderNotice (CommUtil.null2Int (autoOrderNotice));
			config.setAutoOrderReturn (CommUtil.null2Int (autoOrderReturn));
			config.setAutoOrderEvaluate (CommUtil.null2Int (autoOrderEvaluate));
			if (id.equals (""))
				this.configService.add (config);
			else
			{
				this.configService.updateByObject (config);
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "订单设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/set_order_confirm.htm");
			return mv;
		}

	@SecurityMapping(title = "订单列表" , value = "/admin/order_list.htm*" , rtype = "admin" , rname = "订单管理" ,
						rcode = "order_admin" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/order_list.htm" })
	public ModelAndView order_list (HttpServletRequest request , HttpServletResponse response , String order_status , String type , String type_data , String payment , String beginTime , String endTime , String begin_price , String end_price , String currentPage)
		{
			System.out.println ("type=" + type + "page=" + currentPage);
			ModelAndView mv = new JModelAndView ("admin/order_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			OrderFormExample formExample = new OrderFormExample ();
			formExample.clear ();
			formExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			formExample.setOrderByClause ("addTime desc");
			OrderFormExample.Criteria formCriteria = formExample.createCriteria ();
			if (!CommUtil.null2String (order_status).equals (""))
			{
				formCriteria.andOrderStatusEqualTo (Integer.valueOf (CommUtil.null2Int (order_status)));
			}
			if (!CommUtil.null2String (type_data).equals (""))
			{
				if (type.equals ("store"))
				{
					StoreExample storeExample = new StoreExample ();
					storeExample.clear ();
					storeExample.createCriteria ().andStoreNameEqualTo (type_data);
					if (storeService.getObjectList (storeExample) != null && storeService.getObjectList (storeExample).size () != 0)
					{
						StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
						formCriteria.andStoreIdEqualTo (store.getId ());
					}
					else
					{
						formCriteria.andStoreIdIsNull ();
					}
				}
				if (type.equals ("buyer"))
				{
					UserExample userExample = new UserExample ();
					userExample.clear ();
					userExample.createCriteria ().andUsernameEqualTo (type_data);
					if (userService.getObjectList (userExample) != null && userService.getObjectList (userExample).size () != 0)
					{
						User user = userService.getObjectList (userExample).get (0);
						formCriteria.andUserIdEqualTo (user.getId ());
					}
					else
					{
						formCriteria.andUserIdIsNull ();
					}
				}
				if (type.equals ("order"))
				{
					formCriteria.andOrderIdEqualTo (type_data);
				}
			}
			if (!CommUtil.null2String (payment).equals (""))
			{
				PaymentExample paymentExample = new PaymentExample ();
				paymentExample.clear ();
				paymentExample.createCriteria ().andMarkEqualTo (payment);
				if (paymentService.getObjectList (paymentExample) != null && paymentService.getObjectList (paymentExample).size () != 0)
				{
					PaymentWithBLOBs pay = paymentService.getObjectList (paymentExample).get (0);
					formCriteria.andPaymentIdEqualTo (pay.getId ());
				}
				else
				{
					formCriteria.andPaymentIdIsNull ();
				}
			}
			if (!CommUtil.null2String (beginTime).equals (""))
			{
				/*
				 * ofqo.addQuery("obj.addTime",
				 * new SysMap("beginTime", CommUtil.formatDate(beginTime)),
				 * ">=");
				 * }
				 * if (!CommUtil.null2String(endTime).equals("")) {
				 * ofqo.addQuery("obj.addTime",
				 * new SysMap("endTime", CommUtil.formatDate(endTime)), "<=");
				 */
				formCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
			}
			if (!CommUtil.null2String (endTime).equals (""))
			{
				formCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
			}
			if (!CommUtil.null2String (begin_price).equals (""))
			{
				formCriteria.andTotalpriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (begin_price)));
			}
			if (!CommUtil.null2String (end_price).equals (""))
			{
				formCriteria.andTotalpriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (end_price)));
			}
			Pagination pList = orderFormService.getObjectListWithPage (formExample);
		/*	List <OrderFormWithBLOBs> obj = (List <OrderFormWithBLOBs>) pList.getList ();	//错误写法
			if (obj != null && obj.size () > 0)
			{
				for (OrderFormWithBLOBs orderForm : obj)
				{
					if (orderForm.getOrderType () == Globals.ORDER_TYPE_O2O && !StringUtils.isEmpty (orderForm.getAlipayorderId ()))
					{
						AlipayOrder alipayOrder = this.alipayOrderSerivce.getByKey (orderForm.getAlipayorderId ());
						mv.addObject ("TotalFee" , alipayOrder.getTotalFee ());
					}
				}
			}*/
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("order_status" , order_status);
			mv.addObject ("type" , type);
			mv.addObject ("type_data" , type_data);
			mv.addObject ("payment" , payment);
			mv.addObject ("beginTime" , beginTime);
			mv.addObject ("endTime" , endTime);
			mv.addObject ("begin_price" , begin_price);
			mv.addObject ("end_price" , end_price);
			return mv;
		}

	@SecurityMapping(title = "订单详情" , value = "/admin/order_view.htm*" , rtype = "admin" , rname = "订单管理" ,
						rcode = "order_admin" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/order_view.htm" })
	public ModelAndView order_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			OrderForm obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
			orderFormItemExample.clear ();
			orderFormItemExample.createCriteria ().andOrderIdEqualTo (obj.getId ());
			List <OrderFormItem> pList = this.orderFormItemService.getObjectList (orderFormItemExample);
			/* 填充订单详情 */
			OrderFormItemExample formItemExample = new OrderFormItemExample ();
			formItemExample.clear ();
			formItemExample.createCriteria ().andOrderIdEqualTo (obj.getId ());
			List <OrderFormItem> items = this.orderFormItemService.getObjectList (formItemExample);
			obj.setItems (items);
			/* 获取快递信息 */
			List <KuaiDiResultItem> transInfo = kuaidiService.getKuaidiInfo (obj.getShipcode ());
			if (obj != null && !StringUtils.isEmpty (obj.getAlipayorderId ()))
			{
				AlipayOrder alipayOrder = this.alipayOrderSerivce.getByKey (obj.getAlipayorderId ());
				mv.addObject ("TotalFee" , alipayOrder.getTotalFee ());
			}
			mv.addObject ("pList" , pList);
			mv.addObject ("transInfo" , transInfo);
			mv.addObject ("obj" , obj);
			return mv;
		}

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
	@RequestMapping({ "admin/rechargeLogExport.htm" })
	public void RechargeLogExport (HttpServletRequest request , HttpServletResponse response , String order_status , String type , String type_data , String payment , String beginTime , String endTime , String begin_price , String end_price , String currentPage)
		{
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
				list.add("购买数量");
				list.add("豆数量");
				list.add("豆金额");
				list.add ("订单状态");
				list.add ("收货地址");
				list.add("收货人姓名");
				list.add("收货人联系方式");
				list.add ("详细地址");
				
				List <List <Object>> values = new ArrayList <List <Object>> ();
				List <Object> ls = null;
				List <OrderExportEntity> orderExportEntities = orderFormService.selectOrderExport ();
				for (int i = 0 ; i < orderExportEntities.size () ; i++)
				{
					ls = new ArrayList <Object> ();
					ls.add (orderExportEntities.get (i).getStroeName ());
					ls.add (orderExportEntities.get (i).getGoodsName ());
					ls.add (orderExportEntities.get (i).getOrderId ());
					ls.add (orderExportEntities.get (i).getTrueName ());
					ls.add (orderExportEntities.get (i).getAddTime ());
					ls.add (orderExportEntities.get (i).getTotalPrice ());
					ls.add(orderExportEntities.get(i).getCount());
					if(null != orderExportEntities.get(i).getBeanNum()){
						ls.add(orderExportEntities.get(i).getBeanNum());
					}else{
						ls.add(0);
					}
					if(null != orderExportEntities.get(i).getBeanAmout()){
						ls.add(orderExportEntities.get(i).getBeanAmout());
						System.out.println(orderExportEntities.get(i).getBeanAmout());
					}else{
						ls.add(0);
					}
					
					ls.add (orderExportEntities.get (i).getProvince () + " " + orderExportEntities.get (i).getCity () + "" + orderExportEntities.get (i).getArea ());
					ls.add (orderExportEntities.get (i).getInfo ());
					ls.add(orderExportEntities.get(i).getTrueNames());
					ls.add(orderExportEntities.get(i).getTelephones());
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
					values.add (ls);
				}
				System.out.println ("ddd");
				ExcelExport exporr = new ExcelExport ();
				exporr.export ("订单统计" , list , values , outputStream);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "admin/O2OrechargeLogExport.htm" })
	public void RechargeLogO2OExport (HttpServletRequest request , HttpServletResponse response , String order_status , String type , String type_data , String payment , String beginTime , String endTime , String begin_price , String end_price , String currentPage)
		{
			String excelName = "O2O订单导出";
			try
			{
				/* 输出流 */
				OutputStream stream = response.getOutputStream ();
				responseSetting (response , excelName);
				List <String> list = new ArrayList <String> ();
				list.add ("店铺名称");
				list.add ("商品名称");
				list.add ("订单号");
				list.add ("买家名称");
				list.add ("下单时间");
				list.add ("订单总额");
				list.add ("订单状态");
				/*
				 * list.add ("收货地址");
				 * list.add ("详细地址");
				 */
				List <List <Object>> values = new ArrayList <List <Object>> ();
				List <Object> ls = null;
				List <OrderExportEntity> orderExportEntities = orderFormService.selectO2OOrderExpot ();
				for (int i = 0 ; i < orderExportEntities.size () ; i++)
				{
					ls = new ArrayList <Object> ();
					ls.add (orderExportEntities.get (i).getStroeName ());
					ls.add (orderExportEntities.get (i).getGoodsName ());
					ls.add (orderExportEntities.get (i).getOrderId ());
					ls.add (orderExportEntities.get (i).getTrueName ());
					ls.add (orderExportEntities.get (i).getAddTime ());
					ls.add (orderExportEntities.get (i).getTotalPrice ());
					/*
					 * ls.add (orderExportEntities.get (i).getProvince () + " " +
					 * orderExportEntities.get (i).getCity () + "" + orderExportEntities.get
					 * (i).getArea ());
					 * ls.add (orderExportEntities.get (i).getInfo ());
					 */
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
					else
					{
						ls.add ("该订单没毛病！");
						System.err.println (orderExportEntities.get (i).getStatus ());
					}
					values.add (ls);
				}
				System.out.println ("ddd");
				ExcelExport exporr = new ExcelExport ();
				exporr.export ("O2O订单统计" , list , values , stream);
			}
			catch (Exception e)
			{
				// TODO: handle exception
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
			response.setContentType ("application/vnd.ms-excel");
			response.setHeader ("Content-Disposition" , "attachment;filename=" + getExcelFileName (excelName) + "");
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
