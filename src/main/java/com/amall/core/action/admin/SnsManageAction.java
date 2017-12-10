package com.amall.core.action.admin;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Dynamic;
import com.amall.core.bean.DynamicExample;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.IDynamicService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 会员、店铺动态
 * 
 * @author ljx
 *
 */
@Controller
public class SnsManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IDynamicService dynamicService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@SecurityMapping(title = "会员动态列表" , value = "/admin/sns_user.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sns_user.htm" })
	public ModelAndView sns_user (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String condition , String userName)
		{
			ModelAndView mv = new JModelAndView ("admin/sns_user.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			DynamicExample dynamicExample = new DynamicExample ();
			dynamicExample.clear ();
			dynamicExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			dynamicExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria ();
			dynamicCriteria.andDissparentIdIsNull ();
			if ((userName != null) && (!userName.equals ("")))
			{
				/*
				 * qo.addQuery("obj.user.userName", new SysMap("obj_userName", "%"
				 * + userName.trim() + "%"), "like");
				 */
				UserExample userExample = new UserExample ();
				userExample.clear ();
				userExample.createCriteria ().andUsernameLike ("%" + userName.trim () + "%");
				List <User> users = userService.getObjectList (userExample);
				List <Long> ids = new ArrayList <Long> ();
				for (User user : users)
				{
					ids.add (user.getId ());
				}
				if (ids != null && ids.size () != 0)
				{
					dynamicCriteria.andUserIdIn (ids);
				}
				else
				{
					dynamicCriteria.andUserIdIsNull ();
				}
				mv.addObject ("userName" , userName);
			}
			dynamicExample.setOrderByClause ("addTime desc");
			dynamicExample.setPageSize (Integer.valueOf (10));
			Pagination pList = dynamicService.getObjectListWithPage (dynamicExample);
			@SuppressWarnings("unchecked")
			List <Dynamic> dynamicList = (List <Dynamic>) pList.getList ();
			// 设置childs
			for (Dynamic dynamic : dynamicList)
			{
				dynamicExample.clear ();
				DynamicExample.Criteria dynamicCriteria2 = dynamicExample.createCriteria ();
				dynamicCriteria2.andDissparentIdEqualTo (dynamic.getId ());
				List <Dynamic> childs = dynamicService.getObjectList (dynamicExample);
				dynamic.getChilds ().addAll (childs);
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "会员动态删除" , value = "/admin/sns_del.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sns_del.htm" })
	public String sns_user_del (HttpServletRequest request , HttpServletResponse response , String currentPage , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
//				Dynamic obj = this.dynamicService.getByKey (CommUtil.null2Long (id));
				this.dynamicService.deleteByKey (CommUtil.null2Long (id));
			}
			String url = "redirect:/admin/sns_user.htm?currentPage=" + currentPage;
			return url;
		}

	@SecurityMapping(title = "店铺动态列表" , value = "/admin/sns_store.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sns_store.htm" })
	public ModelAndView sns_store (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String condition , String store_name)
		{
			ModelAndView mv = new JModelAndView ("admin/sns_store.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			DynamicExample dynamicExample = new DynamicExample ();
			dynamicExample.clear ();
			dynamicExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			dynamicExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria ();
			dynamicCriteria.andDissparentIdIsNull ();
			if ((store_name != null) && (!store_name.equals ("")))
			{
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andStoreNameLike ("%" + store_name.trim () + "%");
				List <StoreWithBLOBs> stores = storeService.getObjectList (storeExample);
				List <Long> ids = new ArrayList <Long> ();
				for (StoreWithBLOBs store : stores)
				{
					ids.add (store.getId ());
				}
				if (ids != null && ids.size () > 0)
				{
					dynamicCriteria.andStoreIdIn (ids);
				}
				else
				{
					dynamicCriteria.andStoreIdIsNull ();
				}
				mv.addObject ("store_name" , store_name);
			}
			dynamicCriteria.andStoreIdIsNotNull ();
			dynamicExample.setOrderByClause ("addTime desc");
			dynamicExample.setPageSize (Integer.valueOf (10));
			Pagination pList = dynamicService.getObjectListWithPage (dynamicExample);
			@SuppressWarnings("unchecked")
			List <Dynamic> dynamicList = (List <Dynamic>) pList.getList ();
			// 设置childs
			for (Dynamic dynamic : dynamicList)
			{
				dynamicExample.clear ();
				DynamicExample.Criteria dynamicCriteria2 = dynamicExample.createCriteria ();
				dynamicCriteria2.andDissparentIdEqualTo (dynamic.getId ());
				List <Dynamic> childs = dynamicService.getObjectList (dynamicExample);
				dynamic.getChilds ().addAll (childs);
			}
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("storeViewTools" , this.storeViewTools);
			return mv;
		}

	@SecurityMapping(title = "店铺动态删除" , value = "/admin/sns_store_del.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sns_store_del.htm" })
	public String sns_store_del (HttpServletRequest request , HttpServletResponse response , String currentPage , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
//				Dynamic obj = this.dynamicService.getByKey (CommUtil.null2Long (id));
				this.dynamicService.deleteByKey (CommUtil.null2Long (id));
			}
			String url = "redirect:/admin/sns_store.htm?currentPage=" + currentPage;
			return url;
		}

	@SecurityMapping(title = "sns动态设置可见度" , value = "/admin/sns_set_display.htm*" , rtype = "admin" , rname = "会员管理" ,
						rcode = "user_manage" , rgroup = "会员" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/sns_set_display.htm" })
	public String sns_set_display (HttpServletRequest request , HttpServletResponse response , String currentPage , String mulitId , String type , String mark)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				Dynamic obj = this.dynamicService.getByKey (CommUtil.null2Long (id));
				if (obj != null)
				{
					if (type.equals ("show"))
					{
						if (!obj.getDisplay ())
						{
							obj.setDisplay (true);
						}
					}
					else if (obj.getDisplay ())
					{
						obj.setDisplay (false);
					}
					this.dynamicService.updateByObject (obj);
				}
			}
			String url = "redirect:/admin/sns_" + mark + ".htm?currentPage=" + currentPage;
			return url;
		}
}
