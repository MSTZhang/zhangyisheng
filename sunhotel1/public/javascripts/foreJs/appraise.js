$(document).ready(function(){
	//获取登录信息
	var url1 = window.location.href;
	console.log(url1);
});
$(".startBox").click(function(){
	var pre =$(this).prevAll();
	if(pre!=null&&pre.length>0){
		for(var i=0;i<pre.length;i++){
			$(pre[i]).children("img").attr("src","images/foreImg/start/stars2.png");
		}
	}
	$(this).children("img").attr("src","images/foreImg/start/stars2.png");
	var af = $(this).nextAll();
	if(af!=null&&af.length>0){
		for(var i=0;i<af.length;i++){
			$(af[i]).children("img").attr("src","images/foreImg/start/stark2.png");
		}
	}
	var sb = $(this).parent().next("div");
	var score=pre.length+1;
	sb.children(".score").html(score);
	//var 
	if(score==1){
		sb.children(".atti").html("非常糟糕!!!");
	}else if(score==2){
		sb.children(".atti").html("不满意，与描述不符");
	}else if(score==3){
		sb.children(".atti").html("环境一般");
	}else if(score==4){
		sb.children(".atti").html("满意");
	}else if(score==5){
		sb.children(".atti").html("非常满意");
	}
});
$(".smtBtn").click(function(){
	var evtIndex = $(".evtIndex").html();
	var	cleanIndex = $(".cleanIndex").html();
	var	ftIndex = $(".ftIndex").html();
	var serverIndex = $(".serverIndex").html();
	var content=$(".content").val();
	if(evtIndex!=""&&cleanIndex!=null&&ftIndex!=null&&serverIndex!=""){
		var url1 = window.location.href;
		var accNum=url1.substring(url1.indexOf("=")+1,url1.length);
		var jsonData = {"accNumber":accNum,"checkNum":null,"orderId":null,"customId":null,"customName":null,"status":2,"evtIndex":evtIndex,"cleanIndex":cleanIndex,"ftIndex":ftIndex,"serverIndex":serverIndex,"content":content,"accTime":null,"order":null,"member":null};
		var url2="http://localhost:8080/springmvcDemo1/accessible/update";
		var response = ajaxPost(url2,JSON.stringify(jsonData),false);
		if(response!=null){
			var status = response.meta.success;
			if(status){
				window.location.href="evaluateSuccess";
				top.location="evaluateSuccess"; 
			}else{
				window.location.href="login";
			}
		}else{
			alert("无法连接到服务器，请稍后再试");
		}
	}else{
		alert("你的评价尚未完成，请完善");
	}
});
