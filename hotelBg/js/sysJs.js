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
//返回渲染后的html
function loadHtml(url1,url2,dataName){
	//获取房间数据
	var html;
	var response1 =ajaxGet(url1,false);
	console.log(response1);
	if(response1!=null){
		var success = response1.meta.success;
		if(success){
			var response2=ajaxGet(url2,false);
			if(response2!=null){
				html = ejs.render(response2,{"datas":response1.data});
			}else{
				window.parent.location="error.html";
			}
		}else{
			window.parent.location="login.html";
		}
	}else{
		window.parent.location="error.html";
	}
	return html;
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