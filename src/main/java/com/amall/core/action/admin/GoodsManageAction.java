package com.amall.core.action.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsExample.Criteria;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Message;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.lucene.LuceneUtil;
import com.amall.core.lucene.LuceneVo;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.IMessageService;
import com.amall.core.service.cart.ICartDetailService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsCartService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsModuleFloorService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.orderForm.IOrderFormLogService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.tools.database.DatabaseTools;
import com.amall.core.web.virtual.JModelAndView;
import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

/**
 * 
 * <p>
 * Title: GoodsManageAction
 * </p>
 * <p>
 * Description:商品crud管理和违规商品列表查询
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-25下午6:59:58
 * @version 1.0
 */
@Controller
public class GoodsManageAction
{

	@Autowired
	private IGoodsModuleFloorService goodsModuleFloorService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ICartDetailService cartDetailService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IGoodsCartService goodsCartService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderFormLogService orderFormLogService;

	private List <Long> genericIds (GoodsClassWithBLOBs gc)
		{
			List <Long> ids = new ArrayList <Long> ();
			ids.add (gc.getId ());
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			GoodsClassExample.Criteria goodsClassCriteria = goodsClassExample.createCriteria ();
			goodsClassCriteria.andParentIdEqualTo (gc.getId ());
			List <GoodsClassWithBLOBs> list = this.goodsClassService.getObjectList (goodsClassExample);
			gc.getChilds ().addAll (list);
			for (GoodsClassWithBLOBs child : gc.getChilds ())
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

	@SecurityMapping(title = "商品列表" , value = "/admin/goods_list.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_list.htm" })
	public ModelAndView goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goods_name , String store_name , String goodsBrandId , String gcId , String store_recommend)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsCriteria.andGoodsStatusEqualTo(0);
			goodsExample.setPageSize (20);
			if (!StringUtils.isEmpty (goods_name))
			{
				mv.addObject ("goods_name" , goods_name);
				goodsCriteria.andGoodsNameLike ("%" + goods_name + "%");
			}
			if (!StringUtils.isEmpty (goodsBrandId))
			{
				mv.addObject ("goodsBrandId" , goodsBrandId);
				goodsCriteria.andGoodsBrandIdEqualTo (CommUtil.null2Long (goodsBrandId));
			}
			if (!StringUtils.isEmpty (gcId))
			{
				mv.addObject ("gcId" , gcId);
				goodsCriteria.andGcIdEqualTo (CommUtil.null2Long (gcId));
			}
			if (!StringUtils.isEmpty (store_recommend))
			{
				mv.addObject ("store_recommend" , store_recommend);
				goodsCriteria.andStoreRecommendEqualTo (CommUtil.null2Boolean (store_recommend));
			}
			if (!StringUtils.isEmpty (store_name))
			{
				mv.addObject ("store_name" , store_name);
				StoreExample storeExample = new StoreExample ();
				storeExample.clear ();
				storeExample.createCriteria ().andStoreNameLike ("%" + store_name + "%");
				List <StoreWithBLOBs> storeList = this.storeService.getObjectList (storeExample);
				List <Long> storeIds = new ArrayList <Long> ();
				for (StoreWithBLOBs store : storeList)
				{
					storeIds.add (store.getId ());
				}
				goodsCriteria.andGoodsStoreIdIn (storeIds);
			}
			// 只显示正在出售中的商品
			goodsCriteria.andGoodsStatusGreaterThan (Integer.valueOf (-2));
			// 剔除已删除的商品
			goodsCriteria.andDeletestatusEqualTo (false);
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/goods_list.htm" , "" , params , pList , mv);
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			goodsBrandExample.setOrderByClause ("sequence asc");
			List <GoodsBrand> gbs = goodsBrandService.getObjectList (goodsBrandExample);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.setOrderByClause ("sequence asc");
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("gbs" , gbs);
			return mv;
		}

	@SecurityMapping(title = "违规商品列表" , value = "/admin/goods_outline.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_outline.htm" })
	public ModelAndView goods_outline (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType , String goodsName , String goodsType , String goodsBrand)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_outline.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			String url = this.configService.getSysConfig ().getAddress ();
			if ((url == null) || (url.equals ("")))
			{
				url = CommUtil.getURL (request);
			}
			String params = "";
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			Criteria goodsCriteria = goodsExample.createCriteria ();
			goodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsExample.setOrderByClause (Pagination.cst (orderBy , orderType));
			goodsCriteria.andGoodsStatusEqualTo (Integer.valueOf (-2));
			if (goodsName != null && !"".equals (goodsName))
			{
				goodsCriteria.andGoodsNameLike ("%" + goodsName + "%");
			}
			if (goodsBrand != null && !"".equals (goodsBrand))
			{
				goodsCriteria.andGoodsBrandIdEqualTo (Long.valueOf (goodsBrand));
			}
			if (goodsType != null && !"".equals (goodsType))
			{
				GoodsClassWithBLOBs gc = this.goodsClassService.getByKey (Long.valueOf (String.valueOf (goodsType)));
				goodsCriteria.andGcIdIn (genericIds (gc));
			}
			/*
			 * WebForm wf = new WebForm();
			 * wf.toQueryPo(request, GoodsWithBLOBs.class, mv);
			 */
			Pagination pList = goodsService.getObjectListWithPage (goodsExample);
			CommUtil.addIPageList2ModelAndView (url + "/admin/goods_list.htm" , "" , params , pList , mv);
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			goodsBrandExample.setOrderByClause ("sequence asc");
			List <GoodsBrand> gbs = goodsBrandService.getObjectList (goodsBrandExample);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ();
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("gbs" , gbs);
			return mv;
		}

	@SecurityMapping(title = "商品添加" , value = "/admin/goods_add.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_add.htm" })
	public ModelAndView goods_add (HttpServletRequest request , HttpServletResponse response , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "商品编辑" , value = "/admin/goods_edit.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_edit.htm" })
	public ModelAndView goods_edit (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("admin/goods_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			if ((id != null) && (!id.equals ("")))
			{
				Goods goods = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , goods);
				mv.addObject ("currentPage" , currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "商品保存" , value = "/admin/goods_add.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_add.htm" })
	public ModelAndView goods_add (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd , String list_url , String add_url)
		{
			WebForm wf = new WebForm ();
			GoodsWithBLOBs goods = null;
			if (id.equals (""))
			{
				goods = (GoodsWithBLOBs) wf.toPo (request , Goods.class);
				goods.setAddtime (new Date ());
			}
			else
			{
				Goods obj = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
				goods = (GoodsWithBLOBs) wf.toPo (request , obj);
			}
			if (id.equals (""))
				this.goodsService.add (goods);
			else
				this.goodsService.updateByObject (goods);
			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			mv.addObject ("list_url" , list_url);
			mv.addObject ("op_title" , "保存商品成功");
			if (add_url != null)
			{
				mv.addObject ("add_url" , add_url + "?currentPage=" + currentPage);
			}
			return mv;
		}

	@SecurityMapping(title = "商品删除" , value = "/admin/goods_del.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_del.htm" })
	public String goods_del (HttpServletRequest request , String mulitId) throws Exception
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (id));
					List <EvaluateWithBLOBs> evaluates = goods.getEvaluates ();
					for (Evaluate e : evaluates)
					{
						this.evaluateService.deleteByKey (e.getId ());
					}
					/* 删除购物车详情数据 */
					CartDetailExample cartDetailExample = new CartDetailExample ();
					cartDetailExample.createCriteria ().andGoodsIdEqualTo (goods.getId ());
					this.cartDetailService.deleteByExample (cartDetailExample);
					goods.getGoodsUgcs ().clear ();
					goods.getGoodsUgcs ().clear ();
					goods.getGoodsPhotos ().clear ();
					goods.getGoodsUgcs ().clear ();
					goods.getGoodsSpecs ().clear ();
					goods.setDeletestatus (true);
					this.goodsService.updateByObject (goods);
					String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
					File file = new File (goods_lucene_path);
					if (!file.exists ())
					{
						CommUtil.createFolder (goods_lucene_path);
					}
					LuceneUtil lucene = LuceneUtil.instance ();
					LuceneUtil.setIndex_path (goods_lucene_path);
					lucene.delete_index (CommUtil.null2String (id));
					send_site_msg (request , "msg_toseller_goods_delete_by_admin_notify" , goods.getGoodsStore ().getUser () , goods , "商城存在违规");
				}
			}
			return "redirect:goods_list.htm";
		}

	@SuppressWarnings("deprecation")
	private void send_site_msg (HttpServletRequest request , String mark , User user , Goods goods , String reason) throws Exception
		{
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templateList = templateService.getObjectList (templateExample);
			if (templateList.size () > 0)
			{
				Template template = templateList.get (0);
				if (template.getOpen ())
				{
					String path = this.configService.getSysConfig ().getUploadRootPath () + "/vm/";
					PrintWriter pwrite = new PrintWriter (new OutputStreamWriter (new FileOutputStream (path + "msg.vm" , false) , "UTF-8"));
					pwrite.print (template.getContent ());
					pwrite.flush ();
					pwrite.close ();
					Properties p = new Properties ();
					p.setProperty ("file.resource.loader.path" , request.getRealPath ("/") + "vm" + File.separator);
					p.setProperty ("input.encoding" , "UTF-8");
					p.setProperty ("output.encoding" , "UTF-8");
					Velocity.init (p);
					org.apache.velocity.Template blank = Velocity.getTemplate ("msg.vm" , "UTF-8");
					VelocityContext context = new VelocityContext ();
					context.put ("reason" , reason);
					context.put ("user" , user);
					context.put ("config" , this.configService.getSysConfig ());
					context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
					StringWriter writer = new StringWriter ();
					blank.merge (context , writer);
					String content = writer.toString ();
					UserExample userExample = new UserExample ();
					userExample.clear ();
					userExample.createCriteria ().andUsernameEqualTo ("admin");
					User fromUser = userService.getObjectList (userExample).get (0);
					/*
					 * User fromUser = this.userService.getObjByProperty("userName",
					 * "admin");
					 */
					Message msg = new Message ();
					msg.setAddtime (new Date ());
					msg.setContent (content);
					msg.setFromUser (fromUser);
					msg.setTitle (template.getTitle ());
					msg.setToUser (user);
					msg.setType (0);
					this.messageService.add (msg);
					CommUtil.deleteFile (path + "temp.vm");
					writer.flush ();
					writer.close ();
				}
			}
		}

	@SecurityMapping(title = "商品AJAX更新" , value = "/admin/goods_ajax.htm*" , rtype = "admin" , rname = "商品管理" ,
						rcode = "admin_goods" , rgroup = "商品" , display = false , rsequence = 0)
	@RequestMapping({ "/admin/goods_ajax.htm" })
	public void ajax (HttpServletRequest request , HttpServletResponse response , String id , String fieldName , String value) throws ClassNotFoundException
		{
			GoodsWithBLOBs obj = this.goodsService.getByKey (Long.valueOf (Long.parseLong (id)));
			Field [ ] fields = Goods.class.getDeclaredFields ();
			BeanWrapper wrapper = new BeanWrapper (obj);
			Object val = null;
			for (Field field : fields)
			{
				if (field.getName ().equals (fieldName))
				{
					Class <?> clz = Class.forName ("java.lang.String");
					if (field.getType ().getName ().equals ("int"))
					{
						clz = Class.forName ("java.lang.Integer");
					}
					if (field.getType ().getName ().equals ("boolean"))
					{
						clz = Class.forName ("java.lang.Boolean");
					}
					if (!value.equals (""))
						val = BeanUtils.convertType (value , clz);
					else
					{
						val = Boolean.valueOf (!CommUtil.null2Boolean (wrapper.getPropertyValue (fieldName)));
					}
					wrapper.setPropertyValue (fieldName , val);
				}
			}
			if (fieldName.equals ("storeRecommend"))
			{
				if (obj.getStoreRecommend ())
					obj.setStoreRecommendTime (new Date ());
				else
					obj.setStoreRecommendTime (null);
			}
			if (value != null && !"".equals (value))
			{
				obj.setGoodsStatus (Integer.valueOf (value));
			}
			this.goodsService.updateByObject (obj);
			if (obj.getGoodsStatus () == 0)
			{
				String goods_lucene_path = System.getProperty ("user.dir") + File.separator + "luence" + File.separator + "goods";
				File file = new File (goods_lucene_path);
				if (!file.exists ())
				{
					CommUtil.createFolder (goods_lucene_path);
				}
				LuceneVo vo = new LuceneVo ();
				vo.setVo_id (obj.getId ());
				vo.setVo_title (obj.getGoodsName ());
				vo.setVo_content (obj.getGoodsDetails ());
				vo.setVo_type ("goods");
				vo.setVo_store_price (CommUtil.null2Double (obj.getStorePrice ()));
				vo.setVo_add_time (obj.getAddtime ().getTime ());
				vo.setVo_goods_salenum (obj.getGoodsSalenum ());
				LuceneUtil lucene = LuceneUtil.instance ();
				LuceneUtil.setIndex_path (goods_lucene_path);
				lucene.update (CommUtil.null2String (obj.getId ()) , vo);
			}
			else
			{
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
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				if (val != null)
				{
					writer.print (val.toString ());
				}
				else
				{
					writer.print ("");
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

//	@RequestMapping({ "admin/goods_check.htm" })
//	public ModelAndView goods_check (HttpServletResponse response , HttpServletRequest request , Integer currentPage , String goods_name)
//		{
//			ModelAndView mv = new JModelAndView ("admin/goods_check.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
//			GoodsExample example = new GoodsExample ();
//			example.setPageSize (20);
//			if (currentPage == null)
//			{
//				example.setPageNo (1);
//			}
//			else
//			{
//				example.setPageNo (currentPage);
//			}
//			example.setOrderByClause (" addTime desc");
//			example.createCriteria ().andGoodsStatusEqualTo (4).andDeletestatusEqualTo (false);
//			if (goods_name != null)
//			{
//				example.createCriteria ().andGoodsNameLike (goods_name);
//			}
//			Pagination pList = goodsService.getObjectListWithPage (example);
//			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
//			mv.addObject ("currentPage" , currentPage);
//			mv.addObject ("goods_name" , goods_name);
//			return mv;
//		}

//	@RequestMapping({ "admin/goods_checkId.htm" })
//	public ModelAndView goods_checkId (HttpServletResponse response , HttpServletRequest request , Integer id)
//		{
//			ModelAndView mv = new JModelAndView ("admin/goods_checkId.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
//			Goods goods = goodsService.getByKey ((long) id);
//			mv.addObject ("goods" , goods);
//			return mv;
//		}

	/**
	 * 審核
	 * 
	 * @return
	 */
//	@RequestMapping({ "admin/check.htm" })
//	public ModelAndView check (HttpServletRequest request , HttpServletResponse response , String content ,Integer id , Integer chekedId)
//		{
//			ModelAndView mv = new JModelAndView ("admin/success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
//			GoodsWithBLOBs goods=this.goodsService.getByKey ((long)id);
//			if (chekedId != null)
//			{
//				if (chekedId == 0)
//				{	// 审核通过
//					if (content != null)
//					{
//						goods.setWenxinTip ("发布成功！");
//					}
//					goods.setGoodsStatus (0);
//				}
//				else
//				{
//					// 拒绝
//					goods.setGoodsStatus (3);
//					goods.setWenxinTip (content);
//				}
//				goods.setId ((long) id);
//			}
//			goodsService.updateByObject (goods);
//			mv.addObject ("op_title" , "审核完成");
//			return mv;
//		}
}
