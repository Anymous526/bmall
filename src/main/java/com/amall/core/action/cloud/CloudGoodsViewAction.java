package com.amall.core.action.cloud;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Address;
import com.amall.core.bean.CloudBuyCodes;
import com.amall.core.bean.CloudBuyerDetail;
import com.amall.core.bean.CloudBuyerDetailExample;
import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudCodesExample;
import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsExample;
import com.amall.core.bean.CloudGoodsExample.Criteria;
import com.amall.core.bean.CloudGoodsOrder;
import com.amall.core.bean.CloudOnline;
import com.amall.core.bean.CloudOnlineExample;
import com.amall.core.bean.CloudOpen;
import com.amall.core.bean.CloudOpenExample;
import com.amall.core.bean.CloudShowOrder;
import com.amall.core.bean.CloudShowOrderExample;
import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.OrderAddress;
import com.amall.core.bean.User;
import com.amall.core.push.jpush.JPush;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.address.IOrderAddressService;
import com.amall.core.service.cloud.ICloudBuyCodesService;
import com.amall.core.service.cloud.ICloudBuyerDetailService;
import com.amall.core.service.cloud.ICloudCodesService;
import com.amall.core.service.cloud.ICloudGoodsAutoService;
import com.amall.core.service.cloud.ICloudGoodsOrderService;
import com.amall.core.service.cloud.ICloudGoodsService;
import com.amall.core.service.cloud.ICloudOnlineService;
import com.amall.core.service.cloud.ICloudOpenService;
import com.amall.core.service.cloud.ICloudShowOrderService;
import com.amall.core.service.cloud.ICloudStatisticsAutoService;
import com.amall.core.service.cloud.ICloudStatisticsService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CloudGoodsAutoPublicTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class CloudGoodsViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICloudGoodsService cloudGoodsService;

	@Autowired
	private ICloudOnlineService cloudOnlineService;

	@Autowired
	private ICloudBuyerDetailService cloudBuyerDetailService;

	@Autowired
	private ICloudOpenService cloudOpenService;

	@Autowired
	private ICloudCodesService cloudCodesService;

	@Autowired
	private ICloudStatisticsService cloudStatisticsService;

	@Autowired
	private ICloudShowOrderService cloudShowOrderService;

	@Autowired
	private ICloudGoodsOrderService cloudGoodsOrderService;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private IOrderAddressService orderAddressService;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private ICloudBuyCodesService cloudBuyCodesService;

	@Autowired
	private CloudGoodsAutoPublicTools cloudGoodsAutoPublicTools;

	@Autowired
	private ICloudGoodsAutoService cloudGoodsAutoService;

	@Autowired
	private ICloudStatisticsAutoService cloudStatisticsAutoService;

	/* 兑购头部 */
	@RequestMapping({ "/duigou_head.htm" })
	public ModelAndView duigou_head (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("duigou_head.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/* 获取统计信息 */
			CloudStatistics statistics = cloudStatisticsService.getCloudStatistics ();
			String jionUsers = "00000000";
			if (statistics != null)
			{
				jionUsers = getShowNumberString (jionUsers , statistics.getUserCount ());
			}
			mv.addObject ("totalUsers" , jionUsers);
			return mv;
		}

	@RequestMapping({ "/duigou_statics_ajax.htm" })
	@ResponseBody
	public String duigou_statics_ajax (HttpServletRequest request , HttpServletResponse response)
		{
			/* 获取统计信息 */
			CloudStatistics statistics = cloudStatisticsService.getCloudStatistics ();
			String jionUsers = "00000000";
			if (statistics != null)
			{
				jionUsers = getShowNumberString (jionUsers , statistics.getUserCount ());
			}
			return jionUsers;
		}

	/* 兑购菜单 */
	@RequestMapping({ "/duigou_nav.htm" })
	public ModelAndView duigou_nav (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("duigou_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 天使云兑-首页 1元购 */
	@RequestMapping({ "/angel_exchange.htm" })
	public ModelAndView angel_exchange (HttpServletRequest request , HttpServletResponse response , String currentPage , String currentPage1)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Date nowDate = new Date ();
			/* 最近购买和最新开奖 */
			setIndexList (mv , nowDate);
			Pagination CloudGoodsList = getNotOpenGoods (nowDate , 1 , 10 , currentPage);
			// Pagination CloudGoodsList10 = getNotOpenGoods(nowDate, 10, null,currentPage1);
			Integer goodsNum = 0;
			List <CloudGoods> list = angel_exchange_all1 (request , response);
			if (list != null && list.size () > 0)
			{
				goodsNum = list.size ();
			}
			String webPath = CommUtil.getURL (request);
			String url = webPath + "/angel_exchange.htm";
			CommUtil.addIPageList2ModelAndView (url , null , "" , CloudGoodsList , mv);
			// CommUtil.addIPageList2ModelAndView1(url, null, "", CloudGoodsList10, mv);
			mv.addObject ("nowDate" , System.currentTimeMillis ());
			mv.addObject ("goodsNum" , goodsNum);
			return mv;
		}

	/* 天使云兑-首页 10元购 */
	@RequestMapping({ "/angel_exchange10.htm" })
	public ModelAndView angel_exchange10 (HttpServletRequest request , HttpServletResponse response , String currentPage , String currentPage1)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange10.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Date nowDate = new Date ();
			/* 最近购买和最新开奖 */
			setIndexList (mv , nowDate);
			// Pagination CloudGoodsList = getNotOpenGoods(nowDate, 1, 10,currentPage);
			Pagination CloudGoodsList10 = getNotOpenGoods (nowDate , 10 , null , currentPage1);
			Integer goodsNum = 0;
			List <CloudGoods> list = angel_exchange_all1 (request , response);
			if (list != null && list.size () > 0)
			{
				goodsNum = list.size ();
			}
			String webPath = CommUtil.getURL (request);
			String url = webPath + "/angel_exchange10.htm";
			// CommUtil.addIPageList2ModelAndView(url, null, "", CloudGoodsList, mv);
			CommUtil.addIPageList2ModelAndView1 (url , null , "" , CloudGoodsList10 , mv);
			mv.addObject ("nowDate" , System.currentTimeMillis ());
			mv.addObject ("goodsNum" , goodsNum);
			return mv;
		}

	public void setIndexList (ModelAndView mv , Date nowDate)
		{
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			/* 查找是否有流拍的商品，没有置为流拍状态 */
			goodsExample.createCriteria ().andEndTimeLessThan (nowDate).andIsPassedEqualTo (false).andUserIdIsNull ().andDeletestatusEqualTo (false);
			List <CloudGoods> passCloudGoods = cloudGoodsService.getObjectList (goodsExample);
			/* 置为流拍 */
			for (CloudGoods cloudGoods : passCloudGoods)
			{
				cloudGoods.setIsPassed (true);
				cloudGoodsService.updateByObject (cloudGoods);
				cloudGoodsAutoPublicTools.openAndPassAddCloudGoods (cloudGoods , "pass");
				/* 删除相关数据 */
				deletePassCloudGoods (cloudGoods);
			}
			/* 获取最新开奖的4条信息 */
			goodsExample.clear ();
			goodsExample.setOrderByClause ("open_winner_time desc limit 0, 4");
			goodsExample.createCriteria ().andOpenWinnerCodeIsNotNull ();
			List <CloudGoods> openList = cloudGoodsService.getObjectList (goodsExample);
			mv.addObject ("openList" , openList);
			/* 获取最新参与的四条轮播记录 */
			goodsExample.clear ();
			CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
			cloudOnlineExample.setOrderByClause ("addTime desc limit 0, 4");
			List <CloudOnline> pollList = cloudOnlineService.getObjectList (cloudOnlineExample);
			mv.addObject ("pollList" , pollList);
		}

	public List <CloudGoods> getNotOpenGoods (Date nowDate , Integer beginPrice , Integer endPrice)
		{
			/* 查找正在兑购的商品,按结束时间降序排列 */
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("end_time desc");
			Criteria criteria = goodsExample.createCriteria ();
			criteria.andBeginTimeLessThanOrEqualTo (nowDate).andEndTimeGreaterThanOrEqualTo (nowDate).andIsShowEqualTo (true).andUserIdIsNull ().andGoodsNumberGreaterThanOrEqualTo (beginPrice).andDeletestatusEqualTo (false);
			if (endPrice != null)
			{
				criteria.andGoodsNumberLessThan (endPrice);
			}
			List <CloudGoods> CloudGoodsList = cloudGoodsService.getObjectList (goodsExample);
			return CloudGoodsList;
		}

	public Pagination getNotOpenGoods (Date nowDate , Integer beginPrice , Integer endPrice , String page)
		{
			/* 查找正在兑购的商品,按结束时间降序排列 */
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("end_time desc");
			Criteria criteria = goodsExample.createCriteria ();
			criteria.andBeginTimeLessThanOrEqualTo (nowDate).andEndTimeGreaterThanOrEqualTo (nowDate).andIsShowEqualTo (true).andUserIdIsNull ().andGoodsNumberGreaterThanOrEqualTo (beginPrice).andDeletestatusEqualTo (false);
			if (endPrice != null)
			{
				criteria.andGoodsNumberLessThan (endPrice);
			}
			goodsExample.setPageNo (CommUtil.null2Int (page));
			Pagination CloudGoodsList = cloudGoodsService.getObjectListWithPage (goodsExample);
			return CloudGoodsList;
		}

	/* 天使云兑-所有商品 */
	@RequestMapping({ "/angel_exchange_all.htm" })
	public ModelAndView angel_exchange_all (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_all.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Date nowDate = new Date ();
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			goodsExample.setOrderByClause ("end_time desc");
			goodsExample.createCriteria ().andBeginTimeLessThanOrEqualTo (nowDate).andEndTimeGreaterThanOrEqualTo (nowDate).andIsShowEqualTo (true).andUserIdIsNull ().andDeletestatusEqualTo (false);
			List <CloudGoods> CloudGoodsList = cloudGoodsService.getObjectList (goodsExample);
			mv.addObject ("objs" , CloudGoodsList);
			mv.addObject ("nowDate" , System.currentTimeMillis ());
			return mv;
		}

	/* 天使云兑-所有商品 */
	public List <CloudGoods> angel_exchange_all1 (HttpServletRequest request , HttpServletResponse response)
		{
			Date nowDate = new Date ();
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			goodsExample.setOrderByClause ("end_time desc");
			goodsExample.createCriteria ().andBeginTimeLessThanOrEqualTo (nowDate).andEndTimeGreaterThanOrEqualTo (nowDate).andIsShowEqualTo (true).andUserIdIsNull ().andDeletestatusEqualTo (false);
			List <CloudGoods> CloudGoodsList = cloudGoodsService.getObjectList (goodsExample);
			return CloudGoodsList;
		}

	/* 天使云兑-最新揭晓 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/angel_exchange_new.htm" })
	public ModelAndView angel_exchange_new (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_new.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudGoodsExample goodsExample = new CloudGoodsExample ();
			goodsExample.setOrderByClause ("open_winner_time desc");
			goodsExample.createCriteria ().andIsShowEqualTo (true).andUserIdIsNotNull ().andDeletestatusEqualTo (false).andIsPassedEqualTo (false);
			goodsExample.setPageNo (CommUtil.null2Int (currentPage));
			Pagination CloudGoodsList = cloudGoodsService.getObjectListWithPage (goodsExample);
			if (CloudGoodsList.getList () != null && CloudGoodsList.getList ().size () > 0)
			{
				for (CloudGoods cloudGoods : (List <CloudGoods>) CloudGoodsList.getList ())
				{
					CloudBuyerDetail buyerDetail = cloudBuyerDetailService.getCloudBuyerDetailOfCloudGoodsIdAndUserId (cloudGoods.getId () , cloudGoods.getUserId ());
					if (buyerDetail != null)
					{
						cloudGoods.setWinnerBuyCodes (buyerDetail.getBuyCounts ());
					}
				}
			}
			// mv.addObject("objs", CloudGoodsList);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/angel_exchange_new.htm" , null , "" , CloudGoodsList , mv);
			/* 获取总的开奖商品 */
			CloudStatistics cloudStatistics = cloudStatisticsService.getCloudStatistics ();
			long totalCount = 0;
			if (cloudStatistics != null)
			{
				totalCount = cloudStatistics.getGoodsWinnerCount ();
			}
			mv.addObject ("totalOpen" , totalCount);
			return mv;
		}

	/* 天使云兑-晒单有礼 */
	@RequestMapping({ "/angel_exchange_show.htm" })
	public ModelAndView angel_exchange_show (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_show.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudGoodsExample cloudGoodsExample = new CloudGoodsExample ();
			cloudGoodsExample.createCriteria ().andDeletestatusEqualTo (false);
			List <CloudGoods> cloudGoodsList = cloudGoodsService.getObjectList (cloudGoodsExample);
			List <Long> cloudGoodsIds = new ArrayList <Long> ();
			for (CloudGoods cloudGoods : cloudGoodsList)
			{
				cloudGoodsIds.add (cloudGoods.getId ());
			}
			CloudShowOrderExample cloudShowOrderExample = new CloudShowOrderExample ();
			cloudShowOrderExample.setOrderByClause ("addTime desc");
			cloudShowOrderExample.setPageNo (CommUtil.null2Int (currentPage));
			cloudShowOrderExample.createCriteria ().andCloudGoodsIdIn (cloudGoodsIds);
			Pagination cloudShowOrders = cloudShowOrderService.getObjectListWithPage (cloudShowOrderExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/angel_exchange_show.htm" , null , "" , cloudShowOrders , mv);
			return mv;
		}

	/* 晒单详情 */
	@RequestMapping({ "/angel_ex_show_detail.htm" })
	public ModelAndView angel_ex_show_detail (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("angel_ex_show_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudBuyerDetailExample cloudBuyerDetailExample = new CloudBuyerDetailExample ();
			cloudBuyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (CommUtil.null2Long (id));
			Integer userCount = cloudBuyerDetailService.getObjectListCount (cloudBuyerDetailExample);// 购买人次
			CloudGoods cloudGoods = cloudGoodsService.getByKey (CommUtil.null2Long (id));
			/* 最新获奖者 */
			CloudGoodsExample cloudGoodsExample = new CloudGoodsExample ();
			cloudGoodsExample.setOrderByClause ("addTime desc limit 0,6");
			cloudGoodsExample.createCriteria ().andIsPassedEqualTo (false).andUserIdIsNotNull ();
			List <CloudGoods> newWinners = cloudGoodsService.getObjectList (cloudGoodsExample);
			/* 晒单详情 */
			CloudShowOrderExample cloudShowOrderExample = new CloudShowOrderExample ();
			cloudShowOrderExample.createCriteria ().andCloudGoodsIdEqualTo (CommUtil.null2Long (id));
			CloudShowOrder cloudShowOrder = cloudShowOrderService.getObjectList (cloudShowOrderExample).get (0);
			/* 最新晒单 */
			cloudShowOrderExample.clear ();
			cloudShowOrderExample.setOrderByClause ("addTime desc limit 0,4");
			List <CloudShowOrder> cloudShowOrderList = cloudShowOrderService.getObjectList (cloudShowOrderExample);
			mv.addObject ("userCount" , userCount);
			mv.addObject ("cloudGoods" , cloudGoods);
			mv.addObject ("newWinners" , newWinners);
			mv.addObject ("cloudShowOrder" , cloudShowOrder);
			mv.addObject ("cloudShowOrderList" , cloudShowOrderList);
			return mv;
		}

	/* 会员区-详情 */
	@RequestMapping({ "/angel_member_detail.htm" })
	public ModelAndView angel_member_detail (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("angel_member_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudGoods cloudGoods = cloudGoodsService.getByKey (Long.valueOf (id));
			if (cloudGoods == null)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "没有该商品或已经下架");
				mv.addObject ("url" , CommUtil.getURL (request) + "/angel_exchange_show.htm");
				return mv;
			}
			cloudGoods.setClickCount (cloudGoods.getClickCount () + 1);
			cloudGoodsService.updateByObject (cloudGoods);
			mv.addObject ("obj" , cloudGoods);
			mv.addObject ("nowDate" , System.currentTimeMillis ());
			/* 获取购买记录 */
			if (cloudGoods.getOpenWinnerTime () == null)
			{
				CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
				cloudOnlineExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				List <CloudOnline> onlineList = cloudOnlineService.getObjectList (cloudOnlineExample);
				mv.addObject ("buyerList" , onlineList);
			}
			else
			{
				CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
				buyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				List <CloudBuyerDetail> buyerList = cloudBuyerDetailService.getObjectList (buyerDetailExample);
				for (CloudBuyerDetail buyerDetail : buyerList)
				{
					buyerDetail.setCloudCodesDetail (setBuyerCloudCodesDetail (cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsIdAndUserId (buyerDetail.getCloudGoodsId () , buyerDetail.getUserId ())));
				}
				mv.addObject ("buyerList" , buyerList);
				/* 单独获取中奖人的号码 */
				buyerDetailExample.clear ();
				buyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ()).andUserIdEqualTo (cloudGoods.getUserId ());
				mv.addObject ("buyerAddTime" , cloudBuyerDetailService.getObjectList (buyerDetailExample).get (0).getAddtime ());
			}
			/* 获取晒单信息 */
			if (cloudGoods.getOpenWinnerTime () != null)
			{
				CloudOpen cloudOpen = cloudOpenService.getCloudOpen (Long.valueOf (id));
				if (cloudOpen.getShowOrderId () != null)
				{
					mv.addObject ("order" , cloudShowOrderService.getByKey (cloudOpen.getShowOrderId ()));
				}
			}
			return mv;
		}

	/* 天使云兑-详情 */
	@RequestMapping({ "/angel_exchange_detail.htm" })
	public ModelAndView angel_exchange_detail (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudGoods cloudGoods = cloudGoodsService.getByKey (Long.valueOf (id));
			if (cloudGoods == null)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "没有该商品或已经下架");
				mv.addObject ("url" , CommUtil.getURL (request) + "/angel_exchange_show.htm");
				return mv;
			}
			cloudGoods.setClickCount (cloudGoods.getClickCount () + 1);
			cloudGoodsService.updateByObject (cloudGoods);
			mv.addObject ("obj" , cloudGoods);
			mv.addObject ("nowDate" , System.currentTimeMillis ());
			/* 获取购买记录 */
			if (cloudGoods.getOpenWinnerTime () == null)
			{
				CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
				cloudOnlineExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				List <CloudOnline> onlineList = cloudOnlineService.getObjectList (cloudOnlineExample);
				mv.addObject ("buyerList" , onlineList);
			}
			else
			{
				CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
				buyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				List <CloudBuyerDetail> buyerList = cloudBuyerDetailService.getObjectList (buyerDetailExample);
				for (CloudBuyerDetail buyerDetail : buyerList)
				{
					buyerDetail.setCloudCodesDetail (setBuyerCloudCodesDetail (cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsIdAndUserId (buyerDetail.getCloudGoodsId () , buyerDetail.getUserId ())));
				}
				mv.addObject ("buyerList" , buyerList);
				/* 单独获取中奖人的号码 */
				buyerDetailExample.clear ();
				buyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ()).andUserIdEqualTo (cloudGoods.getUserId ());
				mv.addObject ("buyerAddTime" , cloudBuyerDetailService.getObjectList (buyerDetailExample).get (0).getAddtime ());
			}
			/* 获取晒单信息 */
			if (cloudGoods.getOpenWinnerTime () != null)
			{
				CloudOpen cloudOpen = cloudOpenService.getCloudOpen (Long.valueOf (id));
				if (cloudOpen.getShowOrderId () != null)
				{
					mv.addObject ("order" , cloudShowOrderService.getByKey (cloudOpen.getShowOrderId ()));
				}
			}
			return mv;
		}

	/* 天使云兑-开奖详情 */
	@RequestMapping({ "/angel_winning_results.htm" })
	public ModelAndView angel_winning_results (HttpServletRequest request , HttpServletResponse response , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("angel_winning_results.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getCloudOpen (Long.valueOf (goodsId));
			CloudBuyerDetail buyerDetail = cloudBuyerDetailService.getCloudBuyerDetailOfCloudGoodsIdAndUserId (Long.valueOf (goodsId) , cloudOpen.getUserId ());
			cloudOpen.setJoinTime (buyerDetail.getAddtime ());
			cloudOpen.setBuyCount (buyerDetail.getBuyCounts ());
			List <Integer> codes = getBuyerCodes (cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsIdAndUserId (Long.valueOf (goodsId) , cloudOpen.getUserId ()));
			mv.addObject ("obj" , cloudOpen);
			mv.addObject ("numbers" , codes);
			return mv;
		}

	/* 天使云兑-支付页面 */
	@RequestMapping({ "/angel_exchange_pay.htm" })
	public ModelAndView angel_exchange_pay (HttpServletRequest request , HttpServletResponse response , String id , String count)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new JModelAndView ("redirect:buyer/buyer_index.htm");
			}
			CloudGoods cloudGoods = cloudGoodsService.getByKey (Long.valueOf (id));
			int buyCount = Integer.valueOf (count);
			if ((mv = payVerif (mv , user , cloudGoods , buyCount , request , response)) != null)
			{
				return mv;
			}
			mv = new JModelAndView ("angel_exchange_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("obj" , cloudGoods);
			mv.addObject ("count" , Integer.valueOf (count));
			return mv;
		}

	/* 天使云兑-支付 */
	@RequestMapping({ "/angel_exchange_pay_save.htm" })
	public ModelAndView angel_exchange_pay_save (HttpServletRequest request , HttpServletResponse response , String id , String count , String inputOnes)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new ModelAndView ("redirect:buyer/buyer_index.htm");
			}
			CloudGoods cloudGoods = cloudGoodsService.getByKey (Long.valueOf (id));
			if (cloudGoods.getBuyerCodeCount () == 0 && Integer.parseInt (inputOnes) == 0)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "请输入大于等于1的数");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
				return mv;
			}
			int buyCodes = Integer.valueOf (count);
			if ((mv = payVerif (mv , user , cloudGoods , buyCodes , request , response)) != null)
			{
				return mv;
			}
			/* 增加云码购买数量 */
			if (!SyzUpdateCloudGoods (cloudGoods.getId () , buyCodes))
			{
				return cloudPayFail (mv , "该商品已售完" , request , response);
			}
			cloudGoods = cloudGoodsService.getByKey (cloudGoods.getId ());
			/* 保存用户兑购中商品购买信息 */
			saveOnline (user , cloudGoods , buyCodes);
			/* 保存用户兑购码信息 */
			savebuyCodes (cloudGoods.getId () , buyCodes , user , Integer.valueOf (inputOnes));
			/* 扣除用户礼品金 */
			user.setGold (user.getGold () - (buyCodes * cloudGoods.getGoodsNumber ()));
			userService.updateByObject (user);
			/* 确认是否满足开奖 */
			if (cloudGoods.getBuyerCodeCount ().intValue () == cloudGoods.getGoodsCount ().intValue ())
			{
				/* 开奖 */
				openWinner (cloudGoods);
				cloudGoodsAutoPublicTools.openAndPassAddCloudGoods (cloudGoods , "open");
			}
			mv = new JModelAndView ("angel_exchange_pay_success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 晒单有礼 */
	@RequestMapping({ "/goods_show.htm" })
	public ModelAndView goods_show (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("goods_show.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 最近揭晓 */
	@RequestMapping({ "/lastest_announce.htm" })
	public ModelAndView lastest_announce (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("lastest_announce.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 我的云兑订单详情 */
	@RequestMapping({ "/angel_exchange_myorder_detail.htm" })
	public ModelAndView angel_exchange_myorder_detail (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_myorder_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 云兑结果查看更多 */
	@RequestMapping({ "/angel_winner_numbermore.htm" })
	public ModelAndView angel_winner_numbermore (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("angel_winner_numbermore.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 云兑结果计算结果 */
	@RequestMapping({ "/angel_result_list.htm" })
	public ModelAndView angel_result_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("angel_result_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 个人中心的我的云兑购 */
	/* 我的云兑购 */
	@RequestMapping({ "/my_angel_exchang.htm" })
	public ModelAndView my_angel_exchang (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("my_angel_exchang.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
			cloudOnlineExample.createCriteria ().andUserIdEqualTo (user.getId ());
			int onlineCount = cloudOnlineService.getObjectListCount (cloudOnlineExample);
			CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
			buyerDetailExample.createCriteria ().andUserIdEqualTo (user.getId ()).andIsOpenEqualTo (true);
			int buyerCount = cloudBuyerDetailService.getObjectListCount (buyerDetailExample);
			mv.addObject ("onlineCount" , onlineCount);
			mv.addObject ("buyerCount" , buyerCount);
			return mv;
		}

	/* 所有参与记录 */
	@RequestMapping({ "/angel_result_allrecord.htm" })
	public ModelAndView angel_result_allrecord (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("angel_result_allrecord.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			CloudBuyerDetailExample example = new CloudBuyerDetailExample ();
			example.createCriteria ().andCloudGoodsIdEqualTo (cloudOpen.getCloudGoodsId ()).andUserIdNotEqualTo (cloudOpen.getUserId ());
			List <CloudBuyerDetail> buyerDetails = cloudBuyerDetailService.getObjectList (example);
			mv.addObject ("objs" , buyerDetails);
			return mv;
		}

	/* 投票结果 */
	@RequestMapping({ "/angel_result_vote.htm" })
	public ModelAndView angel_result_vote (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("angel_result_vote.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			CloudBuyerDetailExample example = new CloudBuyerDetailExample ();
			example.createCriteria ().andCloudGoodsIdEqualTo (cloudOpen.getCloudGoodsId ());
			List <CloudBuyerDetail> buyerDetails = cloudBuyerDetailService.getObjectList (example);
			mv.addObject ("objs" , buyerDetails);
			mv.addObject ("goodsDetail" , buyerDetails.get (0).getCloudGoods ());
			return mv;
		}

	/* 云兑购记录正在进行 */
	@RequestMapping({ "/my_angel_exchang_list_ing.htm" })
	public ModelAndView my_angel_exchang_list_ing (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_list_ing.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
			buyerDetailExample.createCriteria ().andUserIdEqualTo (user.getId ()).andIsOpenEqualTo (false);
			buyerDetailExample.setPageNo (CommUtil.null2Int (currentPage));
			Pagination buyerDetails = cloudBuyerDetailService.getObjectListWithPage (buyerDetailExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/my_angel_exchang_list_ing.htm" , null , "" , buyerDetails , mv);
			// mv.addObject("objs", buyerDetails);
			mv.addObject ("totalCount" , buyerDetails.getTotalCount ());
			/* 获取已揭晓数量 */
			buyerDetailExample.clear ();
			buyerDetailExample.createCriteria ().andUserIdEqualTo (user.getId ()).andIsOpenEqualTo (true);
			mv.addObject ("winCount" , cloudBuyerDetailService.getObjectListCount (buyerDetailExample));
			return mv;
		}

	/* 云兑购记录已揭晓 */
	@RequestMapping({ "/my_angel_exchang_list_ed.htm" })
	public ModelAndView my_angel_exchang_list_ed (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_list_ed.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
			buyerDetailExample.setOrderByClause ("cloud_Goods_id desc");
			buyerDetailExample.createCriteria ().andUserIdEqualTo (user.getId ()).andIsOpenEqualTo (true);
			buyerDetailExample.setPageNo (CommUtil.null2Int (currentPage));
			Pagination buyerDetails = cloudBuyerDetailService.getObjectListWithPage (buyerDetailExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/my_angel_exchang_list_ed.htm" , null , "" , buyerDetails , mv);
			// mv.addObject("objs", buyerDetails);
			mv.addObject ("totalCount" , buyerDetails.getTotalCount ());
			/* 获取已揭晓数量 */
			buyerDetailExample.clear ();
			buyerDetailExample.createCriteria ().andUserIdEqualTo (user.getId ()).andIsOpenEqualTo (false);
			mv.addObject ("noWinCount" , cloudBuyerDetailService.getObjectListCount (buyerDetailExample));
			return mv;
		}

	/* 云兑购记录本次兑换详情次数 */
	@RequestMapping({ "/my_angel_exchang_list_xq.htm" })
	public ModelAndView my_angel_exchang_list_xq (HttpServletRequest request , HttpServletResponse response , String cloudGoodsId)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_list_xq.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("objs" , cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsIdAndUserId (Long.valueOf (cloudGoodsId) , SecurityUserHolder.getCurrentUser ().getId ()));
			return mv;
		}

	/* 中奖记录 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/my_angel_exchang_winning.htm" })
	public ModelAndView my_angel_exchang_winning (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_winning.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			CloudOpenExample example = new CloudOpenExample ();
			example.setOrderByClause ("addtime desc");
			example.createCriteria ().andUserIdEqualTo (user.getId ());
			example.setPageNo (CommUtil.null2Int (currentPage));
			Pagination cloudOpens = cloudOpenService.getObjectListWithPage (example);
			/* 获取开奖码 */
			if (cloudOpens.getList () != null && cloudOpens.getList ().size () > 0)
			{
				for (CloudOpen cloudOpen : (List <CloudOpen>) cloudOpens.getList ())
				{
					List <Integer> buyerCodes = getBuyerCodes (cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsIdAndUserId (cloudOpen.getCloudGoodsId () , cloudOpen.getUserId ()));
					cloudOpen.setCodes (buyerCodes);
					cloudOpen.setBuyCount (buyerCodes.size ());
					if (cloudOpen.getOrderId () != null)
					{
						cloudOpen.setOrder (cloudGoodsOrderService.getByKey (cloudOpen.getOrderId ()));
					}
				}
			}
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/my_angel_exchang_winning.htm" , null , "" , cloudOpens , mv);
			// mv.addObject("objs", cloudOpens);
			return mv;
		}

	/* 领取奖品 */
	@RequestMapping({ "/buyer/my_angel_exchang_goreceive.htm" })
	public ModelAndView my_angel_exchang_goreceive (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_goreceive.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			mv.addObject ("obj" , cloudOpen);
			return mv;
		}

	/* 中奖记录-确认领取 */
	@RequestMapping({ "/my_angex_order_save.htm" })
	public ModelAndView my_angex_order_save (HttpServletRequest request , HttpServletResponse response , String addressId , String openId)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (openId));
			CloudGoodsOrder goodsOrder = new CloudGoodsOrder ();
			goodsOrder.setAddTime (new Date ());
			goodsOrder.setCloudsGoodsId (Long.valueOf (cloudOpen.getCloudGoodsId ()));
			goodsOrder.setUserId (user.getId ());
			goodsOrder.setOrderId (CommUtil.generateOrderId ());
			goodsOrder.setOrderStatus (Globals.HAVE_PAYMENT);
			goodsOrder.setAddressId (createOrderAddress (Long.valueOf (addressId)));
			cloudGoodsOrderService.add (goodsOrder);
			cloudOpen.setOrderId (goodsOrder.getId ());
			cloudOpenService.updateByObject (cloudOpen);
			return new ModelAndView ("redirect:my_angel_exchang_winning.htm");
		}

	/* 中奖记录-确认收货 */
	@RequestMapping({ "/my_angex_order_send_save.htm" })
	public ModelAndView my_angex_order_send_save (HttpServletRequest request , HttpServletResponse response , String id)
		{
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			CloudGoodsOrder goodsOrder = cloudGoodsOrderService.getByKey (cloudOpen.getOrderId ());
			if (goodsOrder.getOrderStatus ().intValue () == Globals.HAVE_SEND_OUT_GOOD)
			{
				goodsOrder.setOrderStatus (Globals.HAVE_RECEIVED_GOOD);
				cloudGoodsOrderService.updateByObject (goodsOrder);
			}
			return new ModelAndView ("redirect:my_angel_exchang_winning.htm");
		}

	/* 查看订单详情 */
	@RequestMapping({ "/my_angel_exchang_orderdetails.htm" })
	public ModelAndView my_angel_exchang_orderdetails (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_orderdetails.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			cloudOpen.setOrder (cloudGoodsOrderService.getByKey (cloudOpen.getOrderId ()));
			List <KuaiDiResultItem> item = this.kuaidiService.getKuaidiInfo (cloudOpen.getOrder ().getShipCode ());
			mv.addObject ("transInfo" , item);
			mv.addObject ("status" , true);
			mv.addObject ("obj" , cloudOpen);
			return mv;
		}

	/* 商品的晒单 */
	@RequestMapping({ "/cloud_angel_exchang_share.htm" })
	public ModelAndView cloud_angel_exchang_share (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("cloud_angel_exchang_share.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			CloudShowOrderExample cloudShowOrderExample = new CloudShowOrderExample ();
			cloudShowOrderExample.createCriteria ().andCloudGoodsIdEqualTo (cloudOpen.getCloudGoodsId ());
			List <CloudShowOrder> cloudShowOrders = cloudShowOrderService.getObjectList (cloudShowOrderExample);
			mv.addObject ("objs" , cloudShowOrders);
			return mv;
		}

	/* 我的晒单 */
	@RequestMapping({ "/my_angel_exchang_share.htm" })
	public ModelAndView my_angel_exchang_share (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_share.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudShowOrderExample cloudShowOrderExample = new CloudShowOrderExample ();
			User user = SecurityUserHolder.getCurrentUser ();
			cloudShowOrderExample.setOrderByClause ("addTime desc");
			cloudShowOrderExample.createCriteria ().andUserIdEqualTo (user.getId ());
			cloudShowOrderExample.setPageNo (CommUtil.null2Int (currentPage));
			Pagination cloudShowOrders = cloudShowOrderService.getObjectListWithPage (cloudShowOrderExample);
			CommUtil.addIPageList2ModelAndView (CommUtil.getURL (request) + "/my_angel_exchang_share.htm" , null , "" , cloudShowOrders , mv);
			// mv.addObject("objs", cloudShowOrders);
			return mv;
		}

	/* 我要晒单 */
	@RequestMapping({ "/my_angel_exchang_goshare.htm" })
	public ModelAndView my_angel_exchang_goshare (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_angel_exchang_goshare.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			mv.addObject ("obj" , cloudOpen);
			return mv;
		}

	/* 晒单保存 */
	@RequestMapping({ "/my_angel_exchang_share_save.htm" })
	public ModelAndView my_angel_exchang_share_save (HttpServletRequest request , HttpServletResponse response , String id , String imgIds , String context)
		{
			CloudOpen cloudOpen = cloudOpenService.getByKey (Long.valueOf (id));
			if (cloudOpen.getShowOrderId () == null)
			{
				CloudShowOrder cloudShowOrder = new CloudShowOrder ();
				cloudShowOrder.setAddtime (new Date ());
				cloudShowOrder.setCloudGoodsId (cloudOpen.getCloudGoodsId ());
				cloudShowOrder.setUserId (cloudOpen.getUserId ());
				cloudShowOrder.setContext (context);
				if (StringUtils.isNotEmpty (imgIds))
				{
					String [ ] ids = StringUtils.split (imgIds , ",");
					int n = 0;
					for (String imgId : ids)
					{
						n++;
						if (StringUtils.isEmpty (imgId))
						{
							break;
						}
						Long lImgId = Long.valueOf (imgId);
						if (n == 1)
						{
							cloudShowOrder.setPhotoOne (lImgId);
						}
						else if (n == 2)
						{
							cloudShowOrder.setPhotoTwo (lImgId);
						}
						else if (n == 3)
						{
							cloudShowOrder.setPhotoThree (lImgId);
						}
					}
				}
				cloudOpen.setShowOrderId (setCloudOrder (cloudShowOrder));
				cloudOpenService.updateByObject (cloudOpen);
				return new ModelAndView ("redirect:my_angel_exchang_share.htm");
			}
			else
			{
				ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您已经晒过单了");
				mv.addObject ("url" , CommUtil.getURL (request) + "/my_angel_exchang_share.htm");
				return mv;
			}
		}

	private ModelAndView cloudPayFail (ModelAndView mv , String message , HttpServletRequest request , HttpServletResponse response)
		{
			mv = new JModelAndView ("angel_exchange_pay_fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("message" , message);
			return mv;
		}

	/**
	 * @Title: payVerif
	 * @Description: 支付前的验证
	 * @param mv
	 * @param user
	 * @param cloudGoods
	 * @param count
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月28日
	 */
	private ModelAndView payVerif (ModelAndView mv , User user , CloudGoods cloudGoods , Integer buyCount , HttpServletRequest request , HttpServletResponse response)
		{
			/* 是否过期 */
			if (cloudGoods.getEndTime ().getTime () < System.currentTimeMillis ())
			{
				return cloudPayFail (mv , "该商品已经过期" , request , response);
			}
			/* 是否已经揭奖 */
			if (cloudGoods.getUserId () != null)
			{
				return cloudPayFail (mv , "该商品已经开奖" , request , response);
			}
			/* 二次购买 */
			CloudOnline cloudOnline = cloudOnlineService.getCloudOnlineOfUserIdAndGoodsId (user.getId () , cloudGoods.getId ());
			int mayBuyCount = buyCount;
			if (cloudOnline != null)
			{
				mayBuyCount += cloudOnline.getCloudCodesCount ();
			}
			/* 礼品金是否足够 */
			if ((cloudGoods.getGoodsNumber () * buyCount) > user.getGold ())
			{
				return cloudPayFail (mv , "您的礼品金不足" , request , response);
			}
			/* 是否超过剩余可购云码 */
			if ((cloudGoods.getBuyerCodeCount () + buyCount) > cloudGoods.getGoodsCount () || mayBuyCount > cloudGoods.getExchangeLimit ())
			{
				return cloudPayFail (mv , "超出最大可购买数量" , request , response);
			}
			List <CloudCodes> cloudCodesList = cloudCodesService.getObjectList (cloudGoods.getId () , buyCount);
			if (cloudCodesList.isEmpty ())
			{
				return cloudPayFail (mv , "云码已经售完" , request , response);
			}
			return null;
		}

	/**
	 * @Title: saveOnline
	 * @Description: 保存正在兑购中商品信息
	 * @param user
	 * @param cloudGoods
	 * @param buyCodes
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月28日
	 */
	private void saveOnline (User user , CloudGoods cloudGoods , int buyCodes)
		{
			CloudOnline cloudOnline = cloudOnlineService.getCloudOnlineOfUserIdAndGoodsId (user.getId () , cloudGoods.getId ());
			if (cloudOnline == null)
			{
				cloudOnline = new CloudOnline ();
				cloudOnline.setAddtime (new Date ());
				cloudOnline.setCloudCodesCount (buyCodes);
				cloudOnline.setUserId (user.getId ());
				cloudOnline.setCloudGoodsId (cloudGoods.getId ());
				cloudOnlineService.add (cloudOnline);
			}
			else
			{
				cloudOnline.setCloudCodesCount (cloudOnline.getCloudCodesCount () + buyCodes);
				cloudOnlineService.updateByObject (cloudOnline);
			}
		}

	/**
	 * @Title: savebuyCodes
	 * @Description: 保存用户的兑购码
	 * @param cloudGoodsId
	 * @param buyCodes
	 * @param user
	 * @param selectNumber
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月29日
	 */
	private synchronized void savebuyCodes (long cloudGoodsId , int buyCodes , User user , int selectNumber)
		{
			List <CloudCodes> cloudCodesList = cloudCodesService.getObjectList (cloudGoodsId , buyCodes);
			StringBuffer buffer = new StringBuffer ();
			for (CloudCodes codes : cloudCodesList)
			{
				buffer.append (codes.getCode ()).append (",");
			}
			CloudBuyerDetail buyerDetail = getCloudBuyerDetail (user , cloudGoodsId);
			if (buyerDetail == null)
			{
				buyerDetail = new CloudBuyerDetail ();
				buyerDetail.setAddtime (new Date ());
				buyerDetail.setCloudGoodsId (cloudGoodsId);
				buyerDetail.setUserId (user.getId ());
				buyerDetail.setUserSelectNumber (selectNumber);
				buyerDetail.setBuyCounts (buyCodes);
				buyerDetail.setIsOpen (false);
				cloudBuyerDetailService.add (buyerDetail);
			}
			else
			{
				buyerDetail.setUserSelectNumber (buyerDetail.getUserSelectNumber () + selectNumber);
				buyerDetail.setBuyCounts (buyerDetail.getBuyCounts () + buyCodes);
				cloudBuyerDetailService.updateByObject (buyerDetail);
			}
			/* 增加购买记录 */
			CloudBuyCodes cloudBuyCodes = new CloudBuyCodes ();
			cloudBuyCodes.setAddTime (new Date ());
			cloudBuyCodes.setCloudGoodsId (cloudGoodsId);
			cloudBuyCodes.setUserId (user.getId ());
			cloudBuyCodes.setCodes (buffer.toString ());
			cloudBuyCodes.setSelectNumber (selectNumber);
			cloudBuyCodes.setBuyCount (cloudCodesList.size ());
			cloudBuyCodesService.add (cloudBuyCodes);
			/* 删除兑购中的码 */
			List <Integer> codes = new ArrayList <> ();
			for (CloudCodes cloudCodes : cloudCodesList)
			{
				codes.add (cloudCodes.getCode ());
			}
			CloudCodesExample example = new CloudCodesExample ();
			example.createCriteria ().andCodeIn (codes).andCloudGoodsIdEqualTo (cloudGoodsId);
			cloudCodesService.deleteByExample (example);
			/* 增加参与人数统计 */
			CloudStatistics statistics = cloudStatisticsService.getCloudStatistics ();
			statistics.setUserCount (statistics.getUserCount () + 1);
			cloudStatisticsService.updateByObject (statistics);
		}

	private CloudBuyerDetail getCloudBuyerDetail (User user , long cloudGoodsId)
		{
			CloudBuyerDetailExample example = new CloudBuyerDetailExample ();
			example.createCriteria ().andUserIdEqualTo (user.getId ()).andCloudGoodsIdEqualTo (cloudGoodsId);
			List <CloudBuyerDetail> list = cloudBuyerDetailService.getObjectList (example);
			if (list.isEmpty ())
			{
				return null;
			}
			return list.get (0);
		}

	/**
	 * @Title: openWinner
	 * @Description: 开奖
	 * @param userId
	 * @param goodsId
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月29日
	 */
	private void openWinner (CloudGoods cloudGoods)
		{
			CloudBuyerDetailExample example = new CloudBuyerDetailExample ();
			example.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
			List <CloudBuyerDetail> list = cloudBuyerDetailService.getObjectList (example);
			List <CloudBuyCodes> buyCodesList = cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsId (cloudGoods.getId ());
			int winCode = 0;
			long userId = 0l;
			int winnerBuyCount = 0;
			String [ ] arrCodes = null;
			boolean outFlag = false;
			/* 获取开奖号码 */
			for (CloudBuyerDetail detail : list)
			{
				winCode += detail.getUserSelectNumber ();
			}
			/* 开奖设置 */
			for (CloudBuyerDetail detail : list)
			{
				detail.setIsOpen (true);
				cloudBuyerDetailService.updateByObject (detail);
			}
			/* 获取中奖用户 */
			for (CloudBuyCodes codes : buyCodesList)
			{
				arrCodes = StringUtils.split (codes.getCodes () , ",");
				for (String code : arrCodes)
				{
					if (winCode == Integer.valueOf (code))
					{
						outFlag = true;
						break;
					}
				}
				if (outFlag)
				{
					userId = codes.getUserId ();
					winnerBuyCount = codes.getBuyCount ();
					break;
				}
			}
			if (userId != 0)
			{
				/* 填充获奖信息到商品表 */
				cloudGoods.setUserId (userId);
				cloudGoods.setOpenWinnerCode (winCode);
				cloudGoods.setOpenWinnerTime (new Date ());
				cloudGoodsService.updateByObject (cloudGoods);
				/* 填充获奖信息到开奖表 */
				CloudOpen cloudOpen = new CloudOpen ();
				cloudOpen.setAddtime (new Date ());
				cloudOpen.setCloudCode (winCode);
				cloudOpen.setCloudGoodsId (cloudGoods.getId ());
				cloudOpen.setUserId (userId);
				cloudOpen.setBuyCount (winnerBuyCount);
				cloudOpenService.add (cloudOpen);
				/* 删除该商品的在线码 */
				CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
				cloudOnlineExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				cloudOnlineService.deleteByExample (cloudOnlineExample);
				/* 增加统计信息 */
				CloudStatistics statistics = cloudStatisticsService.getCloudStatistics ();
				statistics.setAngelCoinCount (statistics.getAngelCoinCount () + (cloudGoods.getGoodsCount () * cloudGoods.getGoodsNumber ()));
				statistics.setGoodsWinnerCount (statistics.getGoodsWinnerCount () + 1);
				cloudStatisticsService.updateByObject (statistics);
				/* 推送开奖消息到所有平台 */
				Map <String, Object> msgMap = new HashMap <String, Object> ();
				msgMap.put ("winer" , userId);
				msgMap.put ("cloudGoodsId" , cloudGoods.getId ());
				JPush.sendMessageWithPassThroughAll (org.nutz.json.Json.toJson (msgMap) , "angel" + cloudGoods.getId ());
			}
		}

	private String setBuyerCloudCodesDetail (List <CloudBuyCodes> buyCodesList)
		{
			StringBuffer buffer = new StringBuffer ();
			for (CloudBuyCodes buyCodes : buyCodesList)
			{
				buffer.append (buyCodes.getCodes ());
			}
			return buffer.toString ();
		}

	private Long setCloudOrder (CloudShowOrder cloudShowOrder)
		{
			cloudShowOrderService.add (cloudShowOrder);
			CloudShowOrderExample cloudShowOrderExample = new CloudShowOrderExample ();
			cloudShowOrderExample.createCriteria ().andCloudGoodsIdEqualTo (cloudShowOrder.getCloudGoodsId ());
			return cloudShowOrderService.getObjectList (cloudShowOrderExample).get (0).getId ();
		}

	/**
	 * @Title: getOpenWinnerCodes
	 * @Description: 获取兑购码列表
	 * @param numbers
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年2月18日
	 */
	private List <Integer> getBuyerCodes (List <CloudBuyCodes> buyCodesList)
		{
			List <Integer> codes = new ArrayList <> ();
			StringBuffer numbers = new StringBuffer ();
			for (CloudBuyCodes buyCodes : buyCodesList)
			{
				numbers.append (buyCodes.getCodes ());
			}
			for (String s : StringUtils.split (numbers.toString () , ","))
			{
				if (StringUtils.isNotEmpty (s))
				{
					codes.add (Integer.valueOf (s));
				}
			}
			return codes;
		}

	/**
	 * @Title: passCloudGoods
	 * @Description: 流派商品
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年2月18日
	 */
	@RequestMapping({ "/angel_exchange_pass_goods.htm" })
	@ResponseBody
	public String passCloudGoods (HttpServletRequest request , HttpServletResponse response , String id)
		{
			if (StringUtils.isEmpty (id))
			{
				return "error";
			}
			CloudGoods cloudGoods = cloudGoodsService.getByKey (Long.valueOf (id));
			Date nowDate = new Date ();
			if (cloudGoods.getEndTime ().compareTo (nowDate) < 0 && cloudGoods.getOpenWinnerTime () == null)
			{
				cloudGoods.setIsPassed (true);
				cloudGoodsService.updateByObject (cloudGoods);
				/* 删除相关数据 */
				deletePassCloudGoods (cloudGoods);
				return "ok";
			}
			return "error";
		}

	/**
	 * @Title: deletePassCloudGoods
	 * @Description: 删除流拍后的相关数据
	 * @param goodsId
	 * @param request
	 * @throws
	 * @author tangxiang
	 * @date 2016年2月19日
	 */
	private void deletePassCloudGoods (CloudGoods cloudGoods)
		{
			/* 删除线上数据 */
			CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
			cloudOnlineExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
			cloudOnlineService.deleteByExample (cloudOnlineExample);
			/* 删除未分配云码 */
			CloudCodesExample cloudCodesExample = new CloudCodesExample ();
			cloudCodesExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
			cloudCodesService.deleteByExample (cloudCodesExample);
			/* 删除用户已购买云码 */
			/* 如果不是开奖商品，则退还用户礼品金 */
			if (cloudGoods.getOpenWinnerTime () == null)
			{
				List <CloudBuyCodes> buyCodesList = cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsId (cloudGoods.getId ());
				User tempUser = null;
				for (CloudBuyCodes buyCodes : buyCodesList)
				{
					tempUser = userService.getByKey (buyCodes.getUserId ());
					tempUser.setGold (tempUser.getGold () + (buyCodes.getBuyCount () * cloudGoods.getGoodsNumber ()));
					userService.updateByObject (tempUser);
				}
				CloudBuyerDetailExample buyerDetailExample = new CloudBuyerDetailExample ();
				buyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
				cloudBuyerDetailService.deleteByExample (buyerDetailExample);
			}
			/* 增加流拍统计数据 */
			CloudStatistics cloudStatistics = cloudStatisticsService.getCloudStatistics ();
			cloudStatistics.setGoodsPassCount (cloudStatistics.getGoodsPassCount () + 1);
			cloudStatisticsService.updateByObject (cloudStatistics);
		}

	/**
	 * @Title: SyzUpdateCloudGoods
	 * @Description: 同步购买减库存
	 * @param goodsId
	 * @param buyCodes
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年3月25日
	 */
	public synchronized boolean SyzUpdateCloudGoods (Long goodsId , int buyCodes)
		{
			CloudGoods cloudGoods = cloudGoodsService.getByKey (goodsId);
			if ((cloudGoods.getBuyerCodeCount () + buyCodes) > cloudGoods.getGoodsCount ())
			{
				return false;
			}
			cloudGoods.setBuyerCodeCount (cloudGoods.getBuyerCodeCount () + buyCodes);
			cloudGoodsService.updateByObject (cloudGoods);
			return true;
		}

	/**
	 * @Title: getShowNumberString
	 * @Description: 根据输入模板和实际数值返回模板字符串
	 * @param temp
	 * @param number
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年2月22日
	 */
	private String getShowNumberString (String temp , Long number)
		{
			String numberString = number.toString ();
			int len = 0;
			if (numberString.length () <= temp.length ())
			{
				len = numberString.length ();
			}
			else
			{
				len = temp.length ();
			}
			String tempStr = numberString.substring (0 , len);
			return temp.substring (len , temp.length ()) + tempStr;
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
	private Long createOrderAddress (Long addressId)
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
}
