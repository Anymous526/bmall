package com.amall.core.web.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.SmsVerification;
import com.amall.core.bean.SmsVerificationExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.ISmsVerificationService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;

@Component
public class SendSMSVerification {

	@Autowired
	private ISmsVerificationService verificationService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISysConfigService configService;
	
	/**
	 * 判断该手机是否有发送记录
	 * @param phone
	 * @return
	 */
	public SmsVerification isExistPhoneInVerification(String phone)
	{
		SmsVerification verification = null;
		SmsVerificationExample example = new SmsVerificationExample();
    	example.createCriteria().andSmsPhoneEqualTo(phone.trim());
    	List<SmsVerification> list = this.verificationService.getObjectList(example);
    	if(!list.isEmpty())
    	{
    		verification = list.get(0);
    	}
    	return verification;
	}
	
	/**
	 * 判断该手机号是否存在于已注册用户中
	 * @param phone
	 * @return
	 */
	public boolean isExistPhoneInUser(String phone)
	{
		UserExample example = new UserExample();
    	example.createCriteria().andTelephoneEqualTo(phone.trim());
    	if(this.userService.getObjectListCount(example) > 0)
    	{
    		return true;
    	}
    	
    	return false;
	}
	
	/**
	 * 判断是否超出当天最大发送条数限制
	 * @return
	 */
	public boolean isExceedMaxSmsNum(SmsVerification verification)
	{
		int maxNumber = this.configService.getSysConfig().getSmsMaxNumber();
		
		//判断和上条发送时间是否是同一天
		boolean flag = CommUtil.isSameDay(verification.getSmsCreateDate(), 
				String.valueOf(System.currentTimeMillis()));
		
		if(flag)
		{
			if(maxNumber > verification.getSmsCount())
			{
				return false;
			}
		}
		else
		{
			//清空发送条数
			verification.setSmsCount(Globals.NUBER_ZERO);
			verificationService.updateByObject(verification);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 判断是否超出设置的发送间隔
	 * @param verification
	 * @return
	 */
	public boolean isSendInterval(SmsVerification verification)
	{
		long interval = CommUtil.getTimeInterval(verification.getSmsCreateDate(), 
				String.valueOf(System.currentTimeMillis()));
		int configInterval = this.configService.getSysConfig().getSmsSendInterval();
		
		if(configInterval > interval)
		{
			return true;
		}
		
		return false;
	}
	
}
