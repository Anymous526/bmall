package com.amall.core.action.admin;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import com.amall.core.bean.GroupExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.group.IGroupBrandService;
import com.amall.core.service.group.IGroupClassService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GroupManageAction
 * </p>
 * <p>
 * Description: 团购管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月6日下午6:04:33
 * @version 1.0
 */
@Controller
public class GroupManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;// 商品类型Service

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGroupBrandService groupBrandService;// 团购品牌Service

	@Autowired
	private IGroupClassService groupClassService;// 团购分类

	@SecurityMapping(title = "团购列表" , value = "/admin/group_list.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_list.htm" })
	public ModelAndView group_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/group_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			groupExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			groupExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			Pagination pList = this.groupService.getObjectListWithPage (groupExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/group_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "团购增加" , value = "/admin/group_add.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_add.htm" })
	public ModelAndView group_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("/admin/group_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			// GroupExample groupExample = new GroupExample();
			// groupExample.clear();
			// GroupExample.Criteria groupCriteria = groupExample.createCriteria();
			// groupExample.setOrderByClause(Pagination.cst("endTime", "desc"));
			// groupCriteria.andStatusEqualTo(Integer.valueOf(0)).andIsBrandEqualTo(Integer.valueOf(0));
			// List groups = this.groupService.getObjectList(groupExample);
			// if (groups.size() > 0) {
			// Group group = (Group) groups.get(groups.size() - 1);
			// mv.addObject("group", group);
			// }
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdIsNull ();
			List <GoodsClassWithBLOBs> goodsClass = this.goodsClassService.getObjectList (goodsClassExample);
			// for(GoodsClassWithBLOBs gc : goodsClass ) {
			// goodsClassExample.clear();
			// goodsClassExample.createCriteria().andParentIdEqualTo(CommUtil.null2Long(gc.getId()));
			//
			// List<GoodsClassWithBLOBs> gcChilds =
			// this.goodsClassService.getObjectList(goodsClassExample);
			//
			// for(GoodsClassWithBLOBs g : gcChilds) {
			// goodsClassExample.clear();
			// goodsClassExample.createCriteria().andParentIdEqualTo(g.getId());
			// List<GoodsClassWithBLOBs> gcsChildsChilds =
			// this.goodsClassService.getObjectList(goodsClassExample);
			// g.setChilds(gcsChildsChilds);
			// }
			//
			// gc.setChilds(gcChilds);
			// }
			mv.addObject ("gcs" , goodsClass);
			GroupClassExample groupClassExample = new GroupClassExample ();
			groupClassExample.clear ();
			GroupClassExample.Criteria groupClassCriteria = groupClassExample.createCriteria ();
			groupClassCriteria.andParentIdIsNull ();// 单品团列出的是ParentId为null的分类
			List <GroupClass> groupClassEs = this.groupClassService.getObjectList (groupClassExample);
			mv.addObject ("groupClassEs" , groupClassEs);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: group_brand_add
	 * </p>
	 * <p>
	 * Description: 添加品牌团
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/admin/group_brand_add.htm" })
	public ModelAndView group_brand_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_brand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			groupExample.setOrderByClause (Pagination.cst ("endTime" , "desc"));
			groupCriteria.andStatusEqualTo (Integer.valueOf (0)).andIsBrandEqualTo (Integer.valueOf (1));
			List <Group> groups = this.groupService.getObjectList (groupExample);
			if (groups.size () > 0)
			{
				Group group = (Group) groups.get (groups.size () - 1);
				mv.addObject ("group" , group);
			}
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			GoodsBrandExample.Criteria goodsBrandCriteria = goodsBrandExample.createCriteria ();
			// goodsBrandCriteria.andRecommendEqualTo(Boolean.valueOf(true));
			goodsBrandCriteria.andAuditEqualTo (1);
			goodsBrandExample.setOrderByClause ("sequence asc");
			List <GoodsBrand> gbs = this.goodsBrandService.getObjectList (goodsBrandExample);
			mv.addObject ("gbs" , gbs);
			return mv;
		}

	@SecurityMapping(title = "团购编辑" , value = "/admin/group_edit.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_edit.htm" })
	public ModelAndView group_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/group_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Group group = this.groupService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , group);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				GroupExample groupExample = new GroupExample ();
				groupExample.clear ();
				groupExample.setOrderByClause ("endTime desc");
				groupExample.createCriteria ().andStatusEqualTo (Integer.valueOf (0));
				List <Group> groups = groupService.getObjectList (groupExample);
				if (groups.size () > 0)
				{
					Group group1 = (Group) groups.get (0);
					mv.addObject ("group" , group1);
				}
			}
			return mv;
		}

	@SuppressWarnings("deprecation")
	@SecurityMapping(title = "团购保存" , value = "/admin/group_save.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_save.htm" })
	public ModelAndView group_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String beginHour , String endHour , String joinHour , String gc_id , String grc_id)
		{
			WebForm wf = new WebForm ();
			Group group = null;
			if (id.equals (""))
			{
				group = (Group) wf.toPo (request , Group.class);
				group.setAddtime (new Date ());
			}
			else
			{
				Group obj = this.groupService.getByKey (Long.valueOf (Long.parseLong (id)));
				group = (Group) wf.toPo (request , obj);
			}
			Long groupId = null;
			Date beginTime = group.getBegintime ();
			beginTime.setHours (CommUtil.null2Int (beginHour));
			group.setBegintime (beginTime);
			Date endTime = group.getEndtime ();
			endTime.setHours (CommUtil.null2Int (endHour));
			group.setEndtime (endTime);
			Date joinEndTime = group.getJoinendtime ();
			joinEndTime.setHours (CommUtil.null2Int (joinHour));
			group.setJoinendtime (joinEndTime);
			group.setIsBrand (0);// 0表示单品团
			if (beginTime.after (new Date ()))
			{
				// 1表示未开始
				group.setStatus (1);
			}
			group.setGoodsClassId (CommUtil.null2Long (gc_id));// 添加团购分类
			if (id.equals (""))
				this.groupService.add (group);
			else
				this.groupService.updateByObject (group);
			groupId = group.getId ();
			GoodsClassWithBLOBs goodsClass = new GoodsClassWithBLOBs ();
			goodsClass.setGroupId (groupId);
			goodsClass.setId (Long.parseLong (gc_id));
			this.goodsClassService.updateByObject (goodsClass);// 团购的时候更新
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/group_list.htm");
			mv.addObject ("op_title" , "保存团购成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/group_add.htm" + "?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购删除" , value = "/admin/group_del.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_del.htm" })
	public String group_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					Group group = this.groupService.getByKey (CommUtil.null2Long (id));
					/*
					 * for (Goods goods : group.getGoods_list()) {
					 * goods.setGroup_buy(0); goods.setGroup(null);
					 * this.goodsService.update(goods); } for (GroupGoods gg :
					 * group.getGg_list()) {
					 * this.groupGoodsService.delete(gg.getId()); }
					 */
					this.groupService.deleteByKey (CommUtil.null2Long (id));
					if (group.getIsBrand () == 1)// 如果是品牌团
					{
						GroupBrandExample groupBrandExample = new GroupBrandExample ();
						groupBrandExample.clear ();
						GroupBrandExample.Criteria groupBrandCriteria = groupBrandExample.createCriteria ();
						groupBrandCriteria.andGroupIdEqualTo (group.getId ());
						this.groupBrandService.deleteByExample (groupBrandExample);
					}
				}
			}
			return "redirect:group_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购关闭" , value = "/admin/group_close.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_close.htm" })
	public String group_close (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					Group group = this.groupService.getByKey (Long.valueOf (Long.parseLong (id)));
					group.setStatus (-1);
					this.groupService.updateByObject (group);
					/*
					 * for (GroupGoods gg : group.getGg_list()) {
					 * gg.setGg_status(-1); this.groupGoodsService.update(gg); } for
					 * (Goods goods : group.getGoods_list()) { if
					 * (goods.getGroup().getId().equals(group.getId())) {
					 * goods.setGroup(null); goods.setGroup_buy(0);
					 * this.goodsService.update(goods); } }
					 */
				}
			}
			return "redirect:group_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购申请列表" , value = "/admin/group_goods_list.htm*" , rtype = "seller" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_goods_list.htm" })
	public ModelAndView group_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String group_id , String gg_status)
		{
			ModelAndView mv = new JModelAndView ("admin/group_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			// GroupGoodsQueryObject qo = new GroupGoodsQueryObject(currentPage,
			// mv,"addTime", "desc");
			GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
			groupGoodsExample.clear ();
			GroupGoodsExample.Criteria groupGoodsCriteria = groupGoodsExample.createCriteria ();
			groupGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			groupGoodsExample.setOrderByClause (Pagination.cst ("addTime" , "desc"));
			// qo.addQuery("obj.group.id",new SysMap("group_id",
			// CommUtil.null2Long(group_id)), "=");
			groupGoodsCriteria.andGroupIdEqualTo (CommUtil.null2Long (group_id));
			if ((gg_status == null) || (gg_status.equals ("")))
				groupGoodsCriteria.andGgStatusEqualTo (Integer.valueOf (1));
			else
			{
				groupGoodsCriteria.andGgStatusEqualTo (Integer.valueOf (CommUtil.null2Int (gg_status)));
			}
			// IPageList pList = this.groupGoodsService.list(qo);
			Pagination pList = this.groupGoodsService.getObjectListWithPage (groupGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("group_id" , group_id);
			mv.addObject ("gg_status" , Integer.valueOf (CommUtil.null2Int (gg_status)));
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: group_brand_save
	 * </p>
	 * <p>
	 * Description: 新增品牌团，保存
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @param cmd
	 * @param beginHour
	 * @param endHour
	 * @param joinendtime
	 * @param gb_id
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping({ "/admin/group_brand_save.htm" })
	public ModelAndView group_brand_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String beginHour , String endHour , String joinHour , String gb_id)
		{
			WebForm wf = new WebForm ();
			Group group = null;
			if (id.equals (""))
			{
				group = (Group) wf.toPo (request , Group.class);
				group.setAddtime (new Date ());
			}
			else
			{
				Group obj = this.groupService.getByKey (Long.valueOf (Long.parseLong (id)));
				group = (Group) wf.toPo (request , obj);
			}
			Long groupId = null;
			Date beginTime = group.getBegintime ();
			beginTime.setHours (CommUtil.null2Int (beginHour));
			group.setBegintime (beginTime);
			Date endTime = group.getEndtime ();
			endTime.setHours (CommUtil.null2Int (endHour));
			group.setEndtime (endTime);
			Date joinEndTime = group.getJoinendtime ();
			joinEndTime.setHours (CommUtil.null2Int (joinHour));
			group.setJoinendtime (joinEndTime);
			group.setIsBrand (1);// 表示品牌团.如果设为0表示单品团
			if (beginTime.after (new Date ()))
			{
				group.setStatus (1);
			}
			if (id.equals (""))
				this.groupService.add (group);
			else
				this.groupService.updateByObject (group);
			groupId = group.getId ();
			/**
			 * 保存到团购品牌表
			 */
			GroupBrand groupBrand = new GroupBrand ();// 团购品牌
			groupBrand.setBrandId (CommUtil.null2Long (gb_id));
			groupBrand.setGroupId (groupId);
			this.groupBrandService.add (groupBrand);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/group_list.htm");
			mv.addObject ("op_title" , "保存团购成功");
			mv.addObject ("add_url" , CommUtil.getURL (request) + "/admin/group_add.htm" + "?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "团购商品审核通过" , value = "/admin/group_goods_audit.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_goods_audit.htm" })
	public String group_goods_audit (HttpServletRequest request , HttpServletResponse response , String mulitId , String group_id , String gg_status , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GroupGoods gg = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
					gg.setGgStatus (1);
					gg.setGgAuditTime (new Date ());
					this.groupGoodsService.updateByObject (gg);
					GoodsWithBLOBs goods = gg.getGgGoods ();
					goods.setGroupBuy (2);
					goods.setGroup (this.groupService.getByKey (CommUtil.null2Long (group_id)));
					goods.setGoodsCurrentPrice (gg.getGgPrice ());
					this.goodsService.updateByObject (goods);
				}
			}
			return "redirect:group_goods_list.htm?group_id=" + group_id + "&gg_status=" + gg_status + "&currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购商品审核拒绝" , value = "/admin/group_goods_refuse.htm*" , rtype = "admin" , rname = "团购管理" ,
						rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_goods_refuse.htm" })
	public String group_goods_refuse (HttpServletRequest request , HttpServletResponse response , String mulitId , String group_id , String gg_status , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GroupGoods gg = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
					GoodsWithBLOBs goods = gg.getGgGoods ();
					goods.setGroupBuy (0);
					goods.setGroup (null);
					goods.setGoodsCurrentPrice (goods.getStorePrice ());
					this.goodsService.updateByObject (goods);
					gg.setGgStatus (-1);
					this.groupGoodsService.updateByObject (gg);
				}
			}
			return "redirect:group_goods_list.htm?group_id=" + group_id + "&gg_status=" + gg_status + "&currentPage=" + currentPage;
		}

	@SecurityMapping(title = "团购商品审核推荐" , value = "/admin/group_goods_recommend.htm*" , rtype = "admin" ,
						rname = "团购管理" , rcode = "group_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/group_goods_recommend.htm" })
	public String group_goods_recommend (HttpServletRequest request , HttpServletResponse response , String mulitId , String group_id , String gg_status , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GroupGoods gg = this.groupGoodsService.getByKey (CommUtil.null2Long (id));
					if (gg.getGgRecommend () == 0)
						gg.setGgRecommend (1);
					else
					{
						gg.setGgRecommend (0);
					}
					gg.setGgRecommendTime (new Date ());
					this.groupGoodsService.updateByObject (gg);
				}
			}
			return "redirect:group_goods_list.htm?group_id=" + group_id + "&gg_status=" + gg_status + "&currentPage=" + currentPage;
		}
}
