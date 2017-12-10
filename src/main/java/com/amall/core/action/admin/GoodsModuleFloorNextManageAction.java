package com.amall.core.action.admin;

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
import com.amall.core.bean.AreaExample;
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
import com.amall.core.web.tools.StoreTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GoodsModuleManageAction
 * </p>
 * <p>
 * Description: 商品模块楼层下一级crud管理
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
public class GoodsModuleFloorNextManageAction
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

	@SecurityMapping(title = "商品模块楼层省级列表" , value = "/admin/goods_moduleFloorNext_list.htm*" , rtype = "admin" ,
						rname = "商品模块楼层管理" , rcode = "goods_moduleFloorNext" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloorNext_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String floorId , String moduleId)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_moduleFloorNext_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
			gmfne.clear ();
			gmfne.createCriteria ().andFlooridEqualTo (Integer.parseInt (floorId));
			List <GoodsModuleFloorNext> nList = goodsModuleFloorNextService.getObjectList (gmfne);
			List <Area> areas = new ArrayList <Area> ();
			for (GoodsModuleFloorNext gmfn : nList)
			{
				Area area = areaService.getByKey (Long.valueOf (gmfn.getAreaid ()));
				areas.add (area);
			}
			mv.addObject ("objs" , areas);
			mv.addObject ("floorId" , floorId);
			mv.addObject ("moduleId" , moduleId);
			return mv;
		}

	@SecurityMapping(title = "商品模块楼层省份添加" , value = "/admin/goods_moduleFloorNext_add.htm*" , rtype = "admin" ,
						rname = "模块楼层管理" , rcode = "goods_moduleFloorNext" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloorNext_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String moduleId , String floorId)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_moduleFloorNext_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("moduleId" , moduleId);
			mv.addObject ("floorId" , floorId);
			return mv;
		}

	@SecurityMapping(title = "商品模块保存" , value = "/admin/goods_moduleFloorNext_save.htm*" , rtype = "admin" ,
						rname = "模块管理" , rcode = "goods_moduleFloorNext" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloorNext_save.htm" })
	public String save (HttpServletRequest request , HttpServletResponse response , String id , String areaname , String add_url , String list_url , String currentPage , String moduleId , String floorId)
		{
			AreaExample ae = new AreaExample ();
			ae.clear ();
			ae.createCriteria ().andAreanameEqualTo (areaname);
			List <Area> areas = areaService.getObjectList (ae);
			Long areaId = areas.get (0).getId ();
			GoodsModuleFloorNext gmfn = new GoodsModuleFloorNext ();
			gmfn.setAreaid (areaId.intValue ());
			gmfn.setFloorid (Integer.parseInt (floorId));
			goodsModuleFloorNextService.add (gmfn);
			return "redirect:/admin/goods_moduleFloorNext_list.htm?floorId=" + floorId + "&moduleId=" + moduleId;
		}

	@SecurityMapping(title = "商品模块楼层删除" , value = "/admin/goods_moduleFloorNext_del.htm*" , rtype = "admin" ,
						rname = "模块管理" , rcode = "goods_moduleFloorNext" , rgroup = "商品" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/goods_moduleFloorNext_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String floorId , String moduleId)
		{
			GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
			gmfne.clear ();
			gmfne.createCriteria ().andAreaidEqualTo (Integer.parseInt (mulitId));
			goodsModuleFloorNextService.deleteByExample (gmfne);
			return "redirect:/admin/goods_moduleFloorNext_list.htm?floorId=" + floorId + "&moduleId=" + moduleId;
		}

	// ajax验证
	@RequestMapping({ "/admin/goods_moduleFloorNext_verify.htm" })
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
				AreaExample ae = new AreaExample ();
				ae.clear ();
				ae.createCriteria ().andAreanameEqualTo (name).andLevelEqualTo (1);// 区域等级为1
				Integer count = areaService.getObjectListCount (ae);
				if (count != null && count > 0)
				{
					GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
					GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
					gmfe.clear ();
					gmfe.createCriteria ().andModuleIdEqualTo (1);// 查询土特产内所有省份
					List <GoodsModuleFloor> floors = goodsModuleFloorService.getObjectList (gmfe);
					List <String> areanames = new ArrayList <String> ();
					for (GoodsModuleFloor goodsModuleFloor : floors)
					{
						gmfne.clear ();
						gmfne.createCriteria ().andFlooridEqualTo (goodsModuleFloor.getId ());
						List <GoodsModuleFloorNext> nextList = goodsModuleFloorNextService.getObjectList (gmfne);
						for (GoodsModuleFloorNext goodsModuleFloorNext : nextList)
						{
							Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
							areanames.add (area.getAreaname ());
						}
					}
					if (!areanames.contains (name))
					{
						result = "true";
					}
				}
			}
			return result;
		}
}
