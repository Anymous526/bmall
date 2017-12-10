package com.amall.core.service.kuaidi;

import java.util.List;
import com.amall.core.bean.KuaiDiResultItem;

/**
 * 快递service接口
 * <p>
 * Title: IKuaidiService
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author guoxiangjun
 * @date 2015年8月11日下午2:57:21
 * @version 1.0
 */
public interface IKuaidiService
{

	/**
	 * 根据运单号查询快递信息
	 * <p>
	 * Title: getKuaidiInfo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param kuaidiNum
	 *            运单号
	 * @return 快递信息集合
	 */
	List <KuaiDiResultItem> getKuaidiInfo (String kuaidiNum);

	void delete (String kuaidiNum);

	void save (KuaiDiResultItem item);
}
