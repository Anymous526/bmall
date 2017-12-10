package com.amall.core.action.presentation;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.AngelPresentation;
import com.amall.core.bean.AngelPresentationExample;
import com.amall.core.bean.AngelPresentationExample.Criteria;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.presentation.IAngelPresentationService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class AngelPresentationAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAngelPresentationService angelPresentationService;

	/* 我的红包-收到的红包 */
	@RequestMapping({ "/buyer/my_briberymoney.htm" })
	public ModelAndView my_briberymoney (HttpServletRequest request , HttpServletResponse response , String currentPage , String send)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				mv = new JModelAndView ("buyer/my_briberymoney.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				AngelPresentationExample angelPresentationExample = new AngelPresentationExample ();
				angelPresentationExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				angelPresentationExample.setPageSize (6);
				Criteria criteria = angelPresentationExample.createCriteria ();
				if ("true".equals (send))
				{
					angelPresentationExample.setOrderByClause ("add_time desc");
					criteria.andGiveUserIdEqualTo (user.getId ());
				}
				else
				{
					angelPresentationExample.setOrderByClause ("tx_status , add_time desc");
					criteria.andGetUserIdEqualTo (user.getId ());
				}
				Pagination pList = angelPresentationService.getObjectListWithPage (angelPresentationExample);
				CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
				mv.addObject ("send" , CommUtil.null2Boolean (send));
			}
			return mv;
		}

	/* 我的红包-发红包页面 */
	@RequestMapping({ "/buyer/my_briberymoney_send.htm" })
	public ModelAndView my_briberymoney_send (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				mv = new JModelAndView ("buyer/my_briberymoney_send.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/* 红包-发红包 */
	@RequestMapping({ "/send_briberymoney.htm" })
	public ModelAndView send_briberymoney (HttpServletRequest request , HttpServletResponse response , String telephone , String angelGold , String password , String giveContent)
		{
			ModelAndView mv = null;
			User giveUser = SecurityUserHolder.getCurrentUser ();
			if (giveUser == null)
			{
				mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			else
			{
				if (giveUser.getUsername ().equals (telephone))
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "不能给自己发红包");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/my_briberymoney_send.htm");
					return mv;
				}
				/*
				 * if(!giveUser.getPassword().equals(password)){
				 * mv = new JModelAndView("error.html", this.configService.getSysConfig(),
				 * this.userConfigService.getUserConfig(), 1, request, response);
				 * mv.addObject("op_title", "输入密码有误");
				 * mv.addObject("url", CommUtil.getURL(request) + "/my_briberymoney_send.htm");
				 * return mv;
				 * }
				 */
				User getUser = userService.getUserOfUserName (telephone);
				if (getUser == null)
				{
					mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "您输入的账号未注册");
					mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/my_briberymoney_send.htm");
				}
				else
				{
					if (giveUser.getGold () < Integer.parseInt (angelGold))
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "您输入的礼品金不足");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/my_briberymoney_send.htm");
					}
					else
					{
						mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						giveUser.setGold (giveUser.getGold () - Integer.parseInt (angelGold));
						userService.updateByObject (giveUser);
						AngelPresentation angelPresentation = new AngelPresentation ();
						angelPresentation.setAddTime (new Date ());
						angelPresentation.setAngelGold (Integer.parseInt (angelGold));
						angelPresentation.setGiveContent (giveContent);
						angelPresentation.setGiveUserId (giveUser.getId ());
						angelPresentation.setGetUserId (getUser.getId ());
						angelPresentation.setTxStatus (0);
						angelPresentationService.add (angelPresentation);
						mv.addObject ("op_title" , "红包发送成功");
						mv.addObject ("url" , CommUtil.getURL (request) + "/buyer/my_briberymoney_send.htm");
					}
				}
			}
			return mv;
		}

	/* 红包-领取/拒绝 */
	@RequestMapping({ "/my_briberymoney_receive.htm" })
	@ResponseBody
	public String my_briberymoney_receive (HttpServletRequest request , HttpServletResponse response , String id , String isReceive)
		{
			AngelPresentation angelPresentation = angelPresentationService.getByKey (CommUtil.null2Long (id));
			if (angelPresentation == null)
			{
				return "2";
			}
			if (angelPresentation.getTxStatus ().intValue () != 0)
			{
				return null;
			}
			if (CommUtil.null2Boolean (isReceive))
			{
				User getUser = angelPresentation.getGetUser ();
				if (getUser.getGold () != null)
				{
					getUser.setGold (getUser.getGold () + angelPresentation.getAngelGold ());
				}
				else
				{
					getUser.setGold (angelPresentation.getAngelGold ());
				}
				userService.updateByObject (getUser);
				angelPresentation.setTxStatus (1);
			}
			else
			{
				User giveUser = angelPresentation.getGiveUser ();
				giveUser.setGold (giveUser.getGold () + angelPresentation.getAngelGold ());
				userService.updateByObject (giveUser);
				angelPresentation.setTxStatus (2);
			}
			angelPresentation.setTxTime (new Date ());
			// angelPresentation.setGetContent();
			angelPresentationService.updateByObject (angelPresentation);
			return "1";
		}
}
