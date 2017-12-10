package com.amall.common.tools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.beanutils.BeanUtils;

public class ObjectReflectTools
{

	/* 控制循环引用 */
//	private ArrayList <Object> visited = new ArrayList <> ();

	/**
	 * @Title: toString
	 * @Description: 通用的元素信息查看, 使用反射方式,类成员属性不打印
	 * @param obj
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月21日
	 */
	private static String toString (Object obj)
		{
			if (obj == null)
				return "null";
			/* 避免循环引用导致的无限递归 */
			// if(visited.contains(obj))
			// return "......";
			// visited.add(obj);
			/* The Class object that represents the runtime class of this object. */
			Class <? extends Object> cl = obj.getClass ();
			/* is String type */
			if (cl == String.class)
				return (String) obj;
			/* Determines if this Class object represents an array class. */
			if (cl.isArray ())
			{
				/**
				 * Returns the Class representing the component
				 * type of an array. If this class does not represent
				 * an array class this method returns null.
				 */
				String r = cl.getComponentType () + "[]\n{\n\t";
				/* Returns the length of the specified array object, as an int. */
				for (int i = 0 ; i < Array.getLength (obj) ; i++)
				{
					/* Neighbors separated by commas */
					if (i > 0)
						r += ", \n\t";
					/**
					 * Returns the value of the indexed component
					 * in the specified array object. The value
					 * is automatically wrapped in an object if it has a primitive type.
					 * (primitive type : int char long double boolean short byte float)
					 */
					Object val = Array.get (obj , i);
					/* true if and only if this class represents a primitive type */
					if (cl.getComponentType ().isPrimitive ())
						r += val;
					else
						r += toString (val);
				}
				return r + "\n}";
			}
			/* the name of the class or interface represented by this object. */
			String r = cl.getName ();
			do
			{
				r += "[";
				/**
				 * the array of Field objects representing all the declared fields of this class.
				 * This includes public, protected, default (package) access, and private fields,
				 * but excludes inherited fields.
				 * he elements in the array returned are not sorted and are not
				 * in any particular order.
				 */
				Field [ ] fields = cl.getDeclaredFields ();
				/**
				 * Convenience method to set the accessible flag
				 * for an array of objects with a single security check (for efficiency).
				 */
				AccessibleObject.setAccessible (fields , true);
				for (Field f : fields)
				{
					/**
					 * Return true if the integer argument includes the static modifier
					 * , false otherwise.
					 */
					if (!Modifier.isStatic (f.getModifiers ()))
					{
						if (!r.endsWith ("["))
							r += ",";
						/* Returns the name of the field represented by this Field object. */
						r += f.getName () + "=";
						try
						{
							/**
							 * Returns a Class object that identifies the declared type
							 * for the field represented by this Field object.
							 */
							Class <?> t = f.getType ();
							Object val = f.get (obj);
							if (t.isPrimitive ())
								r += val;
							else
								r += toString (val);
						}
						catch (Exception e)
						{
							e.printStackTrace ();
						}
						r += "]";
						/* the superclass of the class represented by this object. */
						if (cl == null)
							break;
						cl = cl.getSuperclass ();
					}
				}
			}
			while (cl != null);
			return r;
		}

	/**
	 * @Title: objectToString
	 * @Description: 判断是否是list是的话就转换成对象数组
	 * @param obj
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年10月22日
	 */
	public static String objectToString (Object obj)
		{
			if (obj instanceof List)
			{
				obj = ((List <?>) obj).toArray ();
			}
			return toString (obj);
		}

	/**
	 * @Title: isVoContainName
	 * @Description: 判断vo是否包含这个字段
	 * @param name
	 * @param clz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月8日
	 */
	public static <T> boolean isVoContainName (String name , Class <T> clz) throws IllegalAccessException , InvocationTargetException
		{
			Field [ ] fields = clz.getDeclaredFields ();
			for (Field field : fields)
			{
				if (field.getName ().equals (name))
				{
					return true;
				}
			}
			return false;
		}

	/**
	 * 
	 * @Title: paramsMapToVo
	 * @Description: 将前端请求的参数集Map，转换成VO对象
	 * @param @param map
	 * @param @param t VO对象
	 * @param @return
	 * @param @throws IllegalAccessException
	 * @param @throws InvocationTargetException
	 * @return T
	 * @throws
	 */
	public static <T> T toVoFromMap (Map <Object, Object> map , T t) throws IllegalAccessException , InvocationTargetException
		{
			Field [ ] fields = t.getClass ().getDeclaredFields ();
			Set <?> set = map.entrySet ();
			Iterator <?> iterator = set.iterator ();
			while (iterator.hasNext ())
			{
				@SuppressWarnings("unchecked")
				Map.Entry <String, Object> enter = (Entry <String, Object>) iterator.next ();
				for (Field field : fields)
				{
					if (field.getName ().equals (enter.getKey ()))
					{
						BeanUtils.setProperty (t , enter.getKey () , enter.getValue ());
					}
				}
			}
			return t;
		}

