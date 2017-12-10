package com.amall.core.action.view;

import java.io.IOException;
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
import com.amall.common.constant.Globals;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 各功能页轮播图广告设置
 * 
 * @author ljx
 *
 */
@Controller
public class AdvertViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IAdvertService advertService;

	@RequestMapping({ "/advert_invoke.htm" })
	public ModelAndView advert_invoke (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("advert_invoke2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				AdvertPositionWithBLOBs ap = this.advertPositionService.getByKey (CommUtil.null2Long (id));
				if (ap != null)
				{
					AdvertPositionWithBLOBs obj = new AdvertPositionWithBLOBs ();
					obj.setApType (ap.getApType ());
					obj.setApStatus (ap.getApStatus ());
					obj.setApShowType (ap.getApShowType ());
					obj.setApWidth (ap.getApWidth ());
					obj.setApHeight (ap.getApHeight ());
					List <Advert> advs = new ArrayList <Advert> ();
					AdvertExample advertExample = new AdvertExample ();
					advertExample.clear ();
					AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
					advertCriteria.andAdApIdEqualTo (ap.getId ());
					List <Advert> adverts = this.advertService.getObjectList (advertExample);
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
						Iterator localIterator2;
						if (obj.getApType ().equals ("slide"))
						{
							if (obj.getApShowType () == 0)
							{
								obj.getAdvs ().addAll (advs);
							}
							if (obj.getApShowType () == 1)
							{
								Random random = new Random ();
								Set list = CommUtil.randomInt (advs.size () , 8);
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
								Random random = new Random ();
								Set list = CommUtil.randomInt (advs.size () , 12);
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
			}
			return mv;
		}

	@RequestMapping({ "/advert_redirect.htm" })
	public void advert_redirect (HttpServletRequest request , HttpServletResponse response , String id)
		{
			try
			{
				Advert adv = this.advertService.getByKey (CommUtil.null2Long (id));
				if (adv != null)
				{
					adv.setAdClickNum (adv.getAdClickNum () + 1);
					this.advertService.updateByObject (adv);
				}
				if (adv != null)
				{
					String url = adv.getAdUrl ();
					response.sendRedirect (url);
				}
				else
				{
					response.sendRedirect (CommUtil.getURL (request));
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/banner.htm" })
	public ModelAndView banner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("banner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			/**
			 * 首页的Banner广告
			 */
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
			advertPositionCriteria.andApMarkEqualTo ("index1");// 首页位置一的广告位
			advertPositionExample.setOrderByClause ("addTime asc");
			List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
			if (advertPositions != null && advertPositions.size () != 0)
			{
				AdvertPositionWithBLOBs advertPosition = advertPositions.get (0);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
				advertCriteria.andAdApIdEqualTo (advertPosition.getId ());
				// 审核通过的
				advertCriteria.andAdStatusEqualTo (Globals.NUBER_ONE);
				advertExample.setOrderByClause ("ad_slide_sequence asc");
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				if (adverts != null && adverts.size () != 0)
				{
					if (adverts.size () > 8)// 如果广告图片超过了8张，则只显示8张
					{
						List <Advert> adverts2 = new ArrayList <Advert> ();
						for (int i = 0 ; i < 8 ; i++)
						{
							Advert advert = adverts.get (i);
							adverts2.add (advert);
						}
						advertPosition.getAdvs ().addAll (adverts2);
					}
					else
					{// 广告图片少于8张
						advertPosition.getAdvs ().addAll (adverts);
					}
					mv.addObject ("mvert" , advertPosition.getAdvs ().get (0));// 保存第一张广告,样式特殊
					mv.addObject ("obj" , advertPosition);
				}
			}
			return mv;
		}

	@RequestMapping({ "/banner1.htm" })
	public ModelAndView banner1 (HttpServletRequest request , HttpServletResponse response , String type)
		{// op_type表示的是从哪个页面包含进来
			ModelAndView mv = new JModelAndView ("banner1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			type = CommUtil.null2String (request.getAttribute ("type"));
			if (type != null && type != "")// 如果有包含进来的方法
			{
				AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
				if (type.equals ("new"))
				{
					advertPositionExample.clear ();
					AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
					advertPositionCriteria.andApMarkEqualTo ("new1");// 新品广告位
					advertPositionExample.setOrderByClause ("addTime asc");
					List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
					if (advertPositions != null && advertPositions.size () != 0)
					{
						AdvertPositionWithBLOBs advertPosition = advertPositions.get (0);
						AdvertExample advertExample = new AdvertExample ();
						advertExample.clear ();
						AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
						advertCriteria.andAdApIdEqualTo (advertPosition.getId ());
						// 只显示有效期内的新品广告
						advertCriteria.andAdBeginTimeLessThanOrEqualTo (new Date ());
						advertCriteria.andAdEndTimeGreaterThanOrEqualTo (new Date ());
						advertExample.setOrderByClause ("ad_slide_sequence asc");
						List <Advert> adverts = this.advertService.getObjectList (advertExample);
						if (adverts != null && adverts.size () != 0)
						{
							if (adverts.size () > 8)// 如果广告图片超过了8张，则只显示8张
							{
								List <Advert> adverts2 = new ArrayList <Advert> ();
								for (int i = 0 ; i < 8 ; i++)
								{
									Advert advert = adverts.get (i);
									adverts2.add (advert);
								}
								advertPosition.getAdvs ().addAll (adverts2);
							}
							else
							{// 广告图片少于8张
								advertPosition.getAdvs ().addAll (adverts);
							}
							mv.addObject ("mvert" , advertPosition.getAdvs ().get (0));// 保存第一张广告,样式特殊
							mv.addObject ("obj" , advertPosition);
						}
					}
				}
				else if (type.equals ("customize"))
				{
					advertPositionExample.clear ();
					AdvertPositionExample.Criteria advertPositionCriteria = advertPositionExample.createCriteria ();
					// 启用该广告位的
					advertPositionCriteria.andApStatusEqualTo (Globals.NUBER_ONE);
					advertPositionCriteria.andApMarkEqualTo ("customize");// 定制广告位
					advertPositionExample.setOrderByClause ("id asc");
					List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
					if (advertPositions != null && advertPositions.size () != 0)
					{
						AdvertPositionWithBLOBs advertPosition = advertPositions.get (0);
						AdvertExample advertExample = new AdvertExample ();
						advertExample.clear ();
						AdvertExample.Criteria advertCriteria = advertExample.createCriteria ();
						advertCriteria.andAdApIdEqualTo (advertPosition.getId ());
						advertExample.setOrderByClause ("ad_slide_sequence asc");
						List <Advert> adverts = this.advertService.getObjectList (advertExample);
						if (adverts != null && adverts.size () != 0)
						{
							if (adverts.size () > 8)// 如果广告图片超过了8张，则只显示8张
							{
								List <Advert> adverts2 = new ArrayList <Advert> ();
								for (int i = 0 ; i < 8 ; i++)
								{
									Advert advert = adverts.get (i);
									adverts2.add (advert);
								}
								advertPosition.getAdvs ().addAll (adverts2);
							}
							else
							{// 广告图片少于8张
								advertPosition.getAdvs ().addAll (adverts);
							}
							mv.addObject ("mvert" , advertPosition.getAdvs ().get (0));// 保存第一张广告,样式特殊
							mv.addObject ("obj" , advertPosition);
						}
					}
				}
			}
			return mv;
		}
}
