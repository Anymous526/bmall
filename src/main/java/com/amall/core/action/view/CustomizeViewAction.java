package com.amall.core.action.view;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.service.goods.IGoodsBrandService;
import com.amall.core.service.goods.IGoodsClassService;
import com.amall.core.service.goods.IGoodsFloorService;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.GoodsFloorTools;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class CustomizeViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IGoodsBrandService goodsBrandService;

	@Autowired
	private IAccessoryService accessoryService;

	@Autowired
	private IGoodsFloorService goodsfloorService;

	@Autowired
	private GoodsFloorTools gf_tools;

	/**
	 * 定制
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/customize.htm" })
	public ModelAndView customize (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("customize.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}

	@RequestMapping({ "/dingzhi_2.htm" })
	public ModelAndView dingzhi_2 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("dingzhi/dingzhi_2.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			GoodsFloorExample goodsFloorExample = new GoodsFloorExample ();
			goodsFloorExample.clear ();
			goodsFloorExample.createCriteria ().andGfMarkEqualTo ("customize");
			List <GoodsFloorWithBLOBs> gfList = this.goodsfloorService.getObjectList (goodsFloorExample);
			for (GoodsFloorWithBLOBs gf : gfList)
			{
				List <GoodsClassWithBLOBs> gcList = this.gf_tools.generic_gf_gc (gf.getGfGcList ());
				for (GoodsClassWithBLOBs gc : gcList)
				{
					gc.setSecondGcImg (this.accessoryService.getByKey (gc.getSecondGcImgId ()));
					for (GoodsClassWithBLOBs child : gc.getChilds ())
					{
						child.setSecondGcImg (this.accessoryService.getByKey (child.getSecondGcImgId ()));
					}
				}
				gf.getGcs ().addAll (gcList);
			}
			mv.addObject ("objs" , gfList);
			return mv;
		}

	@RequestMapping({ "/dingzhi_3.htm" })
	public ModelAndView dingzhi_3 (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("dingzhi/dingzhi_3.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			return mv;
		}
}
