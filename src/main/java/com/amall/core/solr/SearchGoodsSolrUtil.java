package com.amall.core.solr;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.amall.common.constant.Globals;
import com.amall.core.web.tools.CommUtil;
/**
 * 搜索类型(由于表关系的设计,增量查询不能使用,只能单个entity的查询.)
* @ClassName: ShopQuerySolrUtil 
* @Description: TODO
* @author lx
* @date 2016年1月6日 上午11:07:28 
*
 */
public class SearchGoodsSolrUtil {
	
	private static int curPage = 1;
	private static int goodsTypeBrandsPageSize = 10;
	private static int goodsBrandsPageSize = 10;
	private static int goodsClassPageSize = 10;
	private static int goodsSpcesPageSize = 5;
	private static int goodsStorePageSize = 20;
	private static int pageSize = 10;
	private static int size = 20;
	
	/**
	 * 根据关键字精确查询商品类型 
	* @Title: queryTypeGoodsClass 
	* @Description: TODO
	* @param  keyword
	* @param  sortName
	* @param  sprice
	* @param  eprice
	* @return SearchGoodsClassVo  
	* @throws
	 */
	public static SearchGoodsClassVo queryTypeGoodsClass(String keyword,String brandId, String brandSpceId, int curSearchPage,String sortName,BigDecimal sprice,BigDecimal eprice, String orderType) {
		SearchGoodsClassVo searchGoodsClassReturnVo = null;
		try {
			TreeMap<String, String> queryMap = new TreeMap<String, String>();
			queryMap.put("className", keyword);
			QueryResponse queryGoodsClassRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE,curPage, goodsClassPageSize, null,null);
			queryMap.clear();
			SolrDocumentList queryGoodsClassDocumentList = queryGoodsClassRsp.getResults();
			long queryGoodsClassNumFound = queryGoodsClassDocumentList.getNumFound();
			
			
			//精确查询,有查询到结果集
			if(queryGoodsClassNumFound > Globals.NUBER_ZERO){
				
				
				
				List<GoodsBrandVo> listSearchGoodsBrandsVo = new ArrayList<>();
				Map<GoodsSpecificationVo,List<GoodsSpecificationPropertyVo>> mapSpecs = null;
				List<GoodsVo> listSearchGoodsVo = new ArrayList<>();
				
				//1.查询出来的商品分类
				List<GoodsClassVo> listSearchGoodsClassVo = SolrUtil.createListBeanVo(queryGoodsClassDocumentList, GoodsClassVo.class);
				GoodsClassVo searchGoodsClassVo = listSearchGoodsClassVo.get(Globals.NUBER_ZERO);
				
				//2.查询分类下的品牌
				queryMap.put("goodsTypeBrandTypeId", String.valueOf(searchGoodsClassVo.getId()));
				QueryResponse queryGoodsTypeBrandsRsp = SolrUtil.simpleSearch(queryMap,  Boolean.FALSE,curPage, goodsTypeBrandsPageSize, null,null);
				queryMap.clear();
				
				SolrDocumentList queryGoodsTypeBrandsDocumentList = queryGoodsTypeBrandsRsp.getResults();
				long queryGoodsTypeBrandsNumFound = queryGoodsTypeBrandsDocumentList.getNumFound();
				List<GoodsTypeBrandVo> listSearchGoodsTypeBrandVo = null;
				
				//分类下有品牌
				if(queryGoodsTypeBrandsNumFound > Globals.NUBER_ZERO){
					//分类下的品牌结果集
					listSearchGoodsTypeBrandVo = SolrUtil.createListBeanVo(queryGoodsTypeBrandsDocumentList, GoodsTypeBrandVo.class);
					StringBuilder sb = new StringBuilder();
					for(GoodsTypeBrandVo searchGoodsTypeBrandVo : listSearchGoodsTypeBrandVo){
						sb.append(String.valueOf(searchGoodsTypeBrandVo.getGoodsTypeBrandBrandId()));
						sb.append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					queryMap.put("goodsBrandPKId", sb.toString());
					
					QueryResponse queryGoodsBrandsRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,null);
					queryMap.clear();
					
					SolrDocumentList queryGoodsBrandsDocumentList = queryGoodsBrandsRsp.getResults();
					long queryGoodsBrandsNumFound = queryGoodsBrandsDocumentList.getNumFound();
					
					if(queryGoodsBrandsNumFound > Globals.NUBER_ZERO){
						listSearchGoodsBrandsVo = SolrUtil.createListBeanVo(queryGoodsBrandsDocumentList, GoodsBrandVo.class);
					}
				}else{
				//分类下没有品牌	
					
				}
				
				//3.查询分类对应的规格和每个规格的值组
				Long gcId = searchGoodsClassVo.getId();
				queryMap.put("classId", String.valueOf(gcId));
				//最多只查5个规格属性出来显示
				QueryResponse queryGoodsClassSpecRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsSpcesPageSize, null,null);
				queryMap.clear();
				
				SolrDocumentList queryGoodsClassSpecDocumentList = queryGoodsClassSpecRsp.getResults();
				long queryGoodsClassSpecNumFound = queryGoodsClassSpecDocumentList.getNumFound();
				//该分类下有规格属性
				if(queryGoodsClassSpecNumFound > Globals.NUBER_ZERO){
					mapSpecs = new HashMap<>();
					List<GoodsClassSpecVo> listSearchGoodsClassSpecVo = SolrUtil.createListBeanVo(queryGoodsClassSpecDocumentList, GoodsClassSpecVo.class);
					QueryResponse rsp = null;
					SolrDocumentList documentList = null;
					long numFound = 0;
					
					GoodsSpecificationVo searchGoodsSpecificationVo = null;
					List<GoodsSpecificationPropertyVo> listProperty = null;
					List<Long> listStr = new ArrayList<>();
					for(GoodsClassSpecVo searchGoodsClassSpecVo : listSearchGoodsClassSpecVo){
						queryMap.put("goodsSpecificationPKId", String.valueOf(searchGoodsClassSpecVo.getSpecificationId()));
						rsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, pageSize, null,null);
						queryMap.clear();
						documentList = rsp.getResults();
						numFound = documentList.getNumFound();
						if(numFound > Globals.NUBER_ZERO){
							
							List<GoodsSpecificationVo> listSpecification = SolrUtil.createListBeanVo(documentList, GoodsSpecificationVo.class);
							//规格
							searchGoodsSpecificationVo = listSpecification.get(Globals.NUBER_ZERO);
							queryMap.put("specId", String.valueOf(searchGoodsSpecificationVo.getId()));
							
							
							rsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, pageSize, null,null);
							queryMap.clear();
							documentList = rsp.getResults();
							numFound = documentList.getNumFound();
							//规格下有值
							if(numFound > Globals.NUBER_ZERO){
								listProperty = SolrUtil.createListBeanVo(documentList, GoodsSpecificationPropertyVo.class);
							}
							if(!listStr.contains(searchGoodsSpecificationVo.getId())){
								listStr.add(searchGoodsSpecificationVo.getId());
								mapSpecs.put(searchGoodsSpecificationVo, listProperty);
							}
						}
					}
				}
				
				//4.查询在商品表里该分类下的商品,并按照销量排序,分页
				QueryResponse queryGoodsRsp = null;
				queryMap.put("gcId", String.valueOf(searchGoodsClassVo.getId()));
				queryMap.put("goodsStatus", "0");
				
				
				TreeMap<String, Boolean> sortField_map = new TreeMap<String, Boolean>();
				if(StringUtils.isNotEmpty(sortName)){
					if(orderType.equalsIgnoreCase("asc")){
						sortField_map.put(sortName, Boolean.TRUE);
					}else{
						sortField_map.put(sortName, Boolean.FALSE);
					}
				}else{
					//默认按照日期排序(降序)
					sortField_map.put("addTime", Boolean.FALSE);
				}
				
				//查询结果集过滤
				Map<String[], Boolean> queryFilter_map = null;
				if(StringUtils.isNotEmpty(brandId) || StringUtils.isNotEmpty(brandSpceId)){
					queryFilter_map = new HashMap<String[], Boolean>();
					if(StringUtils.isNotEmpty(brandId)){
						queryFilter_map.put(new String[]{"goodsBrandId", brandId}, Boolean.FALSE);
					}
					if(StringUtils.isNotEmpty(brandSpceId)){
						queryFilter_map.put(new String[]{"goodsProperty", brandSpceId}, Boolean.TRUE);
					}
				}
				
				//价格范围段查询  
				if((sprice != null && CommUtil.isInteger(sprice)) || (eprice != null && CommUtil.isInteger(eprice))){
					queryGoodsRsp = SolrUtil.rangeNumberSearch(queryMap, Boolean.TRUE,sortName ,sprice, eprice, curSearchPage , size, sortField_map, queryFilter_map);
				}else{
					queryGoodsRsp = SolrUtil.simpleSearch(queryMap, Boolean.TRUE, curSearchPage, size, sortField_map, queryFilter_map);
				}
				
				queryMap.clear();
				SolrDocumentList queryGoodsDocumentList = queryGoodsRsp.getResults();
				long queryGoodsNumFound = queryGoodsDocumentList.getNumFound();
				
				//该分类下有商品
				List<GoodsVo> listSearchGoodsVos = new ArrayList<>();
				
				if(queryGoodsNumFound > Globals.NUBER_ZERO){
					listSearchGoodsVo = SolrUtil.createListBeanVo(queryGoodsDocumentList, GoodsVo.class);
					int j = 0;
					for(int i = 0; i < listSearchGoodsVo.size(); i++)
					{
						if(listSearchGoodsVo.get(i).getGoodsDeletestatus().equals("false") && listSearchGoodsVo.get(i).getGoodsStatus() == 0)
						{
							listSearchGoodsVos.add(j, listSearchGoodsVo.get(i));
							j++;
						}
					}
					
				}
					int totalRows = Long.valueOf(queryGoodsRsp.getResults().getNumFound()).intValue();
					
					if(listSearchGoodsVos.size()>0){
					searchGoodsClassReturnVo = new SearchGoodsClassVo();	
					searchGoodsClassReturnVo.setTotalRows(totalRows);
					searchGoodsClassReturnVo.setListSearchGoodsBrandsVo(listSearchGoodsBrandsVo);
					searchGoodsClassReturnVo.setListSpecs(mapSpecs);
					searchGoodsClassReturnVo.setListSearchGoodsVo(listSearchGoodsVos);
					}
				
			}else{
				//精确查询,没有查询到结果集
				
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return searchGoodsClassReturnVo;
	}

	/**
	 * 根据关键字精确查询商品品牌
	* @Title: queryTypeGoodsBrand 
	* @Description: TODO
	* @param  keyword
	* @param  sortName
	* @param  sprice
	* @param  eprice
	* @return SearchGoodsBrandVo  
	* @throws
	 */
	public static SearchGoodsBrandVo queryTypeGoodsBrand(String keyword,String brandSpceId,int curSearchPage,String sortName,BigDecimal sprice,BigDecimal eprice, String orderType) {
		
		SearchGoodsBrandVo searchGoodsBrandVo = null;
		
		TreeMap<String, String> queryMap = new TreeMap<String, String>();
		queryMap.put("goodsBrandName", keyword);
		QueryResponse queryGoodsBrandRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,null);
		queryMap.clear();
		SolrDocumentList queryGoodsBrandDocumentList = queryGoodsBrandRsp.getResults();
		long queryGoodsBrandNumFound = queryGoodsBrandDocumentList.getNumFound();
		
		//查询到平台有的品牌
		if(queryGoodsBrandNumFound > Globals.NUBER_ZERO){
			
			
			GoodsBrandVo goodsBrandVo = new GoodsBrandVo();
			Map<GoodsSpecificationVo,List<GoodsSpecificationPropertyVo>> mapSpecs = null;
			List<GoodsVo> listSearchGoodsVo = new ArrayList<>();
			
			List<GoodsBrandVo> listSearchGoodsBrandsVo = null;
			try {
				listSearchGoodsBrandsVo = SolrUtil.createListBeanVo(queryGoodsBrandDocumentList, GoodsBrandVo.class);
				goodsBrandVo = listSearchGoodsBrandsVo.get(Globals.NUBER_ZERO);
				
				//查询品牌下所有分类下的商品中,最多商品对应的分类
				//1.根据品牌ID,到amall_goodstype_brand,查询品牌下的所有商品分类
				queryMap.put("goodsTypeBrandBrandId", String.valueOf(goodsBrandVo.getId()));
				QueryResponse queryGoodsTypeBrandRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,null);
				queryMap.clear();
				SolrDocumentList queryGoodsTypeBrandDocumentList = queryGoodsTypeBrandRsp.getResults();
				long queryGoodsTypeBrandNumFound = queryGoodsTypeBrandDocumentList.getNumFound();
				//品牌下有商品分类(如:小米品牌下有手机,路由器)
				List<Long> listGcId = new ArrayList<>();
				if(queryGoodsTypeBrandNumFound > Globals.NUBER_ZERO){
					StringBuilder sb = new StringBuilder();
					List<GoodsTypeBrandVo> listGoodsTypeBrandVo = SolrUtil.createListBeanVo(queryGoodsTypeBrandDocumentList, GoodsTypeBrandVo.class);
					for(GoodsTypeBrandVo goodsTypeBrandVo : listGoodsTypeBrandVo){
						sb.append(goodsTypeBrandVo.getGoodsTypeBrandTypeId());
						sb.append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					queryMap.put("gcId", sb.toString());
					String facetField = "gcId";
					QueryResponse queryGoodsByGcIdRsp = SolrUtil.simpleSearchGroup(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,facetField,null);
					queryMap.clear();
					
					//根据维度gcid进行分组,倒序
					List<FacetField> facetFields = queryGoodsByGcIdRsp.getFacetFields();
					if(!facetFields.isEmpty()){
						List<Count> listCount = facetFields.get(Globals.NUBER_ZERO).getValues();
						for(Count count :listCount){
							listGcId.add(Long.valueOf(count.getName()));
						}
					}
				}
				//2.根据分类获取到分类下的规格
				if(!listGcId.isEmpty()){
					mapSpecs = new HashMap<>();
					for(int i = 0; i < listGcId.size(); i++){
						queryMap.put("classId", String.valueOf(listGcId.get(i)));
						//最多只查5个规格属性出来显示
						QueryResponse queryGoodsClassSpecRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsSpcesPageSize, null,null);
						queryMap.clear();
						
						SolrDocumentList queryGoodsClassSpecDocumentList = queryGoodsClassSpecRsp.getResults();
						long queryGoodsClassSpecNumFound = queryGoodsClassSpecDocumentList.getNumFound();
						//该分类下有规格属性
						if(queryGoodsClassSpecNumFound > Globals.NUBER_ZERO){
							
							
							List<GoodsClassSpecVo> listSearchGoodsClassSpecVo = SolrUtil.createListBeanVo(queryGoodsClassSpecDocumentList, GoodsClassSpecVo.class);
							QueryResponse rsp = null;
							SolrDocumentList documentList = null;
							long numFound = 0;
							
							GoodsSpecificationVo searchGoodsSpecificationVo = null;
							List<GoodsSpecificationPropertyVo> listProperty = null;
							List<Long> listStr = new ArrayList<>();
							for(GoodsClassSpecVo searchGoodsClassSpecVo : listSearchGoodsClassSpecVo){
								queryMap.put("goodsSpecificationPKId", String.valueOf(searchGoodsClassSpecVo.getSpecificationId()));
								rsp = SolrUtil.simpleSearch(queryMap,  Boolean.FALSE,curPage, pageSize, null,null);
								queryMap.clear();
								documentList = rsp.getResults();
								numFound = documentList.getNumFound();
								if(numFound > Globals.NUBER_ZERO){
									List<GoodsSpecificationVo> listSpecification = SolrUtil.createListBeanVo(documentList, GoodsSpecificationVo.class);
									searchGoodsSpecificationVo = listSpecification.get(Globals.NUBER_ZERO);
									queryMap.put("specId", String.valueOf(searchGoodsSpecificationVo.getId()));
									rsp = SolrUtil.simpleSearch(queryMap,  Boolean.FALSE,curPage, pageSize, null,null);
									queryMap.clear();
									documentList = rsp.getResults();
									numFound = documentList.getNumFound();
									//规格下有值
									if(numFound > Globals.NUBER_ZERO){
										listProperty = SolrUtil.createListBeanVo(documentList, GoodsSpecificationPropertyVo.class);
									}
									if(!listStr.contains(searchGoodsSpecificationVo.getId())){
										listStr.add(searchGoodsSpecificationVo.getId());
										mapSpecs.put(searchGoodsSpecificationVo, listProperty);
									}
								}
								
							}
							break;
						}else{
							continue;
						}
					}
				}
				
				//3.根据商品品牌ID,从goods查询该品牌下的商城(发布商品的时候,要选择商品的品牌,这样才能查询品牌下的商品出来)
				QueryResponse queryGoodsRsp = null;
				queryMap.put("goodsBrandId", String.valueOf(goodsBrandVo.getId()));
				TreeMap<String, Boolean> sortField_map = new TreeMap<String, Boolean>();
				if(StringUtils.isNotEmpty(sortName)){
					if(orderType.equalsIgnoreCase("asc")){
						sortField_map.put(sortName, Boolean.TRUE);
					}else{
						sortField_map.put(sortName, Boolean.FALSE);
					}
				}else{
					//默认按照日期排序(降序)
					sortField_map.put("addTime", Boolean.FALSE);
				}
				
				//查询结果集过滤
				Map<String[], Boolean> queryFilter_map = null;
				if(StringUtils.isNotEmpty(brandSpceId)){
					queryFilter_map = new HashMap<String[], Boolean>();
					queryFilter_map.put(new String[]{"goodsProperty", String.valueOf(brandSpceId)}, Boolean.TRUE);
				}
				
				//价格范围段查询
				if((sprice != null && CommUtil.isInteger(sprice)) || (eprice != null && CommUtil.isInteger(eprice))){
					queryGoodsRsp = SolrUtil.rangeNumberSearch(queryMap, Boolean.TRUE,sortName ,sprice, eprice, curSearchPage , size, sortField_map,queryFilter_map);
				}else{
					queryGoodsRsp = SolrUtil.simpleSearch(queryMap, Boolean.TRUE, curSearchPage, size, sortField_map,queryFilter_map);
				}
				queryMap.clear();
				SolrDocumentList queryGoodsDocumentList = queryGoodsRsp.getResults();
				long queryGoodsNumFound = queryGoodsDocumentList.getNumFound();
				//该品牌下有商品
				List<GoodsVo> listSearchGoodsVos = new ArrayList<>();
 				
				if(queryGoodsNumFound > Globals.NUBER_ZERO){
					listSearchGoodsVo = SolrUtil.createListBeanVo(queryGoodsDocumentList, GoodsVo.class);
					int j = 0;
					for(int i = 0; i < listSearchGoodsVo.size(); i++)
					{
						if(listSearchGoodsVo.get(i).getGoodsDeletestatus().equals("false") && listSearchGoodsVo.get(i).getGoodsStatus() == 0)
						{
							listSearchGoodsVos.add(j, listSearchGoodsVo.get(i));
							j++;
						}
					}
				}
				
					int totalRows = Long.valueOf(queryGoodsRsp.getResults().getNumFound()).intValue();
					if(listSearchGoodsVos.size()>0){
					searchGoodsBrandVo = new SearchGoodsBrandVo();	
					searchGoodsBrandVo.setTotalRows(totalRows);
					searchGoodsBrandVo.setGoodsBrandVo(goodsBrandVo);
					searchGoodsBrandVo.setListSpecs(mapSpecs);
					searchGoodsBrandVo.setListSearchGoodsVo(listSearchGoodsVos);
					}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}else{
			//没有查询到品牌
		}
		return searchGoodsBrandVo;
	}

	
	/**
	 * 根据关键字精确查询商品店铺(前端查询内容给予补全aotuComplete)
	* @Title: queryTypeGoodsStore 
	* @Description: TODO
	* @param  keyword
	* @param  sortName
	* @param  sprice
	* @param  eprice
	* @return SearchGoodsStoreVo  
	* @throws
	 */
	public static SearchGoodsStoreVo queryTypeGoodsStore(String keyword) {
		
		SearchGoodsStoreVo searchGoodsStoreVo = null;
		
		TreeMap<String, String> queryMap = new TreeMap<String, String>();
		queryMap.put("storeName", "*"+keyword+"*");
		queryMap.put("storeStatus", "2");
		QueryResponse searchGoodsStoreRsp = SolrUtil.simpleSearch(queryMap, Boolean.TRUE, curPage, goodsStorePageSize, null,null);
		queryMap.clear();
		SolrDocumentList searchGoodsStoreDocumentList = searchGoodsStoreRsp.getResults();
		long searchGoodsStoreNumFound = searchGoodsStoreDocumentList.getNumFound();
		 
		//查询到平台有的店铺
		if(searchGoodsStoreNumFound > Globals.NUBER_ZERO){
			try {
				searchGoodsStoreVo = new SearchGoodsStoreVo();
				List<GoodsStoreVo> listSearchGoodsStoreVo = SolrUtil.createListBeanVo(searchGoodsStoreDocumentList, GoodsStoreVo.class);
				if(listSearchGoodsStoreVo!=null&&listSearchGoodsStoreVo.size()>0)
				searchGoodsStoreVo.setListGoodsStoreVo(listSearchGoodsStoreVo);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return searchGoodsStoreVo;
	}
	
	/**
	 * 根据关键字精确查询商品规格
	* @Title: queryTypeGoodsSpec 
	* @Description: TODO
	* @param  keyword
	* @param  sortName
	* @param  sprice
	* @param  eprice
	* @return SearchGoodsSpecVo  
	* @throws
	 */
	public static SearchGoodsSpecVo queryTypeGoodsSpec(String keyword,String brandId,String gcId,int curSearchPage,String sortName,BigDecimal sprice,BigDecimal eprice, String orderType) {
		SearchGoodsSpecVo searchGoodsSpecVo = null;
		
		List<GoodsClassVo> listGoodsClassVo = null;
		List<GoodsBrandVo> listGoodsBrandVo = null;
		List<GoodsVo> listGoodsVo = null;
		
		TreeMap<String, String> queryMap = new TreeMap<String, String>();
		queryMap.put("goodsSpecPropertyValue", keyword);
		
		QueryResponse searchGoodsSpecRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, size, null,null);
		queryMap.clear();
		SolrDocumentList searchGoodsSpecRspDocumentList = searchGoodsSpecRsp.getResults();
		long searchGoodsSpecNumFound = searchGoodsSpecRspDocumentList.getNumFound();
		//规格值表查询规格值对应的规格ID
		if(searchGoodsSpecNumFound > Globals.NUBER_ZERO){
			try {
				
				List<GoodsSpecificationPropertyVo> listSearchGoodsStoreVo = SolrUtil.createListBeanVo(searchGoodsSpecRspDocumentList, GoodsSpecificationPropertyVo.class);
				GoodsSpecificationPropertyVo goodsSpecificationPropertyVo = listSearchGoodsStoreVo.get(Globals.NUBER_ZERO);
				//1.根据规格ID查询所有该规格的商品分类(amall_goodsclass_spec)
				queryMap.put("specificationId", String.valueOf(goodsSpecificationPropertyVo.getSpecId()));
				QueryResponse searchGoodsClassSpecRsp = SolrUtil.simpleSearch(queryMap,  Boolean.FALSE,curPage, pageSize, null,null);
				queryMap.clear();
				SolrDocumentList searchGoodsClassSpecDocumentList = searchGoodsClassSpecRsp.getResults();
				long searchGoodsClassSpecNumFound = searchGoodsClassSpecDocumentList.getNumFound();
				if(searchGoodsClassSpecNumFound > Globals.NUBER_ZERO){
					
					List<GoodsClassSpecVo> listGoodsClassSpecVo = SolrUtil.createListBeanVo(searchGoodsClassSpecDocumentList, GoodsClassSpecVo.class);
					List<Long> listGoodsBrandId = new ArrayList<>();
					listGoodsClassVo = new ArrayList<>();
					for(int i = 0; i < listGoodsClassSpecVo.size(); i++){
						//根据gcId获取商品分类
						queryMap.put("goodsClassPKId", String.valueOf(listGoodsClassSpecVo.get(i).getClassId()));
						
						QueryResponse searchGoodsClassRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, pageSize, null,null);
						queryMap.clear();
						SolrDocumentList searchGoodsClassDocumentList = searchGoodsClassRsp.getResults();
						long searchGoodsClassNumFound = searchGoodsClassDocumentList.getNumFound();
						if(searchGoodsClassNumFound > Globals.NUBER_ZERO){
							List<GoodsClassVo> temp = SolrUtil.createListBeanVo(searchGoodsClassDocumentList, GoodsClassVo.class);
							listGoodsClassVo.add(temp.get(Globals.NUBER_ZERO));
						}
						
						//组装品牌ID
						queryMap.put("goodsTypeBrandTypeId", String.valueOf(listGoodsClassSpecVo.get(i).getClassId()));
						QueryResponse searchGoodsTypeBrandRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, pageSize, null,null);
						queryMap.clear();
						SolrDocumentList searchGoodsTypeBrandDocumentList = searchGoodsTypeBrandRsp.getResults();
						long searchGoodsTypeBrandNumFound = searchGoodsTypeBrandDocumentList.getNumFound();
						if(searchGoodsTypeBrandNumFound > Globals.NUBER_ZERO){
							List<GoodsTypeBrandVo> listGoodsTypeBrandVo = SolrUtil.createListBeanVo(searchGoodsTypeBrandDocumentList, GoodsTypeBrandVo.class);
							for(GoodsTypeBrandVo goodsTypeBrandVo : listGoodsTypeBrandVo){
								//过滤重复的品牌Id
								if(!listGoodsBrandId.contains(goodsTypeBrandVo.getGoodsTypeBrandBrandId())){
									listGoodsBrandId.add(goodsTypeBrandVo.getGoodsTypeBrandBrandId());
								}
								
							}
						}
					}
					//2.获取品牌列表(amall_goodstype_brand)
					if(listGoodsBrandId.size() > Globals.NUBER_ZERO){
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < listGoodsBrandId.size(); i++){
							sb.append(listGoodsBrandId.get(i));
							sb.append(",");
						}
						sb.deleteCharAt(sb.length() - 1);
						queryMap.put("goodsBrandPKId", sb.toString());
						QueryResponse queryGoodsBrandRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,null);
						queryMap.clear();
						SolrDocumentList queryGoodsBrandDocumentList = queryGoodsBrandRsp.getResults();
						long queryGoodsBrandNumFound = queryGoodsBrandDocumentList.getNumFound();
						if(queryGoodsBrandNumFound > Globals.NUBER_ZERO){
							listGoodsBrandVo = SolrUtil.createListBeanVo(queryGoodsBrandDocumentList, GoodsBrandVo.class);
						}
					}
					//3.根据商品分类gcId,获取商品列表
					List<GoodsVo> listGoodsVos = new ArrayList<>();
					if(listGoodsClassVo.size() > Globals.NUBER_ZERO){
						listGoodsVo = new ArrayList<>();
						StringBuilder sb = new StringBuilder();
						for(GoodsClassVo goodsClassVo : listGoodsClassVo){
							sb.append(goodsClassVo.getId());
							sb.append(",");
						}
						sb.deleteCharAt(sb.length() - 1);
						
						queryMap.put("gcId", sb.toString());
						QueryResponse queryGoodsRsp = null;
						
						TreeMap<String, Boolean> sortField_map = new TreeMap<String, Boolean>();
						if(StringUtils.isNotEmpty(sortName)){
							if(orderType.equalsIgnoreCase("asc")){
								sortField_map.put(sortName, Boolean.TRUE);
							}else{
								sortField_map.put(sortName, Boolean.FALSE);
							}
						}else{
							//默认按照日期排序(降序)
							sortField_map.put("addTime", Boolean.FALSE);
						}
						
						//查询结果集过滤
						Map<String[], Boolean> queryFilter_map = null;
						
						if(StringUtils.isNotEmpty(gcId) || StringUtils.isNotEmpty(brandId)){
							queryFilter_map = new HashMap<String[], Boolean>();
							if(StringUtils.isNotEmpty(gcId)){
								queryFilter_map.put(new String[]{"gcId", String.valueOf(gcId)}, Boolean.FALSE);
							}
							if(StringUtils.isNotEmpty(brandId)){
								queryFilter_map.put(new String[]{"goodsBrandId", String.valueOf(brandId)}, Boolean.FALSE);
							}
						}

						if((sprice != null && CommUtil.isInteger(sprice)) || (eprice != null && CommUtil.isInteger(eprice))){
							queryGoodsRsp = SolrUtil.rangeNumberSearch(queryMap, Boolean.FALSE,sortName ,sprice, eprice, curSearchPage , size, sortField_map,queryFilter_map);
						}else{
							queryGoodsRsp = SolrUtil.simpleSearch(queryMap, Boolean.FALSE, curSearchPage, size, sortField_map,queryFilter_map);
						}
						
						
						queryMap.clear();
						SolrDocumentList queryGoodsDocumentList = queryGoodsRsp.getResults();
						long queryGoodsNumFound = queryGoodsDocumentList.getNumFound();
						
						if(queryGoodsNumFound > Globals.NUBER_ZERO){
							listGoodsVo = SolrUtil.createListBeanVo(queryGoodsDocumentList, GoodsVo.class);
							int j = 0;
							for(int i = 0; i < listGoodsVo.size(); i++)
							{
								if(listGoodsVo.get(i).getGoodsDeletestatus().equals("false") && listGoodsVo.get(i).getGoodsStatus() == 0)
								{
									listGoodsVos.add(j, listGoodsVo.get(i));
									j++;
								}
							}
						}
						if(listGoodsVos.size()>0){
							int totalRows = Long.valueOf(queryGoodsRsp.getResults().getNumFound()).intValue();
							searchGoodsSpecVo = new SearchGoodsSpecVo();
							searchGoodsSpecVo.setTotalRows(totalRows);	
							searchGoodsSpecVo.setListGoodsClassVo(listGoodsClassVo);
							searchGoodsSpecVo.setListGoodsBrandVo(listGoodsBrandVo);
							searchGoodsSpecVo.setListGoodsVo(listGoodsVos);
						}
					}
					
				}
				
				
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return searchGoodsSpecVo;
	}

	/**
	 * 根据关键字模糊查询商品
	* @Title: queryTypeGoods 
	* @Description: TODO
	* @param keyword
	* @param sortName
	* @param sprice
	* @param eprice
	* @return SearchGoodsVo  
	* @throws
	 */
	public static SearchGoodsVo queryTypeGoods(String keyword, String brandId, String brandSpceId, String gcId, int curSearchPage,String sortName,BigDecimal sprice,BigDecimal eprice, String orderType) {
		SearchGoodsVo searchGoodsVo = null;
		
		List<GoodsVo> listGoodsVo = null;
		List<GoodsBrandVo> listGoodsBrandVo = null;
		List<GoodsClassVo> listGoodsClassVo = null;
		Map<GoodsSpecificationVo,List<GoodsSpecificationPropertyVo>> mapSpecs = null;
		
		
		List<GoodsTypeBrandVo> listGoodsTypeBrandVo = null;
		
		TreeMap<String, String> queryMap = new TreeMap<String, String>();
		QueryResponse queryGoodsRsp = null;
		queryMap.put("goodsName", "*"+keyword+"*");
		System.out.println("搜索的商品名: " + keyword);
		TreeMap<String, Boolean> sortField_map = new TreeMap<String, Boolean>();
		if(StringUtils.isNotEmpty(sortName)){
			if(orderType.equalsIgnoreCase("asc")){
				sortField_map.put(sortName, Boolean.TRUE);
			}else{
				sortField_map.put(sortName, Boolean.FALSE);
			}
		}else{
			//默认按照日期排序(降序)
			sortField_map.put("addTime", Boolean.FALSE);
		}
		
		//1.查询商品结果集不重复的品牌List
		String facetField = "goodsBrandId";
		QueryResponse queryGoodsRsp_facet_goodsBrandId = SolrUtil.simpleSearchGroup(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,facetField,null);
		//根据维度goodsBrandId进行分组,倒序
		List<FacetField> facetFields_goodsBrandId = queryGoodsRsp_facet_goodsBrandId.getFacetFields();
		if(!facetFields_goodsBrandId.isEmpty()){
			StringBuilder sb = new StringBuilder();
			List<Count> listCount = facetFields_goodsBrandId.get(Globals.NUBER_ZERO).getValues();
			for(Count count :listCount){
				//过滤掉分组统计结果为0的品牌
				if(count.getCount() > Globals.NUBER_ZERO){
					sb.append(count.getName());
					sb.append(",");
				}
			}
			if(sb.length() > 0){
				sb.deleteCharAt(sb.length() - 1);
				TreeMap<String, String> queryBrandMap = new TreeMap<String, String>();
				QueryResponse queryBrandRsp = null;
				queryBrandMap.put("goodsBrandPKId", sb.toString());
				queryBrandRsp = SolrUtil.simpleSearch(queryBrandMap,  Boolean.FALSE,curPage, goodsBrandsPageSize, null,null);
				SolrDocumentList queryBrandDocumentList = queryBrandRsp.getResults();
				long queryBrandNumFound = queryBrandDocumentList.getNumFound();
				if(queryBrandNumFound > Globals.NUBER_ZERO){
					try {
						listGoodsBrandVo = SolrUtil.createListBeanVo(queryBrandDocumentList, GoodsBrandVo.class);
					} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		//2.如果品牌List为空，则直接查询商品结果集内,不重复的商品分类List
		if(listGoodsBrandVo == null){
			String facetField_class = "gcId";
			QueryResponse queryGoodsRsp_facet_gcid = SolrUtil.simpleSearchGroup(queryMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,facetField_class,null);
			List<FacetField> facetFields_gcid = queryGoodsRsp_facet_gcid.getFacetFields();
			if(!facetFields_gcid.isEmpty()){
				StringBuilder sb = new StringBuilder();
				List<Count> listCount = facetFields_goodsBrandId.get(Globals.NUBER_ZERO).getValues();
				for(Count count :listCount){
					//过滤掉分组统计结果为0的品牌
					if(count.getCount() > Globals.NUBER_ZERO){
						sb.append(count.getName());
						sb.append(",");
					}
				}
				if(sb.length() > 0){
					sb.deleteCharAt(sb.length() - 1);
					TreeMap<String, String> queryClassMap = new TreeMap<String, String>();
					queryClassMap.put("goodsClassPKId", sb.toString());
					QueryResponse queryClassRsp = SolrUtil.simpleSearch(queryClassMap, Boolean.FALSE, curPage, goodsClassPageSize, null,null);
					SolrDocumentList queryClassDocumentList = queryClassRsp.getResults();
					long queryClassNumFound = queryClassDocumentList.getNumFound();
					if(queryClassNumFound > Globals.NUBER_ZERO){
						try {
							listGoodsClassVo = SolrUtil.createListBeanVo(queryClassDocumentList, GoodsClassVo.class);
						} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}else{
			//3.品牌List不为空,则根据品牌ID查询,品牌下的商品分类List
			StringBuilder sb = new StringBuilder();
			for(GoodsBrandVo goodsBrandVo : listGoodsBrandVo){
				sb.append(goodsBrandVo.getId());
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			TreeMap<String, String> queryTypeBrandMap = new TreeMap<String, String>();
			queryTypeBrandMap.put("goodsTypeBrandBrandId", sb.toString());
			QueryResponse queryTypeBrandRsp = SolrUtil.simpleSearch(queryTypeBrandMap, Boolean.FALSE, curPage, goodsBrandsPageSize, null,null);
			SolrDocumentList queryTypeBrandDocumentList = queryTypeBrandRsp.getResults();
			long queryTypeBrandNumFound = queryTypeBrandDocumentList.getNumFound();
			if(queryTypeBrandNumFound > Globals.NUBER_ZERO){
				try {
					sb.setLength(Globals.NUBER_ZERO);
					listGoodsTypeBrandVo = SolrUtil.createListBeanVo(queryTypeBrandDocumentList, GoodsTypeBrandVo.class);
					for(GoodsTypeBrandVo goodsTypeBrandVo : listGoodsTypeBrandVo){
						sb.append(goodsTypeBrandVo.getGoodsTypeBrandTypeId());
						sb.append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					
					TreeMap<String, String> queryClassMap = new TreeMap<String, String>();
					queryClassMap.put("goodsClassPKId", sb.toString());
					QueryResponse queryClassRsp = SolrUtil.simpleSearch(queryClassMap, Boolean.FALSE, curPage, goodsClassPageSize, null,null);
					SolrDocumentList queryClassDocumentList = queryClassRsp.getResults();
					long queryClassNumFound = queryClassDocumentList.getNumFound();
					if(queryClassNumFound > Globals.NUBER_ZERO){
						listGoodsClassVo = SolrUtil.createListBeanVo(queryClassDocumentList, GoodsClassVo.class);
					}
					
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		//4.根据商品分类List,查询规格List(每个分类对应的规格)
		if(listGoodsClassVo != null){
			mapSpecs = new HashMap<>();
			TreeMap<String, String> queryClassMap = new TreeMap<String, String>();
			for(GoodsClassVo goodsClassVo : listGoodsClassVo){
				try{
					queryClassMap.put("classId", String.valueOf(goodsClassVo.getId()));
					//最多只查5个规格属性出来显示
					QueryResponse queryGoodsClassSpecRsp = SolrUtil.simpleSearch(queryClassMap,  Boolean.FALSE,curPage, goodsSpcesPageSize, null,null);
					queryClassMap.clear();
					
					SolrDocumentList queryGoodsClassSpecDocumentList = queryGoodsClassSpecRsp.getResults();
					long queryGoodsClassSpecNumFound = queryGoodsClassSpecDocumentList.getNumFound();
					//该分类下有规格属性
					if(queryGoodsClassSpecNumFound > Globals.NUBER_ZERO){
						
						
						List<GoodsClassSpecVo> listSearchGoodsClassSpecVo = SolrUtil.createListBeanVo(queryGoodsClassSpecDocumentList, GoodsClassSpecVo.class);
						QueryResponse rsp = null;
						SolrDocumentList documentList = null;
						long numFound = 0;
						
						GoodsSpecificationVo searchGoodsSpecificationVo = null;
						List<GoodsSpecificationPropertyVo> listProperty = null;
						
						for(GoodsClassSpecVo searchGoodsClassSpecVo : listSearchGoodsClassSpecVo){
							queryClassMap.put("goodsSpecificationPKId", String.valueOf(searchGoodsClassSpecVo.getSpecificationId()));
							rsp = SolrUtil.simpleSearch(queryClassMap, Boolean.FALSE, curPage, pageSize, null,null);
							queryClassMap.clear();
							documentList = rsp.getResults();
							numFound = documentList.getNumFound();
							if(numFound > Globals.NUBER_ZERO){
								List<GoodsSpecificationVo> listSpecification = SolrUtil.createListBeanVo(documentList, GoodsSpecificationVo.class);
								searchGoodsSpecificationVo = listSpecification.get(Globals.NUBER_ZERO);
								queryClassMap.put("specId", String.valueOf(searchGoodsSpecificationVo.getId()));
								rsp = SolrUtil.simpleSearch(queryClassMap, Boolean.FALSE, curPage, pageSize, null,null);
								queryClassMap.clear();
								documentList = rsp.getResults();
								numFound = documentList.getNumFound();
								//规格下有值
								if(numFound > Globals.NUBER_ZERO){
									listProperty = SolrUtil.createListBeanVo(documentList, GoodsSpecificationPropertyVo.class);
								}
							}
							mapSpecs.put(searchGoodsSpecificationVo, listProperty);
						}
						break;
					}else{
						continue;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		//查询结果集过滤
		Map<String[], Boolean> queryFilter_map = null;
		if(StringUtils.isNotEmpty(brandId) || StringUtils.isNotEmpty(brandSpceId) || StringUtils.isNotEmpty(gcId)){
			queryFilter_map = new HashMap<String[], Boolean>();
			if(StringUtils.isNotEmpty(brandId)){
				queryFilter_map.put(new String[]{"goodsBrandId", String.valueOf(brandId)}, Boolean.FALSE);
			}
			//Boolean.TRUE 模糊查询
			if(StringUtils.isNotEmpty(brandSpceId)){
				queryFilter_map.put(new String[]{"goodsProperty", String.valueOf(brandSpceId)}, Boolean.TRUE);
			}
			if(StringUtils.isNotEmpty(gcId)){
				queryFilter_map.put(new String[]{"gcId", String.valueOf(gcId)}, Boolean.FALSE);
			}
		}
		//5.模糊搜索商品,按照gcId排序,分页 ,价格范围段查询
		if((sprice != null && CommUtil.isInteger(sprice)) || (eprice != null && CommUtil.isInteger(eprice))){
			queryGoodsRsp = SolrUtil.rangeNumberSearch(queryMap, Boolean.TRUE,sortName ,sprice, eprice, curSearchPage , size, sortField_map,queryFilter_map);
		}else{
			queryGoodsRsp = SolrUtil.simpleSearch(queryMap, Boolean.TRUE, curSearchPage, size, sortField_map,queryFilter_map);
		}
		
		SolrDocumentList queryGoodsDocumentList = queryGoodsRsp.getResults();
		long queryGoodsNumFound = queryGoodsDocumentList.getNumFound();
		if(queryGoodsNumFound > Globals.NUBER_ZERO){
			try {
				listGoodsVo = SolrUtil.createListBeanVo(queryGoodsDocumentList, GoodsVo.class);
				
				List<GoodsVo> listGoodsVos = new ArrayList<>();
				
				int j = 0;
				for(int i = 0; i < listGoodsVo.size(); i++)
				{
					System.out.println("商品模糊搜索结果集有值： " + listGoodsVo.get(i).getGoodsName());
					if(listGoodsVo.get(i).getGoodsDeletestatus().equals("false") && listGoodsVo.get(i).getGoodsStatus() == 0)
					{
						listGoodsVos.add(j, listGoodsVo.get(i));
						j++;
					}
				}
					if(listGoodsVos.size()>0){
					int totalRows = Long.valueOf(queryGoodsRsp.getResults().getNumFound()).intValue();
					searchGoodsVo = new SearchGoodsVo();
					searchGoodsVo.setTotalRows(totalRows);
					searchGoodsVo.setListGoodsBrandVo(listGoodsBrandVo);
					searchGoodsVo.setListGoodsClassVo(listGoodsClassVo);
					searchGoodsVo.setMapSpecs(mapSpecs);
					searchGoodsVo.setListGoodsVo(listGoodsVos);
					}
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}else{
			//没有查询到对应的商品
		}
		return searchGoodsVo;
	}
	
	
}
