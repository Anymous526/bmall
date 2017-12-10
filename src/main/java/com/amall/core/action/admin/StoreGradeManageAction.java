package com.amall.core.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.CreateBeanWrapperUtil;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.service.store.IStoreGradeService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: StoreGradeManageAction
 * </p>
 * <p>
 * Description: 店铺等级管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:14:17
 * @version 1.0
 */
@Controller
public class StoreGradeManageAction
{
	
	private Logger log=Logger.getLogger (StoreGradeManageAction.class);
	
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IStoreGradeService storegradeService;

	@SecurityMapping(title = "店铺等级列表" , value = "/admin/storegrade_list.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_list.htm" })
	public ModelAndView storegrade_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("admin/storegrade_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			// StoreGradeQueryObject qo = new StoreGradeQueryObject(currentPage, mv,orderBy,
			// orderType);
			StoreGradeExample storeGradeExample = new StoreGradeExample ();
			storeGradeExample.clear ();
			StoreGradeExample.Criteria storeGradeCriteria = storeGradeExample.createCriteria ();
			storeGradeExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			storeGradeExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			WebForm wf = new WebForm ();
			Map <String, Map <String, Object>> map = wf.toQueryPo (request , StoreGrade.class , mv);
			Iterator <String> it = map.keySet ().iterator ();
			while (it.hasNext ())
			{
				String key = it.next ().toString ();// 字段名
				Map <String, Object> map2 = map.get (key);
				Iterator <String> it2 = map2.keySet ().iterator ();
				String keys = "";// =或者like
				Object value = null;// 字段值
				if (it2.hasNext ())
				{
					keys = it2.next ().toString ();
					value = map2.get (keys);
				}
				if (key.equals ("gradename"))
				{
					if (keys.equals ("="))
					{
						storeGradeCriteria.andGradenameEqualTo (String.valueOf (value));
					}
					else if (keys.equals ("like"))
					{
						storeGradeCriteria.andGradenameLike (String.valueOf (value));
					}
				}
			}
			// wf.toQueryPo(request, qo, StoreGrade.class, mv);
			Pagination pList = this.storegradeService.getObjectListWithPage (storeGradeExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , params , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "店铺等级添加" , value = "/admin/storegrade_add.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_add.htm" })
	public ModelAndView storegrade_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/storegrade_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "店铺等级编辑" , value = "/admin/storegrade_edit.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_edit.htm" })
	public ModelAndView storegrade_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/storegrade_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				StoreGrade storegrade = this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , storegrade);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "店铺等级保存" , value = "/admin/storegrade_save.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_save.htm" })
	public ModelAndView storegrade_add (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			StoreGrade storegrade = null;
			if (id.equals (""))
			{
				storegrade = (StoreGrade) wf.toPo (request , StoreGrade.class);
				storegrade.setAddtime (new Date ());
			}
			else
			{
				StoreGrade obj = this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id)));
				storegrade = (StoreGrade) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.storegradeService.add (storegrade);
			else
				this.storegradeService.updateByObject (storegrade);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺等级成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "店铺等级删除" , value = "/admin/storegrade_del.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_del.htm" })
	public String storegrade_del (HttpServletRequest request , String mulitId , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					StoreGrade storegrade = this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.storegradeService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:storegrade_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "店铺等级AJAX更新" , value = "/admin/storegrade_ajax.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_ajax.htm" })
	public void storegrade_ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value)
		{
			StoreGrade obj = this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id)));
			Object val = null;
			try
			{
				val=CreateBeanWrapperUtil.createBeanWrapper (StoreGrade.class , obj , fieldName , value);
			}
			catch (ClassNotFoundException e1)
			{
				log.error ("javaBean对象执行动作异常，"+e1.getMessage ());

			}
			this.storegradeService.updateByObject (obj);
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

	@SuppressWarnings("deprecation")
	@SecurityMapping(title = "店铺等级模板设置" , value = "/admin/storegrade_template.htm*" , rtype = "admin" , rname = "店铺等级" ,
						rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_template.htm" })
	public ModelAndView storegrade_template (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("admin/storegrade_template.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("path" , request.getRealPath ("/"));
			mv.addObject ("obj" , this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id))));
			mv.addObject ("separator" , File.separator);
			return mv;
		}

	@SecurityMapping(title = "店铺等级模板保存" , value = "/admin/storegrade_template_add.htm*" , rtype = "admin" ,
						rname = "店铺等级" , rcode = "store_grade" , rgroup = "店铺" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/storegrade_template_add.htm" })
	public ModelAndView storegrade_template_add (HttpServletRequest request , HttpServletResponse response , String list_url , String id , String templates)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			StoreGrade grade = this.storegradeService.getByKey (Long.valueOf (Long.parseLong (id)));
			grade.setTemplates (templates);
			this.storegradeService.updateByObject (grade);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存店铺等级模板成功");
			return mv;
		}
}
