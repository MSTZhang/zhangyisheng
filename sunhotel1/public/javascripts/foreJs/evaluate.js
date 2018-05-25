//获取渲染后的模板
//查询待点评的评价
$(".uneva").click(function(){
	var obj = $(this);
	obj.css("background","#90704D");
	obj.css("color","#fff");
	var oj = $(".evaed");
	oj.css("background","#fff");
	oj.css("color","#90704D");
	var url1="http://localhost:8081/readFile?filename=views/ejsTemplate/evaluateListTmp.ejs";
	var url2="http://localhost:8080/springmvcDemo1/accessible/findByUId?status=1";
	var html = findHtml(url1,url2);
	$("#evaTable").html(html);
});
//查询已点评过的
$(".evaed").click(function(){
	var obj = $(this);
	obj.css("background","#90704D");
	obj.css("color","#fff");
	var oj = $(".uneva");
	oj.css("background","#fff");
	oj.css("color","#90704D");
	var url1="http://localhost:8081/readFile?filename=views/ejsTemplate/evaluateListTmp.ejs";
	var url2="http://localhost:8080/springmvcDemo1/accessible/findByUId?status=2";
	var html = findHtml(url1,url2);
	$("#evaTable").html(html);
});
