package com.amall.core.action.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.service.IGoodsClass2SpecService;
import com.amall.core.service.goods.IGoodsBrandCategoryService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class BrandViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsBrandCategoryService goodsBrandCategorySerivce;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IGoodsSpecService goodsSpecService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	private IGoodsClass2SpecService goodsClass2SpecService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@RequestMapping({ "/brand.htm" })
	public ModelAndView brand (HttpServletRequest request , HttpServletResponse response , String gbc_id)
		{
			ModelAndView mv = new JModelAndView ("brand.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();			// 查询推荐品牌
			goodsBrandExample.clear ();
			goodsBrandExample.setOrderByClause ("sequence asc");
			goodsBrandExample.createCriteria ().andRecommendEqualTo (Boolean.valueOf (true)).andAuditEqualTo (1);
			List <GoodsBrand> gbs = goodsBrandService.getObjectList (goodsBrandExample);
			/*
			 * List<GoodsBrand> gbs1 = new ArrayList<GoodsBrand>();
			 * if(gbs.size()<=10){
			 * for (int i=0;i<10 ;i++) {
			 * gbs1.add(gbs.get(i));
			 * }
			 * }
			 */
			// mv.addObject("gbcs", gbcs);
			mv.addObject ("gbs" , gbs);
			List <GoodsBrand> brands = new ArrayList <GoodsBrand> ();
			if ((gbc_id != null) && (!gbc_id.equals ("")))
			{
				mv.addObject ("gbc_id" , gbc_id);
				/*
				 * params.clear();
				 * params.put("gbc_id", CommUtil.null2Long(gbc_id));
				 * params.put("audit", Integer.valueOf(1));
				 * brands = this.goodsBrandService
				 * .query(
				 * "select obj from GoodsBrand obj where obj.category.id=:gbc_id and obj.audit=:audit order by obj.sequence asc"
				 * ,
				 * params, -1, -1);
				 */
				goodsBrandExample.clear ();
				goodsBrandExample.setOrderByClause ("sequence asc");
				goodsBrandExample.createCriteria ().andAuditEqualTo (1);
				brands = this.goodsBrandService.getObjectList (goodsBrandExample);
			}
			else
			{
				goodsBrandExample.clear ();
				goodsBrandExample.setOrderByClause ("sequence asc");
				goodsBrandExample.createCriteria ().andAuditEqualTo (1);
				brands = this.goodsBrandService.getObjectList (goodsBrandExample);
			}
			List <Map <String, Object >> all_list = new ArrayList <Map <String, Object>> ();
			String list_word = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
			String [ ] words = list_word.split (",");
			for (String word : words)
			{
				Map <String, Object> brand_map = new HashMap <String, Object> ();
				List <GoodsBrand> brand_list = new ArrayList <GoodsBrand> ();
				for (GoodsBrand gb : brands)
				{
					if ((CommUtil.null2String (gb.getFirstWord ()).equals ("")) || (!word.equals (gb.getFirstWord ().toUpperCase ())))
						continue;
					brand_list.add (gb);
				}
				brand_map.put ("brand_list" , brand_list);
				brand_map.put ("word" , word);
				all_list.add (brand_map);
			}
			mv.addObject ("all_list" , all_list);
			return mv;
		}

	@SuppressWarnings({ "unchecked" , "rawtypes" })
	@RequestMapping({ "/brand_goods.htm" })
	public ModelAndView brand_view (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String orderBy , String orderType , String store_price_begin , String store_price_end , String gc_ids , String gs_ids , String op , String goods_name , String goods_view , String all_property_status , String detail_property_status)
		{
			ModelAndView mv = new JModelAndView ("brand_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsBrand gb = this.goodsBrandService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("gb" , gb);
			if ((orderBy == null) || (orderBy.equals ("")))
			{
				orderBy = "addTime";
			}
			if ((op != null) && (!op.equals ("")))
			{
				mv.addObject ("op" , op);
			}
			String orderBy1 = orderBy;
			// GoodsQueryObject gqo = new GoodsQueryObject(currentPage, mv, orderBy,
			// orderType);
			// 根据品牌查分类类型
			GoodsType2BrandExample gt2bExample = new GoodsType2BrandExample ();
			gt2bExample.clear ();
			gt2bExample.createCriteria ().andBrandIdEqualTo (gb.getId ());
			List <GoodsType2Brand> gt2bs = goodsType2BrandService.getObjectList (gt2bExample);
			List <GoodsClassWithBLOBs> gcs = new ArrayList <GoodsClassWithBLOBs> ();
			for (GoodsType2Brand goodsType2Brand : gt2bs)
			{
				GoodsClassWithBLOBs goodsClass = goodsClassService.getByKey (goodsType2Brand.getTypeId ());
				if (goodsClass != null)
				{
					gcs.add (goodsClass);
				}
			}
			mv.addObject ("gcs" , gcs);
			// 通过分类查询规格属性
			GoodsClass2SpecExample gc2sExample = new GoodsClass2SpecExample ();
			GoodsSpecPropertyExample gspExample = new GoodsSpecPropertyExample ();
			if (gcs != null && gcs.size () > 0)
			{
				for (GoodsClassWithBLOBs gc : gcs)
				{
					gc2sExample.clear ();
					gc2sExample.createCriteria ().andClassIdEqualTo (gc.getId ());
					List <GoodsClass2Spec> gc2ses = goodsClass2SpecService.getObjectList (gc2sExample);
					List <GoodsSpecification> gss = new ArrayList <GoodsSpecification> ();
					for (GoodsClass2Spec goodsClass2Spec : gc2ses)
					{
						GoodsSpecification gs = goodsSpecificationService.getByKey (goodsClass2Spec.getSpecificationId ());
						gspExample.clear ();
						gspExample.createCriteria ().andSpecIdEqualTo (goodsClass2Spec.getSpecificationId ());
						List <GoodsSpecProperty> gsps = goodsSpecPropertyService.getObjectList (gspExample);
						gs.setProperties (gsps);
						gss.add (gs);
					}
					mv.addObject ("gss" , gss);
				}
			}
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsCriteria.andGoodsBrandIdEqualTo (gb.getId ()).andGoodsStatusEqualTo (Integer.valueOf (0));
			goodsExample.setPageSize (Integer.valueOf (20));
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				goodsCriteria.andStorePriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				goodsCriteria.andStorePriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
				mv.addObject ("goods_name" , goods_name);
			}
			// Pagination cs = goodsService.getObjectListWithPage(goodsExample);;
			// 判断 商品所属的店铺是否处于正常状态
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andStoreStatusEqualTo (Integer.valueOf (2));
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			List <Long> storeIds = new ArrayList <Long> ();
			for (StoreWithBLOBs storeWithBLOBs : stores)
			{
				storeIds.add (storeWithBLOBs.getId ());
			}
			goodsCriteria.andGoodsStoreIdIn (storeIds);
			List goods_property = new ArrayList ();
			if (!CommUtil.null2String (gc_ids).equals (""))
			{
				String [ ] gc_id_list = gc_ids.substring (1).split ("\\|");
				if (gc_id_list.length == 1)
				{
					String gc_id = gc_id_list[0];
					String [ ] gc_info_list = gc_id.split (",");
					goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (gc_info_list[0]));
					Map map = new HashMap ();
					GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (gc_info_list[0]));
					map.put ("name" , "分类");
					map.put ("value" , gc.getClassname ());
					map.put ("type" , "gc");
					map.put ("id" , gc.getId ());
					goods_property.add (map);
				}
				else
				{
					for (int i = 0 ; i < gc_id_list.length ; i++)
					{
						String gc_id = gc_id_list[i];
						if (i == 0)
						{
							String [ ] gc_info_list = gc_id.split (",");
							goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (gc_info_list[0]));
							Map map = new HashMap ();
							GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (gc_info_list[0]));
							map.put ("name" , "分类");
							map.put ("value" , gc.getClassname ());
							map.put ("type" , "gc");
							map.put ("id" , gc.getId ());
							goods_property.add (map);
						}
						else if (i == gc_id_list.length - 1)
						{
							String [ ] brand_info_list = gc_id.split (",");
							goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
							Map map = new HashMap ();
							GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (brand_info_list[0]));
							map.put ("name" , "分类");
							map.put ("value" , gc.getClassname ());
							map.put ("type" , "gc");
							map.put ("id" , gc.getId ());
							goods_property.add (map);
						}
						else
						{
							String [ ] brand_info_list = gc_id.split (",");
							goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (brand_info_list[0]));
							Map map = new HashMap ();
							GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (CommUtil.null2Long (brand_info_list[0]));
							map.put ("name" , "分类");
							map.put ("value" , gc.getClassname ());
							map.put ("type" , "gc");
							map.put ("id" , gc.getId ());
							goods_property.add (map);
						}
					}
				}
				mv.addObject ("gc_ids" , gc_ids);
			}
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			/* 如果有筛选条件，就进行筛选 */
			List <GoodsWithBLOBs> goods = (List <GoodsWithBLOBs>) pList.getList ();
			if (gs_ids != null && !gs_ids.equals (""))
			{
				List <GoodsWithBLOBs> newGoods = this.goodsViewTools.searchGoodsOfSpec (gs_ids , goods);
				pList.setList (newGoods);
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			if (!CommUtil.null2String (gs_ids).equals (""))
			{
				List gsp_lists = generic_gsp (gs_ids);
				for (int j = 0 ; j < gsp_lists.size () ; j++)
				{
					List gsp_list = (List) gsp_lists.get (j);
					if (gsp_list.size () == 1)
					{
						GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (0);
						// 商品与规格 关系
						/*
						 * gqo.addQuery("gsp" + j, gsp, "obj.goods_specs",
						 * "member of", "and");
						 */
						Map map = new HashMap ();
						map.put ("name" , gsp.getSpec ().getName ());
						map.put ("value" , gsp.getValue ());
						map.put ("type" , "gs");
						map.put ("id" , gsp.getId ());
						goods_property.add (map);
					}
					else
					{
						for (int i = 0 ; i < gsp_list.size () ; i++)
						{
							if (i == 0)
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								//  商品与规格 关系
								/*
								 * gqo.addQuery("gsp" + j + i, gsp, "obj.goods_specs",
								 * "member of", "and(");
								 */
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
							else if (i == gsp_list.size () - 1)
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								//  商品与规格 关系
								/*
								 * gqo.addQuery("gsp" + j + i, gsp,
								 * "obj.goods_specs)", "member of", "or");
								 */
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
							else
							{
								GoodsSpecProperty gsp = (GoodsSpecProperty) gsp_list.get (i);
								// 商品与规格 关系
								/*
								 * gqo.addQuery("gsp" + j + i, gsp, "obj.goods_specs",
								 * "member of", "or");
								 */
								Map map = new HashMap ();
								map.put ("name" , gsp.getSpec ().getName ());
								map.put ("value" , gsp.getValue ());
								map.put ("type" , "gs");
								map.put ("id" , gsp.getId ());
								goods_property.add (map);
							}
						}
					}
				}
				mv.addObject ("gs_ids" , gs_ids);
			}
			mv.addObject ("orderBy" , orderBy1);
			mv.addObject ("user_viewed_goods" , request.getSession (false).getAttribute ("user_viewed_goods"));
			mv.addObject ("goods_property" , goods_property);
			if (CommUtil.null2String (goods_view).equals ("list"))
				goods_view = "list";
			else
			{
				goods_view = "thumb";
			}
			if ((detail_property_status != null) && (!detail_property_status.equals ("")))
			{
				mv.addObject ("detail_property_status" , detail_property_status);
				String [ ] temp_str = detail_property_status.split (",");
				Map pro_map = new HashMap ();
				List pro_list = new ArrayList ();
				for (String property_status : temp_str)
				{
					if ((property_status != null) && (!property_status.equals ("")))
					{
						String [ ] mark = property_status.split ("_");
						pro_map.put (mark[0] , mark[1]);
						pro_list.add (mark[0]);
					}
				}
				mv.addObject ("pro_list" , pro_list);
				mv.addObject ("pro_map" , pro_map);
			}
			mv.addObject ("goods_view" , goods_view);
			mv.addObject ("all_property_status" , all_property_status);
			return mv;
		}

	private List <List <GoodsSpecProperty>> generic_gsp (String gs_ids)
		{
			List <List <GoodsSpecProperty>> list = new ArrayList <List <GoodsSpecProperty>> ();
			String [ ] gs_id_list = gs_ids.substring (1).split ("\\|");
			for (String gd_id_info : gs_id_list)
			{
				// String[] gs_info_list = gd_id_info.split(",");
				GoodsSpecProperty gsp = this.goodsSpecPropertyService.getByKey (CommUtil.null2Long (gd_id_info));
				boolean create = true;
				for (List <GoodsSpecProperty> gsp_list : list)
				{
					for (GoodsSpecProperty gsp_temp : gsp_list)
					{
						if (gsp_temp.getSpec ().getId ().equals (gsp.getSpec ().getId ()))
						{
							gsp_list.add (gsp);
							create = false;
							break;
						}
					}
				}
				if (create)
				{
					List <GoodsSpecProperty> gsps = new ArrayList <GoodsSpecProperty> ();
					gsps.add (gsp);
					list.add (gsps);
				}
			}
			return list;
		}

	@RequestMapping({ "/brand_goods_left.htm" })
	public ModelAndView brand_goods_left (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("brand_goods_left.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdIsNull ();
			List <GoodsClassWithBLOBs> goodsClassEs = this.goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("goodClasses" , goodsClassEs);
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			goodsBrandExample.createCriteria ().andRecommendEqualTo (Boolean.valueOf (true)).andAuditEqualTo (1);
			goodsBrandExample.setOrderByClause ("sequence asc");
			List <GoodsBrand> gbs = this.goodsBrandService.getObjectList (goodsBrandExample);
			mv.addObject ("gbs" , gbs);
			return mv;
		}
}
