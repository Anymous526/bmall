package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsFloor;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsFloorTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * Title: BargainFloorManageAction
 * </p>
 * <p>
 * Description: 首页特卖楼层分类crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author wsw
 * @date 2015年6月30日 10:26:13
 * @version 1.0
 */
@Controller
@RequestMapping({ "/admin/bargain" })
public class BargainFloorManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsFloorService goodsfloorService;

	@Autowired
	private GoodsFloorTools gf_tools;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsService goodsService;

	/**
	 * 
	 * @todo 后台特卖楼层
	 * @author wsw
	 * @date 2015年6月30日 下午2:17:56
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@RequestMapping({ "/goods_bargain_list.htm" })
	public ModelAndView goods_bargain_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if (url == null || url.equals (""))
			{
				url = CommUtil.getURL (request);
			}
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfMarkEqualTo ("bargain").andGfLevelEqualTo (Integer.valueOf (0));
			goodsFloorExample.setOrderByClause ("gf_sequence asc");
			goodsFloorExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			Pagination pList = this.goodsfloorService.getObjectListWithPage (goodsFloorExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/bargin/goods_bargain_list.htm" , "" , "" , pList , mv);
			return mv;
		}

	/**
	 * 
	 * @todo 后台特卖楼层添加
	 * @author wsw
	 * @date 2015年6月30日 下午2:18:09
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param pid
	 * @return
	 */
	@RequestMapping({ "/goods_floor_bargain_add.htm" })
	public ModelAndView goods_floor_add (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("bargain");
			List <GoodsFloorWithBLOBs> gfs = this.goodsfloorService.getObjectList (goodsFloorExample);
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

	/**
	 * 
	 * @todo 特卖楼层保存
	 * @author wsw
	 * @date 2015年6月30日 下午2:49:06
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @param pid
	 * @param list_url
	 * @param add_url
	 * @param gf_url
	 * @return
	 */
	@RequestMapping({ "/goods_floor_bargain_save.htm" })
	public ModelAndView goods_floor_bargain_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String pid , String list_url , String add_url , String gf_url)
		{
			WebForm wf = new WebForm ();
			GoodsFloorWithBLOBs gf;
			if (id == null || id.equals (""))
			{
				gf = wf.toPo (request , GoodsFloorWithBLOBs.class);
			}
			else
			{
				GoodsFloorWithBLOBs goodsFloorWithBLOBs = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
				gf = (GoodsFloorWithBLOBs) wf.toPo (request , goodsFloorWithBLOBs);
			}
			gf.setAddtime (new Date ());
			GoodsFloorWithBLOBs parent = this.goodsfloorService.getByKey (CommUtil.null2Long (pid));
			gf.setGfMark ("bargain");
			if (parent != null)
			{
				gf.setParent (parent);
				gf.setGfLevel (parent.getGfLevel () + 1);
				gf.setParentId (CommUtil.null2Long (parent.getId ()));
			}
			Map<String,String> json_map = new HashMap <String, String> ();
			json_map.put ("acc_url" , gf_url);
			gf.setGfMainPhoto (Json.toJson (json_map , JsonFormat.compact ()));
			if (id==null || id.equals (""))
			{
				this.goodsfloorService.add (gf);
			}
			else
			{
				this.goodsfloorService.updateByObject (gf);
			}
			ModelAndView mv = new JModelAndView ("admin/bargain/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存特卖楼层成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	/**
	 * 
	 * @todo 特卖楼层删除
	 * @author wsw
	 * @date 2015年6月30日 下午2:49:17
	 * @return String
	 * @param request
	 * @param response
	 * @param mulitId
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "楼层分类删除" , value = "/admin/bargain/goods_floor_bargain_del.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_del.htm" })
	public String goods_floor_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					GoodsFloor goodsfloor = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.goodsfloorService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:goods_bargain_list.htm?currentPage=" + currentPage;
		}

	/**
	 * 
	 * @todo 特卖楼层编辑
	 * @author wsw
	 * @date 2015年6月30日 下午2:49:44
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "楼层分类编辑" , value = "/admin/bargain/goods_floor_bargain_edit.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_edit.htm" })
	public ModelAndView goods_floor_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsFloorWithBLOBs goodsfloor = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
				goodsFloorExample.clear ();
				goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("bargain");
				List <GoodsFloorWithBLOBs> gfs = goodsfloorService.getObjectList (goodsFloorExample);
				/*
				 * Map<String, Object> map =
				 * this.gf_tools.generic_gfMainPhotoList(goodsfloor.getGfMainPhoto());
				 * mv.addObject("acc_url", map.get("acc_url"));
				 * Accessory accessory = (Accessory) map.get("acc");
				 * String acc_path = accessory.getPath()
				 * + File.separator
				 * + accessory.getName()
				 * + "."
				 * + accessory.getExt();
				 * mv.addObject("acc_path", acc_path);
				 * mv.addObject("acc", accessory);
				 */
				mv.addObject ("gfs" , gfs);
				mv.addObject ("obj" , goodsfloor);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				mv.addObject ("acc_url" , this.gf_tools.generic_gfMainPhotoList (goodsfloor.getGfMainPhoto ()).get ("acc_url"));
			}
			return mv;
		}

	@SecurityMapping(title = "楼层模板编辑" , value = "/admin/bargain/goods_floor_bargain_template.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_template.htm" })
	public ModelAndView goods_floor_template (HttpServletRequest request , HttpServletResponse response , String currentPage , String id , String tab)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_template.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andParentIdEqualTo (obj.getId ()).andGfMarkEqualTo ("bargain");
			obj.setChilds (this.goodsfloorService.getObjectList (goodsFloorExample));
			mv.addObject ("obj" , obj);
