package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.complaint.IComplaintService;
import com.amall.core.service.complaint.IComplaintSubjectService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: ComplaintSellerAction
 * </p>
 * <p>
 * Description: 卖家投诉管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年7月2日下午6:18:47
 * @version 1.0
 */
@Controller
public class ComplaintSellerAction
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
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICartDetailService cartDetailService;

	@SecurityMapping(title = "卖家投诉发起" , value = "/seller/complaint_handle.htm*" , rtype = "seller" , rname = "投诉管理" ,
						rcode = "complaint_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/complaint_handle.htm" })
	public ModelAndView complaint_handle (HttpServletRequest request , HttpServletResponse response , String order_id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/complaint_handle.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			OrderFormWithBLOBs of = this.orderFormService.getByKey (CommUtil.null2Long (order_id));
			Calendar calendar = Calendar.getInstance ();
			calendar.add (6 , -this.configService.getSysConfig ().getComplaintTime ());
			boolean result = true;
			if ((of.getOrderStatus () == 60) && (of.getFinishtime ().before (calendar.getTime ())))
			{
				result = false;
			}
			ComplaintExample complaintExample = new ComplaintExample ();
			complaintExample.clear ();
			ComplaintExample.Criteria complaintCriteria = complaintExample.createCriteria ();
			complaintCriteria.andOfIdEqualTo (of.getId ());
			List <ComplaintWithBLOBs> complaintlist = this.complaintService.getObjectList (complaintExample);
			of.getComplaints ().addAll (complaintlist);
			boolean result1 = true;
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
			{
				if (result1)
				{
					Cart cart = this.cartService.getByKey (of.getCiId ());
					CartDetailExample cartDetailExample = new CartDetailExample ();
					cartDetailExample.clear ();
					CartDetailExample.Criteria cartDetailCriteria = cartDetailExample.createCriteria ();
					cartDetailCriteria.andCartIdEqualTo (cart.getId ());
					List <CartDetail> cartDetailList = this.cartDetailService.getObjectList (cartDetailExample);
					cart.getCartDetailList ().addAll (cartDetailList);
					of.setCart (cart);
					ComplaintWithBLOBs obj = new ComplaintWithBLOBs ();
					obj.setFromUser (SecurityUserHolder.getCurrentUser ());
					obj.setStatus (0);
					obj.setType ("seller");
					obj.setOf (of);
					obj.setToUser (of.getUser ());
					// this.complaintService.add(obj);不需要保存，跳转后的页面保存
					mv.addObject ("obj" , obj);
					ComplaintSubjectExample complaintSubjectExample = new ComplaintSubjectExample ();
					complaintSubjectExample.clear ();
					complaintSubjectExample.createCriteria ().andTypeEqualTo ("seller");
					List <ComplaintSubject> css = complaintSubjectService.getObjectList (complaintSubjectExample);
					mv.addObject ("css" , css);
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "该订单已经投诉，不允许重复投诉");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
				}
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "该订单已经超过投诉有效期，不能投诉");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return (ModelAndView) mv;
		}

	@SecurityMapping(title = "卖家被投诉列表" , value = "/seller/complaint.htm*" , rtype = "seller" , rname = "投诉管理" ,
						rcode = "complaint_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/complaint.htm" })
	public ModelAndView complaint_seller (HttpServletRequest request , HttpServletResponse response , String currentPage , String status)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_complaint.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintExample complaintExample = new ComplaintExample ();
			complaintExample.clear ();
			complaintExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			complaintExample.setPageSize (10);
			complaintExample.setOrderByClause ("addTime desc");
			ComplaintExample.Criteria complaintCriteria = complaintExample.createCriteria ();
			complaintCriteria.andToUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			if (!CommUtil.null2String (status).equals (""))
				complaintCriteria.andStatusEqualTo (Integer.valueOf (CommUtil.null2Int (status)));
			else
			{
				complaintCriteria.andStatusLessThanOrEqualTo (Integer.valueOf (0));
			}
			Pagination pList = this.complaintService.getObjectListWithPage (complaintExample);
			String url = this.configService.getSysConfig ().getAddress ();
			if (url == null || url.equals (""))
			{
				url = CommUtil.getURL (request);
			}
			CommUtil.addIPageList2ModelAndView (url + "/seller/complaint.htm" , "" , "" , pList , mv);
			mv.addObject ("status" , status);
			return mv;
		}

	@SecurityMapping(title = "卖家查看投诉详情" , value = "/seller/complaint_view.htm*" , rtype = "seller" , rname = "投诉管理" ,
						rcode = "complaint_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/complaint_view.htm" })
	public ModelAndView complaint_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/seller_complaint_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Complaint obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			OrderFormWithBLOBs of = this.orderFormService.getByKey (obj.getOfId ());
			OrderFormItemExample orderFormItemExample = new OrderFormItemExample ();
			orderFormItemExample.clear ();
			orderFormItemExample.createCriteria ().andOrderIdEqualTo (obj.getOfId ());
			List <OrderFormItem> itemList = this.orderFormItemService.getObjectList (orderFormItemExample);
			of.getItems ().addAll (itemList);
			obj.setOf (of);
			if ((obj.getFromUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ())) || (obj.getToUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ())))
			{
				mv.addObject ("obj" , obj);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "参数错误，不存在该投诉");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/complaint.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "卖家查看投诉详情" , value = "/seller/complaint_appeal.htm*" , rtype = "seller" , rname = "投诉管理" ,
						rcode = "complaint_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/complaint_appeal.htm" })
	public ModelAndView complaint_appeal (HttpServletRequest request , HttpServletResponse response , String id , String to_user_content)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ComplaintWithBLOBs obj = this.complaintService.getByKey (CommUtil.null2Long (id));
			obj.setStatus (2);
			obj.setToUserContent (to_user_content);
			obj.setAppealTime (new Date ());
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "complaint";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				map = CommUtil.saveFileToServer (request , "img1" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory to_acc1 = new Accessory ();
					to_acc1.setName (CommUtil.null2String (map.get ("fileName")));
					to_acc1.setExt (CommUtil.null2String (map.get ("mime")));
					to_acc1.setSize (CommUtil.null2Float (map.get ("fileSize")));
					to_acc1.setPath (uploadFilePath + "/complaint");
					to_acc1.setWidth (CommUtil.null2Int (map.get ("width")));
					to_acc1.setHeight (CommUtil.null2Int (map.get ("height")));
					to_acc1.setAddtime (new Date ());
					this.accessoryService.add (to_acc1);
					obj.setToAcc1 (to_acc1);
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img2" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory to_acc2 = new Accessory ();
					to_acc2.setName (CommUtil.null2String (map.get ("fileName")));
					to_acc2.setExt (CommUtil.null2String (map.get ("mime")));
					to_acc2.setSize (CommUtil.null2Float (map.get ("fileSize")));
					to_acc2.setPath (uploadFilePath + "/complaint");
					to_acc2.setWidth (CommUtil.null2Int (map.get ("width")));
					to_acc2.setHeight (CommUtil.null2Int (map.get ("height")));
					to_acc2.setAddtime (new Date ());
					this.accessoryService.add (to_acc2);
					obj.setToAcc2 (to_acc2);
				}
				map.clear ();
				map = CommUtil.saveFileToServer (request , "img3" , saveFilePathName , null , null);
				if (!map.get ("fileName").equals (""))
				{
					Accessory to_acc3 = new Accessory ();
					to_acc3.setName (CommUtil.null2String (map.get ("fileName")));
					to_acc3.setExt (CommUtil.null2String (map.get ("mime")));
					to_acc3.setSize (CommUtil.null2Float (map.get ("fileSize")));
					to_acc3.setPath (uploadFilePath + "/complaint");
					to_acc3.setWidth (CommUtil.null2Int (map.get ("width")));
					to_acc3.setHeight (CommUtil.null2Int (map.get ("height")));
					to_acc3.setAddtime (new Date ());
					this.accessoryService.add (to_acc3);
					obj.setToAcc3 (to_acc3);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			this.complaintService.updateByObject (obj);
			mv.addObject ("op_title" , "申诉提交成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/complaint.htm");
			return mv;
		}
}
