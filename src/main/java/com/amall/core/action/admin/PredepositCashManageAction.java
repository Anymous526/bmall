package com.amall.core.action.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jasypt.encryption.BigDecimalEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.PredepositCash;
import com.amall.core.bean.PredepositCashExample;
import com.amall.core.bean.PredepositCashWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserCashDepositLog;
import com.amall.core.bean.UserCashDepositLogExample;
import com.amall.core.bean.UserCashDepositLogExample.Criteria;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.lee.IUserCashDepositLogService;
import com.amall.core.service.predeposit.IPredepositCashService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ExcelExport;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 提现申请crud管理
 * 
 * @author ljx
 *
 */
@Controller
public class PredepositCashManageAction
{

	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPredepositCashService predepositcashService;

	@Autowired
	private IUserCashDepositLogService cashDepositLogService;

	@Autowired
	private IUserService userService;

	@SecurityMapping(title = "提现申请列表" , value = "/admin/predeposit_cash.htm*" , rtype = "admin" , rname = "预存款管理" ,
						rcode = "predeposit" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/predeposit_cash.htm" })
	public ModelAndView predeposit_cash (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String q_pd_userName , String q_beginTime , String q_endTime)
		{
			ModelAndView mv = new JModelAndView ("admin/predeposit_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getDeposit ())
			{
				String url = this.configService.getSysConfig ().getAddress ();
				if ((url == null) || (url.equals ("")))
				{
					url = CommUtil.getURL (request);
				}
				PredepositCashExample cashExample = new PredepositCashExample ();
				cashExample.clear ();
				cashExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				cashExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				PredepositCashExample.Criteria cashCriteria = cashExample.createCriteria ();
				/*
				 * PredepositCashQueryObject qo = new PredepositCashQueryObject(
				 * currentPage, mv, orderBy, orderType);
				 */
				WebForm wf = new WebForm ();
				Map <String, Map <String, Object>> map = wf.toQueryPo (request , PredepositCash.class , mv);
				Iterator <String> it = map.keySet ().iterator ();
				while (it.hasNext ())
				{
					String key = it.next ().toString ();// 字段名
					Map <String, Object> map2 = map.get (key);
					Iterator <String> it2 = map2.keySet ().iterator ();
					String keys = "";// =或者like
					Object value = null;// 字段值
					if (it2.hasNext ())
					{
						keys = it2.next ().toString ();
						value = map2.get (keys);
					}
					if (key.equals ("cashPayment"))
					{
						if (keys.equals ("="))
						{
							cashCriteria.andCashPaymentEqualTo (String.valueOf (value));
						}
						else if (keys.equals ("like"))
						{
							cashCriteria.andCashPaymentLike (String.valueOf (value));
						}
					}
					else if (key.equals ("cashPayStatus"))
					{
						if (keys.equals ("="))
						{
							cashCriteria.andCashPayStatusEqualTo (Integer.parseInt (String.valueOf (value)));
						}
						else if (keys.equals ("like"))
						{
						}
					}
					else if (key.equals ("cashStatus"))
					{
						if (keys.equals ("="))
						{
							cashCriteria.andCashStatusEqualTo (Integer.parseInt (String.valueOf (value)));
						}
						else if (keys.equals ("like"))
						{
						}
					}
					else if (key.equals ("cashUsername"))
					{
						if (keys.equals ("="))
						{
							cashCriteria.andCashUsernameEqualTo (String.valueOf (value));
						}
						else if (keys.equals ("like"))
						{
							cashCriteria.andCashUsernameLike (String.valueOf (value));
						}
					}
				}
				if (!CommUtil.null2String (q_pd_userName).equals (""))
				{
					UserExample userExample = new UserExample ();
					userExample.clear ();
					UserExample.Criteria userCriteria = userExample.createCriteria ();
					userCriteria.andUsernameEqualTo (q_pd_userName);
					List <User> users = this.userService.getObjectList (userExample);
					if (users != null && users.size () != 0)
					{
						cashCriteria.andCashUserIdEqualTo (users.get (0).getId ());
					}
					else
					{
						cashCriteria.andCashUserIdIsNull ();
					}
					/*
					 * qo.addQuery("obj.cash_user.userName", new SysMap(
					 * "cash_userName", q_pd_userName), "=");
					 */
				}
				if (!CommUtil.null2String (q_beginTime).equals (""))
				{
					cashCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (q_beginTime));
				}
				if (!CommUtil.null2String (q_endTime).equals (""))
				{
					cashCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (q_endTime));
				}
				Pagination pList = predepositcashService.getObjectListWithPage (cashExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("q_pd_userName" , q_pd_userName);
				mv.addObject ("q_beginTime" , q_beginTime);
				mv.addObject ("q_endTime" , q_endTime);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@RequestMapping({ "/admin/predeposit_cashExport.htm" })
	public void predeposit_cashExport (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			OutputStream out = response.getOutputStream ();
			String name = "店铺提现管理";
			respongsetting (response , name);
			List <String> ls = new ArrayList <String> ();
			ls.add ("提现编号");
			ls.add ("会员名称");
			ls.add ("联系电话");
			ls.add ("提交时间");
			ls.add ("支付方式");
			ls.add ("提现金额");
			ls.add ("支付状态");
			ls.add ("提现状态");
			PredepositCashExample cashExample = new PredepositCashExample ();
			cashExample.clear ();
//			PredepositCashExample.Criteria cashCriteria = cashExample.createCriteria ();
			cashExample.setPageSize (30000);
			Pagination pList = predepositcashService.getObjectListWithPage (cashExample);
			@SuppressWarnings("unchecked")
			List <PredepositCash> cashs = (List <PredepositCash>) pList.getList ();
			List <List <Object>> ob = new ArrayList <List <Object>> ();
			List <Object> obs = new ArrayList <Object> ();
			for (int i = 0 ; i < cashs.size () ; i++)
			{
				obs = new ArrayList <Object> ();
				System.out.println (cashs.get (i).getCashAccount ());
				System.out.println (cashs.get (i).getCashUser ().getUsername ());
				obs.add (cashs.get (i).getCashAccount ());
				obs.add (cashs.get (i).getCashUser ().getTruename ());
				obs.add(cashs.get(i).getCashUser().getTelephone());
				obs.add (cashs.get (i).getAddtime ());
				if (cashs.get (i).getCashPayment () == "alipay")
				{
					obs.add ("支付宝");
				}
				else if (cashs.get (i).getCashPayment () == "WXPay")
				{
					obs.add ("微信");
				}
				else if (cashs.get (i).getCashPayment () == "AGPay")
				{
					obs.add ("余额");
				}
				else if (cashs.get (i).getCashPayment () == "chinabank")
				{
					obs.add ("网银");
				}
				else if (cashs.get (i).getCashPayment () == "Unionpay")
				{
					obs.add ("银联");
				}
				else if (cashs.get (i).getCashPayment () == "AGPay")
				{
					obs.add ("平台余额");
				}
				obs.add (cashs.get (i).getCashAmount ());
				obs.add ("null");
				if (cashs.get (i).getCashStatus () == 0)
				{
					obs.add ("等待支付");
				}
				if (cashs.get (i).getCashStatus () == 1)
				{
					obs.add ("已完成支付");
				}
				if (cashs.get (i).getCashStatus () == 2)
				{
					obs.add ("已拒绝");
					System.out.println ("竟来了" + cashs.get (i).getCashStatus ());
				}
				if (cashs.get (i).getCashStatus () == -1)
				{
					obs.add ("已关闭");
				}
				ob.add (obs);
			}
			ExcelExport export = new ExcelExport ();
			export.export (name , ls , ob , out);
		}

	private void respongsetting (HttpServletResponse response , String name)
		{
			response.setContentType ("application/vnd.ms-excel");
			response.setHeader ("Content-Disposition" , "attachment;filename=" + getExcelFileName (name) + "");
		}

	private String getExcelFileName (String name)
		{
			StringBuffer builder = new StringBuffer ();
			builder.append (name);
			builder.append (CommUtil.formatDate (new Date () , "yyyyMMddHHmmss"));
			builder.append (".xls");
			return builder.toString ();
		}

	@SecurityMapping(title = "提现申请编辑" , value = "/admin/predeposit_cash_edit.htm*" , rtype = "admin" , rname = "预存款管理" ,
						rcode = "predeposit" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/predeposit_cash_edit.htm" })
	public ModelAndView predeposit_cash_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/predeposit_cash_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getDeposit ())
			{
				if ((id != null) && (!id.equals ("")))
				{
					PredepositCashWithBLOBs predepositcash = this.predepositcashService.getByKey (Long.valueOf (Long.parseLong (id)));
					mv.addObject ("obj" , predepositcash);
					mv.addObject ("currentPage" , currentPage);
				}
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "提现申请编辑保存" , value = "/admin/predeposit_cash_save.htm*" , rtype = "admin" ,
						rname = "预存款管理" , rcode = "predeposit" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/predeposit_cash_save.htm" })
	public ModelAndView predeposit_cash_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getDeposit ())
			{
				WebForm wf = new WebForm ();
				PredepositCashWithBLOBs obj = this.predepositcashService.getByKey (Long.valueOf (Long.parseLong (id)));
				PredepositCashWithBLOBs predepositcash = (PredepositCashWithBLOBs) wf.toPo (request , obj);
				obj.setCashAdmin (SecurityUserHolder.getCurrentUser ());
				this.predepositcashService.updateByObject (predepositcash);
				User user = obj.getCashUser ();
				user.setAvailablebalance (BigDecimal.valueOf (CommUtil.subtract (user.getAvailablebalance () , predepositcash.getCashAmount ())));
				this.userService.updateByObject (user);
				if (obj.getCashStatus () == 2)
				{
					user.getStore ().setCashAmount (user.getStore ().getCashAmount ().add (obj.getCashAmount ()));
					storeService.updateByObject (user.getStore ());
				}
				mv.addObject ("list_url" , list_url);
				mv.addObject ("op_title" , "审核提现申请成功");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "提现申请详情" , value = "/admin/predeposit_cash_view.htm*" , rtype = "admin" , rname = "预存款管理" ,
						rcode = "predeposit" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/predeposit_cash_view.htm" })
	public ModelAndView predeposit_cash_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/predeposit_cash_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getDeposit ())
			{
				if ((id != null) && (!id.equals ("")))
				{
					PredepositCashWithBLOBs predepositcash = this.predepositcashService.getByKey (Long.valueOf (Long.parseLong (id)));
					User user = this.userService.getByKey (predepositcash.getCashUserId ());
					mv.addObject ("obj" , predepositcash);
					mv.addObject ("user" , user);
				}
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	/**
	 * @Title: benefit_deposit_cash
	 * @Description: 分红提现列表
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月2日
	 */
	@RequestMapping({ "/admin/benefit_deposit_cash.htm" })
	public ModelAndView benefit_deposit_cash (HttpServletRequest request , HttpServletResponse response , String currentPage , String username , String cardType , String cardName , String beginTime , String cardBankName , String endTime)
		{
			ModelAndView mv = new JModelAndView ("admin/benefit_deposit_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserCashDepositLogExample cashExample = new UserCashDepositLogExample ();
			cashExample.setOrderByClause ("id desc");
			cashExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			Criteria criteria = cashExample.createCriteria ();
			if (StringUtils.isNotEmpty (username))
			{
				User user = userService.getUserOfUserName (username);
				if (user != null)
				{
					criteria.andUserIdEqualTo (user.getId ());
				}
				mv.addObject ("username" , user.getUsername ());
			}
			if (StringUtils.isNotEmpty (cardType))
			{
				criteria.andCardTypeEqualTo (cardType);
				mv.addObject ("cardType" , cardType);
			}
			if (StringUtils.isNotEmpty (cardName))
			{
				criteria.andCardNameEqualTo (cardName);
				mv.addObject ("cardName" , cardName);
			}
			if (StringUtils.isNotEmpty (cardBankName))
			{
				criteria.andAddressLike (cardBankName);
				mv.addObject ("cardBankName" , cardBankName);
			}
			if (StringUtils.isNotEmpty (beginTime))
			{
				criteria.andAddTimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
				mv.addObject ("beginTime" , beginTime);
			}
			if (StringUtils.isNotEmpty (endTime))
			{
				criteria.andAddTimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
				mv.addObject ("endTime" , endTime);
			}
			Pagination pList = cashDepositLogService.getObjectListWithPage (cashExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@RequestMapping({ "/admin/benefit_cashExport.htm" })
	public void benefit_cashExport (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			OutputStream out = response.getOutputStream ();
			String name = "分红提现管理";
			respongsetting (response , name);
			List <String> ls = new ArrayList <String> ();
			ls.add ("提现编号");
			ls.add ("会员名称");
			ls.add ("联系方式");
			ls.add ("提交时间");
			ls.add ("支付方式");
			ls.add ("提现金额");
			ls.add ("提现状态");
			try
			{
				UserCashDepositLogExample cashExample = new UserCashDepositLogExample ();
				cashExample.clear ();
				cashExample.setPageSize (30000);
				Pagination pList = cashDepositLogService.getObjectListWithPage (cashExample);
				@SuppressWarnings("unchecked")
				List <UserCashDepositLog> cashs = (List <UserCashDepositLog>) pList.getList ();
				List <List <Object>> ob = new ArrayList <List <Object>> ();
				List <Object> obs = new ArrayList <Object> ();
				for (int i = 0 ; i < cashs.size () ; i++)
				{
					obs = new ArrayList <Object> ();
					obs.add (cashs.get (i).getId ());
					obs.add (cashs.get (i).getUser ().getTruename ());
					obs.add(cashs.get(i).getUser().getTelephone());
					obs.add (cashs.get (i).getAddTime ());
					if (cashs.get (i).getCardType () == "alipay")
					{
						obs.add ("支付宝");
					}
					else if (cashs.get (i).getCardType () == "WXPay")
					{
						obs.add ("微信");
					}
					else if (cashs.get (i).getCardType () == "AGPay")
					{
						obs.add ("余额");
					}
					else if (cashs.get (i).getCardType () == "chinabank")
					{
						obs.add ("网银");
					}
					else if (cashs.get (i).getCardType () == "unionpay")
					{
						obs.add ("银联");
					}
					else
					{
						obs.add ("null");
					}
					obs.add (cashs.get (i).getFee ());
					if (cashs.get (i).getIsWithdraw () == false)
					{
						obs.add ("等待提现");
					}
					else if (cashs.get (i).getIsWithdraw () == true)
					{
						obs.add ("已经提现");
					}
					else
					{
						obs.add ("拒绝提现");
					}
					ob.add (obs);
				}
				ExcelExport export = new ExcelExport ();
				export.export (name , ls , ob , out);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * @Title: benfit_cash_edit
	 * @Description: 分红提现处理
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月2日
	 */
	@RequestMapping({ "/admin/benfit_cash_edit.htm" })
	public ModelAndView benfit_cash_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/benefit_cash_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (StringUtils.isNotEmpty (id))
			{
				mv.addObject ("obj" , cashDepositLogService.getByKey (Long.valueOf (id)));
				mv.addObject ("currentPage" , currentPage);
			}
			return mv;
		}

	@RequestMapping({ "/admin/benefit_cash_save.htm" })
	public ModelAndView benefit_cash_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String isWithdraw , String list_url , String refuseMessage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserCashDepositLog obj = this.cashDepositLogService.getByKey (Long.valueOf (id));
			obj.setAdminUserId (SecurityUserHolder.getCurrentUser ().getId ());
			if ("1".equals (isWithdraw))
			{
				obj.setIsWithdraw (true);
				obj.setTxTime (new Date ());
			}
			/* 拒绝体提现 */
			if ("3".equals (isWithdraw))
			{
				obj.setTxTime (new Date ());
				obj.setRefuseMessage (refuseMessage);
				/* 退还用户提现申请的金额 */
				User user = obj.getUser ();
				
				userMoneyDetail detail = new userMoneyDetail();
				detail.setAddTime(new Date());
				detail.setCanCarry((user.getCanCarry ().add (obj.getFee ())));
				detail.setDetailFee(obj.getFee());
				detail.setDetailTx(1);
				detail.setManageMoney(user.getManageMoney());
				detail.setRemark(refuseMessage);
				detail.setUserId(user.getId());
				this.userMoneyDetailService.add(detail);
				
				user.setCanCarry (user.getCanCarry ().add (obj.getFee ()));
				user.setCurrentFee (user.getCurrentFee ().add (obj.getFee ()));
				this.userService.updateByObject (user);
			}
			this.cashDepositLogService.updateByObject (obj);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "审核提现申请成功");
			return mv;
		}

	@RequestMapping({ "/admin/benefit_cash_view.htm" })
	public ModelAndView benefit_cash_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/benefit_cash_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (StringUtils.isNotEmpty (id))
			{
				UserCashDepositLog depositLog = this.cashDepositLogService.getByKey (Long.valueOf (id));
				mv.addObject ("obj" , depositLog);
			}
			return mv;
		}
}
