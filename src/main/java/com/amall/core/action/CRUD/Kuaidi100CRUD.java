package com.amall.core.action.CRUD;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.service.kuaidi.IKuaidiService;

@Component
public class Kuaidi100CRUD
{

	@Autowired
	private IKuaidiService kuaidiService;

	
	/**
	 * @Title: getKuaiDiResultItem
	 * @Description: 根据快递单号查询快递信息
	 */
	public List<KuaiDiResultItem> getKuaiDiResultItem(String shipCode)
	{
		List<KuaiDiResultItem> item = this.kuaidiService.getKuaidiInfo(shipCode);
		return item;
	}
	
}
