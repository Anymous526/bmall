package com.amall.core.web.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.CartExample;
import com.amall.core.bean.GoodsCartShow;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.bean.CartDetailExample.Criteria;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.web.page.Pagination;


/**
 * @author tangxiang
 *
 */
@Component
public class CartGoodsCountTools {
	
	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;
	
	/**
	 * @Title: getCartCount
	 * @Description: 获取购物车商品数量
	 * @param cookies
	 * @return
	 * @return Integer
	 * @author tangxiang
	 * @date 2015年8月21日 上午10:14:32 
	 */
	public Integer getCartCount(Cookie[] cookies)
	{
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user == null && cookies != null)
		{
			return getCountFromCookie(cookies);
		}
		
		if(user != null)
		{
			return getCountFromCartDetail(user.getId());
		}
		
		return Globals.NUBER_ZERO;
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
	private Integer getCountFromCartDetail(Long userId)
	{
		Integer count = Globals.NUBER_ZERO;
		String cartUUID = isAreadyRecordForCart(userId);
		
		if(cartUUID == null)
		{
			return count; 
		}
	
		List<CartDetail> list = getRecordForCartDetail(cartUUID, false, false, null);
		if(list.isEmpty())
		{
			return count;
		}
		for(CartDetail cartDetail:list)
		{
			count += cartDetail.getGoodsCount();
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
	public Integer getCountFromCookie(Cookie[] cookies)
	{
		Integer count = Globals.NUBER_ZERO;
		Cookie cookie = CommUtil.getCookieValue(Globals.GOODS_CART_ID_NAME, cookies);
		
		if(cookie == null || cookie.getValue() == null || cookie.getValue().equals(""))
		{
			return count;
		}
		
		List<Object> list;
		try
		{
			list = CommUtil.jsonToBeanList(URLDecoder.decode(cookie.getValue(), "UTF-8"), GoodsCartShow.class);
			for(Object obj:list)
			{
				GoodsCartShow cartShow = (GoodsCartShow) obj;
				count += Integer.valueOf(cartShow.getCount());
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		
		
		return count;
	}
	
	/**
	 * 根据UserID和Status为true获取未付款购物车
	 * <p>Title: isAreadyRecordForCart</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 */
	public String isAreadyRecordForCart(Long userId)
	{
		List<Cart> cartList = new ArrayList<Cart>();
		CartExample cartExample = new CartExample();
		
		cartExample.clear();
		cartExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(true);
		cartList = this.cartService.getObjectList(cartExample);
		
		if(cartList.isEmpty())
		{
			return null;
		}
		
		return cartList.get(Globals.NUBER_ZERO).getGoodsCartId();
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
	public List<CartDetail> getRecordForCartDetail(String cartUUID, boolean directBuy, boolean deleteStatus, Long cartId)
	{
		List<CartDetail> CartDetailList = new ArrayList<CartDetail>();
		CartDetailExample cartDetailExample = new CartDetailExample();
		
		cartDetailExample.clear();
		Criteria criteria = cartDetailExample.createCriteria();
		if(cartUUID != null)
		{
			criteria.andGoodsCartIdEqualTo(cartUUID);
		}
		if(cartId != null)
		{
			criteria.andCartIdEqualTo(cartId);
		}
		criteria.andDeleteStatusEqualTo(deleteStatus).andDirectBuyEqualTo(directBuy);
		CartDetailList = this.cartDetailService.getObjectList(cartDetailExample);
		
		return CartDetailList;
	}
}
