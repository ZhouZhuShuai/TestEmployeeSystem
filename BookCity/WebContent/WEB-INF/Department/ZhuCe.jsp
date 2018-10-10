<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			*{
				padding: 0;
				margin: 0;
			}
			.p{
			margin-left: 1200px;
		float: left;
			}
			.qingdenglu{
				color: red;
				cursor: pointer;
			}
			.zhongbu{
				position: relative;
			
				height: 500px;
			}
			.xuanxiang{
				position: absolute;
				margin-left: 600px;
				margin-top: 50px;
				
				
			}
			.xuanxiang_li{
				list-style: none;
				margin-top: 20px;
				font-size: 30px;
				font-weight: 200;
				
			}
			
		</style>
		<script type="text/jscript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
		<script>
			$().ready(function() {
					function show(mes) {
				$("#message").html(mes);
						setTimeout(function() {
							$("#message").html("");
						}, 1000);

					}
				$("form").submit(function() {
		

					if($("#email").val() == "") {
						show("邮箱不能为空");
						
						return false;
					}

					var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
					if(!reg.test($("#email").val())) {
						alert("邮箱格式不对");
						return false;
					}

					var reg1 = /(1[3-9]\d{9}$)/;
					if(!reg1.test($("#phone").val())) {
						alert("手机格式不对");
						return false;
					}

					if($("#password1").val() == "") {
						alert("密码不能为空");
						return false;
					}
					if($("#password1").val().length < 6 || $("#password1").val().length > 16) {
						alert("密码长度必须为6-16位");
						return false;
					}

					if($("#password1").val() != $("#confirm").val()) {
						alert("两次输入的密码不一致");
						return false;
					}
					var reg3 = /^[\u4E00-\u9FA5]{2,4}$/;
					if(!reg3.test($("#name").val())) {
						alert("名字必须2-4中文");
						return false;
					}

				})
				
				$("#login").click(function(){
					location.href="ShowLogin.do";
				})

			})
		</script>
	</head>
	<body>
		<input type="image" src="<%=request.getContextPath() %>/picture/zhuce.png"  class="logo" style="margin-left: 13%;"/>
		<p class="p">已有账号？</p>
		<p class="qingdenglu"><a id="login" style="color: red; text-decoration: none;">请登录 ></a> </p>
		<div class="zhongbu">
			<div class="xuanxiang">
		<form action="DengLu.html">
			
				<ul>
				<li class="xuanxiang_li"><div style="width: 500px;"><label>邮箱</label>
			<input type="text" id="email" style="font-size: 30px;"/><br /></div></li>
			<li class="xuanxiang_li"><div ><label>手机</label>
			<input type="text" id="phone" style="font-size: 30px;"/><br /></div></li>
			<li class="xuanxiang_li"><label>密码</label>
			<input type="text" id="password1" style="font-size: 30px;" /><br /></li>
			<li class="xuanxiang_li"><label>确认密码</label>
			<input type="password" id="confirm" style="font-size: 30px;"/><br /></li>
			<li class="xuanxiang_li"><label>姓名</label>
			<input type="text" id="name" style="font-size: 30px;"/><br /></li>
			<li class="xuanxiang_li"><input type="submit" value="提交" id="d5" style="font-size: 30px;width: 100px; margin-left: 42%;color: black;font-weight: 200; background: #FFFFFF;"/>
			<div id="message"></div></li>
			
			</ul>
			
			

		</form>
		
	</div>
		
		</div>
	
<input type="image" src="<%=request.getContextPath() %>/picture/zuidibu.png" style="margin-left: 13%;"/>
		
		
		
	</body>
</html>
