package com.amall.core.action.CRUD;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.CartExample;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsAndStoreShow;
import com.amall.core.bean.GoodsCartShow;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.CartDetailExample.Criteria;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;

@Component
public class CartCRUD
{

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private ISysConfigService configService;

	/**
	 * @Title: getCartById
	 * @Description: 根据购物车ID获取购物车信息
	 */
	public Cart getCartById (Long id)
		{
			return this.cartService.getByKey (id);
		}
	/**
	 * @Title: deleteCartById
	 * @Description: 根据购物车ID删除购物车
	 */
	public Integer deleteCartById (Long id)
		{
			return this.cartService.deleteByKey (id);
		}
	/**
	 * @Title: updateCartDetail
	 * @Description:
	 */
	public Integer updateCartDetail (CartDetail record)
		{
			return this.cartDetailService.updateByObject (record);
		}
	/**
	 * @Title: updateCart
	 * @Description:
	 */
	public Integer updateCart (Cart record)
		{
			return this.cartService.updateByObject (record);
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
	public String isAreadyRecordForCart (Long userId)
		{
			List <Cart> cartList = new ArrayList <Cart> ();
			CartExample cartExample = new CartExample ();
			cartExample.createCriteria ().andUserIdEqualTo (userId).andStatusEqualTo (true);
			cartList = this.cartService.getObjectList (cartExample);
			if (cartList.isEmpty ())
			{
				return null;
			}
			return cartList.get (0).getGoodsCartId ();
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
	public List <CartDetail> getRecordForCartDetail (String cartUUID , boolean directBuy , boolean deleteStatus , Long cartId)
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
	public CartDetail getRecordForCartDetail (String cartUUID , Long goodsId , String goodsProperty , boolean directBuy , boolean deleteStatus)
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
			return CartDetailList.get (0);
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
	public CartDetail isHaveBuyGoods (String cartUUID , Long goodsId , String goodsProperty , boolean directBuy , boolean deleteStatus , long userId)
		{
			CartDetailExample cartDetailExample = new CartDetailExample ();
			Criteria criteria = cartDetailExample.createCriteria ();
			System.out.println ("goodsId=" + goodsId);
			System.out.println ("userId=" + userId);
			if (cartUUID != null)
			{
				criteria.andGoodsCartIdEqualTo (cartUUID);
			}
			if (goodsProperty != null)
			{
				criteria.andSpecInfoEqualTo (goodsProperty);
			}
			criteria.andGoodsIdEqualTo (goodsId).andDeleteStatusEqualTo (deleteStatus).andDirectBuyEqualTo (directBuy).andUserIdEqualTo (userId);
			List <CartDetail> cartDetails = this.cartDetailService.getObjectList (cartDetailExample);
			System.out.println ("数量=" + cartDetails.size ());
			return cartDetails.size () > 0 ? cartDetails.get (0) : null;
		}
	/**
	 * @Title: getCountFromCartDetail
	 * @Description: 根据用户ID从数据库获取商品数量
	 * @param userId
	 * @return
	 * @return Integer
	 * @date 2015年8月10日 下午6:38:55
	 */
	public Integer getCountFromCartDetail (Long userId)
		{
			Integer count = 0;
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
	public List <GoodsCartShow> getGoodsCartShowListOfCartUUID (String cartUUID , List <Long> goodsIds , boolean directBuy , List <String> goodsSpecs)
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
				cartShow.setGoodsPrice (getGoodsPrice (detail.getGoodsId ()).toString ());
				list.add (cartShow);
			}
			return list;
		}
	/**
	 * @Title
	 * @Description: 获取购买商品的价格
	 * @param id
	 * @return
	 * @return String
	 * @author chenxiujun
	 * @date 2016年01月09日 上午11:51:28
	 */
	public BigDecimal getGoodsPrice (Long id)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (id);
			if (goods.getGoodsCurrentPrice () == null || StringUtils.isEmpty (goods.getGoodsCurrentPrice ().toString ()))
			{
				return goods.getGoodsPrice ();
			}
			else
			{
				return goods.getGoodsCurrentPrice ();
			}
		}
	/**
	 * 判断数据库购物车中的商品库存，如果为0则，从数据库购物车中删除，如果购买的数量大于库存，则将现有的库存设置为购买的库存
	 * 
	 * @author guoxiangjun
	 * @param carGoodsList
	 *            购物车商品列表
	 * @return 是否做出了更改操作
	 */
	public boolean judgeDBCarGoodsIsExist (List <GoodsCartShow> carGoodsList)
		{
			boolean flag = false;
			for (GoodsCartShow goods : carGoodsList)
			{
				Integer inventory = getGoodsCountOfGoodsId (Long.valueOf (goods.getGoodsId ()));
				if (inventory == 0)
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
	 * @Title: deleteGoodsOfGoodsIdAndCartUUID
	 * @Description: 根据GoodsID和cartUUID从购物列表中删除商品
	 * @param goodsId
	 * @param cartUUID
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月10日 下午5:08:16
	 */
	public void deleteGoodsOfGoodsIdAndCartUUID (Long goodsId , String cartUUID , String goodsProperty)
		{
			CartDetailExample detailExample = new CartDetailExample ();
			detailExample.clear ();
			if (!StringUtils.isEmpty (goodsProperty))
			{
				detailExample.createCriteria ().andGoodsIdEqualTo (goodsId).andGoodsCartIdEqualTo (cartUUID).andSpecInfoEqualTo (goodsProperty);
			}
			else
			{
				detailExample.createCriteria ().andGoodsIdEqualTo (goodsId).andGoodsCartIdEqualTo (cartUUID).andSpecIdIsNull ();
			}
			this.cartDetailService.deleteByExample (detailExample);
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
	public List <GoodsAndStoreShow> returnCartGoodsShow (List <GoodsCartShow> showList)
		{
			List <GoodsAndStoreShow> cartGoodsShows = new ArrayList <GoodsAndStoreShow> ();
			List <Goods> goodsList = getGoodsListOfGoodsCartShow (showList);
			List <GoodsCartShow> goodsCartShows = null;
			GoodsAndStoreShow goodsShow = null;
			Store store = null;
			GoodsCartShow goodsCartShow = null;
			/* 获取商品列表 */
			/* 使用hashset防止重复数据出现,由于比较对象的时候没重写equal和hash，所以先用id过滤重复，然后再根据ID填入对象 */
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
				BigDecimal storePrice = new BigDecimal (0);
				for (int i = 0 ; i < goodsList.size () ; i++)
				{
					if (id.compareTo (goodsList.get (i).getGoodsStoreId ()) == 0)
					{
						goodsCartShow = showList.get (i);
						BigDecimal price = getGoodsPrice (goodsList.get (i).getId ());
						/* 如果没取到价格则放弃这个商品 */
						if (price == null)
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
	private String getImagePath (Accessory accessory)
		{
			if (accessory == null)
			{
				return null;
			}
			return this.configService.getSysConfig ().getImagewebserver () + "/" + accessory.getPath () + "/" + accessory.getName ();
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
	private List <Goods> getGoodsListOfGoodsCartShow (List <GoodsCartShow> list)
		{
			List <Goods> returnList = new ArrayList <Goods> (list.size ());
			for (GoodsCartShow goodsJson : list)
			{
				returnList.add (this.goodsService.getByKey (Long.valueOf (goodsJson.getGoodsId ())));
			}
			return returnList;
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
	public Long saveGoodsToCartDBAndReturnId (long userId , String cartUUID)
		{
			Long cartId = -1l;
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
				cartId = this.cartService.add (cart);
				cartId = getRecordForCart (userId , cartUUID , true).getId ();
			}
			return cartId;
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
	public Cart getRecordForCart (Long userId , String cartUUID , boolean cartStatus)
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
			return cartList.get (0);
		}
	/**
	 * @Title: saveGoodsToDetailDB
	 * @Description: 保存商品到DBA，若存在相同的则合并商品
	 * @return void
	 * @author chenxiujun
	 * @date 2016年01月09日
	 */
	public void saveGoodsToDetailDB (Long userId , String cartUUID , long goodsId , boolean isDirectBuy , String specInfo , int goodsCount)
		{
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
				cartDetail.setGoodsId (goodsId);
				cartDetail.setSpecInfo (specInfo);
				cartDetail.setGoodsCount (goodsCount);
				cartDetail.setGoodsCartId (cartUUID);
				cartDetail.setUserId (userId);
				long cartId = saveGoodsToCartDBAndReturnId (userId , cartUUID);
				/*
				 * CartExample example = new CartExample();
				 * example.createCriteria().andUserIdEqualTo(userId).andGoodsCartIdEqualTo(cartUUID);
				 * List<Cart> carts = cartService.getObjectList(example);
				 */
				if (cartId != -1l)
				{
					cartDetail.setCartId (cartId);
				}
				this.cartDetailService.add (cartDetail);
			}
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
	private CartDetail getCartDetailFromGoodsIdAndSpecInfo (String cartUUID , long goodsId , boolean isDirectBuy , String specInfo , boolean deleteStatus)
		{
			CartDetail cartDetail = null;
			CartDetailExample detailExample = new CartDetailExample ();
			detailExample.clear ();
			if (!StringUtils.isEmpty (specInfo))
			{
				detailExample.createCriteria ().andGoodsCartIdEqualTo (cartUUID).andGoodsIdEqualTo (goodsId).andDirectBuyEqualTo (isDirectBuy).andSpecInfoEqualTo (specInfo).andDeleteStatusEqualTo (deleteStatus);
			}
			else
			{
				detailExample.createCriteria ().andGoodsCartIdEqualTo (cartUUID).andGoodsIdEqualTo (goodsId).andDirectBuyEqualTo (isDirectBuy).andSpecIdIsNull ().andDeleteStatusEqualTo (deleteStatus);
			}
			List <CartDetail> details = this.cartDetailService.getObjectList (detailExample);
			if (!details.isEmpty ())
			{
				cartDetail = details.get (0);
			}
			return cartDetail;
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
	public BigDecimal getPayment (List <GoodsCartShow> list)
		{
			BigDecimal totalPayment = new BigDecimal (0);
			for (GoodsCartShow g : list)
			{
				/*
				 * BigDecimal temp = getGoodsPrice(Long.valueOf(g.getGoodsId()));
				 * if(temp == null) { continue; }
				 */
				BigDecimal temp = new BigDecimal (g.getGoodsPrice ());
				temp = temp.multiply (new BigDecimal (g.getCount ()));
				totalPayment = totalPayment.add (temp);
			}
			return totalPayment;
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
	public Cart getRecordForCart (Long userId , boolean cartStatus , boolean isDirectBuy)
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
	public synchronized boolean lockGoods (List <Long> goodsIds , Long userId , boolean directBuy)
		{
			CartDetail cartDetail = null;
			List <Integer> cartCounts = new ArrayList <Integer> ();
			int rollbackCount = 0;
			String cartUUID = null;
			if (!directBuy)
			{
				cartUUID = isAreadyRecordForCart (userId);
			}
			else
			{
				cartDetail = getRecordForCartDetail (null , goodsIds.get (0) , null , directBuy , false);
				if (cartDetail == null)
				{
					return false;
				}
				cartUUID = cartDetail.getGoodsCartId ();
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
	private boolean removeRepository (Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			if (goods != null)
			{
				return removeGoodsRepository (goods , count);
			}
			return false;
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
	private boolean removeGoodsRepository (GoodsWithBLOBs goods , Integer count)
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
	 * @Title: addRepository
	 * @Description: 增加库存
	 * @param goodsId
	 * @param count
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月12日 下午8:27:28
	 */
	public void addRepository (Long goodsId , Integer count)
		{
			GoodsWithBLOBs goods = this.goodsService.getByKey (goodsId);
			addGoodsRepository (goods , count);
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
	private void addGoodsRepository (GoodsWithBLOBs goods , Integer count)
		{
			/* 修改DBA数量 */
			goods.setGoodsInventory (goods.getGoodsInventory () + count);
			this.goodsService.updateByObject (goods);
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
	public List <CartDetail> getRecordForCartDetails (String cartUUID , Long goodsId , String goodsProperty , boolean directBuy , boolean deleteStatus)
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
}
