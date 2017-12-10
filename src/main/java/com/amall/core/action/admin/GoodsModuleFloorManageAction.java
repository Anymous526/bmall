package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Area;
import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.cart.ICart2GspService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoodsModuleFloorNextService;
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
 * Description: 商品模块楼层crud管理
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
public class GoodsModuleFloorManageAction
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

	@Autowired
	private IGoodsModuleFloorNextService goodsModuleFloorNextService;

	@Autowired
	private IAreaService areaService;

	@SecurityMapping(title = "商品模块楼层列表" , value = "/admin/goods_moduleFloor_list.htm*" , rtype = "admin" ,
						rname = "商品模块楼层管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String moduleId , String upCurrentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_moduleFloor_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsModuleFloorExample goodsModuleFloorExample = new GoodsModuleFloorExample ();
			goodsModuleFloorExample.setOrderByClause ("sequence");
			goodsModuleFloorExample.createCriteria ().andModuleIdEqualTo (Integer.parseInt (moduleId));
			goodsModuleFloorExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , GoodsModule.class , mv);
			Pagination pList = goodsModuleFloorService.getObjectListWithPage (goodsModuleFloorExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("moduleId" , moduleId);
			mv.addObject ("upCurrentPage" , upCurrentPage);
			mv.addObject ("storeTools" , this.storeTools);
			return mv;
		}

	@SecurityMapping(title = "商品模块楼层添加" , value = "/admin/goods_moduleFloor_add.htm*" , rtype = "admin" ,
						rname = "模块楼层管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String moduleId , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_moduleFloor_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("moduleId" , moduleId);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "商品模块保存" , value = "/admin/goods_moduleFloor_save.htm*" , rtype = "admin" ,
						rname = "模块管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String add_url , String list_url , String currentPage , String moduleId)
		{
			WebForm wf = new WebForm ();
			GoodsModuleFloor goodsModuleFloor = null;
			if (id.equals (""))
			{
				goodsModuleFloor = (GoodsModuleFloor) wf.toPo (request , GoodsModuleFloor.class);
			}
			else
			{
				GoodsModuleFloor obj = this.goodsModuleFloorService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsModuleFloor = (GoodsModuleFloor) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.goodsModuleFloorService.add (goodsModuleFloor);
			else
				this.goodsModuleFloorService.updateByObject (goodsModuleFloor);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url + "?currentPage=" + currentPage + "&moduleId=" + moduleId);
			mv.addObject ("op_title" , "保存商品模块楼层成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?moduleId=" + moduleId);
			}
			return mv;
		}

	@SecurityMapping(title = "商品模块楼层编辑" , value = "/admin/goods_moduleFloor_edit.htm*" , rtype = "admin" ,
						rname = "模块管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_moduleFloor_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				GoodsModuleFloor goodsmoduleFloor = this.goodsModuleFloorService.getByKey (Long.valueOf (Long.parseLong (id)));
				GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
				gmfne.clear ();
				gmfne.createCriteria ().andFlooridEqualTo (Integer.parseInt (id));
				List <GoodsModuleFloorNext> pros = goodsModuleFloorNextService.getObjectList (gmfne);
				List <Area> areas = new ArrayList <Area> ();
				for (GoodsModuleFloorNext goodsModuleFloorNext : pros)
				{
					Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
					areas.add (area);
				}
				goodsmoduleFloor.setAreas (areas);
				mv.addObject ("moduleId" , goodsmoduleFloor.getModuleId ());
				mv.addObject ("obj" , goodsmoduleFloor);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
				mv.addObject ("shopTools" , this.storeTools);
			}
			return mv;
		}

	@SecurityMapping(title = "商品模块楼层删除" , value = "/admin/goods_moduleFloor_del.htm*" , rtype = "admin" ,
						rname = "模块管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			String moduleId = null;
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsModuleFloor obj = this.goodsModuleFloorService.getByKey (Long.valueOf (Long.parseLong (id)));
					// clearProperty(request, obj);
					moduleId = obj.getModuleId ().toString ();
					this.goodsModuleFloorService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:goods_moduleFloor_list.htm?currentPage=" + currentPage + "&moduleId=" + moduleId;
		}

	@SecurityMapping(title = "商品模块楼层AJAX更新" , value = "/admin/goods_moduleFloor_ajax.htm*" , rtype = "admin" ,
						rname = "模块楼层管理" , rcode = "goods_moduleFloor" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloor_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsModuleFloor obj = this.goodsModuleFloorService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = GoodsModuleFloor.class.getDeclaredFields ();
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
			this.goodsModuleFloorService.updateByObject (obj);
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

	// aJax验证
	@RequestMapping({ "/admin/goods_moduleFloor_verify.htm" })
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
				GoodsModuleFloorExample goodsModuleFloorExample = new GoodsModuleFloorExample ();
				goodsModuleFloorExample.clear ();
				goodsModuleFloorExample.createCriteria ().andFloornameEqualTo (name);
				Integer count = goodsModuleFloorService.getObjectListCount (goodsModuleFloorExample);
				if (count == null || count == 0)
				{
					result = "true";
				}
			}
			return result;
		}
}
