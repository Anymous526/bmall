package com.amall.core.action.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.amall.core.bean.Accessory;
import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.bean.Complaint;
import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintExample.Criteria;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerCash;
import com.amall.core.bean.DreamPartnerCashExample;
import com.amall.core.bean.DreamPartnerExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.ICashDepositService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.complaint.IComplaintService;
import com.amall.core.service.dreampartner.IDreamPartnerService;
import com.amall.core.service.dreampartnercash.IDreamPartnerCashService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ExcelExport;
import com.amall.core.web.tools.TransportTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: ComplaintManageAction
 * </p>
 * <p>
 * Description: 后台投诉 crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月24日下午6:43:50
 * @version 1.0
 */
@Controller
public class ComplaintManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IComplaintService complaintService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private ICashDepositService cashDepositService;

	@Autowired
	private IDreamPartnerCashService dreamPartnerCashService;

	@Autowired
	private IDreamPartnerService dreamPartnerService;
	
	@Autowired
	private TransportTools transportTools;

	@SecurityMapping(title = "投诉列表" , value = "/admin/complaint_list.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_list.htm" })
	public ModelAndView complaint_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String status , String from_user , String to_user , String title , String beginTime , String endTime)
		{
			ModelAndView mv = new JModelAndView ("admin/complaint_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("status" , CommUtil.null2String (status).equals ("") ? "new" : status);
			if ((CommUtil.null2String (status).equals ("")) || (CommUtil.null2String (status).equals ("new")))
			{
				status = "0";
			}
			if (CommUtil.null2String (status).equals ("complain"))
			{
				status = "1";
			}
			if (CommUtil.null2String (status).equals ("talk"))
			{
				status = "2";
			}
			if (CommUtil.null2String (status).equals ("arbitrate"))
			{
				status = "3";
			}
			if (CommUtil.null2String (status).equals ("close"))
			{
				status = "4";
			}
			ComplaintExample complaintExample = new ComplaintExample ();
			complaintExample.clear ();
			complaintExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			complaintExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			Criteria complaintCriteria = complaintExample.createCriteria ();
			complaintCriteria.andStatusEqualTo (Integer.valueOf (CommUtil.null2Int (status)));
			UserExample userExample = new UserExample ();
			if (!CommUtil.null2String (from_user).equals (""))
			{
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo (from_user);
				if (userService.getObjectList (userExample) != null && userService.getObjectList (userExample).size () != 0)
				{
					User user = userService.getObjectList (userExample).get (0);
					complaintCriteria.andFromUserIdEqualTo (user.getId ());
				}
				else
				{
					complaintCriteria.andFromUserIdIsNull ();
				}
			}
			if (!CommUtil.null2String (to_user).equals (""))
			{
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo (to_user);
				if (userService.getObjectList (userExample) != null && userService.getObjectList (userExample).size () != 0)
				{
					User user = userService.getObjectList (userExample).get (0);
					complaintCriteria.andToUserIdEqualTo (user.getId ());
				}
				else
				{
					complaintCriteria.andToUserIdIsNull ();
				}
			}
			if (!CommUtil.null2String (beginTime).equals (""))
			{
				complaintCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
			}
			if (!CommUtil.null2String (endTime).equals (""))
			{
				complaintCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
			}
			Pagination pList = complaintService.getObjectListWithPage (complaintExample);
			// IPageList pList = this.complaintService.list(qo);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("from_user" , from_user);
			mv.addObject ("to_user" , to_user);
			mv.addObject ("title" , title);
			mv.addObject ("beginTime" , beginTime);
			mv.addObject ("endTime" , endTime);
			return mv;
		}

	@SecurityMapping(title = "投诉设置" , value = "/admin/complaint_set.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_set.htm" })
	public ModelAndView complaint_set (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/complaint_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("config" , this.configService.getSysConfig ());
			return mv;
		}

	@SecurityMapping(title = "投诉设置保存" , value = "/admin/complaint_set_save.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_set_save.htm" })
	public ModelAndView complaint_set_save (HttpServletRequest request , HttpServletResponse response , String id , String complaint_time)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (id.equals (""))
			{
				SysConfigWithBLOBs config = this.configService.getSysConfig ();
				config.setComplaintTime (CommUtil.null2Int (complaint_time));
				this.configService.add (config);
			}
			else
			{
				SysConfigWithBLOBs config = this.configService.getSysConfig ();
				config.setComplaintTime (CommUtil.null2Int (complaint_time));
				this.configService.updateByObject (config);
			}
			mv.addObject ("op_title" , "投诉设置成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/admin/complaint_set.htm");
			return mv;
		}

	@SecurityMapping(title = "投诉详情" , value = "/admin/complaint_view.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_view.htm" })
	public ModelAndView complaint_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/complaint_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Complaint obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			OrderFormWithBLOBs of = this.orderFormService.getByKey (obj.getOfId ());
			obj.setOf (of);
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
			orderFormItemExample.clear ();
			orderFormItemExample.createCriteria ().andOrderIdEqualTo (of.getId ());
			List <OrderFormItem> orderFormItemList = this.orderFormItemService.getObjectList (orderFormItemExample);
			mv.addObject ("complaintGoods" , orderFormItemList);
			mv.addObject ("obj" , obj);
			return mv;
		}

	@SecurityMapping(title = "投诉图片" , value = "/admin/complaint_img.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_img.htm" })
	public ModelAndView complaint_img (HttpServletRequest request , HttpServletResponse response , String id , String type)
		{
			ModelAndView mv = new JModelAndView ("admin/complaint_img.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Complaint obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			if (obj.getFromAcc1Id () != null)
			{
				Accessory acc1 = this.accessoryService.getByKey (obj.getFromAcc1Id ());
				obj.setFromAcc1 (acc1);
			}
			if (obj.getFromAcc2Id () != null)
			{
				Accessory acc2 = this.accessoryService.getByKey (obj.getFromAcc2Id ());
				obj.setFromAcc2 (acc2);
			}
			if (obj.getFromAcc3Id () != null)
			{
				Accessory acc3 = this.accessoryService.getByKey (obj.getFromAcc3Id ());
				obj.setFromAcc3 (acc3);
			}
			mv.addObject ("obj" , obj);
			mv.addObject ("type" , type);
			return mv;
		}

	/**
	 * @Title: cash_deposit_list
	 * @Description: 退款信息列表
	 * @param request
	 * @param response
	 * @param type
	 * @param cash_status
	 * @param beginTime
	 * @param endTime
	 * @param userName
	 * @param currentPage
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年9月8日 下午2:38:55
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/admin/cash_deposit_list.htm" })
	public ModelAndView cash_deposit_list (HttpServletRequest request , HttpServletResponse response , String cash_status , String orderBy , String orderType , String beginTime , String endTime , String userName , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/cash_deposit_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CashDepositExample cashExample = new CashDepositExample ();
			cashExample.clear ();
			cashExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			cashExample.setOrderByClause ("create_time desc");
			cashExample.setPageSize (6);
			com.amall.core.bean.CashDepositExample.Criteria criteria = cashExample.createCriteria ();
			if (!CommUtil.null2String (beginTime).equals (""))
			{
				criteria.andCreateTimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
			}
			if (!CommUtil.null2String (endTime).equals (""))
			{
				criteria.andCreateTimeLessThanOrEqualTo (CommUtil.formatDate (beginTime));
			}
			if (!CommUtil.null2String (userName).equals (""))
			{
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo (userName);
				List <User> users = this.userService.getObjectList (userExample);
				if (users != null && !users.isEmpty ())
				{
					criteria.andSellerUserIdEqualTo (users.get (0).getId ());
				}
			}
			if (!CommUtil.null2String (cash_status).equals (""))
			{
				criteria.andCashStatusEqualTo (Integer.valueOf (cash_status));
			}
			Pagination pList = cashDepositService.getObjectListWithPage (cashExample);
			List <CashDeposit> list = (List <CashDeposit>) pList.getList ();
			/*
			 * for (int i = 0; i < list.size(); i++) {
			 * System.out.println("支付订单表中="+list.get(i).getAlipayOrder().getOrderId());
			 * System.out.println("店铺名="+list.get(i).getSellerUser().getStore().getStoreName());
			 * }
			 */
			for (CashDeposit deposit : list)
			{
				System.out.println(deposit.getAlipayOrder().getOrderId());
				deposit.setOrderId (deposit.getRefund ().getOf ().getOrderId ());
			}
			pList.setList (list);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("cash_status" , cash_status);
			mv.addObject ("userName" , userName);
			mv.addObject ("beginTime" , beginTime);
			mv.addObject ("endTime" , endTime);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject("transportTools", transportTools);
			return mv;
		}

	@SuppressWarnings("unchecked")
	@RequestMapping({ "admin/refundExport.htm" })
	public void refundExport (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			OutputStream outputStream = response.getOutputStream ();
			String name = "退款记录导出";
			responsesetting (response , name);
			List <String> ls = new ArrayList <String> ();
			ls.add ("店铺名称");
			ls.add ("退款商家");
			ls.add ("退款申请时间");
			ls.add ("支付订单号");
			ls.add ("退款金额");
			ls.add ("支付方式");
			ls.add ("退款状态");
			CashDepositExample cashExample = new CashDepositExample ();
			cashExample.clear ();
			cashExample.setOrderByClause ("create_time desc");
			cashExample.setPageSize (50000);
//			com.amall.core.bean.CashDepositExample.Criteria criteria = cashExample.createCriteria ();
			Pagination pList = cashDepositService.getObjectListWithPage (cashExample);
			List <CashDeposit> list = (List <CashDeposit>) pList.getList ();
			List <List <Object>> ob = new ArrayList <List <Object>> ();
			List <Object> lss = null;
			for (int i = 0 ; i < list.size () ; i++)
			{
				lss = new ArrayList <Object> ();
				System.out.println ("支付订单表中=" + list.get (i).getAlipayOrder ().getOrderId ());
				System.out.println ("店铺名=" + list.get (i).getSellerUser ().getStore ().getStoreName ());
				lss.add (list.get (i).getSellerUser ().getStore ().getStoreName ());
				lss.add (list.get (i).getSellerUser ().getTruename ());
				lss.add (list.get (i).getRefund ().getAddtime ());
				lss.add (list.get (i).getAlipayOrder ().getOrderId ());
				lss.add (list.get (i).getRefund ().getRefund ());
				lss.add (list.get (i).getAlipayOrder ().getPayType ());
				lss.add (list.get (i).getRefund ().getStatus ());
				ob.add (lss);
			}
			ExcelExport export = new ExcelExport ();
			export.export (name , ls , ob , outputStream);
		}

	private void responsesetting (HttpServletResponse response , String excelName)
		{
			response.setContentType ("application/vnd.ms-excel");	// 内容所属类型，Excel
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

	@RequestMapping({ "/admin/dream_partner_cash_edit.htm" })
	public ModelAndView dream_partner_cash_edit (HttpServletRequest request , HttpServletResponse response , Long id)
		{
			ModelAndView mv = new JModelAndView ("admin/dream_partner_cash_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (id == null)
				return new ModelAndView ("redirect:dream_partner_cash_list.htm");
			DreamPartnerCash cash = this.dreamPartnerCashService.getByKey (id);
			mv.addObject ("obj" , cash);
			return mv;
		}

	@RequestMapping({ "/admin/dream_partner_cash_save.htm" })
	public ModelAndView dream_partner_cash_save (HttpServletRequest request , HttpServletResponse response)
		{
			String id = request.getParameter ("id");
			if (id == null)
				return new ModelAndView ("redirect:dream_partner_cash_list.htm");
			Date date = new Date ();
			DreamPartnerCash cash = this.dreamPartnerCashService.getByKey (Long.valueOf (id));
			DreamPartnerExample example = new DreamPartnerExample ();
			example.createCriteria ().andApplyUserIdEqualTo (cash.getApplyUserId ());
			DreamPartner dreamPartner = this.dreamPartnerService.getObjectList (example).get (0);
			dreamPartner.setUserFee (dreamPartner.getUserFee () != null ? dreamPartner.getUserFee () : (new BigDecimal (0)).add (cash.getApplyFee ()));
			dreamPartner.setLastUserFeeTime (date);
			this.dreamPartnerService.updateByObject (dreamPartner);
			cash.setApproveStatus (true);
			cash.setOperationUserId (SecurityUserHolder.getCurrentUser ().getId ());
			cash.setPayTime (date);
			this.dreamPartnerCashService.updateByObject (cash);
			return new ModelAndView ("redirect:dream_partner_cash_list.htm");
		}

	@RequestMapping({ "/admin/dream_partner_cash_list.htm" })
	public ModelAndView dream_partner_cash_list (HttpServletRequest request , HttpServletResponse response , Long cash_status , String orderBy , String orderType , String beginTime , String endTime , String userName , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/dream_partner_cash_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			DreamPartnerCashExample cashExample = new DreamPartnerCashExample ();
			cashExample.clear ();
			cashExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			cashExample.setOrderByClause ("add_time desc");
			cashExample.setPageSize (6);
			com.amall.core.bean.DreamPartnerCashExample.Criteria criteria = cashExample.createCriteria ();
			if (!CommUtil.null2String (beginTime).equals (""))
			{
				criteria.andAddTimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
			}
			if (!CommUtil.null2String (endTime).equals (""))
			{
				criteria.andAddTimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
			}
			if (!CommUtil.null2String (userName).equals (""))
			{
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo (userName);
				List <User> users = this.userService.getObjectList (userExample);
				if (users != null && !users.isEmpty ())
				{
					criteria.andApplyUserIdEqualTo (users.get (0).getId ());
				}
			}
			if (cash_status != null)
			{
				if (cash_status == 1)
				{
					criteria.andApproveStatusEqualTo (true);
				}
				else
				{
					criteria.andApproveStatusEqualTo (false);
				}
			}
			Pagination pList = dreamPartnerCashService.getObjectListWithPage (cashExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("cash_status" , cash_status);
			mv.addObject ("userName" , userName);
			mv.addObject ("beginTime" , beginTime);
			mv.addObject ("endTime" , endTime);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "投诉审核" , value = "/admin/complaint_audit.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_audit.htm" })
	public ModelAndView complaint_audit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (1);
			this.complaintService.updateByObject (obj);
			mv.addObject ("op_title" , "审核投诉成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/complaint_list.htm");
			return mv;
		}

	@SecurityMapping(title = "投诉关闭" , value = "/admin/complaint_close.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_close.htm" })
	public ModelAndView complaint_close (HttpServletRequest request , HttpServletResponse response , String id , String handle_content)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (4);
			obj.setHandleContent (handle_content);
			obj.setHandleTime (new Date ());
			this.complaintService.updateByObject (obj);
			mv.addObject ("op_title" , "关闭投诉成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/complaint_list.htm");
			return mv;
		}

	@SecurityMapping(title = "发布投诉对话" , value = "/admin/complaint_talk.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_talk.htm" })
	public void complaint_talk (HttpServletRequest request , HttpServletResponse response , String id , String talk_content) throws IOException
		{
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			if (!CommUtil.null2String (talk_content).equals (""))
			{
				String temp = "管理员[" + SecurityUserHolder.getCurrentUser ().getUsername () + "] " + CommUtil.formatLongDate (new Date ()) + "说: " + talk_content;
				if (obj.getTalkContent () == null)
					obj.setTalkContent (temp);
				else
				{
					obj.setTalkContent (temp + "\n\r" + obj.getTalkContent ());
				}
				this.complaintService.updateByObject (obj);
			}
			List<Map<String,String>> maps = new ArrayList <Map <String, String>> ();
			for (String s : CommUtil.str2list (obj.getTalkContent ()))
			{
				Map<String,String> map = new HashMap <String, String> ();
				map.put ("content" , s);
				if (s.indexOf ("管理员") == 0)
				{
					map.put ("role" , "admin");
				}
				if (s.indexOf ("投诉") == 0)
				{
					map.put ("role" , "from_user");
				}
				if (s.indexOf ("申诉") == 0)
				{
					map.put ("role" , "to_user");
				}
				maps.add (map);
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (maps , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "投诉仲裁" , value = "/admin/complaint_handle_close.htm*" , rtype = "admin" , rname = "投诉管理" ,
						rcode = "complaint_manage" , rgroup = "交易" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/complaint_handle_close.htm" })
	public ModelAndView complaint_handle_close (HttpServletRequest request , HttpServletResponse response , String id , String handle_content)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (4);
			obj.setHandleContent (handle_content);
			obj.setHandleTime (new Date ());
			obj.setHandleUser (SecurityUserHolder.getCurrentUser ());
			obj.setHandleUserId (SecurityUserHolder.getCurrentUser ().getId ());
			this.complaintService.updateByObject (obj);
			mv.addObject ("op_title" , "投诉仲裁成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/complaint_list.htm");
			return mv;
		}
}
