/*function addressAdd(){
	var addresses = $("#addresses").val();
	if(addresses==null || addresses=="" || addresses<20) {
		jQuery.ajax({
			type:'POST',
			url:"/amall/buyer/buyer_address_add.htm",
			data:{"currentPage":1},
			success:function(data){
				$("#rightBody").html(data);
			},
			error:function(){
				alert("请检查内部错误");
			}
		});
	}else {
		alert("您最多只能添加二十个收货地址");
	}
	
}

function gotoEditAddress(id,currentPage) {
	jQuery.ajax({
		type:'POST',
		url:"/amall/buyer/buyer_address_edit.htm",
		data:{"id":id,"currentPage":currentPage},
		success:function(data){
			$("#rightBody").html(data);
		},
		error:function(){
			alert("请检查内部错误");
		}
	});
	
}

//设置默认地址
function standardAddress(id,currentPage) {
		jQuery.ajax({	
			type : 'POST',
			url : "/amall/buyer/buyer_address_standard.htm",
			data : {"id": id},
			success : function(data) {
					alert("设置成功!");
			},
			complete:function(){
				setTimeout(gotoAddressList,500);
			},
			error : function(){
				alert("请检查内部错误");
			}
			
		});
		
}

//删除地址
function delAddress(id,currentPage) {
	jQuery.ajax({
		type:'POST',
		url:"/amall/buyer/buyer_address_del.htm",
		data:{"id":id},
		success:function(data){
			
		},
		complete:function(){
			setTimeout(gotoAddressList,500);
		},
		error:function(){
			alert("请检查内部错误");
		}
	});
}
*/