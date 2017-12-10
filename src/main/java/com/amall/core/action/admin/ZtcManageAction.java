package com.amall.core.action.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
//import com.amall.core.bean.Store;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.ZTCGoldLog;
import com.amall.core.bean.ZTCGoldLogExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IZTCGoldLogService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ZtcManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IZTCGoldLogService ztcGoldLogService;

	@SecurityMapping(title = "直通车设置" , value = "/admin/ztc_set.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_set.htm" })
	public ModelAndView ztc_set (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "直通车设置保存" , value = "/admin/ztc_set_save.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_set_save.htm" })
	public ModelAndView ztc_set_save (HttpServletRequest request , HttpServletResponse response , String id , String ztcStatus , String ztcPrice , String ztcGoodsView)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			config.setZtcPrice (CommUtil.null2Int (ztcPrice));
			config.setZtcStatus (CommUtil.null2Boolean (ztcStatus));
			config.setZtcGoodsView (CommUtil.null2Int (ztcGoodsView));
			if (id.equals (""))
				this.configService.add (config);
			else
			{
				this.configService.updateByObject (config);
			}
			mv.addObject ("op_title" , "直通车设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			return mv;
		}

	@SecurityMapping(title = "直通车申请列表" , value = "/admin/ztc_apply.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_apply.htm" })
	public ModelAndView ztc_apply (HttpServletRequest request , HttpServletResponse response , String currentPage , String goods_name , String userName , String store_name , String ztc_status , String ztc_pay_status)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_apply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
				goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				goodsExample.setOrderByClause (Pagination.cst ("ztc_apply_time" , "desc"));
				goodsCriteria.andZtcStatusEqualTo (Integer.valueOf (1));
				if (!CommUtil.null2String (goods_name).equals (""))
				{
					goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
				}
				if (!CommUtil.null2String (userName).equals (""))
				{
					// qo.addQuery("obj.goods_store.user.userName", new SysMap("userName",
					// userName.trim()), "=");
					User user = null;
					UserExample userExample = new UserExample ();
					userExample.clear ();
					userExample.createCriteria ().andUsernameEqualTo (userName.trim ());
					List <User> users = userService.getObjectList (userExample);
					if (null != users && users.size () > 0)
					{
						user = users.get (0);
					}
					if (null != user && null != user.getId ())
					{
						goodsCriteria.andGoodsStoreIdEqualTo (user.getId ());
					}
				}
//				if (!CommUtil.null2String (store_name).equals (""))
//				{
					// qo.addQuery("obj.goods_store.store_name", new SysMap("store_name",
					// store_name), "=");
					// Store store = null;
					// StoreExample storeExample = new StoreExample ();
					// storeExample.clear ();
					// storeExample.createCriteria ().andStoreNameEqualTo (store_name);
					// List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
					// if (stores != null && stores.size () > 0)
					// store = stores.get (0);
					// 商铺名称条件 没设置
					// goodsCriteria.andstor
