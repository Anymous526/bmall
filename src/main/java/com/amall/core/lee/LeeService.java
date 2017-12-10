package com.amall.core.lee;

import java.math.BigDecimal;

import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.User;

/**
 * @author tangxiang
 *
 */
public interface LeeService {
	
	/*互助奖*/
	public void hzLee(User user,BigDecimal upgradeAmount);
	
	/*分红奖*/
	public void fhLee(OrderFormItem formItem);
	
	/*充值奖*/
	public void rechargeLee(User user,BigDecimal rechargeAmount);
	
	/** 
	* @Title: getAllowWithdrawDeposit 
	* @Description: 可以提现的金额
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年3月1日
	*/
	public BigDecimal getAllowWithdrawDeposit(User user);
	
	/** 
	* @Title: getAllMutualFee 
	* @Description: 获取互助所有分利奖励
	* @param user
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年3月1日
	*/
	public BigDecimal getAllMutualFee(Long userId);
	
	
	/** 
	* @Title: getAllShopBenefit 
	* @Description: 获取店铺分利所有奖励 
	* @param user
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年3月1日
	*/
	public BigDecimal getAllShopBenefit(Long userId);
	
	
	/** 
	* @Title: getAllRechargeFee 
	* @Description: 获取充值所有分利奖励
	* @param user
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年3月1日
	*/
	public BigDecimal getAllRechargeFee(Long userId);
	
	/**
	 * getAllGoodsPay
	 * @Description:获取支付表里面所有的非升级订单金额
	 * @param user
	 * @return
	 * @author wangyong
	 */
	public BigDecimal getAllGoodsPay(User user);
	
	/**
	 * getAllBalancePay
	 * @Description:获取订单表里面所有用天使余额支付会员升级的总金额
	 * @param user
	 * @return
	 * @author wangyong
	 */
	public BigDecimal getAllBalancePay(User user);
	
	/**
	 * getAllAlreadyOutMoneyRecord
	 * @Description:获取所有已经提现的记录
	 * @param user
	 * @return
	 * @author wangyong
	 */
	public BigDecimal getAllAlreadyOutMoneyRecord(User user);
	

}
