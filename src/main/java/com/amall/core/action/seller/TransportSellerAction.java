package com.amall.core.action.seller;

import java.util.ArrayList;
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
import com.amall.core.bean.TransArea;
import com.amall.core.bean.TransAreaExample;
import com.amall.core.bean.Transport;
import com.amall.core.bean.TransportExample;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.ITransAreaService;
import com.amall.core.service.ITransportService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.TransportTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: TransportSellerAction
 * </p>
 * <p>
 * Description: 卖家运费模板crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日上午10:49:57
 * @version 1.0
 */
@Controller
public class TransportSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ITransportService transportService;

	@Autowired
	private ITransAreaService transAreaService;

	@Autowired
	private IUserService userService;

	@Autowired
	private TransportTools transportTools;

	@SecurityMapping(title = "卖家运费模板列表" , value = "/seller/transport_list.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_list.htm" })
	public ModelAndView transport_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			TransportExample transportExample = new TransportExample ();
			transportExample.clear ();
			transportExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			transportExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			transportExample.createCriteria ().andStoreIdEqualTo (user.getStoreId ());
			Pagination pList = transportService.getObjectListWithPage (transportExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , params , pList , mv);
			mv.addObject ("transportTools" , this.transportTools);
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板添加" , value = "/seller/transport_add.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_add.htm" })
	public ModelAndView transport_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板编辑" , value = "/seller/transport_edit.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_edit.htm" })
	public ModelAndView transport_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				TransportWithBLOBs transport = this.transportService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , transport);
				mv.addObject ("currentPage" , currentPage);
			}
			mv.addObject ("transportTools" , this.transportTools);
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板复制" , value = "/seller/transport_copy.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_copy.htm" })
	public ModelAndView transport_copy (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				TransportWithBLOBs transport = this.transportService.getByKey (Long.valueOf (Long.parseLong (id)));
				TransportWithBLOBs obj = new TransportWithBLOBs ();
				obj.setStore (transport.getStore ());
				obj.setTransEms (transport.getTransEms ());
				obj.setTransEmsInfo (transport.getTransEmsInfo ());
				obj.setTransExpress (transport.getTransExpress ());
				obj.setTransExpressInfo (transport.getTransExpressInfo ());
				obj.setTransMail (transport.getTransMail ());
				obj.setTransMailInfo (transport.getTransMailInfo ());
				obj.setTransName (transport.getTransName ());
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			mv.addObject ("transportTools" , this.transportTools);
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板保存" , value = "/seller/transport_save.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_save.htm" })
	public String transport_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String transMail , String transExpress , String transEms , String mail_city_count , String express_city_count , String ems_city_count)
		{
			WebForm wf = new WebForm ();
			TransportWithBLOBs transport = null;
			if (id == null || id.equals (""))
			{
				transport = (TransportWithBLOBs) wf.toPo (request , TransportWithBLOBs.class);
				transport.setAddtime (new Date ());
			}
			else
			{
				TransportWithBLOBs obj = this.transportService.getByKey (Long.valueOf (Long.parseLong (id)));
				transport = (TransportWithBLOBs) wf.toPo (request , obj);
			}
			if (CommUtil.null2Boolean (transMail))
			{
				List <Map <String, Object>> trans_mail_info = new ArrayList <Map <String, Object>> ();
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("city_id" , "-1");
				map.put ("city_name" , "全国");
				map.put ("trans_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("mail_trans_weight"))));
				map.put ("trans_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("mail_trans_fee"))));
				map.put ("trans_add_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("mail_trans_add_weight"))));
				map.put ("trans_add_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("mail_trans_add_fee"))));
				trans_mail_info.add (map);
				for (int i = 1 ; i <= CommUtil.null2Int (mail_city_count) ; i++)
				{
					int trans_weight = CommUtil.null2Int (request.getParameter ("mail_trans_weight" + i));
					String city_ids = CommUtil.null2String (request.getParameter ("mail_city_ids" + i));
					if ((!city_ids.equals ("")) && (trans_weight > 0))
					{
						float trans_fee = CommUtil.null2Float (request.getParameter ("mail_trans_fee" + i));
						int trans_add_weight = CommUtil.null2Int (request.getParameter ("mail_trans_add_weight" + i));
						float trans_add_fee = CommUtil.null2Float (request.getParameter ("mail_trans_add_fee" + i));
						String city_name = CommUtil.null2String (request.getParameter ("mail_city_names" + i));
						Map <String, Object> map1 = new HashMap <String, Object> ();
						map1.put ("city_id" , city_ids);
						map1.put ("city_name" , city_name);
						map1.put ("trans_weight" , Integer.valueOf (trans_weight));
						map1.put ("trans_fee" , Float.valueOf (trans_fee));
						map1.put ("trans_add_weight" , Integer.valueOf (trans_add_weight));
						map1.put ("trans_add_fee" , Float.valueOf (trans_add_fee));
						trans_mail_info.add (map1);
					}
				}
				transport.setTransMailInfo (Json.toJson (trans_mail_info , JsonFormat.compact ()));
			}
			if (CommUtil.null2Boolean (transExpress))
			{
				List <Map <String, Object>> trans_express_info = new ArrayList <Map <String, Object>> ();
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("city_id" , "-1");
				map.put ("city_name" , "全国");
				map.put ("trans_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("express_trans_weight"))));
				map.put ("trans_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("express_trans_fee"))));
				map.put ("trans_add_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("express_trans_add_weight"))));
				map.put ("trans_add_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("express_trans_add_fee"))));
				trans_express_info.add (map);
				for (int i = 1 ; i <= CommUtil.null2Int (express_city_count) ; i++)
				{
					int trans_weight = CommUtil.null2Int (request.getParameter ("express_trans_weight" + i));
					String city_ids = CommUtil.null2String (request.getParameter ("express_city_ids" + i));
					if ((!city_ids.equals ("")) && (trans_weight > 0))
					{
						float trans_fee = CommUtil.null2Float (request.getParameter ("express_trans_fee" + i));
						int trans_add_weight = CommUtil.null2Int (request.getParameter ("express_trans_add_weight" + i));
						float trans_add_fee = CommUtil.null2Float (request.getParameter ("express_trans_add_fee" + i));
						String city_name = CommUtil.null2String (request.getParameter ("express_city_names" + i));
						Map <String, Object> map1 = new HashMap <String, Object> ();
						map1.put ("city_id" , city_ids);
						map1.put ("city_name" , city_name);
						map1.put ("trans_weight" , Integer.valueOf (trans_weight));
						map1.put ("trans_fee" , Float.valueOf (trans_fee));
						map1.put ("trans_add_weight" , Integer.valueOf (trans_add_weight));
						map1.put ("trans_add_fee" , Float.valueOf (trans_add_fee));
						trans_express_info.add (map1);
					}
				}
				transport.setTransExpressInfo (Json.toJson (trans_express_info , JsonFormat.compact ()));
			}
			if (CommUtil.null2Boolean (transEms))
			{
				List <Map <String, Object>> trans_ems_info = new ArrayList <Map <String, Object>> ();
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("city_id" , "-1");
				map.put ("city_name" , "全国");
				map.put ("trans_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("ems_trans_weight"))));
				map.put ("trans_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("ems_trans_fee"))));
				map.put ("trans_add_weight" , Integer.valueOf (CommUtil.null2Int (request.getParameter ("ems_trans_add_weight"))));
				map.put ("trans_add_fee" , Float.valueOf (CommUtil.null2Float (request.getParameter ("ems_trans_add_fee"))));
				trans_ems_info.add (map);
				for (int i = 1 ; i <= CommUtil.null2Int (ems_city_count) ; i++)
				{
					int trans_weight = CommUtil.null2Int (request.getParameter ("ems_trans_weight" + i));
					String city_ids = CommUtil.null2String (request.getParameter ("ems_city_ids" + i));
					if ((!city_ids.equals ("")) && (trans_weight > 0))
					{
						float trans_fee = CommUtil.null2Float (request.getParameter ("ems_trans_fee" + i));
						int trans_add_weight = CommUtil.null2Int (request.getParameter ("ems_trans_add_weight" + i));
						float trans_add_fee = CommUtil.null2Float (request.getParameter ("ems_trans_add_fee" + i));
						String city_name = CommUtil.null2String (request.getParameter ("ems_city_names" + i));
						Map <String, Object> map1 = new HashMap <String, Object> ();
						map1.put ("city_id" , city_ids);
						map1.put ("city_name" , city_name);
						map1.put ("trans_weight" , Integer.valueOf (trans_weight));
						map1.put ("trans_fee" , Float.valueOf (trans_fee));
						map1.put ("trans_add_weight" , Integer.valueOf (trans_add_weight));
						map1.put ("trans_add_fee" , Float.valueOf (trans_add_fee));
						trans_ems_info.add (map1);
					}
				}
				transport.setTransEmsInfo (Json.toJson (trans_ems_info , JsonFormat.compact ()));
			}
			transport.setAddtime (new Date ());
			transport.setStore (SecurityUserHolder.getCurrentUser ().getStore ());
			if (id == null || id.equals (""))
				this.transportService.add (transport);
			else
				this.transportService.updateByObject (transport);
			return "redirect:transport_success.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家运费模板保存成功" , value = "/seller/transport_success.htm*" , rtype = "seller" ,
						rname = "物流工具" , rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_success.htm" })
	public ModelAndView transport_success (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "运费模板保存成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/transport_list.htm?currentPage=" + currentPage);
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板删除" , value = "/seller/transport_del.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_del.htm" })
	public String transport_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					// Transport transport = this.transportService.getByKey (Long.valueOf
					// (Long.parseLong (id)));
					this.transportService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:transport_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家运费模板详细信息" , value = "/seller/transport_info.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_info.htm" })
	public ModelAndView transport_info (HttpServletRequest request , HttpServletResponse response , String type , String id)
		{
			if ((type == null) || (type.equals ("")))
			{
				type = CommUtil.null2String (request.getAttribute ("type"));
			}
			if ((id == null) || (id.equals ("")))
			{
				id = CommUtil.null2String (request.getAttribute ("id"));
			}
			if (CommUtil.null2String (type).equals (""))
			{
				type = "mail";
			}
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_" + type + ".html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Transport transport = this.transportService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , transport);
				mv.addObject ("transportTools" , this.transportTools);
			}
			return mv;
		}

	@SecurityMapping(title = "卖家运费模板区域编辑" , value = "/seller/transport_area.htm*" , rtype = "seller" , rname = "物流工具" ,
						rcode = "transport_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/transport_area.htm" })
	public ModelAndView transport_area (HttpServletRequest request , HttpServletResponse response , String id , String trans_city_type , String trans_index)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/transport_area.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			TransAreaExample transAreaExample = new TransAreaExample ();
			transAreaExample.clear ();
			transAreaExample.setOrderByClause ("sequence asc");
			transAreaExample.createCriteria ().andParentIdIsNull ();	// 区级
			List <TransArea> objs = transAreaService.getObjectList (transAreaExample);
			for (TransArea o : objs)
			{
				transAreaExample.clear ();
				transAreaExample.createCriteria ().andParentIdEqualTo (o.getId ());
				List <TransArea> o_c = transAreaService.getObjectList (transAreaExample);	// 省级
				for (TransArea o_cc : o_c)
				{
					transAreaExample.clear ();
					transAreaExample.createCriteria ().andParentIdEqualTo (o_cc.getId ());
					List <TransArea> o_cs = this.transAreaService.getObjectList (transAreaExample);
					o_cc.setChilds (o_cs);
				}
				o.setChilds (o_c);
			}
			mv.addObject ("objs" , objs);
			mv.addObject ("trans_city_type" , trans_city_type);
			mv.addObject ("trans_index" , trans_index);
			return mv;
		}
}
