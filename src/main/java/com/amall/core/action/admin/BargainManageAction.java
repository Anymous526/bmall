package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.INavigationService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.BargainManageTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * Title: BargainManageAction
 * </p>
 * <p>
 * Description: 后台天天特价活动 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月24日下午6:34:41
 * @version 1.0
 */
@Controller
public class BargainManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private INavigationService navigationService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private BargainManageTools bargainManageTools;

	@SecurityMapping(title = "天天特价列表" , value = "/admin/bargain_list.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_list.htm" })
	public ModelAndView bargain_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			bargainExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainExample.setOrderByClause ("bargain_time desc");
			bargainExample.createCriteria ().andMarkEqualTo (Integer.valueOf (0));
			Pagination pList = bargainService.getObjectListWithPage (bargainExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , i + 1);
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			mv.addObject ("bargainManageTools" , this.bargainManageTools);
			return mv;
		}

	@SecurityMapping(title = "天天特价添加" , value = "/admin/bargain_add.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_add.htm" })
	public ModelAndView bargain_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , i + 1);
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "天天特价保存" , value = "/admin/bargain_save.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_save.htm" })
	public ModelAndView bargain_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String bargainTime)
		{
			BargainExample bargainExample = new BargainExample ();
			bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargainTime)).andMarkEqualTo (Integer.valueOf (0));
			List <Bargain> bargains = this.bargainService.getObjectList (bargainExample);
			String list_url = CommUtil.getURL (request) + "/admin/bargain_list.htm";
			String add_url = CommUtil.getURL (request) + "/admin/bargain_add.htm";
			if (bargains.size () > 0)
			{
				ModelAndView mv = new JModelAndView ("admin/fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("list_url" , list_url);
				mv.addObject ("op_title" , "申请日期已存在,保存失败");
				if (add_url != null)
				{
					mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
				}
				return mv;
			}
			WebForm wf = new WebForm ();
			Bargain bargain = null;
			if (id.equals (""))
			{
				bargain = (Bargain) wf.toPo (request , Bargain.class);
				bargain.setAddtime (new Date ());
				bargain.setBargainTime (CommUtil.formatDate (bargainTime));
			}
			else
			{
				Bargain obj = this.bargainService.getByKey (Long.valueOf (Long.parseLong (id)));
				bargain = (Bargain) wf.toPo (request , obj);
			}
			bargain.setMark (0);// 天天特价
			if (id.equals (""))
				this.bargainService.add (bargain);
			else
				this.bargainService.updateByObject (bargain);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "天天特价添加成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "天天特价删除" , value = "/admin/bargain_del.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_del.htm" })
	public ModelAndView bargain_del (HttpServletRequest request , HttpServletResponse response , String bargain_time , String mark)
		{
			ModelAndView mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.createCriteria ().andBgTimeEqualTo (CommUtil.formatDate (bargain_time));
			List <BargainGoods> bargainGoods = bargainGoodsService.getObjectList (bargainGoodsExample);
			if (bargainGoods.size () > 0)
			{
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_list.htm");
				mv.addObject ("op_tip" , "已有商品申请今日特价不可删除");
			}
			else
			{
				BargainExample bargainExample = new BargainExample ();
				bargainExample.clear ();
				if (null != mark && !mark.equals (""))
				{// 如果传过来Mark标识
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time)).andMarkEqualTo (CommUtil.null2Int (mark));
				}
				else
				{// 如果没有传过来
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time));
				}
				List <Bargain> bargains = bargainService.getObjectList (bargainExample);
				if (null != bargains && bargains.size () > 0)
					this.bargainService.deleteByKey (((Bargain) bargains.get (0)).getId ());
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_list.htm");
				mv.addObject ("op_tip" , "删除成功已恢复通用设置");
			}
			return mv;
		}

	@SecurityMapping(title = "天天今日特价ajax更新" , value = "/admin/bargain_ajax.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_ajax.htm" })
	public void bargain_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			Bargain obj = this.bargainService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = Bargain.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			Object val = null;
			for (Field field : fields)
			{
				if (field.getName ().equals (fieldName))
				{
					Class <?> clz = Class.forName ("java.lang.String");
					if (field.getType ().getName ().equals ("int"))
					{
						clz = Class.forName ("java.lang.Integer");
					}
					if (field.getType ().getName ().equals ("boolean"))
					{
						clz = Class.forName ("java.lang.Boolean");
					}
					if (!value.equals (""))
						val = BeanUtils.convertType (value , clz);
					else
					{
						val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
					}
					wrapper.setPropertyValue (fieldName , val);
				}
			}
			this.bargainService.updateByObject (obj);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (val.toString ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "天天特价通用设置" , value = "/admin/set_bargain.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_bargain.htm" })
	public ModelAndView set_bargain (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/set_bargain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , i + 1);
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			return mv;
		}

	@SecurityMapping(title = "时间查询设置" , value = "/admin/date_query_set.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/date_query_set.htm" })
	public ModelAndView date_query_set (HttpServletRequest request , HttpServletResponse response , String count , String date)
		{
			ModelAndView mv = new JModelAndView ("admin/date_query_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.setTime (CommUtil.formatDate (date));
				cal.add (6 , i + 1 + CommUtil.null2Int (count));
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			return mv;
		}

	@SecurityMapping(title = "特价通用设置保存" , value = "/admin/set_bargain_save.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/set_bargain_save.htm" })
	public ModelAndView set_bargain_save (HttpServletRequest request , HttpServletResponse response , String id , String op_title , String list_url)
		{
			SysConfigWithBLOBs obj = this.configService.getSysConfig ();
			WebForm wf = new WebForm ();
			SysConfigWithBLOBs sysConfig = null;
			if (id.equals (""))
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , SysConfigWithBLOBs.class);
				sysConfig.setAddtime (new Date ());
			}
			else
			{
				sysConfig = (SysConfigWithBLOBs) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.configService.add (sysConfig);
			else
			{
				this.configService.updateByObject (sysConfig);
			}
			if (sysConfig.getBargainStatus () == 1)
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.clear ();
				navigationExample.createCriteria ().andUrlEqualTo ("bargain.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				if (navs.size () == 0)
				{
					Navigation nav = new Navigation ();
					nav.setAddtime (new Date ());
					nav.setDisplay (true);
					nav.setLocation (0);
					nav.setNewWin (1);
					nav.setSequence (5);
					nav.setSysnav (true);
					nav.setTitle ("天天特价");
					nav.setType ("diy");
					nav.setUrl ("bargain.htm");
					nav.setOriginalUrl ("bargain.htm");
					this.navigationService.add (nav);
				}
			}
			else
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.createCriteria ().andUrlEqualTo ("bargain.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				for (Navigation nav : navs)
				{
					this.navigationService.deleteByKey (nav.getId ());
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , op_title);
			mv.addObject ("list_url" , list_url);
			return mv;
		}

	@SecurityMapping(title = "天天特价商品列表" , value = "/admin/bargain_goods_list.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_goods_list.htm" })
	public ModelAndView bargain_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goods_name , String bg_status , String bargain_time , String mark)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			BargainGoodsExample.Criteria bargainGoodsCriteria = bargainGoodsExample.createCriteria ();
			if (!CommUtil.null2String (bg_status).equals (""))
			{
				bargainGoodsCriteria.andBgStatusEqualTo (Integer.valueOf (CommUtil.null2Int (bg_status)));
			}
			if (!CommUtil.null2String (goods_name).equals (""))
			{
				GoodsExample goodsExample = new GoodsExample ();
				goodsExample.clear ();
				goodsExample.createCriteria ().andGoodsNameLike ("%" + goods_name.trim () + "%");
				List <GoodsWithBLOBs> goodsList = goodsService.getObjectList (goodsExample);
				List <Long> goodsIds = new ArrayList <Long> ();
				for (GoodsWithBLOBs goodsWithBLOBs : goodsList)
				{
					goodsIds.add (goodsWithBLOBs.getId ());
				}
				if (goodsIds != null && goodsIds.size () > 0)
				{
					bargainGoodsCriteria.andBgGoodsIdIn (goodsIds);
				}
				else
				{
					bargainGoodsCriteria.andBgGoodsIdIsNull ();
				}
			}
			bargainGoodsCriteria.andBgTimeEqualTo (CommUtil.formatDate (bargain_time));
			bargainGoodsCriteria.andMarkEqualTo (0);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("bg_status" , bg_status);
			mv.addObject ("goods_name" , goods_name);
			mv.addObject ("bargain_time" , bargain_time);
			mv.addObject ("mark" , mark);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , i + 1);
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			return mv;
		}

	@SecurityMapping(title = "天天特价商品通过" , value = "/admin/bargain_goods_audit.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_goods_audit.htm" })
	public String bargain_goods_audit (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage , String bargain_time , String mark)
		{
			String uri = "";
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
					bargainGoodsExample.clear ();
					bargainGoodsExample.createCriteria ().andBgTimeEqualTo (CommUtil.formatDate (bargain_time));
					List <BargainGoods> bargainGoods = bargainGoodsService.getObjectList (bargainGoodsExample);
					int audits = 1;
					for (BargainGoods bgs : bargainGoods)
					{
						if (bgs.getBgStatus () == 1)
						{
							audits++;
						}
					}
					BargainExample bargainExample = new BargainExample ();
					bargainExample.clear ();
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time)).andMarkEqualTo (CommUtil.null2Int (mark));
					List <Bargain> bargains = bargainService.getObjectList (bargainExample);
					int set_audits = 0;
					if (bargains.size () > 0)
						set_audits = ((Bargain) bargains.get (0)).getMaximum ();
					else
					{
						set_audits = this.configService.getSysConfig ().getBargainMaximum ();
					}
					if (audits > set_audits)
					{
						uri = "redirect:bargain_audits_out.htm";
					}
					else
					{
						BargainGoods bg = this.bargainGoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
						bg.setBgStatus (1);
						bg.setBgAdminUser (SecurityUserHolder.getCurrentUser ());
						bg.setAuditTime (new Date ());
						this.bargainGoodsService.updateByObject (bg);
						GoodsWithBLOBs goods = bg.getBgGoods ();
						goods.setBargainStatus (2);
						goods.setGoodsCurrentPrice (bg.getBgPrice ());
						this.goodsService.updateByObject (goods);
						uri = "redirect:bargain_goods_list.htm?bargain_time=" + bargain_time + "&currentPage=" + currentPage + "&mark=" + mark;
					}
				}
			}
			return uri;
		}

	@SecurityMapping(title = "天天特价商品审核数超出" , value = "/admin/bargain_audits_out.htm*" , rtype = "admin" ,
						rname = "天天特价" , rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_audits_out.htm" })
	public ModelAndView bargain_audits_out (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_list.htm");
			mv.addObject ("op_tip" , "审核商品数已超出特价商品的最多数");
			return mv;
		}

	@SecurityMapping(title = "天天特价拒绝" , value = "/admin/bargain_goods_refuse.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_goods_refuse.htm" })
	public String bargain_goods_refuse (HttpServletRequest request , HttpServletResponse response , String bargain_time , String mulitId , String currentPage , String mark)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					BargainGoods bg = this.bargainGoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					bg.setBgStatus (-1);
					this.bargainGoodsService.updateByObject (bg);
					GoodsWithBLOBs goods = bg.getBgGoods ();
					goods.setBargainStatus (0);
					goods.setGoodsCurrentPrice (goods.getStorePrice ());
					this.goodsService.updateByObject (goods);
				}
			}
			return "redirect:bargain_goods_list.htm?bargain_time=" + bargain_time + "&currentPage=" + currentPage + "&mark=" + mark;
		}
}
