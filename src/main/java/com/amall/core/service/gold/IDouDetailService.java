package com.amall.core.service.gold;

import java.util.List;
import com.amall.core.bean.DouDetail;
import com.amall.core.bean.DouDetailExample;

/**
 * 
 * <p>Title: IPromoteInfoService</p>
 * <p>Description: 感恩豆明细模块service</p>
 
 * @version 1.0
 */
public abstract interface IDouDetailService
{


	public List <DouDetail> selectByExample (DouDetailExample example);


}
