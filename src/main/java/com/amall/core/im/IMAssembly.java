package com.amall.core.im;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amall.core.im.api.IMUserAPI;
import com.amall.core.im.api.SendMessageAPI;
import com.amall.core.im.comm.ClientContext;
import com.amall.core.im.comm.EasemobRestAPIFactory;
import com.amall.core.im.comm.body.IMUserBody;
import com.amall.core.im.comm.body.IMUsersBody;
import com.amall.core.im.comm.body.TextMessageBody;
import com.amall.core.im.comm.constant.MsgTargetType;
import com.amall.core.im.comm.wrapper.BodyWrapper;
import com.amall.core.im.comm.wrapper.ResponseWrapper;

/**
 * IM操作工具类
 * 
 * @author dinglei
 *
 */
public class IMAssembly {

	private final static Logger log = LoggerFactory.getLogger(IMAssembly.class);

	static EasemobRestAPIFactory factory = ClientContext.getInstance()
			.init(ClientContext.INIT_FROM_PROPERTIES).getAPIFactory();

	static IMUserAPI userAPI = (IMUserAPI) factory
			.newInstance(EasemobRestAPIFactory.USER_CLASS);

	static SendMessageAPI messageAPI = (SendMessageAPI) factory
			.newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);

	// 批量增加用戶最大次數
	private final static Integer NEW_USER_MAX_SIZE = 60;

	private static IMAssembly imAssembly;

	public static IMAssembly newInstance() {
		if (imAssembly == null) {
			imAssembly = new IMAssembly();
		}
		return imAssembly;
	}

	public static String getToken() {
		return factory.getContext().getAuthToken();
	}

	/**
	 * 創建多個用戶(暂时不用)
	 * 
	 * @param username
	 * @param password
	 * @param nickname
	 * @return
	 */
	public Integer newImUser(List<IMUserBody> userList) {
		if (null == userList || userList.size() == 0) {
			return null;
		}
		Integer size = userList.size();
		if (size <= NEW_USER_MAX_SIZE) {
			userAPI.createNewIMUserBatch(userList);
			return size;
		}
		// Integer forSize = (int) Math.ceil(((double) size / (double)
		// NEW_USER_MAX_SIZE));
		int index = 0;
		List<IMUserBody> loadList = new ArrayList<IMUserBody>();
		;
		for (int i = 0; i < size; i++) {
			if (index == NEW_USER_MAX_SIZE) {
				BodyWrapper body = new IMUsersBody(loadList);
				userAPI.createNewIMUserBatch(body);
				loadList.clear();
				index = 0;
			}
			loadList.add(userList.get(i));
			++index;
		}
		if (loadList.size() > 0) {
			BodyWrapper body = new IMUsersBody(loadList);
			userAPI.createNewIMUserBatch(body);
		}
		return size;
	}

	/**
	 * 获取单个用户 (环信服务器)
	 * 
	 * @param username
	 * @return
	 */
	public ResponseWrapper getUser(String username) {
		return (ResponseWrapper) userAPI.getIMUsersByUserName(username);
	}

	/**
	 * 修改昵称
	 * 
	 * @param username
	 * @param nickname
	 */
	public ResponseWrapper updateNickname(String username, String nickname) {
		// 修改密码缺少加密
		IMUserBody bodyUser = (IMUserBody) userAPI
				.getIMUsersByUserName(username);
		if (null == bodyUser) {
			return null;
		}
		bodyUser.setNickName(nickname);

		return (ResponseWrapper) userAPI.modifyIMUserNickNameWithAdminToken(
				bodyUser.getUserName(), bodyUser);
	}

	/**
	 * 添加好友
	 * 
	 * @param username
	 * @param friendName
	 */
	public ResponseWrapper addFriend(String username, String friendName) {
		return (ResponseWrapper) userAPI.addFriendSingle(username, friendName);
	}

	/**
	 * 删除好友
	 * 
	 * @param username
	 * @param friendName
	 */
	public ResponseWrapper removeFriend(String username, String friendName) {
		return (ResponseWrapper) userAPI.deleteFriendSingle(username,
				friendName);
	}

	/**
	 * 查看好友
	 * 
	 * @param username
	 * @return
	 */
	public ResponseWrapper getFriends(String username) {
		return (ResponseWrapper) userAPI.getFriends(username);
	}

	/**
	 * 获取黑名单
	 * 
	 * @param username
	 * @return
	 */
	public ResponseWrapper getBlackList(String username) {
		return (ResponseWrapper) userAPI.getBlackList(username);
	}

	/**
	 * 添加黑名单
	 * 
	 * @param username
	 * @param blackName
	 * @return
	 */
	public ResponseWrapper addToBlack(String username, String blackName) {
		Object imUser = userAPI.getIMUsersByUserName(blackName);
		if (null == imUser) {
			return null;
		}
		return (ResponseWrapper) userAPI.addToBlackList(username, imUser);
	}

	/**
	 * 从黑名单移除
	 * 
	 * @param username
	 * @return
	 */
	public Object removeFromBlackList(String username, String blackname) {
		return userAPI.removeFromBlackList(username, blackname);
	}

	/**
	 * 查看用户在线状态 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object getIMUserStatus(String userName) {
		return userAPI.getIMUserAllChatGroups(userName);
	}

	/**
	 * 查询离线消息数 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object getOfflineMsgCount(String userName) {
		return userAPI.getOfflineMsgCount(userName);
	}

	/**
	 * 查询某条离线消息状态 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @param msgId
	 *            消息ID
	 * @return
	 */
	public Object getSpecifiedOfflineMsgStatus(String userName, String msgId) {
		return userAPI.getSpecifiedOfflineMsgStatus(userName, msgId);
	}

	/**
	 * 用户账号禁用 <br>
	 * POST
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object deactivateIMUser(String userName) {
		return userAPI.deactivateIMUser(userName);
	}

	/**
	 * 用户账号解禁 <br>
	 * POST
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object activateIMUser(String userName) {
		return userAPI.activateIMUser(userName);
	}

	/**
	 * 强制用户下线 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object disconnectIMUser(String userName) {
		return userAPI.disconnectIMUser(userName);
	}

	/**
	 * 获取用户参与的群组 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 */
	public Object getIMUserAllChatGroups(String userName) {
		return userAPI.getIMUserAllChatGroups(userName);
	}

	/**
	 * 获取用户所有参与的聊天室 <br>
	 * GET
	 * 
	 * @param userName
	 *            用戶名或用戶ID
	 * @return
	 * @see http://docs.easemob.com/doku.php?id=start:100serverintegration:
	 *      70chatroommgmt
	 */
	public Object getIMUserAllChatRooms(String userName) {
		return userAPI.getIMUserAllChatRooms(userName);
	}

	public Object deleteIMUserBatch(Long limit) {

		return userAPI.deleteIMUserBatch(limit);
	}

	/**
	 * 发送消息 <br>
	 * POST
	 * 
	 * @param payload
	 *            消息体
	 * @return
	 * @see MessageBody
	 * @see TextMessageBody
	 * @see ImgMessageBody
	 * @see AudioMessageBody
	 * @see VideoMessageBody
	 * @see CommandMessageBody
	 */
	public Object sendMessage(Object body) {
		return messageAPI.sendMessage(body);
	}

	/**
	 * 给用户发送文本消息
	 * 
	 * @param target
	 *            目标用户组
	 * @param message
	 *            消息内容
	 * @param from
	 *            发送者
	 * @return
	 */
	public Object sendTextMessage(String[] target, String message, String from) {
		TextMessageBody messageBody = new TextMessageBody(MsgTargetType.USERS,
				target, from, new HashMap<String, String>(), message);
		return messageAPI.sendMessage(messageBody);
	}
}
