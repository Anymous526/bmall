package com.amall.core.web.tools;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.system.ISysConfigService;


/**
 * 特价相关查询工具类
 * @author ljx
 *
 */
@Component
public class BargainSellerTools {

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainServicve;

	@Autowired
	private ISysConfigService configService;
	
	
	/**
	 *  根据特价时间查询 特价活动的折扣率
	 * @param bargain_time
	 * @return
	 */
	public BigDecimal query_bargain_rebate(Object bargain_time) {
		BargainExample bargainExample = new BargainExample();
		bargainExample.clear();
		bargainExample.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
		List<Bargain> bargain = bargainServicve.getObjectList(bargainExample);
		
		BigDecimal bd = null;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getRebate();
		else {
			bd = this.configService.getSysConfig().getBargainRebate();
		}
		//System.out.println("query_bargain_rebate:"+bd);
		return bd;
	}

	/**
	 * 
	 * <p>Title: getSpecialPrice</p>
	 * <p>Description: 根据BargainGoods的id查询特价价格</p>
	 * @param bargainGoodsId
	 * @return
	 */
	public BigDecimal getSpecialPrice(Long bargainGoodsId)
	{
		BigDecimal b1=null;//折扣之后的商品价
		BargainGoods bargainGoods=this.bargainGoodsService.getByKey(CommUtil.null2Long(bargainGoodsId));
		if(bargainGoods!=null)
		{
			Date bgTime=bargainGoods.getBgTime();
			BargainExample bargainExample=new BargainExample();
			bargainExample.clear();
			bargainExample.createCriteria().andBargainTimeEqualTo(bgTime);
			List<Bargain> bargain=this.bargainServicve.getObjectList(bargainExample);
			BigDecimal bd=null;//折扣价
			if(bargain.size()>0)
			{
				bd=bargain.get(0).getRebate();
			}else{
				bd=this.configService.getSysConfig().getBargainRebate();
			}
			GoodsWithBLOBs goods=bargainGoods.getBgGoods();
			b1=goods.getStorePrice().multiply(bd);
			b1=b1.multiply(new BigDecimal(0.1));
		}
		return b1;
	}
	
	
	/**
	 * 申请限制
	 * @param bargain_time
	 * @return
	 */
	public int query_bargain_maximum(Object bargain_time) {
		
		BargainExample bargainExample = new BargainExample();
		bargainExample.clear();
		bargainExample.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
		List<Bargain> bargain = bargainServicve.getObjectList(bargainExample);
		
		
		int bd = 0;
		if (bargain.size() > 0)
			bd = ((Bargain) bargain.get(0)).getMaximum();
		else {
			bd = this.configService.getSysConfig().getBargainMaximum();
		}
		//System.out.println("query_bargain_maximum:"+bd);
		return bd;
	}
	
	
	/**
	 * 特价通过审核数
	 * @param bargain_time
	 * @return
	 */
	public int query_bargain_audit(Object bargain_time) {
		BargainGoodsExample bargainGoodsExample = new BargainGoodsExample();
		bargainGoodsExample.clear();
		bargainGoodsExample.createCriteria().andBgTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"))
				.andBgStatusEqualTo(Integer.valueOf(1));
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(bargainGoodsExample);
		//System.out.println("query_bargain_audit:"+bargainGoods.size());
		return bargainGoods.size();
	}
	
	public int query_bargain_audit(Object bargain_time,Object bargain_end_time) {
		BargainGoodsExample bargainGoodsExample = new BargainGoodsExample();
		bargainGoodsExample.clear();
		bargainGoodsExample.createCriteria().andBgTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"))
				.andBgEndTimeEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd"))
				.andBgStatusEqualTo(Integer.valueOf(1));
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(bargainGoodsExample);
		//System.out.println("query_bargain_audit:"+bargainGoods.size());
		return bargainGoods.size();
	}
	public int query_bargain_audit(Object bargain_time,Object bargain_end_time,Integer mark) {
		BargainGoodsExample bargainGoodsExample = new BargainGoodsExample();
		bargainGoodsExample.clear();
		bargainGoodsExample.createCriteria().andBgTimeGreaterThanOrEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd HH:mm:ss"))
				.andBgEndTimeLessThanOrEqualTo(CommUtil.formatDate(CommUtil.null2String(bargain_end_time), "yyyy-MM-dd HH:mm:ss"))
				.andBgStatusEqualTo(Integer.valueOf(1))
				.andMarkEqualTo(mark);
		List<BargainGoods> bargainGoods = bargainGoodsService.getObjectList(bargainGoodsExample);
		//System.out.println("query_bargain_audit:"+bargainGoods.size());
		return bargainGoods.size();
	}
	
	
	
	
	/**
	 * 根据特价时间查询，特价时间的类型  
	 * @param bargain_time
	 * @return	为0表示天天特价，为1表示限时特价，为2表示折扣特卖
	 */
	public int query_bargain_mark(Object bargain_time) {
		BargainExample bargainExample = new BargainExample();
		bargainExample.clear();
		bargainExample.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(
				CommUtil.null2String(bargain_time), "yyyy-MM-dd"));
				
		List<Bargain> bargain = bargainServicve.getObjectList(bargainExample);
		if(bargain !=null && bargain.size()>0)
			bargain.get(0).getMark();
		return 0;
	}
}
