$(document).ready(function(e){var _scrolling=setInterval("AutoScroll()",4000);$("#wetext").show();var linum=$("#slide li").length;w=linum*300;$(".ulwe21").css("width",w+"px");$("#slider-control-right,#slider-control-left,#slide .ulwe21 li").hover(function(){clearInterval(_scrolling)},function(){_scrolling=setInterval("AutoScroll()",4000)});$("#slider-control-left").click(function(){var _scroll=$(".ulwe21");_scroll.css({marginLeft:0}).find("li:last-child").prependTo(_scroll);$(".ulwe21").animate({marginLeft:"+0"},"slow")});$("#slider-control-right").click(function(){var _scroll=$(".ulwe21");_scroll.css({marginLeft:0}).find("li:first").appendTo(_scroll);$(".ulwe21").animate({marginLeft:"-300px"},"slow")});$("#slide .ulwe21 a").find("span").hide();$("#slide .ulwe21 a").hover(function(){$(this).find("span").fadeIn(500)},function(){$(this).find("span").fadeOut("slow")});$(".gos_btn").hover(function(){wbth=$(this).val();$(this).val("查 看")},function(){$(this).val(wbth)})});function AutoScroll(){var _scroll=$(".ulwe21");_scroll.animate({marginLeft:"-300px"},2000,function(){_scroll.css({marginLeft:0}).find("li:first").appendTo(_scroll)})};