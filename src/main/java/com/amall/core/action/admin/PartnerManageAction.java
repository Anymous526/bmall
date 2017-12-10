package com.amall.core.action.admin;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Partner;
import com.amall.core.bean.PartnerExample;
import com.amall.core.service.IPartnerService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 合作伙伴crud
 * 
 * @author ljx
 *
 */
@Controller
public class PartnerManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IPartnerService partnerService;

	@Autowired
	private IAccessoryService accessoryService;

	@SecurityMapping(title = "合作伙伴列表" , value = "/admin/partner_list.htm*" , rtype = "admin" , rname = "合作伙伴" ,
						rcode = "partner_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/partner_list.htm" })
	public ModelAndView list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String title)
		{
			ModelAndView mv = new JModelAndView ("admin/partner_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			PartnerExample partnerExample = new PartnerExample ();
			partnerExample.clear ();
			partnerExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			partnerExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			PartnerExample.Criteria partnerCriteria = partnerExample.createCriteria ();
			if ((title != null) && (!title.equals ("")))
			{
				partnerCriteria.andTitleLike ("%" + title + "%");
			}
			WebForm wf = new WebForm ();
			wf.toQueryPo (request , Partner.class , mv);
			partnerExample.setOrderByClause ("sequence asc");
			Pagination pList = partnerService.getObjectListWithPage (partnerExample);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			if ((title != null) && (!title.equals ("")))
				CommUtil.addIPageList2ModelAndView (url + "/admin/partner_list.htm" , "" , "title=" + title , pList , mv);
			else
			{
				CommUtil.addIPageList2ModelAndView (url + "/admin/partner_list.htm" , "" , "" , pList , mv);
			}
			return mv;
		}

	@SecurityMapping(title = "合作伙伴添加" , value = "/admin/partner_add.htm*" , rtype = "admin" , rname = "合作伙伴" ,
						rcode = "partner_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/partner_add.htm" })
	public ModelAndView add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/partner_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "合作伙伴编辑" , value = "/admin/partner_edit.htm*" , rtype = "admin" , rname = "合作伙伴" ,
						rcode = "partner_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/partner_edit.htm" })
	public ModelAndView edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/partner_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Partner partner = this.partnerService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , partner);
				mv.addObject ("currentPage" , currentPage);
				mv.addObject ("edit" , Boolean.valueOf (true));
			}
			return mv;
		}

	@SecurityMapping(title = "合作伙伴保存" , value = "/admin/partner_save.htm*" , rtype = "admin" , rname = "合作伙伴" ,
						rcode = "partner_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/partner_save.htm" })
	public ModelAndView save (HttpServletRequest request , HttpServletResponse response , String id , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			Partner partner = null;
			if (id.equals (""))
			{
				partner = (Partner) wf.toPo (request , Partner.class);
				partner.setAddtime (new Date ());
			}
			else
			{
				Partner obj = this.partnerService.getByKey (Long.valueOf (Long.parseLong (id)));
				partner = (Partner) wf.toPo (request , obj);
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath;
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = partner.getImage () == null ? "" : partner.getImage ().getName ();
				map = CommUtil.saveFileToServer (request , "image" , saveFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName (CommUtil.null2String (map.get ("fileName")));
						photo.setExt (CommUtil.null2String (map.get ("mime")));
						photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
						photo.setPath (uploadFilePath);
						photo.setWidth (CommUtil.null2Int (map.get ("width")));
						photo.setHeight (CommUtil.null2Int (map.get ("height")));
						photo.setAddtime (new Date ());
						this.accessoryService.add (photo);
						partner.setImage (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = partner.getImage ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath);
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			if (id.equals (""))
				this.partnerService.add (partner);
			else
				this.partnerService.updateByObject (partner);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存合作伙伴成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url);
			}
			return mv;
		}

	@SecurityMapping(title = "合作伙伴删除" , value = "/admin/partner_del.htm*" , rtype = "admin" , rname = "合作伙伴" ,
						rcode = "partner_manage" , rgroup = "网站" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/partner_del.htm" })
	public String delete (HttpServletRequest request , String mulitId)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					Partner partner = this.partnerService.getByKey (Long.valueOf (Long.parseLong (id)));
					CommUtil.del_acc (request , partner.getImage () , this.configService.getSysConfig ().getUploadRootPath ());
					this.partnerService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:partner_list.htm";
		}
}
