function ajaxPost(url1,data,asy){
	var obj
	$.ajax({
		type:"POST",
		url:url1,
		data:data,
		async:asy,
		xhrFields:{
		    withCredentials: true // 携带跨域cookie
		},
        crossDomain:true,
        contentType: "application/json;charset=utf-8",
        success:function(result,status){
        	obj=result;
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
        	var text1 = XMLHttpRequest.responseText;
        	if(XMLHttpRequest.status==500){
        		obj = JSON.parse(text1);
        	}
        }
	});
	return obj;
}
function ajaxGet(url1,asy){
	var obj
	$.ajax({
		type:"GET",
		url:url1,
		async:asy,
		xhrFields:{
		    withCredentials: true // 携带跨域cookie
		},
        crossDomain:true,
        contentType: "application/json;charset=utf-8",
        success:function(result,status){
        	obj=result;
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
        	var text1 = XMLHttpRequest.responseText;
        	if(XMLHttpRequest.status==500){
        		obj = JSON.parse(text1);
        	}
        }
	});
	return obj;
}
//ajaxd的get请求封装
function getRequest(url1,asyn,succFun,failFun){
	var response = ajaxGet(url1,asyn);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			succFun(response);
		}else{
			top.location="login";
		}
	}else{
		failFun();
	}
}
//ajax的post请求封装
function postRequest(url1,data,asyn,excute){
	var response = ajaxPost(url1,data,asyn);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			excute(response.data);
		}else{
			top.location="login";
		}
	}else{
		top.location="error";
	}
}
function findHtml(url1,url2){
	var tmp = ajaxGet(url1,false);
	if(tmp!=null){
		var response = ajaxGet(url2,false);
		console.log(response);
		if(response!=null){
			var status = response.meta.success;
			if(status){
				//请求模板
				console.log(response)
				var html = ejs.render(tmp,{"datas":response.data});
				return html;
			}else{
				window.location.href="login";
			}
		}else{
			window.location.href="error";
		}
	}else{
		window.location.href="error";
	}
}
//获取请求参数,返回一个key-value的json
function getParameters(url1){
	var jsonData;
	var str = url1.substring(url1.lastIndexOf("?")+1,url1.length);
	if(str!=null){
		jsonData = {};
		var arrays = str.split("&");
		for(var i =0;i<arrays.length;i++){
			var keys = arrays[i].substring(0,arrays[i].lastIndexOf("="));
			var value = 
			jsonData[keys]=arrays[i].substring(arrays[i].lastIndexOf("=")+1,arrays[i].length);
		}
	}
	return jsonData
}
