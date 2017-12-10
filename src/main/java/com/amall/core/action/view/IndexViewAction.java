package com.amall.core.action.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.action.time.JobManageAction;
import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsExample;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.cloud.ICloudGoodsService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsFloorTools;
import com.amall.core.web.tools.NavViewTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 首页部分显示
 * 
 * @author ljx
 *
 */
@Controller
public class IndexViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private ICloudGoodsService cloudGoodsService;

	@Autowired
	private IAdvertService advertService;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private IGoodsFloorService goodsFloorServcie;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private GoodsFloorTools gf_tools;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IGoodsClassService goodsClassServie;

	@Autowired
	private IUserService userService;

	@Autowired
	private JobManageAction jobManageAction;

	/**
	 * 
	 * <p>
	 * Title: index
	 * </p>
	 * <p>
	 * Description: 发起请求到 index.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/index.htm" })
	public ModelAndView index (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("index.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample gce = new GoodsClassExample ();
			gce.clear ();
			gce.createCriteria ().andLevelEqualTo (1);
			List <GoodsClassWithBLOBs> gcs = this.goodsClassServie.getObjectList (gce);
			for (GoodsClassWithBLOBs gc : gcs)
			{
				gce = new GoodsClassExample ();
				gce.clear ();
				gce.createCriteria ().andParentIdEqualTo (gc.getId ());
				gc.setChilds (this.goodsClassServie.getObjectList (gce));
				break;
			}
			mv.addObject ("goodsClassList" , gcs);
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 找回密码第一步
	 * </p>
	 * <p>
	 * Description: 发起请求到password_forgot.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/password_forgot.htm" })
	public ModelAndView password_forgot (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("password_forgot.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 找回密码第二步
	 * </p>
	 * <p>
	 * Description: 发起请求到forgot_second.htm.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/forgot_second.htm" })
	public ModelAndView forgot_second (HttpServletRequest request , HttpServletResponse response , String phone , String code)
		{
			ModelAndView mv = null;
			User user = getUserOfPhone (phone);
			if (user == null)
			{
				mv = new JModelAndView ("password_forgot.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "用户不存在");
				return mv;
			}
			String genCode = (String) request.getSession ().getAttribute ("verify_code");
			code = code.toUpperCase();
			if (!code.equals (genCode))
			{
				mv = new JModelAndView ("password_forgot.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "验证码错误");
				return mv;
			}
			mv = new JModelAndView ("forgot_second.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("phone" , phone);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 找回密码第三步
	 * </p>
	 * <p>
	 * Description: 发起请求到password_forgot_third.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/password_forgot_third.htm" })
	public ModelAndView password_forgot_third (HttpServletRequest request , HttpServletResponse response , String phone , String smscode)
		{
			ModelAndView mv = null;
			String verifyCode = (String) request.getSession ().getAttribute (Globals.SMS_CODE);
			smscode = smscode.toUpperCase();
			if (verifyCode == null || !verifyCode.equals (smscode))
			{
				mv = new JModelAndView ("forgot_second.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "验证码错误");
				mv.addObject ("phone" , phone);
				return mv;
			}
			mv = new JModelAndView ("password_forgot_third.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("phone" , phone);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 找回密码最终步
	 * </p>
	 * <p>
	 * Description: 发起请求到password_forgot_third.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/password_forgot_finish.htm" })
	public ModelAndView password_forgot_finish (HttpServletRequest request , HttpServletResponse response , String phone , String password)
		{
			ModelAndView mv = null;
			if (password.equals ("") || phone.equals (""))
			{
				mv = new ModelAndView ("redirect:forgot_second.htm");
				return mv;
			}
			User user = getUserOfPhone (phone);
			if (user == null)
			{
				mv = new ModelAndView ("redirect:forgot_second.htm");
				return mv;
			}
			user.setPassword (password.trim ());
			this.userService.updateByObject (user);
			mv = new ModelAndView ("redirect:user/login.htm");
			return mv;
		}

	/* 找回支付密码 */
	@RequestMapping({ "/paymentpwd_forgot.htm" })
	public ModelAndView paymentpwd_forgot (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("paymentpwd_forgot.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 找回支付密码第二步 */
	@RequestMapping({ "/paymentpwd_forgot_second.htm" })
	public ModelAndView paymentpwd_forgot_second (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("/paymentpwd_forgot_second.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				user = userService.getByKey (user.getId ());
			}
			mv.addObject ("user" , user);
			return mv;
		}

	/* 找回支付密码第三步 */
	@RequestMapping({ "/paymentpwd_forgot_third.htm" })
	public ModelAndView paymentpwd_forgot_third (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("paymentpwd_forgot_third.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 意见反馈
	 * </p>
	 * <p>
	 * Description: 发起请求到feedbacks.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/feedbacks.htm" })
	public ModelAndView feedbacks (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("feedbacks.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: 问卷调查
	 * </p>
	 * <p>
	 * Description: 发起请求到survey.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/survey.htm" })
	public ModelAndView survey (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("survey.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: index
	 * </p>
	 * <p>
	 * Description: 发起请求到分享注册页面reg2.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/reg2.htm" })
	public ModelAndView reg2 (HttpServletRequest request , HttpServletResponse response , String pid , String did , String redno)
		{
			ModelAndView mv = null;
			if (redno == null || redno.equals (""))
			{
				mv = new ModelAndView ("redirect:register.htm");
			}
			if (pid != null && !pid.equals (""))
			{
				mv = new JModelAndView ("reg2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("pId" , pid);
				mv.addObject ("dId" , did);
				mv.addObject ("redno" , redno);
			}
			else
			{
				mv = new JModelAndView ("register.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	/**
	 * 
	 * <p>
	 * Title: index
	 * </p>
	 * <p>
	 * Description: 会员发起请求到分享注册页面reg8.htm
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/reg8.htm" , "/shareweiguide.htm" })
	public ModelAndView reg3 (HttpServletRequest request , HttpServletResponse response , String pid , String did , String redno)
		{
			ModelAndView mv = null;
			if (StringUtils.isEmpty (pid) && StringUtils.isNotEmpty (did) && StringUtils.isEmpty (redno))
			{
				// 判断did是不是整形
				if (CommUtil.isInteger (did))
				{
					// 判断did用户存不存在
					User user = this.userService.getByKey (Long.valueOf (did));
					if (user != null)
					{
						mv = new JModelAndView ("reg2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("pId" , pid);
						mv.addObject ("dId" , did);
						mv.addObject ("redno" , redno);
					}
					else
					{
						mv = new JModelAndView ("register.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					}
				}
				else
				{
					mv = new JModelAndView ("register.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				}
			}
			else
			{
				mv = new JModelAndView ("register.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			return mv;
		}

	@RequestMapping({ "/index_floor.htm" })
	public ModelAndView floor (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("index_floor.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfLevelEqualTo (Integer.valueOf (0)).andGfMarkEqualTo ("index").andParentIdIsNull ().andGfDisplayEqualTo (Boolean.valueOf (true));
			List <GoodsFloorWithBLOBs> floors = this.goodsFloorServcie.getObjectList (goodsFloorExample);
			for (int i = 0 ; i < floors.size () ; i++)
			{
				GoodsFloorWithBLOBs floor = floors.get (i);
				List <GoodsClassWithBLOBs> gcs = this.gf_tools.generic_gf_gc (floor.getGfGcList ());
				for (int j = 0 ; j < gcs.size () ; j++)
				{
					GoodsClassWithBLOBs gc = gcs.get (j);
					gc.setFirstGcImg (this.accessoryService.getByKey (CommUtil.null2Long (gc.getFirstGcImgId ())));
					for (GoodsClassWithBLOBs child : gc.getChilds ())
					{
						child.setFirstGcImg (this.accessoryService.getByKey (CommUtil.null2Long (child.getFirstGcImgId ())));
					}
				}
				floor.getGcs ().addAll (gcs);
				List <GoodsBrand> brands = this.gf_tools.generic_brand (floor.getGfBrandList ());
				for (int k = 0 ; k < brands.size () ; k++)
				{
					brands.get (k).setBrandLogo (this.accessoryService.getByKey (CommUtil.null2Long (brands.get (k).getBrandlogoId ())));
				}
				floor.setBrands (brands);
				List <GoodsClassWithBLOBs> lfs = this.gf_tools.generic_adv (floor.getGfLeftAdv ());
				List <GoodsClassWithBLOBs> leftGcs = new ArrayList <GoodsClassWithBLOBs> ();
				for (GoodsClassWithBLOBs g : lfs)
				{
					for (GoodsClassWithBLOBs c_g : g.getChilds ())
					{
						leftGcs.add (c_g);
					}
				}
				floor.setLeftGcs (leftGcs);
			}
			mv.addObject ("floors" , floors);
			mv.addObject ("gf_tools" , this.gf_tools);
			/**
			 * 底部广告位
			 */
			AdvertPositionExample advertPositionExample = new AdvertPositionExample ();
			advertPositionExample.clear ();
			advertPositionExample.setOrderByClause ("addTime desc");// 按时间逆序排列
			advertPositionExample.createCriteria ().andApMarkEqualTo ("index2");// 首页位置二的广告位
			List <AdvertPositionWithBLOBs> advertPositions = this.advertPositionService.getObjectList (advertPositionExample);
			AdvertPositionWithBLOBs advertPosition = null;
			Advert advert = null;
			if (advertPositions != null && advertPositions.size () > 0)
			{
				advertPosition = advertPositions.get (advertPositions.size () - 1);
				AdvertExample advertExample = new AdvertExample ();
				advertExample.clear ();
				advertExample.createCriteria ().andAdApIdEqualTo (advertPosition.getId ());
				advertExample.setOrderByClause ("addTime desc");
				List <Advert> adverts = this.advertService.getObjectList (advertExample);
				if (adverts != null && adverts.size () > 0)
				{
					advert = adverts.get (0);
					mv.addObject ("mvert" , advert);// 取最新的广告位
					mv.addObject ("advertPosition" , advertPosition);
				}
			}
			return mv;
		}

	/**
	 * 免费兑换楼层
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/redeemfloor.htm" })
	public ModelAndView redeemfloor (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("redeemfloor.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Date nowDate = new Date ();
			mv.addObject ("nowDate" , nowDate.getTime ());
			CloudGoodsExample cloudGoodsExample = new CloudGoodsExample ();
			cloudGoodsExample.setOrderByClause ("click_count desc");
			cloudGoodsExample.createCriteria ().andBeginTimeLessThanOrEqualTo (nowDate).andEndTimeGreaterThanOrEqualTo (nowDate).andIsShowEqualTo (true).andUserIdIsNull ().andDeletestatusEqualTo (false);
			List <CloudGoods> cloudGoodsList = this.cloudGoodsService.getObjectList (cloudGoodsExample);
			if (cloudGoodsList.size () > 8)
			{
				mv.addObject ("cloudGoodsList" , cloudGoodsList.subList (0 , 8));
			}
			else
			{
				mv.addObject ("cloudGoodsList" , cloudGoodsList);
			}
			return mv;
		}

	/**
	 * 特卖楼层
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/sale.htm" })
	public ModelAndView sale (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("sale.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andParentIdIsNull ().andGfMarkEqualTo ("bargain");
			List <GoodsFloorWithBLOBs> gfs = this.goodsFloorServcie.getObjectList (goodsFloorExample);
			for (GoodsFloorWithBLOBs gf : gfs)
			{
				goodsFloorExample.clear ();
				goodsFloorExample.createCriteria ().andGfMarkEqualTo ("bargain").andParentIdEqualTo (CommUtil.null2Long (gf.getId ()));
				gf.setChilds (this.goodsFloorServcie.getObjectList (goodsFloorExample));
			}
			mv.addObject ("gfs" , gfs);
			mv.addObject ("navTools" , this.navTools);
			mv.addObject ("gf_tools" , this.gf_tools);
			return mv;
		}

	@RequestMapping({ "/sale_load.htm" })
	public ModelAndView sale_load (HttpServletRequest request , HttpServletResponse response , String gf_id)
		{
			ModelAndView mv = new JModelAndView ("sale_load.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsFloorWithBLOBs gfs = this.goodsFloorServcie.getByKey (CommUtil.null2Long (gf_id));
			Map <String, GoodsWithBLOBs> map = new HashMap <String, GoodsWithBLOBs> ();
			List <GoodsWithBLOBs> goodsList = new ArrayList <GoodsWithBLOBs> ();
			if (gfs != null)
			{
				map = this.gf_tools.generic_goods_list (gfs.getGfListGoods ());
				for (int i = 1 ; i <= 4 ; i++)
				{
					goodsList.add ((GoodsWithBLOBs) map.get ("goods" + i));
				}
			}
			mv.addObject ("goodsList" , goodsList);
			return mv;
		}

	private User getUserOfPhone (String phone)
		{
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (phone);
			List <User> users = this.userService.getObjectList (example);
			if (users != null && !users.isEmpty ())
			{
				return users.get (Globals.NUBER_ZERO);
			}
			return null;
		}

	@RequestMapping({ "/test_benefit.htm" })
	public void test_benefit (HttpServletRequest request , HttpServletResponse response)
		{
			jobManageAction.execute ();
		}
}
