package com.amall.core.action.buyer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.constant.Globals;
import com.amall.core.bean.DouDetail;
import com.amall.core.bean.DouDetailExample;
import com.amall.core.bean.PlatformEarningDetail;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.doulog;
import com.amall.core.bean.doulogExample;
import com.amall.core.bean.trend;
import com.amall.core.bean.trendExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.lee.LeeUtil;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.gold.IDouDetailService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.gold.ITrendService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.lee.IPlatformEarningDetailService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVipActiveService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.util.DateUtil;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.web.Page;

@Controller
public class DouAction {

	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISysConfigService sysConfigService;
	
	@Autowired
	private IDoulogService doulogService;
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IPlatformEarningDetailService platformEarningDetailService;
	
	@Autowired
	private IUserConfigService userConfigService;
	
	@Autowired
	private ITrendService trendService;
	
	@Autowired
	private IUserVipActiveService userVipActiveService;
	
	@Autowired
	private IDouDetailService doudetailService;

	
	@RequestMapping({"/dou_deal_list.htm"})
	public ModelAndView dou_deal_list(HttpServletRequest request, HttpServletResponse response){
	
		ModelAndView mv = null;
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		mv = new JModelAndView("seller/usercenter/buyer_consult.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		
		doulogExample doulogExample = new doulogExample();
		doulogExample.clear();
		doulogExample.setOrderByClause("addTime desc");
		com.amall.core.bean.doulogExample.Criteria criteria = doulogExample.createCriteria();
		criteria.andDealtimeIsNull();
		List<doulog> list = doulogService.getObjectList(doulogExample);
		
		mv.addObject("obj", list);
		
		return mv;
	}
	
	@RequestMapping({"/my_dou.htm"})
	public ModelAndView my_dou(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new JModelAndView("login.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		mv.addObject("douNum", user.getDou());
		
		return mv;
	}
	
	/**
	 * 出售感恩豆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/buyer/dou_sale.htm"})
	public ModelAndView dou_sale(HttpServletRequest request, HttpServletResponse response, String prices, String totalDouNums, String statuss){
		
		ModelAndView mv = new JModelAndView("buyer/angel_bean_buy.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		Long userId = user.getId();
		
		BigDecimal price = new BigDecimal(prices);
		Integer totalDouNum = Integer.valueOf(totalDouNums);
		Integer status = Integer.valueOf(statuss);
		
		System.out.println("price ： " + price + "totalNum : " + totalDouNums + "status : " + statuss);
		
		BigDecimal totalFee = price.multiply(new BigDecimal(totalDouNum));
		
		if(userId == null || price == null || totalDouNum == null)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "参数不齐全");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
			return mv;
		}
		
		System.out.println("price : " + price + "totalDouNums : " + totalDouNums);
		if(price.compareTo(BigDecimal.ZERO)==0 || totalDouNum.compareTo(0)==0)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "价格不正确");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
			return mv;
		}
		
		
		if(user.getDou() == null)
		{
			user.setDou(0);
		}
		
		SysConfig config = this.sysConfigService.getSysConfig();
		//卖出，先扣豆
		if(status == 0)
		{
			if(totalDouNum > user.getDou() * Globals.DOU_RATE)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "每次只能出售豆数量的百分之十");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
				return mv;
			}
			
			if(price.compareTo(config.getMaxPrice()) > 0 || price.compareTo(config.getMinPricce()) < 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "价格不正确");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
				return mv;
			}
			
			
			doulogExample doulogExample = new doulogExample();
			doulogExample.clear();
			doulogExample.setOrderByClause("addTime desc");
			doulogExample.createCriteria().andUserIdEqualTo(userId).andTotalDouNumGreaterThan(0);
			List<doulog> activeLog = this.doulogService.getObjectList(doulogExample);
			
			//Long BossId = new Long(57125);
			Integer doustatus = user.getStatus() == null ? 0 : user.getStatus();
			if(activeLog != null && activeLog.size() > 0 && !doustatus.equals(9000))
			{
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					String date2 = DateUtil.getCurrentTime(new Date());
					String date3 = DateUtil.getCurrentTime(activeLog.get(0).getAddtime());
					Date date1 = format.parse(date2);
					Date date = format.parse(date3);
					
					
					Calendar calendar = Calendar.getInstance();
					calendar.setFirstDayOfWeek(Calendar.MONDAY);
					calendar.setTime(date);
					int aWeek = calendar.get(Calendar.WEEK_OF_YEAR);
					
					Calendar calendar1 = Calendar.getInstance();
					calendar1.setFirstDayOfWeek(Calendar.MONDAY);
					calendar1.setTime(date1);
					int aWeek1 = calendar1.get(Calendar.WEEK_OF_YEAR);
					
					//老板账号除外
					if(aWeek == aWeek1)
					{
						mv = new JModelAndView("error.html",
								this.configService.getSysConfig(),
								this.userConfigService.getUserConfig(), 1, request,
								response);
						mv.addObject("op_title", "每周只能卖出一次");
						mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
						return mv;
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			user.setDou(user.getDou() - totalDouNum);
			userService.updateByObject(user);
			
			doulog doulog = new doulog();
			doulog.setAddtime(new Date());
			doulog.setPrice(price);
			doulog.setTotalDouNum(totalDouNum);
			doulog.setUserId(userId);
			doulog.setType((short)0);
			this.doulogService.add(doulog);
			mv.addObject("op_title", "发布成功");
			//买入，不先扣钱
		}else if(status == 1){
			
			if(user.getCurrentFee() == null)
			{
				user.setCurrentFee(BigDecimal.ZERO);
			}
			
			BigDecimal nowcarry=(BigDecimal) (user.getCanCarry()==null?BigDecimal.ZERO:user.getCanCarry());
			BigDecimal nowmanage=(BigDecimal) (user.getManageMoney()==null?BigDecimal.ZERO:user.getManageMoney());
			
			//if(user.getCurrentFee().compareTo(totalFee) < 0)
			if(nowcarry.add(nowmanage).compareTo(totalFee) < 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "价格不正确");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
				return mv;
				
			}
			
			if(price.compareTo(config.getMaxPrice()) > 0 || price.compareTo(config.getMinPricce()) < 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "价格不正确");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
				return mv;
			}
			
			//先扣除用户金额
			/*user.setCurrentFee(user.getCurrentFee().subtract(totalFee));
			if(user.getManageMoney().compareTo(totalFee) >= 0)
			{
				user.setManageMoney(user.getManageMoney().subtract(totalFee));
			}else{
				user.setManageMoney(BigDecimal.ZERO);
				user.setCanCarry(user.getCanCarry().subtract(totalFee.subtract(user.getManageMoney())));
			}
			
			userService.updateByObject(user);*/
			
			doulog doulog = new doulog();
			doulog.setAddtime(new Date());
			doulog.setPrice(price);
			doulog.setTotalDouNum(totalDouNum);
			doulog.setDealUserId(Integer.valueOf(String.valueOf(userId)));
			doulog.setType((short)0);
			this.doulogService.add(doulog);
			mv.addObject("op_title", "发布成功");
		}
		return mv;
	}
	
