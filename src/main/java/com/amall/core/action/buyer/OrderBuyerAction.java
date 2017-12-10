package com.amall.core.action.buyer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.CartExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsProperty;
import com.amall.core.bean.GoodsReturn;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.bean.RefundGoods;
import com.amall.core.bean.RefundItem;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IExpressCompanyService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.IRefundGoodsService;
import com.amall.core.service.IRefundItemSerivce;
import com.amall.core.service.IRefundService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IAreaService;
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
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.kuaidi.IKuaidiStatusService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.predeposit.IPredepositLogService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.express.kuaidi100.Kuaidi100HttpRequest;
import com.amall.core.web.express.kuaidi100.JsonRequest;
import com.amall.core.web.express.kuaidi100.JsonResponse;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.PaymentTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : OrderBuyerAction
 *
 * Description : 用户订单
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:44:41
 *
 */
@Controller
public class OrderBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IPredepositLogService predepositLogService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private ICartService goodsCartService2;// Cart这个表实体类对应的Service文件

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private IGoodsReturnItemService goodsReturnItemService;

	@Autowired
	private PaymentTools paymentTools;

	@Autowired
	private IGoodsReturnService goodsReturnService;

	@Autowired
	private IExpressCompanyService expressCompayService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IRefundService RefundService;

	@Autowired
	private IGoodsReturnLogService goodsReturnLogService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private IKuaidiStatusService kuaidiStatusService;

	@Autowired
	private IRefundItemSerivce refundItemSerice;

	@Autowired
	private IRefundGoodsService refundGoodsService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IIntegralLogService integralLogService;

	/**
	 * 买家中心 -- 我的订单
	 * 
	 * @author wsw
	 * @date 2015年6月6日 下午5:36:42
	 * @param request
	 * @param response
	 * @param currentPage
	 *            当前页
	 * @param choices
	 *            页面用户输入的查询条件
	 * @param order_time
	 *            用户选择的，查询的订单日期
	 * @param order_status
	 *            用户选择的，查询的订单状态
	 * @return ModelAndView
	 * @todo 用来接收页面用户的查询订单的请求，并将查询结果返回
	 */
	@RequestMapping({ "/buyer/buyer_order.htm" })
	public ModelAndView order (HttpServletRequest request , HttpServletResponse response , String currentPage , String choices , String order_time , String order_status)
		{
			ModelAndView mv = null;
			User buyerUser = SecurityUserHolder.getCurrentUser ();
			if (buyerUser == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				mv = new JModelAndView ("buyer/buyer_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				OrderFormExample orderFormExample = new OrderFormExample ();
				orderFormExample.clear ();
				orderFormExample.setOrderByClause ("addTime desc");
				orderFormExample.setPageNo (CommUtil.null2Int (currentPage));
				orderFormExample.setPageSize (6);
				OrderFormExample.Criteria orderCriteria = orderFormExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andDeletestatusEqualTo (false);
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
				{
					url = CommUtil.getURL (request);
				}
				List <OrderFormWithBLOBs> orderFormWithBLOBs = null;
				// 根据页面传来的三个条件 order_id , goodsName , goods_id进行并集模糊查询
				List <OrderFormWithBLOBs> ordersByName = new ArrayList <OrderFormWithBLOBs> ();
				// 根据页面传递的条件 来模糊查询
				if (!CommUtil.null2String (choices).equals (""))
				{
					orderCriteria = orderCriteria.andOrderIdLike ("%" + choices + "%");
					OrderFormExample.Criteria goodsNameCriteria = orderFormExample.createCriteria ();
					// GoodsCartExample goodsCartExample = new GoodsCartExample();
					orderFormWithBLOBs = this.orderFormService.selectOfByGoodsNameLike ("%" + choices + "%");
					/**
					 * 按商品名称查询
					 */
					GoodsExample goodsExample = new GoodsExample ();
					GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
					goodsCriteria.andGoodsNameLike ("%" + choices + "%");
					List <GoodsWithBLOBs> goods = this.goodsService.getObjectList (goodsExample);
					CartExample cartExample = new CartExample ();
					List <Long> cartIds = new ArrayList <Long> ();
					for (GoodsWithBLOBs good : goods)
					{
						cartExample.clear ();
						CartExample.Criteria cartCriteria = cartExample.createCriteria ();
						cartCriteria.andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
						cartCriteria.andGoodsIdsLike ("%" + good.getId () + "%");
						List <Cart> cartList = this.goodsCartService2.getObjectList (cartExample);
						for (Cart c : cartList)
						{
							cartIds.add (c.getId ());
						}
					}
					OrderFormExample orderFormExample2 = new OrderFormExample ();
					orderFormExample2.clear ();
					OrderFormExample.Criteria orderFormCriteria2 = orderFormExample2.createCriteria ();
					if (cartIds.size () != 0)
					{
						orderFormCriteria2.andCiIdIn (cartIds);
					}
					else
					{
						orderFormCriteria2.andCiIdIsNull ();
					}
					// 通过商品名称进行模糊查询
					ordersByName = this.orderFormService.getObjectList (orderFormExample2);
					mv.addObject ("choices" , choices);
				}
				// 传来的order_time，来进行时间划分
				if (!CommUtil.null2String (order_time).equals (""))
				{
					Calendar calendar = Calendar.getInstance ();
					calendar.setTime (new Date ());
					if (order_time.equals ("recentlyMonths"))
					{
						orderCriteria.andAddtimeLessThan (new Date ()).andAddtimeGreaterThan (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) + "-" + (calendar.get (Calendar.MONTH) - 2) + "-" + calendar.get (Calendar.DATE)) , "yyyy-MM-dd"));
					}
					// 今年
					if (order_time.equals ("toYear"))
					{
						orderCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR)) + "-01-01"));
					}
					// 一年内
					if (order_time.equals ("oneYearAgo"))
					{
						orderCriteria.andAddtimeBetween (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 1) + "-01-01") , CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 1) + "-12-31"));
					}
					// 两年内
					if (order_time.equals ("twoYearsAgo"))
					{
						System.err.println (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 2) + "-01-01"));
						System.out.println (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 2) + "-12-31"));
						orderCriteria.andAddtimeBetween (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 2) + "-01-01") , CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 2) + "-12-31"));
					}
					// 三年内
					if (order_time.equals ("threeYearsAgo"))
					{
						orderCriteria.andAddtimeBetween (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 3) + "-01-01") , CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 3) + "-12-31"));
					}
					// 三年前
					if (order_time.equals ("beforeThreeYearsAgo"))
					{
						orderCriteria.andAddtimeLessThan (CommUtil.formatDate (String.valueOf (calendar.get (Calendar.YEAR) - 4) + "-12-31"));
					}
					mv.addObject ("order_time" , order_time);
				}
				if (!CommUtil.null2String (order_status).equals (""))
				{
					// 未付款(等待付款)
					if (order_status.equals ("order_submit"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (10));
					}
					// 已付款(等待发货)
					if (order_status.equals ("order_pay"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (20));
					}
					// 已发货(等待收货)
					if (order_status.equals ("order_shipping"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (30));
					}
					// 已收货,尚未评价(等待评价)
					if (order_status.equals ("order_receive"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (40));
					}
					// 已评价
					if (order_status.equals ("order_finish"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (50));
					}
					// 订单取消
					if (order_status.equals ("order_cancel"))
					{
						orderCriteria.andOrderStatusEqualTo (Integer.valueOf (0));
					}
				}
				// 将订单状态传递到前台 显示在下拉框中
				mv.addObject ("order_status" , order_status);
				Pagination pList = this.orderFormService.getObjectListWithPage (orderFormExample);
				List <OrderFormWithBLOBs> orders = (List <OrderFormWithBLOBs>) pList.getList ();
				for (OrderFormWithBLOBs o : orders)
				{
					OrderFormItemExample ofie = new OrderFormItemExample ();
					ofie.clear ();
					ofie.createCriteria ().andOrderIdEqualTo (o.getId ());
					List <OrderFormItem> items = this.orderFormItemService.getObjectList (ofie);
					o.setItems (items);
					// 是否有退款记录
					/*
					 * if(o.getRefundId() != null){
					 * Refund refund = this.RefundService.getByKey(o.getRefundId());
					 * o.setRefundObj(refund);
					 * }
					 */
					// 是否有退货记录
					/*
					 * RefundGoodsExample exa = new RefundGoodsExample();
					 * exa.clear();
					 * exa.createCriteria().andOfIdEqualTo(Long.valueOf(o.getOrderId()));
					 * List<RefundGoods> rgs = this.refundGoodsService.selectByExample(exa);
					 * RefundGoods rg = rgs.size()>0?rgs.get(0):null;
					 * o.setRefundGoods(rg);
					 */
					/*
					 * CartDetailExample example = new CartDetailExample();
					 * example.clear();
					 * example.createCriteria().andCartIdEqualTo(o.getCiId());
					 * List<CartDetail> cartDetails = this.cartDetailService.getObjectList(example);
					 * List<CartDetail> tempList = new ArrayList<>();
					 * for (CartDetail goods : cartDetails) {
					 * if (o.getStoreId().equals(goods.getGoods().getGoodsStoreId())) {
					 * tempList.add(goods);
					 * }
					 * }
					 * Cart cart = new Cart();
					 * cart.setCartDetailList(tempList);
					 * o.setCart(cart);
					 */
					o.setUser (this.userService.getByKey (CommUtil.null2Long (o.getUserId ())));
				}
				pList.setList (orders);
				// 当choices是通过商品名称进行模糊查询时 , 获取的ordersByName是不为空 , 将该集合设置进如pList内部
				if (ordersByName != null && ordersByName.size () > 0)
				{
					pList.setList (ordersByName);
				}
				CommUtil.addIPageList2ModelAndView (url + "/buyer/buyer_order.htm" , "" , "" , pList , mv);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/finish_buyer_order.htm" })
	public ModelAndView finish_buyer_order (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/finish_buyer_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.setOrderByClause ("addTime desc");
			orderFormExample.setPageNo (CommUtil.null2Int (currentPage));
			orderFormExample.setPageSize (3);
			orderFormExample.createCriteria ().andUserIdEqualTo (user.getId ()).andDeletestatusEqualTo (false).andOrderStatusEqualTo (50);
			Pagination pList = this.orderFormService.getObjectListWithPage (orderFormExample);
			mv.addObject ("objs" , pList.getList ());
			return mv;
		}

	/**
	 * 
	 * @todo 订单取消,通过前台传递订单号,来获取当前用户需要取消的订单是否存在
	 * @author wsw
	 * @date 2015年7月15日 上午11:22:11
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "订单取消" , value = "/buyer/order_cancel.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_cancel.htm" })
	public ModelAndView order_cancel (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_order_cancel.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs orderFormWithBLOBs = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (orderFormWithBLOBs.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv.addObject ("obj" , orderFormWithBLOBs);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:58:38
	 * @todo 收获确认页面的跳转
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "收货确认" , value = "/buyer/order_cofirm.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_cofirm.htm" })
	public ModelAndView order_cofirm (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_order_cofirm.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 根据前台传来的id 获取该用户是否存在该订单
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/order.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:58:08
	 * @todo 确认收货 ,保存,并写入到日志
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "收货确认保存" , value = "/buyer/order_cofirm_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_cofirm_save.htm" })
	public String order_cofirm_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage) throws Exception
		{
			OrderFormWithBLOBs orderFormWithBLOBs = this.orderFormService.getByKey (CommUtil.null2Long (id));
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			if (orderFormWithBLOBs.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				/* 更新订单状态 */
				orderFormWithBLOBs.setOrderStatus (Globals.HAVE_RECEIVED_GOOD);
				orderFormWithBLOBs.setFinishtime (new Date ());
				int count = this.orderFormService.updateByObject (orderFormWithBLOBs);
				/* 购买商品赠送积分 */
				User user = orderFormWithBLOBs.getUser ();
				double cost = orderFormWithBLOBs.getTotalprice ().doubleValue ();
				int rule = config.getConsumptionratio ();
				int integrallimit = config.getEveryindentlimit ();
				if (cost >= 10 && rule > 0)
				{
					int integral = (int) cost / rule;
					if (integral > integrallimit)
					{
						integral = integrallimit;
					}
					/*user.setIntegral (user.getIntegral () + integral);*/
					int cnt = this.userService.updateByObject (user);
					if (cnt > 0)
					{ // 当用户表更新后，开始设置积分日志
					/*	this.createIntegralLog ("用户购买商品增加" + integral + "积分" , "buy" , integral);*/
					}
				}
				if (count > 0)
				{ // 当orderForm更新后,返回的行数会大于1,即更新成功,开始设置订单日志
					this.createOrderLog ("确认收货,交易成功" , "60" , Long.valueOf (orderFormWithBLOBs.getOrderId ()));
				}
			}
			String url = "redirect:buyer_order.htm?currentPage=" + currentPage;
			return url;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:52:40
	 * @todo 买家评价
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "买家评价" , value = "/buyer/order_evaluate.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_evaluate.htm" })
	public ModelAndView order_evaluate (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_order_evaluate.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 获取订单
			OrderForm orderForm = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (orderForm.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				/*
				 * GoodsCartExample goodsCartExample = new GoodsCartExample();
				 * goodsCartExample.clear();
				 * goodsCartExample.createCriteria().andOfIdEqualTo(orderForm.getId(
				 * )); List<GoodsCart> gcs = this.goodsCartService
				 * .getObjectList(goodsCartExample);
				 * // 获取订单的goodscart orderForm.setGcs(gcs);
				 */
				Cart cart = this.goodsCartService2.getByKey (orderForm.getCiId ());
				String [ ] goodsIds = cart.getGoodsIds ().split (",");// 获得Cart对象所拥有的GoodsWithBLOBs对象
				List <GoodsWithBLOBs> goodslist = new ArrayList <GoodsWithBLOBs> ();
				for (String goodsId : goodsIds)
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
					goodslist.add (goods);
				}
				cart.getGoodslist ().addAll (goodslist);
				CartDetailExample cartDetailExample = new CartDetailExample ();
				cartDetailExample.clear ();
				CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
				cartDetailCriteria.andCartIdEqualTo (cart.getId ());
				List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
				for (CartDetail cartDetail : cartDetailList)
				{
					if (cartDetail.getSpecId () != null && !cartDetail.getSpecId ().equals (""))
					{
						String [ ] ids = cartDetail.getSpecId ().split (",");
						if (ids != null && ids.length > 0)
						{
							List <GoodsProperty> properties = new ArrayList <GoodsProperty> ();
							for (String id2 : ids)
							{
								GoodsProperty gp = this.goodsPropertyService.selectByPrimaryKey (CommUtil.null2Long (id2));
								properties.add (gp);
							}
							cartDetail.getProperties ().addAll (properties);
						}
					}
				}
				cart.getCartDetailList ().addAll (cartDetailList);
				orderForm.setCart (cart);
				mv.addObject ("obj" , orderForm);
				if (orderForm.getOrderStatus () >= 50)
				{ // orderStatus==50的时候
					// 是已经评价完毕
					mv = new JModelAndView ("success.html" , // 跳转到 万能的success页面
					this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "订单已经评价！");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
				}
			}
			else
			{ // 该用户 并没有该笔订单.
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/order.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:59:30
	 * @todo 买家收获确认之后,对该商品的评价,并记录日志
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "买家评价保存" , value = "/buyer/order_evaluate_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_evaluate_save.htm" })
	public ModelAndView order_evaluate_save (HttpServletRequest request , HttpServletResponse response , String id) throws Exception
		{
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (id));
			// 当该用户存在此笔订单的时候,才可以进行评价
			if (orderForm.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				if (orderForm.getOrderStatus () == 40)
				{ // 当orderStatus为40的时候
					// 处于已收货状态 但是未评价 给予评价功能
					orderForm.setOrderStatus (Integer.valueOf (50));
					this.orderFormService.updateByObject (orderForm);
					OrderFormLog ofl = new OrderFormLog (); // 写日志啦
					ofl.setAddtime (new Date ());
					ofl.setLogInfo ("评价订单");
					ofl.setLogUser (SecurityUserHolder.getCurrentUser ());
					ofl.setOfId (orderForm.getId ());
					ofl.setOf (orderForm);
					this.orderFormLogService.add (ofl);
					/*
					 * GoodsCartExample goodsCartExample = new GoodsCartExample();
					 * goodsCartExample.clear();
					 * goodsCartExample.createCriteria().andOfIdEqualTo(
					 * orderForm.getId()); List<GoodsCart> gcs =
					 * this.goodsCartService .getObjectList(goodsCartExample);
					 */
					CartExample cartExample = new CartExample ();
					cartExample.clear ();
					CartExample.Criteria cartCriteria = cartExample.createCriteria ();
					cartCriteria.andIdEqualTo (orderForm.getCiId ());
					List <Cart> gcs = this.goodsCartService2.getObjectList (cartExample);
					Cart cart = gcs.get (0);
					CartDetailExample cartDetailExample = new CartDetailExample ();
					cartDetailExample.clear ();
					CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
					cartDetailCriteria.andCartIdEqualTo (cart.getId ());
					List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
					for (CartDetail gc1 : cartDetailList)
					{
						EvaluateWithBLOBs eva = new EvaluateWithBLOBs (); // 评论
						eva.setAddtime (new Date ());
						eva.setEvaluate_goods (gc1.getGoods ());
						eva.setEvaluateGoodsId (gc1.getGoodsId ());
						eva.setEvaluateInfo (request.getParameter ("evaluate_info_" + cart.getId ()));
						eva.setEvaluateBuyerVal (CommUtil.null2Int (request.getParameter ("evaluate_buyer_val" + cart.getId ())));
						eva.setDescriptionEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("description_evaluate" + cart.getId ()))));
						eva.setServiceEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("service_evaluate" + cart.getId ()))));
						eva.setShipEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("ship_evaluate" + cart.getId ()))));
						eva.setEvaluateType ("goods");
						eva.setEvaluate_user (SecurityUserHolder.getCurrentUser ());
						eva.setOf (orderForm);
						eva.setGoodsSpec (gc1.getSpecInfo ());
						this.evaluateService.add (eva);
						List <EvaluateWithBLOBs> evas = this.evaluateService.selectByOfLeftJoinStoreId (orderForm.getStoreId ());
						double store_evaluate1 = 0.0D;
						double store_evaluate1_total = 0.0D;
						double description_evaluate = 0.0D;
						double description_evaluate_total = 0.0D;
						double service_evaluate = 0.0D;
						double service_evaluate_total = 0.0D;
						double ship_evaluate = 0.0D;
						double ship_evaluate_total = 0.0D;
						DecimalFormat df = new DecimalFormat ("0.0"); // df ?
						for (Evaluate eva1 : evas)
						{
							// 店铺总评论分
							store_evaluate1_total = store_evaluate1_total + eva1.getEvaluateBuyerVal ();
							// 商品描述总评论分
							description_evaluate_total = description_evaluate_total + CommUtil.null2Double (eva1.getDescriptionEvaluate ());
							// 服务总评论分
							service_evaluate_total = service_evaluate_total + CommUtil.null2Double (eva1.getServiceEvaluate ());
							// 物流总评论分
							ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double (eva1.getShipEvaluate ());
						}
						// 店铺评分 : 店铺总评论分 / 评论条数
						store_evaluate1 = CommUtil.null2Double (df.format (store_evaluate1_total / evas.size ()));
						// 商品评分: 总评论分 / 评论条数
						description_evaluate = CommUtil.null2Double (df.format (description_evaluate_total / evas.size ()));
						// 服务评分 : 服务总评论分 / 总评论数
						service_evaluate = CommUtil.null2Double (df.format (service_evaluate_total / evas.size ()));
						ship_evaluate = CommUtil.null2Double (df.format (ship_evaluate_total / evas.size ()));
						StoreWithBLOBs store = orderForm.getStore ();
						// 将用户评价的得分记入店铺总信用度
						store.setStoreCredit (store.getStoreCredit () + eva.getEvaluateBuyerVal ());
						this.storeService.updateByObject (store);
						StorePointExample storePointExample = new StorePointExample ();
						storePointExample.clear ();
						storePointExample.createCriteria ().andStoreIdEqualTo (store.getId ());
						List <StorePoint> sps = this.storePointService.getObjectList (storePointExample);
						StorePoint point = null;
						if (sps.size () > 0)
							point = (StorePoint) sps.get (0);
						else
						{
							point = new StorePoint ();
						}
						point.setAddtime (new Date ());
						point.setStore (store);
						point.setDescriptionEvaluate (BigDecimal.valueOf (description_evaluate));
						point.setServiceEvaluate (BigDecimal.valueOf (service_evaluate));
						point.setShipEvaluate (BigDecimal.valueOf (ship_evaluate));
						point.setStoreEvaluate1 (BigDecimal.valueOf (store_evaluate1));
						if (sps.size () > 0)
							this.storePointService.updateByObject (point);
						else
						{
							this.storePointService.add (point);
						}
						User user = orderForm.getUser ();
						/*user.setIntegral (user.getIntegral () + this.configService.getSysConfig ().getIndentcomment ());*/
						int count = this.userService.updateByObject (user);
						if (count > 0)
						{
							this.createIntegralLog ("用户评论商品增加" + this.configService.getSysConfig ().getIndentcomment () + "积分" , "evaluate" , this.configService.getSysConfig ().getIndentcomment ());
						}
					}
				}
			}
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "订单评价成功！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月15日 下午3:20:59
	 * @todo 删除订单信息
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "删除订单信息" , value = "/buyer/order_delete.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_delete.htm" })
	public String order_delete (HttpServletRequest request , HttpServletResponse response , String id , String currentPage) throws Exception
		{
			OrderForm obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if ((obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ())) && (obj.getOrderStatus () == 0))
			{
				/*
				 * for (GoodsCart gc : obj.getGcs()) { gc.getGsps().clear();
				 * this.goodsCartService.deleteByKey(gc.getId()); }
				 */
				Long ciId = obj.getCiId ();
				this.goodsCartService2.deleteByKey (ciId);
				this.orderFormService.deleteByKey (obj.getId ());
			}
			return "redirect:buyer_order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "买家物流详情" , value = "/buyer/ship_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_ship_view.htm" })
	@ResponseBody
	public String order_ship_view (HttpServletRequest request , HttpServletResponse response , String id , Long goodsId)
		{
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (id));
			Map <String, Object> map = new HashMap <> ();
			if (orderForm != null)
			{
				if (orderForm.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
				{
					map.put ("obj" , orderForm);
					// KuaiDiStatus kuaidiStatus =
					// this.kuaidiStatusService.getKuaiDiStatus(orderForm.getShipcode());
					String kuaidiNum = "";
					ExpressCompany ec = null;
					if (!goodsId.equals (0L))
					{
						RefundGoods rg = this.refundGoodsService.getObjectByOrderIdAndGooodsId (Long.valueOf (id) , goodsId);
						kuaidiNum = rg.getKuaidiNum (); // 退货物流单号
						ec = this.expressCompayService.getByKey (rg.getKuaidiId ());
					}
					else
					{
						kuaidiNum = orderForm.getShipcode (); // 退货物流单号
						ec = orderForm.getEc ();
					}
					List <KuaiDiResultItem> item = this.kuaidiService.getKuaidiInfo (kuaidiNum);
					map.put ("transInfo" , item);
					// map.put("kuaidiStatus", kuaidiStatus);
					map.put ("expressCompany" , ec);
					map.put ("kuaidiNum" , kuaidiNum);
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

	@SecurityMapping(title = "买家申请退款" , value = "/buyer/order_refund.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/order_refund.htm" })
	public ModelAndView order_refund (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long goodsId)
		{
			ModelAndView mv = null;
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				/* 判断是否满足退货退款条件 */
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , goodsId);
				if (item.getOrderForm ().getOrderStatus () == 20)
				{
					mv = new JModelAndView ("buyer/buyer_return.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					List <RefundItem> refundItems = refundItemSerice.selectByExample (null);
					mv.addObject ("obj" , obj);
					mv.addObject ("orderFormItem" , item);
					mv.addObject ("refundMoney" , item.getGoodsPrice ().multiply (new BigDecimal (item.getGoodsCount ())));
					mv.addObject ("refundItems" , refundItems);
					mv.addObject ("currentPage" , currentPage);
				}
				else
				{
					if (item.getRefundServer () == Globals.REFUND_SERVER_TIME_0)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "该商品不可退款退货");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
					}
					else if (!isConformRefund (obj , item.getRefundServer ()))
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "超过退款退货时间，不可退款退货");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
					}
					else
					{
						mv = new JModelAndView ("buyer/buyer_return.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						List <RefundItem> refundItems = refundItemSerice.selectByExample (null);
						mv.addObject ("obj" , obj);
						mv.addObject ("orderFormItem" , item);
						mv.addObject ("refundMoney" , item.getGoodsPrice ().multiply (new BigDecimal (item.getGoodsCount ())));
						mv.addObject ("refundItems" , refundItems);
						mv.addObject ("currentPage" , currentPage);
					}
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家退款保存" , value = "/buyer/order_refund_save.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/order_refund_save.htm" })
	public String order_refund_save (HttpServletRequest request , HttpServletResponse response , Long id , String currentPage , String refundType , String refund , String refundLog , String goodsId , String imgPaths)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (id);
			if (obj.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				/* 检查是否以前申请过被拒绝了，有就直接覆盖 */
				RefundExample example = new RefundExample ();
				example.createCriteria ().andOfIdEqualTo (obj.getId ());
				List <Refund> list = this.RefundService.getObjectList (example);
				Refund refunds = null;
				if (list.size () == 0)
				{
					refunds = new Refund ();
				}
				else
				{
					refunds = list.get (0);
					// 新代码
					RefundExample exRefundExample = new RefundExample ();
					exRefundExample.createCriteria ().andOfIdEqualTo (refunds.getOfId ());
					RefundService.deleteByExample (exRefundExample);
				}
				refunds.setRefundType (refundType);
				refunds.setRefund (new BigDecimal (refund));
				refunds.setRefundLog (refundLog);
				refunds.setGoodsId (Long.valueOf (goodsId));
				refunds.setAddtime (new Date ());
				refunds.setImgPaths (imgPaths);
				refunds.setDeletestatus (false);
				refunds.setStatus (Globals.HAVE_RECEIVED_MOENY);
				refunds.setOfId (obj.getId ());
				refunds.setRefundUserId (obj.getUser ().getId ());
				this.RefundService.add (refunds);  // 添加退款记录
				obj.setRefundId (refunds.getId ());
				this.orderFormService.updateByObject (obj);
				// 更新订单详细
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , refunds.getGoodsId ());
				item.setRefund (Globals.HAVE_RECEIVED_MOENY);
				this.orderFormItemService.updateByObject (item);
				this.createOrderLog (Globals.HAVE_RECEIVED_MOENY_NAME + ":" + refunds.getRefund () , String.valueOf (Globals.HAVE_RECEIVED_MOENY) , Long.valueOf (obj.getOrderId ()));
			}
			return "redirect:buyer_order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "买家申请退货" , value = "/buyer/buyer_retund_goods.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_return_goods.htm" })
	public ModelAndView buyer_return_goods (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long goodsId)
		{
			ModelAndView mv = null;
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj != null && obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				List <RefundItem> refundItems = refundItemSerice.selectByExample (null);
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , goodsId);
				/* 判断是否满足退货退款条件 */
				if (obj.getOrderStatus () == 20)
				{
					mv = new JModelAndView ("buyer/buyer_return_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("obj" , obj);
					mv.addObject ("refundItems" , refundItems);
					mv.addObject ("orderFormItem" , item);
					mv.addObject ("refundMoney" , item.getGoodsPrice ().multiply (new BigDecimal (item.getGoodsCount ())));
					mv.addObject ("currentPage" , currentPage);
				}
				else
				{
					if (item.getRefundServer () == Globals.REFUND_SERVER_TIME_0)
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "该商品不可退款退货");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
					}
					else if (!isConformRefund (obj , item.getRefundServer ()))
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "超过退款退货时间，不可退款退货");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
					}
					else
					{
						mv = new JModelAndView ("buyer/buyer_return_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("obj" , obj);
						mv.addObject ("refundItems" , refundItems);
						mv.addObject ("orderFormItem" , item);
						mv.addObject ("refundMoney" , item.getGoodsPrice ().multiply (new BigDecimal (item.getGoodsCount ())));
						mv.addObject ("currentPage" , currentPage);
					}
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家退货申请保存" , value = "/buyer/buyer_return_goods_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_return_goods_save.htm" })
	public String order_return_apply (HttpServletRequest request , HttpServletResponse response , Long id , String currentPage , String refundType , String refundLog , String refund , String goodsId , String imgPaths)
		{
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (id);
			if (obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				RefundGoods refundGoods = new RefundGoods ();
				refundGoods.setRefundType (refundType);
				refundGoods.setRefund (new BigDecimal (refund));
				refundGoods.setRefundLog (refundLog);
				refundGoods.setGoodsId (Long.valueOf (goodsId));
				refundGoods.setAddtime (new Date ());
				refundGoods.setImgPaths (imgPaths);
				refundGoods.setAddtime (new Date ());
				refundGoods.setDeletestatus (false);
				refundGoods.setStatus (Globals.BUYER_APPLY_RETURN_GOOD);
				refundGoods.setOfId (Long.valueOf (id));
				refundGoods.setRefundUserId (SecurityUserHolder.getCurrentUser ().getId ());
				this.refundGoodsService.insert (refundGoods);  // 添加退货记录
				GoodsReturn goodsReturn = new GoodsReturn ();
				goodsReturn.setAddtime (new Date ());
				goodsReturn.setDeletestatus (false);
				goodsReturn.setOfId (Long.valueOf (id));
				Store store = this.storeService.getByKey (this.orderFormService.getByKey (CommUtil.null2Long (id)).getStoreId ());
				goodsReturn.setUserId (store.getUserId ());
				goodsReturn.setReturnInfo (refundLog);
				goodsReturn.setReturnId (CommUtil.null2String (refundGoods.getId ()));
				this.goodsReturnService.add (goodsReturn);
				// 更新订单详细
				OrderFormItem item = this.orderFormItemService.getObjectByOrderIdAndGoodsId (obj.getId () , refundGoods.getGoodsId ());
				item.setRefund (Globals.BUYER_APPLY_RETURN_GOOD);
				this.orderFormItemService.updateByObject (item);
				this.createOrderLog (Globals.BUYER_APPLY_RETURN_GOOD_NAME + ":" + refundGoods.getRefund () , String.valueOf (Globals.BUYER_APPLY_RETURN_GOOD) , Long.valueOf (obj.getOrderId ()));
			}
			return "redirect:buyer_order.htm?currentPage=" + currentPage;
		}

	/**
	 * 
	 * @todo T虚拟商品,废弃
	 * @author wsw
	 * @date 2015年7月11日 下午3:39:36
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "虚拟商品信息" , value = "/buyer/order_seller_intro.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_seller_intro.htm" })
	public ModelAndView order_seller_intro (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_order_seller_intro.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderForm obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (obj.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv.addObject ("obj" , obj);
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

	// 生成积分日志
	private void createIntegralLog (String content , String type , int integral)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			IntegralLog integralLog = new IntegralLog ();
			integralLog.setAddtime (new Date ());
			integralLog.setContent (content);
			integralLog.setIntegral (integral);
			integralLog.setType (type);
			integralLog.setDeletestatus (false);
			integralLog.setIntegralUserId (user.getId ());
			this.integralLogService.add (integralLog);
		}

	@SecurityMapping(title = "买家订单详情" , value = "buyer/order_view.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "buyer/order_view.htm" })
	public ModelAndView order_view (HttpServletRequest request , HttpServletResponse response , String id , String type)
		{
			ModelAndView mv = new JModelAndView ("order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs obj = this.orderFormService.getByKey (CommUtil.null2Long (id));
			// 操作日志
			OrderFormLogExample orderFormLogExample = new OrderFormLogExample ();
			orderFormLogExample.clear ();
			orderFormLogExample.createCriteria ().andOfIdEqualTo (Long.valueOf (obj.getOrderId ()));
			List <OrderFormLog> orderFormLogs = this.orderFormLogService.getObjectList (orderFormLogExample);
			mv.addObject ("ofls" , orderFormLogs);
			// 订单商品
			Cart cart = this.cartService.getByKey (obj.getCiId ());
			CartDetailExample cartDetailExample = new CartDetailExample ();
			cartDetailExample.clear ();
			CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
			cartDetailCriteria.andCartIdEqualTo (cart.getId ());
			List <CartDetail> tempList = new ArrayList <> ();
			List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
			for (CartDetail cartDetail : cartDetailList)
			{
				if (cartDetail.getSpecId () != null && !cartDetail.getSpecId ().equals (""))
				{
					String [ ] specIds = cartDetail.getSpecId ().split (",");
					List <GoodsProperty> list = new ArrayList <GoodsProperty> ();
					for (String specId : specIds)
					{
						GoodsProperty goodsProperty = this.goodsPropertyService.selectByPrimaryKey (CommUtil.null2Long (specId));
						list.add (goodsProperty);
					}
					cartDetail.getProperties ().addAll (list);
				}
				if (cartDetail.getGoods ().getGoodsStoreId ().equals (obj.getStoreId ()))
				{
					tempList.add (cartDetail);
				}
			}
			cart.getCartDetailList ().addAll (tempList);
			mv.addObject ("cart" , cart);
			if (SecurityUserHolder.getCurrentUser ().getId ().equals (obj.getUserId ()))
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
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家退货物流信息" , value = "/buyer/order_return_ship.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_order_return_ship.htm" })
	public ModelAndView order_return_ship (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long goodsId)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_order_return_ship.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs orderFormWithBLOBs = this.orderFormService.getByKey (CommUtil.null2Long (id));
			if (orderFormWithBLOBs.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				ExpressCompanyExample companyExample = new ExpressCompanyExample ();
				companyExample.clear ();
				companyExample.setOrderByClause ("company_sequence asc");
				companyExample.createCriteria ().andCompanyStatusEqualTo (0);
				List <ExpressCompany> expressCompanys = expressCompayService.getObjectList (companyExample);
				mv.addObject ("obj" , orderFormWithBLOBs);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("goodsId" , goodsId);
				mv.addObject ("expressCompanys" , expressCompanys);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "买家退货物流信息保存" , value = "/buyer/order_return_ship_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/order_return_ship_save.htm" })
	public ModelAndView order_return_ship_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , Long ec_id , String return_shipCode , Long goodsId)
		{
			ModelAndView mv = new JModelAndView ("buyer/order_return_apply_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (id));
			ExpressCompany expressCompany = this.expressCompayService.getByKey (CommUtil.null2Long (ec_id));
			// 设置退货物流公司
			orderForm.setReturnShipcode (return_shipCode);
			orderForm.setReturnEcId (ec_id);
			orderForm.setReturnEc (expressCompany);
			this.orderFormService.updateByObject (orderForm);
			String toCityInfo = orderForm.getAddr ().getProvince () + orderForm.getAddr ().getCity () + orderForm.getAddr ().getArea () + orderForm.getAddr ().getAreaInfo ();
			JsonRequest req = new JsonRequest ();
			req.setCompany (expressCompany.getCompanyMark ());
			// req.setFrom("广东省东莞市");
			req.setTo (toCityInfo);
			req.setNumber (return_shipCode);
			String result = "";
			try
			{
				String ret = Kuaidi100HttpRequest.getInstance ().postData (req , CommUtil.getURL (request));
				JsonResponse resp = Json.fromJson (JsonResponse.class , ret);
				if (resp.getResult () == true)
				{
					result = "物流保存成功！";
					RefundGoods rg = this.refundGoodsService.getObjectByOrderIdAndGooodsId (CommUtil.null2Long (id) , CommUtil.null2Long (goodsId));
					rg.setKuaidiId (CommUtil.null2Long (ec_id));
					rg.setKuaidiNum (return_shipCode);
					this.refundGoodsService.updateByPrimaryKey (rg);
					KuaiDiResultItem item = new KuaiDiResultItem ();
					item.setKuaidinum (rg.getKuaidiNum ());
					item.setContext ("买家发货");
					item.setTime (CommUtil.formatLongDate (new Date ()));
					this.kuaidiService.save (item);
				}
				else
				{
					result = "物流保存失败，请检查信息是否正确";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			mv.addObject ("result" , result);
			return mv;
		}

	@SuppressWarnings("deprecation")
	private void send_email (HttpServletRequest request , OrderFormWithBLOBs order , String mark) throws Exception
		{
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templates = this.templateService.getObjectList (templateExample);
			Template template = null;
			if (templates != null && templates.size () > 0)
			{
				template = templates.get (0);
			}
			if (template != null && template.getOpen ())
			{
				String email = order.getStore ().getUser ().getEmail ();
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andIdEqualTo (order.getStoreId ());
				List <StoreWithBLOBs> storeWithBLOBs = this.storeService.getObjectList (storeExample);
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andStoreIdEqualTo (storeWithBLOBs.get (0).getId ());
				List <User> users = this.userService.getObjectList (userExample);
				String eamil = users.get (0).getEmail ();
				String subject = template.getTitle ();
				String path = this.configService.getSysConfig ().getUploadRootPath () + "/vm/";
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
				this.msgTools.sendEmail (email , subject , content);
			}
		}

	/**
	 * 
	 * @todo 团购订单
	 * @author wsw
	 * @date 2015年7月1日 下午1:53:07
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param user_id
	 * @return
	 */
	@RequestMapping({ "/buyer/group_order.htm" })
	public ModelAndView group_order (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("/buyer/group_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			// 当团购中添加一个商品,生成订单之后,会直接在该订单中添加该团购的主键id作为外键来索引
			if (user != null)
			{
				OrderFormExample orderFormExample = new OrderFormExample ();
				orderFormExample.clear ();
				orderFormExample.createCriteria ().andUserIdEqualTo (user.getId ()).andGroupIdIsNotNull ();
				orderFormExample.setOrderByClause ("addTime desc");
				orderFormExample.setPageSize (3);
				orderFormExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				Pagination pList = this.orderFormService.getObjectListWithPage (orderFormExample);
				List <OrderFormWithBLOBs> orders = this.orderFormService.getObjectList (orderFormExample);
				List <OrderFormWithBLOBs> os = new ArrayList <OrderFormWithBLOBs> ();
				int count = Pagination.cpn (CommUtil.null2Int (currentPage)) * orderFormExample.getPageSize ();
				int num = (count > orders.size ()) ? orders.size () : count;
				for (int i = (count - orderFormExample.getPageSize ()) ; i < num ; i++)
				{
					os.add (orders.get (i));
				}
				pList.setList (os);
				mv.addObject ("objs" , pList.getList ());
				mv.addObject ("totalPages" , pList.getTotalPage ());
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
				{
					url = CommUtil.getURL (request);
				}
				mv.addObject ("currentPage" , currentPage);
				String Ajax_url = url + "/buyer/group_order.htm";
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (Ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			}
			return mv;
		}

	/**
	 * 
	 * @todo 用户订单取消记录
	 * @author wsw
	 * @date 2015年7月1日 下午4:12:38
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/buyer/order_cancel_record.htm" })
	public ModelAndView order_cancel_record (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/order_cancel_record.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				OrderFormExample orderFormExample = new OrderFormExample ();
				orderFormExample.clear ();
				orderFormExample.setPageSize (3);
				orderFormExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				orderFormExample.setOrderByClause ("addTime desc");
				orderFormExample.createCriteria ().andOrderStatusEqualTo (Integer.valueOf (0)).andUserIdEqualTo (user.getId ());
				Pagination pList = this.orderFormService.getObjectListWithPage (orderFormExample);
				List <OrderFormWithBLOBs> orderForms = this.orderFormService.getObjectList (orderFormExample);
				for (OrderFormWithBLOBs orderForm : orderForms)
				{
					OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
					orderFormItemExample.clear ();
					orderFormItemExample.createCriteria ().andOrderIdEqualTo (orderForm.getId ());
					List <OrderFormItem> orderFormItems = this.orderFormItemService.getObjectList (orderFormItemExample);
					orderForm.setItems (orderFormItems);
				}
				pList.setList (orderForms);
				pList.setTotalCount (orderForms.size ());
				int count = Pagination.cpn (CommUtil.null2Int (currentPage)) * orderFormExample.getPageSize ();
				int num = (count > orderForms.size ()) ? orderForms.size () : count;
				List <OrderFormWithBLOBs> os = new ArrayList <OrderFormWithBLOBs> ();
				for (int i = (count - orderFormExample.getPageSize ()) ; i < num ; i++)
				{
					os.add (orderForms.get (i));
				}
				pList.setList (os);
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
				{
					url = CommUtil.getURL (request);
				}
				String Ajax_url = url + "/buyer/order_cancel_record.htm";
				mv.addObject ("objs" , pList.getList ());
				mv.addObject ("totalPages" , pList.getTotalPage ());
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (Ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			}
			return mv;
		}

	@SuppressWarnings("deprecation")
	private void send_sms (HttpServletRequest request , OrderForm order , String mobile , String mark) throws Exception
		{
			// this.templateService.getObjByProperty("mark", mark);
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templates = this.templateService.getObjectList (templateExample);
			Template template = null;
			if (templates != null && templates.size () > 0)
			{
				template = templates.get (0);
			}
			if (template != null && template.getOpen ())
			{
				String path = this.configService.getSysConfig ().getUploadRootPath () + "/vm/";
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
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andIdEqualTo (order.getUserId ());
				List <User> users = this.userService.getObjectList (userExample);
				User user = null;
				if (users != null && users.size () > 0)
				{
					user = users.get (0);
				}
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andIdEqualTo (order.getStoreId ());
				List <StoreWithBLOBs> stores = this.storeService.getObjectList (storeExample);
				Store store = null;
				if (stores != null && stores.size () > 0)
				{
					store = stores.get (0);
				}
				userExample.clear ();
				userExample.createCriteria ().andStoreIdEqualTo (store.getId ());
				List <User> sellers = this.userService.getObjectList (userExample);
				User seller = new User ();
				if (sellers != null && sellers.size () > 0)
				{
					seller = sellers.get (0);
				}
				context.put ("buyer" , user);
				context.put ("seller" , seller);
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

	/**
	 * 
	 * @author xpy
	 * @date 2015年8月28日 下午2:48:40
	 * @todo 买家评价
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/buyer/buyer_orderComment.htm" })
	public ModelAndView buyer_orderComment (HttpServletRequest request , HttpServletResponse response , String orderId , String goodsId , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_orderComment.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 获取评价商品
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			// 货架商品所在的订单
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (orderId));
			// 当用户存在此订单的时候，才可以评价
			if (orderForm.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv.addObject ("goods" , goods);
				mv.addObject ("orderForm" , orderForm);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + orderId + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm?currentPage=" + currentPage);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/buyer_orderCommentSave.htm" })
	public ModelAndView buyer_orderCommentSave (HttpServletRequest request , HttpServletResponse response , String orderId , String goodsId) throws Exception
		{
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (orderId));
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			EvaluateExample evaluateExample = new EvaluateExample ();
			evaluateExample.createCriteria ().andOfIdEqualTo (CommUtil.null2Long (orderId)).andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId));
			Integer evaCount = evaluateService.getObjectListCount (evaluateExample);
			if (evaCount > 0)
			{
				ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "不能重复评价！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
				return mv;
			}
			// 当用户拥有此订单的时候才可以评价
			if (orderForm.getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				// 已收货但是还没有评价
				if (orderForm.getOrderStatus () == 40)
				{
					EvaluateWithBLOBs eva = new EvaluateWithBLOBs ();
					eva.setAddtime (new Date ());
					eva.setEvaluateGoodsId (CommUtil.null2Long (goodsId));
					eva.setEvaluate_goods (goods);
					eva.setEvaluateInfo (request.getParameter ("evaluate_info"));
					eva.setEvaluateBuyerVal (CommUtil.null2Int (request.getParameter ("evaluate_buyer_val")));
					eva.setDescriptionEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("description_evaluate"))));
					eva.setServiceEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("service_evaluate"))));
					eva.setShipEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("ship_evaluate"))));
					eva.setEvaluateType ("goods");
					eva.setOf (orderForm);
					eva.setEvaluateUserId (SecurityUserHolder.getCurrentUser ().getId ());
					eva.setEvaluate_user (SecurityUserHolder.getCurrentUser ());
					eva.setEvaluateSellerUserId (goods.getGoodsStore ().getUserId ());
					eva.setEvaluate_seller_user (goods.getGoodsStore ().getUser ());
					// 设置评价商品的规格
					OrderFormItem orderFornItem = this.orderFormItemService.getObjectByOrderIdAndGoodsId (CommUtil.null2Long (orderId) , CommUtil.null2Long (goodsId));
					eva.setGoodsSpec (orderFornItem.getSpecInfo ());
					// 设置评价的图片
					String [ ] imgIds = request.getParameter ("imgIds").split (",");
					if (imgIds.length == 1)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
					}
					if (imgIds.length == 2)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
						eva.setImg2id (CommUtil.null2Long (imgIds[1]));
						eva.setImg2 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[1])));
					}
					if (imgIds.length == 3)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
						eva.setImg2id (CommUtil.null2Long (imgIds[1]));
						eva.setImg2 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[1])));
						eva.setImg3id (CommUtil.null2Long (imgIds[2]));
						eva.setImg3 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[2])));
					}
					// 新增商品评价
					this.evaluateService.add (eva);
					// 评价完之后，更新该商品状态为已评价
					orderFornItem.setItemStatus (true);
					this.orderFormItemService.updateByObject (orderFornItem);
					List <EvaluateWithBLOBs> evas = this.evaluateService.selectByOfLeftJoinStoreId (orderForm.getStoreId ());
					double store_evaluate1 = 0.0D;
					double store_evaluate1_total = 0.0D;
					double description_evaluate = 0.0D;
					double description_evaluate_total = 0.0D;
					double service_evaluate = 0.0D;
					double service_evaluate_total = 0.0D;
					double ship_evaluate = 0.0D;
					double ship_evaluate_total = 0.0D;
					DecimalFormat df = new DecimalFormat ("0.0");
					for (Evaluate eva1 : evas)
					{
						// 店铺总评论分
						store_evaluate1_total = store_evaluate1_total + eva1.getEvaluateBuyerVal ();
						// 商品描述总评论分
						description_evaluate_total = description_evaluate_total + CommUtil.null2Double (eva1.getDescriptionEvaluate ());
						// 服务总评论分
						service_evaluate_total = service_evaluate_total + CommUtil.null2Double (eva1.getServiceEvaluate ());
						// 物流总评论分
						ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double (eva1.getShipEvaluate ());
					}
					// 店铺评分 : 店铺总评论分 / 评论条数
					store_evaluate1 = CommUtil.null2Double (df.format (store_evaluate1_total));
					// 商品评分: 总评论分 / 评论条数
					description_evaluate = CommUtil.null2Double (df.format (description_evaluate_total / evas.size ()));
					// 服务评分 : 服务总评论分 / 总评论数
					service_evaluate = CommUtil.null2Double (df.format (service_evaluate_total / evas.size ()));
					ship_evaluate = CommUtil.null2Double (df.format (ship_evaluate_total / evas.size ()));
					StoreWithBLOBs store = this.storeService.getByKey (goods.getGoodsStoreId ());
					// 将用户评价的得分记入店铺总信用度
					store.setStoreCredit (store.getStoreCredit () + eva.getEvaluateBuyerVal ());
					// this.storeService.updateByObject(store);
					StorePointExample storePointExample = new StorePointExample ();
					storePointExample.clear ();
					storePointExample.createCriteria ().andStoreIdEqualTo (store.getId ());
					List <StorePoint> sps = this.storePointService.getObjectList (storePointExample);
					StorePoint point = null;
					if (sps.size () > 0)
						point = (StorePoint) sps.get (0);
					else
					{
						point = new StorePoint ();
					}
					point.setAddtime (new Date ());
					point.setStore (store);
					point.setStoreId (store.getId ());
					point.setDescriptionEvaluate (BigDecimal.valueOf (description_evaluate));
					point.setServiceEvaluate (BigDecimal.valueOf (service_evaluate));
					point.setShipEvaluate (BigDecimal.valueOf (ship_evaluate));
					point.setStoreEvaluate1 (BigDecimal.valueOf (store_evaluate1));
					if (sps.size () > 0)
						this.storePointService.updateByObject (point);
					else
					{
						this.storePointService.add (point);
					}
					store.setPointId (point.getId ());
					store.setPoint (point);
					this.storeService.updateByObject (store);
					User user = orderForm.getUser ();
					/*user.setIntegral (user.getIntegral () + this.configService.getSysConfig ().getIndentcomment ());*/
					this.userService.updateByObject (user);
					OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
					orderFormItemExample.createCriteria ().andOrderIdEqualTo (orderForm.getId ());
					List <OrderFormItem> items = orderFormItemService.getObjectList (orderFormItemExample);
					List <Boolean> itemStatuses = new ArrayList <Boolean> ();
					for (OrderFormItem item : items)
					{
						itemStatuses.add (item.getItemStatus ());
					}
					if (!itemStatuses.contains (false) && !itemStatuses.contains (null))
					{
						orderForm.setOrderStatus (Integer.valueOf (50));
						orderFormService.updateByObject (orderForm);
					}
				}
			}
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "评价成功！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
			return mv;
		}

	/**
	 * 
	 * @todo 评价图像上传
	 * @author wsw
	 * @date 2015年7月15日 上午9:49:17
	 * @return void
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/buyer/buyer_upload_evaluate.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String upload_evaluate (HttpServletRequest request , HttpServletResponse response , String width , String height , String isCheckWithHeight) throws IOException
		{
			User user = SecurityUserHolder.getCurrentUser ();
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "evaluate";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imgId = "";
			String imagePath = "";
			Accessory eva_img = new Accessory ();
			int reqIsCheckWithHeight = CommUtil.null2Int (isCheckWithHeight);
			if (reqIsCheckWithHeight > Globals.NUBER_ZERO)
			{
				int reqWidth = CommUtil.null2Int (width);
				int reqHeight = CommUtil.null2Int (height);
				int mapWidth = CommUtil.null2Int (map.get ("width"));
				int mapHeight = CommUtil.null2Int (map.get ("height"));
				if ((Math.abs (reqWidth - mapWidth) == 0) && ((Math.abs (reqHeight - mapHeight) == 0)))
				{
					if (!map.get ("fileName").equals (""))
					{
						eva_img.setName (CommUtil.null2String (map.get ("fileName")));
						eva_img.setExt (CommUtil.null2String (map.get ("mime")));
						eva_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						eva_img.setPath (uploadFilePath + "/evaluate");
						eva_img.setWidth (CommUtil.null2Int (map.get ("width")));
						eva_img.setHeight (CommUtil.null2Int (map.get ("height")));
						eva_img.setAddtime (new Date ());
						eva_img.setUserId (user.getId ());
						this.accessoryService.add (eva_img);
						imgId = String.valueOf (eva_img.getId ());
						imagePath = String.valueOf (this.configService.getSysConfig ().getImagewebserver () + "/" + eva_img.getPath () + "/" + eva_img.getName ());
					}
					response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imgId + "\",\"imagePath\":\"" + imagePath + "\"}";
					return response_rs;
				}
				else
				{
					imgId = String.valueOf (0);
					response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imgId + "\"}";
					return response_rs;
				}
			}
			else
			{
				if (!map.get ("fileName").equals (""))
				{
					eva_img.setName (CommUtil.null2String (map.get ("fileName")));
					eva_img.setExt (CommUtil.null2String (map.get ("mime")));
					eva_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
					eva_img.setPath (uploadFilePath + "/evaluate");
					eva_img.setWidth (CommUtil.null2Int (map.get ("width")));
					eva_img.setHeight (CommUtil.null2Int (map.get ("height")));
					eva_img.setAddtime (new Date ());
					eva_img.setUserId (user.getId ());
					this.accessoryService.add (eva_img);
					imgId = String.valueOf (eva_img.getId ());
					imagePath = String.valueOf (this.configService.getSysConfig ().getImagewebserver () + "/" + eva_img.getPath () + "/" + eva_img.getName ());
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imgId + "\",\"imagePath\":\"" + imagePath + "\"}";
				return response_rs;
			}
		}

	/**
	 * 
	 * @todo 买家退款图像上传
	 * @author xpy
	 * @date 2015年9月16日 下午15:15:47
	 * @return void
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/buyer/buyer_upload_return.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String upload_return (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			User user = SecurityUserHolder.getCurrentUser ();
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "refund";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imgId = "";
			String imagePath = "";
			Accessory return_img = new Accessory ();
			if (fileName.equals (""))
			{
				if (!map.get ("fileName").equals (""))
				{
					return_img.setName (CommUtil.null2String (map.get ("fileName")));
					return_img.setExt (CommUtil.null2String (map.get ("mime")));
					return_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
					return_img.setPath (uploadFilePath + "/refund");
					return_img.setWidth (CommUtil.null2Int (map.get ("width")));
					return_img.setHeight (CommUtil.null2Int (map.get ("height")));
					return_img.setAddtime (new Date ());
					return_img.setUserId (user.getId ());
					this.accessoryService.add (return_img);
					imgId = String.valueOf (return_img.getId ());
					imagePath = String.valueOf (this.configService.getSysConfig ().getImagewebserver () + "/" + return_img.getPath () + "/" + return_img.getName ());
				}
			}
			response_rs = imgId + "," + imagePath;
			return response_rs;
		}

	@RequestMapping(value = "/buyer/buyer_return_goods_delImg.htm")
	public void delete_return (HttpServletRequest request , HttpServletResponse response , String imgId) throws IOException
		{
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			Accessory img = this.accessoryService.getByKey (CommUtil.null2Long (imgId));
			Integer ret = this.accessoryService.deleteByKey (img.getId ());
			if (ret > 0)
			{
				CommUtil.del_acc (request , img , this.configService.getSysConfig ().getUploadRootPath ());
			}
			PrintWriter writer = response.getWriter ();
			writer.print (ret);
		}

	@RequestMapping({ "/query_order_status.htm" })
	@ResponseBody
	public String query_order_status (HttpServletRequest request , HttpServletResponse response , String payId)
		{
			AlipayOrder alipayOrder = this.alipayOrderService.getByKey (Long.valueOf (payId));
			if (alipayOrder != null && alipayOrder.getTxnTime () != null)
			{
				return payId;
			}
			else
			{
				return "";
			}
		}

	@RequestMapping({ "/order_pay_success.htm" })
	public ModelAndView order_pay_success (HttpServletRequest request , HttpServletResponse response , String id , String payId)
		{
			ModelAndView mv = null;
			AlipayOrder alipayOrder = this.alipayOrderService.getByKey (Long.valueOf (payId));
			mv = new JModelAndView ("order_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("payment" , alipayOrder.getTotalFee ());
			return mv;
		}

	/**
	 * @Title: isConformRefund
	 * @Description: 判断商品是否符合退货退款要求
	 * @param obj
	 * @param state
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月19日
	 */
	private boolean isConformRefund (OrderFormWithBLOBs obj , Integer state)
		{
			Date nowDate = new Date ();
			Date orderDate = obj.getFinishtime ();
			Integer days = CommUtil.isContainTime (nowDate , orderDate);
			switch (state)
			{
			/*
			 * case Globals.REFUND_SERVER_TIME_0:
			 * return false;
			 */
				case Globals.REFUND_SERVER_TIME_7 :
					if (days >= Globals.WEEK)
						return false;
				case Globals.REFUND_SERVER_TIME_15 :
					if (days >= Globals.HALF_MONTH)
						return false;
				case Globals.REFUND_SERVER_TIME_30 :
					if (days >= Globals.MONTH)
						return false;
				default :
					break;
			}
			/* 未发货或者已经收货才能申请退货 */
			if (obj.getOrderStatus () == Globals.HAVE_PAYMENT || obj.getOrderStatus () == Globals.HAVE_RECEIVED_GOOD || obj.getOrderStatus () == Globals.COMPLETED_AND_EVALUATED)
			{
				return true;
			}
			return false;
		}
}
