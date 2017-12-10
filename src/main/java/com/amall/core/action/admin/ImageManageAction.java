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
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.bean.AccessoryExample.Criteria;
import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;
import com.amall.core.bean.Goods2PhotoExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.goods.IGoods2PhotoService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class ImageManageAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGoods2PhotoService goods2PhotoService;

	@SecurityMapping(title = "会员相册列表", value = "/admin/user_photo_list.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "会员", display = false, rsequence = 0)
	@RequestMapping({ "/admin/user_photo_list.htm" })
	public ModelAndView user_album_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String orderBy,
			String orderType, String store_name) {
		ModelAndView mv = new JModelAndView("admin/photo_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		AlbumExample albumExample = new AlbumExample();
		albumExample.clear();
		AlbumExample.Criteria albumCriteria = albumExample.createCriteria();
		albumExample.setPageNo(Pagination.cpn(CommUtil.null2Int(currentPage)));
		albumExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		albumExample.setPageSize(Pagination.cpn(CommUtil.null2Int(Integer.valueOf(15))));
		/*AlbumQueryObject qo = new AlbumQueryObject(currentPage, mv, orderBy,
				orderType);*/

		if ((store_name != null) && (!store_name.trim().equals(""))) {
			StoreExample storeExample=new StoreExample();
			storeExample.clear();
			StoreExample.Criteria storeCriteria=storeExample.createCriteria();
			storeCriteria.andStoreNameLike("%" + store_name.trim() + "%");
			List<StoreWithBLOBs> stores=this.storeService.getObjectList(storeExample);
			List<Long> storeIds=new ArrayList<Long>();
			for(StoreWithBLOBs store:stores)
			{
				storeIds.add(store.getId());
			}
			UserExample userExample=new UserExample();
			userExample.clear();
			UserExample.Criteria userCriteria=userExample.createCriteria();
			if(storeIds != null && storeIds.size()>0){
				userCriteria.andStoreIdIn(storeIds);
			}else{
				userCriteria.andStoreIdIsNull();
			}
			
			List<User> users=this.userService.getObjectList(userExample);
			List<Long> userIds=new ArrayList<Long>();
			for(User user:users)
			{
				userIds.add(user.getId());
			}
			albumCriteria.andUserIdIn(userIds);
			/*albumCriteria.andUserIdEqualTo(currentUser.getId())
			
			qo.addQuery("obj.user.store.store_name", new SysMap(
					"store_store_name", "%" + store_name.trim() + "%"), "like");
			mv.addObject("store_name", store_name);*/
			mv.addObject("store_name",store_name);
		}
		Pagination pList = albumService.getObjectListWithPage(albumExample);
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		return mv;
	}

	@SecurityMapping(title = "会员相册删除", value = "/admin/user_photo_del.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "会员", display = false, rsequence = 0)
	@RequestMapping({ "/admin/user_photo_del.htm" })
	public String user_album_del(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				List<Accessory> accs = this.albumService.getByKey(
						Long.valueOf(Long.parseLong(id))).getPhotos();
				for (Accessory acc : accs) {
					CommUtil.del_acc(request, acc, this.configService.getSysConfig().getUploadRootPath());
					for (GoodsWithBLOBs goods : acc.getGoods_main_list()) {  
						/*goods.setGoods_main_photo(null);
						this.goodsService.updateByObject(goods);*/
						this.goodsService.deleteByKey(goods.getId());
					}
					for (GoodsWithBLOBs goods1 : acc.getGoods_list()) {
						/**
						 * 这里涉及到第三张表amall_goods_photo,暂未做
						 */
						/*
						goods1.getGoods_photos().remove(acc);//amall_goods_photo表
						this.goodsService.updateByObject(goods1);*/
						Goods2PhotoExample goods2PhotoExample=new Goods2PhotoExample();
						goods2PhotoExample.clear();
						Goods2PhotoExample.Criteria goods2PhotoCriteria=goods2PhotoExample.createCriteria();
						goods2PhotoCriteria.andGoodsIdEqualTo(goods1.getId());
						goods2PhotoCriteria.andPhotoIdEqualTo(acc.getId());
						this.goods2PhotoService.deleteByExample(goods2PhotoExample);
					}
				}
				this.albumService.deleteByKey(Long.valueOf(Long.parseLong(id)));
			}
		}
		String url = "redirect:/admin/user_photo_list.htm?currentPage="
				+ currentPage;
		return url;
	}

	@SecurityMapping(title = "会员相册图片列表", value = "/admin/user_pic_list.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "会员", display = false, rsequence = 0)
	@RequestMapping({ "/admin/user_pic_list.htm" })
	public ModelAndView user_pic_list(HttpServletRequest request,
			HttpServletResponse response, String aid, String currentPage,
			String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/pic_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		AccessoryExample accessoryExample = new AccessoryExample();
		accessoryExample.clear();
		Criteria accessoryCriteria = accessoryExample.createCriteria();
		accessoryExample.setPageNo(Pagination.cpn((CommUtil
				.null2Int(currentPage))));
		accessoryExample.setOrderByClause(Pagination.cst(orderBy, orderType));
		accessoryExample.setPageSize(Integer.valueOf(50));
		/*
		 * AccessoryQueryObject qo = new AccessoryQueryObject(currentPage, mv,
		 * orderBy, orderType);
		 */
		accessoryCriteria.andAlbumIdEqualTo(CommUtil.null2Long(aid));

		/*
		 * qo.addQuery("obj.album.id", new SysMap("obj_album_id",
		 * CommUtil.null2Long(aid)), "="); qo.setPageSize(Integer.valueOf(50));
		 */
		Pagination pList = accessoryService
				.getObjectListWithPage(accessoryExample);
		// IPageList pList = this.accessoryService.list(qo);
		CommUtil.addIPageList2ModelAndView("", "", "", pList, mv);
		Album album = this.albumService.getByKey(CommUtil.null2Long(aid));
		mv.addObject("album", album);
		return mv;
	}

	@SecurityMapping(title = "会员相册图片删除", value = "/admin/user_pic_del.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "会员", display = false, rsequence = 0)
	@RequestMapping({ "/admin/user_pic_del.htm" })
	public String user_pic_del(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String mulitId,
			String aid) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			Integer flag;
			Accessory obj = this.accessoryService.getByKey(CommUtil
					.null2Long(id));
			flag = this.accessoryService.deleteByKey(CommUtil.null2Long(id));
			if (flag > 0) {
				CommUtil.del_acc(request, obj, this.configService.getSysConfig().getUploadRootPath());
			}
		}
		String url = "redirect:/admin/user_pic_list.htm?currentPage="
				+ currentPage + "&aid=" + aid;
		return url;
	}
}
