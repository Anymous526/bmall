package com.amall.core.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.amall.common.constant.Globals;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.push.jpush.JPush;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.virtual.JModelAndView;

@Controller
public class MessagePushAction
{

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IUserService userService;

	@RequestMapping({ "/admin/push_message_to_all.htm" })
	public void push_message_to_all (HttpServletRequest request , HttpServletResponse response , String content , String platform)
		{
			List <User> users = userService.getObjectList (new UserExample ());
			int limit = Globals.PUSH_MESSAGE_MAX_NUMBER - content.length ();
			Map <String, Object> msgMap = new HashMap <String, Object> ();
			List <Long> ids = new ArrayList <Long> ();
			int i = 0;
			int count;
			while (i < users.size ())
			{
				count = 0;
				for (int j = i ; j < users.size () + 1 ; j++)
				{
					i = j;
					if (j < users.size ())
						count += users.get (j).getId ().toString ().length ();
					if (count >= limit)
					{
						break;
					}
					if (j < users.size ())
						ids.add (users.get (j).getId ());
				}
				msgMap.clear ();
				msgMap.put ("user" , ids);
				msgMap.put ("content" , content);
				if ("1".equals (platform))
					JPush.sendNotifyAllForAndroid (org.nutz.json.Json.toJson (msgMap) , "angelMsgToAll");
				else if ("2".equals (platform))
					JPush.sendNotifyAllForIOS (org.nutz.json.Json.toJson (msgMap) , "angelMsgToAll");
				else if ("3".equals (platform))
					JPush.sendMessageWithPassThroughAll (org.nutz.json.Json.toJson (msgMap) , "angelMsgToAll");
			}
		}

	@RequestMapping({ "/admin/push_message_to_one.htm" })
	public void push_message_to_one (HttpServletRequest request , HttpServletResponse response , String phone , String content , String platform)
		{
			UserExample example = new UserExample ();
			example.createCriteria ().andUsernameEqualTo (phone);
			Long userId = userService.getObjectList (example).get (0).getId ();
			Map <String, Object> msgMap = new HashMap <String, Object> ();
			msgMap.put ("user" , userId);
			msgMap.put ("content" , content);
			if ("1".equals (platform))
				JPush.sendNotifyAllForAndroid (org.nutz.json.Json.toJson (msgMap) , "angelMsgToOne");
			else if ("2".equals (platform))
				JPush.sendNotifyAllForIOS (org.nutz.json.Json.toJson (msgMap) , "angelMsgToOne");
			else if ("3".equals (platform))
				JPush.sendMessageWithPassThroughAll (org.nutz.json.Json.toJson (msgMap) , "angelMsgToOne");
		}

	@RequestMapping({ "/admin/msg_push.htm" })
	public ModelAndView msg_push (HttpServletRequest request , HttpServletResponse response)
		{
			ModelAndView mv = new JModelAndView ("admin/message_push.html" , this.configService.getSysConfig () , this.userConfigService.getUserConfig () , 0 , request , response);
			return mv;
		}
}
