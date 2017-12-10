package com.amall.core.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreClassManageAction
 * </p>
 * <p>
 * Description: 店铺分类crud ，店铺分类下级数据加载
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-26下午9:24:49
 * @version 1.0
 */
@Controller
public class StoreClassManageAction
{
	
	private Logger log=Logger.getLogger (StoreClassManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreClassService storeclassService;

	@SecurityMapping(title = "店铺分类列表" , value = "/admin/storeclass_list.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/storeclass_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			StoreClassExample.Criteria storeClassCriteria = storeClassExample.createCriteria ();
			storeClassExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			storeClassExample.setOrderByClause (Pagination.cst ("sequence" , "asc"));
			storeClassCriteria.andParentIdIsNull ();
			Pagination pList = this.storeclassService.getObjectListWithPage (storeClassExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/storeclass_list.htm" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "店铺分类添加" , value = "/admin/storeclass_add.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String pid)
		{
			ModelAndView mv = new JModelAndView ("admin/storeclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			storeClassExample.createCriteria ().andParentIdIsNull ();
			storeClassExample.setOrderByClause ("sequence asc");
			List <StoreClass> scs = storeclassService.getObjectList (storeClassExample);
			mv.addObject ("scs" , scs);
			if ((pid != null) && (!pid.equals ("")))
			{
				StoreClass obj = new StoreClass ();
				obj.setParent (this.storeclassService.getByKey (Long.valueOf (Long.parseLong (pid))));
				mv.addObject ("obj" , obj);
			}
			return mv;
		}

	@SecurityMapping(title = "店铺分类编辑" , value = "/admin/storeclass_edit.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/storeclass_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				StoreClass storeclass = this.storeclassService.getByKey (Long.valueOf (Long.parseLong (id)));
				StoreClassExample storeClassExample = new StoreClassExample ();
				storeClassExample.clear ();
				storeClassExample.createCriteria ().andParentIdIsNull ();
				storeClassExample.setOrderByClause ("sequence asc");
				List <StoreClass> scs = storeclassService.getObjectList (storeClassExample);
				mv.addObject ("scs" , scs);
				mv.addObject ("obj" , storeclass);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "店铺分类保存" , value = "/admin/storeclass_save.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_save.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String id , String pid , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			StoreClass storeclass = null;
			if (id.equals (""))
			{
				storeclass = (StoreClass) wf.toPo (request , StoreClass.class);
				storeclass.setAddtime (new Date ());
			}
			else
			{
				StoreClass obj = this.storeclassService.getByKey (Long.valueOf (Long.parseLong (id)));
				storeclass = (StoreClass) wf.toPo (request , obj);
			}
			if ((pid != null) && (!pid.equals ("")))
			{
				StoreClass parent = this.storeclassService.getByKey (Long.valueOf (Long.parseLong (pid)));
				storeclass.setParent (parent);
				storeclass.setLevel (parent.getLevel () + 1);
			}
			if (id.equals (""))
				this.storeclassService.add (storeclass);
			else
				this.storeclassService.updateByObject (storeclass);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺分类成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage + "&pid=" + pid);
			}
			return mv;
		}

	private List <Long> genericIds (StoreClass sc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (sc.getId ());
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			storeClassExample.createCriteria ().andParentIdEqualTo (sc.getId ());
			List <StoreClass> scs = storeclassService.getObjectList (storeClassExample);
			sc.getChilds ().addAll (scs);
			for (StoreClass child : sc.getChilds ())
			{
				List <Long> cids = genericIds (child);
				for (Long cid : cids)
				{
					ids.add (cid);
				}
				ids.add (child.getId ());
			}
			return ids;
		}

	@SecurityMapping(title = "店铺分类删除" , value = "/admin/storeclass_del.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_del.htm" })
	public String delete (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					List <Long> list = genericIds (this.storeclassService.getByKey (Long.valueOf (Long.parseLong (id))));
					StoreClassExample storeClassExample = new StoreClassExample ();
					storeClassExample.clear ();
					storeClassExample.createCriteria ().andIdIn (list);
					storeClassExample.setOrderByClause ("level desc");
					List <StoreClass> scs = storeclassService.getObjectList (storeClassExample);
					for (StoreClass sc : scs)
					{
						sc.setParentId (null);
						this.storeclassService.deleteByKey (sc.getId ());
					}
				}
			}
			return "redirect:storeclass_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "店铺分类AJAX保存" , value = "/admin/storeclass_ajax.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			StoreClass obj = this.storeclassService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val=CreateBeanWrapperUtil.createBeanWrapper (StoreClass.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());

			}
			this.storeclassService.updateByObject (obj);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (val.toString ());
			}
			catch (IOException e)
			{
				log.error (e.getMessage ());
			}
		}

	@RequestMapping({ "/admin/storeclass_verify.htm" })
	public void storeclass_verify (HttpServletRequest request , HttpServletResponse response , String className , String id)
		{
			boolean ret = true;
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			storeClassExample.createCriteria ().andClassnameEqualTo (className).andIdNotEqualTo (CommUtil.null2Long (id));
			List <StoreClass> gcs = storeclassService.getObjectList (storeClassExample);
			if (gcs != null && gcs.size () > 0)
			{
				ret = false;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				log.error (e.getMessage ());
			}
		}

	@SecurityMapping(title = "店铺分类下级数据加载" , value = "/admin/storeclass_data.htm*" , rtype = "admin" , rname = "店铺分类" ,
						rcode = "store_class" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storeclass_data.htm" })
	public ModelAndView storeclass_data (HttpServletRequest request , HttpServletResponse response , String pid , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/storeclass_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreClassExample storeClassExample = new StoreClassExample ();
			storeClassExample.clear ();
			storeClassExample.createCriteria ().andParentIdEqualTo (Long.valueOf (Long.parseLong (pid)));
			List <StoreClass> gcs = storeclassService.getObjectList (storeClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}
}
