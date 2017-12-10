package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.SpareGoods;
import com.amall.core.bean.SpareGoodsClass;
import com.amall.core.bean.SpareGoodsClassExample;
import com.amall.core.bean.SpareGoodsExample;
import com.amall.core.bean.SpareGoodsWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.spare.ISpareGoodsClassService;
import com.amall.core.service.spare.ISpareGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class SpareGoodsSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ISpareGoodsService sparegoodsService;

	@Autowired
	private ISpareGoodsClassService sparegoodsclassService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private StoreViewTools storeViewTools;

	@SecurityMapping(title = "闲置商品列表" , value = "/seller/spare_goods.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/spare_goods.htm" })
	public ModelAndView spare_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String type)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/spare_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			SpareGoodsExample spareGoodsExample = new SpareGoodsExample ();
			spareGoodsExample.clear ();
			spareGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			spareGoodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			SpareGoodsExample.Criteria spareGoodsCriteria = spareGoodsExample.createCriteria ();
			spareGoodsCriteria.andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			if ((type != null) && (!type.equals ("")))
			{
				spareGoodsCriteria.andDownEqualTo (Integer.valueOf (CommUtil.null2Int (type)));
				mv.addObject ("type" , type);
			}
			spareGoodsExample.setPageSize (Integer.valueOf (15));
			Pagination pList = sparegoodsService.getObjectListWithPage (spareGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "发布闲置商品" , value = "/seller/add_spare_goods.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/add_spare_goods.htm" })
	public ModelAndView spare_goods_add (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/add_spare_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * Map map = new HashMap();
			 * map.put("level", Integer.valueOf(2));
			 * List level2 = this.sparegoodsclassService
			 * .query("select obj from SpareGoodsClass obj where obj.level=:level order by sequence asc"
			 * ,
			 * map, -1, -1);
			 * List areas = this.areaService.query(
			 * "select obj from Area obj where obj.parent.id is null", null,
			 * -1, -1);
			 */
			SpareGoodsClassExample spareGoodsClassExample = new SpareGoodsClassExample ();
			spareGoodsClassExample.clear ();
			spareGoodsClassExample.setOrderByClause ("sequence asc");
			spareGoodsClassExample.createCriteria ().andLevelEqualTo (Integer.valueOf (2));
			List <SpareGoodsClass> level2 = sparegoodsclassService.getObjectList (spareGoodsClassExample);
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = areaService.getObjectList (areaExample);
			String spare_goods_session = CommUtil.randomString (32);
			request.getSession (false).setAttribute ("spare_goods_session" , spare_goods_session);
			mv.addObject ("spare_goods_session" , spare_goods_session);
			mv.addObject ("imageSuffix" , this.storeViewTools.genericImageSuffix (this.configService.getSysConfig ().getImagesuffix ()));
			mv.addObject ("areas" , areas);
			mv.addObject ("level2" , level2);
			return mv;
		}

	@SecurityMapping(title = "闲置商品信息编辑" , value = "/seller/spare_goods_edit.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/spare_goods_edit.htm" })
	public ModelAndView spare_goods_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = null;
			SpareGoods obj = this.sparegoodsService.getByKey (CommUtil.null2Long (id));
			if (obj.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv = new JModelAndView ("seller/usercenter/add_spare_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				SpareGoodsClassExample spareGoodsClassExample = new SpareGoodsClassExample ();
				spareGoodsClassExample.clear ();
				spareGoodsClassExample.setOrderByClause ("sequence asc");
				spareGoodsClassExample.createCriteria ().andParentIdIsNull ();
				List <SpareGoodsClass> sgcs = sparegoodsclassService.getObjectList (spareGoodsClassExample);
				/*
				 * List sgcs = this.sparegoodsclassService
				 * .query(
				 * "select obj from SpareGoodsClass obj where obj.parent.id is null order by sequence asc"
				 * ,
				 * null, -1, -1);
				 */
				spareGoodsClassExample.clear ();
				spareGoodsClassExample.setOrderByClause ("sequence asc");
				spareGoodsClassExample.createCriteria ().andLevelEqualTo (Integer.valueOf (2));
				List <SpareGoodsClass> level2 = sparegoodsclassService.getObjectList (spareGoodsClassExample);
				/*
				 * Map map = new HashMap();
				 * map.put("level", Integer.valueOf(2));
				 * List level2 = this.sparegoodsclassService
				 * .query(
				 * "select obj from SpareGoodsClass obj where obj.level=:level order by sequence asc"
				 * ,
				 * map, -1, -1);
				 */
				AreaExample areaExample = new AreaExample ();
				areaExample.clear ();
				areaExample.createCriteria ().andParentIdIsNull ();
				List <Area> areas = areaService.getObjectList (areaExample);
				mv.addObject ("obj" , obj);
				mv.addObject ("areas" , areas);
				mv.addObject ("level2" , level2);
				mv.addObject ("sgcs" , sgcs);
				mv.addObject ("imageSuffix" , this.storeViewTools.genericImageSuffix (this.configService.getSysConfig ().getImagesuffix ()));
				String spare_goods_session = CommUtil.randomString (32);
				request.getSession (false).setAttribute ("spare_goods_session" , spare_goods_session);
				mv.addObject ("spare_goods_session" , spare_goods_session);
				mv.addObject ("imagesuffix" , this.storeViewTools.genericImageSuffix (this.configService.getSysConfig ().getImagesuffix ()));
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm");
				mv.addObject ("op_title" , "您所访问的地址不存在!");
			}
			return mv;
		}

	@SecurityMapping(title = "闲置商品信息删除" , value = "/seller/spare_goods_dele.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/spare_goods_dele.htm" })
	public ModelAndView spare_goods_dele (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			SpareGoods obj = this.sparegoodsService.getByKey (CommUtil.null2Long (id));
			if (obj != null)
			{
				if (obj.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
				{
					this.sparegoodsService.deleteByKey (CommUtil.null2Long (id));
					mv.addObject ("op_title" , "删除闲置商品成功!");
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您所访问的地址不存在!");
				}
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm?currentPage=" + currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您所访问的地址不存在!");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "闲置商品下架上架操作" , value = "/seller/spare_goods_updown.htm*" , rtype = "seller" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/spare_goods_updown.htm" })
	public ModelAndView spare_goods_updown (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String type)
		{
			ModelAndView mv = new JModelAndView ("error" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "您所访问的地址不存在!");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm?currentPage=" + currentPage);
			SpareGoodsWithBLOBs obj = this.sparegoodsService.getByKey (CommUtil.null2Long (id));
			if (obj != null)
			{
				if (obj.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
				{
					obj.setDown (CommUtil.null2Int (type));
					this.sparegoodsService.updateByObject (obj);
					mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
					mv.addObject ("op_title" , "操作成功!");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm?currentPage=" + currentPage + "&&type=" + type);
				}
			}
			return mv;
		}

	@SecurityMapping(title = "闲置商品保存" , value = "/seller/spare_goods_save.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/spare_goods_save.htm" })
	public ModelAndView spare_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String class_id , String oldAndnew , String area_id , String img1_id , String img2_id , String img3_id , String img4_id , String img5_id , String main_img_id , String spare_goods_session)
		{
			ModelAndView mv = null;
			String spare_goods_session1 = CommUtil.null2String (request.getSession (false).getAttribute ("spare_goods_session"));
			if (spare_goods_session.equals (spare_goods_session1))
			{
				WebForm wf = new WebForm ();
				SpareGoodsWithBLOBs sparegoods = null;
				SpareGoodsClass goodsClass = this.sparegoodsclassService.getByKey (CommUtil.null2Long (class_id));
				if (id.equals (""))
				{
					sparegoods = (SpareGoodsWithBLOBs) wf.toPo (request , SpareGoodsWithBLOBs.class);
					sparegoods.setAddtime (new Date ());
					sparegoods.setUser (SecurityUserHolder.getCurrentUser ());
				}
				else
				{
					SpareGoods obj = this.sparegoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					sparegoods = (SpareGoodsWithBLOBs) wf.toPo (request , obj);
				}
				Area area = this.areaService.getByKey (CommUtil.null2Long (area_id));
				sparegoods.setArea (area);
				if ((img1_id != null) && (!img1_id.equals ("")))
				{
					Accessory img1 = this.accessoryService.getByKey (CommUtil.null2Long (img1_id));
					sparegoods.setImg1 (img1);
				}
				if ((img2_id != null) && (!img2_id.equals ("")))
				{
					Accessory img2 = this.accessoryService.getByKey (CommUtil.null2Long (img2_id));
					sparegoods.setImg2 (img2);
				}
				if ((img3_id != null) && (!img3_id.equals ("")))
				{
					Accessory img3 = this.accessoryService.getByKey (CommUtil.null2Long (img3_id));
					sparegoods.setImg3 (img3);
				}
				if ((img4_id != null) && (!img4_id.equals ("")))
				{
					Accessory img4 = this.accessoryService.getByKey (CommUtil.null2Long (img4_id));
					sparegoods.setImg4 (img4);
				}
				if ((img5_id != null) && (!img5_id.equals ("")))
				{
					Accessory img5 = this.accessoryService.getByKey (CommUtil.null2Long (img5_id));
					sparegoods.setImg5 (img5);
				}
				if ((main_img_id != null) && (!main_img_id.equals ("")))
				{
					Accessory main_img = this.accessoryService.getByKey (CommUtil.null2Long (main_img_id));
					sparegoods.setMainImg (main_img);
				}
				else
				{
					Accessory img1 = this.accessoryService.getByKey (CommUtil.null2Long (img1_id));
					sparegoods.setMainImg (img1);
				}
				sparegoods.setSpareGoodsClass (goodsClass);
				sparegoods.setOldandnew (CommUtil.null2Int (oldAndnew));
				if (id.equals (""))
					this.sparegoodsService.add (sparegoods);
				else
					this.sparegoodsService.updateByObject (sparegoods);
				mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm?type=0");
				mv.addObject ("op_title" , "闲置商品发布成功!");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/spare_goods.htm");
				mv.addObject ("op_title" , "禁止重复发布商品!");
			}
			request.getSession (false).removeAttribute ("spare_goods_session");
			return mv;
		}

	@SecurityMapping(title = "闲置商品发布页Ajax加载下级地区信息" , value = "/seller/sparegoods_area_data.htm*" , rtype = "seller" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/sparegoods_area_data.htm" })
	public ModelAndView sparegoods_area_data (HttpServletRequest request , HttpServletResponse response , String parent_id , String area_mark)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/sparegoods_area_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (parent_id));
			List <Area> childs = areaService.getObjectList (areaExample);
			if (childs.size () > 0)
			{
				mv.addObject ("childs" , childs);
			}
			if (area_mark.equals ("privence"))
			{
				mv.addObject ("area_mark" , "city");
			}
			if (area_mark.equals ("city"))
			{
				mv.addObject ("area_mark" , "last");
			}
			return mv;
		}

	@RequestMapping({ "/seller/sparegoods_swf_upload.htm" })
	public void sparegoods_swf_upload (HttpServletRequest request , HttpServletResponse response , String special_id)
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "spare_goods";
			Map <String, Object> json_map = new HashMap <String, Object> ();
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = "";
				map = CommUtil.saveFileToServer (request , "imgFile" , saveFilePathName , fileName , null);
				Accessory accessory = new Accessory ();
				accessory.setName (CommUtil.null2String (map.get ("fileName")));
				accessory.setExt (CommUtil.null2String (map.get ("mime")));
				accessory.setSize (CommUtil.null2Float (map.get ("fileSize")));
				accessory.setPath (uploadFilePath + "/spare_goods");
				accessory.setWidth (CommUtil.null2Int (map.get ("width")));
				accessory.setHeight (CommUtil.null2Int (map.get ("height")));
				accessory.setAddtime (new Date ());
				this.accessoryService.add (accessory);
				json_map.put ("url" , accessory.getPath () + "/" + accessory.getName ());
				json_map.put ("id" , accessory.getId ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (json_map));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "图片删除" , value = "/seller/sparegoods_removeimg.htm*" , rtype = "seller" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/sparegoods_removeimg.htm" })
	public void sparegoods_img_dele (HttpServletRequest request , HttpServletResponse response , String count , String sp_id , String img_id)
		{
			SpareGoodsWithBLOBs sp = null;
			Accessory img = this.accessoryService.getByKey (CommUtil.null2Long (img_id));
			if ((sp_id != null) && (!sp_id.equals ("")))
			{
				sp = this.sparegoodsService.getByKey (CommUtil.null2Long (sp_id));
				if ((count.equals ("1")) && (sp.getImg1 () != null))
				{
					sp.setImg1 (null);
				}
				if ((count.equals ("2")) && (sp.getImg2 () != null))
				{
					sp.setImg2 (null);
				}
				if ((count.equals ("3")) && (sp.getImg3 () != null))
				{
					sp.setImg3 (null);
				}
				if ((count.equals ("4")) && (sp.getImg4 () != null))
				{
					sp.setImg4 (null);
				}
				if ((count.equals ("5")) && (sp.getImg5 () != null))
				{
					sp.setImg5 (null);
				}
				this.sparegoodsService.updateByObject (sp);
			}
			int flag = 0;
			flag = this.accessoryService.deleteByKey (img.getId ());
			if (flag > 0)
			{
				CommUtil.del_acc (request , img , this.configService.getSysConfig ().getUploadRootPath ());
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (flag);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
}
