var allcount=0;var H=$("#spHeadTotalNum");var getAllNum=function(first){var success=function(ret){ret=JSON.parse(ret);if(ret.status==0){if(allcount!=ret.count){if(allcount==0){allcount=ret.count;var aE=ret.count.toString();var aD=aE.length;var az=-33;var aF="";for(var aI=0;aI<aD;aI++){az=az+33;var aA='<div name="dig" class="roll" style="right:'+az+'px; top:-378px;">';for(var aG=9;aG>-1;aG--){aA+='<em t="'+aG+'">'+aG+"</em>"}aA+="</div>";if(aI!=0&&(aI+1)%3==0){az=az+0;aA='<div class="roll" style="right:'+az+'px"></div>'+aA}aF=aA+aF}H.html(aF);var aC=aE.split("");H.children('div[name="dig"]').each(function(aN,aK){var aM=$(this);var aL=parseInt(aC[aN]);aM.animate({top:"-"+(42*(9-aL))+"px"},{queue:false,duration:b,complete:function(){}})})}else{var aB=allcount.toString().split("");var aJ=ret.count.toString().split("");allcount=ret.count;H.children('div[name="dig"]').each(function(aP,aL){var aO=$(this);var aQ=0;var aN=parseInt(aB[aP]);if(aB[aP]<aJ[aP]){aQ=parseInt(aJ[aP])-parseInt(aB[aP])}else{aQ=10+parseInt(aJ[aP])-parseInt(aB[aP])}aO.css("top","-378px");var aR=aO.children('em[t="'+aN+'"]');var aK=aR.nextAll();for(var aM=aK.length-1;aM>-1;aM--){aO.prepend(aK[aM])}aO.animate({top:"-"+(378-aQ*42)+"px"},{queue:false,duration:b,complete:function(){}})})}}}};var a=$("#spBuyCount");var b=a.text();htmlobj=$.ajax({url:"duigou_statics_ajax.htm",async:false});Hb=htmlobj.responseText;if(first===true){success('{"status":0,"count":"'+Hb+'"}')}else{$.ajax({url:"duigou_statics_ajax.htm?id="+(new Date()).getTime(),method:"post",dataType:"html",success:function(data){success('{"status":0,"count":"'+data+'"}')}})}setTimeout(getAllNum,5000)};getAllNum(true);