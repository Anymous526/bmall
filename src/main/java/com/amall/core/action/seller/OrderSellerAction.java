package com.amall.core.action.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormExample.Criteria;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.RefundItem;
import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.bean.RefundGoods;
import com.amall.core.bean.RefundGoodsExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.ICashDepositService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IExpressCompanyService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.IRefundGoodsService;
import com.amall.core.service.IRefundItemSerivce;
import com.amall.core.service.IRefundService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsReturnItemService;
import com.amall.core.service.goods.IGoodsReturnLogService;
import com.amall.core.service.goods.IGoodsReturnService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.express.kuaidi100.JsonRequest;
import com.amall.core.web.express.kuaidi100.JsonResponse;
import com.amall.core.web.express.kuaidi100.Kuaidi100HttpRequest;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.PaymentTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: OrderSellerAction
 * </p>
 * <p>
 * Description: 卖家相关订单处理， 如订单查询、收发货、物流、评价等
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月18日上午9:48:11
 * @version 1.0
 */
@Controller
public class OrderSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private ICashDepositService cashDepositService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IRefundService RefundService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsReturnService goodsReturnService;

	@Autowired
	private IGoodsReturnItemService goodsReturnItemService;

	@Autowired
	private IGoodsReturnLogService goodsReturnLogService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRefundItemSerivce refundItemService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IExpressCompanyService expressCompayService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private PaymentTools paymentTools;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private IRefundGoodsService refundGoodsService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IStoreService storeService;

	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "卖家订单列表" , value = "/seller/order.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order.htm" })
	public ModelAndView order (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderId , String buyerName , Integer order_status , String beginTime , String endTime , boolean refund)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			user = userService.getByKey (user.getId ());
			Long storeId = null;
			if (user.getStore () != null)
			{
				storeId = user.getStore ().getId ();
			}
			SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			// 订单分页查询
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			orderFormExample.setPageSize (5);
			orderFormExample.setOrderByClause ("addTime desc");
			OrderFormExample.Criteria ofCriteria = orderFormExample.createCriteria ();
			ofCriteria.andStoreIdEqualTo (storeId);
			if (beginTime != null && !beginTime.equals (""))
			{
				try
				{
					Date d1 = sf.parse (beginTime);
					ofCriteria.andAddtimeGreaterThanOrEqualTo (d1);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
			}
			if (endTime != null && !endTime.equals (""))
			{
				try
				{
					Date d2 = sf.parse (endTime);
					ofCriteria.andAddtimeLessThanOrEqualTo (d2);
				}
				catch (ParseException e)
				{
					e.printStackTrace ();
				}
			}
			if (order_status != null && order_status != 1000)
			{
				ofCriteria.andOrderStatusEqualTo (order_status);
				mv.addObject ("orderStatus" , true);
			}
			if (orderId != null && !orderId.equals (""))
			{
				ofCriteria.andOrderIdLike ("%" + orderId + "%");
				mv.addObject ("order_id" , orderId);
			}
			if (buyerName != null && !buyerName.equals (""))
			{
				UserExample example = new UserExample ();
				example.createCriteria ().andUsernameEqualTo (buyerName.trim ());
				List <User> userList = this.userService.getObjectList (example);
				User buyer = null;
				if (userList != null && !userList.isEmpty ())
				{
					buyer = userList.get (0);
					ofCriteria.andUserIdEqualTo (buyer.getId ());
				}
				mv.addObject ("buyer_userName" , buyerName);
			}
			Pagination pList = this.orderFormService.getObjectListWithPage (orderFormExample);
			List <OrderFormWithBLOBs> listt = (List <OrderFormWithBLOBs>) pList.getList ();
			List <OrderFormWithBLOBs> list = new ArrayList <OrderFormWithBLOBs> ();
			if (refund == true)
			{
				for (OrderFormWithBLOBs order : listt)
				{
					if (order.getRefundId () != null && !order.getRefundId ().toString ().equals (""))
					{
						list.add (order);
					}
				}
			}
			else
			{
				list.addAll (listt);
			}
			List <String> strList = new ArrayList <String> ();
			// 取得订单中文提示信息
			strList = convertListOrderStatusToCN (list);
			Map <OrderFormWithBLOBs, String> orderMap = null;
			for (OrderFormWithBLOBs order : list)
			{
				OrderFormItemExample ofie = new OrderFormItemExample ();
				ofie.createCriteria ().andOrderIdEqualTo (order.getId ());
				List <OrderFormItem> items = this.orderFormItemService.getObjectList (ofie);
				order.setItems (items);
			}
			pList.setList (list);
			// 组合返回信息
			orderMap = combinationMap (list , strList);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("order_status" , order_status);
			return mv;
		}

	/**
	 * 组合两个长度相等的list数据
	 */
	public static Map <OrderFormWithBLOBs, String> combinationMap (List <OrderFormWithBLOBs> list , List <String> strList)
		{
			Map <OrderFormWithBLOBs, String> map = new HashMap <OrderFormWithBLOBs, String> ();
			if (list.size () == strList.size ())
			{
				for (int i = 0 ; i < list.size () ; i++)
				{
					map.put (list.get (i) , strList.get (i));
				}
			}
			return map;
		}

	/**
	 * 订单状态转换
	 * 
	 * @param list
	 * @return
	 */
	private List <String> convertListOrderStatusToCN (List <OrderFormWithBLOBs> list)
		{
			List <String> ret = new ArrayList <String> ();
			for (OrderFormWithBLOBs o : list)
			{
				ret.add (CommUtil.getOrderFormStatusName (o.getOrderStatus ()));
			}
			return ret;
		}

	@SecurityMapping(title = "订单详情" , value = "seller/order_view.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "seller/order_view.htm" })
	public ModelAndView order_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			User user = SecurityUserHolder.getCurrentUser ();
			// 操作日志
			OrderFormLogExample orderFormLogExample = new OrderFormLogExample ();
			orderFormLogExample.clear ();
			orderFormLogExample.createCriteria ().andOfIdEqualTo (Long.valueOf (obj.getOrderId ()));
			List <OrderFormLog> orderFormLogs = this.orderFormLogService.getObjectList (orderFormLogExample);
			mv.addObject ("ofls" , orderFormLogs);
			/* 填充订单详情 */
			OrderFormItemExample formItemExample = new OrderFormItemExample ();
			formItemExample.createCriteria ().andOrderIdEqualTo (obj.getId ());
			List <OrderFormItem> items = this.orderFormItemService.getObjectList (formItemExample);
			obj.setItems (items);
			if (obj.getStore ().getId ().equals (user.getStore ().getId ()))
			{
				mv.addObject ("obj" , obj);
				// 物流信息
				List <KuaiDiResultItem> transInfo = kuaidiService.getKuaidiInfo (obj.getShipcode ());
				mv.addObject ("transInfo" , transInfo);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您店铺中没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "卖家取消订单" , value = "/seller/order_cancel.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_cancel.htm" })
	public ModelAndView order_cancel (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order_cancel.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "卖家物流详情" , value = "/seller/ship_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/buyer_ship_view.htm" })
	@ResponseBody
	public String order_ship_view (HttpServletRequest request , HttpServletResponse response , String id , Long goodsId)
		{
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (id));
			Map <String, Object> map = new HashMap <> ();
			if (null != orderForm)
			{
				if (orderForm.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
				{
					map.put ("obj" , orderForm);
					String kuaidiNum = "";
					if (!goodsId.equals (0L))
					{
						RefundGoods rg = this.refundGoodsService.getObjectByOrderIdAndGooodsId (Long.valueOf (id) , goodsId);
						kuaidiNum = rg.getKuaidiNum (); // 退货物流单号
					}
					else
					{
						kuaidiNum = orderForm.getShipcode ();
					}
					List <KuaiDiResultItem> item = this.kuaidiService.getKuaidiInfo (kuaidiNum);
					map.put ("transInfo" , item);
					map.put ("status" , true);
				}
				else
				{
					map.put ("status" , false);
					map.put ("msg" , "您查询的物流不存在！");
				}
			}
			else
			{
				map.put ("status" , false);
				map.put ("msg" , "您查询的物流不存在！");
			}
			String mapJson = Json.toJson (map);
			return mapJson;
		}

	@SecurityMapping(title = "卖家取消订单保存" , value = "/seller/order_cancel_save.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_cancel_save.htm" })
	public String order_cancel_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String state_info , String other_state_info) throws Exception
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()) && obj.getOrderStatus () == Globals.WAIT_PAYMENT_ORDER)
			{
				obj.setOrderStatus (Globals.CANCELLED_ORDER);
				this.orderFormService.updateByObject (obj);
				OrderFormLog ofl = new OrderFormLog ();
				ofl.setAddtime (new Date ());
				ofl.setLogInfo ("取消订单");
				ofl.setLogUser (SecurityUserHolder.getCurrentUser ());
				ofl.setOf (obj);
				if (state_info.equals ("other"))
					ofl.setStateInfo (other_state_info);
				else
				{
					ofl.setStateInfo (state_info);
				}
				this.orderFormLogService.add (ofl);
				if (this.configService.getSysConfig ().getEmailenable ())
				{
					// send_email(request, obj, "email_tobuyer_order_cancel_notify");
				}
				if (this.configService.getSysConfig ().getSmsenbale ())
				{
					// send_sms(request, obj, obj.getUser().getMobile(),
					// "sms_tobuyer_order_cancel_notify");
				}
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家调整订单费用" , value = "/seller/order_fee.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_fee.htm" })
	public ModelAndView order_fee (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String orderItemId)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order_fee.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			OrderFormItem item = orderFormItemService.getByKey (Long.valueOf (orderItemId));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("orderItemId" , orderItemId);
				mv.addObject ("item" , item);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "卖家调整订单费用保存" , value = "/seller/order_fee_save.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_fee_save.htm" })
	public String order_fee_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String goodsAmount , String shipPrice , String totalPrice , String orderItemId) throws Exception
		{
			/* 调整价格 */
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				/* 更新支付价格 */
				// BigDecimal newtotalprice = (new BigDecimal(goodsAmount)).add(new
				// BigDecimal(shipPrice));
				BigDecimal newtotalprice;
				if (shipPrice != null && !"".equals (shipPrice))
				{
					newtotalprice = (new BigDecimal (goodsAmount)).add (new BigDecimal (shipPrice));
				}
				else
				{
					newtotalprice = BigDecimal.valueOf (CommUtil.null2Double (goodsAmount));
				}
				/* 修改订单条款 */
				OrderFormItemExample example = new OrderFormItemExample ();
				example.clear ();
				example.createCriteria ().andIdEqualTo (Long.valueOf (orderItemId));
				OrderFormItem orderFormItems = orderFormItemService.getObjectList (example).get (0);
				BigDecimal totalprice = newtotalprice;
				orderFormItems.setGoodsPrice (totalprice);
				orderFormItems.setUpdateorder (true);
				orderFormItemService.updateByObject (orderFormItems);
				List <OrderFormItem> orderItems = new ArrayList <OrderFormItem> ();
				example.clear ();
				example.createCriteria ().andOrderIdEqualTo (CommUtil.null2Long (id));
				orderItems = orderFormItemService.getObjectList (example);
				Double newtotalPrice = 0.00;
				for (OrderFormItem orderFormItem : orderItems)
				{
					System.out.println (orderFormItem.getGoodsPrice ().multiply (new BigDecimal (orderFormItem.getGoodsCount ())));
					newtotalPrice += (orderFormItem.getGoodsPrice ().multiply (new BigDecimal (orderFormItem.getGoodsCount ()))).doubleValue ();
					System.out.println (newtotalPrice);
				}
				System.out.println (newtotalPrice);
				/* 更新订单价格 */
				obj.setGoodsAmount (BigDecimal.valueOf (CommUtil.null2Double (newtotalPrice)));
				obj.setShipPrice (BigDecimal.valueOf (CommUtil.null2Double (shipPrice)));
				obj.setTotalprice (new BigDecimal (newtotalPrice));
				// 用垃圾字段作为改价的标志
				obj.setAutoConfirmEmail (true);
				this.orderFormService.updateByObject (obj);
				OrderFormLog ofl = new OrderFormLog ();
				ofl.setAddtime (new Date ());
				ofl.setLogInfo ("调整订单费用 ：" + new BigDecimal (newtotalPrice));
				ofl.setLogUser (SecurityUserHolder.getCurrentUser ());
				ofl.setOf (obj);
				this.orderFormLogService.add (ofl);
				if (this.configService.getSysConfig ().getEmailenable ())
				{
					send_email (request , obj , "email_tobuyer_order_update_fee_notify");
				}
				if (this.configService.getSysConfig ().getSmsenbale ())
				{
					send_sms (request , obj , obj.getUser ().getMobile () , "sms_tobuyer_order_fee_notify");
				}
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "线下付款确认" , value = "/seller/seller_order_outline.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_order_outline.htm" })
	public ModelAndView seller_order_outline (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order_outline.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "线下付款确认保存" , value = "/seller/seller_order_outline_save.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_order_outline_save.htm" })
	public String seller_order_outline_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String state_info) throws Exception
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				obj.setOrderStatus (20);
				this.orderFormService.updateByObject (obj);
				OrderFormLog ofl = new OrderFormLog ();
				ofl.setAddtime (new Date ());
				ofl.setLogInfo ("确认线下付款");
				ofl.setLogUser (SecurityUserHolder.getCurrentUser ());
				ofl.setOf (obj);
				ofl.setStateInfo (state_info);
				this.orderFormLogService.add (ofl);
				if (this.configService.getSysConfig ().getEmailenable ())
				{
					send_email (request , obj , "email_tobuyer_order_outline_pay_ok_notify");
				}
				if (this.configService.getSysConfig ().getSmsenbale ())
				{
					send_sms (request , obj , obj.getUser ().getMobile () , "sms_tobuyer_order_outline_pay_ok_notify");
				}
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家确认发货" , value = "/seller/order_shipping.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_shipping.htm" })
	public ModelAndView order_shipping (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String itemIds)
		{
			ModelAndView mv = null;
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj != null)
			{
				if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
				{
					if (StringUtils.isNotEmpty (itemIds))
					{
						/* 在买家申请退款等状态不允许发货，避免纠纷 */
						OrderFormItemExample example = new OrderFormItemExample ();
						example.clear ();
						example.createCriteria ().andOrderIdEqualTo (obj.getId ());
						List <OrderFormItem> formItems = this.orderFormItemService.getObjectList (example);
						for (OrderFormItem item : formItems)
						{
							if (item.getRefund () != null && (item.getRefund () == Globals.HAVE_RECEIVED_MOENY || item.getRefund () == Globals.WAIT_REFUND))
							{
								mv = new JModelAndView ("seller/seller_order_shipping.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
								mv.addObject ("op_title" , "买家申请退款或退款中不能发货");
								return mv;
							}
						}
						ExpressCompanyExample companyExample = new ExpressCompanyExample ();
						companyExample.clear ();
						companyExample.setOrderByClause ("company_sequence asc");
						companyExample.createCriteria ().andCompanyStatusEqualTo (0);
						List <ExpressCompany> expressCompanys = expressCompayService.getObjectList (companyExample);
						mv = new JModelAndView ("seller/seller_order_shipping.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("obj" , obj);
						mv.addObject ("currentPage" , currentPage);
						mv.addObject ("itemIds" , itemIds);
						mv.addObject ("expressCompanys" , expressCompanys);
						return mv;
					}
					else
					{
						mv = new JModelAndView ("seller/seller_order_shipping.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "请选择发货商品");
						return mv;
					}
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "该货物不是属于你的货物");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	/**
	 * @Title: sendOutGoods
	 * @Description: 卖家发货OK
	 * @param request
	 * @param response
	 * @param kuaidiCompany
	 *            快递公司代码
	 * @param kuaidiNum
	 *            运单号
	 * @param orderId
	 *            订单号
	 * @return ModelAndView
	 * @author guoxiangjun
	 * @date 2015年8月19日 下午7:25:20
	 */
	@RequestMapping({ "seller/send_out_goods.htm" })
	public ModelAndView sendOutGoods (HttpServletRequest request , HttpServletResponse response , Long kuaidiCompany , String kuaidiNum , Long orderId , String kuaidiPrice , String itemIds)
		{
			ModelAndView mv = new JModelAndView ("/seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs order = this.orderFormService.getByKey (orderId);
			if (order.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				ExpressCompany com = this.expressCompayService.getByKey (kuaidiCompany);
				String toCityInfo = order.getAddr ().getProvince () + order.getAddr ().getCity () + order.getAddr ().getArea () + order.getAddr ().getAreaInfo ();
				JsonRequest req = new JsonRequest ();
				req.setCompany (com.getCompanyMark ());
				// req.setFrom("广东省东莞市");
				req.setTo (toCityInfo);
				req.setNumber (kuaidiNum);
				String result = "";
				try
				{
					String ret = Kuaidi100HttpRequest.getInstance ().postData (req , CommUtil.getURL (request));
					JsonResponse resp = Json.fromJson (JsonResponse.class , ret);
					if (resp.getResult () == true)
					{
						String [ ] strs = itemIds.split (",");
						List <Long> itemIdList = new ArrayList <Long> ();
						for (int i = 0 ; i < strs.length ; i++)
						{
							itemIdList.add (CommUtil.null2Long (strs[i]));
						}
						OrderFormItemExample example = new OrderFormItemExample ();
						example.createCriteria ().andIdIn (itemIdList);
						List <OrderFormItem> formItems = this.orderFormItemService.getObjectList (example);
						example.clear ();
						example.createCriteria ().andOrderIdEqualTo (order.getId ());
						List <OrderFormItem> items = orderFormItemService.getObjectList (example);
						if (items.size () != itemIdList.size ())
						{
							/* 拆分订单 */
							OrderFormWithBLOBs bloBs = new OrderFormWithBLOBs ();
							String orderformId = CommUtil.generateOrderId ();
							bloBs.setAddtime (new Date ());
							bloBs.setInvoice (order.getInvoice ());
							bloBs.setInvoicetype (order.getInvoicetype ());
							bloBs.setMsg (order.getMsg ());
							bloBs.setOrderId (orderformId);
							bloBs.setOrderStatus (order.getOrderStatus ());
							bloBs.setPaytime (order.getPaytime ());
							bloBs.setAddrId (order.getAddrId ());
							bloBs.setPaymentId (order.getPaymentId ());
							bloBs.setStoreId (order.getStoreId ());
							bloBs.setUserId (order.getUserId ());
							bloBs.setAlipayorderId (order.getAlipayorderId ());
							// 设置运费
							double totalPrice = 0.0;
							for (OrderFormItem orderFormItem : formItems)
							{
								totalPrice += orderFormItem.getGoodsPrice ().doubleValue () * orderFormItem.getGoodsCount ();
							}
							BigDecimal goodsAmount = new BigDecimal (totalPrice);
							bloBs.setGoodsAmount (goodsAmount);
							bloBs.setTotalprice (goodsAmount);
							// 修改运费
							BigDecimal oldPrice = new BigDecimal (order.getGoodsAmount ().doubleValue () - totalPrice);
							order.setGoodsAmount (oldPrice);
							order.setTotalprice (oldPrice);
							orderFormService.add (bloBs);
							orderFormService.updateByObject (order);
							// 修改订单详情
							for (OrderFormItem orderFormItem : formItems)
							{
								orderFormItem.setOrderId (bloBs.getId ());
								orderFormItemService.updateByObject (orderFormItem);
							}
							/* 生成订单日志记录 */
							OrderFormLog formLog = new OrderFormLog ();
							formLog.setAddtime (new Date ());
							formLog.setLogUserId (bloBs.getUserId ());
							formLog.setStateInfo (bloBs.getOrderStatus ().toString ());
							formLog.setOfId (Long.valueOf (bloBs.getOrderId ()));
							formLog.setLogInfo (Globals.WAIT_PAYMENT_ORDER_NAME);
							this.orderFormLogService.add (formLog);
							order = bloBs;
						}
						result = "发货成功！";
						order.setOrderStatus (Globals.HAVE_SEND_OUT_GOOD); // 已发货
						// 更新订单
						order.setShipcode (kuaidiNum);
						order.setShiptime (new Date ());
						order.setEcId (Long.valueOf (kuaidiCompany));
						order.setShipPrice (new BigDecimal (Integer.valueOf (kuaidiPrice)));
						this.orderFormService.updateByObject (order);
						KuaiDiResultItem item = new KuaiDiResultItem ();
						item.setKuaidinum (kuaidiNum);
						item.setContext ("卖家发货");
						item.setTime (CommUtil.formatLongDate (new Date ()));
						this.kuaidiService.save (item);
						// 创建订单日志
						this.createOrderLog ("卖家已发货" , String.valueOf (Globals.HAVE_SEND_OUT_GOOD) , orderId);
					}
					else
					{
						result = "发货失败，请检查信息是否正确";
					}
				}
				catch (Exception e)
				{
					e.printStackTrace ();
				}
				mv.addObject ("op_title" , "订单号为 " + order.getOrderId () + " " + result);
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm?orderStatus=20");
			}
			else
			{
				mv.setViewName ("404.html");
			}
			return mv;
		}

	// 生成订单日志
	private void createOrderLog (String info , String status , Long orderId)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			OrderFormLog orderLog = new OrderFormLog ();
			orderLog.setAddtime (new Date ());
			orderLog.setLogInfo (info);
			orderLog.setLogUserId (user.getId ());
			orderLog.setDeletestatus (false);
			orderLog.setStateInfo (status);
			orderLog.setOfId (orderId);
			this.orderFormLogService.add (orderLog);
		}

	@SecurityMapping(title = "卖家退货" , value = "/seller/order_return.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_return.htm" })
	public ModelAndView order_return (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order_return.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				Cart cart = this.cartService.getByKey (obj.getCiId ());
				CartDetailExample cartDetailExample = new CartDetailExample ();
				cartDetailExample.clear ();
				CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
				cartDetailCriteria.andCartIdEqualTo (cart.getId ());
				List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
				cart.getCartDetailList ().addAll (cartDetailList);
				obj.setCart (cart);
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "卖家评价" , value = "/seller/seller_order_evaluate.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_order_evaluate.htm" })
	public ModelAndView order_evaluate (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_order_evaluate.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			StoreWithBLOBs store = storeService.getByKey (CommUtil.null2Long (id));
			Long userId = store.getUser ().getId ();
			EvaluateExample evaluateExample = new EvaluateExample ();
			evaluateExample.createCriteria ().andEvaluateSellerUserIdEqualTo (userId);
			evaluateExample.setOrderByClause ("addTime desc");
			List <EvaluateWithBLOBs> objs = evaluateService.getObjectList (evaluateExample);
			mv.addObject ("store" , store);
			mv.addObject ("objs" , objs);
			return mv;
		}

	@SecurityMapping(title = "卖家评价保存" , value = "/seller/order_evaluate_save.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_evaluate_save.htm" })
	public ModelAndView order_evaluate_save (HttpServletRequest request , HttpServletResponse response , String id , String evaluate_info , String evaluate_seller_val)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				if (obj.getOrderStatus () == 50)
				{
					obj.setOrderStatus (60);
					obj.setFinishtime (new Date ());
					this.orderFormService.updateByObject (obj);
					Enumeration <String> enum1 = request.getParameterNames ();
					// List maps = new ArrayList <Object> ();
					while (enum1.hasMoreElements ())
					{
						String paramName = (String) enum1.nextElement ();
						if (paramName.indexOf ("evaluate_seller_val") >= 0)
						{
							// String value = request.getParameter (paramName);
							EvaluateWithBLOBs eva = this.evaluateService.getByKey (CommUtil.null2Long (paramName.substring (19)));
							eva.setEvaluateSellerVal (CommUtil.null2Int (request.getParameter (paramName)));
							eva.setEvaluate_seller_user (SecurityUserHolder.getCurrentUser ());
							eva.setEvaluateSellerInfo (request.getParameter ("evaluate_info" + eva.getId ().toString ()));
							eva.setEvaluateSellerTime (new Date ());
							this.evaluateService.updateByObject (eva);
							User user = obj.getUser ();
							user.setUserCredit (user.getUserCredit () + eva.getEvaluateSellerVal ());
							if (this.configService.getSysConfig ().getIntegral ())
							{
								int integral = 0;
								if (this.configService.getSysConfig ().getConsumptionratio () > 0)
								{
									integral = CommUtil.null2Int (Double.valueOf (CommUtil.div (obj.getTotalprice () , Integer.valueOf (this.configService.getSysConfig ().getConsumptionratio ()))));
								}
								integral = integral > this.configService.getSysConfig ().getEveryindentlimit () ? this.configService.getSysConfig ().getEveryindentlimit () : integral;
								/*user.setIntegral (user.getIntegral () + integral);*/
								this.userService.updateByObject (user);
								IntegralLog log = new IntegralLog ();
								log.setAddtime (new Date ());
								log.setContent ("订单" + obj.getOrderId () + "完成增加" + integral + "分");
								log.setIntegral (integral);
								log.setIntegralUser (user);
								log.setType ("login");
								this.integralLogService.add (log);
							}
						}
					}
				}
				OrderFormLog ofl = new OrderFormLog ();
				ofl.setAddtime (new Date ());
				ofl.setLogInfo ("评价订单");
				ofl.setLogUser (SecurityUserHolder.getCurrentUser ());
				ofl.setOf (obj);
				this.orderFormLogService.add (ofl);
			}
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "订单评价成功！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			return mv;
		}

	@SecurityMapping(title = "打印订单" , value = "/seller/order_print.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usercenter/order_print.htm" })
	public ModelAndView order_print (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/order_print.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				OrderFormWithBLOBs orderform = this.orderFormService.getByKey (CommUtil.null2Long (id));
				Cart cart = this.cartService.getByKey (orderform.getCiId ());
				CartDetailExample cartDetailExample = new CartDetailExample ();
				cartDetailExample.clear ();
				CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
				cartDetailCriteria.andCartIdEqualTo (cart.getId ());
				List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
				cart.getCartDetailList ().addAll (cartDetailList);
				orderform.setCart (cart);
				mv.addObject ("obj" , orderform);
			}
			return mv;
		}

	@SecurityMapping(title = "卖家物流详情" , value = "/seller/order_query_userinfor.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_query_userinfor.htm" })
	public ModelAndView seller_query_userinfor (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_query_userinfor.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderForm obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			return mv;
		}

	@SecurityMapping(title = "买家退货申请详情" , value = "/seller/seller_return_goods.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_return_goods.htm" })
	public ModelAndView seller_order_return_apply_view (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_return_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				RefundGoodsExample exa = new RefundGoodsExample ();
				exa.clear ();
				exa.createCriteria ().andOfIdEqualTo (obj.getId ());
				RefundGoods rg = this.refundGoodsService.selectByExample (exa).get (0);
				RefundItem item = this.refundItemService.selectByPrimaryKey (Long.valueOf (rg.getRefundType ()));
				List <Accessory> imgList = new ArrayList <> ();
				String img = rg.getImgPaths ();
				if (img != null && !img.equals (""))
				{
					String [ ] imgs = img.split (",");
					for (String str : imgs)
					{
						imgList.add (this.accessoryService.getByKey (Long.valueOf (str)));
					}
				}
				rg.setItemRefundItem (item);
				rg.setImgs (imgList);
				mv.addObject ("obj" , obj);
				mv.addObject ("refund" , rg);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@RequestMapping({ "/seller/evaluate_manage.htm" })
	public ModelAndView evaluate_manage (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/evaluate_manage.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 卖家总资产查询
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/seller/property.htm" })
	public ModelAndView property (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/property.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			System.out.println(user.getAddtime());
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			OrderFormExample example = new OrderFormExample ();
			example.clear ();
			Calendar c1 = new GregorianCalendar ();
			c1.set (Calendar.HOUR_OF_DAY , 0);
			c1.set (Calendar.MINUTE , 0);
			c1.set (Calendar.SECOND , 0);
			Calendar c2 = new GregorianCalendar ();
			c2.set (Calendar.HOUR_OF_DAY , 23);
			c2.set (Calendar.MINUTE , 59);
			c2.set (Calendar.SECOND , 59);
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			String star = sdf.format (c1.getTime ());
			String end = sdf.format (c2.getTime ());
			Date stardate = null;
			Date endDate = null;
			try
			{
				stardate = sdf.parse (star);
				endDate = sdf.parse (end);
				System.out.println ("s=" + stardate);
				System.out.println ("d=" + endDate);
			}
			catch (ParseException x)
			{
				x.printStackTrace ();
			}
			System.out.println ("店铺id" + user.getStoreId ());
			// 查询一天内的营业额
			List <Integer> statusIds = new ArrayList <Integer> ();
			statusIds.add (50);
			statusIds.add (40);
			Criteria criteria = example.createCriteria();
			criteria.andAddtimeBetween (stardate , endDate);
			criteria.andOrderStatusIn (statusIds);
			criteria.andStoreIdEqualTo (user.getStoreId ());
			BigDecimal sun = new BigDecimal (0.0);
			List <OrderForm> orderForms = orderFormService.selectOrderForms (example);
			System.out.println ("size=" + orderForms.size ());
			if (orderForms.size () != 0)
			{
				for (OrderForm orderFormWithBLOBs : orderForms)
				{
					sun = orderFormWithBLOBs.getTotalprice ().add (sun);
				}
			}
			// 查询当月营业额
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
			List <Integer> statusId = new ArrayList <Integer> ();
			statusId.add (50);
			statusId.add (40);
			OrderFormExample exampletow = new OrderFormExample ();
			exampletow.clear ();
			exampletow.createCriteria ().andStoreIdEqualTo (user.getStoreId ()).andAddtimeBetween (dates , datee).andOrderStatusIn (statusId);
			/*
			 * exampletow.createCriteria().andOrderStatusEqualTo(20);
			 * System.out.println("storeid="+user.getStoreId());
			 * exampletow.createCriteria().andStoreIdEqualTo(user.getStoreId());
			 * exampletow.createCriteria().andAddtimeBetween(dates,datee);
			 */
			BigDecimal suns = new BigDecimal (0.0);
			List <OrderForm> orderFormss = orderFormService.selectOrderForms (exampletow);
			System.out.println ("orderfomsssize=" + orderFormss.size ());
			if (orderFormss.size () != 0)
			{
				for (OrderForm orderFormWithBLOB : orderFormss)
				{
					suns = orderFormWithBLOB.getTotalprice ().add (suns);
				}
			}
			mv.addObject ("monthPrice" , suns);
			mv.addObject ("totalPrice" , sun);
			mv.addObject ("TotalAssets" , user.getCurrentFee ());
			return mv;
		}

	@RequestMapping({ "/seller/logistics_query.htm" })
	public ModelAndView logistics_query (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/logistics_query.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/seller/logistics_tool.htm" })
	public ModelAndView logistics_tool (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/logistics_tool.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/seller/customer_service.htm" })
	public ModelAndView customer_service (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/customer_service.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/seller/customer_service_add.htm" })
	public ModelAndView customer_service_add (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/customer_service_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/seller/logistics_add.htm" })
	public ModelAndView logistics_add (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/logistics_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@SecurityMapping(title = "买家申请退款详情" , value = "/seller/seller_order_return_apply_view.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_confim_order_refund.htm" })
	public ModelAndView seller_confim_order_refund (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_return.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				Refund refund = this.RefundService.getByKey (obj.getRefundId ());
				List <Accessory> imgList = new ArrayList <> ();
				String img = refund.getImgPaths ();
				if (img != null && !img.equals (""))
				{
					String [ ] imgs = img.split (",");
					for (String str : imgs)
					{
						imgList.add (this.accessoryService.getByKey (Long.valueOf (str)));
					}
				}
				if (refund.getRefundType () != null)
				{
					RefundItem item = this.refundItemService.selectByPrimaryKey (Long.valueOf (refund.getRefundType ()));
					refund.setItemRefundItem (item);
				}
				refund.setImgs (imgList);
				mv.addObject ("obj" , obj);
				mv.addObject ("refund" , refund);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "拒绝买家退款" , value = "/seller/no_order_refund.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/no_order_refund.htm" })
	public String no_order_refund (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long refundId)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (Long.valueOf (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				this.createOrderLog (Globals.NO_HAVE_RECEIVED_MOENY_NAME , String.valueOf (Globals.NO_HAVE_RECEIVED_MOENY) , Long.valueOf (obj.getOrderId ()));
				Refund log = this.RefundService.getByKey (refundId);
				log.setStatus (Globals.NO_HAVE_RECEIVED_MOENY);  // 拒绝
				this.RefundService.updateByObject (log);
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , log.getGoodsId ());
				item.setRefund (Globals.NO_HAVE_RECEIVED_MOENY);
				this.orderFormItemService.updateByObject (item);
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "拒绝买家退货" , value = "/seller/no_order_refund_goods.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/no_order_refund_goods.htm" })
	public String no_order_refund_goods (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long refundId)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (Long.valueOf (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				this.createOrderLog (Globals.BUYER_APPLY_RETURN_GOOD_NAME , String.valueOf (Globals.BUYER_APPLY_RETURN_GOOD) , Long.valueOf (obj.getOrderId ()));
				RefundGoods log = this.refundGoodsService.selectByPrimaryKey (refundId);
				log.setStatus (Globals.SELLER_REFUSE_RETURN_GOOD);  // 拒绝
				this.refundGoodsService.updateByPrimaryKey (log);
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , log.getGoodsId ());
				item.setRefund (Globals.SELLER_REFUSE_RETURN_GOOD);
				this.orderFormItemService.updateByObject (item);
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "同意退款" , value = "/seller/order_refund_save.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_refund_save.htm" })
	public String order_refund_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String refund , Long refundId) throws InterruptedException
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				Refund ref = this.RefundService.getByKey (refundId);
				ref.setStatus (Globals.WAIT_REFUND);  // 等待退款
				ref.setFactRefund (new BigDecimal (refund));
				this.RefundService.updateByObject (ref);
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (CommUtil.null2Long (id) , ref.getGoodsId ());
				item.setRefund (Globals.WAIT_REFUND);
				this.orderFormItemService.updateByObject (item);
				/* 一个订单已经存在，且等待退款就修改状态 */
				CashDeposit cashDeposit = null;
				CashDepositExample example = new CashDepositExample ();
				example.createCriteria ().andCashStatusEqualTo (Globals.APPLY_REFUND_SELLER).andRefundIdEqualTo (refundId);
				List <CashDeposit> deposits = this.cashDepositService.getObjectList (example);
				if (!deposits.isEmpty ())
				{
					cashDeposit = deposits.get (0);
					cashDeposit.setPayOrderId (obj.getAlipayorderId ());
					cashDeposit.setCreateTime (new Date ());
					cashDeposit.setRefundId (refundId);
					this.cashDepositService.updateByObject (cashDeposit);
				}
				else
				{
					cashDeposit = new CashDeposit ();
					cashDeposit.setPayOrderId (obj.getAlipayorderId ());
					cashDeposit.setCashStatus (Globals.APPLY_REFUND_SELLER);
					cashDeposit.setCreateTime (new Date ());
					cashDeposit.setRefundId (refundId);
					cashDeposit.setSellerUserId (SecurityUserHolder.getCurrentUser ().getId ());
					this.cashDepositService.add (cashDeposit);
				}
			}
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "同意退货" , value = "/seller/order_refund_goods_save.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/order_refund_goods_save.htm" })
	public String order_refund_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String refund , Long refundId)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				RefundGoods log = this.refundGoodsService.selectByPrimaryKey (refundId);
				log.setStatus (Globals.RETURN_GOOD);  // 同意
				this.refundGoodsService.updateByPrimaryKey (log);
				// 更改购买的商品状态
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , log.getGoodsId ());
				item.setRefund (Globals.RETURN_GOOD);
				this.orderFormItemService.updateByObject (item);
				this.createOrderLog (Globals.RETURN_GOOD_NAME , String.valueOf (Globals.RETURN_GOOD) , Long.valueOf (obj.getOrderId ()));
			}
			
			return "redirect:order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "确认买家退货" , value = "/seller/seller_order_return_confirm.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_order_return_confirm.htm" })
	public ModelAndView seller_order_return_confirm (HttpServletRequest request , HttpServletResponse response , String id)
		{
			System.out.println("进入了该代金券方法");
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getStore ().getId ().equals (SecurityUserHolder.getCurrentUser ().getStore ().getId ()))
			{
				mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				RefundGoodsExample rge = new RefundGoodsExample ();
				rge.createCriteria ().andOfIdEqualTo (obj.getId ());
				RefundGoods rg = this.refundGoodsService.selectByExample (rge).get (0);
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (CommUtil.null2Long (id) , rg.getGoodsId ());
				if (item.getRefund ().intValue () == Globals.RETURN_GOOD)
				{
					item.setRefund (Globals.WAIT_REFUND);
					this.orderFormItemService.updateByObject (item);
					// 新代码
					RefundExample example = new RefundExample ();
					example.createCriteria ().andOfIdEqualTo (obj.getId ());
					List <Refund> list = this.RefundService.getObjectList (example);
					Refund refunds = new Refund();
					if (list.size () > 0)
					{
						refunds = list.get (0);
						// 新代码
						RefundExample exRefundExample = new RefundExample ();
						exRefundExample.createCriteria ().andOfIdEqualTo (refunds.getOfId ());
						RefundService.deleteByExample (exRefundExample);
					}
					Refund ref = new Refund ();
					ref.setAddtime (new Date ());
					ref.setDeletestatus (false);
					ref.setGoodsId (rg.getGoodsId ());
					ref.setStatus (Globals.WAIT_REFUND);  // 等待退款
					ref.setOfId (obj.getId ());
					ref.setRefund (rg.getRefund ());
					ref.setRefundUserId (SecurityUserHolder.getCurrentUser ().getId ());
					// ref.setRefundType("退货");
					ref.setRefundType (rg.getRefundType ());
					ref.setFactRefund (rg.getRefund ());
					this.RefundService.add (ref);
					CashDeposit cashDeposit = new CashDeposit ();
					cashDeposit.setPayOrderId (obj.getAlipayorderId ());
					cashDeposit.setCashStatus (Globals.APPLY_REFUND_SELLER);
					cashDeposit.setCreateTime (new Date ());
					cashDeposit.setRefundId (ref.getId ());
					cashDeposit.setSellerUserId (SecurityUserHolder.getCurrentUser ().getId ());
					this.cashDepositService.add (cashDeposit);
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
					mv.addObject ("op_title" , "退货成功");
				}
				else
				{
					mv.addObject ("op_title" , "该订单不在退货中" + id);
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
				}
			}
			else
			{
				mv.addObject ("op_title" , "您店铺中没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			/*卖家同意退货后，返回代金券*/
			User user = userService.getByKey(obj.getUserId());
			double price = 0;
			if(null != obj.getGoodsAmount() && obj.getGoodsAmount().compareTo(new BigDecimal(0))>1){
				price = obj.getGoodsAmount().subtract(obj.getTotalprice()).doubleValue();
			}
			if(null == user.getIntegral()){
				user.setIntegral(0);
			}
			user.setIntegral(user.getIntegral()+(int)price);
			userService.updateByObject(user);
			 IntegralLog log = new IntegralLog ();
			 log.setAddtime (new Date ());
			 log.setContent ("用户" + CommUtil.formatLongDate (new Date ()) + "退货增加" +
			  price + "分");
			 log.setIntegral ((int)price);
			 log.setIntegralUserId(user.getId());
			 log.setOrderId(obj.getOrderId());
			 log.setType ("reg");
			  this.integralLogService.add (log);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: send_email
	 * </p>
	 * <p>
	 * Description: 使用编辑好的模板 发现订单信息到邮件
	 * </p>
	 * 
	 * @param request
	 * @param order
	 * @param mark
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	private void send_email (HttpServletRequest request , OrderForm order , String mark) throws Exception
		{
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			Template template = null;
			List <Template> templates = templateService.getObjectList (templateExample);
			if (null != templates && templates.size () > 0)
			{
				template = templates.get (0);
			}
			if ((template != null) && (template.getOpen ()))
			{
				String email = order.getUser ().getEmail ();
				String subject = template.getTitle ();
				String path = request.getSession ().getServletContext ().getRealPath ("") + File.separator + "vm" + File.separator;
				if (!CommUtil.fileExist (path))
				{
					CommUtil.createFolder (path);
				}
				PrintWriter pwrite = new PrintWriter (new OutputStreamWriter (new FileOutputStream (path + "msg.vm" , false) , "UTF-8"));
				pwrite.print (template.getContent ());
				pwrite.flush ();
				pwrite.close ();
				Properties p = new Properties ();
				p.setProperty ("file.resource.loader.path" , request.getRealPath ("") + File.separator + "vm" + File.separator);
				p.setProperty ("input.encoding" , "UTF-8");
				p.setProperty ("output.encoding" , "UTF-8");
				Velocity.init (p);
				org.apache.velocity.Template blank = Velocity.getTemplate ("msg.vm" , "UTF-8");
				VelocityContext context = new VelocityContext ();
				context.put ("buyer" , order.getUser ());
				context.put ("seller" , order.getStore ().getUser ());
				context.put ("config" , this.configService.getSysConfig ());
				context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
				context.put ("webPath" , CommUtil.getURL (request));
				context.put ("order" , order);
				StringWriter writer = new StringWriter ();
				blank.merge (context , writer);
				String content = writer.toString ();
				this.msgTools.sendEmail (email , subject , content);
			}
		}

	@SuppressWarnings("deprecation")
	private void send_sms (HttpServletRequest request , OrderForm order , String mobile , String mark) throws Exception
		{
			/*
			 * Template template = this.templateService .getObjByProperty("mark",
			 * mark);
			 */
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			Template template = null;
			List <Template> templates = templateService.getObjectList (templateExample);
			if (null != templates && templates.size () > 0)
			{
				template = templates.get (0);
			}
			if ((template != null) && (template.getOpen ()))
			{
				String path = request.getSession ().getServletContext ().getRealPath ("") + File.separator + "vm" + File.separator;
				if (!CommUtil.fileExist (path))
				{
					CommUtil.createFolder (path);
				}
				PrintWriter pwrite = new PrintWriter (new OutputStreamWriter (new FileOutputStream (path + "msg.vm" , false) , "UTF-8"));
				pwrite.print (template.getContent ());
				pwrite.flush ();
				pwrite.close ();
				Properties p = new Properties ();
				p.setProperty ("file.resource.loader.path" , request.getRealPath ("/") + "vm" + File.separator);
				p.setProperty ("input.encoding" , "UTF-8");
				p.setProperty ("output.encoding" , "UTF-8");
				Velocity.init (p);
				org.apache.velocity.Template blank = Velocity.getTemplate ("msg.vm" , "UTF-8");
				VelocityContext context = new VelocityContext ();
				context.put ("buyer" , order.getUser ());
				context.put ("seller" , order.getStore ().getUser ());
				context.put ("config" , this.configService.getSysConfig ());
				context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
				context.put ("webPath" , CommUtil.getURL (request));
				context.put ("order" , order);
				StringWriter writer = new StringWriter ();
				blank.merge (context , writer);
				String content = writer.toString ();
				this.msgTools.sendSMS (mobile , content);
			}
		}

	@RequestMapping({ "/seller/propertyDetails.htm" })
	@ResponseBody
	public void propertyDetails (HttpServletRequest request , HttpServletResponse response , String page)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				try
				{
					// 该用户未登录
					response.getWriter ().print ("1");
				}
				catch (IOException e)
				{
					// Auto-generated catch block
					e.printStackTrace ();
				}
				return;
			}
			if (user.getStoreId () != null)
			{
			}
		}
	
	public static void main(String[] arges) throws ParseException{
		Calendar c1 = new GregorianCalendar ();
		c1.set (Calendar.HOUR_OF_DAY , 0);
		c1.set (Calendar.MINUTE , 0);
		c1.set (Calendar.SECOND , 0);
		Calendar c2 = new GregorianCalendar ();
		c2.set (Calendar.HOUR_OF_DAY , 23);
		c2.set (Calendar.MINUTE , 59);
		c2.set (Calendar.SECOND , 59);
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String star = sdf.format (c1.getTime ());
		String end = sdf.format (c2.getTime ());
		Date stardate = null;
		Date endDate = null;
	
		
			stardate = sdf.parse (star);
			endDate = sdf.parse (end);
			System.out.println (c1.getTime ());
			System.out.println (c2.getTime ());
			System.out.println (star);
			System.out.println (end);
	}
}
