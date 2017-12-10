package com.amall.common.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.amall.common.constant.Globals;

public class CNDateUtils extends DateUtils
{
	
	/** 
	* @Title: formatDate 
	* @Description: 根据格式转换日期
	* @param v
	* @param format
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月11日
	*/
	public static String formatDate(Object v, String format) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(v);
	}
	
	public static String formatDate(Object v) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(v);
	}
	
	public static String formatUnionDate(Object v) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(v);
	}
	
	/** 
	* @Title: formatLongDate 
	* @Description: yyyy-MM-dd HH:mm:ss
	* @param v
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月11日
	*/
	public static String formatLongDate(Object v)
	{
		return formatDate(v, "yyyy-MM-dd HH:mm:ss");
	}
	
	/** 
	* @Title: formatShortDate 
	* @Description: yyyy-MM-dd
	* @param v
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月11日
	*/
	public static String formatShortDate(Object v)
	{
		return formatDate(v, "yyyy-MM-dd");
	}
	
	/** 
	* @Title: isSameDay 
	* @Description: 是否是同一天
	* @param time1 currentTimeMillis()
	* @param time2 currentTimeMillis()
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年12月23日
	*/
	public static boolean isSameDay(Long time1, Long time2)
	{
		return isSameDay(new Date(time1), new Date(time2));
	}
	
	/**
	 * 计算两次时间的间隔
	 * @param oldTime
	 * @param newTime
	 * @return 秒
	 */
	public static long getTimeInterval(String oldTime, String newTime)
	{
		return (Long.valueOf(newTime) - Long.valueOf(oldTime)) / Globals.MILLISECOND_TO_SECOND;
	}
	
	/**
	 * 
	 * <p>
	 * Title: formatTime
	 * </p>
	 * <p>
	 * Description: 将传入的object类型，按照传入的指定格式 格式化，转换为String类型
	 * </p>
	 * 
	 * @param format
	 *            指定的格式
	 * @param v
	 *            object
	 * @return String 转换后的字符串
	 */
	public static String formatTime(String format, Object v) {
		if (v == null)
			return null;
		if (v.equals(""))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(v);
	}
	
	public static final String parseTZDate(String source) throws ParseException {
		if (source == null || source.length() == 0) {
			return null;
		}
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		return dateFormat1.format(StringToDate(source,"yyyy-MM-dd HH:mm:ss"));

	}
    
    public static Date StringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
    
    public static String formatTimeByDate(Date date) {
        return date == null ? "" : formatDate(date, "yyyyMMddHHmmss");
    }
    
    public static Date addMinutes(Date srcDate, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(srcDate);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }
    
    public static Date subtractHour(Date srcDate, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(srcDate);
        cal.add(Calendar.HOUR, -hours);
        return cal.getTime();
    }
    
    public static Date subtractDay(Date srcDate, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(srcDate);
        cal.add(Calendar.DAY_OF_MONTH, -day);
        return cal.getTime();
    }
}
