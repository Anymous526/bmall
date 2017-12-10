$(function(){ 
	$(".ce > li > a").click(function(){
		$(this).addClass("xz").parents().siblings().find("a").removeClass("xz")
		});
	
	$(window).scroll(function(){
		var top=$(window).scrollTop();
		if(top>370){
			$(".ce").addClass("ce2")
			}
		else{
			$(".ce").removeClass("ce2")
			}
		
		var tt=$(window).height(); 
		var num=0;
		for(var n=0;n<6;n++){
			if(top>=n*tt&&top<=(n+1)*tt){
				num=n
			} 
			$(".ce > li > a").removeClass("xz").eq(num).addClass("xz")
			}
		});
	$("#navon0").click(function(){
		$("html,body").animate({scrollTop:$("#div0").offset().top},600)
		});
	$("#navon1").click(function(){$("html,body").animate({scrollTop:$("#div1").offset().top},600)});$("#navon2").click(function(){$("html,body").animate({scrollTop:$("#div2").offset().top},600)});$("#navon3").click(function(){$("html,body").animate({scrollTop:$("#div3").offset().top},600)});$("#navon4").click(function(){$("html,body").animate({scrollTop:$("#div4").offset().top},600)});$("#navon5").click(function(){$("html,body").animate({scrollTop:$("#div5").offset().top},600)})});