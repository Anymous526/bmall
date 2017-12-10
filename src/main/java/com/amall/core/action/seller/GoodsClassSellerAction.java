package com.amall.core.action.seller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.User;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GoodsClassSellerAction
 * </p>
 * <p>
 * Description: 卖家商品分类crud 管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月18日上午9:53:45
 * @version 1.0
 */
@Controller
public class GoodsClassSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserGoodsClassService usergoodsclassService;

	@Autowired
	private IUserService userService;

	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "卖家商品分类列表" , value = "/seller/usergoodsclass_list.htm*" , rtype = "seller" ,
						rname = "商品分类" , rcode = "usergoodsclass_seller" , rgroup = "商品管理" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/usergoodsclass_list.htm" })
	public ModelAndView usergoodsclass_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsclass_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , UserGoodsClass.class , mv);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
				userGoodsClassExample.clear ();
				userGoodsClassExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
				userGoodsClassExample.setOrderByClause ("sequence asc");
				userGoodsClassExample.setPageSize (Integer.valueOf (20));
				userGoodsClassExample.createCriteria ().andParentIdIsNull ().andUserIdEqualTo (user.getId ());
				Pagination pList = usergoodsclassService.getObjectListWithPage (userGoodsClassExample);
				for (UserGoodsClass ug : ((List <UserGoodsClass>) (pList.getList ())))
				{
					userGoodsClassExample.clear ();
					userGoodsClassExample.createCriteria ().andParentIdEqualTo (ug.getId ()).andUserIdEqualTo (user.getId ());
					List <UserGoodsClass> c_ugs = this.usergoodsclassService.getObjectList (userGoodsClassExample);
					for (UserGoodsClass c_ug : c_ugs)
					{
						userGoodsClassExample.clear ();
						userGoodsClassExample.createCriteria ().andParentIdEqualTo (c_ug.getId ()).andUserIdEqualTo (user.getId ());
						List <UserGoodsClass> c_cugs = this.usergoodsclassService.getObjectList (userGoodsClassExample);
						c_ug.setChilds (c_cugs);
					}
					ug.setChilds (c_ugs);
				}
				CommUtil.addIPageList2ModelAndView (url + "/seller/usergoodsclass_list.htm" , "" , params , pList , mv);
			}
			return mv;
		}

	@SecurityMapping(title = "卖家商品分类保存" , value = "/seller/usergoodsclass_save.htm*" , rtype = "seller" ,
						rname = "商品分类" , rcode = "usergoodsclass_seller" , rgroup = "商品管理" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/usergoodsclass_save.htm" })
	public String usergoodsclass_save (HttpServletRequest request , HttpServletResponse response , String id , String pid)
		{
			WebForm wf = new WebForm ();
			UserGoodsClass usergoodsclass = null;
			if (id.equals (""))
			{
				usergoodsclass = (UserGoodsClass) wf.toPo (request , UserGoodsClass.class);
				usergoodsclass.setAddtime (new Date ());
			}
			else
			{
				UserGoodsClass obj = this.usergoodsclassService.getByKey (Long.valueOf (Long.parseLong (id)));
				usergoodsclass = (UserGoodsClass) wf.toPo (request , obj);
			}
			usergoodsclass.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
			if (!pid.equals (""))
			{
				UserGoodsClass parent = this.usergoodsclassService.getByKey (Long.valueOf (Long.parseLong (pid)));
				usergoodsclass.setParentId (parent.getId ());
				usergoodsclass.setParent (parent);
			}
			if (id.equals (""))
				this.usergoodsclassService.add (usergoodsclass);
			else
				this.usergoodsclassService.updateByObject (usergoodsclass);
			return "redirect:usergoodsclass_list.htm";
		}

	@SecurityMapping(title = "卖家商品分类删除" , value = "/seller/usergoodsclass_del.htm*" , rtype = "seller" ,
						rname = "商品分类" , rcode = "usergoodsclass_seller" , rgroup = "商品管理" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/usergoodsclass_del.htm" })
	public String usergoodsclass_del (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					UserGoodsClass usergoodsclass = this.usergoodsclassService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.usergoodsclassService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:usergoodsclass_list.htm";
		}

	@SecurityMapping(title = "新增卖家商品分类" , value = "/seller/address_add.htm*" , rtype = "seller" , rname = "商品分类" ,
						rcode = "usergoodsclass_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsclass_add.htm" })
	public ModelAndView usergoodsclass_add (HttpServletRequest request , HttpServletResponse response , String currentPage , String pid)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
			userGoodsClassExample.clear ();
			userGoodsClassExample.setOrderByClause ("sequence asc");
			userGoodsClassExample.createCriteria ().andParentIdIsNull ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			List <UserGoodsClass> ugcs = usergoodsclassService.getObjectList (userGoodsClassExample);
			if (!CommUtil.null2String (pid).equals (""))
			{
				UserGoodsClass parent = this.usergoodsclassService.getByKey (CommUtil.null2Long (pid));
				UserGoodsClass obj = new UserGoodsClass ();
				obj.setParent (parent);
				mv.addObject ("obj" , obj);
			}
			mv.addObject ("ugcs" , ugcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "编辑卖家商品分类" , value = "/seller/usergoodsclass_edit.htm*" , rtype = "seller" ,
						rname = "商品分类" , rcode = "usergoodsclass_seller" , rgroup = "商品管理" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/usergoodsclass_edit.htm" })
	public ModelAndView usergoodsclass_edit (HttpServletRequest request , HttpServletResponse response , String currentPage , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
			userGoodsClassExample.clear ();
			userGoodsClassExample.setOrderByClause ("sequence asc");
			userGoodsClassExample.createCriteria ().andParentIdIsNull ();
			List <UserGoodsClass> ugcs = usergoodsclassService.getObjectList (userGoodsClassExample);
			UserGoodsClass obj = this.usergoodsclassService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			mv.addObject ("ugcs" , ugcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}
}
