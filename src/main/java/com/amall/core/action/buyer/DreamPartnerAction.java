package com.amall.core.action.buyer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerCash;
import com.amall.core.bean.DreamPartnerCashExample;
import com.amall.core.bean.DreamPartnerExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.dreampartner.IDreamPartnerService;
import com.amall.core.service.dreampartnercash.IDreamPartnerCashService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.virtual.JModelAndView;
import javassist.NotFoundException;

@Controller
public class DreamPartnerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IDreamPartnerService dreamPartnerService;

	@Autowired
	private IDreamPartnerCashService dreamPartnerCashService;

	@Autowired
	private IUserService userService;

	@RequestMapping({ "/buyer/apply_dream_partner.htm" })
	public ModelAndView apply_dream_partner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = null;
			User user = SecurityUserHolder.getCurrentUser ();
			if (isExistUserRecord (user.getId ()))
			{
				mv = new JModelAndView ("buyer/apply_dream_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("title" , "您的资料已提交，请等待审核通过");
				return mv;
			}
			mv = new JModelAndView ("buyer/apply_dream_partner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/buyer/apply_dream_partner_finish.htm" })
	public ModelAndView apply_dream_partner_finish (HttpServletRequest request , HttpServletResponse response , Long cardFrontId , Long cardBackId , String username)
		{
			ModelAndView mv = new JModelAndView ("buyer/apply_dream_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			/* 防止原表单反复刷新造成提示信息错误 */
			if (isExistUserRecord (user.getId ()))
			{
				mv.addObject ("title" , "您的资料已提交，请等待审核通过");
				return mv;
			}
			if (cardFrontId == null || cardBackId == null || username == null)
			{
				mv.addObject ("title" , "申请提交失败，证件照必须要正反面");
				return mv;
			}
			if (isExistUserRecord (user.getId ()))
			{
				mv.addObject ("title" , "申请提交失败，请勿重复申请");
				return mv;
			}
			User refUser = null;
			try
			{
				refUser = findUserOfUserName (username);
			}
			catch (NotFoundException e)
			{
				e.printStackTrace ();
				mv.addObject ("title" , "申请失败，推荐人不存在");
				return mv;
			}
			DreamPartner dreamPartner = new DreamPartner ();
			dreamPartner.setAddTime (new Date ());
			dreamPartner.setApplyUserId (user.getId ());
			dreamPartner.setReferrerUserId (refUser.getId ());
			dreamPartner.setApproveStatus (false);
			dreamPartner.setCardBackId (cardBackId);
			dreamPartner.setCardFrontId (cardFrontId);
			dreamPartnerService.add (dreamPartner);
			mv.addObject ("title" , "您的资料已提交，请等待审核通过");
			return mv;
		}

	@RequestMapping({ "/buyer/my_dream_partner.htm" })
	public ModelAndView my_dream_partner (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_dream_partner.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new ModelAndView ("redirect:/index.htm");
			}
			List <DreamPartner> tempList = getOneLowerUser (user.getId ());
			if (!tempList.isEmpty ())
			{
				mv.addObject ("objs" , tempList);
			}
			return setDreamPartnerSize (user.getId () , mv);
		}

	@RequestMapping({ "/buyer/my_dream_partner2.htm" })
	public ModelAndView my_dream_partner2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_dream_partner2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new ModelAndView ("redirect:/index.htm");
			}
			List <DreamPartner> tempList = getTwoLowerUser (getOneLowerUser (user.getId ()));
			if (!tempList.isEmpty ())
			{
				mv.addObject ("objs" , tempList);
			}
			return setDreamPartnerSize (user.getId () , mv);
		}

	@RequestMapping({ "/buyer/my_dream_partner3.htm" })
	public ModelAndView my_dream_partner3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/my_dream_partner3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new ModelAndView ("redirect:/index.htm");
			}
			List <DreamPartner> tempList = getThreeLowerUser (getTwoLowerUser (getOneLowerUser (user.getId ())));
			if (!tempList.isEmpty ())
			{
				mv.addObject ("objs" , tempList);
			}
			return setDreamPartnerSize (user.getId () , mv);
		}

	@RequestMapping({ "/buyer/dream_cash.htm" })
	public ModelAndView dream_cash (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/dream_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/buyer/dream_cash_list.htm" })
	public ModelAndView dream_cash_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/dream_cash_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user == null)
			{
				return new ModelAndView ("redirect:/index.htm");
			}
			DreamPartnerCashExample cashExample = new DreamPartnerCashExample ();
			cashExample.createCriteria ().andApplyUserIdEqualTo (user.getId ());
			List <DreamPartnerCash> list = this.dreamPartnerCashService.getObjectList (cashExample);
			if (list != null && !list.isEmpty ())
			{
				mv.addObject ("objs" , list);
			}
			return mv;
		}

	@RequestMapping({ "/buyer/dream_cash_save.htm" })
	public ModelAndView dream_cash_save (HttpServletRequest request , HttpServletResponse response)
		{
			User user = SecurityUserHolder.getCurrentUser ();
			String applyFee = request.getParameter ("applyFee");
			if (user == null)
			{
				return new ModelAndView ("redirect:/index.htm");
			}
			if (applyFee != null && !applyFee.equals (""))
			{
				/* 首先判断是否足够提现人数 */
				DreamPartnerExample example = new DreamPartnerExample ();
				example.createCriteria ().andApplyUserIdEqualTo (user.getId ());
				List <DreamPartner> list = this.dreamPartnerService.getObjectList (example);
				DreamPartner partner = list.get (0);
				int useFee = partner.getTotalFee ().subtract (partner.getUserFee () != null ? partner.getUserFee () : (new BigDecimal (0))).intValue ();
				if (useFee > Integer.valueOf (applyFee))
				{
					DreamPartnerCash cash = new DreamPartnerCash ();
					cash.setAddTime (new Date ());
					cash.setApplyFee (new BigDecimal (applyFee));
					cash.setApplyUserId (user.getId ());
					cash.setApproveStatus (false);
					this.dreamPartnerCashService.add (cash);
				}
			}
			return new ModelAndView ("redirect:dream_cash_list.htm");
		}

	private boolean isExistUserRecord (Long userId)
		{
			DreamPartnerExample example = new DreamPartnerExample ();
			example.createCriteria ().andApplyUserIdEqualTo (userId);
			List <DreamPartner> list = dreamPartnerService.getObjectList (example);
			if (list != null && !list.isEmpty ())
			{
				return true;
			}
			return false;
		}

	private User findUserOfUserName (String username) throws NotFoundException
		{
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (username);
			List <User> list = this.userService.getObjectList (example);
			if (list != null && list.size () == 1)
			{
				return list.get (0);
			}
			else
			{
				throw new NotFoundException ("username not found");
			}
		}

	/**
	 * @Title: getOneLowerUser
	 * @Description: 获取一级梦想会员
	 * @param userId
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月3日
	 */
	private List <DreamPartner> getOneLowerUser (Long userId)
		{
			DreamPartnerExample example = new DreamPartnerExample ();
			example.createCriteria ().andReferrerUserIdEqualTo (userId).andApproveStatusEqualTo (true);
			return dreamPartnerService.getObjectList (example);
		}

	/**
	 * @Title: getTwoLowerUser
	 * @Description: 获取二级梦想会员
	 * @param list
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月3日
	 */
	private List <DreamPartner> getTwoLowerUser (List <DreamPartner> list)
		{
			List <DreamPartner> retList = new ArrayList <DreamPartner> ();
			List <User> users = new ArrayList <User> ();
			/* 获取申请人列表 */
			for (DreamPartner dreamPartner : list)
			{
				users.add (dreamPartner.getApplyUser ());
			}
			/* 获取每个申请的下级 */
			for (User user : users)
			{
				List <DreamPartner> tempList = getOneLowerUser (user.getId ());
				if (tempList != null && !tempList.isEmpty ())
				{
					retList.addAll (tempList);
				}
			}
			return retList;
		}

	/**
	 * @Title: getThreeLowerUser
	 * @Description: 获取三级梦想会员
	 * @param list
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月3日
	 */
	private List <DreamPartner> getThreeLowerUser (List <DreamPartner> list)
		{
			return getTwoLowerUser (list);
		}

	/**
	 * @Title: setManyLevelDreamPartner
	 * @Description: 填充多级会员类型
	 * @param list
	 * @param type
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月3日
	 */
	private List <DreamPartner> setManyLevelDreamPartner (List <DreamPartner> list , int type)
		{
			List <DreamPartner> retList = new ArrayList <DreamPartner> ();
			/* 填充1级会员 */
			if (type == 1)
			{
				for (DreamPartner partner : list)
				{
					partner.setType ("一级梦想会员");
					retList.add (partner);
				}
			}
			/* 获取2级会员 */
			if (type == 2)
			{
				for (DreamPartner partner : list)
				{
					partner.setType ("二级梦想会员");
					retList.add (partner);
				}
			}
			/* 填充3级会员 */
			if (type == 3)
			{
				for (DreamPartner partner : list)
				{
					partner.setType ("三级梦想会员");
					retList.add (partner);
				}
			}
			return retList;
		}

	private ModelAndView setDreamPartnerSize (Long userId , ModelAndView mv)
		{
			mv.addObject ("oneSize" , getOneLowerUser (userId).size ());
			mv.addObject ("twoSize" , getTwoLowerUser (getOneLowerUser (userId)).size ());
			mv.addObject ("threeSize" , getThreeLowerUser (getTwoLowerUser (getOneLowerUser (userId))).size ());
			return mv;
		}

	private List <DreamPartner> getManyDreamPartner (Long userId)
		{
			List <DreamPartner> retList = new ArrayList <DreamPartner> ();
			/* 获取一级梦想会员 */
			List <DreamPartner> tempList = getOneLowerUser (userId);
			if (tempList == null || tempList.isEmpty ())
				return retList;
			/* 填充一级梦想会员 */
			retList.addAll (setManyLevelDreamPartner (tempList , 1));
			/* 获取二级梦想会员 */
			tempList = getTwoLowerUser (tempList);
			if (tempList == null || tempList.isEmpty ())
				return retList;
			/* 填充二级梦想会员 */
			retList.addAll (setManyLevelDreamPartner (tempList , 2));
			/* 获取三级梦想会员 */
			tempList = getThreeLowerUser (tempList);
			if (tempList == null || tempList.isEmpty ())
				return retList;
			/* 填充三级梦想会员 */
			retList.addAll (setManyLevelDreamPartner (tempList , 3));
			return retList;
		}
}
