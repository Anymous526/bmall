package com.amall.core.action.admin;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.INavigationService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 基本设置和积分规则管理
 * 
 * @author ljx
 *
 */
@Controller
public class OperationManageAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private INavigationService navigationService;

	@SecurityMapping(title = "基本设置" , value = "/admin/operation_base_set.htm*" , rtype = "admin" , rname = "基本设置" ,
						rcode = "operation_base" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/operation_base_set.htm" })
	public ModelAndView operation_base_set (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/operation_base_setting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "基本设置保存" , value = "/admin/base_set_save.htm*" , rtype = "admin" , rname = "基本设置" ,
						rcode = "operation_base" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/base_set_save.htm" })
	public ModelAndView base_set_save (HttpServletRequest request , HttpServletResponse response , String id , String integral , String integralstore , String voucher , String deposit , String gold , String goldmarketvalue , String groupbuy)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			config.setIntegral (CommUtil.null2Boolean (integral));
			config.setIntegralstore (CommUtil.null2Boolean (integralstore));
			config.setVoucher (CommUtil.null2Boolean (voucher));
			config.setDeposit (CommUtil.null2Boolean (deposit));
			config.setGold (CommUtil.null2Boolean (gold));
			config.setGoldmarketvalue (CommUtil.null2Int (goldmarketvalue));
			config.setGroupbuy (CommUtil.null2Boolean (groupbuy));
			if (id.equals (""))
				this.configService.add (config);
			else
			{
				this.configService.updateByObject (config);
			}
			if (config.getIntegralstore ())
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.createCriteria ().andUrlEqualTo ("integral.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				if (navs.size () == 0)
				{
					Navigation nav = new Navigation ();
					nav.setAddtime (new Date ());
					nav.setDisplay (true);
					nav.setLocation (0);
					nav.setNewWin (1);
					nav.setSequence (2);
					nav.setSysnav (true);
					nav.setTitle ("积分商城");
					nav.setType ("diy");
					nav.setUrl ("integral.htm");
					nav.setOriginalUrl ("integral.htm");
					this.navigationService.add (nav);
				}
			}
			else
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.createCriteria ().andUrlEqualTo ("integral.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				for (Navigation nav : navs)
				{
					this.navigationService.deleteByKey (nav.getId ());
				}
			}
			if (config.getGroupbuy ())
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.clear ();
				navigationExample.createCriteria ().andUrlEqualTo ("group.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				if (navs.size () == 0)
				{
					Navigation nav = new Navigation ();
					nav.setAddtime (new Date ());
					nav.setDisplay (true);
					nav.setLocation (0);
					nav.setNewWin (1);
					nav.setSequence (3);
					nav.setSysnav (true);
					nav.setTitle ("团购");
					nav.setType ("diy");
					nav.setUrl ("group.htm");
					nav.setOriginalUrl ("group.htm");
					this.navigationService.add (nav);
				}
			}
			else
			{
				NavigationExample navigationExample = new NavigationExample ();
				navigationExample.clear ();
				navigationExample.createCriteria ().andUrlEqualTo ("group.htm");
				List <Navigation> navs = this.navigationService.getObjectList (navigationExample);
				for (Navigation nav : navs)
				{
					this.navigationService.deleteByKey (nav.getId ());
				}
			}
			mv.addObject ("op_title" , "保存基本设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_base_set.htm");
			return mv;
		}

	@SecurityMapping(title = "积分规则" , value = "/admin/operation_integral_rule.htm*" , rtype = "admin" , rname = "积分规则" ,
						rcode = "integral_rule" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/operation_integral_rule.htm" })
	public ModelAndView integral_rule (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/operation_integral_rule.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	@SecurityMapping(title = "积分规则保存" , value = "/admin/integral_rule_save.htm*" , rtype = "admin" , rname = "积分设置" ,
						rcode = "integral_rule" , rgroup = "运营" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/integral_rule_save.htm" })
	public ModelAndView integral_rule_save (HttpServletRequest request , HttpServletResponse response , String id , String memberregister , String memberdaylogin , String indentcomment , String consumptionratio , String everyindentlimit , String goodsclasscount)
		{
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			SysConfigWithBLOBs config = this.configService.getSysConfig ();
			config.setMemberregister (CommUtil.null2Int (memberregister));
			config.setMemberdaylogin (CommUtil.null2Int (memberdaylogin));
			config.setIndentcomment (CommUtil.null2Int (indentcomment));
			config.setConsumptionratio (CommUtil.null2Int (consumptionratio));
			config.setEveryindentlimit (CommUtil.null2Int (everyindentlimit));
			config.setGoodsClassCount (CommUtil.null2Int (goodsclasscount));
			if (id.equals (""))
				this.configService.add (config);
			else
			{
				this.configService.updateByObject (config);
			}
			mv.addObject ("op_title" , "保存积分设置成功");
			mv.addObject ("list_url" , CommUtil.getURL (request) + "/admin/operation_integral_rule.htm");
			return mv;
		}
}
