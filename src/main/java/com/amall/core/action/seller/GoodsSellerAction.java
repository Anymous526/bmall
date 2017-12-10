package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.Area;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;
import com.amall.core.bean.Goods2SpecExample;
import com.amall.core.bean.Goods2Ugc;
import com.amall.core.bean.Goods2UgcExample;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassStaple;
import com.amall.core.bean.GoodsClassStapleExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleExample;
import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;
import com.amall.core.bean.GoodsPoint;
import com.amall.core.bean.GoodsRate;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import com.amall.core.bean.GoodsType2Spec;
import com.amall.core.bean.GoodsType2SpecExample;
import com.amall.core.bean.GoodsTypeProperty;
import com.amall.core.bean.GoodsTypePropertyExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.bean.Report;
import com.amall.core.bean.ReportExample;
import com.amall.core.bean.Store;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.TransportExample;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.lucene.LuceneUtil;
import com.amall.core.lucene.LuceneVo;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IGoodsClass2SpecService;
import com.amall.core.service.IPaymentService;
import com.amall.core.service.ITransportService;
import com.amall.core.service.IWaterMarkService;
import com.amall.core.service.address.IAreaService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.cart.ICartService;
import com.amall.core.service.goods.IGoods2PhotoService;
import com.amall.core.service.goods.IGoods2SpecService;
import com.amall.core.service.goods.IGoods2UserGoodsClassService;
import com.amall.core.service.goods.IGoodsBrandCategoryService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsClassStapleService;
import com.amall.core.service.goods.IGoodsModuleFloorNextService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsModuleService;
import com.amall.core.service.goods.IGoodsPointService;
import com.amall.core.service.goods.IGoodsPropertyService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IGoodsSpecService;
import com.amall.core.service.goods.IGoodsSpecificationService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.goods.IGoodsType2SpecService;
import com.amall.core.service.goods.IGoodsTypePropertyService;
import com.amall.core.service.goods.IGoodsTypeService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.report.IReportService;
import com.amall.core.service.store.IStoreNavigationService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserGoodsClassService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.GoodsViewTools;
import com.amall.core.web.tools.StoreTools;
import com.amall.core.web.tools.StoreViewTools;
import com.amall.core.web.tools.TransportTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GoodsSellerAction
 * </p>
 * <p>
 * Description: 卖家中心 商品相关 如发布、分类、上下架等crud操作
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月17日下午7:51:43
 * @version 1.0
 */
@Controller
public class GoodsSellerAction
{

	static Logger log = Logger.getLogger (GoodsSellerAction.class);

	@Autowired
	private IOrderFormItemService orderFormItemService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IGoodsType2BrandService type2BranchService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsClassStapleService goodsclassstapleService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserGoodsClassService userGoodsClassService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsSpecPropertyService specPropertyService;

	@Autowired
	private IGoodsTypePropertyService goodsTypePropertyService;

	@Autowired
	private IWaterMarkService waterMarkService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private IReportService reportService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private ITransportService transportService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private TransportTools transportTools;

	@Autowired
	private StoreTools storeTools;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private IGoodsSpecService goodsSpecServcice;

	@Autowired
	private IGoodsPropertyService goodsPropertyService;

	@Autowired
	private IGoods2UserGoodsClassService goods2UserGoodsClassService;

	@Autowired
	private IGoodsTypeService goodsTypeService;

	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	private IGoodsType2SpecService goodsType2SpecService;

	@Autowired
	private IGoods2SpecService goods2SpecSerivce;

	@Autowired
	private IGoods2UserGoodsClassService goods2UgcService;

	@Autowired
	private IGoodsBrandCategoryService goodsBrandCategoryService;

	@Autowired
	private IGoodsSpecificationService goodsSpecificationService;

	@Autowired
	private IGoodsClass2SpecService class2SpecService;

	@Autowired
	private IStoreNavigationService storenavigationService;

	@Autowired
	private IGoods2PhotoService goods2PhotoService;

	@Autowired
	private IGoodsPointService goodsPointService;

	@Autowired
	private IGoodsModuleService goodsModuleService;

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@Autowired
	private IGoodsModuleFloorNextService goodsModuleFloorNextService;

	@Autowired
	private IAreaService areaService;


