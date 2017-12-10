package com.amall.core.action.news;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.SystemMsgRecord;
import com.amall.core.bean.SystemMsgRecordExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.systemmsgrecord.ISystemMsgRecordService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class NewsViewAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IIntegralGoodsOrderService integralGoodsOrderService;
	
	@Autowired
	private IUserService userservice;
	
	@Autowired
	private ISystemMsgRecordService recordService;
	
	@RequestMapping({ "/news/news_notice_list.htm" })
	public ModelAndView news_notice_list(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_notice_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_1.htm" })
	public ModelAndView news_article_1(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_1.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_2.htm" })
	public ModelAndView news_article_2(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_2.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_3.htm" })
	public ModelAndView news_article_3(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_3.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_4.htm" })
	public ModelAndView news_article_4(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_4.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_5.htm" })
	public ModelAndView news_article_5(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_5.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	@RequestMapping({ "/news/news_article_6.htm" })
	public ModelAndView news_article_6(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/news_article_6.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
 
	@RequestMapping({ "/news/message_evaluate.htm" })
	public ModelAndView message_evaluate(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("news/message_evaluate.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	/** 
	* @Title: message_list 
	* @Description: 系统消息查询
	* @param request
	* @param response
	* @param currentPage
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月27日
	*/
	@RequestMapping({ "/news/message_list.htm" })
	public ModelAndView message_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = null; 
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user != null)
		{
			mv = new JModelAndView("news/message_list.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
	 
			/* 只取未读消息  */
			SystemMsgRecordExample example = new SystemMsgRecordExample();
		    example.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		    example.setOrderByClause("add_time desc, read_status asc");
		    example.createCriteria().andUserIdEqualTo(user.getId());
			Pagination pList = this.recordService.getObjectListWithPage(example);
			CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);

			return mv;
		}
		
		return new ModelAndView("redirect:/index.htm");
	}
	
	/** 
	* @Title: message_content 
	* @Description: 查看具体内容 
	* @param request
	* @param response
	* @param id
	* @return
	* @throws 
	* @author tangxiang
	* @date 2015年10月27日
	*/
	@RequestMapping({ "/news/message_content_1.htm" })
	public ModelAndView message_content(HttpServletRequest request,
			HttpServletResponse response, Long id) {
		ModelAndView mv = null; 
 
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user != null)
		{
			mv = new JModelAndView("news/message_content_1.html",
					this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			
			
			/* 当前条 */
			SystemMsgRecord msgRecord = this.recordService.getByKey(id);
			mv.addObject("currentMsg", msgRecord);
			
			SystemMsgRecordExample example = new SystemMsgRecordExample();
			example.setOrderByClause("add_time desc");
			example.createCriteria().andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId())
							.andReadStatusEqualTo(false).andIdNotEqualTo(id);
			
			List<SystemMsgRecord> list = this.recordService.getObjectList(example);
			
			/* 下一条未读消息 */
			if(list != null && !list.isEmpty())
			{
				mv.addObject("nextMsg",list.get(0));
			}
			
			/* 当前条标记为已读 */
			msgRecord.setReadStatus(true);
			msgRecord.setReadTime(new Date());
			this.recordService.updateByObject(msgRecord);
			
			return mv;
		}
		
		return new ModelAndView("redirect:/index.htm");
	}
	
	@RequestMapping({ "/news/message_del.htm" })
	public String message_del(HttpServletRequest request,
			HttpServletResponse response, Long id) {
		
		User user = SecurityUserHolder.getCurrentUser();
		
		if(user != null && id != null)
		{
			this.recordService.deleteByKey(id);
			return "redirect:/news/message_list.htm";
		}
		
		return "redirect:/index.htm";
	}
	/*我的礼品金推广*/
	@RequestMapping({ "/buyer/my_gold_spread.htm" })
	public ModelAndView my_gold_spread(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = null; 
		mv = new JModelAndView("buyer/my_gold_spread.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
 

		return mv;
	}
	
	
}



