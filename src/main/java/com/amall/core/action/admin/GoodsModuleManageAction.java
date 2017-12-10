package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleExample;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.service.cart.ICart2GspService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsModuleService;
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
 * Title: GoodsModuleManageAction
 * </p>
 * <p>
 * Description: 商品模块crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ygq
 * @date 2016-2-27下午11:36:52
 * @version 1.0
 */
@Controller
public class GoodsModuleManageAction
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

	@Autowired
	private IGoodsModuleService goodsModuleService;

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@SecurityMapping(title = "商品模块列表" , value = "/admin/goods_module_list.htm*" , rtype = "admin" , rname = "商品模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_module_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsModuleExample goodsModuleExample = new GoodsModuleExample ();
			goodsModuleExample.clear ();
			goodsModuleExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsModuleExample.setPageSize (6);
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , GoodsModule.class , mv);
			Pagination pList = goodsModuleService.getObjectListWithPage (goodsModuleExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("storeTools" , this.storeTools);
			return mv;
		}

	@SecurityMapping(title = "商品模块添加" , value = "/admin/goods_module_add.htm*" , rtype = "admin" , rname = "模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String name , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_module_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "商品模块编辑" , value = "/admin/goods_module_edit.htm*" , rtype = "admin" , rname = "模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_module_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsModule goodsModule = this.goodsModuleService.getByKey (Long.valueOf (Long.parseLong (id)));
				/*
				 * GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample();
				 * floorExample.clear();
				 * floorExample.createCriteria().andModuleIdEqualTo(Integer.parseInt(id));
				 * List<GoodsModuleFloor> goodsFloors =
				 * goodsModuleFloorService.getObjectList(floorExample);
				 * goodsModule.setFloors(goodsFloors);
				 */
				mv.addObject ("obj" , goodsModule);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				mv.addObject ("shopTools" , this.storeTools);
			}
			return mv;
		}

	@SecurityMapping(title = "商品模块保存" , value = "/admin/goods_module_save.htm*" , rtype = "admin" , rname = "模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String count , String add_url , String list_url , String currentPage)
		{
			WebForm wf = new WebForm ();
			GoodsModule goodsModule = null;
			if (id.equals (""))
			{
				goodsModule = (GoodsModule) wf.toPo (request , GoodsModule.class);
			}
			else
			{
				GoodsModule obj = this.goodsModuleService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsModule = (GoodsModule) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.goodsModuleService.add (goodsModule);
			else
				this.goodsModuleService.updateByObject (goodsModule);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage);
			mv.addObject ("op_title" , "保存商品模块成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "商品模块删除" , value = "/admin/goods_module_del.htm*" , rtype = "admin" , rname = "模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsModule obj = this.goodsModuleService.getByKey (Long.valueOf (Long.parseLong (id)));
					clearProperty (request , obj);
					this.goodsModuleService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:goods_module_list.htm?currentPage=" + currentPage;
		}

	private void clearProperty (HttpServletRequest request , GoodsModule module)
		{
			GoodsModuleFloorExample floorExample = new GoodsModuleFloorExample ();
			floorExample.clear ();
			floorExample.createCriteria ().andModuleIdEqualTo (module.getId ());
			List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (floorExample);
			for (GoodsModuleFloor goodsModuleFloor : floorList)
			{
				System.out.println (goodsModuleFloor.getFloorname ());
				goodsModuleFloorService.deleteByKey (Long.valueOf (goodsModuleFloor.getId ()));
			}
		}

	@SecurityMapping(title = "商品模块AJAX更新" , value = "/admin/goods_module_ajax.htm*" , rtype = "admin" , rname = "模块管理" ,
						rcode = "goods_module" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_module_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsModule obj = this.goodsModuleService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsModule.class.getDeclaredFields ();
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
			this.goodsModuleService.updateByObject (obj);
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

	// aJax添加验证
	@RequestMapping({ "/admin/goods_module_verify.htm" })
	@ResponseBody
	public String goods_spec_verify (HttpServletRequest request , HttpServletResponse response , String name)
		{
			String result = "false";
			if (name == null || "".equals (name))
			{
				// 参数名字为空,提示不能为空
				result = "nameNull";
			}
			else
			{
				GoodsModuleExample goodsModuleExample = new GoodsModuleExample ();
				goodsModuleExample.clear ();
				goodsModuleExample.createCriteria ().andModulenameEqualTo (name);
				Integer count = goodsModuleService.getObjectListCount (goodsModuleExample);
				if (count == null || count == 0)
				{
					result = "true";
				}
			}
			return result;
		}
}
