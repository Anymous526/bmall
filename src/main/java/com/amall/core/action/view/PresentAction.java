package com.amall.core.action.view;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IConsultService;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IFavoriteService;
import com.amall.core.service.IGoodsClass2SpecService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.advert.IAdvertPositionService;
import com.amall.core.service.advert.IAdvertService;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoods2PhotoService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsModuleFloorNextService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsModuleService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.goods.IGoodsTypePropertyService;
import com.amall.core.service.goods.IGoodsTypeService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreClassService;
import com.amall.core.service.store.IStorePointService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.AreaViewTools;
import com.amall.core.web.tools.CartGoodsCountTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.TransportTools;
import com.amall.core.web.tools.UserTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class PresentAction
{

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IFavoriteService favoriteService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	// **************
	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IStorePointService storePointService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IConsultService consultService;

	@Autowired
	private IGoodsBrandService brandService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsTypePropertyService goodsTypePropertyService;

	@Autowired
	private IIntegralGoodsService integralGoodsService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IStoreClassService storeClassService;

	@Autowired
	private AreaViewTools areaViewTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private UserTools userTools;

	@Autowired
	private TransportTools transportTools;

	@Autowired
	private IGoods2SpecService goods2SpecService;

	@Autowired
	private IGoodsClass2SpecService goodsClass2SpecService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsTypeService goodsTypeService;

	@Autowired
	private IGoodsSpecService goodsSpecService;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	ICartService cartService;

	@Autowired
	private IGoods2PhotoService goods2PhotoService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IGroupGoodsService groupGoodsSerice;

	@Autowired
	private CartGoodsCountTools cartGoodsCountTools;

	@Autowired
	private IGoodsModuleService goodsModuleService;

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@Autowired
	private IGoodsModuleFloorNextService goodsModuleFloorNextService;

	@Autowired
	private IAdvertPositionService advertPositionService;

	@Autowired
	private IAdvertService advertService;

	@RequestMapping({ "/buyer/buyer_order_test1.htm" })
	public ModelAndView buyer_order_test1 (HttpServletRequest request , HttpServletResponse response , String orderId , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("buyer_orderComment.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 申请退货 */
	@RequestMapping({ "/buyer/sqth.htm" })
	public ModelAndView buyer_order_test7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("sqth.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 退换列表2 */
	@RequestMapping({ "/buyer/tuihuan2.htm" })
	public ModelAndView buyer_order_test9 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("tuihuan2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 退换列表3 */
	@RequestMapping({ "/buyer/tuihuan3.htm" })
	public ModelAndView buyer_order_test10 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("tuihuan3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 天使会员成功 */
	@RequestMapping({ "/buyer/active_appliaction_sccuess2.htm" })
	public ModelAndView active_appliaction_sccuess2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/active_appliaction_sccuess2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 百度验证 */
	@RequestMapping({ "/baidu_verify_xeE2RrCBjl.htm" })
	public ModelAndView baidu_verify_xeE2RrCBjl (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("baidu_verify_xeE2RrCBjl.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 填写物流 */
	@RequestMapping({ "/buyer/sqtk3.htm" })
	public ModelAndView sqtk3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("sqtk3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 团购订单列表 */
	@RequestMapping({ "/tuan_order_list.htm" })
	public ModelAndView tuan_order_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("tuan_order_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 团购订单详情 */
	@RequestMapping({ "/tuan_order_detail.htm" })
	public ModelAndView tuan_order_detail (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("tuan_order_detail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 支付失败 */
	@RequestMapping({ "/buyer/pay_fail.htm" })
	public ModelAndView pay_fail (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/pay_fail.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 关于我们 */
	@RequestMapping({ "/about.htm" })
	public ModelAndView about (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/about.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 */
	@RequestMapping({ "/help_center.htm" })
	public ModelAndView help_center (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_center.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists1.htm" })
	public ModelAndView help_lists1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists1_1.htm" })
	public ModelAndView help_lists1_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists1_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists1_2.htm" })
	public ModelAndView help_lists1_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists1_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists1_3.htm" })
	public ModelAndView help_lists1_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists1_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2.htm" })
	public ModelAndView help_lists2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_1.htm" })
	public ModelAndView help_lists2_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_2.htm" })
	public ModelAndView help_lists2_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_3.htm" })
	public ModelAndView help_lists2_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_4.htm" })
	public ModelAndView help_lists2_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_5.htm" })
	public ModelAndView help_lists2_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists2_6.htm" })
	public ModelAndView help_lists2_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists2_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3.htm" })
	public ModelAndView help_lists3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_1.htm" })
	public ModelAndView help_lists3_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_3.htm" })
	public ModelAndView help_lists3_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_4.htm" })
	public ModelAndView help_lists3_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_5.htm" })
	public ModelAndView help_lists3_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_6.htm" })
	public ModelAndView help_lists3_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_7.htm" })
	public ModelAndView help_lists3_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists3_8.htm" })
	public ModelAndView help_lists3_8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists3_8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists4.htm" })
	public ModelAndView help_lists4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists4_1.htm" })
	public ModelAndView help_lists4_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists4_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists4_2.htm" })
	public ModelAndView help_lists4_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists4_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5.htm" })
	public ModelAndView help_lists5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_1.htm" })
	public ModelAndView help_lists5_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_2.htm" })
	public ModelAndView help_lists5_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_3.htm" })
	public ModelAndView help_lists5_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_4.htm" })
	public ModelAndView help_lists5_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_5.htm" })
	public ModelAndView help_lists5_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists5_6.htm" })
	public ModelAndView help_lists5_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists5_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists6.htm" })
	public ModelAndView help_lists6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists6_1.htm" })
	public ModelAndView help_lists6_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists6_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists6_2.htm" })
	public ModelAndView help_lists6_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists6_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists6_3.htm" })
	public ModelAndView help_lists6_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists6_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists6_4.htm" })
	public ModelAndView help_lists6_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists6_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7.htm" })
	public ModelAndView help_lists7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7_1.htm" })
	public ModelAndView help_lists7_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7_2.htm" })
	public ModelAndView help_lists7_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7_3.htm" })
	public ModelAndView help_lists7_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7_4.htm" })
	public ModelAndView help_lists7_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists7_5.htm" })
	public ModelAndView help_lists7_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists7_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists8.htm" })
	public ModelAndView help_lists8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists8_1.htm" })
	public ModelAndView help_lists8_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists8_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists8_2.htm" })
	public ModelAndView help_lists8_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists8_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists9.htm" })
	public ModelAndView help_lists9 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists9.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists9_1.htm" })
	public ModelAndView help_lists9_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists9_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists9_2.htm" })
	public ModelAndView help_lists9_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists9_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10.htm" })
	public ModelAndView help_lists10 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_1.htm" })
	public ModelAndView help_lists10_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_2.htm" })
	public ModelAndView help_lists10_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_3.htm" })
	public ModelAndView help_lists10_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_4.htm" })
	public ModelAndView help_lists10_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_5.htm" })
	public ModelAndView help_lists10_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists10_6.htm" })
	public ModelAndView help_lists10_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists10_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11.htm" })
	public ModelAndView help_lists11 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_1.htm" })
	public ModelAndView help_lists11_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_2.htm" })
	public ModelAndView help_lists11_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_3.htm" })
	public ModelAndView help_lists11_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_4.htm" })
	public ModelAndView help_lists11_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_5.htm" })
	public ModelAndView help_lists11_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_6.htm" })
	public ModelAndView help_lists11_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_7.htm" })
	public ModelAndView help_lists11_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_8.htm" })
	public ModelAndView help_lists11_8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_9.htm" })
	public ModelAndView help_lists11_9 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_9.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_10.htm" })
	public ModelAndView help_lists11_10 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_10.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_11.htm" })
	public ModelAndView help_lists11_11 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_11.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_12.htm" })
	public ModelAndView help_lists11_12 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_12.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_13.htm" })
	public ModelAndView help_lists11_13 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_13.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_14.htm" })
	public ModelAndView help_lists11_14 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_14.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_15.htm" })
	public ModelAndView help_lists11_15 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_15.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists11_16.htm" })
	public ModelAndView help_lists11_16 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists11_16.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12.htm" })
	public ModelAndView help_lists12 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_1.htm" })
	public ModelAndView help_lists12_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_2.htm" })
	public ModelAndView help_lists12_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_3.htm" })
	public ModelAndView help_lists12_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_4.htm" })
	public ModelAndView help_lists12_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_5.htm" })
	public ModelAndView help_lists12_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_6.htm" })
	public ModelAndView help_lists12_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_7.htm" })
	public ModelAndView help_lists12_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_8.htm" })
	public ModelAndView help_lists12_8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_9.htm" })
	public ModelAndView help_lists12_9 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_9.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_10.htm" })
	public ModelAndView help_lists12_10 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_10.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_11.htm" })
	public ModelAndView help_lists12_11 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_11.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_12.htm" })
	public ModelAndView help_lists12_12 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_12.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_13.htm" })
	public ModelAndView help_lists12_13 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_13.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_14.htm" })
	public ModelAndView help_lists12_14 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_14.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_lists12_15.htm" })
	public ModelAndView help_lists12_15 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_lists12_15.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1.htm" })
	public ModelAndView help_listw1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_1.htm" })
	public ModelAndView help_listw1_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_2.htm" })
	public ModelAndView help_listw1_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_3.htm" })
	public ModelAndView help_listw1_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_4.htm" })
	public ModelAndView help_listw1_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_5.htm" })
	public ModelAndView help_listw1_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_6.htm" })
	public ModelAndView help_listw1_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_7.htm" })
	public ModelAndView help_listw1_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw1_8.htm" })
	public ModelAndView help_listw1_8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw1_8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2.htm" })
	public ModelAndView help_listw2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_1.htm" })
	public ModelAndView help_listw2_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_2.htm" })
	public ModelAndView help_listw2_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_3.htm" })
	public ModelAndView help_listw2_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_4.htm" })
	public ModelAndView help_listw2_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_5.htm" })
	public ModelAndView help_listw2_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw2_6.htm" })
	public ModelAndView help_listw2_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw2_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3.htm" })
	public ModelAndView help_listw3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3_1.htm" })
	public ModelAndView help_listw3_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3_2.htm" })
	public ModelAndView help_listw3_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		} /* 消费者帮助 列表 */

	@RequestMapping({ "/help_listw3_3.htm" })
	public ModelAndView help_listw3_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		} /* 消费者帮助 列表 */

	@RequestMapping({ "/help_listw3_4.htm" })
	public ModelAndView help_listw3_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		} /* 消费者帮助 列表 */

	@RequestMapping({ "/help_listw3_5.htm" })
	public ModelAndView help_listw3_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		} /* 消费者帮助 列表 */

	@RequestMapping({ "/help_listw3_6.htm" })
	public ModelAndView help_listw3_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3_7.htm" })
	public ModelAndView help_listw3_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3_8.htm" })
	public ModelAndView help_listw3_8 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_8.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw3_9.htm" })
	public ModelAndView help_listw3_9 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw3_9.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4.htm" })
	public ModelAndView help_listw4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4_1.htm" })
	public ModelAndView help_listw4_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4_2.htm" })
	public ModelAndView help_listw4_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4_3.htm" })
	public ModelAndView help_listw4_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4_4.htm" })
	public ModelAndView help_listw4_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw4_5.htm" })
	public ModelAndView help_listw4_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw4_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5.htm" })
	public ModelAndView help_listw5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_1.htm" })
	public ModelAndView help_listw5_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_2.htm" })
	public ModelAndView help_listw5_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_3.htm" })
	public ModelAndView help_listw5_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_4.htm" })
	public ModelAndView help_listw5_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_5.htm" })
	public ModelAndView help_listw5_5 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_5.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_6.htm" })
	public ModelAndView help_listw5_6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw5_7.htm" })
	public ModelAndView help_listw5_7 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw5_7.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw6.htm" })
	public ModelAndView help_listw6 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw6.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw6_1.htm" })
	public ModelAndView help_listw6_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw6_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 消费者帮助 列表 */
	@RequestMapping({ "/help_listw6_2.htm" })
	public ModelAndView help_listw6_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_listw6_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list1_1.htm" })
	public ModelAndView help_list1_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list1_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 招商标准 */
	@RequestMapping({ "/help_list1_2.htm" })
	public ModelAndView help_list1_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list1_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 招商标准 */
	@RequestMapping({ "/help_list1_3.htm" })
	public ModelAndView help_list1_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list1_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 招商标准 */
	@RequestMapping({ "/help_list1_4.htm" })
	public ModelAndView help_list1_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list1_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list2_1.htm" })
	public ModelAndView help_list2_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list2_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list2_2.htm" })
	public ModelAndView help_list2_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list2_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list2_3.htm" })
	public ModelAndView help_list2_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list2_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list2_4.htm" })
	public ModelAndView help_list2_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list2_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list3_1.htm" })
	public ModelAndView help_list3_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list3_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list3_2.htm" })
	public ModelAndView help_list3_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list3_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心详细 天使商城招商类别及细则 */
	@RequestMapping({ "/help_list3_3.htm" })
	public ModelAndView help_list3_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list3_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 收费标准 */
	@RequestMapping({ "/help_list4_1.htm" })
	public ModelAndView help_list4_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list4_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 收费标准 */
	@RequestMapping({ "/help_list4_2.htm" })
	public ModelAndView help_list4_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list4_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 收费标准 */
	@RequestMapping({ "/help_list4_3.htm" })
	public ModelAndView help_list4_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list4_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 收费标准 */
	@RequestMapping({ "/help_list4_4.htm" })
	public ModelAndView help_list4_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list4_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 收费标准 */
	@RequestMapping({ "/help_list5_1.htm" })
	public ModelAndView help_list5_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list5_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 店铺开通 */
	@RequestMapping({ "/help_list6_1.htm" })
	public ModelAndView help_list6_1 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list6_1.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 店铺开通 */
	@RequestMapping({ "/help_list6_2.htm" })
	public ModelAndView help_list6_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list6_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 店铺开通 */
	@RequestMapping({ "/help_list6_3.htm" })
	public ModelAndView help_list6_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list6_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 帮助中心 店铺开通 */
	@RequestMapping({ "/help_list6_4.htm" })
	public ModelAndView help_list6_4 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("help/help_list6_4.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* test */
	@RequestMapping({ "/exchange_list2.htm" })
	public ModelAndView exchange_list2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("exchange_list2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 店铺 模板1 */
	@RequestMapping({ "/shop_template_view.htm" })
	public ModelAndView shop_template_view (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("shop_template_view.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 店铺 模板1 */
	@RequestMapping({ "/shop_template_pink.htm" })
	public ModelAndView shop_template_pink (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("shop_template_pink.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_northeast.htm" })
	public ModelAndView specialty_northeast (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_northeast.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_northchina.htm" })
	public ModelAndView specialty_northchina (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_northchina.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_centralchina.htm" })
	public ModelAndView specialty_centralchina (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_centralchina.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_eastchina.htm" })
	public ModelAndView specialty_eastchina (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_eastchina.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_western.htm" })
	public ModelAndView specialty_western (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_western.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_southwest.htm" })
	public ModelAndView specialty_southwest (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_southwest.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_southchina.htm" })
	public ModelAndView specialty_southchina (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_southchina.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_hmt.htm" })
	public ModelAndView specialty_hmt (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_hmt.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 东北土特产 */
	@RequestMapping({ "/specialty_overseas.htm" })
	public ModelAndView specialty_overseas (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("specialty_overseas.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/*--------------------  新加页面   -------------------------------*/
	/* 邀请 */
	@RequestMapping({ "/angel_exchange_share.htm" })
	public ModelAndView angel_exchange_share (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("angel_exchange_share.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 个人中心里面 */
	@RequestMapping({ "/buyer/b_bingo_list.htm" })
	public ModelAndView b_bingo_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/b_bingo_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/buyer/b_add_tsb_list.htm" })
	public ModelAndView b_add_tsb_list (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/b_add_tsb_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 兑购记录晒单分享 */
	@RequestMapping({ "/buyer/b_showgoods.htm" })
	public ModelAndView b_showgoods (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("buyer/b_showgoods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* -----------------------天使兑购 ----------------------- */
	/* 天使会员 */
	@RequestMapping({ "/amall_member.htm" })
	public ModelAndView amall_member (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("amall_member.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 天使会员2 */
	@RequestMapping({ "/amall_member2.htm" })
	public ModelAndView amall_member2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("amall_member2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				mv.addObject ("totalMember" , this.userService.findTotalMember (user.getId ()));
			}
			IntegralGoodsExample integralGoodsExample = new IntegralGoodsExample ();
			integralGoodsExample.setOrderByClause ("ig_click_count desc");
			integralGoodsExample.setPageSize (8);
			IntegralGoodsExample.Criteria integralGoodsCriteria = integralGoodsExample.createCriteria ();
			integralGoodsCriteria.andIgShowEqualTo (true);
			Pagination pList = this.integralGoodsService.getObjectListWithPage (integralGoodsExample);
			if (pList.getList () != null && pList.getList ().size () > 0)
			{
				mv.addObject ("hotGoods" , pList.getList ());
			}
			integralGoodsExample.clear ();
			integralGoodsExample.setOrderByClause ("addtime desc");
			integralGoodsExample.setPageSize (8);
			IntegralGoodsExample.Criteria integralGoodsCriteria1 = integralGoodsExample.createCriteria ();
			integralGoodsCriteria1.andIgShowEqualTo (true);
			Pagination newList = this.integralGoodsService.getObjectListWithPage (integralGoodsExample);
			if (newList.getList () != null && newList.getList ().size () > 0)
			{
				mv.addObject ("newList" , newList.getList ());
			}
			integralGoodsExample.clear ();
			integralGoodsExample.setOrderByClause ("igGoodsGoldNum asc");
			integralGoodsExample.setPageSize (8);
			IntegralGoodsExample.Criteria integralGoodsCriteria2 = integralGoodsExample.createCriteria ();
			integralGoodsCriteria2.andIgShowEqualTo (true);
			Pagination priceList = this.integralGoodsService.getObjectListWithPage (integralGoodsExample);
			if (priceList.getList () != null && priceList.getList ().size () > 0)
			{
				mv.addObject ("priceList" , priceList.getList ());
			}
			return mv;
		}

	/* 福音产品 */
	@RequestMapping({ "/amall_gospel.htm" })
	public ModelAndView amall_gospel (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("amall_gospel.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/* 新奇特列表 */
	@RequestMapping({ "buyer/runstore.htm" })
	public ModelAndView runstore (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("runstore.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	/*--------------------  新加页面   -------------------------------*/
	/* 我的收藏 */
	@RequestMapping({ "/my_favorite_goods.htm" })
	public ModelAndView my_favorite_goods (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("my_favorite_goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			FavoriteExample favoriteExample = new FavoriteExample ();
			favoriteExample.setOrderByClause ("addTime desc");
			favoriteExample.createCriteria ().andTypeEqualTo (Integer.valueOf (0)).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andStoreIdIsNotNull ().andGoodsIdIsNotNull ();
			List <Favorite> listFavorite = this.favoriteService.getObjectList (favoriteExample);
			mv.addObject ("objs" , listFavorite);
			return mv;
		}

	@RequestMapping({ "/buyer_favorite_del.htm" })
	public String favorite_del (HttpServletRequest request , HttpServletResponse response , String mulitId , int type)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
//					Favorite favorite = this.favoriteService.getByKey (Long.valueOf (Long.parseLong (id)));
					this.favoriteService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			if (type == 0)
			{	// type = 0 时 , 为收藏商品 , 所以重定向到收藏商品页面
				return "redirect:/my_favorite_goods.htm";
			}
			// type != 0 为收藏的店铺页面 , 重定向到店铺收藏页面
			return "redirect:buyer_favorite_store.htm";
		}
}
