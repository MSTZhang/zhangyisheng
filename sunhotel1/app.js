var express = require("express");
var app = express();
var path = require('path');
var http=require("http");
var session = require('express-session');
var cookieParser = require('cookie-parser');
app.use(cookieParser('sessiontest'));
app.use(session({
    secret: 'sessiontest',//与cookieParser中的一致
    resave: true,
    saveUninitialized:true
}));
app.use(express.static(path.join(__dirname, 'public')))
app.set('views', path.join(__dirname, 'views'));
app.engine("html",require("ejs").__express); // or   app.engine("html",require("ejs").renderFile);
app.set("view engine","ejs");
//app.set('view engine', 'html');
/*******************************************************************************/
app.post("/user_login",function(req,res){
    var pars = req.params;
    var options={"host":"localhost","port":8080,"path":"/springmvcDemo1/index","method":"post"};
    var requestServer=http.request(options,function(reqServer,respServer){
        reqServer.setEncoding("utf-8");
        reqServer.on("data",function(chunk){
            res.writeHead(200,{"Content-Type": "application/json"});
            res.write(chunk);
            console.log(chunk);
            res.end();
        });
        
    });
    requestServer.end();
});
/*********************************************************************************/
app.get("/index",function(req,resp){
    //resp.sendFile("");
    var data = {data:null};
    resp.render("foreSystem/index",data);
});
//读取模板文件
app.get("/readFile",function(req,resp){
    var fileName =req.param("filename");
    resp.sendfile(fileName);
});
//个人中心跳转
app.get("/home",function(req,resp){
    resp.render("foreSystem/home");
});
//我的信息跳转
app.get("/personInfo",function(req,resp){
    resp.render("foreSystem/personInfo");
});
//我的钱包跳转
app.get("/wallet",function(req,resp){
    resp.render("foreSystem/wallet");
});
//我的点评跳转
app.get("/evaluate",function(req,res){
    console.log("我的点评");
    res.render("foreSystem/evaluate");
});
//跳转到点评页面
app.get("/appraise",function(req,res){
    console.log(req.param("accNum"));
    res.render("foreSystem/appraise");
});
//跳转成功页面
app.get("/evaluateSuccess",function(req,res){
    res.render("evaluateSuccess");
});
//注册页面跳转
app.get("/register",function(req,res){
    res.render("foreSystem/register");
});
//登录页面请求跳转
app.get("/login",function(req,res){
    res.render("foreSystem/loginPage");
});
//跳转预定页面
app.get("/roomBook",function(req,resp){
    resp.render("foreSystem/roomBook");
});
//跳转到选房页面
app.get("/order",function(req,resp){
    resp.render("foreSystem/order");
});
//跳转订单页面
app.get("/bookPage",function(req,resp){
    var bookInfo=req.param("bookInfo");
    req.session.bookInfo=bookInfo;
    resp.render("foreSystem/bookPage");
});
//跳转预定成功页面orderSuccess
app.get("/orderSuccess",function(req,resp){
    resp.render("foreSystem/orderSuccess");
});
//跳转到支付成功页面
app.get("/applySuccess",function(req,resp){
    resp.render("applySuccess");
});
//跳转到支付界面
app.get("/applyPage",function(req,resp){
    resp.render("foreSystem/applyPage");
});
//获取预定信息
app.get("/getBookInfo",function(req,resp){
    bookInfo = req.session.bookInfo;
    resp.send(bookInfo);
    resp.end();
    console.log("session响应完毕");
});
//修改订单日期
app.post("/alterOdTm",function(req,resp){
    var s1 = req.param("chTime");
    var s2 = req.param("lvTime");
    var s3 = req.param("days");
    var bf = req.session.bookInfo;
    var jsonDate = JSON.parse(bf);
    jsonDate.checkTime = s1;
    jsonDate.endTime = s2;
    jsonDate.days=s3;
    var str1 = JSON.stringify(jsonDate);
    req.session.bookInfo = str1;
    resp.write("ok");
    resp.end();
});
app.get("/home_lastNews",function(req,resp){
    //构造json数据
    var jsonData={"datas":[{"newsId":1,"newsTitle":"国际高端酒店抢滩二三线市场","newsContent":"","subTime":"2018-03-09","author":"张先生"},{"newsId":1,"newsTitle":"国际高端酒店抢滩二三线市场","newsContent":"","subTime":"2018-03-09","author":"张先生"},{"newsId":1,"newsTitle":"国际高端酒店抢滩二三线市场","newsContent":"","subTime":"2018-03-09","author":"张先生"},{"newsId":1,"newsTitle":"国际高端酒店抢滩二三线市场","newsContent":"","subTime":"2018-03-09","author":"张先生"},{"newsId":1,"newsTitle":"国际高端酒店抢滩二三线市场","newsContent":"","subTime":"2018-03-09","author":"张先生"}]};
    //resp.writeHead(200,{"Content-Type": "application/json"});
    var str =JSON.stringify(jsonData);
    console.log("home请求到达");
    resp.write(str);
    resp.end();
    console.log("home请求响应完成");
});
app.get("/loadHouseTemplate",function(req,res){
    console.log("正在加载模板数据");
    res.render("ejsTemplate/houseList");
    console.log("加载完成");
});
/*********************************************************************************/
app.get("/testLay",function(req,resp){
    resp.render("error.ejs");
});
var server = app.listen(8081, function () {
    var host = server.address().address
    var port = server.address().port
    console.log("应用实例demo，访问地址为 http://%s:%s", host, port)
   
})
