//连接
var conn = null;
// 当前登录用户Id
var currentUserId = null;

var textSending = false;
// 消息输入框
var talkInputId = "rl_exp_input";
// 对话显示内容框
var msgCardDivId = "wei_co_21";
// 当前对话用户
var curChatUserId = null;
// 对话聊天默认头像
var chatdefaultImg = "service/img/details_icon_tstong.png";

var picshim;

var showLoginUI = function() {
	$('#loginmodal').css({
		"display" : "block"
	});
	$('#username').focus();
};
var hiddenLoginUI = function() {
	$('#loginmodal').css({
		"display" : "none"
	});
};
var showWaitLoginedUI = function() {
	$('#waitLoginmodal').css({
		"display" : "block"
	});
};
var hiddenWaitLoginedUI = function() {
	$('#waitLoginmodal').css({
		"display" : "none"
	});
};
var showChatUI = function() {
	$('#main_inner').css({
		"display" : "block"
	});
};
var showNouser = function() {
	$('#wei_co_21').css({
		"display" : "block"
	});
};
var hideNouser = function() {
	$('#wei_co_21').css({
		"display" : "none"
	});
};
displayName = '';
var getLoginInfo = function() {
	return {
		isLogin : false
	};
};

// easemobwebim-sdk注册回调函数
$(document).ready(function() {
	hiddenWaitLoginedUI();
	conn = new Easemob.im.Connection({
		multiResources : Easemob.im.config.multiResources,
		https : Easemob.im.config.https,
		url : Easemob.im.config.xmppURL
	});
	// 初始化连接
	conn.listen({
		// 当连接成功的回调
		onOpened : function() {
			handleOpen(conn);
		},
		// 当连接关闭时的回调
		onClosed : function() {
			handleClosed();
		},
		// 收到文本消息时的回调函数
		onTextMessage : function(message) {
			handleTextMessage(message);
		},
		// 收到图片消息时的回调方法
		onPictureMessage : function(message) {
			handlePictureMessage(message);
		},
		// 收到联系人订阅请求的回调方法
		onPresence : function(message) {
			handlePresence(message);
		},
		// 收到联系人信息的回调方法
		onRoster : function(message) {
			handleRoster(message);
		},
		// 异常时的回调方法
		onError : function(message) {
			handleError(message);
		}
	});
	// 是否登录显示对应的页面
	var loginInfo = getLoginInfo();
	if (loginInfo.isLogin) {
		showWaitLoginedUI();
	} else {
		showLoginUI();
	}
});

// 登录函数
var login = function() {
	setTimeout(function() {
		var user = $("#username").val();
		var pwd = $("#password").val();
		if (user == '' || pwd == '') {
			alert("请输入用户名和密码");
			return;
		}
		hiddenLoginUI();
		showWaitLoginedUI();
		conn.open({
			apiUrl : Easemob.im.config.apiURL,
			user : user,
			pwd : pwd,
			// 连接时提供appkey
			appKey : Easemob.im.config.appkey
		});
		return false;
	}, 50);
};

// 收到联系人订阅请求的回调方法
var handlePresence = function(message) {

};
// 收到联系人信息的回调方法
var handleRoster = function(message) {

}
// 处理连接函数。主要处理登录成功后对页面元素做处理
var handleOpen = function(conn) {
	// 从连接中获取当前登录人的注册账号
	currentUserId = conn.context.userId;
	// $('#user_name').html(currentUserId);
	// 获取当前登录人的联系人列表
	conn.getRoster({
		success : function(roster) {
			// 页面处理
			hiddenWaitLoginedUI();
			showChatUI();

			curChatUserId = $('#currentChatId').val();
			var message = sendStoreGoods();
			$('#rl_exp_input').val(message);
			// 设置用户上线状态。必须调用
			conn.setPresence();
			$("#send_text").trigger('click');
			// 主动添加对方为好友。方便店家联系买家
			startAddFriend(curChatUserId);
		}
	});
	if (!Easemob.im.Helper.isCanUploadFileAsync
			&& typeof uploadShim === 'function') {
		picshim = uploadShim('sendPicInput', 'pic');
	}
	// 启动心跳
	if (conn.isOpend()) {
		conn.heartBeat(conn);
	}
};

