package com.amall.core.action.admin21;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.IStoreStatService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.StatTools;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class AdminTest
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IIntegralLogService integralLogService;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private IStoreStatService storeStatService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private StatTools statTools;

	/* 管理员登录 */
	@RequestMapping({ "/ad/login.htm" })
	public ModelAndView login (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 管理首页 */
	@RequestMapping({ "/ad/menu.htm" })
	public ModelAndView menu (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/menu.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 首页内容 */
	@RequestMapping({ "/ad/main.htm" })
	public ModelAndView main (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/main.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员管理 */
	@RequestMapping({ "/ad/member.htm" })
	public ModelAndView member (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/member.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员编辑 */
	@RequestMapping({ "/ad/member_edit.htm" })
	public ModelAndView member_edit (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/member_edit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员添加 */
	@RequestMapping({ "/ad/member_add.htm" })
	public ModelAndView member_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/member_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 实名认证 */
	@RequestMapping({ "/ad/affirm.htm" })
	public ModelAndView affirm (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/affirm.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 实名认证审核 */
	@RequestMapping({ "/ad/affirm_verify.htm" })
	public ModelAndView affirm_verify (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/affirm_verify.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员管理 */
	@RequestMapping({ "/ad/store.htm" })
	public ModelAndView store (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/store.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 商品管理 */
	@RequestMapping({ "/ad/goods.htm" })
	public ModelAndView goods (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 分类管理 */
	@RequestMapping({ "/ad/goods_category.htm" })
	public ModelAndView goods_category (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods_category.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 类型管理 */
	@RequestMapping({ "/ad/goods_type.htm" })
	public ModelAndView goods_type (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods_type.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 规格管理 */
	@RequestMapping({ "/ad/goods_norms.htm" })
	public ModelAndView goods_norms (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods_norms.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 品牌管理 */
	@RequestMapping({ "/ad/goods_brand.htm" })
	public ModelAndView goods_brand (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods_brand.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 品牌管理 */
	@RequestMapping({ "/ad/goods_evaluate.htm" })
	public ModelAndView goods_evaluate (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/goods_evaluate.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 交易管理 */
	@RequestMapping({ "/ad/trade.htm" })
	public ModelAndView trade (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 订单设置 */
	@RequestMapping({ "/ad/trade_order.htm" })
	public ModelAndView trade_order (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade_order.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 咨询管理 */
	@RequestMapping({ "/ad/trade_consult.htm" })
	public ModelAndView trade_consult (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade_consult.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 提现管理 */
	@RequestMapping({ "/ad/trade_cash.htm" })
	public ModelAndView trade_cash (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 退款退货管理 */
	@RequestMapping({ "/ad/trade_refund.htm" })
	public ModelAndView trade_refund (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade_refund.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 投诉举报管理 */
	@RequestMapping({ "/ad/trade_complain.htm" })
	public ModelAndView trade_complain (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/trade_complain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 店铺模板 */
	@RequestMapping({ "/ad/store_model.htm" })
	public ModelAndView store_model (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/store_model.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 店铺分类 */
	@RequestMapping({ "/ad/store_category.htm" })
	public ModelAndView store_category (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/store_category.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 店铺等级 */
	@RequestMapping({ "/ad/store_grade.htm" })
	public ModelAndView store_grade (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/store_grade.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 运商家信用 */
	@RequestMapping({ "/ad/store_credit.htm" })
	public ModelAndView store_credit (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/store_credit.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 运营管理 */
	@RequestMapping({ "/ad/run.htm" })
	public ModelAndView run (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 运营管理 */
	@RequestMapping({ "/ad/run_storey.htm" })
	public ModelAndView run_storey (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_storey.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* pc广告管理 */
	@RequestMapping({ "/ad/run_advert_pc.htm" })
	public ModelAndView run_advert_pc (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_advert_pc.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* wap广告管理 */
	@RequestMapping({ "/ad/run_advert_wap.htm" })
	public ModelAndView run_advert_wap (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_advert_wap.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 促销管理 */
	@RequestMapping({ "/ad/run_sales.htm" })
	public ModelAndView run_sales (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_sales.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 消息推送 */
	@RequestMapping({ "/ad/run_news.htm" })
	public ModelAndView run_news (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_news.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 公告 */
	@RequestMapping({ "/ad/run_advert.htm" })
	public ModelAndView run_advert (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_advert.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 商城通知 */
	@RequestMapping({ "/ad/run_notice.htm" })
	public ModelAndView run_notice (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_notice.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 快递设置 */
	@RequestMapping({ "/ad/run_fastmail.htm" })
	public ModelAndView run_fastmail (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_fastmail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 短信发送 */
	@RequestMapping({ "/ad/run_message.htm" })
	public ModelAndView run_message (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_message.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 优惠券管理 */
	@RequestMapping({ "/ad/run_coupon.htm" })
	public ModelAndView run_coupon (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_coupon.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 推广信息标题设置 */
	@RequestMapping({ "/ad/run_information.htm" })
	public ModelAndView run_information (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/run_information.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员充值统计 */
	@RequestMapping({ "/ad/census.htm" })
	public ModelAndView census (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/census.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员账户升级统计 */
	@RequestMapping({ "/ad/census_upgrade.htm" })
	public ModelAndView census_upgrade (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/census_upgrade.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 店铺分红统计 */
	@RequestMapping({ "/ad/census_share.htm" })
	public ModelAndView census_share (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/census_share.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 平台收入统计 */
	@RequestMapping({ "/ad/census_platform.htm" })
	public ModelAndView census_platform (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/census_platform.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 平台用户分红提现 */
	@RequestMapping({ "/ad/census_cash.htm" })
	public ModelAndView census_cash (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/census_cash.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 工具管理 */
	@RequestMapping({ "/ad/tool.htm" })
	public ModelAndView tool (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/tool.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 工具管理 */
	@RequestMapping({ "/ad/tool_data.htm" })
	public ModelAndView tool_data (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/tool_data.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 工具管理 */
	@RequestMapping({ "/ad/tool_fulltext.htm" })
	public ModelAndView tool_fulltext (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/tool_fulltext.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 设置管理 */
	@RequestMapping({ "/ad/setup.htm" })
	public ModelAndView setup (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 站点设置 */
	@RequestMapping({ "/ad/web_set.htm" })
	public ModelAndView web_set (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/web_set.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 上传设置 */
	@RequestMapping({ "/ad/setup_update.htm" })
	public ModelAndView setup_update (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_update.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* SEO设置 */
	@RequestMapping({ "/ad/setup_seo.htm" })
	public ModelAndView setup_seo (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_seo.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* email设置 */
	@RequestMapping({ "/ad/setup_email.htm" })
	public ModelAndView setup_email (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_email.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 短信设置 */
	@RequestMapping({ "/ad/setup_message.htm" })
	public ModelAndView setup_message (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_message.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 二级域名 */
	@RequestMapping({ "/ad/setup_twolevel.htm" })
	public ModelAndView setup_twolevel (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_twolevel.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 通知模板 */
	@RequestMapping({ "/ad/setup_notice.htm" })
	public ModelAndView setup_notice (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_notice.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 支付管理 */
	@RequestMapping({ "/ad/setup_pay.htm" })
	public ModelAndView setup_pay (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/setup_pay.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 网站管理 */
	@RequestMapping({ "/ad/website.htm" })
	public ModelAndView website (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/website.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 关于我们 */
	@RequestMapping({ "/ad/aboutus.htm" })
	public ModelAndView aboutus (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/aboutus.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员通知 */
	@RequestMapping({ "/ad/mb_notices.htm" })
	public ModelAndView mb_notices (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/mb_notices.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 会员礼品金 */
	@RequestMapping({ "/ad/mb_coins.htm" })
	public ModelAndView mb_coins (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/mb_coins.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* top */
	@RequestMapping({ "/ad/top.htm" })
	public ModelAndView top (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/top.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 修改密码 */
	@RequestMapping({ "/ad/modify_password.htm" })
	public ModelAndView modify_password (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/modify_password.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* top */
	@RequestMapping({ "/ad/bottom.htm" })
	public ModelAndView bottom (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/bottom.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 500 */
	@RequestMapping({ "/ad/500.htm" })
	public ModelAndView error500 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/500.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}

	/* 404 */
	@RequestMapping({ "/ad/404.htm" })
	public ModelAndView error404 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin21/404.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}
}
