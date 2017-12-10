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
 * Description: 后台折扣特价活动 管理
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
public class BargainDiscountManageAction
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

	/**
	 * 折扣特价列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@RequestMapping({ "/admin/bargain_discount_list.htm" })
	public ModelAndView bargain_discount_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_discount_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			bargainExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainExample.setOrderByClause ("bargain_time desc");
			bargainExample.createCriteria ().andMarkEqualTo (Integer.valueOf (2));
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

	@SecurityMapping(title = "折扣特价商品列表" , value = "/admin/bargain_discount_goods_list.htm*" , rtype = "admin" ,
						rname = "天天特价" , rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_goods_list.htm" })
	public ModelAndView bargain_discount_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goods_name , String bg_status , String bargain_time , String bargain_end_time , String mark)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_discount_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
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
			// bargainGoodsCriteria.andBgTimeEqualTo(CommUtil.formatDate(bargain_time))
			// //设置特价商品的开始和结束 时间查询条件
			// .andBgEndTimeEqualTo(CommUtil.formatDate(bargain_end_time));
			bargainGoodsCriteria.andBgTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargain_time , "yyyy-MM-dd HH:mm:ss")).andBgEndTimeLessThanOrEqualTo (CommUtil.formatDate (bargain_end_time , "yyyy-MM-dd HH:mm:ss"));
			bargainGoodsCriteria.andMarkEqualTo (2);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			/*
			 * bargainExample.createCriteria().andBargainTimeEqualTo(CommUtil.formatDate(bargain_time
			 * ))
			 * .andBargainEndTimeEqualTo(CommUtil.formatDate(bargain_end_time)).andMarkEqualTo(2);
			 */
			bargainExample.createCriteria ().andMarkEqualTo (2);
			List <Bargain> bargains = bargainService.getObjectList (bargainExample);
			mv.addObject ("bg_status" , bg_status);
			mv.addObject ("goods_name" , goods_name);
			mv.addObject ("bargainTime" , bargain_time);
			mv.addObject ("bargainEndTime" , bargain_end_time);
			mv.addObject ("bargains" , bargains);
			mv.addObject ("mark" , mark);
			return mv;
		}

	@SecurityMapping(title = "折扣特价商品通过" , value = "/admin/bargain_discount_goods_audit.htm*" , rtype = "admin" ,
						rname = "天天特价" , rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_goods_audit.htm" })
	public String bargain_discount_goods_audit (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage , String bargain_time , String bargain_end_time , String mark)
		{
			String uri = "";
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
					bargainGoodsExample.clear ();
					bargainGoodsExample.createCriteria ().andBgTimeEqualTo (CommUtil.formatDate (bargain_time)).andBgEndTimeEqualTo (CommUtil.formatDate (bargain_end_time));
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
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time)).andBargainEndTimeEqualTo (CommUtil.formatDate (bargain_end_time)).andMarkEqualTo (CommUtil.null2Int (mark));
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
						uri = "redirect:bargain_discount_audits_out.htm";
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
						uri = "redirect:bargain_discount_goods_list.htm?bargain_time=" + bargain_time + "&bargain_end_time=" + bargain_end_time + "&currentPage=" + currentPage + "&mark=" + mark;
					}
				}
			}
			return uri;
		}

	@SecurityMapping(title = "折扣特价拒绝" , value = "/admin/bargain_goods_refuse.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_goods_refuse.htm" })
	public String bargain_goods_refuse (HttpServletRequest request , HttpServletResponse response , String bargain_time , String bargain_end_time , String mulitId , String currentPage , String mark)
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
			return "redirect:bargain_discount_goods_list.htm?bargain_time=" + bargain_time + "&bargain_end_time=" + bargain_end_time + "&currentPage=" + currentPage + "&mark=" + mark;
		}

	@SecurityMapping(title = "折扣特价商品审核数超出" , value = "/admin/bargain_discount_audits_out.htm*" , rtype = "admin" ,
						rname = "限时特价" , rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_audits_out.htm" })
	public ModelAndView bargain_time_audits_out (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_discount_list.htm");
			mv.addObject ("op_tip" , "审核商品数已超出特价商品的最多数");
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: bargain_discount_add
	 * </p>
	 * <p>
	 * Description:折扣特卖添加
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/admin/bargain_discount_add.htm" })
	public ModelAndView bargain_discount_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/bargain_discount_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			bargainExample.createCriteria ().andMarkEqualTo (2);
			List <Bargain> bargains = bargainService.getObjectList (bargainExample);
			mv.addObject ("bargains" , bargains);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: bargain_discount_save
	 * </p>
	 * <p>
	 * Description: 折扣特卖保存
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @param bargainTime
	 * @return
	 */
	@RequestMapping({ "/admin/bargain_discount_save.htm" })
	public ModelAndView bargain_discount_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String bargainTime , String bargainEndTime)
		{
			// 申请日期包含在大日期范围内的情况
			BargainExample bargainExample1 = new BargainExample ();
			bargainExample1.clear ();
			bargainExample1.createCriteria ().andBargainTimeLessThanOrEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss")).andBargainEndTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss")).andMarkEqualTo (Integer.valueOf (2)).andBargainStatusEqualTo ("1");
			List <Bargain> bargains1 = this.bargainService.getObjectList (bargainExample1);
			// 申请日期的终止时间小于最大时间，但是起始时间大于最小日期的情况
			BargainExample bargainExample2 = new BargainExample ();
			bargainExample2.clear ();
			bargainExample2.createCriteria ().andBargainTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss")).andBargainTimeLessThanOrEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss")).andBargainEndTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss")).andMarkEqualTo (Integer.valueOf (2)).andBargainStatusEqualTo ("1");
			List <Bargain> bargains2 = this.bargainService.getObjectList (bargainExample2);
			// 申请日期的起始时间大于最小日期，但是终止时间大于最大时间的情况
			BargainExample bargainExample3 = new BargainExample ();
			bargainExample3.clear ();
			bargainExample3.createCriteria ().andBargainTimeLessThanOrEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss")).andBargainEndTimeGreaterThanOrEqualTo (CommUtil.formatDate (bargainTime , "yyyy-MM-dd HH:mm:ss")).andBargainEndTimeLessThanOrEqualTo (CommUtil.formatDate (bargainEndTime , "yyyy-MM-dd HH:mm:ss")).andMarkEqualTo (Integer.valueOf (2)).andBargainStatusEqualTo ("1");
			List <Bargain> bargains3 = this.bargainService.getObjectList (bargainExample3);
			String list_url = CommUtil.getURL (request) + "/admin/bargain_discount_list.htm";
			String add_url = CommUtil.getURL (request) + "/admin/bargain_discount_add.htm";
			if (bargains1.size () > 0 || bargains2.size () > 0 || bargains3.size () > 0)
			{
				ModelAndView mv = new JModelAndView ("admin/fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("list_url" , list_url);
				if (bargains2.size () > 0 || bargains3.size () > 0)
				{
					mv.addObject ("op_title" , "申请日期范围与现有活动日期有交叉,保存失败");
				}
				else
				{
					mv.addObject ("op_title" , "申请日期范围已存在,保存失败");
				}
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
			}
			else
			{
				Bargain obj = this.bargainService.getByKey (Long.valueOf (Long.parseLong (id)));
				bargain = (Bargain) wf.toPo (request , obj);
			}
			bargain.setMark (2);// 折扣特卖
			if (id.equals (""))
				this.bargainService.add (bargain);
			else
				this.bargainService.updateByObject (bargain);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "折扣特价添加成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "折扣特价状态修改" , value = "/admin/bargain_discount_status_save.htm*" , rtype = "admin" ,
						rname = "折扣特价" , rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_status_save.htm" })
	public ModelAndView bargain_time_status_save (HttpServletRequest request , HttpServletResponse response , String id , String bargainStatus)
		{
			ModelAndView mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			Bargain bargain = null;
			if (!"".equals (id))
			{
				bargain = this.bargainService.getByKey (Long.valueOf (id));
				bargain.setBargainStatus (bargainStatus);
				if ("0".equals (bargainStatus))
				{
					bargain.setCloseTime (new Date ());
				}
				else
				{
					bargain.setCloseTime (null);
				}
				this.bargainService.updateByObject (bargain);
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_discount_list.htm");
				mv.addObject ("op_tip" , "修改成功");
			}
			else
			{
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_discount_list.htm");
				mv.addObject ("op_tip" , "修改失败");
			}
			return mv;
		}

	@SecurityMapping(title = "折扣特价删除" , value = "/admin/bargain_discount_del.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_del.htm" })
	public ModelAndView bargain_discount_del (HttpServletRequest request , HttpServletResponse response , String bargain_time , String bargain_end_time , String mark)
		{
			ModelAndView mv = new JModelAndView ("admin/tip.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.createCriteria ().andBgTimeEqualTo (CommUtil.formatDate (bargain_time));
			List <BargainGoods> bargainGoods = bargainGoodsService.getObjectList (bargainGoodsExample);
			if (bargainGoods.size () > 0)
			{
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_discount_list.htm");
				mv.addObject ("op_tip" , "已有商品申请该特价活动不可删除");
			}
			else
			{
				BargainExample bargainExample = new BargainExample ();
				bargainExample.clear ();
				if (null != mark && !mark.equals (""))
				{// 如果传过来Mark标识
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time)).andBargainEndTimeEqualTo (CommUtil.formatDate (bargain_end_time)).andMarkEqualTo (CommUtil.null2Int (mark));
				}
				else
				{// 如果没有传过来
					bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time));
				}
				List <Bargain> bargains = bargainService.getObjectList (bargainExample);
				if (null != bargains && bargains.size () > 0)
					this.bargainService.deleteByKey (((Bargain) bargains.get (0)).getId ());
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/bargain_discount_list.htm");
				mv.addObject ("op_tip" , "删除成功");
			}
			return mv;
		}

	@SecurityMapping(title = "折扣特价ajax更新" , value = "/admin/bargain_time_ajax.htm*" , rtype = "admin" , rname = "天天特价" ,
						rcode = "bargain_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/bargain_discount_ajax.htm" })
	public void bargain_discount_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
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
}
