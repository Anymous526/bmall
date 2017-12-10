package com.amall.core.action.seller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsReturn;
import com.amall.core.bean.GoodsReturnExample;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IRefundService;
import com.amall.core.service.goods.IGoodsReturnItemService;
import com.amall.core.service.goods.IGoodsReturnService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class GoodsReturnSellerAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsReturnService goodsReturnService;

	@Autowired
	private IGoodsReturnItemService goodsReturnItemService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderFormService orderFormService;
	
	@Autowired
	private IOrderFormItemService orderFormItemService;
	
	@Autowired
	private IRefundService RefundService;

	@SecurityMapping(title = "卖家退货列表", value = "/seller/goods_return.htm*", rtype = "seller", rname = "退货管理", rcode = "goods_return_seller", rgroup = "客户服务", display = false, rsequence = 0)
	@RequestMapping({ "/seller/goods_return.htm" })
	public ModelAndView refund(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String data_type, String data, String beginTime, String endTime) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/goods_return.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		
		GoodsReturnExample goodsReturnExample = new GoodsReturnExample();
		goodsReturnExample.clear();
		goodsReturnExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		goodsReturnExample.setOrderByClause("addTime desc");
		goodsReturnExample.setPageSize(Integer.valueOf(30));
		GoodsReturnExample.Criteria goodsReturnCriteria = goodsReturnExample.createCriteria();
		
		if (!CommUtil.null2String(data).equals("")) {
			if (CommUtil.null2String(data_type).equals("order_id")) {
				/*qo.addQuery("obj.of.order_id", new SysMap("order_id", data),
						"=");*/
				OrderFormWithBLOBs orderForm = orderFormService.getByKey(Long.parseLong(data));
				goodsReturnCriteria.andOfIdEqualTo(orderForm.getId());
			}
			if (CommUtil.null2String(data_type).equals("buyer_name")) {
				/*qo.addQuery("obj.of.user.userName",
						new SysMap("userName", data), "=");*/
				UserExample userExample = new UserExample();
				userExample.clear();
				userExample.createCriteria().andUsernameEqualTo(data);
				List<User> users = userService.getObjectList(userExample);
				User user = null;
				if (users.size() >0 && users !=null)
					user = users.get(0);
				
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				orderFormExample.createCriteria().andUserIdEqualTo(user.getId());
				List<OrderFormWithBLOBs> ofs = orderFormService.getObjectList(orderFormExample);
				OrderFormWithBLOBs of = null;
				if(ofs.size()>0 && ofs !=null)
					of = ofs.get(0);
				
				goodsReturnCriteria.andOfIdEqualTo(of.getId());
			}
		}
		if (!CommUtil.null2String(beginTime).equals("")) {
			goodsReturnCriteria.andAddtimeGreaterThanOrEqualTo(CommUtil.formatDate(beginTime));
			
		}
		if (!CommUtil.null2String(endTime).equals("")) {
			
			goodsReturnCriteria.andAddtimeLessThanOrEqualTo(CommUtil.formatDate(endTime));
		}
		User user = SecurityUserHolder.getCurrentAdminUser();
		goodsReturnCriteria.andUserIdEqualTo(user.getId());
		Pagination pList = goodsReturnService.getObjectListWithPage(goodsReturnExample);
		
		for(Object O : pList.getList()){
			GoodsReturn gr = (GoodsReturn)O;
			OrderFormWithBLOBs of = this.orderFormService.getByKey(gr.getOfId());
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample();
			orderFormItemExample.clear();
			orderFormItemExample.createCriteria().andOrderIdEqualTo(of.getId());
			List<OrderFormItem> oftList = this.orderFormItemService.getObjectList(orderFormItemExample);
			of.getItems().addAll(oftList);
			gr.setOf(of);
		}
		
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		CommUtil.addIPageList2ModelAndView(url+"/seller/goods_return.htm", "", "", pList, mv);
		mv.addObject("data_type", data_type);
		mv.addObject("data", data);
		mv.addObject("beginTime", beginTime);
		mv.addObject("endTime", endTime);
		return mv;
	}

	@SecurityMapping(title = "卖家查看退货详情", value = "/seller/return_view.htm*", rtype = "seller", rname = "退货管理", rcode = "goods_return_seller", rgroup = "客户服务", display = false, rsequence = 0)
	@RequestMapping({ "/seller/goods_return_view.htm" })
	public ModelAndView goods_return_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/goods_return_view.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		
		GoodsReturn obj = this.goodsReturnService.getByKey(CommUtil
				.null2Long(id));
		OrderFormWithBLOBs of = this.orderFormService.getByKey(obj.getOfId());
		OrderFormItemExample orderFormItemExample = new OrderFormItemExample();
		orderFormItemExample.clear();
		orderFormItemExample.createCriteria().andOrderIdEqualTo(of.getId());
		List<OrderFormItem> ofList = this.orderFormItemService.getObjectList(orderFormItemExample);
		of.getItems().addAll(ofList);
		obj.setOfId(of.getId());
		obj.setOf(of);
		mv.addObject("obj", obj);
		return mv;
	}
	
	@SecurityMapping(title = "卖家退款列表", value = "/seller/return_view.htm*", rtype = "seller", rname = "退货管理", rcode = "goods_return_seller", rgroup = "客户服务", display = false, rsequence = 0)
	@RequestMapping({ "/seller/return_view.htm" })
	public ModelAndView return_view(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String data_type, String data, String beginTime, String endTime) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/money_return.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		
		RefundExample refundExample = new RefundExample();
		refundExample.clear();
		refundExample.setOrderByClause("addTime desc");
		refundExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		refundExample.setPageSize(Integer.valueOf(30));
		
		RefundExample.Criteria refundCriteria = refundExample.createCriteria();
		if(!CommUtil.null2String(data).equals("")){
			if (CommUtil.null2String(data_type).equals("order_id")) {
				OrderFormWithBLOBs orderForm = orderFormService.getByKey(Long.parseLong(data));
				refundCriteria.andOfIdEqualTo(orderForm.getId());
			}
			if (CommUtil.null2String(data_type).equals("buyer_name")) {
				UserExample userExample = new UserExample();
				userExample.clear();
				userExample.createCriteria().andUsernameEqualTo(data);
				List<User> users = userService.getObjectList(userExample);
				User user = null;
				if (users.size() >0 && users !=null)
					user = users.get(0);
					
				OrderFormExample orderFormExample = new OrderFormExample();
				orderFormExample.clear();
				orderFormExample.createCriteria().andUserIdEqualTo(user.getId());
				List<OrderFormWithBLOBs> ofs = orderFormService.getObjectList(orderFormExample);
				OrderFormWithBLOBs of = null;
				if(ofs.size()>0 && ofs !=null)
					of = ofs.get(0);
				refundCriteria.andOfIdEqualTo(of.getId());
			}
		}
		if (!CommUtil.null2String(beginTime).equals("")) {
			refundCriteria.andAddtimeGreaterThanOrEqualTo(CommUtil.formatDate(beginTime));
			
		}
		if (!CommUtil.null2String(endTime).equals("")) {
			refundCriteria.andAddtimeLessThanOrEqualTo(CommUtil.formatDate(endTime));
		}
		
		User user = SecurityUserHolder.getCurrentAdminUser();
		refundCriteria.andRefundUserIdEqualTo(user.getId());
		Pagination pList = this.RefundService.getObjectListWithPage(refundExample);
		
		for(Object O : pList.getList()){
			Refund refund = (Refund)O;
			OrderFormWithBLOBs of = this.orderFormService.getByKey(refund.getOfId());
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample();
			orderFormItemExample.clear();
			orderFormItemExample.createCriteria().andOrderIdEqualTo(of.getId());
			List<OrderFormItem> oftList = this.orderFormItemService.getObjectList(orderFormItemExample);
			of.getItems().addAll(oftList);
			refund.setOf(of);
		}
		
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		CommUtil.addIPageList2ModelAndView(url+"/seller/return_view.htm", "", "", pList, mv);
		mv.addObject("data_type", data_type);
		mv.addObject("data", data);
		mv.addObject("beginTime", beginTime);
		mv.addObject("endTime", endTime);
		return mv;
	}
	
	@SecurityMapping(title = "卖家查看退款详情", value = "/seller/return_view.htm*", rtype = "seller", rname = "退货管理", rcode = "goods_return_seller", rgroup = "客户服务", display = false, rsequence = 0)
	@RequestMapping({ "/seller/money_return_view.htm" })
	public ModelAndView money_return_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/money_return_view.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		Refund obj = this.RefundService.getByKey(CommUtil.null2Long(id));
		OrderFormWithBLOBs of = this.orderFormService.getByKey(obj.getOfId());
		OrderFormItemExample orderFormItemExample = new OrderFormItemExample();
		orderFormItemExample.clear();
		orderFormItemExample.createCriteria().andOrderIdEqualTo(of.getId());
		List<OrderFormItem> ofList = this.orderFormItemService.getObjectList(orderFormItemExample);
		of.getItems().addAll(ofList);
		obj.setOfId(of.getId());
		obj.setOf(of);
		mv.addObject("obj", obj);
		
		return mv;
	}
}