	/**
	 * 买家卖家撤销订单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/cancel_order.htm"})
	public ModelAndView cancel_order(HttpServletRequest request, HttpServletResponse response, String Id){

		ModelAndView mv = new JModelAndView("login.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		Long id = Long.valueOf(Id);
		
		
		doulog doulogs = doulogService.getByKey(id);
		Integer douNum = doulogs.getTotalDouNum();
		
		
		if(doulogs == null)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "未找到此订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/cancel_order.htm");
			return mv;
		}
		
		if(doulogs.getType()!=(short)0)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "此订单交易已成功");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/cancel_order.htm");
			return mv;
		}
		
		if((doulogs.getUserId() != null && !doulogs.getUserId().equals(user.getId())) ||
				(doulogs.getDealUserId() != null &&  !Long.valueOf(doulogs.getDealUserId()).equals(user.getId())))
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单异常状态");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/cancel_order.htm");
			return mv;
		}
		
		//买单撤销订单
		if(doulogs.getUserId() == null && doulogs.getDealUserId() != null && doulogs.getType() == (short)0)
		{
			doulogs.setTotalDouNum(0);
			doulogs.setAddtime(new Date());
			doulogService.updateByObject(doulogs);
		
		}
		
		//卖单撤销
		if(doulogs.getUserId() != null && doulogs.getDealUserId() == null && doulogs.getType() == (short)0)
		{
			doulogs.setTotalDouNum(0);
			doulogs.setAddtime(new Date());
			doulogService.updateByObject(doulogs);
			
			if(user.getDou() == null)
			{
				user.setDou(0);
			}
			
			user.setDou(user.getDou() + douNum);
			userService.updateByObject(user);
		}
		
		return mv;
	}
	
	
	/**
	 * 感恩豆买单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/buyer/angel_bean_buy.htm"})
	public ModelAndView angel_bean_buy(HttpServletRequest request, HttpServletResponse response){
	
		ModelAndView mv = null;
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		doulogExample doulogExample = new doulogExample();
		doulogExample.clear();
		doulogExample.setOrderByClause("addTime desc");
		
		doulogExample.createCriteria().andTypeEqualTo((short)0).andDealUserIdIsNull().andTotalDouNumNotEqualTo(0);
		List<doulog> doulogs = doulogService.getObjectList(doulogExample);
		
		mv = new JModelAndView("buyer/angel_bean_buy.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		mv.addObject("objs", doulogs);
		if(user.getDou() == null)
		{
			user.setDou(0);
		}
		
		SysConfigWithBLOBs bloBs = sysConfigService.getSysConfig();
		mv.addObject("maxprice", bloBs.getMaxPrice());
		mv.addObject("minprice", bloBs.getMinPricce());
		
		mv.addObject("douNum", user.getDou());
		mv.addObject("userId", user.getId());
		return mv;
		
	}
	
	/**
	 * 感恩豆卖单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/buyer/angel_bean_sale.htm"})
	public ModelAndView dou_list(HttpServletRequest request, HttpServletResponse response){
	
		ModelAndView mv = null;
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		doulogExample doulogExample = new doulogExample();
		doulogExample.clear();
		doulogExample.setOrderByClause("addTime desc");
		
		doulogExample.createCriteria().andTypeEqualTo((short)0).andUserIdIsNull().andTotalDouNumNotEqualTo(0);
		List<doulog> doulogs = doulogService.getObjectList(doulogExample);
		
		mv = new JModelAndView("buyer/angel_bean_sale.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		mv.addObject("objs", doulogs);
		if(user.getDou() == null)
		{
			user.setDou(0);
		}
		
		SysConfigWithBLOBs bloBs = sysConfigService.getSysConfig();
		mv.addObject("maxprice", bloBs.getMaxPrice());
		mv.addObject("minprice", bloBs.getMinPricce());
		
		mv.addObject("douNum", user.getDou());
		mv.addObject("userId", user.getId());
		return mv;
	}
	
	/**
	 * 用户买入感恩豆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/buy_dou.htm"})
	public ModelAndView buy_dou(HttpServletRequest request, HttpServletResponse response, String Id, String dealUserId){

		ModelAndView mv = new JModelAndView("buyer/angel_bean_buy.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		Long userId = user.getId();
		Long douLogId = Long.valueOf(Id);
		doulog doulogs = this.doulogService.getByKey(douLogId);
		BigDecimal totalPrice = doulogs.getPrice().multiply(new BigDecimal(doulogs.getTotalDouNum()));
		BigDecimal rate = LeeUtil.getConfigInstance().getBenefitRate();
		//税后0.9
		BigDecimal userMoney = totalPrice.multiply(Globals.AMALL_RATE);
		//2 8比例8
		BigDecimal canCarry = userMoney.multiply(rate);
		
		if(totalPrice.compareTo(BigDecimal.ZERO) <= 0)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单异常状态");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
			return mv;
		}
		
		if(douLogId == null)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "没有找到这个订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
			return mv;
		}
		

		if(doulogs.getType()!=(short)0)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "此订单交易已成功");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
			return mv;
		}
		
		if((doulogs.getUserId()!=null && doulogs.getUserId().equals(userId) )  || 
				(doulogs.getDealUserId()!=null  &&  Long.valueOf(doulogs.getDealUserId()).equals(userId) ) )
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "不能对自己的订单进行交易");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
			return mv;
		}
		
		//买入
		System.out.println("dealUserId : " + dealUserId);
		if(dealUserId == null)
		{
			if(user.getCurrentFee() == null)
			{
				user.setCurrentFee(BigDecimal.ZERO);
			}
			BigDecimal nowcarry=(BigDecimal) (user.getCanCarry()==null?BigDecimal.ZERO:user.getCanCarry());
			BigDecimal nowmanage=(BigDecimal) (user.getManageMoney()==null?BigDecimal.ZERO:user.getManageMoney());
			
			//if(user.getCurrentFee().compareTo(totalPrice) < 0)
			if((nowcarry.add(nowmanage)).compareTo(totalPrice) < 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "金额不足");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
				return mv;
			}
			
			if(user.getCanCarry() == null)
			{
				user.setCanCarry(BigDecimal.ZERO);
			}
			
			if(user.getManageMoney() == null)
			{
				user.setManageMoney(BigDecimal.ZERO);
			}
			
			userMoneyDetail moneyDetail = new userMoneyDetail();
			
			if(user.getManageMoney().compareTo(totalPrice) >= 0)
			{
				user.setManageMoney(user.getManageMoney().subtract(totalPrice));
				
				moneyDetail.setCanCarry(user.getCanCarry());
				moneyDetail.setManageMoney(user.getManageMoney().subtract(totalPrice));
				
			}else{
				user.setCanCarry(user.getCanCarry().subtract(totalPrice.subtract(user.getManageMoney())));
				user.setManageMoney(BigDecimal.ZERO);
			
				moneyDetail.setCanCarry(user.getCanCarry().subtract(totalPrice.subtract(user.getManageMoney())));
				moneyDetail.setManageMoney(BigDecimal.ZERO);
			}
			
			if(user.getDou() == null)
			{
				user.setDou(0);
			}
			
			
			moneyDetail.setAddTime(new Date());
			moneyDetail.setDetailFee(BigDecimal.ZERO.subtract(totalPrice));
			moneyDetail.setDetailTx(9);
			moneyDetail.setRemark("买入感恩豆扣除");
			moneyDetail.setUserId(user.getId());
			this.userMoneyDetailService.add(moneyDetail);
			
			user.setCurrentFee(user.getCurrentFee().subtract(totalPrice));
			user.setDou(user.getDou() + doulogs.getTotalDouNum());
			userService.updateByObject(user);
			
			//type == 5 代表是买卖感恩豆手续费
			PlatformEarningDetail detail = new PlatformEarningDetail(new Date(), totalPrice.subtract(userMoney), 5, userId, totalPrice);
			platformEarningDetailService.add(detail);
			
			doulogs.setDealDouNum(doulogs.getTotalDouNum());
			doulogs.setDealUserId(Integer.valueOf(String.valueOf(user.getId())));
			doulogs.setDealtime(new Date());
			doulogs.setType((short)1);
			doulogs.setTax(totalPrice.subtract(userMoney));
			this.doulogService.updateByObject(doulogs);
			
			User dealUser = userService.getByKey(Long.valueOf(doulogs.getUserId()));
			
			if(dealUser.getCanCarry() == null)
			{
				dealUser.setCanCarry(BigDecimal.ZERO);
			}
			
			if(dealUser.getCurrentFee() == null)
			{
				dealUser.setCurrentFee(BigDecimal.ZERO);
			}
			
			if(dealUser.getManageMoney() == null)
			{
				dealUser.setManageMoney(BigDecimal.ZERO);
			}
			
			userMoneyDetail moneyDetail2 = new userMoneyDetail();
			moneyDetail2.setAddTime(new Date());
			moneyDetail2.setCanCarry(dealUser.getCanCarry().add(canCarry));
			moneyDetail2.setDetailFee(userMoney);
			moneyDetail2.setDetailTx(10);
			moneyDetail2.setManageMoney(dealUser.getManageMoney().add(userMoney.subtract(canCarry)));
			moneyDetail2.setRemark("卖出感恩豆添加");
			moneyDetail2.setUserId(dealUser.getId());
			this.userMoneyDetailService.add(moneyDetail2);
			
			dealUser.setCurrentFee(dealUser.getCurrentFee().add(userMoney));
			dealUser.setCanCarry(dealUser.getCanCarry().add(canCarry));
			dealUser.setManageMoney(dealUser.getManageMoney().add(userMoney.subtract(canCarry)));
			userService.updateByObject(dealUser);
			mv.addObject("op_title", "交易成功！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
			//卖出
		}else{
			
			doulogExample doulogExample = new doulogExample();
			doulogExample.clear();
			doulogExample.setOrderByClause("addTime desc");
			doulogExample.createCriteria().andUserIdEqualTo(Long.valueOf(dealUserId)).andTotalDouNumGreaterThan(0);
			List<doulog> activeLog = this.doulogService.getObjectList(doulogExample);
			
			//Long BossId = new Long(57125);
			Integer doustatus = user.getStatus() == null ? 0 : user.getStatus();
			System.out.println("user.getstatus =: " + user.getStatus());
			if(activeLog != null && activeLog.size() > 0 && !doustatus.equals(9000))
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					String date2 = DateUtil.getCurrentTime(new Date());
					String date3 = DateUtil.getCurrentTime(activeLog.get(0).getAddtime());
					Date date1 = format.parse(date2);
					Date date = format.parse(date3);
					
					Calendar calendar = Calendar.getInstance();
					calendar.setFirstDayOfWeek(Calendar.MONDAY);
					calendar.setTime(date);
					int aWeek = calendar.get(Calendar.WEEK_OF_YEAR);
					
					Calendar calendar1 = Calendar.getInstance();
					calendar1.setFirstDayOfWeek(Calendar.MONDAY);
					calendar1.setTime(date1);
					int aWeek1 = calendar1.get(Calendar.WEEK_OF_YEAR);
					
					if(aWeek == aWeek1)
					{
						mv = new JModelAndView("error.html",
								this.configService.getSysConfig(),
								this.userConfigService.getUserConfig(), 1, request,
								response);
						mv.addObject("op_title", "每周只能卖出一次");
						mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
						return mv;
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			//等于user，不要看字面
			User user2 = userService.getByKey(Long.valueOf(dealUserId));
			//买家
			User user3 = this.userService.getByKey(Long.valueOf(doulogs.getDealUserId()));
			
			if(user2 == null)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "订单异常状态");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
				return mv;
			}
			
			if(user2.getDou() == null)
			{
				user2.setDou(0);
			}
			
			BigDecimal nowcarry=(BigDecimal) (user3.getCanCarry()==null?BigDecimal.ZERO:user3.getCanCarry());
			BigDecimal nowmanage=(BigDecimal) (user3.getManageMoney()==null?BigDecimal.ZERO:user3.getManageMoney());
			//检测买家余额
			if(nowcarry.add(nowmanage).compareTo(totalPrice) < 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "卖出失败，买家（对方）余额不足");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
				return mv;
			}
			if(user.getDou() == null)
			{
				user.setDou(0);
			}
			if((user.getDou() * 0.1) < doulogs.getTotalDouNum())
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "每次只能卖出感恩豆的10％哦");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
				return mv;
			}
			//检测卖家豆。提前检测，防止执行到中途出错。已发布卖出先扣豆，但此处是卖给已发布想买豆的
			if(user.getDou()==null ||  doulogs.getTotalDouNum().compareTo(user.getDou()) > 0)
			{
				mv = new JModelAndView("error.html",
						this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request,
						response);
				mv.addObject("op_title", "剩余感恩豆不足");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
				return mv;
			}
			
			
			if(user2.getCanCarry() == null)
			{
				user2.setCanCarry(BigDecimal.ZERO);
			}
			
			if(user2.getCurrentFee() == null)
			{
				user2.setCurrentFee(BigDecimal.ZERO);
			}
			
			if(user2.getManageMoney() == null)
			{
				user2.setManageMoney(BigDecimal.ZERO);
			}
			
			userMoneyDetail moneyDetail2 = new userMoneyDetail();
			moneyDetail2.setAddTime(new Date());
			moneyDetail2.setCanCarry(user2.getCanCarry().add(canCarry));
			moneyDetail2.setDetailFee(userMoney);
			moneyDetail2.setDetailTx(10);
			moneyDetail2.setManageMoney(user2.getManageMoney().add(userMoney.subtract(canCarry)));
			moneyDetail2.setRemark("卖出感恩豆添加");
			moneyDetail2.setUserId(user2.getId());
			this.userMoneyDetailService.add(moneyDetail2);
			
			user2.setDou(user2.getDou() - doulogs.getTotalDouNum());
			user2.setCurrentFee(user2.getCurrentFee().add(userMoney));
			user2.setCanCarry(user2.getCanCarry().add(canCarry));
			/*user2.setManageMoney(user2.getManageMoney().add(userMoney.subtract(canCarry)));*/
			user2.setIntegral(user2.getIntegral()+userMoney.subtract(canCarry).intValue());
			userService.updateByObject(user2);
			VipActiveLog log = new VipActiveLog();
			log.setAddtime(new Date());
			log.setContent("用户卖豆所得代金券");
			log.setUserId(user2.getId());
			log.setFinancialGold(userMoney.subtract(canCarry).intValue());
			userVipActiveService.add(log);
			