// 发送咨询的商品 。通知卖家
var sendStoreGoods = function() {
	var message = "你好！我想咨询商品。" + $('#goods_name').html();
	return message;
}

// 主动添加好友操作的实现方法
var startAddFriend = function(curChatUserId) {
	if (curChatUserId == '') {
		return;
	}
	// 发送添加好友请求
	conn.subscribe({
		to : curChatUserId,
		message : "加个好友呗"
	});
	return;
};

// 异常情况下的处理方法
var handleError = function(e) {
	if (currentUserId == null) {
		hiddenWaitLoginedUI();
		alert(e.msg + ",请重新登录");
		showLoginUI();
	} else {
		var msg = e.msg;
		if (e.type == EASEMOB_IM_CONNCTION_SERVER_CLOSE_ERROR) {
			if (msg == "" || msg == 'unknown') {
				alert("服务器断开连接,可能是因为在别处登录");
			} else {
				alert("服务器断开连接");
			}
		} else if (e.type === EASEMOB_IM_CONNCTION_SERVER_ERROR) {
			if (msg.toLowerCase().indexOf("user removed") != -1) {
				alert("用户已经在管理后台删除");
			}
		} else {
			alert(msg);
		}
	}
	conn.stopHeartBeat(conn);
};

// easemobwebim-sdk收到图片消息的回调方法的实现
var handlePictureMessage = function(message) {
	var filename = message.filename;// 文件名称，带文件扩展名
	var from = message.from;// 文件的发送者
	//非当前聊天人发来的消息。过滤掉。
	if (from != curChatUserId) {
		return;
	}
	var mestype = message.type;// 消息发送的类型是群组消息还是个人消息
	var contactDivId = from;

	var options = message;
	var img = document.createElement("img");
	img.src = message.url;
	appendMsg(from, contactDivId, {
		data : [ {
			type : 'pic',
			filename : filename || '',
			data : img
		} ]
	});
};

// 连接中断时的处理，主要是对页面进行处理
var handleClosed = function() {
	currentUserId = null;
	curChatUserId = null;
	hiddenChatUI();
	showLoginUI();
	textSending = false;
};
// 发送消息
var sendText = function() {
	if (textSending) {
		return;
	}
	textSending = true;
	var msgInput = document.getElementById(talkInputId);
	var msg = msgInput.value;
	if (msg == null || msg.length == 0
			|| msg.replace(/(^\s*)|(\s*$)/g, "") == "") {
		textSending = false;
		return;
	}
	var to = curChatUserId;
	if (to == null) {
		textSending = false;
		return;
	}
	var options = {
		to : to,
		msg : msg,
		type : "chat"
	};
	// easemobwebim-sdk发送文本消息的方法 to为发送给谁，meg为文本消息对象
	conn.sendTextMessage(options);
	// 当前登录人发送的信息在聊天窗口中原样显示
	var msgtext = Easemob.im.Utils.parseLink(Easemob.im.Utils
			.parseEmotions(encode(msg)));
	appendMsg(currentUserId, to, msgtext);
	msgInput.value = "";
	msgInput.focus();
	setTimeout(function() {
		textSending = false;
	}, 1000);
};

// easemobwebim-sdk收到文本消息的回调方法的实现
var handleTextMessage = function(message) {
	var from = message.from;// 消息的发送者
	//非当前聊天人发来的消息。过滤掉。
	if (from != curChatUserId) {
		return;
	}
	var mestype = message.type;// 消息发送的类型是群组消息还是个人消息
	var messageContent = message.data;// 文本消息体
	appendMsg(from, from, messageContent);
};

