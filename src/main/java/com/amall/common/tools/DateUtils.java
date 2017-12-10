package com.amall.common.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间工具类
 * 
 * @Title DateUtils.java
 * @author dinglei
 * @Description TODO
 * @date 2016年6月22日 下午6:11:51
 * @version V1.0
 */
public class DateUtils
{

	public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";


	/**
	 * 
	 * @Title: 获取当前日期
	 * @Description TODO
	 * @return
	 */
	public static Date getCurrentDate ( )
		{
			Calendar calendar = Calendar.getInstance ();
			return calendar.getTime ();
		}


	public static Date getCurrentDate (	String format)
		{
			SimpleDateFormat df = new SimpleDateFormat (Format_DateTime);
			Date date = null;
			try
			{
				date = df.parse (format);
			}
			catch (ParseException e)
			{
				throw new RuntimeException (e);
			}
			return date;
		}


	/**
	 * 
	 * @Title: 将传入的开始时间 和结束时间 计算出 具体的天 、小时、分钟、秒
	 * @Description TODO
	 * @param begin
	 * @param end
	 * @returnmap key：时间单位描述（day、hour、min、second） value:具体对应的数
	 */
	public static Map <String, Long> cal_time_space (	Date begin , Date end)
		{
			long l = end.getTime () - begin.getTime ();
			long day = l / 86400000L;
			long hour = l / 3600000L - day * 24L;
			long min = l / 60000L - day * 24L * 60L - hour * 60L;
			long second = l / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60L;
			Map <String, Long> map = new HashMap <String, Long> ();
			map.put ("day" , Long.valueOf (day));
			map.put ("hour" , Long.valueOf (hour));
			map.put ("min" , Long.valueOf (min));
			map.put ("second" , Long.valueOf (second));
			return map;
		}


	/**
	 * 
	 * @Title: 是否是同一天
	 * @Description TODO
	 * @param oldDate
	 * @param newDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean isSameDay (	String oldDate , String newDate)
		{
			Date old = new Date (Long.valueOf (oldDate));
			Date newD = new Date (Long.valueOf (newDate));
			if (old.getYear () == newD.getYear () && old.getMonth () == newD.getMonth () && old.getDay () == newD.getDay ())
			{
				return true;
			}
			return false;
		}


	/**
	 * @Title: isContainTime
	 * @Description: 计算两个时间的间隔天数
	 * @param newDate
	 * @param oldDate
	 * @return
	 * @return int
	 * @author wuyaogang
	 * @date 2016年8月15日 下午5:27:10
	 */
	public static int isContainTime (	Date newDate , Date oldDate)
		{
			Long newTime = newDate.getTime ();
			Long oldTime = oldDate.getTime ();
			Long days = (newTime - oldTime) / (1000 * 60 * 60 * 24);
			return days.intValue ();
		}


	/**
	 * 格式化一个Date对象 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTime (	Date date)
		{
			if (null != date)
			{
				SimpleDateFormat df = new SimpleDateFormat (Format_DateTime);
				return df.format (date);
			}
			else
			{
				return "";
			}
		}


	/**
	 * @Title :  getCurrentFirstDay
	 * @Deprecated :  获取当前月第一天
	 * @author : liuguo
	 * @Date :  2017/06/22 10:53
	 */
	public static Date getCurrentFirstDay ( )
		{
			Calendar c = Calendar.getInstance ();
			c.add (Calendar.MONTH , 0);
			c.set (Calendar.DAY_OF_MONTH , 1);// 设置为1号,当前日期既为本月第一天
			return c.getTime ();
		}


	/**
	 * @Title : getCurrentLastDay
	 * @Deprecated :  获取当前月最后一天
	 * @author : liuguo
	 * @Date :  2017/06/22 10:53
	 */
	public static Date getCurrentLastDay ( )
		{
			Calendar ca = Calendar.getInstance ();
			ca.set (Calendar.DAY_OF_MONTH , ca.getActualMaximum (Calendar.DAY_OF_MONTH));
			return ca.getTime ();
		}
}
