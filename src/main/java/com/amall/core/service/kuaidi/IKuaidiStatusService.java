package com.amall.core.service.kuaidi;

import com.amall.core.bean.KuaiDiStatus;

/**
 * 快递状态服务
 * <p>Title: IKuaidiStatusService</p>
 * <p>Description: 保存、更新、查询快递状态表 *</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	guoxiangjun
 * @date	2015年8月12日上午10:42:53
 * @version 1.0
 */
public interface IKuaidiStatusService {

	void saveKuaiDiStatus(KuaiDiStatus kuaiDiStatus);
	
	void updateKuaiDiStauts(KuaiDiStatus kuaidiStatus);
	
	KuaiDiStatus getKuaiDiStatus(String kuaidiNum);

}
