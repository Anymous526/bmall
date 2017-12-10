package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.poi.poifs.storage.ListManagedBlock;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.easyjf.util.FileCopyUtils;
import com.easyjf.web.ajax.JSonConvertUtil;

/**
 * 楼层处理工具类
 * @author 
 *
 */

@Component
public class GoodsFloorTools {

	@Autowired
	private IGoodsFloorService goodsFloorService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private IGoodsBrandService goodsBrandService;
	
	
	
	public List<GoodsClassWithBLOBs> generic_gf_gc(String json) {
		List<GoodsClassWithBLOBs> gcs = new ArrayList<GoodsClassWithBLOBs>();
		if ((json != null) && (!json.equals(""))) {
			List<Map> list = (List) Json.fromJson(List.class, json);
			for (Map map : list) {
				GoodsClassWithBLOBs the_gc = this.goodsClassService.getByKey(CommUtil
						.null2Long(map.get("pid")));
				if (the_gc != null) {
					int count = CommUtil.null2Int(map.get("gc_count"));
					GoodsClassWithBLOBs gc = new GoodsClassWithBLOBs();
					gc.setId(the_gc.getId());
					gc.setClassname(the_gc.getClassname());
					gc = the_gc;
					for (int i = 1; i <= count; i++) {
						GoodsClassWithBLOBs child = this.goodsClassService
								.getByKey(CommUtil.null2Long(map.get("gc_id"
										+ i)));
						if(child != null){
							gc.getChilds().add(child);
						}
						
					}
					gcs.add(gc);
				}
			}
		}
		return gcs;
	}
	
	/**
	 * 
	 * @todo 解析gfMainPhoto的json字符串,并返回一个存储连接以及该photo的map集合
	 * @author wsw
	 * @date 2015年6月24日 上午11:28:50
	 * @return Map<String,Object>
	 * @param json
	 * @return
	 */
	public Map<String, Object> generic_gfMainPhotoList(String json) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(json != null && (!json.equals(""))) {
			Map m = Json.fromJson(Map.class, json);
			map.put("acc_url", m.get("acc_url"));
			
			map.put("acc", this.accessoryService.getByKey(CommUtil.null2Long(m.get("acc_id"))));
		}
	return map;
	}

	public List<Goods> generic_goods(String json) {
		List goods_list = new ArrayList();
		if ((json != null) && (!json.equals(""))) {
			Map map = (Map) Json.fromJson(Map.class, json);
			for (int i = 1; i <= 10; i++) {
				String key = "goods_id" + i;

				Goods goods = this.goodsService.getByKey(CommUtil
						.null2Long(map.get(key)));
				if (goods != null) {
					goods_list.add(goods);
				}
			}
		}

		return goods_list;
	}

	public Map generic_goods_list(String json) {
		Map<String,GoodsWithBLOBs> map = new HashMap<String,GoodsWithBLOBs>();
		if ((json != null) && (!json.equals(""))) {
			Map list = (Map) Json.fromJson(Map.class, json);
			Goods goods1 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id1")));
			if(goods1!=null && goods1.getGoodsStatus() == 0 ){
				map.put("goods1", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id1"))));
			}
			
			Goods goods2 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id2")));
			if(goods2!=null && goods2.getGoodsStatus() == 0 ){
				map.put("goods2", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id2"))));
			}
			
			Goods goods3 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id3")));
			if(goods3!=null && goods3.getGoodsStatus() == 0 ){
				map.put("goods3", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id3"))));
			}
			Goods goods4 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id4")));
			if(goods4!=null && goods4.getGoodsStatus() == 0 ){
				map.put("goods4", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id4"))));
			}
			
			Goods goods5 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id5")));
			if(goods5!=null && goods5.getGoodsStatus() == 0 ){
				map.put("goods5", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id5"))));
			}
			
			Goods goods6 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id6")));
			if(goods6!=null && goods6.getGoodsStatus() == 0 ){
				map.put("goods6", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id6"))));
			}
			
			Goods goods7 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id7")));
			if(goods7!=null && goods7.getGoodsStatus() == 0 ){
				map.put("goods7", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id7"))));
			}
			
			Goods goods8 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id8")));
			if(goods8!=null && goods8.getGoodsStatus() == 0 ){
				map.put("goods8", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id8"))));
			}
			
			Goods goods9 = goodsService.getByKey(CommUtil.null2Long(list.get("goods_id9")));
			if(goods9!=null && goods9.getGoodsStatus() == 0 ){
				map.put("goods9", this.goodsService.getByKey(CommUtil
						.null2Long(list.get("goods_id9"))));
			}
		}   
		return map;
	}    
	
	public Object setNull(){
		return null;
	}

	public List<GoodsClassWithBLOBs> generic_adv(String json) {
		List<GoodsClassWithBLOBs> gcs = new ArrayList<GoodsClassWithBLOBs>();
		if ((json != null) && (!json.equals(""))) {
			List<Map> list = (List) Json.fromJson(List.class, json);
			for (Map map : list) {
				GoodsClassWithBLOBs the_gc = this.goodsClassService.getByKey(CommUtil.null2Long(map.get("pid")));
				
				if (the_gc != null) {
					
					int count = CommUtil.null2Int(map.get("gc_count"));
					GoodsClassWithBLOBs gc = new GoodsClassWithBLOBs();
					gc.setId(the_gc.getId());
					gc.setClassname(the_gc.getClassname());
					gc = the_gc;
					for (int i = 1; i <= count; i++) {
						GoodsClassWithBLOBs child = this.goodsClassService.getByKey(CommUtil.null2Long(map.get("gc_id"+ i)));
						gc.getChilds().add(child);
					}
					gcs.add(gc);
				}
			}
		}
		return gcs;
	}
	/**
	 * 
	 * <p>Title: generic_brand</p>
	 * <p>Description: 查询商品品牌</p>
	 * @param json
	 * @return
	 */
	public List<GoodsBrand> generic_brand(String json) {
		List<GoodsBrand> brands = new ArrayList<GoodsBrand>();
		if ((json != null) && (!json.equals(""))) {
			Map map = (Map) Json.fromJson(Map.class, json);
			for (int i = 1; i <= 11; i++) {
				String key = "brand_id" + i;
				GoodsBrand brand = this.goodsBrandService.getByKey(CommUtil
						.null2Long(map.get(key)));
				if (brand != null) {
					brands.add(brand);
				}
			}
		}
		return brands;
	}
	
}
