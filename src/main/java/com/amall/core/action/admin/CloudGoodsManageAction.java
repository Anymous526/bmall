package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.CloudBuyCodes;
import com.amall.core.bean.CloudBuyerDetailExample;
import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudCodesExample;
import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import com.amall.core.bean.CloudGoodsExample;
import com.amall.core.bean.CloudGoodsExample.Criteria;
import com.amall.core.bean.CloudGoodsOrder;
import com.amall.core.bean.CloudGoodsOrderExample;
import com.amall.core.bean.CloudOnlineExample;
import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsExample;
import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IExpressCompanyService;
import com.amall.core.service.cloud.ICloudBuyCodesService;
import com.amall.core.service.cloud.ICloudBuyerDetailService;
import com.amall.core.service.cloud.ICloudCodesService;
import com.amall.core.service.cloud.ICloudGoodsAutoService;
import com.amall.core.service.cloud.ICloudGoodsOrderService;
import com.amall.core.service.cloud.ICloudGoodsService;
import com.amall.core.service.cloud.ICloudOnlineService;
import com.amall.core.service.cloud.ICloudStatisticsAutoService;
import com.amall.core.service.cloud.ICloudStatisticsService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.express.kuaidi100.JsonRequest;
import com.amall.core.web.express.kuaidi100.JsonResponse;
import com.amall.core.web.express.kuaidi100.Kuaidi100HttpRequest;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: IntegralGoodsManageAction
 * </p>
 * <p>
 * Description: 积分兑换
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年7月9日下午7:58:50
 * @version 1.0
 */
@Controller
public class CloudGoodsManageAction
{
	
