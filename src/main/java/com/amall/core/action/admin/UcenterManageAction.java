package com.amall.core.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: UcenterManageAction
 * </p>
 * <p>
 * Description: UC（用户中心 ucenter）配置和保存管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:11:29
 * @version 1.0
 */
@Controller
public class UcenterManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@SecurityMapping(title = "UC配置" , value = "/admin/ucenter.htm*" , rtype = "admin" , rname = "UC整合" ,
						rcode = "admin_bbs" , rgroup = "工具" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ucenter.htm" })
	public ModelAndView ucenter (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/ucenter.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "UC信息保存" , value = "/admin/ucenter_save.htm*" , rtype = "admin" , rname = "UC整合" ,
						rcode = "admin_bbs" , rgroup = "工具" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/ucenter_save.htm" })
	public ModelAndView ucenter_add (HttpServletRequest request , HttpServletResponse response , String uc_bbs , String uc_appid , String uc_api , String uc_key , String uc_ip , String uc_database_url , String uc_database_port , String uc_database_username , String uc_database_pws , String uc_database , String uc_table_preffix)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			config.setUcBbs (CommUtil.null2Boolean (uc_bbs));
			config.setUcAppid (uc_appid);
			config.setUcApi (uc_api);
			config.setUcKey (uc_key);
			config.setUcIp (uc_ip);
			config.setUcDatabaseUrl (uc_database_url);
			config.setUcDatabasePort (uc_database_port);
			config.setUcDatabaseUsername (uc_database_username);
			config.setUcDatabasePws (uc_database_pws);
			config.setUcDatabase (uc_database);
			config.setUcTablePreffix (uc_table_preffix);
			this.configService.updateByObject (config);
			mv.addObject ("op_title" , "UC配置保存成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/ucenter.htm");
			return mv;
		}
}
