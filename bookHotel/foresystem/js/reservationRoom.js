$(".roomInfoContent").click(
	function(){
		console.log(this);
		var $info = $(this).next("div");
		var status =$info.css("display");
		console.log(status);
		if(status!=="none"){
			$info.css("display","none");
		}else{
			$info.css("display","block");
		}
	}
);
$(".assureBox").mouseenter(
	function(){
		$(this).next(".assureText").css("display","block");
	}
);
$(".assureBox").mouseleave(
	function(){
		$(this).next(".assureText").css("display","none");
	}
);
function ynHomeBtn(data){
	window.open("order.html");
}
