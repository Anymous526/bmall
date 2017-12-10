package com.amall.core.action.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
//import com.amall.core.bean.GroupClass;
//import com.amall.core.bean.GroupClassExample;
import com.amall.core.bean.GroupExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.group.IGroupBrandService;
import com.amall.core.service.group.IGroupClassService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CartGoodsCountTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GroupBrandTools;
import com.amall.core.web.tools.GroupViewTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GroupViewAction
 * </p>
 * <p>
 * Description: 团购
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author 李越
 * @date 2015年6月19日上午11:16:28
 * @version 1.0
 */
@Controller
public class GroupViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGroupClassService groupClassService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private GroupViewTools groupViewTools;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGroupBrandService groupBrandService;// 分组品牌Service

	@Autowired
	private GroupBrandTools groupBrandTools;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IAccessoryService accessoryService;  // 图片管理

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private CartGoodsCountTools cartGoodsCountTools;

	/**
	 * 
	 * <p>
	 * Title: groupbuynav
	 * </p>
	 * <p>
	 * Description: nav.html
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbuynavss.htm" })
	public ModelAndView groupbuynav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupbuynavss.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("navTools" , this.navTools);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setPageSize (8);
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDisplayEqualTo (Boolean.valueOf (true));
			Pagination pList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
			for (Object oGc : pList.getList ())
			{
				GoodsClassWithBLOBs gc = (GoodsClassWithBLOBs) oGc;
				goodsClassExample.clear ();
				goodsClassExample.setPageSize (5);
				goodsClassExample.setOrderByClause ("sequence asc");
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
				Pagination gcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
				for (Object oc_gc : gcList.getList ())
				{
					GoodsClassWithBLOBs c_gc = (GoodsClassWithBLOBs) oc_gc;
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (c_gc.getId ()).andDisplayEqualTo (Boolean.valueOf (true));
					goodsClassExample.setPageSize (8);
					goodsClassExample.setOrderByClause ("sequence asc");
					Pagination cGcList = this.goodsClassService.getObjectListWithPage (goodsClassExample);
					for (Object obj : cGcList.getList ())
					{
						c_gc.getChilds ().add ((GoodsClassWithBLOBs) obj);
					}
				}
				for (Object o : gcList.getList ())
				{
					gc.getChilds ().add ((GoodsClassWithBLOBs) o);
					gc.setIconAcc (this.accessoryService.getByKey (gc.getIconAccId ()));
				}
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbuybanner
	 * </p>
	 * <p>
	 * Description: banner.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbuybanner.htm" })
	public ModelAndView groupbuybanner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupbuybanner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertCriteria1 = advertPositionExample.createCriteria ();
			advertCriteria1.andApMarkEqualTo ("groupbuy1");
			advertPositionExample.setOrderByClause ("id desc");
			if (this.advertPositionService.getObjectList (advertPositionExample) != null && this.advertPositionService.getObjectList (advertPositionExample).size () != 0)
			{
				AdvertPositionWithBLOBs obj1 = this.advertPositionService.getObjectList (advertPositionExample).get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				advertExample.setOrderByClause ("addTime desc");
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (obj1.getId ());
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				List <Advert> advs = new ArrayList <Advert> ();
				for (Advert temp_adv : adverts)
				{
					if ((temp_adv.getAdStatus () != 1) || (!temp_adv.getAdBeginTime ().before (new Date ())) || (!temp_adv.getAdEndTime ().after (new Date ())))
						continue;
					advs.add (temp_adv);
				}
				if (advs.size () < 5)
				{
					obj1.getAdvs ().addAll (advs);
				}
				else
				{
					List <Advert> advs2 = new ArrayList <Advert> ();
					for (int i = 0 ; i < 5 ; i++)
					{
						advs2.add (advs.get (i));
					}
					obj1.getAdvs ().addAll (advs2);
				}
				mv.addObject ("obj1" , obj1);// 团购位置一展示的广告位
			}
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertCriteria2 = advertPositionExample.createCriteria ();
			advertCriteria2.andApMarkEqualTo ("groupbuy2");
			advertPositionExample.setOrderByClause ("id desc");
			if (this.advertPositionService.getObjectList (advertPositionExample) != null && this.advertPositionService.getObjectList (advertPositionExample).size () != 0)
			{
				AdvertPositionWithBLOBs obj2 = this.advertPositionService.getObjectList (advertPositionExample).get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				advertExample.setOrderByClause ("addTime desc");
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (obj2.getId ());
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				List <Advert> advs = new ArrayList <Advert> ();
				for (Advert temp_adv : adverts)
				{
					if ((temp_adv.getAdStatus () != 1) || (!temp_adv.getAdBeginTime ().before (new Date ())) || (!temp_adv.getAdEndTime ().after (new Date ())))
						continue;
					advs.add (temp_adv);
				}
				if (advs.size () < 3)
				{
					obj2.getAdvs ().addAll (advs);
				}
				else
				{
					List <Advert> advs2 = new ArrayList <Advert> ();
					for (int i = 0 ; i < 3 ; i++)
					{
						advs2.add (advs.get (i));
					}
					obj2.getAdvs ().addAll (advs2);
				}
				mv.addObject ("obj2" , obj2);// 团购位置二展示的广告位
			}
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertCriteria3 = advertPositionExample.createCriteria ();
			advertCriteria3.andApMarkEqualTo ("groupbuy3");
			advertPositionExample.setOrderByClause ("id desc");
			this.advertPositionService.getObjectList (advertPositionExample);
			if (this.advertPositionService.getObjectList (advertPositionExample) != null && this.advertPositionService.getObjectList (advertPositionExample).size () != 0)
			{
				AdvertPositionWithBLOBs obj3 = this.advertPositionService.getObjectList (advertPositionExample).get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				advertExample.setOrderByClause ("addTime desc");
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (obj3.getId ());
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				List <Advert> advs = new ArrayList <Advert> ();
				for (Advert temp_adv : adverts)
				{
					if ((temp_adv.getAdStatus () != 1) || (!temp_adv.getAdBeginTime ().before (new Date ())) || (!temp_adv.getAdEndTime ().after (new Date ())))
						continue;
					advs.add (temp_adv);
				}
				if (advs.size () < 2)
				{
					obj3.getAdvs ().addAll (advs);
				}
				else
				{
					List <Advert> advs2 = new ArrayList <Advert> ();
					for (int i = 0 ; i < 2 ; i++)
					{
						advs2.add (advs.get (i));
					}
					obj3.getAdvs ().addAll (advs2);
				}
				mv.addObject ("obj3" , obj3);// 团购位置三展示的广告位
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbuybrand
	 * </p>
	 * <p>
	 * Description: brand.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbuybrand.htm" })
	public ModelAndView groupbuybrand (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupbuybrand.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * GroupClassExample groupClassExample=new GroupClassExample();
			 * groupClassExample.clear();
			 * groupClassExample.setOrderByClause("addTime desc");
			 * groupClassExample.setStartRow(0);
			 * groupClassExample.setPageSize(9);//取排序后前9个数据
			 * GroupClassExample.Criteria groupClassCriteria=groupClassExample.createCriteria();
			 * groupClassCriteria.andParentIdIsNull();
			 * List<GroupClass>
			 * groupClassList=this.groupClassService.selectByExampleWithPage(groupClassExample);
			 */
			// 查询所有团购活动
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			// 状态为正常的
			groupCriteria.andStatusEqualTo (0);
			// 结束时间大于等于当前时间
			groupCriteria.andEndtimeGreaterThanOrEqualTo (new Date ());
			groupCriteria.andIsBrandEqualTo (1);
			List <Group> list = this.groupService.getObjectList (groupExample);
			List <GroupGoods> groupGoodsList = new ArrayList <GroupGoods> ();
			List <GoodsBrand> goodsBrands = new ArrayList <GoodsBrand> ();
			List <Long> goodsBrandList = new ArrayList <Long> ();
			if (list.size () > 0)
			{
				List <Long> ids = new ArrayList <Long> ();
				for (Group group : list)
				{
					ids.add (group.getId ());
					// 从团购品牌表查询品牌ID
					GroupBrandExample groupBrandExample = new GroupBrandExample ();
					groupBrandExample.clear ();
					GroupBrandExample.Criteria groupBrandCriteria = groupBrandExample.createCriteria ();
					groupBrandCriteria.andGroupIdEqualTo (group.getId ());
					List <GroupBrand> groupBrandlist = this.groupBrandService.getObjectList (groupBrandExample);
					GroupBrand groupBrand = null;
					if (groupBrandlist.size () > 0)
					{
						groupBrand = groupBrandlist.get (0);
						if (!goodsBrandList.contains (groupBrand.getBrandId ()))
						{
							goodsBrandList.add (groupBrand.getBrandId ());
						}
					}
				}
				// 查询参加团购活动的商品信息
				GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
				groupGoodsExample.clear ();
				GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
				if (ids != null && ids.size () != 0)
				{
					groupGoodsCriteria.andGroupIdIn (ids);
				}
				// 审核通过的商品
				groupGoodsCriteria.andGgStatusEqualTo (1);
				// 获取参加团购活动的商品信息
				groupGoodsList = this.groupGoodsService.getObjectList (groupGoodsExample);
			}
			if (goodsBrandList.size () > 0)
			{
				for (Long gid : goodsBrandList)
				{
					goodsBrands.add (this.goodsBrandService.getByKey (gid));
				}
			}
			mv.addObject ("groupGoodsList" , groupGoodsList);
			mv.addObject ("grps" , goodsBrands);
			mv.addObject ("groupViewTools" , this.groupViewTools);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbuy_list
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbuy_list.htm" })
	public ModelAndView groupbuy_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String isDay , String ggName)
		{
			ModelAndView mv = new JModelAndView ("groupbuy_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 查询所有团购活动
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			// 状态为正常的(后台定时器每2分钟扫团购表,团购活动发布默认状态为1(未开启),如果定时器扫到系统时候大于活动开始时间，更改状态为0正常)
			groupCriteria.andStatusEqualTo (0);
			// 只查单品团
			groupCriteria.andIsBrandEqualTo (0);
			if (isDay == null || isDay.equals (""))
			{
				// 活动开始时间大于当前时间
				// groupCriteria.andBegintimeGreaterThanOrEqualTo(new Date());
				// 活动结束时间大于当前时间
				groupCriteria.andEndtimeGreaterThanOrEqualTo (new Date ());
			}
			else
			{
				if (isDay.equals ("-1"))// 昨天开团
				{
					Calendar calendar = Calendar.getInstance ();
					calendar.setTime (new Date ());
					calendar.add (Calendar.DATE , -1);// 取得前一天
					int year = calendar.get (Calendar.YEAR);// 得到年
					int month = calendar.get (Calendar.MONTH) + 1;// 得到月
					int day = calendar.get (Calendar.DATE);
					String date = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00";
					System.out.println ("时间是" + date);
					SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
					try
					{
						Date d = sf.parse (date);
						groupCriteria.andBegintimeGreaterThanOrEqualTo (d);
						groupCriteria.andBegintimeLessThan (new Date ());
					}
					catch (ParseException e)
					{
						e.printStackTrace ();
					}
				}
				else if (isDay.equals ("1"))// 今天开团
				{
					Calendar calendar = Calendar.getInstance ();
					calendar.setTime (new Date ());
					int year = calendar.get (Calendar.YEAR);// 得到年
					int month = calendar.get (Calendar.MONTH) + 1;// 得到月
					int day = calendar.get (Calendar.DATE);
					String date = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00";
					String date2 = "" + year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "23:59:59";
					System.out.println ("时间是" + date + ":" + date2);
					SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
					try
					{
						Date d = sf.parse (date);
						Date d2 = sf.parse (date2);
						groupCriteria.andBegintimeGreaterThanOrEqualTo (d);
						groupCriteria.andBegintimeLessThanOrEqualTo (d2);
					}
					catch (ParseException e)
					{
						e.printStackTrace ();
					}
				}
			}
			mv.addObject ("isDay" , isDay);
			List <Group> groups = this.groupService.getObjectList (groupExample);
			if (null != groups && groups.size () > 0)
			{
				GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
				groupGoodsExample.clear ();
				GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
				groupGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				groupGoodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				List <Long> ids = new ArrayList <Long> ();
				if (groups != null && groups.size () != 0)
				{
					for (Group group : groups)
					{
						ids.add (group.getId ());
					}
				}
				if (ids.size () != 0)
				{
					groupGoodsCriteria.andGroupIdIn (ids);
				}
				else
				{
					groupGoodsCriteria.andGroupIdIsNull ();
				}
				if (ggName != null && !ggName.equals (""))// 如果有搜索条件
				{
					groupGoodsCriteria.andGgNameLike ("%" + ggName.trim () + "%");
					mv.addObject ("ggName" , ggName);
				}
				// 审核状态 0 待审核 1 审核通过 -1 审核拒绝
				groupGoodsCriteria.andGgStatusEqualTo (Integer.valueOf (1));
				Pagination pList = this.groupGoodsService.getObjectListWithPage (groupGoodsExample);
				mv.addObject ("objs" , pList.getList ());
				mv.addObject ("totalPages" , pList.getTotalPage ());
				if ((orderBy == null) || (orderBy.equals ("")))
				{
					orderBy = "addTime";
				}
				if ((orderType == null) || (orderType.equals ("")))
				{
					orderType = "desc";
				}
				mv.addObject ("order_type" , CommUtil.null2String (orderBy) + "_" + CommUtil.null2String (orderType));
				String aJax_url = CommUtil.getURL (request) + "/groupbuy_list.htm";
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (aJax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
				// CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
				mv.addObject ("orderBy" , orderBy);
				mv.addObject ("orderType" , orderType);
			}
			return mv;
		}

	@RequestMapping({ "/groupbuy.htm" })
	public ModelAndView groupbuy (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupbuy.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * GroupExample groupExample=new GroupExample();
			 * groupExample.clear();
			 * GroupExample.Criteria groupCriteria=groupExample.createCriteria();
			 * groupCriteria.andBegintimeLessThanOrEqualTo(new Date());
			 * groupCriteria.andEndtimeGreaterThanOrEqualTo(new Date());
			 * List<Group> groups=this.groupService.getObjectList(groupExample);
			 * if(groups.size()>0)
			 * {
			 * GroupGoodsExample groupGoodsExample=new GroupGoodsExample();
			 * groupGoodsExample.clear();
			 * GroupGoodsExample.Criteria groupGoodsCriteria=groupGoodsExample.createCriteria();
			 * groupGoodsExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
			 * groupGoodsExample.setOrderByClause(Pagination.cst(orderBy, orderType));
			 * groupGoodsCriteria.andGroupIdEqualTo(groups.get(0).getId());
			 * groupGoodsCriteria.andGgStatusEqualTo(Integer.valueOf(1));
			 * Pagination pList=this.groupGoodsService.getObjectListWithPage(groupGoodsExample);
			 * CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
			 * if ((orderBy == null) || (orderBy.equals(""))) {
			 * orderBy = "addTime";
			 * }
			 * if ((orderType == null) || (orderType.equals(""))) {
			 * orderType = "desc";
			 * }
			 * mv.addObject("order_type", CommUtil.null2String(orderBy) + "_" +
			 * CommUtil.null2String(orderType));
			 * mv.addObject("orderBy", orderBy);
			 * mv.addObject("orderType", orderType);
			 * }
			 */
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: bulkItemNav
	 * </p>
	 * <p>
	 * Description: 团购单品导航
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param isDay
	 * @param ggName
	 * @return
	 */
	@RequestMapping({ "/bulkitemnav.htm" })
	public ModelAndView bulkItemNav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("bulkitemnav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: bulkItemBody
	 * </p>
	 * <p>
	 * Description: 团购单品主界面搜索
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param isDay
	 * @param ggName
	 * @return
	 */
	@RequestMapping({ "/bulkitembody.htm" })
	public ModelAndView bulkItemBody (HttpServletRequest request , HttpServletResponse response , String gc_id , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("bulkitembody.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 查询团购下的所有单品团活动 start
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			// 状态为正常的
			groupCriteria.andStatusEqualTo (0);
			// 活动开始时间大于当前时间
			// groupCriteria.andBegintimeGreaterThanOrEqualTo(new Date());
			// 活动结束时间大于当前时间
			groupCriteria.andEndtimeGreaterThanOrEqualTo (new Date ());
			// groupCriteria.andBegintimeGreaterThan(new Date());//在开团之前这里展示出来
			groupCriteria.andIsBrandEqualTo (0);// 单品团
			groupCriteria.andGoodsClassIdIsNotNull ();// 单品团，团购分类Id不为null
			List <Group> groups = this.groupService.getObjectList (groupExample);
			// 查询团购下的所有单品团活动 end
			// 查询平台发布单品团下所有的商品分类 start
			List <Long> groupClassList = null;
			List <GoodsClass> goodsClassList = new ArrayList <GoodsClass> ();
			if (null != groups && groups.size () > 0)
			{
				groupClassList = new ArrayList <Long> ();
				for (Group group : groups)
				{
					if (!groupClassList.contains (group.getGoodsClassId ()))
					{
						groupClassList.add (group.getGoodsClassId ());
					}
				}
			}
			if (null != groupClassList && groupClassList.size () > 0)
			{
				for (Long gid : groupClassList)
				{
					goodsClassList.add (this.goodsClassService.getByKey (gid));
				}
			}
			mv.addObject ("goodsClassList" , goodsClassList);
			// 查询平台发布单品团下所有的商品分类 end
			// 参与单品团活动的商品,包括条件查询 start
			GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
			groupGoodsExample.clear ();
			GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
			List <Long> groupIds = null;
			if (groups != null && groups.size () != 0)
			{
				groupIds = new ArrayList <Long> ();
				for (Group group : groups)
				{
					groupIds.add (group.getId ());
				}
			}
			if (null != groupIds && groupIds.size () != 0)
			{
				groupGoodsCriteria.andGroupIdIn (groupIds);
			}
			else
			{
				groupGoodsCriteria.andGroupIdIsNull ();
			}
			// 审核通过的商品
			groupGoodsCriteria.andGgStatusEqualTo (1);
			if (gc_id != null && !gc_id.equals (""))
			{
				if (gc_id.indexOf (",") == -1)// 如果gc_id不是“全部”过来的，点全部需要重新组合gc_id“，”
				{
					GoodsClass gc = this.goodsClassService.getByKey (CommUtil.null2Long (gc_id));// 得到此类商品
					List <Long> ids = new ArrayList <Long> ();
					if (gc != null)
					{
						// ids=genericIds(gc);
						ids.add (gc.getId ());
						groupGoodsCriteria.andGgGcIdIn (ids);
						// 以前做的是根据GroupGoods得到Goods。现在是去掉Goods使用GroupGoods
						/*
						 * List<GroupGoods>
						 * list=this.groupGoodsService.getObjectList(groupGoodsExample);
						 * List<Long> ggGoodsIds=new ArrayList<Long>();//团购对应的商品的Id号
						 * for(GroupGoods groupGoods:list)
						 * {
						 * ggGoodsIds.add(groupGoods.getGgGoodsId());
						 * }
						 * if(ggGoodsIds.size()!=0)
						 * {
						 * goodsCriteria.andIdIn(ggGoodsIds);
						 * }
						 */
					}
				}
				else if (gc_id.indexOf (",") != -1)// 全部过来的gc_id
				{
					String gcIdArr [ ] = gc_id.split (",");// 得到gc_id数组
					List <Long> idList = new ArrayList <Long> ();
					for (String gcId : gcIdArr)
					{
						GoodsClass gc = this.goodsClassService.getByKey (CommUtil.null2Long (gcId));
						List <Long> ids = new ArrayList <Long> ();
						// ids=genericIds(gc);
						ids.add (gc.getId ());
						idList.addAll (ids);
					}
					if (idList.size () != 0)
					{
						groupGoodsExample.clear ();
						groupGoodsCriteria = groupGoodsExample.createCriteria ();
						groupGoodsCriteria.andGgGcIdIn (idList);
						/*
						 * List<GroupGoods>
						 * list=this.groupGoodsService.getObjectList(groupGoodsExample);
						 * List<Long> ggGoodsIds=new ArrayList<Long>();//团购对应的商品的Id号
						 * for(GroupGoods groupGoods:list)
						 * {
						 * ggGoodsIds.add(groupGoods.getGgGoodsId());
						 * }
						 * if(ggGoodsIds.size()!=0)
						 * {
						 * goodsExample.clear();
						 * goodsCriteria=goodsExample.createCriteria();
						 * goodsCriteria.andIdIn(ggGoodsIds);
						 * }
						 */
					}
				}
			}
			if (orderBy != null && !orderBy.equals ("") && orderType != null && !orderType.equals (""))//
			{
				if (orderBy.indexOf (",") == -1 && orderType.indexOf (",") == -1)// 如果不是查询条件“全部”过来的
				{
					groupGoodsExample.setOrderByClause (orderBy + " " + orderType);
				}
				else if (orderBy.indexOf (",") != -1 && orderType.indexOf (",") != -1)// 点全部过来的
				{
					String orderBys [ ] = orderBy.split (",");// 得到OrderBy数组
					String orderTypes [ ] = orderType.split (",");// 得到OrderType数组
					String orderByClause = "";
					for (int i = 0 ; i < orderBys.length ; i++)
					{
						String orderBy1 = orderBys[i];
						String orderType1 = orderTypes[i];
						orderByClause = orderByClause + orderBy1 + " " + orderType1 + ",";
					}
					orderByClause = orderByClause.substring (0 , orderByClause.length () - 1);
					groupGoodsExample.setOrderByClause (orderByClause);
				}
			}
			groupGoodsExample.setPageNo (CommUtil.null2Int (currentPage));
			groupGoodsExample.setPageSize (8);
			Pagination pList = this.groupGoodsService.getObjectListWithPage (groupGoodsExample);
			// 参与单品团活动的商品 包括条件查询 end
			mv.addObject ("objs" , pList.getList ());
			mv.addObject ("totalPages" , pList.getTotalPage ());
			mv.addObject ("gc_id" , gc_id);
			mv.addObject ("orderBy" , orderBy);
			mv.addObject ("orderType" , orderType);
			mv.addObject ("currentPage" , currentPage);
			String aJax_url = CommUtil.getURL (request) + "/bulkitembody.htm";
			mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (aJax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: bulkItem
	 * </p>
	 * <p>
	 * Description:团购单品
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param isDay
	 * @param ggName
	 * @return
	 */
	@RequestMapping({ "/bulkitem.htm" })
	public ModelAndView bulkItem (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("bulkitem.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
			 * groupGoodsExample.clear ();
			 * GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
			 * GoodsExample goodsExample = new GoodsExample ();
			 * goodsExample.clear ();
			 * GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			 * if (gc_id != null && gc_id != "")
			 * {
			 * if (gc_id.indexOf (",") == -1)// 如果gc_id不是“全部”过来的，点全部需要重新组合gc_id“，”
			 * {
			 * GroupClass gc = this.groupClassService.getByKey (CommUtil.null2Long (gc_id));//
			 * 得到此类商品
			 * List <Long> ids = new ArrayList <Long> ();
			 * if (gc != null)
			 * {
			 * ids = genericIds (gc);
			 * groupGoodsCriteria.andGgGcIdIn (ids);
			 * List <GroupGoods> list = this.groupGoodsService.getObjectList (groupGoodsExample);
			 * List <Long> ggGoodsIds = new ArrayList <Long> ();// 团购对应的商品的Id号
			 * for (GroupGoods groupGoods : list)
			 * {
			 * ggGoodsIds.add (groupGoods.getGgGoodsId ());
			 * }
			 * if (ggGoodsIds.size () != 0)
			 * {
			 * goodsCriteria.andIdIn (ggGoodsIds);
			 * }
			 * }
			 * }
			 * else if (gc_id.indexOf (",") != -1)// 全部过来的gc_id
			 * {
			 * String gcIdArr [ ] = gc_id.split (",");// 得到gc_id数组
			 * List <Long> idList = new ArrayList <Long> ();
			 * for (String gcId : gcIdArr)
			 * {
			 * GroupClass gc = this.groupClassService.getByKey (CommUtil.null2Long (gcId));
			 * List <Long> ids = new ArrayList <Long> ();
			 * ids = genericIds (gc);
			 * idList.addAll (ids);
			 * }
			 * if (idList.size () != 0)
			 * {
			 * groupGoodsExample.clear ();
			 * groupGoodsCriteria = groupGoodsExample.createCriteria ();
			 * groupGoodsCriteria.andGgGcIdIn (idList);
			 * List <GroupGoods> list = this.groupGoodsService.getObjectList (groupGoodsExample);
			 * List <Long> ggGoodsIds = new ArrayList <Long> ();// 团购对应的商品的Id号
			 * for (GroupGoods groupGoods : list)
			 * {
			 * ggGoodsIds.add (groupGoods.getGgGoodsId ());
			 * }
			 * if (ggGoodsIds.size () != 0)
			 * {
			 * goodsExample.clear ();
			 * goodsCriteria = goodsExample.createCriteria ();
			 * goodsCriteria.andIdIn (ggGoodsIds);
			 * }
			 * }
			 * }
			 * }
			 * if (orderBy != null && orderBy != "" && orderType != null && orderType != "")//
			 * {
			 * if (orderBy.indexOf (",") == -1 && orderType.indexOf (",") == -1)// 如果不是查询条件“全部”过来的
			 * {
			 * goodsExample.setOrderByClause (orderBy + " " + orderType);
			 * }
			 * else if (orderBy.indexOf (",") != -1 && orderType.indexOf (",") != -1)// 点全部过来的
			 * {
			 * String orderBys [ ] = orderBy.split (",");// 得到OrderBy数组
			 * String orderTypes [ ] = orderType.split (",");// 得到OrderType数组
			 * String orderByClause = "";
			 * for (int i = 0 ; i < orderBys.length ; i++)
			 * {
			 * String orderBy1 = orderBys[i];
			 * String orderType1 = orderTypes[i];
			 * orderByClause = orderByClause + orderBy1 + " " + orderType1 + ",";
			 * }
			 * orderByClause = orderByClause.substring (0 , orderByClause.length () - 1);
			 * goodsExample.setOrderByClause (orderByClause);
			 * }
			 * }
			 * goodsExample.setPageNo (CommUtil.null2Int (currentPage));
			 * goodsExample.setPageSize (24);
			 * Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
			 * mv.addObject ("objs" , pList.getList ());
			 * mv.addObject ("totalPages" , pList.getTotalPage ());
			 * mv.addObject ("gc_id" , gc_id);
			 * mv.addObject ("orderBy" , orderBy);
			 * mv.addObject ("orderType" , orderType);
			 * mv.addObject ("currentPage" , currentPage);
			 * String aJax_url = CommUtil.getURL (request) + "/bulkitembody.html";
			 * mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (aJax_url , "" ,
			 * pList.getPageNo () , pList.getTotalPage ()));
			 */
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbrandnav
	 * </p>
	 * <p>
	 * Description: 品牌团导航页面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbrandnav.htm" })
	public ModelAndView groupbrandnav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupbrand_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbrandbody
	 * </p>
	 * <p>
	 * Description: 品牌团body页面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbrandbody.htm" })
	public ModelAndView groupbrandbody (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("groupbrand_body.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * //商品品牌 start
			 * GoodsBrandExample goodsBrandExample=new GoodsBrandExample();
			 * goodsBrandExample.clear();
			 * GoodsBrandExample.Criteria goodsBrandCriteria=goodsBrandExample.createCriteria();
			 * String gb_id=CommUtil.null2String(request.getAttribute("gb_id"));//gb_id可不传
			 * if(gb_id!=null&&gb_id!="")
			 * {
			 * goodsBrandCriteria.andIdEqualTo(CommUtil.null2Long(gb_id));
			 * }
			 * //是否推荐(被推荐的商品品牌才会参加团购品牌的活动)
			 * goodsBrandCriteria.andRecommendEqualTo(Boolean.valueOf(true));
			 * goodsBrandCriteria.andAuditEqualTo(Boolean.valueOf(true));
			 * goodsBrandExample.setOrderByClause("sequence asc");
			 * List<GoodsBrand>
			 * goodsBrands=this.goodsBrandService.getObjectList(goodsBrandExample);//品牌
			 * //商品品牌 end
			 * List<Long> brandIds=new ArrayList<Long>();
			 * for(GoodsBrand goodsBrand:goodsBrands)
			 * {
			 * brandIds.add(goodsBrand.getId());
			 * }
			 * if(brandIds.size()!=0)
			 * {
			 * //团购品牌 start
			 * GroupBrandExample groupBrandExample=new GroupBrandExample();
			 * groupBrandExample.clear();
			 * GroupBrandExample.Criteria groupBrandCriteria=groupBrandExample.createCriteria();
			 * groupBrandCriteria.andBrandIdIn(brandIds);
			 * List<GroupBrand> groupBrands=this.groupBrandService.getObjectList(groupBrandExample);
			 * //团购品牌 end
			 * //获取品牌团各个品牌下,参加活动的商品
			 * List<Long> groupIds=new ArrayList<Long>();
			 * for(GroupBrand groupBrand:groupBrands)
			 * {
			 * groupIds.add(groupBrand.getGroupId());
			 * }
			 * if(groupIds.size()!=0)
			 * {
			 * GroupGoodsExample groupGoodsExample=new GroupGoodsExample();
			 * groupGoodsExample.clear();
			 * GroupGoodsExample.Criteria groupGoodsCriteria=groupGoodsExample.createCriteria();
			 * groupGoodsCriteria.andGroupIdIn(groupIds);
			 * //审核通过的
			 * groupGoodsCriteria.andGgStatusEqualTo(1);
			 * groupGoodsExample.setPageNo(CommUtil.null2Int(currentPage));
			 * groupGoodsExample.setPageSize(16);
			 * groupGoodsExample.setOrderByClause("addTime desc");
			 * Pagination pList=this.groupGoodsService.getObjectListWithPage(groupGoodsExample);
			 * mv.addObject("objs", pList.getList());
			 * mv.addObject("totalPages", pList.getTotalPage());
			 * mv.addObject("currentPage", currentPage);
			 * String aJax_url = CommUtil.getURL(request) + "/groupbrandbody.htm";
			 * mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(aJax_url, "",
			 * pList.getPageNo(),pList.getTotalPage()));
			 * mv.addObject("groupBrandTools", groupBrandTools);
			 * }
			 * }
			 */
			// 查询所有团购活动
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			// 过滤查询团购活动开始时间大于当前时间的团购活动
			// groupCriteria.andBegintimeGreaterThan(new Date());//在开团之前这里展示出来
			// 状态为正常的
			groupCriteria.andStatusEqualTo (0);
			groupCriteria.andEndtimeGreaterThanOrEqualTo (new Date ());
			groupCriteria.andIsBrandEqualTo (1);
			List <Group> list = this.groupService.getObjectList (groupExample);
			if (list.size () > 0)
			{
				List <Long> ids = new ArrayList <Long> ();
				for (Group group : list)
				{
					ids.add (group.getId ());
				}
				// 查询参加团购活动的商品信息
				GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
				groupGoodsExample.clear ();
				GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
				if (ids != null && ids.size () != 0)
				{
					groupGoodsCriteria.andGroupIdIn (ids);
				}
				// 审核通过的商品
				groupGoodsCriteria.andGgStatusEqualTo (1);
				// 获取参加团购活动的商品信息
				Pagination pList = this.groupGoodsService.getObjectListWithPage (groupGoodsExample);
				mv.addObject ("objs" , pList.getList ());
				mv.addObject ("totalPages" , pList.getTotalPage ());
				mv.addObject ("currentPage" , currentPage);
				String aJax_url = CommUtil.getURL (request) + "/groupbrandbody.htm";
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (aJax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
				mv.addObject ("groupBrandTools" , groupBrandTools);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupbrand
	 * </p>
	 * <p>
	 * Description:进入品牌团页面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupbrand.htm" })
	public ModelAndView groupbrand (HttpServletRequest request , HttpServletResponse response , String gb_id)// gb_id表示商品的品牌.gb_id可传，也可不传
		{
			ModelAndView mv = new JModelAndView ("groupbrand.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (null!=gb_id && !gb_id.equals (""))// 如果不为空，则保存到作用域
			{
				mv.addObject ("gb_id" , gb_id);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive_bodyright
	 * </p>
	 * <p>
	 * Description: 团购过度Body右侧，精品推荐
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupExcessive_bodyright.htm" })
	public ModelAndView groupExcessive_bodyright (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupExcessive_bodyright.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String goodsId = CommUtil.null2String (request.getAttribute ("goodsId"));
			if (goodsId != null)
			{
				GoodsWithBLOBs obj = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
				goodsExample.setPageSize (7);
				if (obj != null)
				{
					goodsCriteria.andGoodsStoreIdEqualTo (obj.getGoodsStoreId ());
					goodsCriteria.andIdNotEqualTo (obj.getId ());
				}
				goodsCriteria.andGoodsRecommendEqualTo (Boolean.valueOf (true));
				goodsExample.setOrderByClause ("addTime desc");
				goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf ("0"));
				List <GoodsWithBLOBs> goods_recommend_list = this.goodsService.getObjectList (goodsExample);
				List <GoodsWithBLOBs> goods_list = new ArrayList <GoodsWithBLOBs> ();
				if (goods_recommend_list.size () > 7)
				{
					goods_list = goods_recommend_list.subList (0 , 7);
				}
				else
				{
					goods_list = goods_recommend_list;
					for (GoodsWithBLOBs g : goods_list)
					{
						Accessory image = this.accessoryService.getByKey (g.getGoodsMainPhotoId ());
						g.setGoodsMainPhoto (image);
					}
				}
				mv.addObject ("goods_recommend_list" , goods_list);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive_body
	 * </p>
	 * <p>
	 * Description:团购过度Body
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupExcessive_body.htm" })
	public ModelAndView groupExcessive_body (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("groupExcessive_body.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String gg_id = CommUtil.null2String (request.getAttribute ("gg_id"));// gg_id表示传过来的团购商品的主键Id。即amall_group_goods表的主键
			if (null!=gg_id && !gg_id.equals (""))
			{
				GroupGoods groupGoods = this.groupGoodsService.getByKey (CommUtil.null2Long (gg_id));
				mv.addObject ("groupGoods" , groupGoods);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive
	 * </p>
	 * <p>
	 * Description: 团购过度页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/groupExcessive.htm" })
	public ModelAndView groupExcessive (HttpServletRequest request , HttpServletResponse response , String gg_id)// gg_id表示传过来的amall_group_goods表的主键Id
		{
			ModelAndView mv = new JModelAndView ("groupExcessive.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (null!=gg_id && !gg_id.equals (""))
			{
				mv.addObject ("gg_id" , gg_id);// gg_id是amall_group_goods的主键
				GroupGoods gg = groupGoodsService.getByKey (Long.parseLong (gg_id));
				mv.addObject ("gg" , gg);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/g_nav.htm" })
	public ModelAndView gnav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("g_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/bulkitem_nav.htm" })
	public ModelAndView bulkitemnav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("bulkitem_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/bulkitem_head.htm" })
	public ModelAndView bulkitemhead (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("bulkitem_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/* 购物车数量显示 */
			mv.addObject ("countTools" , this.cartGoodsCountTools);
			mv.addObject ("cookies" , request.getCookies ());
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: groupExcessive
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/g_head.htm" })
	public ModelAndView ghead (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("g_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: setExcessiveTime
	 * </p>
	 * <p>
	 * Description:设置团购剩余时间
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param groupGoodsId
	 * @return
	 */
	@RequestMapping({ "/setExcessiveTime.htm" })
	public void setExcessiveTime (HttpServletRequest request , HttpServletResponse response , String groupGoodsId)
		{
			String remainTime = "";
			PrintWriter out = null;
			response.setContentType ("text/plain;charset=UTF-8");
			// response.setHeader("Cache-Control", "no-cache");
			/**
			 * 如果传过来的团购商品Id不为NULL
			 */
			if (null!=groupGoodsId && !groupGoodsId.equals (""))
			{
				GroupGoods groupGoods = this.groupGoodsService.getByKey (CommUtil.null2Long (groupGoodsId));
				Long groupId = groupGoods.getGroupId ();
				Group group = this.groupService.getByKey (groupId);
				Date groupEndTime = group.getEndtime ();// 得到团购结束时间
				Date date1 = new Date ();// 得到当前时间
				remainTime = getDistanceTime (date1 , groupEndTime);
			}
			try
			{
				out = response.getWriter ();
				out.write (remainTime.toString ());
				out.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 
	 * <p>
	 * Title: getDiatanceTime
	 * </p>
	 * <p>
	 * Description: 两个时间相差距离多少天多少小时多少分多少秒
	 * </p>
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String getDistanceTime (Date date1 , Date date2)
		{
			long time1 = date1.getTime ();
			long time2 = date2.getTime ();
			long diff;
			long day = 0;
			long hour = 0;
			long min = 0;
			long sec = 0;
			if (time1 < time2)
			{
				diff = time2 - time1;
			}
			else
			{
				diff = 0;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
		}

//	private List <Long> genericIds (GroupClass gc)
//		{
//			List <Long> ids = new ArrayList <Long> ();
//			ids.add (gc.getId ());
//			GroupClassExample groupClassExample = new GroupClassExample ();
//			groupClassExample.clear ();
//			GroupClassExample.Criteria groupClassCriteria = groupClassExample.createCriteria ();
//			groupClassCriteria.andParentIdEqualTo (gc.getId ());
//			List <GroupClass> list = this.groupClassService.getObjectList (groupClassExample);
//			gc.getChilds ().addAll (list);
//			for (GroupClass child : gc.getChilds ())
//			{
//				List <Long> cids = genericIds (child);
//				for (Long cid : cids)
//				{
//					ids.add (cid);
//				}
//				ids.add (child.getId ());
//			}
//			return ids;
//		}

	/**
	 * 
	 * <p>
	 * Title: showPageFormHtml
	 * </p>
	 * <p>
	 * Description: 表单页码处理
	 * </p>
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pages
	 *            总页码数
	 * @return String 点击页码后的路径
	 */
	public static String showPageFormHtml (int currentPage , int pages)
		{
			String s = "";
			if (pages > 0)
			{
				if (currentPage >= 1)
				{
					s = s + "<a href='javascript:void(0);' onclick='return gotoPage(1)'>首页</a> ";
					if (currentPage > 1)
					{
						s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + (currentPage - 1) + ")'>上一页</a> ";
					}
				}
				int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
				if (beginPage <= pages)
				{
					s = s + "第　";
					int i = beginPage;
					for (int j = 0 ; (i <= pages) && (j < 6) ; j++)
					{
						if (i == currentPage)
							s = s + "<a class='this' href='javascript:void(0);' onclick='return gotoPage(" + i + ")'>" + i + "</a> ";
						else
							s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + i + ")'>" + i + "</a> ";
						i++;
					}
					s = s + "页　";
				}
				if (currentPage <= pages)
				{
					if (currentPage < pages)
					{
						s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + (currentPage + 1) + ")'>下一页</a> ";
					}
					s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + pages + ")'>末页</a> ";
				}
			}
			return s;
		}
}
