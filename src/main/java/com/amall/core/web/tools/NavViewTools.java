package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.service.INavigationService;
import com.amall.core.service.activity.IActivityService;
import com.amall.core.service.article.IArticleService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: NavViewTools</p>
 * <p>Description: 查询导航信息  </p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015年5月15日上午9:19:50
 * @version 1.0
 */
@Component
public class NavViewTools {

	@Autowired
	private INavigationService navService;

	@Autowired
	private IArticleService articleService;

	@Autowired
	private IActivityService activityService;

	@Autowired
	private IGoodsClassService goodsClassService;
	
	/**
	 * 
	 * <p>Title: queryNav</p>
	 * <p>Description: 查询导航信息</p>
	 * @param location 参数位置
	 * @param count
	 * @return  分页包装对象
	 */
	public Pagination queryNav(int location, int count) {
		NavigationExample example = new NavigationExample();
		example.createCriteria().andDisplayEqualTo(Boolean.valueOf(true)).andLocationEqualTo(Integer.valueOf(location))
				.andTypeEqualTo("sparegoods");
		example.setOrderByClause("sequence asc");
		example.setPageNo(1);
		example.setPageSize(CommUtil.null2Int(count));
		Pagination navs = navService.getObjectListWithPage(example);
		
		/*List navs = new ArrayList();
		Map params = new HashMap();
		params.put("display", Boolean.valueOf(true));
		params.put("location", Integer.valueOf(location));
		params.put("type", "sparegoods");
		navs = this.navService.
				.query("select obj from Navigation obj where obj.display=:display and obj.location=:location and obj.type!=:type order by obj.sequence asc",
						params, 0, count);*/
		return navs;
	}
}
