package com.amall.core.web.tools;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.service.IEvaluateService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.goods.IGoodsSpecPropertyService;
import com.amall.core.service.goods.IOrderFormItemService;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;

/**
 * 
 * <p>Title: StoreTools</p>
 * <p>Description: 店铺工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-24下午5:44:32
 * @version 1.0
 */
@Component
public class StoreTools {
	
	@Autowired
	private ISysConfigService configService;
	
	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderFormService orderFormService;
	
	@Autowired
	private IOrderFormItemService orderFormItemService;
	
	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IEvaluateService evaluateService;
	
	@Autowired
	private IGoodsSpecPropertyService goodsSpecPropertyService;
	
	/**
	 * 
	 * <p>Title: genericProperty</p>
	 * <p>Description: 根据规格信息 加载规格属性内容</p>
	 * @param spec
	 * @return
	 */
	public String genericProperty(GoodsSpecification spec) {
		String val = "";
		
		GoodsSpecPropertyExample goodsSpecPropertyExample = new GoodsSpecPropertyExample();
		goodsSpecPropertyExample.clear();
		GoodsSpecPropertyExample.Criteria goodsSpecPropertyCriteria = goodsSpecPropertyExample.createCriteria();
		goodsSpecPropertyCriteria.andSpecIdEqualTo(spec.getId());
		List<GoodsSpecProperty> list = this.goodsSpecPropertyService.getObjectList(goodsSpecPropertyExample);
		if(list != null && !list.isEmpty()){
			spec.getProperties().addAll(list);
			for (GoodsSpecProperty gsp : spec.getProperties()) {
				val = val + "," + gsp.getValue();
			}
			if (!val.equals("")) {
				return val.substring(1);
			}
		}
		return "";
	}
	/**
	 * 
	 * <p>Title: createUserFolder</p>
	 * <p>Description: 创建用户文件夹</p>
	 * @param request
	 * @param config
	 * @param store
	 * @return
	 */
	public String createUserFolder(HttpServletRequest request,
			SysConfigWithBLOBs config, StoreWithBLOBs store) {
		String path = "";
		String uploadFilePath = config.getUploadfilepath();
		if (config.getImagesavetype().equals("sidImg")) {
			path = this.configService.getSysConfig().getUploadRootPath()
					+ uploadFilePath 
					+ File.separator 
					+ "store"
					+ File.separator 
					+ store.getId();
		}

		if (config.getImagesavetype().equals("sidYearImg")) {
			path = this.configService.getSysConfig().getUploadRootPath()
					+ uploadFilePath 
					+ File.separator 
					+ "store"
					+ File.separator 
					+ store.getId() 
					+ File.separator
					+ CommUtil.formatTime("yyyy", new Date());
		}
		if (config.getImagesavetype().equals("sidYearMonthImg")) {
			path = this.configService.getSysConfig().getUploadRootPath()
					+ uploadFilePath 
					+ File.separator 
					+ "store"
					+ File.separator 
					+ store.getId() 
					+ File.separator
					+ CommUtil.formatTime("yyyy", new Date()) 
					+ File.separator
					+ CommUtil.formatTime("MM", new Date());
		}
		if (config.getImagesavetype().equals("sidYearMonthDayImg")) {
			path = this.configService.getSysConfig().getUploadRootPath()
					+ uploadFilePath 
					+ File.separator 
					+ "store"
					+ File.separator 
					+ store.getId() 
					+ File.separator
					+ CommUtil.formatTime("yyyy", new Date()) 
					+ File.separator
					+ CommUtil.formatTime("MM", new Date()) 
					+ File.separator
					+ CommUtil.formatTime("dd", new Date());
			
		}
		
		CommUtil.createFolder(path);
		return path;
	}
	/**
	 * 
	 * <p>Title: createUserFolderURL</p>
	 * <p>Description: 创建用户文件夹</p>
	 * @param config  用户信息
	 * @param store   店铺信息
	 * @return  文件夹路径
	 */
	public String createUserFolderURL(SysConfigWithBLOBs config, StoreWithBLOBs store) {
		String path = "";
		String uploadFilePath = config.getUploadfilepath();
		if (config.getImagesavetype().equals("sidImg")) {
			path = uploadFilePath 
					+ "/store/" 
					+ store.getId().toString();
		}

		if (config.getImagesavetype().equals("sidYearImg")) {
			path = uploadFilePath 
					+ "/store/" 
					+ store.getId() 
					+ "/"
					+ CommUtil.formatTime("yyyy", new Date());
		}
		if (config.getImagesavetype().equals("sidYearMonthImg")) {
			path = uploadFilePath 
					+ "/store/" 
					+ store.getId() 
					+ "/"
					+ CommUtil.formatTime("yyyy", new Date()) 
					+ "/"
					+ CommUtil.formatTime("MM", new Date());
		}
		if (config.getImagesavetype().equals("sidYearMonthDayImg")) {
			path = uploadFilePath 
					+ "/store/" 
					+ store.getId() 
					+ "/"
					+ CommUtil.formatTime("yyyy", new Date())
					+ "/"
					+ CommUtil.formatTime("MM", new Date()) 
					+ "/"
					+ CommUtil.formatTime("dd", new Date());
		}
		return path;
	}

	public String generic_goods_class_info(GoodsClass gc) {
		if (gc != null) {
			String goods_class_info = generic_the_goods_class_info(gc);
			return goods_class_info.substring(0, goods_class_info.length() - 1);
		}
		return "";
	}

	private String generic_the_goods_class_info(GoodsClass gc) {
		if (gc != null) {
			String goods_class_info = gc.getClassname() + ">";
			if (gc.getParent() != null) {
				String class_info = generic_the_goods_class_info(gc.getParent());
				goods_class_info = class_info + goods_class_info;
			}
			return goods_class_info;
		}
		return "";
	}
	/**
	 * 
	 * <p>Title: query_store_with_user</p>
	 * <p>Description: 查询用户是否开店</p>
	 * @param user_id  用户id	
	 * @return  int  有就返回1，没有就返回0
	 */
	public int query_store_with_user(String user_id) {
		int status = 0;
		
		User user = userService.getByKey(CommUtil.null2Long(user_id));
		
		
		//Store store = storeService.getByKey(user.getId());
		
		/*Store store = this.storeService.getObjByProperty("user.id",
				CommUtil.null2Long(user_id));*/
		if (user.getStore() != null)
			status = 1;
		return status;
	}
}
