package com.amall.core.action.buyer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.bean.IntegralLogExample;
import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.MutualBenefitExample;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.RechargeBenefit;
import com.amall.core.bean.RechargeBenefitExample;
import com.amall.core.bean.ShopBenefit;
import com.amall.core.bean.ShopBenefitExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.lee.LeeService;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.cloud.ICloudBuyerDetailService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.lee.IRechargeBenefitService;
import com.amall.core.service.lee.IShopBenefitService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVipActiveService;
//import com.amall.core.vo.AmallCoinDividend;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : AddressBuyerAction
 *
 * Description : 用户地址
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:43:51
 *
 */
@Controller
public class shareBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private LeeService leeService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	@Autowired
	private IRechargeBenefitService rechargeBenefitService;

	@Autowired
	private IShopBenefitService shopBenefitService;

	@Autowired
	private ICloudBuyerDetailService cloudBuyerDetailService;

	@Autowired
	private IUserVipActiveService userVipActiveService;

	@SecurityMapping(title = "" , value = "/buyer/new_user_share.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/new_user_share.htm" })
	public ModelAndView new_user_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_user_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.setPageNo (CommUtil.null2Int (currentPage));
			userExample.setOrderByClause ("addTime desc");
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			Pagination pList = this.userService.getObjectListWithPage (userExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@RequestMapping({ "/buyer/new_user_indirect_share.htm" })
	public ModelAndView new_user_indirect_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_indirect_user_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			/* 直接推荐人列表 */
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			userExample.clear ();
			/* 所有间接推荐人的ID */
			List <Long> listIndirectReferIds = new ArrayList <> ();
			for (User directRefer : listDirectReferUser)
			{
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				for (User indirectReferUser : listIndirectReferUser)
				{
					listIndirectReferIds.add (indirectReferUser.getId ());
				}
				userExample.clear ();
			}
			if (!listIndirectReferIds.isEmpty ())
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				userExample.setOrderByClause ("addTime desc");
				userExample.createCriteria ().andIdIn (listIndirectReferIds);
				Pagination pList = this.userService.getObjectListWithPage (userExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			else
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				Pagination pList = new Pagination ();
				pList.setPageNo (userExample.getPageNo ());
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/new_user_super_share.htm" })
	public ModelAndView new_user_super_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_super_user_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			/* 直接推荐人列表 */
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			userExample.clear ();
			/* 所有三级推荐人的ID */
			List <Long> listSuperReferIds = new ArrayList <> ();
			for (User directRefer : listDirectReferUser)
			{
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				userExample.clear ();
				for (User indirectRefer : listIndirectReferUser)
				{
					userExample.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ());
					List <User> listSuperReferUser = userService.getObjectList (userExample);
					for (User superReferUser : listSuperReferUser)
					{
						listSuperReferIds.add (superReferUser.getId ());
					}
					userExample.clear ();
				}
			}
			if (!listSuperReferIds.isEmpty ())
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				userExample.setOrderByClause ("addTime desc");
				userExample.createCriteria ().andIdIn (listSuperReferIds);
				Pagination pList = this.userService.getObjectListWithPage (userExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			else
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				Pagination pList = new Pagination ();
				pList.setPageNo (userExample.getPageNo ());
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			return mv;
		}

	@SecurityMapping(title = "" , value = "/buyer/new_shop_share.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/new_shop_share.htm" })
	public ModelAndView new_shop_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_shop_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.setPageNo (CommUtil.null2Int (currentPage));
			userExample.setOrderByClause ("addTime desc");
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ()).andStoreIdIsNotNull ();
			Pagination pList = this.userService.getObjectListWithPage (userExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@RequestMapping({ "/buyer/new_shop_indirect_share.htm" })
	public ModelAndView new_shop_indirect_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_indirect_shop_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			userExample.clear ();
			List <Long> listIndirectReferIds = new ArrayList <> ();
			for (User directRefer : listDirectReferUser)
			{
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ()).andStoreIdIsNotNull ();
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				for (User indirectReferUser : listIndirectReferUser)
				{
					listIndirectReferIds.add (indirectReferUser.getId ());
				}
				userExample.clear ();
			}
			if (!listIndirectReferIds.isEmpty ())
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				userExample.setOrderByClause ("addTime desc");
				userExample.createCriteria ().andIdIn (listIndirectReferIds);
				Pagination pList = this.userService.getObjectListWithPage (userExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/new_shop_super_share.htm" })
	public ModelAndView new_shop_super_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/share_super_shop_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			/* 直接推荐人列表 */
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			userExample.clear ();
			/* 所有三级推荐人的ID */
			List <Long> listSuperReferIds = new ArrayList <> ();
			for (User directRefer : listDirectReferUser)
			{
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				userExample.clear ();
				for (User indirectRefer : listIndirectReferUser)
				{
					userExample.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ()).andStoreIdIsNotNull ();
					List <User> listSuperReferUser = userService.getObjectList (userExample);
					for (User superReferUser : listSuperReferUser)
					{
						listSuperReferIds.add (superReferUser.getId ());
					}
					userExample.clear ();
				}
			}
			if (!listSuperReferIds.isEmpty ())
			{
				userExample.setPageNo (CommUtil.null2Int (currentPage));
				userExample.setOrderByClause ("addTime desc");
				userExample.createCriteria ().andIdIn (listSuperReferIds);
				Pagination pList = this.userService.getObjectListWithPage (userExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			return mv;
		}

	/**
	 * @Title: my_vip_benefit
	 * @Description: VIP互助奖
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月23日
	 */
	@RequestMapping({ "/buyer/my_vip_benefit.htm" })
	public ModelAndView my_vip_benefit (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_vip_benefit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				MutualBenefitExample benefitExample = new MutualBenefitExample ();
				benefitExample.setOrderByClause ("id desc");
				benefitExample.setPageNo (CommUtil.null2Int (currentPage));
				benefitExample.createCriteria ().andGetUserIdEqualTo (user.getId ());
				Pagination details = mutualBenefitService.getObjectListWithPage (benefitExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , details , mv);
				// mv.addObject("objs", details);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * @Title: my_benefit_fee
	 * @Description: 我的分红金额
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月23日
	 */
	@RequestMapping({ "/buyer/my_benefit_fee.htm" })
	public ModelAndView my_benefit_fee (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_benefit_fee.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				ShopBenefitExample shopBenefitExample = new ShopBenefitExample ();
				shopBenefitExample.setOrderByClause ("id desc");
				shopBenefitExample.setPageNo (CommUtil.null2Int (currentPage));
				shopBenefitExample.createCriteria ().andGetUserIdEqualTo (user.getId ());
				Pagination list = shopBenefitService.getObjectListWithPage (shopBenefitExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , list , mv);
				// mv.addObject("objs", list);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * @Title: my_benefit_fee
	 * @Description: 我的充值奖
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月23日
	 */
	@RequestMapping({ "/buyer/my_benefit_recharge.htm" })
	public ModelAndView my_benefit_recharge (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_benefit_recharge.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				RechargeBenefitExample rechargeBenefitExample = new RechargeBenefitExample ();
				rechargeBenefitExample.setOrderByClause ("id desc");
				rechargeBenefitExample.setPageNo (CommUtil.null2Int (currentPage));
				rechargeBenefitExample.createCriteria ().andGetUserIdEqualTo (user.getId ());
				Pagination retList = rechargeBenefitService.getObjectListWithPage (rechargeBenefitExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , retList , mv);
				// mv.addObject("objs", retList);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * @Title: my_special_currency
	 * @Description: 余额消费记录
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月23日
	 */
	@RequestMapping({ "/buyer/my_special_currency.htm" })
	public ModelAndView my_special_currency (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_special_currency.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				// List<OrderFormWithBLOBs> retList = new ArrayList<OrderFormWithBLOBs>();
				/* 查找消费记录 */
				// retList.addAll(findSpecialCurrencyRecode(user.getId(),currentPage));
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , findSpecialCurrencyRecode (user.getId () , currentPage) , mv);
				// mv.addObject("objs", retList);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/my_benefit_head.htm" })
	public ModelAndView my_benefit_head (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			mv = new JModelAndView ("buyer/my_benefit_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			BigDecimal a = user.getManageMoney () == null ? BigDecimal.ZERO : user.getManageMoney ();
			BigDecimal b = user.getCanCarry () == null ? BigDecimal.ZERO : user.getCanCarry ();
			mv.addObject ("bonus" , a.add (b));
			/* 可提现金额 */
			BigDecimal depositCurrency = leeService.getAllowWithdrawDeposit (user);
			mv.addObject ("depositCurrency" , depositCurrency);
			// 理财金
			BigDecimal manageMoney = user.getManageMoney ();
			mv.addObject ("manageMoney" , manageMoney);
			/* 店铺分利总数 */
			mv.addObject ("benefit" , leeService.getAllShopBenefit (user.getId ()));
			/* 互助奖 */
			mv.addObject ("vipFee" , leeService.getAllMutualFee (user.getId ()));
			/* 充值奖 */
			mv.addObject ("rechange" , leeService.getAllRechargeFee (user.getId ()));
			return mv;
		}

	/* 我的资产-礼品金 - 礼品金消费列表 */
	@RequestMapping({ "/buyer/myAssets_consumption.htm" })
	public ModelAndView myAssets_v2_consumption (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_gold_consume.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			IntegralGoodsOrderExample example = new IntegralGoodsOrderExample ();
			example.clear ();
			example.createCriteria ().andIgoUserIdEqualTo (user.getId ());
			example.setOrderByClause ("addTime desc");
			example.setPageNo (CommUtil.null2Int (currentPage));
			List <IntegralGoodsOrderWithBLOBs> integralGood = integralGoodsOrderService.getObjectList (example);
			Pagination integralGoods = integralGoodsOrderService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , integralGoods , mv);
			int cost = 0;
			for (IntegralGoodsOrderWithBLOBs intergoods : integralGood)
			{
				if (intergoods.getIgoStatus () > 10)
				{
					cost += intergoods.getIgoTotalGold ();
				}
			}
			mv.addObject ("cost" , cost);
			return mv;
		}

	@RequestMapping({ "/buyer/my_integral.htm" })
	public ModelAndView my_integral (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_integral.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			IntegralLogExample example = new IntegralLogExample ();
			example.setPageNo (CommUtil.null2Int (currentPage));
			example.setOrderByClause ("addTime desc");
			example.createCriteria ().andIntegralUserIdEqualTo (user.getId ());
			Pagination pList = this.integralLogService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/*
	 * //城市代理商的月份奖金
	 * @RequestMapping({ "/buyer/city_partner_total.htm" })
	 * public ModelAndView city_partner_total(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * ModelAndView mv = new JModelAndView("buyer/city_partner_total.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(),
	 * 1 , request, response);
	 * return mv;
	 * }
	 */
	@RequestMapping({ "/buyer/city_partner.htm" })
	public ModelAndView city_partner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/city_partner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/buyer/city_partner_list.htm" })
	public ModelAndView city_partner_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/city_partner_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/buyer/extension_obtain.htm" })
	public ModelAndView extension_obtain (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/extension_obtain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * @todo 海报二维码
	 * @author wht
	 * @date 2016年10月26日 下午10:41
	 * @return
	 */
	@RequestMapping({ "/buyer/poster.htm" })
	public ModelAndView poster (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String type)
		{
			ModelAndView mv;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv = new JModelAndView ("/buyer/poster.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				user = this.userService.getByKey (user.getId ());
				mv.addObject ("user" , user);
				mv.addObject ("userid" , user.getId ());
				// 二维码的链接
				String urlparams = "?pid=&did=" + user.getId () + "&redno=";
				// 微信分享内容里面的链接
				mv.addObject ("codelink" , "http://m.amall.com/reg8.htm" + urlparams);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * @todo 海报二维码
	 * @author wht
	 * @date 2016年10月26日 下午10:41
	 * @return
	 */
	@RequestMapping({ "/buyer/poster_back.htm" })
	public ModelAndView poster_back (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String type)
		{
			ModelAndView mv;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv = new JModelAndView ("/buyer/poster_back.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				user = this.userService.getByKey (user.getId ());
				mv.addObject ("user" , user);
				mv.addObject ("userid" , user.getId ());
				// 二维码的链接
				String urlparams = "?pid=&did=" + user.getId () + "&redno=";
				// 微信分享内容里面的链接
				mv.addObject ("codelink" , "http://m.amall.com/reg8.htm" + urlparams);
			}
			else
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/lets_extension.htm" })
	public ModelAndView lets_extension (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/lets_extension.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
			// user = this.userService.getByKey (user.getId ());
			// if (user != null)
			// {
			mv.addObject ("userid" , user.getId ());
			// 会员申请链接
			mv.addObject ("partnerurl_pre" , Globals.partnerurl_pre);
			// }
			}
			return mv;
		}

	@RequestMapping({ "/buyer/ref_user_count.htm" })
	public ModelAndView ref_user_count (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/ref_user_count.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			Integer directUserCount = 0;
			Integer indirectUserCount = 0;
			Integer superUserCount = 0;
			/**
			 * 查询直接推荐的总数
			 */
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			/* 直接推荐人列表 */
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			directUserCount = listDirectReferUser.size ();
			userExample.clear ();
			List <Long> firstIds = new ArrayList <Long> ();
			List <Long> secondIds = new ArrayList <Long> ();
			List <Long> thirdIds = new ArrayList <Long> ();
			/**
			 * 查询间接和三级推荐的总数
			 */
			for (User directRefer : listDirectReferUser)
			{
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				Integer indirectTempCount = listIndirectReferUser.size ();
				indirectUserCount = indirectUserCount + indirectTempCount;
				userExample.clear ();
				firstIds.add (directRefer.getId ());
				for (User indirectRefer : listIndirectReferUser)
				{
					userExample.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ());
					List <User> listSuperUser = userService.getObjectList (userExample);
					superUserCount = superUserCount + listSuperUser.size ();
					userExample.clear ();
					secondIds.add (indirectRefer.getId ());
					for (User superUser : listSuperUser)
					{
						thirdIds.add (superUser.getId ());
					}
				}
			}
			MutualBenefitExample mutualBenefitExample = new MutualBenefitExample ();
			RechargeBenefitExample rechargeBenefitExample = new RechargeBenefitExample ();
			ShopBenefitExample shopBenefitExample = new ShopBenefitExample ();
			StoreExample storeExample = new StoreExample ();
			BigDecimal firstMutualBenefit = new BigDecimal (0.00);
			BigDecimal secondMutualBenefit = new BigDecimal (0.00);
			BigDecimal thirdMutualBenefit = new BigDecimal (0.00);
			BigDecimal firstRechargeBenefit = new BigDecimal (0.00);
			BigDecimal secondRechargeBenefit = new BigDecimal (0.00);
			BigDecimal thirdRechargeBenefit = new BigDecimal (0.00);
			BigDecimal firstShopBenefit = new BigDecimal (0.00);
			BigDecimal secondShopBenefit = new BigDecimal (0.00);
			BigDecimal thirdShopBenefit = new BigDecimal (0.00);
			List <MutualBenefit> mutualBenefits;
			List <RechargeBenefit> rechargeBenefits;
			List <ShopBenefit> shopBenefits;
			if (firstIds.size () > 0)
			{
				// 一级互助奖
				mutualBenefitExample.createCriteria ().andGiveUserIdIn (firstIds).andGetUserIdEqualTo (user.getId ());
				mutualBenefits = mutualBenefitService.getObjectList (mutualBenefitExample);
				for (MutualBenefit mutualBenefit : mutualBenefits)
				{
					firstMutualBenefit = firstMutualBenefit.add (mutualBenefit.getMutualFee ());
				}
				// 一级充值奖
				rechargeBenefitExample.clear ();
				rechargeBenefitExample.createCriteria ().andGiveUserIdIn (firstIds).andGetUserIdEqualTo (user.getId ());
				rechargeBenefits = rechargeBenefitService.getObjectList (rechargeBenefitExample);
				for (RechargeBenefit rechargeBenefit : rechargeBenefits)
				{
					firstRechargeBenefit = firstRechargeBenefit.add (rechargeBenefit.getRechargeFee ());
				}
				// 一级分红奖
				storeExample.clear ();
				storeExample.createCriteria ().andUserIdIn (firstIds);
				List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
				List <Long> storeIds = new ArrayList <Long> ();
				for (StoreWithBLOBs store : stores)
				{
					storeIds.add (store.getId ());
				}
				if (storeIds.size () > 0)
				{
					shopBenefitExample.clear ();
					shopBenefitExample.createCriteria ().andGiveShopIdIn (storeIds).andGetUserIdEqualTo (user.getId ());
					shopBenefits = shopBenefitService.getObjectList (shopBenefitExample);
					for (ShopBenefit shopBenefit : shopBenefits)
					{
						firstShopBenefit = firstShopBenefit.add (shopBenefit.getShopFee ());
					}
				}
			}
			if (secondIds.size () > 0)
			{
				// 二级互助将
				mutualBenefitExample.clear ();
				mutualBenefitExample.createCriteria ().andGiveUserIdIn (secondIds).andGetUserIdEqualTo (user.getId ());
				mutualBenefits = mutualBenefitService.getObjectList (mutualBenefitExample);
				for (MutualBenefit mutualBenefit : mutualBenefits)
				{
					secondMutualBenefit = secondMutualBenefit.add (mutualBenefit.getMutualFee ());
				}
				// 二级充值奖
				rechargeBenefitExample.clear ();
				rechargeBenefitExample.createCriteria ().andGiveUserIdIn (secondIds).andGetUserIdEqualTo (user.getId ());
				rechargeBenefits = rechargeBenefitService.getObjectList (rechargeBenefitExample);
				for (RechargeBenefit rechargeBenefit : rechargeBenefits)
				{
					secondRechargeBenefit = secondRechargeBenefit.add (rechargeBenefit.getRechargeFee ());
				}
				// 二级分红奖
				storeExample.clear ();
				storeExample.createCriteria ().andUserIdIn (secondIds);
				List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
				List <Long> storeIds = new ArrayList <Long> ();
				for (StoreWithBLOBs store : stores)
				{
					storeIds.add (store.getId ());
				}
				if (storeIds.size () > 0)
				{
					shopBenefitExample.clear ();
					shopBenefitExample.createCriteria ().andGiveShopIdIn (storeIds).andGetUserIdEqualTo (user.getId ());
					shopBenefits = shopBenefitService.getObjectList (shopBenefitExample);
					for (ShopBenefit shopBenefit : shopBenefits)
					{
						secondShopBenefit = secondShopBenefit.add (shopBenefit.getShopFee ());
					}
				}
			}
			if (thirdIds.size () > 0)
			{
				// 三级互助将
				mutualBenefitExample.clear ();
				mutualBenefitExample.createCriteria ().andGiveUserIdIn (thirdIds).andGetUserIdEqualTo (user.getId ());
				mutualBenefits = mutualBenefitService.getObjectList (mutualBenefitExample);
				for (MutualBenefit mutualBenefit : mutualBenefits)
				{
					thirdMutualBenefit = thirdMutualBenefit.add (mutualBenefit.getMutualFee ());
				}
				// 三级充值奖
				rechargeBenefitExample.clear ();
				rechargeBenefitExample.createCriteria ().andGiveUserIdIn (thirdIds).andGetUserIdEqualTo (user.getId ());
				rechargeBenefits = rechargeBenefitService.getObjectList (rechargeBenefitExample);
				for (RechargeBenefit rechargeBenefit : rechargeBenefits)
				{
					thirdRechargeBenefit = thirdRechargeBenefit.add (rechargeBenefit.getRechargeFee ());
				}
				// 三级分红奖
				storeExample.clear ();
				storeExample.createCriteria ().andUserIdIn (thirdIds);
				List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
				List <Long> storeIds = new ArrayList <Long> ();
				for (StoreWithBLOBs store : stores)
				{
					storeIds.add (store.getId ());
				}
				if (storeIds.size () > 0)
				{
					shopBenefitExample.clear ();
					shopBenefitExample.createCriteria ().andGiveShopIdIn (storeIds).andGetUserIdEqualTo (user.getId ());
					shopBenefits = shopBenefitService.getObjectList (shopBenefitExample);
					for (ShopBenefit shopBenefit : shopBenefits)
					{
						thirdShopBenefit = thirdShopBenefit.add (shopBenefit.getShopFee ());
					}
				}
			}
			mv.addObject ("directUser" , directUserCount);
			mv.addObject ("indirectUser" , indirectUserCount);
			mv.addObject ("superUser" , superUserCount);
			mv.addObject ("firstMutualBenefit" , firstMutualBenefit);
			mv.addObject ("secondMutualBenefit" , secondMutualBenefit);
			mv.addObject ("thirdMutualBenefit" , thirdMutualBenefit);
			mv.addObject ("firstRechargeBenefit" , firstRechargeBenefit);
			mv.addObject ("secondRechargeBenefit" , secondRechargeBenefit);
			mv.addObject ("thirdRechargeBenefit" , thirdRechargeBenefit);
			mv.addObject ("firstShopBenefit" , firstShopBenefit);
			mv.addObject ("secondShopBenefit" , secondShopBenefit);
			mv.addObject ("thirdShopBenefit" , thirdShopBenefit);
			mv.addObject ("totalBenefit" , firstMutualBenefit.add (secondMutualBenefit).add (thirdMutualBenefit).add (firstRechargeBenefit).add (secondRechargeBenefit).add (thirdRechargeBenefit).add (firstShopBenefit).add (secondShopBenefit).add (thirdShopBenefit));
			return mv;
		}

	@RequestMapping({ "/buyer/ref_shop_count.htm" })
	public ModelAndView ref_shop_count (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/ref_shop_count.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			Integer directShopCount = 0;
			Integer inDirectShopCount = 0;
			Integer superShopCount = 0;
			/**
			 * 查询直接店铺的总数
			 */
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ()).andStoreIdIsNotNull ();
			/* 直接推荐人开店列表 */
			List <User> listDirectReferUser = userService.getObjectList (userExample);
			directShopCount = listDirectReferUser.size ();
			userExample.clear ();
			userExample.createCriteria ().andDirectReferEqualTo (user.getId ());
			/* 直接推荐人列表 */
			List <User> listDirectReferUser1 = userService.getObjectList (userExample);
			/**
			 * 查询间接店铺和三级店铺的总数
			 */
			for (User directRefer : listDirectReferUser1)
			{
				userExample.clear ();
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ()).andStoreIdIsNotNull ();
				List <User> listIndirectReferUser = userService.getObjectList (userExample);
				Integer indirectTempCount = listIndirectReferUser.size ();
				inDirectShopCount = inDirectShopCount + indirectTempCount;
				userExample.clear ();
				userExample.createCriteria ().andDirectReferEqualTo (directRefer.getId ());
				List <User> listIndirectReferUser1 = userService.getObjectList (userExample);
				for (User indirectRefer : listIndirectReferUser1)
				{
					userExample.clear ();
					userExample.createCriteria ().andDirectReferEqualTo (indirectRefer.getId ()).andStoreIdIsNotNull ();
					Integer superTempCount = userService.getObjectListCount (userExample);
					superShopCount = superShopCount + superTempCount;
				}
			}
			/* 店铺分利总数 */
			mv.addObject ("benefit" , leeService.getAllShopBenefit (user.getId ()));
			mv.addObject ("directShop" , directShopCount);
			mv.addObject ("indirectShop" , inDirectShopCount);
			mv.addObject ("superShop" , superShopCount);
			return mv;
		}

//	private List <AmallCoinDividend> findExchangeRecode (Long userId)
//		{
//			List <AmallCoinDividend> retList = new ArrayList <AmallCoinDividend> ();
//			IntegralGoodsOrderExample example = new IntegralGoodsOrderExample ();
//			example.setOrderByClause ("addTime desc");
//			example.createCriteria ().andIgoUserIdEqualTo (userId).andIgoStatusEqualTo (Globals.HAVE_PAYMENT);
//			List <IntegralGoodsOrderWithBLOBs> list = this.integralGoodsOrderService.getObjectList (example);
//			if (list != null && !list.isEmpty ())
//			{
//				AmallCoinDividend coinDividend = null;
//				for (IntegralGoodsOrderWithBLOBs bloBs : list)
//				{
//					coinDividend = new AmallCoinDividend ();
//					coinDividend.setRealName (bloBs.getIg ().getIgGoodsName ());
//					coinDividend.setDividendType ("免费兑换");
//					coinDividend.setDividendGold (new BigDecimal (bloBs.getIgoTotalGold ()));
//					coinDividend.setDividendDate (CommUtil.formatShortDate (bloBs.getAddtime ()));
//					retList.add (coinDividend);
//				}
//			}
//			return retList;
//		}

	/*
	 * private Pagination findSpecialCurrencyRecode(Long userId)
	 * {
	 * OrderFormExample example = new OrderFormExample();
	 * 已收货，已评价，结束，
	 * List<Integer> inStatus = new ArrayList<Integer>();
	 * inStatus.add(Globals.COMPLETED_AND_EVALUATED);
	 * inStatus.add(Globals.FINISH);
	 * inStatus.add(Globals.FINISH_AND_NOT_EVALUATED);
	 * inStatus.add(Globals.HAVE_RECEIVED_GOOD);
	 * 获取余额支付方式ID
	 * Payment payment = getPayType("AGPay");
	 * example.setOrderByClause("addTime desc");
	 * example.createCriteria().andUserIdEqualTo(userId).andOrderStatusIn(inStatus).andPaymentIdEqualTo
	 * (payment.getId());
	 * Pagination orders = this.orderFormService.getObjectListWithPage(example);
	 * return orders;
	 * }
	 */
	private Pagination findSpecialCurrencyRecode (Long userId , String currentPage)
		{
			OrderFormExample example = new OrderFormExample ();
			/* 已收货，已评价，结束， */
			List <Integer> inStatus = new ArrayList <Integer> ();
			inStatus.add (Globals.COMPLETED_AND_EVALUATED);
			inStatus.add (Globals.FINISH);
			inStatus.add (Globals.FINISH_AND_NOT_EVALUATED);
			inStatus.add (Globals.HAVE_RECEIVED_GOOD);
			/* 获取余额支付方式ID */
			Payment payment = getPayType ("AGPay");
			example.setOrderByClause ("addTime desc");
			example.setPageNo (CommUtil.null2Int (currentPage));
			example.createCriteria ().andUserIdEqualTo (userId).andOrderStatusIn (inStatus).andPaymentIdEqualTo (payment.getId ());
			Pagination orders = this.orderFormService.getObjectListWithPage (example);
			return orders;
		}

	/**
	 * @Title: getPayType
	 * @Description: 获取支付类型
	 * @param type
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月12日
	 */
	private Payment getPayType (String type)
		{
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			paymentExample.createCriteria ().andMarkEqualTo (type);
			List <PaymentWithBLOBs> payments = paymentService.getObjectList (paymentExample);
			return (Payment) payments.get (Globals.NUBER_ZERO);
		}
}
