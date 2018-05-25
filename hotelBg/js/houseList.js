//加载房间信息
function loadRoomInfo(){
	//获取房间数据
	var url2="http://localhost:8080/springmvcDemo1/room/select";
	var response2 =ajaxGet(url2,false);
	var jsonData = response2.data;
	//获取模板
	var url3="http://localhost/hotelBg/template/houseList.ejs";
	var response3=ajaxGet(url3,false);
	var html = ejs.render(response3,{rooms:jsonData});
	$(".houseListBox").html(html);
}
$(document).ready(function(){
	//验证是否登录
	var url1="http://localhost:8080/springmvcDemo1/manager/loginValidate";
	var response1 = ajaxGet(url1,false);
	loadRoomInfo();
	var url2 = window.location.href;
	var paras = getParameters(url2);
	if(paras!=null){
		var method = paras["method"];
		var value=paras["value"];
		init(method,value);
	}
	/*var url3="http://127.0.0.1:8020/hotelBg/template/reservationTmp.ejs";
	response2 = ajaxGet(url3,false);
	$(".registerBox").html(response2);*/
});
//加载预定信息或登记信息
function init(method,value){
	var url1;
	if("balance"==method){
		url1 ="http://localhost:8080/springmvcDemo1/checkIn/findByCheckNum?checkNum="+value;
	}else if("register"==method){
		url1="";
	}
	url1 ="http://localhost:8080/springmvcDemo1/checkIn/findByCheckNum?checkNum="+value;
	var response = ajaxGet(url1,false);
	if(response!=null){
		cleanRgInf();
		var success = response.meta.success;
		if(success){
			if("balance"==method){
				$(".checkoutBtn").show();
				$(".registerBtn").hide();
			}else{
				$(".registerBtn").show();
				$(".checkoutBtn").hide();
			}
			
			$(".reserBtn").hide();
			$(".settleBtn").hide();
			
			console.log(response);
			var jsonData = response.data;
			fillCheckInfo(jsonData);
			//$("#price").val(jsonData.roomType.price);
		}else{
			alert("服务器内部错误");
		}
	}else{
		alert("操作失败");
	}
}
//*****************************************************
laydate.render({
  elem: '#checkTime' //指定元素
});
//*****************************************************
laydate.render({
  elem: '#leaveTime' //指定元素
});
//******************************************************
//获取入住信息，返回json对象
function getRgInf(arrays){
	var jsonData={};
	//入住时间
	for(var i=0;i<arrays.length;i++){
		var obj = $("#"+arrays[i]);
		var val = obj.val();
		if(val==null||val==""){
			jsonData[arrays[i]]=null;
		}else{
			jsonData[arrays[i]]=val;
		}
	}
	return jsonData;
}
//判断入住信息是否为空
function isNull(){
	
}
//清空登记信息的内容
function cleanRgInf(){
	var arrys = ["checkTime","days","leaveTime","num","bookTime","paperNumber","customTel","adress","customName"];
	for(var i=0;i<arrys.length;i++){
		$("#"+arrys[i]).val("");
	}
	$("#paperType").val("身份证");
	$("#sex").val(1);
	$("#cmLevel").val(1);
}
//入住信息的填充,传入json对象
function fillCheckInfo(data){
	for(var keys in data){
		$("#"+keys).val(data[keys]);
	}
}
//post发送请求的函数

//******************************************************
//登记按钮
$(".registerBtn").click(function(){
	var ur = "http://localhost:8080/springmvcDemo1/checkIn/add"
	//发送请求
	var arrays = ["checkNumber","userId","rmId","rtyId","cmLevel","customName","sex","paperType","paperNumber","adress","num","checkTime","days","leaveTime","forgift","status","balanceNumber","operatorId","room","roomType"];
	var jsonData = getRgInf(arrays);
	var str = JSON.stringify(jsonData);
	var result = ajaxPost(ur,str,false);
	if(result!=null){
		var success = result.meta.success;
		if(success){
			window.location.reload();
		}else{
			alert("登记失败");
		}
	}else{
		alert("添加失败");
	}
});
//预定按钮
$(".reserBtn").click(function(){
	var arrays=["orderId","customName","customTel","rtyId","rmId","checkTime","leaveTime","num","days","bookTime","remark","forgift"];
	var jsonData = getRgInf(arrays);
	var str = JSON.stringify(jsonData);
	var url1="http://localhost:8080/springmvcDemo1/order/operatorAdd";
	var response = ajaxPost(url1,str,false);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			cleanRgInf();
			window.location.reload();
		}else{
			alert("操作失败");
		}
	}else{
		alert("无法连接到服务器");
	}
});
//结账
$(".checkoutBtn").click(function(){
	//计算总金额
	var checkNum = $("#checkNumber").val();
	var url1="http://localhost:8080/springmvcDemo1/checkIn/totalPrice?checkNum="+checkNum;
	var response = ajaxGet(url1,false);
	if(response!=null){
		var statu = response.meta.success;
		if(statu){
			$(".registerBtn").hide();
			$(".reserBtn").hide();
			$(".settleBtn").show();
			$(".checkoutBtn").hide();
			$(".totalPrice").html(response.data);
		}else{
			alert("请求失败，请稍后再试");
		}
	}else{
		alert("无法连接到服务器");
	}
});
//确认结账
$(".reBtn").click(function(){
	var checkNum = $("#checkNumber").val();
	var url1="http://localhost:8080/springmvcDemo1/checkIn/balance?checkNum="+checkNum;
	var response = ajaxGet(url1,false);
	if(response!=null){
		var statu = response.meta.success;
		if(statu){
			cleanRgInf();
			window.location.reload();
		}else{
			alert("结账失败");
		}
	}else{
		alert("结账失败");
	}
});
