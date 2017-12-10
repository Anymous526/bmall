package com.amall.core.action.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Address;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.CartDetailExample.Criteria;
import com.amall.core.bean.CartExample;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsAndStoreShow;
import com.amall.core.bean.GoodsCartShow;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;
import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;
import com.amall.core.bean.OrderAddress;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserConfig;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IOrderAddressService;
import com.amall.core.service.alipayorder.IAlipayOrderService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.lee.IMutualBenefitService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.pay.PayTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * @author tangxiang
 *
 */
@Controller
public class CartAndOrderFormViewAction
{

	@Autowired
	private IMutualBenefitService mutualBenefitService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private IAlipayOrderService alipayOrderService;

	@Autowired
	private PayTools payTools;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IGroupGoodsService groupGoodsSerice;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IOrderAddressService orderAddressService;

	@Autowired
	private IUserService userService;


	/**
	 * @Title: add_goods_cart
	 * @Description: 添加商品到购物车，登录后添加到DBA，未登录添加到cookie
	 * @param request
	 * @param response
	 * @param goodsId
	 * @param goodsProperty
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 下午4:10:00
	 */
	@RequestMapping({ "/cart/add_goods_to_cart.htm" })
	public @ResponseBody String add_goods_cart (HttpServletRequest request , HttpServletResponse response ,
												String goodsPrice , String goodsId , String goodsProperty ,
												String count , String goodsName , String type)
		{
			/* 验空传入信息 */
			if (goodsId == null || goodsId.equals ("") || count == null || count.equals (""))
			{
				return Globals.RETURN_NULL;
			}
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				/*
				 * 当用户没有登录但cookie
				 * cartUUID存在则直接使用存放商品信息到cookie中，没有则在cookie中增加一个cartUUID
				 */
				/* 获取cookie中保存的cartUUID */
				String cookieCartUUID = getCookieUUID (request , Globals.GOODS_CART_ID_NAME);
				GoodsCartShow goodsJson = new GoodsCartShow ();
				goodsJson.setCount (count);
				goodsJson.setGoodsId (goodsId);
				goodsJson.setGoodsPrice (goodsPrice);
				goodsJson.setGoodsProperty (goodsProperty.trim ());
				goodsJson.setGoodsName (goodsName);
				if (cookieCartUUID == null || cookieCartUUID.equals (""))
				{
					cookieCartUUID = UUID.randomUUID ().toString ();
					goodsJson.setCartUUID (cookieCartUUID);
				}
				else
				{
					goodsJson.setCartUUID (cookieCartUUID);
				}
				Cookie cookie = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , request.getCookies ());
				boolean addcookie = setGoodsToCookie (goodsJson , cookie , response);
				if (!addcookie)
				{
					return Globals.RETURN_NULL;
				}
				/* 测试代码，读取所有cookie */
				// testReadCartFromCookie(request);
				return (getCountFromCookie (request.getCookies ()) + Integer.valueOf (count)) + "";
			}
			String cartUUID = isAreadyRecordForCart (user.getId ());
			/* 主表没有有效购物车时，生成一个新的购物车并生成一个新的cartUUID, 存在有效购物车时，直接合并数据 */
			if (cartUUID == null)
			{
				cartUUID = UUID.randomUUID ().toString ();
				saveGoodsToCartDBAndReturnId (user.getId () , cartUUID);
			}
			/* 合并表数据, 要判断是否商家自己购买自己的商品 */
			if (!user.getId ().equals (this.goodsService.getByKey (Long.valueOf (goodsId)).getGoodsStore ().getUserId ()))
			{
				saveGoodsToDetailDB (cartUUID , Long.valueOf (goodsId) , false , goodsProperty , Integer.valueOf (count) , type);
			}
			return getCountFromCartDetail (user.getId ()).toString ();
		}


	/**
	 * @Title: settle_accounts
	 * @Description: 直接购买，未登录则提示登录
	 * @param request
	 * @param response
	 * @param goodsId
	 * @param goodsProperty
	 * @param count
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月8日 下午4:27:48
	 */
	@RequestMapping({ "/cart/settle_accounts.htm" })
	public ModelAndView settle_accounts (	HttpServletRequest request , HttpServletResponse response , String goodsId ,
											String goodsProperty , String count , String type , String goodstype)
		{
			ModelAndView mv = null;
			String cartUUID = UUID.randomUUID ().toString ();
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			if (StringUtils.isEmpty (goodsId) || StringUtils.isEmpty (count))
			{
				// 提示选择商品？
				return returnToIndex (mv , request , response);
			}
			int buyCount = 0;
			System.out.println ("count == " + count.toString ());
			if (null != count && !count.equals (""))
			{
				/* 判断购买数量是否超过库存 */
				buyCount = Integer.valueOf (count);
			}
			GoodsWithBLOBs goods = this.goodsService.getByKey (Long.valueOf (goodsId));
			if (goods.getGoodsInventory () < buyCount)
			{
				return returnToIndex (mv , request , response);
			}
			/* 商品添加到商品列表，直接支付状态为true, 先判断是否存在同样的商品 */
			CartDetail cartDetail = getRecordForCartDetail (null , Long.valueOf (goodsId) , goodsProperty , true , false);
			if (cartDetail == null)
			{
				saveGoodsToDetailDB (cartUUID , Long.valueOf (goodsId) , true , goodsProperty , buyCount , goodstype);
			}
			else
			{
				cartUUID = cartDetail.getGoodsCartId ();
				/* 修改数量为当前所选择数量 */
				if (count != null && Integer.valueOf (count) > 0)
				{
					cartDetail.setGoodsCount (Integer.valueOf (count));
					this.cartDetailService.updateByObject (cartDetail);
					System.out.println ("有商品记录的情况下：== " + cartDetail.getGoodsCount ());
				}
			}
			SysConfigWithBLOBs sysConfig = this.configService.getSysConfig ();
			UserConfig userConfig = this.userConfigService.getUserConfig ();
			if (null != sysConfig && null != userConfig)
			{
				mv = new JModelAndView ("cart/cart_confirm_order_index.html" , sysConfig , userConfig , 1 , request , response);
			}
			/* 根据购物车UUID, 删除状态为false, 直接状态为true取得支付总价 */
			List <Long> ids = new ArrayList <Long> ();
			ids.add (Long.valueOf (goodsId));
			List <GoodsCartShow> cartShows = getGoodsCartShowListOfCartUUID (cartUUID , ids , true , null);
			/* 没有找到商品则返回购物车 */
			if (cartShows.isEmpty ())
			{
				return returnToCart (mv , request , response);
			}
			List <GoodsAndStoreShow> shows = returnCartGoodsShow (cartShows);
			BigDecimal payment = getPayment (cartShows);
			mv.addObject ("cartGoodsShow" , shows);
			mv.addObject ("payment" , payment);
			mv.addObject ("directBuy" , "true");
			return mv;
		}


	/**
	 * 显示购物车购物列表
	 * <p>
	 * Title: cartShowGoodsList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author tangxiang
	 */
	@RequestMapping({ "/cart/cart_index.htm" })
	public ModelAndView cartShowGoodsList (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			mv = returnToCart (mv , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			String CartUUIDFormDBA = null;
			testReadCartFromCookie (request);
			/* 从Cookie购物车获取 */
			if (user == null)
			{
				/* 判断是否存在cookie */
				Cookie cookieGoods = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , request.getCookies ());
				List <Object> list = new ArrayList <Object> ();
				if (cookieGoods != null && cookieGoods.getValue () != null && !cookieGoods.getValue ().equals (""))
				{
					try
					{
						list = CommUtil.jsonToBeanList (URLDecoder.decode (cookieGoods.getValue () , "UTF-8") , GoodsCartShow.class);
					}
					catch (UnsupportedEncodingException e)
					{
						e.printStackTrace ();
					}
				}
				if (!list.isEmpty ())
				{
					if (judgeCookieGoodsIsExist (cookieGoods , list , request , response))
					{
						/* 如果更新了cookie中的购物车商品信息 则重新获取一下 */
						try
						{
							list = CommUtil.jsonToBeanList (URLDecoder.decode (cookieGoods.getValue () , "UTF-8") , GoodsCartShow.class);
						}
						catch (UnsupportedEncodingException e)
						{
							e.printStackTrace ();
						}
					}
					mv.addObject ("cartGoodsShow" , getShowCartGoodsOfCookieList (list));
					mv.addObject ("totalPayment" , getPaymentOfCookieList (list));
					return mv;
				}
			}
			else
			/* 从库中获取 */
			{
				CartUUIDFormDBA = isAreadyRecordForCart (user.getId ());
				/* 不存在购物车时直接返回 */
				if (CartUUIDFormDBA == null)
				{
					return mv;
				}
				List <GoodsCartShow> list = getGoodsCartShowListOfCartUUID (CartUUIDFormDBA , null , false , null);
				if (judgeDBCarGoodsIsExist (list))
				{
					/* 如果更新了数据库中的购物车商品信息 则重新获取一下 */
					list = getGoodsCartShowListOfCartUUID (CartUUIDFormDBA , null , false , null);
				}
				List <GoodsAndStoreShow> stores = returnCartGoodsShow (list);
				mv.addObject ("cartGoodsShow" , stores);
				mv.addObject ("totalPayment" , getPayment (list));
				return mv;
			}
			return mv;
		}


	/**
	 * 判断cookie购物车中的商品是否存在，如果不存在，则删除,否者判断库存是否
	 * 
	 * @author guoxiangjun
	 * @param carGoodsList
	 *            购物车商品列表
	 */
	private boolean judgeCookieGoodsIsExist (	Cookie cookieGoods , List <Object> list , HttpServletRequest request ,
												HttpServletResponse response)
		{
			boolean flag = false;
			for (Object obj : list)
			{
				GoodsCartShow goods = (GoodsCartShow) obj;
				Integer inventory = getGoodsCountOfGoodsId (Long.valueOf (goods.getGoodsId ()));
				Integer status = getGoodsCountOfGoodsStatus (Long.valueOf (goods.getGoodsId ()));
				if (inventory == Globals.NUBER_ZERO || status != Globals.NUBER_ZERO)
				{
					this.deleteCookieGoodsOfGoodsId (goods.getGoodsId () , cookieGoods , response);
					flag = true;
				}
				else
				{
					if (inventory < Integer.valueOf (goods.getCount ()))
					{
						goods.setCount (inventory.toString ()); // 如果当前商品的库存<已加入购物车的数量
						flag = false;
					}
				}
			}
			return flag;
		}


	/**
	 * 判断数据库购物车中的商品库存，如果为0则，从数据库购物车中删除，如果购买的数量大于库存，则将现有的库存设置为购买的库存
	 * 
	 * @author guoxiangjun
	 * @param carGoodsList
	 *            购物车商品列表
	 * @return 是否做出了更改操作
	 */
	private boolean judgeDBCarGoodsIsExist (List <GoodsCartShow> carGoodsList)
		{
			boolean flag = false;
			for (GoodsCartShow goods : carGoodsList)
			{
				Integer inventory = getGoodsCountOfGoodsId (Long.valueOf (goods.getGoodsId ()));
				if (inventory == Globals.NUBER_ZERO)
				{
					deleteGoodsOfGoodsIdAndCartUUID (Long.valueOf (goods.getGoodsId ()) , goods.getCartUUID () , goods.getGoodsProperty ());
					flag = true;
				}
				else
				{
					if (inventory < Integer.valueOf (goods.getCount ()))
					{
						// 如果当前商品的库存小于已加入购物车的数量
						CartDetail detail = getRecordForCartDetail (goods.getCartUUID () , Long.valueOf (goods.getGoodsId ()) , null , false , false);
						detail.setGoodsCount (inventory);
						this.cartDetailService.updateByObject (detail); // 更新到数据库
						flag = true;
					}
				}
			}
			return flag;
		}


	/**
	 * @Title: goods_count_adjust
	 * @Description: 调整购买数量
	 * @param request
	 * @param response
	 * @param goodsId
	 *            商品ID
	 * @param goodsCount
	 *            要购买数量
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午4:11:50
	 */
	@RequestMapping({ "/cart/goods_count_adjust.htm" })
	public void goods_count_adjust (HttpServletRequest request , HttpServletResponse response , String goodsId ,
									String goodsCount , String cartUUID , String goodsProperty)
		{
			int inventory = Globals.NUBER_ZERO;
			boolean ret = false;
			User user = SecurityUserHolder.getCurrentUser ();
			/* 根据商品ID查询到商品数量 */
			if (goodsId != null && !goodsId.equals ("") && goodsCount != null && !goodsCount.equals ("") && Integer.valueOf (goodsCount) >= Globals.NUBER_ONE)
			{
				inventory = getGoodsCountOfGoodsId (Long.valueOf (goodsId));
				if (inventory >= Integer.valueOf (goodsCount))
				{
					ret = true;
				}
			}
			/* 当数量满足时，调整商品数量, 未登录时调整cookie数量, 登录后调整DBA数量 */
			if (user == null)
			{
				/* 调整cookie数量 */
				updateCookieGoodsCount (goodsId , goodsCount , goodsProperty != null ? goodsProperty.trim () : null , request , response);
			}
			else
			{
				/* 调整DBA数量 */
				CartDetail cartDetail = getRecordForCartDetail (cartUUID , Long.valueOf (goodsId) , goodsProperty != null ? goodsProperty.trim () : null , false , false);
				if (cartDetail != null)
				{
					cartDetail.setGoodsCount (Integer.valueOf (goodsCount));
					this.cartDetailService.updateByObject (cartDetail);
				}
			}
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


	/**
	 * @Title: remove_goods_cart
	 * @Description: 删除购物车里面的商品，用户登录删除DBA信息，用户未登录删除cookie信息
	 * @param request
	 * @param response
	 * @param goodsId
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月10日 下午4:54:42
	 */
	@RequestMapping({ "/cart/remove_goods_cart.htm" })
	public String remove_goods_cart (	HttpServletRequest request , HttpServletResponse response , String goodsId ,
										String cartUUID , String goodsProperty)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			/* 未登录时，删除cookie信息 */
			if (user == null)
			{
				deleteCookieGoodsOfGoodsId (goodsId , goodsProperty.trim () , request , response);
			}
			else
			{
				deleteGoodsOfGoodsIdAndCartUUID (Long.valueOf (goodsId) , cartUUID , goodsProperty.trim ());
			}
			return "redirect:/cart/cart_index.htm";
		}


	/**
	 * @Title: orderFormPay
	 * @Description: 我的订单 付款
	 * @param request
	 * @param response
	 * @param orderFormId
	 * @return
	 * @return ModelAndView
	 * @author guoxiangjun
	 * @date 2015年8月18日 下午4:38:35
	 */
	@RequestMapping({ "/cart/orderform_pay.htm" })
	private ModelAndView orderFormPay (	HttpServletRequest request , HttpServletResponse response , String orderFormId)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return returnToIndex (mv , request , response);
			}
			OrderFormWithBLOBs or = this.orderFormService.getByKey (Long.valueOf (orderFormId));
			List <String> orderIdList = new ArrayList <String> ();
			orderIdList.add (or.getOrderId ());
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = SecurityUserHolder.getCurrentUser ();
				currentUser = userService.getByKey (currentUser.getId ());
				System.out.println ("支付密码=" + currentUser.getPayPassword ());
				System.out.println (currentUser.getUsername ());
			}
			mv = new JModelAndView ("cart/cart_pay_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , Globals.NUBER_ONE , request , response);
			mv.addObject ("payment" , or.getTotalprice ());
			mv.addObject ("orderList" , orderIdList);
			mv.addObject ("id" , or.getId ());
			mv.addObject ("currentUser" , currentUser);
			return mv;
		}


	/**
	 * @Title: cart_settle_accounts
	 * @Description: 购物车商品信息结算，这里不保存总价到购物车主表，在生成订单那里保存
	 * @param request
	 * @param response
	 * @param goodsIds
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月10日 下午5:45:07
	 */
	@RequestMapping({ "/cart/cart_settle_accounts.htm" })
	public ModelAndView cart_settle_accounts (	HttpServletRequest request , HttpServletResponse response ,
												String goodsIds)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			/* 当用户未登录时 */
			if (user == null)
			{
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.endsWith (""))
				{
					url = CommUtil.getURL (request);
				}
				request.getSession (false).setAttribute ("refereUrl" , url + "/cart/cart_settle_accounts.htm");
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			/* 判断是否有有效购物车 */
			String cartUUID = isAreadyRecordForCart (user.getId ());
			/* 没有购物车则返回首页 */
			if (cartUUID == null)
			{
				return returnToIndex (mv , request , response);
			}
			/* 没有商品ID则返回购物车 */
			if (goodsIds == null || goodsIds.equals (""))
			{
				return returnToCart (mv , request , response);
			}
			List <Long> ids = getGoodsIdsFromCart (goodsIds , "\\|");
			List <String> sepcs = getGoodsSpecFromCart (goodsIds , "\\|");
			/* 没有商品ID则返回购物车 */
			if (ids.isEmpty ())
			{
				return returnToCart (mv , request , response);
			}
			List <GoodsCartShow> cartShows = getGoodsCartShowListOfCartUUID (cartUUID , ids , false , sepcs);
			/* 没有找到商品则返回购物车 */
			if (cartShows.isEmpty ())
			{
				return returnToCart (mv , request , response);
			}
			List <GoodsAndStoreShow> shows = returnCartGoodsShow (cartShows);
			BigDecimal payment = getPayment (cartShows);
			mv = new JModelAndView ("cart/cart_confirm_order_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , Globals.NUBER_ONE , request , response);
			mv.addObject ("cartUUID" , cartUUID);
			mv.addObject ("cartGoodsShow" , shows);
			mv.addObject ("payment" , payment);
			return mv;
		}


	/**
	 * @Title: cart_pay_index
	 * @Description: 订单生成页，这里选择支付方式、快递、优惠等信息
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月11日 下午3:24:00
	 */
	@RequestMapping({ "/cart/cart_pay_index.htm" })
	public ModelAndView cart_pay_index (HttpServletRequest request , HttpServletResponse response , String cartUUID)
		{
			ModelAndView mv = null;
			BigDecimal sumPrice = new BigDecimal (Globals.NUBER_ZERO);
			OrderFormWithBLOBs bloBs = null;
			User user = SecurityUserHolder.getCurrentUser ();
			String goodsIdsAndPropertys = request.getParameter ("goodsIds");
			String addressId = request.getParameter ("addressId");
			String msg = request.getParameter ("msgs");
			String invoice = request.getParameter ("invoices");
			// 获取用户所选商品对应的配送方式,格式商品ID`配送方式(166`express|165`express|)
			String goodsIdAndTransType = request.getParameter ("goodsIdAndTransType");
			boolean directBuy = false;
			/* 地址,商品,用户不能为空 */
			if (addressId == null || goodsIdsAndPropertys == null || user == null)
			{
				return returnToCart (mv , request , response);
			}
			List <Long> ids = getGoodsIdsFromString (goodsIdsAndPropertys);
			List <String> propertys = getGoodsPropertysFromString (goodsIdsAndPropertys);
			/* id和地址不对也返回到购物车 */
			if (ids.isEmpty () || !isNum (addressId))
			{
				return returnToCart (mv , request , response);
			}
			/* 根据商品ID，查找店铺 */
			List <Long> storeIds = getStoreHashSetOfGoodsId (ids);
			List <String> msgs = checkStringInfo (msg , storeIds.size ());
			List <String> invoices = checkStringInfo (invoice , storeIds.size ());
			/* 获取邮寄map */
			Map <Long, String> shipMap = getShipMap (goodsIdAndTransType);
			/* 若不存在店铺则返回购物 */
			if (storeIds.isEmpty ())
			{
				return returnToCart (mv , request , response);
			}
			Cart cart = null;
			/* 判断是否直接购买 */
			if (StringUtils.isEmpty (cartUUID))
			{
				CartDetail detail = isHaveBuyGoods (null , ids.get (Globals.NUBER_ZERO) , null , true , false);
				if (detail == null)
				{
					return returnToCart (mv , request , response);
				}
				if (detail.getDirectBuy ())
				{
					directBuy = true;
					cart = cartService.getByKey (detail.getCartId ());
				}
			}
			if (cart == null)
			{
				cart = getRecordForCart (user.getId () , true , directBuy);
			}
			/* 锁定商品，这里要优先做。防止并发情况使用锁 */
			if (!lockGoods (ids , user.getId () , directBuy))
			{
				return returnToCart (mv , request , response);
			}
			/* 初始化订单信息 */
			List <String> orderIdList = new ArrayList <String> ();
			for (int k = 0 ; k < ids.size () ; k++)
			{
				for (int i = 0 ; i < storeIds.size () ; i++)
				{
					Goods goods = this.goodsService.getByKey (ids.get (k));
					if (goods.getGoodsStoreId ().longValue () == storeIds.get (i).longValue ())
					{
						String orderId = CommUtil.generateOrderId ();
						orderIdList.add (orderId);
						bloBs = new OrderFormWithBLOBs ();
						bloBs.setStoreId (storeIds.get (i));
						bloBs.setAddrId (createOrderAddress (Long.valueOf (addressId)));
						bloBs.setAddtime (new Date ());
						bloBs.setMsg (msgs.get (i));
						bloBs.setCiId (cart.getId ());
						bloBs.setInvoice (invoices.get (i));
						bloBs.setOrderStatus (Globals.WAIT_PAYMENT_ORDER);
						bloBs.setUserId (user.getId ());
						bloBs.setOrderId (orderId);
						fullOrderForm (goods , bloBs , propertys.get (k) , shipMap , user.getId () , directBuy);
						break;
					}
				}
			}
			/* 先锁定购物车 */
			cart.setStatus (false);
			this.cartService.updateByObject (cart);
			/* 当不是直接购买时，查找该购物车是否存在未选择的商品，存在则生成一个新的购物车来存放 */
			if (!directBuy)
			{
				List <CartDetail> cartDetails = getRecordForCartDetail (null , false , false , cart.getId ());
				if (!cartDetails.isEmpty ())
				{
					/* 生成购物车 */
					String newCartUUID = UUID.randomUUID ().toString ();
					Long newCartId = saveGoodsToCartDBAndReturnId (user.getId () , newCartUUID);
					/* 更新商品列表cartUUID */
					for (CartDetail cartDetail : cartDetails)
					{
						cartDetail.setGoodsCartId (newCartUUID);
						cartDetail.setCartId (newCartId);
						this.cartDetailService.updateByObject (cartDetail);
					}
				}
			}
			/* 获取支付总价 */
			/* 邮费 */
			for (String orderId : orderIdList)
			{
				OrderForm form = getOrderFormOfOrderId (orderId , null);
				sumPrice = sumPrice.add (form.getShipPrice ());
			}
			/* 购物车购买 */
			if (!directBuy)
			{
				sumPrice = sumPrice.add (getOrderGoodsPrice (cart.getId () , directBuy));
			}
			else
			{
				/* 直接购买 */
				sumPrice = sumPrice.add (getDirectBuyGoodsPrice (cart.getId () , ids.get (Globals.NUBER_ZERO) , directBuy));
			}
			User currentUser = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				currentUser = SecurityUserHolder.getCurrentUser ();
				currentUser = userService.getByKey (currentUser.getId ());
				System.out.println ("支付密码=" + currentUser.getPayPassword ());
				System.out.println (currentUser.getUsername ());
			}
			mv = new JModelAndView ("cart/cart_pay_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , Globals.NUBER_ONE , request , response);
			mv.addObject ("currentUser" , currentUser);
			mv.addObject ("orderList" , orderIdList);
			mv.addObject ("payment" , sumPrice.toString ());
			mv.addObject ("id" , bloBs.getId ());
			return mv;
		}


	/**
	 * @Title : O2OCreateOrder
	 * @Deprecated ： O2O创富用户生成未支付订单
	 * @param request
	 * @param response
	 * @param cartUUID
	 * @return ModelAndView
	 * @author liuguo
	 * @Date 2016/12/13 11:34
	 */
	@RequestMapping({ "/cart/O2O_create_order.htm" })
	public ModelAndView O2OCreateOrder (HttpServletRequest request , HttpServletResponse response , String cartUUID)
		{
			ModelAndView mv = null;
			BigDecimal sumPrice = new BigDecimal (Globals.NUBER_ZERO);
			OrderFormWithBLOBs bloBs = null;
			User user = SecurityUserHolder.getCurrentUser ();
			String goodsIdsAndPropertys = request.getParameter ("goodsIds");
			String msg = request.getParameter ("msgs");
			boolean directBuy = false;
			/* 商品,用户不能为空 */
			if (goodsIdsAndPropertys == null || user == null)
			{
				return returnToCart (mv , request , response);
			}
			List <Long> ids = getGoodsIdsFromString (goodsIdsAndPropertys);
			List <String> propertys = getGoodsPropertysFromString (goodsIdsAndPropertys);
			/* 根据商品ID，查找店铺 */
			List <Long> storeIds = getStoreHashSetOfGoodsId (ids);
			List <String> msgs = checkStringInfo (msg , storeIds.size ());
			/* 若不存在店铺则返回购物 */
			if (storeIds.isEmpty ())
			{
				return returnToCart (mv , request , response);
			}
			/* 初始化订单信息 */
			List <String> orderIdList = new ArrayList <String> ();
			for (int k = 0 ; k < ids.size () ; k++)
			{
				for (int i = 0 ; i < storeIds.size () ; i++)
				{
					Goods goods = this.goodsService.getByKey (ids.get (k));
					if (goods.getGoodsStoreId ().longValue () == storeIds.get (i).longValue ())
					{
						String orderId = CommUtil.generateOrderId ();
						orderIdList.add (orderId);
						bloBs = new OrderFormWithBLOBs ();
						bloBs.setStoreId (storeIds.get (i));
						bloBs.setAddtime (new Date ());
						bloBs.setMsg (msgs.get (i));
						bloBs.setOrderStatus (Globals.WAIT_PAYMENT_ORDER);
						bloBs.setUserId (user.getId ());
						bloBs.setOrderId (orderId);
						// 区分普通订单与O2O订单
						bloBs.setOrderType (Globals.ORDER_TYPE_O2O);
						fullOrderForm (goods , bloBs , propertys.get (k) , null , user.getId () , directBuy);
						break;
					}
				}
			}
			/* 获取支付总价 */
			/* 邮费 */
			for (String orderId : orderIdList)
			{
				OrderForm form = getOrderFormOfOrderId (orderId , null);
				sumPrice = sumPrice.add (form.getShipPrice ());
			}
			/* 直接购买 */
			sumPrice = sumPrice.add (getDirectBuyGoodsPrice (null , ids.get (Globals.NUBER_ZERO) , directBuy));
			mv = new JModelAndView ("cart/" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , Globals.NUBER_ONE , request , response);
			mv.addObject ("orderList" , orderIdList);
			mv.addObject ("payment" , sumPrice.toString ());
			mv.addObject ("id" , bloBs.getId ());
			return mv;
		}


	/**
	 * 计算订单内,购买某商品,对应的配送方式,购买的该商品数量,得出的运费
	 * 
	 * @param goodsId
	 *            商品id
	 * @param type
	 *            配送类型
	 * @param count
	 *            商品数量
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BigDecimal getGoodsTransFee (Long goodsId , String type , Integer count)
		{
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			TransportWithBLOBs transportWithBLOBs = goodsWithBLOBs.getTransport ();
			List <Map> list = null;
			if (type.equals ("ems"))
			{
				String emsinfo = transportWithBLOBs.getTransEmsInfo ();
				// json串转object
				list = (List) Json.fromJson (List.class , emsinfo);
			}
			if (type.equals ("express"))
			{
				String expressinfo = transportWithBLOBs.getTransExpressInfo ();
				list = (List) Json.fromJson (List.class , expressinfo);
			}
			if (type.equals ("mail"))
			{
				String mailinfo = transportWithBLOBs.getTransMailInfo ();
				list = (List) Json.fromJson (List.class , mailinfo);
			}
			BigDecimal calFee = BigDecimal.ONE;
			if (list != null)
			{
				Map map = list.get (0);
				BigDecimal transFee = new BigDecimal (map.get ("trans_fee").toString ());
				BigDecimal transAddFee = new BigDecimal (map.get ("trans_add_fee").toString ());
				if (Integer.valueOf (count) > 1)
				{
					calFee = transFee.add (transAddFee.multiply (new BigDecimal ((Integer.valueOf (count) - 1))));
				}
				else
				{
					calFee = transFee;
				}
			}
			return calFee;
		}


	/**
	 * @Title: order_cancel_save
	 * @Description: 订单取消
	 * @param request
	 * @param response
	 * @param orderFormId
	 *            订单号
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月14日 下午3:42:47
	 */
	@RequestMapping({ "/buyer/order_cancel_save.htm" })
	public String order_cancel_save (	HttpServletRequest request , HttpServletResponse response , String id ,
										String currentPage , String state_info , String other_state_info)
		{
			if (id != null && !id.equals (""))
			{
				OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (Long.valueOf (id));
				/* 判断订单状态, 1.等待支付, 2.货到付款待发货 */
				if (orderForm.getOrderStatus () == Globals.WAIT_PAYMENT_ORDER || orderForm.getOrderStatus () == Globals.SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD)
				{
					/* 返还商品 */
					List <OrderFormItem> formItems = getOrderFormItemList (orderForm.getId ());
					if (formItems != null)
					{
						for (OrderFormItem formItem : formItems)
						{
							addRepository (formItem.getGoodsId () , formItem.getGoodsCount ());
						}
					}
					orderForm.setOrderStatus (Globals.CANCELLED_ORDER);
					this.orderFormService.updateByObject (orderForm);
					// 货到付款待发货
					// 订单发生改动，将日志记入到订单日志内
					OrderFormLog ofl = new OrderFormLog ();
					ofl.setAddtime (new Date ());
					ofl.setLogInfo ("取消订单");
					ofl.setLogUserId (SecurityUserHolder.getCurrentUser ().getId ());
					ofl.setOfId (orderForm.getId ());
					if (state_info.equals ("other"))
						ofl.setStateInfo (other_state_info);
					else
						ofl.setStateInfo (state_info);
					this.orderFormLogService.add (ofl);
				}
			}
			// 重定向到 买家中心 订单详情页面
			return "redirect:buyer_order.htm?currentPage=" + currentPage;
		}


	/**
	 * 测试页面
	 * <p>
	 * Title: test
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/carttest.htm" })
	public ModelAndView test (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("test.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/**
	 * @Title: order_pay
	 * @Description: 订单支付
	 * @param request
	 * @param response
	 * @param webbankpay
	 * @param orderIds
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月19日 上午11:40:20
	 */
	@RequestMapping({ "/order_pay.htm" })
	public ModelAndView order_pay (	HttpServletRequest request , HttpServletResponse response , String webbankpay ,
									String orderIds , String bool , String payment_pwd)
		{
			/**
			 * webbankpay代表支付方式.alipayorderId代表AlipayOrder的id。id代表OrderForm的Id号(支付失败，订单返回支付的时候要)
			 */
			ModelAndView mv = null;
			OrderFormWithBLOBs of = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (webbankpay.equals ("AGPay"))
			{
				//根据请求URL的IP地址判断是否是测试环境139.196.150.190，默认测试环境开通余额支付，便于开发测试
				if (request.getServerName ().equals ("139.196.150.190"))
				{
					String pwd = request.getParameter ("payment_pwd");
					if (!pwd.toString ().equals (user.getPayPassword ().toString ()))
					{
						mv = new JModelAndView ("cart/cart_pay_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("msg" , "密码有误");
						return mv;
					}
				}
				else
				{
					mv = new JModelAndView ("cart/cart_pay_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("msg" , "功能正在升级中，敬请期待！");
					return mv;
				}
			}
			if (orderIds == null)
			{
				return returnToCart (mv , request , response);
			}
			List <String> orderIdList = getStringFromString (orderIds , ",");
			if (orderIdList.isEmpty () || webbankpay == null || webbankpay.equals (""))
			{
				return returnToOrderError (mv , request , response);
			}
			AlipayOrder alipayOrder = null;
			/* 判断是否以前支付过 */
			if (isExistAlipayOrder (orderIdList.get (Globals.NUBER_ZERO)) != null)
			{
				of = this.getOrderFormOfOrderId (orderIdList.get (Globals.NUBER_ZERO) , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
				if (of != null)
				{
					return generatePayInfo (webbankpay , of , mv , request , response);
				}
			}
			if (orderIdList.size () == Globals.NUBER_ONE)
			{
				alipayOrder = new AlipayOrder ();
				of = this.getOrderFormOfOrderId (orderIdList.get (Globals.NUBER_ZERO) , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
				if (of != null)
				{
					alipayOrder.setOrderId (orderIdList.get (Globals.NUBER_ZERO));
					alipayOrder.setTotalFee (of.getTotalprice ());
					of.setAlipayorderId (saveNewAlipayOrder (alipayOrder).getId ());
					this.orderFormService.updateByObject (of);
					// 订单支付完毕，订单中商品的销量相应的增加
					List <OrderFormItem> orderFormItemList = getOrderFormItemList (of.getId ());
					for (OrderFormItem orderFormItem : orderFormItemList)
					{
						GoodsWithBLOBs goods = this.goodsService.getByKey (orderFormItem.getGoodsId ());
						int saleSum = goods.getGoodsSalenum () + orderFormItem.getGoodsCount ();
						goods.setGoodsSalenum (saleSum);
						this.goodsService.updateByObject (goods);
					}
					return generatePayInfo (webbankpay , of , mv , request , response);
				}
			}
			else if (orderIdList.size () > Globals.NUBER_ONE)
			{
				/* 订单号大于1个则生成个新订单号作为关联订单 */
				alipayOrder = new AlipayOrder ();
				BigDecimal payment = new BigDecimal (Globals.NUBER_ZERO);
				/* 存在不满足订单直接返回错误 */
				for (String orderId : orderIdList)
				{
					of = this.getOrderFormOfOrderId (orderId , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
					if (of == null)
					{
						return returnToOrderError (mv , request , response);
					}
					payment = payment.add (of.getTotalprice ());
				}
				alipayOrder.setTotalFee (payment);
				alipayOrder.setOrderId (CommUtil.generateOrderId ());
				alipayOrder = saveNewAlipayOrder (alipayOrder);
				for (String orderId : orderIdList)
				{
					of = this.getOrderFormOfOrderId (orderId , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
					of.setAlipayorderId (alipayOrder.getId ());
					this.orderFormService.updateByObject (of);
					// 订单支付完毕，订单中商品的销量相应的增加
					List <OrderFormItem> orderFormItemList = getOrderFormItemList (of.getId ());
					for (OrderFormItem orderFormItem : orderFormItemList)
					{
						GoodsWithBLOBs goods = this.goodsService.getByKey (orderFormItem.getGoodsId ());
						int saleSum = goods.getGoodsSalenum () + orderFormItem.getGoodsCount ();
						goods.setGoodsSalenum (saleSum);
						this.goodsService.updateByObject (goods);
					}
				}
				mv = generatePayInfo (webbankpay , of , mv , request , response);
			}
			return mv;
		}


	/**
	 * @Title: saveNewAlipayOrder
	 * @Description: 保存alipay订单并返回主键
	 * @param alipayOrder
	 * @return
	 * @return Long
	 * @author tangxiang
	 * @date 2015年8月18日 下午8:18:28
	 */
	private AlipayOrder saveNewAlipayOrder (AlipayOrder alipayOrder)
		{
			this.alipayOrderService.add (alipayOrder);
			AlipayOrderExample example = new AlipayOrderExample ();
			example.createCriteria ().andOrderIdEqualTo (alipayOrder.getOrderId ()).andTotalFeeEqualTo (alipayOrder.getTotalFee ());
			return this.alipayOrderService.getObjectList (example).get (Globals.NUBER_ZERO);
		}


	private void fullOrderForm (Goods goods , OrderFormWithBLOBs bloBs , String specInfo , Map <Long, String> shipMap ,
								Long userId , boolean directBuy)
		{
			BigDecimal payment = new BigDecimal (Globals.NUBER_ZERO);
			BigDecimal shipFee = new BigDecimal (Globals.NUBER_ZERO);
			String cartUUID = null;
			OrderFormItem formItem;
			if (!directBuy)
			{
				cartUUID = isAreadyRecordForCart (userId);
			}
			else
			{
				cartUUID = getRecordForCartDetail (null , goods.getId () , null , directBuy , false).getGoodsCartId ();
			}
			/* 锁定商品列表信息 */
			CartDetail cartDetail = getRecordForCartDetail (cartUUID , goods.getId () , specInfo , directBuy , false);
			cartDetail.setDeleteStatus (true);
			this.cartDetailService.updateByObject (cartDetail);
			/* 获取价格 */
			if (cartDetail.getType () != null && !cartDetail.getType ().equals (""))
			{
				payment = payment.add (getSpecialGoodsPrice (goods.getId () , cartDetail.getType ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
			}
			else
			{
				payment = payment.add (getGoodsPrice (goods.getId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
			}
			/* 获取邮费 */
			if (shipMap.get (goods.getId ()) != null)
			{
				shipFee = shipFee.add (getGoodsTransFee (goods.getId () , shipMap.get (goods.getId ()) , cartDetail.getGoodsCount ()));
			}
			bloBs.setTotalprice (payment.add (shipFee));
			bloBs.setShipPrice (shipFee);
			bloBs.setGoodsAmount (payment);
			this.orderFormService.add (bloBs);
			/* 填充订单详情表 */
			// 根据UUID获得购物车，并取得当中指定id的cartDetail集合，商品id相同的cartDetail可能有多个，因为相同的商品存在规格参数不同
			List <CartDetail> cartDetails = getRecordForCartDetails (cartUUID , goods.getId () , specInfo , directBuy , true);
			for (CartDetail detail : cartDetails)
			{
				formItem = new OrderFormItem ();
				formItem.setAddTime (new Date ());
				formItem.setDirectBuy (directBuy);
				formItem.setGoodsCount (detail.getGoodsCount ());
				formItem.setGoodsId (goods.getId ());
				formItem.setGoodsName (goods.getGoodsName ());
				formItem.setGoodsPhoto (goods.getGoodsMainPhotoId ());
				formItem.setGoodsRate (goods.getGc ().getRate ());
				formItem.setRefundServer (goods.getRefundServerTime ());
				if (detail.getType () != null && !detail.getType ().equals (""))
				{
					formItem.setGoodsPrice (getSpecialGoodsPrice (goods.getId () , detail.getType ()));
				}
				else
				{
					formItem.setGoodsPrice (getGoodsPrice (goods.getId ()));
				}
				formItem.setSpecInfo (detail.getSpecInfo ());
				formItem.setLeeStatus (false);
				formItem.setOrderId (getOrderFormOfOrderId (bloBs.getOrderId () , null).getId ());
				this.orderFormItemService.add (formItem);
			}
			/* 生成订单日志记录 */
			OrderFormLog formLog = new OrderFormLog ();
			formLog.setAddtime (new Date ());
			formLog.setLogUserId (bloBs.getUserId ());
			formLog.setStateInfo (bloBs.getOrderStatus ().toString ());
			formLog.setOfId (Long.valueOf (bloBs.getOrderId ()));
			formLog.setLogInfo (Globals.WAIT_PAYMENT_ORDER_NAME);
			this.orderFormLogService.add (formLog);
		}


	/**
	 * @Title: isExistAlipayOrder
	 * @Description: 查找是否在订单中已经存在支付订单号
	 * @param orderId
	 * @return
	 * @return AlipayOrder
	 * @author tangxiang
	 * @date 2015年8月19日 下午3:25:36
	 */
	private AlipayOrder isExistAlipayOrder (String orderId)
		{
			AlipayOrder alipayOrder = null;
			OrderFormWithBLOBs bloBs = getOrderFormOfOrderId (orderId , String.valueOf (Globals.WAIT_PAYMENT_ORDER));
			if (bloBs.getAlipayorderId () != null && bloBs.getAlipayorderId () > Globals.NUBER_ZERO)
			{
				alipayOrder = this.alipayOrderService.getByKey (bloBs.getAlipayorderId ());
				alipayOrder.setOrderId (CommUtil.generateOrderId ());
				alipayOrderService.updateByObject (alipayOrder);
			}
			return alipayOrder;
		}


	/**
	 * @Title: getOrderFormOfOrderId
	 * @Description: 根据订单ID获取订单对象
	 * @param orderId
	 * @return
	 * @return OrderFormWithBLOBs
	 * @author tangxiang
	 * @date 2015年8月11日 下午6:07:37
	 */
	public OrderFormWithBLOBs getOrderFormOfOrderId (	String orderId , String orderStatus)
		{
			List <OrderFormWithBLOBs> list = new ArrayList <OrderFormWithBLOBs> ();
			OrderFormExample example = new OrderFormExample ();
			example.clear ();
			com.amall.core.bean.OrderFormExample.Criteria criteria = example.createCriteria ();
			criteria.andOrderIdEqualTo (orderId);
			if (orderStatus != null)
			{
				criteria.andOrderStatusEqualTo (Integer.valueOf (orderStatus));
			}
			list = this.orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return null;
			}
			return list.get (Globals.NUBER_ZERO);
		}


	public List <String> getUserOrder (	Long userId)
		{
			List <String> list = new ArrayList <String> ();
			List <OrderFormWithBLOBs> orderFormList;
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.createCriteria ().andUserIdEqualTo (userId).andOrderStatusEqualTo (10);
			orderFormList = this.orderFormService.getObjectList (orderFormExample);
			if (!orderFormList.isEmpty ())
			{
				for (OrderFormWithBLOBs orderFormWithBLOBs : orderFormList)
				{
					list.add (orderFormWithBLOBs.getOrderId ());
				}
			}
			return list;
		}


	/**
	 * @Title: lockGoods
	 * @Description: 锁定商品,失败则回退
	 * @param goodsIds
	 * @param userId
	 * @return
	 * @return boolean
	 * @author tangxiang
	 * @date 2015年8月12日 下午5:59:14
	 */
	public synchronized boolean lockGoods (	List <Long> goodsIds , Long userId , boolean directBuy)
		{
			CartDetail cartDetail = null;
			List <Integer> cartCounts = new ArrayList <Integer> ();
			int rollbackCount = Globals.NUBER_ZERO;
			String cartUUID = null;
			if (!directBuy)
			{
				cartUUID = isAreadyRecordForCart (userId);
			}
			else
			{
				cartUUID = getRecordForCartDetail (null , goodsIds.get (Globals.NUBER_ZERO) , null , directBuy , false).getGoodsCartId ();
			}
			/* 根据商品ID和用户，获取有效购物商品数量 */
			for (Long id : goodsIds)
			{
				cartDetail = getRecordForCartDetail (cartUUID , id , null , directBuy , false);
				if (cartDetail == null)
				{
					return false;
				}
				cartCounts.add (cartDetail.getGoodsCount ());
			}
			/* 删除库存，数量先从规格表找，没有再从商品表找 */
			for (int i = 0 ; i < goodsIds.size () ; i++)
			{
				if (!removeRepository (goodsIds.get (i) , cartCounts.get (i)))
				{
					break;
				}
				rollbackCount++;
			}
			/* 判断是否全部删除成功，没有则回退 */
			if (rollbackCount != goodsIds.size ())
			{
				for (int i = 0 ; i <= rollbackCount ; i++)
				{
					addRepository (goodsIds.get (i) , cartCounts.get (i));
				}
				return false;
			}
			return true;
		}


	/**
	 * @Title: removeRepository
	 * @Description: 删除库存
	 * @param goodsId
	 * @param count
	 * @return
	 * @return boolean
	 * @author tangxiang
	 * @date 2015年8月13日 上午10:22:30
	 */
	private boolean removeRepository (	Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			if (goods != null)
			{
				return removeGoodsRepository (goods , count);
			}
			return false;
		}


	private List <String> checkStringInfo (	String str , int size)
		{
			List <String> list = new ArrayList <String> (size);
			list = getStringFromString (str , "\\|");
			if (list.isEmpty ())
			{
				for (int i = 0 ; i < size ; i++)
				{
					list.add (" ");
				}
			}
			if (list.size () < size)
			{
				for (int i = list.size () ; i < size ; i++)
				{
					list.add (" ");
				}
			}
			return list;
		}


	/**
	 * @Title: removeGoodsRepository
	 * @Description: 删除商品表库存
	 * @param goods
	 *            商品
	 * @param count
	 *            要删除的数量
	 * @return
	 * @return boolean
	 * @author tangxiang
	 * @date 2015年8月12日 下午7:54:01
	 */
	private boolean removeGoodsRepository (	GoodsWithBLOBs goods , Integer count)
		{
			/* 比较数量 */
			if (goods.getGoodsInventory () < count)
			{
				return false;
			}
			/* 修改DBA数量 */
			goods.setGoodsInventory (goods.getGoodsInventory () - count);
			this.goodsService.updateByObject (goods);
			return true;
		}


	/**
	 * @Title: addGoodsRepository
	 * @Description: 增加商品表库存
	 * @param goodsId
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月12日 下午8:17:35
	 */
	private void addGoodsRepository (	GoodsWithBLOBs goods , Integer count)
		{
			/* 修改DBA数量 */
			goods.setGoodsInventory (goods.getGoodsInventory () + count);
			// 修改销量
			goods.setGoodsSalenum (goods.getGoodsSalenum () - count);
			this.goodsService.updateByObject (goods);
		}


	/**
	 * @Title: addRepository
	 * @Description: 增加库存
	 * @param goodsId
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月12日 下午8:27:28
	 */
	public void addRepository (	Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			addGoodsRepository (goods , count);
		}


	/**
	 * @Title: returnPayPage
	 * @Description: 配置返回支付页面
	 * @param webbankpay
	 * @param payId
	 * @param mv
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 * @author tangxiang
	 * @date 2015年8月19日 上午10:59:30
	 */
	public ModelAndView returnPayPage (	String webbankpay , Long payId , String goodsName , String type ,
										ModelAndView mv , HttpServletRequest request , HttpServletResponse response)
		{
			if (webbankpay.equals ("alipay") || webbankpay.equals ("Unionpay"))
			{
				mv = new JModelAndView ("line_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("payType" , webbankpay);
				mv.addObject ("url" , CommUtil.getURL (request));
				mv.addObject ("payTools" , this.payTools);
				mv.addObject ("type" , type);
				mv.addObject ("alipayOrderId" , payId);
			}
			if (webbankpay.equals ("WXPay"))
			{
				String pre_str = null;
				/**
				 * 模式一
				 * String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
				 * Long time_stamp = System.currentTimeMillis() / 1000;
				 * 
				 * pre_str = "weixin://wxpay/bizpayurl?sign=" + WXPay.sign(nonce_str,
				 * time_stamp.toString(), payId.toString())
				 * + "&appid=" + Configure.APP_ID + "&mch_id=" + Configure.MCH_ID
				 * + "&product_id=" + payId + "&time_stamp=" + time_stamp + "&nonce_str=" +
				 * nonce_str;
				 **/
				// 模式二
				pre_str = payTools.genericWXPay (CommUtil.getURL (request) , payId , goodsName , type);
				if (pre_str != null)
				{
					mv = new JModelAndView ("wx_pay_pre.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/* 不包含weixin表示订单号重复了 */
					if (pre_str.contains ("weixin"))
					{
						mv.addObject ("pre_str" , pre_str);
						mv.addObject ("payId" , payId);
					}
					else
					{
						mv.addObject ("message" , pre_str);
					}
				}
			}
			else if (webbankpay.equals ("AGPay"))
			{
				String AGPay = null;
				AGPay = payTools.genericAGPay (CommUtil.getURL (request) , payId , goodsName , type);
				if (AGPay != null)
				{
					mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					/*
					 * AlipayOrder of = null;//多个订单对应新生成的订单
					 * of = this.alipayOrderService.getByKey(payId);
					 * String outTradeNo = of.getOrderId();// 订单号
					 */mv.addObject ("op_title" , "支付成功");
					mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "支付失败，余额不足以支付!");
					mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
				}
			}
			return mv;
		}


	public ModelAndView returnToCart (	ModelAndView mv , HttpServletRequest request , HttpServletResponse response)
		{
			mv = new JModelAndView ("cart/cart_index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	public ModelAndView returnToOrderError (ModelAndView mv , HttpServletRequest request , HttpServletResponse response)
		{
			mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "支付方式错误！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/index.htm");
			return mv;
		}


	public ModelAndView returnToIndex (	ModelAndView mv , HttpServletRequest request , HttpServletResponse response)
		{
			mv = new JModelAndView ("index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}


	/**
	 * 分割商品ID字符串
	 * <p>
	 * Title: getGoodsIdsFromString
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param goodsIdsAndPropertys
	 * @return
	 */
	public List <Long> getGoodsIdsFromString (	String goodsIdsAndPropertys)
		{
			String [ ] goodsIdArr = goodsIdsAndPropertys.trim ().split ("\\|");
			List <Long> ids = new ArrayList <Long> ();
			for (int i = 0 ; i < goodsIdArr.length ; i++)
			{
				if (goodsIdArr[i] != null && !goodsIdArr[i].equals (""))
				{
					int end = goodsIdArr[i].indexOf ("=");
					String id;
					if (end != -1)
					{
						id = goodsIdArr[i].substring (0 , end);
					}
					else
					{
						id = goodsIdArr[i];
					}
					if (isNum (id))
					{
						ids.add (Long.parseLong (id));
					}
				}
			}
			return ids;
		}


	/**
	 * 分割商品属性字符串
	 * <p>
	 * Title: getGoodsPropertysFromString
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param goodsIdsAndPropertys
	 * @return
	 */
	public List <String> getGoodsPropertysFromString (	String goodsIdsAndPropertys)
		{
			String [ ] propertyArr = goodsIdsAndPropertys.trim ().split ("\\|");
			List <String> propertys = new ArrayList <String> ();
			for (int i = 0 ; i < propertyArr.length ; i++)
			{
				if (propertyArr[i] != null && !propertyArr[i].equals (""))
				{
					String tempStr = propertyArr[i].trim ();
					int start = tempStr.indexOf ("=");
					int end = tempStr.length ();
					String propertyStr = null;
					if (end - start > 1)
					{
						propertyStr = tempStr.substring (start + 1 , end);
					}
					propertys.add (propertyStr);
				}
			}
			return propertys;
		}


	public List <Long> getGoodsPropertysFromString (String goodsIds , String splitStr)
		{
			String [ ] goodsIdArr = goodsIds.trim ().split (splitStr);
			List <Long> ids = new ArrayList <Long> ();
			for (int i = 0 ; i < goodsIdArr.length ; i++)
			{
				if (goodsIdArr[i] != null && !goodsIdArr[i].equals (""))
				{
					if (isNum (goodsIdArr[i]))
					{
						ids.add (Long.parseLong (goodsIdArr[i]));
					}
				}
			}
			return ids;
		}


	/**
	 * @Title: getGoodsIdsFromCart
	 * @Description: 分割商品结算时的商品Id字段
	 * @param goodsIds
	 * @param splitStr
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月21日
	 */
	public List <Long> getGoodsIdsFromCart (String goodsIds , String splitStr)
		{
			String [ ] goodsIdArr = goodsIds.trim ().split (splitStr);
			List <Long> ids = new ArrayList <Long> ();
			for (int i = 0 ; i < goodsIdArr.length ; i++)
			{
				if (goodsIdArr[i] != null && !goodsIdArr[i].equals (""))
				{
					ids.add (Long.parseLong (goodsIdArr[i].split ("\\^")[0]));
				}
			}
			return ids;
		}


	/**
	 * @Title: getGoodsSpecFromCart
	 * @Description: 分割商品结算时的商品规格属性
	 * @param goodsIds
	 * @param splitStr
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月21日
	 */
	public List <String> getGoodsSpecFromCart (	String goodsIds , String splitStr)
		{
			String [ ] goodsIdArr = goodsIds.trim ().split (splitStr);
			List <String> specs = new ArrayList <String> ();
			for (int i = 0 ; i < goodsIdArr.length ; i++)
			{
				if (goodsIdArr[i] != null && !goodsIdArr[i].equals (""))
				{
					String [ ] spec = goodsIdArr[i].split ("\\^");
					if (spec.length == 2 && !spec[1].equals (""))
					{
						specs.add (spec[1]);
					}
					else
					{
						specs.add (null);
					}
				}
			}
			return specs;
		}


	/**
	 * @Title: getShipMap
	 * @Description: 邮寄map 存放商品id和这个商品选择的邮寄类型
	 * @param str
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月28日
	 */
	private Map <Long, String> getShipMap (	String str)
		{
			Map <Long, String> map = new HashMap <> ();
			String [ ] arr1 = str.trim ().split ("\\|");
			for (String str1 : arr1)
			{
				if (!str1.equals (""))
				{
					String k = str1.split ("`")[Globals.NUBER_ZERO];
					String v = str1.split ("`")[Globals.NUBER_ONE];
					if (!k.equals ("") && !v.equals (""))
					{
						map.put (Long.valueOf (k) , v);
					}
				}
			}
			return map;
		}


	/**
	 * 分割字符串
	 * <p>
	 * Title: getStringFromString
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public List <String> getStringFromString (	String str , String splitStr)
		{
			String [ ] goodsIdArr = str.trim ().split (splitStr);
			List <String> strs = new ArrayList <String> ();
			for (int i = 0 ; i < goodsIdArr.length ; i++)
			{
				if (goodsIdArr[i] != null && !goodsIdArr[i].equals (""))
				{
					strs.add (goodsIdArr[i].trim ());
				}
			}
			return strs;
		}


	/**
	 * @Title: getStoreHashSetOfGoodsId
	 * @Description: 根据商品Id List找到店铺
	 * @param ids
	 * @return
	 * @return HashSet<Store>
	 * @author tangxiang
	 * @date 2015年8月11日 下午4:22:05
	 */
	private List <Long> getStoreHashSetOfGoodsId (	List <Long> ids)
		{
			List <Long> storeIds = new ArrayList <> ();
			/* 获取店铺ID */
			for (Long id : ids)
			{
				if (!storeIds.contains (id))
				{
					storeIds.add (this.goodsService.getByKey (id).getGoodsStoreId ());
				}
			}
			return storeIds;
		}


	/**
	 * 
	 * <p>
	 * Title: saveCartAndDetail
	 * </p>
	 * <p>
	 * Description: 添加Cart和CartDetail
	 * </p>
	 * 
	 * @param cart
	 * @param cartDetail
	 */
	public void saveCartAndDetail (	Cart cart , CartDetail cartDetail , String goodsCartId , User user ,
									String goodsId , String goodsCount , String specInfo , String type , String specId)
		{
			cart.setAddtime (new Date ());
			cart.setGoodsCartId (goodsCartId);
			cart.setStatus (true);
			cart.setUserId (user.getId ());
			BigDecimal price = this.getGoodsPrice (CommUtil.null2Long (goodsId));
			cart.setPayment (price.multiply (new BigDecimal (goodsCount)));
			this.cartService.add (cart);
			cartDetail.setAddTime (new Date ());
			cartDetail.setDirectBuy (true);
			cartDetail.setGoodsCartId (goodsCartId);
			cartDetail.setGoodsCount (CommUtil.null2Int (goodsCount));
			cartDetail.setGoodsId (CommUtil.null2Long (goodsId));
			cartDetail.setSpecInfo (specInfo);
			cartDetail.setType (type);
			cartDetail.setSpecId (specId);
			cartDetail.setUserId (user.getId ());
			this.cartDetailService.add (cartDetail);
		}


	/**
	 * 匹配0-9的数值
	 * <p>
	 * Title: isNum
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNum (	String str)
		{
			return str.matches ("[0-9]+");
		}


	/**
	 * 合并条目表和主表价格
	 * <p>
	 * Title: mergeCartAndCartDetailPrice
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param goodsCartIdName
	 */
	public String mergeCartAndCartDetailPrice (	List <CartDetail> cartDetailList , Cart cart)
		{
			Goods goods;
			BigDecimal totalPayment = new BigDecimal (0);
			BigDecimal count;
			for (CartDetail c : cartDetailList)
			{
				goods = this.goodsService.getByKey (c.getGoodsId ());
				count = new BigDecimal (c.getGoodsCount ());
				BigDecimal price = this.getGoodsPrice (goods.getId ());
				totalPayment = totalPayment.add (count.multiply (price));
			}
			cart.setPayment (totalPayment);
			return cart.getPayment ().toString ();
		}


	/**
	 * @Title: isAreadyOrder
	 * @Description: 判断是否订单重复
	 * @param userId
	 * @param orderId
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月11日 下午4:11:39
	 */
	public String isAreadyOrder (	Long userId , String orderId)
		{
			List <OrderFormWithBLOBs> orderFormlist = new ArrayList <OrderFormWithBLOBs> ();
			OrderFormExample orderFormExample = new OrderFormExample ();
			orderFormExample.clear ();
			orderFormExample.createCriteria ().andUserIdEqualTo (userId).andOrderIdEqualTo (orderId);
			orderFormlist = this.orderFormService.getObjectList (orderFormExample);
			if (orderFormlist.isEmpty ())
			{
				return null;
			}
			return orderFormlist.get (Globals.NUBER_ZERO).getId ().toString ();
		}


	/**
	 * 根据UserID和Status为true获取未付款购物车
	 * <p>
	 * Title: isAreadyRecordForCart
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userId
	 * @return
	 */
	public String isAreadyRecordForCart (	Long userId)
		{
			List <Cart> cartList = new ArrayList <Cart> ();
			CartExample cartExample = new CartExample ();
			cartExample.clear ();
			cartExample.createCriteria ().andUserIdEqualTo (userId).andStatusEqualTo (true);
			cartList = this.cartService.getObjectList (cartExample);
			if (cartList.isEmpty ())
			{
				return null;
			}
			return cartList.get (Globals.NUBER_ZERO).getGoodsCartId ();
		}


	/**
	 * @Title: getRecordForCart
	 * @Description: 根据cartUUID获取，用户ID，购物车状态获取购物车
	 * @param userId
	 * @param cartUUID
	 * @return
	 * @return Cart
	 * @author tangxiang
	 * @date 2015年8月10日 下午3:29:55
	 */
	public Cart getRecordForCart (	Long userId , String cartUUID , boolean cartStatus)
		{
			List <Cart> cartList = new ArrayList <Cart> ();
			CartExample cartExample = new CartExample ();
			cartExample.clear ();
			cartExample.createCriteria ().andUserIdEqualTo (userId).andStatusEqualTo (cartStatus).andGoodsCartIdEqualTo (cartUUID);
			cartList = this.cartService.getObjectList (cartExample);
			if (cartList.isEmpty ())
			{
				return null;
			}
			return cartList.get (Globals.NUBER_ZERO);
		}


	/**
	 * @Title: getRecordForCart
	 * @Description: 根据用户Id和购物车状态获取购物车
	 * @param userId
	 * @param cartStatus
	 * @return
	 * @return Cart
	 * @author tangxiang
	 * @date 2015年8月11日 下午6:03:06
	 */
	public Cart getRecordForCart (	Long userId , boolean cartStatus , boolean isDirectBuy)
		{
			/* 是直接购买需要根据购物车详情表获取到购物车 */
			if (isDirectBuy)
			{
				List <CartDetail> detailList = new ArrayList <> ();
				CartDetailExample detailExample = new CartDetailExample ();
				detailExample.createCriteria ().andUserIdEqualTo (userId).andDirectBuyEqualTo (isDirectBuy);
				detailList = this.cartDetailService.getObjectList (detailExample);
				if (detailList.isEmpty ())
				{
					return null;
				}
				return this.cartService.getByKey (detailList.get (0).getCartId ());
			}
			List <Cart> cartList = new ArrayList <Cart> ();
			CartExample cartExample = new CartExample ();
			cartExample.createCriteria ().andUserIdEqualTo (userId).andStatusEqualTo (cartStatus);
			cartList = this.cartService.getObjectList (cartExample);
			if (cartList.isEmpty ())
			{
				return null;
			}
			return cartList.get (Globals.NUBER_ZERO);
		}


	@RequestMapping({ "/order_finish.htm" })
	public ModelAndView order_finish (	HttpServletRequest request , HttpServletResponse response , String goodsId ,
										String cartUUID , String goodsProperty)
		{
			ModelAndView mv = new JModelAndView ("order_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv.addObject ("userid" , user.getId ());
				mv.addObject ("vipshareurl_pre" , Globals.vipshareurl_pre);
			}
			return mv;
		}


	/**
	 * @Title: getRecordForCartDetail
	 * @Description: 根据cartUUID获取多条记录
	 * @param cartUUID
	 * @param directBuy
	 * @param deleteStatus
	 * @return
	 * @return CartDetail
	 * @author tangxiang
	 * @date 2015年8月13日 上午9:30:04
	 */
	public List <CartDetail> getRecordForCartDetail (	String cartUUID , boolean directBuy , boolean deleteStatus ,
														Long cartId)
		{
			List <CartDetail> CartDetailList = new ArrayList <CartDetail> ();
			CartDetailExample cartDetailExample = new CartDetailExample ();
			cartDetailExample.clear ();
			Criteria criteria = cartDetailExample.createCriteria ();
			if (cartUUID != null)
			{
				criteria.andGoodsCartIdEqualTo (cartUUID);
			}
			if (cartId != null)
			{
				criteria.andCartIdEqualTo (cartId);
			}
			criteria.andDeleteStatusEqualTo (deleteStatus).andDirectBuyEqualTo (directBuy);
			CartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
			return CartDetailList;
		}


	/**
	 * @Title: getRecordForCartDetail
	 * @Description: 根据cartUUID商品ID商品属性商品状态获取商品列表记录(包含了ID相同但是规格不同的的商品)
	 * @param cartUUID
	 * @param goodsId
	 * @param goodsProperty
	 * @param directBuy
	 * @param deleteStatus
	 * @return
	 * @return CartDetail
	 * @author xpy
	 * @date 2015年9月22日 下午3:09:19
	 */
	public List <CartDetail> getRecordForCartDetails (	String cartUUID , Long goodsId , String goodsProperty ,
														boolean directBuy , boolean deleteStatus)
		{
			List <CartDetail> CartDetailList = new ArrayList <CartDetail> ();
			CartDetailExample cartDetailExample = new CartDetailExample ();
			cartDetailExample.clear ();
			Criteria criteria = cartDetailExample.createCriteria ();
			if (cartUUID != null)
			{
				criteria.andGoodsCartIdEqualTo (cartUUID);
			}
			if (goodsProperty != null)
			{
				criteria.andSpecInfoEqualTo (goodsProperty);
			}
			criteria.andGoodsIdEqualTo (goodsId).andDeleteStatusEqualTo (deleteStatus).andDirectBuyEqualTo (directBuy);
			CartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
			if (CartDetailList == null || CartDetailList.isEmpty ())
			{
				return null;
			}
			return CartDetailList;
		}


	/**
	 * @Title: getRecordForCartDetail
	 * @Description: 根据cartUUID商品ID商品属性商品状态获取商品列表一条记录
	 * @param cartUUID
	 * @param goodsId
	 * @param goodsProperty
	 * @param directBuy
	 * @param deleteStatus
	 * @return
	 * @return CartDetail
	 * @author tangxiang
	 * @date 2015年8月18日 下午3:09:19
	 */
	public CartDetail getRecordForCartDetail (	String cartUUID , Long goodsId , String goodsProperty ,
												boolean directBuy , boolean deleteStatus)
		{
			List <CartDetail> CartDetailList = new ArrayList <CartDetail> ();
			CartDetailExample cartDetailExample = new CartDetailExample ();
			cartDetailExample.clear ();
			Criteria criteria = cartDetailExample.createCriteria ();
			if (cartUUID != null)
			{
				criteria.andGoodsCartIdEqualTo (cartUUID);
			}
			// if(goodsProperty != null)
			// {
			// criteria.andSpecInfoEqualTo(goodsProperty);
			// }
			criteria.andGoodsIdEqualTo (goodsId).andDeleteStatusEqualTo (deleteStatus).andDirectBuyEqualTo (directBuy);
			CartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
			if (CartDetailList == null || CartDetailList.isEmpty ())
			{
				return null;
			}
			return CartDetailList.get (Globals.NUBER_ZERO);
		}


	/**
	 * @Title: isHaveBuyGoods
	 * @Description: 判断是否存在商品
	 * @param cartUUID
	 * @param goodsId
	 * @param goodsProperty
	 * @param directBuy
	 * @param deleteStatus
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月21日
	 */
	private CartDetail isHaveBuyGoods (	String cartUUID , Long goodsId , String goodsProperty , boolean directBuy ,
										boolean deleteStatus)
		{
			CartDetailExample cartDetailExample = new CartDetailExample ();
			Criteria criteria = cartDetailExample.createCriteria ();
			if (cartUUID != null)
			{
				criteria.andGoodsCartIdEqualTo (cartUUID);
			}
			if (goodsProperty != null)
			{
				criteria.andSpecInfoEqualTo (goodsProperty);
			}
			criteria.andGoodsIdEqualTo (goodsId).andDeleteStatusEqualTo (deleteStatus).andDirectBuyEqualTo (directBuy);
			List <CartDetail> cartDetails = this.cartDetailService.getObjectList (cartDetailExample);
			return cartDetails.size () > 0 ? cartDetails.get (0) : null;
		}


	/**
	 * @Title: returnGoodsCountOfUserIdOrCookie
	 * @Description: 获取商品数量
	 * @param user
	 * @param cookies
	 * @return
	 * @return Integer
	 * @author tangxiang
	 * @date 2015年8月10日 下午6:55:04
	 */
	public Integer returnGoodsCountOfUserIdOrCookie (	User user , Cookie [ ] cookies)
		{
			Integer count = Globals.NUBER_ZERO;
			if (user == null)
			{
				count = getCountFromCookie (cookies);
			}
			else
			{
				count = getCountFromCartDetail (user.getId ());
			}
			return count;
		}


	/**
	 * @Title: getCountFromCartDetail
	 * @Description: 根据用户ID从数据库获取商品数量
	 * @param userId
	 * @return
	 * @return Integer
	 * @author tangxiang
	 * @date 2015年8月10日 下午6:38:55
	 */
	private Integer getCountFromCartDetail (Long userId)
		{
			Integer count = Globals.NUBER_ZERO;
			String cartUUID = isAreadyRecordForCart (userId);
			if (cartUUID == null)
			{
				return 0;
			}
			List <CartDetail> list = getRecordForCartDetail (cartUUID , false , false , null);
			if (list.isEmpty ())
			{
				return count;
			}
			for (CartDetail cartDetail : list)
			{
				count += cartDetail.getGoodsCount ();
			}
			return count;
		}


	/**
	 * @Title: getCountFromCookie
	 * @Description: 从cookie中获取商品数量
	 * @param request
	 * @return
	 * @return Integer
	 * @author tangxiang
	 * @date 2015年8月10日 下午6:39:18
	 */
	public Integer getCountFromCookie (	Cookie [ ] cookies)
		{
			Integer count = Globals.NUBER_ZERO;
			Cookie cookie = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , cookies);
			if (cookie == null || cookie.getValue () == null || cookie.getValue ().equals (""))
			{
				return count;
			}
			List <Object> list;
			try
			{
				list = CommUtil.jsonToBeanList (URLDecoder.decode (cookie.getValue () , "UTF-8") , GoodsCartShow.class);
				for (Object obj : list)
				{
					GoodsCartShow cartShow = (GoodsCartShow) obj;
					count += Integer.valueOf (cartShow.getCount ());
				}
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
			return count;
		}


	/**
	 * 根据商品条目列表查找商品
	 * <p>
	 * Title: getRecordForGoods
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param cartDetailList
	 * @return
	 */
	public List <Goods> getRecordForGoods (	List <CartDetail> cartDetailList)
		{
			List <Goods> goodsList = new ArrayList <Goods> ();
			for (CartDetail cartDetail : cartDetailList)
			{
				goodsList.add (this.goodsService.getByKey (cartDetail.getGoodsId ()));
			}
			return goodsList;
		}


	/**
	 * @Title: getPaymentFromCartDetail
	 * @Description: 取得支付价格
	 * @param goodsCartId
	 * @param deleteStatus
	 * @param directBuy
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月8日 下午5:01:03
	 */
	public BigDecimal getPaymentFromCartDetail (String cartUUID , boolean deleteStatus , boolean directBuy)
		{
			BigDecimal price;
			BigDecimal goodsCount;
			BigDecimal payment = new BigDecimal (0);
			List <CartDetail> cartDetailList = getRecordForCartDetail (cartUUID , directBuy , deleteStatus , null);
			List <Goods> goodsList = getRecordForGoods (cartDetailList);
			if (goodsList != null)
			{
				for (int i = 0 ; i < goodsList.size () ; i++)
				{
					goodsCount = new BigDecimal (cartDetailList.get (i).getGoodsCount ());
					price = this.getGoodsPrice (goodsList.get (i).getId ());
					payment = payment.add (price.multiply (goodsCount));
				}
			}
			return payment;
		}


	/**
	 * @Title: getStoreOfGoodsId
	 * @Description: 获取店铺实体
	 * @param goodsId
	 * @return
	 * @return Store
	 * @author tangxiang
	 * @date 2015年8月8日 下午5:07:02
	 */
	public Store getStoreOfGoodsId (Long goodsId)
		{
			return this.goodsService.getByKey (goodsId).getGoodsStore ();
		}


	/**
	 * 持久化购物车主表信息
	 * <p>
	 * Title: saveCartMainInfo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param goodsCartId
	 * @param userId
	 * @param goodsCount
	 * @param goodsId
	 * @param specId
	 */
	public void saveCartMainInfo (	String goodsCartId , Long userId)
		{
			Cart cart = new Cart ();
			cart.setGoodsCartId (goodsCartId);
			cart.setAddtime (new Date ());
			cart.setStatus (true);
			cart.setUserId (userId);
			this.cartService.add (cart);
		}


	/**
	 * 测试读取所有cookie
	 * <p>
	 * Title: testReadCartFromCookie
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 */
	public void testReadCartFromCookie (HttpServletRequest request)
		{
			System.out.println ("======================================================");
			Cookie [ ] cookies = request.getCookies ();
			if (cookies == null || cookies.length == 0)
			{
				System.out.println ("there is no any cookie ..");
			}
			else
			{
				for (Cookie c : cookies)
				{
					try
					{
						System.out.println ("there are many cookies :" + c.getName () + "    " + URLDecoder.decode (c.getValue () , "UTF-8"));
					}
					catch (UnsupportedEncodingException e)
					{
						e.printStackTrace ();
					}
				}
			}
			System.out.println ("======================================================");
		}


	/**
	 * @Title: synchronizationDBCartAndCookieCart
	 * @Description: 用来同步数据库购物和cookie保存的购物
	 * @param userId
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月7日 上午11:51:56
	 */
	public void synchronizationDBCartAndCookieCart (Long userId , HttpServletRequest request ,
													HttpServletResponse response)
		{
			/* 获取DB购物车UUID */
			String cartUUID = isAreadyRecordForCart (userId);
			/* 获取cookie的购物商品信息 */
			Cookie cookie = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , request.getCookies ());
			if (cookie == null || cookie.getValue () == null || cookie.getValue ().equals (""))
			{
				return;
			}
			List <CartDetail> details;
			try
			{
				details = getCartDetailListFromJsonString (URLDecoder.decode (cookie.getValue () , "UTF-8"));
				/* 如果不存在该用户DB购物车，则生成新购物车 */
				if (cartUUID == null || cartUUID.equals (""))
				{
					String cookieUUID = getCookieUUID (request , Globals.GOODS_CART_ID_NAME);
					if (cookieUUID != null && !cookieUUID.equals (""))
					{
						saveCartMainInfo (cookieUUID , userId);
						/* 合并数据 */
						mergeCookieGoodsAndDBGoods (cookieUUID , details);
					}
				}
				else
				{
					/* 合并数据 */
					mergeCookieGoodsAndDBGoods (cartUUID , details);
				}
				/* 删除cookie的购物车信息 */
				CommUtil.removeCookie (Globals.GOODS_CART_ID_NAME , response , request.getCookies ());
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
		}


	/**
	 * @Title: mergeCookieGoodsAndDBGoods
	 * @Description: 合并cookie的商品到数据库
	 * @param strUUID
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月7日 下午2:33:05
	 */
	public void mergeCookieGoodsAndDBGoods (String cartUUID , List <CartDetail> details)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			if (!details.isEmpty ())
			{
				/* 写入cookie商品到数据库, 存在相同的就合并数量 */
				for (CartDetail detail : details)
				{
					/* 判断是否商家自己购买 */
					if (!user.getId ().equals (this.goodsService.getByKey (detail.getGoodsId ()).getGoodsStore ().getUserId ()))
					{
						saveGoodsToDetailDB (cartUUID , detail.getGoodsId () , detail.getDirectBuy () , detail.getSpecInfo () , detail.getGoodsCount () , null);
					}
				}
			}
		}


	/**
	 * @Title: getCartDetailListFromJsonString
	 * @Description: 获取json串中的商品信息，组装成bean
	 *               {[{"cartUUID":"aaxxada_xxxx",
	 *               "goodsId":"1234","goodsProperty":"白色，纯棉，XL，印了熊猫","count":"2"},]}
	 * @return
	 * @return List<GoodsSpec>
	 * @author tangxiang
	 * @date 2015年8月7日 下午2:53:12
	 */
	public List <CartDetail> getCartDetailListFromJsonString (	String jsonStr)
		{
			List <CartDetail> cartDetails = new ArrayList <CartDetail> ();
			List <Object> objs = CommUtil.jsonToBeanList (jsonStr , GoodsCartShow.class);
			if (!objs.isEmpty ())
			{
				CartDetail cartDetail = null;
				for (int i = 0 ; i < objs.size () ; i++)
				{
					GoodsCartShow goodsJson = (GoodsCartShow) objs.get (i);
					cartDetail = new CartDetail ();
					cartDetail.setGoodsCartId (goodsJson.getCartUUID ());
					cartDetail.setGoodsCount (Integer.valueOf (goodsJson.getCount ()));
					cartDetail.setSpecInfo (goodsJson.getGoodsProperty ());
					cartDetail.setGoodsId (Long.valueOf (goodsJson.getGoodsId ()));
					cartDetail.setDirectBuy (false);
					cartDetails.add (cartDetail);
				}
			}
			return cartDetails;
		}


	/**
	 * @Title: saveGoodsToDetailDB
	 * @Description: 保存商品到DBA，若存在相同的则合并商品
	 * @param cartUUID
	 * @param goodsId
	 * @param isDirectBuy
	 *            直接支付状态
	 * @param specInfo
	 * @param goodsCount
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月7日 下午3:25:43
	 */
	public void saveGoodsToDetailDB (	String cartUUID , long goodsId , boolean isDirectBuy , String specInfo ,
										int goodsCount , String type)
		{
			long userId = SecurityUserHolder.getCurrentUser ().getId ();
			/* 查找是否有相同商品， 有则返回商品对象 */
			CartDetail cartDetail = getCartDetailFromGoodsIdAndSpecInfo (cartUUID , goodsId , isDirectBuy , specInfo , false);
			if (cartDetail != null)
			{
				cartDetail.setGoodsCount (cartDetail.getGoodsCount () + goodsCount);
				this.cartDetailService.updateByObject (cartDetail);
			}
			else
			{
				cartDetail = new CartDetail ();
				cartDetail.setAddTime (new Date ());
				cartDetail.setDirectBuy (isDirectBuy);
				cartDetail.setType (type);
				cartDetail.setGoodsId (goodsId);
				cartDetail.setSpecInfo (specInfo);
				cartDetail.setGoodsCount (goodsCount);
				cartDetail.setGoodsCartId (cartUUID);
				cartDetail.setUserId (userId);
				long cartId = saveGoodsToCartDBAndReturnId (userId , cartUUID);
				if (cartId != Globals.RETURN_FAIL)
				{
					cartDetail.setCartId (cartId);
				}
				// type 需要设置 ？
				this.cartDetailService.add (cartDetail);
				System.out.println ("新增物品  cartDetail == : " + cartDetail.getGoodsCount ());
			}
		}


	/**
	 * @Title: saveGoodsToCartDBAndReturnId
	 * @Description: 保存购物车信息，并返回购物车ID，若存在则直接返回购物车ID
	 * @param cartUUID
	 * @param userId
	 * @return
	 * @return Long
	 * @author tangxiang
	 * @date 2015年8月7日 下午3:50:50
	 */
	private Long saveGoodsToCartDBAndReturnId (	long userId , String cartUUID)
		{
			Long cartId = Globals.RETURN_FAIL;
			Cart cart = null;
			cart = getRecordForCart (userId , cartUUID , true);
			if (cart != null)
			{
				cartId = cart.getId ();
			}
			else
			{
				cart = new Cart ();
				cart.setAddtime (new Date ());
				cart.setGoodsCartId (cartUUID);
				cart.setStatus (true);
				cart.setUserId (userId);
				this.cartService.add (cart);
				cartId = getRecordForCart (userId , cartUUID , true).getId ();
			}
			return cartId;
		}


	/**
	 * @Title: getCartDetailForGoodsIdAndSpecInfo
	 * @Description: 根据条件在商品列表中查找商品
	 * @param cartUUID
	 * @param goodsId
	 * @param isDirectBuy
	 * @param specInfo
	 * @return
	 * @return CartDetail
	 * @author tangxiang
	 * @date 2015年8月7日 下午3:26:18
	 */
	private CartDetail getCartDetailFromGoodsIdAndSpecInfo (String cartUUID , long goodsId , boolean isDirectBuy ,
															String specInfo , boolean deleteStatus)
		{
			CartDetail cartDetail = null;
			CartDetailExample detailExample = new CartDetailExample ();
			detailExample.clear ();
			detailExample.createCriteria ().andGoodsCartIdEqualTo (cartUUID).andGoodsIdEqualTo (goodsId).andDirectBuyEqualTo (isDirectBuy).andSpecInfoEqualTo (specInfo).andDeleteStatusEqualTo (deleteStatus);
			List <CartDetail> details = this.cartDetailService.getObjectList (detailExample);
			if (!details.isEmpty ())
			{
				cartDetail = details.get (Globals.NUBER_ZERO);
			}
			return cartDetail;
		}


	/**
	 * @Title: getCookieUUID
	 * @Description: 返回cookieUUID
	 * @param request
	 * @param name
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月7日 下午4:48:52
	 */
	private String getCookieUUID (	HttpServletRequest request , String name)
		{
			String cookieUUID = null;
			Cookie cookie = CommUtil.getCookieValue (name , request.getCookies ());
			if (cookie == null)
			{
				return null;
			}
			String jsonStr;
			try
			{
				jsonStr = URLDecoder.decode (cookie.getValue () , "UTF-8");
				if (jsonStr != null && !jsonStr.equals (""))
				{
					List <Object> objs = CommUtil.jsonToBeanList (jsonStr , GoodsCartShow.class);
					if (!objs.isEmpty ())
					{
						GoodsCartShow goodsJson = (GoodsCartShow) objs.get (0);
						cookieUUID = goodsJson.getCartUUID ();
					}
				}
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
			return cookieUUID;
		}


	/**
	 * @Title: setGoodsToCookie
	 * @Description: 保存商品信息到cookie，若不存在则新增cookie，存在则更新cookie
	 * @param goodsJson
	 * @param cookie
	 * @param response
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 下午2:56:27
	 */
	private boolean setGoodsToCookie (	GoodsCartShow goodsJson , Cookie cookie , HttpServletResponse response)
		{
			if (cookie == null)
			{
				List <GoodsCartShow> list = new ArrayList <GoodsCartShow> ();
				list.add (goodsJson);
				try
				{
					CommUtil.addCookie (Globals.GOODS_CART_ID_NAME , URLEncoder.encode (CommUtil.beanListToJsonStr (list) , "UTF-8") , Globals.YEAR , response);
				}
				catch (UnsupportedEncodingException e)
				{
					e.printStackTrace ();
				}
			}
			else
			{
				String jsonStr = CommUtil.beanToJsonStr (goodsJson);
				/* 首先判断是否重复购买，是则合并 */
				try
				{
					jsonStr = combinationRepeatGoods (jsonStr , URLDecoder.decode (cookie.getValue () , "UTF-8"));
					if (jsonStr == null)
					{
						return false;
					}
					CommUtil.removeCookie (Globals.GOODS_CART_ID_NAME , cookie , response);
					CommUtil.addCookie (Globals.GOODS_CART_ID_NAME , URLEncoder.encode (jsonStr , "UTF-8") , Globals.YEAR , response);
				}
				catch (UnsupportedEncodingException e)
				{
					e.printStackTrace ();
				}
			}
			return true;
		}


	/**
	 * @Title: updateCookieGoodsCount
	 * @Description: 更新Cookie商品数量
	 * @param goodsId
	 * @param count
	 * @param request
	 * @param response
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午4:45:13
	 */
	private void updateCookieGoodsCount (	String goodsId , String goodsCount , String goodsProperty ,
											HttpServletRequest request , HttpServletResponse response)
		{
			Cookie cookie = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , request.getCookies ());
			List <Object> list;
			try
			{
				list = CommUtil.jsonToBeanList (URLDecoder.decode (cookie.getValue () , "UTF-8") , GoodsCartShow.class);
				List <GoodsCartShow> returnList = new ArrayList <GoodsCartShow> (list.size ());
				for (Object obj : list)
				{
					GoodsCartShow cartShow = (GoodsCartShow) obj;
					if (cartShow.getGoodsId ().compareTo (goodsId) == Globals.NUBER_ZERO && cartShow.getGoodsProperty ().equals (goodsProperty))
					{
						cartShow.setCount (goodsCount);
					}
					returnList.add (cartShow);
				}
				String jsonStr = CommUtil.beanListToJsonStr (returnList);
				CommUtil.removeCookie (Globals.GOODS_CART_ID_NAME , cookie , response);
				CommUtil.addCookie (Globals.GOODS_CART_ID_NAME , URLEncoder.encode (jsonStr , "UTF-8") , Globals.YEAR , response);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
		}


	/**
	 * @Title: deleteCookieGoodsOfGoodsId
	 * @Description: 根据goodsId从cookie中删除商品
	 * @param goodsId
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午5:01:10
	 */
	private void deleteCookieGoodsOfGoodsId (	String goodsId , String goodsProperty , HttpServletRequest request ,
												HttpServletResponse response)
		{
			Cookie cookie = CommUtil.getCookieValue (Globals.GOODS_CART_ID_NAME , request.getCookies ());
			List <Object> list;
			try
			{
				list = CommUtil.jsonToBeanList (URLDecoder.decode (cookie.getValue () , "UTF-8") , GoodsCartShow.class);
				List <GoodsCartShow> returnList = new ArrayList <GoodsCartShow> (list.size ());
				for (Object obj : list)
				{
					GoodsCartShow cartShow = (GoodsCartShow) obj;
					if (!cartShow.getGoodsId ().equals (goodsId))
					{
						returnList.add (cartShow);
					}
					if (cartShow.getGoodsId ().equals (goodsId) && !goodsProperty.equals (cartShow.getGoodsProperty ()))
					{
						returnList.add (cartShow);
					}
				}
				String jsonStr = CommUtil.beanListToJsonStr (returnList);
				CommUtil.removeCookie (Globals.GOODS_CART_ID_NAME , cookie , response);
				CommUtil.addCookie (Globals.GOODS_CART_ID_NAME , URLEncoder.encode (jsonStr , "UTF-8") , Globals.YEAR , response);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
		}


	/**
	 * @Title: deleteCookieGoodsOfGoodsId
	 * @Description: 根据goodsId从cookie中删除商品
	 * @param goodsId
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午5:01:10
	 */
	private void deleteCookieGoodsOfGoodsId (	String goodsId , Cookie cookie , HttpServletResponse response)
		{
			List <Object> list;
			try
			{
				list = CommUtil.jsonToBeanList (URLDecoder.decode (cookie.getValue () , "UTF-8") , GoodsCartShow.class);
				List <GoodsCartShow> returnList = new ArrayList <GoodsCartShow> (list.size ());
				for (Object obj : list)
				{
					GoodsCartShow cartShow = (GoodsCartShow) obj;
					if (cartShow.getGoodsId () != goodsId)
					{
						returnList.add (cartShow);
					}
				}
				String jsonStr = CommUtil.beanListToJsonStr (returnList);
				CommUtil.removeCookie (Globals.GOODS_CART_ID_NAME , cookie , response);
				CommUtil.addCookie (Globals.GOODS_CART_ID_NAME , URLEncoder.encode (jsonStr , "UTF-8") , Globals.YEAR , response);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace ();
			}
		}


	/**
	 * @Title: deleteGoodsOfGoodsIdAndCartUUID
	 * @Description: 根据GoodsID和cartUUID从购物列表中删除商品
	 * @param goodsId
	 * @param cartUUID
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午5:08:16
	 */
	private void deleteGoodsOfGoodsIdAndCartUUID (	Long goodsId , String cartUUID , String goodsProperty)
		{
			CartDetailExample detailExample = new CartDetailExample ();
			detailExample.clear ();
			detailExample.createCriteria ().andGoodsIdEqualTo (goodsId).andGoodsCartIdEqualTo (cartUUID).andSpecInfoEqualTo (goodsProperty);
			this.cartDetailService.deleteByExample (detailExample);
		}


	/**
	 * @Title: combinationRepeatGoods
	 * @Description: 合并重复的商品，并返回json数组串
	 * @param newJson
	 * @param oldJson
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月8日 下午3:58:59
	 */
	private String combinationRepeatGoods (	String newJson , String oldJson)
		{
			GoodsCartShow newGood = (GoodsCartShow) CommUtil.jsonToBean (newJson , GoodsCartShow.class);
			List <Object> oldlist = CommUtil.jsonToBeanList (oldJson , GoodsCartShow.class);
			List <GoodsCartShow> list = new ArrayList <GoodsCartShow> ();
			boolean isSame = false;
			/* 判断是否超过最大cookie购买商品数量 */
			if (oldlist.size () >= Globals.COOKIE_MAX_NUMBER)
			{
				return null;
			}
			/* 若存在相同的商品，规格也一样的则数量相加 */
			for (Object o : oldlist)
			{
				GoodsCartShow g = (GoodsCartShow) o;
				if (g.getGoodsId ().equals (newGood.getGoodsId ()) && g.getGoodsProperty ().trim ().equals (newGood.getGoodsProperty ().trim ()))
				{
					g.setCount (String.valueOf ((Integer.valueOf (newGood.getCount ()) + Integer.valueOf (g.getCount ()))));
					isSame = true;
				}
				list.add (g);
			}
			if (isSame)
			{
				return CommUtil.beanListToJsonStr (list);
			}
			else
			{
				return CommUtil.combinationJsonString (newJson , oldJson , GoodsCartShow.class);
			}
		}


	/**
	 * @Title: getShowCartGoodsOfCookieList
	 * @Description: 从cookie中取出商品信息到购物车
	 * @param list
	 * @return
	 * @return List<CartGoodsShow>
	 * @author tangxiang
	 * @date 2015年8月10日 上午10:45:52
	 */
	private List <GoodsAndStoreShow> getShowCartGoodsOfCookieList (	List <Object> list)
		{
			return returnCartGoodsShow (ObjectListToBeanList (list));
		}


	/**
	 * @Title: getPayment
	 * @Description: 获取购物车支付的总价
	 * @param list
	 * @return
	 * @return BigDecimal
	 * @author tangxiang
	 * @date 2015年8月10日 下午3:05:46
	 */
	private BigDecimal getPayment (	List <GoodsCartShow> list)
		{
			BigDecimal totalPayment = new BigDecimal (Globals.NUBER_ZERO);
			for (GoodsCartShow g : list)
			{
				/*
				 * BigDecimal temp =
				 * getGoodsPrice(Long.valueOf(g.getGoodsId()));
				 * if(temp == null)
				 * {
				 * continue;
				 * }
				 */
				BigDecimal temp = new BigDecimal (g.getGoodsPrice ());
				temp = temp.multiply (new BigDecimal (g.getCount ()));
				totalPayment = totalPayment.add (temp);
			}
			return totalPayment;
		}


	/**
	 * @Title: getPaymentOfCookieList
	 * @Description: 从Cookie中获取购物车支付的总价
	 * @param list
	 * @return
	 * @return BigDecimal
	 * @author tangxiang
	 * @date 2015年8月10日 下午3:05:46
	 */
	private BigDecimal getPaymentOfCookieList (	List <Object> list)
		{
			return getPayment (ObjectListToBeanList (list));
		}


	/**
	 * @Title: returnCartGoodsShow
	 * @Description: 返回购物车展示商品信息列表
	 * @param goodsList
	 * @return
	 * @return List<CartGoodsShow>
	 * @author tangxiang
	 * @date 2015年8月10日 上午11:22:51
	 */
	private List <GoodsAndStoreShow> returnCartGoodsShow (	List <GoodsCartShow> showList)
		{
			List <GoodsAndStoreShow> cartGoodsShows = new ArrayList <GoodsAndStoreShow> ();
			List <Goods> goodsList = getGoodsListOfGoodsCartShow (showList);
			List <GoodsCartShow> goodsCartShows = null;
			GoodsAndStoreShow goodsShow = null;
			Store store = null;
			GoodsCartShow goodsCartShow = null;
			/* 获取商品列表 */
			/*
			 * 使用hashset防止重复数据出现,由于比较对象的时候没重写equal和hash，所以先用id过滤重复，
			 * 然后再根据ID填入对象
			 */
			HashSet <Long> storeHashSet = new HashSet <Long> ();
			/* 获取storeID填入hashSet */
			for (GoodsCartShow g : showList)
			{
				storeHashSet.add (this.goodsService.getByKey (Long.valueOf (g.getGoodsId ())).getGoodsStoreId ());
			}
			/* 填充返回数据 */
			for (Long id : storeHashSet)
			{
				goodsCartShows = new ArrayList <GoodsCartShow> ();
				store = this.storeService.getByKey (id);
				goodsShow = new GoodsAndStoreShow ();
				BigDecimal storePrice = new BigDecimal (Globals.NUBER_ZERO);
				for (int i = 0 ; i < goodsList.size () ; i++)
				{
					if (id.compareTo (goodsList.get (i).getGoodsStoreId ()) == Globals.NUBER_ZERO)
					{
						goodsCartShow = showList.get (i);
						BigDecimal price = getGoodsPrice (goodsList.get (i).getId ());
						long status = getGoodsCountOfGoodsStatus (goodsList.get (i).getId ());
						/* 如果没取到价格则放弃这个商品 */
						if (price == null || status != Globals.NUBER_ZERO)
						{
							continue;
						}
						storePrice = storePrice.add (new BigDecimal (goodsCartShow.getGoodsPrice ()).multiply (new BigDecimal (goodsCartShow.getCount ())));
						// goodsCartShow.setGoodsPrice(price.toString());
						Goods good = this.goodsService.getByKey (Long.valueOf (goodsCartShow.getGoodsId ()));
						goodsCartShow.setGoodsImg (getImagePath (good.getGoodsMainPhoto ()));
						goodsCartShows.add (goodsCartShow);
					}
				}
				goodsShow.setGoodsList (goodsCartShows);
				goodsShow.setStoreName (store.getStoreName ());
				goodsShow.setStorePrice (storePrice.toString ());
				goodsShow.setStoreId (store.getId ().toString ());
				cartGoodsShows.add (goodsShow);
			}
			return cartGoodsShows;
		}


	/**
	 * @Title: getImagePath
	 * @Description: 获取第一张图片路径
	 * @param accessory
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月17日 下午3:28:36
	 */
	private String getImagePath (	Accessory accessory)
		{
			if (accessory == null)
			{
				return null;
			}
			return this.configService.getSysConfig ().getImagewebserver () + "/" + accessory.getPath () + "/" + accessory.getName ();
		}


	/**
	 * @Title: getGoodsPrice
	 * @Description: 根据商品ID获取商品价格，先从规格价格里面取，如果没有则从商品价格中取店铺售价
	 * @param cartId
	 *            ,id
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月10日 上午11:51:28
	 */
	private BigDecimal getGoodsPrice (	Long id)
		{
			BigDecimal price = null;
			price = this.goodsService.getByKey (id).getGoodsPrice ();
			return price;
		}


	/**
	 * @Title
	 * @Description: 根据所购商品(CartDetail)的type获取购买商品的价格
	 * @param id
	 *            ,type
	 * @return
	 * @return String
	 * @author xpy
	 * @date 2015年9月30日 上午11:51:28
	 */
	private BigDecimal getSpecialGoodsPrice (	Long id , String type)
		{
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (id));
			BigDecimal price = new BigDecimal (0.00);
			/*
			 * if(type.equals("tiantian")){
			 * //当该商品在做天天特价的活动
			 * BargainGoodsExample bargainGoodsExample=new
			 * BargainGoodsExample();
			 * bargainGoodsExample.clear();
			 * BargainGoodsExample.Criteria
			 * bargainGoodsCriteria=bargainGoodsExample.createCriteria(
			 * );
			 * bargainGoodsCriteria.andBgTimeEqualTo(CommUtil.
			 * formatString2Date(CommUtil.formatShortDate
			 * (new Date())))
			 * .andBgEndTimeIsNull(); //查询当天
			 * bargainGoodsCriteria.andBgStatusEqualTo(1);//查询审核通过的
			 * bargainGoodsCriteria.andBgGoodsIdEqualTo(Long.valueOf(id
			 * ));
			 * List<BargainGoods>
			 * listBargainGoods=this.bargainGoodsService.getObjectList(
			 * bargainGoodsExample);
			 * if(listBargainGoods.size() >0 && listBargainGoods !=
			 * null){
			 * Double priceH=0.00;
			 * Double
			 * zhekou=listBargainGoods.get(0).getBgRebate().doubleValue
			 * ();
			 * Double
			 * yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
			 * priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
			 * //保留两位小数点
			 * BigDecimal b= new BigDecimal(priceH);
			 * BigDecimal price1 = b.setScale(2,
			 * BigDecimal.ROUND_HALF_UP);
			 * //goodsWithBLOBs.setGoodsPrice(price1);
			 * price = price1;
			 * }
			 * }else
			 */
			if (type.equals ("xianshi"))
			{
				// 当该商品在做限时特价的活动
				BargainExample bargainExample = new BargainExample ();
				bargainExample.clear ();
				BargainExample.Criteria bargainCriteria = bargainExample.createCriteria ();
				List <Date> bargainTime = new ArrayList <Date> ();
				bargainExample.clear ();
				bargainCriteria = bargainExample.createCriteria ();
				bargainCriteria.andMarkEqualTo (1);
				bargainCriteria.andBargainTimeLessThanOrEqualTo (new Date ());// 在当前时间之前开始的特价
				bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo (new Date ());// 在当前时间之后还未结束的限时特价
				List <Bargain> bargains = this.bargainService.getObjectList (bargainExample);
				bargainTime = new ArrayList <Date> ();
				List <Date> bargainEndTime = new ArrayList <Date> ();
				for (Bargain bargain : bargains)
				{
					bargainTime.add (bargain.getBargainTime ());
					bargainEndTime.add (bargain.getBargainEndTime ());
				}
				BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
				bargainGoodsExample.clear ();
				BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
				if (bargainTime.size () > 0)
				{
					bargainGoodsCriteria.andBgTimeIn (bargainTime);
				}
				else
				{
					bargainGoodsCriteria.andBgTimeIsNull ();
				}
				if (bargainEndTime.size () > 0)
				{
					bargainGoodsCriteria.andBgEndTimeIn (bargainEndTime);
				}
				else
				{
					bargainGoodsCriteria.andBgEndTimeIsNull ();
				}
				bargainGoodsCriteria.andBgStatusEqualTo (1);
				bargainGoodsCriteria.andBgGoodsIdEqualTo (Long.valueOf (id));
				List <BargainGoods> listBargainGoods = this.bargainGoodsService.getObjectList (bargainGoodsExample);
				if (null != listBargainGoods && listBargainGoods.size () > 0)
				{
					// Double priceH=0.00;
					// Double
					// zhekou=listBargainGoods.get(0).getBgRebate().doubleValue();
					// Double
					// yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
					// priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
					// 保留两位小数点
					// BigDecimal b= new BigDecimal(priceH);
					// BigDecimal price1 = b.setScale(2,
					// BigDecimal.ROUND_HALF_UP);
					// goodsWithBLOBs.setGoodsPrice(price1);
					// price = price1;
					price = listBargainGoods.get (0).getBgPrice ();
				}
			}
			else if (type.equals ("zhekou"))
			{
				// 当该商品在做折扣特价的时候
				BargainExample bargainExample = new BargainExample ();
				bargainExample.clear ();
				BargainExample.Criteria bargainCriteria = bargainExample.createCriteria ();
				bargainExample.clear ();
				bargainCriteria = bargainExample.createCriteria ();
				bargainCriteria.andMarkEqualTo (2);
				bargainCriteria.andBargainTimeLessThanOrEqualTo (new Date ());// 在当前时间之前开始的特价
				bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo (new Date ());// 在当前时间之后还未结束的折扣特卖
				List <Bargain> bargains = this.bargainService.getObjectList (bargainExample);
				List <Date> bargainTime = new ArrayList <Date> ();
				for (Bargain bargain : bargains)
				{
					bargainTime.add (bargain.getBargainTime ());
				}
				BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
				bargainGoodsExample.clear ();
				BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
				if (bargainTime.size () > 0)
				{
					bargainGoodsCriteria.andBgTimeIn (bargainTime);
				}
				else
				{
					bargainGoodsCriteria.andBgTimeIsNull ();
				}
				bargainGoodsCriteria.andBgStatusEqualTo (1);
				List <BargainGoods> listBargainGoods = this.bargainGoodsService.getObjectList (bargainGoodsExample);
				if (null != listBargainGoods && listBargainGoods.size () > 0)
				{
					// Double priceH=0.00;
					// Double
					// zhekou=listBargainGoods.get(0).getBgRebate().doubleValue();
					// Double
					// yuanPrice=goodsWithBLOBs.getGoodsPrice().doubleValue();
					// priceH=zhekou.doubleValue()*yuanPrice.doubleValue()*0.1;
					// 保留两位小数点
					// BigDecimal b= new BigDecimal(priceH);
					// BigDecimal price1 = b.setScale(2,
					// BigDecimal.ROUND_HALF_UP);
					// goodsWithBLOBs.setGoodsPrice(price1);
					// price = price1;
					price = listBargainGoods.get (0).getBgPrice ();
				}
			}
			else if (type.equals ("group"))
			{
				// 当商品在做团购活动的时候
				GroupGoodsExample groupGoodsExample = new GroupGoodsExample ();
				groupGoodsExample.clear ();
				groupGoodsExample.createCriteria ().andGgGoodsIdEqualTo (goodsWithBLOBs.getId ());
				GroupGoods gg = this.groupGoodsSerice.getObjectList (groupGoodsExample).get (0);
				GroupExample groupExample = new GroupExample ();
				groupExample.clear ();
				groupExample.createCriteria ().andIdEqualTo (gg.getGroupId ()).andBegintimeLessThanOrEqualTo (new Date ()).andEndtimeGreaterThanOrEqualTo (new Date ());
				List <Group> groupList = this.groupService.getObjectList (groupExample);
				if (null != groupList && groupList.size () > 0)
				{
					BigDecimal groupPrice = gg.getGgPrice ();
					// goodsWithBLOBs.setGoodsPrice(groupPrice);
					price = groupPrice;
				}
			}
			return price;
		}


	/**
	 * @Title: getDirectBuyGoodsPrice
	 * @Description: 获取直接购买商品的总价格
	 * @param cartId
	 *            ,id
	 * @param directBuy
	 * @return
	 * @throws
	 * @author xpy
	 * @date 2015年10月14日
	 */
	private BigDecimal getDirectBuyGoodsPrice (	Long cartId , Long id , boolean directBuy)
		{
			BigDecimal price = new BigDecimal (Globals.NUBER_ZERO);
			List <CartDetail> list = getRecordForCartDetail (null , directBuy , true , cartId);
			if (!list.isEmpty ())
			{
				for (CartDetail cartDetail : list)
				{
					if (cartDetail.getGoodsId ().equals (id))
					{
						if (cartDetail.getType () != null && !cartDetail.getType ().equals (""))
						{
							price = price.add (getSpecialGoodsPrice (cartDetail.getGoodsId () , cartDetail.getType ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
						}
						else
						{
							price = price.add (getGoodsPrice (cartDetail.getGoodsId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
						}
					}
				}
			}
			return price;
		}


	/**
	 * @Title: getOrderGoodsPrice
	 * @Description: 获取订单商品总价格
	 * @param cartId
	 * @param directBuy
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年9月28日
	 */
	private BigDecimal getOrderGoodsPrice (	Long cartId , boolean directBuy)
		{
			BigDecimal price = new BigDecimal (Globals.NUBER_ZERO);
			List <CartDetail> list = getRecordForCartDetail (null , directBuy , true , cartId);
			if (!list.isEmpty ())
			{
				for (CartDetail cartDetail : list)
				{
					if (cartDetail.getType () != null && !cartDetail.getType ().equals (""))
					{
						price = price.add (getSpecialGoodsPrice (cartDetail.getGoodsId () , cartDetail.getType ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
					}
					else
					{
						price = price.add (getGoodsPrice (cartDetail.getGoodsId ()).multiply (new BigDecimal (cartDetail.getGoodsCount ())));
					}
				}
			}
			return price;
		}


	/**
	 * @Title: getGoodsJsonGoodsList
	 * @Description: 根据GoodsCartShow列表获取商品信息列表
	 * @param list
	 * @return
	 * @return List<Goods>
	 * @author tangxiang
	 * @date 2015年8月10日 上午11:02:27
	 */
	private List <Goods> getGoodsListOfGoodsCartShow (	List <GoodsCartShow> list)
		{
			List <Goods> returnList = new ArrayList <Goods> (list.size ());
			for (GoodsCartShow goodsJson : list)
			{
				returnList.add (this.goodsService.getByKey (Long.valueOf (goodsJson.getGoodsId ())));
			}
			return returnList;
		}


	/**
	 * @Title: getGoodsCartShowListOfCartUUID
	 * @Description: 根据cartUUID获取购物车信息列表
	 * @param cartUUID
	 * @param goodsIds
	 *            选择的商品id
	 * @return
	 * @return List<GoodsCartShow>
	 * @author tangxiang
	 * @date 2015年8月10日 下午3:23:25
	 */
	private List <GoodsCartShow> getGoodsCartShowListOfCartUUID (	String cartUUID , List <Long> goodsIds ,
																	boolean directBuy , List <String> goodsSpecs)
		{
			List <GoodsCartShow> list = new ArrayList <GoodsCartShow> ();
			List <CartDetail> cartDetails = null;
			if (goodsIds != null)
			{
				cartDetails = new ArrayList <CartDetail> ();
				for (int i = 0 ; i < goodsIds.size () ; i++)
				{
					CartDetail cartDetail = null;
					if (goodsSpecs != null)
					{
						cartDetail = getRecordForCartDetail (cartUUID , goodsIds.get (i) , goodsSpecs.get (i) , directBuy , false);
					}
					else
					{
						cartDetail = getRecordForCartDetail (cartUUID , goodsIds.get (i) , null , directBuy , false);
					}
					if (cartDetail != null)
					{
						cartDetails.add (cartDetail);
					}
				}
			}
			else
			{
				cartDetails = getRecordForCartDetail (cartUUID , false , false , null);
			}
			GoodsCartShow cartShow = null;
			if (cartDetails == null || cartDetails.isEmpty ())
			{
				return list;
			}
			for (CartDetail detail : cartDetails)
			{
				cartShow = new GoodsCartShow ();
				cartShow.setCartUUID (cartUUID);
				cartShow.setCount (detail.getGoodsCount ().toString ());
				cartShow.setGoodsId (detail.getGoodsId ().toString ());
				cartShow.setGoodsProperty (detail.getSpecInfo ());
				cartShow.setGoodsName (this.goodsService.getByKey (detail.getGoodsId ()).getGoodsName ());
				if (detail.getType () != null && !detail.getType ().equals (""))
				{
					cartShow.setGoodsPrice (getSpecialGoodsPrice (detail.getGoodsId () , detail.getType ()).toString ());
				}
				else
				{
					cartShow.setGoodsPrice (getGoodsPrice (detail.getGoodsId ()).toString ());
				}
				list.add (cartShow);
			}
			return list;
		}


	/**
	 * @Title: ObjectListToBeanList
	 * @Description: Object对象转换成GoodsCartShow列表
	 * @param list
	 * @return
	 * @return List<GoodsCartShow>
	 * @author tangxiang
	 * @date 2015年8月10日 下午2:57:40
	 */
	private List <GoodsCartShow> ObjectListToBeanList (	List <Object> list)
		{
			List <GoodsCartShow> returnList = new ArrayList <GoodsCartShow> (list.size ());
			for (Object obj : list)
			{
				returnList.add ((GoodsCartShow) obj);
			}
			return returnList;
		}


	/**
	 * @Title: getGoodsCountOfGoodsId
	 * @Description: 根据商品ID获取商品库存
	 * @param goodsId
	 * @return
	 * @return Integer
	 * @author tangxiang
	 * @date 2015年8月10日 下午4:09:31
	 */
	private Integer getGoodsCountOfGoodsId (Long goodsId)
		{
			Goods goods = this.goodsService.getByKey (goodsId);
			return goods.getGoodsInventory ();
		}


	/**
	 * @Title: getGoodsCountOfGoodsStatus
	 * @Description: 根据商品ID获取商品状态
	 * @param goodsId
	 * @return
	 * @return Integer
	 * @author wangyong
	 * @date 2016年5月21日
	 */
	private Integer getGoodsCountOfGoodsStatus (Long goodsId)
		{
			Goods goods = this.goodsService.getByKey (goodsId);
			return goods.getGoodsStatus ();
		}


	private ModelAndView generatePayInfo (	String webbankpay , OrderFormWithBLOBs of , ModelAndView mv ,
											HttpServletRequest request , HttpServletResponse response)
		{
			List <PaymentWithBLOBs> payments = new ArrayList <PaymentWithBLOBs> ();
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			PaymentExample.Criteria paymentCriteria = paymentExample.createCriteria ();
			/* 商品名称，多个商品则只显示第一个 + 等商品 描述 */
			String goodsName = getOrderGoodsNames (of.getId ());
			/* 使用平台帐号收款 */
			if (this.configService.getSysConfig ().getConfigPaymentType () != Globals.NUBER_ONE)// 则用本平台管理员的支付宝账号
			{
				return returnToOrderError (mv , request , response);
			}
			else
			{
				paymentCriteria.andMarkEqualTo (webbankpay);
				paymentCriteria.andTypeEqualTo ("admin");
				payments = this.paymentService.getObjectList (paymentExample);
				if (payments.isEmpty ())
				{
					return returnToOrderError (mv , request , response);
				}
				of.setPayment ((Payment) payments.get (Globals.NUBER_ZERO));
				this.orderFormService.updateByObject (of);
				return returnPayPage (webbankpay , of.getAlipayorderId () , goodsName , "goods" , mv , request , response);
			}
		}


	/**
	 * @Title: getOrderFormItemList
	 * @Description: 获取订单详情表
	 * @param orderId
	 * @return
	 * @return List<OrderFormItem>
	 * @author tangxiang
	 * @date 2015年8月27日 下午5:23:26
	 */
	public List <OrderFormItem> getOrderFormItemList (	Long orderId)
		{
			OrderFormItemExample example = new OrderFormItemExample ();
			example.clear ();
			example.createCriteria ().andOrderIdEqualTo (orderId);
			List <OrderFormItem> list = this.orderFormItemService.getObjectList (example);
			if (list == null || list.isEmpty ())
			{
				return null;
			}
			return list;
		}


	/**
	 * @Title: getOrderGoodsNames
	 * @Description: 获取订单商品名称
	 * @param ofId
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月17日
	 */
	private String getOrderGoodsNames (	Long ofId)
		{
			String goodsName = "";
			List <OrderFormItem> list = getOrderFormItemList (ofId);
			goodsName = list.get (0).getGoodsName ();
			if (list.size () > 1)
			{
				goodsName += "等商品";
			}
			return goodsName;
		}


	/**
	 * @Title: setOrderAddress
	 * @Description: 创建订单地址信息
	 * @param addressId
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月17日
	 */
	private Long createOrderAddress (	Long addressId)
		{
			OrderAddress orderAddress = new OrderAddress ();
			Address address = addressService.getByKey (addressId);
			orderAddress.setAddtime (new Date ());
			orderAddress.setArea (address.getArea ().getAreaname ());
			orderAddress.setAreaInfo (address.getAreaInfo ());
			orderAddress.setCity (address.getArea ().getParent ().getAreaname ());
			orderAddress.setProvince (address.getArea ().getParent ().getParent ().getAreaname ());
			orderAddress.setTelephone (address.getMobile ());
			orderAddress.setTruename (address.getTruename ());
			orderAddressService.add (orderAddress);
			return orderAddress.getId ();
		}


	private void O2OBenefit (	AlipayOrder alipayOrder , OrderFormWithBLOBs orderForm)
		{/*
		 * // 卖家
		 * final BigDecimal RATESELLER = new BigDecimal ("7");
		 * // 买家
		 * final BigDecimal BUYERRATES = new BigDecimal ("3");
		 * // 直接
		 * final BigDecimal RATEDIRECT = new BigDecimal ("1");
		 * // 间接
		 * final BigDecimal RATERemote = new BigDecimal ("1");
		 * // 买家用户
		 * User buyerUser = null;
		 * // 城市代理商
		 * User cityRole = null;
		 * // 直接推荐人
		 * User directRefer = null;
		 * // 间接推荐人
		 * User indirectUser = null;
		 * // 商家
		 * User user = null;
		 * if (orderForm != null)
		 * {
		 * user =
		 * storeService.getByKey(orderForm.getStoreId()).getUser();
		 * }
		 * if(null != user){
		 * System.out.println ("卖家用户分红开始：" + buyerUser.getUsername
		 * ());
		 * if (null == user.getHistoryFee ())
		 * {
		 * user.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * user.setHistoryFee (user.getHistoryFee ().add (tenFee));
		 * if (null == user.getCurrentFee ())
		 * {
		 * user.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * user.setCurrentFee (user.getCurrentFee ().add (tenFee));
		 * if (null == user.getCanCarry ())
		 * {
		 * user.setCanCarry (BigDecimal.ZERO);
		 * }
		 * user.setCanCarry (user.getCanCarry ().add (tenFee.multiply
		 * (canCarryRate)));
		 * if (null == user.getManageMoney ())
		 * {
		 * user.setManageMoney (BigDecimal.ZERO);
		 * }
		 * user.setManageMoney (user.getManageMoney ().add
		 * (tenFee.multiply (manageMoneyRate)));
		 * this.userService.updateUsers (user);
		 * MutualBenefit mutualBenefit = new MutualBenefit ();
		 * mutualBenefit.setAddTime (new Date ());
		 * mutualBenefit.setGetUserId (buyerUser.getId ());
		 * mutualBenefit.setGiveUserId (user.getId ());
		 * mutualBenefit.setMutualFee (tenFee);
		 * this.mutualBenefitService.add (mutualBenefit);
		 * }
		 * System.out.println ("orderForm-OrderId ：" + (orderForm ==
		 * null ? null : orderForm.getOrderId ()) + ",alipayOrder-id="
		 * + (alipayOrder == null ? null : alipayOrder.getId ()) +
		 * ",user=" + (user == null ? null : user.getUsername ()));
		 * // 7%创富金给买家用户
		 * if (null != orderForm && null != orderForm.getUserId () &&
		 * !orderForm.getUserId ().toString ().equals (""))
		 * {
		 * buyerUser = orderForm.getUser ();
		 * BigDecimal tenFee = prices.multiply (BUYERRATES).setScale
		 * (2 , BigDecimal.ROUND_DOWN);
		 * if (null != buyerUser)
		 * {
		 * System.out.println ("买家用户分红开始：" + buyerUser.getUsername ()
		 * + ",fee=" + tenFee);
		 * if (null == buyerUser.getHistoryFee ())
		 * {
		 * buyerUser.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * buyerUser.setHistoryFee (buyerUser.getHistoryFee ().add
		 * (tenFee));
		 * if (null == buyerUser.getCurrentFee ())
		 * {
		 * buyerUser.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * buyerUser.setCurrentFee (buyerUser.getCurrentFee ().add
		 * (tenFee));
		 * if (null == buyerUser.getCanCarry ())
		 * {
		 * buyerUser.setCanCarry (BigDecimal.ZERO);
		 * }
		 * buyerUser.setCanCarry (buyerUser.getCanCarry ().add
		 * (tenFee.multiply (canCarryRate)));
		 * if (null == buyerUser.getManageMoney ())
		 * {
		 * buyerUser.setManageMoney (BigDecimal.ZERO);
		 * }
		 * buyerUser.setManageMoney (buyerUser.getManageMoney ().add
		 * (tenFee.multiply (manageMoneyRate)));
		 * this.userService.updateUsers (buyerUser);
		 * MutualBenefit mutualBenefit = new MutualBenefit ();
		 * mutualBenefit.setAddTime (new Date ());
		 * mutualBenefit.setGetUserId (buyerUser.getId ());
		 * mutualBenefit.setGiveUserId (user.getId ());
		 * mutualBenefit.setMutualFee (tenFee);
		 * this.mutualBenefitService.add (mutualBenefit);
		 * }
		 * }
		 * 由数据库event完成，根据order订单
		 * // 1%城市代理商奖
		 * if (null != buyerUser && null != buyerUser.getCityId () &&
		 * !buyerUser.getCityId
		 * ().toString ().equals (""))
		 * {
		 * cityRole = userCRUD.getCityRole (buyerUser.getCityId ());
		 * if (null != cityRole)
		 * {
		 * if (null == cityRole.getHistoryFee ())
		 * { cityRole.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * cityRole.setHistoryFee(cityRole.getHistoryFee ().add
		 * (prices));
		 * if (null == cityRole.getCurrentFee ())
		 * { cityRole.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * cityRole.setCurrentFee(cityRole.getCurrentFee ().add
		 * (prices));
		 * if (null == cityRole.getCanCarry ())
		 * {
		 * cityRole.setCanCarry (BigDecimal.ZERO);
		 * }
		 * cityRole.setCanCarry(cityRole.getCanCarry ().add
		 * (prices.multiply (canCarryRate)));
		 * if (null == cityRole.getManageMoney ())
		 * {
		 * cityRole.setManageMoney (BigDecimal.ZERO);
		 * }
		 * cityRole.setManageMoney(cityRole.getManageMoney ().add
		 * (prices.multiply
		 * (manageMoneyRate)));
		 * this.userService.updateUsers (cityRole);
		 * MutualBenefit mutualBenefit = new MutualBenefit ();
		 * mutualBenefit.setAddTime (new Date ());
		 * mutualBenefit.setGetUserId (cityRole.getId ());
		 * mutualBenefit.setGiveUserId (user.getId ());
		 * mutualBenefit.setMutualFee (prices);
		 * this.mutualBenefitService.add (mutualBenefit);
		 * }
		 * }
		 * // 1% 直接招商奖
		 * if (null != buyerUser && null != buyerUser.getDirectRefer
		 * () && !buyerUser.getDirectRefer ().toString ().equals (""))
		 * {
		 * directRefer = userCRUD.getUserById
		 * (buyerUser.getDirectRefer ());
		 * if (null != directRefer)
		 * {
		 * System.out.println ("直接用户分红开始：" + directRefer.getUsername
		 * () + ",fee=" + prices);
		 * if (null == directRefer.getHistoryFee ())
		 * {
		 * directRefer.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * directRefer.setHistoryFee (directRefer.getHistoryFee ().add
		 * (prices));
		 * if (null == directRefer.getCurrentFee ())
		 * {
		 * directRefer.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * directRefer.setCurrentFee (directRefer.getCurrentFee ().add
		 * (prices));
		 * if (null == directRefer.getCanCarry ())
		 * {
		 * directRefer.setCanCarry (BigDecimal.ZERO);
		 * }
		 * System.out.println ("直接用户分红理财金：" + prices.multiply
		 * (canCarryRate));
		 * directRefer.setCanCarry (directRefer.getCanCarry ().add
		 * (prices.multiply (canCarryRate)));
		 * if (null == directRefer.getManageMoney ())
		 * {
		 * directRefer.setManageMoney (BigDecimal.ZERO);
		 * }
		 * System.out.println ("直接用户分红可提现：" + prices.multiply
		 * (manageMoneyRate));
		 * directRefer.setManageMoney (directRefer.getManageMoney
		 * ().add (prices.multiply (manageMoneyRate)));
		 * this.userService.updateUsers (directRefer);
		 * if (null != directRefer && null != buyerUser)
		 * {
		 * MutualBenefit mutualBenefit = new MutualBenefit ();
		 * mutualBenefit.setAddTime (new Date ());
		 * mutualBenefit.setGetUserId (directRefer.getId ());
		 * mutualBenefit.setGiveUserId (user.getId ());
		 * mutualBenefit.setMutualFee (prices);
		 * this.mutualBenefitService.add (mutualBenefit);
		 * }
		 * }
		 * }
		 * // 1%间接招商奖
		 * if (null != directRefer && null !=
		 * directRefer.getDirectRefer () &&
		 * !directRefer.getDirectRefer ().toString ().equals (""))
		 * {
		 * indirectUser = userCRUD.getUserById
		 * (directRefer.getDirectRefer ());
		 * if (null != indirectUser)
		 * {
		 * System.out.println ("间接用户分红开始：" + indirectUser.getUsername
		 * ());
		 * if (null == indirectUser.getHistoryFee ())
		 * {
		 * indirectUser.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * indirectUser.setHistoryFee (indirectUser.getHistoryFee
		 * ().add (prices));
		 * if (null == indirectUser.getCurrentFee ())
		 * {
		 * indirectUser.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * indirectUser.setCurrentFee (indirectUser.getCurrentFee
		 * ().add (prices));
		 * if (null == indirectUser.getCanCarry ())
		 * {
		 * indirectUser.setCanCarry (BigDecimal.ZERO);
		 * }
		 * indirectUser.setCanCarry (indirectUser.getCanCarry ().add
		 * (prices.multiply (canCarryRate)));
		 * if (null == directRefer.getManageMoney ())
		 * {
		 * indirectUser.setManageMoney (BigDecimal.ZERO);
		 * }
		 * indirectUser.setManageMoney (indirectUser.getManageMoney
		 * ().add (prices.multiply (manageMoneyRate)));
		 * this.userService.updateUsers (indirectUser);
		 * if (indirectUser != null && buyerUser != null)
		 * {
		 * MutualBenefit mutual = new MutualBenefit ();
		 * mutual.setAddTime (new Date ());
		 * mutual.setGetUserId (indirectUser.getId ());
		 * mutual.setGiveUserId (user.getId ());
		 * mutual.setMutualFee (prices);
		 * this.mutualBenefitService.add (mutual);
		 * }
		 * }
		 * }
		 * // 2%AMALL
		 * System.out.println ("平台分红开始");
		 * PlatformEarningDetail example = new PlatformEarningDetail
		 * ();
		 * example.setAddTime (new Date ());
		 * example.setEarningFee (prices);
		 * if (null != user)
		 * {
		 * example.setGiveUserId (user.getId ());
		 * }
		 * example.setOriginalFee (prices);
		 * this.platformEarningDetailService.add (example);
		 * System.out.println ("平台分红结束id=：" + example.getId ());
		 * // 3%商家创富奖
		 * if (null != user)
		 * {
		 * BigDecimal fee = prices.multiply (SELLERRATES);
		 * System.out.println ("商家分红开始：" + user.getUsername () +
		 * ",fee=" + fee);
		 * if (null == user.getHistoryFee ())
		 * {
		 * user.setHistoryFee (BigDecimal.ZERO);
		 * }
		 * user.setHistoryFee (user.getHistoryFee ().add (fee));
		 * if (null == user.getCurrentFee ())
		 * {
		 * user.setCurrentFee (BigDecimal.ZERO);
		 * }
		 * user.setCurrentFee (user.getCurrentFee ().add (fee));
		 * if (null == user.getCanCarry ())
		 * {
		 * user.setCanCarry (BigDecimal.ZERO);
		 * }
		 * user.setCanCarry (user.getCanCarry ().add (fee.multiply
		 * (canCarryRate)));
		 * if (null == user.getManageMoney ())
		 * {
		 * user.setManageMoney (BigDecimal.ZERO);
		 * }
		 * user.setManageMoney (user.getManageMoney ().add
		 * (fee.multiply (manageMoneyRate)));
		 * this.userService.updateUsers (user);
		 * MutualBenefit mutual = new MutualBenefit ();
		 * mutual.setAddTime (new Date ());
		 * mutual.setGetUserId (user.getId ());
		 * mutual.setGiveUserId (user.getId ());
		 * mutual.setMutualFee (fee);
		 * this.mutualBenefitService.add (mutual);
		 * }
		 */
		}
}