// 显示聊天记录的统一处理方法
var appendMsg = function(who, contact, message) {
	// 消息体 {isemotion:true;body:[{type:txt,msg:ssss}{type:emotion,msg:imgdata}]}
	var localMsg = null;
	if (typeof message == 'string') {
		localMsg = Easemob.im.Helper.parseTextMessage(message);
		localMsg = localMsg.body;
	} else {
		localMsg = message.data;
	}
	var path = $('#webpath').val();
	var webpath = path.replace("store", "");

	var lineDiv = document.createElement("div");
	var imgHead = $(("<div class=\admimg\><img src=\"" + webpath + "/"
			+ chatdefaultImg + "\" width=\"60\" height=\"60\"></div>"));

	var msg = null;
	var imgData;
	var messageContent = localMsg;
	for (var i = 0; i < messageContent.length; i++) {
		var msgContent = messageContent[i];
		var type = msgContent.type;
		var data = msgContent.data;
		if (type == "pic") {
			var filename = msgContent.filename;
			// msg = $(("<div class=\"info\">" + filename + "</div>"));
			imgData = data;
		} else {
			// 文本内容添加
			msg = $(("<div class=\"info\">" + data + "</div>"));
			if (currentUserId == who) {
				// 我的文本样式设置
				msg[0].style.backgroundColor = "#EBEBEB";
			}
		}
	}
	var msgContentDiv = document.getElementById(msgCardDivId);
	if (currentUserId == who) {
		lineDiv.setAttribute("class", "aaaaaa");
		lineDiv.appendChild(imgHead[0]);
		if (imgData) {
			var imgMsg = document.createElement("div");
			imgMsg.setAttribute("class", "info");
			imgMsg.appendChild(imgData);
			lineDiv.appendChild(imgMsg);
		} else {
			lineDiv.appendChild(msg[0]);
		}
	} else {
		lineDiv.setAttribute("id", "adm");
		lineDiv.appendChild(imgHead[0]);
		if (imgData) {
			var imgMsg = document.createElement("div");
			imgMsg.setAttribute("class", "info");
			imgMsg.appendChild(imgData);
			lineDiv.appendChild(imgMsg);
		} else {
			lineDiv.appendChild(msg[0]);
		}
	}

	msgContentDiv.appendChild(lineDiv);

	msgContentDiv.scrollTop = msgContentDiv.scrollHeight;
	return lineDiv;
};

function sendPic() {
	// 图片接收者，如“test1”
	var to = curChatUserId;
	if (to == null) {
		alert("请选择联系人");
		return;
	}
	// fileInputId：文件选择输入框的ID，SDK自动根据ID自动获取文件对象（含图片，或者其他类型文件）
	var fileObj = Easemob.im.Helper.getFileUrl("fileInput");
	if (fileObj.url == null || fileObj.url == '') {
		alert("请选择发送图片");
		return;
	}
	var filetype = fileObj.filetype;
	var filename = fileObj.filename;
	if (filetype in pictype) {
		var opt = {
			fileInputId : "fileInput",
			to : to,
			onFileUploadError : function(error) {
				var messageContent = (error.msg || '') + ",发送图片文件失败:"
						+ (filename);
				appendMsg(currentUserId, to, messageContent);
			},
			onFileUploadComplete : function(data) {
				filename = data.filename || '';
				var img = document.createElement("img");
				img.src = data.uri + '/' + data.entities[0].uuid;
				appendMsg(currentUserId, to, {
					data : [ {
						type : 'pic',
						filename : filename,
						data : img
					} ]
				});
			}
		};
		conn.sendPicture(opt);
		return;
	}
	alert("不支持此图片类型" + filetype);
};

var pictype = {
	"jpg" : true,
	"gif" : true,
	"png" : true,
	"bmp" : true
};

