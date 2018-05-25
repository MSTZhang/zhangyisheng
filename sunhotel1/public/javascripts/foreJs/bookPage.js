$(document).ready(function(){
	//加载预订信息模板
	var template;
	$.ajax({
		type:"get",
		contentType: "application/json;charset=utf-8",
		url:"readFile?filename=views/ejsTemplate/bookInfo.ejs",
		async:false,
		xhrFields: {
		    withCredentials:true // 携带跨域cookie
		},
        crossDomain:true,
		success:function(result,status){
			template = result;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		 //var html =ejs.render(loginInfoTemplate,{member:null});
		 //$(".headNav2_nav12").html(html);
		}
	});
	//向nodejs发送请求拿到session,
	$.ajax({
		type:"get",
		contentType: "application/json;charset=utf-8",
		url:"http://localhost:8081/getBookInfo",
		async:false,
		xhrFields: {
		    withCredentials:true // 携带跨域cookie
		},
        crossDomain:true,
		success:function(result,status){
			var jsonStr = JSON.parse(result);
			var html = ejs.render(template,jsonStr);
			$(".message_box").html(html);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		 //var html =ejs.render(loginInfoTemplate,{member:null});
		 //$(".headNav2_nav12").html(html);
		}
	});
});
//向后台发送预定信息
$(".smtBtn1").click(function(){
	var url1 = "http://localhost:8081/getBookInfo";
	var bookInfoStr = ajaxGet(url1,false);
	var bookInfo=JSON.parse(bookInfoStr);
	//构造json数据
	var custom = $("#customName").val();
	var room={"roomId":null,"acId":bookInfo.acId,"roomTypeId":null,"floor":null,"rmStatus":null,"roomType":null,"flexible":null};
	var jsonData={"orderId":null,"customName":$("#customName").val(),"customTel":$("#tel").val(),"rtyId":bookInfo.roomTypeId,"rmId":null,"checkTime":bookInfo.checkTime,"leaveTime":bookInfo.endTime,"num":$("#pnum").val(),"days":bookInfo.days,"bookTime":null,"odStatus":1,"remark":$("#remark").val(),"forgift":bookInfo.forgift,"room":room,"member":null,"roomType":null};
	str = JSON.stringify(jsonData);
	//console.log(jsonData);
	var url2="http://localhost:8080/springmvcDemo1/order/customAdd";
	var response = ajaxPost(url2,str,false);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			var orderId = response.data;
			window.location.href="orderSuccess?orderId="+orderId;
		}else{
			alert("预定失败");
		}
	}else{
		alert("无法连接到服务器");
	}
});