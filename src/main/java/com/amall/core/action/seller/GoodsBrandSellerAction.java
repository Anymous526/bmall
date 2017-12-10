package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.goods.IGoodsBrandCategoryService;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsType2BrandService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: GoodsBrandSellerAction
 * </p>
 * <p>
 * Description: 卖家商品 品牌crud管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月18日上午9:52:38
 * @version 1.0
 */
@Controller
public class GoodsBrandSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IGoodsType2BrandService goodsType2BrandService;

	@Autowired
	private IGoodsBrandCategoryService goodsBrandCategoryService;

	@Autowired
	private IGoodsClassService goodsClassService;

	/**
	 * @Title: loadGoodsClass
	 * @Description: 商品分类加载
	 * @param request
	 * @param response
	 * @param pid
	 * @return void
	 * @author guoxiangjun
	 * @date 2015年8月17日 下午4:12:52
	 */
	@RequestMapping({ "/seller/seller_load_goods_class.htm" })
	public void seller_loadGoodsClass (HttpServletRequest request , HttpServletResponse response , Long pid)
		{
			GoodsClassExample exa = new GoodsClassExample ();
			exa.clear ();
			exa.createCriteria ().andParentIdEqualTo (pid).andDeletestatusEqualTo (false);
			List <GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList (exa);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (gcs));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "卖家品牌列表" , value = "/seller/usergoodsbrand_list.htm*" , rtype = "seller" , rname = "品牌申请" ,
						rcode = "usergoodsbrand_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsbrand_list.htm" })
	public ModelAndView usergoodsbrand_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String orderBy , String orderType)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsbrand_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsBrandExample goodsBrandExample = new GoodsBrandExample ();
			goodsBrandExample.clear ();
			goodsBrandExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			goodsBrandExample.setOrderByClause ("addTime desc");
			User user = userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			goodsBrandExample.createCriteria ().andUserIdEqualTo (user.getId ());
			Pagination pList = goodsBrandService.getObjectListWithPage (goodsBrandExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			return mv;
		}

	@SecurityMapping(title = "卖家品牌申请" , value = "/seller/usergoodsbrand_add.htm*" , rtype = "seller" , rname = "品牌申请" ,
						rcode = "usergoodsbrand_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsbrand_add.htm" })
	public ModelAndView usergoodsbrand_add (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsbrand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDeletestatusEqualTo (false);
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			return mv;
		}

	@SecurityMapping(title = "卖家品牌编辑" , value = "/seller/usergoodsbrand_edit.htm*" , rtype = "seller" , rname = "品牌申请" ,
						rcode = "usergoodsbrand_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsbrand_edit.htm" })
	public ModelAndView usergoodsbrand_edit (HttpServletRequest request , HttpServletResponse response , String id)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/usergoodsbrand_add.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsBrand goodsBrand = null;
			if ((id != null) && (!id.equals ("")))
			{
				goodsBrand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				mv.addObject ("obj" , goodsBrand);
			}
			GoodsClassExample goodsClassExample = new GoodsClassExample ();
			goodsClassExample.clear ();
			goodsClassExample.createCriteria ().andParentIdIsNull ().andDeletestatusEqualTo (false);
			;
			goodsClassExample.setOrderByClause ("sequence asc");
			List <GoodsClassWithBLOBs> gcs = goodsClassService.getObjectList (goodsClassExample);
			mv.addObject ("gcs" , gcs);
			mv.addObject ("edit" , Boolean.valueOf (true));
			return mv;
		}

	@SecurityMapping(title = "卖家品牌删除" , value = "/seller/usergoodsbrand_dele.htm*" , rtype = "seller" , rname = "品牌申请" ,
						rcode = "usergoodsbrand_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsbrand_dele.htm" })
	public String usergoodsbrand_dele (HttpServletRequest request , String id , String currentPage)
		{
			if (!id.equals (""))
			{
				GoodsBrand brand = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				if (brand.getAudit () != 1)
				{
					CommUtil.del_acc (request , brand.getBrandLogo () , this.configService.getSysConfig ().getUploadRootPath ());
					this.goodsBrandService.deleteByKey (Long.valueOf (Long.parseLong (id)));
				}
			}
			return "redirect:usergoodsbrand_list.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家品牌保存" , value = "/seller/usergoodsbrand_save.htm*" , rtype = "seller" , rname = "品牌申请" ,
						rcode = "usergoodsbrand_seller" , rgroup = "商品管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/usergoodsbrand_save.htm" })
	public String usergoodsbrand_save (HttpServletRequest request , HttpServletResponse response , String id , String cmd , String cat_name , String list_url , String add_url , String categoryId)
		{
			WebForm wf = new WebForm ();
			GoodsBrand goodsBrand = null;
			if (id.equals (""))
			{
				goodsBrand = (GoodsBrand) wf.toPo (request , GoodsBrand.class);
				goodsBrand.setAddtime (new Date ());
				goodsBrand.setAudit (1);
				goodsBrand.setUserstatus (1);
				goodsBrand.setUser (SecurityUserHolder.getCurrentUser ());
				goodsBrand.setCategoryId(Long.valueOf(categoryId));
			}
			else
			{
				GoodsBrand obj = this.goodsBrandService.getByKey (Long.valueOf (Long.parseLong (id)));
				goodsBrand = (GoodsBrand) wf.toPo (request , obj);
				goodsBrand.setCategoryId(Long.valueOf(categoryId));
			}
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + File.separator + uploadFilePath + File.separator + "brand";
			Map <String, Object> map = new HashMap <String, Object> ();
			try
			{
				String fileName = goodsBrand.getBrandLogo () == null ? "" : goodsBrand.getBrandLogo ().getName ();
				map = CommUtil.saveFileToServer (request , "brandLogo" , saveFilePathName , fileName , null);
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						Accessory photo = new Accessory ();
						photo.setName (CommUtil.null2String (map.get ("fileName")));
						photo.setExt (CommUtil.null2String (map.get ("mime")));
						photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
						photo.setPath (uploadFilePath + "/brand");
						photo.setWidth (CommUtil.null2Int (map.get ("width")));
						photo.setHeight (CommUtil.null2Int (map.get ("height")));
						photo.setAddtime (new Date ());
						Long photoId = this.accessoryService.add (photo);
						
						goodsBrand.setBrandLogo (photo);
					}
				}
				else if (!map.get ("fileName").equals (""))
				{
					Accessory photo = goodsBrand.getBrandLogo ();
					photo.setName (CommUtil.null2String (map.get ("fileName")));
					photo.setExt (CommUtil.null2String (map.get ("mime")));
					photo.setSize (CommUtil.null2Float (map.get ("fileSize")));
					photo.setPath (uploadFilePath + "/brand");
					photo.setWidth (CommUtil.null2Int (map.get ("width")));
					photo.setHeight (CommUtil.null2Int (map.get ("height")));
					photo.setAddtime (new Date ());
					this.accessoryService.updateByObject (photo);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			if (id.equals (""))
			{
				this.goodsBrandService.add (goodsBrand);
			}
			else
			{
				this.goodsBrandService.updateByObject (goodsBrand);
			}
			String [ ] cates = categoryId.split ("\\|");		//分类id
			GoodsType2Brand goodsType2Brand = null;
			for (String s : cates)
			{
				goodsType2Brand = new GoodsType2Brand ();
				goodsType2Brand.setBrandId (goodsBrand.getId ());
				goodsType2Brand.setTypeId (Long.valueOf (s));
				this.goodsType2BrandService.add (goodsType2Brand);
			}
			return "redirect:usergoodsbrand_list.htm";
		}
}
