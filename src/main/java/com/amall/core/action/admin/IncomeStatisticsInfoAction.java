package com.amall.core.action.admin;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.MutualBenefitExample;
import com.amall.core.bean.PlatformEarningDetailExample;
import com.amall.core.bean.RechargeBenefit;
import com.amall.core.bean.RechargeBenefitExample;
import com.amall.core.bean.RechargeLog;
import com.amall.core.bean.RechargeLogExample;
import com.amall.core.bean.RechargeLogExample.Criteria;
import com.amall.core.bean.ShopBenefitExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.lee.IPlatformEarningDetailService;
import com.amall.core.service.lee.IRechargeBenefitService;
import com.amall.core.service.lee.IRechargeLogService;
import com.amall.core.service.lee.IShopBenefitService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.service.user.IUserVipActiveService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: IncomeStatisticsInfoAction
 * </p>
 * <p>
 * Description: 收入统计信息
 * </p>
 * 
 * @author ygq
 * @date 2016年4月12日下午11:34:00
 * @version 1.0
 */
@Controller
public class IncomeStatisticsInfoAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IRechargeLogService rechargeLogService;

	@Autowired
	private IRechargeBenefitService rechargeBenefitService;

	@Autowired
	private IUserVipActiveService userVipActiveService;

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	@Autowired
	private IShopBenefitService shopBenefitService;

	@Autowired
	private IPlatformEarningDetailService platformEarningDetailService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	/**
	 * @Title: recharge_info
	 * @Description: 用户充值列表
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author ygq
	 * @date 2016年3月30日
	 */
	@RequestMapping({ "/admin/recharge_info.htm" })
	public ModelAndView recharge_info (HttpServletRequest request , HttpServletResponse response , String currentPage , String telephone , String rechargeTime)
		{
			ModelAndView mv = new JModelAndView ("admin/recharge_info.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			RechargeLogExample example = new RechargeLogExample ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			example.setOrderByClause ("add_time desc");
			Criteria criteria = example.createCriteria ();
			if (StringUtils.isNotEmpty (telephone))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andTelephoneEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> users = userService.getObjectList (userExample);
				if (null != users && users.size () > 0)
				{
					criteria.andUserIdEqualTo (users.get (0).getId ());
				}
				else
				{
					criteria.andUserIdEqualTo (0l);
				}
			}
			if ("1".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("2".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("3".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			Pagination pList = this.rechargeLogService.getObjectListWithPage (example);
			RechargeBenefitExample rbe = new RechargeBenefitExample ();
			@SuppressWarnings("unchecked")
			List <RechargeLog> rechargeLogs = (List <RechargeLog>) pList.getList ();
			for (RechargeLog rechargeLog : rechargeLogs)
			{
				Calendar c = Calendar.getInstance ();
				c.setTime (rechargeLog.getAddTime ());
				c.add (Calendar.MINUTE , +1);
				rbe.clear ();
				rbe.createCriteria ().andGiveUserIdEqualTo (rechargeLog.getUserId ()).andAddTimeBetween (rechargeLog.getAddTime () , c.getTime ());
				List <RechargeBenefit> RechargeBenefits = rechargeBenefitService.getObjectList (rbe);
				rechargeLog.setRechargeBenefits (RechargeBenefits);
				;
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("telephone" , telephone);
			mv.addObject ("rechargeTime" , rechargeTime);
			return mv;
		}

	@RequestMapping({ "/admin/vip_active_info.htm" })
	public ModelAndView vip_active_info (HttpServletRequest request , HttpServletResponse response , String currentPage , String telephone , String rechargeTime)
		{
			ModelAndView mv = new JModelAndView ("admin/vip_active_info.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			VipActiveLogExample example = new VipActiveLogExample ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			example.setOrderByClause ("addTime desc");
			com.amall.core.bean.VipActiveLogExample.Criteria criteria = example.createCriteria ();
			if (StringUtils.isNotEmpty (telephone))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andTelephoneEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> users = userService.getObjectList (userExample);
				if (users.size () > 0)
					criteria.andUserIdEqualTo (users.get (0).getId ());
				else
					criteria.andUserIdEqualTo (0l);
			}
			if ("1".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			if ("2".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			if ("3".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			Pagination pList = this.userVipActiveService.getObjectListWithPage (example);
			@SuppressWarnings("unchecked")
			List <VipActiveLog> vipActiveLogs = (List <VipActiveLog>) pList.getList ();
			MutualBenefitExample mbe = new MutualBenefitExample ();
			for (VipActiveLog vipActiveLog : vipActiveLogs)
			{
				Calendar c = Calendar.getInstance ();
				c.setTime (vipActiveLog.getAddtime ());
				c.add (Calendar.MINUTE , +1);
				mbe.clear ();
				mbe.createCriteria ().andGiveUserIdEqualTo (vipActiveLog.getUserId ()).andAddTimeBetween (vipActiveLog.getAddtime () , c.getTime ());
				List <MutualBenefit> mutualBenefits = mutualBenefitService.getObjectList (mbe);
				vipActiveLog.setMutualBenefits (mutualBenefits);
				if (vipActiveLog.getPayUserId () == null)
					vipActiveLog.setPayUser (vipActiveLog.getUser ());
				else
				{
					User user = userService.getByKey (vipActiveLog.getPayUserId ());
					vipActiveLog.setPayUser (user);
				}
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("telephone" , telephone);
			mv.addObject ("rechargeTime" , rechargeTime);
			return mv;
		}

	@RequestMapping({ "/admin/store_benefit.htm" })
	public ModelAndView store_benefit (HttpServletRequest request , HttpServletResponse response , String currentPage , String telephone , String rechargeTime)
		{
			ModelAndView mv = new JModelAndView ("admin/store_benefit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			ShopBenefitExample shopBenefitExample = new ShopBenefitExample ();
			shopBenefitExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			shopBenefitExample.setOrderByClause ("add_time desc");
			com.amall.core.bean.ShopBenefitExample.Criteria criteria = shopBenefitExample.createCriteria ();
			if (StringUtils.isNotEmpty (telephone))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andTelephoneEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> users = userService.getObjectList (userExample);
				if (users.size () > 0)
				{
					User user = users.get (0);
					StoreExample storeExample = new StoreExample ();
					storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
					if (storeService.getObjectList (storeExample).size () > 0)
						criteria.andGiveShopIdEqualTo (storeService.getObjectList (storeExample).get (0).getId ());
					else
						criteria.andGiveShopIdEqualTo (0l);
				}
				else
					criteria.andGiveShopIdEqualTo (0l);
			}
			if ("1".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("2".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("3".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			Pagination pList = shopBenefitService.getObjectListWithPage (shopBenefitExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("telephone" , telephone);
			mv.addObject ("rechargeTime" , rechargeTime);
			return mv;
		}

	@RequestMapping({ "/admin/funds_management.htm" })
	public ModelAndView funds_management (HttpServletRequest request , HttpServletResponse response , String currentPage , String time)
		{
			ModelAndView mv = new JModelAndView ("admin/funds_management.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			PlatformEarningDetailExample pede = new PlatformEarningDetailExample ();
			pede.setOrderByClause ("add_time desc");
			pede.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			com.amall.core.bean.PlatformEarningDetailExample.Criteria criteria = pede.createCriteria ();
			if ("1".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("2".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("3".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			Pagination pList = platformEarningDetailService.getObjectListWithPage (pede);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("time" , time);
			return mv;
		}

	@RequestMapping({ "/admin/platform_earning.htm" })
	public ModelAndView platform_earning (HttpServletRequest request , HttpServletResponse response , String currentPage , String time)
		{
			ModelAndView mv = new JModelAndView ("admin/platform_earning.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			PlatformEarningDetailExample pede = new PlatformEarningDetailExample ();
			pede.setOrderByClause ("add_time desc");
			pede.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			com.amall.core.bean.PlatformEarningDetailExample.Criteria criteria = pede.createCriteria ();
			if ("1".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("2".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("3".equals (time))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			Pagination pList = platformEarningDetailService.getObjectListWithPage (pede);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("time" , time);
			return mv;
		}
}
