$(document).ready(
	function(){
		console.log("加载");
		$(".second_level").css("display","none");
	}
);
$(".menuControl").click(
	function(){
		var $obj = $(this).parent().next();
		var status = $obj.css("display");
		console.log($obj);
		if(status!="none"){
			$obj.css("display","none");
			$(this).attr("src","img/add.png");
		}else{
			$obj.css("display","block");
			console.log("hide");
			$(this).attr("src","img/decrease.png");
		}
	}
);
$(".topMenu").click(
	function(){
		var $obj = $(".sysMenu");
		var status = $obj.css("display");
		if(status!="none"){
			$obj.css("display","none");
		}else{
			$obj.css("display","block");
		}
	}
);
//顶部菜单鼠标移入事件
$(".topNavSys").mouseenter(
	function(){
		$(this).children(".insM").show();
	}
);
$(".topNavSys").mouseleave(
	function(){
		$(this).children(".insM").hide();
	}
);
