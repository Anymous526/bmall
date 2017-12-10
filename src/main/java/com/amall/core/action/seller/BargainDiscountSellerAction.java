package com.amall.core.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.BargainSellerTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: BargainSellerAction
 * </p>
 * <p>
 * Description: 折扣特价管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日下午8:34:09
 * @version 1.0
 */
@Controller
public class BargainDiscountSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private BargainSellerTools bargainSellerTools;

	@SecurityMapping(title = "折扣特价列表" , value = "/seller/bargain_discount.htm*" , rtype = "seller" , rname = "折扣特价列表" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount.htm" })
	public ModelAndView bargain_limit_discount (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain_discount.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * int day_count = this.configService.getSysConfig().getBargainValidity(); //获得特价商品申请有效期
			 * List<Date> dates = new ArrayList<Date>();
			 * for (int i = 0; i < day_count; i++) {
			 * Calendar cal = Calendar.getInstance();
			 * cal.add(6, i + 1);
			 * dates.add(cal.getTime());
			 * }
			 * mv.addObject("dates", dates);
			 */
			String goodsId = request.getParameter ("goodsId");
			mv.addObject ("goodsId" , goodsId);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			BargainExample.Criteria bargainCriteria = bargainExample.createCriteria ();
			bargainCriteria.andMarkEqualTo (Integer.valueOf (2));
			bargainCriteria.andBargainStatusEqualTo ("1");
			bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo (CommUtil.formatString2Date (CommUtil.formatShortDate (new Date ())));
			List <Bargain> bargains = bargainService.getObjectList (bargainExample);
			mv.addObject ("bargains" , bargains);
			mv.addObject ("bargainSellerTools" , this.bargainSellerTools);
			return mv;
		}

	@SecurityMapping(title = "申请折扣特价" , value = "/seller/bargain_discount_apply.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_apply.htm" })
	public ModelAndView bargain_discount_apply (HttpServletRequest request , HttpServletResponse response , String bargainTime , String bargainEndTime , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain_discount_apply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * if (CommUtil.null2String(bargainTime).equals("")) {
			 * Calendar cal = Calendar.getInstance();
			 * cal.add(6, 1);
			 * bargainTime = CommUtil.formatShortDate(cal.getTime());
			 * }
			 * Calendar cal = Calendar.getInstance();
			 * cal.add(6, this.configService.getSysConfig().getBargainValidity());
			 * if (CommUtil.formatDate(bargainTime).after(cal.getTime())) {
			 * cal = Calendar.getInstance();
			 * cal.add(6, 1);
			 * bargainTime = CommUtil.formatShortDate(cal.getTime());
			 * }
			 */
			/* 获取商品信息 */
			Goods goods = goodsService.getByKey (Long.valueOf (goodsId));
			mv.addObject ("goods" , goods);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss")).andBargainEndTimeEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss")).andMarkEqualTo (Integer.valueOf (2));
			List <Bargain> bargain = bargainService.getObjectList (bargainExample);
			int audit_count = this.bargainSellerTools.query_bargain_audit (bargainTime , bargainEndTime , 2);
			int bargain_count = this.configService.getSysConfig ().getBargainMaximum ();
			if (bargain.size () > 0)
			{
				bargain_count = ((Bargain) bargain.get (0)).getMaximum ();
			}
			if (audit_count >= bargain_count)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "特价申请名额已满");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain_discount.htm");
			}
			mv.addObject ("bargain_rebate" , bargain.size () > 0 ? ((Bargain) bargain.get (0)).getRebate () : this.configService.getSysConfig ().getBargainRebate ());
			mv.addObject ("bargain_state" , bargain.size () > 0 ? ((Bargain) bargain.get (0)).getState () : this.configService.getSysConfig ().getBargainState ());
			mv.addObject ("bargainTime" , bargainTime);
			mv.addObject ("bargainEndTime" , bargainEndTime);
			return mv;
		}

	@SecurityMapping(title = "添加商品" , value = "/seller/bargain_discount_goods.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_goods.htm" })
	public void bargain_goods (HttpServletRequest request , HttpServletResponse response , String goods_name)
		{
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("addTime desc");
			goodsExample.createCriteria ().andGoodsNameLike ("%" + goods_name.trim () + "%").andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andGroupBuyEqualTo (Integer.valueOf (0)).andActivityStatusEqualTo (Integer.valueOf (0)).andBargainStatusEqualTo (Integer.valueOf (0));
			List <GoodsWithBLOBs> goods_list = goodsService.getObjectList (goodsExample);
			List <Map <String, Object>>  maps = new ArrayList <Map <String, Object>> ();
			for (GoodsWithBLOBs goods : goods_list)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("goods_name" , goods.getGoodsName ());
				map.put ("goods_id" , goods.getId ());
				maps.add (map);
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (maps , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "特价商品保存" , value = "/seller/bargain_discount_apply_save.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_apply_save.htm" })
	public String bargain_apply_save (HttpServletRequest request , HttpServletResponse response , String goodsId , String bargainTime , String bargainEndTime , String bg_rebate , String alImgId , String bargainGoodsStatus)
		{
			// if ((goods_ids != null) && (!goods_ids.equals(""))) {
			// String[] ids = goods_ids.split(",");
			// for (String id : ids) {
			if (goodsId != null && !"".equals (goodsId))
			{
				BargainGoods bg = new BargainGoods ();
				bg.setAddtime (new Date ());
				bg.setBgStatus (0);
				bg.setBgTime (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss"));
				bg.setBgEndTime (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss"));
				bg.setBargainGoodsStatus (bargainGoodsStatus);
				GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
				goods.setBargainStatus (1);
				this.goodsService.updateByObject (goods);
				/*
				 * double bg_price = CommUtil.mul(Double.valueOf(CommUtil.mul(
				 * Double.valueOf(0.1D), bg_rebate)), goods
				 * .getStorePrice());
				 */
				BigDecimal num = BigDecimal.valueOf (0.1D);
				BigDecimal reb = BigDecimal.valueOf (CommUtil.null2Double (bg_rebate));
				bg.setBgGoods (goods);
				BigDecimal now_price = BigDecimal.valueOf (CommUtil.mul (Double.valueOf (CommUtil.mul (num , reb)) , goods.getGoodsPrice ()));
				bg.setBgPrice (now_price);
				goods.setBargainStatus (1);
				this.goodsService.updateByObject (goods);
				bg.setBgGoods (goods);
				bg.setBgRebate (BigDecimal.valueOf (CommUtil.null2Double (bg_rebate)));
				bg.setAlImgId (Long.valueOf (alImgId));
				bg.setMark (2);
				this.bargainGoodsService.add (bg);
				// }
				// }
				return "redirect:bargain_discount_apply_success.htm?bargainTime=" + bargainTime + "&bargainEndTime=" + bargainEndTime;
			}
			return "redirect:bargain_apply_error.htm";
		}

	@SecurityMapping(title = "商品保存成功" , value = "/seller/bargain_discount_apply_success.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_apply_success.htm" })
	public ModelAndView bargain_apply_success (HttpServletRequest request , HttpServletResponse response , String bargainTime , String bargainEndTime , String editBgStatus)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (editBgStatus != null && !"".equals (editBgStatus))
			{
				mv.addObject ("op_title" , "折扣特价状态修改成功");
			}
			else
			{
				mv.addObject ("op_title" , "申请折扣特价成功");
			}
			// mv.addObject("url", CommUtil.getURL(request)+"/seller/bargain_discount.htm");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain_discount_goods_list.htm?bargainTime=" + bargainTime + "&bargainEndTime=" + bargainEndTime);
			return mv;
		}

	@SecurityMapping(title = "商品保存失败" , value = "/seller/bargain_discount_apply_error.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_apply_error.htm" })
	public ModelAndView bargain_apply_error (HttpServletRequest request , HttpServletResponse response , String editBgStatus)
		{
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (editBgStatus != null && !"".equals (editBgStatus))
			{
				mv.addObject ("op_title" , "限时特价状态修改失败");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain_discount.htm");
			}
			else
			{
				mv.addObject ("op_title" , "至少选择一件商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_goods.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "折扣特价商品列表" , value = "/seller/bargain_discount_goods_list.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_goods_list.htm" })
	public ModelAndView bargain_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String bargainTime , String bargainEndTime)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain_discount_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ());
			List <GoodsWithBLOBs> store_goodses = goodsService.getObjectList (goodsExample);
			List <Long> storeGoodsId = new ArrayList <Long> ();
			for (GoodsWithBLOBs storeGoods : store_goodses)
			{
				storeGoodsId.add (storeGoods.getId ());
			}
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setPageSize (Integer.valueOf (30));
			bargainGoodsExample.setOrderByClause ("addTime desc");
			bargainGoodsExample.createCriteria ().andMarkEqualTo (2);
			if (bargainTime != null && !"".equals (bargainTime))
			{
				bargainGoodsExample.createCriteria ().andBgTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss"));
			}
			bargainGoodsExample.createCriteria ().andBgGoodsIdIn (storeGoodsId);
			if (bargainEndTime != null && !"".equals (bargainEndTime))
			{
				bargainGoodsExample.createCriteria ().andBgEndTimeLessThanOrEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss"));
			}
			else
			{
				bargainGoodsExample.createCriteria ().andBgEndTimeIsNull ();
			}
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("bargain_time" , bargainTime);
			mv.addObject ("bargain_end_time" , bargainEndTime);
			return mv;
		}

	@SecurityMapping(title = "折扣特价状态修改" , value = "/seller/bargain_discount_goods_status_save.htm*" , rtype = "seller" ,
						rname = "折扣特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_discount_goods_status_save.htm" })
	public String bargain_time_goods_status_save (HttpServletRequest request , HttpServletResponse response , String id , String bargainGoodsStatus , String bargainTime , String bargainEndTime)
		{
			if (id != null && !"".equals (id))
			{
				BargainGoods bg = this.bargainGoodsService.getByKey (Long.valueOf (id));
				bg.setBargainGoodsStatus (bargainGoodsStatus);
				GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (bg.getBgGoodsId ()));
				if ("0".equals (bargainGoodsStatus))
				{
					bg.setCloseTime (new Date ());
					goods.setGoodsCurrentPrice (null);
				}
				else
				{
					bg.setCloseTime (null);
					goods.setGoodsCurrentPrice (bg.getBgPrice ());
				}
				this.bargainGoodsService.updateByObject (bg);
				this.goodsService.updateByObject (goods);
				return "redirect:bargain_discount_apply_success.htm?editBgStatus=1&bargainTime=" + bargainTime + "&bargainEndTime=" + bargainEndTime;
			}
			else
			{
				return "redirect:bargain_discount_error.htm?editBgStatus=1&bargainTime=" + bargainTime + "&bargainEndTime=" + bargainEndTime;
			}
		}
}
