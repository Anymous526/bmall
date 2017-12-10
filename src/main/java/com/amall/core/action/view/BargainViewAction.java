package com.amall.core.action.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.BargainSellerTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: BargainViewAction
 * </p>
 * <p>
 * Description:前台特价页面
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author 李越
 * @date 2015年6月26日下午7:19:22
 * @version 1.0
 */
@Controller
public class BargainViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private BargainSellerTools bargainSellerTools;

	/**
	 * 
	 * <p>
	 * Title: specialpricehead
	 * </p>
	 * <p>
	 * Description: 特价Body
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/specialpricehead.htm" })
	public ModelAndView specialpricehead (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialpricehead.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: specialpricebanner
	 * </p>
	 * <p>
	 * Description:banner特价
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/specialpricebanner.htm" })
	public ModelAndView specialpricebanner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialpricebanner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
			advertPositionCriteria.andApMarkEqualTo ("sale");// 特价的广告位
			advertPositionExample.setOrderByClause ("id desc");
			if (this.advertPositionService.getObjectList (advertPositionExample) != null && this.advertPositionService.getObjectList (advertPositionExample).size () != 0)
			{
				AdvertPositionWithBLOBs ap = this.advertPositionService.getObjectList (advertPositionExample).get (0);
				AdvertPositionWithBLOBs obj = new AdvertPositionWithBLOBs ();
				obj.setApType (ap.getApType ());
				obj.setApStatus (ap.getApStatus ());
				obj.setApShowType (ap.getApShowType ());
				obj.setApWidth (ap.getApWidth ());
				obj.setApHeight (ap.getApHeight ());
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (ap.getId ());
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				List <Advert> advs = new ArrayList <Advert> ();
				ap.getAdvs ().addAll (adverts);// 根据外键取出图片Id
				for (Advert temp_adv : ap.getAdvs ())
				{
					if ((temp_adv.getAdStatus () != 1) || (!temp_adv.getAdBeginTime ().before (new Date ())) || (!temp_adv.getAdEndTime ().after (new Date ())))
						continue;
					advs.add (temp_adv);
				}
				if (advs.size () > 0)
				{
					if (obj.getApType ().equals ("text"))
					{
						if (obj.getApShowType () == 0)
						{
							obj.setApText (((Advert) advs.get (0)).getAdText ());
							obj.setApAccUrl (((Advert) advs.get (0)).getAdUrl ());
							obj.setAdvId (CommUtil.null2String (((Advert) advs.get (0)).getId ()));
						}
						if (obj.getApShowType () == 1)
						{
							Random random = new Random ();
							int i = random.nextInt (advs.size ());
							obj.setApText (((Advert) advs.get (i)).getAdText ());
							obj.setApAccUrl (((Advert) advs.get (i)).getAdUrl ());
							obj.setAdvId (CommUtil.null2String (((Advert) advs.get (i)).getId ()));
						}
					}
					if (obj.getApType ().equals ("img"))
					{
						if (obj.getApShowType () == 0)
						{
							obj.setApAcc (((Advert) advs.get (0)).getAdAcc ());
							obj.setApAccUrl (((Advert) advs.get (0)).getAdUrl ());
							obj.setAdvId (CommUtil.null2String (((Advert) advs.get (0)).getId ()));
						}
						if (obj.getApShowType () == 1)
						{
							Random random = new Random ();
							int i = random.nextInt (advs.size ());
							obj.setApAcc (((Advert) advs.get (i)).getAdAcc ());
							obj.setApAccUrl (((Advert) advs.get (i)).getAdUrl ());
							obj.setAdvId (CommUtil.null2String (((Advert) advs.get (i)).getId ()));
						}
					}
					Iterator <Integer> localIterator2;
					if (obj.getApType ().equals ("slide"))
					{
						if (obj.getApShowType () == 0)
						{
							obj.getAdvs ().addAll (advs);
						}
						if (obj.getApShowType () == 1)
						{
							Set <Integer> list = CommUtil.randomInt (advs.size () , 8);
							for (localIterator2 = list.iterator () ; localIterator2.hasNext () ;)
							{
								int i = ((Integer) localIterator2.next ()).intValue ();
								obj.getAdvs ().add ((Advert) advs.get (i));
							}
						}
					}
					if (obj.getApType ().equals ("scroll"))
					{
						if (obj.getApShowType () == 0)
						{
							obj.getAdvs ().addAll (advs);
						}
						if (obj.getApShowType () == 1)
						{
							Set <Integer> list = CommUtil.randomInt (advs.size () , 12);
							for (localIterator2 = list.iterator () ; localIterator2.hasNext () ;)
							{
								int i = ((Integer) localIterator2.next ()).intValue ();
								obj.getAdvs ().add ((Advert) advs.get (i));
							}
						}
					}
				}
				else
				{
					obj.setApAcc (ap.getApAcc ());
					obj.setApText (ap.getApText ());
					obj.setApAccUrl (ap.getApAccUrl ());
					Advert adv = new Advert ();
					adv.setAdUrl (obj.getApAccUrl ());
					adv.setAdAcc (ap.getApAcc ());
					obj.getAdvs ().add (adv);
				}
				if (obj.getApStatus () == 1)
					mv.addObject ("obj" , obj);
				else
				{
					mv.addObject ("obj" , new AdvertPosition ());
				}
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: specialpricelist
	 * </p>
	 * <p>
	 * Description: 天天特价List
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/specialpricelist.htm" })
	public ModelAndView specialpricelist (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("specialpricelist.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setOrderByClause ("audit_time asc");
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setPageSize (2);
			BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
			bargainGoodsCriteria.andBgTimeEqualTo (CommUtil.formatString2Date (CommUtil.formatShortDate (new Date ()))).andBgEndTimeIsNull ();   // 查询当天
			bargainGoodsCriteria.andBgStatusEqualTo (1);// 查询审核通过的
			bargainGoodsCriteria.andMarkEqualTo (0);
//			String url = this.configService.getSysConfig ().getAddress ();
			String a = CommUtil.getURL (request);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView (a + "/specialpricelist.htm" , "" , "" , pList , mv);
			mv.addObject ("bargainSellerTools" , bargainSellerTools);// 特价工具类
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: specialpricetimelist
	 * </p>
	 * <p>
	 * Description: 限时特价List
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/specialpricetimelist.htm" })
	public ModelAndView specialpricetimelist (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("specialpricetimelist.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// BargainExample bargainExample=new BargainExample();
			// bargainExample.clear();
			// BargainExample.Criteria bargainCriteria=bargainExample.createCriteria();
			// List<Date> bargainTime=new ArrayList<Date>();
			// bargainExample.clear();
			// bargainCriteria=bargainExample.createCriteria();
			// bargainCriteria.andMarkEqualTo(1);
			// bargainCriteria.andBargainTimeLessThanOrEqualTo(new Date());//在当前时间之前开始的特价
			// bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo(new Date());//在当前时间之后还未结束的限时特价
			// List<Bargain> bargains=this.bargainService.getObjectList(bargainExample);
			// bargainTime=new ArrayList<Date>();
			// List<Date> bargainEndTime=new ArrayList<Date>();
			// for(Bargain bargain:bargains)
			// {
			// bargainTime.add(bargain.getBargainTime());
			// bargainEndTime.add(bargain.getBargainEndTime());
			// }
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setOrderByClause ("audit_time asc");
			BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setPageSize (6);
			bargainGoodsCriteria.andBargainGoodsStatusEqualTo ("1").andBgTimeLessThanOrEqualTo (new Date ()).andBgEndTimeGreaterThanOrEqualTo (new Date ());
			/*
			 * if(bargainTime.size()>0)
			 * {
			 * bargainGoodsCriteria.andBgTimeIn(bargainTime);
			 * }else{
			 * bargainGoodsCriteria.andBgTimeIsNull();
			 * }
			 * if(bargainEndTime.size()>0)
			 * {
			 * bargainGoodsCriteria.andBgEndTimeIn(bargainEndTime);
			 * }else{
			 * bargainGoodsCriteria.andBgEndTimeIsNull();
			 * }
			 */
			bargainGoodsCriteria.andBgStatusEqualTo (1);
			bargainGoodsCriteria.andMarkEqualTo (1);