	/**
	 * 
	 * @Title: requestParamsToVo
	 * @Description: 将请求中的参数列表转成VO对象,要求参数名和VO属性名称一致
	 * @param @param request
	 * @param @param t
	 * @param @return
	 * @param @throws IllegalAccessException
	 * @param @throws InvocationTargetException
	 * @return T
	 * @throws
	 */
	public static <T> T toVoFromRequestParams (HttpServletRequest request , T t)
		{
			Field [ ] fields = t.getClass ().getDeclaredFields ();
			Class <?> sClz = t.getClass ().getSuperclass ();
			Field [ ] sfields = null;
			if (sClz != null)
			{
				sfields = sClz.getDeclaredFields ();
			}
			Enumeration <String> params = request.getParameterNames ();
			String tempName = "";
			try
			{
				while (params.hasMoreElements ())
				{
					tempName = params.nextElement ();
					for (Field field : fields)
					{
						if (field.getName ().equals (tempName))
						{
							BeanUtils.setProperty (t , tempName , request.getParameter (tempName));
						}
					}
					if (sfields != null)
					{
						for (Field field : sfields)
						{
							if (field.getName ().equals (tempName))
							{
								BeanUtils.setProperty (t , tempName , request.getParameter (tempName));
								// field.set(t, request.getParameter(tempName));
							}
						}
					}
				}
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace ();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace ();
			}
			catch (InvocationTargetException e)
			{
				e.printStackTrace ();
			}
			return t;
		}

	/**
	 * @Title: toMap
	 * @Description: bean转换成一个map
	 * @param bean
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月8日
	 */
	public static Map <String, Object> toMap (Object vo)
		{
			Map <String, Object> map = new HashMap <String, Object> ();
			return setFiledsToMap (map , vo);
		}

	/**
	 * @Title: toSortMap
	 * @Description: 使用treeMap
	 * @param vo
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月8日
	 */
	public static Map <String, Object> toSortMap (Object vo)
		{
			Map <String, Object> sortMap = new TreeMap <> (toMap (vo));
			return sortMap;
		}

	private static Map <String, Object> setFiledsToMap (Map <String, Object> map , Object vo)
		{
			Class <? extends Object> clz = vo.getClass ();
			Field [ ] fields = clz.getDeclaredFields ();
			for (Field field : fields)
			{
				field.setAccessible (true);
				Object obj;
				try
				{
					obj = field.get (vo);
					if (obj != null)
					{
						if (isStringOrBaseType (obj))
						{
							map.put (field.getName () , obj);
						}
					}
				}
				catch (IllegalArgumentException e)
				{
					e.printStackTrace ();
				}
				catch (IllegalAccessException e)
				{
					e.printStackTrace ();
				}
			}
			Class <? extends Object> superClass = clz.getSuperclass ();
			if (superClass != null)
			{
				Field [ ] sfields = superClass.getDeclaredFields ();
				for (Field field : sfields)
				{
					field.setAccessible (true);
					Object obj;
					try
					{
						obj = field.get (vo);
						if (obj != null)
						{
							if (isStringOrBaseType (obj))
							{
								map.put (field.getName () , obj);
							}
						}
					}
					catch (IllegalArgumentException e)
					{
						e.printStackTrace ();
					}
					catch (IllegalAccessException e)
					{
						e.printStackTrace ();
					}
				}
			}
			return map;
		}

	/**
	 * @Title: isStringOrBaseType
	 * @Description: 判断是否属于基础数据类型或者字符串 (int, long, double, float,boolean)
	 * @param obj
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月31日
	 */
	public static boolean isStringOrBaseType (Object obj)
		{
			if (obj instanceof String)
			{
				return true;
			}
			else if (obj instanceof Long)
			{
				return true;
			}
			else if (obj instanceof Integer)
			{
				return true;
			}
			else if (obj instanceof Double)
			{
				return true;
			}
			else if (obj instanceof Float)
			{
				return true;
			}
			else if (obj instanceof Boolean)
			{
				return true;
			}
			else if (obj instanceof BigDecimal)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

	/**
	 * @Title: beanToBeanVo
	 * @Description: bean对象填充Vo对象
	 * @param bean
	 * @param beanClass
	 * @param BeanVoClass
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月28日
	 */
	public static Object beanToBeanVo (Object bean , Class <?> beanClass , Class <?> BeanVoClass)
		{
			try
			{
				Object t = BeanVoClass.newInstance ();
				Field [ ] beanFields = beanClass.getDeclaredFields ();
				Field [ ] beanVoFields = BeanVoClass.getDeclaredFields ();
				for (Field fieldVo : beanVoFields)
				{
					fieldVo.setAccessible (true);
					for (Field field : beanFields)
					{
						field.setAccessible (true);
						if (fieldVo.getName ().equals (field.getName ()))
						{
							Object obj = field.get (bean);
							if (obj != null)
							{
								if (field.getType () == Date.class)
								{
									Date date = (Date) obj;
									fieldVo.set (t , date.getTime ());
								}
								else
								{
									fieldVo.set (t , obj);
								}
							}
						}
					}
				}
				return t;
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
		}

	/**
	 * @Title: beanListToVoList
	 * @Description:
	 * @param beans
	 * @param beanClass
	 * @param BeanVoClass
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月28日
	 */
	public static List <Object> beanListToVoList (List <?> beans , Class <?> beanClass , Class <?> BeanVoClass)
		{
			List <Object> list = new ArrayList <Object> ();
			if (beans.isEmpty ())
			{
				return null;
			}
			for (Object bean : beans)
			{
				Object obj = beanToBeanVo (bean , beanClass , BeanVoClass);
				if (obj != null)
				{
					list.add (obj);
				}
			}
			return list;
		}
}
