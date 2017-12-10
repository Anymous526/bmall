package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.web.page.Pagination;
import com.google.gson.JsonObject;

/**
 * 
 * <p>Title: GoodsViewTools</p>
 * <p>Description: 商品显示工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午9:28:33
 * @version 1.0
 */
@Component
public class GoodsViewTools {

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;
	
	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;
	
	@Autowired
	private IBargainGoodsService bargainGoodsService;
	
	public List<GoodsSpecification> generic_spec(String id) {
		List specs = new ArrayList();
		if ((id != null) && (!id.equals(""))) {
			GoodsWithBLOBs goods = this.goodsService.getByKey(Long.valueOf(Long
					.parseLong(id)));
			for (GoodsSpecProperty gsp : goods.getGoodsSpecs()) {
				GoodsSpecification spec = gsp.getSpec();
				if (!specs.contains(spec)) {
					specs.add(spec);
				}
			}
		}
		Collections.sort(specs, new Comparator() {
			public int compare(Object gs1, Object gs2) {
				return ((GoodsSpecification) gs1).getSequence()
						- ((GoodsSpecification) gs2).getSequence();
			}
		});

		return specs;
	}
	

	public List<UserGoodsClass> query_user_class(String pid) {
		List<UserGoodsClass> list = new ArrayList<UserGoodsClass>();
		if ((pid == null) || (pid.equals(""))) {
			UserGoodsClassExample example = new UserGoodsClassExample();
			example.clear();
			example.setOrderByClause("sequence asc");
			example.createCriteria().andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId())
				.andParentIdIsNull();
			list = this.userGoodsClassService.getObjectList(example);
			
		} else {
			UserGoodsClassExample example = new UserGoodsClassExample();
			example.clear();
			example.setOrderByClause("sequence asc");
			example.createCriteria().andParentIdEqualTo(Long.valueOf(Long.parseLong(pid)))
					.andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
			list = this.userGoodsClassService.getObjectList(example);
		}
		return list;
	}

	public Pagination query_with_gc(String gc_id, int count) {
		Pagination p = new Pagination();
		GoodsClassWithBLOBs gc = this.goodsClassService.getByKey(CommUtil
				.null2Long(gc_id));
		if (gc != null) {
			
			GoodsExample example = new GoodsExample();
			example.clear();
			example.createCriteria().andIdIn(genericIds(gc))
					.andGoodsStatusEqualTo(Integer.valueOf(0));
			example.setPageNo(1);
			example.setPageSize(count);
			example.setOrderByClause("goods_click desc");
			p = this.goodsService.getObjectListWithPage(example);
		}
		return p;
	}
	
	
	private List<Long> genericIds(GoodsClass gc) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(gc.getId());
		GoodsClassExample goodsClassExample = new GoodsClassExample();
		goodsClassExample.clear();
		goodsClassExample.createCriteria().andParentIdEqualTo(gc.getId());
		List<GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList(goodsClassExample);
		gc.setChilds(gcs);
		
		for (GoodsClass child : gc.getChilds()) {
			List<Long> cids = genericIds(child);
			for (Long cid : cids) {
				ids.add(cid);
			}
			ids.add(child.getId());
		}
		return ids;
	}

	public Pagination sort_sale_goods(String store_id, int count) {
		Pagination p = new Pagination();
		GoodsExample example = new GoodsExample();
		example.clear();
		example.createCriteria().andGoodsStoreIdEqualTo(CommUtil.null2Long(store_id))
				.andGoodsStatusEqualTo(Integer.valueOf(0));
		example.setPageNo(1);
		example.setPageSize(count);
		example.setOrderByClause("goods_salenum desc");
		p = this.goodsService.getObjectListWithPage(example);
		return p;
	}

	public Pagination sort_collect_goods(String store_id, int count) {
		Pagination p = new Pagination();
		GoodsExample example = new GoodsExample();
		example.clear();
		example.createCriteria().andGoodsStoreIdEqualTo(CommUtil.null2Long(store_id))
		.andGoodsStatusEqualTo(Integer.valueOf(0));
		example.setPageNo(1);
		example.setPageSize(count);
		example.setOrderByClause("goods_collect desc");
		p = this.goodsService.getObjectListWithPage(example);
		return p;
	}

	public List<GoodsWithBLOBs> query_combin_goods(String id) {
		return this.goodsService.getByKey(CommUtil.null2Long(id))
				.getCombinGoods();
	}
	
	public List<GoodsSpecification> getGoodsAndGoodsSpcOfGoodsList(List<GoodsWithBLOBs> goodsList)
	{
		
		List<GoodsSpecification> retList = new ArrayList<GoodsSpecification>();
		
		//[{"key":"1","value":"3|5|41"}]
		for(GoodsWithBLOBs goods:goodsList)
		{
			GoodsSpecification specification = null;
			if (goods.getGoodsProperty() != null && !goods.getGoodsProperty().equals("")) 
			{
				JSONArray array = JSONArray.fromObject(goods
						.getGoodsProperty());
				for (int i = 0; i < array.size(); i++) 
				{
					JSONObject obj = array.getJSONObject(i);
					String keyValue = obj.getString("key");
					specification = this.goodsSpecificationService.getByKey(Long.valueOf(keyValue));
					if (specification == null) 
					{
						continue;
					}

					String value = obj.getString("value");
					String[] strArray = value.split("\\|");
					if (strArray == null || strArray.length == Globals.NUBER_ZERO) 
					{
						continue;
					}
					
					List<GoodsSpecProperty> specProperties = getGoodsSpecPropertyS(strArray);
					
					if(!specProperties.isEmpty())
					{
						specification.setProperties(specProperties);
					}
				}
			}
			
			retList.add(specification);
		}
		
		return retList;
	}
	
	/**
	 * @Title: getGoodsSpecPropertyS
	 * @Description:根据属性值ID数组 获取属性值对象, 第一步查询入口
	 * @param strArray
	 * @return
	 * @return List<GoodsSpecProperty>
	 * @author tangxiang
	 * @date 2015年8月20日 下午4:18:51 
	 */
	private List<GoodsSpecProperty> getGoodsSpecPropertyS(String[] strArray)
	{
		List<GoodsSpecProperty> specProperties = new ArrayList<GoodsSpecProperty>();
		for (String strId : strArray) 
		{
			GoodsSpecProperty goodsSpecProperty = this.goodsSpecPropertyService
					.getByKey(Long.valueOf(strId));
			
			if (goodsSpecProperty == null) 
			{
				continue;
			}
			specProperties.add(goodsSpecProperty);
		}
		
		return specProperties;
	}
	
	/**
	 * @Title: searchGoodsOfSpec
	 * @Description: 匹配规格属性，第二步入口
	 * @param specStr
	 * @param goodsList
	 * @return
	 * @return List<GoodsWithBLOBs>
	 * @author tangxiang
	 * @date 2015年8月20日 下午5:16:42 
	 */
	public List<GoodsWithBLOBs> searchGoodsOfSpec(String specStr, List<GoodsWithBLOBs> goodsList)
	{
		List<GoodsWithBLOBs> bloBs = new ArrayList<GoodsWithBLOBs>();
		
		
		for(GoodsWithBLOBs goods:goodsList)
		{
			if (goods.getGoodsProperty() != null && !goods.getGoodsProperty().equals("")) 
			{
				JSONArray array = JSONArray.fromObject(goods
						.getGoodsProperty());
				for (int i = 0; i < array.size(); i++) 
				{
					JSONObject obj = array.getJSONObject(i);

					String value = obj.getString("value");
					String[] strArray = value.split("\\|");
					if (strArray == null || strArray.length == Globals.NUBER_ZERO) 
					{
						continue;
					}
					
					/* 查找到满足条件的就结束循环 */
					if(isContainProperty(specStr, strArray))
					{
						bloBs.add(goods);
						break;
					}
				}
			}
		}
		
		return bloBs;
	}
	
	/**
	 * @Title: isContainProperty
	 * @Description: 判断传入条件属否被完全包含
	 * @param specStr
	 * @param strArray
	 * @return
	 * @return boolean
	 * @author tangxiang
	 * @date 2015年8月20日 下午5:14:55 
	 */
	private boolean isContainProperty(String specStr, String[] strArray)
	{
		if(specStr == null)
		{
			return true;
		}
		
		String[] searchArray = specStr.split("\\|");
		
		if (searchArray == null || searchArray.length == Globals.NUBER_ZERO) 
		{
			return true;
		}
		
		
		List<String> oldList = Arrays.asList(strArray);
		List<String> newList = Arrays.asList(searchArray);
		boolean flag = oldList.containsAll(newList);
		return flag;
	}
	
	/**
	 * @Title: bargainGoodsCount
	 * @Description: 根据goodsId查询是否做了特价活动
	 * @param goodsId
	 * @return
	 * @return 
	 * @author chenxiujun
	 * @date 2015年12月14日 上午10:10:55 
	 */
	public int bargainGoodsCount(String goodsId,String mark){
		BargainGoodsExample bGoodsExample = new BargainGoodsExample();
		bGoodsExample.clear();
		bGoodsExample.createCriteria().andBgGoodsIdEqualTo(Long.valueOf(goodsId))
							.andMarkEqualTo(Integer.valueOf(mark)).andBargainGoodsStatusEqualTo("1");
		int goodsCount = this.bargainGoodsService.getObjectListCount(bGoodsExample);
		return goodsCount;
	}
}
