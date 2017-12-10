package com.amall.core.action.seller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.Store;
import com.amall.core.bean.WaterMark;
import com.amall.core.bean.WaterMarkExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IWaterMarkService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.WebForm;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class WaterMarkSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IWaterMarkService watermarkService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IUserService userService;

	@SecurityMapping(title = "图片水印" , value = "/seller/watermark.htm*" , rtype = "seller" , rname = "图片管理" ,
						rcode = "album_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/watermark.htm" })
	public ModelAndView watermark (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/watermark.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Store store = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ()).getStore ();
			if (store != null)
			{
				WaterMarkExample waterMarkExample = new WaterMarkExample ();
				waterMarkExample.clear ();
				waterMarkExample.createCriteria ().andStoreIdEqualTo (store.getId ());
				List <WaterMark> wms = watermarkService.getObjectList (waterMarkExample);
				if (wms.size () > 0)
				{
					mv.addObject ("obj" , wms.get (0));
				}
			}
			return mv;
		}

	@SecurityMapping(title = "图片水印保存" , value = "/seller/watermark_save.htm*" , rtype = "seller" , rname = "图片管理" ,
						rcode = "album_seller" , rgroup = "其他设置" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/watermark_save.htm" })
	public ModelAndView watermark_save (HttpServletRequest request , HttpServletResponse response , String id , String currentPage , String cmd)
		{
			ModelAndView mv = null;
			if (SecurityUserHolder.getCurrentUser ().getStore () != null)
			{
				WebForm wf = new WebForm ();
				WaterMark watermark = null;
				if (id.equals (""))
				{
					watermark = (WaterMark) wf.toPo (request , WaterMark.class);
					watermark.setAddtime (new Date ());
				}
				else
				{
					WaterMark obj = this.watermarkService.getByKey (Long.valueOf (Long.parseLong (id)));
					watermark = (WaterMark) wf.toPo (request , obj);
				}
				watermark.setStore (SecurityUserHolder.getCurrentUser ().getStore ());
				String path = this.configService.getSysConfig ().getUploadRootPath () + "upload/wm";
				try
				{
					Map <String, Object> map = CommUtil.saveFileToServer (request , "wm_img" , path , null , null);
					if (!map.get ("fileName").equals (""))
					{
						Accessory wm_image = new Accessory ();
						wm_image.setAddtime (new Date ());
						wm_image.setHeight (CommUtil.null2Int (map.get ("height")));
						wm_image.setName (CommUtil.null2String (map.get ("fileName")));
						wm_image.setPath ("upload/wm");
						wm_image.setSize (CommUtil.null2Float (map.get ("fileSize")));
						wm_image.setUser (SecurityUserHolder.getCurrentUser ());
						wm_image.setWidth (CommUtil.null2Int ("width"));
						this.accessoryService.add (wm_image);
						watermark.setWmImage (wm_image);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace ();
				}
				if (id.equals (""))
					this.watermarkService.add (watermark);
				else
					this.watermarkService.updateByObject (watermark);
				mv = new JModelAndView ("success.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "水印设置成功");
			}
			else
			{
				mv = new JModelAndView ("error.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
				mv.addObject ("op_title" , "您尚未开店");
			}
			mv.addObject ("url" , CommUtil.getURL (request) + "/seller/watermark.htm");
			return mv;
		}
}
