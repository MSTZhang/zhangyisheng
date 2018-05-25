//设置iframe的高度
function setHeight(){
	    //alert(this.document.body.scrollHeight); //弹出当前页面的高度
		var obj =parent.document.getElementById("middleText"); //取得父页面IFrame对象
		//alert(obj.height); //弹出父页面中IFrame中设置的高度
		var height=this.document.body.scrollHeight;
		alert(height);
		if(height<670){
			obj.height=670;
		}else{
			obj.height=height; //调整父页面中IFrame的高度为此页面的高度 
		}
		
}
setHeight();