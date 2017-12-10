package com.amall.core.action.buyer;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Address;
import com.amall.core.bean.AddressExample;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : AddressBuyerAction
 *
 * Description : 用户地址
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:43:51
 *
 */
@Controller
public class AddressBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserService userService;

	/**
	 * @todo 收货地址列表。
	 * @author wsw
	 * @date 2015年6月6日 下午6:14:17
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SecurityMapping(title = "收货地址列表" , value = "/buyer/buyer_addressList.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_addressList.htm" })
	public ModelAndView address (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_addressList.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if (url == null || url.equals (""))
			{
				url = CommUtil.getURL (request);
			}
			AddressExample addressExample = new AddressExample ();
			addressExample.clear ();
			addressExample.setPageSize (3);
			addressExample.setPageNo (CommUtil.null2Int (currentPage));
			addressExample.setOrderByClause ("standStatus desc");
			System.out.println ("当前用户id=" + SecurityUserHolder.getCurrentUser ().getId ());
			addressExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andAreaIdIsNotNull ();
			List <Address> addresses = this.addressService.getObjectList (addressExample);
			mv.addObject ("addresses" , addresses);
			String ajax_url = CommUtil.getURL (request) + "/buyer/buyer_addressList.htm";
			Pagination pList = this.addressService.getObjectListWithPage (addressExample);
			mv.addObject ("objs" , pList.getList ());
			mv.addObject ("totalPages" , pList.getTotalPage ());
			mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = this.areaService.getObjectList (areaExample);
			mv.addObject ("areas" , areas);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	/*
	 * @SecurityMapping(title = "", value = "/buyer/shop_report.htm*", rtype = "buyer", rname =
	 * "用户中心", rcode = "user_center", rgroup = "用户中心", display = false, rsequence = 0)
	 * @RequestMapping({ "/buyer/shop_report.htm" })
	 * public ModelAndView shopReport(HttpServletRequest request,
	 * HttpServletResponse response, String currentPage, String orderBy, String orderType, String
	 * id) {
	 * ModelAndView mv = new JModelAndView("buyer/shop_report.html",
	 * this.configService.getSysConfig(),
	 * this.userConfigService.getUserConfig(),
	 * 1 , request, response);
	 * GoodsWithBLOBs goods = this.goodsService.getByKey(Long.valueOf(Long.parseLong(id)));
	 * Store store = this.storeService.getByKey(goods.getGoodsStoreId());
	 * User storeUser = this.userService.getByKey(store.getUserId());
	 * if(store != null && storeUser != null){
	 * store.setUser(storeUser);
	 * goods.setGoodsStore(store);
	 * }
	 * mv.addObject("goods", goods);
	 * return mv;
	 * }
	 */
	@SecurityMapping(title = "" , value = "/buyer/stor_report.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/stor_report.htm" })
	public ModelAndView storReport (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("buyer/stor_report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月11日 下午4:30:35
	 * @todo 添加地址页面
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/buyer/buyer_address_add.htm" })
	public ModelAndView addAddress (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_address_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = this.areaService.getObjectList (areaExample);
			mv.addObject ("areas" , areas);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月11日 下午4:30:55
	 * @todo 用户地址编辑,修改
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	// 编辑收货地址
	@RequestMapping({ "/buyer/buyer_address_edit.htm" })
	public ModelAndView address_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/buyer_address_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Address address = this.addressService.getByKey (CommUtil.null2Long (id));
			AreaExample areaExample = new AreaExample ();
			areaExample.clear ();
			areaExample.createCriteria ().andParentIdIsNull ();
			List <Area> areas = this.areaService.getObjectList (areaExample);
			mv.addObject ("obj" , address);
			mv.addObject ("areas" , areas);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月11日 下午4:31:26
	 * @todo 保存用户修改的地址
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param areaId
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/buyer/buyer_address_save.htm" })
	public String address_save (HttpServletRequest request , HttpServletResponse response , String id , String areaId , String currentPage)
		{
			WebForm webForm = new WebForm ();
			Address address = null;
			if (id.equals (""))
			{
				address = webForm.toPo (request , Address.class);
				address.setAddtime (new Date ());
			}
			else
			{
				Address add = this.addressService.getByKey (CommUtil.null2Long (id));
				address = (Address) webForm.toPo (request , add);
			}
			address.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
			Area area = this.areaService.getByKey (CommUtil.null2Long (areaId));
			// address.setArea 将地区信息赋入到地址对象内
			address.setArea (area);
			if (id.equals (""))
				this.addressService.add (address);
			else
				this.addressService.updateByObject (address);
			return "redirect:/buyer/buyer_addressList.htm";
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月11日 下午4:31:42
	 * @todo 删除用户地址
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "收货地址删除" , value = "/buyer/buyer_address_del.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_address_del.htm" })
	public String address_del (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			if (!id.equals (""))
			{
				this.addressService.deleteByKey (CommUtil.null2Long (id));
			}
			// 删除后 , 重定向到用户地址列表
			return "redirect:/buyer/buyer_addressList.htm?currentPage=" + currentPage;
		}

	/**
	 * 
	 * @todo 异步刷新默认地址
	 * @author wsw
	 * @date 2015年6月19日 下午4:43:57
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/buyer/buyer_address_standard.htm" })
	public @ResponseBody String address_standard (HttpServletRequest request , HttpServletResponse response , String id)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			String msg = "false";
			if (user != null)
			{
				AddressExample addressExample = new AddressExample ();
				addressExample.clear ();
				addressExample.createCriteria ().andUserIdEqualTo (user.getId ()).andStandStatusEqualTo (Boolean.valueOf (true));
				List <Address> addresses = this.addressService.getObjectList (addressExample);
				// 设置原始默认地址失效
				if (addresses != null && addresses.size () > 0)
				{
					addresses.get (0).setStandStatus (Boolean.valueOf (false));
					this.addressService.updateByObject (addresses.get (0));
				}
				// 把传入的id的地址设置成默认地址,并返回"true"给予ajax回应
				Address address = this.addressService.getByKey (CommUtil.null2Long (id));
				address.setStandStatus (CommUtil.null2Boolean (true));
				this.addressService.updateByObject (address);
				msg = "true";
			}
			return msg;
		}
}
