package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IGoodsClass2SpecService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class AdminOrderAction
{

	/***
	 * 生成订单
	 * 
	 * @param request
	 * @param response
	 * @param goodsId
	 * @param userId
	 */
	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsClass2SpecService goodsclassSpec;

	@RequestMapping({ "/admin/OrderGenerated.htm" })
	@ResponseBody
	public void OrderGenerated (HttpServletRequest request , HttpServletResponse response , String goodsId , String userId)
		{
			Goods goods = goodsService.getByKey (Long.parseLong (goodsId));
			String orderId = CommUtil.generateOrderId ();	// 生成订单随机数
			System.out.println (userId);
			Calendar calendar = Calendar.getInstance ();
			Date date = new Date (System.currentTimeMillis ());
			calendar.setTime (date);
			calendar.add (Calendar.WEEK_OF_YEAR , -1);
			// calendar.add(Calendar.YEAR, -1);
			date = calendar.getTime ();
			System.out.println (date);
			OrderFormWithBLOBs order = new OrderFormWithBLOBs ();
			order.setStoreId (goods.getGoodsStoreId ());
			order.setAddtime (date);
			// order.setCiId(cart.getId());
			order.setOrderStatus (Globals.HAVE_RECEIVED_GOOD);		// 设置成已收货
			order.setUserId (Long.parseLong (userId));
			order.setOrderId (orderId);
			order.setTotalprice (goods.getGoodsCurrentPrice ());
			order.setOrderType ("1000");		// 标识刷单信息
			// order.setShipPrice(shipFee);
			// order.setGoodsAmount(payment);
			this.orderFormService.add (order);
			OrderFormItem formItem = new OrderFormItem ();
			formItem.setAddTime (date);
			formItem.setDirectBuy (true);
			// formItem.setGoodsCount(detail.getGoodsCount());
			formItem.setGoodsId (goods.getId ());
			formItem.setGoodsName (goods.getGoodsName ());
			formItem.setGoodsPhoto (goods.getGoodsMainPhotoId ());
			// formItem.setGoodsRate(goods.getGc().getRate());
			formItem.setRefundServer (goods.getRefundServerTime ());
			formItem.setGoodsPrice (goods.getGoodsPrice ());
			// formItem.setSpecInfo(detail.getSpecInfo()); //规格信息
			formItem.setLeeStatus (false);
			formItem.setOrderId (getOrderFormOfOrderId (order.getOrderId () , null).getId ());
			this.orderFormItemService.add (formItem);
			/* 生成订单日志记录 */
			OrderFormLog formLog = new OrderFormLog ();
			formLog.setAddtime (new Date ());
			formLog.setLogUserId (order.getUserId ());
			formLog.setStateInfo (order.getOrderStatus ().toString ());
			formLog.setOfId (Long.valueOf (order.getOrderId ()));
			formLog.setLogInfo (Globals.HAVE_RECEIVED_GOOD_NAME);
			this.orderFormLogService.add (formLog);
			System.err.println ("订单编号=" + orderId);
			try
			{
				response.getWriter ().print (orderId);	// 生成订单成功
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/***
	 * 根据订单ID获取订单对象
	 * 
	 * @param orderId
	 * @param orderStatus
	 * @return
	 */
	public OrderFormWithBLOBs getOrderFormOfOrderId (String orderId , String orderStatus)
		{
			List <OrderFormWithBLOBs> list = new ArrayList <OrderFormWithBLOBs> ();
			OrderFormExample example = new OrderFormExample ();
			example.clear ();
			com.amall.core.bean.OrderFormExample.Criteria criteria = example.createCriteria ();
			criteria.andOrderIdEqualTo (orderId);
			if (orderStatus != null)
			{
				criteria.andOrderStatusEqualTo (Integer.valueOf (orderStatus));
			}
			list = this.orderFormService.getObjectList (example);
			if (list.isEmpty ())
			{
				return null;
			}
			return list.get (Globals.NUBER_ZERO);
		}

	/**
	 * 获取所有的刷单用户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "admin/vest_list.htm" })
	public ModelAndView vestList (HttpServletRequest request , HttpServletResponse response)
		{
			User users = SecurityUserHolder.getCurrentUser ();
			ModelAndView mv = new JModelAndView ("admin/vest_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample example = new UserExample ();
			example.setOrderByClause ("addTime desc");
			example.createCriteria ().andStatusEqualTo (1000);
			List <User> user = userService.getObjectList (example);
			mv.addObject ("user" , user);
			mv.addObject("users", users);
			return mv;
		}

	@RequestMapping({ "/admin/buyer_orderCommentSave.htm" })
	public ModelAndView buyer_orderCommentSave (HttpServletRequest request , HttpServletResponse response , String userIds , String goodsId , String info) throws Exception
		{
			/* 生成订单 */
			System.err.println ("info=" + info);
			Goods goodsj = goodsService.getByKey (Long.parseLong (goodsId));
			String orderId = CommUtil.generateOrderId ();	// 生成订单随机数
			System.out.println (userIds);
			Calendar calendar = Calendar.getInstance ();
			Date date = new Date (System.currentTimeMillis ());
			calendar.setTime (date);
			calendar.add (Calendar.WEEK_OF_YEAR , -1);
			// calendar.add(Calendar.YEAR, -1);
			date = calendar.getTime ();
			System.out.println (date);
			OrderFormWithBLOBs order = new OrderFormWithBLOBs ();
			order.setStoreId (goodsj.getGoodsStoreId ());
			order.setAddtime (date);
			// order.setCiId(cart.getId());
			order.setOrderStatus (Globals.HAVE_RECEIVED_GOOD);		// 设置成已收货
			order.setUserId (Long.parseLong (userIds));
			order.setOrderId (orderId);
			order.setTotalprice (goodsj.getGoodsCurrentPrice ());
			order.setOrderType ("1000");		// 标识刷单信息
			// order.setShipPrice(shipFee);
			// order.setGoodsAmount(payment);
			this.orderFormService.add (order);
			System.err.println ("订单编号=" + orderId);
			OrderFormItem formItem = new OrderFormItem ();
			formItem.setAddTime (date);
			formItem.setDirectBuy (true);
			// formItem.setGoodsCount(detail.getGoodsCount());
			formItem.setGoodsId (goodsj.getId ());
			formItem.setGoodsName (goodsj.getGoodsName ());
			formItem.setGoodsPhoto (goodsj.getGoodsMainPhotoId ());
			// formItem.setGoodsRate(goods.getGc().getRate());
			formItem.setRefundServer (goodsj.getRefundServerTime ());
			formItem.setGoodsPrice (goodsj.getGoodsPrice ());
			if(null == info){
				formItem.setSpecInfo (goodsj.getGoodsName ());	// 规格信息
			}else{
				formItem.setSpecInfo (goodsj.getGoodsName ()+" : "+info);	// 规格信息
			}
			formItem.setLeeStatus (false);
			formItem.setOrderId (getOrderFormOfOrderId (order.getOrderId () , null).getId ());
			this.orderFormItemService.add (formItem);
			/* 生成订单日志记录 */
			OrderFormLog formLog = new OrderFormLog ();
			formLog.setAddtime (new Date ());
			formLog.setLogUserId (order.getUserId ());
			formLog.setStateInfo (order.getOrderStatus ().toString ());
			formLog.setOfId (Long.valueOf (order.getOrderId ()));
			formLog.setLogInfo (Globals.HAVE_RECEIVED_GOOD_NAME);
			this.orderFormLogService.add (formLog);
			/* 生成订单结束 */
			OrderFormWithBLOBs orderForm = this.orderFormService.getByKey (CommUtil.null2Long (order.getId ()));
			GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			EvaluateExample evaluateExample = new EvaluateExample ();
			evaluateExample.createCriteria ().andOfIdEqualTo (CommUtil.null2Long (order.getId ())).andEvaluateGoodsIdEqualTo (CommUtil.null2Long (goodsId));
			Integer evaCount = evaluateService.getObjectListCount (evaluateExample);
			if (evaCount > 0)
			{
				ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "不能重复评价！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_order.htm");
				return mv;
			}
			// 当用户拥有此订单的时候才可以评价
			if (orderForm.getUserId () != null)
			{
				// 已收货但是还没有评价
				if (orderForm.getOrderStatus () == 40)
				{
					EvaluateWithBLOBs eva = new EvaluateWithBLOBs ();
					 Calendar calendars = Calendar.getInstance();
				        Date dates = new Date(System.currentTimeMillis());
				        calendars.setTime(dates);
				        for(int i=0;i<1;i++){
				            double num = 3*(Math.random());//Math.random()生成的数字是0-1之间（不包括1）
				            int result = (int)num-3;
				            calendars.add(Calendar.WEEK_OF_YEAR,result );
				            System.out.println(result);
				        }
				    dates = calendars.getTime();
					SimpleDateFormat formatl = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
					eva.setAddtime (dates);
					eva.setEvaluateGoodsId (CommUtil.null2Long (goodsId));
					eva.setEvaluate_goods (goods);
					eva.setEvaluateInfo (request.getParameter ("evaluate_info"));
					eva.setEvaluateBuyerVal (CommUtil.null2Int (request.getParameter ("evaluate_buyer_val")));
					eva.setDescriptionEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("description_evaluate"))));
					eva.setServiceEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("service_evaluate"))));
					eva.setShipEvaluate (BigDecimal.valueOf (CommUtil.null2Double (request.getParameter ("ship_evaluate"))));
					eva.setEvaluateType ("goods");
					eva.setOf (orderForm);
					User users = userService.getByKey (Long.parseLong (userIds));
					eva.setEvaluateUserId (Long.parseLong (userIds));
					eva.setEvaluate_user (users);
					eva.setEvaluateSellerUserId (goods.getGoodsStore ().getUserId ());
					eva.setEvaluate_seller_user (goods.getGoodsStore ().getUser ());
					// 设置评价商品的规格
					OrderFormItem orderFornItem = this.orderFormItemService.getObjectByOrderIdAndGoodsId (CommUtil.null2Long (order.getId ()) , CommUtil.null2Long (goodsId));
					eva.setGoodsSpec (orderFornItem.getSpecInfo ());
					// 设置评价的图片
					String [ ] imgIds = request.getParameter ("imgIds").split (",");
					if (imgIds.length == 1)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
					}
					if (imgIds.length == 2)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
						eva.setImg2id (CommUtil.null2Long (imgIds[1]));
						eva.setImg2 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[1])));
					}
					if (imgIds.length == 3)
					{
						eva.setImg1id (CommUtil.null2Long (imgIds[0]));
						eva.setImg1 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[0])));
						eva.setImg2id (CommUtil.null2Long (imgIds[1]));
						eva.setImg2 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[1])));
						eva.setImg3id (CommUtil.null2Long (imgIds[2]));
						eva.setImg3 (this.accessoryService.getByKey (CommUtil.null2Long (imgIds[2])));
					}
					// 新增商品评价
					this.evaluateService.add (eva);
					// 评价完之后，更新该商品状态为已评价
					orderFornItem.setItemStatus (true);
					this.orderFormItemService.updateByObject (orderFornItem);
					List <EvaluateWithBLOBs> evas = this.evaluateService.selectByOfLeftJoinStoreId (orderForm.getStoreId ());
					double store_evaluate1 = 0.0D;
					double store_evaluate1_total = 0.0D;
					double description_evaluate = 0.0D;
					double description_evaluate_total = 0.0D;
					double service_evaluate = 0.0D;
					double service_evaluate_total = 0.0D;
					double ship_evaluate = 0.0D;
					double ship_evaluate_total = 0.0D;
					DecimalFormat df = new DecimalFormat ("0.0");
					for (Evaluate eva1 : evas)
					{
						// 店铺总评论分
						store_evaluate1_total = store_evaluate1_total + eva1.getEvaluateBuyerVal ();
						// 商品描述总评论分
						description_evaluate_total = description_evaluate_total + CommUtil.null2Double (eva1.getDescriptionEvaluate ());
						// 服务总评论分
						service_evaluate_total = service_evaluate_total + CommUtil.null2Double (eva1.getServiceEvaluate ());
						// 物流总评论分
						ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double (eva1.getShipEvaluate ());
					}
					// 店铺评分 : 店铺总评论分 / 评论条数
					store_evaluate1 = CommUtil.null2Double (df.format (store_evaluate1_total));
					// 商品评分: 总评论分 / 评论条数
					description_evaluate = CommUtil.null2Double (df.format (description_evaluate_total / evas.size ()));
					// 服务评分 : 服务总评论分 / 总评论数
					service_evaluate = CommUtil.null2Double (df.format (service_evaluate_total / evas.size ()));
					ship_evaluate = CommUtil.null2Double (df.format (ship_evaluate_total / evas.size ()));
					StoreWithBLOBs store = this.storeService.getByKey (goods.getGoodsStoreId ());
					// 将用户评价的得分记入店铺总信用度
					store.setStoreCredit (store.getStoreCredit () + eva.getEvaluateBuyerVal ());
					// this.storeService.updateByObject(store);
					StorePointExample storePointExample = new StorePointExample ();
					storePointExample.clear ();
					storePointExample.createCriteria ().andStoreIdEqualTo (store.getId ());
					List <StorePoint> sps = this.storePointService.getObjectList (storePointExample);
					StorePoint point = null;
					if (sps.size () > 0)
						point = (StorePoint) sps.get (0);
					else
					{
						point = new StorePoint ();
					}
					point.setAddtime (new Date ());
					point.setStore (store);
					point.setStoreId (store.getId ());
					point.setDescriptionEvaluate (BigDecimal.valueOf (description_evaluate));
					point.setServiceEvaluate (BigDecimal.valueOf (service_evaluate));
					point.setShipEvaluate (BigDecimal.valueOf (ship_evaluate));
					point.setStoreEvaluate1 (BigDecimal.valueOf (store_evaluate1));
					if (sps.size () > 0)
						this.storePointService.updateByObject (point);
					else
					{
						this.storePointService.add (point);
					}
					store.setPointId (point.getId ());
					store.setPoint (point);
					this.storeService.updateByObject (store);
					User user = orderForm.getUser ();
					/*user.setIntegral (user.getIntegral () + this.configService.getSysConfig ().getIndentcomment ());*/
					this.userService.updateByObject (user);
					OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
					orderFormItemExample.createCriteria ().andOrderIdEqualTo (orderForm.getId ());
					List <OrderFormItem> items = orderFormItemService.getObjectList (orderFormItemExample);
					List <Boolean> itemStatuses = new ArrayList <Boolean> ();
					for (OrderFormItem item : items)
					{
						itemStatuses.add (item.getItemStatus ());
					}
					if (!itemStatuses.contains (false) && !itemStatuses.contains (null))
					{
						orderForm.setOrderStatus (Integer.valueOf (50));
						orderFormService.updateByObject (orderForm);
					}
				}
			}
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("op_title" , "评价成功！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/admin/index.htm");
			return mv;
		}

	@SecurityMapping(title = "图像上传" , value = "/buyer/buyer_upload_avatars.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/buyer_upload_avatars.htm" })
	public void upload_avatar (HttpServletRequest request , HttpServletResponse response , String userId) throws IOException
		{
			System.err.println ("user=" + userId);
			User user = userService.getByKey (Long.parseLong (userId));
			// 判断是否是上传文件表单
			boolean isMultipart = ServletFileUpload.isMultipartContent (request);	// 用于判断是那种表单
			if (isMultipart)
			{
				// 返回保存的相对路径
				String returnPath = null;
				PrintWriter writer = response.getWriter ();
				String filePath = this.configService.getSysConfig ().getUploadRootPath () + this.configService.getSysConfig ().getUploadfilepath () + File.separator + "avatar" + File.separator;
				System.err.println ("filePath= " + filePath);
				String relativePath = "/upload/avatar/";
				File uploadDir = new File (filePath);
				if (!uploadDir.exists ())
				{
					uploadDir.mkdirs ();
				}
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Map <String, MultipartFile> fileMap = multipartRequest.getFileMap ();
				String fileName = null;
				for (Map.Entry <String, MultipartFile> entity : fileMap.entrySet ())
				{
					// 上传文件名
					MultipartFile mf = entity.getValue ();
					fileName = mf.getOriginalFilename ();
					String fileExt = fileName.substring (fileName.lastIndexOf (".") + 1).toLowerCase ();
					if (!fileExt.equals ("jpg") && !fileExt.equals ("png"))
					{
						writer.print (returnPath);
					}
					String saveName = user.getId () + "-" + UUID.randomUUID ().toString () + "." + fileExt;
					File uploadFile = new File (filePath + saveName);
					try
					{
						FileCopyUtils.copy (mf.getBytes () , uploadFile);
						Accessory photo = new Accessory ();
						if (user.getPhoto () != null)
						{
							photo = user.getPhoto ();
						}
						else
						{
							photo.setAddtime (new Date ());
						}
						photo.setSize ((float) mf.getSize ());
						photo.setName (saveName);
						photo.setExt (fileExt);
						photo.setPath ("/upload/avatar");
						photo.setUserId (Long.parseLong (userId));
						photo.setAddtime (new Date ());
						if (user.getPhoto () == null)
							this.accessoryService.add (photo);
						else
						{
							this.accessoryService.updateByObject (photo);
						}
						returnPath = photo.getId () + "," + relativePath + saveName;
						AccessoryExample example = new AccessoryExample ();
						example.createCriteria ().andNameEqualTo (saveName);
						user.setPhotoId (accessoryService.getObjectList (example).get (0).getId ());
						this.userService.updateByObject (user);
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
					writer.print (returnPath);
				}
			}
		}

	/***
	 * Ajax
	 * 根据商品ID查询该商品类型
	 * 
	 * @param request
	 * @param response
	 * @param goodsId
	 */
	@RequestMapping({ "/admin/specification.htm" })
	public void specification (HttpServletRequest request , HttpServletResponse response , String goodsId)
		{
			if (goodsId != null)
			{
				Long id = new Long (0);
				id = Long.parseLong (goodsId);
				Goods gcId = goodsService.getByKey (id);
				HashMap <String, Long> map = null;
				if (gcId == null)
				{
					try
					{
						response.getWriter ().print (Json.toJson (2));	// 没有该商品
						return;
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}	// 该商品没有规格
				}
				else
				{
					map = new HashMap <String, Long> ();
					map.put ("goodsId" , id);
					map.put ("classId" , gcId.getGcId ());
				}
				List <GoodsSpecification> list = goodsSpecificationService.selectSpec (map);
				if (null != list && list.size () > 0)
				{
					for (GoodsSpecification goodsSpecification : list)
					{
						map.put ("specId" , goodsSpecification.getId ());
						List <GoodsSpecProperty> list2 = goodsSpecificationService.selectSpecAll (map);
						goodsSpecification.setProperties (list2);
					}
					try
					{
						response.getWriter ().print (Json.toJson (list));
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
					return;
				}
				else
				{
					try
					{
						response.getWriter ().print (Json.toJson (1));// 该商品没有规格
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}	
					return;
				}
			}
		}
	
	@RequestMapping({ "/buyer/buyer_upload_avatarss.htm" })
	public void upload_avatars (HttpServletRequest request , HttpServletResponse response , String userId) throws IOException
		{
			System.err.println ("user=" + userId);
			User user = userService.getByKey (Long.parseLong (userId));
			// 判断是否是上传文件表单
			boolean isMultipart = ServletFileUpload.isMultipartContent (request);	// 用于判断是那种表单
			if (isMultipart)
			{
				// 返回保存的相对路径
				String returnPath = null;
				PrintWriter writer = response.getWriter ();
				String filePath = "/data/uploadfiles/amall/upload/picture/";
				System.err.println ("filePath= " + filePath);
				String relativePath = "/upload/picture/";
				File uploadDir = new File (filePath);
				if (!uploadDir.exists ())
				{
					uploadDir.mkdirs ();
				}
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Map <String, MultipartFile> fileMap = multipartRequest.getFileMap ();
				String fileName = null;
				for (Map.Entry <String, MultipartFile> entity : fileMap.entrySet ())
				{
					// 上传文件名
					MultipartFile mf = entity.getValue ();
					fileName = mf.getOriginalFilename ();
					String fileExt = fileName.substring (fileName.lastIndexOf (".") + 1).toLowerCase ();
					if (!fileExt.equals ("jpg") && !fileExt.equals ("png"))
					{
						writer.print (returnPath);
					}
					String saveName = user.getId () + "-" + UUID.randomUUID ().toString () + "." + fileExt;
					File uploadFile = new File (filePath + saveName);
					try
					{
						FileCopyUtils.copy (mf.getBytes () , uploadFile);
						Accessory photo = new Accessory ();
						if (user.getPhoto () != null)
						{
							photo = user.getPhoto ();
						}
						else
						{
							photo.setAddtime (new Date ());
						}
						photo.setSize ((float) mf.getSize ());
						photo.setName (saveName);
						photo.setExt (fileExt);
						photo.setPath ("/upload/picture/");
						photo.setUserId (Long.parseLong (userId));
						photo.setAddtime (new Date ());
						if (user.getPhoto () == null)
							this.accessoryService.add (photo);
						else
						{
							this.accessoryService.updateByObject (photo);
						}
						returnPath = photo.getId () + "," + relativePath + saveName;
						AccessoryExample example = new AccessoryExample ();
						example.createCriteria ().andNameEqualTo (saveName);
						user.setPhotoId (accessoryService.getObjectList (example).get (0).getId ());
						this.userService.updateByObject (user);
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
					writer.print (returnPath);
				}
			}
		}
}
