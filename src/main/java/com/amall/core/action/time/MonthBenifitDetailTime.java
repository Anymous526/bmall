package com.amall.core.action.time;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.WeekBenifit;
import com.amall.core.bean.WeekBenifitDetail;
import com.amall.core.bean.WeekBenifitDetailExample;
import com.amall.core.bean.WeekBenifitExample;
import com.amall.core.bean.doulog;
import com.amall.core.service.BonusPoolDetailService;
import com.amall.core.service.BonusPoolService;
import com.amall.core.service.MonthBenifitDedtailService;
import com.amall.core.service.MonthBenifitService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.sun.org.apache.regexp.internal.recompile;

@Component("participationInProfitJob")
public class MonthBenifitDetailTime {

	Logger log = Logger.getLogger(MonthBenifitDetailTime.class);

	@Autowired
	private ISysConfigService sysConfigService;

	@Autowired
	private BonusPoolService bonusPoolService;

	@Autowired
	private BonusPoolDetailService bonusPoolDetailService;

	@Autowired
	private MonthBenifitDedtailService monthBenifitDetailService;

	@Autowired
	private MonthBenifitService monthBenifitService;

	@Autowired
	private IDoulogService doulogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	public void execute() {
		try {
			participationInProfit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void participationInProfit() {
		// 获取当前周
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		System.out.println((long) calendar.get(Calendar.WEEK_OF_YEAR));
		int thisweek = calendar.get(Calendar.WEEK_OF_YEAR);
		//配置1，分红最低推荐人数
		Long minusers=1L;
		//配置2，钱，2 8 分
		BigDecimal eight = new BigDecimal(0.8);
		//配置3，钱，2 8 分
		BigDecimal two = new BigDecimal(0.2);
		

		List<WeekBenifit> weekBenifits = new ArrayList<WeekBenifit>();
		List<WeekBenifitDetail> weekBenifitDetails = new ArrayList<WeekBenifitDetail>();
		WeekBenifitExample example = new WeekBenifitExample();
		example.clear();
		example.createCriteria().andWeekEqualTo((long) thisweek);
		weekBenifits = bonusPoolService.query(example);

		if (null != weekBenifits && weekBenifits.size() > 0) {
			if (weekBenifits.get(0).getUsers() > 0) {
				if (weekBenifits.get(0).getTotalamount().compareTo(new BigDecimal(0)) > 0) {
					//orders本来用于排行的，现在用于是否已经分红，避免出现bug重复分红
					WeekBenifitDetailExample example2 = new WeekBenifitDetailExample();
					example2.clear();
					example2.createCriteria().andWeekEqualTo((long) thisweek).andUsersGreaterThanOrEqualTo(minusers).andOrdersEqualTo(0L).andBuyedstatusEqualTo(true);
					weekBenifitDetails = bonusPoolDetailService.queryBenifutDetail(example2);
					
					if(weekBenifitDetails==null || weekBenifitDetails.size()==0)
						return;
					
					// 总点数
					int count = 0;
					for (WeekBenifitDetail weekBenifitDetail : weekBenifitDetails) {
						count += weekBenifitDetail.getUsers();
					}
					
					
					if(count<=1 &&  weekBenifitDetails.size()>1){
						System.out.println("本周分红错误，请检查代码");
						return;
					}
					
					// 总豆金额
					BigDecimal douPrice = new BigDecimal(0);
					if (null != weekBenifits.get(0).getDou()
							&& weekBenifits.get(0).getDou().compareTo(new BigDecimal(0)) > 0) {
						douPrice = weekBenifits.get(0).getDou();
					}


					/* 除去豆金额 */
					// 每点数分钱
					BigDecimal amount = weekBenifits.get(0).getTotalamount()
							.subtract(douPrice)
							.divide(new BigDecimal(count), RoundingMode.DOWN)
							.setScale(2, RoundingMode.DOWN);
					
					//重要，上值有可能为负数，因为总豆可能大于总钱。
					if(amount.compareTo(new BigDecimal("0.00"))<=0)
						amount=new BigDecimal("0.00");
					
					/* 平均每人豆比例 */

					/* 返回豆 */
					SysConfigWithBLOBs config = sysConfigService.getSysConfig();
					//当日豆价格
					BigDecimal priceDou = config.getMinPricce();

					// 每点数分豆
					BigDecimal scale = douPrice.divide(
							new BigDecimal(count), RoundingMode.DOWN).setScale(
							2, RoundingMode.DOWN);

					/* 金额2,8分 */ //严重bug如果amount是1分，结果将变成0。必须先算出总额再 28分，否则28加起来可能不等于总额，哪怕差1分
					

					/* 平摊 */
					for (WeekBenifitDetail weekBenifitDetail2 : weekBenifitDetails) {

						User user = new User();
						user = userService.getByKey(weekBenifitDetail2.getUserId());
						//本人点数
						Long users=weekBenifitDetail2.getUsers();
						//本人总现金金额
						BigDecimal amountUser=amount.multiply(
								new BigDecimal(users)).setScale(2,
								RoundingMode.DOWN);
						
						//分豆
						BigDecimal douBenifit=new BigDecimal(0.00);int dounum =0;
						if (scale.compareTo(new BigDecimal(0)) > 0) {
							//本人总豆金额
							douBenifit = scale.multiply(
									new BigDecimal(users)).setScale(2,
											RoundingMode.DOWN);
							//本人总豆数量
							dounum=douBenifit.divide(priceDou,2,RoundingMode.DOWN).setScale(2,RoundingMode.DOWN).intValue();
							
							if(user.getDou()==null)
								user.setDou(0);

							user.setDou(user.getDou()+dounum);
							
							/* 记录豆日志 */
							doulog doulog = new doulog();
							doulog.setAddtime(new Date());
							doulog.setDealtime(new Date());
							doulog.setUserId(1L);
							doulog.setDealUserId(Integer.valueOf(user.getId()+ ""));
							doulog.setTotalDouNum(dounum);
							doulog.setDealDouNum(dounum);
							doulog.setType((short) 12);
							doulog.setPrice(priceDou);
							this.doulogService.add(doulog);
						}
						//分钱(现金)
						if (amount.compareTo(new BigDecimal(0)) > 0) {
							
							if(user.getCanCarry()==null)
								user.setCanCarry(new BigDecimal("0.00"));
							if(user.getManageMoney()==null)
								user.setManageMoney(new BigDecimal("0.00"));
							if(user.getHistoryFee()==null)
								user.setHistoryFee(new BigDecimal("0.00"));
							if(user.getCurrentFee()==null)
								user.setCurrentFee(new BigDecimal("0.00"));
							
							user.setCanCarry(user.getCanCarry().add(
									amountUser.multiply(eight).setScale(2,
											RoundingMode.DOWN)));

							user.setManageMoney(user.getManageMoney().add(
									amountUser.multiply(two).setScale(2,
											RoundingMode.DOWN)));

							user.setHistoryFee(user.getHistoryFee().add(
									amountUser));
							
							user.setCurrentFee(user.getCurrentFee().add(
									amountUser));
							
							userService.updateByObject(user);
							
							//分红明细表置位
							
							weekBenifitDetail2.setAmount(amountUser.add(douBenifit));
							weekBenifitDetail2.setDou(douBenifit);
							//临时用于已分红，避免重复。不用于排序了
							weekBenifitDetail2.setOrders(1L);
							this.bonusPoolDetailService.updateByObject (weekBenifitDetail2);

							
							//分红记录
							MutualBenefit mutualBenefit = new MutualBenefit();
							mutualBenefit.setAddTime(new Date());
							mutualBenefit.setGetUserId(user.getId());
							mutualBenefit.setGiveUserId(1L);
							mutualBenefit.setMutualFee(amountUser);
							mutualBenefitService.add(mutualBenefit);
						}
					}
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			System.out.println("没有可分红的人数");
			return;
		}

	}
}
