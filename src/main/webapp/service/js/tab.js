$(function(){
	$(".zzsc .tab a").mouseover(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		number = index;
		$('.zzsc .content li').hide();
		$('.zzsc .content li:eq('+index+')').show();
	});
});





$(document).ready(function(){
	var label= $('label');
	var content= $('.qa');
	$('.qa').not(":first").hide();
	$('label').on("click",function(){
		var tLabel = $(this);
		var tContent = tLabel.next();		
		content.slideUp("normal");
		tContent.slideDown("slow");		
	});
});