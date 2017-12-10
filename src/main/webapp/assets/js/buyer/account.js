/*function gotoBuyerAccount(){
	jQuery.ajax({
		type:'POST',
		url:"/amall/buyer/buyer_account.htm",
		data:"",
		success:function(data){
			$("#rightBody").html(data);
		},
		error:function(){
			alert("请检查内部错误");
		}
	});
}


//异步提交表单
function subInfo(){
	  var $form = $("#infoForm");
	  var url = $form.attr("action");
	  var i = jQuery.post(url, $form.serialize(), function(data)
		        {
		            alert("修改成功!");
		        });
}

//修改密码
function gotoUpdatePwd(){
	jQuery.ajax({
		type:"POST",
		data:"",
		url:"/amall/buyer/buyer_account_password.htm",
		success:function(data){
			$("#rightBody").html(data);
		},
		error:function(){
			alert("请检查内部错误");
		}
	});
}

//异步提交密码修改
function subPwd(){
	var $form = $("#pwdForm");
	var url = $form.attr("action");
	var i = jQuery.post(url,$form.serialize(),function(data){
		alert(data);
		$("#old_password").empty();
		$("#new_password").empty();
		$("#new_password1").empty();
		alert("修改成功!");
	});
}


*/