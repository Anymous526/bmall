package com.amall.core.action.seller;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.pay.PayTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * @author tangxiang
 *         保证金缴纳
 */
@Controller
public class CashDepositAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private PayTools payTools;

	/**
	 * @Title: seller_cash_deposit
	 * @Description: 根据所开店铺级别缴纳保证金
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年9月7日 上午10:05:17
	 */
	@RequestMapping({ "/seller/seller_cash_deposit.htm" })
	public ModelAndView seller_cash_deposit (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_pay_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			/* 获取需要缴纳的保证金 */
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = this.storeService.getByKey (user.getStoreId ());
			user.setStore (store);
			String payment = store.getGrade ().getPrice ();
			mv.addObject ("user" , user);
			mv.addObject ("payment" , payment);
			mv.addObject ("orderId" , orderId);
			return mv;
		}

	/**
	 * @Title: seller_cash_deposit_pay
	 * @Description: 支付保证金
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年9月7日 上午10:41:31
	 */
	@RequestMapping({ "/seller/seller_cash_deposit_pay.htm" })
	public ModelAndView seller_cash_deposit_pay (HttpServletRequest request , HttpServletResponse response , String webbankpay)
		{
			ModelAndView mv = null;
			/* 生成一个订单号 */
			String orderId = CommUtil.generateOrderId ();
			/* 获取需要缴纳的保证金 */
			User user = SecurityUserHolder.getCurrentUser ();
			Store store = this.storeService.getByKey (user.getStoreId ());
			String payment = store.getGrade ().getPrice ();
			AlipayOrder order = new AlipayOrder ();
			order.setTotalFee (new BigDecimal (payment));
			order.setOrderId (orderId);
			order.setUserId (user.getId ());
			this.alipayOrderService.add (order);
			AlipayOrderExample example = new AlipayOrderExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			Long payId = this.alipayOrderService.getObjectList (example).get (Globals.NUBER_ZERO).getId ();
			/* 微信支付流程 */
			if ("WXPay".equals (webbankpay))
			{
				String pre_str = null;
				// 模式二
				pre_str = payTools.genericWXPay (CommUtil.getURL (request) , payId , "店铺保证金" , "goods");
				if (pre_str != null)
				{
					mv = new JModelAndView ("wx_pay_pre.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/* 不包含http表示订单号重复了 */
					if (pre_str.contains ("weixin"))
					{
						mv.addObject ("pre_str" , pre_str);
						mv.addObject ("payId" , payId);
					}
					else
					{
						mv.addObject ("message" , pre_str);
					}
				}
				return mv;
			}
			mv = new JModelAndView ("line_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("type" , "cash_deposit");
			mv.addObject ("payType" , webbankpay);
			mv.addObject ("url" , CommUtil.getURL (request));
			mv.addObject ("payTools" , this.payTools);
			mv.addObject ("alipayOrderId" , payId);
			return mv;
		}
}