			userMoneyDetail moneyDetail = new userMoneyDetail();
			
			if(user3.getCurrentFee() == null)
			{
				user3.setCurrentFee(BigDecimal.ZERO);
			}
			if(user3.getCanCarry() == null)
			{
				user3.setCanCarry(BigDecimal.ZERO);
			}
			if(user3.getManageMoney() == null)
			{
				user3.setManageMoney(BigDecimal.ZERO);
			}

			user3.setCurrentFee(user3.getCurrentFee().subtract(totalPrice));
			if(user3.getManageMoney().compareTo(totalPrice) >= 0)
			{
				user3.setManageMoney(user3.getManageMoney().subtract(totalPrice));
				
				moneyDetail.setCanCarry(user3.getCanCarry());
				moneyDetail.setManageMoney(user3.getManageMoney().subtract(totalPrice));
			}else{
				user3.setCanCarry(user3.getCanCarry().subtract(totalPrice.subtract(user3.getManageMoney())));
				user3.setManageMoney(BigDecimal.ZERO);
				
				moneyDetail.setCanCarry(user3.getCanCarry().subtract(totalPrice.subtract(user3.getManageMoney())));
				moneyDetail.setManageMoney(BigDecimal.ZERO);
			}
			
			moneyDetail.setAddTime(new Date());
			moneyDetail.setDetailFee(BigDecimal.ZERO.subtract(totalPrice));
			moneyDetail.setDetailTx(9);
			moneyDetail.setRemark("买入感恩豆扣除");
			moneyDetail.setUserId(user3.getId());
			this.userMoneyDetailService.add(moneyDetail);
			
