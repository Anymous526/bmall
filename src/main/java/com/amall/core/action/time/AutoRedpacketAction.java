package com.amall.core.action.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.CommonValues;
import com.amall.common.constant.Globals;
import com.amall.common.tools.Json;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPackgeExample;
import com.amall.core.bean.RedPaper;
import com.amall.core.bean.User;
import com.amall.core.push.jpush.JPush;
import com.amall.core.service.IRedPackgeService;
import com.amall.core.service.IRedPaperService;
import com.amall.core.service.user.IUserService;

@Component("Redpacket_job")
public class AutoRedpacketAction
{

	Logger log = Logger.getLogger (AutoRedpacketAction.class);

	@Autowired
	private IRedPaperService redPaperService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRedPackgeService redPackgeService;

	/**
	 * 系统自动发红包
	 * 
	 * @author wangyong
	 * @Data 2016.11.11
	 * 
	 */
	public void AutoRedpackgeJob ( )
		{
			//不再发红包啦
		 	if(true){
		 		return;
		 	}
		 	
			Random random = new Random ();
			int a = random.nextInt (100);
			SimpleDateFormat toDay = new SimpleDateFormat ("yyyy-MM-dd");
			RedPackgeExample packgeExample = new RedPackgeExample ();
			packgeExample.clear ();
			packgeExample.setOrderByClause ("add_time desc");
			packgeExample.createCriteria ().andUpgradeLevelEqualTo (3);
			List <RedPackge> list = this.redPackgeService.getObjectList (packgeExample);
			Date date = null;
			if (list == null || list.size () == 0)
			{
				date = new Date (01);
			}
			else
			{
				date = list.get (0).getAddTime ();
			}
			Date dt = new Date ();
			String date1 = toDay.format (date);
			String dt1 = toDay.format (dt);
			if (!date1.equals (dt1))
			{
				if (a > 96)
				{
					log.info ("开始自动发红包---------");
					log.info ("随机数字是：" + a);
					AlipayOrder order = new AlipayOrder ();
					order.setUserId (new Long (1));
					// 系统app发红包
					examineRedPaper (order);
					log.info ("自动发红包结束---------");
				}
				else
				{
					log.info ("随机数字小于95---------数字是： " + a);
				}
				Calendar rightNow = Calendar.getInstance ();
				int hour = rightNow.get (Calendar.HOUR_OF_DAY);
				if (hour > 21)
				{
					log.info ("到了22点还没有发出去就强制发出---------");
					AlipayOrder order = new AlipayOrder ();
					order.setUserId (new Long (1));
					// 系统app发红包
					examineRedPaper (order);
					log.info ("强制发红包结束---------");
				}
			}
			else
			{
				log.info ("今天已经发了红包了----------");
			}
		}

	/**
	 * 生成红包
	 * 
	 * @param sendUserId
	 * @param redNumber
	 * @param sendType
	 * @param redPackgeType
	 * @param upgradeLevel
	 */
	private void examineRedPaper (AlipayOrder order)
		{
			RedPackge redPackge = new RedPackge ();
			User sendUser = this.userService.getByKey (order.getUserId ());
			if (sendUser != null)
			{
				/* 发送系统红包 */
				// LeeConfig leeConfig = LeeConfigurationBuilder.getInstance().parseConfiguration();
				int upgradeLevel = 3;
				/* 系统发当前订单金额的20%的礼品金红包 */
				int totalGold = CommonValues.SYSTEM_SEND_TOTALGOLD;
				int redNumber = CommonValues.SYSTEM_SEND_REDPAPER_TOTALNUM;
				if (totalGold > 0)
				{
					redPackge.setAddTime (new Date ());
					redPackge.setRedNumber (redNumber);
					redPackge.setRedPackgeRemain (redNumber);
					redPackge.setRedPackgeType ("1");
					redPackge.setSendType (Globals.NUBER_ZERO);
					redPackge.setTotalGold (totalGold);
					redPackge.setUpgradeLevel (upgradeLevel);
					redPackge.setUserId (sendUser.getId ());
					this.redPackgeService.add (redPackge);
					RedPaper redPaper = null;
					for (int i = 0 ; i < CommonValues.SYSTEM_SEND_REDPAPER_NUM_ONE ; i++)
					{
						Random ranSort = new Random ();
						int sort = ranSort.nextInt (10) + 1;
						redPaper = new RedPaper ();
						redPaper.setAddtime (new Date ());
						redPaper.setGold (CommonValues.SYSTEM_SEND_REDPAPER_GLOD_ONE);
						redPaper.setSort (sort);
						redPaper.setSendUserId (sendUser.getId ());
						redPaper.setUserRedPackgeId (redPackge.getId ());
						this.redPaperService.add (redPaper);
					}
					for (int i = 0 ; i < CommonValues.SYSTEM_SEND_REDPAPER_NUM_FIVE ; i++)
					{
						Random ranSort = new Random ();
						int sort = ranSort.nextInt (10) + 1;
						redPaper = new RedPaper ();
						redPaper.setAddtime (new Date ());
						redPaper.setGold (CommonValues.SYSTEM_SEND_REDPAPER_GLOD_FIVE);
						redPaper.setSort (sort);
						redPaper.setSendUserId (sendUser.getId ());
						redPaper.setUserRedPackgeId (redPackge.getId ());
						this.redPaperService.add (redPaper);
					}
					/* 推送红包 */
					Map <String, String> map = new HashMap <> ();
					map.put ("userId" , sendUser.getId ().toString ());
					map.put ("userName" , "天使A猫");
					map.put ("id" , redPackge.getId ().toString ());
					map.put ("key" , "sendRedPaper");
					JPush.sendMessageWithPassThroughAll (Json.gson.toJson (map) , null);
					log.info ("推送红包结束--------");
				}
			}
		}
}