	private static Logger  logger=Logger.getLogger (CloudGoodsManageAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IExpressCompanyService expressCompanyService;

	@Autowired
	private ICloudGoodsService cloudGoodsService;

	@Autowired
	private ICloudStatisticsService cloudStatisticsService;

	@Autowired
	private ICloudCodesService cloudCodesService;

	@Autowired
	private ICloudOnlineService cloudOnlineService;

	@Autowired
	private ICloudGoodsOrderService cloudGoodsOrderService;

	@Autowired
	private IExpressCompanyService expressCompayService;

	@Autowired
	private IKuaidiService kuaidiService;

	@Autowired
	private ICloudBuyCodesService cloudBuyCodesService;

	@Autowired
	private ICloudBuyerDetailService cloudBuyerDetailService;

	@Autowired
	private ICloudGoodsAutoService cloudGoodsAutoService;

	@Autowired
	private ICloudStatisticsAutoService cloudStatisticsAutoService;

	/**
	 * @Title: cloud_goods
	 * @Description: 兑购兑换列表
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param goodsName
	 * @param isShow
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月26日
	 */
	@RequestMapping({ "/admin/cloud_goods.htm" })
	public ModelAndView cloud_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goodsName , String isShow)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsExample example = new CloudGoodsExample ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			example.setOrderByClause ("addTime desc");
			Criteria criteria = example.createCriteria ();
			if (StringUtils.isNotEmpty (goodsName))
			{
				criteria.andGoodsNameLike ("%" + goodsName.trim () + "%");
			}
			if (StringUtils.isNotEmpty (isShow))
			{
				criteria.andIsShowEqualTo (Boolean.valueOf (CommUtil.null2Boolean (isShow)));
			}
			/* 不是已开奖和已流拍的商品 */
			criteria.andIsPassedEqualTo (false).andUserIdIsNull ().andDeletestatusEqualTo (false);
			Pagination pList = this.cloudGoodsService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("goodsName" , goodsName);
			mv.addObject ("isShow" , isShow);
			return mv;
		}

	/**
	 * @Title: cloud_pass
	 * @Description: 流拍列表
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param goodsName
	 * @param isShow
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月26日
	 */
	@RequestMapping({ "/admin/cloud_pass.htm" })
	public ModelAndView cloud_pass (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goodsName , String isShow)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_goods_pass.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsExample example = new CloudGoodsExample ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			example.setOrderByClause ("addTime desc");
			Criteria criteria = example.createCriteria ();
			if (StringUtils.isNotEmpty (goodsName))
			{
				criteria.andGoodsNameLike ("%" + goodsName.trim () + "%");
			}
			/* 已流拍的商品 */
			criteria.andIsPassedEqualTo (true).andDeletestatusEqualTo (false);
			Pagination pList = this.cloudGoodsService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("goodsName" , goodsName);
			return mv;
		}

	/**
	 * @Title: cloud_goods_winner
	 * @Description: 开奖列表
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param goodsName
	 * @param isShow
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月26日
	 */
	@RequestMapping({ "/admin/cloud_goods_winner.htm" })
	public ModelAndView cloud_goods_winner (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goodsName , String isShow)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_goods_winner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsExample example = new CloudGoodsExample ();
			example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			example.setOrderByClause ("open_winner_time desc");
			Criteria criteria = example.createCriteria ();
			if (StringUtils.isNotEmpty (goodsName))
			{
				criteria.andGoodsNameLike ("%" + goodsName.trim () + "%");
			}
			criteria.andUserIdIsNotNull ().andDeletestatusEqualTo (false);
			Pagination pList = this.cloudGoodsService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("goodsName" , goodsName);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_goods_add.htm" })
	public ModelAndView cloud_goods_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_goods_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (goodsClassExample);
			for (GoodsClassWithBLOBs gc : gcs)
			{
				goodsClassExample.clear ();
				goodsClassExample.setOrderByClause ("sequence asc");
				goodsClassExample.createCriteria ().andParentIdEqualTo (gc.getId ());
				List <GoodsClassWithBLOBs> c_gcs = this.goodsClassService.getObjectList (goodsClassExample);
				for (GoodsClassWithBLOBs c_gc : c_gcs)
				{
					goodsClassExample.clear ();
					goodsClassExample.setOrderByClause ("sequence asc");
					goodsClassExample.createCriteria ().andParentIdEqualTo (c_gc.getId ());
					List <GoodsClassWithBLOBs> c_cgcs = this.goodsClassService.getObjectList (goodsClassExample);
					c_gc.setChilds (c_cgcs);
				}
				gc.setChilds (c_gcs);
			}
			mv.addObject ("gcs" , gcs);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_goods_save.htm" })
	public ModelAndView cloud_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String beginHour , String endHour , String list_url , String add_url , String pid , String goodsImgId)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			WebForm wf = new WebForm ();
			CloudGoods goods = null;
			long goodsId = 0l;
			if (id.equals (""))
			{
				goods = (CloudGoods) wf.toPo (request , CloudGoods.class);
				goods.setAddtime (new Date ());
				goods.setGoodsSn ("cloud" + CommUtil.formatTime ("yyyyMMddHHmmss" , new Date ()) + SecurityUserHolder.getCurrentUser ().getId ());
			}
			else
			{
				CloudGoods obj = this.cloudGoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
				goods = (CloudGoods) wf.toPo (request , obj);
			}
			if (StringUtils.isNotEmpty (goodsImgId))
			{
				goods.setGoodsImgId (Long.valueOf (goodsImgId));
			}
			if (StringUtils.isNotEmpty (pid))
			{
				GoodsClassWithBLOBs goodsClassWithBLOBs = this.goodsClassService.getByKey (CommUtil.null2Long (pid));
				if (goodsClassWithBLOBs != null)
				{
					goodsClassWithBLOBs.setParent (this.goodsClassService.getByKey (goodsClassWithBLOBs.getParentId ()));
					if (goodsClassWithBLOBs.getParent () != null)
					{
						goodsClassWithBLOBs.getParent ().setParent (this.goodsClassService.getByKey (goodsClassWithBLOBs.getParent ().getParentId ()));
					}
					if (null != goodsClassWithBLOBs.getId ())
					{
						goods.setGoodsClassId (goodsClassWithBLOBs.getId ());
					}
				}
			}
			Calendar cal = Calendar.getInstance ();
			if (goods.getBeginTime () != null)
			{
				cal.setTime (goods.getBeginTime ());
				cal.add (10 , CommUtil.null2Int (beginHour));
				goods.setBeginTime (cal.getTime ());
			}
			if (goods.getEndTime () != null)
			{
				cal.setTime (goods.getEndTime ());
				cal.add (10 , CommUtil.null2Int (endHour));
				goods.setEndTime (cal.getTime ());
			}
			if (StringUtils.isEmpty (id))
			{
				this.cloudGoodsService.add (goods);
				CloudGoodsExample example = new CloudGoodsExample ();
				example.createCriteria ().andAddtimeEqualTo (goods.getAddtime ()).andGoodsNameEqualTo (goods.getGoodsName ());
				goodsId = this.cloudGoodsService.getObjectList (example).get (0).getId ();
			}
			else
			{
				this.cloudGoodsService.updateByObject (goods);
				goodsId = goods.getId ();
			}
			List <CloudStatistics> statisticsList = cloudStatisticsService.getObjectList (new CloudStatisticsExample ());
			CloudStatistics cloudStatistics = null;
			if (statisticsList.isEmpty ())
			{
				cloudStatistics = new CloudStatistics ();
				cloudStatistics.setAddtime (new Date ());
				cloudStatistics.setGoodsCount (1l);
				cloudStatisticsService.add (cloudStatistics);
			}
			else
			{
				cloudStatistics = statisticsList.get (0);
				cloudStatistics.setGoodsCount (cloudStatistics.getGoodsCount () + 1l);
				cloudStatisticsService.updateByObject (cloudStatistics);
			}
			/* 生成云码 */
			try
			{
				generalCodes (goodsId , goods.getGoodsCount ());
				mv.addObject ("op_title" , "保存兑购商品成功");
			}
			catch (Exception e)
			{
				logger.error (e.getMessage ());
				mv.addObject ("op_title" , "生成云码失败");
				cloudGoodsService.deleteByKey (goodsId);
			}
			mv.addObject ("list_url" , list_url);
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@RequestMapping(value = "/admin/cloud_goods_img_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String cloud_goods_img_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "cloud_goods";
			Map<String,Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imageId = "";
			int reqWidth = CommUtil.null2Int (width);
			int reqHeight = CommUtil.null2Int (height);
			int mapWidth = CommUtil.null2Int (map.get ("width"));
			int mapHeight = CommUtil.null2Int (map.get ("height"));
			if ((Math.abs (reqWidth - mapWidth) == 0) && ((Math.abs (reqHeight - mapHeight) == 0)))
			{
				Accessory gg_img = new Accessory ();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						gg_img.setName (CommUtil.null2String (map.get ("fileName")));
						gg_img.setExt (CommUtil.null2String (map.get ("mime")));
						gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						gg_img.setPath (uploadFilePath + "/cloud_goods");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
					}
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
			else
			{
				imageId = String.valueOf (0);
				response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
		}

	@RequestMapping({ "/admin/cloud_goods_delId.htm" })
	public String cloud_goods_delId (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			deleteCloudGoods (Long.valueOf (id) , request);
			return "redirect:cloud_goods.htm?currentPage=" + currentPage;
		}

	@RequestMapping({ "/admin/cloud_goods_del.htm" })
	public String cloud_goods_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					deleteCloudGoods (Long.valueOf (id) , request);
				}
			}
			return "redirect:integral_goods.htm?currentPage=" + currentPage;
		}

	@RequestMapping({ "/admin/cloud_order.htm" })
	public ModelAndView cloud_order (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String orderId , String userName , String status)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsOrderExample goodsOrderExample = new CloudGoodsOrderExample ();
			goodsOrderExample.setOrderByClause ("add_time desc");
			goodsOrderExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			com.amall.core.bean.CloudGoodsOrderExample.Criteria criteria = goodsOrderExample.createCriteria ();
			if (StringUtils.isNotEmpty (orderId))
			{
				criteria.andOrderIdEqualTo (orderId);
			}
			if (StringUtils.isNotEmpty (userName))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andUsernameEqualTo (userName);
				List <User> users = userService.getObjectList (userExample);
				List <Long> userIds = new ArrayList <Long> ();
				for (User user : users)
				{
					userIds.add (user.getId ());
				}
				if (!userIds.isEmpty ())
				{
					criteria.andUserIdIn (userIds);
				}
			}
			if (StringUtils.isNotEmpty (status))
			{
				criteria.andOrderStatusEqualTo (Integer.valueOf (status));
			}
			Pagination pList = this.cloudGoodsOrderService.getObjectListWithPage (goodsOrderExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("orderId" , orderId);
			mv.addObject ("userName" , userName);
			mv.addObject ("status" , status);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_order_view.htm" })
	public ModelAndView cloud_order_view (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsOrder obj = cloudGoodsOrderService.getByKey (Long.valueOf (id));
			mv.addObject ("obj" , obj);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_order_del.htm" })
	public ModelAndView integral_order_del (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_order_ship.htm" })
	public ModelAndView cloud_order_ship (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/cloud_order_ship.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			CloudGoodsOrder obj = this.cloudGoodsOrderService.getByKey (CommUtil.null2Long (id));
			ExpressCompanyExample ecExample = new ExpressCompanyExample ();
			List <ExpressCompany> ecs = expressCompanyService.getObjectList (ecExample);
			mv.addObject ("obj" , obj);
			mv.addObject ("ecs" , ecs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@RequestMapping({ "/admin/cloud_order_code_select.htm" })
	@ResponseBody
	public String cloud_order_code_select (HttpServletRequest request , HttpServletResponse response , String shipCode)
		{
			CloudGoodsOrderExample cloudGoodsOrderExample = new CloudGoodsOrderExample ();
			cloudGoodsOrderExample.createCriteria ().andShipCodeEqualTo (shipCode);
			Integer count = cloudGoodsOrderService.getObjectListCount (cloudGoodsOrderExample);
			if (count > 0)
			{
				return "true";
			}
			return "false";
		}

	@RequestMapping({ "/admin/cloud_order_merge_ship.htm" })
	@ResponseBody
	public String cloud_order_merge_ship (HttpServletRequest request , HttpServletResponse response , String shipCode , String id , String igoShipContent , String igoShipPrice)
		{
			CloudGoodsOrderExample cloudGoodsOrderExample = new CloudGoodsOrderExample ();
			cloudGoodsOrderExample.createCriteria ().andShipCodeEqualTo (shipCode);
			List <CloudGoodsOrder> orderList = cloudGoodsOrderService.getObjectList (cloudGoodsOrderExample);
			CloudGoodsOrder cloudGoodsOrder = orderList.get (0);
			CloudGoodsOrder obj = cloudGoodsOrderService.getByKey (CommUtil.null2Long (id));
			obj.setOrderStatus (Globals.HAVE_SEND_OUT_GOOD);
			obj.setShipCode (shipCode);
			obj.setShipTime (new Date ());
			obj.setShipContent (igoShipContent);
			obj.setEcId (cloudGoodsOrder.getEcId ());
			if (StringUtils.isEmpty (igoShipPrice))
				igoShipPrice = "0";
			obj.setShipTransFee (new BigDecimal (igoShipPrice));
			this.cloudGoodsOrderService.updateByObject (obj);
			KuaiDiResultItem item = new KuaiDiResultItem ();
			item.setKuaidinum (shipCode);
			item.setContext ("兑购发货");
			item.setTime (CommUtil.formatLongDate (new Date ()));
			this.kuaidiService.save (item);
			return "true";
		}

	@RequestMapping({ "/admin/cloud_order_ship_save.htm" })
	public String cloud_order_ship_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String igoShipPrice , String igoShipCode , String igoShipContent , String ecId)
		{
			CloudGoodsOrder obj = this.cloudGoodsOrderService.getByKey (CommUtil.null2Long (id));
			/* kuaidi100 上报 */
			ExpressCompany com = this.expressCompayService.getByKey (Long.valueOf (ecId));
			String toCityInfo = obj.getAddress ().getProvince () + obj.getAddress ().getCity () + obj.getAddress ().getArea () + obj.getAddress ().getAreaInfo ();
			JsonRequest req = new JsonRequest ();
			req.setCompany (com.getCompanyMark ());
			// req.setFrom("广东省东莞市");
			req.setTo (toCityInfo);
			req.setNumber (igoShipCode);
			String result = "";
			try
			{
				String ret = Kuaidi100HttpRequest.getInstance ().postData (req , CommUtil.getURL (request));
				JsonResponse resp = Json.fromJson (JsonResponse.class , ret);
				if (resp.getResult () == true)
				{
					result = "发货成功！";
					// 更新订单
					obj.setOrderStatus (Globals.HAVE_SEND_OUT_GOOD);
					obj.setShipCode (igoShipCode);
					obj.setShipTime (new Date ());
					obj.setShipContent (igoShipContent);
					obj.setEcId (CommUtil.null2Long (ecId));
					if (StringUtils.isEmpty (igoShipPrice))
						igoShipPrice = "0";
					obj.setShipTransFee (new BigDecimal (igoShipPrice));
					this.cloudGoodsOrderService.updateByObject (obj);
					KuaiDiResultItem item = new KuaiDiResultItem ();
					item.setKuaidinum (igoShipCode);
					item.setContext ("兑购发货");
					item.setTime (CommUtil.formatLongDate (new Date ()));
					this.kuaidiService.save (item);
				}
				else
				{
					result = "发货失败，请检查信息是否正确";
				}
				logger.info (result);
			}
			catch (Exception e)
			{
				logger.error (result+"，"+e.getMessage ());
				e.printStackTrace ();
			}
			return "redirect:cloud_order.htm?currentPage=" + currentPage;
		}

	/**
	 * @Title: generalCodes
	 * @Description: 生成云码
	 * @param cloudGoodsId
	 * @param counts
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月28日
	 */
	private void generalCodes (long cloudGoodsId , int counts)
		{
			if (cloudGoodsId == 0 || counts == 0)
			{
				return;
			}
			int [ ] arr = new int [counts];
			for (int i = 0 ; i < counts ; i++)
			{
				arr[i] = i + 1;
			}
			upsetArray (arr);
			List <CloudCodes> list = new ArrayList <> ();
			CloudCodes cloudCodes = null;
			for (int code : arr)
			{
				cloudCodes = new CloudCodes ();
				cloudCodes.setCloudGoodsId (cloudGoodsId);
				cloudCodes.setCode (code);
				list.add (cloudCodes);
			}
			cloudCodesService.add (list);
		}

	/**
	 * @Title: upsetArray
	 * @Description: 打乱数组
	 * @param arr
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月20日
	 */
	private void upsetArray (int [ ] arr)
		{
			int temp = 0;
			int randomNumber = 0;
			Random random = new Random ();
			for (int i = 0 ; i < arr.length ; i++)
			{
				randomNumber = random.nextInt (arr.length);
				temp = arr[i];
				arr[i] = arr[randomNumber];
				arr[randomNumber] = temp;
			}
		}

	private void deleteCloudGoods (long goodsId , HttpServletRequest request)
		{
			CloudGoods cloudGoods = this.cloudGoodsService.getByKey (Long.valueOf (goodsId));
			/* 删除图片 */
			/*
			 * CommUtil.del_acc(request, cloudGoods.getAccessory(),
			 * this.configService.getSysConfig().getUploadRootPath());
			 */
			/* 删除线上数据 */
			CloudOnlineExample cloudOnlineExample = new CloudOnlineExample ();
			cloudOnlineExample.createCriteria ().andCloudGoodsIdEqualTo (goodsId);
			cloudOnlineService.deleteByExample (cloudOnlineExample);
			/* 删除未分配云码 */
			CloudCodesExample cloudCodesExample = new CloudCodesExample ();
			cloudCodesExample.createCriteria ().andCloudGoodsIdEqualTo (goodsId);
			cloudCodesService.deleteByExample (cloudCodesExample);
			/* 删除用户已购买云码 */
			/* 如果不是开奖商品，则退还用户礼品金 */
			if (cloudGoods.getOpenWinnerTime () == null)
			{
				List <CloudBuyCodes> buyCodesList = cloudBuyCodesService.getCloudBuyCodesOfCloudGoodsId (goodsId);
				User tempUser = null;
				for (CloudBuyCodes buyCodes : buyCodesList)
				{
					tempUser = userService.getByKey (buyCodes.getUserId ());
					tempUser.setGold (tempUser.getGold () + (buyCodes.getBuyCount () * cloudGoods.getGoodsNumber ()));
					userService.updateByObject (tempUser);
				}
			}
			/* 删除商品购买详情 */
			CloudBuyerDetailExample cloudBuyerDetailExample = new CloudBuyerDetailExample ();
			cloudBuyerDetailExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
			cloudBuyerDetailService.deleteByExample (cloudBuyerDetailExample);
			/* 删除商品 */
			cloudGoods.setDeletestatus (true);
			this.cloudGoodsService.updateByObject (cloudGoods);
			/* 修改自动发货 */
			CloudGoodsAutoExample cloudGoodsAutoExample = new CloudGoodsAutoExample ();
			cloudGoodsAutoExample.createCriteria ().andCloudGoodsIdEqualTo (cloudGoods.getId ());
			CloudGoodsAuto auto = this.cloudGoodsAutoService.getObjectList (cloudGoodsAutoExample).get (0);
			auto.setCloudGoodsId (0l);
			auto.setIsEnable (false);
			auto.setRemainGoodsNumber (auto.getRemainGoodsNumber () - 1);
			auto.setPassGoodsNumber (auto.getPassGoodsNumber () + 1);
			this.cloudGoodsAutoService.updateByObject (auto);
			CloudStatisticsAuto statisticsAuto = new CloudStatisticsAuto ();
			statisticsAuto.setCloudGoodsAutoId (auto.getId ());
			statisticsAuto.setCloudGoodsId (cloudGoods.getId ());
			statisticsAuto.setIsPass (true);
			cloudStatisticsAutoService.add (statisticsAuto);
			/* 删除该商品的统计数据 */
			CloudStatistics record = cloudStatisticsService.getObjectList (new CloudStatisticsExample ()).get (0);
			record.setAngelCoinCount (record.getGoodsCount () - 1);
			cloudStatisticsService.updateByObject (record);
		}

	@RequestMapping({ "/admin/cloud_goods_search.htm" })
	@ResponseBody
	public String cloud_goods_search (HttpServletRequest request , HttpServletResponse response , String goodsName)
		{
			List <CloudGoods> goodsList = null;
			if (StringUtils.isNotEmpty (goodsName))
			{
				CloudGoodsExample cloudGoodsExample = new CloudGoodsExample ();
				cloudGoodsExample.createCriteria ().andGoodsNameLike ("%" + goodsName + "%").andIsShowEqualTo (true);
				cloudGoodsExample.setOrderByClause ("id desc");
				goodsList = cloudGoodsService.getObjectList (cloudGoodsExample);
			}
			return Json.toJson (goodsList);
		}

	@RequestMapping({ "/admin/cloud_goods_show.htm" })
	@ResponseBody
	public String cloud_goods_show (HttpServletRequest request , HttpServletResponse response , String id)
		{
			CloudGoods cloudGoods = cloudGoodsService.getByKey (CommUtil.null2Long (id));
			return Json.toJson (cloudGoods);
		}
}