//			List <Goods> goods = this.gf_tools.generic_goods (obj.getGfListGoods ());
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("tab" , tab);
			mv.addObject ("url" , CommUtil.getURL (request));
			return mv;
		}

	@SecurityMapping(title = "楼层分类Ajax更新" , value = "/admin/bargain/goods_floor_bargain_ajax.htm*" , rtype = "admin" ,
						rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_ajax.htm" })
	public void goods_floor_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsFloor.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			if (obj != null)
			{
				obj.setGfMark ("bargain");
			}
			Object val = null;
			for (Field field : fields)
			{
				if (field.getName ().equals (fieldName))
				{
					Class <?> clz = Class.forName ("java.lang.String");
					if (field.getType ().getName ().equals ("int"))
					{
						clz = Class.forName ("java.lang.Integer");
					}
					if (field.getType ().getName ().equals ("boolean"))
					{
						clz = Class.forName ("java.lang.Boolean");
					}
					if (!value.equals (""))
						val = BeanUtils.convertType (value , clz);
					else
					{
						val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
					}
					wrapper.setPropertyValue (fieldName , val);
				}
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
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "楼层分类下级加载" , value = "/admin/bargain/goods_floor_bargain_data.htm*" , rtype = "admin" ,
						rname = "分类管理" , rcode = "goods_bargain" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_data.htm" })
	public ModelAndView goods_floor_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andParentIdEqualTo (Long.parseLong (pid)).andGfMarkEqualTo ("bargain");
			List <GoodsFloorWithBLOBs> gfs = this.goodsfloorService.getObjectList (goodsFloorExample);
			mv.addObject ("gfs" , gfs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "新品楼层商品添加模版" , value = "/admin/bargain/goods_floor_bargain_list_goods.htm*" ,
						rtype = "admin" , rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_list_goods.htm" })
	public ModelAndView goods_floor_list_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_list_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClassWithBLOBs g : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdEqualTo (g.getId ());
				g.setChilds (this.goodsClassService.getObjectList (goodsClassExample));
			}
			obj.setGcs (gcs);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("obj" , obj);
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "楼层模板分类商品编辑" , value = "/admin/bargain/goods_floor_bargain_list_goods_load.htm*" ,
						rtype = "admin" , rname = "首页楼层" , rcode = "goods_floor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/goods_floor_bargain_list_goods_load.htm" })
	public ModelAndView goods_floor_list_goods_load (HttpServletRequest request , HttpServletResponse response , String currentPage , String gc_id , String goods_name)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain/goods_floor_bargain_list_goods_load.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause ("addTime desc");
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			if (!CommUtil.null2String (gc_id).equals (""))
			{
				List <Long> ids = genericIds (this.goodsClassService.getByKey (CommUtil.null2Long (gc_id)));
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
				goodsCriteria.andGoodsNameLike ("%" + goods_name + "%");
			}
			Pagination pList = this.goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/admin/bargain/goods_floor_bargain_list_goods_load.htm" , "" , "&gc_id=" + gc_id + "&goods_name=" + goods_name , pList , mv);
			return mv;
		}

	@RequestMapping({ "/goods_floor_bargain_list_goods_add.htm" })
	public String goods_floor_list_goods_add (HttpServletRequest request , HttpServletResponse response , String list_title , String id , String ids)
		{
			GoodsFloorWithBLOBs obj = this.goodsfloorService.getByKey (CommUtil.null2Long (id));
			String [ ] id_list = ids.split (",");
			Map<String,String> map = new HashMap <String, String> ();
			for (int i = 0 ; i < id_list.length ; i++)
			{
				if (!id_list[i].equals (""))
				{
					map.put ("goods_id" + i , id_list[i]);
				}
			}
			obj.setGfListGoods (Json.toJson (map , JsonFormat.compact ()));
			obj.setGfMark ("bargain");
			this.goodsfloorService.updateByObject (obj);
			return "redirect:goods_floor_bargain_template.htm?id=" + obj.getId ();
		}

	private List <Long> genericIds (GoodsClass gc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (gc.getId ());
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
