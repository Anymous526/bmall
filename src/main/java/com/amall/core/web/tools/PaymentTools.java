package com.amall.core.web.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.user.IUserService;

/**
 * 
 * <p>Title: PaymentTools</p>
 * <p>Description: 支付工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午4:01:29
 * @version 1.0
 */
@Component
public class PaymentTools {

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IUserService userService;

	public boolean queryPayment(String mark, String type) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andMarkEqualTo(mark).andTypeEqualTo(type);
		
		Map params = new HashMap();
		params.put("mark", mark);
		params.put("type", type);
		List objs = this.paymentService.getObjectList(example);
		if (objs.size() > 0) {
			return ((PaymentWithBLOBs) objs.get(0)).getInstall();
		}
		return false;
	}

	public Map queryPayment(String mark) {
		Long store_id = null;
		store_id = this.userService
				.getByKey(SecurityUserHolder.getCurrentUser().getId())
				.getStoreId();
		PaymentExample paymentexample = new PaymentExample();
		paymentexample.createCriteria().andMarkEqualTo(mark).andTypeEqualTo("user")
				.andStoreIdEqualTo(store_id);
		
		List<PaymentWithBLOBs> objs = this.paymentService.getObjectList(paymentexample);
		/*		.query("select obj from Payment obj where obj.mark=:mark and obj.type=:type and obj.store.id=:store_id",
						params, -1, -1);*/
		Map ret = new HashMap();
		if (objs.size() == 1) {
			ret.put("install",
					Boolean.valueOf(((PaymentWithBLOBs) objs.get(0)).getInstall()));
			ret.put("already", Boolean.valueOf(true));
			
			//PaymentWithBLOBs payment = objs.get(0);
			
		} else {
			ret.put("install", Boolean.valueOf(false));
			ret.put("already", Boolean.valueOf(false));
		}
		return ret;
	}

	public Map queryStorePayment(String mark, String store_id) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andMarkEqualTo(mark).andStoreIdEqualTo(Long.parseLong(store_id));
		
		Map ret = new HashMap();
		Map params = new HashMap();
		params.put("mark", mark);
		params.put("store_id", CommUtil.null2Long(store_id));
		List objs = this.paymentService.getObjectList(example);
				/*.query("select obj from Payment obj where obj.mark=:mark and obj.store.id=:store_id",
						params, -1, -1);*/
		if (objs.size() == 1) {
			ret.put("install",
					Boolean.valueOf(((PaymentWithBLOBs) objs.get(0)).getInstall()));
			ret.put("content", ((PaymentWithBLOBs) objs.get(0)).getContent());
		} else {
			ret.put("install", Boolean.valueOf(false));
			ret.put("content", "");
		}
		return ret;
	}

	public Map queryShopPayment(String mark) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andMarkEqualTo(mark).andTypeEqualTo("admin");
		List<PaymentWithBLOBs> objs = paymentService.getObjectList(example);
		
		Map ret = new HashMap();
		
		/*Map params = new HashMap();
		params.put("mark", mark);
		params.put("type", "admin");
		List objs = this.paymentService
				.query("select obj from Payment obj where obj.mark=:mark and obj.type=:type",
						params, -1, -1);*/
		if (objs.size() == 1) {
			ret.put("install",
					Boolean.valueOf(((PaymentWithBLOBs) objs.get(0)).getInstall()));
			ret.put("content", ((PaymentWithBLOBs) objs.get(0)).getContent());
		} else {
			ret.put("install", Boolean.valueOf(false));
			ret.put("content", "");
		}
		return ret;
	}
}
