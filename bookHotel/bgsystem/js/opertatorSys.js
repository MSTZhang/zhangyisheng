$(".delete1").mouseenter(function(){
	var obj = $(this);
	obj.children("img").attr("src","img/delete1.png");
	obj.css("color","red");
	
});
$(".delete1").mouseleave(function(){
	var obj = $(this);
	obj.children("img").attr("src","img/delete.png");
	obj.css("color","#515151");
	
});
$(".alert1").mouseenter(function(){
	var obj = $(this);
	obj.children("img").attr("src","img/change1.png");
	obj.css("color","red");
	
});
$(".alert1").mouseleave(function(){
	var obj = $(this);
	obj.children("img").attr("src","img/change.png");
	obj.css("color","#515151");
	
});
$(".lockSystem").click(
	function(){
		var value = prompt("管理员密码","")
		while((value==null)||(value!='zhangyisheng')){
			value = prompt("管理员密码","")
		}
	}
);