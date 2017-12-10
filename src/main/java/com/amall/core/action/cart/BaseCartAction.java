package com.amall.core.action.cart;

import java.util.Date;

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
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IMessageService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MenuTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.tools.OrderViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class BaseCartAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IArticleService articleService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private OrderViewTools orderViewTools;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private MenuTools menuTools;

	@Autowired
	private IStoreCartService storeCartService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IAreaService areaService;


	/**
	 * 购物车查询部分
	 * <p>
	 * Title: cart_search
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@SecurityMapping(title = "购物车查询", value = "/seller/seller_nav.htm*", rtype = "all", rname = "购物车查询", rcode = "cart_search", rgroup = "购物车查询", display = false, rsequence = 0)
	@RequestMapping({ "/cart/cart_search.htm" })
	public ModelAndView cart_search(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("cart/cart_search.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);

		return mv;
	}

	/**
	 * 购物车跳转登录
	 * <p>
	 * Title: cart_login
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/cart/cart_login.htm" })
	public ModelAndView cart_login(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = null;
		if (SecurityUserHolder.getCurrentUser() == null) {
			mv = new JModelAndView("cart/cart_login.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request,
					response);

		}

		return mv;
	}

	/**
	 * 购物车推荐栏
	 * <p>
	 * Title: scrollList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/cart/scrollList.htm" })
	public ModelAndView scrollList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = null;

		mv = new JModelAndView("cart/scrollList.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);

		return mv;
	}

	/**
	 * 订单确认logo
	 * <p>
	 * Title: cart_confirm_order_index
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/cart/cart_confirm_order_logo.htm" })
	public ModelAndView cart_confirm_order_logo(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView(
				"cart/cart_confirm_order_logo.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}

	/**
	 * 订单确认地址
	 * <p>
	 * Title: cart_confirm_order_address
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/cart/cart_confirm_order_address.htm" })
	public ModelAndView cart_confirm_order_address(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {

		ModelAndView mv = new JModelAndView(
				"cart/cart_confirm_order_address.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);

		AddressExample addressExample = new AddressExample();
		addressExample.clear();
		addressExample.setPageNo(CommUtil.null2Int(currentPage));
		addressExample.setPageSize(4);
		addressExample.setOrderByClause("standStatus desc");
		addressExample.createCriteria().andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId()).andAreaIdIsNotNull();

		Pagination pList = this.addressService
				.getObjectListWithPage(addressExample);
		mv.addObject("objs", pList.getList());
		mv.addObject("totalPages", pList.getTotalPage());
		String aJax_url = CommUtil.getURL(request)
				+ "/cart/cart_confirm_order_address.htm";
		mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(aJax_url,
				"", pList.getPageNo(), pList.getTotalPage()));

		// areas
		AreaExample areaExample = new AreaExample();
		areaExample.clear();
		areaExample.createCriteria().andParentIdIsNull();
		mv.addObject("areas", this.areaService.getObjectList(areaExample));
		return mv;
	}

	/**
	 * 
	 * @todo 订单页面ajax异步保存地址
	 * @author wsw
	 * @date 2015年6月30日 下午1:42:31
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param areaId
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/cart/cart_address_save.htm" })
	@ResponseBody
	public String address_save(HttpServletRequest request,
			HttpServletResponse response, String id, String areaId,
			String currentPage) {
		String result = "false";
		WebForm webForm = new WebForm();
		Address address = null;
		if (id==null ||id.equals("")) {
			address = webForm.toPo(request, Address.class);
			address.setAddtime(new Date());

		} else {

			Address add = this.addressService.getByKey(CommUtil.null2Long(id));
			address = (Address) webForm.toPo(request, add);
		}
		
		address.setUserId(SecurityUserHolder.getCurrentUser().getId());

		Area area = this.areaService.getByKey(CommUtil.null2Long(areaId));
		// address.setArea 将地区信息赋入到地址对象内
		address.setArea(area);
		if (id.equals("")){
			this.addressService.add(address);
			result = "true";
		}
		else{
			this.addressService.updateByObject(address);
			result = "true";
		}

		return result;

	}

	/**
	 * 订单支付logo
	 * <p>
	 * Title: cart_pay_logo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/cart/cart_pay_logo.htm" })
	public ModelAndView cart_pay_logo(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("cart/cart_pay_logo.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}

 
/**
 * 订单支付logo1
 * <p>
 * Title: cart_pay_logo1
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @param request
 * @param response
 * @return mv
 */
@RequestMapping({ "/cart/cart_pay_logo1.htm" })
public ModelAndView cart_pay_logo1(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mv = new JModelAndView("cart/cart_pay_logo1.html",
			this.configService.getSysConfig(),
			this.userConfigService.getUserConfig(), 1, request, response);
	return mv;
}

/**
 * 订单支付logo
 * <p>
 * Title: cart_pay_logo2
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @param request
 * @param response
 * @return mv
 */
@RequestMapping({ "/cart/cart_pay_logo2.htm" })
public ModelAndView cart_pay_logo2(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mv = new JModelAndView("cart/cart_pay_logo2.html",
			this.configService.getSysConfig(),
			this.userConfigService.getUserConfig(), 1, request, response);
	return mv;
}

}