//				}
				if (!CommUtil.null2String (ztc_status).equals (""))
				{
					goodsCriteria.andZtcStatusEqualTo (Integer.valueOf (CommUtil.null2Int (ztc_status)));
				}
				if (!CommUtil.null2String (ztc_pay_status).equals (""))
				{
					goodsCriteria.andZtcPayStatusEqualTo (Integer.valueOf (CommUtil.null2Int (ztc_pay_status)));
				}
				// IPageList pList = this.goodsService.list(qo);
				Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("goods_name" , goods_name);
				mv.addObject ("userName" , userName);
				mv.addObject ("store_name" , store_name);
				mv.addObject ("ztc_status" , ztc_status);
				mv.addObject ("ztc_pay_status" , ztc_pay_status);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "直通车商品审核" , value = "/admin/ztc_apply_edit.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_apply_edit.htm" })
	public ModelAndView ztc_apply_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_apply_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				GoodsWithBLOBs obj = this.goodsService.getByKey (CommUtil.null2Long (id));
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "直通车商品查看" , value = "/admin/ztc_apply_view.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_apply_view.htm" })
	public ModelAndView ztc_apply_view (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_apply_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				GoodsWithBLOBs obj = this.goodsService.getByKey (CommUtil.null2Long (id));
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "直通车商品审核保存" , value = "/admin/ztc_apply_save.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_apply_save.htm" })
	public ModelAndView ztc_apply_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String ztc_status , String ztc_admin_content)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				GoodsWithBLOBs obj = this.goodsService.getByKey (CommUtil.null2Long (id));
				obj.setZtcAdmin (SecurityUserHolder.getCurrentUser ());
				obj.setZtcAdminContent (ztc_admin_content);
				Calendar cal = Calendar.getInstance ();
				if ((CommUtil.null2Int (ztc_status) == 2) && (cal.after (obj.getZtcBeginTime ())))
					obj.setZtcDredgePrice (obj.getZtcPrice ());
				else
				{
					obj.setZtcStatus (CommUtil.null2Int (ztc_status));
				}
				boolean ret = (this.goodsService.updateByObject (obj) != 0);
				if ((ret) && (obj.getZtcStatus () == 2))
				{
					User user = obj.getGoodsStore ().getUser ();
					user.setGold (user.getGold () - obj.getZtcGold ());
					this.userService.updateByObject (user);
					ZTCGoldLog log = new ZTCGoldLog ();
					log.setAddtime (new Date ());
					log.setZglContent ("开通直通车，消耗金币");
					log.setZglGold (obj.getZtcGold ());
					log.setZglGoodsId (obj.getId ());
					log.setZglType (1);
					this.ztcGoldLogService.add (log);
				}
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("op_title" , "直通车审核成功");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_apply.htm?currentPage=" + currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "直通车商品" , value = "/admin/ztc_goods.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_goods.htm" })
	public ModelAndView ztc_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String goods_name , String userName , String store_name)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
				goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				goodsExample.setOrderByClause (Pagination.cst ("ztc_apply_time" , "desc"));
				goodsCriteria.andZtcStatusEqualTo (Integer.valueOf (2));
				if (!CommUtil.null2String (goods_name).equals (""))
				{
					goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
				}
				if (!CommUtil.null2String (userName).equals (""))
				{
					User user = null;
					UserExample userExample = new UserExample ();
					userExample.clear ();
					userExample.createCriteria ().andUsernameEqualTo (userName.trim ());
					List <User> users = userService.getObjectList (userExample);
					if (null != users && users.size () > 0)
					{
						user = users.get (0);
					}
					if (null != user && null != user.getId ())
					{
						goodsCriteria.andGoodsStoreIdEqualTo (user.getId ());
					}
				}
				// if (!CommUtil.null2String (store_name).equals (""))
				// {
				// qo.addQuery("obj.goods_store.store_name", new SysMap("store_name",
				// store_name), "=");
				// }
				Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("goods_name" , goods_name);
				mv.addObject ("userName" , userName);
				mv.addObject ("store_name" , store_name);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "直通车金币日志" , value = "/admin/ztc_gold_log.htm*" , rtype = "admin" , rname = "竞价直通车" ,
						rcode = "ztc_set" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ztc_gold_log.htm" })
	public ModelAndView ztc_gold_log (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String goods_name , String store_name , String beginTime , String endTime)
		{
			ModelAndView mv = new JModelAndView ("admin/ztc_gold_log.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getZtcStatus ())
			{
				ZTCGoldLogExample ztcGoldLogExample = new ZTCGoldLogExample ();
				ztcGoldLogExample.clear ();
				ZTCGoldLogExample.Criteria ztcGoldLogCriteria = ztcGoldLogExample.createCriteria ();
				ztcGoldLogExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				ztcGoldLogExample.setOrderByClause ("addTime desc");
				GoodsExample goodsExample = new GoodsExample ();
				if (!CommUtil.null2String (goods_name).equals (""))
				{
					Goods zgl = null;
					goodsExample.clear ();
					goodsExample.createCriteria ().andGoodsNameLike ("%" + goods_name.trim () + "%");
					List <GoodsWithBLOBs> zglGoods = goodsService.getObjectList (goodsExample);
					if (null != zglGoods && zglGoods.size () > 0)
					{
						zgl = zglGoods.get (0);
					}
					if (null != zgl && null != zgl.getId ())
					{
						ztcGoldLogCriteria.andZglGoodsIdEqualTo (zgl.getId ());
					}
					// qo.addQuery("obj.zgl_goods.goods_name", new SysMap("goods_name", "%" +
					// goods_name.trim() + "%"), "like");
				}
				if (!CommUtil.null2String (store_name).equals (""))
				{
					// qo.addQuery("obj.zgl_goods.goods_store.store_name", new SysMap("store_name",
					// store_name), "=");
					StoreExample storeExample = new StoreExample ();
					storeExample.clear ();
					storeExample.createCriteria ().andStoreNameEqualTo (store_name);
					List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
					if (null != stores && stores.size () > 0)
					{
						goodsExample.clear ();
						goodsExample.createCriteria ().andGoodsStoreIdEqualTo (stores.get (0).getId ());
						List <GoodsWithBLOBs> zglGoods = goodsService.getObjectList (goodsExample);
						if (zglGoods != null && zglGoods.size () > 0)
							ztcGoldLogCriteria.andZglGoodsIdEqualTo (zglGoods.get (0).getId ());
					}
				}
				if (!CommUtil.null2String (beginTime).equals (""))
				{
					ztcGoldLogCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
				}
				if (!CommUtil.null2String (endTime).equals (""))
				{
					ztcGoldLogCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
				}
				Pagination pList = this.ztcGoldLogService.getObjectListWithPage (ztcGoldLogExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("goods_name" , goods_name);
				mv.addObject ("store_name" , store_name);
				mv.addObject ("beginTime" , beginTime);
				mv.addObject ("endTime" , endTime);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启直通车");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ztc_set.htm");
			}
			return mv;
		}
}
