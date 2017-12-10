package com.amall.core.action.seller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoldLogExample;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.bean.GoldRecord;
import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.GoldRecordWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.PredepositLog;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.predeposit.IPredepositLogService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.pay.PayTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;


/**
 * 
 * <p>Title: GoldSellerAction</p>
 * <p>Description: 金币兑换管理</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午7:39:58
 * @version 1.0
 */
@Controller
public class GoldSellerAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IGoldRecordService goldRecordService;

	@Autowired
	private IGoldLogService goldLogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPredepositLogService predepositLogService;

	@Autowired
	private PayTools payTools;

	@SecurityMapping(title = "金币兑换", value = "/seller/gold_record.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_record.htm" })
	public ModelAndView gold_record(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/gold_record.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (!this.configService.getSysConfig().getGold()) {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "商城未开启金币功能");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		} else {
			
			PaymentExample paymentExample = new PaymentExample();
			paymentExample.clear();
			paymentExample.createCriteria().andInstallEqualTo(Boolean.valueOf(true))
					.andMarkNotEqualTo("alipay_wap").andMarkNotEqualTo("weixin").andTypeEqualTo("admin");
			
			List<PaymentWithBLOBs> payments = paymentService.getObjectList(paymentExample);
			
			
			
			String gold_session = CommUtil.randomString(32);
			request.getSession(false)
					.setAttribute("gold_session", gold_session);
			mv.addObject("gold_session", gold_session);
			mv.addObject("payments", payments);
		}
		return mv;
	}

	@SecurityMapping(title = "金币兑换保存", value = "/buyer/gold_record_save.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_record_save.htm" })
	public ModelAndView gold_record_save(HttpServletRequest request,
			HttpServletResponse response, String id, String gold_payment,
			String gold_exchange_info, String gold_session) {
		ModelAndView mv = new JModelAndView("line_pay.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (this.configService.getSysConfig().getGold()) {
			String gold_session1 = CommUtil.null2String(request.getSession(
					false).getAttribute("gold_session"));
			if ((!gold_session1.equals(""))
					&& (gold_session1.equals(gold_session))) {
				request.getSession(false).removeAttribute("gold_session");
				WebForm wf = new WebForm();
				GoldRecordWithBLOBs obj = null;
				if (CommUtil.null2String(id).equals("")) {
					obj = (GoldRecordWithBLOBs) wf.toPo(request, GoldRecordWithBLOBs.class);
					obj.setAddtime(new Date());
					if (gold_payment.equals("outline"))
						obj.setGoldPayStatus(1);
					else {
						obj.setGoldPayStatus(0);
					}
					obj.setGoldSn("gold"
							+ CommUtil.formatTime("yyyyMMddHHmmss", new Date())
							+ SecurityUserHolder.getCurrentUser().getId());
					obj.setGoldUser(SecurityUserHolder.getCurrentUser());
					obj.setGoldCount(obj.getGoldMoney()
							* this.configService.getSysConfig()
									.getGoldmarketvalue());
					this.goldRecordService.add(obj);
				} else {
					GoldRecord gr = this.goldRecordService.getByKey(CommUtil
							.null2Long(id));
					obj = (GoldRecordWithBLOBs) wf.toPo(request, gr);
					this.goldRecordService.updateByObject(obj);
				}
				if (gold_payment.equals("outline")) {
					GoldLogWithBLOBs log = new GoldLogWithBLOBs();
					log.setAddtime(new Date());
					log.setGlPayment(obj.getGoldPayment());
					log.setGlContent("线下支付");
					log.setGlMoney(obj.getGoldMoney());
					log.setGlCount(obj.getGoldCount());
					log.setGlType(0);
					log.setGlUser(obj.getGoldUser());
					log.setGr(obj);
					this.goldLogService.add(log);
					mv = new JModelAndView("success.html",
							this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request,
							response);
					mv.addObject("op_title", "线下支付提交成功，等待审核");
					mv.addObject("url", CommUtil.getURL(request)
							+ "/seller/gold_record_list.htm");
				} else if (gold_payment.equals("balance")) {
					User user = this.userService.getByKey(SecurityUserHolder
							.getCurrentUser().getId());
					double balance = CommUtil.null2Double(user
							.getAvailablebalance());
					if (balance > obj.getGoldMoney()) {
						user.setGold(user.getGold() + obj.getGoldCount());
						user.setAvailablebalance(BigDecimal.valueOf(CommUtil
								.subtract(user.getAvailablebalance(),
										Integer.valueOf(obj.getGoldMoney()))));
						this.userService.updateByObject(user);

						obj.setGoldPayStatus(2);
						obj.setGoldStatus(1);
						this.goldRecordService.updateByObject(obj);

						PredepositLog pre_log = new PredepositLog();
						pre_log.setAddtime(new Date());
						pre_log.setPdLoguser(user);
						pre_log.setPdOpType("兑换金币");
						pre_log.setPdLogAmount(BigDecimal.valueOf(-obj
								.getGoldMoney()));
						pre_log.setPdLogInfo("兑换金币物减少可用预存款");
						pre_log.setPdType("可用预存款");
						this.predepositLogService.add(pre_log);

						GoldLogWithBLOBs log = new GoldLogWithBLOBs();
						log.setAddtime(new Date());
						log.setGlPayment(obj.getGoldPayment());
						log.setGlContent("预存款支付");
						log.setGlMoney(obj.getGoldMoney());
						log.setGlCount(obj.getGoldCount());
						log.setGlType(0);
						log.setGlUser(obj.getGoldUser());
						log.setGr(obj);
						this.goldLogService.add(log);
						mv = new JModelAndView("success.html",
								this.configService.getSysConfig(),
								this.userConfigService.getUserConfig(), 1,
								request, response);
						mv.addObject("op_title", "金币兑换成功");
						mv.addObject("url", CommUtil.getURL(request)
								+ "/seller/gold_record_list.htm");
					} else {
						mv = new JModelAndView("error.html",
								this.configService.getSysConfig(),
								this.userConfigService.getUserConfig(), 1,
								request, response);
						mv.addObject("op_title", "预存款金额不足");
						mv.addObject("url", CommUtil.getURL(request)
								+ "/seller/gold_record.htm");
					}
				} else {
					mv.addObject("payType", gold_payment);
					mv.addObject("type", "gold");
					mv.addObject("url", CommUtil.getURL(request));
					mv.addObject("payTools", this.payTools);
					mv.addObject("gold_id", obj.getId());
					
					PaymentExample paymentExample = new PaymentExample();
					paymentExample.clear();
					paymentExample.createCriteria().andInstallEqualTo(Boolean.valueOf(true))
							.andMarkEqualTo(obj.getGoldPayment()).andTypeEqualTo("admin");
					
					List<PaymentWithBLOBs> payments = paymentService.getObjectList(paymentExample);
					
					mv.addObject(
							"payment_id",
							payments.size() > 0 ? ((Payment) payments.get(0))
									.getId() : new Payment());
				}
			} else {
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "您已经提交过该请求");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/seller/gold_record_list.htm");
			}
		} else {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启金币");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "金币兑换", value = "/seller/gold_record_list.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_record_list.htm" })
	public ModelAndView gold_record_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/gold_record_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (!this.configService.getSysConfig().getGold()) {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启金币");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		} else {
			
			GoldRecordExample goldRecordExample = new GoldRecordExample();
			goldRecordExample.clear();
			goldRecordExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
			goldRecordExample.setOrderByClause("addTime desc");
			goldRecordExample.createCriteria().andGoldUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
			Pagination pList = goldRecordService.getObjectListWithPage(goldRecordExample);
			
			CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		}
		return mv;
	}

	@SecurityMapping(title = "金币兑换支付", value = "/seller/gold_pay.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_pay.htm" })
	public ModelAndView gold_pay(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/gold_pay.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (this.configService.getSysConfig().getGold()) {
			GoldRecord obj = this.goldRecordService.getByKey(CommUtil
					.null2Long(id));

			if (obj.getGoldUser().getId()
					.equals(SecurityUserHolder.getCurrentUser().getId())) {
				String gold_session = CommUtil.randomString(32);
				request.getSession(false).setAttribute("gold_session",
						gold_session);
				mv.addObject("gold_session", gold_session);
				mv.addObject("obj", obj);
			} else {
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "参数错误，您没有该兑换信息");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/seller/gold_record_list.htm");
			}
		} else {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启金币");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "金币兑换详情", value = "/seller/gold_view.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_view.htm" })
	public ModelAndView gold_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/gold_view.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (this.configService.getSysConfig().getGold()) {
			GoldRecord obj = this.goldRecordService.getByKey(CommUtil
					.null2Long(id));

			if (obj.getGoldUser().getId()
					.equals(SecurityUserHolder.getCurrentUser().getId())) {
				mv.addObject("obj", obj);
			} else {
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "参数错误，您没有该兑换信息");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/seller/gold_record_list.htm");
			}
		} else {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启金币");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "兑换日志", value = "/seller/gold_log.htm*", rtype = "seller", rname = "金币管理", rcode = "gold_seller", rgroup = "其他设置", display = false, rsequence = 0)
	@RequestMapping({ "/seller/gold_log.htm" })
	public ModelAndView gold_log(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/gold_log.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		if (!this.configService.getSysConfig().getGold()) {
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启金币");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/seller_index.htm");
		} else {
			
			GoldLogExample goldLogExample = new GoldLogExample();
			goldLogExample.clear();
			goldLogExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
			goldLogExample.setOrderByClause("addTime desc");
			goldLogExample.createCriteria().andGlUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
			Pagination pList = goldLogService.getObjectListWithPage(goldLogExample);
			
			CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
			mv.addObject("user", this.userService.getByKey(SecurityUserHolder
					.getCurrentUser().getId()));
		}
		return mv;
	}
}
