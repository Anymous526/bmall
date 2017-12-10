package com.amall.core.lee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.common.constant.Globals;
import com.amall.common.tools.CNNumberUtils;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.MutualBenefitExample;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.PlatformBenefitDetail;
import com.amall.core.bean.PlatformEarningDetail;
import com.amall.core.bean.RechargeBenefit;
import com.amall.core.bean.RechargeBenefitExample;
import com.amall.core.bean.ShopBenefit;
import com.amall.core.bean.ShopBenefitExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserCashDepositLog;
import com.amall.core.bean.UserCashDepositLogExample;
import com.amall.core.bean.doulog;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.gold.IUserMoneyDetailService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.lee.IPlatformBenefitDetailService;
import com.amall.core.service.lee.IPlatformEarningDetailService;
import com.amall.core.service.lee.IRechargeBenefitService;
import com.amall.core.service.lee.IShopBenefitService;
import com.amall.core.service.lee.IUserCashDepositLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.user.IUserService;

/**
 * 分利
 * 
 * @author dinglei
 *
 */
@Service
@Transactional
public class LeeServiceImpl implements LeeService
{

	static Logger log = Logger.getLogger (LeeServiceImpl.class);

	private static LeeConfig leeConfig = null;
	// 初始化加载leeConfig
	static
	{
		if (null == leeConfig)
		{
			LeeConfigurationBuilder leeConfigBuilder = LeeConfigurationBuilder.getInstance ();
			leeConfig = leeConfigBuilder.parseConfiguration ();
		}
	}

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	@Autowired
	private IRechargeBenefitService rechargeBenefitService;

	@Autowired
	private IPlatformEarningDetailService platformEarningDetailService;

	@Autowired
	private IUserCashDepositLogService cashDepositLogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IShopBenefitService shopBenefitService;

	@Autowired
	private IPlatformBenefitDetailService platformBenefitDetailService;
	
	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IGoodsService goodsSerivce;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IUserMoneyDetailService userMoneyDetailService;
	
	@Autowired
	private IDoulogService doulogService;
	
	@Override
	public void hzLee (User user , BigDecimal upgradeAmount)
		{
			/* 平台收入 */
			Long newPlatformId = setNewPlatformEarningDetail (user.getId () , upgradeAmount , upgradeAmount , LeeConfig.LEEHZTYPE);
			/* 互助奖的处理(直接,间接,三级) */
			/* 平台支出金额 */
			BigDecimal platformFee = new BigDecimal (0);
			/* 升级会员的直接推荐人 */
			User directUser = userService.getByKey (user.getDirectRefer ());
			// 支出等级
			Integer level = leeConfig.getV_zero ().getLevel ();
			/* 如果直接推荐人不存在,则升级的金额直接给平台 */
			if (directUser != null)
			{
				log.info ("directUser : " + directUser.getUsername ());
				log.info ("直接推荐人互助分红开始");
				platformFee = saveHzBenefitAndUpdateUser (user , directUser , upgradeAmount , platformFee);
				log.info ("直接推荐人互助分红结束");
				User inDirectReferUser = userService.getByKey (directUser.getDirectRefer ());
				/* 间接推荐人不存在。间接消费商不分红 */
				if (inDirectReferUser != null && inDirectReferUser.getLevelAngel () >= Globals.NUBER_THREE)
				{
					log.info ("inDirectReferUser : " + inDirectReferUser.getUsername ());
					level = leeConfig.getV_three ().getLevel ();
					log.info ("间接推荐人互助分红开始");
					platformFee = saveHzIndirectAndUpdateUser (user , inDirectReferUser , upgradeAmount , platformFee);
					log.info ("间接推荐人互助分红结束");
					/*
					 * User superReferUser = userService.getByKey(inDirectReferUser
					 * .getDirectRefer());
					 * // 三级推荐人不存在
					 * if (superReferUser != null) {
					 * log.info("superReferUser : " + superReferUser.getUsername());
					 * level = leeConfig.getV_two().getLevel();
					 * log.info("三级推荐人互助分红开始");
					 * platformFee = saveHzBenefitAndUpdateUser(user,
					 * superReferUser, upgradeAmount,
					 * platformFee);
					 * log.info("三级推荐人互助分红结束");
					 * }
					 */
				}
			}
			/* 保存平台支出金额 */
			if (platformFee.compareTo (BigDecimal.ZERO) > 0)
			{
				PlatformBenefitDetail beneFitDetail = new PlatformBenefitDetail (new Date () , platformFee , level , LeeConfig.LEEHZTYPE , newPlatformId , user.getId ());
				platformBenefitDetailService.add (beneFitDetail);
			}
		}

