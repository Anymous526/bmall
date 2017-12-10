package com.amall.core.action.admin;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.AngelPresentationExample;
import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.doulogExample;
import com.amall.core.bean.GoldRecordExample.Criteria;
import com.amall.core.service.IRedPackgeService;
import com.amall.core.service.gold.IDoulogService;
import com.amall.core.service.gold.IGoldRecordService;
import com.amall.core.service.presentation.IAngelPresentationService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class RechargeDetailsAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoldRecordService goldService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRedPackgeService iredPackge;

	@Autowired
	private IAngelPresentationService angelService;

	@Autowired
	private IDoulogService doulogService;

	@RequestMapping({ "admin/selectGoldDetail.htm" })
	public ModelAndView selectGoldDetail (HttpServletRequest request , HttpServletResponse response , Integer currentPage , String telephone , String rechargeTime)
		{
			ModelAndView mv = new JModelAndView ("admin/select_gold_detai.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			GoldRecordExample example = new GoldRecordExample ();
			Criteria criteria = example.createCriteria ();
			Integer size = 20;
			if (StringUtils.isNotEmpty (telephone))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andUsernameEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> users = userService.getObjectList (userExample);
				if (null != users && users.size () > 0)
				{
					criteria.andGoldUserIdEqualTo (users.get (0).getId ());
				}
				else
				{
					criteria.andGoldUserIdEqualTo (0l);
				}
			}
			if (currentPage == null)
			{
				example.setPageNo (1);
			}
			else
			{
				example.setPageNo (currentPage);
			}
			example.setPageSize (size);
			if ("1".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			if ("2".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			if ("3".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddtimeGreaterThan (c.getTime ());
			}
			Pagination pList = goldService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("telephone" , telephone);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("rechargeTime" , rechargeTime);
			return mv;
		}

	@RequestMapping({ "admin/selectRedPackGeGoldDetail.htm" })
	public ModelAndView selectRedPackGeGoldDetail (HttpServletRequest request , HttpServletResponse response , Integer currentPage , String telephone , String rechargeTime)
		{
			ModelAndView mv = new JModelAndView ("admin/select_redpack_geold_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			AngelPresentationExample example = new AngelPresentationExample ();
			com.amall.core.bean.AngelPresentationExample.Criteria criteria = example.createCriteria ();
			Integer size = 20;
			if (StringUtils.isNotEmpty (telephone))
			{
				UserExample userExample = new UserExample ();
				userExample.createCriteria ().andUsernameEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> users = userService.getObjectList (userExample);
				if (users.size () > 0)
					criteria.andGetUserIdEqualTo (users.get (0).getId ());
				else
					criteria.andGetUserIdEqualTo (0l);
			}
			if (currentPage == null)
			{
				example.setPageNo (1);
			}
			else
			{
				example.setPageNo (currentPage);
			}
			example.setPageSize (size);
			if ("1".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.WEEK_OF_YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("2".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.MONTH , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			if ("3".equals (rechargeTime))
			{
				Calendar c = Calendar.getInstance ();
				c.add (Calendar.YEAR , -1);
				criteria.andAddTimeGreaterThan (c.getTime ());
			}
			Pagination pList = angelService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("telephone" , telephone);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("rechargeTime" , rechargeTime);
			return mv;
		}

	@RequestMapping({ "admin/angel_bean_details.htm" })
	public ModelAndView angel_bean_details (HttpServletResponse response , HttpServletRequest request , String telephone , Integer type , Integer currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/angel_bean_details.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			UserExample example = new UserExample ();
			doulogExample example2 = new doulogExample ();
			example.clear ();
			example2.clear ();
			com.amall.core.bean.doulogExample.Criteria criteria = example2.createCriteria ();
			if (cn.jpush.api.utils.StringUtils.isNotEmpty(telephone))
			{
				example.createCriteria ().andUsernameEqualTo (telephone).andDeletestatusEqualTo (false);
				List <User> user = userService.getObjectList (example);
				if (user.size () > 0)
					criteria.andUserIdEqualTo (user.get (0).getId ());
			}
		
			if (type != null)
			{
				if (type == 1)
				{
					criteria.andTypeEqualTo ((short)1);
				}
				else if (type == 0)
				{
					criteria.andTypeEqualTo ((short)0);
				}
			}
			if (currentPage == null)
			{
				example2.setPageNo (1);
			}
			else
			{
				example2.setPageNo (currentPage);
			}
			int pageSize = 20;
			example2.setPageSize (pageSize);
			Pagination pList = doulogService.page (example2);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("currentPage" , currentPage);
			mv.addObject ("type" , type);
			mv.addObject ("telephone" , telephone);
			return mv;
		}
}
