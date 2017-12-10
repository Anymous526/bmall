package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoldLogExample;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.bean.GoldRecord;
import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.GoldRecordWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.gold.IGoldLogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GoldRecordManageAction
 * </p>
 * <p>
 * Description: 礼品金管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月4日下午8:52:03
 * @version 1.0
 */
@Controller
public class GoldRecordManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoldRecordService goldrecordService;

	@Autowired
	private IGoldLogService goldLogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IIntegralLogService integrallogService;

	@SecurityMapping(title = "礼品金购买记录" , value = "/admin/gold_record.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_record.htm" })
	public ModelAndView gold_record (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String beginTime , String endTime , String beginCount , String endCount)
		{
			ModelAndView mv = new JModelAndView ("admin/gold_record.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getGold ())
			{
				GoldRecordExample goldRecordExample = new GoldRecordExample ();
				goldRecordExample.clear ();
				GoldRecordExample.Criteria goldRecordCriteria = goldRecordExample.createCriteria ();
				goldRecordExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				goldRecordExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				// GoldRecordQueryObject qo = new GoldRecordQueryObject(currentPage,mv, orderBy,
				// orderType);
				if (!CommUtil.null2String (beginTime).equals (""))
				{
					goldRecordCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
				}
				if (!CommUtil.null2String (endTime).equals (""))
				{
					goldRecordCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
				}
				if (!CommUtil.null2String (beginCount).equals (""))
				{
					goldRecordCriteria.andGoldCountGreaterThanOrEqualTo (Integer.valueOf (CommUtil.null2Int (beginCount)));
				}
				if (!CommUtil.null2String (endCount).equals (""))
				{
					goldRecordCriteria.andGoldCountLessThanOrEqualTo (Integer.valueOf (CommUtil.null2Int (endCount)));
				}
				Pagination pList = this.goldrecordService.getObjectListWithPage (goldRecordExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("beginTime" , beginTime);
				mv.addObject ("endTime" , endTime);
				mv.addObject ("beginCount" , beginCount);
				mv.addObject ("endCount" , endCount);
			}
			else
			{
				mv = new JModelAndView ("amall/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "礼品金日志列表" , value = "/admin/gold_log.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_log.htm" })
	public ModelAndView gold_log (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String beginTime , String endTime)
		{
			ModelAndView mv = new JModelAndView ("admin/gold_log.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getGold ())
			{
				// GoldLogQueryObject qo = new GoldLogQueryObject(currentPage, mv,orderBy,
				// orderType);
				GoldLogExample goldLogExample = new GoldLogExample ();
				goldLogExample.clear ();
				GoldLogExample.Criteria goldLogCriteria = goldLogExample.createCriteria ();
				goldLogExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				goldLogExample.setOrderByClause (Pagination.cst (orderBy , orderType));
				if (!CommUtil.null2String (beginTime).equals (""))
				{
					goldLogCriteria.andAddtimeGreaterThanOrEqualTo (CommUtil.formatDate (beginTime));
				}
				if (!CommUtil.null2String (endTime).equals (""))
				{
					goldLogCriteria.andAddtimeLessThanOrEqualTo (CommUtil.formatDate (endTime));
				}
				// IPageList pList = this.goldLogService.list(qo);
				Pagination pList = this.goldLogService.getObjectListWithPage (goldLogExample);
				// CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("beginTime" , beginTime);
				mv.addObject ("endTime" , endTime);
			}
			else
			{
				mv = new JModelAndView ("amall/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "礼品金购买记录编辑" , value = "/admin/gold_record_edit.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_record_edit.htm" })
	public ModelAndView gold_record_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/gold_record_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getGold ())
			{
				if ((id != null) && (!id.equals ("")))
				{
					GoldRecord goldrecord = this.goldrecordService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (goldrecord.getGoldStatus () == 0)
					{
						mv.addObject ("obj" , goldrecord);
						mv.addObject ("currentPage" , currentPage);
					}
					else
					{
						mv = new JModelAndView ("amall/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
						mv.addObject ("op_title" , "参数错误，编辑失败");
						mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/gold_record.htm");
					}
				}
			}
			else
			{
				mv = new JModelAndView ("amall/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "礼品金购买记录" , value = "/admin/gold_record_save.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_record_save.htm" })
	public ModelAndView gold_record_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getGold ())
			{
				WebForm wf = new WebForm ();
				GoldRecordWithBLOBs goldrecord = null;
				if (id.equals (""))
				{
					goldrecord = (GoldRecordWithBLOBs) wf.toPo (request , GoldRecord.class);
					goldrecord.setAddtime (new Date ());
				}
				else
				{
					GoldRecordWithBLOBs obj = this.goldrecordService.getByKey (Long.valueOf (Long.parseLong (id)));
					goldrecord = (GoldRecordWithBLOBs) wf.toPo (request , obj);
				}
				if (goldrecord.getGoldPayStatus () == 2)
				{
					goldrecord.setGoldStatus (1);
				}
				goldrecord.setGoldAdmin (SecurityUserHolder.getCurrentUser ());
				goldrecord.setGoldAdminInfo ("管理员审核礼品金");
				goldrecord.setGoldAdminTime (new Date ());
				if (id.equals (""))
					this.goldrecordService.add (goldrecord);
				else
					this.goldrecordService.updateByObject (goldrecord);
				if (goldrecord.getGoldPayStatus () == 2)
				{
					User user = goldrecord.getGoldUser ();
					user.setGold (user.getGold () + goldrecord.getGoldCount ());
					this.userService.updateByObject (user);
					GoldLogWithBLOBs log = new GoldLogWithBLOBs ();
					log.setAddtime (new Date ());
					log.setGlAdmin (SecurityUserHolder.getCurrentUser ());
					log.setGlAdminContent (goldrecord.getGoldAdminInfo ());
					log.setGlAdminTime (new Date ());
					log.setGlContent ("管理员审核礼品金记录");
					log.setGlCount (goldrecord.getGoldCount ());
					log.setGlMoney (goldrecord.getGoldMoney ());
					log.setGlPayment (goldrecord.getGoldPayment ());
					log.setGlType (0);
					log.setGlUser (goldrecord.getGoldUser ());
					this.goldLogService.add (log);
				}
				mv.addObject ("list_url" , list_url);
				mv.addObject ("op_title" , "编辑礼品金记录成功");
			}
			else
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "礼品金购买记录删除" , value = "/admin/gold_record_del.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_record_del.htm" })
	public String gold_record_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			if (this.configService.getSysConfig ().getGold ())
			{
				String [ ] ids = mulitId.split (",");
				for (String id : ids)
				{
					if (!id.equals (""))
					{
//						GoldRecord goldrecord = this.goldrecordService.getByKey (Long.valueOf (Long.parseLong (id)));
						this.goldrecordService.deleteByKey (Long.valueOf (Long.parseLong (id)));
					}
				}
			}
			return "redirect:gold_record.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "礼品金购买记录" , value = "/admin/gold_record_view.htm*" , rtype = "admin" , rname = "礼品金管理" ,
						rcode = "gold_record_admin" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_record_view.htm" })
	public ModelAndView gold_record_view (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/gold_record_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if (this.configService.getSysConfig ().getGold ())
			{
				if ((id != null) && (!id.equals ("")))
				{
					GoldRecordWithBLOBs goldrecord = this.goldrecordService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (goldrecord.getGoldStatus () != 0)
					{
						mv.addObject ("obj" , goldrecord);
						mv.addObject ("currentPage" , currentPage);
					}
					else
					{
						mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
						mv.addObject ("op_title" , "参数错误，编辑失败");
						mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/gold_record.htm");
					}
				}
			}
			else
			{
				mv = new JModelAndView ("amall/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: user_integral
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "礼品金管理" , value = "/admin/user_integral.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_gold.htm" })
	public ModelAndView userGold (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/user_gold.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			if (!config.getGold ())
			{
				mv = new JModelAndView ("admin/error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
				mv.addObject ("op_title" , "系统未开启礼品金功能，设置失败");
				mv.addObject ("open_url" , "admin/operation_base_set.htm");
				mv.addObject ("open_op" , "礼品金开启");
				mv.addObject ("open_mark" , "operation_base_op");
				mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/welcome.htm");
			}
			return mv;
		}

	@SecurityMapping(title = "礼品金动态获取" , value = "/admin/verify_user_integral.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/verify_user_gold.htm" })
	public void verify_userGold (HttpServletRequest request , HttpServletResponse response , String userName)
		{
			User user = null;
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = userService.getObjectList (userExample);
			if (users != null && users.size () > 0)
				user = users.get (0);
			int ret = -1;
			if (user != null)
			{
				ret = user.getGold ();
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "积分管理保存" , value = "/admin/user_gold_save.htm*" , rtype = "admin" , rname = "积分管理" ,
						rcode = "user_integral" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/user_gold_save.htm" })
	public ModelAndView user_gold_save (HttpServletRequest request , HttpServletResponse response , String userName , String operate_type , String gold , String content)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample userExample = new UserExample ();
			userExample.createCriteria ().andUsernameEqualTo (userName);
			List <User> users = userService.getObjectList (userExample);
			User user = null;
			if (users != null && users.size () > 0)
			{
				user = users.get (0);
			}
			if (user != null)
			{
				int newBalance = 0;
				if (operate_type.equals ("add"))
				{
					newBalance = user.getGold () + CommUtil.null2Int (gold);
					user.setGold (newBalance);
				}
				else if (user.getGold () > CommUtil.null2Int (gold))
				{
					newBalance = user.getGold () - CommUtil.null2Int (gold);
					user.setGold (newBalance);
				}
				else
				{
					user.setGold (0);
				}
				this.userService.updateByObject (user);
				GoldRecordWithBLOBs log = new GoldRecordWithBLOBs ();
				log.setAddtime (new Date ());
				log.setGoldPayment (content);
				if (operate_type.equals ("add"))
					log.setGoldCount (CommUtil.null2Int (gold));
				else
				{
					log.setGoldCount (-CommUtil.null2Int (gold));
				}
				// log.setOperate_user(SecurityUserHolder.getCurrentUser());
				// log.setIntegral_user(user);
				log.setGoldAdminId (SecurityUserHolder.getCurrentUser ().getId ());
				log.setGoldUserId (user.getId ());
				log.setGoldSn ("system");
				this.goldrecordService.add (log);
				mv.addObject ("op_title" , "操作用户积分成功");
			}
			else
			{
				mv.addObject ("op_title" , "操作用户积分失败，会员" + userName + "不存在");
			}
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/user_gold.htm");
			return mv;
		}

	@SecurityMapping(title = "礼品金明细" , value = "/admin/integrallog_list.htm*" , rtype = "admin" , rname = "积分明细" ,
						rcode = "user_gold" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/gold_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String userName)
		{
			ModelAndView mv = new JModelAndView ("admin/gold_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			GoldRecordExample roldLogExample = new GoldRecordExample ();
			roldLogExample.clear ();
			GoldRecordExample.Criteria roldCriteria = roldLogExample.createCriteria ();
			roldLogExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			roldLogExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			UserExample userExample = new UserExample ();
			userExample.clear ();
			if ((userName != null) && (!userName.equals ("")))
				userExample.createCriteria ().andUsernameLike ("%" + userName + "%");
			List <User> users = userService.getObjectList (userExample);
			List <Long> userIds = new ArrayList <Long> ();
			for (User user2 : users)
			{
				userIds.add (user2.getId ());
			}
			if (userIds != null && userIds.size () > 0)
			{
				roldCriteria.andGoldUserIdIn (userIds);
			}
			else
			{
				roldCriteria.andGoldUserIdIsNull ();
			}
			Pagination pList = this.goldrecordService.getObjectListWithPage (roldLogExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/gold_list.htm" , "" , "&userName=" + CommUtil.null2String (userName) , pList , mv);
			return mv;
		}
}
