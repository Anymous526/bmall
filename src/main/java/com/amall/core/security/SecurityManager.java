package com.amall.core.security;

import java.util.Map;

/**
 * 
 * <p>
 * Title: SecurityManager
 * </p>
 * <p>
 * Description: 提供一个返回Map<String,String>的抽象方法
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28上午10:01:22
 * @version 1.0
 */
public abstract class SecurityManager
{

	public abstract Map <String, String> loadUrlAuthorities ( );
}
