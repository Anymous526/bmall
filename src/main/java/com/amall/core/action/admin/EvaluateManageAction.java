package com.amall.core.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;



/**
 * 商品评价
 * @author ljx
 *
 */

@Controller
public class EvaluateManageAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IEvaluateService evaluateService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IGoodsService goodsService;
	

	@SecurityMapping(title = "商品评价列表", value = "/admin/evaluate_list.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/evaluate_list.htm" })
	public ModelAndView evaluate_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String goods_name, String userName) {
		ModelAndView mv = new JModelAndView("admin/evaluate_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		EvaluateExample evaluateExample = new EvaluateExample();
		evaluateExample.clear();
		evaluateExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		evaluateExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		EvaluateExample.Criteria evaluateCriteria = evaluateExample.createCriteria();
		
		//EvaluateQueryObject qo = new EvaluateQueryObject(currentPage, mv,orderBy, orderType);
		if (!CommUtil.null2String(goods_name).equals("")) {
			//qo.addQuery("obj.evaluate_goods.goods_name", new SysMap("goods_name", "%" + goods_name + "%"), "like");
			GoodsExample goodsExample=new GoodsExample();
			goodsExample.clear();
			GoodsExample.Criteria goodsCriteria=goodsExample.createCriteria();
			goodsCriteria.andGoodsNameLike("%" + goods_name + "%");
			List<GoodsWithBLOBs> goods=this.goodsService.getObjectList(goodsExample);
			List<Long> goodsId=new ArrayList<Long>();
			for(Goods good:goods)
			{
				goodsId.add(good.getId());
			}
			if(goodsId!=null && goodsId.size()>0){
				evaluateCriteria.andEvaluateGoodsIdIn(goodsId);
			}else{
				evaluateCriteria.andEvaluateGoodsIdIsNull();
			}
			
			//TODU
		//	evaluateCriteria.and
		}
		if (!CommUtil.null2String(userName).equals("")) {
			//qo.addQuery("obj.evaluate_user.userName", new SysMap("evaluate_user", userName), "=");
					
		//	evaluateCriteria
			UserExample userExample=new UserExample();
			userExample.clear();
			UserExample.Criteria userCriteria=userExample.createCriteria();
			userCriteria.andUsernameEqualTo(userName);
			List<User> users=this.userService.getObjectList(userExample);
			if(users!=null&&users.size()!=0)
			{
				evaluateCriteria.andEvaluateUserIdEqualTo(users.get(0).getId());
			}else{
				evaluateCriteria.andEvaluateUserIdIsNull();
			}
		}
		mv.addObject("goods_name", goods_name);
		mv.addObject("userName", userName);
		
		
		
		Pagination pList=evaluateService.getObjectListWithPage(evaluateExample);
	
		//IPageList pList = this.evaluateService.list(qo);
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		return mv;
	}

	@SecurityMapping(title = "商品评价编辑", value = "/admin/evaluate_edit.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/evaluate_edit.htm" })
	public ModelAndView evaluate_edit(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/evaluate_edit.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		EvaluateWithBLOBs obj = this.evaluateService.getByKey(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		return mv;
	}

	@SecurityMapping(title = "商品评价编辑", value = "/admin/evaluate_save.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "交易", display = false, rsequence = 0)
	@RequestMapping({ "/admin/evaluate_save.htm" })
	public ModelAndView evaluate_save(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String id,
			String evaluate_status, String evaluate_admin_info,
			String list_url, String edit) {
		ModelAndView mv = new JModelAndView("admin/success.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		EvaluateWithBLOBs obj = this.evaluateService.getByKey(CommUtil.null2Long(id));
		obj.setEvaluateAdminInfo(evaluate_admin_info);
		obj.setEvaluateStatus(CommUtil.null2Int(evaluate_status));
		this.evaluateService.updateByObject(obj);
		if ((CommUtil.null2Boolean(edit)) && (obj.getEvaluateStatus() == 2)) {
			User user = obj.getEvaluate_user();
			StoreWithBLOBs store = obj.getEvaluate_seller_user().getStore();
			user.setUserCredit(user.getUserCredit()
					- obj.getEvaluateBuyerVal());
			this.userService.updateByObject(user);
			store.setStoreCredit(store.getStoreCredit()
					- obj.getEvaluateSellerVal());
			this.storeService.updateByObject(store);
		}
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "商品评价编辑成功");
		return mv;
	}
}
