package com.amall.core.action.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import com.amall.core.bean.CloudGoodsAutoExample.Criteria;
import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsAutoExample;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.service.IExpressCompanyService;
import com.amall.core.service.cloud.ICloudBuyCodesService;
import com.amall.core.service.cloud.ICloudCodesService;
import com.amall.core.service.cloud.ICloudGoodsAutoService;
import com.amall.core.service.cloud.ICloudGoodsOrderService;
import com.amall.core.service.cloud.ICloudGoodsService;
import com.amall.core.service.cloud.ICloudOnlineService;
import com.amall.core.service.cloud.ICloudStatisticsAutoService;
import com.amall.core.service.cloud.ICloudStatisticsService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CloudGoodsAutoPublicTools;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>Title: CloudGoodsAutoManageAction</p>
 * <p>Description: 兑购自动发布兑换</p>
 * @author	ygq
 * @date	2016年4月1日下午4:58:50
 * @version 1.0
 */
@Controller
public class CloudGoodsAutoManageAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	
	@Autowired
	private IGoodsClassService goodsClassService;
	
	@Autowired
	private IExpressCompanyService expressCompanyService;
	
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	
	@Autowired
	private ICloudStatisticsService cloudStatisticsService;
	
	@Autowired
	private ICloudCodesService cloudCodesService;
	
	@Autowired
	private ICloudOnlineService cloudOnlineService;
	
	@Autowired
	private ICloudGoodsOrderService cloudGoodsOrderService;
	
	@Autowired
	private IExpressCompanyService expressCompayService;
	
	@Autowired
	private IKuaidiService kuaidiService;
	
	@Autowired
	private ICloudBuyCodesService cloudBuyCodesService;
	
	@Autowired
	private ICloudGoodsAutoService cloudGoodsAutoService;
	
	@Autowired
	private CloudGoodsAutoPublicTools cloudGoodsAutoPublicTools;
	
	@Autowired
	private ICloudStatisticsAutoService cloudStatisticsAutoService;
	
	/** 
	* @Title: cloud_goods_auto 
	* @Description: 兑购兑换列表
	* @param request
	* @param response
	* @param currentPage
	* @param orderBy
	* @param orderType
	* @param goodsName
	* @param isEnable
	* @return
	* @throws 
	* @author ygq
	* @date 2016年3月30日
	*/
	@RequestMapping({ "/admin/cloud_goods_auto.htm" })
	public ModelAndView cloud_goods_auto(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goodsName, String isEnable) {
		ModelAndView mv = new JModelAndView("admin/cloud_goods_auto.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		
		CloudGoodsAutoExample example = new CloudGoodsAutoExample();
		example.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		example.setOrderByClause("addTime desc");
		Criteria criteria = example.createCriteria();
		
		if (StringUtils.isNotEmpty(goodsName)) {
			criteria.andGoodsNameLike("%" + goodsName.trim() + "%");
		}
		if (StringUtils.isNotEmpty(isEnable)) {
			criteria.andIsEnableEqualTo(Boolean.valueOf(CommUtil
							.null2Boolean(isEnable)));
		}
		
		
		Pagination pList = this.cloudGoodsAutoService.getObjectListWithPage(example);
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		mv.addObject("goodsName", goodsName);
		mv.addObject("isEnable", isEnable);
		return mv;
	}
	
	

	@RequestMapping({ "/admin/cloud_goods_auto_add.htm" })
	public ModelAndView cloud_goods_auto_add(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"admin/cloud_goods_auto_add.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		GoodsClassExample goodsClassExample = new GoodsClassExample();
		goodsClassExample.clear();
		goodsClassExample.setOrderByClause("sequence asc");
		goodsClassExample.createCriteria().andParentIdIsNull();
		List<GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList(goodsClassExample);
		
		for(GoodsClassWithBLOBs gc : gcs ) {
			goodsClassExample.clear();
			goodsClassExample.setOrderByClause("sequence asc");
			goodsClassExample.createCriteria().andParentIdEqualTo(gc.getId());
			List<GoodsClassWithBLOBs> c_gcs = this.goodsClassService.getObjectList(goodsClassExample);
			
			for(GoodsClassWithBLOBs c_gc :c_gcs) {
				goodsClassExample.clear();
				goodsClassExample.setOrderByClause("sequence asc");
				goodsClassExample.createCriteria().andParentIdEqualTo(c_gc.getId());
				List<GoodsClassWithBLOBs> c_cgcs = this.goodsClassService.getObjectList(goodsClassExample);
				c_gc.setChilds(c_cgcs);
			}
			gc.setChilds(c_gcs);
		}
		
		mv.addObject("gcs", gcs);	
			
		return mv;
	}
	
	@RequestMapping({ "/admin/cloud_goods_auto_edit.htm" })
	public ModelAndView cloud_goods_auto_edit(HttpServletRequest request,
			HttpServletResponse response, String currentPage,String id) {
		ModelAndView mv = new JModelAndView(
				"admin/cloud_goods_add.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		GoodsClassExample goodsClassExample = new GoodsClassExample();
		goodsClassExample.clear();
		goodsClassExample.setOrderByClause("sequence asc");
		goodsClassExample.createCriteria().andParentIdIsNull();
		List<GoodsClassWithBLOBs> gcs = this.goodsClassService.getObjectList(goodsClassExample);
		
		for(GoodsClassWithBLOBs gc : gcs ) {
			goodsClassExample.clear();
			goodsClassExample.setOrderByClause("sequence asc");
			goodsClassExample.createCriteria().andParentIdEqualTo(gc.getId());
			List<GoodsClassWithBLOBs> c_gcs = this.goodsClassService.getObjectList(goodsClassExample);
			
			for(GoodsClassWithBLOBs c_gc :c_gcs) {
				goodsClassExample.clear();
				goodsClassExample.setOrderByClause("sequence asc");
				goodsClassExample.createCriteria().andParentIdEqualTo(c_gc.getId());
				List<GoodsClassWithBLOBs> c_cgcs = this.goodsClassService.getObjectList(goodsClassExample);
				c_gc.setChilds(c_cgcs);
			}
			gc.setChilds(c_gcs);
		}
		
		CloudGoodsAuto cloudGoodsAuto = cloudGoodsAutoService.getByKey(CommUtil.null2Long(id));
		Accessory img = accessoryService.getByKey(cloudGoodsAuto.getGoodsImgId());
		cloudGoodsAuto.setAccessory(img);
		
		mv.addObject("gcs", gcs);
		mv.addObject("edit", Boolean.valueOf(true));
		mv.addObject("obj", cloudGoodsAuto);
		
		return mv;
	}

	@RequestMapping({ "/admin/cloud_goods_auto_save.htm" })
	public ModelAndView cloud_goods_auto_save(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String list_url, String add_url,String pid,
			String goodsImgId) {
		ModelAndView mv = new JModelAndView("admin/success.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		WebForm wf = new WebForm();
		CloudGoodsAuto goods = null;
		if (StringUtils.isEmpty(id)) {
			goods = (CloudGoodsAuto) wf.toPo(request, CloudGoodsAuto.class);
			goods.setAddtime(new Date());
		} else {
			CloudGoodsAuto obj = this.cloudGoodsAutoService.getByKey(Long
					.valueOf(id));
			goods = (CloudGoodsAuto) wf.toPo(request, obj);	
		}
		if(StringUtils.isNotEmpty(goodsImgId)){
			goods.setGoodsImgId(Long.valueOf(goodsImgId));
		}
		
		if(StringUtils.isNotEmpty(pid) && !"-1".equals(pid)) {
			GoodsClassWithBLOBs goodsClassWithBLOBs = this.goodsClassService.getByKey(CommUtil.null2Long(pid));
			if(goodsClassWithBLOBs!=null) {
				goodsClassWithBLOBs.setParent(this.goodsClassService.getByKey(goodsClassWithBLOBs.getParentId()));
				if(goodsClassWithBLOBs.getParent()!=null)
				goodsClassWithBLOBs.getParent().setParent(this.goodsClassService.getByKey(goodsClassWithBLOBs.getParent().getParentId()));
			}
			
			goods.setGoodsClassId(goodsClassWithBLOBs.getId());
		}
		
		if (StringUtils.isEmpty(id))
		{
			goods.setCloudGoodsId(0l);	
			goods.setOpenGoodsNumber(0);
			goods.setPassGoodsNumber(0);
			this.cloudGoodsAutoService.add(goods);
		}
		else 
		{
			this.cloudGoodsAutoService.updateByObject(goods);
		}
		
		Long cloudGoodsId = 0l;
		if(goods.getIsEnable() && goods.getRemainGoodsNumber() > 0 && goods.getCloudGoodsId() == 0l){
			cloudGoodsId = cloudGoodsAutoPublicTools.addCloudGoods(goods);
		}
		if(cloudGoodsId > 0){
			goods.setCloudGoodsId(cloudGoodsId);
			this.cloudGoodsAutoService.updateByObject(goods);
		}
		
		mv.addObject("list_url", list_url);
		if (add_url != null)
		{
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
				
		return mv;
	}
	
	
	@RequestMapping({ "/admin/cloud_goods_auto_delId.htm" })
	public String cloud_goods_auto_delId(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		deleteCloudGoodsAuto(CommUtil.null2Long(id),request);
		return "redirect:cloud_goods_auto.htm?currentPage=" + currentPage;
	}

	@RequestMapping({ "/admin/cloud_goods_auto_del.htm" })
	public String cloud_goods_auto_del(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				deleteCloudGoodsAuto(CommUtil.null2Long(id),request);
			}
		}
		return "redirect:cloud_goods_auto.htm?currentPage=" + currentPage;
	}
	
	private void deleteCloudGoodsAuto(Long id, HttpServletRequest request){
		/* 删除图片 */
		/*CloudGoodsAuto cloudGoodsAuto = cloudGoodsAutoService.getByKey(id);
		CloudGoodsAutoExample cloudGoodsAutoExample = new CloudGoodsAutoExample();
		if(cloudGoodsAuto.getGoodsImgId() != null){
			cloudGoodsAutoExample.createCriteria().andGoodsImgIdEqualTo(cloudGoodsAuto.getGoodsImgId());
			Integer count = cloudGoodsAutoService.getObjectListCount(cloudGoodsAutoExample);
			if(count == 1){
				Accessory img = accessoryService.getByKey(cloudGoodsAuto.getGoodsImgId());
				CommUtil.del_acc(request, img, this.configService.getSysConfig().getUploadRootPath());
			}
		}*/
		/* 删除商品 */
		cloudGoodsAutoService.deleteByKey(id);
		
		/* 删除该商品的统计数据 */
		CloudStatisticsAutoExample autoExample = new CloudStatisticsAutoExample();
		autoExample.createCriteria().andCloudGoodsAutoIdEqualTo(id);
		List<CloudStatisticsAuto> autoList = cloudStatisticsAutoService.getObjectList(autoExample);
		for (CloudStatisticsAuto cloudStatisticsAuto : autoList) {
			cloudStatisticsAutoService.deleteByKey(cloudStatisticsAuto.getId());
		}
	}
	
	@RequestMapping({ "/admin/cloud_goods_auto_search.htm" })
	@ResponseBody
	public String cloud_goods_search(HttpServletRequest request,
			HttpServletResponse response, String goodsName) {
		List<CloudGoodsAuto> goodsList = null;
		if(StringUtils.isNotEmpty(goodsName)){
			CloudGoodsAutoExample cloudGoodsAutoExample = new CloudGoodsAutoExample();
			cloudGoodsAutoExample.createCriteria().andGoodsNameLike("%"+goodsName+"%");
			cloudGoodsAutoExample.setOrderByClause("addTime desc");
			goodsList = cloudGoodsAutoService.getObjectList(cloudGoodsAutoExample);
		}
		return Json.toJson(goodsList);
	}
	
	@RequestMapping({ "/admin/cloud_goods_auto_show.htm" })
	@ResponseBody
	public String cloud_goods_show(HttpServletRequest request,
			HttpServletResponse response, String id) {
		CloudGoodsAuto cloudGoodsAuto = cloudGoodsAutoService.getByKey(CommUtil.null2Long(id));
		Accessory img = accessoryService.getByKey(cloudGoodsAuto.getGoodsImgId());
		cloudGoodsAuto.setAccessory(img);
		return Json.toJson(cloudGoodsAuto);
	}
	
	@RequestMapping({ "/admin/cloud_goods_change_auto.htm" })
	@ResponseBody
	public String cloud_goods_change_auto(HttpServletRequest request,
			HttpServletResponse response, String id,String isEnable) {
		CloudGoodsAuto auto = this.cloudGoodsAutoService.getByKey(CommUtil.null2Long(id));
		if (CommUtil.null2Boolean(isEnable)) {
			auto.setIsEnable(false);
		}else{
			auto.setIsEnable(true);
			Long cloudGoodsId = 0l;
			if(auto.getIsEnable() && auto.getRemainGoodsNumber() > 0 && auto.getCloudGoodsId() == 0l){
				cloudGoodsId = cloudGoodsAutoPublicTools.addCloudGoods(auto);
			}else{
				return "false";
			}
			if(cloudGoodsId > 0)
				auto.setCloudGoodsId(cloudGoodsId);
		}
		
		this.cloudGoodsAutoService.updateByObject(auto);
		return "true";
	}
}
