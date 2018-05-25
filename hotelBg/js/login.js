function form_submit(){
	//获取数据
	var user = $("#user").val();
	var pwd = $("#pwd").val();
	//去除空格
	if(user!=""&&pwd!=""){
		//构造json数据
		var jsonData={"id":null,"userCount":user,"pwd":pwd,"mLevel":null};
		var str = JSON.stringify(jsonData);
		//向服务器端发送请求
		$("#transitDiv").css("display","block");
		var url1 = "http://localhost:8080/springmvcDemo1/manager/login";
		var resoponse = ajaxPost(url1,str,false);
		console.log(resoponse);
		if(resoponse!=null){
			var success = resoponse.meta.success;
			if(success){
				$("#transitDiv").css("display","none");
				window.location.href="main.html";
			}else{
				$("#transitDiv").css("display","none");
				console.log(XMLHttpRequest);
				var message = resoponse.meta.message;
				alert(message);
			}
		}else{
			$("#transitDiv").css("display","none");
			alert("服务器内部错误");
		}
	}
	
}