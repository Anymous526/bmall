package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.jpush.api.utils.StringUtils;

import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsFloor;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsFloorTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : 新品楼层管理
 *
 * Description : 对新品楼层的CRUD
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月22日 下午6:18:20
 *
 */
@Controller
@RequestMapping({ "/admin/newGoods" })
public class NewGoodsFloorManageAction
{

	private Logger log = Logger.getLogger (NewGoodsFloorManageAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsFloorService goodsfloorService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private GoodsFloorTools gf_tools;

	@SecurityMapping(title = "楼层分类列表" , value = "/admin/newGoods/goods_floor_list.htm*" , rtype = "admin" ,
						rname = "新品楼层" , rcode = "goods_new__floor" , rgroup = "新品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_list.htm" })
	public ModelAndView goods_floor_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsFloorExample.setOrderByClause ("gf_sequence asc");
			goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("newGoods");
			Pagination pList = goodsfloorService.getObjectListWithPage (goodsFloorExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/newGoods/goods_floor_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "楼层分类添加" , value = "/admin/newGoods/goods_floor_add.htm*" , rtype = "admin" ,
						rname = "新品楼层" , rcode = "goods_new_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_add.htm" })
	public ModelAndView goods_floor_add (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("newGoods");
			List <GoodsFloorWithBLOBs> gfs = goodsfloorService.getObjectList (goodsFloorExample);
			mv.addObject ("gfs" , gfs);
			GoodsFloorWithBLOBs obj = new GoodsFloorWithBLOBs ();
			GoodsFloor parent = this.goodsfloorService.getByKey (CommUtil.null2Long (pid));
			obj.setParent (parent);
			if (parent != null)
				obj.setGfLevel (parent.getGfLevel () + 1);
			obj.setGfDisplay (true);
			mv.addObject ("obj" , obj);
			return mv;
		}

	@SecurityMapping(title = "楼层分类编辑" , value = "/admin/newGoods/goods_floor_edit.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_edit.htm" })
	public ModelAndView goods_floor_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsFloorWithBLOBs goodsfloor = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
				goodsFloorExample.clear ();
				goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("newGoods");
				List <GoodsFloorWithBLOBs> gfs = goodsfloorService.getObjectList (goodsFloorExample);
				Map <String, Object> map = this.gf_tools.generic_gfMainPhotoList (goodsfloor.getGfMainPhoto ());
				mv.addObject ("acc_url" , map.get ("acc_url"));
				Accessory accessory = (Accessory) map.get ("acc");
				String acc_path = "";
				if (accessory != null)
				{
					acc_path = accessory.getPath () + File.separator + accessory.getName () + "." + accessory.getExt ();
				}
				mv.addObject ("acc_path" , acc_path);
				mv.addObject ("acc" , accessory);
				mv.addObject ("gfs" , gfs);
				mv.addObject ("obj" , goodsfloor);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "楼层分类保存" , value = "/admin/newGoods/goods_floor_save.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_save.htm" })
	public ModelAndView goods_floor_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String pid , String list_url , String add_url , String gf_url , String type , String goodId)
		{
			WebForm wf = new WebForm ();
			
			GoodsFloorWithBLOBs goodsfloor = null;
			if (id.equals (""))
			{
				goodsfloor = (GoodsFloorWithBLOBs) wf.toPo (request , GoodsFloorWithBLOBs.class);
				goodsfloor.setAddtime (new Date ());
			}
			else
			{
				GoodsFloor obj = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsfloor = (GoodsFloorWithBLOBs) wf.toPo (request , obj);
			}
			GoodsFloor parent = this.goodsfloorService.getByKey (CommUtil.null2Long (pid));
			if(StringUtils.isNotEmpty(type) && type.equals("bargain")){
				goodsfloor.setGfMark ("daily_bargain");
				/*清空之前的首页特卖（每上传都会一更）*/
				List<GoodsFloorWithBLOBs> goodsFloors = new ArrayList<GoodsFloorWithBLOBs>();
				GoodsFloorExample example = new GoodsFloorExample();
				example.createCriteria().andGfMarkEqualTo("daily_bargain");
				goodsFloors = goodsfloorService.getObjectList(example);
				for (GoodsFloorWithBLOBs goodsFloorWithBLOBs : goodsFloors) {
					if(null != goodsFloorWithBLOBs.getId()){
						goodsfloorService.deleteByKey(goodsFloorWithBLOBs.getId());
					}
					
				}
			}else{
				goodsfloor.setGfMark ("newGoods");
			}

			//结束
			if (parent != null)
			{
				goodsfloor.setParent (parent);
				goodsfloor.setGfLevel (parent.getGfLevel () + 1);
			}
			if (id.equals (""))
				this.goodsfloorService.add (goodsfloor);
			else
				this.goodsfloorService.updateByObject (goodsfloor);
			ModelAndView mv = new JModelAndView ("admin/newGoods/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存首页楼层成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			if(StringUtils.isNotEmpty(goodId)){
				Map <String, Object> json_map = new HashMap <String, Object> ();
				json_map.put ("goodsId" , goodId);
				goodsfloor.setGfListGoods(Json.toJson (json_map , JsonFormat.compact ()));
			}
			Map <String, Object> map = new HashMap <String, Object> ();
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = null;
			if(StringUtils.isNotEmpty(type) && type.equals("bargain")){
				 addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "bargain";
			}else{
				 addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "goodsFloor";
			}
			
			Map <String, Object> json_map = new HashMap <String, Object> ();
			Accessory acc = null;
			try
			{
			
				map = CommUtil.saveFileToServer (request , "img" , addFilePathName , "" , null);
				if (!map.get ("fileName").equals (""))
				{
					acc = new Accessory ();
					acc.setName (CommUtil.null2String (map.get ("fileName")));
					acc.setExt (CommUtil.null2String (map.get ("mime")));
					acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
					if(StringUtils.isNotEmpty(type) && type.equals("bargain")){
						acc.setPath (uploadFilePath + "/bargain");
					}else{
						acc.setPath (uploadFilePath + "/goodsFloor");
					}
					acc.setWidth (CommUtil.null2Int (map.get ("width")));
					acc.setHeight (CommUtil.null2Int (map.get ("height")));
					acc.setAddtime (new Date ());
					this.accessoryService.add (acc);
					json_map.put ("acc_id" , acc.getId ());
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			json_map.put ("acc_url" , "upload/bargain/"+acc.getName());
			System.out.println (Json.toJson (json_map , JsonFormat.compact ()));
			goodsfloor.setGfMainPhoto (Json.toJson (json_map , JsonFormat.compact ()));
			this.goodsfloorService.updateByObject (goodsfloor);
			return mv;
		}

	@SecurityMapping(title = "楼层分类删除" , value = "/admin/newGoods/goods_floor_del.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_del.htm" })
	public String goods_floor_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					// GoodsFloor goodsfloor = this.goodsfloorService.getByKey (Long.valueOf
					// (Long.parseLong (id)));
					this.goodsfloorService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:goods_floor_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "楼层分类Ajax更新" , value = "/admin/newGoods/goods_floor_ajax.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_ajax.htm" })
	public void goods_floor_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val = CreateBeanWrapperUtil.createBeanWrapper (GoodsFloorWithBLOBs.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，" + e1.getMessage ());
			}
			this.goodsfloorService.updateByObject (obj);
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

	@SecurityMapping(title = "楼层分类下级加载" , value = "/admin/newGoods/goods_floor_data.htm*" , rtype = "admin" ,
						rname = "分类管理" , rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_data.htm" })
	public ModelAndView goods_floor_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andParentIdEqualTo (Long.parseLong (pid)).andGfMarkEqualTo ("newGoods");
			List <GoodsFloorWithBLOBs> gfs = goodsfloorService.getObjectList (goodsFloorExample);
			mv.addObject ("objs" , gfs);
			mv.addObject ("gfs" , gfs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "楼层模板编辑" , value = "/admin/newGoods/goods_floor_template.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_template.htm" })
	public ModelAndView goods_floor_template (HttpServletRequest request , HttpServletResponse response , String currentPage , String id , String tab)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_template.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andParentIdEqualTo (obj.getId ()).andGfMarkEqualTo ("newGoods");
			obj.setChilds (this.goodsfloorService.getObjectList (goodsFloorExample));
			mv.addObject ("obj" , obj);
			List <Goods> goods = this.gf_tools.generic_goods (obj.getGfListGoods ());
			mv.addObject ("gf_tools" , goods);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("tab" , tab);
			mv.addObject ("url" , CommUtil.getURL (request));
			return mv;
		}

	@SecurityMapping(title = "楼层模板商品分类编辑" , value = "/admin/newGoods/goods_floor_class.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_class.htm" })
	public ModelAndView goods_floor_class (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_class.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClass gc : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
				gc.setChilds (this.goodsClassService.getObjectList (goodsClassExample));
			}
			/*
			 * List<GoodsClass> gcsByJson = this.gf_tools.generic_gf_gc(obj.getGfGcList());
			 * for(int i = 0 ;i<gcsByJson.size();i++) {
			 * goodsClassExample.clear();
			 * goodsClassExample.createCriteria().andParentIdEqualTo(gcsByJson.get(i).getId());
			 * List<GoodsClassWithBLOBs> gcss =
			 * this.goodsClassService.getObjectList(goodsClassExample);
			 * gcsByJson.get(i).setChilds(gcss);
			 * }
			 * mv.addObject("gcsByJson", gcsByJson);
			 */
			mv.addObject ("gcs" , gcs);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "楼层模板商品分类加载" , value = "/admin/newGoods/goods_floor_class_load.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_class_load.htm" })
	public ModelAndView goods_floor_class_load (HttpServletRequest request , HttpServletResponse response , String currentPage , String gc_id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_class_load.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClass gc = this.goodsClassService.getByKey (CommUtil.null2Long (gc_id));
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (goodsClassExample);
			gc.setChilds (gcs);
			mv.addObject ("gc" , gc);
			return mv;
		}

	@SecurityMapping(title = "楼层模板商品分类保存" , value = "/admin/newGoods/goods_floor_class_add.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_class_add.htm" })
	public String goods_floor_class_add (HttpServletRequest request , HttpServletResponse response , String id , String ids , String gf_name)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			obj.setGfName (gf_name);
			List <Map <String, Object>> gf_gc_list = new ArrayList <Map <String, Object>> ();
			String [ ] id_list = ids.split (",pid:");
			for (String t_id : id_list)
			{
				String [ ] c_id_list = t_id.split (",");
				Map <String, Object> map = new HashMap <String, Object> ();
				for (int i = 0 ; i < c_id_list.length ; i++)
				{
					String c_id = c_id_list[i];
					if (c_id.indexOf ("cid") < 0)
						map.put ("pid" , c_id);
					else
					{
						map.put ("gc_id" + i , c_id.substring (4));
					}
				}
				map.put ("gc_count" , Integer.valueOf (c_id_list.length - 1));
				if (!map.get ("pid").toString ().equals (""))
				{
					gf_gc_list.add (map);
				}
			}
			obj.setGfMark ("newGoods");
			obj.setGfGcList (Json.toJson (gf_gc_list , JsonFormat.compact ()));
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + id;
		}

	@SecurityMapping(title = "楼层模板分类商品编辑" , value = "/admin/newGoods/goods_floor_gc_goods.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_gc_goods.htm" })
	public ModelAndView goods_floor_gc_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_gc_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloor obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "楼层模板分类商品保存" , value = "/admin/newGoods/goods_floor_gc_goods_add.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_gc_goods_add.htm" })
	public String goods_floor_gc_goods_add (HttpServletRequest request , HttpServletResponse response , String gf_name , String id , String ids)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			obj.setGfName (gf_name);
			String [ ] id_list = ids.split (",");
			Map <Object, String> map = new HashMap <Object, String> ();
			for (int i = 0 ; i < id_list.length ; i++)
			{
				if (!id_list[i].equals (""))
				{
					map.put ("goods_id" + i , id_list[i]);
				}
			}
			obj.setGfGcGoods (Json.toJson (map , JsonFormat.compact ()));
			obj.setGfMark ("newGoods");
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + obj.getParentId () + "&tab=" + id;
		}

	@SecurityMapping(title = "新品楼层商品添加模版" , value = "/admin/newGoods/goods_floor_list_goods.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_list_goods.htm" })
	public ModelAndView goods_floor_list_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_list_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClassWithBLOBs gc : gcs)
			{
				goodsClassExample.clear ();
				GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
				goodsClassCriteria.andParentIdEqualTo (gc.getId ());
				List <GoodsClassWithBLOBs> childs = this.goodsClassService.getObjectList (goodsClassExample);
				gc.getChilds ().addAll (childs);
			}
			mv.addObject ("gcs" , gcs);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "楼层模板右侧商品列表保存" , value = "/admin/newGoods/goods_floor_list_goods_add.htm*" ,
						rtype = "admin" , rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/goods_floor_list_goods_add.htm" })
	public String goods_floor_list_goods_add (HttpServletRequest request , HttpServletResponse response , String list_title , String id , String ids)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			String [ ] id_list = ids.split (",");
			Map <Object, String> map = new HashMap <Object, String> ();
			for (int i = 0 ; i < id_list.length ; i++)
			{
				if (!id_list[i].equals (""))
				{
					map.put ("goods_id" + i , id_list[i]);
				}
			}
			obj.setGfListGoods (Json.toJson (map , JsonFormat.compact ()));
			obj.setGfMark ("newGoods");
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + obj.getId ();
		}

	@SecurityMapping(title = "楼层模板左下方广告编辑" , value = "/admin/newGoods/goods_floor_left_adv.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_left_adv.htm" })
	public ModelAndView goods_floor_left_adv (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newgoods/goods_floor_left_adv.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloor obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.createCriteria ().andApStatusEqualTo (Integer.valueOf (1)).andApWidthEqualTo (Integer.valueOf (156)).andApTypeEqualTo ("img");
			advertPositionExample.setOrderByClause ("addTime desc");
			List <AdvertPositionWithBLOBs> aps = advertPositionService.getObjectList (advertPositionExample);
			mv.addObject ("aps" , aps);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			return mv;
		}

	@SecurityMapping(title = "楼层模板左下方广告保存" , value = "/admin/newGoods/goods_floor_left_adv_add.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_left_adv_add.htm" })
	public String goods_floor_left_adv_add (HttpServletRequest request , HttpServletResponse response , String type , String id , String adv_url , String adv_id)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			Map <String, Object> map = new HashMap <String, Object> ();
			if (type.equals ("user"))
			{
				String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
				String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "mvert";
				Map <String, Object> json_map = new HashMap <String, Object> ();
				try
				{
					map = CommUtil.saveFileToServer (request , "img" , addFilePathName , "" , null);
					if (!map.get ("fileName").equals (""))
					{
						Accessory acc = new Accessory ();
						acc.setName (CommUtil.null2String (map.get ("fileName")));
						acc.setExt (CommUtil.null2String (map.get ("mime")));
						acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
						acc.setPath (uploadFilePath + "/mvert");
						acc.setWidth (CommUtil.null2Int (map.get ("width")));
						acc.setHeight (CommUtil.null2Int (map.get ("height")));
						acc.setAddtime (new Date ());
						this.accessoryService.add (acc);
						json_map.put ("acc_id" , acc.getId ());
					}
				}
				catch (IOException e)
				{
					log.error (e.getMessage ());
				}
				json_map.put ("acc_url" , adv_url);
				json_map.put ("adv_id" , "");
				System.out.println (Json.toJson (json_map , JsonFormat.compact ()));
				obj.setGfLeftAdv (Json.toJson (json_map , JsonFormat.compact ()));
			}
			if (type.equals ("adv"))
			{
				Map <String, String> json_map = new HashMap <String, String> ();
				json_map.put ("acc_id" , "");
				json_map.put ("acc_url" , "");
				json_map.put ("adv_id" , adv_id);
				System.out.println (Json.toJson (json_map , JsonFormat.compact ()));
				obj.setGfLeftAdv (Json.toJson (json_map , JsonFormat.compact ()));
			}
			obj.setGfMark ("newGoods");
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + obj.getId ();
		}

	@SecurityMapping(title = "楼层模板右下方广告编辑" , value = "/admin/newGoods/goods_floor_right_adv.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_right_adv.htm" })
	public ModelAndView goods_floor_right_adv (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_right_adv.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloor obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.createCriteria ().andApStatusEqualTo (Integer.valueOf (1)).andApWidthEqualTo (Integer.valueOf (205)).andApTypeEqualTo ("img");
			advertPositionExample.setOrderByClause ("addTime desc");
			List <AdvertPositionWithBLOBs> aps = advertPositionService.getObjectList (advertPositionExample);
			/*
			 * Map params = new HashMap();
			 * params.put("ap_status", Integer.valueOf(1));
			 * params.put("ap_width", Integer.valueOf(205));
			 * params.put("ap_type", "img");
			 * List aps = this.advertPositionService
			 * .query(
			 * "select obj from AdvertPosition obj where obj.ap_status=:ap_status and obj.ap_width=:ap_width and obj.ap_type=:ap_type order by obj.addTime desc"
			 * ,
			 * params, -1, -1);
			 */
			mv.addObject ("aps" , aps);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			return mv;
		}

	@SecurityMapping(title = "楼层模板右下方广告保存" , value = "/admin/newGoods/goods_floor_right_adv_add.htm*" ,
						rtype = "admin" , rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/goods_floor_right_adv_add.htm" })
	public String goods_floor_right_adv_add (HttpServletRequest request , HttpServletResponse response , String type , String id , String adv_url , String adv_id)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			Map <String, Object> map = new HashMap <String, Object> ();
			if (type.equals ("user"))
			{
				String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
				String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "mvert";
				Map <String, Object> json_map = new HashMap <String, Object> ();
				try
				{
					map = CommUtil.saveFileToServer (request , "img" , addFilePathName , "" , null);
					if (!map.get ("fileName").equals (""))
					{
						Accessory acc = new Accessory ();
						acc.setName (CommUtil.null2String (map.get ("fileName")));
						acc.setExt (CommUtil.null2String (map.get ("mime")));
						acc.setSize (CommUtil.null2Float (map.get ("fileSize")));
						acc.setPath (uploadFilePath + "/mvert");
						acc.setWidth (CommUtil.null2Int (map.get ("width")));
						acc.setHeight (CommUtil.null2Int (map.get ("height")));
						acc.setAddtime (new Date ());
						this.accessoryService.add (acc);
						json_map.put ("acc_id" , acc.getId ());
					}
				}
				catch (IOException e)
				{
					log.error (e.getMessage ());
				}
				json_map.put ("acc_url" , adv_url);
				json_map.put ("adv_id" , "");
				System.out.println (Json.toJson (json_map , JsonFormat.compact ()));
				obj.setGfRightAdv (Json.toJson (json_map , JsonFormat.compact ()));
			}
			if (type.equals ("adv"))
			{
				Map <String, String> json_map = new HashMap <String, String> ();
				json_map.put ("acc_id" , "");
				json_map.put ("acc_url" , "");
				json_map.put ("adv_id" , adv_id);
				System.out.println (Json.toJson (json_map , JsonFormat.compact ()));
				obj.setGfRightAdv (Json.toJson (json_map , JsonFormat.compact ()));
			}
			obj.setGfMark ("newGoods");
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + obj.getId ();
		}

	@SecurityMapping(title = "楼层模板品牌编辑" , value = "/admin/newGoods/goods_floor_brand.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_brand.htm" })
	public ModelAndView goods_floor_brand (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_brand.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloor obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsBrandExample brandExample = new GoodsBrandExample ();
			brandExample.clear ();
			brandExample.setPageNo (1);
			brandExample.setOrderByClause ("sequence asc");
			Pagination pList = goodsBrandService.getObjectListWithPage (brandExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/admin/newGoods/goods_floor_brand_load.htm" , "" , "" , pList , mv);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			return mv;
		}

	@SecurityMapping(title = "楼层模板品牌保存" , value = "/admin/newGoods/goods_floor_brand_add.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_brand_add.htm" })
	public String goods_floor_brand_add (HttpServletRequest request , HttpServletResponse response , String id , String ids)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			String [ ] id_list = ids.split (",");
			Map <Object, String> map = new HashMap <Object, String> ();
			for (int i = 0 ; i < id_list.length ; i++)
			{
				if (!id_list[i].equals (""))
				{
					map.put ("brand_id" + i , id_list[i]);
				}
			}
			System.out.println (Json.toJson (map , JsonFormat.compact ()));
			obj.setGfMark ("newGoods");
			obj.setGfBrandList (Json.toJson (map , JsonFormat.compact ()));
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_template.htm?id=" + obj.getId ();
		}

	@SecurityMapping(title = "楼层模板品牌加载" , value = "/admin/newGoods/goods_floor_brand_load.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_brand_load.htm" })
	public ModelAndView goods_floor_brand_load (HttpServletRequest request , HttpServletResponse response , String currentPage , String name)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_brand_load.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsBrandExample brandExample = new GoodsBrandExample ();
			brandExample.clear ();
			brandExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			brandExample.setOrderByClause ("sequence asc");
			GoodsBrandExample.Criteria brandCriteria = brandExample.createCriteria ();
			brandCriteria.andAuditEqualTo (1);
			if (!CommUtil.null2String (name).equals (""))
			{
				brandCriteria.andNameLike ("%" + name.trim () + "%");
			}
			Pagination pList = goodsBrandService.getObjectListWithPage (brandExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/admin/newGoods/goods_floor_brand_load.htm" , "" , "&name=" + CommUtil.null2String (name) , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "楼层模板分类商品编辑" , value = "/admin/newGoods/goods_floor_list_goods_load.htm*" ,
						rtype = "admin" , rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/goods_floor_list_goods_load.htm" })
	public ModelAndView goods_floor_list_goods_load (HttpServletRequest request , HttpServletResponse response , String currentPage , String gc_id , String goods_name)
		{
			ModelAndView mv = new JModelAndView ("admin/newGoods/goods_floor_list_goods_load.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause ("addTime desc");
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			if (!CommUtil.null2String (gc_id).equals (""))
			{
				List <Long> ids = genericIds (this.goodsClassService.getByKey (CommUtil.null2Long (gc_id)));
				/*
				 * Map paras = new HashMap();
				 * paras.put("ids", ids);
				 * qo.addQuery("obj.gc.id in (:ids)", paras);
				 */
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andIdIn (ids);
				List <GoodsClassWithBLOBs> goodsClasses = goodsClassService.getObjectList (goodsClassExample);
				List <Long> gcIds = new ArrayList <Long> ();
				for (GoodsClassWithBLOBs goodsClassWithBLOBs : goodsClasses)
				{
					gcIds.add (goodsClassWithBLOBs.getId ());
				}
				goodsCriteria.andGcIdIn (gcIds);
			}
			if (!CommUtil.null2String (goods_name).equals (""))
			{
				/*
				 * qo.addQuery("obj.goods_name", new SysMap("goods_name", "%"
				 * + goods_name + "%"), "like");
				 */
				goodsCriteria.andGoodsNameLike ("%" + goods_name + "%");
			}
			/*
			 * qo.addQuery("obj.goods_status",
			 * new SysMap("goods_status", Integer.valueOf(0)), "=");
			 * IPageList pList = this.goodsService.list(qo);
			 * goodsCriteria.andGoodsStatusEqualTo(Integer.valueOf(0));
			 */
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/admin/newGoods/goods_floor_list_goods_load.htm" , "" , "&gc_id=" + gc_id + "&goods_name=" + goods_name , pList , mv);
			return mv;
		}

	private List <Long> genericIds (GoodsClass gc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (gc.getId ());
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> gcList = this.goodsClassService.getObjectList (goodsClassExample);
			gc.getChilds ().addAll (gcList);
			for (GoodsClass child : gc.getChilds ())
			{
				List <Long> cids = genericIds (child);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
				ids.add (child.getId ());
			}
			return ids;
		}
}