	/**
	 * 直接互助金保存
	 * 
	 * @param giveUser
	 * @param gainUser
	 * @param amount
	 * @param platformFee
	 * @return
	 */
	public BigDecimal saveHzBenefitAndUpdateUser(User giveUser, User gainUser,
            BigDecimal amount, BigDecimal platformFee) 
    {
        if(null == gainUser.getLevelAngel() || gainUser.getLevelAngel() == Globals.NUBER_ZERO){
        	
        	return new BigDecimal(0.0);
        }
        //if(giveUser.getLevelAngel() ==  Globals.NUBER_TWO){	//直接为消费商可分红
        //	return new BigDecimal(0.0);
        //}
        log.info("保存推荐人的互助奖信息 giveUser " + giveUser.getUsername()
                   + " giveUser " + gainUser.getUsername() + " amount " + amount
                   + " platformFee " + platformFee);
        
        try {
        	BigDecimal benefitRate = BigDecimal.ZERO;
            BigDecimal distributionAmount = BigDecimal.ZERO;
           //
            benefitRate = LeeUtil.getVipInstance (giveUser.getLevelAngel ()).getHzLee ();
            
            log.info("benefitRate="+benefitRate);
            distributionAmount = getFeeDownOfRate(amount, benefitRate);
            log.info("distributionAmount : " + distributionAmount);
            

            /* 平台所不得金额 */
            platformFee = platformFee.add(distributionAmount);

            log.info("保存推荐人的互助奖开始");
            /* 保存推荐人的互助奖记录 */
            MutualBenefit mutualBenefit = new MutualBenefit();
            mutualBenefit.setAddTime(new Date());
            mutualBenefit.setMutualFee(distributionAmount);
            mutualBenefit.setGiveUser(giveUser);
            mutualBenefit.setGetUser(gainUser);
            mutualBenefitService.add(mutualBenefit);
            log.info("保存推荐人的互助奖结束");

            /* 更新推荐人的总额 */
            BigDecimal currentFee = gainUser.getCurrentFee();
            BigDecimal historyFee = gainUser.getHistoryFee();
            if (currentFee == null) {
                currentFee = BigDecimal.ZERO;
            }
            if (historyFee == null) {
                historyFee = BigDecimal.ZERO;
            }
            
            BigDecimal rate = LeeUtil.getConfigInstance().getBenefitRate();
        	BigDecimal rate2 = (new BigDecimal(1)).subtract(rate);
        	
        	userMoneyDetail detail = new userMoneyDetail();
			detail.setAddTime(new Date());
			detail.setCanCarry(gainUser.getCanCarry () != null ? gainUser.getCanCarry ().add (distributionAmount.multiply (rate)) : distributionAmount.multiply (rate));
			detail.setDetailFee(distributionAmount);
			detail.setDetailTx(2);
			detail.setManageMoney(gainUser.getManageMoney () != null ? gainUser.getManageMoney ().add (distributionAmount.multiply (rate2)) : distributionAmount.multiply (rate2));
			detail.setRemark("直接推荐人互助金");
			detail.setUserId(gainUser.getId());
			this.userMoneyDetailService.add(detail);
        	
        	gainUser.setCanCarry(gainUser.getCanCarry() != null ? gainUser.getCanCarry().add(distributionAmount.multiply(rate)) : distributionAmount.multiply(rate));
        	gainUser.setManageMoney(gainUser.getManageMoney() != null ? gainUser.getManageMoney().add(distributionAmount.multiply(rate2)) : distributionAmount.multiply(rate2));
            
            gainUser.setCurrentFee(currentFee.add(distributionAmount));
            gainUser.setHistoryFee(historyFee.add(distributionAmount));
            userService.updateByObject(gainUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return platformFee;

    }

	/**
	 * 间接推荐人分利保存
	 */
	public BigDecimal saveHzIndirectAndUpdateUser(User giveUser, User gainUser,
            BigDecimal amount, BigDecimal platformFee) 
    {
    	 if(null == gainUser.getLevelAngel() || gainUser.getLevelAngel() <= Globals.NUBER_TWO){
         	
         	return new BigDecimal(0.0);
         }
        log.info("保存推荐人的互助奖信息 giveUser " + giveUser.getUsername()
                   + " giveUser " + gainUser.getUsername() + " amount " + amount
                   + " platformFee " + platformFee);
        
        try {
        	BigDecimal benefitRate = BigDecimal.ZERO;
            BigDecimal distributionAmount = BigDecimal.ZERO;
          
            //
            benefitRate = LeeUtil.getVipInstance (giveUser.getLevelAngel ()).getItLee ();
            distributionAmount = getFeeDownOfRate(amount, benefitRate);
            log.info("distributionAmount : " + distributionAmount);

            /* 平台所得金额 */
            platformFee = platformFee.add(distributionAmount);

            log.info("保存推荐人的互助奖开始");
            /* 保存推荐人的互助奖记录 */
            MutualBenefit mutualBenefit = new MutualBenefit();
            mutualBenefit.setAddTime(new Date());
            mutualBenefit.setMutualFee(distributionAmount);
            mutualBenefit.setGiveUser(giveUser);
            mutualBenefit.setGetUser(gainUser);
            mutualBenefitService.add(mutualBenefit);
            log.info("保存推荐人的互助奖结束");

            /* 更新推荐人的总额 */
            BigDecimal currentFee = gainUser.getCurrentFee();
            BigDecimal historyFee = gainUser.getHistoryFee();
            if (currentFee == null) {
                currentFee = BigDecimal.ZERO;
            }
            if (historyFee == null) {
                historyFee = BigDecimal.ZERO;
            }
            
            BigDecimal rate = LeeUtil.getConfigInstance().getBenefitRate();//0.8
        	BigDecimal rate2 = (new BigDecimal(1)).subtract(rate);
        	
        	userMoneyDetail detail = new userMoneyDetail();
			detail.setAddTime(new Date());
			detail.setCanCarry(gainUser.getCanCarry () != null ? gainUser.getCanCarry ().add (distributionAmount.multiply (rate)) : distributionAmount.multiply (rate));
			detail.setDetailFee(distributionAmount);
			detail.setDetailTx(3);
			detail.setManageMoney(gainUser.getManageMoney () != null ? gainUser.getManageMoney ().add (distributionAmount.multiply (rate2)) : distributionAmount.multiply (rate2));
			detail.setRemark("间接接推荐人互助金");
			detail.setUserId(gainUser.getId());
			this.userMoneyDetailService.add(detail);
        	
        	gainUser.setCanCarry(gainUser.getCanCarry() != null ? gainUser.getCanCarry().add(distributionAmount.multiply(rate)) : distributionAmount.multiply(rate));
        	gainUser.setManageMoney(gainUser.getManageMoney() != null ? gainUser.getManageMoney().add(distributionAmount.multiply(rate2)) : distributionAmount.multiply(rate2));
            
            gainUser.setCurrentFee(currentFee.add(distributionAmount));
            gainUser.setHistoryFee(historyFee.add(distributionAmount));
            userService.updateByObject(gainUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return platformFee;

    }

	@Override
	public void fhLee (OrderFormItem formItem)
		{
			/* 不参与分红的情况 */
			if (NotUserJionBenefit (formItem))
			{
				System.out.println ("zheli?");
				return;
			}
			log.info ("用户参与店铺分利订单 ：" + formItem.getGoodsName ());
			/* 获取店铺用户 */
			if (formItem == null)
			{
				return;
			}
			if (formItem.getOrderForm () == null)
			{
				return;
			}
			if (formItem.getOrderForm ().getStore () == null)
			{
				return;
			}
			if (formItem.getOrderForm ().getStore ().getUser () == null)
			{
				return;
			}
			User storeUser = formItem.getOrderForm ().getStore ().getUser ();
			User user = new User();
			user = userService.getByKey(storeUser.getId());
			BigDecimal castFee = new BigDecimal (0.00);
			OrderFormWithBLOBs orderfb = orderFormService.getByKey (formItem.getOrderId ());
			if (orderfb.getAutoConfirmSms () == true)
			{
				log.info ("分配给卖家感恩豆");
				log.info("user.getDou="+user.getDou());
				log.info("storeUser.getDou="+storeUser.getDou());
				
				BigDecimal price = orderfb.getTotalprice ().subtract (orderfb.getGoodsAmount ());	// 所消费代金券
					//豆不用加入金额明细了吧
					/*
					userMoneyDetail moneyDetail2 = new userMoneyDetail();
					moneyDetail2.setAddTime(new Date());
					moneyDetail2.setCanCarry(storeUser.getCanCarry());
					moneyDetail2.setDetailFee(orderfb.getBeanAmount());
					moneyDetail2.setDetailTx(10);
					moneyDetail2.setManageMoney(storeUser.getManageMoney ().add (orderfb.getBeanAmount()));
					moneyDetail2.setRemark("返还卖家感恩豆");
					moneyDetail2.setUserId(storeUser.getId());
					this.userMoneyDetailService.add(moneyDetail2);
					*/
					if(null == storeUser.getDou()){
						storeUser.setDou(0);
					}
					/* 获取该商品的利率，豆也要按比例分红哦 */
					BigDecimal goodsRate = getRateByOrderFormItem (formItem);
					//分红的豆，取ceil，如1.2 ，取2
					int benifitDou=orderfb.getBeanNum().multiply(goodsRate).divide(new BigDecimal("1"), 0, RoundingMode.CEILING).intValue();
					int storeAddDou=orderfb.getBeanNum().intValue()-benifitDou;
					System.out.println ("storeAddDou="+storeAddDou);
					storeUser.setDou(user.getDou()+storeAddDou);
					int effected=userService.updateUsers (storeUser);
					if(effected==0){
						System.out.println ("更新user dou失败return:"+storeUser.getId()+"-"+storeAddDou);
						return;
					}

					/* 保存豆记录 */
					doulog dl = new doulog ();
					dl.setAddtime(new Date ());
					dl.setDealtime (new Date ());
					dl.setUserId (Long.valueOf (1));//注意：
					dl.setDealUserId(Integer.valueOf(storeUser.getId()+""));
					dl.setTotalDouNum(storeAddDou);
					dl.setDealDouNum (storeAddDou);
					dl.setType ((short)4);
					this.doulogService.add(dl);
					
				
			}
			/* 消费金额，注意购物可使用豆，金额要减去豆 */
			//castFee = orderfb.getTotalprice ();
			castFee = orderfb.getGoodsAmount();
			//全豆支付后，可能为负值
			if(castFee.compareTo(BigDecimal.ZERO)<=0)
				castFee= new BigDecimal ("0.00");
			//豆的数量。不是整数是为将来做扩展
			BigDecimal doucastFee = new BigDecimal ("0.00");
			if(orderfb.getAutoConfirmSms()){
				doucastFee=orderfb.getBeanNum();
			}
			
			// castFee = formItem.getGoodsPrice ().multiply (new BigDecimal (formItem.getGoodsCount
			// ()));
			/* 获取该商品的利率 */
			//BigDecimal goodsRate = getGoodsRate (formItem);
			BigDecimal goodsRate = getRateByOrderFormItem (formItem);
			
			/* 获取参与分利的金额 */
			// BigDecimal totalFee = getFeeUpOfRate (castFee , goodsRate);
			BigDecimal totalFee = getFeeDownOfRate (castFee , goodsRate);
			/* 用户分利,并返回分利总金额 */
			BigDecimal userBenefit = toBenefitOfUser (storeUser , castFee ,  doucastFee, formItem.getOrderForm (),goodsRate);
			/* 保存平台分利 存储金额 = 消费金额 - (消费金额 * 利率) */
			setNewPlatformEarningDetail (storeUser.getId () , totalFee.subtract (userBenefit) , totalFee , LeeConfig.LEEFHTYPE);
			/* 更新店铺可用金额 */
			updateStoreCashMoney (this.storeService.getByKey (formItem.getOrderForm ().getStore ().getId ()) , castFee.subtract (totalFee));
		}

	@Override
	public void rechargeLee (User user , BigDecimal rechargeAmount)
		{
			/* 充值奖的处理(直接,间接,三级) */
			/* 平台收入 */
			Long newPlatform = setNewPlatformEarningDetail (user.getId () , rechargeAmount , rechargeAmount , LeeConfig.LEERECHARGETYPE);
			/* 平台支出金额 */
			BigDecimal platformFee = new BigDecimal (0);
			/* 会员充值分红对象 */
			RechargeBenefit rechargeBenefit = null;
			/* 平台充值分红对象 */
			// PlatformEarningDetail platformEarningDetail = null;
			// 支出等级
			Integer level = leeConfig.getV_zero ().getLevel ();
			/* 充值会员的直接推荐人 */
			User directUser = userService.getByKey (user.getDirectRefer ());
			/* 如果直接推荐人不存在,则充值的金额直接给平台 */
			if (directUser == null)
			{
				log.info ("直接推荐人不存在");
			}
			else
			{
				log.info ("直接推荐人充值奖分红开始");
				platformFee = saveRechargeBenefitAndUpdateUser (user , directUser , rechargeAmount , rechargeBenefit , platformFee);
				log.info ("直接推荐人充值奖分红结束");
				User inDirectReferUser = userService.getByKey (directUser.getDirectRefer ());
				/* 间接推荐人不存在 */
				if (inDirectReferUser == null)
				{
					log.info ("间接推荐人不存在");
				}
				else
				{
					log.info ("间接推荐人充值奖分红开始");
					platformFee = saveRechargeBenefitAndUpdateUser (user , inDirectReferUser , rechargeAmount , rechargeBenefit , platformFee);
					log.info ("间接推荐人充值奖分红结束");
					level = leeConfig.getV_three ().getLevel ();
					/*
					 * User superReferUser = userService.getByKey(inDirectReferUser
					 * .getDirectRefer());
					 * // 三级推荐人不存在
					 * if (superReferUser == null) {
					 * log.info("三级推荐人不存在");
					 * } else {
					 * log.info("三级推荐人充值奖分红开始");
					 * platformFee = saveRechargeBenefitAndUpdateUser(user,
					 * superReferUser, rechargeAmount, rechargeBenefit,
					 * platformFee);
					 * log.info("三级推荐人充值奖分红结束");
					 * level = leeConfig.getV_two().getLevel();
					 * }
					 */
				}
			}
			if (platformFee.compareTo (BigDecimal.ZERO) > 0)
			{
				PlatformBenefitDetail beneFitDetail = new PlatformBenefitDetail (new Date () , platformFee , level , LeeConfig.LEERECHARGETYPE , newPlatform , user.getId ());
				platformBenefitDetailService.add (beneFitDetail);
			}
		}

	public BigDecimal saveRechargeBenefitAndUpdateUser (User giveUser , User gainUser , BigDecimal amount , RechargeBenefit rechargeBenefit , BigDecimal platformFee)
		{
			/* 推荐人存在,处理推荐人的充值奖 */
			BigDecimal distributionAmount = BigDecimal.ZERO;
			/* 判断推荐人是否是天使会员,天使会员不会有充值奖 */
			if (gainUser.getLevelAngel () > 0)
			{
				BigDecimal benefitRate = LeeUtil.getVipInstance (gainUser.getLevelAngel ()).getRechargeLee ();
				distributionAmount = getFeeDownOfRate (amount , benefitRate);
				/* 平台所不得金额 */
				platformFee = platformFee.add (distributionAmount);
				log.info ("平台所不得金额 : " + platformFee);
				/* 保存推荐人的充值奖记录 */
				rechargeBenefit = new RechargeBenefit ();
				rechargeBenefit.setAddTime (new Date ());
				rechargeBenefit.setGiveUserId (giveUser.getId ());
				rechargeBenefit.setGetUserId (gainUser.getId ());
				rechargeBenefit.setRechargeFee (distributionAmount);
				rechargeBenefitService.add (rechargeBenefit);
				/* 更新推荐人的总额 */
				BigDecimal currentFee = gainUser.getCurrentFee ();
				BigDecimal historyFee = gainUser.getHistoryFee ();
				if (currentFee == null)
				{
					currentFee = BigDecimal.ZERO;
				}
				if (historyFee == null)
				{
					historyFee = BigDecimal.ZERO;
				}
				/* 更新推荐人的总额 */
				BigDecimal rate = LeeUtil.getConfigInstance ().getBenefitRate ();
				BigDecimal rate2 = (new BigDecimal (1)).subtract (rate);
				
				userMoneyDetail detail = new userMoneyDetail();
				detail.setAddTime(new Date());
				detail.setCanCarry(gainUser.getCanCarry () != null ? gainUser.getCanCarry ().add (distributionAmount.multiply (rate)) : distributionAmount.multiply (rate));
				detail.setDetailFee(distributionAmount);
				detail.setDetailTx(4);
				detail.setManageMoney(gainUser.getManageMoney () != null ? gainUser.getManageMoney ().add (distributionAmount.multiply (rate2)) : distributionAmount.multiply (rate2));
				detail.setRemark("推荐人充值奖");
				detail.setUserId(gainUser.getId());
				this.userMoneyDetailService.add(detail);
				
				gainUser.setCanCarry (gainUser.getCanCarry () != null ? gainUser.getCanCarry ().add (distributionAmount.multiply (rate)) : distributionAmount.multiply (rate));
				gainUser.setManageMoney (gainUser.getManageMoney () != null ? gainUser.getManageMoney ().add (distributionAmount.multiply (rate2)) : distributionAmount.multiply (rate2));
				gainUser.setCurrentFee (currentFee.add (distributionAmount));
				gainUser.setHistoryFee (historyFee.add (distributionAmount));
				userService.updateByObject (gainUser);
			}
			return platformFee;
		}

	/**
	 * @Title: setNewPlatformEarningDetail
	 * @Description: 新增平台收入记录
	 * @param giveUserId
	 *            给予用户ID
	 * @param fee
	 *            给予金额
	 * @param originalFee
	 *            原始金额
	 * @param type
	 *            给予类型
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private Long setNewPlatformEarningDetail (Long giveUserId , BigDecimal fee , BigDecimal originalFee , Integer type)
		{
			PlatformEarningDetail detail = new PlatformEarningDetail (new Date () , fee , type , giveUserId , originalFee);
			return platformEarningDetailService.add (detail);
		}

	/**
	 * @Title: updateStoreCashMoney
	 * @Description: 更新店铺可用金额
	 * @param store
	 *            店铺
	 * @param fee
	 *            获得金额,是扣除分利的后的金额
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private void updateStoreCashMoney (StoreWithBLOBs store , BigDecimal fee)
		{
			/* 更新店铺可提现额度 */
			BigDecimal storeFee = store.getCashAmount ();
			if (storeFee != null)
			{
				storeFee = storeFee.add (fee);
			}
			else
			{
				storeFee = new BigDecimal (0);
				storeFee = storeFee.add (fee);
			}
			store.setCashAmount (storeFee);
			storeService.updateByObject (store);
		}

	/**
	 * @Title: NotJionBenefit
	 * @Description: 用户不参与分利的情况
	 * @param formItem
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private boolean NotUserJionBenefit (OrderFormItem formItem)
		{
			if (formItem == null)
			{
				System.out.println ("formItem有空");
				return false;
			}
			if (formItem.getOrderForm () == null)
			{
				System.out.println ("formItem.getOrderForm ()有空");
				return false;
			}
			if (formItem.getOrderForm ().getStore () == null)
			{
				System.out.println ("formItem.getOrderForm ().getStore ()有空");
				return false;
			}
			if (formItem.getOrderForm ().getStore ().getUser () == null)
			{
				System.out.println ("formItem.getOrderForm ().getStore ().getUser ()有空");
				return false;
			}
			/* 获取店铺用户 */
			User storeUser = formItem.getOrderForm ().getStore ().getUser ();
			/* 不存在店铺用户则直接退出 */
			if (storeUser == null)
			{
				System.err.println ("store user is null");
				return true;
			}
			// OrderFormWithBLOBs orderfb = orderFormService.getByKey(formItem.getOrderId());
			// if(orderfb.getOrderType() != null && orderfb.getOrderType().equals("2000"))
			// {
			// System.out.println("orderfb.getOrderType() =========== " + orderfb.getOrderType());
			// return true;
			// }
			OrderFormWithBLOBs orderb = orderFormService.getByKey (formItem.getOrderId ());
			/* 消费金额 */
			BigDecimal castFee = orderb.getTotalprice ();
			// BigDecimal castFee = formItem.getGoodsPrice ().multiply (new BigDecimal
			// (formItem.getGoodsCount ()));
			/* 获取该商品的利率 */
			BigDecimal goodsRate = getGoodsRate (formItem);
			/* 若利率为空则不参与分利 */
			if (goodsRate == null || goodsRate.compareTo (new BigDecimal (0)) <= 0)
			{
				/* 更新店铺可用金 */
				updateStoreCashMoney ((StoreWithBLOBs) formItem.getOrderForm ().getStore () , castFee);
				return true;
			}
			/* 获取参与分利的金额 */
			// BigDecimal totalFee = getFeeUpOfRate (castFee , goodsRate);
			BigDecimal totalFee = getFeeDownOfRate (castFee , goodsRate);
			/* 若总分利金额小于一角，则直接存入平台账号，不参与分利 */
			if (totalFee.compareTo (new BigDecimal ("0.1")) < 0)
			{
				if (totalFee.compareTo (BigDecimal.ZERO) != 0)
				{
					// 更新平台金额
					setNewPlatformEarningDetail (storeUser.getId () , totalFee , totalFee , LeeConfig.LEEFHTYPE);
				}
				/* 更新店铺可用金 */
				updateStoreCashMoney ((StoreWithBLOBs) formItem.getOrderForm ().getStore () , castFee.subtract (totalFee));
				return true;
			}
			/* 若店铺用户没有直接推荐人, 分红直接放入平台 */
			// 新规则，有买家就要分红。故不能返回true
			/*
			 * if (storeUser.getDirectRefer () == null)
			 * {
			 * if (totalFee.compareTo (BigDecimal.ZERO) != 0)
			 * {
			 * setNewPlatformEarningDetail (storeUser.getId () , totalFee , totalFee ,
			 * LeeConfig.LEEFHTYPE);
			 * }
			 * //更新店铺可用金
			 * updateStoreCashMoney ((StoreWithBLOBs) formItem.getOrderForm ().getStore () ,
			 * castFee.subtract (totalFee));
			 * return true;
			 * }
			 */
			return false;
		}

	/**
	 * @Title: getGoodsRate
	 * @Description: 获取该商品的利率
	 * @param formItem
	 * @return
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private BigDecimal getGoodsRate (OrderFormItem formItem)
		{
			return formItem.getGoodsRate ();
		}

	/**
	 * @Title: toBenefitOfUser
	 * @Description: 用户分红,目前是3级分红
	 * @param storeUser
	 *            店铺用户
	 * @param benefitFee
	 *            分利总额
	 * @return 返回用户总共分走的金额
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private BigDecimal toBenefitOfUser (User storeUser , BigDecimal benefitFee , BigDecimal doucastFee,OrderForm orderForm, BigDecimal goodsrate)
		{
			/* 分利层数 LeeUtil.getConfigInstance ().getBenefitSize () */
			// int benefitSize = LeeUtil.getConfigInstance ().getBenefitSize ();
			int benefitSize = 1;
			BigDecimal rate = goodsrate;
			User tempUser = storeUser;		// 商家。*******注意啦：已改为消费者推荐人*****
			User ConsumerDirectUser = null;	// 消费者推荐人
			User ConsumerinDirectUser = null;	// 消费者间接推荐人  *******注意啦又添加间接，同时直接分红比例5->1
			User indirectUser = null;	// 间接推荐人
			User ConsumerUser = null;	// 消费者
			User directUser = null;	// 直接推荐人
			BigDecimal userTotalfee = BigDecimal.ZERO;
			while (benefitSize-- > 0)
			{
				/* 消费者 */
				ConsumerUser = userService.getByKey (orderForm.getUserId ());
				log.info ("消费者分利（已取消）=" + ConsumerUser.getUsername ());
				if(ConsumerUser!=null)
					ConsumerDirectUser = userService.getByKey (ConsumerUser.getDirectRefer ());
				if (ConsumerDirectUser != null)
					log.info ("消费者直接推荐人（已取消）=" + ConsumerDirectUser.getUsername ());
				if (ConsumerDirectUser != null)
					ConsumerinDirectUser = userService.getByKey (ConsumerDirectUser.getDirectRefer ());
				if (ConsumerinDirectUser != null)
					log.info ("消费者间接推荐人（已取消）=" + ConsumerinDirectUser.getUsername ());
				/* 获取直接推荐人 */
				if (tempUser != null)
					directUser = userService.getByKey (tempUser.getDirectRefer ());
				if (directUser != null)
					log.info ("商家直接推荐人=" + directUser.getUsername ());
				/* 获取间接推荐人 */
				if (directUser != null)
					indirectUser = userService.getByKey (directUser.getDirectRefer ());
				if (indirectUser != null)
					log.info ("商家间接推荐人=" + indirectUser.getUsername ());
				/* 不存在直接推荐人就退出循环 */
				/*
				 * if (tempUser == null)
				 * {
				 * break;
				 * }
				 */
				/*
				 * if(indirectUser == null){
				 * break;
				 * }
				 * if(ConsumerUser == null){
				 * break;
				 * }
				 */
				Integer level = tempUser.getLevelAngel ();
				/* 处理历史遗留数据 */
				if (level == null)
				{
					level = 0;
				}
				Integer levels = null;
				if (indirectUser != null)
					levels = indirectUser.getLevelAngel ();
				if (levels == null)
				{
					levels = 0;
				}
				/* 消费者直接利率 */
				// BigDecimal userRate = LeeUtil.getVipInstance (level).getFhLee ();
				BigDecimal storeUserRate = new BigDecimal (0.01);
				//if (rate != null && rate.compareTo (Globals.SPECIAL_BENIFIT_RATE) == 0)
				//{//固定5个点，现改为：总20，分5个点。20170915 又改为1个点
					//storeUserRate = new BigDecimal (0.05);
				//}
				//log.info ("当前消费者直接利率 ： " + storeUserRate);
				log.info ("当前消费者直接推荐人分红利率（已取消） ： " + storeUserRate);
				/* 消费者直接所分得金额 */
				BigDecimal storeuserBenefit = getFeeDownOfRate (benefitFee , storeUserRate);
				BigDecimal storeuserBenefitDou = getFeeDownOfRate (doucastFee , storeUserRate);
				log.info ("当前消费者直接所分得金额（已取消） ： " + storeuserBenefit);
				
				/* 消费者间接推荐人利率 */
				BigDecimal consumerinDirectUserRate = new BigDecimal (0.01);
				
				log.info ("当前消费者间接推荐人分红利率（已取消） ： " + consumerinDirectUserRate);
				/* 消费者直接所分得金额 */
				BigDecimal consumerinDirectUserBenefit = getFeeDownOfRate (benefitFee , consumerinDirectUserRate);
				BigDecimal consumerinDirectUserBenefitDou = getFeeDownOfRate (doucastFee , consumerinDirectUserRate);
				log.info ("当前消费者间接所分得金额（已取消） ： " + consumerinDirectUserBenefit);
				
				
				/* 用户(消费者)利率 */
				BigDecimal userRate = new BigDecimal (0.1);
				//if (rate != null && rate.compareTo (Globals.SPECIAL_BENIFIT_RATE) == 0)
				//{
					//商品分红减0.1（其他所有人分红之和）即为买家分红。现改为10点
					//userRate = rate.subtract(new BigDecimal ("0.1"));
					userRate =new BigDecimal ("0.1");
				//}
				if(userRate.compareTo(new BigDecimal ("0.00"))<=0)
					userRate=new BigDecimal ("0.00");
				log.info ("当前用户分红利率 （已取消）： " + userRate);
				/* 用户所分得金额 */
				BigDecimal userBenefit = getFeeDownOfRate (benefitFee , userRate);
				BigDecimal userBenefitDou = getFeeDownOfRate (doucastFee , userRate);
				log.info ("用户所分得金额 （已取消）： " + userBenefit);
				/* 直接推荐人利率 */
				BigDecimal tempuserRate = new BigDecimal (0.01);
				log.info ("店铺直接推荐人分红利率 ： " + tempuserRate);
				/* 直接推荐人用户所分得金额 */
				BigDecimal tempuserBenefit = getFeeDownOfRate (benefitFee , tempuserRate);
				BigDecimal tempuserBenefitDou = getFeeDownOfRate (doucastFee , tempuserRate);
				log.info ("店铺直接用户所分得金额 ： " + tempuserBenefit);
				/* 间接推荐人利率 */
				BigDecimal indirectuserRate = new BigDecimal (0.01);
				log.info ("店铺间接推荐人分红利率 ： " + indirectuserRate);
				/* 间接推荐人用户所分得金额 */
				BigDecimal indirectuserBenefit = getFeeDownOfRate (benefitFee , indirectuserRate);
				BigDecimal indirectuserBenefitDou = getFeeDownOfRate (doucastFee , indirectuserRate);
				log.info ("店铺间接用户所分得金额 ： " + indirectuserBenefit);
				
				if (null != ConsumerDirectUser)//已取消,改为分红池
				{
					//if (storeuserBenefit.compareTo (BigDecimal.ZERO) != 0)
					if (true)	//里面已做限制。上面逻辑有bug，分红为0，但分红豆不为0
					{
						//saveUserBenefitFee (ConsumerDirectUser , storeuserBenefit , orderForm);
						//saveUserBenefitDou (ConsumerDirectUser , storeuserBenefitDou ,  orderForm);
					}
				}
				if (null != ConsumerinDirectUser)//已取消,改为分红池
				{
					//if (consumerinDirectUserBenefit.compareTo (BigDecimal.ZERO) != 0)
					if (true)	
					{
						//saveUserBenefitFee (ConsumerinDirectUser , consumerinDirectUserBenefit , orderForm);
						//saveUserBenefitDou (ConsumerinDirectUser , consumerinDirectUserBenefitDou ,  orderForm);
					}
				}
				
				if (null != ConsumerUser)//已取消，改为分红池
				{
					//if (userBenefit.compareTo (BigDecimal.ZERO) != 0)
					if (true)
					{
						//saveUserBenefitFee (ConsumerUser , userBenefit , orderForm);
						//saveUserBenefitDou (ConsumerUser , userBenefitDou ,  orderForm);
					}
				}
				//直接 消费商以上。已改为会员即可
				if (null != directUser //&& directUser.getLevelAngel()>=Globals.NUBER_TWO
						)
				{
					//if (tempuserBenefit.compareTo (BigDecimal.ZERO) != 0)
					if (true)
					{
						saveUserBenefitFee (directUser , tempuserBenefit , orderForm);
						saveUserBenefitDou (directUser , tempuserBenefitDou ,  orderForm);
					}
				}
				//间接 联盟商以上，即消费商没有
				if (null != indirectUser && indirectUser.getLevelAngel()>=Globals.NUBER_THREE)
				{
					//if (indirectuserBenefit.compareTo (BigDecimal.ZERO) != 0)
					if (true)
					{
						saveUserBenefitFee (indirectUser , indirectuserBenefit , orderForm);
						saveUserBenefitDou (indirectUser , indirectuserBenefitDou ,  orderForm);
					}
				}
				userTotalfee = userTotalfee.add (storeuserBenefit).add (indirectuserBenefit).add (tempuserBenefit).add (userBenefit);
			}
			return userTotalfee;
		}

	/**
	 * @Title: saveUserBenefitFee
	 * @Description: 保存用户分利金额和分利记录
	 * @param benefitUser
	 * @param userBenefit
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private synchronized void saveUserBenefitFee (User benefitUser , BigDecimal userBenefit , OrderForm orderForm)
		{
			//加一限制，因为此项可能为0，但豆不为0
			if(userBenefit.compareTo(BigDecimal.ZERO)<=0) return;
			
			BigDecimal historyFee = benefitUser.getHistoryFee ();
			BigDecimal currentFee = benefitUser.getCurrentFee ();
			if (historyFee == null)
			{
				historyFee = BigDecimal.ZERO;
			}
			if (currentFee == null)
			{
				currentFee = BigDecimal.ZERO;
			}
			historyFee = historyFee.add (userBenefit);
			currentFee = currentFee.add (userBenefit);
			// BigDecimal rate = LeeUtil.getConfigInstance ().getBenefitRate ();
			BigDecimal rate = new BigDecimal ("0");
			// BigDecimal rate2 = (new BigDecimal (1)).subtract (rate);
			// BigDecimal rate2= new BigDecimal ("10");
			BigDecimal rate2 = new BigDecimal ("1");
			
			userMoneyDetail detail = new userMoneyDetail();
			detail.setAddTime(new Date());
			detail.setCanCarry(benefitUser.getCanCarry () != null ? benefitUser.getCanCarry ().add (userBenefit.multiply (rate)) : userBenefit.multiply (rate));
			detail.setDetailFee(userBenefit);
			detail.setDetailTx(7);
			detail.setManageMoney(benefitUser.getManageMoney () != null ? benefitUser.getManageMoney ().add (userBenefit.multiply (rate2)) : userBenefit.multiply (rate2));
			detail.setRemark("店铺分红");
			detail.setUserId(benefitUser.getId());
			this.userMoneyDetailService.add(detail);
			
			benefitUser.setCanCarry (benefitUser.getCanCarry () != null ? benefitUser.getCanCarry ().add (userBenefit.multiply (rate)) : userBenefit.multiply (rate));
			benefitUser.setManageMoney (benefitUser.getManageMoney () != null ? benefitUser.getManageMoney ().add (userBenefit.multiply (rate2)) : userBenefit.multiply (rate2));
			benefitUser.setHistoryFee (historyFee);
			benefitUser.setCurrentFee (currentFee);
			this.userService.updateByObject (benefitUser);
			/* 保存分红记录 */
			ShopBenefit shopBenefit = new ShopBenefit ();
			shopBenefit.setAddTime (new Date ());
			shopBenefit.setGetUserId (benefitUser.getId ());
			shopBenefit.setGiveShopId (orderForm.getStoreId ());
			shopBenefit.setOrderId (orderForm.getId ());
			shopBenefit.setShopFee (userBenefit);
			shopBenefitService.add (shopBenefit);
		}
	/**
	 * @Title: saveUserBenefitDou
	 * @Description: 保存用户分利豆
	 * @param benefitUser
	 * @param userBenefit
	 
	 */
	private synchronized void saveUserBenefitDou (User benefitUser , BigDecimal doucastFee , OrderForm orderForm)
		{
			if(benefitUser==null || doucastFee==null || orderForm==null)return;
			
			if(doucastFee.compareTo(BigDecimal.ZERO)<=0) return;
			
			Integer adddou=doucastFee.setScale(0, RoundingMode.FLOOR).intValue();
			if(adddou<=0)return;
			
			Integer dou = benefitUser.getDou();
			
			if (dou == null)
			{
				dou = 0;
			}
			
			dou = dou+adddou;
			
			benefitUser.setDou(dou);
			this.userService.updateUsers(benefitUser);
			
			/* 保存豆记录 */
			doulog dl = new doulog ();
			dl.setAddtime(new Date ());
			dl.setDealtime (new Date ());
			dl.setUserId (Long.valueOf (1));
			dl.setDealUserId(Integer.valueOf(benefitUser.getId()+""));
			dl.setTotalDouNum(adddou);
			dl.setDealDouNum (adddou);
			dl.setType ((short)5);
			this.doulogService.add(dl);
		}
	/**
	 * @Title: getFeeOfRate
	 * @Description: 进位取两位获取分利金额
	 * @param fee
	 * @param rate
	 * @return
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	private BigDecimal getFeeUpOfRate (BigDecimal fee , BigDecimal rate)
		{
			return fee.multiply (rate).setScale (2 , BigDecimal.ROUND_UP);
		}

	private BigDecimal getFeeDownOfRate (BigDecimal fee , BigDecimal rate)
		{
			return fee.multiply (rate).setScale (2 , BigDecimal.ROUND_DOWN);
		}

	/**
	 * 获取可提现金额
	 */
	@Override
	public BigDecimal getAllowWithdrawDeposit (User user)
		{
			/*
			 * BigDecimal rate = LeeUtil.getConfigInstance().getBenefitRate();
			 * BigDecimal historyFee = user.getHistoryFee();
			 * //购物消费金额
			 * BigDecimal shipFee = getAllGoodsPay(user);
			 * System.out.println("用户名：" + user.getUsername() + "购物消费金额: " + shipFee);
			 * if (historyFee != null) {
			 * historyFee =
			 * (historyFee.subtract(shipFee)).multiply(rate).setScale(2,BigDecimal.ROUND_DOWN);
			 * System.out.println("减去购物消费金额后的历史金额： " + historyFee);
			 * historyFee =
			 * historyFee.subtract(getAllAlreadyOutMoneyRecord(user).add(getAllBalancePay(user)));
			 * System.out.println("减去最终提现记录和升级记录后的可体现金额：" + historyFee);
			 * if((historyFee.compareTo(BigDecimal.ZERO)) < 0 ||
			 * user.getCurrentFee().compareTo(historyFee) <= 0)
			 * {
			 * historyFee = user.getCurrentFee().multiply(rate);
			 * }
			 * return historyFee;
			 * }
			 * return BigDecimal.ZERO;
			 */
			if (user.getCanCarry () != null)
			{
				return user.getCanCarry ();
			}
			return BigDecimal.ZERO;
		}