//			String url = this.configService.getSysConfig ().getAddress ();
			String a = CommUtil.getURL (request);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView (a + "/specialpricetimelist.htm" , "" , "" , pList , mv);
			mv.addObject ("bargainSellerTools" , bargainSellerTools);// 特价工具类
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: specialpricezhekoulist
	 * </p>
	 * <p>
	 * Description: 折扣特价List
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/specialpricezhekoulist.htm" })
	public ModelAndView specialpricezhekoulist (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("specialpricezhekoulist.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/*
			 * BargainExample bargainExample=new BargainExample();
			 * bargainExample.clear();
			 * BargainExample.Criteria bargainCriteria=bargainExample.createCriteria();
			 * bargainExample.clear();
			 * bargainCriteria=bargainExample.createCriteria();
			 * bargainCriteria.andMarkEqualTo(2);
			 * bargainCriteria.andBargainTimeLessThanOrEqualTo(new Date());//在当前时间之前开始的特价
			 * bargainCriteria.andBargainEndTimeGreaterThanOrEqualTo(new Date());//在当前时间之后还未结束的折扣特卖
			 * List<Bargain> bargains = this.bargainService.getObjectList(bargainExample);
			 * List<Date> bargainTime=new ArrayList<Date>();
			 * List<Date> bargainEndTime=new ArrayList<Date>();
			 * for(Bargain bargain:bargains)
			 * {
			 * bargainTime.add(bargain.getBargainTime());
			 * bargainEndTime.add(bargain.getBargainEndTime());
			 * }
			 */
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setOrderByClause ("audit_time asc");
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setPageSize (8);
			BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
			bargainGoodsCriteria.andBargainGoodsStatusEqualTo ("1").andBgTimeLessThanOrEqualTo (new Date ()).andBgEndTimeGreaterThanOrEqualTo (new Date ());
			/*
			 * if(bargainTime.size()>0)
			 * {
			 * bargainGoodsCriteria.andBgTimeIn(bargainTime);
			 * }else{
			 * bargainGoodsCriteria.andBgTimeIsNull();
			 * }
			 * if(bargainEndTime.size()>0)
			 * {
			 * bargainGoodsCriteria.andBgEndTimeIn(bargainEndTime);
			 * }else{
			 * bargainGoodsCriteria.andBgEndTimeIsNull();
			 * }
			 */
			bargainGoodsCriteria.andBgStatusEqualTo (1);
			bargainGoodsCriteria.andMarkEqualTo (2);
//			String url = this.configService.getSysConfig ().getAddress ();
			String a = CommUtil.getURL (request);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView (a + "/specialpricezhekoulist.htm" , "" , "" , pList , mv);
			mv.addObject ("bargainSellerTools" , bargainSellerTools);// 特价工具类
			return mv;
		}

	@RequestMapping({ "/specialprice.htm" })
	public ModelAndView specialprice (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialprice.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
