package com.amall.core.action.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.solr.SearchGoodsBrandVo;
import com.amall.core.solr.SearchGoodsClassVo;
import com.amall.core.solr.SearchGoodsSolrUtil;
import com.amall.core.solr.SearchGoodsSpecVo;
import com.amall.core.solr.SearchGoodsStoreVo;
import com.amall.core.solr.SearchGoodsVo;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.page.SimplePage;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * @ClassName: SearchViewAction
 * @Description: 商品搜索
 * @author lx
 * @date 2016年1月13日 下午2:50:33
 */
@Controller
public class SearchViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private StoreViewTools storeTools;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsClassService goodsClassService;

	/*
	 * 商品搜索
	 */
	@SuppressWarnings({ "unused" , "unchecked" })
	@RequestMapping({ "/search.htm" })
	public ModelAndView search (HttpServletRequest request , HttpServletResponse response , String currentPage , String keyword , String orderBy , String orderType , String sprice , String eprice , String sc_id , String storeGrade_id , String storepoint , String area_id , String area_name , String brandId , String brandSpceId , String gcId)
		{
			ModelAndView mv = null;
			if (StringUtils.isNotEmpty (keyword))
			{
				keyword = CommUtil.decodeAndReplaceNULL (keyword);
				int curSearchPage = Globals.NUBER_ONE;
				if (StringUtils.isNotEmpty (currentPage))
				{
					if (CommUtil.isInteger (currentPage))
					{
						curSearchPage = Integer.parseInt (currentPage);
					}
				}
				BigDecimal p_sprice = null;
				BigDecimal p_eprice = null;
				if (StringUtils.isNotEmpty (sprice))
				{
					p_sprice = new BigDecimal (sprice);
				}
				if (StringUtils.isNotEmpty (eprice))
				{
					p_eprice = new BigDecimal (eprice);
				}
				// 已经选择
				List <Map<String,Object>>  goods_property = new ArrayList <Map<String,Object>> ();
				/* 搜索规则: 先精确查询商品类型,品牌,店铺,规格,如果查询返回有结果集.就走该查询流程,如果无结果集,则走商品的模糊搜索 */
				// 1.根据关键字精确查询商品类型
				SearchGoodsClassVo searchGoodsClassReturnVo = SearchGoodsSolrUtil.queryTypeGoodsClass (keyword , brandId , brandSpceId , curSearchPage , orderBy , p_sprice , p_eprice , orderType);
				if (null == searchGoodsClassReturnVo)
				{
					// 2.根据关键字精确查询商品品牌
					SearchGoodsBrandVo searchGoodsBrandVo = SearchGoodsSolrUtil.queryTypeGoodsBrand (keyword , brandSpceId , curSearchPage , orderBy , p_sprice , p_eprice , orderType);
					if (null == searchGoodsBrandVo)
					{
						// 3.根据关键字精确查询商品店铺
						SearchGoodsStoreVo searchGoodsStoreVo = SearchGoodsSolrUtil.queryTypeGoodsStore (keyword);
						if (null == searchGoodsStoreVo)
						{
							// 4.根据关键字精确查询商品规格
							SearchGoodsSpecVo searchGoodsSpecVo = SearchGoodsSolrUtil.queryTypeGoodsSpec (keyword , brandId , gcId , curSearchPage , orderBy , p_sprice , p_eprice , orderType);
							if (null == searchGoodsSpecVo)
							{
								// 5.根据关键字模糊查询商品
								SearchGoodsVo searchGoodsVo = SearchGoodsSolrUtil.queryTypeGoods (keyword , brandId , brandSpceId , gcId , curSearchPage , orderBy , p_sprice , p_eprice , orderType);
								if (null == searchGoodsVo)
								{
									// 查询不到任何内容
									mv = new JModelAndView ("search_noresult_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
								}
								else
								{
									// 跳转到搜索商品列表页
									mv = new JModelAndView ("search_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
									mv.addObject ("gbs" , searchGoodsVo.getListGoodsBrandVo ());
									mv.addObject ("gcs" , searchGoodsVo.getListGoodsClassVo ());
									mv.addObject ("objs" , searchGoodsVo.getListGoodsVo ());
									mv.addObject ("spces" , searchGoodsVo.getMapSpecs ());
									// 分页处理
									String url = CommUtil.getURL (request);
									int totalPage = (searchGoodsVo.getTotalRows () + SimplePage.DEF_COUNT - 1) / SimplePage.DEF_COUNT;
									mv.addObject ("totalPage" , totalPage);
									mv.addObject ("currentPage" , curSearchPage);
									mv.addObject ("gotoPageHTML" , CommUtil.showPageFormHtml (curSearchPage , totalPage));
									// 已选择
									Map <String, Object> map = null;
									if (StringUtils.isNotEmpty (brandId))
									{
										mv.addObject ("brandId" , brandId);
										GoodsBrand brand = this.goodsBrandService.getByKey (CommUtil.null2Long (brandId));
										map = new HashMap <String, Object> ();
										map.put ("name" , "品牌");
										map.put ("value" , brand.getName ());
										map.put ("type" , "brand");
										map.put ("id" , brand.getId ());
										goods_property.add (map);
									}
									if (StringUtils.isNotEmpty (gcId))
									{
										mv.addObject ("gcId" , gcId);
										GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (gcId));
										map = new HashMap <String, Object> ();
										map.put ("name" , "分类");
										map.put ("value" , gc.getClassname ());
										map.put ("type" , "gc");
										map.put ("id" , gc.getId ());
										goods_property.add (map);
									}
									if (StringUtils.isNotEmpty (brandSpceId))
									{
										mv.addObject ("brandSpceId" , brandSpceId);
										GoodsSpecProperty gsp = goodsSpecPropertyService.getByKey (CommUtil.null2Long (brandSpceId));
										map = new HashMap <String, Object> ();
										map.put ("name" , gsp.getSpec ().getName ());
										map.put ("value" , gsp.getValue ());
										map.put ("type" , "gs");
										map.put ("id" , gsp.getId ());
										goods_property.add (map);
									}
									mv.addObject ("goods_property" , goods_property);
								}
							}
							else
							{
								// 跳转到搜索规格列表页
								mv = new JModelAndView ("search_goodsSpces_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
								mv.addObject ("gbs" , searchGoodsSpecVo.getListGoodsBrandVo ());
								mv.addObject ("gcs" , searchGoodsSpecVo.getListGoodsClassVo ());
								mv.addObject ("objs" , searchGoodsSpecVo.getListGoodsVo ());
								// 分页处理
								String url = CommUtil.getURL (request);
								int totalPage = (searchGoodsSpecVo.getTotalRows () + SimplePage.DEF_COUNT - 1) / SimplePage.DEF_COUNT;
								mv.addObject ("totalPage" , totalPage);
								mv.addObject ("currentPage" , curSearchPage);
								mv.addObject ("gotoPageHTML" , CommUtil.showPageFormHtml (curSearchPage , totalPage));
								// 已选择
								Map <String, Object> map = null;
								if (StringUtils.isNotEmpty (brandId))
								{
									mv.addObject ("brandId" , brandId);
									GoodsBrand brand = this.goodsBrandService.getByKey (CommUtil.null2Long (brandId));
									map = new HashMap <String, Object> ();
									map.put ("name" , "品牌");
									map.put ("value" , brand.getName ());
									map.put ("type" , "brand");
									map.put ("id" , brand.getId ());
									goods_property.add (map);
								}
								if (StringUtils.isNotEmpty (gcId))
								{
									mv.addObject ("gcId" , gcId);
									GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (gcId));
									map = new HashMap <String, Object> ();
									map.put ("name" , "分类");
									map.put ("value" , gc.getClassname ());
									map.put ("type" , "gc");
									map.put ("id" , gc.getId ());
									goods_property.add (map);
								}
								mv.addObject ("goods_property" , goods_property);
							}
						}
						else
						{
							// 搜索店铺列表页
							mv = new JModelAndView ("search_shop_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
							StoreExample storeExample = new StoreExample ();
							storeExample.clear ();
							if ((orderBy != null) && (!orderBy.equals ("")))
							{
								if (orderBy.equals ("addTime"))
									orderType = "asc";
								else
								{
									orderType = "desc";
								}
								storeExample.setOrderByClause (orderBy + " " + orderType);
								mv.addObject ("orderBy" , orderBy);
								mv.addObject ("orderType" , orderType);
							}
							else
							{
								storeExample.setOrderByClause ("addTime asc");
							}
							storeExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
							StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
							if ((keyword != null) && (!keyword.equals ("")))
							{
								storeCriteria.andStoreNameLike ("%" + keyword + "%");
								mv.addObject ("keyword" , keyword);
							}
							if ((sc_id != null) && (!sc_id.equals ("")))
							{
								StoreClass storeclass = this.storeClassService.getByKey (CommUtil.null2Long (sc_id));
								List <Long> ids = getStoreClassChildIds (storeclass);
								storeCriteria.andScIdIn (ids);
								mv.addObject ("sc_id" , sc_id);
							}
							if ((storeGrade_id != null) && (!storeGrade_id.equals ("")))
							{
								storeCriteria.andGradeIdEqualTo (CommUtil.null2Long (storeGrade_id));
								mv.addObject ("storeGrade_id" , storeGrade_id);
							}
							List <Long> areaids = new ArrayList <Long> ();
							if (area_id != null && !area_id.equals (""))
							{
								areaids.add (CommUtil.null2Long (area_id));
								AreaExample areaExample = new AreaExample ();
								areaExample.clear ();
								areaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (area_id));
								List <Area> areaList = this.areaService.getObjectList (areaExample);
								for (Area area : areaList)
								{
									areaids.add (area.getId ());
									areaExample.clear ();
									areaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (area.getId ()));
									List <Area> arealist = this.areaService.getObjectList (areaExample);
									for (Area area2 : arealist)
									{
										areaids.add (area2.getId ());
									}
								}
								storeCriteria.andAreaIdIn (areaids);
							}
							if (area_name != null && !area_name.equals (""))
							{
								AreaExample areaExample = new AreaExample ();
								areaExample.clear ();
								areaExample.createCriteria ().andAreanameLike ("%" + area_name + "%");
								List <Area> areaList = this.areaService.getObjectList (areaExample);
								for (Area area : areaList)
								{
									areaids.add (area.getId ());
								}
								storeCriteria.andAreaIdIn (areaids);
							}
							if ((storepoint != null) && (!storepoint.equals ("")))
							{
								if (CommUtil.null2Double (storepoint) > 0)
								{
									List <Long> pointIds = new ArrayList <Long> ();
									StorePointExample storePointExample = new StorePointExample ();
									storePointExample.clear ();
									storePointExample.createCriteria ().andStoreEvaluate1GreaterThanOrEqualTo (new BigDecimal (storepoint));
									List <StorePoint> sps = storePointService.getObjectList (storePointExample);
									if (null!=sps && sps.size () > 0)
									{
										for (StorePoint storePoint : sps)
										{
											pointIds.add (storePoint.getId ());
										}
										storeCriteria.andPointIdIn (pointIds);
									}
								}
								mv.addObject ("storepoint" , storepoint);
							}
							storeCriteria.andStoreStatusEqualTo (Integer.valueOf (2));
							storeExample.setPageSize (Integer.valueOf (16));
							Pagination pList = this.storeService.getObjectListWithPage (storeExample);
							List <StoreWithBLOBs> storeList = (List <StoreWithBLOBs>) pList.getList ();
							GoodsExample goodsExample = new GoodsExample ();
							for (StoreWithBLOBs s : storeList)
							{
								goodsExample.clear ();
								goodsExample.createCriteria ().andGoodsStoreIdEqualTo (s.getId ());
								List <GoodsWithBLOBs> goodsList = goodsService.getObjectList (goodsExample);
								s.setGoodsList (goodsList);
							}
							String url = CommUtil.getURL (request);
							CommUtil.addIPageList2ModelAndView (url + "/search.htm" , "" , "" , pList , mv);
							StoreClassExample storeClassExample = new StoreClassExample ();		// 店铺类型
							storeClassExample.clear ();
							storeClassExample.setOrderByClause ("sequence asc");
							storeClassExample.createCriteria ().andParentIdIsNull ();
							List <StoreClass> scs = storeClassService.getObjectList (storeClassExample);
							mv.addObject ("storeViewTools" , this.storeViewTools);
							mv.addObject ("scs" , scs);
							StoreGradeExample sgExample = new StoreGradeExample ();		// 店铺等级
							sgExample.clear ();
							sgExample.setOrderByClause ("sequence asc");
							List <StoreGrade> storeGrades = storeGradeService.getObjectList (sgExample);
							mv.addObject ("storeGrades" , storeGrades);
							AreaExample areaExample = new AreaExample ();				// 所在地区
							areaExample.clear ();
							storeClassExample.setOrderByClause ("sequence asc");
							areaExample.createCriteria ().andParentIdIsNull ();
							List <Area> areas = areaService.getObjectList (areaExample);
							mv.addObject ("areas" , areas);
						}
					}
					else
					{
						// 跳转到商品品牌搜索结果页
						mv = new JModelAndView ("search_goodsBrand_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("gbs" , searchGoodsBrandVo.getGoodsBrandVo ());
						mv.addObject ("spces" , searchGoodsBrandVo.getListSpecs ());
						mv.addObject ("objs" , searchGoodsBrandVo.getListSearchGoodsVo ());
						// 分页处理
						String url = CommUtil.getURL (request);
						int totalPage = (searchGoodsBrandVo.getTotalRows () + SimplePage.DEF_COUNT - 1) / SimplePage.DEF_COUNT;
						mv.addObject ("totalPage" , totalPage);
						mv.addObject ("currentPage" , curSearchPage);
						mv.addObject ("gotoPageHTML" , CommUtil.showPageFormHtml (curSearchPage , totalPage));
						Map <String, Object> map = null;
						if (StringUtils.isNotEmpty (brandSpceId))
						{
							mv.addObject ("brandSpceId" , brandSpceId);
							GoodsSpecProperty gsp = goodsSpecPropertyService.getByKey (CommUtil.null2Long (brandSpceId));
							map = new HashMap <String, Object> ();
							map.put ("name" , gsp.getSpec ().getName ());
							map.put ("value" , gsp.getValue ());
							map.put ("type" , "gs");
							map.put ("id" , gsp.getId ());
							goods_property.add (map);
						}
						mv.addObject ("goods_property" , goods_property);
					}
				}
				else
				{
					// 跳转到商品分类搜索结果页
					mv = new JModelAndView ("search_goodsClass_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("gbs" , searchGoodsClassReturnVo.getListSearchGoodsBrandsVo ());
					mv.addObject ("spces" , searchGoodsClassReturnVo.getListSpecs ());
					mv.addObject ("objs" , searchGoodsClassReturnVo.getListSearchGoodsVo ());
					// 分页处理
					String url = CommUtil.getURL (request);
					int totalPage = (searchGoodsClassReturnVo.getTotalRows () + SimplePage.DEF_COUNT - 1) / SimplePage.DEF_COUNT;
					mv.addObject ("totalPage" , totalPage);
					mv.addObject ("currentPage" , curSearchPage);
					mv.addObject ("gotoPageHTML" , CommUtil.showPageFormHtml (curSearchPage , totalPage));
					// 已选择
					Map <String, Object> map = null;
					if (StringUtils.isNotEmpty (brandId))
					{
						mv.addObject ("brandId" , brandId);
						GoodsBrand brand = this.goodsBrandService.getByKey (CommUtil.null2Long (brandId));
						map = new HashMap <String, Object> ();
						map.put ("name" , "品牌");
						map.put ("value" , brand.getName ());
						map.put ("type" , "brand");
						map.put ("id" , brand.getId ());
						goods_property.add (map);
					}
					if (StringUtils.isNotEmpty (brandSpceId))
					{
						mv.addObject ("brandSpceId" , brandSpceId);
						GoodsSpecProperty gsp = goodsSpecPropertyService.getByKey (CommUtil.null2Long (brandSpceId));
						map = new HashMap <String, Object> ();
						map.put ("name" , gsp.getSpec ().getName ());
						map.put ("value" , gsp.getValue ());
						map.put ("type" , "gs");
						map.put ("id" , gsp.getId ());
						goods_property.add (map);
					}
					mv.addObject ("goods_property" , goods_property);
				}
			}
			else
			{
				mv = new JModelAndView ("index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			mv.addObject ("keyword" , keyword);
			mv.addObject ("orderBy" , orderBy);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("sprice" , sprice);
			mv.addObject ("eprice" , eprice);
			mv.addObject ("storeTools" , storeTools);
			return mv;
		}

	private List <Long> getStoreClassChildIds (StoreClass sc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (sc.getId ());
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			storeClassExample.createCriteria ().andParentIdEqualTo (sc.getId ());
			List <StoreClass> storeClassList = storeClassService.getObjectList (storeClassExample);
			sc.getChilds ().addAll (storeClassList);
			for (StoreClass storeclass : sc.getChilds ())
			{
				List <Long> cids = getStoreClassChildIds (storeclass);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
			}
			return ids;
		}

//	private List <List <GoodsSpecProperty>> generic_gsp (String gs_ids)
//		{
//			List <List <GoodsSpecProperty>> list = new ArrayList <List <GoodsSpecProperty>> ();
//			String [ ] gs_id_list = gs_ids.split ("\\|");
//			for (String gd_id_info : gs_id_list)
//			{
//				// String[] gs_info_list = gd_id_info.split(",");
//				GoodsSpecProperty gsp = this.goodsSpecPropertyService.getByKey (CommUtil.null2Long (gd_id_info));
//				boolean create = true;
//				for (List <GoodsSpecProperty> gsp_list : list)
//				{
//					for (GoodsSpecProperty gsp_temp : gsp_list)
//					{
//						if (gsp_temp.getSpec ().getId ().equals (gsp.getSpec ().getId ()))
//						{
//							gsp_list.add (gsp);
//							create = false;
//							break;
//						}
//					}
//				}
//				if (create)
//				{
//					List <GoodsSpecProperty> gsps = new ArrayList <GoodsSpecProperty> ();
//					gsps.add (gsp);
//					list.add (gsps);
//				}
//			}
//			return list;
//		}

	/**
	 * 店铺搜索结果页面，店铺分类搜索排序展示
	 * 
	 * @param request
	 * @param response
	 * @param type
	 * @param keyword
	 * @param goods_name
	 * @param brand_ids
	 * @param gbs_ids
	 * @param gc_ids
	 * @param gs_ids
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param store_price_begin
	 * @param store_price_end
	 * @param view_type
	 * @param sc_id
	 * @param storeGrade_id
	 * @param storepoint
	 * @param goods_view
	 * @param all_property_status
	 * @param detail_property_status
	 * @return
	 */
	@RequestMapping({ "/search_shop.htm" })
	public ModelAndView search_shop (HttpServletRequest request , HttpServletResponse response , String type , String keyword , String goods_name , String brand_ids , String gbs_ids , String gc_ids , String gs_ids , String currentPage , String orderBy , String orderType , String store_price_begin , String store_price_end , String view_type , String sc_id , String storeGrade_id , String storepoint , String goods_view , String all_property_status , String detail_property_status)
		{
			ModelAndView mv = new JModelAndView ("search_shop_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return (ModelAndView) mv;
		}
}
