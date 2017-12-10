package com.amall.core.action.view;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.BuZhu;
import com.amall.core.bean.BuZhuExample;
import com.amall.core.bean.CityPartNerSum;
import com.amall.core.bean.CityPartNerSumExample;
import com.amall.core.bean.FengHong;
import com.amall.core.bean.FengHongExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.ICityService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class PartnerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ICityService iCityService;

	@Autowired
	private IUserService userService;

	@RequestMapping({ "/city_partner_total.htm" })
	public ModelAndView cityPartnerTotal (HttpServletRequest request , HttpServletResponse response , String identity , Integer page)
		{
			ModelAndView md = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				md = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return md;
			}
			BigDecimal fh = new BigDecimal (0.0);
			BigDecimal bz = new BigDecimal (0.0);
			BigDecimal ze = new BigDecimal (0.0);
			List <FengHong> fenghong = null;
			List <BuZhu> list = null;
			if (identity != null && !identity.equals (""))
			{
				System.out.println (user.getId ());
				CityPartNerSumExample examples = new CityPartNerSumExample ();
				examples.createCriteria ().andUseridEqualTo (user.getId ());
				List <CityPartNerSum> cityNerSums = iCityService.selectyueji (examples);
				if (identity.equals ("1"))
				{
					md = new JModelAndView ("buyer/city_partner_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					FengHongExample example = new FengHongExample ();
					example.createCriteria ().andGetUserIdEqualTo (user.getId ());
					example.setOrderByClause ("add_time desc");
					fenghong = userService.selectFengHong (example);
					CityPartNerSumExample exampleh = new CityPartNerSumExample ();
					exampleh.createCriteria ().andUseridEqualTo (user.getId ());
					exampleh.setOrderByClause ("month desc");
					List <CityPartNerSum> cityPartNerSums = iCityService.selectyueji (exampleh);
					for (CityPartNerSum fengHong2 : cityPartNerSums)
					{
						fh = fh.add (fengHong2.getFenhong ());
						System.out.println ("fh=" + fh);
					}
					md.addObject ("cityNerSums" , cityNerSums);
					md.addObject ("fh" , fh);
					md.addObject ("fenghong" , fenghong);
					return md;
				}
				else if (identity.equals ("0"))
				{
					md = new JModelAndView ("buyer/city_partner_list2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					// 补助明细
					BuZhuExample example = new BuZhuExample ();
					example.createCriteria ().andGetUserIdEqualTo (user.getId ());
					example.setOrderByClause (" add_time desc");
					list = userService.selectBuZhu (example);
					CityPartNerSumExample exampless = new CityPartNerSumExample ();
					exampless.createCriteria ().andUseridEqualTo (user.getId ());
					exampless.setOrderByClause ("month desc");
					List <CityPartNerSum> cityPartNerSums = iCityService.selectyueji (exampless);
					for (CityPartNerSum buZhu : cityPartNerSums)
					{
						bz = bz.add (buZhu.getBuzhu ());
						System.out.println ("bz=" + bz);
					}
					md.addObject ("cityNerSums" , cityNerSums);
					md.addObject ("buZhu" , list);
					md.addObject ("bz" , bz);
					return md;
				}
				else if (identity.equals ("2"))
				{
					md = new JModelAndView ("buyer/city_partner_total.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					CityPartNerSumExample example = new CityPartNerSumExample ();
					example.createCriteria ().andUseridEqualTo (user.getId ());
					// int count = iCityService.count(example);
					/*
					 * int totalPage = (count + 8 -1) / 8;
					 * if(page>totalPage){
					 * example.setOrderByClause("month desc "+CommUtil.null2Int((totalPage-1)*8)+" "+
					 * 8);
					 * }else{
					 * example.setOrderByClause("month desc "+CommUtil.null2Int((page-1)*8)+" "+8);
					 * }
					 */
					List <CityPartNerSum> cityPartNerSums = iCityService.selectyueji (example);
					for (CityPartNerSum zes : cityPartNerSums)
					{
						bz = bz.add (zes.getBuzhu ());
						fh = fh.add (zes.getFenhong ());
					}
					ze = fh.add (bz);
					System.out.println ("ze=" + ze);
					md.addObject ("ze" , ze);
					md.addObject ("cityNerSums" , cityNerSums);
					md.addObject ("cityNerSums" , cityPartNerSums);
					md.addObject ("page" , page);
					return md;
				}
			}
			else
			{
				// 返回一个未知错误
				md.addObject ("msg" , "系统正在维护");
				return md;
			}
			return md;
		}
}
