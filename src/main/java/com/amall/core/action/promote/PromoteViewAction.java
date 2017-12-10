package com.amall.core.action.promote;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.PromoteVipHistory;
import com.amall.core.bean.PromoteVipHistoryExample;
import com.amall.core.bean.PromoteVipItem;
import com.amall.core.bean.PromoteVipItemExample;
import com.amall.core.bean.PromoteVipRank;
import com.amall.core.bean.PromoteVipRankExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.promote.IPromoteVipHistoryService;
import com.amall.core.service.promote.IPromoteVipItemService;
import com.amall.core.service.promote.IPromoteVipRankService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class PromoteViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;
	
	@Autowired
    private IPromoteVipHistoryService promoteVipHistoryService;
	
	@Autowired
    private IPromoteVipItemService promoteVipItemService;
	
	@Autowired
    private IPromoteVipRankService promoteVipRankService;

		
    /**
     * 当前月的推广排名
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/promoteCurrentRank.htm" })
	public ModelAndView promoteCurrentRank(HttpServletRequest request, HttpServletResponse response) { 
		ModelAndView mv = new JModelAndView("admin21/login.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		 
		return mv;
	}
		
    /**
     * 当前月我的推广排名
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/MyPromoteCurrentRank.htm" })
    public ModelAndView MyPromoteCurrentRank(HttpServletRequest request, HttpServletResponse response) { 
        
        User user = SecurityUserHolder.getCurrentUser(); 
        
        if(user == null)
        {
            return new ModelAndView("redirect:index.htm");
        }
        
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        
        PromoteVipRankExample example = new PromoteVipRankExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<PromoteVipRank> list = promoteVipRankService.getObjectList(example);
        
        if(!list.isEmpty())
        {
            mv.addObject("myPromote", list.get(0));
        }
        
        return mv;
    }
    
    /**
     * 指定年月推广排名
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/PromoteRankPoint.htm" })
    public ModelAndView PromoteRankPoint(HttpServletRequest request, HttpServletResponse response
      , String year, String month) 
    { 
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
         
        return mv;
    }
    
    /**
     * 推广排名历史纪录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/PromoteRankHistory.htm" })
    public ModelAndView PromoteRankHistory(HttpServletRequest request, HttpServletResponse response) 
    { 
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
         
        return mv;
    }
    
    /**
     * 我的推广排名历史纪录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/MyPromoteRankHistory.htm" })
    public ModelAndView MyPromoteRankHistory(HttpServletRequest request, HttpServletResponse response) 
    { 
        
        User user = SecurityUserHolder.getCurrentUser(); 
        
        if(user == null)
        {
            return new ModelAndView("redirect:index.htm");
        }
        
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        
        PromoteVipHistoryExample example = new PromoteVipHistoryExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<PromoteVipHistory> list = promoteVipHistoryService.getObjectList(example);
        
        if(!list.isEmpty())
        {
            mv.addObject("myPromotes", list);
        }
        
        return mv;
    }
    
    /**
     * 我的指定年月推广排名
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/MyPromoteRankPoint.htm" })
    public ModelAndView MyPromoteRankPoint(HttpServletRequest request, HttpServletResponse response
      , String year, String month) 
    { 
        User user = SecurityUserHolder.getCurrentUser(); 
        
        if(user == null)
        {
            return new ModelAndView("redirect:index.htm");
        }
        
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        
        return mv;
    }
    
    /**
     * 指定推广的人数详情
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/promotePersonPoint.htm" })
    public ModelAndView promotePersonPoint(HttpServletRequest request, HttpServletResponse response
      , String year, String month, String promoteUserId) 
    { 
        ModelAndView mv = new JModelAndView("admin21/login.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        
        PromoteVipItemExample example = new PromoteVipItemExample();
        com.amall.core.bean.PromoteVipItemExample.Criteria criteria = example.createCriteria();
        
        if(StringUtils.isNotEmpty(year))
        {
            criteria.andYearEqualTo(Integer.parseInt(year));
        }
        
        if(StringUtils.isNotEmpty(month))
        {
            criteria.andMonthEqualTo(Integer.parseInt(month));
        }
        
        if(StringUtils.isNotEmpty(promoteUserId))
        {
            criteria.andPromoteUserIdEqualTo(Long.parseLong(promoteUserId));
        }
        
        List<PromoteVipItem> list = promoteVipItemService.getObjectList(example);
        
        if(!list.isEmpty())
        {
            mv.addObject("promoteItems", list);
        }
        
        return mv;
    }
}
 
   
   