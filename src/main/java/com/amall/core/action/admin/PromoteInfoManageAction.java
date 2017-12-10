package com.amall.core.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.PromoteInfo;
import com.amall.core.bean.PromoteInfoExample;
import com.amall.core.service.IPromoteInfoService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>Title: PromoteInfpManageAction</p>
 * <p>Description: 积分兑换</p>
 * @author	ygq
 * @date	2016年4月21日下午14:58:50
 * @version 1.0
 */
@Controller
public class PromoteInfoManageAction {
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	
	@Autowired
	private IAccessoryService accessoryService;
	
	@Autowired
	private IPromoteInfoService promoteInfoService;

	/** 
	* @Title: promote_info 
	* @Description: 推广信息
	* @param request
	* @param response
	* @param currentPage
	* @param orderBy
	* @param orderType
	* @param goodsName
	* @param isShow
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年1月26日
	*/
	@RequestMapping({ "/admin/promote_info.htm" })
	public ModelAndView promote_info(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goodsName, String isShow) {
		ModelAndView mv = new JModelAndView("admin/promote_info.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		PromoteInfo promoteInfo = promoteInfoService.getObjectList(new PromoteInfoExample()).get(0);
		
		mv.addObject("obj", promoteInfo);
		return mv;
	}
	

	@RequestMapping({ "/admin/promote_info_save.htm" })
	@ResponseBody
	public String promote_info_save(HttpServletRequest request,
			HttpServletResponse response, String id, String title,String content) {
		
		PromoteInfo promote = promoteInfoService.getByKey(CommUtil.null2Long(id));
		if(StringUtils.isNotEmpty(title)){
			promote.setTitle(title);
		}
		if(StringUtils.isNotEmpty(content)){
			promote.setContent(content);
		}
		promoteInfoService.updateByObject(promote);
		
		return "true";
	}
}
