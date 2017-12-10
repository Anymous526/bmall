package com.amall.core.action.brandshop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.service.IMessageService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreCartService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.MenuTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.tools.OrderViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class BaseBandShopAction
{

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

	/**
	 * 品牌店head部分
	 * <p>
	 * Title: brandshop_head
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/brandshop/brandshop_head.htm" })
	public ModelAndView brandshop_head (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("brandshop/brandshop_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 品牌店铺菜单
	 * <p>
	 * Title: conversion_menu
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/brandshop/brandshop_menu.htm" })
	public ModelAndView brandshop_menu (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			mv = new JModelAndView ("brandshop/brandshop_menu.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 品牌店铺主页左菜单
	 * <p>
	 * Title: conversion_menu
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/brandshop/brandshop_left.htm" })
	public ModelAndView brandshop_left (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			mv = new JModelAndView ("brandshop/brandshop_left.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
