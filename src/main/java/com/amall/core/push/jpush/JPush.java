package com.amall.core.push.jpush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.amall.common.tools.DateUtils;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public abstract class JPush
{

	static Logger log = Logger.getLogger (JPush.class);

	private static final JPushClient jpushClient = new JPushClient (JPushConfig.APP_ID , JPushConfig.APP_KEY);

	/**
	 * @Title: sendNotifyAll
	 * @Description: 给所有平台所有用户发通知
	 * @param msg
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月30日
	 */
	public static void sendNotifyAll (String msg , String ... tags)
		{
			sendContent (buildPushPayload (msg , Platform.all () , false , tags));
		}

	/**
	 * @Title: sendNotifyAllForAndroid
	 * @Description: 发送到安卓
	 * @param msg
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月30日
	 */
	public static void sendNotifyAllForAndroid (String msg , String ... tags)
		{
			sendContent (buildPushPayload (msg , Platform.android () , false , tags));
		}

	/**
	 * @Title: sendNotifyAllForIOS
	 * @Description: 发送到IOS
	 * @param msg
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月30日
	 */
	public static void sendNotifyAllForIOS (String msg , String ... tags)
		{
			sendContent (buildPushPayload (msg , Platform.ios () , false , tags));
		}

	/**
	 * @Title: sendMessageOfPassThroughAll
	 * @Description: 透传发送信息到所有平台
	 * @param msg
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月30日
	 */
	public static void sendMessageWithPassThroughAll (String msg , String ... tags)
		{
			sendModeSelect (msg , tags);
		}

	/**
	 * @Title: sendMessageWithPassThroughOfAndroid
	 * @Description: 透传信息到安卓
	 * @param msg
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月30日
	 */
	public static void sendMessageOfAndroid (String msg , String ... tags)
		{
			sendContent (buildPushPayload (msg , Platform.android () , true , tags));
		}
	
	
	
	/**
	 * @Title : sendMessageUnique
	 * @Deprecated ： 点对点发送
	 * @param msg
	 * @param deviceType
	 * @param registrationID
	 */
	public static PushResult sendMessageUnique (Map<String, String> msgMap , String deviceType , String ... registrationID)
		{
			PushResult pushResult = null;
			if (deviceType != null && deviceType.equals ("Android"))
			{
				try
				{
					 pushResult=JPush.jpushClient.sendAndroidNotificationWithRegistrationID("亲" ,"你的账号于"+DateUtils.formatTime (new Date ())+"在电脑登入", msgMap , registrationID);
				}
				catch (APIConnectionException | APIRequestException e)
				{
					e.printStackTrace ();
				}
			}
			if (deviceType != null && deviceType.equals ("Ios"))
			{
				try
				{
					 pushResult=JPush.jpushClient.sendIosNotificationWithRegistrationID("亲，你的账号于"+DateUtils.formatTime (new Date ())+"在电脑登入" , msgMap , registrationID);
				}
				catch (APIConnectionException | APIRequestException e)
				{
					e.printStackTrace ();
				}
			}
			return pushResult;
		}
	

	/**
	 * 选择发送消息的模式
	 * 
	 * @param msg
	 * @param tags
	 */
	private static void sendModeSelect (String msg , String ... tags)
		{
			boolean isDelayed = false;
			List <String> list = new ArrayList <> ();
			String [ ] tagArr = null;
			if (tags != null)
			{
				isDelayed = true;
				list.addAll (Arrays.asList (tags));
			}
			if (JPushConfig.isTest)
			{
				list.add (JPushConfig.TEST_MODE);
			}
			if (!list.isEmpty ())
			{
				tagArr = new String [list.size ()];
				for (int i = 0 ; i < list.size () ; i++)
				{
					tagArr[i] = list.get (i);
				}
			}
			else
			{
				tagArr = null;
			}
			if (isDelayed)
			{
				sendContentDelayed (buildPushPayload (msg , Platform.all () , true , tagArr));
			}
			else
			{
				sendContent (buildPushPayload (msg , Platform.all () , true , tagArr));
			}
		}

	private static void sendContent (final PushPayload payload)
		{
			new Thread (new Runnable ()
			{

				@Override
				public void run ( )
					{
						PushResult result;
						try
						{
							result = jpushClient.sendPush (payload);
							log.info ("Got result - " + result);
						}
						catch (APIConnectionException e)
						{
							e.printStackTrace ();
						}
						catch (APIRequestException e)
						{
							e.printStackTrace ();
						}
					}
			}).start ();
			log.info ("send message " + payload.toString ());
		}

	private static void sendContentDelayed (final PushPayload payload)
		{
			new Thread (new Runnable ()
			{

				@Override
				public void run ( )
					{
						try
						{
							/* 由于app订阅tag需要一定时间，所以消息推送延迟10秒 */
							Thread.sleep (10000);
							 jpushClient.sendPush (payload);
						}
						catch (APIConnectionException e)
						{
							log.error ("Connection error, should retry later" , e);
						}
						catch (APIRequestException e)
						{
							log.error ("Should review the error, and fix the request" , e);
							log.error ("HTTP Status: " + e.getStatus ());
							log.error ("Error Code: " + e.getErrorCode ());
							log.error ("Error Message: " + e.getErrorMessage ());
						}
						catch (InterruptedException e)
						{
							e.printStackTrace ();
						}
					}
			}).start ();
		}

	/**
	 * @Title: buildPushPayload
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param msg
	 * @param platform
	 * @param isMsg
	 *            是否是消息
	 * @param tags
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年4月1日
	 */
	private static PushPayload buildPushPayload (String msg , Platform platform , boolean isMsg , String ... tags)
		{
			Builder builder = PushPayload.newBuilder ();
			builder.setPlatform (platform);
			if (isMsg)
			{
				builder.setMessage (Message.content (msg));
			}
			else
			{
				builder.setNotification (Notification.alert (msg));
			}
			if (tags != null)
			{
				builder.setAudience (Audience.tag (tags));
			}
			else
			{
				builder.setAudience (Audience.all ());
			}
			return builder.build ();
		}

//	public static void main (String [ ] args)
//		{
//			Map <String, String> map = new HashMap <> ();
//			map.put ("userId" , "34447");
//			map.put ("userName" , "匿名");
//			map.put ("id" , "11");
//			map.put ("key" , "sendRedPaper");
//			JPush.sendMessageWithPassThroughAll (Json.gson.toJson (map) , null);
//		}
}
