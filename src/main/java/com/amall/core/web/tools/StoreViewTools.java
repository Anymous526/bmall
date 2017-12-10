package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateExample.Criteria;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: StoreViewTools</p>
 * <p>Description: 店铺显示工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午9:55:47
 * @version 1.0
 */
@Component
public class StoreViewTools {

	@Autowired
	private IStoreService storeService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IOrderFormService orderFormService;
	
	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IStoreClassService storeClassService;
	
	@Autowired
	private IAccessoryService iAccessoryService;

	public String genericFunction(StoreGrade grade) {
		String fun = "";
		if (grade.getAddFunciton().equals(""))
			fun = "无";
		String[] list = grade.getAddFunciton().split(",");
		for (String s : list) {
			if (s.equals("editor_multimedia")) {
				fun = "富文本编辑器" + fun;
			}
		}
		return fun;
	}

	public String genericImageSuffix(String imageSuffix) {
		String suffix = "";
		String[] list = imageSuffix.split("\\|");
		for (String l : list) {
			suffix = "*." + l + ";" + suffix;
		}
		return suffix.substring(0, suffix.length() - 1);
	}

	public int generic_store_credit(String id) {
		int credit = 0;
		String sys_credit = this.configService.getSysConfig().getCreditrule();
		Map map = (Map) Json.fromJson(HashMap.class, sys_credit);
		List list = new ArrayList();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			list.add(Integer.valueOf(Integer.parseInt(map.get(key).toString())));
		}
		Integer[] ints = (Integer[]) list.toArray(new Integer[list.size()]);
		Arrays.sort(ints, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				int a = CommUtil.null2Int(obj1);
				int b = CommUtil.null2Int(obj2);
				if (a == b) {
					return 0;
				}
				return a > b ? 1 : -1;
			}
		});
		Store store = this.storeService.getByKey(Long.valueOf(Long
				.parseLong(id)));
		for (int i = 0; i < ints.length - 1; i++) {
			if ((ints[i].intValue() > store.getStoreCredit())
					|| (ints[(i + 1)].intValue() < store.getStoreCredit()))
				continue;
			credit = i + 1;
			break;
		}

		if (store.getStoreCredit() >= ints[(ints.length - 1)].intValue()) {
			credit = ints.length;
		}
		return credit;
	}

	public int generic_user_credit(String id) {
		int credit = 0;
		String user_credit = this.configService.getSysConfig()
				.getUserCreditrule();
		Map map = (Map) Json.fromJson(HashMap.class, user_credit);
		List list = new ArrayList();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			list.add(Integer.valueOf(Integer.parseInt(map.get(key).toString())));
		}
		Integer[] ints = (Integer[]) list.toArray(new Integer[list.size()]);
		Arrays.sort(ints, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				int a = CommUtil.null2Int(obj1);
				int b = CommUtil.null2Int(obj2);
				if (a == b) {
					return 0;
				}
				return a > b ? 1 : -1;
			}
		});
		User user = this.userService.getByKey(CommUtil.null2Long(id));
		for (int i = 0; i < ints.length - 1; i++) {
			if ((ints[i].intValue() > user.getUserCredit())
					|| (ints[(i + 1)].intValue() < user.getUserCredit()))
				continue;
			credit = i + 1;
			break;
		}

		if (user.getUserCredit() >= ints[(ints.length - 1)].intValue()) {
			credit = ints.length;
		}
		return credit;
	}

	public Pagination query_recommend_store(int count) {
		Pagination p = new Pagination();
		StoreExample example = new StoreExample();
		example.createCriteria().andStoreRecommendEqualTo(Boolean.valueOf(true));
		example.setPageNo(1);
		example.setPageSize(count);
		example.setOrderByClause("store_recommend_time desc");
		p = this.storeService.getObjectListWithPage(example);
		return p;
	}

	public List<GoodsWithBLOBs> query_recommend_store_goods(Store store, int begin,
			int max) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andGoodsRecommendEqualTo(Boolean.valueOf(true))
				.andGoodsStoreIdEqualTo(store.getId()).andGoodsStatusEqualTo(Integer.valueOf(0)).andDeletestatusEqualTo(false);
		example.setPageNo(begin);
		example.setPageSize(max);
		
		List<GoodsWithBLOBs> goods = this.goodsService.getObjectList(example);
				
		if (goods.size() < 5) {
			return goods;
		}
		return goods.subList(begin, max);
	}

	public int query_evaluate(String store_id, int evaluate_val, String type,
			String date_symbol, int date_count) {
		Calendar cal = Calendar.getInstance();
		EvaluateExample example = new EvaluateExample();
		Criteria criteria = example.createCriteria();
		criteria.andEvaluateGoodsIdEqualTo(CommUtil.null2Long(store_id))
			.andEvaluateBuyerValEqualTo(Integer.valueOf(CommUtil
		.null2Int(Integer.valueOf(evaluate_val))));
		if (type.equals("date")) {
			cal.add(6, date_count);
		}
		if (type.equals("week")) {
			cal.add(3, date_count);
		}
		if (type.equals("month")) {
			cal.add(2, date_count);
		}
		if (date_symbol.equals("before")) {
			//小于这个时间点
			criteria.andAddtimeLessThanOrEqualTo(cal.getTime());
		}else {
			//大于这个时间点
			criteria.andAddtimeGreaterThanOrEqualTo(cal.getTime());
		}
		
		List<EvaluateWithBLOBs> evas = this.evaluateService.getObjectList(example);
		
		return evas.size();
	}

	public Map query_point(StoreWithBLOBs store) {
		Map map = new HashMap();
		double description_result = 0.0D;
		double service_result = 0.0D;
		double ship_result = 0.0D;
		if (store.getSc() != null) {
			StoreClass sc = this.storeClassService.getByKey(store.getSc()
					.getId());
			float description_evaluate = CommUtil.null2Float(sc
					.getDescriptionEvaluate());
			float service_evaluate = CommUtil.null2Float(sc
					.getServiceEvaluate());
			float ship_evaluate = CommUtil.null2Float(sc.getShipEvaluate());
			if (store.getPoint() != null) {
				float store_description_evaluate = CommUtil.null2Float(store
						.getPoint().getDescriptionEvaluate());
				float store_service_evaluate = CommUtil.null2Float(store
						.getPoint().getServiceEvaluate());
				float store_ship_evaluate = CommUtil.null2Float(store
						.getPoint().getShipEvaluate());

				description_result = CommUtil.div(
						Float.valueOf(store_description_evaluate
								- description_evaluate),
						Float.valueOf(description_evaluate));
				service_result = CommUtil.div(Float
						.valueOf(store_service_evaluate - service_evaluate),
						Float.valueOf(service_evaluate));
				ship_result = CommUtil.div(
						Float.valueOf(store_ship_evaluate - ship_evaluate),
						Float.valueOf(ship_evaluate));
			}
		}
		if (description_result > 0.0D) {
			map.put("description_css", "better");
			map.put("description_type", "高于");
			map.put("description_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(description_result),
							Integer.valueOf(100))))
							+ "%");
		}
		if (description_result == 0.0D) {
			map.put("description_css", "better");
			map.put("description_type", "持平");
			map.put("description_result", "-----");
		}
		if (description_result < 0.0D) {
			map.put("description_css", "lower");
			map.put("description_type", "低于");
			map.put("description_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(-description_result),
							Integer.valueOf(100))))
							+ "%");
		}
		if (service_result > 0.0D) {
			map.put("service_css", "better");
			map.put("service_type", "高于");
			map.put("service_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(service_result),
							Integer.valueOf(100))))
							+ "%");
		}
		if (service_result == 0.0D) {
			map.put("service_css", "better");
			map.put("service_type", "持平");
			map.put("service_result", "-----");
		}
		if (service_result < 0.0D) {
			map.put("service_css", "lower");
			map.put("service_type", "低于");
			map.put("service_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(-service_result),
							Integer.valueOf(100))))
							+ "%");
		}
		if (ship_result > 0.0D) {
			map.put("ship_css", "better");
			map.put("ship_type", "高于");
			map.put("ship_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(ship_result), Integer.valueOf(100))))
							+ "%");
		}
		if (ship_result == 0.0D) {
			map.put("ship_css", "better");
			map.put("ship_type", "持平");
			map.put("ship_result", "-----");
		}
		if (ship_result < 0.0D) {
			map.put("ship_css", "lower");
			map.put("ship_type", "低于");
			map.put("ship_result",
					CommUtil.null2String(Double.valueOf(CommUtil.mul(
							Double.valueOf(-ship_result), Integer.valueOf(100))))
							+ "%");
		}
		return map;
	}
	
	/**
	 * 
	 * <p>Title: query_store_sale</p>
	 * <p>Description: 查询店铺的销量</p>
	 * @param storeId  店铺Id
	 * @return int  店铺销量
	 */
	public int query_store_sale(String storeId){
		int sum = 0;
		//查询该店铺已经支付过的订单，统计这些订单中所有商品的数量
		OrderFormExample orderFormExample = new OrderFormExample();
		orderFormExample.clear();
		orderFormExample.createCriteria().andStoreIdEqualTo(CommUtil.null2Long(storeId))
		.andOrderStatusGreaterThan(Integer.valueOf(10));
		List<OrderFormWithBLOBs> orderFormList = this.orderFormService.getObjectList(orderFormExample);
		for(OrderFormWithBLOBs orderForm : orderFormList){
			OrderFormItemExample orderFornItemExample = new OrderFormItemExample();
			orderFornItemExample.clear();
			orderFornItemExample.createCriteria().andOrderIdEqualTo(orderForm.getId());
			List<OrderFormItem> orderFormItemList = this.orderFormItemService.getObjectList(orderFornItemExample);
			for(OrderFormItem orderFormItem : orderFormItemList){
				sum += orderFormItem.getGoodsCount();
			}
		}
		return sum;
	}
	
	/**
	 * 
	 * <p>Title: query_store_goodseva</p>
	 * <p>Description: 查询店铺的好评率</p>
	 * @param storeId  店铺Id
	 * @return int  店铺好评
	 */
	public double query_store_goodseva(String storeId){
		int goodssum = 0; //好评总和
		int sum = 0; //评价总和
		//查找该店铺的所有商品，在评价表中找出每一件商品的好评并求和
		GoodsExample goodsexample = new GoodsExample();
		goodsexample.clear();
		goodsexample.createCriteria().andGoodsStoreIdEqualTo(CommUtil.null2Long(storeId));
		List<GoodsWithBLOBs> goodsList = this.goodsService.getObjectList(goodsexample);
		for(GoodsWithBLOBs goods : goodsList){
			EvaluateExample evaExample = new EvaluateExample();
			evaExample.clear();
			evaExample.createCriteria().andEvaluateGoodsIdEqualTo(goods.getId())
			.andEvaluateBuyerValEqualTo(Integer.valueOf(1));
			goodssum += this.evaluateService.getObjectListCount(evaExample);
			
			evaExample.clear();
			evaExample.createCriteria().andEvaluateGoodsIdEqualTo(goods.getId());
			sum += this.evaluateService.getObjectListCount(evaExample);

		}
		
		if(sum == 0){
			return 0;
		}else{
			return CommUtil.divide(goodssum, sum); //返回百分数
		}
	}
	
	public String genericImageById(Long photoId){
		Accessory accessory = iAccessoryService.getByKey(photoId);
		if(null != accessory){
			return configService.getSysConfig().getImagewebserver()+"/"+accessory.getPath()+"/"+accessory.getName();
		}else{
			return "";
		}
	}
}
