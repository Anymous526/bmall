package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassStaple;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsTypeExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsClassStapleService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsTypeService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

@Controller
public class GoodsClassManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsTypeService goodsTypeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassStapleService goodsClassStapleService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@SecurityMapping(title = "商品分类列表" , value = "/admin/goods_class_list.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_list.htm" })
	public ModelAndView goods_class_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_class_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , GoodsClass.class , mv);
			Pagination pList = goodsClassService.getObjectListWithPage (goodsClassExample);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/admin/goods_class_list.htm" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "商品分类添加" , value = "/admin/goods_class_add.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_add.htm" })
	public ModelAndView goods_class_add (HttpServletRequest request , HttpServletResponse response , String pid , String icon_sys)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_class_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			List <GoodsType> gts = goodsTypeService.getObjectList (new GoodsTypeExample ());
			GoodsClassWithBLOBs parent = null;
			if ((pid != null) && (!pid.equals ("")))
			{
				GoodsClassWithBLOBs obj = new GoodsClassWithBLOBs ();
				parent = this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (pid)));
				obj.setParent (parent);
				obj.setDisplay (true);
				obj.setRecommend (true);
				mv.addObject ("obj" , obj);
			}
			for (GoodsClassWithBLOBs gc : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (gc.getId ()));
				List <GoodsClassWithBLOBs> gcChilds = this.goodsClassService.getObjectList (goodsClassExample);
				for (GoodsClassWithBLOBs g : gcChilds)
				{
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (g.getId ());
					List <GoodsClassWithBLOBs> gcsChildsChilds = this.goodsClassService.getObjectList (goodsClassExample);
					g.setChilds (gcsChildsChilds);
				}
				gc.setChilds (gcChilds);
			}
			GoodsModuleFloorExample example = new GoodsModuleFloorExample ();
			example.clear ();
			example.createCriteria ().andModuleIdEqualTo (Globals.NUBER_FIVE);
			List <GoodsModuleFloor> goodsModuleFloorList = goodsModuleFloorService.getObjectList (example);
			mv.addObject ("gmf" , goodsModuleFloorList);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("gts" , gts);
			return mv;
		}

	@SecurityMapping(title = "商品分类编辑" , value = "/admin/goods_class_edit.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_edit.htm" })
	public ModelAndView goods_class_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_class_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsClass goodsClass = this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , goodsClass);
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andParentIdIsNull ();
				List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
				List <GoodsType> gts = goodsTypeService.getObjectList (new GoodsTypeExample ());
				GoodsModuleFloorExample example = new GoodsModuleFloorExample ();
				example.clear ();
				example.createCriteria ().andModuleIdEqualTo (Globals.NUBER_FIVE);
				List <GoodsModuleFloor> goodsModuleFloorList = goodsModuleFloorService.getObjectList (example);
				mv.addObject ("gmf" , goodsModuleFloorList);
				mv.addObject ("gcs" , gcs);
				mv.addObject ("gts" , gts);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "商品分类保存" , value = "/admin/goods_class_save.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_save.htm" })
	public ModelAndView goods_class_save (HttpServletRequest request , HttpServletResponse response , String id , String pid , String goodsTypeId , String currentPage , String list_url , String add_url , String child_link , String icon_sys , String img_text , String moduleId)
		{
			WebForm wf = new WebForm ();
			GoodsClassWithBLOBs goodsClass = null;
			if (StringUtils.isEmpty (id))
			{
				goodsClass = (GoodsClassWithBLOBs) wf.toPo (request , GoodsClassWithBLOBs.class);
				goodsClass.setAddtime (new Date ());
				goodsClass.setRate(new BigDecimal(Globals.FINANCIAL_GOLD_RATE_TWO));
				goodsClassService.add (goodsClass);
			}
			else
			{
				GoodsClassWithBLOBs obj = this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsClass = (GoodsClassWithBLOBs) wf.toPo (request , obj);
				goodsClassService.updateByObject (goodsClass);
			}
			if (goodsClass.getFirstGcImgId () != null)
			{
				Accessory firstGcImg = this.accessoryService.getByKey (goodsClass.getFirstGcImgId ());
				goodsClass.setFirstGcImg (firstGcImg);
				// 让goodsClass的icon和firstGcImg保持一致
				goodsClass.setIconAccId (goodsClass.getFirstGcImgId ());
				goodsClass.setIconAcc (firstGcImg);
			}
			if (goodsClass.getSecondGcImgId () != null)
			{
				Accessory secondGcImg = this.accessoryService.getByKey (goodsClass.getSecondGcImgId ());
				goodsClass.setSecondGcImg (secondGcImg);
			}
			if (pid != null)
			{
				GoodsClassWithBLOBs parent = this.goodsClassService.getByKey (CommUtil.null2Long (pid));
				if (parent != null)
				{
					goodsClass.setParent (parent);
					goodsClass.setLevel (parent.getLevel () + 1);
				}
			}
			if (moduleId != null && !moduleId.equals (""))
			{
				goodsClass.setModuleId (Long.valueOf (moduleId));
			}
			if (goodsTypeId != null && !goodsTypeId.equals (""))
			{
				GoodsType goodsType = this.goodsTypeService.getByKey (CommUtil.null2Long (goodsTypeId));
				goodsClass.setGoodsType (goodsType);
				List <Long> ids = genericIds (goodsClass);
				if (CommUtil.null2Boolean (child_link))
				{
					for (Long gc_id : ids)
					{
						if (gc_id != null)
						{
							GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (gc_id);
							gc.setGoodstypeId (goodsType.getId ());
							this.goodsClassService.updateByObject (gc);
						}
					}
				}
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "class_icon";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = "";
				if (goodsClass.getIconAcc () != null)
					fileName = goodsClass.getIconAcc ().getName ();
				map = CommUtil.saveFileToServer (request , "gcImg" , saveFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName (CommUtil.null2String (map.get ("fileName")));
						photo.setExt (CommUtil.null2String (map.get ("mime")));
						photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
						photo.setPath (uploadFilePath + "/class_icon");
						photo.setWidth (CommUtil.null2Int (map.get ("width")));
						photo.setHeight (CommUtil.null2Int (map.get ("height")));
						photo.setAddtime (new Date ());
						this.accessoryService.add (photo);
						goodsClass.setIconAcc (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = goodsClass.getIconAcc ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/class_icon");
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					photo.setAddtime (new Date ());
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.goodsClassService.updateByObject (goodsClass);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "保存商品分类成功");
			mv.addObject ("list_url" , list_url);
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?pid=" + pid);
			}
			return mv;
		}

	@SecurityMapping(title = "商品分类下级加载" , value = "/admin/goods_class_data.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_data.htm" })
	public ModelAndView goods_class_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_class_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (Long.valueOf (Long.parseLong (pid)));
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "商品分类Ajax更新" , value = "/admin/goods_class_ajax.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_ajax.htm" })
	public void goods_class_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsClass.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (gc);
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
			this.goodsClassService.updateByObject (gc);
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

	private List <Long> genericIds (GoodsClass gc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (gc.getId ());
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			gc.setChilds (gcs);
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

	@SecurityMapping(title = "商品分类批量推荐" , value = "/admin/goods_class_recommend.htm*" , rtype = "admin" ,
						rname = "分类管理" , rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_recommend.htm" })
	public String goods_class_recommend (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (id)));
					gc.setRecommend (true);
					this.goodsClassService.updateByObject (gc);
				}
			}
			return "redirect:goods_class_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "商品分类批量删除" , value = "/admin/goods_class_del.htm*" , rtype = "admin" , rname = "分类管理" ,
						rcode = "goods_class" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_class_del.htm" })
	public String goods_class_del (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					List <Long> list = genericIds (this.goodsClassService.getByKey (Long.valueOf (Long.parseLong (id))));
					GoodsClassExample goodsClassExample = new GoodsClassExample ();
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andIdIn (list);
					goodsClassExample.setOrderByClause ("level desc");
					List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
					for (GoodsClassWithBLOBs gc : gcs)
					{
						for (GoodsWithBLOBs goods : gc.getGoodsList ())
						{
							goods.setGc (null);
							this.goodsService.updateByObject (goods);
						}
						for (GoodsClassStaple gsc : gc.getGcss ())
						{
							this.goodsClassStapleService.deleteByKey (gsc.getId ());
						}
						GoodsType type = gc.getGoodsType ();
						if (type != null)
						{
							type.getGcs ().remove (gc);
							this.goodsTypeService.updateByObject (type);
						}
						gc.setParentId (Long.valueOf (-1));  // 设置上级外键id 为-1 表示删除
						this.goodsClassService.deleteByKey (gc.getId ());
					}
				}
			}
			return "redirect:goods_class_list.htm?currentPage=" + currentPage;
		}

	@RequestMapping({ "/admin/goods_class_verify.htm" })
	public void goods_class_verify (HttpServletRequest request , HttpServletResponse response , String className , String id , String pid)
		{
			boolean ret = true;
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andClassnameEqualTo (className).andIdEqualTo (CommUtil.null2Long (id)).andParentIdEqualTo (CommUtil.null2Long (pid));
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			if ((gcs != null) && (gcs.size () > 0))
			{
				ret = false;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 
	 * <p>
	 * Title: seller_upload
	 * </p>
	 * <p>
	 * Description:上传图片
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param width
	 * @param height
	 * @return
	 * @throws IOException
	 * @author xpy
	 * @date 2015年8月19日 14:37
	 */
	@RequestMapping(value = "/admin/goods_class_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String seller_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "class_icon";
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
						gg_img.setPath (uploadFilePath + "/class_icon");
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
}