			user3.setDou(user3.getDou() + doulogs.getTotalDouNum());
			userService.updateByObject(user3);
			
			doulogs.setDealDouNum(doulogs.getTotalDouNum());
			doulogs.setUserId(Long.valueOf(dealUserId));
			doulogs.setDealtime(new Date());
			doulogs.setType((short)1);
			doulogs.setTax(totalPrice.subtract(userMoney));
			this.doulogService.updateByObject(doulogs);
			
			//type == 5 代表是买卖感恩豆手续费
			PlatformEarningDetail detail = new PlatformEarningDetail(new Date(), totalPrice.subtract(userMoney), 5, userId, totalPrice);
			platformEarningDetailService.add(detail);
			
			mv.addObject("op_title", "交易成功！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_sale.htm");
		}
		
		return mv;
	}
	
	/**
	 * 用户查看自己的感恩豆买卖记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/buyer/angel_bean_detail.htm"})
	public ModelAndView buy_dou_list(HttpServletRequest request, HttpServletResponse response, String statuss , Integer currentPage){
		
		ModelAndView mv = new JModelAndView("buyer/angel_bean_detail.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		Long userId = user.getId();
		if(null == currentPage){
			currentPage = 0;
		}
		DouDetailExample doudetailexample = new DouDetailExample ();
		doudetailexample.clear ();
		doudetailexample.setOrderByClause ("addtime desc" + " limit" + " " + currentPage * 10 + " , " + 10);
		doudetailexample.createCriteria ().andUseridEqualTo (userId);
		List <DouDetail> doudetail = this.doudetailService.selectByExample (doudetailexample);
		
		
		if(doudetail == null || doudetail.size() <= 0)
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "暂无豆交易记录喔！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
			return mv;
		}
		
		mv.addObject("objs", doudetail);
		mv.addObject("userId", user.getId());
		mv.addObject("currentPage", currentPage);
		return mv;
	}
	
	/**
	 * 销售价格限制接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/dou_config.htm"})
	public ModelAndView dou_config(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mv = new JModelAndView("login.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		SysConfigWithBLOBs config = sysConfigService.getSysConfig();
		
		mv.addObject("MaxPrice", config.getMaxPrice());
		mv.addObject("MinPrice", config.getMinPricce());
		return mv;
	}
	
	/**
	 * 获取趋势数据接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/angel_bean_trend.htm"})
	public ModelAndView dou_trend(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mv = new JModelAndView("buyer/angel_bean_trend.html",
				this.configService.getSysConfig(), 
				this.userConfigService.getUserConfig(), 
				1 , request, response);
		
		User user = SecurityUserHolder.getCurrentUser();
		if(user == null)
		{
			mv = new JModelAndView("login.html",
					this.configService.getSysConfig(), 
					this.userConfigService.getUserConfig(), 
					1 , request, response);
			
			return mv;
		}
		
		trendExample trendExample = new trendExample();
		trendExample.setOrderByClause("id asc");
		List<trend> trends = trendService.getObjectList(trendExample);
		
		if(trends == null )
		{
			mv = new JModelAndView("error.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单不存在");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/angel_bean_buy.htm");
			return mv;
		}
		
		mv.addObject("obj", trends);
		
		return mv;
	}
	
}
