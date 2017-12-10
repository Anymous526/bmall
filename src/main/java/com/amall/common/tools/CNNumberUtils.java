package com.amall.common.tools;

import java.math.BigDecimal;
import org.apache.commons.lang3.math.NumberUtils;
import com.amall.common.constant.Globals;

public class CNNumberUtils extends NumberUtils
{

	/**
	 * 判断是否为null，不是就直接返回，是就转换为int类型 默认是0
	 * 
	 * @param object
	 *            类型
	 * @return int类型
	 */
	public static int null2Int (Object s)
		{
			int v = 0;
			if (s != null)
				try
				{
					v = Integer.parseInt (s.toString ());
				}
				catch (Exception localException)
				{
				}
			return v;
		}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为float类型 默认是 0.0F
	 * 
	 * @param object
	 *            类型
	 * @return float类型
	 */
	public static float null2Float (Object s)
		{
			float v = 0.0F;
			if (s != null)
				try
				{
					v = Float.parseFloat (s.toString ());
				}
				catch (Exception localException)
				{
				}
			return v;
		}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为double类型 默认是0.0D
	 * 
	 * @param object
	 *            类型
	 * @return double类型
	 */
	public static double null2Double (Object s)
		{
			double v = 0.0D;
			if (s != null)
				try
				{
					v = Double.parseDouble (null2String (s));
				}
				catch (Exception localException)
				{
				}
			return v;
		}

	public static BigDecimal null2BigDecimal (Object s)
		{
			BigDecimal decimal = null;
			if (s != null)
				try
				{
					decimal = new BigDecimal (null2String (s));
					return decimal;
				}
				catch (Exception localException)
				{
				}
			return new BigDecimal (0);
		}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为boolean类型 默认是false
	 * 
	 * @param object
	 *            类型
	 * @return boolean类型
	 */
	public static boolean null2Boolean (Object s)
		{
			boolean v = false;
			if (s != null)
				try
				{
					v = Boolean.parseBoolean (s.toString ());
				}
				catch (Exception localException)
				{
				}
			return v;
		}

	/**
	 * 判断是否为null，是就转换为"" ,不是就去掉空格转换为String类型
	 * 
	 * @param object
	 *            类型
	 * @return String类型
	 */
	public static String null2String (Object s)
		{
			return s == null ? "" : s.toString ().trim ();
		}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为Long类型的 -1
	 * 
	 * @param object
	 * @return Long类型
	 */
	public static Long null2Long (Object s)
		{
			Long v = Long.valueOf (-1L);
			if (s != null)
				try
				{
					v = Long.valueOf (Long.parseLong (s.toString ()));
				}
				catch (Exception localException)
				{
				}
			return v;
		}

	/**
	 * 
	 * @todo 两个对象进行相除,返回百分数
	 * @date 2015年6月18日 下午7:05:16
	 * @return String
	 * @return
	 */
	public static int divide (Object a , Object b)
		{
			double aNew = Double.parseDouble (CNNumberUtils.null2String (a));
			double bNew = Double.parseDouble (CNNumberUtils.null2String (b));
			double r = 0.0D;
			if (bNew != 0)
			{
				r = (aNew / bNew) * 100;
			}
			return (int) Math.floor (r);
		}

	/**
	 * 用来保存订单流水计数，最大9999
	 */
	static int addedOrderNumber = 0;

	/**
	 * @Title: generateOrderId
	 * @Description: 生成一个订单号，前12位为格林时间/2,后面为1- 9999 的自增数
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月11日 下午2:29:04
	 */
	public synchronized static String generateOrderId ( )
		{
			if (++addedOrderNumber > Globals.NUBER_ORDER_MAX)
			{
				addedOrderNumber = 0;
			}
			Long time = System.currentTimeMillis () / 2;
			return time.toString () + addedOrderNumber;
		}

	/**
	 * @Title : checkModuleId
	 * @Deprecated : 根据 moduleID检查是否是厂价特卖
	 * @param s
	 * @return ：boolean
	 * @author : liuguo
	 * @Date : 2017/06/14 10:06
	 */
	public static boolean checkModuleId (Object s)
		{
			boolean v = false;
			int moduleId = null2Int (s);
			if (moduleId >= 1000 && moduleId <= 1007)
			{
				v = true;
			}
			return v;
		}
}
