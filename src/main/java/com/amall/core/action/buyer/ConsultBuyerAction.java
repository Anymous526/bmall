package com.amall.core.action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.ConsultExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IConsultService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;


/**
 * 
 * <p>Title: ConsultBuyerAction</p>
 * <p>Description: 卖家咨询列表</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月24日下午7:10:45
 * @version 1.0
 */
@Controller
public class ConsultBuyerAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IConsultService consultService;

	/**
	 * 
	 * @todo 买家咨询列表
	 * @author wsw
	 * @date 2015年7月15日 上午10:44:58
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param reply
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "买家咨询列表", value = "/buyer/consult.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心", display = false, rsequence = 0)
	@RequestMapping({ "/buyer/consult.htm" })
	public ModelAndView consult(HttpServletRequest request,
			HttpServletResponse response, String reply, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"seller/usercenter/buyer_consult.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		
		ConsultExample consultExample = new ConsultExample();
		consultExample.clear();
		consultExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		consultExample.setOrderByClause("addTime desc");
		ConsultExample.Criteria consultCriteria = consultExample.createCriteria();
		
		
		if (!CommUtil.null2String(reply).equals("")) {
			
			consultCriteria.andReplyEqualTo(Boolean.valueOf(CommUtil.null2Boolean(reply)));
			
		}
		
		consultCriteria.andConsultUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId());
		Pagination pList = consultService.getObjectListWithPage(consultExample);
		
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		mv.addObject("reply", CommUtil.null2String(reply));
		return mv;
	}
}
