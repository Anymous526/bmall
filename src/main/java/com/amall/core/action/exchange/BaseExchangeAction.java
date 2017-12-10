package com.amall.core.action.exchange;

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
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.integral.IIntegralGoodsService;
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
public class BaseExchangeAction
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

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	/**
	 * 免费兑换查询部分
	 * <p>
	 * Title: conversion_search
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/exchange/exchange_search.htm" })
	public ModelAndView conversion_search (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("exchange/exchange_search.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 免费兑换查询部分
	 * <p>
	 * Title: conversion_search
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping({ "/exchange/exchange_search2.htm" })
	public ModelAndView conversion_search2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("exchange/exchange_search2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/exchange/exchange_search3.htm" })
	public ModelAndView conversion_search3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("exchange/exchange_search3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
