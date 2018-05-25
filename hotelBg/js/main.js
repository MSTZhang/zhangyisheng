//页面准备好时
$(document).ready(function(){
	//验证是否已登录
	var url1="http://localhost:8080/springmvcDemo1/manager/loginValidate";
	var response = ajaxGet(url1,false);
	if(response!=null){
		var success =response.meta.success; 
		if(!success){
			window.location.href="login.html"
		}
	}else{
		window.location.href="error.html";
	}
	
});
function showPwdBox(){
	$(".alterPwd").show();
}
function canelBtn(){
	$(".alterPwd").hide();
}
function submitBtn(){
	var oldPwd = $("#oldPwd").val().trim();
	var newPwd = $("#newPwd").val().trim();
	if(oldPwd!=""&&newPwd!=""){
		$(".alterPwd").hide();
		var url1="http://localhost:8080/springmvcDemo1/manager/alterPwd?oldPwd="+oldPwd+"&newPwd="+newPwd;
		var response = ajaxGet(url1,false);
		if(response!=null){
			var success=response.meta.success;
			if(success){
				alert("修改成功");
				window.parent.frames.location.href="login.html";
			}else{
				alert("修改失败");
			}
		}else{
			
		}
	}
}
