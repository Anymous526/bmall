package com.amall.core.action.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.bargain.IBargainGoodsService;
import com.amall.core.service.bargain.IBargainService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.BargainSellerTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: BargainSellerAction
 * </p>
 * <p>
 * Description: 天天特价活动管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日下午8:34:09
 * @version 1.0
 */
@Controller
public class BargainSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IBargainGoodsService bargainGoodsService;

	@Autowired
	private IBargainService bargainService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private BargainSellerTools bargainSellerTools;

	@Autowired
	private IAccessoryService accessoryService;

	@SecurityMapping(title = "特价列表" , value = "/seller/bargain.htm*" , rtype = "seller" , rname = "特价列表" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain.htm" })
	public ModelAndView bargain (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			int day_count = this.configService.getSysConfig ().getBargainValidity ();   // 获得特价商品申请有效期
			List <Date> dates = new ArrayList <Date> ();
			for (int i = 0 ; i < day_count ; i++)
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , i + 1);
				dates.add (cal.getTime ());
			}
			mv.addObject ("dates" , dates);
			mv.addObject ("bargainSellerTools" , this.bargainSellerTools);
			return mv;
		}

	@SecurityMapping(title = "申请今日特价" , value = "/seller/bargain_apply.htm*" , rtype = "seller" , rname = "今日特价" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_apply.htm" })
	public ModelAndView bargain_apply (HttpServletRequest request , HttpServletResponse response , String bargain_time)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain_apply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			if (CommUtil.null2String (bargain_time).equals (""))
			{
				Calendar cal = Calendar.getInstance ();
				cal.add (6 , 1);
				bargain_time = CommUtil.formatShortDate (cal.getTime ());
			}
			Calendar cal = Calendar.getInstance ();
			cal.add (6 , this.configService.getSysConfig ().getBargainValidity ());
			if (CommUtil.formatDate (bargain_time).after (cal.getTime ()))
			{
				cal = Calendar.getInstance ();
				cal.add (6 , 1);
				bargain_time = CommUtil.formatShortDate (cal.getTime ());
			}
			BargainExample bargainExample = new BargainExample ();
			bargainExample.clear ();
			bargainExample.createCriteria ().andBargainTimeEqualTo (CommUtil.formatDate (bargain_time));
			List <Bargain> bargain = bargainService.getObjectList (bargainExample);
			int audit_count = this.bargainSellerTools.query_bargain_audit (bargain_time);
			int bargain_count = this.configService.getSysConfig ().getBargainMaximum ();
			if (bargain.size () > 0)
			{
				bargain_count = ((Bargain) bargain.get (0)).getMaximum ();
			}
			if (audit_count >= bargain_count)
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "特价申请名额已满");
				mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain.htm");
			}
			mv.addObject ("bargain_rebate" , bargain.size () > 0 ? ((Bargain) bargain.get (0)).getRebate () : this.configService.getSysConfig ().getBargainRebate ());
			mv.addObject ("bargain_state" , bargain.size () > 0 ? ((Bargain) bargain.get (0)).getState () : this.configService.getSysConfig ().getBargainState ());
			mv.addObject ("bargain_time" , bargain_time);
			return mv;
		}

	/**
	 * 天天特价图片上传
	 * <p>
	 * Title: seller_upload
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param width
	 * @param height
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/seller/bargain_upload.htm" , method = RequestMethod.POST)
	@ResponseBody
	public String seller_upload (HttpServletRequest request , HttpServletResponse response , String width , String height) throws IOException
		{
			String uploadFilePath = this.configService.getSysConfig ().getUploadfilepath ();
			String saveFilePathName = this.configService.getSysConfig ().getUploadRootPath () + uploadFilePath + File.separator + "activity";
			Map <String, Object> map = new HashMap <String, Object> ();
			String fileName = "";
			map = CommUtil.saveFileToServer (request , "Filedata" , saveFilePathName , fileName , null);
			String response_rs = "";
			String imageId = "";
			int reqWidth = CommUtil.null2Int (width);
			int reqHeight = CommUtil.null2Int (height);
			int mapWidth = CommUtil.null2Int (map.get ("width"));
			int mapHeight = CommUtil.null2Int (map.get ("height"));
			if ((Math.abs (reqWidth - mapWidth) == 0) && ((Math.abs (reqHeight - mapHeight) == 0)))
			{
				Accessory gg_img = new Accessory ();
				if (fileName.equals (""))
				{
					if (!map.get ("fileName").equals (""))
					{
						gg_img.setName (CommUtil.null2String (map.get ("fileName")));
						gg_img.setExt (CommUtil.null2String (map.get ("mime")));
						gg_img.setSize (CommUtil.null2Float (map.get ("fileSize")));
						gg_img.setPath (uploadFilePath + "/activity");
						gg_img.setWidth (CommUtil.null2Int (map.get ("width")));
						gg_img.setHeight (CommUtil.null2Int (map.get ("height")));
						gg_img.setAddtime (new Date ());
						this.accessoryService.add (gg_img);
						imageId = String.valueOf (gg_img.getId ());
					}
				}
				response_rs = "{\"pass\":\"yes\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
			else
			{
				imageId = String.valueOf (0);
				response_rs = "{\"pass\":\"no\",\"imgId\":\"" + imageId + "\"}";
				return response_rs;
			}
		}

	@SecurityMapping(title = "添加商品" , value = "/seller/bargain_goods.htm*" , rtype = "seller" , rname = "今日特价" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_goods.htm" })
	public void bargain_goods (HttpServletRequest request , HttpServletResponse response , String goods_name)
		{
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.setOrderByClause ("addTime desc");
			goodsExample.createCriteria ().andGoodsNameLike ("%" + goods_name.trim () + "%").andGoodsStatusEqualTo (Integer.valueOf (0)).andGoodsStoreIdEqualTo (store.getId ()).andGroupBuyEqualTo (Integer.valueOf (0)).andActivityStatusEqualTo (Integer.valueOf (0)).andBargainStatusEqualTo (Integer.valueOf (0));
			List <GoodsWithBLOBs> goods_list = goodsService.getObjectList (goodsExample);
			List <Map <String, Object>> maps = new ArrayList <Map <String, Object>> ();
			for (GoodsWithBLOBs goods : goods_list)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("goods_name" , goods.getGoodsName ());
				map.put ("goods_id" , goods.getId ());
				maps.add (map);
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (Json.toJson (maps , JsonFormat.compact ()));
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@SecurityMapping(title = "特价商品保存" , value = "/seller/bargain_apply_save.htm*" , rtype = "seller" , rname = "今日特价" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_apply_save.htm" })
	public String bargain_apply_save (HttpServletRequest request , HttpServletResponse response , String goods_ids , String bargain_time , String bg_rebate , String alImgId)
		{
			if ((goods_ids != null) && (!goods_ids.equals ("")))
			{
				String [ ] ids = goods_ids.split (",");
				for (String id : ids)
				{
					if (!id.equals (""))
					{
						BargainGoods bg = new BargainGoods ();
						bg.setAddtime (new Date ());
						bg.setBgStatus (0);
						bg.setBgTime (CommUtil.formatDate (bargain_time));
						GoodsWithBLOBs goods = this.goodsService.getByKey (CommUtil.null2Long (id));
						goods.setBargainStatus (1);
						this.goodsService.updateByObject (goods);
//						double bg_price = CommUtil.mul (Double.valueOf (CommUtil.mul (Double.valueOf (0.1D) , bg_rebate)) , goods.getStorePrice ());
						BigDecimal num = BigDecimal.valueOf (0.1D);
						BigDecimal reb = BigDecimal.valueOf (CommUtil.null2Double (bg_rebate));
						bg.setBgGoods (goods);
						BigDecimal now_price = BigDecimal.valueOf (CommUtil.mul (Double.valueOf (CommUtil.mul (num , reb)) , goods.getGoodsPrice ()));
						bg.setBgPrice (now_price);
						goods.setBargainStatus (1);
						this.goodsService.updateByObject (goods);
						bg.setBgGoods (goods);
						bg.setBgRebate (BigDecimal.valueOf (CommUtil.null2Double (bg_rebate)));
						bg.setAlImgId (Long.valueOf (alImgId));
						bg.setMark (0);
						this.bargainGoodsService.add (bg);
					}
				}
				return "redirect:bargain_apply_success.htm?bargain_time=" + bargain_time;
			}
			return "redirect:bargain_apply_error.htm";
		}

	@SecurityMapping(title = "商品保存成功" , value = "/seller/bargain_apply_success.htm*" , rtype = "seller" ,
						rname = "今日特价" , rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_apply_success.htm" })
	public ModelAndView bargain_apply_success (HttpServletRequest request , HttpServletResponse response , String bargain_time)
		{
			ModelAndView mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "申请特价成功");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain_goods_list.htm?bargain_time=" + bargain_time);
			return mv;
		}

	@SecurityMapping(title = "商品保存失败" , value = "/seller/bargain_apply_error.htm*" , rtype = "seller" , rname = "今日特价" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_apply_error.htm" })
	public ModelAndView bargain_apply_error (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			mv.addObject ("op_title" , "至少选择一件商品");
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/bargain.htm");
			return mv;
		}

	@SecurityMapping(title = "特价商品列表" , value = "/seller/bargain_goods_list.htm*" , rtype = "seller" , rname = "今日特价" ,
						rcode = "bargain_seller" , rgroup = "促销管理" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/bargain_goods_list.htm" })
	public ModelAndView bargain_goods_list (HttpServletRequest request , HttpServletResponse response , String currentPage , String bargain_time)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/bargain_goods_list.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
			StoreWithBLOBs store = storeService.getObjectList (storeExample).get (0);
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ());
			List <GoodsWithBLOBs> store_goodses = goodsService.getObjectList (goodsExample);
			List <Long> storeGoodsId = new ArrayList <Long> ();
			for (GoodsWithBLOBs storeGoods : store_goodses)
			{
				storeGoodsId.add (storeGoods.getId ());
			}
			BargainGoodsExample bargainGoodsExample = new BargainGoodsExample ();
			bargainGoodsExample.clear ();
			bargainGoodsExample.setPageNo (Pagination.cpn (CommUtil.null2Int (currentPage)));
			bargainGoodsExample.setPageSize (Integer.valueOf (30));
			bargainGoodsExample.setOrderByClause ("addTime desc");
			bargainGoodsExample.createCriteria ().andBgTimeEqualTo (CommUtil.formatDate (bargain_time)).andBgGoodsIdIn (storeGoodsId);
			Pagination pList = bargainGoodsService.getObjectListWithPage (bargainGoodsExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("bargain_time" , bargain_time);
			return mv;
		}
}
