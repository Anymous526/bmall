package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;

/**
 * 
 * <p>Title: GoodsFloorViewTools</p>
 * <p>Description: 商品楼层显示工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午9:56:46
 * @version 1.0
 */
@Component
public class GoodsFloorViewTools {

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

	public List<GoodsClass> generic_gf_gc(String json) {
		List gcs = new ArrayList();
		if ((json != null) && (!json.equals(""))) {
			List<Map> list = (List) Json.fromJson(List.class, json);
			for (Map map : list) {
				GoodsClass the_gc = this.goodsClassService.getByKey(CommUtil
						.null2Long(map.get("pid")));
				if (the_gc != null) {
					int count = CommUtil.null2Int(map.get("gc_count"));
					GoodsClass gc = new GoodsClass();
					gc.setId(the_gc.getId());
					gc.setClassname(the_gc.getClassname());
					for (int i = 1; i <= count; i++) {
						GoodsClassWithBLOBs child = this.goodsClassService
								.getByKey(CommUtil.null2Long(map.get("gc_id"+ i)));
						gc.getChilds().add(child);
					}
					gcs.add(gc);
				}
			}
		}
		return gcs;
	}

	public List<Goods> generic_goods(String json) {
		List <Goods> goods_list = new ArrayList<Goods>();
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
		Map map = new HashMap();
		map.put("list_title", "商品排行");
		if ((json != null) && (!json.equals(""))) {
			Map list = (Map) Json.fromJson(Map.class, json);
			map.put("list_title", CommUtil.null2String(list.get("list_title")));
			map.put("goods1", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id1"))));
			map.put("goods2", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id2"))));
			map.put("goods3", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id3"))));
			map.put("goods4", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id4"))));
			map.put("goods5", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id5"))));
			map.put("goods6", this.goodsService.getByKey(CommUtil
					.null2Long(list.get("goods_id6"))));
		}
		return map;
	}

	public String generic_adv(String web_url, String json) {
		String template = "<div style='float:left;overflow:hidden;'>";
		if ((json != null) && (!json.equals(""))) {
			Map map = (Map) Json.fromJson(Map.class, json);
			if (CommUtil.null2String(map.get("adv_id")).equals("")) {
				Accessory img = this.accessoryService.getByKey(CommUtil
						.null2Long(map.get("acc_id")));
				if (img != null) {
					String url = CommUtil.null2String(map.get("acc_url"));
					template = template + "<a href='" + url
							+ "' target='_blank'><img src='" + web_url + "/"
							+ img.getPath() + "/" + img.getName() + "' /></a>";
				}
			} else {
				AdvertPositionWithBLOBs ap = this.advertPositionService
						.getByKey(CommUtil.null2Long(map.get("adv_id")));
				AdvertPositionWithBLOBs obj = new AdvertPositionWithBLOBs();
				obj.setApType(ap.getApType());
				obj.setApStatus(ap.getApStatus());
				obj.setApShowType(ap.getApShowType());
				obj.setApWidth(ap.getApWidth());
				obj.setApHeight(ap.getApHeight());
				List<Advert> advs = new ArrayList<Advert>();
				for (Advert temp_adv : ap.getAdvs()) {
					if ((temp_adv.getAdStatus() != 1)
							|| (!temp_adv.getAdBeginTime().before(new Date()))
							|| (!temp_adv.getAdEndTime().after(new Date())))
						continue;
					advs.add(temp_adv);
				}

				if (advs.size() > 0) {
					if (obj.getApType().equals("img")) {
						if (obj.getApShowType() == 0) {
							obj.setApAcc(((Advert) advs.get(0)).getAdAcc());
							obj.setApAccUrl(((Advert) advs.get(0))
									.getAdUrl());
							obj.setAdvId(CommUtil.null2String(((Advert) advs
									.get(0)).getId()));
						}
						if (obj.getApShowType() == 1) {
							Random random = new Random();
							int i = random.nextInt(advs.size());
							obj.setApAcc(((Advert) advs.get(i)).getAdAcc());
							obj.setApAccUrl(((Advert) advs.get(i))
									.getAdUrl());
							obj.setAdvId(CommUtil.null2String(((Advert) advs
									.get(i)).getId()));
						}
					}
				} else {
					obj.setApAcc(ap.getApAcc());
					obj.setApText(ap.getApText());
					obj.setApAccUrl(ap.getApAccUrl());
					Advert adv = new Advert();
					adv.setAdUrl(obj.getApAccUrl());
					adv.setAdAcc(ap.getApAcc());
					obj.getAdvs().add(adv);
				}

				template = template + "<a href='" + obj.getApAccUrl()
						+ "' target='_blank'><img src='" + web_url + "/"
						+ obj.getApAcc().getPath() + "/"
						+ obj.getApAcc().getName() + "' /></a>";
			}
		}
		template = template + "</div>";
		return template;
	}

	public List<GoodsBrand> generic_brand(String json) {
		List brands = new ArrayList();
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
	
	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午4:27:06
	 * @todo 通过传入特定的id 来获取一个该id对应的楼层的子集合
	 * @return List<GoodsFloorWithBLOBs>
	 * @param id
	 * @return
	 */
	public List<GoodsFloorWithBLOBs> generic_getChilds(String id) {
		return this.goodsFloorService.selectChildsByInnerJoin(CommUtil.null2Long(id));
	}
}
