package com.amall.core.action.admin;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class CombinManageAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsService goodsService;

	@SecurityMapping(title = "组合销售设置", value = "/admin/set_combin.htm*", rtype = "admin", rname = "组合销售", rcode = "combin_admin", rgroup = "运营", display = false, rsequence = 0)
	@RequestMapping({ "/admin/set_combin.htm" })
	public ModelAndView set_combin(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/set_combin.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "组合销售设置保存", value = "/admin/set_combin_save.htm*", rtype = "admin", rname = "组合销售", rcode = "combin_admin", rgroup = "运营", display = false, rsequence = 0)
	@RequestMapping({ "/admin/set_combin_save.htm" })
	public ModelAndView set_combin_save(HttpServletRequest request,
			HttpServletResponse response, String id) {
		SysConfigWithBLOBs obj = this.configService.getSysConfig();
		WebForm wf = new WebForm();
		SysConfigWithBLOBs sysConfig = null;
		if (id.equals("")) {
			sysConfig = (SysConfigWithBLOBs) wf.toPo(request, SysConfig.class);
			//sysConfig.setAddTime(new Date());
			sysConfig.setAddtime(new Date());
		} else {
			sysConfig = (SysConfigWithBLOBs) wf.toPo(request, obj);
		}
		if (id.equals(""))
			this.configService.add(sysConfig);
		else {
			//this.configService.update(sysConfig);
			this.configService.updateByObject(sysConfig);
		}
		ModelAndView mv = new JModelAndView("admin/success.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);

		mv.addObject("op_title", "组合销售设置成功");
		mv.addObject("list_url", CommUtil.getURL(request)
				+ "/admin/set_combin.htm");
		return mv;
	}

	@SecurityMapping(title = "组合销售设置", value = "/admin/combin_goods.htm*", rtype = "admin", rname = "组合销售", rcode = "combin_admin", rgroup = "运营", display = false, rsequence = 0)
	@RequestMapping({ "/admin/combin_goods.htm" })
	public ModelAndView combin_goods(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goods_name, String combin_status) {
		ModelAndView mv = new JModelAndView("admin/combin_goods.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		//GoodsQueryObject qo = new GoodsQueryObject(currentPage, mv, orderBy,orderType);
		GoodsExample goodsExample=new GoodsExample();
		goodsExample.clear();
		GoodsExample.Criteria goodsCriteria=goodsExample.createCriteria();
		goodsExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		goodsExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		
		goodsCriteria.andCombinStatusGreaterThan(Integer.valueOf(0));
		goodsCriteria.andGoodsStatusEqualTo(Integer.valueOf(0));
		if (!CommUtil.null2String(goods_name).equals("")) {
			goodsCriteria.andGoodsNameLike("%"
					+ goods_name.trim() + "%");
			mv.addObject("goods_name", goods_name);
		}
		if (!CommUtil.null2String(combin_status).equals("")) {
			goodsCriteria.andCombinStatusEqualTo(Integer.valueOf(CommUtil.null2Int(combin_status)));
			mv.addObject("combin_status", combin_status);
		}
		//IPageList pList = this.goodsService.list(qo);
		Pagination pList=this.goodsService.getObjectListWithPage(goodsExample);
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		return mv;
	}

	@SecurityMapping(title = "组合销售商品审核", value = "/admin/combin_goods_audit.htm*", rtype = "admin", rname = "组合销售", rcode = "combin_admin", rgroup = "运营", display = false, rsequence = 0)
	@RequestMapping({ "/admin/combin_goods_audit.htm" })
	public String combin_goods_audit(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!CommUtil.null2String(id).equals("")) {
				GoodsWithBLOBs goods = this.goodsService.getByKey(CommUtil
						.null2Long(id));
				goods.setCombinStatus(2);
				this.goodsService.updateByObject(goods);
			}
		}
		return "redirect:combin_goods.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "组合销售商品拒绝", value = "/admin/combin_goods_refuse.htm*", rtype = "admin", rname = "组合销售", rcode = "combin_admin", rgroup = "运营", display = false, rsequence = 0)
	@RequestMapping({ "/admin/combin_goods_refuse.htm" })
	public String combin_goods_refuse(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!CommUtil.null2String(id).equals("")) {
				GoodsWithBLOBs goods = this.goodsService.getByKey(CommUtil
						.null2Long(id));
				goods.setCombinStatus(-1);
				this.goodsService.updateByObject(goods);
			}
		}
		return "redirect:combin_goods.htm?currentPage=" + currentPage;
	}
}
