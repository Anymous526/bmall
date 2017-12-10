package com.amall.core.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.PaymentTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 支付方式crud
 * 
 * @author ljx
 *
 */
@Controller
public class PaymentManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private PaymentTools paymentTools;

	@SecurityMapping(title = "支付方式列表" , value = "/admin/payment_list.htm*" , rtype = "admin" , rname = "支付方式" ,
						rcode = "payment_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/payment_list.htm" })
	public ModelAndView payment_list (HttpServletRequest request , HttpServletResponse response , String type)
		{
			ModelAndView mv = new JModelAndView ("admin/payment_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (CommUtil.null2String (type).equals ("user"))
				mv.addObject ("op" , "store");
			else
				mv.addObject ("op" , "platform");
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			String store_payment = CommUtil.null2String (config.getStorePayment ());
			Map <?, ?> map = (Map <?, ?>) Json.fromJson (HashMap.class , store_payment);
			if (map != null)
			{
				for (Iterator <?> it = map.keySet ().iterator () ; it.hasNext () ;)
				{
					String key = (String) it.next ();
					Object val = map.get (key);
					mv.addObject (key , val);
				}
			}
			mv.addObject ("paymentTools" , this.paymentTools);
			return mv;
		}

	@SecurityMapping(title = "支付方式设置" , value = "/admin/payment_set.htm*" , rtype = "admin" , rname = "支付方式" ,
						rcode = "payment_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/payment_set.htm" })
	public ModelAndView payment_set (HttpServletRequest request , HttpServletResponse response , String mark , String type , String pay , String configId)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (CommUtil.null2String (type).equals ("admin"))
			{
				PaymentExample paymentExample = new PaymentExample ();
				paymentExample.clear ();
				paymentExample.createCriteria ().andMarkEqualTo (mark).andTypeEqualTo (type);
				List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
				/*
				 * Map params = new HashMap();
				 * params.put("mark", mark);
				 * params.put("type", type);
				 * List objs = this.paymentService
				 * .query("select obj from Payment obj where obj.mark=:mark and obj.type=:type",
				 * params, -1, -1);
				 */
				PaymentWithBLOBs obj = null;
				if (objs.size () > 0)
					obj = (PaymentWithBLOBs) objs.get (0);
				else
					obj = new PaymentWithBLOBs ();
				obj.setAddtime (new Date ());
				obj.setMark (mark);
				obj.setInstall (!CommUtil.null2Boolean (pay));
				obj.setType (type);
				if (CommUtil.null2String (obj.getName ()).equals (""))
				{
					if (mark.trim ().equals ("alipay"))
					{
						obj.setName ("支付宝");
					}
					if (mark.trim ().equals ("balance"))
					{
						obj.setName ("预存款支付");
					}
					if (mark.trim ().equals ("outline"))
					{
						obj.setName ("线下支付");
					}
					if (mark.trim ().equals ("tenpay"))
					{
						obj.setName ("财付通");
					}
					if (mark.trim ().equals ("bill"))
					{
						obj.setName ("快钱支付");
					}
					if (mark.trim ().equals ("Unionpay"))
					{
						obj.setName ("银联在线");
					}
					if (mark.trim ().equals ("alipay_wap"))
					{
						obj.setName ("支付宝手机网页支付");
					}
				}
				if (objs.size () > 0)
					this.paymentService.updateByObject (obj);
				else
					this.paymentService.add (obj);
			}
			if (CommUtil.null2String (type).equals ("user"))
			{
				SysConfigWithBLOBs config = this.configService.getSysConfig ();
				String store_payment = CommUtil.null2String (config.getStorePayment ());
				@SuppressWarnings("unchecked")
				Map <String, Boolean> map = (Map <String, Boolean>) Json.fromJson (HashMap.class , store_payment);
				if (map == null)
					map = new HashMap <String, Boolean> ();
				map.put (mark , Boolean.valueOf (!CommUtil.null2Boolean (pay)));
				store_payment = Json.toJson (map , JsonFormat.compact ());
				config.setStorePayment (store_payment);
				if (!CommUtil.null2String (configId).equals (""))
					this.configService.updateByObject (config);
				else
					this.configService.add (config);
			}
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/payment_list.htm?type=" + type);
			mv.addObject ("op_title" , "设置支付方式成功");
			mv.addObject ("paymentTools" , this.paymentTools);
			return mv;
		}

	@SecurityMapping(title = "支付方式编辑" , value = "/admin/payment_edit.htm*" , rtype = "admin" , rname = "支付方式" ,
						rcode = "payment_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/payment_edit.htm" })
	public ModelAndView payment_edit (HttpServletRequest request , HttpServletResponse response , String mark)
		{
			ModelAndView mv = new JModelAndView ("admin/payment_info.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (mark).andTypeEqualTo ("admin");
			List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
			Payment obj = null;
			if (objs.size () > 0)
			{
				obj = (Payment) objs.get (0);
			}
			else
			{
				obj = new Payment ();
				obj.setMark (mark);
			}
			mv.addObject ("obj" , obj);
			mv.addObject ("edit" , Boolean.valueOf (true));
			return mv;
		}

	@SecurityMapping(title = "支付方式保存" , value = "/admin/payment_save.htm*" , rtype = "admin" , rname = "支付方式" ,
						rcode = "payment_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/payment_save.htm" })
	public ModelAndView payment_save (HttpServletRequest request , HttpServletResponse response , String mark , String list_url)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (mark).andTypeEqualTo ("admin");
			List <PaymentWithBLOBs> objs = paymentService.getObjectList (paymentExample);
			PaymentWithBLOBs obj = null;
			if (objs.size () > 0)
			{
				Payment temp = (Payment) objs.get (0);
				WebForm wf = new WebForm ();
				obj = (PaymentWithBLOBs) wf.toPo (request , temp);
			}
			else
			{
				WebForm wf = new WebForm ();
				obj = (PaymentWithBLOBs) wf.toPo (request , PaymentWithBLOBs.class);
				obj.setAddtime (new Date ());
				obj.setType ("admin");
			}
			if (objs.size () > 0)
				this.paymentService.updateByObject (obj);
			else
			{
				this.paymentService.add (obj);
			}
			mv.addObject ("op_title" , "保存支付方式成功");
			mv.addObject ("list_url" , list_url);
			return mv;
		}

	@SecurityMapping(title = "平台支付方式设置" , value = "/admin/payment_config_set.htm*" , rtype = "admin" , rname = "支付方式" ,
						rcode = "payment_set" , rgroup = "设置" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/payment_config_set.htm" })
	public ModelAndView payment_config_set (HttpServletRequest request , HttpServletResponse response , String id , String configPaymentType)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfig obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs sysConfig = null;
			if (id.equals (""))
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , SysConfigWithBLOBs.class);
			else
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			sysConfig.setConfigPaymentType (CommUtil.null2Int (configPaymentType));
			if (id.equals (""))
				this.configService.add (sysConfig);
			else
			{
				this.configService.updateByObject (sysConfig);
			}
			mv.addObject ("op_title" , "设置统一支付成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/payment_list.htm");
			return mv;
		}
}
