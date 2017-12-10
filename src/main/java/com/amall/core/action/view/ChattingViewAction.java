package com.amall.core.action.view;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Chatting;
import com.amall.core.bean.ChattingExample;
import com.amall.core.bean.ChattingLog;
import com.amall.core.bean.ChattingLogExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.chatting.IChattingFriendService;
import com.amall.core.service.chatting.IChattingLogService;
import com.amall.core.service.chatting.IChattingService;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.sns.ISnsFriendService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.page.Pagination;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.UserTools;
import com.amall.core.web.virtual.JModelAndView;

/**
 * 
 * Title : @ChattingViewAction
 *
 * Description : 用户在线即时咨询功能
 * 
 * Company : www.hg-sem.com
 *
 * @Author wsw
 *
 * @date 2015年6月26日 下午2:43:53
 *
 */
@Controller
public class ChattingViewAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ISnsFriendService snsFriendService;

	@Autowired
	private UserTools userTools;

	@Autowired
	private IChattingFriendService chattingFriendService;

	@Autowired
	private IChattingLogService chattinglogService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IChattingService chattingService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGoodsService goodsService;

	@RequestMapping({ "/chatting.htm" })
	public ModelAndView chatting (HttpServletRequest request , HttpServletResponse response , String receiverId , String goodsId)
		{
			ModelAndView mv = new JModelAndView ("chatting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			mv.addObject ("store" , this.storeService.getByKey (CommUtil.null2Long (goodsWithBLOBs.getGoodsStoreId ())));
			mv.addObject ("goods" , goodsWithBLOBs);
			if (user != null)
			{
				// 连续左连接
				StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (goodsWithBLOBs.getGoodsStoreId ()));
				mv.addObject ("store" , store);
				User receiver = this.userService.getByKey (CommUtil.null2Long (receiverId));
				ChattingExample chattingExample = new ChattingExample ();
				chattingExample.clear ();
				chattingExample.createCriteria ().andUser1IdEqualTo (receiver.getId ()).andUser2IdEqualTo (user.getId ());
				ChattingExample.Criteria criteria = chattingExample.createCriteria ();
				criteria.andUser1IdEqualTo (user.getId ()).andUser2IdEqualTo (receiver.getId ());
				chattingExample.or (criteria);
				List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
				ChattingLogExample chattingLogExample = new ChattingLogExample ();
				if (chattings != null && chattings.size () > 0)
				{
					for (Chatting c : chattings)
					{
						chattingLogExample.clear ();
						chattingExample.setOrderByClause ("addTime asc");
						chattingLogExample.createCriteria ().andChattingIdEqualTo (c.getId ());
						List <ChattingLog> chattingLogs = this.chattinglogService.getObjectList (chattingLogExample);
						c.setChattingLogs (chattingLogs);
						for (ChattingLog log : chattingLogs)
						{
							log.setMark (Integer.valueOf (0));	// 打开窗口后,把当前所有的日志记录都设置为已读
							this.chattinglogService.updateByObject (log);
						}
					}
				}
				mv.addObject ("chattings" , chattings);
				List <Object> list = new ArrayList <Object> ();
				for (int i = 1 ; i <= 60 ; i++)
				{
					list.add (Integer.valueOf (i));	// 秒数
				}
				mv.addObject ("emoticons" , list);
			}
			else
			{
				// 用户未登录
			}
			return mv;
		}

	/**
	 * 
	 * @todo 聊天刷新
	 * @author wsw
	 * @date 2015年6月26日 下午4:25:23
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param user_id
	 * @return
	 */
	@RequestMapping({ "/chatting_refresh.htm" })
	public ModelAndView chatting_refresh (HttpServletRequest request , HttpServletResponse response , String user_id)
		{
			ModelAndView mv = new JModelAndView ("chatting_logs.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
//			Chatting chatting = null;
//			User seller = this.userService.getByKey (CommUtil.null2Long (user_id));	// 当前用户聊天的对象
			if (null != SecurityUserHolder.getCurrentUser ())
			{
				ChattingExample chattingExample = new ChattingExample ();
				chattingExample.clear ();
				chattingExample.setOrderByClause ("addTime asc");
				chattingExample.createCriteria ().andUser1IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser2IdEqualTo (CommUtil.null2Long (user_id));
				ChattingExample.Criteria criteria2 = chattingExample.createCriteria ();
				criteria2.andUser1IdEqualTo (CommUtil.null2Long (user_id)).andUser2IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				chattingExample.or (criteria2);
				List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
				if (chattings.size () > 0)
				{
					for (Chatting c : chattings)
					{
						ChattingLogExample chattingLogExample = new ChattingLogExample ();
						chattingLogExample.clear ();
						chattingLogExample.createCriteria ().andChattingIdEqualTo (c.getId ());
						chattingLogExample.setOrderByClause ("addTime asc");
						List <ChattingLog> logs = this.chattinglogService.getObjectList (chattingLogExample);
						for (ChattingLog log : logs)
						{
							log.setMark (0);
							this.chattinglogService.updateByObject (log);
						}
						c.setChattingLogs (logs);
					}
					mv.addObject ("chattings" , chattings);
					// 查找到聊天记录
				}
			}
			return mv;
		}

	/**
	 * 
	 * @todo 展现聊天历史记录
	 * @author wsw
	 * @date 2015年6月26日 下午4:35:27
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param user_id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping({ "/chatting_ShowHistory.htm" })
	public ModelAndView chatting_ShowHistory (HttpServletRequest request , HttpServletResponse response , String user_id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("chatting_logs.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Chatting chatting = null;
			if (null != SecurityUserHolder.getCurrentUser ())
			{
				ChattingExample chattingExample = new ChattingExample ();
				chattingExample.clear ();
				chattingExample.createCriteria ().andUser1IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser2IdEqualTo (CommUtil.null2Long (user_id));
				ChattingExample.Criteria criteria2 = chattingExample.createCriteria ();
				criteria2.andUser1IdEqualTo (CommUtil.null2Long (user_id)).andUser2IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				chattingExample.or (criteria2);
				List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
				/*
				 * Map map = new HashMap();
				 * map.put("uid", SecurityUserHolder.getCurrentUser().getId());
				 * map.put("user_id", CommUtil.null2Long(user_id));
				 * List chattings = this.chattingService
				 * .query(
				 * "select obj from Chatting obj where obj.user1.id=:uid and obj.user2.id=:user_id or obj.user1.id=:user_id and obj.user2.id=:uid"
				 * ,
				 * map, -1, -1);
				 */
				if (chattings.size () > 0)
				{
					chatting = (Chatting) chattings.get (0);
					/*
					 * ChattingLogQueryObject qo = new ChattingLogQueryObject(currentPage, mv, null,
					 * null);
					 */
					ChattingLogExample chattingLogExample = new ChattingLogExample ();
					chattingLogExample.clear ();
					chattingLogExample.setOrderByClause ("addTime desc");
					chattingLogExample.setPageSize (Integer.valueOf (10));
					chattingLogExample.createCriteria ().andChattingIdEqualTo (chatting.getId ());
					Pagination pList = this.chattinglogService.getObjectListWithPage (chattingLogExample);
					String ajax_url = CommUtil.getURL (request) + "/chatting_showHistory.htm";
					mv.addObject ("historys" , pList.getList ());
					mv.addObject ("gotoPageAjaxHTML" , CommUtil.showPageAjaxHtml (ajax_url , "" , pList.getPageNo () , pList.getTotalPage ()));
					/*
					 * qo.addQuery("obj.chatting.id", new SysMap("chatting_id", chatting.getId()),
					 * "=");
					 * qo.setOrderBy("addTime");
					 * qo.setOrderType("desc");
					 * qo.setPageSize(Integer.valueOf(10));
					 * IPageList pList = this.chattinglogService.list(qo);
					 * mv.addObject("historys", pList.getResult());
					 * String Ajax_url = CommUtil.getURL(request) +
					 * "/chatting_ShowHistory.htm";
					 * mv
					 * .addObject("gotoPageAjaxHTML",
					 * CommUtil.showPageAjaxHtml(Ajax_url, "", pList
					 * .getCurrentPage(), pList.getPages()));
					 */
				}
			}
			return mv;
		}

	/**
	 * 
	 * @todo 聊天记录接收,保存 , 返回当前最新的消息,并组成html标签,append到最下面的地方
	 * @author wsw
	 * @date 2015年6月26日 下午4:45:48
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param user_id
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping({ "/chatting_save.htm" })
	@ResponseBody
	public String chatting_save (HttpServletRequest request , HttpServletResponse response , String content , String goodsId)
		{
			// List <ChattingLog> logs = new ArrayList <ChattingLog> ();
			GoodsWithBLOBs goodsWithBLOBs = this.goodsService.getByKey (CommUtil.null2Long (goodsId));
			StoreWithBLOBs store = null;
			if (goodsWithBLOBs != null)
			{
				store = this.storeService.getByKey (CommUtil.null2Long (goodsWithBLOBs.getGoodsStoreId ()));
				User seller = null;
				if (store != null)
				{
					seller = store.getUser ();
					Chatting chatting = null;
					if (null != SecurityUserHolder.getCurrentUser ())
					{
						ChattingExample chattingExample = new ChattingExample ();
						chattingExample.clear ();
						chattingExample.createCriteria ().andUser1IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser2IdEqualTo (CommUtil.null2Long (seller.getId ()));
						ChattingExample.Criteria criteria2 = chattingExample.createCriteria ();
						criteria2.andUser1IdEqualTo (CommUtil.null2Long (seller.getId ())).andUser2IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
						chattingExample.or (criteria2);
						List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
						if (chattings.size () > 0)
						{
							chatting = (Chatting) chattings.get (0);
						}
						else
						{
							chatting = new Chatting ();
							chatting.setAddtime (new Date ());
							chatting.setUser1 (seller);
							chatting.setUser1Id (seller.getId ());
							chatting.setUser2 (SecurityUserHolder.getCurrentUser ());
							chatting.setUser2Id (SecurityUserHolder.getCurrentUser ().getId ());
							this.chattingService.add (chatting);
						}
						ChattingLog log = new ChattingLog ();
						log.setAddtime (new Date ());
						log.setUser (SecurityUserHolder.getCurrentUser ());
						log.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
						log.setChattingId (chatting.getId ());
						log.setContent (content);
						log.setChatting (chatting);
						log.setMark (Integer.valueOf (1));
						log.setGoodsId (CommUtil.null2Long (goodsId));
						this.chattinglogService.add (log);
						// ChattingLogExample chattingLogExample = new ChattingLogExample ();
						// chattingLogExample.clear ();
						// chattingLogExample.setOrderByClause ("addTime desc");
						// chattingLogExample.createCriteria ().andChattingIdEqualTo (chatting.getId
						// ()).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
						// logs = this.chattinglogService.getObjectList (chattingLogExample);
					}
				}
			}
			User user = SecurityUserHolder.getCurrentUser ();
			String img = "$!webPath/" + user.getPhoto ().getPath () + "/" + user.getPhoto ().getName () + "_small." + user.getPhoto ().getExt ();
			String resultJson = user.getId () + "," + img + "^" + content;
			return resultJson;
		}

	/**
	 * 
	 * @todo 计算当前可输入字数
	 * @author wsw
	 * @date 2015年7月1日 下午2:44:50
	 * @return String
	 * @param request
	 * @param response
	 * @param msgCount
	 * @return
	 */
	@RequestMapping({ "/msgCount.htm" })
	@ResponseBody
	public String reclMsgCount (HttpServletRequest request , HttpServletResponse response , String msgCount)
		{
			int result = 350 - CommUtil.null2Int (msgCount);
			return result + "";
		}

	/**
	 * 
	 * @todo 使用Ajax动态刷新, 是否接收到新的信息
	 * @author wsw
	 * @date 2015年7月1日 下午5:09:27
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/msgReceive.htm" })
	public ModelAndView msgReceive (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("msgReceive.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();
			if (user != null)
			{
				// 通过两表左连接查询 , 返回一个chattinglog集合 , 遍历该集合,拿到一个发信息的userId集合 这样可以获得发信息的 user列表 ,
				// 在页面进行遍历出来,
				// 接着使用ajax进行异步刷新, 当点击某个用户名的时候, 将id传到聊天页面
				List <ChattingLog> logs = this.chattinglogService.selectLogsByMarkAndUser1Id (user.getId ());	// 将当前对象作为信息接受者来传入
				List <User> users = new ArrayList <User> ();
				for (ChattingLog log : logs)
				{
					log.setUser (this.userService.getByKey (log.getUserId ()));	// 获得每一个日志中的用户对象 ,
																				// 按userId进行的分组查询
					users.add (log.getUser ());
				}
				mv.addObject ("logs" , logs);
				mv.addObject ("users" , users);
			}
			return mv;
		}
}
