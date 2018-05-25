var preRadio;
var i=2;
$(document).ready(function(){
	var current=$(".radio_"+1);
	current.css("background","red");
	preRadio=current;
	bgtimer();
	var loginInfoTemplate;
	//获取导航栏登录信息的模板
	console.log("发送ajax请求")
	var url1 = "http://localhost:8081/readFile?filename=views/ejsTemplate/indexTopLoginedTmp.ejs";
	var response = ajaxGet(url1,false);
	if(response!=null){
		var url2="http://localhost:8080/springmvcDemo1/loginInfo";
		var response1 = ajaxGet(url2,false);
		if(response1!=null){
			var html =ejs.render(response,{member:response1.data});
			$(".headNav2_nav12").html(html);
		}else{
			var html =ejs.render(response,{member:null});
		 	$(".headNav2_nav12").html(html);
		}
	}else{
		
	}
});
function bgtimer(){
	function bt(){
		var src="url(http://localhost:8081/images/foreImg/bg"+i+".jpg)";
		$(".middleBox").css("background",src);
		preRadio.css("background","#fff");
		$(".radio_"+i).css("background","red");
		preRadio=$(".radio_"+i);
		i++;
		if(i==7){
			i=1;
		}
		
	}
	setInterval(bt,5000);
}
//点击radios按钮时图片切换
$(".checkRadio").children("li").click(function(){
	preRadio.css("background","#fff");
	var obj = $(this);
	obj.css("background","red");
	var str = obj.attr("class");
	i=str.substring(6,7);
	var src="url(http://localhost:8081/images/foreImg/bg"+i+".jpg)";
	$(".middleBox").css("background",src);
	preRadio=obj;
});
$(".lastBtn").click(function(){
	var str =preRadio.attr("class");
	var j =str.substring(6,7);
	i=parseInt(j);
	i=i-1;
	if(i!=0){
		var src="url(http://localhost:8081/images/foreImg/bg"+i+".jpg)";
		$(".middleBox").css("background",src);
		preRadio.css("background","#fff");
		$(".radio_"+i).css("background","red");
		preRadio=$(".radio_"+i);
	}
});
$(".nextBtn").click(function(){
	var str =preRadio.attr("class");
	var j =str.substring(6,7);
	j=parseInt(j)+1;
	i=i+1;
	if(j<=6){
		i=j;
		var src="url(http://localhost:8081/images/foreImg/bg"+i+".jpg)";
		$(".middleBox").css("background",src);
		preRadio.css("background","#fff");
		$(".radio_"+i).css("background","red");
		preRadio=$(".radio_"+i);
	}
	
});