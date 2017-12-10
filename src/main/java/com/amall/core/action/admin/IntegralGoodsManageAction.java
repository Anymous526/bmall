package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Address;
import com.amall.core.bean.AddressExample;
import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.bean.IntegralGoodsOrder;
import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IExpressCompanyService;
import com.amall.core.service.INavigationService;
import com.amall.core.service.address.IAddressService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.express.kuaidi100.JsonRequest;
import com.amall.core.web.express.kuaidi100.JsonResponse;
import com.amall.core.web.express.kuaidi100.Kuaidi100HttpRequest;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.ExcelExport;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
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
public class IntegralGoodsManageAction
{
	private Logger logger=Logger.getLogger (IntegralGoodsManageAction.class);
	@Autowired
	private IAddressService addressService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IIntegralGoodsService integralgoodsService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private INavigationService navigationService;

	@Autowired
	private IExpressCompanyService expressCompayService;

	@Autowired
	private IExpressCompanyService expressCompanyService;

	@Autowired
	private IKuaidiService kuaidiService;

	@SecurityMapping(title = "积分礼品列表" , value = "/admin/integral_goods.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_goods.htm" })
	public ModelAndView integral_goods (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String igGoodsName , String igShow)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				IntegralGoodsExample integralGoodsExample = new IntegralGoodsExample ();
				integralGoodsExample.clear ();
				IntegralGoodsExample.Criteria integralGoodsCriteria = integralGoodsExample.createCriteria ();
				integralGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				integralGoodsExample.setOrderByClause ("addTime desc");
				// integralGoodsCriteria.andNavigationIdIsNotNull();
				if (!CommUtil.null2String (igGoodsName).equals (""))
				{
					integralGoodsCriteria.andIgGoodsNameLike ("%" + igGoodsName.trim () + "%");
				}
				if (!CommUtil.null2String (igShow).equals (""))
				{
					integralGoodsCriteria.andIgShowEqualTo (Boolean.valueOf (CommUtil.null2Boolean (igShow)));
				}
				Pagination pList = this.integralgoodsService.getObjectListWithPage (integralGoodsExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("igGoodsName" , igGoodsName);
				mv.addObject ("igShow" , igShow);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "积分礼品添加" , value = "/admin/integral_goods_add.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_add.htm" })
	public ModelAndView integral_goods_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_goods_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
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
				List <Navigation> navigations = navigationService.getObjectList (new NavigationExample ());
				mv.addObject ("navigations" , navigations);
				mv.addObject ("gcs" , gcs);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "积分礼品编辑" , value = "/admin/integral_goods_edit.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_edit.htm" })
	public ModelAndView integral_goods_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_goods_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				if ((id != null) && (!id.equals ("")))
				{
					IntegralGoods integralgoods = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					integralgoods.setGc (this.goodsClassService.getByKey (integralgoods.getIgGcId ()));
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
					mv.addObject ("obj" , integralgoods);
					mv.addObject ("currentPage" , currentPage);
					mv.addObject ("edit" , Boolean.valueOf (true));
				}
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "积分礼品保存" , value = "/admin/integral_goods_save.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_save.htm" })
	public ModelAndView integral_goods_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String beginHour , String endHour , String list_url , String add_url , String pid , String navigationId , String igGoodsImgId , String igClickCount)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				WebForm wf = new WebForm ();
				IntegralGoods goods = null;
				if (id.equals (""))
				{
					goods = (IntegralGoods) wf.toPo (request , IntegralGoods.class);
					goods.setAddtime (new Date ());
					goods.setIgGoodsSn ("gift" + CommUtil.formatTime ("yyyyMMddHHmmss" , new Date ()) + SecurityUserHolder.getCurrentUser ().getId ());
				}
				else
				{
					IntegralGoods obj = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					goods = (IntegralGoods) wf.toPo (request , obj);
				}
				if (StringUtils.isNotEmpty (igGoodsImgId))
				{
					goods.setIgGoodsImgId (Long.valueOf (igGoodsImgId));
				}
				if (navigationId != null && !navigationId.equals (""))
				{
					goods.setNavigationId (Long.parseLong (navigationId));
				}
				if (pid != null && !pid.equals (""))
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
							goods.setIgGcId (goodsClassWithBLOBs.getId ());
						}
					}
				}
				if (StringUtils.isNotEmpty (igClickCount))
				{
					goods.setIgClickCount (Integer.parseInt (igClickCount));
				}
				// String uploadFilePath = this.configService.getSysConfig()
				// .getUploadfilepath();
				// String saveFilePathName =
				// this.configService.getSysConfig().getUploadRootPath()
				// + uploadFilePath + File.separator + "integral_goods";
				// Map map = new HashMap();
				// String fileName = "";
				//
				// if (goods.getIgGoodsImg() != null)
				// fileName = goods.getIgGoodsImg().getName();
				/*
				 * try { map = CommUtil.saveFileToServer(request, "img1",
				 * saveFilePathName, fileName, null); Accessory acc = null; if
				 * (fileName.equals("")) { if (map.get("fileName") != "") { acc =
				 * new Accessory();
				 * acc.setName(CommUtil.null2String(map.get("fileName")));
				 * acc.setExt(CommUtil.null2String(map.get("mime")));
				 * acc.setSize(CommUtil.null2Float(map.get("fileSize")));
				 * acc.setPath(uploadFilePath + "/integral_goods");
				 * acc.setWidth(CommUtil.null2Int(map.get("width")));
				 * acc.setHeight(CommUtil.null2Int(map.get("height")));
				 * acc.setAddtime(new Date()); this.accessoryService.add(acc);
				 * goods.setIgGoodsImg(acc); } } else if (map.get("fileName") != "")
				 * { acc = goods.getIgGoodsImg();
				 * acc.setName(CommUtil.null2String(map.get("fileName")));
				 * acc.setExt(CommUtil.null2String(map.get("mime")));
				 * acc.setSize(CommUtil.null2Float(map.get("fileSize")));
				 * acc.setPath(uploadFilePath + "/integral_goods");
				 * acc.setWidth(CommUtil.null2Int(map.get("width")));
				 * acc.setHeight(CommUtil.null2Int(map.get("height")));
				 * acc.setAddtime(new Date());
				 * this.accessoryService.updateByObject(acc); } } catch (IOException
				 * e) { e.printStackTrace(); } String ext =
				 * goods.getIgGoodsImg().getExt().indexOf(".") < 0 ? "." +
				 * goods.getIgGoodsImg().getExt() : goods.getIgGoodsImg().getExt();
				 * String source =
				 * this.configService.getSysConfig().getUploadRootPath() +
				 * goods.getIgGoodsImg().getPath() + File.separator +
				 * goods.getIgGoodsImg().getName(); String target = source +
				 * "_small" + ext; CommUtil.createSmall(source, target,
				 * this.configService .getSysConfig().getSmallwidth(),
				 * this.configService .getSysConfig().getSmallheight());
				 */
				Calendar cal = Calendar.getInstance ();
				if (goods.getIgBeginTime () != null)
				{
					cal.setTime (goods.getIgBeginTime ());
					cal.add (10 , CommUtil.null2Int (beginHour));
					goods.setIgBeginTime (cal.getTime ());
				}
				if (goods.getIgEndTime () != null)
				{
					cal.setTime (goods.getIgEndTime ());
					cal.add (10 , CommUtil.null2Int (endHour));
					goods.setIgEndTime (cal.getTime ());
				}
				if (goods.getIgLimitCount () == null || Integer.valueOf (0).equals (goods.getIgLimitCount ()))
				{
					goods.setIgLimitCount (100000000);
				}
				if (id.equals (""))
					this.integralgoodsService.add (goods);
				else
				{
					this.integralgoodsService.updateByObject (goods);
				}
				mv.addObject ("list_url" , list_url);
				mv.addObject ("op_title" , "保存积分商品成功");
				if (add_url != null)
					mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@RequestMapping(value = "/admin/ingetral_goods_img_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String ingetral_goods_img_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "integral_goods";
			Map <String, Object> map = new HashMap <String, Object> ();
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
						gg_img.setPath (uploadFilePath + "/integral_goods");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
					}
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\",\"path\":\"" + gg_img.getPath () + "\",\"name\":\"" + gg_img.getName () + "\"}";
				return response_rs;
			}
			else
			{
				imageId = String.valueOf (0);
				response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
		}

	@SecurityMapping(title = "单个积分礼品删除" , value = "/admin/integral_goods_delId.htm*" , rtype = "admin" ,
						rname = "积分商城" , rcode = "integral_goods_admin" , rgroup = "运营" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_delId.htm" })
	public String integralGoodsDelId (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			IntegralGoods integralgoods = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
			CommUtil.del_acc (request , integralgoods.getIgGoodsImg () , this.configService.getSysConfig ().getUploadRootPath ());
			this.integralgoodsService.deleteByKey (Long.valueOf (Long.parseLong (id)));
			return "redirect:integral_goods.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "是否上/下架商品" , value = "/admin/integral_goods_isShow.htm*" , rtype = "admin" ,
						rname = "积分商城" , rcode = "integral_goods_admin" , rgroup = "运营" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_isShow.htm" })
	public String isShow (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			IntegralGoods integralgoods = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
			if (integralgoods.getIgShow ())
			{
				integralgoods.setIgShow (false);
			}
			else
			{
				integralgoods.setIgShow (true);
			}
			this.integralgoodsService.updateByObject (integralgoods);
			return "redirect:integral_goods.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "是否推荐商品" , value = "/admin/integral_goods_isRecommend.htm*" , rtype = "admin" ,
						rname = "积分商城" , rcode = "integral_goods_admin" , rgroup = "运营" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_isRecommend.htm" })
	public String isRecommend (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			IntegralGoods integralgoods = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
			if (integralgoods.getIgRecommend ())
			{
				integralgoods.setIgRecommend (false);
			}
			else
			{
				integralgoods.setIgRecommend (true);
			}
			this.integralgoodsService.updateByObject (integralgoods);
			return "redirect:integral_goods.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "积分礼品删除" , value = "/admin/integral_goods_del.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_goods_del.htm" })
	public String integral_goods_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					IntegralGoods integralgoods = this.integralgoodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					CommUtil.del_acc (request , integralgoods.getIgGoodsImg () , this.configService.getSysConfig ().getUploadRootPath ());
					this.integralgoodsService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:integral_goods.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "积分礼品兑换列表" , value = "/admin/integral_order.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order.htm" })
	public ModelAndView integral_order (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String igo_order_sn , String userName , String igo_payment , String igo_status)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				IntegralGoodsOrderExample integralGoodsOrderExample = new IntegralGoodsOrderExample ();
				integralGoodsOrderExample.clear ();
				IntegralGoodsOrderExample.Criteria igoCriteria = integralGoodsOrderExample.createCriteria ();
				integralGoodsOrderExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				integralGoodsOrderExample.setOrderByClause ("addtime desc");
				if (!CommUtil.null2String (igo_order_sn).equals (""))
				{
					igoCriteria.andIgoOrderSnLike (igo_order_sn);
				}
				if (!CommUtil.null2String (userName).equals (""))
				{
					UserExample userExample = new UserExample ();
					userExample.clear ();
					userExample.createCriteria ().andUsernameLike (userName);
					List <User> users = userService.getObjectList (userExample);
					List <Long> userIds = new ArrayList <Long> ();
					if (null != users && users.size () > 0)
					{
						for (User user : users)
						{
							userIds.add (user.getId ());
						}
					}
					if (userIds != null && userIds.size () > 0)
						igoCriteria.andIgoUserIdIn (userIds);
				}
				if (!CommUtil.null2String (igo_payment).equals (""))
				{
					igoCriteria.andIgoPaymentEqualTo (igo_payment.trim ());
				}
				if (!CommUtil.null2String (igo_status).equals (""))
				{
					igoCriteria.andIgoStatusEqualTo (Integer.valueOf (CommUtil.null2Int (igo_status)));
				}
				Pagination pList = this.integralGoodsOrderService.getObjectListWithPage (integralGoodsOrderExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("igo_order_sn" , igo_order_sn);
				mv.addObject ("userName" , userName);
				mv.addObject ("igo_payment" , igo_payment);
				mv.addObject ("igo_status" , igo_status);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "积分礼品兑换详情" , value = "/admin/integral_order_view.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_view.htm" })
	public ModelAndView integral_order_view (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				IntegralGoodsOrder obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
				mv.addObject ("obj" , obj);
				// 八月1号之前下订单的兑换订单ID号
				int oldIntegralId = 111;
				System.out.println (obj.getIgoAddrId ());
				if (obj.getId () < oldIntegralId)
				{
					Address address = addressService.getByKey (obj.getIgoAddrId ());
					mv.addObject ("address" , address);
				}
				/* 获取快递信息 */
				List <KuaiDiResultItem> transInfo = kuaidiService.getKuaidiInfo (obj.getIgoShipCode ());
				mv.addObject ("transInfo" , transInfo);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "取消积分订单" , value = "/admin/integral_order_cancel.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_cancel.htm" })
	public ModelAndView integral_order_cancel (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				obj.setIgoStatus (-1);
				this.integralGoodsOrderService.updateByObject (obj);
				/*
				 * for (IntegralGoodsCart igc : obj.getIgoGcs()) { IntegralGoods
				 * goods = igc.getGoods();
				 * goods.setIgGoodsCount(goods.getIgGoodsCount() + igc.getCount());
				 * this.integralgoodsService.updateByObject(goods); }
				 */
				
				User user = obj.getIgoUser ();
				user.setGold ((user.getGold () + obj.getIgoTotalGold ()));
				this.userService.updateByObject (user);
				/*
				IntegralLog log = new IntegralLog ();
				log.setAddtime (new Date ());
				log.setContent ("取消" + obj.getIgoOrderSn () + "积分兑换，返还积分");
				log.setIntegral (obj.getIgoTotalIntegral ());
				log.setIntegralUser (obj.getIgoUser ());
				log.setOperateUser (SecurityUserHolder.getCurrentUser ());
				log.setType ("integral_order");
				this.integralLogService.add (log);
				mv.addObject ("op_title" , "积分兑换取消成功");
				*/
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/integral_order.htm");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "订单确认付款" , value = "/admin/integral_order_payok.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_payok.htm" })
	public ModelAndView integral_order_payok (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				obj.setIgoStatus (20);
				this.integralGoodsOrderService.updateByObject (obj);
				mv.addObject ("op_title" , "确认收款成功");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/integral_order.htm");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "订单删除" , value = "/admin/integral_order_del.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_del.htm" })
	public ModelAndView integral_order_del (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			IntegralGoodsOrder obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				if (obj.getIgoStatus () == -1)
				{
					this.integralGoodsOrderService.deleteByKey (obj.getId ());
				}
				mv.addObject ("op_title" , "删除兑换订单成功");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/integral_order.htm");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "订单费用调整" , value = "/admin/integral_order_fee.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_fee.htm" })
	public ModelAndView integral_order_fee (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_order_fee.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			IntegralGoodsOrder obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "订单费用调整保存" , value = "/admin/integral_order_fee_save.htm*" , rtype = "admin" ,
						rname = "积分商城" , rcode = "integral_goods_admin" , rgroup = "运营" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/integral_order_fee_save.htm" })
	public String integral_order_fee_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String igoTransFee)
		{
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				obj.setIgoTransFee (BigDecimal.valueOf (CommUtil.null2Double (igoTransFee)));
				if (CommUtil.null2Double (obj.getIgoTransFee ()) == 0.0D)
				{
					obj.setIgoPayTime (new Date ());
					obj.setIgoStatus (20);
				}
				this.integralGoodsOrderService.updateByObject (obj);
			}
			return "redirect:integral_order.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "发货设置" , value = "/admin/integral_order_ship.htm*" , rtype = "admin" , rname = "积分商城" ,
						rcode = "integral_goods_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_order_ship.htm" })
	public ModelAndView integral_order_ship (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/integral_order_ship.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			IntegralGoodsOrder obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			ExpressCompanyExample ecExample = new ExpressCompanyExample ();
			ecExample.clear ();
			List <ExpressCompany> ecs = expressCompanyService.getObjectList (ecExample);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("ecs" , ecs);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "发货设置保存" , value = "/admin/integral_order_ship_save.htm*" , rtype = "admin" ,
						rname = "积分商城" , rcode = "integral_goods_admin" , rgroup = "运营" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/admin/integral_order_ship_save.htm" })
	public String integral_order_ship_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String igoShipCode , String igoShipTime , String igoShipContent , String ecId)
		{
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (this.configService.getSysConfig ().getIntegralstore ())
			{
				ExpressCompany com = this.expressCompayService.getByKey (CommUtil.null2Long (ecId));
				String toCityInfo = obj.getIgoAddr ().getProvince () + obj.getIgoAddr ().getCity () + obj.getIgoAddr ().getArea () + obj.getIgoAddr ().getAreaInfo ();
				JsonRequest req = new JsonRequest ();
				req.setCompany (com.getCompanyMark ());
				// req.setFrom("广东省东莞市");
				req.setTo (toCityInfo);
				req.setNumber (igoShipCode);
				String ret;
				try
				{
					ret = Kuaidi100HttpRequest.getInstance ().postData (req , CommUtil.getURL (request));
					JsonResponse resp = Json.fromJson (JsonResponse.class , ret);
					if (resp.getResult () == true)
					{
						obj.setIgoStatus (30);
						obj.setIgoShipCode (igoShipCode);
						obj.setIgoShipTime (CommUtil.formatDate (igoShipTime));
						obj.setIgoShipContent (igoShipContent);
						obj.setEcId (CommUtil.null2Long (ecId));
						this.integralGoodsOrderService.updateByObject (obj);
					}
				}
				catch (Exception e)
				{
					logger.error (e.getMessage ());
				}
			}
			return "redirect:integral_order.htm?currentPage=" + currentPage;
		}

	@RequestMapping({ "/admin/user_address.htm" })
	public ModelAndView user_address (HttpServletRequest request , HttpServletResponse response , String username , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/user_address_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (StringUtils.isNotEmpty (username))
			{
				User user = userService.getUserOfUserName (username);
				AddressExample addressExample = new AddressExample ();
				addressExample.clear ();
				addressExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				addressExample.setOrderByClause ("addTime desc");
				com.amall.core.bean.AddressExample.Criteria criteria = addressExample.createCriteria ();
				criteria.andUserIdEqualTo (user.getId ());
				Pagination pList = this.addressService.getObjectListWithPage (addressExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("username" , username);
			}
			return mv;
		}

	@RequestMapping({ "admin/Exportintegral_order.htm" })
	public void Exportintegral_order (HttpServletRequest request , HttpServletResponse response) throws IOException
		{
			try
			{
				OutputStream out = response.getOutputStream ();
				responseSetting (response , "礼品金兑换列表");
				List <String> ob = new ArrayList <String> ();
				ob.add ("兑换单号");
				ob.add ("会员名称");
				ob.add ("礼品名称");
				ob.add ("兑换礼品金");
				ob.add ("运费");
				ob.add ("支付方式");
				ob.add("兑换数量");
				ob.add ("兑换时间");
				ob.add ("状态");
				ob.add ("收货人电话号码");
				ob.add ("收货人姓名");
				ob.add ("收货地址");
				ob.add ("详细地址");
				IntegralGoodsOrderExample integralGoodsOrderExample = new IntegralGoodsOrderExample ();
				integralGoodsOrderExample.clear ();
				integralGoodsOrderExample.setOrderByClause ("addtime desc");
				List <IntegralGoodsOrderWithBLOBs> pList = integralGoodsOrderService.getObjectList (integralGoodsOrderExample);
				List <List <Object>> ls = new ArrayList <List <Object>> ();
				List <Object> lf = new ArrayList <Object> ();
				for (int i = 0 ; i < pList.size () ; i++)
				{
					lf = new ArrayList <Object> ();
					lf.add (pList.get (i).getIgoOrderSn ());
					if (pList.get (i).getIgoUser () != null)
					{
						if (pList.get (i).getIgoUser ().getTruename () != null)
						{
							lf.add (pList.get (i).getIgoUser ().getTruename ());
						}
					}
					if (pList.get (i).getIg () != null)
					{
						if (cn.jpush.api.utils.StringUtils.isEmpty (pList.get (i).getIg ().getIgGoodsName ()))
						{
							logger.info ("商品名 : " + pList.get (i).getIg ().getIgGoodsName ().toString ());
						}
						else
						{
							lf.add (pList.get (i).getIg ().getIgGoodsName ());
						}
					}
					lf.add (pList.get (i).getIgoTotalGold ());
					lf.add (pList.get (i).getIgoTransFee ());
					lf.add (pList.get (i).getIgoPayment ());
					lf.add(pList.get(i).getIgoTotalIntegral());
					lf.add (pList.get (i).getAddtime ());
					if (pList.get (i).getIgoStatus () == 20)
					{
						lf.add ("已付款，待发货");
					}
					if (pList.get (i).getIgoStatus () == 30)
					{
						lf.add ("已发货");
					}
					if (pList.get (i).getIgoStatus () == -1)
					{
						lf.add ("已取消");
					}
					if (pList.get (i).getIgoStatus () == 40)
					{
						lf.add ("已收货，完成");
					}
					if (pList.get (i).getIgoAddr () != null)
					{
						if (pList.get (i).getIgoAddr ().getProvince () != null)
						{
							if (pList.get (i).getIgoAddr ().getCity () != null)
							{
								if (pList.get (i).getIgoAddr ().getArea () != null)
								{
									lf.add (pList.get (i).getIgoAddr ().getTelephone ());
									lf.add (pList.get (i).getIgoAddr ().getTruename ());
									lf.add (pList.get (i).getIgoAddr ().getProvince () + " " + pList.get (i).getIgoAddr ().getCity () + " " + pList.get (i).getIgoAddr ().getArea ());
								}
							}
						}
					}
					if (pList.get (i).getIgoAddr () != null)
					{
						if (pList.get (i).getIgoAddr ().getAreaInfo () != null)
						{
							lf.add (pList.get (i).getIgoAddr ().getAreaInfo ());
						}
					}
					ls.add (lf);
				}
				ExcelExport exporr = new ExcelExport ();
				exporr.export ("礼品金兑换订单统计" , ob , ls , out);
			}
			catch (Exception e)
			{
				logger.error (e.getMessage ());
			}
		}

	private void responseSetting (HttpServletResponse response , String excelName)
		{
			response.setContentType ("application/vnd.ms-excel");
			response.setHeader ("Content-Disposition" , "attachment;filename=" + getExcelFileName (excelName) + "");
		}

	private static String getExcelFileName (String title)
		{
			StringBuffer sb = new StringBuffer ();
			sb.append (title);
			sb.append (CommUtil.formatDate (new Date () , "yyyyMMddHHmmss"));
			sb.append (".xls");
			return CommUtil.encode (sb.toString ());
		}
}
