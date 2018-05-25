$("#userName").focusin(function(){
	var obj = $(this).parent("div").next().children("span");
	obj.html("");
});
$("#userName").focusout(function(){
	var obj = $(this).parent("div").next().children("span");
	//var val = obj.html();
	var value=$(this).val();
	if(value==null||value==""){
		obj.html("用户名不能为空");
	}
});
//*****************************
$("#tel").focusin(function(){
	var obj = $(this).parent("div").next().children("span");
	obj.html("");
});
$("#tel").focusout(function(){
	var obj = $(this).parent("div").next().children("span");
	//var val = obj.html();
	var value=$(this).val();
	if(value==null||value==""){
		obj.html("必须填写手机号");
	}
});
//********************************
$("#pwd").focusin(function(){
	var obj = $(this).parent("div").next().children("span");
	obj.html("");
});
$("#pwd").focusout(function(){
	var obj = $(this).parent("div").next().children("span");
	//var val = obj.html();
	var value=$(this).val();
	if(value==null||value==""){
		obj.html("登录密码不能为空");
	}
});
//********************************
$("#rePwd").focusin(function(){
	var obj = $(this).parent("div").next().children("span");
	obj.html("");
});
$("#rePwd").focusout(function(){
	var obj = $(this).parent("div").next().children("span");
	//var val = obj.html();
	var pwd=$("#pwd").val();
	var rpwd=$(this).val();
	if(pwd!=rpwd){
		obj.html("两次密码不一致");
	}
});
//********************************
$("#email").focusin(function(){
	var obj = $(this).parent("div").next().children("span");
	obj.html("");
});
$("#email").focusout(function(){
	var obj = $(this).parent("div").next().children("span");
	//var val = obj.html();
	var value=$(this).val();
	if(value==null||value==""){
		obj.html("邮箱不能为空");
	}
});
$("#registerBtn").click(function(){
	var userName = $("#userName").val();
	var tel = $("#tel").val();
	var pwd = $("#pwd").val();
	var rpwd = $("#rePwd").val();
	var email = $("#email").val();
	console.log(email+"   "+rpwd+"  "+pwd+"  "+tel+"  "+userName);
	if((userName!=null&&userName!="")&&(tel!=null&&tel!="")&&(pwd!=null&&pwd!="")&&(pwd==rpwd)&&(email!=null&&email!="")){
		$(".slidBox").show();
		//构造json数据
		var userJson ={"id":null,"customName":userName,"pwd":pwd,"tel":tel,"email":email,"level":null,"discount":null,"isAble":null};
		var str =JSON.stringify(userJson);
		//发起ajax请求
		$.ajax({
		type:"post",
		contentType: "application/json;charset=utf-8",
		data:str,
		url:"http://localhost:8080/springmvcDemo1/member/register",
		async:false,
		success:function(result,status){
			$(".slidBox").hide();
			$(".tipInf").html("注册成功<span style='color:#08c608;font-size: 30px;'>&nbsp;&radic;</span>");
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		 $(".tipInf").html("注册失败<span style='color:#08c608;font-size: 30px;'>&nbsp;&times;</span>");
		}
	});
	}else{
		alert("请正确填写信息");
	}
});
