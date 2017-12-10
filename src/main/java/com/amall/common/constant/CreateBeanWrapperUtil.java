package com.amall.common.constant;

import java.lang.reflect.Field;
import com.amall.core.web.tools.CommUtil;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * 		创建javaBean对象执行动作工具类
 * </P>
 * 
 * @author liuguo
 *
 */
public class CreateBeanWrapperUtil
{

	/**
	 * @Title createBeanWrapper
	 * @Deprecated 创建javaBean对象执行动作
	 * @param cl
	 *            类类型
	 * @param obj
	 *            类对象
	 * @param fieldName
	 * @param value
	 * @throws ClassNotFoundException
	 * @author liuguo
	 * @Date 2017/01/16 17:54
	 */
	public static Object createBeanWrapper (Class <?> cl , Object obj , String fieldName , String value) throws ClassNotFoundException
		{
			Field [ ] fields = cl.getClass ().getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			Object val = null;
			if (null != fields && fields.length != 0)
			{
				Class <?> clz = null;
				for (Field field : fields)
				{
					if (field.getName ().equals (fieldName))
					{
						clz = Class.forName ("java.lang.String");
						if (field.getType ().getName ().equals ("int"))
						{
							clz = Class.forName ("java.lang.Integer");
						}
						if (field.getType ().getName ().equals ("boolean"))
						{
							clz = Class.forName ("java.lang.Boolean");
						}
						if (!value.equals (""))
						{
							val = BeanUtils.convertType (value , clz);
						}
						else
						{
							val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
						}
						wrapper.setPropertyValue (fieldName , val);
					}
				}
			}
			return val;
		}
}
