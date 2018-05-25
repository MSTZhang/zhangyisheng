function editText(){
	var checks = $(".checkbox2:checkBox:checked");
	if(checks!=null){
		//遍历
		for(var i=0;i<checks.length;i++){
			var obj = $(checks[i]).parent().parent().nextAll();
			for(var j=0;j<obj.length;j++){
				$(obj[j]).children("div").attr("contenteditable",true);
			}
		}
	}
}
function getCheckedRm(){
	var checks = $(".checkbox2:checkBox:checked");
	var rtys;
	if(checks!=null&&checks.length>0){
		rtys=[];
		var titles=[];
		var head=$(".thead1");
		for(var k=0;k<head.length;k++){
			titles.push($(head[k]).attr("id"));
		}
		//遍历
		for(var i=0;i<checks.length;i++){
			var jsonData={};
			var obj = $(checks[i]).parent().parent().nextAll();
			var thead =$(checks[i]).parent().parent()
			for(var j=0;j<titles.length;j++){
				var str = $(obj[j]).children("div").children("span").html();
				jsonData[titles[j]]=str;
			}
			//var roomType={"roomTypeId":rtyId,"roomTypeName":rtyName,"bedType":bedType,"bedNum":bedNum,"area":area1,"imgUrl":imgUrl,"price":price};
			rtys.push(jsonData);
		}
	}
	return rtys;
}
