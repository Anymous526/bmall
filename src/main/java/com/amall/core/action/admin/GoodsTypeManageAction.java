package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandCategory;
import com.amall.core.bean.GoodsBrandCategoryExample;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsSpecificationExample;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2Spec;
import com.amall.core.bean.GoodsType2SpecExample;
import com.amall.core.bean.GoodsTypeExample;
import com.amall.core.bean.GoodsTypeProperty;
import com.amall.core.bean.GoodsTypePropertyExample;
import com.amall.core.service.goods.IGoodsBrandCategoryService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.goods.IGoodsType2SpecService;
import com.amall.core.service.goods.IGoodsTypePropertyService;
import com.amall.core.service.goods.IGoodsTypeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * Title: GoodsTypeManageAction
 * </p>
 * <p>
 * Description: 商品类型crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:53:48
 * @version 1.0
 */
@Controller
public class GoodsTypeManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsTypeService goodsTypeService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsBrandCategoryService goodsBrandCategoryService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IGoodsTypePropertyService goodsTypePropertyService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	private IGoodsType2SpecService goodsType2SpecService;

	@Autowired
	private StoreTools shopTools;

	@SecurityMapping(title = "商品类型列表" , value = "/admin/goods_type_list.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_type_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsTypeExample goodsTypeExample = new GoodsTypeExample ();
			goodsTypeExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsTypeExample.setOrderByClause ("sequence asc");
			Pagination pList = goodsTypeService.getObjectListWithPage (goodsTypeExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "商品类型搜索" , value = "/admin/goods_type_search.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_search.htm" })
	public ModelAndView search (HttpServletRequest request , HttpServletResponse response , String searchName , String name , String sequence)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_type_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample ();
			goodsSpecificationExample.clear ();
			goodsSpecificationExample.setOrderByClause ("sequence asc");
			if (searchName != null && !searchName.equals (""))
			{
				goodsSpecificationExample.createCriteria ().andNameLike ("%" + searchName.trim () + "%");
			}
			List <GoodsSpecification> gss = goodsSpecificationService.getObjectList (goodsSpecificationExample);
			mv.addObject ("gss" , gss);
			mv.addObject ("searchName" , searchName);
			// 规格值到工具类中查询和拼接
			mv.addObject ("shopTools" , this.shopTools);
			return mv;
		}

	@SecurityMapping(title = "商品类型添加" , value = "/admin/goods_type_add.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_type_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsBrandCategoryExample goodsBrandCategoryExample = new GoodsBrandCategoryExample ();
			goodsBrandCategoryExample.clear ();
			goodsBrandCategoryExample.setOrderByClause ("sequence asc");
			List <GoodsBrandCategory> gbcs = goodsBrandCategoryService.getObjectList (goodsBrandCategoryExample);
			// 查询品牌
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			for (GoodsBrandCategory goodsBrandCategory : gbcs)
			{
				goodsBrandExample.clear ();
				goodsBrandExample.createCriteria ().andCategoryIdEqualTo (goodsBrandCategory.getId ());
				goodsBrandCategory.setBrands (goodsBrandService.getObjectList (goodsBrandExample));
			}
			GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample ();
			goodsSpecificationExample.clear ();
			goodsSpecificationExample.setOrderByClause ("sequence asc");
			List <GoodsSpecification> gss = goodsSpecificationService.getObjectList (goodsSpecificationExample);
			mv.addObject ("gss" , gss);
			mv.addObject ("gbcs" , gbcs);
			// 规格值到工具类中查询和拼接
			mv.addObject ("shopTools" , this.shopTools);
			return mv;
		}

	@SecurityMapping(title = "商品类型编辑" , value = "/admin/goods_type_edit.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_type_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsType goodsType = this.goodsTypeService.getByKey (Long.valueOf (Long.parseLong (id)));
				// 从中间表中查询商品品牌
				GoodsType2BrandExample gt2be = new GoodsType2BrandExample ();
				gt2be.clear ();
				gt2be.createCriteria ().andTypeIdEqualTo (Long.parseLong (id));
				List <GoodsType2Brand> gt2bs = goodsType2BrandService.getObjectList (gt2be);
				List <GoodsBrand> goodsBrands = new ArrayList <GoodsBrand> ();
				for (GoodsType2Brand goodsType2Brand : gt2bs)
				{
					GoodsBrand goodsBrand = goodsBrandService.getByKey (goodsType2Brand.getBrandId ());
					goodsBrands.add (goodsBrand);
				}
				goodsType.setGbs (goodsBrands);
				// 查询商品类型属性
				GoodsTypePropertyExample gtpExample = new GoodsTypePropertyExample ();
				gtpExample.clear ();
				gtpExample.createCriteria ().andGoodstypeIdEqualTo (Long.parseLong (id));
				List <GoodsTypeProperty> gtps = goodsTypePropertyService.getObjectList (gtpExample);
				goodsType.setProperties (gtps);
				// 查询商品类型
				GoodsClassExample goodsClassExample = new GoodsClassExample ();
				goodsClassExample.clear ();
				goodsClassExample.createCriteria ().andGoodstypeIdEqualTo (Long.parseLong (id));
				List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
				goodsType.setGcs (gcs);
				// 从中间表中查询商品属性
				GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
				goodsType2SpecExample.clear ();
				goodsType2SpecExample.createCriteria ().andTypeIdEqualTo (Long.parseLong (id));
				List <GoodsType2Spec> gt2s = goodsType2SpecService.getObjectList (goodsType2SpecExample);
				List <GoodsSpecification> goodsSpecifications = new ArrayList <GoodsSpecification> ();
				for (GoodsType2Spec goodsType2Spec : gt2s)
				{
					GoodsSpecification goodsSpecification = goodsSpecificationService.getByKey (goodsType2Spec.getSpecId ());
					goodsSpecifications.add (goodsSpecification);
				}
				goodsType.setGss (goodsSpecifications);
				GoodsBrandCategoryExample goodsBrandCategoryExample = new GoodsBrandCategoryExample ();
				goodsBrandCategoryExample.clear ();
				goodsBrandCategoryExample.setOrderByClause ("sequence asc");
				List <GoodsBrandCategory> gbcs = goodsBrandCategoryService.getObjectList (goodsBrandCategoryExample);
				// 查询品牌
				GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
				for (GoodsBrandCategory goodsBrandCategory : gbcs)
				{
					goodsBrandExample.clear ();
					goodsBrandExample.createCriteria ().andCategoryIdEqualTo (goodsBrandCategory.getId ());
					goodsBrandCategory.setBrands (goodsBrandService.getObjectList (goodsBrandExample));
				}
				// 查询规格
				GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample ();
				goodsSpecificationExample.clear ();
				goodsSpecificationExample.setOrderByClause ("sequence asc");
				List <GoodsSpecification> gss = goodsSpecificationService.getObjectList (goodsSpecificationExample);
				mv.addObject ("gss" , gss);
				mv.addObject ("gbcs" , gbcs);
				mv.addObject ("shopTools" , this.shopTools);
				mv.addObject ("obj" , goodsType);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "商品类型保存" , value = "/admin/goods_type_save.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String cmd , String currentPage , String list_url , String add_url , String spec_ids , String brand_ids , String count)
		{
			WebForm wf = new WebForm ();
			GoodsType goodsType = null;
			if (id.equals (""))
			{
				goodsType = (GoodsType) wf.toPo (request , GoodsType.class);
				goodsType.setAddtime (new Date ());
			}
			else
			{
				GoodsType obj = this.goodsTypeService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsType = (GoodsType) wf.toPo (request , obj);
				// 删除中间表数据
				GoodsType2BrandExample goodsType2BrandExample = new GoodsType2BrandExample ();
				goodsType2BrandExample.clear ();
				goodsType2BrandExample.createCriteria ().andTypeIdEqualTo (Long.parseLong (id));
				GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
				goodsType2SpecExample.clear ();
				goodsType2SpecExample.createCriteria ().andTypeIdEqualTo (Long.parseLong (id));
				goodsType2BrandService.deleteByExample (goodsType2BrandExample);
				goodsType2SpecService.deleteByExample (goodsType2SpecExample);
			}
			goodsType.getGss ().clear ();
			goodsType.getGbs ().clear ();
			String [ ] gs_ids = spec_ids.split (",");
			GoodsSpecification gs;
			GoodsType2Spec gt2s = new GoodsType2Spec ();
			for (String gs_id : gs_ids)
			{
				if (!gs_id.equals (""))
				{
					gs = this.goodsSpecificationService.getByKey (Long.valueOf (Long.parseLong (gs_id)));
					goodsType.getGss ().add (gs);
					gt2s.setTypeId (goodsType.getId ());		// 添加数据到中间表
					gt2s.setSpecId (gs.getId ());
					goodsType2SpecService.add (gt2s);
				}
			}
			String [ ] gb_ids = brand_ids.split (",");
			GoodsType2Brand gt2b = new GoodsType2Brand ();
			for (String gb_id : gb_ids)
			{
				if (!gb_id.equals (""))
				{
					GoodsBrand gb = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (gb_id)));
					goodsType.getGbs ().add (gb);
					gt2b.setBrandId (gb.getId ());     // 添加数据到中间表
					gt2b.setTypeId (goodsType.getId ());
					goodsType2BrandService.add (gt2b);
				}
			}
			if (id.equals (""))
				this.goodsTypeService.add (goodsType);
			else
				this.goodsTypeService.updateByObject (goodsType);
			genericProperty (request , goodsType , count);
			Object mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			((ModelAndView) mv).addObject ("list_url" , list_url + "?currentPage=" + currentPage);
			((ModelAndView) mv).addObject ("op_title" , "保存商品类型成功");
			if (add_url != null)
			{
				((ModelAndView) mv).addObject ("add_url" , add_url);
			}
			return (ModelAndView) mv;
		}

	public void genericProperty (HttpServletRequest request , GoodsType type , String count)
		{
			for (int i = 1 ; i <= CommUtil.null2Int (count) ; i++)
			{
				int sequence = CommUtil.null2Int (request.getParameter ("gtp_sequence_" + i));
				String name = CommUtil.null2String (request.getParameter ("gtp_name_" + i));
				String value = CommUtil.null2String (request.getParameter ("gtp_value_" + i));
				boolean display = CommUtil.null2Boolean (request.getParameter ("gtp_display_" + i));
				if ((!name.equals ("")) && (!value.equals ("")))
				{
					GoodsTypeProperty gtp = null;
					String id = CommUtil.null2String (request.getParameter ("gtp_id_" + i));
					if (id.equals (""))
						gtp = new GoodsTypeProperty ();
					else
					{
						gtp = this.goodsTypePropertyService.getByKey (Long.valueOf (Long.parseLong (id)));
					}
					gtp.setAddtime (new Date ());
					gtp.setDisplay (display);
					gtp.setGoodsType (type);
					gtp.setName (name);
					gtp.setSequence (sequence);
					gtp.setValue (value);
					if (id.equals (""))
						this.goodsTypePropertyService.add (gtp);
					else
						this.goodsTypePropertyService.updateByObject (gtp);
				}
			}
		}

	@SecurityMapping(title = "商品类型删除" , value = "/admin/goods_type_del.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			List <Long> goodsTypeIds = new ArrayList <Long> ();
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsType goodsType = this.goodsTypeService.getByKey (Long.valueOf (Long.parseLong (id)));
					goodsType.getGbs ().clear ();
					goodsType.getGss ().clear ();
					goodsTypeIds.add (Long.parseLong (id));
					for (GoodsClassWithBLOBs gc : goodsType.getGcs ())
					{
						gc.setGoodsType (null);
						this.goodsClassService.updateByObject (gc);
					}
					this.goodsTypeService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			// 删除中间表数据
			GoodsType2BrandExample goodsType2BrandExample = new GoodsType2BrandExample ();
			goodsType2BrandExample.clear ();
			goodsType2BrandExample.createCriteria ().andTypeIdIn (goodsTypeIds);
			GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
			goodsType2SpecExample.clear ();
			goodsType2SpecExample.createCriteria ().andTypeIdIn (goodsTypeIds);
			goodsType2BrandService.deleteByExample (goodsType2BrandExample);
			goodsType2SpecService.deleteByExample (goodsType2SpecExample);
			return "redirect:goods_type_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "商品类型属性AJAX删除" , value = "/admin/goods_type_property_delete.htm*" , rtype = "admin" ,
						rname = "类型管理" , rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_property_delete.htm" })
	public void goods_type_property_delete (HttpServletRequest request , HttpServletResponse response , String id)
		{
			Integer ret = null;
			if (!id.equals (""))
			{
				GoodsTypeProperty property = this.goodsTypePropertyService.getByKey (Long.valueOf (Long.parseLong (id)));
				property.setGoodstypeId (null);
				ret = this.goodsTypePropertyService.deleteByKey (property.getId ());
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

	@SecurityMapping(title = "商品类型AJAX更新" , value = "/admin/goods_type_ajax.htm*" , rtype = "admin" , rname = "类型管理" ,
						rcode = "goods_type" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_type_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsType obj = this.goodsTypeService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsType.class.getDeclaredFields ();
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
			this.goodsTypeService.updateByObject (obj);
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

	@RequestMapping({ "/admin/goods_type_verify.htm" })
	public void goods_type_verify (HttpServletRequest request , HttpServletResponse response , String name , String id , String edit)
		{
			boolean ret = true;
			if (StringUtils.isEmpty (edit))
			{
				GoodsTypeExample goodsTypeExample = new GoodsTypeExample ();
				goodsTypeExample.clear ();
				goodsTypeExample.createCriteria ().andNameEqualTo (name).andIdEqualTo (CommUtil.null2Long (id));
				List <GoodsType> gts = goodsTypeService.getObjectList (goodsTypeExample);
				if ((gts != null) && (gts.size () > 0))
				{
					ret = false;
				}
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
}