	/**
	 * 获取支付表里面所有的非升级订单金额
	 * 
	 * @param user
	 * @return
	 */
	public BigDecimal getAllGoodsPay (User user)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			AlipayOrderExample alipayOrderExample = new AlipayOrderExample ();
			alipayOrderExample.createCriteria ().andSellerUserIdEqualTo (user.getId ()).andPaymentIdEqualTo (new Long (10)).andCardTypeEqualTo (String.valueOf (2)).andIsRefundEqualTo (false);
			List <AlipayOrder> list = alipayOrderService.getObjectList (alipayOrderExample);
			if (!list.isEmpty ())
			{
				for (AlipayOrder log : list)
				{
					totalFee = totalFee.add (log.getTotalFee ());
				}
			}
			return totalFee;
		}

	/**
	 * 获取订单表里面所有用天使余额支付会员升级的总金额(包含购物退款的记录，退款后不允许提现了)
	 * 
	 * @param user
	 * @return
	 */
	public BigDecimal getAllBalancePay (User user)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			AlipayOrderExample alipayOrderExample = new AlipayOrderExample ();
			alipayOrderExample.createCriteria ().andSellerUserIdEqualTo (user.getId ()).andPaymentIdEqualTo (new Long (10)).andCardTypeEqualTo (String.valueOf (1)).andIsRefundEqualTo (true);
			List <AlipayOrder> list = alipayOrderService.getObjectList (alipayOrderExample);
			if (!list.isEmpty ())
			{
				for (AlipayOrder log : list)
				{
					totalFee = totalFee.add (log.getTotalFee ());
				}
			}
			return totalFee;
		}

	/**
	 * @Title: getAllAlreadyOutMoneyRecord
	 * @Description: 获取所有已经提现的记录
	 * @param user
	 * @return
	 * @throws @author tangxiang
	 * @date 2016年3月1日
	 */
	public BigDecimal getAllAlreadyOutMoneyRecord (User user)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			UserCashDepositLogExample cashDepositLogExample = new UserCashDepositLogExample ();
			cashDepositLogExample.createCriteria ().andUserIdEqualTo (user.getId ()).andRefuseMessageIsNull ();
			List <UserCashDepositLog> list = cashDepositLogService.getObjectList (cashDepositLogExample);
			if (!list.isEmpty ())
			{
				for (UserCashDepositLog log : list)
				{
					totalFee = totalFee.add (log.getFee ());
				}
			}
			return totalFee;
		}

	@Override
	public BigDecimal getAllMutualFee (Long userId)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			MutualBenefitExample mutualBenefitExample = new MutualBenefitExample ();
			mutualBenefitExample.createCriteria ().andGetUserIdEqualTo (userId);
			List <MutualBenefit> retList = mutualBenefitService.getObjectList (mutualBenefitExample);
			if (!retList.isEmpty ())
			{
				for (MutualBenefit mutualBenefit : retList)
				{
					totalFee = totalFee.add (mutualBenefit.getMutualFee ());
				}
			}
			return totalFee;
		}

	@Override
	public BigDecimal getAllShopBenefit (Long userId)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			ShopBenefitExample benefitExample = new ShopBenefitExample ();
			benefitExample.createCriteria ().andGetUserIdEqualTo (userId);
			List <ShopBenefit> retList = shopBenefitService.getObjectList (benefitExample);
			if (!retList.isEmpty ())
			{
				for (ShopBenefit benefit : retList)
				{
					totalFee = totalFee.add (benefit.getShopFee ());
				}
			}
			return totalFee;
		}

	@Override
	public BigDecimal getAllRechargeFee (Long userId)
		{
			BigDecimal totalFee = BigDecimal.ZERO;
			RechargeBenefitExample benefitExample = new RechargeBenefitExample ();
			benefitExample.createCriteria ().andGetUserIdEqualTo (userId);
			List <RechargeBenefit> retList = rechargeBenefitService.getObjectList (benefitExample);
			if (!retList.isEmpty ())
			{
				for (RechargeBenefit benefit : retList)
				{
					totalFee = totalFee.add (benefit.getRechargeFee ());
				}
			}
			return totalFee;
		}
	
	/**
	 * @Title : getRateByOrderForm
	 * @Deprecated : 获取分红比列
	 * @param orderForm
	 * @return ：BigDecimal
	 * @author : liuguo
	 * @Date : 017/06/09 15:32
	 */
	public BigDecimal getRateByOrderFormItem (OrderFormItem formitem)
		{
			BigDecimal rate = Globals.COMMON_BENIFIT_RATE;
			if (formitem != null)
			{
				try
				{
					//GoodsClassWithBLOBs goodsClass = this.goodsClassService.getByKey (this.goodsSerivce.getByKey (formitem.getGoodsId ()).getGcId ());
					//if (CNNumberUtils.checkModuleId (goodsClass.getModuleId ()))
					GoodsWithBLOBs goods= this.goodsSerivce.getByKey (formitem.getGoodsId ());
					if (goods.getGoodsRate()!=null)
					{
						// 厂价特卖分红比列 50%，已废弃
						rate = goods.getGoodsRate();
					}
					else
					{
						// 普通商品分红比列 15%，精确到某个商品，不是类goodsclass。当然商品统一为15%.注意数据库中有null
						rate =  Globals.COMMON_BENIFIT_RATE;
					}
					
				}
				catch (Exception e)
				{
					System.out.println ("获取分红比例错误:"+e.getMessage ());
				}
			}
			//可能为null,不能小于0.1
			if(rate==null || rate.compareTo(new BigDecimal("0.1"))<0)rate = Globals.COMMON_BENIFIT_RATE;
			return rate;
		}
}
