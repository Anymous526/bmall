package com.amall.core.action.seller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.store.IStoreNavigationService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreNavSellerAction
 * </p>
 * <p>
 * Description:卖家中心 店铺导航 crud 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月25日下午6:36:56
 * @version 1.0
 */
@Controller
public class StoreNavSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreNavigationService storenavigationService;

	@Autowired
	private IStoreService storeService;

	@SecurityMapping(title = "卖家导航管理" , value = "/seller/store_nav.htm*" , rtype = "seller" , rname = "导航管理" ,
						rcode = "store_nav_seller" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_nav.htm" })
	public ModelAndView store_nav (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_nav.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			StoreWithBLOBs store = storeService.getByKey (SecurityUserHolder.getCurrentUser ().getStoreId ());
			StoreNavigationExample navigationExample = new StoreNavigationExample ();
			navigationExample.clear ();
			navigationExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			navigationExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			navigationExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			Pagination pList = storenavigationService.getObjectListWithPage (navigationExample);
			CommUtil.addIPageList2ModelAndView (url + "/seller/store_nav.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "卖家导航添加" , value = "/seller/store_nav_add.htm*" , rtype = "seller" , rname = "导航管理" ,
						rcode = "store_nav" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_nav_add.htm" })
	public ModelAndView store_nav_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_nav_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "卖家导航编辑" , value = "/seller/store_nav_edit.htm*" , rtype = "seller" , rname = "导航管理" ,
						rcode = "store_nav" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_nav_edit.htm" })
	public ModelAndView store_nav_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/store_nav_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				StoreNavigation storenavigation = this.storenavigationService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , storenavigation);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "卖家导航保存" , value = "/seller/store_nav_save.htm*" , rtype = "seller" , rname = "导航管理" ,
						rcode = "store_nav" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_nav_save.htm" })
	public ModelAndView store_nav_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd)
		{
			WebForm wf = new WebForm ();
			StoreNavigation storenavigation = null;
			if (id.equals (""))
			{
				storenavigation = (StoreNavigation) wf.toPo (request , StoreNavigation.class);
				storenavigation.setAddtime (new Date ());
			}
			else
			{
				StoreNavigation obj = this.storenavigationService.getByKey (Long.valueOf (Long.parseLong (id)));
				storenavigation = (StoreNavigation) wf.toPo (request , obj);
			}
			// Store store = this.storeService.getObjByProperty("user.id",
			// SecurityUserHolder.getCurrentUser().getId());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
			storenavigation.setStore (store);
			if (id.equals (""))
				this.storenavigationService.add (storenavigation);
			else
				this.storenavigationService.updateByObject (storenavigation);
			ModelAndView mv = new JModelAndView ("seller/usercenter/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/store_nav.htm");
			mv.addObject ("op_title" , "保存导航成功");
			return mv;
		}

	@SecurityMapping(title = "卖家导航删除" , value = "/seller/store_nav_del.htm*" , rtype = "seller" , rname = "导航管理" ,
						rcode = "store_nav" , rgroup = "店铺设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/store_nav_del.htm" })
	public String store_nav_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					StoreNavigation storenavigation = this.storenavigationService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.storenavigationService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:store_nav.htm?currentPage=" + currentPage;
		}
}
