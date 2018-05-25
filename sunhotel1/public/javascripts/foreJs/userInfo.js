//左边导航栏点击事件
function leftNavClick(data){
	$("#showFrame").attr("src",data);
}
function show1(clsName){
	$("#shadowBox").show();
	$("."+clsName).show();
}
function hide1(clsName){
	$("#shadowBox").hide();
	$("."+clsName).hide()
}
$(".alertPwdBtn").click(function(){
	alert("修改密码");
	var currentPwd = $("#currenPwd").val().trim();
	var newPwd = $("#newPwd").val().trim();
	var rePwd = $("#rePwd").val().trim();
	if(newPwd!=null&&newPwd==rePwd&&currentPwd!=null){
		var url1="http://localhost:8080/springmvcDemo1/member/updatePwd?currentPwd="+currentPwd+"&newPwd="+newPwd;
		var response = ajaxGet(url1,false);
		if(response!=null){
			if(response.meta.success){
				window.location.href="index";
			}else{
				$("#pwdTip1").html("密码不正确");
			}
		}
	}
});
$(".cancelBtn").click(function(){
	$(".alterPwdBox").hide();
	$("#shadowBox").hide();
});

