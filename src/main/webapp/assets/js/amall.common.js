var appCommon={isValidText:function(param){if((param.indexOf("|")>=0)||(param.indexOf("#")>=0)){window.alert("“|”和“#”为系统保留字符，请不要输入！");return false}return true},luhmCheck:function(bankno){var lastNum=bankno.substr(bankno.length-1,1);var first15Num=bankno.substr(0,bankno.length-1);var newArr=new Array();for(var i=first15Num.length-1;i>-1;i--){newArr.push(first15Num.substr(i,1))}var arrJiShu=new Array();var arrJiShu2=new Array();var arrOuShu=new Array();for(var j=0;j<newArr.length;j++){if((j+1)%2==1){if(parseInt(newArr[j])*2<9){arrJiShu.push(parseInt(newArr[j])*2)}else{arrJiShu2.push(parseInt(newArr[j])*2)}}else{arrOuShu.push(newArr[j])}}var jishu_child1=new Array();var jishu_child2=new Array();for(var h=0;h<arrJiShu2.length;h++){jishu_child1.push(parseInt(arrJiShu2[h])%10);jishu_child2.push(parseInt(arrJiShu2[h])/10)}var sumJiShu=0;var sumOuShu=0;var sumJiShuChild1=0;var sumJiShuChild2=0;var sumTotal=0;for(var m=0;m<arrJiShu.length;m++){sumJiShu=sumJiShu+parseInt(arrJiShu[m])}for(var n=0;n<arrOuShu.length;n++){sumOuShu=sumOuShu+parseInt(arrOuShu[n])}for(var p=0;p<jishu_child1.length;p++){sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p])}sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);var k=parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;var luhm=10-k;if(lastNum==luhm){return true}else{window.alert("银行卡号必须符合Luhm校验");return false}}};var vcity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};checkCard=function(card){if(card===""){alert("请输入身份证号，身份证号不能为空");return false}if(isCardNo(card)===false){alert("您输入的身份证号码不正确，请重新输入");return false}if(checkProvince(card)===false){alert("您输入的身份证号码不正确,请重新输入");return false}if(checkBirthday(card)===false){alert("您输入的身份证号码生日不正确,请重新输入");return false}if(checkParity(card)===false){alert("您的身份证校验位不正确,请重新输入");return false}return true};isCardNo=function(card){var reg=/(^\d{15}$)|(^\d{17}(\d|X)$)/;if(reg.test(card)===false){return false}return true};checkProvince=function(card){var province=card.substr(0,2);if(vcity[province]==undefined){return false}return true};checkBirthday=function(card){var len=card.length;if(len=="15"){var re_fifteen=/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;var arr_data=card.match(re_fifteen);var year=arr_data[2];var month=arr_data[3];var day=arr_data[4];var birthday=new Date("19"+year+"/"+month+"/"+day);return verifyBirthday("19"+year,month,day,birthday)}if(len=="18"){var re_eighteen=/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;var arr_data=card.match(re_eighteen);var year=arr_data[2];var month=arr_data[3];var day=arr_data[4];var birthday=new Date(year+"/"+month+"/"+day);return verifyBirthday(year,month,day,birthday)}return false};verifyBirthday=function(year,month,day,birthday){var now=new Date();var now_year=now.getFullYear();if(birthday.getFullYear()==year&&(birthday.getMonth()+1)==month&&birthday.getDate()==day){var time=now_year-year;if(time>=3&&time<=100){return true}return false}return false};checkParity=function(card){card=changeFivteenToEighteen(card);var len=card.length;if(len=="18"){var arrInt=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);var arrCh=new Array("1","0","X","9","8","7","6","5","4","3","2");var cardTemp=0,i,valnum;for(i=0;i<17;i++){cardTemp+=card.substr(i,1)*arrInt[i]}valnum=arrCh[cardTemp%11];if(valnum==card.substr(17,1)){return true}return false}return false};changeFivteenToEighteen=function(card){if(card.length=="15"){var arrInt=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);var arrCh=new Array("1","0","X","9","8","7","6","5","4","3","2");var cardTemp=0,i;card=card.substr(0,6)+"19"+card.substr(6,card.length-6);for(i=0;i<17;i++){cardTemp+=card.substr(i,1)*arrInt[i]}card+=arrCh[cardTemp%11];return card}return card};