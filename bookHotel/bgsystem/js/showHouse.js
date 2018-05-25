//鼠标移入顶部过滤条件时的状态
$(".houseHead").children("ul").children("li").mouseenter(
	function(){
		$(this).css("background","#009933");
		$(this).css("color","white");
	}
);
$(".houseHead").children("ul").children("li").mouseleave(
	function(){
		var cls = $(this).attr("class");
		if(cls!="currentLi"){
			$(this).css("background","#fef8f3");
			$(this).css("color","black");
		}
		
	}
);

//鼠标点击顶部过滤条件时
$(".houseHead").children("ul").children("li").click(
	function(){
		$(this).parent("ul").find(".currentLi").removeClass("currentLi");
		$(this).addClass("currentLi");
	}
);
	

//鼠标移入左侧过滤条件时
$(".roomFloor").children("div").mouseenter(
	function(){
		$(this).css("background","orange");
		$(this).css("color","white");
		$(this).css("border","1px solid #ca9e2d");
	}
);
$(".roomFloor").children("div").mouseleave(
	function(){
		var cls = $(this).attr("class");
		if(cls!="selectedFloor"){
			$(this).css("background","#fef8f3");
			$(this).css("color","black");
			$(this).css("border","none");
		}
	}
);