package com.amall.core.action.seller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.PaymentTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: PaymentSellerAction
 * </p>
 * <p>
 * Description: 卖家选择的支付方式管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月17日下午7:13:28
 * @version 1.0
 */
@Controller
public class PaymentSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IUserService userService;

	@Autowired
	private PaymentTools paymentTools;

	@SecurityMapping(title = "支付方式列表" , value = "/seller/payment.htm*" , rtype = "seller" , rname = "支付方式" ,
						rcode = "payment_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/payment.htm" })
	public ModelAndView payment (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/payment.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String store_payment = this.configService.getSysConfig ().getStorePayment ();
			if ((store_payment != null) && (!store_payment.equals ("")))
			{
				Map map = (Map) Json.fromJson (HashMap.class , store_payment);
				mv.addObject ("map" , map);
				mv.addObject ("paymentTools" , this.paymentTools);
			}
			return mv;
		}

	@SecurityMapping(title = "支付方式安装" , value = "/seller/payment_install.htm*" , rtype = "seller" , rname = "支付方式" ,
						rcode = "payment_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/payment_install.htm" })
	public ModelAndView payment_install (HttpServletRequest request , HttpServletResponse response , String mark)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/payment/" + mark + ".html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if ((mark != null) && (!mark.equals ("")))
			{
				PaymentExample paymentExample = new PaymentExample ();
				paymentExample.clear ();
				paymentExample.createCriteria ().andMarkEqualTo (mark).andStoreIdEqualTo (user.getStore ().getId ());
				List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
				if (objs.size () > 0)
				{
					mv.addObject ("obj" , objs.get (0));
				}
			}
			return mv;
		}

	@SecurityMapping(title = "支付方式卸载" , value = "/seller/payment_uninstall.htm*" , rtype = "seller" , rname = "支付方式" ,
						rcode = "payment_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/payment_uninstall.htm" })
	public ModelAndView payment_uninstall (HttpServletRequest request , HttpServletResponse response , String mark)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			/*
			 * params.put("mark", mark); params.put("store_id",
			 * user.getStore().getId()); List objs = this.paymentService .query(
			 * "select obj from Payment obj where obj.mark=:mark and obj.store.id=:store_id"
			 * , params, -1, -1);
			 */
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (mark).andStoreIdEqualTo (user.getStore ().getId ());
			List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
			if (objs.size () > 0)
			{
				for (OrderFormWithBLOBs of : ((PaymentWithBLOBs) objs.get (0)).getOfs ())
				{
					of.setPayment (null);
					this.orderFormService.updateByObject (of);
				}
				this.paymentService.deleteByKey (((Payment) objs.get (0)).getId ());
			}
			mv.addObject ("op_title" , "支付方式卸载成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/payment.htm");
			return mv;
		}

	@SecurityMapping(title = "支付方式编辑" , value = "/seller/payment_edit.htm*" , rtype = "seller" , rname = "支付方式" ,
						rcode = "payment_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/payment_edit.htm" })
	public ModelAndView payment_edit (HttpServletRequest request , HttpServletResponse response , String mark)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/payment/" + mark + ".html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (mark).andStoreIdEqualTo (user.getStore ().getId ());
			List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
			if (objs.size () > 0)
				mv.addObject ("obj" , objs.get (0));
			return mv;
		}

	@SecurityMapping(title = "支付方式保存" , value = "/seller/payment_save.htm*" , rtype = "seller" , rname = "支付方式" ,
						rcode = "payment_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/payment_save.htm" })
	public ModelAndView payment_save (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			WebForm wf = new WebForm ();
			if (!id.equals (""))
			{
				Payment obj = this.paymentService.getByKey (CommUtil.null2Long (id));
				PaymentWithBLOBs payment = (PaymentWithBLOBs) wf.toPo (request , obj);
				this.paymentService.updateByObject (payment);
			}
			else
			{
				PaymentWithBLOBs payment = (PaymentWithBLOBs) wf.toPo (request , PaymentWithBLOBs.class);
				payment.setAddtime (new Date ());
				payment.setType ("user");
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				payment.setStoreId (user.getStoreId ());
				this.paymentService.add (payment);
			}
			mv.addObject ("op_title" , "支付方式保存成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/payment.htm");
			return mv;
		}
}