	@SecurityMapping(title = "发布商品第一步" , value = "/seller/add_goods_first.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/add_goods_first.htm" })
	public ModelAndView add_goods_first (	HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());    // /空值
			/* 读取最新店铺信息 */
			user.setStore (this.storeService.getByKey (user.getStoreId ()));
			List <PaymentWithBLOBs> payments = null;
			PaymentExample paymentExample = new PaymentExample ();
			paymentExample.clear ();
			PaymentExample.Criteria paymentCriteria = paymentExample.createCriteria ();
			Integer configPaymentType = this.configService.getSysConfig ().getConfigPaymentType ();
			if (configPaymentType == 1)
			{
				paymentCriteria.andTypeEqualTo ("admin").andInstallEqualTo (Boolean.valueOf (true));
				payments = paymentService.getObjectList (paymentExample);
			}
			else
			{
				paymentCriteria.andStoreIdEqualTo (user.getStore ().getId ()).andInstallEqualTo (Boolean.valueOf (true));
				payments = paymentService.getObjectList (paymentExample);
			}
			if (payments.size () == 0)
			{
				mv.addObject ("op_title" , "请至少开通一种支付方式");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/usercenter/payment.htm");
				return mv;
			}
			request.getSession (false).removeAttribute ("goods_class_info");
			int store_status = user.getStore () == null ? 0 : user.getStore ().getStoreStatus ();
			if (store_status == 2)
			{
				StoreGrade grade = user.getStore ().getGrade ();
				GoodsExample goodsExample = new GoodsExample ();			// 查询用户所属店铺所有商品
				goodsExample.clear ();
				goodsExample.createCriteria ().andGoodsStoreIdEqualTo (user.getStoreId ());
				Integer user_goods_count = goodsService.getObjectListCount (goodsExample);
				if ((grade.getGoodscount () == 0) || (user_goods_count < grade.getGoodscount ()))
				{
					GoodsClassExample goodsClassExample = new GoodsClassExample ();
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdIsNull ();
					goodsClassExample.setOrderByClause ("sequence asc");
					List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
					mv = new JModelAndView ("seller/add_goods_first.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					GoodsClassStapleExample goodsClassStapleExample = new GoodsClassStapleExample ();
					goodsClassStapleExample.clear ();
					goodsClassStapleExample.setOrderByClause ("addTime desc");
					goodsClassStapleExample.createCriteria ().andStoreIdEqualTo (user.getStore ().getId ());
					List <GoodsClassStaple> staples = goodsclassstapleService.getObjectList (goodsClassStapleExample);
					mv.addObject ("staples" , staples);
					mv.addObject ("gcs" , gcs);
					mv.addObject ("id" , CommUtil.null2String (id));
				}
				else
				{
					mv.addObject ("op_title" , "您的店铺等级只允许上传" + grade.getGoodscount () + "件商品!");
					mv.addObject ("url" , CommUtil.getURL (request) + "/seller/usercenter/store_grade.htm");
				}
			}
			if (store_status == 0)
			{
				mv.addObject ("op_title" , "您尚未开通店铺，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			if (store_status == 1)
			{
				mv.addObject ("op_title" , "您的店铺在审核中，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			if (store_status == 3)
			{
				mv.addObject ("op_title" , "您的店铺已被关闭，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			// if (store_status == 2) {
			// mv.addObject("op_title", "缴纳保证金，你就可以发布商品了");
			// mv.addObject("url", CommUtil.getURL(request)
			// + "/seller/seller_index.htm");
			// }
			return mv;
		}


	@SecurityMapping(title = "商品运费模板分页显示" , value = "/seller/goods_transport.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_transport.htm" })
	public ModelAndView goods_transport (	HttpServletRequest request , HttpServletResponse response ,
											String currentPage , String orderBy , String orderType , String ajax)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/goods_transport.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (CommUtil.null2Boolean (ajax))
			{
				mv = new JModelAndView ("seller/usercenter/goods_transport_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			}
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			StoreWithBLOBs store = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()).getStore ();
			TransportExample transportExample = new TransportExample ();
			transportExample.clear ();
			transportExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			transportExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			// transportExample.setPageSize(Integer.valueOf(1));
			transportExample.createCriteria ().andStoreIdEqualTo (store.getId ());
			Pagination pList = transportService.getObjectListWithPage (transportExample);
			CommUtil.addIPageList2ModelAndView (url + "/seller/usercenter/goods_transport.html" , "" , params , pList , mv);
			mv.addObject ("transportTools" , this.transportTools);
			return mv;
		}


	@SecurityMapping(title = "发布商品第二步" , value = "/seller/add_goods_second.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/add_goods_second.htm" })
	public ModelAndView add_goods_second (	HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			/* 读取最新店铺信息 */
			user.setStore (this.storeService.getByKey (user.getStoreId ()));
			SysConfig config = this.configService.getSysConfig ();
			mv.addObject ("config" , config);
			int store_status = user.getStore ().getStoreStatus ();
			if (store_status == 2)
			{
				mv = new JModelAndView ("seller/add_goods_second.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				GoodsClassWithBLOBs gc = null;
				GoodsType goodsType = null;
				if (request.getSession (false).getAttribute ("goods_class_info") != null)
				{
					gc = (GoodsClassWithBLOBs) request.getSession (false).getAttribute ("goods_class_info");
					gc = this.goodsClassService.getByKey (gc.getId ());
					String goods_class_info = generic_goods_class_info (gc);
					GoodsClassWithBLOBs goods_class = this.goodsClassService.getByKey (gc.getId ());
					goodsType = goodsTypeService.getByKey (goods_class.getGoodstypeId ());
					Map <GoodsSpecification, List <GoodsSpecProperty>> returnMap = new HashMap <GoodsSpecification, List <GoodsSpecProperty>> ();
					if (goodsType != null)
					{
						GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
						goodsType2SpecExample.clear ();
						goodsType2SpecExample.createCriteria ().andTypeIdEqualTo (goodsType.getId ());
						List <GoodsType2Spec> gt2s = goodsType2SpecService.getObjectList (goodsType2SpecExample);
						List <GoodsSpecification> goodsSpecifications = new ArrayList <GoodsSpecification> ();
						GoodsSpecPropertyExample goodsSpecPropertyExample = new GoodsSpecPropertyExample ();
						if (gt2s != null && !gt2s.isEmpty ())
						{
							for (GoodsType2Spec goodsType2Spec : gt2s)
							{
								GoodsSpecification goodsSpecification = goodsSpecificationService.getByKey (goodsType2Spec.getSpecId ());
								goodsSpecPropertyExample.clear ();
								goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (goodsType2Spec.getSpecId ());
								List <GoodsSpecProperty> gsps = goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
								goodsSpecification.getProperties ().addAll (gsps);
								goodsSpecifications.add (goodsSpecification);
								returnMap.put (goodsSpecification , gsps);
							}
							goodsType.setGss (goodsSpecifications);
						}
						else
						{
							/* 获取规格信息 */
							GoodsClass2SpecExample class2SpecExample = new GoodsClass2SpecExample ();
							class2SpecExample.clear ();
							class2SpecExample.createCriteria ().andClassIdEqualTo (Long.valueOf (goods_class.getId ()));
							List <GoodsClass2Spec> class2Specs = class2SpecService.getObjectList (class2SpecExample);
							/* 组装规格信息 */
							for (GoodsClass2Spec class2Spec : class2Specs)
							{
								GoodsSpecification goodsSpecification = this.goodsSpecificationService.getByKey (class2Spec.getSpecificationId ());
								goodsSpecPropertyExample.clear ();
								goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (goodsSpecification.getId ());
								List <GoodsSpecProperty> specProperties = this.goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
								/* 不存在属性值的不添加 */
								if (!specProperties.isEmpty ())
								{
									returnMap.put (goodsSpecification , specProperties);
								}
							}
						}
						// 查询商品类型属性
						GoodsTypePropertyExample gtpExample = new GoodsTypePropertyExample ();
						gtpExample.clear ();
						gtpExample.createCriteria ().andGoodstypeIdEqualTo (goodsType.getId ());
						List <GoodsTypeProperty> gtps = goodsTypePropertyService.getObjectList (gtpExample);
						goodsType.setProperties (gtps);
					}
					mv.addObject ("sepcs" , returnMap);
					mv.addObject ("gt" , goodsType);
					mv.addObject ("goods_class" , goods_class);
					mv.addObject ("goods_class_info" , goods_class_info.substring (0 , goods_class_info.length () - 1));
				}
				String path = this.configService.getSysConfig ().getUploadRootPath () + this.configService.getSysConfig ().getUploadfilepath () + File.separator + "store" + File.separator + user.getStore ().getId ();
				double img_remain_size = 0.0D;
				if (user.getStore ().getGrade ().getSpacesize () > 0.0F)
				{
					img_remain_size = user.getStore ().getGrade ().getSpacesize () - CommUtil.div (Double.valueOf (CommUtil.fileSize (new File (path))) , Integer.valueOf (1024));
				}
				// 查询用户自己定义的分类
				UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
				userGoodsClassExample.clear ();
				userGoodsClassExample.setOrderByClause ("sequence asc");
				userGoodsClassExample.createCriteria ().andUserIdEqualTo (user.getId ()).andDisplayEqualTo (Boolean.valueOf (true)).andParentIdIsNull ();
				List <UserGoodsClass> ugcs = userGoodsClassService.getObjectList (userGoodsClassExample);
				// 查询设置用户自定义分类子类
				List <UserGoodsClass> ugcChils = new ArrayList <UserGoodsClass> ();
				for (UserGoodsClass userGoodsClass : ugcs)
				{
					userGoodsClassExample.clear ();
					userGoodsClassExample.createCriteria ().andParentIdEqualTo (userGoodsClass.getId ());
					ugcChils = userGoodsClassService.getObjectList (userGoodsClassExample);
					userGoodsClass.getChilds ().addAll (ugcChils);
				}
				// 查询商品分类或者商品类型下的品牌
				GoodsType2BrandExample goodsType2BrandExample = new GoodsType2BrandExample ();
				if (null != gc && null != gc.getId () && !gc.getId ().toString ().equals (""))
				{
					goodsType2BrandExample.createCriteria ().andTypeIdEqualTo (gc.getId ());
				}
				List <GoodsType2Brand> type2Brands = goodsType2BrandService.getObjectList (goodsType2BrandExample);
				List <GoodsBrand> brands = new ArrayList <> ();
				if (!(type2Brands != null && !type2Brands.isEmpty ()))
				{
					if (goodsType != null)
					{
						goodsType2BrandExample.clear ();
						goodsType2BrandExample.createCriteria ().andTypeIdEqualTo (goodsType.getId ());
						type2Brands = goodsType2BrandService.getObjectList (goodsType2BrandExample);
					}
				}
				for (GoodsType2Brand type2Brand : type2Brands)
				{
					GoodsBrand brand = goodsBrandService.getGoodsById (type2Brand.getBrandId ());
					if (brand != null)
					{
						brands.add (brand);
					}
				}
				// GoodsBrandExample goodsBrandExample = new
				// GoodsBrandExample();
				// goodsBrandExample.clear();
				// goodsBrandExample.setOrderByClause("sequence asc");
				// List<GoodsBrand> gbs =
				// goodsBrandService.getObjectList(goodsBrandExample);
				// 查询店铺导航
				StoreNavigationExample storeNavigationExample = new StoreNavigationExample ();
				storeNavigationExample.clear ();
				storeNavigationExample.setOrderByClause ("sequence asc");
				storeNavigationExample.createCriteria ().andStoreIdEqualTo (user.getStoreId ());
				List <StoreNavigation> navs = storenavigationService.getObjectList (storeNavigationExample);
				// 查询商品所属模块
				GoodsModuleExample gme = new GoodsModuleExample ();
				gme.clear ();
				gme.setOrderByClause ("id");
				gme.createCriteria ().andDeletestatusEqualTo (false);
				List <GoodsModule> gms = goodsModuleService.getObjectList (gme);
				// 感恩金利率
//				List <GoodsRate> rateList = new ArrayList <GoodsRate> ();
//				Map <String, String> rateMap = new LinkedHashMap <String, String> ();
//				rateMap.put (Globals.FINANCIAL_GOLD_RATE_TWO , "20%");
////				rateMap.put (Globals.FINANCIAL_GOLD_RATE_THREE , "30%");
//				GoodsRate rate = null;
//				for (Map.Entry <String, String> map : rateMap.entrySet ())
//				{
//					rate = new GoodsRate (map.getKey () , map.getValue ());
//					rateList.add (rate);
//				}
//				mv.addObject ("goodsRate" , rateList);
				// 感恩豆利率
				List <GoodsRate> beanRateList = new ArrayList <GoodsRate> ();
				Map <String, String> beanrateMap = new LinkedHashMap <String, String> ();
				beanrateMap.put ("0.0" , "00%");
				beanrateMap.put ("0.1" , "10%");
				beanrateMap.put ("0.2" , "20%");
				beanrateMap.put ("0.3" , "30%");
				beanrateMap.put ("0.4" , "40%");
				beanrateMap.put ("0.5" , "50%");
				beanrateMap.put ("0.6" , "60%");
				beanrateMap.put ("0.7" , "70%");
				beanrateMap.put ("0.8" , "80%");
				beanrateMap.put ("0.9" , "90%");
				beanrateMap.put ("1.0" , "100%");
				GoodsRate goodsBeanRate = null;
				for (Map.Entry <String, String> map : beanrateMap.entrySet ())
				{
					goodsBeanRate = new GoodsRate (map.getKey () , map.getValue ());
					beanRateList.add (goodsBeanRate);
				}
				mv.addObject ("beanRate" , beanRateList);
				mv.addObject ("gms" , gms);
				mv.addObject ("navs" , navs);
				mv.addObject ("gbs" , brands);
				mv.addObject ("ugcs" , ugcs);
				mv.addObject ("img_remain_size" , Double.valueOf (img_remain_size));
				mv.addObject ("imageSuffix" , this.storeViewTools.genericImageSuffix (this.configService.getSysConfig ().getImagesuffix ()));
				String goods_session = CommUtil.randomString (32);
				mv.addObject ("goods_session" , goods_session);
				request.getSession (false).setAttribute ("goods_session" , goods_session);
			}
			if (store_status == 0)
			{
				mv.addObject ("op_title" , "您尚未开通店铺，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			if (store_status == 1)
			{
				mv.addObject ("op_title" , "您的店铺在审核中，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			if (store_status == 3)
			{
				mv.addObject ("op_title" , "您的店铺已被关闭，不能发布商品");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			return mv;
		}


	// ajax级联获取商品模块所以模块楼层
	@RequestMapping({ "/seller/floorByModule.htm" })
	public void searchByModuleId (	HttpServletRequest request , HttpServletResponse response , Integer module)
		{
			if (module != null && module > 0)
			{
				GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
				gmfe.clear ();
				gmfe.setOrderByClause ("id");
				gmfe.createCriteria ().andModuleIdEqualTo (module);
				List <GoodsModuleFloor> floorList = goodsModuleFloorService.getObjectList (gmfe);
				response.setContentType ("text/plain");
				response.setHeader ("Cache-Control" , "no-cache");
				response.setCharacterEncoding ("UTF-8");
				try
				{
					PrintWriter writer = response.getWriter ();
					writer.print (Json.toJson (floorList , JsonFormat.compact ()));
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
		}


	// 商品模块第三级级联显示省份
	@RequestMapping({ "/seller/provByFloor.htm" })
	public void searchByFloorId (	HttpServletRequest request , HttpServletResponse response , Integer floorId)
		{
			if (floorId != null && floorId > 0)
			{
				GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
				gmfne.clear ();
				gmfne.createCriteria ().andFlooridEqualTo (floorId);
				List <GoodsModuleFloorNext> nextList = goodsModuleFloorNextService.getObjectList (gmfne);
				List <Area> areas = new ArrayList <Area> ();
				for (GoodsModuleFloorNext goodsModuleFloorNext : nextList)
				{
					Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
					areas.add (area);
				}
				response.setContentType ("text/plain");
				response.setHeader ("Cache-Control" , "no-cache");
				response.setCharacterEncoding ("UTF-8");
				try
				{
					PrintWriter writer = response.getWriter ();
					writer.print (Json.toJson (areas , JsonFormat.compact ()));
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
		}


	@SecurityMapping(title = "模糊查询商品品牌" , value = "/seller/brandByname.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/brandByname.htm" })
	public void searchBybrandName (	HttpServletRequest request , HttpServletResponse response , String brandName)
		{
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			goodsBrandExample.setOrderByClause ("sequence asc");
			if (brandName != null && !"".equals (brandName))
			{
				goodsBrandExample.createCriteria ().andNameLike ("%" + brandName + "%");
			}
			List <GoodsBrand> list = goodsBrandService.getObjectList (goodsBrandExample);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (list , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}


	@SuppressWarnings("unchecked")
	public static GoodsSpecProperty [ ][ ] list2group (	List <List <GoodsSpecProperty>> list)
		{
			GoodsSpecProperty [ ][ ] gps = new GoodsSpecProperty [list.size ()] [ ];
			for (int i = 0 ; i < list.size () ; i++)
			{
				gps[i] = ((GoodsSpecProperty [ ]) ((List) list.get (i)).toArray (new GoodsSpecProperty [((List) list.get (i)).size ()]));
			}
			return gps;
		}


	@SuppressWarnings("unused")
	private List <List <GoodsSpecProperty>> generic_spec_property (	Set <GoodsSpecification> specs)
		{
			List <List <GoodsSpecProperty>> result_list = new ArrayList <List <GoodsSpecProperty>> ();
			List <List <GoodsSpecProperty>> list = new ArrayList <List <GoodsSpecProperty>> ();
			int max = 1;
			for (GoodsSpecification spec : specs)
			{
				list.add (spec.getProperties ());
			}
			GoodsSpecProperty [ ][ ] gsps = list2group (list);
			for (int i = 0 ; i < gsps.length ; i++)
			{
				max *= gsps[i].length;
			}
			for (int i = 0 ; i < max ; i++)
			{
				List <GoodsSpecProperty> temp_list = new ArrayList <GoodsSpecProperty> ();
				int temp = 1;
				for (int j = 0 ; j < gsps.length ; j++)
				{
					temp *= gsps[j].length;
					temp_list.add (j , gsps[j][(i / (max / temp) % gsps[j].length)]);
				}
				GoodsSpecProperty [ ] temp_gsps = (GoodsSpecProperty [ ]) temp_list.toArray (new GoodsSpecProperty [temp_list.size ()]);
				Arrays.sort (temp_gsps , new Comparator <Object> ()
				{

					public int compare (Object obj1 , Object obj2)
						{
							GoodsSpecProperty a = (GoodsSpecProperty) obj1;
							GoodsSpecProperty b = (GoodsSpecProperty) obj2;
							if (a.getSpec ().getSequence ().equals (b.getSpec ().getSequence ()))
							{
								return 0;
							}
							return a.getSpec ().getSequence () > b.getSpec ().getSequence () ? 1 : -1;
						}
				});
				result_list.add (Arrays.asList (temp_gsps));
			}
			return result_list;
		}


	/**
	 * 图片上传
	 * 
	 * @param request
	 * @param response
	 * @param user_id
	 *            用户id
	 * @param album_id
	 *            图片id
	 */
	@RequestMapping({ "/seller/swf_upload.htm" })
	public void swf_upload (HttpServletRequest request , HttpServletResponse response , String user_id ,
							String album_id , String goodsId)
		{
			User user = this.userService.getByKey (CommUtil.null2Long (user_id));
			/* 当时编辑时 检查图片是否满5张了 */
			if (!StringUtils.isEmpty (goodsId))
			{
				Goods2PhotoExample goodsPhotoExample = new Goods2PhotoExample ();
				goodsPhotoExample.createCriteria ().andGoodsIdEqualTo (Long.valueOf (goodsId));
				List <Goods2Photo> listGoods2Photo = this.goods2PhotoService.getObjectList (goodsPhotoExample);
				if (listGoods2Photo.size () >= 5)
				{
					try
					{
						String json = null;
						response.getWriter ().println (json);
					}
					catch (IOException e)
					{
						e.printStackTrace ();
					}
				}
			}
			String path = this.storeTools.createUserFolder (request , // 创建文件夹
																		// 并获得文件存储时的绝对路径
					this.configService.getSysConfig () , user.getStore ());
			String url = this.storeTools.createUserFolderURL ( // 获得文件存储时
																// 文件夹的相对路径
			this.configService.getSysConfig () , user.getStore ());
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile ("imgFile");
			double fileSize = Double.valueOf (file.getSize ()).doubleValue ();
			fileSize /= 1048576.0D;
			double csize = CommUtil.fileSize (new File (path));
			double remainSpace = 0.0D;
			if (user.getStore ().getGrade ().getSpacesize () != 0.0F)
				remainSpace = (user.getStore ().getGrade ().getSpacesize () * 1024.0F - csize) * 1024.0D;			// 计算用户店铺剩余文件上传空间大小
			else
			{
				remainSpace = 10000000.0D; // 10M
			}
			Map <String, Object> json_map = new HashMap <String, Object> ();
			if (remainSpace > fileSize)
			{												// 用户店铺剩余文件上传空间大小 大于文件大小 才容许上传
				try
				{
					Map <String, Object> map = CommUtil.saveGoodsImgToServer (request , "imgFile" , path ,         // 保存图片到服务器
							// ，并返回参数到map
							null , null);
					json_map.put ("width" , CommUtil.null2Int (map.get ("compWidth")));// 宽度
					json_map.put ("height" , CommUtil.null2Int (map.get ("compHeight")));// 高度
					json_map.put ("size" , CommUtil.null2Int (map.get ("compFileSize")));// 图片文件大小
					Accessory image = new Accessory ();
					image.setAddtime (new Date ());
					image.setExt ((String) map.get ("mime"));
					image.setPath (url);
					image.setWidth (CommUtil.null2Int (map.get ("compWidth")));
					image.setHeight (CommUtil.null2Int (map.get ("compHeight")));
					image.setName (CommUtil.null2String (map.get ("compFileName")));
					image.setSize (CommUtil.null2Float (map.get ("compFileSize")));
					image.setUser (user);
					/*
					 * Album album = null;
					 * AlbumExample albumExample = new AlbumExample();
					 * if ((album_id != null) &&
					 * (!album_id.equals(""))) {
					 * album = this.albumService.getByKey(CommUtil
					 * .null2Long(album_id));
					 * } else {
					 * albumExample.clear();
					 * albumExample.createCriteria()
					 * .andUserIdEqualTo(user.getId());
					 * List<Album> albums = this.albumService
					 * .getObjectList(albumExample);
					 * if (albums.size() > 0 && albums != null)
					 * album = albums.get(0);
					 * if (album == null) {
					 * album = new Album();
					 * album.setAddtime(new Date());
					 * album.setAlbumName("默认相册");
					 * album.setAlbumSequence(-10000);
					 * album.setAlbumDefault(true);
					 * this.albumService.add(album);
					 * }
					 * }
					 * image.setAlbum(album);
					 */
					this.accessoryService.add (image);
					Accessory srcImage = new Accessory ();
					srcImage.setAddtime (new Date ());
					srcImage.setExt ((String) map.get ("mime"));
					srcImage.setPath (url);
					srcImage.setWidth (CommUtil.null2Int (map.get ("srcWidth")));
					srcImage.setHeight (CommUtil.null2Int (map.get ("srcHeight")));
					srcImage.setName (CommUtil.null2String (map.get ("srcFileName")));
					srcImage.setSize (CommUtil.null2Float (map.get ("srcFileSize")));
					srcImage.setUser (user);
					this.accessoryService.add (srcImage);
					json_map.put ("url" , this.configService.getSysConfig ().getImagewebserver () + "/" + url + "/" + image.getName ());									// 图片全路径
					json_map.put ("id" , image.getId ());							// 图片id
					json_map.put ("remainSpace" , Double							// 剩余上传空间大小
					.valueOf (remainSpace == 10000.0D ? 0.0D : remainSpace));
					// json_map.put("aa", 123);
					String ext = image.getExt ().indexOf (".") < 0 ? "." + image.getExt () : image.getExt ();
					String source = this.configService.getSysConfig ().getUploadRootPath () + image.getPath () + File.separator + image.getName ();
					String target = source + "_small" + ext; // 图片的完整绝对路径+图片名+_small+后缀
					CommUtil.createSmall (source , target , this.configService			// 创建并保存小尺寸图片
					.getSysConfig ().getSmallwidth () , this.configService.getSysConfig ().getSmallheight ());
					String midext = image.getExt ().indexOf (".") < 0 ? "." // 截取文件格式类型
							+ image.getExt () : image.getExt ();
					String midtarget = source + "_middle" + ext; // 图片的完整绝对路径+图片名+_middle+后缀
					CommUtil.createSmall (source , midtarget , this.configService			// 创建并保存中等尺寸图片
					.getSysConfig ().getMiddlewidth () , this.configService.getSysConfig ().getMiddleheight ());
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
			else
			{
				json_map.put ("url" , "");
				json_map.put ("id" , "");
				json_map.put ("remainSpace" , Integer.valueOf (0));
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (json_map));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}


	@SecurityMapping(title = "商品图片删除" , value = "/seller/goods_image_del.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_image_del.htm" })
	public void goods_image_del (	HttpServletRequest request , HttpServletResponse response , String image_id)
		{
			if (!StringUtils.isEmpty (image_id))
			{
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				String path = this.storeTools.createUserFolder (request , this.configService.getSysConfig () , user.getStore ());
				response.setContentType ("text/plain");
				response.setHeader ("Cache-Control" , "no-cache");
				response.setCharacterEncoding ("UTF-8");
				try
				{
					Map <String, Number> map = new HashMap <String, Number> ();
					Accessory img = this.accessoryService.getByKey (CommUtil.null2Long (image_id));
					for (GoodsWithBLOBs goods : img.getGoods_main_list ())
					{
						goods.setGoodsMainPhoto (null);
						this.goodsService.updateByObject (goods);
					}
					for (GoodsWithBLOBs goods1 : img.getGoods_list ())
					{
						goods1.getGoodsPhotos ().remove (img);
						this.goodsService.updateByObject (goods1);
					}
					Integer ret = this.accessoryService.deleteByKey (img.getId ());
					Goods2PhotoExample goods2PhotoExample = new Goods2PhotoExample ();
					goods2PhotoExample.clear ();
					goods2PhotoExample.createCriteria ().andPhotoIdEqualTo (Long.valueOf (image_id.trim ()));
					System.out.println ("开始删除:______" + image_id);
					this.goods2PhotoService.deleteByExample (goods2PhotoExample);
					System.out.println ("结束删除:______" + image_id);
					if (ret > 0)
					{
						CommUtil.del_acc (request , img , this.configService.getSysConfig ().getUploadRootPath ());
					}
					double csize = CommUtil.fileSize (new File (path));
					double remainSpace = 10000.0D;
					if (user.getStore ().getGrade ().getSpacesize () != 0.0F)
					{
						remainSpace = CommUtil.div (Double.valueOf (user.getStore ().getGrade ().getSpacesize () * 1024.0F - csize) , Integer.valueOf (1024));
					}
					map.put ("result" , ret);
					map.put ("remainSpace" , Double.valueOf (remainSpace));
					PrintWriter writer = response.getWriter ();
					writer.print (Json.toJson (map));
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
			}
		}


	private String clearContent (	String inputString)
		{
			String htmlStr = inputString;
			String textStr = "";
			try
			{
				String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>";
				String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>";
				String regEx_html = "<[^>]+>";
				String regEx_html1 = "<[^>]+";
				Pattern p_script = Pattern.compile (regEx_script , 2);
				Matcher m_script = p_script.matcher (htmlStr);
				htmlStr = m_script.replaceAll ("");
				Pattern p_style = Pattern.compile (regEx_style , 2);
				Matcher m_style = p_style.matcher (htmlStr);
				htmlStr = m_style.replaceAll ("");
				Pattern p_html = Pattern.compile (regEx_html , 2);
				Matcher m_html = p_html.matcher (htmlStr);
				htmlStr = m_html.replaceAll ("");
				Pattern p_html1 = Pattern.compile (regEx_html1 , 2);
				Matcher m_html1 = p_html1.matcher (htmlStr);
				htmlStr = m_html1.replaceAll ("");
				textStr = htmlStr;
			}
			catch (Exception e)
			{
				System.err.println ("Html2Text: " + e.getMessage ());
			}
			return textStr;
		}


	@SecurityMapping(title = "发布商品第三步" , value = "/seller/add_goods_finish.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/add_goods_finish.htm" })
	public ModelAndView add_goods_finish (	HttpServletRequest request , HttpServletResponse response , String id ,
											Integer goods_class_id , String image_ids , String goods_main_img_id ,
											String user_class_ids , String goods_brand_id , String goods_spec_ids ,
											String goods_properties , String intentory_details , String goods_session ,
											String transportType , String transportId , String specNeed ,
											String storeNavId , Integer refundServerTime , Integer moduleId ,
											Integer proviceId , String goodsRate , String isDou , String beanRate , String goodsInfo)
		{
			ModelAndView mv = null;
			String goods_session1 = CommUtil.null2String (request.getSession (false).getAttribute ("goods_session"));
			if (goods_session1.equals (""))
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "禁止重复提交表单");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			else if (goods_session1.equals (goods_session))
			{
				if ((id == null) || (id.equals ("")))
				{
					mv = new JModelAndView ("seller/add_goods_finish.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				}
				else
				{
					mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
					mv.addObject ("op_title" , "商品编辑成功");
					mv.addObject ("url" , CommUtil.getURL (request) + "/goods_" + id + ".htm");
				}
				WebForm wf = new WebForm ();
				GoodsWithBLOBs goods = null;
				if (null != id && id.equals (""))
				{
					goods = (GoodsWithBLOBs) wf.toPo (request , GoodsWithBLOBs.class);
					goods.setAddtime (new Date ());
					goods.setGoodsRate(new BigDecimal(Globals.FINANCIAL_GOLD_RATE_TWO));
					User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
					goods.setGoodsStore (user.getStore ());
				}
				else
				{
					GoodsWithBLOBs obj = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					goods = (GoodsWithBLOBs) wf.toPo (request , obj);
					goods.getGoodsSpecs ().clear ();						// 更具商品id清空规格中间表数据
					// goods.setGoodsStatus (4);
					goods.setGoodsStatus (Globals.NUBER_ZERO);
					goods.setGoodsRate (goodsRate == null ? new BigDecimal(Globals.FINANCIAL_GOLD_RATE_TWO) : new BigDecimal(goodsRate));
					/*if (!StringUtils.isEmpty (goodsRate))
					{
						goods.setGoodsRate (new BigDecimal (goodsRate));
					}*/
					Goods2SpecExample g2sExample = new Goods2SpecExample ();
					g2sExample.clear ();
					g2sExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
					goods2SpecSerivce.deleteByExample (g2sExample);
					Goods2UgcExample g2uExample = new Goods2UgcExample ();
					g2uExample.clear ();
					g2uExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
					goods2UserGoodsClassService.deleteByExample (g2uExample);
				}
				if (Double.valueOf (beanRate) > 0)
				{
					goods.setAcceptBean (true);
				}
				if (!StringUtils.isEmpty (beanRate))
				{
					goods.setBeanRate (new BigDecimal (beanRate));
				}
				if ((goods.getCombinStatus () != 2) && (goods.getDeliveryStatus () != 2) && (goods.getBargainStatus () != 2) && (goods.getActivityStatus () != 2))
				{
					goods.setGoodsCurrentPrice (goods.getStorePrice ());
				}
				goods.setRefundServerTime (refundServerTime);
				goods.setGoodsName (clearContent (goods.getGoodsName ()));
				if(cn.jpush.api.utils.StringUtils.isNotEmpty(goodsInfo)){
					goods.setGoodsInfo(goodsInfo);
				}
				GoodsClassWithBLOBs gc = null;
				if (goods_class_id == null)
				{
					gc = this.goodsClassService.getByKey (null);
				}
				else
				{
					gc = this.goodsClassService.getByKey (Long.valueOf (goods_class_id));
				}
				goods.setGc (gc);
				// 商品主图
				Accessory main_img = null;
				if ((goods_main_img_id != null) && (!goods_main_img_id.equals ("")))
				{
					main_img = this.accessoryService.getByKey (Long.valueOf (Long.parseLong (goods_main_img_id)));
					goods.setGoodsMainPhoto (main_img);
					goods.setGoodsMainPhotoId (main_img.getId ());
				}
				goods.getGoodsUgcs ().clear ();
				String [ ] ugc_ids = user_class_ids.split (",");
				String [ ] arrayOfString1 = ugc_ids;
				if (arrayOfString1.length > 0)
				{
					for (int i = 0 ; i < arrayOfString1.length ; i++)
					{
						String ugc_id = arrayOfString1[i];
						// Goods2Ugc g2u = new Goods2Ugc ();
						if (!ugc_id.equals (""))
						{
							UserGoodsClass ugc1 = this.userGoodsClassService.getByKey (Long.valueOf (Long.parseLong (ugc_id)));
							goods.getGoodsUgcs ().add (ugc1);
						}
					}
				}
				// 商品详情图
				String [ ] img_ids = image_ids.split (",");
				goods.getGoodsPhotos ().clear ();
				for (int j = 0 , len = img_ids.length ; j < len ; j++)
				{
					if (!img_ids[j].equals (""))
					{
						Accessory img2 = this.accessoryService.getByKey (Long.valueOf (Long.parseLong (img_ids[j])));
						goods.getGoodsPhotos ().add (img2);
					}
				}
				if ((goods_brand_id != null) && (!goods_brand_id.equals ("")))
				{
					GoodsBrand goods_brand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (goods_brand_id)));
					goods.setGoodsBrand (goods_brand);
				}
				String [ ] spec_ids = goods_spec_ids.split (",");
				for (int i = 0 ; i < spec_ids.length ; i++)
				{			// 将商品和规格属性数据加入到中间表
					String spec_id = spec_ids[i];
					// Goods2Spec g2s = new Goods2Spec ();
					if (!spec_id.equals (""))
					{
						GoodsSpecProperty gsp = this.specPropertyService.getByKey (Long.valueOf (Long.parseLong (spec_id)));
						goods.getGoodsSpecs ().add (gsp);
					}
				}
				/* 设置规格属性 */
				goods.setGoodsProperty (goods_properties);
				// 设置商品模块楼层ID
				if (proviceId == null)
				{
					goods.setModuleId (moduleId);
				}
				else
				{
					GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
					gmfne.clear ();
					gmfne.createCriteria ().andAreaidEqualTo (proviceId);
					goodsModuleFloorNextService.getObjectList (gmfne);
					if (!goodsModuleFloorNextService.getObjectList (gmfne).isEmpty ())
					{
						goods.setModuleId (goodsModuleFloorNextService.getObjectList (gmfne).get (0).getId ());
					}
					else
					{
						mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
						mv.addObject ("op_title" , "商品模块要选择具体分类！");
						mv.addObject ("url" , CommUtil.getURL (request) + "/seller/add_goods_first.htm");
						return mv;
					}
				}
				List <Map <String, String>> maps = new ArrayList <Map <String, String>> ();
				maps.clear ();
				String [ ] inventory_list = intentory_details.split (";");
				for (int i = 0 ; i < inventory_list.length ; i++)
				{
					String inventory = inventory_list[i];
					if (!inventory.equals (""))
					{
						String [ ] list2 = inventory.split (",");
						Map <String, String> map = new HashMap <String, String> ();
						map.put ("id" , list2[0]);
						map.put ("count" , list2[1]);
						map.put ("price" , list2[2]);
						maps.add (map);
					}
				}
				goods.setGoodsInventoryDetail (Json.toJson (maps , JsonFormat.compact ()));
				if (CommUtil.null2Int (transportType) == 0)
				{
					TransportWithBLOBs trans = this.transportService.getByKey (CommUtil.null2Long (transportId));
					goods.setTransport (trans);
				}
				if (CommUtil.null2Int (transportType) == 1)
				{
					goods.setTransport (null);
					goods.setGoodsTransfee (Globals.NUBER_ONE);
				}
				if (id.equals (""))
				{
					// goods.setGoodsStatus(1);//发布商品后不能及时的上架，需到仓库中点击上架才可以
					// String goodsDetail =
					// goods.getGoodsDetails().replace("/upload",
					// this.configService.getSysConfig().getImagewebserver()+"/upload");
					// goods.setGoodsDetails(goodsDetail);
					if (moduleId != null)
					{
						long ids = (long) moduleId;
						GoodsModuleFloor floor = goodsModuleFloorService.getByKey (ids);
						if (floor != null)
						{
							// goods.setGoodsStatus (4);
							goods.setGoodsStatus (Globals.NUBER_ZERO);
							/*
							 * if(floor.getModuleId()==3){ //海外购
							 * goods.setGoodsStatus(3);
							 * }
							 * if(floor.getModuleId()==1){ //土特产
							 * goods.setGoodsStatus(4);
							 * }
							 * if(floor.getModuleId()==2){ //新奇特
							 * goods.setGoodsStatus(5);
							 * }
							 * if(floor.getModuleId()==4){ //大健康
							 * goods.setGoodsStatus(6);
							 * }
							 * if(floor.getModuleId()==9999){ //特卖场
							 * goods.setGoodsStatus(7);
							 * }
							 */
						}
					}
					this.goodsService.add (goods);
					// 将商品图片信息存入中间表
					List <Accessory> list = goods.getGoodsPhotos ();
					for (Accessory a : list)
					{
						Goods2Photo g2p = new Goods2Photo ();
						g2p.setGoodsId (goods.getId ());
						g2p.setPhotoId (a.getId ());
						this.goods2PhotoService.add (g2p);
					}
					Goods2UgcExample g2uExample = new Goods2UgcExample ();
					g2uExample.clear ();
					g2uExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
					goods2UgcService.deleteByExample (g2uExample);
					// for (int i = 0 ; i < arrayOfString1.length ;
					// i++)
					// {
					// System.out.print (arrayOfString1[i]);
					// Goods2Ugc goods2Ugc = new Goods2Ugc ();
					// if (!"".equals (arrayOfString1[i]) &&
					// arrayOfString1[i] != null)
					// {
					// /*
					// * goods2Ugc.setGoodsId(goods.getId());
					// *
					// goods2Ugc.setClassId(Long.valueOf(Long.parseLong(arrayOfString1[i])));
					// *
					// this.goods2UserGoodsClassService.add(goods2Ugc);
					// */
					// }
					// }
					// 设置商品评分
					GoodsPoint gp = new GoodsPoint ();
					gp.setDescriptionEvaluate (new BigDecimal (5.0));
					gp.setServiceEvaluate (new BigDecimal (5.0));
					gp.setShipEvaluate (new BigDecimal (5.0));
					gp.setGoods (goods);
					goodsPointService.add (gp);
					goods.setPoint (gp);
					goodsService.updateByObject (goods);
					String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
					File file = new File (goods_lucene_path);
					if (!file.exists ())
					{
						CommUtil.createFolder (goods_lucene_path);
					}
					LuceneVo vo = new LuceneVo ();
					vo.setVo_id (goods.getId ());
					vo.setVo_title (goods.getGoodsName ());
					vo.setVo_content (goods.getGoodsDetails ());
					vo.setVo_type ("goods");
					vo.setVo_store_price (CommUtil.null2Double (goods.getStorePrice ()));
					vo.setVo_add_time (goods.getAddtime ().getTime ());
					vo.setVo_goods_salenum (goods.getGoodsSalenum ());   // 商品销量
					LuceneUtil lucene = LuceneUtil.instance ();
					LuceneUtil.setIndex_path (goods_lucene_path);
					lucene.writeIndex (vo);
				}
				else
				{
					this.goodsService.updateByObject (goods);
					// 清除中间表amall_goods_photo所有该商品数据
					Goods2PhotoExample example = new Goods2PhotoExample ();
					example.clear ();
					example.createCriteria ().andGoodsIdEqualTo (goods.getId ());
					this.goods2PhotoService.deleteByExample (example);
					// 更新商品图片
					List <Accessory> list = goods.getGoodsPhotos ();
					for (Accessory a : list)
					{
						Goods2Photo g2p = new Goods2Photo ();
						g2p.setGoodsId (goods.getId ());
						g2p.setPhotoId (a.getId ());
						this.goods2PhotoService.add (g2p);
					}
					Goods2UgcExample goods2UgcExample = new Goods2UgcExample ();
					for (int i = 0 ; i < arrayOfString1.length ; i++)
					{
						Goods2Ugc goods2Ugc = new Goods2Ugc ();
						if (!"".equals (arrayOfString1[i]) && arrayOfString1[i] != null)
						{
							goods2Ugc.setGoodsId (goods.getId ());
							goods2Ugc.setClassId (Long.valueOf (Long.parseLong (arrayOfString1[i])));
							goods2UgcExample.clear ();
							goods2UgcExample.createCriteria ().andClassIdEqualTo (Long.valueOf (Long.parseLong (arrayOfString1[i]))).andGoodsIdEqualTo (Long.valueOf (goods.getId ()));
							this.goods2UserGoodsClassService.updateByExample (goods2Ugc , goods2UgcExample);
						}
					}
					String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
					File file = new File (goods_lucene_path);
					if (!file.exists ())
					{
						CommUtil.createFolder (goods_lucene_path);
					}
					LuceneVo vo = new LuceneVo ();
					vo.setVo_id (goods.getId ());
					vo.setVo_title (goods.getGoodsName ());
					vo.setVo_content (goods.getGoodsDetails ());
					vo.setVo_type ("goods");
					vo.setVo_store_price (CommUtil.null2Double (goods.getStorePrice ()));
					vo.setVo_add_time (goods.getAddtime ().getTime ());
					vo.setVo_goods_salenum (goods.getGoodsSalenum ());
					LuceneUtil lucene = LuceneUtil.instance ();
					LuceneUtil.setIndex_path (goods_lucene_path);
					lucene.update (CommUtil.null2String (goods.getId ()) , vo);
				}
				mv.addObject ("obj" , goods);
				request.getSession (false).removeAttribute ("goods_session");
				request.getSession (false).removeAttribute ("goods_class_info");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "参数错误");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			return (ModelAndView) mv;
		}


	@SecurityMapping(title = "加载商品分类" , value = "/seller/load_goods_class.htm*" , rtype = "seller" , rname = "商品发布" ,
						rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/load_goods_class.htm" })
	public void load_goods_class (	HttpServletRequest request , HttpServletResponse response , String pid ,
									String session)
		{
			GoodsClassWithBLOBs obj = this.goodsClassService.getByKey (CommUtil.null2Long (pid)); // 根据id查询本类的分类
			GoodsClassExample goodsClassExample = new GoodsClassExample (); // 查询子分类
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdEqualTo (CommUtil.null2Long (pid));
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
			if (CommUtil.null2Boolean (session) && obj != null)
			{
				request.getSession (false).setAttribute ("goods_class_info" , obj);
			}
			if (gcs != null && gcs.size () > 0)
			{
				for (GoodsClassWithBLOBs gc : gcs)
				{
					Map <String, Object> map = new HashMap <String, Object> ();
					map.put ("id" , gc.getId ());
					map.put ("classname" , gc.getClassname ());
					list.add (map);
				}
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (list));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}


	@SecurityMapping(title = "添加用户常用商品分类" , value = "/seller/load_goods_class.htm*" , rtype = "seller" ,
						rname = "商品发布" , rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/add_goods_class_staple.htm" })
	public void add_goods_class_staple (HttpServletRequest request , HttpServletResponse response)
		{
			String ret = "error";
			if (request.getSession (false).getAttribute ("goods_class_info") != null)
			{
				GoodsClassWithBLOBs gc = (GoodsClassWithBLOBs) request.getSession (false).getAttribute ("goods_class_info");
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				GoodsClassStapleExample goodsClassStapleExample = new GoodsClassStapleExample ();
				goodsClassStapleExample.clear ();
				goodsClassStapleExample.createCriteria ().andStoreIdEqualTo (user.getStore ().getId ()).andGcIdEqualTo (gc.getId ());
				List <GoodsClassStaple> gcs = goodsclassstapleService.getObjectList (goodsClassStapleExample);
				if (gcs.size () == 0)
				{
					GoodsClassStaple staple = new GoodsClassStaple ();
					staple.setAddtime (new Date ());
					staple.setGc (gc);
					String name = generic_goods_class_info (gc);
					staple.setName (name.substring (0 , name.length () - 1));
					staple.setStore (user.getStore ());
					Long flag = this.goodsclassstapleService.add (staple);
					if (flag > 0)
					{
						Map <String, Object> map = new HashMap <String, Object> ();
						map.put ("name" , staple.getName ());
						map.put ("id" , staple.getId ());
						ret = Json.toJson (map);
					}
				}
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
				e.printStackTrace ();
			}
		}


	@SecurityMapping(title = "删除用户常用商品分类" , value = "/seller/del_goods_class_staple.htm*" , rtype = "seller" ,
						rname = "商品发布" , rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/del_goods_class_staple.htm" })
	public void del_goods_class_staple (HttpServletRequest request , HttpServletResponse response , String id)
		{
			Integer ret = this.goodsclassstapleService.deleteByKey (Long.valueOf (Long.parseLong (id)));
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
				e.printStackTrace ();
			}
		}


	@SecurityMapping(title = "根据用户常用商品分类加载分类信息" , value = "/seller/del_goods_class_staple.htm*" , rtype = "seller" ,
						rname = "商品发布" , rcode = "goods_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/load_goods_class_staple.htm" })
	public void load_goods_class_staple (	HttpServletRequest request , HttpServletResponse response , String id ,
											String name)
		{
			// 搜索时 name传入时 乱码
			GoodsClassWithBLOBs obj = null;
			if ((id != null) && (!id.equals ("")))
				obj = this.goodsclassstapleService.getByKey (Long.valueOf (Long.parseLong (id))).getGc ();
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			if ((name != null) && (!name.equals ("")))
				goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andClassnameEqualTo (name);
			List <GoodsClassWithBLOBs> goodsclasses = goodsClassService.getObjectList (goodsClassExample);
			if (null != goodsclasses && goodsclasses.size () > 0)
				obj = goodsclasses.get (0);
			// obj =
			// this.goodsClassService.getObjByProperty("className",
			// name);
			List <List <Map <String, Object>>> list = new ArrayList <List <Map <String, Object>>> ();
			if (obj != null)
			{
				request.getSession (false).setAttribute ("goods_class_info" , obj);
				List <Map <String, Object>> second_list = new ArrayList <Map <String, Object>> ();
				List <Map <String, Object>> third_list = new ArrayList <Map <String, Object>> ();
				List <Map <String, Object>> other_list = new ArrayList <Map <String, Object>> ();
				Object gc;
				if (obj.getLevel () == 2)
				{
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (obj.getParent ().getParentId ());
					goodsClassExample.setOrderByClause ("sequence asc");
					List <GoodsClassWithBLOBs> second_gcs = goodsClassService.getObjectList (goodsClassExample);
					for (GoodsClass gc1 : second_gcs)
					{
						Map <String, Object> map = new HashMap <String, Object> ();
						map.put ("id" , gc1.getId ());
						map.put ("className" , gc1.getClassname ());
						second_list.add (map);
					}
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (obj.getParentId ());
					goodsClassExample.setOrderByClause ("sequence asc");
					List <GoodsClassWithBLOBs> third_gcs = goodsClassService.getObjectList (goodsClassExample);
					for (Iterator <?> iter = third_gcs.iterator () ; iter.hasNext () ;)
					{
						gc = (GoodsClassWithBLOBs) iter.next ();
						Map <String, Object> map = new HashMap <String, Object> ();
						map.put ("id" , ((GoodsClassWithBLOBs) gc).getId ());
						map.put ("className" , ((GoodsClassWithBLOBs) gc).getClassname ());
						third_list.add (map);
					}
				}
				if (obj.getLevel () == 1)
				{
					/*
					 * params.clear(); params.put("pid",
					 * obj.getParent().getId());
					 * List third_gcs = this.goodsClassService .query(
					 * "select obj from GoodsClass obj where obj.parent.id=:pid order by obj.sequence asc"
					 * , params, -1, -1);
					 */
					goodsClassExample.clear ();
					goodsClassExample.createCriteria ().andParentIdEqualTo (obj.getParentId ());
					goodsClassExample.setOrderByClause ("sequence asc");
					List <GoodsClassWithBLOBs> third_gcs = goodsClassService.getObjectList (goodsClassExample);
					for (gc = third_gcs.iterator () ; ((Iterator <?>) gc).hasNext () ;)
					{
						GoodsClass gc2 = (GoodsClass) ((Iterator <?>) gc).next ();
						Map <String, Object> map = new HashMap <String, Object> ();
						map.put ("id" , gc2.getId ());
						map.put ("className" , gc2.getClassname ());
						second_list.add (map);
					}
				}
				Map <String, Object> map = new HashMap <String, Object> ();
				String staple_info = generic_goods_class_info (obj);
				map.put ("staple_info" , staple_info.substring (0 , staple_info.length () - 1));
				other_list.add (map);
				list.add (second_list);
				list.add (third_list);
				list.add (other_list);
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (list , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}


	private String generic_goods_class_info (	GoodsClassWithBLOBs gc)
		{
			String goods_class_info = gc.getClassname () + ">";
			if (gc.getParent () != null)
			{
				String class_info = generic_goods_class_info (gc.getParent ());
				goods_class_info = class_info + goods_class_info;
			}
			return goods_class_info;
		}


	@SecurityMapping(title = "出售中的商品列表" , value = "/seller/seller_goods.htm*" , rtype = "seller" , rname = "出售中的商品" ,
						rcode = "goods_list_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/seller_goods.htm" })
	public ModelAndView goods (	HttpServletRequest request , HttpServletResponse response , String currentPage ,
								String orderBy , String orderType , String goods_name , String user_class_id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/goods.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = CommUtil.getURL (request);
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			String params = "";
			StoreWithBLOBs store = storeService.getByKey (user.getStore ().getId ());
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause ("addTime desc");
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
			}
			/*
			 * if ((user_class_id != null) &&
			 * (!user_class_id.equals(""))) {
			 * List<Goods2Ugc> goods2UgcList = new
			 * ArrayList<Goods2Ugc>();
			 * List<Long> ids = new ArrayList<Long>();
			 * Goods2UgcExample goods2UgcExample = new
			 * Goods2UgcExample();
			 * goods2UgcExample.clear();
			 * goods2UgcExample.createCriteria().andClassIdEqualTo(Long
			 * .valueOf(Long.parseLong(user_class_id)));
			 * goods2UgcList =
			 * goods2UserGoodsClassService.getObjectList
			 * (goods2UgcExample);
			 * for(Goods2Ugc goods2Ugc : goods2UgcList){
			 * ids.add(goods2Ugc.getGoodsId());
			 * }
			 * goodsCriteria.andIdIn(ids);
			 * }
			 */
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/seller/seller_goods.htm" , "" , params , pList , mv);
			mv.addObject ("storeTools" , this.storeTools);
			mv.addObject ("goodsViewTools" , this.goodsViewTools);
			return mv;
		}


	@SecurityMapping(title = "仓库中的商品列表" , value = "/seller/seller_goods_storage.htm*" , rtype = "seller" ,
						rname = "仓库中的商品" , rcode = "goods_storage_seller" , rgroup = "商品管理" , display = false ,
						rsequence = 0)
	@RequestMapping({ "/seller/seller_goods_storage.htm" })
	public ModelAndView goods_storage (	HttpServletRequest request , HttpServletResponse response , String currentPage ,
										String orderBy , String orderType , String goods_name , String user_class_id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/goods_storage.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause ("addTime desc");
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (1)).andGoodsStoreIdEqualTo (user.getStore ().getId ()).andDeletestatusEqualTo (false);
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name.trim () + "%");
			}
			if ((user_class_id != null) && (!user_class_id.equals ("")))
			{
				UserGoodsClass ugc = this.userGoodsClassService.getByKey (Long.valueOf (Long.parseLong (user_class_id)));
				goodsCriteria.andGcIdEqualTo (ugc.getId ());
			}
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/seller/seller_goods_storage.htm" , "" , params , pList , mv);
			mv.addObject ("storeTools" , this.storeTools);
			mv.addObject ("goodsViewTools" , this.goodsViewTools);
			return mv;
		}


	@SecurityMapping(title = "违规下架商品" , value = "/seller/goods_out.htm*" , rtype = "seller" , rname = "违规下架商品" ,
						rcode = "goods_out_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_out.htm" })
	public ModelAndView goods_out (	HttpServletRequest request , HttpServletResponse response , String currentPage ,
									String orderBy , String orderType , String goods_name , String user_class_id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/goods_out.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			String params = "";
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause ("goods_seller_time desc");
			Store store = storeService.getByKey ((Long) user.getStore ().getId ());
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (-2)).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			if ((goods_name != null) && (!goods_name.equals ("")))
			{
				goodsCriteria.andGoodsNameLike ("%" + goods_name + "%");
			}
			if ((user_class_id != null) && (!user_class_id.equals ("")))
			{
				UserGoodsClass ugc = this.userGoodsClassService.getByKey (Long.valueOf (Long.parseLong (user_class_id)));
				goodsCriteria.andGcIdEqualTo (ugc.getId ());
			}
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/seller/goods_out.htm" , "" , params , pList , mv);
			mv.addObject ("storeTools" , this.storeTools);
			mv.addObject ("goodsViewTools" , this.goodsViewTools);
			return mv;
		}


	@SecurityMapping(title = "商品编辑" , value = "/seller/goods_edit.htm*" , rtype = "seller" , rname = "商品编辑" ,
						rcode = "goods_edit_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_edit.htm" })
	public ModelAndView goods_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/add_goods_second.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClass gc = null;
			GoodsWithBLOBs obj = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
			if (obj.getGoodsStore ().getUserId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
			{
				User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
				String path = this.configService.getSysConfig ().getUploadRootPath () + File.separator + "upload" + File.separator + "store" + File.separator + user.getStore ().getId ();
				double img_remain_size = user.getStore ().getGrade ().getSpacesize () - CommUtil.div (Double.valueOf (CommUtil.fileSize (new File (path))) , Integer.valueOf (1024));
				UserGoodsClassExample userGoodsClassExample = new UserGoodsClassExample ();
				userGoodsClassExample.clear ();
				userGoodsClassExample.setOrderByClause ("sequence asc");
				userGoodsClassExample.createCriteria ().andUserIdEqualTo (user.getId ())        // user.getDirectRefer()
				.andDisplayEqualTo (Boolean.valueOf (true)).andParentIdIsNull ();
				List <UserGoodsClass> ugcs = userGoodsClassService.getObjectList (userGoodsClassExample);
				// 先清除属性
				obj.getGoodsPhotos ().clear ();
				// 清除中间表里的数据,到保存的时候在重新设置
				Goods2PhotoExample goodsPhotoExample = new Goods2PhotoExample ();
				goodsPhotoExample.createCriteria ().andGoodsIdEqualTo (obj.getId ());
				List <Goods2Photo> listGoods2Photo = this.goods2PhotoService.getObjectList (goodsPhotoExample);
				List <Accessory> listAccessory = new ArrayList <Accessory> ();
				for (Goods2Photo goods2Photo : listGoods2Photo)
				{
					long photoId = goods2Photo.getPhotoId ();
					Accessory accessory = accessoryService.getByKey (photoId);
					listAccessory.add (accessory);
				}
				obj.setGoodsPhotos (listAccessory);
				List <UserGoodsClass> ugcChils = new ArrayList <UserGoodsClass> ();
				for (UserGoodsClass userGoodsClass : ugcs)
				{
					userGoodsClassExample.clear ();
					userGoodsClassExample.createCriteria ().andParentIdEqualTo (userGoodsClass.getId ());
					ugcChils = userGoodsClassService.getObjectList (userGoodsClassExample);
					userGoodsClass.getChilds ().addAll (ugcChils);
				}
				AccessoryExample accessoryExample = new AccessoryExample ();
				accessoryExample.clear ();
				accessoryExample.setPageSize (Integer.valueOf (8));
				accessoryExample.setOrderByClause ("addTime desc");
				AccessoryExample.Criteria accessoryCriteria = accessoryExample.createCriteria ();
				accessoryCriteria.andUserIdEqualTo (user.getId ());
				Pagination pList = accessoryService.getObjectListWithPage (accessoryExample);
				String photo_url = CommUtil.getURL (request) + "/seller/load_photo.htm";
				// 查询店铺导航
				StoreNavigationExample storeNavigationExample = new StoreNavigationExample ();
				storeNavigationExample.clear ();
				storeNavigationExample.setOrderByClause ("sequence asc");
				storeNavigationExample.createCriteria ().andStoreIdEqualTo (user.getStoreId ());
				List <StoreNavigation> navs = storenavigationService.getObjectList (storeNavigationExample);
				// 查询商品所属模块
				GoodsModuleExample gme = new GoodsModuleExample ();
				gme.clear ();
				gme.setOrderByClause ("id");
				gme.createCriteria ().andDeletestatusEqualTo (false);
				List <GoodsModule> gms = goodsModuleService.getObjectList (gme);
				if (obj.getModuleId () != null)
				{
					GoodsModuleFloorNext next = goodsModuleFloorNextService.getByKey (Long.valueOf (obj.getModuleId ()));
					if (next == null)
					{
						mv.addObject ("moduleId" , obj.getModuleId ());
						GoodsModuleFloor floor = goodsModuleFloorService.getByKey (Long.valueOf (obj.getModuleId ()));
						if (floor != null)
						{
							mv.addObject ("module" , floor.getModuleId ());
							GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
							gmfe.clear ();
							gmfe.createCriteria ().andModuleIdEqualTo (floor.getModuleId ());
							List <GoodsModuleFloor> floors = goodsModuleFloorService.getObjectList (gmfe);
							mv.addObject ("floors" , floors);
						}
					}
					else
					{
						mv.addObject ("proviceId" , next.getAreaid ());
						mv.addObject ("moduleId" , next.getFloorid ());
						GoodsModuleFloor floor = goodsModuleFloorService.getByKey (Long.valueOf (next.getFloorid ()));
						mv.addObject ("module" , floor.getModuleId ());
						GoodsModuleFloorExample gmfe = new GoodsModuleFloorExample ();
						gmfe.clear ();
						gmfe.createCriteria ().andModuleIdEqualTo (floor.getModuleId ());
						List <GoodsModuleFloor> floors = goodsModuleFloorService.getObjectList (gmfe);
						mv.addObject ("floors" , floors);
						GoodsModuleFloorNextExample gmfne = new GoodsModuleFloorNextExample ();
						gmfne.clear ();
						gmfne.createCriteria ().andFlooridEqualTo (next.getFloorid ());
						List <GoodsModuleFloorNext> nexts = goodsModuleFloorNextService.getObjectList (gmfne);
						List <Area> areas = new ArrayList <Area> ();
						for (GoodsModuleFloorNext goodsModuleFloorNext : nexts)
						{
							Area area = areaService.getByKey (Long.valueOf (goodsModuleFloorNext.getAreaid ()));
							areas.add (area);
						}
						mv.addObject ("areas" , areas);
					}
				}
				// 感恩金利率
				List <GoodsRate> rateList = new ArrayList <GoodsRate> ();
				Map <String, String> rateMap = new LinkedHashMap <String, String> ();
				rateMap.put (Globals.FINANCIAL_GOLD_RATE_TWO , "20%");
//				rateMap.put (Globals.FINANCIAL_GOLD_RATE_THREE , "30%");
				GoodsRate rate = null;
				for (Map.Entry <String, String> map : rateMap.entrySet ())
				{
					rate = new GoodsRate (map.getKey () , map.getValue ());
					rateList.add (rate);
				}
				mv.addObject ("goodsRate" , rateList);
				// 感恩豆利率
				List <GoodsRate> beanRateList = new ArrayList <GoodsRate> ();
				Map <String, String> beanrateMap = new LinkedHashMap <String, String> ();
				beanrateMap.put ("0.0" , "00%");
				beanrateMap.put ("0.1" , "10%");
				beanrateMap.put ("0.2" , "20%");
				beanrateMap.put ("0.3" , "30%");
				beanrateMap.put ("0.4" , "40%");
				beanrateMap.put ("0.5" , "50%");
				beanrateMap.put ("0.6" , "60%");
				beanrateMap.put ("0.7" , "70%");
				beanrateMap.put ("0.8" , "80%");
				beanrateMap.put ("0.9" , "90%");
				beanrateMap.put ("1.0" , "100%");
				GoodsRate goodsBeanRate = null;
				for (Map.Entry <String, String> map : beanrateMap.entrySet ())
				{
					goodsBeanRate = new GoodsRate (map.getKey () , map.getValue ());
					beanRateList.add (goodsBeanRate);
				}
				mv.addObject ("beanRate" , beanRateList);
				mv.addObject ("gms" , gms);
				mv.addObject ("navs" , navs);
				mv.addObject ("photos" , pList.getList ());
				mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (photo_url , "" , pList.getPageNo () , pList.getTotalPage ()));
				mv.addObject ("ugcs" , ugcs);
				mv.addObject ("img_remain_size" , Double.valueOf (img_remain_size));
				if (obj.getGoodsRate () != null && obj.getBeanRate () != null)
				{
					mv.addObject ("objRate" , obj.getGoodsRate ().multiply (new BigDecimal ("100")).toBigInteger().toString () + "%");
					mv.addObject ("objBeanRate" , obj.getBeanRate ().multiply (new BigDecimal ("100")).toBigInteger().toString () + "%");
				}

				mv.addObject ("obj" , obj);
				GoodsType goodsType = null;
				Map <GoodsSpecification, List <GoodsSpecProperty>> returnMap = new HashMap <GoodsSpecification, List <GoodsSpecProperty>> ();
				if (request.getSession (false).getAttribute ("goods_class_info") != null) // /有错误
				{
					GoodsClass session_gc = (GoodsClass) request.getSession (false).getAttribute ("goods_class_info");
					gc = this.goodsClassService.getByKey (session_gc.getId ());
					if (gc.getGoodstypeId () != null)
					{        // bug存在地
						goodsType = goodsTypeService.getByKey (gc.getGoodstypeId ());
						log.info ("gc.getGoodstypeId():" + com.amall.common.tools.Json.gson.toJson (gc.getGoodstypeId ()));
						// log.info("goodstype:" +
						// com.amall.common.tools.Json.gson.toJson(goodsType));
						// ///////sdsdssssss出错地
						log.info ("goodstype:" + Json.toJson (goodsType));
						// 从中间表中查询商品属性
						GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
						goodsType2SpecExample.clear ();
						goodsType2SpecExample.createCriteria ().andTypeIdEqualTo (goodsType.getId ());
						log.info ("goodsType.getId():" + com.amall.common.tools.Json.gson.toJson (goodsType.getId ()));
						List <GoodsType2Spec> gt2s = goodsType2SpecService.getObjectList (goodsType2SpecExample);
						List <GoodsSpecification> goodsSpecifications = new ArrayList <GoodsSpecification> ();
						GoodsSpecPropertyExample goodsSpecPropertyExample = new GoodsSpecPropertyExample ();
						for (GoodsType2Spec goodsType2Spec : gt2s)
						{
							GoodsSpecification goodsSpecification = goodsSpecificationService.getByKey (goodsType2Spec.getSpecId ());
							goodsSpecPropertyExample.clear ();
							goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (goodsType2Spec.getSpecId ());
							List <GoodsSpecProperty> gsps = goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
							goodsSpecification.getProperties ().addAll (gsps);
							goodsSpecifications.add (goodsSpecification);
							returnMap.put (goodsSpecification , gsps);
						}
						goodsType.setGss (goodsSpecifications);
						// 查询商品类型属性
						GoodsTypePropertyExample gtpExample = new GoodsTypePropertyExample ();
						gtpExample.clear ();
						gtpExample.createCriteria ().andGoodstypeIdEqualTo (goodsType.getId ());
						List <GoodsTypeProperty> gtps = goodsTypePropertyService.getObjectList (gtpExample);
						goodsType.setProperties (gtps);
						mv.addObject ("goods_class_info" , this.storeTools.generic_goods_class_info (gc));
						// mv.addObject("goods_class", gc);
						request.getSession (false).removeAttribute ("goods_class_info");
					}
				}
				else if (obj.getGc () != null)
				{
					goodsType = goodsTypeService.getByKey (obj.getGc ().getGoodstypeId ());
					if (goodsType != null)
					{
						GoodsType2SpecExample goodsType2SpecExample = new GoodsType2SpecExample ();
						goodsType2SpecExample.clear ();
						goodsType2SpecExample.createCriteria ().andTypeIdEqualTo (goodsType.getId ());
						List <GoodsType2Spec> gt2s = goodsType2SpecService.getObjectList (goodsType2SpecExample);
						List <GoodsSpecification> goodsSpecifications = new ArrayList <GoodsSpecification> ();
						GoodsSpecPropertyExample goodsSpecPropertyExample = new GoodsSpecPropertyExample ();
						if (gt2s != null && !gt2s.isEmpty ())
						{
							for (GoodsType2Spec goodsType2Spec : gt2s)
							{
								GoodsSpecification goodsSpecification = goodsSpecificationService.getByKey (goodsType2Spec.getSpecId ());
								goodsSpecPropertyExample.clear ();
								goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (goodsType2Spec.getSpecId ());
								List <GoodsSpecProperty> gsps = goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
								goodsSpecification.getProperties ().addAll (gsps);
								goodsSpecifications.add (goodsSpecification);
								returnMap.put (goodsSpecification , gsps);
							}
							goodsType.setGss (goodsSpecifications);
						}
						else
						{
							/* 获取规格信息 */
							GoodsClass2SpecExample class2SpecExample = new GoodsClass2SpecExample ();
							class2SpecExample.clear ();
							class2SpecExample.createCriteria ().andClassIdEqualTo (Long.valueOf (obj.getGc ().getId ()));
							List <GoodsClass2Spec> class2Specs = class2SpecService.getObjectList (class2SpecExample);
							/* 组装规格信息 */
							for (GoodsClass2Spec class2Spec : class2Specs)
							{
								GoodsSpecification goodsSpecification = this.goodsSpecificationService.getByKey (class2Spec.getSpecificationId ());
								goodsSpecPropertyExample.clear ();
								goodsSpecPropertyExample.createCriteria ().andSpecIdEqualTo (goodsSpecification.getId ());
								List <GoodsSpecProperty> specProperties = this.goodsSpecPropertyService.getObjectList (goodsSpecPropertyExample);
								/* 不存在属性值的不添加 */
								if (!specProperties.isEmpty ())
								{
									returnMap.put (goodsSpecification , specProperties);
								}
							}
						}
					}
					// mv.addObject("goods_class", gc);
					mv.addObject ("sepcs" , returnMap);
					mv.addObject ("goods_class_info" , this.storeTools.generic_goods_class_info (obj.getGc ()));
					mv.addObject ("goods_class" , obj.getGc ());
				}
				// 查询商品品牌
				// 查询该分类下的品牌
				GoodsType2BrandExample goodsType2BrandExample = new GoodsType2BrandExample ();
				goodsType2BrandExample.clear ();
				goodsType2BrandExample.createCriteria ().andTypeIdEqualTo (obj.getGcId ());
				List <GoodsType2Brand> type2Brands = goodsType2BrandService.getObjectList (goodsType2BrandExample);
				List <GoodsBrand> brands = new ArrayList <> ();
				if (!(type2Brands != null && !type2Brands.isEmpty ()))
				{
					if (goodsType != null)
					{
						goodsType2BrandExample.clear ();
						goodsType2BrandExample.createCriteria ().andTypeIdEqualTo (goodsType.getId ());
						type2Brands = goodsType2BrandService.getObjectList (goodsType2BrandExample);
					}
				}
				for (GoodsType2Brand type2Brand : type2Brands)
				{
					GoodsBrand brand = goodsBrandService.getByKey (type2Brand.getBrandId ());
					if (brand != null)
					{
						brands.add (brand);
					}
				}
				mv.addObject ("gbs" , brands);
				mv.addObject ("gt" , goodsType);
				String goods_session = CommUtil.randomString (32);
				mv.addObject ("goods_session" , goods_session);
				request.getSession (false).setAttribute ("goods_session" , goods_session);
				mv.addObject ("imageSuffix" , this.storeViewTools.genericImageSuffix (this.configService.getSysConfig ().getImagesuffix ()));
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您没有该商品信息！");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/seller_index.htm");
			}
			mv.addObject ("goods_class" , gc);
			return mv;
		}


	@SecurityMapping(title = "商品上下架" , value = "/seller/goods_sale.htm*" , rtype = "seller" , rname = "商品上下架" ,
						rcode = "goods_sale_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_sale.htm" })
	public String goods_sale (	HttpServletRequest request , HttpServletResponse response , String mulitId)
		{
			String url = "/seller/seller_goods.htm";
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
					if (goods.getGoodsStore ().getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
					{
						int goods_status = goods.getGoodsStatus () == 0 ? 1 : 0;
						goods.setGoodsStatus (goods_status);
						this.goodsService.updateByObject (goods);
						if (goods_status == 0)
						{
							url = "/seller/seller_goods_storage.htm";
							String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
							File file = new File (goods_lucene_path);
							if (!file.exists ())
							{
								CommUtil.createFolder (goods_lucene_path);
							}
							/*
							 * LuceneVo vo = new LuceneVo();
							 * vo.setVo_id(goods.getId());
							 * vo.setVo_title(goods.getGoodsName());
							 * vo.setVo_content(goods.getGoodsDetails()
							 * );
							 * vo.setVo_type("goods");
							 * vo.setVo_store_price(CommUtil.null2Double
							 * (goods
							 * .getStorePrice()));
							 * vo.setVo_add_time(goods.getAddtime().
							 * getTime());
							 * vo.setVo_goods_salenum(goods.
							 * getGoodsSalenum());
							 */
							LuceneUtil lucene = LuceneUtil.instance ();
							LuceneUtil.setIndex_path (goods_lucene_path);
							lucene.delete_index (id);
						}
						else
						{
							// 删除购物车内详情
							CartDetailExample cartDetailExample = new CartDetailExample ();
							cartDetailExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
							this.cartDetailService.deleteByExample (cartDetailExample);
							// 删除订单表里面未付款的订单
							/*
							 * OrderFormItemExample itemExample = new
							 * OrderFormItemExample();
							 * itemExample.createCriteria().
							 * andGoodsIdEqualTo(goods.getId());
							 * List<OrderFormItem> formItem =
							 * orderFormItemService.getObjectList(
							 * itemExample);
							 * OrderFormExample example = new
							 * OrderFormExample();
							 * for(OrderFormItem of : formItem){
							 * example.createCriteria().andAddrIdEqualTo
							 * (of.getOrderId());
							 * OrderForm ofm =
							 * orderFormService.getByKey
							 * (of.getOrderId());
							 * if(ofm.getOrderStatus() < 20 ||
							 * !ofm.getOrderStatus().equals(""))
							 * {
							 * this.orderFormService.deleteByExample(
							 * example);
							 * }
							 * }
							 */
							String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
							File file = new File (goods_lucene_path);
							if (!file.exists ())
							{
								CommUtil.createFolder (goods_lucene_path);
							}
							LuceneUtil lucene = LuceneUtil.instance ();
							LuceneUtil.setIndex_path (goods_lucene_path);
							lucene.delete_index (CommUtil.null2String (goods.getId ()));
						}
					}
				}
			}
			return "redirect:" + url;
		}


	@SecurityMapping(title = "商品删除" , value = "/seller/goods_del.htm*" , rtype = "seller" , rname = "商品删除" ,
						rcode = "goods_del_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_del.htm" })
	public String goods_del (	HttpServletRequest request , HttpServletResponse response , String mulitId , String op)
		{
			String url = "/seller/seller_goods.htm";
			if (CommUtil.null2String (op).equals ("storage"))
			{
				url = "/seller/seller_goods_storage.htm";
			}
			if (CommUtil.null2String (op).equals ("out"))
			{
				url = "/seller/goods_out.htm";
			}
			if (CommUtil.null2String (op).equals ("cheked"))
			{
				url = "/seller/chekedFailing.htm";
			}
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (id));
					if (goods.getGoodsStore ().getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
					{
						// GoodsCartExample cartExample = new
						// GoodsCartExample ();
						// cartExample.clear ();
						// cartExample.createCriteria
						// ().andGoodsIdEqualTo (goods.getId ());
						// List <GoodsCart> goodCarts =
						// goodsCartService.getObjectList
						// (cartExample);
						/*
						 * Map map = new HashMap(); map.put("gid",
						 * goods.getId());
						 * List<GoodsCart> goodCarts =
						 * this.goodsCartService .query(
						 * "select obj from GoodsCart obj where obj.goods.id = :gid"
						 * , map, -1, -1);
						 */
						// Long ofid = null;
						// Long of_id;
						List <EvaluateWithBLOBs> evaluates = goods.getEvaluates ();
						for (EvaluateWithBLOBs e : evaluates)
						{
							this.evaluateService.deleteByKey (e.getId ());
						}
						/* 删除购物车详情数据 */
						CartDetailExample cartDetailExample = new CartDetailExample ();
						cartDetailExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
						this.cartDetailService.deleteByExample (cartDetailExample);
						/* 删除商品，修改状态 */
						goods.getGoodsUgcs ().clear ();
						goods.getGoodsUgcs ().clear ();
						goods.getGoodsPhotos ().clear ();
						goods.getGoodsUgcs ().clear ();
						goods.getGoodsSpecs ().clear ();
						goods.setDeletestatus (true);
						this.goodsService.updateByObject (goods);
						// 删除商品图片中间表中的数据
						Goods2PhotoExample goods2PhotoExample = new Goods2PhotoExample ();
						goods2PhotoExample.clear ();
						goods2PhotoExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
						this.goods2PhotoService.deleteByExample (goods2PhotoExample);
						String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
						File file = new File (goods_lucene_path);
						if (!file.exists ())
						{
							CommUtil.createFolder (goods_lucene_path);
						}
						LuceneUtil lucene = LuceneUtil.instance ();
						LuceneUtil.setIndex_path (goods_lucene_path);
						lucene.delete_index (CommUtil.null2String (id));
					}
				}
			}
			return "redirect:" + url;
		}


	@SecurityMapping(title = "被举报禁售商品" , value = "/seller/goods_report.htm*" , rtype = "seller" , rname = "被举报禁售商品" ,
						rcode = "goods_report_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/goods_report.htm" })
	public ModelAndView goods_report (	HttpServletRequest request , HttpServletResponse response , String currentPage ,
										String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/goods_report.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (user.getId ()).andDeletestatusEqualTo (false);
			Store store = storeService.getObjectList (storeExample).get (0);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			List <GoodsWithBLOBs> goodslist = goodsService.getObjectList (goodsExample);
			List <Long> reportList = new ArrayList <Long> ();
			;
			for (GoodsWithBLOBs goods : goodslist)
			{
				reportList.add (goods.getId ());
			}
			ReportExample reportExample = new ReportExample ();
			reportExample.clear ();
			reportExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			reportExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			ReportExample.Criteria reportCriteria = reportExample.createCriteria ();
			reportCriteria.andResultEqualTo (Integer.valueOf (1)).andGoodsIdIn (reportList);
			Pagination pList = reportService.getObjectListWithPage (reportExample);
			/*
			 * ReportQueryObject qo = new
			 * ReportQueryObject(currentPage, mv,
			 * orderBy, orderType);
			 * qo.addQuery("obj.goods.goods_store.user.id", new
			 * SysMap("user_id",
			 * SecurityUserHolder.getCurrentUser().getId()), "=");
			 * qo.addQuery("obj.result", new SysMap("result",
			 * Integer.valueOf(1)),
			 * "="); IPageList pList = this.reportService.list(qo);
			 */
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}


	@SecurityMapping(title = "举报图片查看" , value = "/seller/report_img.htm*" , rtype = "seller" , rname = "被举报禁售商品" ,
						rcode = "goods_report_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/report_img.htm" })
	public ModelAndView report_img (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/report_img.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Report obj = this.reportService.getByKey (CommUtil.null2Long (id));
			if (obj.getAcc1Id () != null && !obj.getAcc1Id ().toString ().equals (""))
			{
				Accessory acc1 = this.accessoryService.getByKey (obj.getAcc1Id ());
				obj.setAcc1 (acc1);
			}
			if (obj.getAcc2Id () != null && !obj.getAcc2Id ().toString ().equals (""))
			{
				Accessory acc2 = this.accessoryService.getByKey (obj.getAcc2Id ());
				obj.setAcc2 (acc2);
			}
			if (obj.getAcc3Id () != null && !obj.getAcc3Id ().toString ().equals (""))
			{
				Accessory acc3 = this.accessoryService.getByKey (obj.getAcc3Id ());
				obj.setAcc3 (acc3);
			}
			mv.addObject ("obj" , obj);
			return mv;
		}


	/**
	 * 
	 * <p>
	 * Title: goods_img_album
	 * </p>
	 * <p>
	 * Description: 加载商品图片相册
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param type
	 * @return
	 */
	@RequestMapping({ "/seller/goods_img_album.htm" })
	public ModelAndView goods_img_album (	HttpServletRequest request , HttpServletResponse response ,
											String currentPage , String type)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/" + type + ".html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			AccessoryExample accessoryExample = new AccessoryExample ();
			accessoryExample.clear ();
			accessoryExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			accessoryExample.setPageSize (Integer.valueOf (16));
			accessoryExample.setOrderByClause ("addTime desc");
			accessoryExample.createCriteria ().andUserIdEqualTo (user.getId ());
			Pagination pList = accessoryService.getObjectListWithPage (accessoryExample);
			String photo_url = CommUtil.getURL (request) + "/seller/usercenter/goods_img_album.htm";
			mv.addObject ("photos" , pList.getList ());
			mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (photo_url , "" , pList.getPageNo () , pList.getTotalPage ()));
			return mv;
		}


	/***
	 * 审核未通过的商品
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "seller/chekedFailing.htm" })
	public ModelAndView chekedFailing (	HttpServletRequest request , HttpServletResponse response , Integer currentPage)
		{
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getByKey (user.getStore ().getId ());
			if (store == null)
			{
				ModelAndView mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			ModelAndView mv = new JModelAndView ("seller/usercenter/chekedFailing.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample example = new GoodsExample ();
			example.setPageSize (10);
			if (currentPage != null)
			{
				example.setPageNo (currentPage);
			}
			else
			{
				example.setPageNo (1);
			}
			example.setOrderByClause (" addTime desc");
			example.createCriteria ().andGoodsStatusEqualTo (Globals.GOODS_AUDIT_NOTPASS).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			Pagination pList = goodsService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}


	/***
	 * 正在审核
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "seller/chekedunder_review.htm" })
	public ModelAndView chekedunder_review (HttpServletRequest request , HttpServletResponse response ,
											Integer currentPage)
		{
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getByKey (user.getStore ().getId ());
			if (store == null)
			{
				ModelAndView mv = new JModelAndView ("login.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				return mv;
			}
			ModelAndView mv = new JModelAndView ("seller/usercenter/chekedunder_review.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsExample example = new GoodsExample ();
			example.setPageSize (10);
			if (currentPage != null)
			{
				example.setPageNo (currentPage);
			}
			else
			{
				example.setPageNo (1);
			}
			example.setOrderByClause (" addTime desc");
			example.createCriteria ().andGoodsStatusEqualTo (Globals.GOODS_WAIT_AUDIT).andGoodsStoreIdEqualTo (store.getId ()).andDeletestatusEqualTo (false);
			Pagination pList = goodsService.getObjectListWithPage (example);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}
}
