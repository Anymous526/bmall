package com.amall.core.action.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amall.core.bean.RevenueExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IRevenservice;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;

@Controller
public class RenvenueAction {
	Logger logger = Logger.getLogger(LoginViewAction.class);

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	
	@Autowired
	private IRevenservice revenserVice;

	@RequestMapping({"store/incomeStatistics.htm"})
	public void incomeStatistics(HttpServletRequest request , HttpServletResponse response , String page) throws IOException{
		User user = SecurityUserHolder.getCurrentUser();
		if(user == null){
			response.getWriter().print("1");	//当前用户并未登陆
			return;
		}
		
		if(user.getStore() == null)
		{
			response.getWriter().print("2");  //当前用户不是卖家
			return;
		}
		
		RevenueExample example = new RevenueExample();
		example.createCriteria().andStoreIdEqualTo(user.getStoreId());
		int size = 5;
		if(page == null){
			example.setPageNo(1);
		}else{
			example.setPageNo(Integer.parseInt(page));
		}
		example.setPageSize(size);
		Pagination list = revenserVice.list(example);
		System.err.println(list);
		response.getWriter().print(Json.toJson(list));
		return;
		
	}
}
