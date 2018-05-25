//账户输入框失去焦点时判断是否为空，为空给予提示
$("#userName").focusout(function(){
	var value =$(this).val().trim();
	if(value==""){
		$(".userMsg").html("账号不能为空");
	}
});
//账户获得焦点时清空提示信息
$("#userName").focusin(function(){
	$(".userMsg").html("");
});
//密码输入框失去焦点时判断是否为空，为空给予提示
$("#pwd").focusout(function(){
	var value =$(this).val().trim();
	if(value==""){
		$(".pwdMsg").html("密码不能为空");
	}
});
//账户获得焦点时清空提示信息
$("#pwd").focusin(function(){
	$(".pwdMsg").html("");
});
$("#smtBtn").click(function(){
	var userName = $("#userName").val().trim();
	var pwd = $("#pwd").val().trim();
	//如果账号和密码都不为空则提交登录请求
	if(userName!=""&&pwd!=""){
		//构造json字符串
		$(".loadingBox").show();
		var jsonData;
		if(userName.indexOf("@")>0){
			jsonData={"id":null,"customName":null,"pwd":"123456","tel":null,"email":userName,"level":null,"discount":null,"status":null};
		}else{
			jsonData={"id":null,"customName":null,"pwd":"123456","tel":userName,"email":null,"level":null,"discount":null,"status":null};
		}
		var url1="http://localhost:8080/springmvcDemo1/member";
		var response = ajaxPost(url1,JSON.stringify(jsonData),false);
		if(response!=null){
			var status = response.meta.success;
			if(status){
				$(".loadingBox").hide();
				window.location.href="index";
			}else{
				$(".loadingBox").hide();
				$(".loginFail").html("账号或密码不正确");
			}
			
		}else{
			$(".loadingBox").hide();
			alert("无法连接到服务器");
		}
	}
});
