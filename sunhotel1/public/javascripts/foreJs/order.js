//查询未入住的订单
function findUnCheck(url1){
	var response = ajaxGet(url1,false);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			var url2 = "http://localhost:8081/readFile?filename=views/ejsTemplate/orderTmp.ejs";
			var tmp = ajaxGet(url2,false);
			if(tmp!=null){
				console.log(response.data);
				var html = ejs.render(tmp,{"datas":response.data});
				$(".orderListBox").html(html);
			}else{
				window.location.href="error";
			}
		}else{
			window.location.href="login";
		}
	}else{
		window.location.href="error";
	}
}
$(document).ready(function(){
	var url1="http://localhost:8080/springmvcDemo1/order/findUnCheck";
	findUnCheck(url1);
});
$(".uneva").click(function(){
	var obj = $(this);
	obj.css("background","#90704D");
	obj.css("color","#fff");
	var oj = $(".evaed");
	oj.css("background","#fff");
	oj.css("color","#90704D");
	var url1="http://localhost:8080/springmvcDemo1/order/findUnCheck";
	findUnCheck(url1);
});
$(".evaed").click(function(){
	var obj = $(this);
	obj.css("background","#90704D");
	obj.css("color","#fff");
	var oj = $(".uneva");
	oj.css("background","#fff");
	oj.css("color","#90704D");
	var url1="http://localhost:8080/springmvcDemo1/order/findHisCheck";
	findUnCheck(url1);
});