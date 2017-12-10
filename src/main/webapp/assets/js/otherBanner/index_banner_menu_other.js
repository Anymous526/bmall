$(document).ready(function(){ 
	$("#pullDownTitle").mouseover(function(){
		$("#pullDownListOtherBanner").show();
		//li鼠标覆盖事件
		$(".pullDownList li").mouseover(function(){
			$("#pullDownListOtherBanner").show();
			$(this).addClass("menulihover").siblings().removeClass("menulihover");
			$(this).find("div[name='yMenuListCon']").show();
			
		//li鼠标移出事件	
		}).mouseout(function(){
			$(this).find("div[name='yMenuListCon']").hide();
			
		});
		
	}).mouseout(function(){
		$("#pullDownListOtherBanner").hide();
	}); 
	 
	$("#pullDownListOtherBanner").mouseover(function(){ 
		//li鼠标覆盖事件
		$(".pullDownList li").mouseover(function(){
			$("#pullDownListOtherBanner").show();
			$(this).addClass("menulihover").siblings().removeClass("menulihover");
			$(this).find("div[name='yMenuListCon']").show();
			
		//li鼠标移出事件	
		}).mouseout(function(){
			$(this).find("div[name='yMenuListCon']").hide();
			
		});
		
	}).mouseout(function(){
		$("#pullDownListOtherBanner").hide();
	}); 
	 
	 
	$("#pullDownListOtherBanner div[name='yMenuListCon']").mouseleave(function(){  
		$("#pullDownListOtherBanner").hide();
	});
	 
	 
});