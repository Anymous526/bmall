package com.amall.core.action.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Message;
import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.bean.StoreGradeLog;
import com.amall.core.bean.StoreGradeLogExample;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.push.jpush.JPush;
import com.amall.core.service.IConsultService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IMessageService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.privilege.IRoleService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStoreGradeLogService;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaManageTools;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreManageAction
 * </p>
 * <p>
 * Description: 店铺crud，店铺模板crud，店铺升级日志查询，卖家信用查询和设置
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午9:17:57
 * @version 1.0
 */
@Controller
public class StoreManageAction
{

	private Logger log = Logger.getLogger (StoreManageAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IStoreGradeService storeGradeService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IConsultService consultService;

	@Autowired
	private AreaManageTools areaManageTools;

	@Autowired
	private StoreTools storeTools;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IStoreGradeLogService storeGradeLogService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IAlbumService albumService;

	@SecurityMapping(title = "店铺列表" , value = "/admin/store_list.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_list.htm" })
	public ModelAndView store_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/store_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
			storeExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			storeExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			WebForm wf = new WebForm ();
			/**
			 * 第一个String表示字段名，Map<String，Object>中String表示=或者like条件,Object表示字段值
			 * 
			 */
			Map <String, Map <String, Object>> map = wf.toQueryPo (request , Store.class , mv);
			Iterator <String> it = map.keySet ().iterator ();
			while (it.hasNext ())
			{
				String key = it.next ().toString ();// 字段名
				Map <String, Object> map2 = map.get (key);
				Iterator <String> it2 = map2.keySet ().iterator ();
				String keys = "";// =或者like
				Object value = null;// 字段值
				if (it2.hasNext ())
				{
					keys = it2.next ().toString ();
					value = map2.get (keys);
				}
				if (key.equals ("storeName"))
				{
					if (keys.equals ("="))
					{
						storeCriteria.andStoreNameEqualTo (String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						storeCriteria.andStoreNameLike ("%" + String.valueOf (value) + "%");
					}
				}
				if(key.equals("storeOwer")){
					if (keys.equals ("="))
					{
						storeCriteria.andStoreOwerCardEqualTo(String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						storeCriteria.andStoreOwerLike("%" + String.valueOf (value) + "%");
					}
				}
				else if (key.equals ("gradeId"))
				{
					if (keys.equals ("="))
					{
						storeCriteria.andGradeIdEqualTo (Long.valueOf (String.valueOf (value)));
						mv.addObject ("gradeId" , Long.valueOf (String.valueOf (value)));
					}
					else if (keys.equals ("like"))
					{
						// id没有like
					}
				}
				else if (key.equals ("storeStatus"))
				{
					if (keys.equals ("="))
					{
						storeCriteria.andStoreStatusEqualTo (Integer.valueOf (String.valueOf (value)));
						mv.addObject ("storeStatus" , Integer.valueOf (String.valueOf (value)));
					}
					else if (keys.equals ("like"))
					{
						// status没有like
					}
				}
			}
			// IPageList pList = this.storeService.list(qo);
			Pagination pList = this.storeService.getObjectListWithPage (storeExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/store_list.htm" , "" , params , pList , mv);
			StoreGradeExample storeGradeExample = new StoreGradeExample ();
			storeGradeExample.clear ();
			storeGradeExample.setOrderByClause (Pagination.cst ("sequence" , "asc"));
			List <StoreGrade> grades = this.storeGradeService.getObjectList (storeGradeExample);
			mv.addObject ("grades" , grades);
			return mv;
		}

	@SecurityMapping(title = "店铺添加1" , value = "/admin/store_add.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_add.htm" })
	public ModelAndView store_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/store_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "店铺添加2" , value = "/admin/store_new.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_new.htm" })
	public ModelAndView store_new (HttpServletRequest request , HttpServletResponse response , String currentPage , String username , String list_url , String add_url)
		{
			ModelAndView mv = new JModelAndView ("admin/store_new.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (username);
			User user = null;
			List <User> users = userService.getObjectList (userExample);
			if (null != users && users.size () > 0)
				user = users.get (0);
			Store store = null;
			if (user != null)
				store = storeService.getByKey (user.getStoreId ());
			if (user == null)
			{
				mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_tip" , "不存在该用户");
				mv.addObject ("list_url" , list_url);
			}
			else if (store == null)
			{
				StoreClassExample storeClassExample = new StoreClassExample ();
				storeClassExample.clear ();
				storeClassExample.createCriteria ().andParentIdIsNull ();
				storeClassExample.setOrderByClause ("sequence asc");
				List <StoreClass> scs = storeClassService.getObjectList (storeClassExample);
				for (int i = 0 ; i < scs.size () ; i++)
				{
					StoreClass sc = scs.get (i);
					Map <String, Long> map = new HashMap <String, Long> ();
					map.put ("storeclassId" , sc.getId ());
					List <StoreClass> childs = storeClassService.selectChilds (map);
					sc.getChilds ().addAll (childs);
				}
				/*
				 * List scs = this.storeClassService
				 * .query(
				 * "select obj from StoreClass obj where obj.parent.id is null order by obj.sequence asc"
				 * ,
				 * null, -1, -1);
				 */
				AreaExample areaExample = new AreaExample ();
				areaExample.clear ();
				areaExample.createCriteria ().andParentIdIsNull ();
				List <Area> areas = areaService.getObjectList (areaExample);
				StoreGradeExample storeGradeExample = new StoreGradeExample ();
				storeGradeExample.clear ();
				storeGradeExample.setOrderByClause ("sequence asc");
				List <StoreGrade> grades = storeGradeService.getObjectList (storeGradeExample);
				mv.addObject ("grades" , grades);
				mv.addObject ("areas" , areas);
				mv.addObject ("scs" , scs);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("user" , user);
			}
			else
			{
				mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_tip" , "该用户已经开通店铺");
				mv.addObject ("list_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "店铺编辑" , value = "/admin/store_edit.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_edit.htm" })
	public ModelAndView store_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/store_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				StoreWithBLOBs store = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
				StoreClassExample storeClassExample = new StoreClassExample ();
				storeClassExample.clear ();
				storeClassExample.createCriteria ().andParentIdIsNull ();
				storeClassExample.setOrderByClause ("sequence asc");
				List <StoreClass> scs = storeClassService.getObjectList (storeClassExample);
				for (int i = 0 ; i < scs.size () ; i++)
				{
					StoreClass storeClass = scs.get (i);
					StoreClassExample storeClassExample2 = new StoreClassExample ();
					storeClassExample2.clear ();
					StoreClassExample.Criteria storeClassCriteria = storeClassExample2.createCriteria ();
					storeClassCriteria.andParentIdEqualTo (storeClass.getId ());
					List <StoreClass> childs = storeClassService.getObjectList (storeClassExample2);
					storeClass.getChilds ().addAll (childs);
				}
				AreaExample areaExample = new AreaExample ();
				areaExample.clear ();
				areaExample.createCriteria ().andParentIdIsNull ();
				List <Area> areas = areaService.getObjectList (areaExample);
				UserExample userExample = new UserExample ();
				userExample.clear ();
				UserExample.Criteria userCriteria = userExample.createCriteria ();
				System.out.println (store.getId ());
				userCriteria.andStoreIdEqualTo (store.getId ());
				User user = null;
				List <User> users = userService.getObjectList (userExample);
				if (null != users && users.size () > 0)
				{
					user = users.get (0);
					store.setUserId (user.getId ());
				}
				StorePoint storePoint = new StorePoint ();
				storePoint.setAddtime (new Date ());
				storePoint.setDescriptionEvaluate (BigDecimal.valueOf (5.0));
				storePoint.setServiceEvaluate (BigDecimal.valueOf (5.0));
				storePoint.setShipEvaluate (BigDecimal.valueOf (5.0));
				storePointService.add (storePoint);
				store.setPoint (storePoint);			// 添加店铺 评分 外键
				this.storeService.updateByObject (store);
				mv.addObject ("areas" , areas);
				mv.addObject ("scs" , scs);
				mv.addObject ("obj" , store);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				if (store.getArea () != null)
				{
					mv.addObject ("area_info" , this.areaManageTools.generic_area_info (store.getArea ()));
				}
			}
			return mv;
		}

	@SecurityMapping(title = "店铺保存" , value = "/admin/store_save.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_save.htm" })
	public ModelAndView store_save (HttpServletRequest request , HttpServletResponse response , String id , String area_id , String sc_id , String grade_id , String user_id , String store_status , String currentPage , String cmd , String list_url , String add_url , String violation_reseaon , String refuse_reason , String depositcash) throws Exception
		{
			WebForm wf = new WebForm ();
			StoreWithBLOBs store = null;
			if (null != id && id.equals (""))
			{
				store = (StoreWithBLOBs) wf.toPo (request , StoreWithBLOBs.class);
				store.setAddtime (new Date ());
			}
			else
			{
				StoreWithBLOBs obj = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
				store = (StoreWithBLOBs) wf.toPo (request , obj);
			}
			Area area = this.areaService.getByKey (CommUtil.null2Long (area_id));
			store.setArea (area);
			StoreClass sc = this.storeClassService.getByKey (Long.valueOf (Long.parseLong (sc_id)));
			store.setSc (sc);
			store.setTemplate ("default");
			if ((grade_id != null) && (!grade_id.equals ("")))
			{
				store.setGrade (this.storeGradeService.getByKey (Long.valueOf (Long.parseLong (grade_id))));
			}
			if ((store_status != null) && (!store_status.equals ("")))
			{
				//storeStutas==4  是后台审核的时候通过了但没有交保证金
				if (Integer.parseInt (depositcash) == 0 && store_status.equals ("4"))
				{
					store.setStoreStatus (2);
				}
				else
				{
					store.setStoreStatus (CommUtil.null2Int (store_status));
				}
			}
			else
				store.setStoreStatus (-1);
			if ((store_status != null) && (!store_status.equals ("")) && store_status.equals ("3"))
			{
				store.setViolationReseaon (violation_reseaon);
			}
			if ((store_status != null) && (!store_status.equals ("")) && store_status.equals ("-1"))
			{
				store.setRefuseReason (refuse_reason);
			}
			if (store.getStoreRecommend ())
				store.setStoreRecommendTime (new Date ());
			else
				store.setStoreRecommendTime (null);
			if (null != id && id.equals (""))
			{
				this.storeService.add (store);
				if (store.getStoreStatus () == 2)
				{
					// 开店成功推送成功消息
					open_shop_jusp (id);
					// 开店成功保存storeid到user表里面去
					setStoreId (store.getUserId () , store.getId ());
				}
				else
				{
					remStoreId (store.getUserId ());
					if (store.getStoreStatus () == -1)
					{
						// 开店失败推送失败消息
						reject_shop_jusp (id);
					}
				}
			}
			else
			{
				this.storeService.updateByObject (store);
				if (store.getStoreStatus () == 2)
				{
					// 开店成功推送成功消息
					open_shop_jusp (id);
					// 开店成功保存storeid到user表里面去
					setStoreId (store.getUserId () , store.getId ());
				}
				else
				{
					remStoreId (store.getUserId ());
					if (store.getStoreStatus () == -1)
					{
						// 开店失败推送失败消息
						reject_shop_jusp (id);
					}
				}
			}
			if ((user_id != null) && (!user_id.equals ("")))
			{
				User user = this.userService.getByKey (Long.valueOf (Long.parseLong (user_id)));
				store.setUserId (Long.parseLong (user_id));
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
				storeCriteria.andStoreNameEqualTo (store.getStoreName ());
				if (id != null && !id.equals (""))
				{
					storeCriteria.andIdEqualTo (Long.parseLong (id));
				}
				if (grade_id != null && !grade_id.equals (""))
				{
					storeCriteria.andGradeIdEqualTo (Long.parseLong (grade_id));
				}
				StoreWithBLOBs store1 = this.storeService.getObjectList (storeExample).get (0);
				user.setStore (store1);
				user.setUserrole ("BUYER_SELLER");
				RoleExample roleExample = new RoleExample ();
				roleExample.clear ();
				roleExample.createCriteria ().andTypeEqualTo ("SELLER");
				List <Role> roles = roleService.getObjectList (roleExample);
				/*
				 * Map params = new HashMap();
				 * params.put("type", "SELLER");
				 * List roles = this.roleService.query(
				 * "select obj from Role obj where obj.type=:type", params,
				 * -1, -1);
				 */
				user.getRoles ().addAll (roles);
				for (int i = 0 ; i < roles.size () ; i++)
				{
					Role role = roles.get (i);
					Map <String, Long> map = new HashMap <String, Long> ();
					map.put ("userId" , Long.parseLong (user_id));
					map.put ("roleId" , role.getId ());
					this.userService.insertUserRole (map);
				}
				this.userService.updateByObject (user);
			}
			if (null != id && !id.equals ("") && store.getStoreStatus () == 3)
			{
				send_site_msg (request , "msg_toseller_store_closed_notify" , store);
			}
			// storeService.updateByObject(store);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SuppressWarnings("deprecation")
	private void send_site_msg (HttpServletRequest request , String mark , StoreWithBLOBs store) throws Exception
		{
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templates = templateService.getObjectList (templateExample);
			Template template = null;
			if (templates != null && templates.size () > 0)
			{
				template = templates.get (0);
			}
			/*
			 * Template template = this.templateService
			 * .getObjByProperty("mark", mark);
			 */
			if (template != null && template.getOpen ())
			{
				String path = request.getRealPath ("/") + "/vm/";
				PrintWriter pwrite = new PrintWriter (new OutputStreamWriter (new FileOutputStream (path + "msg.vm" , false) , "UTF-8"));
				pwrite.print (template.getContent ());
				pwrite.flush ();
				pwrite.close ();
				Properties p = new Properties ();
				p.setProperty ("file.resource.loader.path" , request.getRealPath ("/") + "vm" + File.separator);
				p.setProperty ("input.encoding" , "UTF-8");
				p.setProperty ("output.encoding" , "UTF-8");
				Velocity.init (p);
				org.apache.velocity.Template blank = Velocity.getTemplate ("msg.vm" , "UTF-8");
				VelocityContext context = new VelocityContext ();
				context.put ("reason" , store.getViolationReseaon ());
				context.put ("user" , store.getUser ());
				context.put ("config" , this.configService.getSysConfig ());
				context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
				StringWriter writer = new StringWriter ();
				blank.merge (context , writer);
				String content = writer.toString ();
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameEqualTo ("admin");
				User fromUser = userService.getObjectList (userExample).get (0);
				/*
				 * User fromUser = this.userService.getObjByProperty("userName",
				 * "admin");
				 */
				Message msg = new Message ();
				msg.setAddtime (new Date ());
				msg.setContent (content);
				msg.setFromUser (fromUser);
				msg.setTitle (template.getTitle ());
				msg.setToUser (store.getUser ());
				msg.setType (0);
				this.messageService.add (msg);
				CommUtil.deleteFile (path + "msg.vm");
				writer.flush ();
				writer.close ();
			}
		}

	@SecurityMapping(title = "店铺删除" , value = "/admin/store_del.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_del.htm" })
	public String store_del (HttpServletRequest request , String mulitId) throws Exception
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					StoreWithBLOBs store = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (store.getUser () != null)
						store.getUser ().setStoreId (null);
					for (GoodsWithBLOBs goods : store.getGoodsList ())
					{
						/*
						 * Map map = new HashMap();
						 * map.put("gid", goods.getId());
						 * goodCarts = this.goodsCartService
						 * .query("select obj from GoodsCart obj where obj.goods.id = :gid",
						 * map, -1, -1);
						 */
						List <EvaluateWithBLOBs> evaluates = goods.getEvaluates ();
						for (Evaluate e : evaluates)
						{
							this.evaluateService.deleteByKey (e.getId ());
						}
						goods.getGoodsUgcs ().clear ();
						Accessory acc = goods.getGoodsMainPhoto ();
						if (acc != null)
						{
							acc.setAlbum (null);
							AlbumExample albumExample = new AlbumExample ();
							albumExample.clear ();
							AlbumExample.Criteria albumCriteria = albumExample.createCriteria ();
							albumCriteria.andAlbumCoverIdEqualTo (acc.getId ());
							Album album = this.albumService.getObjectList (albumExample).get (0);
							if (album != null)
							{
								album.setAlbumCover (null);
								this.albumService.updateByObject (album);
								this.albumService.deleteByKey (album.getId ());
							}
							this.accessoryService.updateByObject (acc);
							this.accessoryService.deleteByKey (acc.getId ());
						}
						for (Accessory acc1 : goods.getGoodsPhotos ())
						{
							if (acc1 != null)
							{
								acc1.setAlbum (null);
								AlbumExample albumExample2 = new AlbumExample ();
								albumExample2.clear ();
								AlbumExample.Criteria albumCriteria2 = albumExample2.createCriteria ();
								albumCriteria2.andAlbumCoverIdEqualTo (acc1.getId ());
								Album album = this.albumService.getObjectList (albumExample2).get (0);
								if (album != null)
								{
									album.setAlbumCover (null);
									this.albumService.updateByObject (album);
									this.albumService.deleteByKey (album.getId ());
								}
								acc1.setCover_album (null);
								this.accessoryService.updateByObject (acc1);
								this.accessoryService.deleteByKey (acc1.getId ());
							}
						}
						Map <String, Long> map = new HashMap <String, Long> ();
						map.put ("goodsId" , goods.getId ());
						List <GoodsWithBLOBs> combinGoods = this.goodsService.selectGoodsCombin (map);
						goods.getCombinGoods ().addAll (combinGoods);
						goods.getCombinGoods ().clear ();
						this.goodsService.deleteByKey (goods.getId ());
					}
					this.storeService.deleteByKey (CommUtil.null2Long (id));
					/* 从用户表里面清空店铺id */
					UserExample userExample = new UserExample ();
					userExample.createCriteria ().andStoreIdEqualTo (CommUtil.null2Long (id));
					List <User> users = this.userService.getObjectList (userExample);
					User user = users.get (0);
					user.setStoreId (null);
					this.userService.updateByObject (user);
					send_site_msg (request , "msg_toseller_goods_delete_by_admin_notify" , store);
				}
			}
			return "redirect:store_list.htm";
		}

	@SecurityMapping(title = "店铺AJAX更新" , value = "/admin/store_ajax.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_ajax.htm" })
	public void store_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			StoreWithBLOBs obj = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (StoreWithBLOBs.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，" + e1.getMessage ());
			}
			this.storeService.updateByObject (obj);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (val.toString ());
			}
			catch (IOException e)
			{
				log.error (e.getMessage ());
			}
		}

	@SecurityMapping(title = "卖家信用查询" , value = "/admin/store_base.htm*" , rtype = "admin" , rname = "基本设置" ,
						rcode = "admin_store_base" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_base.htm" })
	public ModelAndView store_base (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/store_base_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "卖家信用保存" , value = "/admin/store_set_save.htm*" , rtype = "admin" , rname = "基本设置" ,
						rcode = "admin_store_base" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_set_save.htm" })
	public ModelAndView store_set_add (HttpServletRequest request , HttpServletResponse response , String id , String list_url , String store_allow)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs sc = this.configService.getSysConfig ();
			sc.setStoreAllow (CommUtil.null2Boolean (store_allow));
			Map <Object, Integer> map = new HashMap <Object, Integer> ();
			for (int i = 0 ; i <= 29 ; i++)
			{
				map.put ("creditrule" + i , Integer.valueOf (CommUtil.null2Int (request.getParameter ("creditrule" + i))));
			}
			String creditrule = Json.toJson (map , JsonFormat.compact ());
			sc.setCreditrule (creditrule);
			if (id.equals (""))
			{
				this.configService.add (sc);
			}
			else
			{
				this.configService.updateByObject (sc);
			}
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺设置成功");
			return mv;
		}

	@SuppressWarnings("deprecation")
	@SecurityMapping(title = "店铺模板" , value = "/admin/store_template.htm*" , rtype = "admin" , rname = "店铺模板" ,
						rcode = "admin_store_template" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_template.htm" })
	public ModelAndView store_template (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/store_template.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("path" , request.getRealPath ("/"));
			mv.addObject ("separator" , File.separator);
			return mv;
		}

	@SecurityMapping(title = "店铺模板增加" , value = "/admin/store_template_add.htm*" , rtype = "admin" , rname = "店铺模板" ,
						rcode = "admin_store_template" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_template_add.htm" })
	public ModelAndView store_template_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/store_template_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "店铺模板保存" , value = "/admin/store_template_save.htm*" , rtype = "admin" , rname = "店铺模板" ,
						rcode = "admin_store_template" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_template_save.htm" })
	public ModelAndView store_template_save (HttpServletRequest request , HttpServletResponse response , String id , String list_url , String templates)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs sc = this.configService.getSysConfig ();
			sc.setTemplates (templates);
			if (id.equals (""))
				this.configService.add (sc);
			else
				this.configService.updateByObject (sc);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "店铺模板设置成功");
			return mv;
		}

	@SecurityMapping(title = "店铺升级列表" , value = "/admin/store_gradelog_list.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_gradelog_list.htm" })
	public ModelAndView store_gradelog_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String store_name , String grade_id , String store_grade_status)
		{
			ModelAndView mv = new JModelAndView ("admin/store_gradelog_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			StoreGradeLogExample storeGradeLogExample = new StoreGradeLogExample ();
			storeGradeLogExample.clear ();
			storeGradeLogExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			storeGradeLogExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			StoreGradeLogExample.Criteria storeGradeLogCriteria = storeGradeLogExample.createCriteria ();
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			StoreExample.Criteria storeCriteria = storeExample.createCriteria ();
			if (!CommUtil.null2String (store_name).equals (""))
			{
				storeCriteria.andStoreNameLike ("%" + store_name + "%");
				mv.addObject ("store_name" , store_name);
			}
			if (CommUtil.null2Long (grade_id).longValue () != -1L)
			{
				storeCriteria.andUpdateGradeIdEqualTo (CommUtil.null2Long (grade_id));
				mv.addObject ("grade_id" , grade_id);
			}
			List <StoreWithBLOBs> storeList = this.storeService.getObjectList (storeExample);
			StoreWithBLOBs store = null;
			if (storeList != null && storeList.size () > 0)
			{
				store = storeList.get (0);
				storeGradeLogCriteria.andStoreIdEqualTo (store.getId ());
			}
			else
			{
				storeGradeLogCriteria.andStoreIdIsNull ();
			}
			if (!CommUtil.null2String (store_grade_status).equals (""))
			{
				storeGradeLogCriteria.andStoreGradeStatusEqualTo (Integer.valueOf (CommUtil.null2Int (store_grade_status)));
				mv.addObject ("store_grade_status" , store_grade_status);
			}
			Pagination pList = storeGradeLogService.getObjectListWithPage (storeGradeLogExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/store_list.htm" , "" , params , pList , mv);
			StoreGradeExample storeGradeExample = new StoreGradeExample ();
			storeGradeExample.clear ();
			storeGradeExample.setOrderByClause ("sequence asc");
			List <StoreGrade> grades = storeGradeService.getObjectList (storeGradeExample);
			mv.addObject ("grades" , grades);
			return mv;
		}

	@SecurityMapping(title = "店铺升级编辑" , value = "/admin/store_gradelog_edit.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_gradelog_edit.htm" })
	public ModelAndView store_gradelog_edit (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/store_gradelog_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreGradeLog obj = this.storeGradeLogService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "店铺升级保存" , value = "/admin/store_gradelog_save.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_gradelog_save.htm" })
	public ModelAndView store_gradelog_add (HttpServletRequest request , HttpServletResponse response , String currentPage , String id , String cmd , String list_url) throws Exception
		{
			WebForm wf = new WebForm ();
			StoreGradeLog obj = this.storeGradeLogService.getByKey (CommUtil.null2Long (id));
			StoreGradeLog log = (StoreGradeLog) wf.toPo (request , obj);
			log.setLogEdit (true);
			log.setAddtime (new Date ());
			int ret = this.storeGradeLogService.updateByObject (log);
			if (ret != 0)
			{
				StoreWithBLOBs store = log.getStore ();
				if (log.getStoreGradeStatus () == 1)
				{
					store.setGrade (store.getUpdateGrade ());
				}
				store.setUpdateGrade (null);
				this.storeService.updateByObject (store);
			}
			if (log.getStoreGradeStatus () == 1)
			{
				send_site_msg (request , "msg_toseller_store_update_allow_notify" , log.getStore ());
			}
			if (log.getStoreGradeStatus () == -1)
			{
				send_site_msg (request , "msg_toseller_store_update_refuse_notify" , log.getStore ());
			}
			send_site_msg (request , "msg_toseller_store_update_allow_notify" , log.getStore ());
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺成功");
			return mv;
		}

	@SecurityMapping(title = "店铺升级日志查看" , value = "/admin/store_gradelog_view.htm*" , rtype = "admin" , rname = "店铺管理" ,
						rcode = "admin_store_set" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/store_gradelog_view.htm" })
	public ModelAndView store_gradelog_view (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/store_gradelog_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreGradeLog obj = this.storeGradeLogService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	/**
	 * 推送申请开店成功信息
	 * 
	 * @param id
	 */
	private void open_shop_jusp (String id)
		{
			Store store = null;
			if (StringUtils.isNotEmpty (id))
			{
				store = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
				// user = this.userService.getByKey(Long.valueOf(Long.parseLong(id)));
			}
			Map <String, Object> msgMap = new HashMap <String, Object> ();
			if (null != store)
			{
				if (null != store.getUserId ())
				{
					msgMap.put ("userId" , store.getUserId ().toString ());
				}
				if (null != store.getStoreName () && !store.getStoreName ().equals (""))
				{
					msgMap.put ("storeName" , store.getStoreName ().toString ());
				}
				msgMap.put ("content" , "恭喜您的店铺开店申请已被批准！");
				msgMap.put ("key" , "sendOpenShop");
				// JPush.sendMessageWithPassThroughAll(org.nutz.json.Json.toJson(msgMap),String.valueOf(store.getUserId()));
				JPush.sendMessageWithPassThroughAll (org.nutz.json.Json.toJson (msgMap) , String.valueOf (store.getUserId ()));
			}
		}

	/**
	 * 推送申请开店失败信息
	 * 
	 * @param id
	 */
	private void reject_shop_jusp (String id)
		{
			Store store = null;
			if (StringUtils.isNotEmpty (id))
			{
				store = this.storeService.getByKey (Long.valueOf (Long.parseLong (id)));
				// user = this.userService.getByKey(Long.valueOf(Long.parseLong(id)));
			}
			Map <String, Object> msgMap = new HashMap <String, Object> ();
			if (null != store)
			{
				if (null != store.getUserId ())
				{
					msgMap.put ("userId" , store.getUserId ().toString ());
				}
				if (null != store.getStoreName () && !store.getStoreName ().equals (""))
				{
					msgMap.put ("storeName" , store.getStoreName ().toString ());
				}
			msgMap.put ("content" , "您的开店申请已被拒绝！可以重新申请开店！");
			msgMap.put ("key" , "sendOpenShop");
			JPush.sendMessageWithPassThroughAll (org.nutz.json.Json.toJson (msgMap) , String.valueOf (store.getUserId ()));
			}
		}

	/**
	 * 保存店铺主键ID到user表里面去
	 * 
	 * @param userId
	 * @param storeId
	 */
	private void setStoreId (Long userId , Long storeId)
		{
			User user = this.userService.getByKey (userId);
			user.setStoreId (storeId);
			this.userService.updateByObject (user);
		}

	/**
	 * 删除user表里面的店铺ID
	 * 
	 * @param userId
	 * @param storeId
	 */
	private void remStoreId (Long userId)
		{
			User user = this.userService.getByKey (userId);
			user.setStoreId (null);
			this.userService.updateByObject (user);
		}
}
