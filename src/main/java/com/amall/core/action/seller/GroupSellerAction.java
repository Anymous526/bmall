package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupArea;
import com.amall.core.bean.GroupAreaExample;
import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import com.amall.core.bean.GroupExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.goods.IGoods2UserGoodsClassService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.group.IGroupAreaService;
import com.amall.core.service.group.IGroupBrandService;
import com.amall.core.service.group.IGroupClassService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GroupSellerAction
 * </p>
 * <p>
 * Description: 卖家中心团购和团购商品的 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日下午2:24:12
 * @version 1.0
 */
@Controller
public class GroupSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupAreaService groupAreaService;

	@Autowired
	private IGroupClassService groupClassService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGroupBrandService groupBrandService;// 品牌团购Service

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoods2UserGoodsClassService goods2UgcService;

	@SecurityMapping(title = "卖家团购列表" , value = "/seller/group.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group.htm" })
	public ModelAndView group (HttpServletRequest request , HttpServletResponse response , String currentPage , String gg_name)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/group.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
			groupGoodsExample.clear ();
			groupGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			groupGoodsExample.setOrderByClause ("addTime desc");
			GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs goodsStore = null;
			// GoodsWithBLOBs ggGoods = null;一个店铺不止有一个商品，多个商品都可能参与团购
			List <Long> ggGoodsIds = new ArrayList <Long> ();// 保存GoodsId
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ());
			List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
			if (null != stores && stores.size () > 0)
			{
				goodsStore = stores.get (0);
			}
			if (goodsStore != null)
			{
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				goodsExample.createCriteria ().andGoodsStoreIdEqualTo (goodsStore.getId ());
				List <GoodsWithBLOBs> goodses = goodsService.getObjectList (goodsExample);
				/*
				 * if(goodses != null && goodses.size()>0)
				 * ggGoods = goodses.get(0);
				 */
				for (GoodsWithBLOBs goods : goodses)
				{
					ggGoodsIds.add (goods.getId ());
				}
			}
			if (ggGoodsIds.size () != 0)
			{// 可能有多个商品参与团购，而不止有一个商品
				groupGoodsCriteria.andGgGoodsIdIn (ggGoodsIds);
			}
			else
			{
				groupGoodsCriteria.andGgGoodsIdIsNull ();
			}
			/*
			 * qo.addQuery("obj.gg_goods.goods_store.user.id", new SysMap("user_id",
			 * SecurityUserHolder.getCurrentUser().getId()), "=");
			 */
			if (!CommUtil.null2String (gg_name).equals (""))
			{
				/*
				 * qo.addQuery("obj.gg_name", new SysMap("gg_name", "%" + gg_name
				 * + "%"), "like");
				 */
				groupGoodsCriteria.andGgNameLike ("%" + gg_name + "%");
			}
			Pagination pList = groupGoodsService.getObjectListWithPage (groupGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("gg_name" , gg_name);
			return mv;
		}

	@SecurityMapping(title = "卖家团购添加" , value = "/seller/group_add.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group_add.htm" })
	public ModelAndView group_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/group_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * Map params = new HashMap();
			 * params.put("joinEndTime", new Date());
			 * List groups = this.groupService
			 * .query("select obj from Group obj where obj.joinEndTime>=:joinEndTime",
			 * params, -1, -1);
			 * List gas = this.groupAreaService
			 * .query(
			 * "select obj from GroupArea obj where obj.parent.id is null order by obj.ga_sequence asc"
			 * ,
			 * null, -1, -1);
			 * List gcs = this.groupClassService
			 * .query(
			 * "select obj from GroupClass obj where obj.parent.id is null order by obj.gc_sequence asc"
			 * ,
			 * null, -1, -1);
			 */
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			// 单品团
			groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIsBrandEqualTo (0);
			List <Group> groups = groupService.getObjectList (groupExample);
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.setOrderByClause ("ga_sequence asc");
			groupAreaExample.createCriteria ().andParentIdIsNull ();
			List <GroupArea> gas = groupAreaService.getObjectList (groupAreaExample);
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			groupClassExample.setOrderByClause ("gc_sequence asc");
			groupClassExample.createCriteria ().andParentIdIsNull ();
			List <GroupClass> gcs = groupClassService.getObjectList (groupClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("gas" , gas);
			mv.addObject ("groups" , groups);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: group_brand_add
	 * </p>
	 * <p>
	 * Description: 新增品牌团购商品
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/seller/group_brand_add.htm" })
	public ModelAndView group_brand_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/group_brand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * Map params = new HashMap();
			 * params.put("joinEndTime", new Date());
			 * List groups = this.groupService
			 * .query("select obj from Group obj where obj.joinEndTime>=:joinEndTime",
			 * params, -1, -1);
			 * List gas = this.groupAreaService
			 * .query(
			 * "select obj from GroupArea obj where obj.parent.id is null order by obj.ga_sequence asc"
			 * ,
			 * null, -1, -1);
			 * List gcs = this.groupClassService
			 * .query(
			 * "select obj from GroupClass obj where obj.parent.id is null order by obj.gc_sequence asc"
			 * ,
			 * null, -1, -1);
			 */
			GroupBrandExample groupBrandExample = new GroupBrandExample ();
			groupBrandExample.clear ();
			GroupBrandExample.Criteria groupBrandCriteria = groupBrandExample.createCriteria ();
			groupBrandCriteria.andBrandIdIsNotNull ();
			List <GroupBrand> groupBrands = this.groupBrandService.getObjectList (groupBrandExample);
			List <Long> groupIds = new ArrayList <Long> ();// 所有有品牌团购的团购Ids
			for (GroupBrand groupBrand : groupBrands)
			{
				groupIds.add (groupBrand.getGroupId ());
			}
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			if (groupIds.size () != 0)
			{
				groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIdIn (groupIds);
			}
			else
			{
				groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIdIsNull ();
			}
			List <Group> groups = groupService.getObjectList (groupExample);
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.setOrderByClause ("ga_sequence asc");
			groupAreaExample.createCriteria ().andParentIdIsNull ();
			List <GroupArea> gas = groupAreaService.getObjectList (groupAreaExample);
			mv.addObject ("gas" , gas);
			mv.addObject ("groups" , groups);
			return mv;
		}

	@SecurityMapping(title = "卖家团购编辑" , value = "/seller/group_edit.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group_edit.htm" })
	public ModelAndView group_edit (HttpServletRequest request , HttpServletResponse response , String id , String isBrand)
		{
			ModelAndView mv;
			if (CommUtil.null2Int (isBrand) == 1)// 品牌团
			{
				mv = new JModelAndView ("seller/usercenter/group_brand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else if (CommUtil.null2Int (isBrand) == 0)// 单品团
			{
				mv = new JModelAndView ("seller/usercenter/group_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{// 默认单品团
				mv = new JModelAndView ("seller/usercenter/group_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			/*
			 * Map params = new HashMap();
			 * params.put("joinEndTime", new Date());
			 * List groups = this.groupService
			 * .query("select obj from Group obj where obj.joinEndTime>=:joinEndTime",
			 * params, -1, -1);
			 * List gas = this.groupAreaService
			 * .query(
			 * "select obj from GroupArea obj where obj.parent.id is null order by obj.ga_sequence asc"
			 * ,
			 * null, -1, -1);
			 * List gcs = this.groupClassService
			 * .query(
			 * "select obj from GroupClass obj where obj.parent.id is null order by obj.gc_sequence asc"
			 * ,
			 * null, -1, -1);
			 */
			List <Group> groups = null;
			if (CommUtil.null2Int (isBrand) == 0)
			{// 得到单品团团购
				GroupExample groupExample = new GroupExample ();
				groupExample.clear ();
				groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIsBrandEqualTo (0);
				groups = groupService.getObjectList (groupExample);
			}
			else if (CommUtil.null2Int (isBrand) == 1)
			{// 得到品牌团团购
				GroupBrandExample groupBrandExample = new GroupBrandExample ();
				groupBrandExample.clear ();
				GroupBrandExample.Criteria groupBrandCriteria = groupBrandExample.createCriteria ();
				groupBrandCriteria.andBrandIdIsNotNull ();
				List <GroupBrand> groupBrands = this.groupBrandService.getObjectList (groupBrandExample);
				List <Long> groupIds = new ArrayList <Long> ();// 所有有品牌团购的团购Ids
				for (GroupBrand groupBrand : groupBrands)
				{
					groupIds.add (groupBrand.getGroupId ());
				}
				GroupExample groupExample = new GroupExample ();
				groupExample.clear ();
				if (groupIds.size () != 0)
				{
					groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIdIn (groupIds);
				}
				else
				{
					groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ()).andIdIsNull ();
				}
				groups = groupService.getObjectList (groupExample);
			}
			else
			{// 默认的团购
				GroupExample groupExample = new GroupExample ();
				groupExample.clear ();
				groupExample.createCriteria ().andJoinendtimeGreaterThanOrEqualTo (new Date ());
				groups = groupService.getObjectList (groupExample);
			}
			GroupAreaExample groupAreaExample = new GroupAreaExample ();
			groupAreaExample.clear ();
			groupAreaExample.setOrderByClause ("ga_sequence asc");
			groupAreaExample.createCriteria ().andParentIdIsNull ();
			List <GroupArea> gas = groupAreaService.getObjectList (groupAreaExample);
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			groupClassExample.setOrderByClause ("gc_sequence asc");
			groupClassExample.createCriteria ().andParentIdIsNull ();
			List <GroupClass> gcs = groupClassService.getObjectList (groupClassExample);
			GroupGoods obj = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("gas" , gas);
			mv.addObject ("groups" , groups);
			return mv;
		}

	@SecurityMapping(title = "卖家团购商品" , value = "/seller/group_goods.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group_goods.htm" })
	public ModelAndView group_goods (HttpServletRequest request , HttpServletResponse response , String isBrand , String selId)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/group_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (selId));
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClassWithBLOBs gc : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.setOrderByClause ("sequence asc");
				GoodsClassExample.Criteria userGoodsCriteria = goodsClassExample.createCriteria ();
				userGoodsCriteria.andParentIdEqualTo (gc.getId ());
				List <GoodsClassWithBLOBs> childs = this.goodsClassService.getObjectList (goodsClassExample);
				if (childs != null && childs.size () != 0)
				{
					gc.getChilds ().addAll (childs);
				}
			}
			mv.addObject ("gcs" , gcs);
			mv.addObject ("isBrand" , isBrand);
			mv.addObject ("selId" , selId);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: group_goods_load
	 * </p>
	 * <p>
	 * Description: 加载商品信息
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param goods_name
	 * @param gc_id
	 */
	@RequestMapping({ "/seller/group_goods_load.htm" })
	public void group_goods_load (HttpServletRequest request , HttpServletResponse response , String goods_name , String gc_id , String brand_id)
		{
			goods_name = CommUtil.convert (goods_name , "UTF-8");
			StoreWithBLOBs store = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()).getStore ();
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			if (!"".equals (goods_name))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
			}
			if (!"".equals (gc_id) && gc_id != null)
				goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (gc_id));
			if (!"".equals (brand_id) && brand_id != null)
				goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (brand_id));
			goodsCriteria.andGroupBuyEqualTo (Integer.valueOf (0)).andDeliveryStatusEqualTo (Integer.valueOf (0)).andCombinStatusEqualTo (Integer.valueOf (0)).andActivityStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ());
			// List<Goods> goods = this.goodsService.query(query, params, -1, -1);
			List <GoodsWithBLOBs> goods = goodsService.getObjectList (goodsExample);
			List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
			for (GoodsWithBLOBs obj : goods)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				// 获取选择参加团购活动的商品的分类的顶级分类ID start
				long gcId = obj.getGcId ();
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andIdEqualTo (gcId);
				List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (goodsClassExample);
				if (!gcs.isEmpty ())
				{
					GoodsClassWithBLOBs gcwb = gcs.get (Globals.NUBER_ZERO);
					int level = gcwb.getLevel ();
					if (level == Globals.NUBER_ONE)
					{
						gcId = gcwb.getParent ().getId ();
					}
					else if (level == Globals.NUBER_TWO)
					{
						gcId = gcwb.getParent ().getParent ().getId ();
					}
				}
				// 获取选择参加团购活动的商品的分类的顶级分类ID end
				map.put ("id" , obj.getId ());
				map.put ("goods_name" , obj.getGoodsName ());
				map.put ("store_price" , obj.getGoodsPrice ());
				map.put ("store_inventory" , Integer.valueOf (obj.getGoodsInventory ()));
				map.put ("store_gcid" , gcId);
				map.put ("store_goodsBrandId" , obj.getGoodsBrandId ());
				list.add (map);
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (list , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "团购商品保存" , value = "/seller/group_goods_save.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group_goods_save.htm" })
	public String group_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String group_id , String goodsId , String gc_id , String ga_id)
		{
			WebForm wf = new WebForm ();
			GroupGoods gg = null;
			if (id.equals (""))
			{
				gg = (GroupGoods) wf.toPo (request , GroupGoods.class);
				gg.setAddtime (new Date ());
			}
			else
			{
				GroupGoods obj = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
				gg = (GroupGoods) wf.toPo (request , obj);
			}
			Group group = this.groupService.getByKey (CommUtil.null2Long (group_id));
			gg.setGroup (group);
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			gg.setGgGoods (goods);
			GroupClass gc = this.groupClassService.getByKey (CommUtil.null2Long (gc_id));
			gg.setGgGc (gc);
			GroupArea ga = this.groupAreaService.getByKey (CommUtil.null2Long (ga_id));
			gg.setGgGa (ga);
			gg.setGgRebate (BigDecimal.valueOf (CommUtil.div (Double.valueOf (CommUtil.mul (gg.getGgPrice () , Integer.valueOf (10))) , gg.getGgGoods ().getGoodsPrice ())));
			if (id.equals (""))
				this.groupGoodsService.add (gg);
			else
			{
				this.groupGoodsService.updateByObject (gg);
			}
			goods.setGroupBuy (1);
			this.goodsService.updateByObject (goods);
			request.getSession (false).setAttribute ("url" , CommUtil.getURL (request) + "/seller/group.htm");
			request.getSession (false).setAttribute ("op_title" , "团购商品保存成功");
			return "redirect:" + CommUtil.getURL (request) + "/success.htm";
		}

	/**
	 * 
	 * <p>
	 * Title: group_brand_goods_save
	 * </p>
	 * <p>
	 * Description: 品牌团购商品保存
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param group_id
	 * @param goods_id
	 * @param gc_id
	 * @param ga_id
	 * @return
	 */
	@RequestMapping({ "/seller/group_brand_goods_save.htm" })
	public String group_brand_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String group_id , String goodsId , String ga_id)
		{
			WebForm wf = new WebForm ();
			GroupGoods gg = null;
			if (id.equals (""))
			{
				gg = (GroupGoods) wf.toPo (request , GroupGoods.class);
				gg.setAddtime (new Date ());
			}
			else
			{
				GroupGoods obj = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
				gg = (GroupGoods) wf.toPo (request , obj);
			}
			Group group = this.groupService.getByKey (CommUtil.null2Long (group_id));
			gg.setGroup (group);
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			gg.setGgGoods (goods);
			GroupArea ga = this.groupAreaService.getByKey (CommUtil.null2Long (ga_id));
			gg.setGgGa (ga);
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "group";
			Map <String, Object> map = new HashMap <String, Object> ();
			Map <String, Object> map2 = new HashMap <String, Object> ();
			try
			{
				String fileName = gg.getGgImg () == null ? "" : gg.getGgImg ().getName ();
				String fileName2 = gg.getGgImg2 () == null ? "" : gg.getGgImg2 ().getName ();
				map = CommUtil.saveFileToServer (request , "gg_acc" , saveFilePathName , fileName , null);
				map2 = CommUtil.saveFileToServer (request , "gg_acc2" , saveFilePathName , fileName2 , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory gg_img = new Accessory ();
						gg_img.setName (CommUtil.null2String (map.get ("fileName")));
						gg_img.setExt (CommUtil.null2String (map.get ("mime")));
						gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						gg_img.setPath (uploadFilePath + "/group");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						gg.setGgImg (gg_img);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory gg_img = gg.getGgImg ();
					gg_img.setName (CommUtil.null2String (map.get ("fileName")));
					gg_img.setExt (CommUtil.null2String (map.get ("mime")));
					gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
					gg_img.setPath (uploadFilePath + "/group");
					gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
					gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
					gg_img.setAddtime (new Date ());
					this.accessoryService.updateByObject (gg_img);
				}
				if (fileName2.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory gg_img2 = new Accessory ();
						gg_img2.setName (CommUtil.null2String (map2.get ("fileName")));
						gg_img2.setExt (CommUtil.null2String (map2.get ("mime")));
						gg_img2.setSize (CommUtil.null2Float (map2.get ("fileSize")));
						gg_img2.setPath (uploadFilePath + "/group");
						gg_img2.setWidth (CommUtil.null2Int (map2.get ("width")));
						gg_img2.setHeight (CommUtil.null2Int (map2.get ("height")));
						gg_img2.setAddtime (new Date ());
						this.accessoryService.add (gg_img2);
						gg.setGgImg2 (gg_img2);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory gg_img2 = gg.getGgImg2 ();
					gg_img2.setName (CommUtil.null2String (map2.get ("fileName")));
					gg_img2.setExt (CommUtil.null2String (map2.get ("mime")));
					gg_img2.setSize (CommUtil.null2Float (map2.get ("fileSize")));
					gg_img2.setPath (uploadFilePath + "/group");
					gg_img2.setWidth (CommUtil.null2Int (map2.get ("width")));
					gg_img2.setHeight (CommUtil.null2Int (map2.get ("height")));
					gg_img2.setAddtime (new Date ());
					this.accessoryService.updateByObject (gg_img2);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			gg.setGgRebate (BigDecimal.valueOf (CommUtil.div (Double.valueOf (CommUtil.mul (gg.getGgPrice () , Integer.valueOf (10))) , gg.getGgGoods ().getGoodsPrice ())));
			if (id.equals (""))
				this.groupGoodsService.add (gg);
			else
			{
				this.groupGoodsService.updateByObject (gg);
			}
			goods.setGroupBuy (1);
			this.goodsService.updateByObject (goods);
			request.getSession (false).setAttribute ("url" , CommUtil.getURL (request) + "/seller/group.htm");
			request.getSession (false).setAttribute ("op_title" , "团购商品保存成功");
			return "redirect:" + CommUtil.getURL (request) + "/success.htm";
		}

	@SuppressWarnings("unused")
	private List <Long> genericUserGcIds (GoodsClassWithBLOBs ugc)
		{
			List <Long> ids = new ArrayList <Long> ();
			if (ugc != null)
			{
				ids.add (ugc.getId ());
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.clear ();
				GoodsClassExample.Criteria userGoodsCriteria = goodsClassExample.createCriteria ();
				userGoodsCriteria.andParentIdEqualTo (ugc.getId ());
				List <GoodsClassWithBLOBs> childs = this.goodsClassService.getObjectList (goodsClassExample);
				if (childs != null && childs.size () != 0)
				{
					ugc.getChilds ().addAll (childs);
				}
				for (GoodsClassWithBLOBs child : ugc.getChilds ())
				{
					List <Long> cids = genericUserGcIds (child);
					for (Long cid : cids)
					{
						ids.add (cid);
					}
					ids.add (child.getId ());
				}
			}
			return ids;
		}

	@SecurityMapping(title = "团购商品删除" , value = "/seller/group_del.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/group_del.htm" })
	public String group_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				GroupGoods gg = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
				GoodsWithBLOBs goods = gg.getGgGoods ();
				goods.setGroupBuy (0);
				this.goodsService.updateByObject (goods);
				CommUtil.del_acc (request , gg.getGgImg () , this.configService.getSysConfig ().getUploadRootPath ());
				this.groupGoodsService.deleteByKey (CommUtil.null2Long (id));
			}
			return "redirect:group.htm?currentPage=" + currentPage;
		}

	@RequestMapping(value = "/seller/seller_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String seller_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "group";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imageId = "";
			int reqWidth = CommUtil.null2Int (width);
			int reqHeight = CommUtil.null2Int (height);
			int mapWidth = CommUtil.null2Int (map.get ("width"));
			int mapHeight = CommUtil.null2Int (map.get ("height"));
			if ((Math.abs (reqWidth - mapWidth) == 0) && ((Math.abs (reqHeight - mapHeight) == 0)))
			{
				Accessory gg_img = new Accessory ();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						gg_img.setName (CommUtil.null2String (map.get ("fileName")));
						gg_img.setExt (CommUtil.null2String (map.get ("mime")));
						gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						gg_img.setPath (uploadFilePath + "/group");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
					}
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
			else
			{
				imageId = String.valueOf (0);
				response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
		}

	@RequestMapping({ "/seller/group_add2.htm" })
	public ModelAndView group_add2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("/seller/usercenter/group_add2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			return mv;
		}

	@RequestMapping(value = "/seller/seller_groupbrand.htm")
	@ResponseBody
	public String seller_groupbrand (HttpServletRequest request , HttpServletResponse response , String groupId)
		{
			long group_id = CommUtil.null2Long (groupId);
			GroupBrandExample groupBrandExample = new GroupBrandExample ();
			groupBrandExample.clear ();
			groupBrandExample.createCriteria ().andGroupIdEqualTo (group_id);
			List <GroupBrand> groupBrandList = this.groupBrandService.getObjectList (groupBrandExample);
			String response_rs = "";
			if (groupBrandList.size () > 0)
			{
				GroupBrand groupBrand = groupBrandList.get (0);
				String group_brand_id = String.valueOf (groupBrand.getBrandId ());
				String group_brand_name = groupBrand.getGoodsBrand ().getName ();
				response_rs = "{\"pass\":\"yes\",\"group_brand_id\":\"" + group_brand_id + "\",\"group_brand_name\":\"" + group_brand_name + "\"}";
			}
			else
			{
				response_rs = "{\"pass\":\"no\"}";
			}
			return response_rs;
		}
}