// 处理不支持异步上传的浏览器,使用swfupload作为解决方案
var uploadShim = function(fileInputId, type) {
	var pageTitle = document.title;
	if (typeof SWFUpload === 'undefined') {
		return;
	}

	return new SWFUpload({
		file_post_name : 'file',
		flash_url : "im/js/swfupload/swfupload.swf",
		button_placeholder_id : fileInputId,
		button_width : 24,
		button_height : 24,
		button_cursor : SWFUpload.CURSOR.HAND,
		button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
		file_size_limit : 10485760,
		file_upload_limit : 0,
		file_queued_handler : function(file) {
			if (this.getStats().files_queued > 1) {
				this.cancelUpload();
			}
			var checkType = window[type + 'type'];
			if (!checkType[file.type.slice(1)]) {
				conn.onError({
					type : EASEMOB_IM_UPLOADFILE_ERROR,
					msg : '不支持此文件类型' + file.type
				});
				this.cancelUpload();
			} else if (10485760 < file.size) {
				conn.onError({
					type : EASEMOB_IM_UPLOADFILE_ERROR,
					msg : '文件大小超过限制！请上传大小不超过10M的文件'
				});
				this.cancelUpload();
			} else {
				flashFilename = file.name;
				switch (type) {
				case 'pic':
					sendPic();
					break;
				}
			}
		},
		file_dialog_start_handler : function() {
			if (Easemob.im.Helper.getIEVersion
					&& Easemob.im.Helper.getIEVersion < 10) {
				document.title = pageTitle;
			}
		},
		upload_error_handler : function(file, code, msg) {
			if (code != SWFUpload.UPLOAD_ERROR.FILE_CANCELLED
					&& code != SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED
					&& code != SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED) {
				this.uploadOptions.onFileUploadError
						&& this.uploadOptions.onFileUploadError({
							type : EASEMOB_IM_UPLOADFILE_ERROR,
							msg : msg
						});
			}
		},
		upload_complete_handler : function() {
			// this.setButtonText('点击上传');
		},
		upload_success_handler : function(file, response) {
			// 处理上传成功的回调
			try {
				var res = Easemob.im.Helper.parseUploadResponse(response);
				res = $.parseJSON(res);
				res.filename = file.name;
				this.uploadOptions.onFileUploadComplete
						&& this.uploadOptions.onFileUploadComplete(res);
			} catch (e) {
				conn.onError({
					type : EASEMOB_IM_UPLOADFILE_ERROR,
					msg : '上传图片发生错误'
				});
			}
		}
	});
}
var flashPicUpload = function(url, options) {
	flashUpload(picshim, url, options);
};

// 提供上传接口
var flashUpload = function(swfObj, url, options) {
	swfObj.setUploadURL(url);
	swfObj.uploadOptions = options;
	swfObj.startUpload();
};

var getObjectURL = function getObjectURL(file) {
	var url = null;
	if (window.createObjectURL != undefined) { // basic
		url = window.createObjectURL(file);
	} else if (window.URL != undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
};

var encode = function(str) {
	if (!str || str.length === 0)
		return "";
	var s = '';
	s = str.replace(/&amp;/g, "&");
	s = s.replace(/<(?=[^o][^)])/g, "&lt;");
	s = s.replace(/>/g, "&gt;");
	// s = s.replace(/\'/g, "&#39;");
	s = s.replace(/\"/g, "&quot;");
	s = s.replace(/\n/g, "<br>");
	return s;
};

// 表情配置
Easemob.im.EMOTIONS = {
	path : 'static/img/faces/',
	map : {
		'[):]' : 'ee_1.png',
		'[:D]' : 'ee_2.png',
		'[;)]' : 'ee_3.png',
		'[:-o]' : 'ee_4.png',
		'[:p]' : 'ee_5.png',
		'[(H)]' : 'ee_6.png',
		'[:@]' : 'ee_7.png',
		'[:s]' : 'ee_8.png',
		'[:$]' : 'ee_9.png',
		'[:(]' : 'ee_10.png',
		'[:\'(]' : 'ee_11.png',
		'[:|]' : 'ee_12.png',
		'[(a)]' : 'ee_13.png',
		'[8o|]' : 'ee_14.png',
		'[8-|]' : 'ee_15.png',
		'[+o(]' : 'ee_16.png',
		'[<o)]' : 'ee_17.png',
		'[|-)]' : 'ee_18.png',
		'[*-)]' : 'ee_19.png',
		'[:-#]' : 'ee_20.png',
		'[:-*]' : 'ee_21.png',
		'[^o)]' : 'ee_22.png',
		'[8-)]' : 'ee_23.png',
		'[(|)]' : 'ee_24.png',
		'[(u)]' : 'ee_25.png',
		'[(S)]' : 'ee_26.png',
		'[(*)]' : 'ee_27.png',
		'[(#)]' : 'ee_28.png',
		'[(R)]' : 'ee_29.png',
		'[({)]' : 'ee_30.png',
		'[(})]' : 'ee_31.png',
		'[(k)]' : 'ee_32.png',
		'[(F)]' : 'ee_33.png',
		'[(W)]' : 'ee_34.png',
		'[(D)]' : 'ee_35.png'
	}
};
