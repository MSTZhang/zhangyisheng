//房间展示模板
$(document).ready(function(){
	//加载模板数据
	//加载房间列表
	var url1 = "http://localhost:8081/readFile?filename=views/ejsTemplate/houseList.ejs";
	var url2 = "http://localhost:8080/springmvcDemo1/roomType/select";
	var html = findHtml(url1,url2);
	$(".roomTable").html(html);
	//加载评论
	var url3="http://localhost:8081/readFile?filename=views/ejsTemplate/commentshowTmp.ejs";
	var url4="http://localhost:8080/springmvcDemo1/accessible/findGoodRate";
	var tmp = ajaxGet(url3,false);
	var response = ajaxGet(url4,false);
	var html1;
	console.log(response.data);
	if(response!=null){
		var status = response.meta.success;
		if(status){
			html1 = ejs.render(tmp,{"datas":response.data});
		}else{
			html1 = ejs.render(tmp,{"datas":null});
		}
	}
	$(".userAccessBox").html(html1);
	var obj = response.data;
	//设置好评率
	$(".goodRate").html((obj.goodRate*100)+"%");
	//设置综合评分的星星数量
	var starts="";
	var num = (obj.evtScore+obj.cleanScore+obj.ftScore+obj.serverScore)/4;
	for(var i =0;i<num;i++){
		starts=starts+"&#9733;";
	}
	$(".cpsiteSoreStart").html(starts);
	//填充评价人数
	$(".accPerons").html(obj.num);
	//设置进度条
	//设置环境指数进度条
	//计算进度条长度
	var evtLen = obj.evtScore/5;
	var cleanLen = obj.cleanScore/5;
	var ftLen = obj.ftScore/5;
	var serverScore = obj.serverScore/5;
	$(".evtScore").css("width",evtLen*100+"px");
	$(".cleanScore").css("width",cleanLen*100+"px");
	$(".ftScore").css("width",ftLen*100+"px");
	$(".serverScore").css("width",serverScore*100+"px");
	$(".evtNum").html(obj.evtScore+".0");
	$(".cleanNum").html(obj.cleanScore+".0");
	$(".ftNum").html(obj.ftScore+".0");
	$(".serverNum").html(obj.serverScore+".0");
//最外层ready
});
$(".bookBtn").click(function(){
	alert("fa");
});
$(function(){
	var navH = $(".middleNav").offset().top;
	$(window).scroll(function(){
		//获取滚动条的滑动距离
		var scroH = $(this).scrollTop();
		if(scroH>=navH){
		$(".middleNav").css({"position":"fixed","top":0});
		}else if(scroH<navH){
		$(".middleNav").css({"position":"static"});
		}
	})
})