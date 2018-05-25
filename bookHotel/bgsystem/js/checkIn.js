$(".unselecedRm tr").dblclick(
	function(){
		var obj = $(this).clone(true);
		obj.children().css("background","white");
		obj.children().css("color","black");
		$(".selecedRm").append(obj);
	}
);
$(".unselecedRm tr").mouseenter(
	function(){
		$(this).children().css("cursor","pointer");
		$(this).children().css("background","grey");
		$(this).children().css("color","white");
	}
);
$(".unselecedRm tr").mouseleave(
	function(){
		$(this).children().css("background","white");
		$(this).children().css("color","black");
	}
);
$("#cancelRm").click(
	function(){
		var fg = confirm("确定撤销？");
		if(fg==true){
			$(".selecedRm").empty();	
		}
	}
);
