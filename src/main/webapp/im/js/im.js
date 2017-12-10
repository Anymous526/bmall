//连接
var conn = null;
// 当前登录用户Id
var currentUserId = null;
// 当前登录人的双向好友
var bothRoster = [];
// 当前登录人的单向好友
var toRoster = [];
var textSending = false;
// 消息内容框
var talkInputId = "rl_exp_input";
// 消息对话主体框
var msgCardDivId = "chat_main";
// 当前对话用户
var curChatUserId = null;
// 联系人列表UL
var contactList = "contact_list";
// 联系人默认头像
var contactsImg = "assets/img/webwxgeticon.jpg";
// 对话聊天默认头像
var chatdefaultImg = "service/img/50.png";

var maxWidth = 300;

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
	$('#chat_txt').css({
		"display" : "block"
	});
};
var hideNouser = function() {
	$('#chat_txt').css({
		"display" : "none"
	});
};
displayName = '';

var getLoginInfo = function() {
	return {
		isLogin : false
	};
};

window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL;

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

// 处理连接函数。主要处理登录成功后对页面元素做处理
var handleOpen = function(conn) {
	// 从连接中获取当前登录人的注册账号
	currentUserId = conn.context.userId;
	$('#user_name').html(currentUserId);
	// 获取当前登录人的联系人列表
	conn.getRoster({
		success : function(roster) {
			// 页面处理
			hiddenWaitLoginedUI();
			showChatUI();
			var curroster;
			for ( var i in roster) {
				var ros = roster[i];
				// both为双方互为好友，要显示的联系人,from我是对方的单向好友
				if (ros.subscription == 'both' || ros.subscription == 'from') {
					bothRoster.push(ros);
				} else if (ros.subscription == 'to') {
					// to表明了联系人是我的单向好友
					toRoster.push(ros);
				}
			}
			if (bothRoster.length > 0 || toRoster.length > 0) {
				// 构建联系人div
				buildContactDiv(bothRoster, toRoster);
			}
			// 设置用户上线状态。必须调用
			conn.setPresence();
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
	console.log("连接成功");
};

// 构建联系人列表div
var buildContactDiv = function(boRoster, toRoster) {
	// var content = document.getElementById("content-1");
	var cache = {};
	// 单向好友和双向好友都添加在一起。后续不需要可以删除
	for (var j = 0; j < toRoster.length; j++) {
		boRoster.push(toRoster[i]);
	}
	for (var i = 0; i < boRoster.length; i++) {
		var jid = boRoster[i].jid;
		var userName = jid.substring(jid.indexOf("_") + 1).split("@")[0];
		if (userName in cache) {
			continue;
		}
		cache[userName] = true;

		var lielem = $('<li>').attr({
			'id' : userName,
			'type' : 'chat',
			'displayName' : userName
		}).click(function() {
			chooseContactDivClick(this);
		});
		var userDiv = $('<div>').attr({
			'class' : "user"
		});
		$('<img>').attr({
			'src' : contactsImg
		}).appendTo(userDiv);

		var userinfo = $('<div>').attr({
			'class' : "user-info"
		});
		$('<span>').attr({
			'class' : "store-name"
		}).html(userName).appendTo(userinfo);
		
		$('<img>').attr({
			'src' : 'service/img/delete.png',
			'width' : '20px',
			'height' : '20px',
			'float' : 'right'
		}).click(function(){
			directDelFriend(userName);
		}).appendTo(userinfo);
		
		lielem.append(userDiv).append(userinfo);

		$('#contact_list').append(lielem);
	}
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
// 点击聊天时 。切换聊天窗口div
var chooseContactDivClick = function(li) {
	var chatUserId = li.id;

	if (chatUserId != curChatUserId) {
		if (curChatUserId == null) {
			showContactChatDiv(chatUserId);
		} else {
			showContactChatDiv(chatUserId);
			hiddenContactChatDiv(curChatUserId);
		}
		curChatUserId = chatUserId;
	}
	hideNouser();
	// 有未读消息处理
	var badgespan = $(li).children(".badge");
	if (badgespan && badgespan.length > 0) {
		li.removeChild(li.children[2]);
	}
	// 点击有未读消息对象时对未读消息提醒的处理
	var badgespanGroup = $(li).parent().parent().parent().find(".badge");
	if (badgespanGroup && badgespanGroup.length == 0) {
		$(li).parent().parent().parent().prev().children().children().remove();
	}
};

// 构造当前聊天记录的窗口div
var getContactChatDiv = function(chatUserId) {
	return document.getElementById(currentUserId + "-" + chatUserId);
};
// 如果当前没有某一个联系人的聊天窗口div就新建一个
var createContactChatDiv = function(chatUserId) {
	var msgContentDivId = currentUserId + "-" + chatUserId;
	var newContent = document.createElement("div");
	$(newContent).attr({
		"id" : msgContentDivId,
		"class" : "chat_content",
		"className" : "chat_content",
		"style" : "display:none"
	});
	return newContent;
};

// 显示当前选中联系人的聊天窗口div，并将该联系人在联系人列表中背景色置为蓝色
var showContactChatDiv = function(chatUserId) {
	var contentDiv = getContactChatDiv(chatUserId);
	if (contentDiv == null) {
		contentDiv = createContactChatDiv(chatUserId);
		document.getElementById(msgCardDivId).appendChild(contentDiv);
	}
	contentDiv.style.display = "block";
	var contactLi = document.getElementById(chatUserId);
	if (contactLi == null) {
		return;
	}
	// 设置li选中的点颜色
	contactLi.style.backgroundColor = "#23252b";
	document.getElementById("rl_exp_input").focus();
	var dispalyTitle = null;// 聊天窗口显示当前对话人名称
	dispalyTitle = "与" + chatUserId + "聊天中";
	document.getElementById("title_name").innerHTML = dispalyTitle;
};

// 对上一个联系人的聊天窗口div做隐藏处理，并将联系人列表中选择的联系人背景色置空
var hiddenContactChatDiv = function(chatUserId) {
	var contactLi = document.getElementById(chatUserId);
	if (contactLi) {
		contactLi.style.backgroundColor = "";
	}
	var contentDiv = getContactChatDiv(chatUserId);
	if (contentDiv) {
		contentDiv.style.display = "none";
	}
};

// 发送图片
var sendPic = function() {
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

// 连接中断时的处理，主要是对页面进行处理
var handleClosed = function() {
	currentUserId = null;
	bothRoster = [];
	toRoster = [];
	hiddenChatUI();
	clearContactUI("contact_list", "", "", msgCardDivId);
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
	if (msg == null || msg.length == 0) {
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
	turnoffFaces_box();
	msgInput.value = "";
	msgInput.focus();
	setTimeout(function() {
		textSending = false;
	}, 1000);
};
// 表情选择div的关闭方法
var turnoffFaces_box = function() {
	$("#rl_bq").fadeOut("slow");
};
// 退出清除
var clearContactUI = function(contactlistUL, contactgrouplistUL,
		momogrouplistUL, contactChatDiv) {
	// 清除左侧联系人内容
	$('#contact_list').empty();
	// 清除右侧对话框内容
	document.getElementById(talkToDivId).children[0].innerHTML = "";
	var chatRootDiv = document.getElementById(contactChatDiv);
	var children = chatRootDiv.children;
	for (var i = children.length - 1; i > 1; i--) {
		chatRootDiv.removeChild(children[i]);
	}
	hideNouser();
};

// easemobwebim-sdk收到文本消息的回调方法的实现
var handleTextMessage = function(message) {
	console.log("文本消息来了");
	var from = message.from;// 消息的发送者
	var mestype = message.type;// 消息发送的类型是群组消息还是个人消息
	var messageContent = message.data;// 文本消息体
	appendMsg(from, from, messageContent);
};

// 显示聊天记录的统一处理方法
var appendMsg = function(who, contact, message) {
	var contactUL = document.getElementById(contactList);
	var contactDivId = contact;
	var contactLi = getContactLi(contactDivId);
	if (contactLi == null) {
		// 构建陌生人聊天
		createMomogrouplistUL(who, message);
	}
	// 消息体 {isemotion:true;body:[{type:txt,msg:ssss}{type:emotion,msg:imgdata}]}
	var localMsg = null;
	if (typeof message == 'string') {
		localMsg = Easemob.im.Helper.parseTextMessage(message);
		localMsg = localMsg.body;
	} else {
		localMsg = message.data;
	}

	var lineDiv = document.createElement("div");
	// 图片div
	var imgHead = $(("<div class=\admimg\><img src=\"" + chatdefaultImg + "\"/></div>"));

	var msg;
	var imgData;
	var messageContent = localMsg;
	for (var i = 0; i < messageContent.length; i++) {
		var msg = messageContent[i];
		var type = msg.type;
		var data = msg.data;
		// 表情消息
		if (type == "emotion") {

			msg = $("<div class=\"info\"><img src='" + data + "'/></div>");

		} else if (type == "pic") {
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
	if (curChatUserId == null) {
		setCurrentContact(contact);
	}
	// 判断是否是当前对话用户
	if (curChatUserId && curChatUserId.indexOf(contact) < 0) {
		var contactLi = getContactLi(contactDivId);
		if (contactLi == null) {
			return;
		}
		// 设置li 消息提示数目
		contactLi.style.backgroundColor = "green";
		var badgespan = $(contactLi).children(".badge");
		if (badgespan && badgespan.length > 0) {
			var count = badgespan.text();
			var myNum = new Number(count);
			myNum++;
			badgespan.text(myNum);
		} else {
			$(contactLi).append('<span class="badge" style="float:right">1</span>');
		}
	}
	var msgContentDiv = getContactChatDiv(contactDivId);
	if (currentUserId == who) {
		lineDiv.setAttribute("id", "gue");
		if (imgData) {
			var imgMsg = document.createElement("div");
			imgMsg.setAttribute("class", "info");
			imgMsg.appendChild(imgData);
			lineDiv.appendChild(imgMsg);
		} else {
			lineDiv.appendChild(msg[0]);
		}
		lineDiv.appendChild(imgHead[0]);
		lineDiv.style.textAlign = "left";
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
		lineDiv.style.textAlign = "left";
	}
	var create = false;
	if (msgContentDiv == null) {
		msgContentDiv = createContactChatDiv(contactDivId);
		create = true;
	}
	msgContentDiv.appendChild(lineDiv);
	if (create) {
		document.getElementById(msgCardDivId).appendChild(msgContentDiv);
	}
	msgContentDiv.scrollTop = msgContentDiv.scrollHeight;
	return lineDiv;
};

// 收到陌生人消息时创建陌生人列表
var createMomogrouplistUL = function(who, message) {
	var lielem = $('<li>').attr({
		'id' : who,
		'type' : 'chat',
		'displayName' : who
	}).click(function() {
		chooseContactDivClick(this);
	});
	var userDiv = $('<div>').attr({
		'class' : "user"
	});
	$('<img>').attr({
		'src' : contactsImg
	}).appendTo(userDiv);

	var userinfo = $('<div>').attr({
		'class' : "user-info"
	});
	$('<span>').attr({
		'class' : "store-name"
	}).html(who).appendTo(userinfo);
	
	$('<img>').attr({
		'src' : 'service/img/delete.png',
		'width' : '20px',
		'height' : '20px',
		'float' : 'right'
	}).click(function(){
		directDelFriend(who);
	}).appendTo(userinfo);
	
	lielem.append(userDiv).append(userinfo);

	$('#contact_list').append(lielem);
};

// easemobwebim-sdk收到图片消息的回调方法的实现
var handlePictureMessage = function(message) {
	var filename = message.filename;// 文件名称，带文件扩展名
	var from = message.from;// 文件的发送者
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

// 获取当前时间
var getLoacalTimeString = function getLoacalTimeString() {
	var date = new Date();
	var time = date.getHours() + ":" + date.getMinutes() + ":"
			+ date.getSeconds();
	return time;
}

// 设置当前显示的聊天窗口div，
var setCurrentContact = function(defaultUserId) {
	showContactChatDiv(defaultUserId);
	if (curChatUserId != null) {
		hiddenContactChatDiv(curChatUserId);
	} else {
		hideNouser();
	}
	curChatUserId = defaultUserId;
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

// 选择联系人的处理
var getContactLi = function(chatUserId) {
	return document.getElementById(chatUserId);
};

// easemobwebim-sdk中收到联系人订阅请求的处理方法，具体的type值所对应的值请参考xmpp协议规范
var handlePresence = function(e) {
	// （发送者希望订阅接收者的出席信息），即别人申请加你为好友
	if (e.type == 'subscribe') {
		// 同意好友请求
		agreeAddFriend(e.from);// e.from用户名
	}
};

// easemobwebim-sdk中处理出席状态操作
var handleRoster = function(rosterMsg) {
};

// 回调方法执行时同意添加好友操作的实现方法
var agreeAddFriend = function(user) {
	conn.subscribed({
		to : user,
		message : "[resp:true]"
	});
};

// 直接调用删除操作时的调用方法
var directDelFriend = function(user) {
	if(confirm("确定要删除此联系人吗?")){
		if (validateFriend(user, bothRoster)) {
			conn.removeRoster({
				to : user,
				success : function() {
					conn.unsubscribe({
						to : user
					});
					cleanRemoveLi(user);
				},
				error : function() {
					alert("删除联系人失败");
				}
			});
		} else {
			cleanRemoveLi(user);
		}
	}
};

//删除联系人 。清理UL和联系
var cleanRemoveLi = function(userId){
	$('#'+currentUserId + '-' + userId+'').remove();
	$('#'+userId+'').remove();
	
	if(userId == curChatUserId){
		curChatUserId = null;
		showNouser();
		document.getElementById("title_name").innerHTML = "";
	}
}

//判断要删除的好友是否在当前好友列表中
var validateFriend = function(optionuser, bothRoster) {
	for ( var deluser in bothRoster) {
		if (optionuser == bothRoster[deluser].name) {
			return true;
		}
	}
	return false;
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

// 回调方法执行时删除好友操作的方法处理
var delFriend = function(user) {
	conn.removeRoster({
		to : user,
		groups : [ 'default' ],
		success : function() {
			conn.unsubscribed({
				to : user
			});
		}
	});
};
// 清除聊天记录
var clearCurrentChat = function() {
	var currentDiv = getContactChatDiv(curChatUserId)
			|| createContactChatDiv(curChatUserId);
	currentDiv.innerHTML = "";
};

// 提供上传接口
var flashUpload = function(swfObj, url, options) {
	swfObj.setUploadURL(url);
	swfObj.uploadOptions = options;
	swfObj.startUpload();
};
var flashPicUpload = function(url, options) {
	flashUpload(picshim, url, options);
};

// 处理不支持异步上传的浏览器,使用swfupload作为解决方案
var uploadType = null;
var uploadShim = function(fileInputId, type) {
	var pageTitle = document.title;
	if (typeof SWFUpload === 'undefined') {
		return;
	}
	return new SWFUpload({
		file_post_name : 'file',
		flash_url : "static/js/swfupload/swfupload.swf",
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
				case 'file':
					sendFile();
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

// 系统功能
var search_user = function() {
	var seareUser = $('#frm_search21').val().trim();
	if (seareUser.length != 11) {
		alert("请输入11位的手机号码");
		return;
	}
	var reg = /^1[34578]\d{9}$/;
	if (!reg.test(seareUser)) {
		alert("请输入正确的手机号码");
		return;
	}
	jQuery.ajax({
		tyep : 'GET',
		url : '/admin/searchUser.htm',
		data:{'username':seareUser},
		datatype : 'json',
		contentType : 'application/json',
		success:function(data){
				alert(data)
		},
		error:function(){
			alert("搜索出错");
		}
	});
}

// 表情配置
Easemob.im.EMOTIONS = {
	path : 'service/images/',
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
