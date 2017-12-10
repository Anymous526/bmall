package com.amall.core.action.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsFloorTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class NewGoodsAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsFloorService goodsFloorService;

	@Autowired
	private GoodsFloorTools gf_tools;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@RequestMapping({ "/new.htm" })
	public ModelAndView banner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("new.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/new_goods_floor.htm" })
	public ModelAndView floor (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("new_goods_floor.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfDisplayEqualTo (Boolean.valueOf (true)).andParentIdIsNull ().andGfMarkEqualTo ("newGoods").andGfLevelEqualTo (Integer.valueOf (0));
			goodsFloorExample.setOrderByClause ("gf_sequence asc");
			List <GoodsFloorWithBLOBs> floors = this.goodsFloorService.getObjectList (goodsFloorExample);
			for (int i = 0 ; i < floors.size () ; i++)
			{
				floors.get (i).setChilds (this.goodsFloorService.selectChildsByInnerJoin (floors.get (i).getId ()));
			}
			mv.addObject ("floors" , floors);
			mv.addObject ("gf_tools" , this.gf_tools);
			mv.addObject ("url" , CommUtil.getURL (request));
			// 广告
			AdvertExample advertExample = new AdvertExample ();
			advertExample.clear ();
			advertExample.setOrderByClause (" addTime desc ");
			advertExample.setPageSize (4);
			advertExample.createCriteria ().andAdBeginTimeLessThanOrEqualTo (new Date ()).andAdEndTimeGreaterThanOrEqualTo (new Date ()).andAdStatusEqualTo (Integer.valueOf (1));
			List <Advert> adverts = this.advertService.getObjectList (advertExample);
			mv.addObject ("ads" , adverts);
			/**
			 * 重点推荐。广告位
			 */
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			AdvertPositionExample.Criteria advertCriteria = advertPositionExample.createCriteria ();
			advertCriteria.andApMarkEqualTo ("new2");// 广告位，广告位置新品位置2
			advertPositionExample.setOrderByClause ("id desc");
			if (this.advertPositionService.getObjectList (advertPositionExample) != null && this.advertPositionService.getObjectList (advertPositionExample).size () != 0)
			{
				AdvertPositionWithBLOBs obj1 = this.advertPositionService.getObjectList (advertPositionExample).get (0);
				AdvertExample advertExample2 = new AdvertExample ();
				advertExample2.clear ();
				advertExample2.setOrderByClause ("addTime desc");
				AdvertExample.Criteria advertCriteria2 = advertExample2.createCriteria ();
				advertCriteria2.andAdApIdEqualTo (obj1.getId ());
				List <Advert> adverts2 = this.advertService.getObjectList (advertExample2);
				List <Advert> advs = new ArrayList <Advert> ();
				for (Advert temp_adv : adverts2)
				{
					if ((temp_adv.getAdStatus () != 1) || (!temp_adv.getAdBeginTime ().before (new Date ())) || (!temp_adv.getAdEndTime ().after (new Date ())))
						continue;
					advs.add (temp_adv);
				}
				if (advs.size () < 4)
				{
					obj1.getAdvs ().addAll (advs);
				}
				else
				{
					List <Advert> advs2 = new ArrayList <Advert> ();
					for (int i = 0 ; i < 4 ; i++)
					{
						advs2.add (advs.get (i));
					}
					obj1.getAdvs ().addAll (advs2);
				}
				mv.addObject ("obj1" , obj1);// 展示的广告位,重点推荐
			}
			return mv;
		}
}
