<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

#main {
	
}

#left {
	width:250px;
	height: 600px;
	float: left;
	padding-left: 50px;
	
}

#right {
	width: 1000px;
	height: 600px;
}

#top {
	clear: both;
	height: 50px;
	background: #ccc;
	height: 50px;
}

#bottom {
	clear: both;
	height: 100px;
	background: #ccc;
}

.yi {
	width: 160px;
	height: 40px;
	background: #ccc;
	border-radius: 5px;
	line-height: 40px;
	text-align: center;
	margin-top: 10px;
}

a {
	color: black;
	text-decoration: none;
}
.er{
list-style: none;
margin-left: 50px;


width:80px;
}
.er li{
margin-top:5px;
background: #ccc;
text-align: center;
border-radius: 5px
}
.er a{

}
#fangwenliang{
line-height: 50px;
text-align: center;
color: #337ab7;

}
</style>


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript"> 
var websocket = null;

//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
	websocket = new WebSocket("ws://192.168.0.104:8080/test07/websocket");
} else {
	alert('没有建立websocket连接')
}

//连接发生错误的回调方法
websocket.onerror = function() {
	//setMessage("错误");
};

//连接成功建立的回调方法
websocket.onopen = function(event) {
	//setMessage("建立连接");
}

//接收到消息的回调方法
websocket.onmessage = function(event) {
	//setMessage(event.data);
	$("#fangwenliang").html("本网站共有"+event.data+"人访问呦");
}

//连接关闭的回调方法
websocket.onclose = function() {
	//setMessage("close");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口。
window.onbeforeunload = function() {
	websocket.close();
}

/* //将消息显示在网页上
function setMessage(text) {
	var message = $("#mes").html();
	$("#mes").html(message + text + "<br/>")
} */

//关闭连接
function closeWebSocket() {
	websocket.close();
}

/* //发送消息
function send() {
	var message = $("#text").val();
	websocket.send(message);
} */
$().ready(function(){
	$(".yi").click(function(){
		$(this).next().slideToggle(500);
	})
	
})


</script>

</head>
<body>
	<div id="container">
		<div id="top"> 
		<div id="fangwenliang">目前为止本网站共有 <%=application.getAttribute("num") %>人访问</div>
		</div>
		<div id="main">
			<div id="left">
				<div class="yi">
					员工管理
					
				</div>
				<ul class="er">
					<li><a href="emp" target="right">员工管理</a></li>
					<li><a href="emp?type=zengjia" target="right">员工添加</a></li>

				</ul>
				
				

				<div class="yi">
					部门管理
				</div>
				<ul class="er">
					<li><a href="dep" target="right">部门管理</a></li>
					<li><a href="dep?type=ShowAdd" target="right">部门添加</a></li>

				</ul>
				<div class="yi">
					项目管理
				</div>
				<ul class="er">
					<li><a href="pro" target="right">项目管理</a></li>
					<li><a href="pro?type=ShowAdd" target="right">项目添加</a></li>

				</ul>
				<div class="yi">绩效管理</div>
				<ul class="er">
					<li><a href="score" target="right">绩效展示</a></li>
					<li><a href="score?type=manage" target="right">绩效管理</a></li>

				</ul>
			</div>
			<iframe id="right" name="right" scrolling="no" frameborder="0"
				src="emp"></iframe>
		</div>
		<div id="bottom"></div>
	</div>



</body>
</html>