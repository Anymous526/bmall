package com.amall.core.web.tools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ObjectReflectTools
{
	/* 控制循环引用 */
	private ArrayList<Object> visited = new ArrayList<>();

	/** 
	* @Title: toString 
	* @Description: 通用的元素信息查看, 使用反射方式,类成员属性不打印
	* @param obj
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月21日
	*/
	private static String toString(Object obj)
	{
		if(obj == null) 
			return "null";
		
		/* 避免循环引用导致的无限递归 */
//		if(visited.contains(obj)) 
//			return "......";
		
//		visited.add(obj);
		
		/* The Class object that represents the runtime class of this object. */
		Class cl = obj.getClass();
		
		/* is String type */
		if(cl == String.class) 
			return (String)obj;
		
		/* Determines if this Class object represents an array class. */
		if(cl.isArray())
		{
			/**
			 *  Returns the Class representing the component 
			 *  type of an array. If this class does not represent 
			 *  an array class this method returns null.
			 */
			String r = cl.getComponentType() + "[]\n{\n\t";
			
			/* Returns the length of the specified array object, as an int. */
			for(int i = 0; i < Array.getLength(obj); i++)
			{
				/* Neighbors separated by commas */
				if(i > 0) r += ", \n\t";
				
				/**
				 * Returns the value of the indexed component 
				 * in the specified array object. The value 
				 * is automatically wrapped in an object if it has a primitive type.
				 * (primitive type : int char long double boolean short byte float)
				 */
				Object val = Array.get(obj, i);
				
				/* true if and only if this class represents a primitive type */
				if(cl.getComponentType().isPrimitive()) 
					r += val;
				else 
					r += toString(val);
			}
			
			return r + "\n}";
		}
		
		
		/* the name of the class or interface represented by this object. */
		String r = cl.getName();
		
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
			Field[] fields = cl.getDeclaredFields();
			
			/**
			 * Convenience method to set the accessible flag 
			 * for an array of objects with a single security check (for efficiency). 
			 */
			AccessibleObject.setAccessible(fields, true);
			
			for(Field f:fields)
			{
				
				/**
				 * Return true if the integer argument includes the static modifier
				 * , false otherwise.
				 */
				if(!Modifier.isStatic(f.getModifiers()))
				{
					if(!r.endsWith("[")) 
						r += ",";
					
					/* Returns the name of the field represented by this Field object. */
					r += f.getName() + "=";
					
					try
					{
						/**
						 * Returns a Class object that identifies the declared type 
						 * for the field represented by this Field object.
						 */
						Class t = f.getType();
						Object val = f.get(obj);
						
						if(t.isPrimitive()) 
							r += val;
						else 
							r += toString(val);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					
					r += "]";
					
					/* the superclass of the class represented by this object. */
					if(cl == null)
						break;
					cl = cl.getSuperclass();
				}
			}
		}while(cl != null);
		
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
	public static String objectToString(Object obj)
	{
		if(obj instanceof List)
		{
			obj = ((List) obj).toArray();
		}
		
		return toString(obj);
		
	}
}
