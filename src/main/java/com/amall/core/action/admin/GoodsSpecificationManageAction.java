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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Cart2GspExample;
import com.amall.core.bean.Goods2SpecExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsSpecificationExample;
import com.amall.core.service.cart.ICart2GspService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.image.IAccessoryService;
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
 * Title: GoodsSpecificationManageAction
 * </p>
 * <p>
 * Description: 商品规格crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:57:52
 * @version 1.0
 */
@Controller
public class GoodsSpecificationManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsSpecificationService goodsSpecService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoods2SpecService goods2SpecseService;

	@Autowired
	private ICart2GspService cart2GspService;

	@Autowired
	private StoreTools storeTools;

	@SecurityMapping(title = "商品规格列表" , value = "/admin/goods_spec_list.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_spec_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsSpecificationExample specificationExample = new GoodsSpecificationExample ();
			specificationExample.clear ();
			specificationExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			specificationExample.setOrderByClause ("sequence asc");
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , GoodsSpecification.class , mv);
			Pagination pList = goodsSpecService.getObjectListWithPage (specificationExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("shopTools" , this.storeTools);
			return mv;
		}

	@SecurityMapping(title = "商品规格添加" , value = "/admin/goods_spec_add.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_spec_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: edit
	 * </p>
	 * <p>
	 * Description: 商品规格编辑
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 *            商品规格id
	 * @param currentPage
	 *            当前页码
	 * @return
	 */
	@SecurityMapping(title = "商品规格编辑" , value = "/admin/goods_spec_edit.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_spec_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsSpecification goodsSpecification = this.goodsSpecService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsSpecPropertyExample propertyExample = new GoodsSpecPropertyExample ();
				propertyExample.clear ();
				propertyExample.createCriteria ().andSpecIdEqualTo (Long.parseLong (id));
				List <GoodsSpecProperty> goodsSpecPropertys = goodsSpecPropertyService.getObjectList (propertyExample);
				goodsSpecification.setProperties (goodsSpecPropertys);
				mv.addObject ("obj" , goodsSpecification);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				mv.addObject ("shopTools" , this.storeTools);
			}
			return mv;
		}

	@SecurityMapping(title = "商品规格保存" , value = "/admin/goods_spec_save.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String cmd , String count , String add_url , String list_url , String currentPage)
		{
			WebForm wf = new WebForm ();
			GoodsSpecification goodsSpecification = null;
			if (id.equals (""))
			{
				goodsSpecification = (GoodsSpecification) wf.toPo (request , GoodsSpecification.class);
				goodsSpecification.setAddtime (new Date ());
			}
			else
			{
				GoodsSpecification obj = this.goodsSpecService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsSpecification = (GoodsSpecification) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.goodsSpecService.add (goodsSpecification);
			else
				this.goodsSpecService.updateByObject (goodsSpecification);
			genericProperty (request , goodsSpecification , count);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage);
			mv.addObject ("op_title" , "保存商品规格成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	private void clearProperty (HttpServletRequest request , GoodsSpecification spec)
		{
			for (GoodsSpecProperty property : spec.getProperties ())
			{
				property.setSpec (null);
				Accessory img = property.getSpecImage ();
				CommUtil.del_acc (request , img , this.configService.getSysConfig ().getUploadRootPath ());
				property.setSpecImage (null);
				this.goodsSpecPropertyService.deleteByKey (property.getId ());
			}
		}

	private void genericProperty (HttpServletRequest request , GoodsSpecification spec , String count)
		{
			for (int i = 1 ; i <= CommUtil.null2Int (count) ; i++)
			{
				Integer sequence = Integer.valueOf (CommUtil.null2Int (request.getParameter ("sequence_" + i)));
				String value = CommUtil.null2String (request.getParameter ("value_" + i));
				if ((sequence == null) || (value == null) || (value.equals ("")))
					continue;
				String id = CommUtil.null2String (request.getParameter ("id_" + i));
				GoodsSpecProperty property = null;
				if ((id != null) && (!id.equals ("")))
					property = this.goodsSpecPropertyService.getByKey (Long.valueOf (Long.parseLong (id)));
				else
					property = new GoodsSpecProperty ();
				property.setAddtime (new Date ());
				property.setSequence (sequence.intValue ());
				property.setSpec (spec);
				property.setValue (value);
				String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
				String addFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "spec";
				Map <String, Object> map = new HashMap <String, Object> ();
				try
				{
					String fileName = property.getSpecImage () == null ? "" : property.getSpecImage ().getName ();
					map = CommUtil.saveFileToServer (request , "specImage_" + i , addFilePathName , fileName , null);
					if (fileName.equals (""))
					{
						if (!map.get ("fileName").equals (""))
						{
							Accessory specImage = new Accessory ();
							specImage.setName (CommUtil.null2String (map.get ("fileName")));
							specImage.setExt (CommUtil.null2String (map.get ("mime")));
							specImage.setSize (CommUtil.null2Float (map.get ("fileSize")));
							specImage.setPath (uploadFilePath + "/spec");
							specImage.setWidth (CommUtil.null2Int (map.get ("width")));
							specImage.setHeight (CommUtil.null2Int (map.get ("height")));
							specImage.setAddtime (new Date ());
							this.accessoryService.add (specImage);
							property.setSpecImage (specImage);
						}
					}
					else if (!map.get ("fileName").equals (""))
					{
						Accessory specImage = property.getSpecImage ();
						specImage.setName (CommUtil.null2String (map.get ("fileName")));
						specImage.setExt (CommUtil.null2String (map.get ("mime")));
						specImage.setSize (CommUtil.null2Float (map.get ("fileSize")));
						specImage.setPath (uploadFilePath + "/spec");
						specImage.setWidth (CommUtil.null2Int (map.get ("width")));
						specImage.setHeight (CommUtil.null2Int (map.get ("height")));
						specImage.setAddtime (new Date ());
						this.accessoryService.updateByObject (specImage);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
				if (null != id && !id.equals (""))
				{
					this.goodsSpecPropertyService.updateByObject (property);
				}
				else
				{
					this.goodsSpecPropertyService.add (property);
				}
			}
		}

	@SecurityMapping(title = "商品规格删除" , value = "/admin/goods_spec_del.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsSpecification obj = this.goodsSpecService.getByKey (Long.valueOf (Long.parseLong (id)));
					clearProperty (request , obj);
					this.goodsSpecService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:goods_spec_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "商品规格属性AJAX删除" , value = "/admin/goods_property_delete.htm*" , rtype = "admin" ,
						rname = "规格管理" , rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_property_delete.htm" })
	public void goods_property_delete (HttpServletRequest request , HttpServletResponse response , String id)
		{
			Integer ret = 0;
			if (!id.equals (""))
			{
				Goods2SpecExample goods2SpecExample = new Goods2SpecExample ();
				goods2SpecExample.clear ();
				goods2SpecExample.createCriteria ().andSpecIdEqualTo (Long.parseLong (id));
				goods2SpecseService.deleteByExample (goods2SpecExample);
				Cart2GspExample cart2GspExample = new Cart2GspExample ();
				cart2GspExample.clear ();
				cart2GspExample.createCriteria ().andGspIdEqualTo (Long.parseLong (id));
				cart2GspService.deleteByExample (cart2GspExample);
				GoodsSpecProperty property = this.goodsSpecPropertyService.getByKey (Long.valueOf (Long.parseLong (id)));
				property.setSpecId (Long.valueOf (-1));
				Accessory img = property.getSpecImage ();
				CommUtil.del_acc (request , img , this.configService.getSysConfig ().getUploadRootPath ());
				property.setSpecImage (null);
				ret = this.goodsSpecPropertyService.deleteByKey (property.getId ());
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

	@SecurityMapping(title = "商品规格AJAX更新" , value = "/admin/goods_spec_ajax.htm*" , rtype = "admin" , rname = "规格管理" ,
						rcode = "goods_spec" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_spec_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsSpecification obj = this.goodsSpecService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsSpecification.class.getDeclaredFields ();
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
			this.goodsSpecService.updateByObject (obj);
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

	@RequestMapping({ "/admin/goods_spec_verify.htm" })
	@ResponseBody
	public String goods_spec_verify (HttpServletRequest request , HttpServletResponse response , String name , String id)
		{
			String result = "false";
			GoodsSpecificationExample example = new GoodsSpecificationExample ();
			List <GoodsSpecification> gsps = new ArrayList <GoodsSpecification> ();
			if (name == null || name.equals (""))
			{
				// 参数名字为空,提示不能为空
				result = "nameNull";
			}
			else
			{
				// 参数名字不为空,判断id是否存在,存在,则是编辑状态,不存在则为新增状态
				if (id == null || id.equals (""))
				{
					// 新增状态,判断所有名字
					example.clear ();
					example.createCriteria ().andNameEqualTo (name);
					gsps = this.goodsSpecService.getObjectList (example);
					if (gsps == null || gsps.size () == 0)
					{
						// 集合不存在元素
						result = "true";
					}
				}
				else
				{
					// id不为空,表示为编辑状态
					GoodsSpecification goods = this.goodsSpecService.getByKey (Long.valueOf (id));
					if (name.equals (goods.getName ()))
					{
						// 就是该商品的名字
						result = "true";
					}
					else
					{
						// 不是编辑状态的商品的名字
						example.clear ();
						example.createCriteria ().andNameEqualTo (name);
						gsps = this.goodsSpecService.getObjectList (example);
						if (gsps == null || gsps.size () == 0)
						{
							result = "true";	// 同样的,集合不存在与当前名字重合的元素
						}
					}
				}
			}
			return result;
		}
}
