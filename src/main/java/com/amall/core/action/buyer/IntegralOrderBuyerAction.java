package com.amall.core.action.buyer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.bean.IntegralLogExample;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : IntegralOrderBuyerAction
 *
 * Description : 免费兑换订单
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月17日 下午3:44:24
 *
 */
@Controller
public class IntegralOrderBuyerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private IGoldLogService goldLogService;

	@Autowired
	private IGoldRecordService goldrecordService;

	@Autowired
	private IKuaidiService kuaidiService;

	/**
	 * 
	 * @todo 买家积分列表
	 * @author wsw
	 * @date 2015年7月15日 上午11:16:48
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "买家积分列表" , value = "/buyer/integral_order_list.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/integral_order_list.htm" })
	public ModelAndView integral_order_list (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/integral_order_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			user = this.userService.getByKey (user.getId ());
			mv.addObject ("user" , user);
			if (this.configService.getSysConfig ().getIntegralstore ())
			{ // 积分商城已开启
				IntegralLogExample integralLogExample = new IntegralLogExample ();
				integralLogExample.clear ();
				integralLogExample.setPageNo (CommUtil.null2Int (currentPage));
				integralLogExample.setPageSize (26);
				integralLogExample.setOrderByClause ("addTime desc");
				integralLogExample.createCriteria ().andIntegralUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				Pagination pList = this.integralLogService.getObjectListWithPage (integralLogExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "系统未开启积分商城");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/buyer_index.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @todo 用户积分订单查看
	 * @author wsw
	 * @date 2015年7月13日 上午11:33:14
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/buyer/integral_order.htm" })
	public ModelAndView integral_ordel (HttpServletRequest request , HttpServletResponse response , String currentPage , String igo_order_sn)
		{
			ModelAndView mv = new JModelAndView ("buyer/integral_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				IntegralGoodsOrderExample example = new IntegralGoodsOrderExample ();
				example.clear ();
				example.setOrderByClause ("addTime desc");
				example.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				example.setPageSize (6);
				IntegralGoodsOrderExample.Criteria igoCriteria = example.createCriteria ();
				igoCriteria.andIgoUserIdEqualTo (user.getId ()).andDeletestatusEqualTo (false);
				if (!CommUtil.null2String (igo_order_sn).equals (""))
				{
					igoCriteria.andIgoOrderSnLike (igo_order_sn);
				}
				String url = this.configService.getSysConfig ().getAddress ();
				if (url == null || url.equals (""))
					url = CommUtil.getURL (request);
				String aJax_url = url + "/buyer/integral_order.htm";
				Pagination pList = this.integralGoodsOrderService.getObjectListWithPage (example);
				CommUtil.addIPageList2ModelAndView (aJax_url , "" , "" , pList , mv);
			}
			return mv;
		}

	@SecurityMapping(title = "免费兑换物流详情" , value = "/buyer/igGoods_ship_view.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/igGoods_ship_view.htm" })
	@ResponseBody
	public String igGoods_ship_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			IntegralGoodsOrderWithBLOBs igo = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			Map <String, Object> map = new HashMap <> ();
			if (igo != null)
			{
				if (igo.getIgoUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
				{
					map.put ("obj" , igo);
					String kuaidiNum = igo.getIgoShipCode ();
					List <KuaiDiResultItem> item = this.kuaidiService.getKuaidiInfo (kuaidiNum);
					map.put ("transInfo" , item);
					// map.put("kuaidiStatus", kuaidiStatus);
					map.put ("status" , true);
				}
				else
				{
					map.put ("status" , false);
					map.put ("msg" , "您查询的物流不存在！");
				}
			}
			else
			{
				map.put ("status" , false);
				map.put ("msg" , "您查询的物流不存在！");
			}
			String mapJson = Json.toJson (map);
			return mapJson;
		}

	@SecurityMapping(title = "买家删除已完成兑换订单" , value = "buyer/integral_order_del.htm*" , rtype = "seller" ,
						rname = "订单管理" , rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "buyer/integral_order_del.htm" })
	public ModelAndView integral_order_del (HttpServletRequest request , HttpServletResponse response , Long id , String currentPage)
		{
			ModelAndView mv = null;
			IntegralGoodsOrderWithBLOBs order = this.integralGoodsOrderService.getByKey (id);
			if (id == null || order == null)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm?currentPage=" + currentPage);
			}
			else
			{
				if (order.getIgoStatus () == 40)
				{
					order.setDeletestatus (true);
					this.integralGoodsOrderService.updateByObject (order);
					mv = new ModelAndView ("redirect:/buyer/integral_order.htm?currentPage=" + currentPage);
				}
				else
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您编号为" + id + "的订单未完成！");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm?currentPage=" + currentPage);
				}
			}
			return mv;
		}

	@SecurityMapping(title = "买家免费订单详情" , value = "buyer/integral_order_view.htm*" , rtype = "seller" , rname = "订单管理" ,
						rcode = "order_seller" , rgroup = "交易管理" , display = false , rsequence = 0)
	@RequestMapping({ "buyer/integral_order_view.htm" })
	public ModelAndView integral_order_view (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("integral_order_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			IntegralGoodsOrderWithBLOBs obj = integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (SecurityUserHolder.getCurrentUser ().getId ().equals (obj.getIgoUserId ()))
			{
				mv.addObject ("obj" , obj);
				// 物流信息
				List <KuaiDiResultItem> transInfo = kuaidiService.getKuaidiInfo (obj.getIgoShipCode ());
				mv.addObject ("transInfo" , transInfo);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您店铺中没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/order.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:58:38
	 * @todo 积分商品收货确认页面的跳转
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "收货确认" , value = "/buyer/integral_order_cofirm.htm*" , rtype = "buyer" , rname = "用户中心" ,
						rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/integral_order_cofirm.htm" })
	public ModelAndView integral_order_cofirm (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("buyer/integral_order_cofirm.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			// 根据前台传来的id 获取该用户是否存在该订单
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (obj.getIgoUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				mv.addObject ("obj" , obj);
				mv.addObject ("currentPage" , currentPage);
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm");
			}
			return mv;
		}

	/**
	 * 
	 * @author wsw
	 * @date 2015年6月13日 下午2:58:08
	 * @todo 确认收货 ,保存,并写入到日志
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "收货确认保存" , value = "/buyer/integral_order_cofirm_save.htm*" , rtype = "buyer" ,
						rname = "用户中心" , rcode = "user_center" , rgroup = "用户中心" , display = false , rsequence = 0)
	@RequestMapping({ "/buyer/integral_order_cofirm_save.htm" })
	public ModelAndView integral_order_cofirm_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage) throws Exception
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			IntegralGoodsOrderWithBLOBs obj = this.integralGoodsOrderService.getByKey (CommUtil.null2Long (id));
			if (obj != null)
			{
				if (obj.getIgoUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
				{
					obj.setIgoStatus (40);
					this.integralGoodsOrderService.updateByObject (obj);
					mv.addObject ("op_title" , "确认收货成功");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm");
					return mv;
				}
			}
			mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "您没有编号为" + id + "的订单！");
			mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/integral_order.htm?currentPage=" + currentPage);
			return mv;
		}
}
