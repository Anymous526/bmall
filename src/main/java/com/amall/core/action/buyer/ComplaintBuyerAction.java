package com.amall.core.action.buyer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Cart;
import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.Complaint;
import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintGoods;
import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.complaint.IComplaintGoodService;
import com.amall.core.service.complaint.IComplaintService;
import com.amall.core.service.complaint.IComplaintSubjectService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: ComplaintBuyerAction
 * </p>
 * <p>
 * Description: 买家投诉列表
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月24日下午7:17:00
 * @version 1.0
 */
@Controller
public class ComplaintBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IComplaintService complaintService;

	@Autowired
	private IComplaintSubjectService complaintSubjectService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cardDetailService;

	@Autowired
	private IComplaintGoodService complaintGoodsService;

	@Autowired
	private IOrderFormItemService orderFormItemService;

	/**
	 * 
	 * @todo 买家投诉列表
	 * @author wsw
	 * @date 2015年7月15日 上午10:11:52
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param status
	 * @return
	 */
	@SecurityMapping(title = "买家投诉列表" , value = "/buyer/complaint.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint.htm" })
	public ModelAndView complaint (HttpServletRequest request , HttpServletResponse response , String currentPage , String status)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/buyer_complaint.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintExample complaintExample = new ComplaintExample ();
			complaintExample.clear ();
			complaintExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			complaintExample.setOrderByClause ("addTime desc");
			ComplaintExample.Criteria complaintCriteria = complaintExample.createCriteria ();
			complaintCriteria.andFromUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			if (!CommUtil.null2String (status).equals (""))
			{
				complaintCriteria.andStatusEqualTo (Integer.valueOf (CommUtil.null2Int (status)));
			}
			Pagination pList = complaintService.getObjectListWithPage (complaintExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("status" , status);
			return mv;
		}

	/**
	 * 
	 * @todo 买家发起投诉
	 * @author wsw
	 * @date 2015年7月15日 上午10:00:26
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param order_id
	 * @return
	 */
	@SecurityMapping(title = "买家投诉发起" , value = "/buyer/complaint_handle.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_handle.htm" })
	public ModelAndView complaint_handle (HttpServletRequest request , HttpServletResponse response , String order_id)
		{
			ModelAndView mv = new JModelAndView ("buyer/complaint_handle.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs of = this.orderFormService.getByKey (CommUtil.null2Long (order_id));
			Calendar calendar = Calendar.getInstance ();
			calendar.add (6 , -this.configService.getSysConfig ().getComplaintTime ());
			boolean result = true;
			// 当订单状态为已经结束状态, 不给予投诉
			if ((of.getOrderStatus () == 60) && (of.getFinishtime ().before (calendar.getTime ())))
			{
				result = false;
			}
			boolean result1 = true;
			// 判断该用户是否对该商品已经投诉, 如果已经投诉过 , 不给予投诉
			if (of.getComplaints ().size () > 0)
			{
				for (Complaint complaint : of.getComplaints ())
				{
					if (complaint.getFromUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
					{
						result1 = false;
					}
				}
			}
			if (result)
			{	// 该订单处于有效期
				if (result1)
				{ // 用户尚未发起投诉
					Complaint obj = new Complaint ();
					obj.setFromUser (SecurityUserHolder.getCurrentUser ());
					obj.setStatus (0);
					obj.setType ("buyer");
					Cart cart = this.cartService.getByKey (of.getCiId ());
					CartDetailExample cartDetailExample = new CartDetailExample ();
					cartDetailExample.clear ();
					CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
					cartDetailCriteria.andCartIdEqualTo (cart.getId ());
					List <CartDetail> cartDetailList = this.cardDetailService.getObjectList (cartDetailExample);
					cart.getCartDetailList ().addAll (cartDetailList);
					of.setCart (cart);
					obj.setOf (of);
					obj.setToUser (of.getStore ().getUser ());
					mv.addObject ("obj" , obj);
					ComplaintSubjectExample complaintSubjectExample = new ComplaintSubjectExample ();
					complaintSubjectExample.clear ();
					complaintSubjectExample.createCriteria ().andTypeEqualTo ("buyer");
					List <ComplaintSubject> css = complaintSubjectService.getObjectList (complaintSubjectExample);
					mv.addObject ("css" , css);
				}
				else
				{ // 用户已经发起过投诉
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "该订单已经投诉，不允许重复投诉");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/order.htm");
				}
			}
			else
			{// 订单已过有效期
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "该订单已经超过投诉有效期，不能投诉");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/order.htm");
			}
			return (ModelAndView) mv;
		}

	/**
	 * 
	 * @todo 买家投诉列表 , 在买家中心里查询
	 * @author wsw
	 * @date 2015年7月15日 上午10:05:13
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param order_id
	 * @param cs_id
	 * @param from_user_content
	 * @param goods_ids
	 * @param to_user_id
	 * @param type
	 * @return
	 */
	@SecurityMapping(title = "买家投诉保存" , value = "/buyer/complaint_save.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_save.htm" })
	public ModelAndView complaint_save (HttpServletRequest request , HttpServletResponse response , String order_id , String cs_id , String from_user_content , String goods_ids , String to_user_id , String type)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintWithBLOBs obj = new ComplaintWithBLOBs ();
			obj.setAddtime (new Date ());
			ComplaintSubject cs = this.complaintSubjectService.getByKey (CommUtil.null2Long (cs_id));
			OrderFormWithBLOBs of = this.orderFormService.getByKey (CommUtil.null2Long (order_id));
			obj.setCs (cs);
			obj.setFromUserContent (from_user_content);
			obj.setFromUser (SecurityUserHolder.getCurrentUser ());
			obj.setToUser (this.userService.getByKey (CommUtil.null2Long (to_user_id)));
			obj.setType (type);
			obj.setOf (of);
			String [ ] goods_id_list = goods_ids.split (",");
			for (String goods_id : goods_id_list)
			{
				Goods goods = this.goodsService.getByKey (CommUtil.null2Long (goods_id));
				ComplaintGoods cg = new ComplaintGoods ();
				cg.setAddtime (new Date ());
				cg.setComplaint (obj);
				cg.setGoods (goods);
				cg.setContent (CommUtil.null2String (request.getParameter ("content_" + goods_id)));
				this.complaintGoodsService.add (cg);
				obj.getCgs ().add (cg);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "complaint";
			Map<String, Object> map = new HashMap<String,Object> ();
			try
			{
				map = CommUtil.saveFileToServer (request , "img1" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory from_acc1 = new Accessory ();
					from_acc1.setName (CommUtil.null2String (map.get ("fileName")));
					from_acc1.setExt (CommUtil.null2String (map.get ("mime")));
					from_acc1.setSize (CommUtil.null2Float (map.get ("fileSize")));
					from_acc1.setPath (uploadFilePath + "/complaint");
					from_acc1.setWidth (CommUtil.null2Int (map.get ("width")));
					from_acc1.setHeight (CommUtil.null2Int (map.get ("height")));
					from_acc1.setAddtime (new Date ());
					this.accessoryService.add (from_acc1);
					obj.setFromAcc1 (from_acc1);
					obj.setFromAcc1Id (from_acc1.getId ());
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img2" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory from_acc2 = new Accessory ();
					from_acc2.setName (CommUtil.null2String (map.get ("fileName")));
					from_acc2.setExt (CommUtil.null2String (map.get ("mime")));
					from_acc2.setSize (CommUtil.null2Float (map.get ("fileSize")));
					from_acc2.setPath (uploadFilePath + "/complaint");
					from_acc2.setWidth (CommUtil.null2Int (map.get ("width")));
					from_acc2.setHeight (CommUtil.null2Int (map.get ("height")));
					from_acc2.setAddtime (new Date ());
					this.accessoryService.add (from_acc2);
					obj.setFromAcc2 (from_acc2);
					obj.setFromAcc2Id (from_acc2.getId ());
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img3" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory from_acc3 = new Accessory ();
					from_acc3.setName (CommUtil.null2String (map.get ("fileName")));
					from_acc3.setExt (CommUtil.null2String (map.get ("mime")));
					from_acc3.setSize (CommUtil.null2Float (map.get ("fileSize")));
					from_acc3.setPath (uploadFilePath + "/complaint");
					from_acc3.setWidth (CommUtil.null2Int (map.get ("width")));
					from_acc3.setHeight (CommUtil.null2Int (map.get ("height")));
					from_acc3.setAddtime (new Date ());
					this.accessoryService.add (from_acc3);
					obj.setFromAcc3 (from_acc3);
					obj.setFromAcc3Id (from_acc3.getId ());
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.complaintService.add (obj);
			mv.addObject ("op_title" , "投诉提交成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/complaint.htm");
			return (ModelAndView) mv;
		}

	/**
	 * 
	 * @todo 查看投诉详情
	 * @author wsw
	 * @date 2015年7月15日 上午10:07:49
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "买家查看投诉详情" , value = "/buyer/complaint_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_view.htm" })
	public ModelAndView complaint_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("buyer/complaint_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			if ((obj.getFromUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ())) || (obj.getToUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ())))
			{
				OrderFormWithBLOBs orderform = this.orderFormService.getByKey (obj.getOfId ());
				OrderFormItemExample orderFormItemexample = new OrderFormItemExample ();
				orderFormItemexample.clear ();
				orderFormItemexample.createCriteria ().andOrderIdEqualTo (orderform.getId ());
				List <OrderFormItem> itemList = this.orderFormItemService.getObjectList (orderFormItemexample);
				orderform.getItems ().addAll (itemList);
				/*
				 * ComplaintGoodsExample complaintGoodsExample=new ComplaintGoodsExample();
				 * complaintGoodsExample.clear();
				 * ComplaintGoodsExample.Criteria
				 * complaintGoodsCriteria=complaintGoodsExample.createCriteria();
				 * complaintGoodsCriteria.andComplaintIdEqualTo(obj.getId());
				 * List<ComplaintGoods>
				 * cgs=this.complaintGoodsService.getObjectList(complaintGoodsExample);
				 * obj.getCgs().addAll(cgs);
				 * OrderFormWithBLOBs of=obj.getOf();
				 * Long ciId=of.getCiId();
				 */
				Cart cart = this.cartService.getByKey (orderform.getCiId ());
				CartDetailExample cartDetailExample = new CartDetailExample ();
				cartDetailExample.createCriteria ();
				cartDetailExample.createCriteria ().andCartIdEqualTo (cart.getId ());
				List <CartDetail> cartDetailList = this.cardDetailService.getObjectList (cartDetailExample);
				cart.getCartDetailList ().addAll (cartDetailList);
				orderform.setCart (cart);
				obj.setOf (orderform);
				obj.setOfId (orderform.getId ());
				mv.addObject ("obj" , obj);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "参数错误，不存在该投诉");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/complaint.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @todo 买家取消投诉
	 * @author wsw
	 * @date 2015年7月15日 上午10:07:59
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "买家取消投诉" , value = "/buyer/complaint_cancel.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_cancel.htm" })
	public String complaint_cancel (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
//			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			this.complaintService.deleteByKey (CommUtil.null2Long (id));
			return "redirect:complaint.htm?currentPage=" + currentPage;
		}

	/**
	 * 
	 * @todo 投诉图片
	 * @author wsw
	 * @date 2015年7月15日 上午10:08:08
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param type
	 * @return
	 */
	@SecurityMapping(title = "投诉图片" , value = "/buyer/complaint_img.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_img.htm" })
	public ModelAndView complaint_img (HttpServletRequest request , HttpServletResponse response , String id , String type)
		{
			ModelAndView mv = new JModelAndView ("buyer/complaint_img.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Complaint obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			if (obj.getFromAcc1Id () != null)
			{
				Accessory acc1 = this.accessoryService.getByKey (obj.getFromAcc1Id ());
				obj.setFromAcc1 (acc1);
			}
			if (obj.getFromAcc2Id () != null)
			{
				Accessory acc2 = this.accessoryService.getByKey (obj.getFromAcc2Id ());
				obj.setFromAcc2 (acc2);
			}
			if (obj.getFromAcc3Id () != null)
			{
				Accessory acc3 = this.accessoryService.getByKey (obj.getFromAcc3Id ());
				obj.setFromAcc3 (acc3);
			}
			mv.addObject ("type" , type);
			mv.addObject ("obj" , obj);
			return mv;
		}

	/**
	 * 
	 * @todo 投诉对话
	 * @author wsw
	 * @date 2015年7月15日 上午10:08:15
	 * @return void
	 * @param request
	 * @param response
	 * @param id
	 * @param talk_content
	 * @throws IOException
	 */
	@SecurityMapping(title = "发布投诉对话" , value = "/buyer/complaint_talk.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_talk.htm" })
	public void complaint_talk (HttpServletRequest request , HttpServletResponse response , String id , String talk_content) throws IOException
		{
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			if (!CommUtil.null2String (talk_content).equals (""))
			{
				String user_role = "";
				if (SecurityUserHolder.getCurrentUser ().getId ().equals (obj.getFromUser ().getId ()))
				{
					user_role = "投诉人";
				}
				if (SecurityUserHolder.getCurrentUser ().getId ().equals (obj.getToUser ().getId ()))
				{
					user_role = "申诉人";
				}
				String temp = user_role + "[" + SecurityUserHolder.getCurrentUser ().getUsername () + "] " + CommUtil.formatLongDate (new Date ()) + "说: " + talk_content;
				if (obj.getTalkContent () == null)
					obj.setTalkContent (temp);
				else
				{
					obj.setTalkContent (temp + "\n\r" + obj.getTalkContent ());
				}
				this.complaintService.updateByObject (obj);
			}
			List <Map <String, String>> maps = new ArrayList <Map <String, String>> ();
			for (String s : CommUtil.str2list (obj.getTalkContent ()))
			{
				Map <String, String> map = new HashMap <String, String> ();
				map.put ("content" , s);
				if (s.indexOf ("管理员") == 0)
				{
					map.put ("role" , "admin");
				}
				if (s.indexOf ("投诉") == 0)
				{
					map.put ("role" , "from_user");
				}
				if (s.indexOf ("申诉") == 0)
				{
					map.put ("role" , "to_user");
				}
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

	/**
	 * 
	 * @todo 申诉提交仲裁
	 * @author wsw
	 * @date 2015年7月15日 上午10:08:29
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param to_user_content
	 * @return
	 */
	@SecurityMapping(title = "申诉提交仲裁" , value = "/buyer/complaint_arbitrate.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/complaint_arbitrate.htm" })
	public ModelAndView complaint_arbitrate (HttpServletRequest request , HttpServletResponse response , String id , String to_user_content)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (3);
			this.complaintService.updateByObject (obj);
			mv.addObject ("op_title" , "申诉提交仲裁成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/complaint_seller.htm");
			return mv;
		}
}
