package com.amall.core.action.admin;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.DeliveryGoods;
import com.amall.core.bean.DeliveryGoodsExample;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.INavigationService;
import com.amall.core.service.delivery.IDeliveryGoodsService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class DeliveryManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IDeliveryGoodsService deliveryGoodsService;

	@Autowired
	private INavigationService navigationService;

	@SecurityMapping(title = "买就送设置" , value = "/admin/set_delivery.htm*" , rtype = "admin" , rname = "买就送" ,
						rcode = "delivery_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_delivery.htm" })
	public ModelAndView set_delivery (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/set_delivery.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "买就送设置保存" , value = "/admin/set_delivery_save.htm*" , rtype = "admin" , rname = "买就送" ,
						rcode = "delivery_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_delivery_save.htm" })
	public ModelAndView set_delivery_save (HttpServletRequest request , HttpServletResponse response , String id)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs sysConfig = null;
			if (id.equals (""))
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , SysConfig.class);
				// sysConfig.setAddTime(new Date());
				sysConfig.setAddtime (new Date ());
			}
			else
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.configService.add (sysConfig);
			else
			{
				this.configService.updateByObject (sysConfig);
			}
			if (sysConfig.getDeliveryStatus () == 1)
			{
				// Map params = new HashMap();
				// params.put("url", "delivery.htm");
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.createCriteria ().andUrlEqualTo ("delivery.htm");
				/*
				 * List navs = this.navigationService.query(
				 * "select obj from Navigation obj where obj.url=:url",
				 * params, -1, -1);
				 */
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				if (navs.size () == 0)
				{
					Navigation nav = new Navigation ();
					// nav.setAddTime(new Date());
					nav.setAddtime (new Date ());
					nav.setDisplay (true);
					nav.setLocation (0);
					// nav.setNew_win(1);
					nav.setNewWin (1);
					nav.setSequence (6);
					// nav.setSysNav(true);
					nav.setSysnav (true);
					nav.setTitle ("买就送");
					nav.setType ("diy");
					nav.setUrl ("delivery.htm");
					// nav.setOriginal_url("delivery.htm");
					nav.setOriginalUrl ("delivery.htm");
					this.navigationService.add (nav);
				}
			}
			else
			{
				/*
				 * Map params = new HashMap();
				 * params.put("url", "delivery.htm");
				 * List<Navigation> navs = this.navigationService.query(
				 * "select obj from Navigation obj where obj.url=:url",
				 * params, -1, -1);
				 */
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.createCriteria ().andUrlEqualTo ("delivery.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				for (Navigation nav : navs)
				{
					this.navigationService.deleteByKey (nav.getId ());
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "买就送设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/set_delivery.htm");
			return mv;
		}

	@SecurityMapping(title = "买就送商品列表" , value = "/admin/delivery_goods_list.htm*" , rtype = "admin" , rname = "买就送" ,
						rcode = "delivery_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/delivery_goods_list.htm" })
	public ModelAndView delivery_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goods_name , String d_status)
		{
			ModelAndView mv = new JModelAndView ("admin/delivery_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			// DeliveryGoodsQueryObject qo = new DeliveryGoodsQueryObject(currentPage,mv, orderBy,
			// orderType);
			DeliveryGoodsExample deliveryGoodsExample = new DeliveryGoodsExample ();
			deliveryGoodsExample.clear ();
			DeliveryGoodsExample.Criteria deliveryGoodsCriteria = deliveryGoodsExample.createCriteria ();
			deliveryGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			deliveryGoodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			if (!CommUtil.null2String (d_status).equals (""))
			{
				deliveryGoodsCriteria.andDStatusEqualTo (Integer.valueOf (CommUtil.null2Int (d_status)));
			}
			if (!CommUtil.null2String (goods_name).equals (""))
			{
				/*
				 * qo.addQuery("obj.d_goods.goods_name", new SysMap("goods_name", "%"
				 * + goods_name.trim() + "goods_name"), "=");
				 */
			}
			// IPageList pList = this.deliveryGoodsService.list(qo);
			Pagination pList = this.deliveryGoodsService.getObjectListWithPage (deliveryGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("d_status" , d_status);
			mv.addObject ("goods_name" , goods_name);
			return mv;
		}

	@SecurityMapping(title = "买就送商品审核" , value = "/admin/delivery_goods_audit.htm*" , rtype = "admin" , rname = "买就送" ,
						rcode = "delivery_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/delivery_goods_audit.htm" })
	public String delivery_goods_audit (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!CommUtil.null2String (id).equals (""))
				{
					DeliveryGoods obj = this.deliveryGoodsService.getByKey (CommUtil.null2Long (id));
					// obj.setD_admin_user(SecurityUserHolder.getCurrentUser());
					obj.setdStatus (1);
					obj.setdAuditTime (new Date ());
					this.deliveryGoodsService.updateByObject (obj);
					/*
					 * Goods goods = obj.getD_goods();
					 * goods.setDeliveryStatus(2);
					 * this.goodsService.updateByObject(goods);
					 */
				}
			}
			return "redirect:delivery_goods_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "买就送拒绝" , value = "/admin/delivery_goods_refuse.htm*" , rtype = "admin" , rname = "买就送" ,
						rcode = "delivery_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/delivery_goods_refuse.htm" })
	public String delivery_goods_refuse (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!CommUtil.null2String (id).equals (""))
				{
					DeliveryGoods obj = this.deliveryGoodsService.getByKey (CommUtil.null2Long (id));
					// obj.setD_admin_user(SecurityUserHolder.getCurrentUser());
					obj.setdStatus (-1);
					obj.setdRefuseTime (new Date ());
					this.deliveryGoodsService.updateByObject (obj);
				}
			}
			return "redirect:delivery_goods_list.htm?currentPage=" + currentPage;
		}
}
