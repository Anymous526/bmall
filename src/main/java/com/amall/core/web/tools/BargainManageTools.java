package com.amall.core.web.tools;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.system.ISysConfigService;

/**
 * 
 * <p>Title: BargainManageTools</p>
 * <p>Description: 特价相关查询工具类 </p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-24下午4:25:41
 * @version 1.0
 */
@Component
public class BargainManageTools {

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainServicve;

	@Autowired
	private ISysConfigService configService;
	/**
	 * 
	 * <p>Title: query_bargain_rebate</p>
	 * <p>Description: 根据交易时间查询交易折扣</p>
	 * @param bargain_time 交易时间
	 * @return BigDecimal 折扣度
	 */
	public BigDecimal query_bargain_rebate(Object bargain_time) {
		
		BargainExample example = new BargainExample();
		example.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
		List<Bargain> bargain = bargainServicve.getObjectList(example);
		
		BigDecimal bd = null;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getRebate();
		else {
			bd = this.configService.getSysConfig().getBargainRebate();
			
		}
		return bd;
	}
	
	public BigDecimal query_bargain_rebate(Object bargain_time,Object bargain_end_time) {
		
		BargainExample example = new BargainExample();
		example.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"))
				.andBargainEndTimeEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd"));
		
		List<Bargain> bargain = bargainServicve.getObjectList(example);
		
		BigDecimal bd = null;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getRebate();
		else {
			bd = this.configService.getSysConfig().getBargainRebate();
			
		}
		return bd;
	}
	/**
	 * 
	 * <p>Title: query_bargain_maximum</p>
	 * <p>Description:查询交易最大数量 </p>
	 * @param bargain_time
	 * @return int 数量
	 */
	public int query_bargain_maximum(Object bargain_time) {

		BargainExample example = new BargainExample();
		example.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
		List<Bargain> bargain = bargainServicve.getObjectList(example);
		
		int bd = 0;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getMaximum();
		else {
			bd = this.configService.getSysConfig().getBargainMaximum();
		}
		return bd;
	}
	
	public int query_bargain_maximum(Object bargain_time,Object bargain_end_time) {
		
		BargainExample example = new BargainExample();
		example.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"))
				.andBargainEndTimeEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd"));
		List<Bargain> bargain = bargainServicve.getObjectList(example);
		
		int bd = 0;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getMaximum();
		else {
			bd = this.configService.getSysConfig().getBargainMaximum();
		}
		return bd;
	}
	

	public int query_bargain_audit(Object bargain_time) {

		BargainGoodsExample example = new BargainGoodsExample();
		if(bargain_time != null){
			example.createCriteria().andBgTimeEqualTo(CommUtil.formatDate(
					CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
		}
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		int bd = 0;
		for (BargainGoods bg : bargainGoods) {
			if (bg.getBgStatus() == 1) {
				bd++;
			}
		}
		return bd;
	}
	
	public int query_bargain_audit(Object bargain_time,Object bargain_end_time) {
		
		BargainGoodsExample example = new BargainGoodsExample();
		example.createCriteria().andBgTimeGreaterThanOrEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"))
				.andBgEndTimeLessThanOrEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd"));
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		int bd = 0;
		for (BargainGoods bg : bargainGoods) {
			if (bg.getBgStatus() == 1) {
				bd++;
			}
		}
		return bd;
	}
	
	public int query_bargain_audit(Object bargain_time,Object bargain_end_time,Integer mark) {
		
		BargainGoodsExample example = new BargainGoodsExample();
		example.createCriteria().andBgTimeGreaterThanOrEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd HH:mm:ss"))
				.andBgEndTimeLessThanOrEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd HH:mm:ss"))
				.andMarkEqualTo(mark);
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		int bd = 0;
		for (BargainGoods bg : bargainGoods) {
			if (bg.getBgStatus() == 1) {
				bd++;
			}
		}
		return bd;
	}
	
	/**
	 * 
	 * <p>Title: query_bargain_apply</p>
	 * <p>Description: 查询特价商品数量</p>
	 * @param bargain_time
	 * @return
	 */
	public int query_bargain_apply(Object bargain_time) {
		
		BargainGoodsExample example = new BargainGoodsExample();
		if(bargain_time != null){
			example.createCriteria().andBgTimeEqualTo(CommUtil.formatDate(
					CommUtil.null2String(bargain_time)));
		}
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		return bargainGoods.size();
	}
	
	public int query_bargain_apply(Object bargain_time,Object bargain_end_time) {
		
		BargainGoodsExample example = new BargainGoodsExample();
		example.createCriteria().andBgTimeGreaterThanOrEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time)))
				.andBgEndTimeLessThanOrEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd"));
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		return bargainGoods.size();
	}
	
	public int query_bargain_apply(Object bargain_time,Object bargain_end_time,Integer mark) {
		
		BargainGoodsExample example = new BargainGoodsExample();
		example.createCriteria().andBgTimeGreaterThanOrEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time),"yyyy-MM-dd HH:mm:ss"))
				.andBgEndTimeLessThanOrEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd HH:mm:ss"))
				.andMarkEqualTo(mark);
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(example);
		
		return bargainGoods.size();
	}
}
