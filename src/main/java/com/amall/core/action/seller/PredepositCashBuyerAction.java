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
import com.amall.core.bean.PredepositCash;
import com.amall.core.bean.PredepositCashExample;
import com.amall.core.bean.PredepositCashWithBLOBs;
import com.amall.core.bean.PredepositLog;
import com.amall.core.bean.StoreEarningDetail;
import com.amall.core.bean.StoreEarningDetailExample;
import com.amall.core.bean.User;
import com.amall.core.lee.LeeService;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.predeposit.IPredepositCashService;
import com.amall.core.service.predeposit.IPredepositLogService;
import com.amall.core.service.store.IStoreEarningDetailService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: PredepositCashBuyerAction
 * </p>
 * <p>
 * Description: 卖家提现管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月25日下午7:27:14
 * @version 1.0
 */
@Controller
public class PredepositCashBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPredepositCashService predepositCashService;

	@Autowired
	private IPredepositLogService predepositLogService;

	@Autowired
	private IStoreEarningDetailService earningDetailService;

	@Autowired
	private IUserService userService;

	@Autowired
	private LeeService leeService;

	@SecurityMapping(title = "提现管理" , value = "/buyer/buyer_cash.htm*" , rtype = "buyer" , rname = "预存款管理" ,
						rcode = "predeposit_set" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_cash.htm" })
	public ModelAndView seller_cash (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User storeUser = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			if (!this.configService.getSysConfig ().getDeposit ())
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			else
			{
				/* 可用额度需要实时读取 */
				if (storeUser.getStore ().getCashAmount () == null)
				{
					mv.addObject ("cashAmount" , 0);
				}
				else
				{
					mv.addObject ("cashAmount" , storeUser.getStore ().getCashAmount ());
				}
			}
			return mv;
		}

	@SecurityMapping(title = "提现管理保存" , value = "/seller/seller_cash_save.htm*" , rtype = "seller" , rname = "预存款管理" ,
						rcode = "predeposit_set" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_cash_save.htm" })
	public ModelAndView seller_cash_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			WebForm wf = new WebForm ();
			PredepositCashWithBLOBs obj = (PredepositCashWithBLOBs) wf.toPo (request , PredepositCashWithBLOBs.class);
			obj.setCashSn ("cash" + CommUtil.formatTime ("yyyyMMddHHmmss" , new Date ()) + SecurityUserHolder.getCurrentUser ().getId ());
			obj.setAddtime (new Date ());
			obj.setCashUser (SecurityUserHolder.getCurrentUser ());
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			// 判断提现金额是否小于等于 当前用户的店铺 可用余额
			if (CommUtil.null2Double (obj.getCashAmount ()) <= CommUtil.null2Double (user.getStore ().getCashAmount ()))
			{
				this.predepositCashService.add (obj);
				PredepositLog log = new PredepositLog ();
				log.setAddtime (new Date ());
				log.setPdLogAmount (obj.getCashAmount ());
				log.setPdLogInfo ("申请提现");
				log.setPdLoguser (obj.getCashUser ());
				log.setPdOpType ("提现");
				log.setPdType ("可用预存款");
				this.predepositLogService.add (log);
				user.getStore ().setCashAmount (user.getStore ().getCashAmount ().subtract (obj.getCashAmount ()));
				this.storeService.updateByObject (user.getStore ());
				mv.addObject ("op_title" , "提现申请成功");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "提现金额大于用户余额，提现失败");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_cash_list.htm");
			return mv;
		}

	@SecurityMapping(title = "提现管理" , value = "/seller/seller_cash_list.htm*" , rtype = "seller" , rname = "预存款管理" ,
						rcode = "predeposit_set" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_cash_list.htm" })
	public ModelAndView seller_cash_list (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_cash_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (!this.configService.getSysConfig ().getDeposit ())
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			else
			{
				PredepositCashExample predepositCashExample = new PredepositCashExample ();
				predepositCashExample.clear ();
				predepositCashExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				predepositCashExample.setOrderByClause ("addTime desc");
				predepositCashExample.createCriteria ().andCashUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				Pagination pList = predepositCashService.getObjectListWithPage (predepositCashExample);
				CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/seller/seller_cash_list.htm" , null , "" , pList , mv);
			}
			return mv;
		}

	/**
	 * @Title: seller_store_fee_detail
	 * @Description: 店铺收入详情
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月22日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/seller/seller_store_fee_detail.htm" })
	public ModelAndView seller_store_fee_detail (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_store_fee_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			StoreEarningDetailExample detailExample = new StoreEarningDetailExample ();
			detailExample.setOrderByClause ("id desc");
			detailExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			detailExample.createCriteria ().andStoreIdEqualTo (SecurityUserHolder.getCurrentUser ().getStoreId ());
			Pagination pList = earningDetailService.getObjectListWithPage (detailExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/seller/seller_store_fee_detail.htm" , null , "" , pList , mv);
			List <StoreEarningDetail> list = (List <StoreEarningDetail>) pList.getList ();
			if (!list.isEmpty ())
			{
				BigDecimal totalFee = BigDecimal.ZERO;
				BigDecimal benefitFee = BigDecimal.ZERO;
				for (StoreEarningDetail detail : list)
				{
					totalFee = totalFee.add (detail.getFee ());
					benefitFee = benefitFee.add (detail.getBenefitFee ());
				}
				mv.addObject ("totalFee" , totalFee);
				mv.addObject ("benefitFee" , benefitFee);
			}
			return mv;
		}

	@SecurityMapping(title = "会员提现详情" , value = "/seller/seller_cash_view.htm*" , rtype = "seller" , rname = "预存款管理" ,
						rcode = "predeposit_set" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_cash_view.htm" })
	public ModelAndView seller_cash_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/seller_cash_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (this.configService.getSysConfig ().getDeposit ())
			{
				PredepositCash obj = this.predepositCashService.getByKey (CommUtil.null2Long (id));
				mv.addObject ("obj" , obj);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统未开启预存款");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			return mv;
		}

	/***
	 * 个人提现接口
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "提现管理保存" , value = "/Personagesellerseller/seller_cash_save.htm*" ,
						rtype = "Personagesellerseller" , rname = "预存款管理" , rcode = "predeposit_set" , rgroup = "用户中心" ,
						display = false , rsequence = 0)
	@RequestMapping({ "/Personagesellerseller/seller_cash_save.htm" })
	public ModelAndView Personageseller_cash_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			WebForm wf = new WebForm ();
			PredepositCashWithBLOBs obj = (PredepositCashWithBLOBs) wf.toPo (request , PredepositCashWithBLOBs.class);
			obj.setCashSn ("cash" + CommUtil.formatTime ("yyyyMMddHHmmss" , new Date ()) + SecurityUserHolder.getCurrentUser ().getId ());
			obj.setAddtime (new Date ());
			obj.setCashUser (SecurityUserHolder.getCurrentUser ());
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			/* 可提现金额 */
			BigDecimal depositCurrency = leeService.getAllowWithdrawDeposit (user);
			// 判断提现金额是否小于等于 当前用户的店铺 可用余额
			if (CommUtil.null2Double (obj.getCashAmount ()) <= CommUtil.null2Double (depositCurrency))
			{
				this.predepositCashService.add (obj);
				PredepositLog log = new PredepositLog ();
				log.setAddtime (new Date ());
				log.setPdLogAmount (obj.getCashAmount ());
				log.setPdLogInfo ("申请提现");
				log.setPdLoguser (obj.getCashUser ());
				log.setPdOpType ("提现");
				log.setPdType ("可用预存款");
				this.predepositLogService.add (log);
				user.getStore ().setCashAmount (user.getStore ().getCashAmount ().subtract (obj.getCashAmount ()));
				this.storeService.updateByObject (user.getStore ());
				mv.addObject ("op_title" , "提现申请成功");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "提现金额大于用户余额，提现失败");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_cash_list.htm");
			return mv;
		}
}
