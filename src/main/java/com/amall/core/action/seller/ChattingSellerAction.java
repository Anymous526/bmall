package com.amall.core.action.seller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.amall.core.bean.Chatting;
import com.amall.core.bean.ChattingExample;
import com.amall.core.bean.ChattingFriend;
import com.amall.core.bean.ChattingFriendExample;
import com.amall.core.bean.ChattingLog;
import com.amall.core.bean.ChattingLogExample;
import com.amall.core.bean.SnsFriend;
import com.amall.core.bean.SnsFriendExample;
//import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
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
 * Description : 卖家用户在线即时咨询功能
 * 
 * Company : www.hg-sem.com
 *
 * @Author 李越
 *
 * @date 2015年6月26日 下午2:43:53
 *
 */
@Controller
public class ChattingSellerAction
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

	/**
	 * 
	 * <p>
	 * Title: chatting
	 * </p>
	 * <p>
	 * Description: 进入卖家聊天窗口
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/seller/chatting.htm" })
	public ModelAndView chatting (HttpServletRequest request , HttpServletResponse response , String uId)// uId代表买家发信息的uId
		{
			ModelAndView mv = new JModelAndView ("seller/chatting.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();// 得到卖家的Id
			if (user != null)
			{
				Map <String, Long> map = new HashMap <String, Long> ();
				map.put ("userId" , user.getId ());// 卖家Id,收信息。user1收信息,user2发信息
				List <Chatting> chattingList = this.chattingService.selectChatting (map);// 得到收到信息的Chatting
				List <Long> user2Ids = new ArrayList <Long> ();
				for (Chatting c : chattingList)
				{
					user2Ids.add (c.getUser2Id ());// 获得发信息人的userId
				}
				if (user2Ids.size () != 0)
				{
					UserExample userExample = new UserExample ();
					userExample.clear ();
					UserExample.Criteria userCriteria = userExample.createCriteria ();
					userCriteria.andIdIn (user2Ids);
					List <User> buyerUsers = this.userService.getObjectList (userExample);// 得到买家的用户信息
					mv.addObject ("buyerUsers" , buyerUsers);
				}
				SnsFriendExample snsFriendExample = new SnsFriendExample ();
				snsFriendExample.clear ();
				snsFriendExample.createCriteria ().andFromuserIdEqualTo (user.getId ());
				List <SnsFriend> friends = this.snsFriendService.getObjectList (snsFriendExample);
				mv.addObject ("Friends" , friends);
				mv.addObject ("userTools" , this.userTools);
				if (friends.size () > 0)
				{
					int count = 0;
					for (SnsFriend friend : friends)
					{
						boolean flag = this.userTools.userOnLine (friend.getToUser ().getUsername ());
						if (flag)
						{
							count++;
						}
						mv.addObject ("OnlineCount" , Integer.valueOf (count));
					}
				}
				ChattingFriendExample chattingFriendExample = new ChattingFriendExample ();
				chattingFriendExample.clear ();
				chattingFriendExample.createCriteria ().andUserIdEqualTo (user.getId ());
				chattingFriendExample.setOrderByClause ("addTime desc");
				List <ChattingFriend> contactings = this.chattingFriendService.getObjectList (chattingFriendExample);
				mv.addObject ("Contactings" , contactings);
				mv.addObject ("user" , SecurityUserHolder.getCurrentUser ());
				mv.addObject ("uId" , uId);// 设置uId到作用域
				/*
				 * ChattingExample chattingExample = new ChattingExample();
				 * chattingExample.clear();
				 * chattingExample.createCriteria().andUser1IdEqualTo(CommUtil.null2Long(user.getId()
				 * )).andUser2IdEqualTo(CommUtil.null2Long(uId));
				 * ChattingExample.Criteria criteria = chattingExample.createCriteria();
				 * criteria.andUser2IdEqualTo(CommUtil.null2Long(user.getId())).andUser1IdEqualTo(
				 * CommUtil.null2Long(uId));
				 * chattingExample.or(criteria);
				 * List<Chatting> chattings = this.chattingService.getObjectList(chattingExample);
				 * ChattingLogExample chattingLogExample = new ChattingLogExample();
				 * if(chattings!=null && chattings.size()>0){
				 * for(Chatting c : chattings) {
				 * chattingLogExample.clear();
				 * chattingLogExample.setOrderByClause("addTime asc");
				 * chattingLogExample.createCriteria().andChattingIdEqualTo(c.getId()).andMarkEqualTo
				 * (Integer.valueOf(0));
				 * List<ChattingLog> chattingLogs =
				 * this.chattinglogService.getObjectList(chattingLogExample);
				 * for(ChattingLog cLog:chattingLogs)
				 * {
				 * cLog.setMark(0);
				 * }
				 * c.setChattingLogs(chattingLogs);
				 * }
				 * }
				 * mv.addObject("chattings", chattings);
				 */
				List<Object> list = new ArrayList <Object> ();
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
	 * <p>
	 * Title: chattingHistory
	 * </p>
	 * <p>
	 * Description: 局部刷新
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping({ "/seller/chatting_history.htm" })
	public ModelAndView chattingHistory (HttpServletRequest request , HttpServletResponse response , String uId)
		{
			ModelAndView mv = new JModelAndView ("seller/chat_history.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			User user = SecurityUserHolder.getCurrentUser ();// 得到卖家的Id
			if (user != null)
			{
				if (null!=uId && !uId.equals (""))
				{
					ChattingExample chattingExample = new ChattingExample ();
					chattingExample.clear ();
					chattingExample.createCriteria ().andUser1IdEqualTo (CommUtil.null2Long (user.getId ())).andUser2IdEqualTo (CommUtil.null2Long (uId));
					ChattingExample.Criteria criteria = chattingExample.createCriteria ();
					criteria.andUser2IdEqualTo (CommUtil.null2Long (user.getId ())).andUser1IdEqualTo (CommUtil.null2Long (uId));
					chattingExample.or (criteria);
					List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
					ChattingLogExample chattingLogExample = new ChattingLogExample ();
					if (chattings != null && chattings.size () > 0)
					{
						for (Chatting c : chattings)
						{
							chattingLogExample.clear ();
							chattingLogExample.setOrderByClause ("addTime asc");
							chattingLogExample.createCriteria ().andChattingIdEqualTo (c.getId ());// 读的时候，mark为1为0都无所谓
							List <ChattingLog> chattingLogs = this.chattinglogService.getObjectList (chattingLogExample);
							for (ChattingLog cLog : chattingLogs)
							{
								if (!cLog.getUserId ().equals (user.getId ()))
								{// 表示自己发出去的消息mark对方未读所以不置为0。对方发过来的消息，已读Mark置为0
									cLog.setMark (0);
									this.chattinglogService.updateByObject (cLog);// 刷出来的状态都置为0，表示已读
								}
							}
							c.setChattingLogs (chattingLogs);
						}
					}
					mv.addObject ("chattings" , chattings);
				}
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
	@RequestMapping({ "/seller/chatting_refresh.htm" })
	public ModelAndView chatting_refresh (HttpServletRequest request , HttpServletResponse response , String user_id)
		{
			ModelAndView mv = new JModelAndView ("chatting_logs.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Chatting chatting = null;
			// User user = this.userService.getByKey(CommUtil.null2Long(user_id)); //当前用户聊天的对象
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				ChattingExample chattingExample = new ChattingExample ();
				chattingExample.clear ();
				chattingExample.createCriteria ().andUser1IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser2IdEqualTo (CommUtil.null2Long (user_id));
				ChattingExample.Criteria criteria2 = chattingExample.createCriteria ();
				criteria2.andUser1IdEqualTo (CommUtil.null2Long (user_id)).andUser2IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
				chattingExample.or (criteria2);
				List <Chatting> chattings = this.chattingService.getObjectList (chattingExample);
				if (chattings.size () > 0)
				{
					chatting = (Chatting) chattings.get (0);
					// 查找到聊天记录
					ChattingLogExample chattingLogExample = new ChattingLogExample ();
					chattingLogExample.clear ();
					chattingLogExample.createCriteria ().andChattingIdEqualTo (chatting.getId ()).andMarkEqualTo (Integer.valueOf (0)).andUserIdEqualTo (CommUtil.null2Long (user_id));
					chattingLogExample.setOrderByClause ("addTime asc");
					List <ChattingLog> logs = this.chattinglogService.getObjectList (chattingLogExample);
					mv.addObject ("logs" , logs);
					for (ChattingLog log : logs)
					{
						if (log.getUser ().getId ().equals (SecurityUserHolder.getCurrentUser ().getId ()))
							continue;
						log.setMark (1);
						this.chattinglogService.updateByObject (log);
					}
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
	@RequestMapping({ "/seller/chatting_ShowHistory.htm" })
	public ModelAndView chatting_ShowHistory (HttpServletRequest request , HttpServletResponse response , String user_id , String currentPage)
		{
			ModelAndView mv = new JModelAndView ("chatting_logs.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 1 , request , response);
			Chatting chatting = null;
			if (SecurityUserHolder.getCurrentUser () != null)
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
	@RequestMapping({ "/seller/chatting_save.htm" })
	@ResponseBody
	public String chatting_save (HttpServletRequest request , HttpServletResponse response , String content , String storeId , String uId)
		{
//			List <ChattingLog> logs = new ArrayList <ChattingLog> ();
			/**
			 * storeId暂时没用到
			 */
//			StoreWithBLOBs store = this.storeService.getByKey (CommUtil.null2Long (storeId));
//			User seller = null;
//			if (store != null)
//			{
//				seller = store.getUser ();
//			}
			User buyer = this.userService.getByKey (CommUtil.null2Long (uId));// 买家
			Chatting chatting = null;
			if (SecurityUserHolder.getCurrentUser () != null)
			{
				ChattingExample chattingExample = new ChattingExample ();
				chattingExample.clear ();
				chattingExample.createCriteria ().andUser1IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser2IdEqualTo (CommUtil.null2Long (uId));// user2Id发信息的人
				ChattingExample.Criteria criteria2 = chattingExample.createCriteria ();
				criteria2.andUser2IdEqualTo (SecurityUserHolder.getCurrentUser ().getId ()).andUser1IdEqualTo (CommUtil.null2Long (uId));// user1Id收信息的人
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
					chatting.setUser1Id (CommUtil.null2Long (uId));
					chatting.setUser1 (buyer);// 收信息的人
					chatting.setUser2Id (CommUtil.null2Long (SecurityUserHolder.getCurrentUser ().getId ()));
					chatting.setUser2 (SecurityUserHolder.getCurrentUser ());// 发信息的人
					this.chattingService.add (chatting);
				}
				if (chatting != null)
				{
					ChattingLog log = new ChattingLog ();
					log.setAddtime (new Date ());
					log.setUser (SecurityUserHolder.getCurrentUser ());
					log.setUserId (SecurityUserHolder.getCurrentUser ().getId ());
					log.setChattingId (chatting.getId ());
					log.setContent (content);
					log.setChatting (chatting);
					log.setMark (1);
					this.chattinglogService.add (log);
				}
//				ChattingLogExample chattingLogExample = new ChattingLogExample ();
//				chattingLogExample.clear ();
//				chattingLogExample.setOrderByClause ("addTime desc");
//				chattingLogExample.createCriteria ().andChattingIdEqualTo (chatting.getId ()).andUserIdEqualTo (SecurityUserHolder.getCurrentUser ().getId ());
//				logs = this.chattinglogService.getObjectList (chattingLogExample);
			}
			User user = SecurityUserHolder.getCurrentUser ();
			String img = "$!webPath/" + user.getPhoto ().getPath () + "/" + user.getPhoto ().getName () + "_small." + user.getPhoto ().getExt ();
			String resultJson = user.getId () + "," + img + "^" + content;
			return resultJson;
		}

	@RequestMapping({ "/seller/msgCount.htm" })
	@ResponseBody
	public String reclMsgCount (HttpServletRequest request , HttpServletResponse response , String msgCount)
		{
			int result = 350 - CommUtil.null2Int (msgCount);
			return result + "";
		}
}
