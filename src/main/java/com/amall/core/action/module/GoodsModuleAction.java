package com.amall.core.action.module;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.Area;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.goods.IGoodsModuleFloorNextService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsModuleService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class GoodsModuleAction
{

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IGoodsModuleService goodsModuleService;

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@Autowired
	private IGoodsModuleFloorNextService goodsModuleFloorNextService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IAdvertService advertService;

	/* 海外购 */
	@RequestMapping({ "/over_purchases.htm" })
	public ModelAndView over_purchases (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("over_purchases.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// bannner
			banner (mv , "oversea");
			// 查询所有海外购楼层开始,查询改楼层商品 只显示8个
			Integer id = 3;// 海外购模块id为3
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.setOrderByClause ("sequence");
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
			GoodsExample ge = new GoodsExample ();
			List <GoodsWithBLOBs> goodsList = null;
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				ge.clear ();
				ge.setOrderByClause ("addTime desc limit 0,8");
				ge.createCriteria ().andModuleIdEqualTo (goodsModuleFloor.getId ()).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				goodsList = goodsService.getObjectList (ge);
				goodsModuleFloor.setGoodsList (goodsList);
			}
			mv.addObject ("floorList" , floorList);
			// 查询所有海外购楼层结束
			return mv;
		}

	private void banner (ModelAndView mv , String apMark)
		{
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
			advertPositionCriteria.andApMarkEqualTo (apMark);// 首页位置一的广告位
			advertPositionExample.setOrderByClause ("addTime asc");
			List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
			if (advertPositions != null && advertPositions.size () != 0)
			{
				AdvertPositionWithBLOBs advertPosition = advertPositions.get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (advertPosition.getId ());
				// 审核通过的
				advertCriteria.andAdStatusEqualTo (Globals.NUBER_ONE);
				advertExample.setOrderByClause ("ad_slide_sequence asc");
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				if (adverts != null && adverts.size () != 0)
				{
					if (adverts.size () > 8)// 如果广告图片超过了8张，则只显示8张
					{
						List <Advert> adverts2 = new ArrayList <Advert> ();
						for (int i = 0 ; i < 8 ; i++)
						{
							Advert advert = adverts.get (i);
							adverts2.add (advert);
						}
						advertPosition.getAdvs ().addAll (adverts2);
					}
					else
					{// 广告图片少于8张
						advertPosition.getAdvs ().addAll (adverts);
					}
					mv.addObject ("obj" , advertPosition);
				}
			}
		}

	/* 海外购 */
	@RequestMapping({ "/over_shopping.htm" })
	public ModelAndView over_shopping (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("over_shopping.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 海外购 */
	@RequestMapping({ "/over_purchases_more.htm" })
	public ModelAndView over_shopping_more (HttpServletRequest request , HttpServletResponse response , String floorId , String currentPage , String orderBy , String orderType , String store_price_begin , String store_price_end)
		{
			ModelAndView mv = new JModelAndView ("over_purchases_more.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "oversea");
			GoodsModuleFloor floor = goodsModuleFloorService.getByKey (Long.valueOf (floorId));// 获得该楼层信息
			GoodsExample ge = new GoodsExample ();
			if (orderBy == null || orderBy.equals (""))
			{
				ge.setOrderByClause ("goods_average desc");	// 默认综合排序
			}
			else
			{
				ge.setOrderByClause (orderBy + " " + orderType);
			}
			ge.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			ge.createCriteria ().andModuleIdEqualTo (CommUtil.null2Int (floorId)).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			ge.setPageSize (8);
			GoodsExample.Criteria criteria = ge.createCriteria ();
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				criteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				criteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("floor" , floor);
			mv.addObject ("floorId" , floorId);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("orderBy" , orderBy);
			return mv;
		}

	/* 土特产 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/specialty.htm" })
	public ModelAndView specialty (HttpServletRequest request , HttpServletResponse response , String store_price_begin , String store_price_end , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("specialty.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Integer id = 1; // 土特产的id值为1
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			floorExample.setOrderByClause ("id");
			floorExample.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			// banner
			banner (mv , "specialty");
			// 商品展示&生活的橱窗
			GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
			GoodsExample ge = new GoodsExample ();
			List <GoodsWithBLOBs> goodsList = null; // 存放该特区的所以商品
			List <GoodsWithBLOBs> goodsList3 = new ArrayList <GoodsWithBLOBs> ();// 存储土特产所有商品
			List <Area> areas = null;// 存放省级区域
			List <Integer> nextId = null;// 该区域 省级id集合
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				gmfne.clear ();
				gmfne.createCriteria ().andFlooridEqualTo (goodsModuleFloor.getId ());
				List <GoodsModuleFloorNext> nextList = goodsModuleFloorNextService.getObjectList (gmfne);
				goodsList = new ArrayList <GoodsWithBLOBs> ();
				areas = new ArrayList <Area> ();
				nextId = new ArrayList <Integer> ();
				for (GoodsModuleFloorNext goodsModuleFloorNext : nextList)
				{
					nextId.add (goodsModuleFloorNext.getId ());
					Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
					areas.add (area);
				}
				ge.clear ();
				if (orderBy == null || orderBy.equals (""))
				{
					ge.setOrderByClause ("goods_average desc");	// 默认综合排序
				}
				else
				{
					ge.setOrderByClause (orderBy + " " + orderType);
				}
				ge.setPageNo (1);
				ge.setPageSize (8);
				GoodsExample.Criteria criteria = ge.createCriteria ();
				criteria.andModuleIdIn (nextId).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				if ((store_price_begin != null) && (!store_price_begin.equals ("")))
				{
					criteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
					mv.addObject ("store_price_begin" , store_price_begin);
				}
				if ((store_price_end != null) && (!store_price_end.equals ("")))
				{
					criteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
					mv.addObject ("store_price_end" , store_price_end);
				}
				goodsList = (List <GoodsWithBLOBs>) goodsService.getObjectListWithPage (ge).getList ();
				goodsList3.addAll (goodsList);
				goodsModuleFloor.setGoodsList (goodsList);
				goodsModuleFloor.setAreas (areas);
			}
			List <GoodsWithBLOBs> goodsList4 = new ArrayList <GoodsWithBLOBs> ();
			if (goodsList3.size () > 8)
			{
				for (int i = 0 ; i < 8 ; i++)
				{
					goodsList4.add (goodsList3.get (i));
				}
				mv.addObject ("gds" , goodsList4);
			}
			else
			{
				mv.addObject ("gds" , goodsList3);
			}
			mv.addObject ("floorList" , floorList);
			return mv;
		}

	/* 土特产分区 */
	@RequestMapping({ "/specialty_area.htm" })
	public ModelAndView specialty_area (HttpServletRequest request , HttpServletResponse response , String floorId , String currentPage , String store_price_begin , String store_price_end , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("specialty_area.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// banner
			banner (mv , "specialty");
			GoodsModuleFloor floor = goodsModuleFloorService.getByKey (Long.parseLong (floorId));// 获得该楼层信息
			GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
			gmfne.clear ();
			gmfne.createCriteria ().andFlooridEqualTo (Integer.parseInt (floorId));
			List <GoodsModuleFloorNext> nextList = goodsModuleFloorNextService.getObjectList (gmfne);
			List <Area> areas = new ArrayList <Area> ();// 存放省级区域
			List <Integer> nextId = new ArrayList <Integer> ();// 该区域 省级id集合
			for (GoodsModuleFloorNext goodsModuleFloorNext : nextList)
			{
				nextId.add (goodsModuleFloorNext.getId ());
				Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
				areas.add (area);
			}
			floor.setAreas (areas);
			GoodsExample ge = new GoodsExample ();
			ge.clear ();
			if (orderBy == null || orderBy.equals (""))
			{
				ge.setOrderByClause ("goods_average desc");	// 默认综合排序
			}
			else
			{
				ge.setOrderByClause (orderBy + " " + orderType);
			}
			if (currentPage == null)
			{
				ge.setPageNo (1);
			}
			else
			{
				ge.setPageNo (Integer.parseInt (currentPage));
			}
			ge.setPageSize (8);
			GoodsExample.Criteria criteria = ge.createCriteria ();
			criteria.andModuleIdIn (nextId).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				criteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				criteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			Integer id = 1; // 土特产的id值为1
			floorExample.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			mv.addObject ("floor" , floor);
			mv.addObject ("floorList" , floorList);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("orderBy" , orderBy);
			return mv;
		}

	/* 省份特产 */
	@RequestMapping({ "/specialty_province.htm" })
	public ModelAndView specialty_province (HttpServletRequest request , HttpServletResponse response , String areaId , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("specialty_province.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 获取土特产所以省份信息
			Integer id = 1; // 土特产的id值为1
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			floorExample.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
			List <Area> areas = null;// 存放省级区域
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				gmfne.clear ();
				gmfne.createCriteria ().andFlooridEqualTo (goodsModuleFloor.getId ());
				List <GoodsModuleFloorNext> nextList = goodsModuleFloorNextService.getObjectList (gmfne);
				areas = new ArrayList <Area> ();
				for (GoodsModuleFloorNext goodsModuleFloorNext : nextList)
				{
					Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
					areas.add (area);
				}
				goodsModuleFloor.setAreas (areas);
			}
			// 获取商品信息
			gmfne.clear ();
			gmfne.createCriteria ().andAreaidEqualTo (Integer.parseInt (areaId));
			Integer nextId = goodsModuleFloorNextService.getObjectList (gmfne).get (0).getId ();
			GoodsExample ge = new GoodsExample ();
			ge.clear ();
			ge.setOrderByClause ("addTime desc");
			ge.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			ge.createCriteria ().andModuleIdEqualTo (nextId).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			ge.setPageSize (8);
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("areaId" , areaId);
			mv.addObject ("floorList" , floorList);
			return mv;
		}

	/* 新奇特 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/amall_xqt.htm" })
	public ModelAndView amall_xqt (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("amall_xqt.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			banner (mv , "xqt");
			Integer id = 2;// 新奇特模块id为2
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.clear ();
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
			GoodsExample ge = new GoodsExample ();
			List <GoodsWithBLOBs> goodsList = null;
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				ge.clear ();
				ge.createCriteria ().andModuleIdEqualTo (goodsModuleFloor.getId ()).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
				ge.setOrderByClause ("goods_average desc");
				ge.setPageNo (1);
				ge.setPageSize (12);
				goodsList = (List <GoodsWithBLOBs>) goodsService.getObjectListWithPage (ge).getList ();
				goodsModuleFloor.setGoodsList (goodsList);
			}
			mv.addObject ("floorList" , floorList);
			return mv;
		}

	/* 新奇特列表 */
	@RequestMapping({ "/xqt_list.htm" })
	public ModelAndView xqt_list (HttpServletRequest request , HttpServletResponse response , String floorId , String currentPage , String store_price_begin , String store_price_end , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("xqt_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 获取所有楼层名称
			Integer id = 2;// 新奇特模块id为2
			GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
			gmfe.clear ();
			gmfe.createCriteria ().andModuleIdEqualTo (id);
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
			GoodsExample ge = new GoodsExample ();
			ge.clear ();
			if (orderBy == null || orderBy.equals (""))
			{
				ge.setOrderByClause ("goods_average desc");	// 默认综合排序
			}
			/*
			 * else if(orderBy.equals(orderBy)||orderType.equals (orderType))
			 * {
			 * ge.setOrderByClause("goods_average desc"); //默认综合排序
			 * }
			 */
			else
			{
				ge.setOrderByClause (orderBy + " " + orderType);
			}
			ge.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			ge.setPageSize (8);
			GoodsExample.Criteria goodsCriteria = ge.createCriteria ();
			goodsCriteria.andModuleIdEqualTo (Integer.parseInt (floorId)).andGoodsStatusEqualTo (0).andDeletestatusEqualTo (false);
			if ((store_price_begin != null) && (!store_price_begin.equals ("")))
			{
				goodsCriteria.andGoodsPriceGreaterThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_begin)));
				mv.addObject ("store_price_begin" , store_price_begin);
			}
			if ((store_price_end != null) && (!store_price_end.equals ("")))
			{
				goodsCriteria.andGoodsPriceLessThanOrEqualTo (BigDecimal.valueOf (CommUtil.null2Double (store_price_end)));
				mv.addObject ("store_price_end" , store_price_end);
			}
			Pagination pList = goodsService.getObjectListWithPage (ge);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("floorId" , floorId);
			mv.addObject ("floorList" , floorList);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("orderBy" , orderBy);
			return mv;
		}

	/* 海外购更多列表 */
	@RequestMapping({ "over_purchases_more.htm" })
	public ModelAndView over_purchases_more (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("over_purchases_more.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
