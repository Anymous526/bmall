package com.amall.core.action.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.annotation.SecurityMapping;
import com.amall.core.bean.Consult;
import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.ConsultWithBLOBs;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Store;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.IConsultService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.MsgTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * <p>
 * Title: ConsultSellerAction
 * </p>
 * <p>
 * Description: 卖家咨询管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015年6月23日下午8:34:49
 * @version 1.0
 */
@Controller
public class ConsultSellerAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IConsultService consultService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private MsgTools msgTools;

	@SecurityMapping(title = "卖家咨询列表" , value = "/seller/consult.htm*" , rtype = "seller" , rname = "咨询管理" ,
						rcode = "consult_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/consult.htm" })
	public ModelAndView consult (HttpServletRequest request , HttpServletResponse response , String reply , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/consult.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			ConsultExample consultExample = new ConsultExample ();
			consultExample.clear ();
			consultExample.setPageNo (Pagination.cpn (CommUtil.null2Int (consultExample)));
			consultExample.setOrderByClause ("addTime desc");
			ConsultExample.Criteria consultCriteria = consultExample.createCriteria ();
			if (!CommUtil.null2String (reply).equals (""))
			{
				consultCriteria.andReplyEqualTo (Boolean.valueOf (CommUtil.null2Boolean (reply)));
			}
			User user = this.userService.getByKey (SecurityUserHolder.getCurrentUser ().getId ());
			Store store = storeService.getByKey (user.getStore ().getId ());
			Goods goods = null;
			GoodsExample goodsExample = new GoodsExample ();
			goodsExample.clear ();
			goodsExample.createCriteria ().andGoodsStoreIdEqualTo (store.getId ());
			List <GoodsWithBLOBs> goodses = goodsService.getObjectList (goodsExample);
			if (null != goodses && goodses.size () > 0)
			{
				goods = goodses.get (0);
			}
			if (null != goods && null != goods.getId () && !goods.getId ().toString ().equals (""))
			{
				consultCriteria.andGoodsIdEqualTo (goods.getId ());
			}
			Pagination pList = consultService.getObjectListWithPage (consultExample);
			CommUtil.addIPageList2ModelAndView ("" , "" , "" , pList , mv);
			mv.addObject ("reply" , CommUtil.null2String (reply));
			return mv;
		}

	@SecurityMapping(title = "卖家咨询回复" , value = "/seller/consult_reply.htm*" , rtype = "seller" , rname = "咨询管理" ,
						rcode = "consult_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/consult_reply.htm" })
	public ModelAndView consult_reply (HttpServletRequest request , HttpServletResponse response , String id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("seller/usercenter/consult_reply.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Consult obj = this.consultService.getByKey (CommUtil.null2Long (id));
			mv.addObject ("obj" , obj);
			mv.addObject ("currentPage" , currentPage);
			return mv;
		}

	@SecurityMapping(title = "卖家咨询回复保存" , value = "/seller/consult_reply_save.htm*" , rtype = "seller" ,
						rname = "咨询管理" , rcode = "consult_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/consult_reply_save.htm" })
	public String consult_reply_save (HttpServletRequest request , HttpServletResponse response , String id , String consult_reply , String currentPage) throws Exception
		{
			ConsultWithBLOBs obj = this.consultService.getByKey (CommUtil.null2Long (id));
			obj.setConsultReply (consult_reply);
			obj.setReplyTime (new Date ());
			obj.setReplyUser (SecurityUserHolder.getCurrentUser ());
			obj.setReply (true);
			this.consultService.updateByObject (obj);
			send_email (request , obj , "email_tobuyer_cousult_reply_notify");
			return "redirect:consult.htm?currentPage=" + currentPage;
		}

	@SecurityMapping(title = "卖家咨询删除" , value = "/seller/consult_del.htm*" , rtype = "seller" , rname = "咨询管理" ,
						rcode = "consult_seller" , rgroup = "客户服务" , display = false , rsequence = 0)
	@RequestMapping({ "/seller/consult_del.htm" })
	public String consult_del (HttpServletRequest request , HttpServletResponse response , String mulitId , String consult_reply , String currentPage)
		{
			String [ ] ids = mulitId.split (",");
			for (String id : ids)
			{
				if (!id.equals (""))
				{
					this.consultService.deleteByKey (CommUtil.null2Long (id));
				}
			}
			return "redirect:consult.htm?currentPage=" + currentPage;
		}

	@SuppressWarnings("deprecation")
	private void send_email (HttpServletRequest request , Consult obj , String mark) throws Exception
		{
			Template template = null;
			TemplateExample templateExample = new TemplateExample ();
			templateExample.clear ();
			templateExample.createCriteria ().andMarkEqualTo (mark);
			List <Template> templates = templateService.getObjectList (templateExample);
			if (templates != null && templates.size () > (0))
			{
				template = templates.get (0);
			}
			if (null!=template && template.getOpen ())
			{
				String email = obj.getConsultEmail ();
				String subject = template.getTitle ();
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
				context.put ("buyer" , obj.getConsultUser ());
				context.put ("config" , this.configService.getSysConfig ());
				context.put ("send_time" , CommUtil.formatLongDate (new Date ()));
				context.put ("webPath" , CommUtil.getURL (request));
				context.put ("goods" , obj.getGoods ());
				StringWriter writer = new StringWriter ();
				blank.merge (context , writer);
				String content = writer.toString ();
				this.msgTools.sendEmail (email , subject , content);
			}
		}
}
