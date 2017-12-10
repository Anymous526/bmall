package com.amall.core.action.admin;

import java.io.File;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandCategory;
import com.amall.core.bean.GoodsBrandCategoryExample;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.service.goods.IGoodsBrandCategoryService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * Title: _GoodsBrandManageAction
 * </p>
 * <p>
 * Description: 商品品牌crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午10:51:18
 * @version 1.0
 */
@Controller
public class GoodsBrandManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsBrandCategoryService goodsBrandCategoryService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsBrandCategoryService goodsbrandCategoryService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	/**
	 * 后台商品分类加载
	 * 
	 * @Title: loadGoodsClass
	 * @Description: 
	 * @param request
	 * @param response
	 * @param pid
	 * @return void
	 * @author guoxiangjun
	 * @date 2015年8月17日 下午4:12:52
	 */
	@RequestMapping({ "/admin/load_goods_class.htm" })
	public void loadGoodsClass (HttpServletRequest request , HttpServletResponse response , Long pid)
		{
			GoodsClassExample exa = new GoodsClassExample ();
			exa.clear ();
			exa.createCriteria ().andParentIdEqualTo (pid).andDeletestatusEqualTo (false);
			List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (exa);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (gcs));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "商品品牌列表" , value = "/admin/goods_brand_list.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String name , String category)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_brand_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsBrandExample brandExample = new GoodsBrandExample ();
			brandExample.clear ();
			brandExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			brandExample.setOrderByClause ("sequence asc");
			GoodsBrandExample.Criteria brandCriteria = brandExample.createCriteria ();
			// brandCriteria.andAuditEqualTo(Boolean.valueOf(true));
			if (!CommUtil.null2String (name).equals (""))
			{
				brandCriteria.andNameLike ("%" + name.trim () + "%");
			}
			if (!CommUtil.null2String (category).equals (""))
			{
				GoodsBrandCategoryExample brandCategoryExample = new GoodsBrandCategoryExample ();
				brandCategoryExample.clear ();
				brandCategoryExample.createCriteria ().andNameLike ("%" + category.trim () + "%");
				List <GoodsBrandCategory> goodsbrands = goodsbrandCategoryService.getObjectList (brandCategoryExample);
				List <Long> ids = new ArrayList <Long> ();
				for (GoodsBrandCategory goodsBrandCategory : goodsbrands)
				{
					ids.add (goodsBrandCategory.getId ());
				}
				if (ids != null && ids.size () > 0)
				{
					brandCriteria.andCategoryIdIn (ids);
				}
				else
				{
					brandCriteria.andCategoryIdIsNull ();
				}
			}
			Pagination pList = goodsBrandService.getObjectListWithPage (brandExample);
			for (Object obj : pList.getList ())
			{
				GoodsBrand gb = (GoodsBrand) obj;
				GoodsType2BrandExample exa = new GoodsType2BrandExample ();
				exa.clear ();
				exa.createCriteria ().andBrandIdEqualTo (gb.getId ());
				List <GoodsType2Brand> type2Brands = this.goodsType2BrandService.getObjectList (exa);
				String classNames = "";
				for (GoodsType2Brand tb : type2Brands)
				{
					GoodsClass gc = this.goodsClassService.getByKey (tb.getTypeId ());
					if (gc != null)
					{
						classNames += gc.getClassname () + "|";
					}
				}
				GoodsBrandCategory cate = new GoodsBrandCategory ();
				cate.setName (classNames.equals ("") ? classNames : classNames.substring (0 , classNames.lastIndexOf ("|")));
				gb.setCategory (cate);
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("name" , name);
			mv.addObject ("category" , category);
			return mv;
		}

	@SecurityMapping(title = "商品品牌待审核列表" , value = "/admin/goods_brand_audit.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_audit.htm" })
	public ModelAndView audit (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String name , String category)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_brand_audit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsBrandExample brandExample = new GoodsBrandExample ();
			brandExample.clear ();
			brandExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			brandExample.setOrderByClause ("sequence asc");
			GoodsBrandExample.Criteria brandCriteria = brandExample.createCriteria ();
			brandCriteria.andAuditEqualTo (0).andUserstatusEqualTo (Integer.valueOf (1));
			if (!CommUtil.null2String (name).equals (""))
			{
				brandCriteria.andNameLike ("%" + name.trim () + "%");
			}
			if (!CommUtil.null2String (category).equals (""))
			{
				GoodsBrandCategoryExample brandCategoryExample = new GoodsBrandCategoryExample ();
				brandCategoryExample.clear ();
				brandCategoryExample.createCriteria ().andNameLike ("%" + category.trim () + "%");
				List <GoodsBrandCategory> goodsbrands = goodsbrandCategoryService.getObjectList (brandCategoryExample);
				List <Long> ids = new ArrayList <Long> ();
				for (GoodsBrandCategory goodsBrandCategory : goodsbrands)
				{
					ids.add (goodsBrandCategory.getId ());
				}
				if (null!=ids && ids.size ()>0)
				{
					brandCriteria.andCategoryIdIn (ids);
				}
				else
				{
					brandCriteria.andCategoryIdIsNull ();
				}
			}
			Pagination pList = goodsBrandService.getObjectListWithPage (brandExample);
			for (Object obj : pList.getList ())
			{
				GoodsBrand gb = (GoodsBrand) obj;
				GoodsType2BrandExample exa = new GoodsType2BrandExample ();
				exa.clear ();
				exa.createCriteria ().andBrandIdEqualTo (gb.getId ());
				List <GoodsType2Brand> type2Brands = this.goodsType2BrandService.getObjectList (exa);
				String classNames = "";
				for (GoodsType2Brand tb : type2Brands)
				{
					GoodsClass gc = this.goodsClassService.getByKey (tb.getTypeId ());
					if (gc != null)
					{
						classNames += gc.getClassname () + "|";
					}
				}
				GoodsBrandCategory cate = new GoodsBrandCategory ();
				cate.setName (classNames.equals ("") ? classNames : classNames.substring (0 , classNames.lastIndexOf ("|")));
				gb.setCategory (cate);
			}
			CommUtil.addIPageList2ModelAndView ("/admin/goods_brand_audit.htm" , "" , "" , pList , mv);
			mv.addObject ("name" , name);
			mv.addObject ("category" , category);
			return mv;
		}

	@SecurityMapping(title = "商品品牌审核通过" , value = "/admin/goods_brands_pass.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brands_pass.htm" })
	public String goods_brands_pass (HttpServletRequest request , String id)
		{
			if (!id.equals (""))
			{
				GoodsBrand goodsBrand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsBrand.setAudit (1);
				this.goodsBrandService.updateByObject (goodsBrand);
			}
			return "redirect:goods_brand_audit.htm";
		}

	@SecurityMapping(title = "商品品牌审核拒绝" , value = "/admin/goods_brands_refuse.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brands_refuse.htm" })
	public String goods_brands_refuse (HttpServletRequest request , String id)
		{
			if (!id.equals (""))
			{
				GoodsBrand goodsBrand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsBrand.setAudit (2);
				this.goodsBrandService.updateByObject (goodsBrand);
			}
			return "redirect:goods_brand_audit.htm";
		}

	@SecurityMapping(title = "商品品牌添加" , value = "/admin/goods_brand_add.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_brand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDeletestatusEqualTo (false);
			;
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			List <GoodsBrandCategory> categorys = goodsBrandCategoryService.getObjectList (new GoodsBrandCategoryExample ());
			mv.addObject ("gcs" , gcs);
			mv.addObject ("categorys" , categorys);
			return mv;
		}

	@SecurityMapping(title = "商品品牌编辑" , value = "/admin/goods_brand_edit.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_brand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDeletestatusEqualTo (false);
			;
			goodsClassExample.setOrderByClause ("sequence asc");
			List<GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsBrand goodsBrand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsType2BrandExample exa = new GoodsType2BrandExample ();
				exa.clear ();
				exa.createCriteria ().andBrandIdEqualTo (Long.valueOf (id));
				List <GoodsType2Brand> type2Brands = this.goodsType2BrandService.getObjectList (exa);
				String classNames = "";
				String classIds = "";
				for (GoodsType2Brand tb : type2Brands)
				{
					GoodsClass gc = this.goodsClassService.getByKey (tb.getTypeId ());
					classNames += gc.getClassname () + "|";
					classIds += gc.getId () + "|";
				}
				if (!classNames.equals (""))
				{
					mv.addObject ("classNames" , classNames.substring (0 , classNames.lastIndexOf ("|")));
					mv.addObject ("classIds" , classIds.substring (0 , classIds.lastIndexOf ("|")));
				}
				mv.addObject ("gcs" , gcs);
				mv.addObject ("obj" , goodsBrand);
			}
			List <GoodsBrandCategory> categorys = goodsBrandCategoryService.getObjectList (new GoodsBrandCategoryExample ());
			mv.addObject ("categorys" , categorys);
			mv.addObject ("edit" , Boolean.valueOf (true));
			return mv;
		}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param cmd
	 *            动作 save
	 * @param cat_name
	 *            类别名称
	 * @param list_url
	 * @param add_url
	 * @return
	 */
	@SecurityMapping(title = "商品品牌保存" , value = "/admin/goods_band_save.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_band_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String cmd , String goodsClassId , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			GoodsBrand goodsBrand = null;
			if (id.equals (""))
			{
				goodsBrand = (GoodsBrand) wf.toPo (request , GoodsBrand.class);
				goodsBrand.setAddtime (new Date ());
				goodsBrand.setAudit (0);
				goodsBrand.setUserstatus (0);
			}
			else
			{
				GoodsBrand obj = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsBrand = (GoodsBrand) wf.toPo (request , obj);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "brand";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = goodsBrand.getBrandLogo () == null ? "" : goodsBrand.getBrandLogo ().getName ();
				map = CommUtil.saveFileToServer (request , "brandLogo" , addFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName (CommUtil.null2String (map.get ("fileName")));
						photo.setExt (CommUtil.null2String (map.get ("mime")));
						photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
						photo.setPath (uploadFilePath + "/brand");
						photo.setWidth (CommUtil.null2Int (map.get ("width")));
						photo.setHeight (CommUtil.null2Int (map.get ("height")));
						photo.setAddtime (new Date ());
						this.accessoryService.add (photo);
						goodsBrand.setBrandLogo (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = goodsBrand.getBrandLogo ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/brand");
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
			if (id.equals (""))
			{
				this.goodsBrandService.add (goodsBrand);
			}
			else
			{
				GoodsType2BrandExample exa = new GoodsType2BrandExample ();
				exa.clear ();
				exa.createCriteria ().andBrandIdEqualTo (Long.valueOf (id));
				this.goodsType2BrandService.deleteByExample (exa);
			}
			GoodsType2Brand goodsType2Brand = null;
			if (goodsClassId != null && !goodsClassId.equals (""))
			{
				String [ ] ids = goodsClassId.split ("\\|");
				for (String s : ids)
				{
					goodsType2Brand = new GoodsType2Brand ();
					goodsType2Brand.setBrandId (goodsBrand.getId ());
					goodsType2Brand.setTypeId (Long.valueOf (s));
					this.goodsType2BrandService.add (goodsType2Brand);
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存品牌成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "商品品牌删除" , value = "/admin/goods_brand_del.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String audit , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsBrand brand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
					CommUtil.del_acc (request , brand.getBrandLogo () , this.configService.getSysConfig ().getUploadRootPath ());
					accessoryService.deleteByKey (brand.getBrandlogoId ());      // 删除图片信息
					for (GoodsWithBLOBs goods : brand.getGoodsList ())
					{
						goods.setGoodsBrand (null);
						this.goodsService.updateByObject (goods);
					}
					for (GoodsType type : brand.getTypes ())
					{
						type.getGbs ().remove (brand);
					}
					this.goodsBrandService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			String returnUrl = "redirect:goods_brand_list.htm?currentPage=" + currentPage;
			if ((audit != null) && (!audit.equals ("")))
			{
				returnUrl = "redirect:goods_brand_audit.htm?currentPage=" + currentPage;
			}
			return returnUrl;
		}

	@SecurityMapping(title = "商品品牌AJAX更新" , value = "/admin/goods_brand_ajax.htm*" , rtype = "admin" , rname = "品牌管理" ,
						rcode = "goods_brand" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_brand_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsBrand obj = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsBrand.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
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
			this.goodsBrandService.updateByObject (obj);
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

	/**
	 * 商品品牌名称校验
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param id
	 */
	@RequestMapping({ "/admin/goods_brand_verify.htm" })
	@ResponseBody
	public String goods_brand_verify (HttpServletRequest request , HttpServletResponse response , String name , String mark , String id)
		{
			String result = "false";
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			List <GoodsBrand> brands = new ArrayList <GoodsBrand> ();
			if (name == null || name.equals (""))
			{
				return "nameNull";
			}
			if (mark == null || mark.equals (""))
			{
				// 当mark为空的时候.表示,是添加页面,需要判断所有的名字
				goodsBrandExample.clear ();
				goodsBrandExample.createCriteria ().andNameEqualTo (name);	// 直接判断所有的名字
				brands = this.goodsBrandService.getObjectList (goodsBrandExample);
				if (brands != null && brands.size () > 0)
				{
					// 当品牌不为空,且长度大于0 ,则已经存在该品牌了
					result = "false";
				}
				else
				{
					result = "true";
				}
			}
			else
			{
				// 当mark不为空,即为修改页面,需要判断除当前名字之外的所有名字
				if (id != null && !id.equals (""))
				{
					GoodsBrand b = this.goodsBrandService.getByKey (Long.parseLong (id));
					//  b是一定存在的 需要进行判断的是当前的名称与该id对应的对象名是否重合 ,再分步判断名称是否与数据库内名称重复
					// 拿出所有的名字进行遍历
					if (b != null)
					{
						if (b.getName ().equals (name))
						{
							// 传入的为编辑的商品对象
							goodsBrandExample.clear ();
							brands = this.goodsBrandService.getObjectList (goodsBrandExample);
							for (GoodsBrand gb : brands)
							{
								if (b.getName ().equals (gb.getName ()))
								{
									result = "true";	// 传入的品牌名字的判断
									break;
								}
								else if (name.equals (gb.getName ()))
								{
									// 当前输入的名字的判断
									result = "false";
									break;
								}
							}
						}
						else
						{	// 传入的name不是编辑时的name
							goodsBrandExample.clear ();
							goodsBrandExample.createCriteria ().andNameEqualTo (name);	// 直接判断所有的名字
							brands = this.goodsBrandService.getObjectList (goodsBrandExample);
							if (brands != null && brands.size () > 0)
							{
								// 当品牌不为空,且长度大于0 ,则已经存在该品牌了
								result = "false";
							}
							else
							{
								result = "true";
							}
						}
					}
				}
			}
			return result;
		}
}
