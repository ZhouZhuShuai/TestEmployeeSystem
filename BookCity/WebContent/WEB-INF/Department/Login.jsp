<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
		<script type="text/javascript">
		$().ready(function(){
			$("#zhuce").click(function(){
				location.href="ShowZhuCe.do"
			})
		})
		
		</script>
		<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" rel="stylesheet" />
		
		<style type="text/css">
			*{
				padding: 0;
				margin: 0;
			}
			.logo{
				position: relative;
				width: 350px;
				height: 100px;
				left: 20%;
				
			}
			.zhongbubeijing{
				position: relative;
				height: 600px;
				
				
				
			}
			.T1{
				margin-left: 20%;
				float: left;
				margin-top: 20px;
			
				
			}
			.denglv{
				    
					width: 500px;
					height: 550px;
					background: #FFFFFF;
					position: absolute;		
				left: 60%;
					top: 20px;
					
			}
			.zhanghudenglu{
				margin-left:30%;
				margin-top: 15%;
				font-size: 30px;
				border: 1px solid red;
				
				width:150px;
				text-align: center;
				font-weight: 300;
				color: red;	
					border-radius: 20px;			
			
			}
			.yonghuming1{
				border: 1px solid #DCDCDC;
				margin-top: 60px;
				width: 427px;
				margin-left: 30px;
			}
			.yonghuming2{
				float: left;
				height: 40px;
				
			}
			.yonghuming3{
				float: right;
				width: 380px;
				height: 35px;
			}
			.quedingdenglu{
				margin-left:20%;
				margin-top: 15%;
				font-size: 30px;
				border: 1px solid red;
					border-radius: 20px;
				width:300px;
				text-align: center;
				font-weight: 300;
				color: red;		
				cursor: pointer;	
			
			}
			.zhuce{
				margin-left: 80%;
				margin-top: 20%;
				color: red;
				cursor: pointer;
			}
			
		</style>
	</head>
	<body>
		<input type="image" src="<%=request.getContextPath()%>/picture/dengluLoGo.png"  class="logo"/>
		
		
		
		<div class="zhongbubeijing">
			<input type="image" src="<%=request.getContextPath()%>/picture/jingdongEka.jpg" class="T1"/>
			<div class="denglv">
				<form action="Dologin.do"   method="post" >
				<p class="zhanghudenglu">账户登录</p>
				<div class="yonghuming1">
					<input type="image" class="yonghuming2"src="<%=request.getContextPath()%>/picture/xiaoren.png" />
					<input class="yonghuming3" type="text" name="username" placeholder="邮箱/用户名/以验证手机"value="" style="color: #DCDCDC;"/>
				</div>
				
				<div class="yonghuming1">
					<input type="image" class="yonghuming2"src="<%=request.getContextPath()%>/picture/suo.png" />
					<input class="yonghuming3" type="text" name="password" placeholder="请输入密码哦"value="" style="color: #DCDCDC;"/>
				</div>
				<div>${mes }</div>
				
				<!-- <p class="quedingdenglu">确定登录</p> -->
				<input type="submit" class="quedingdenglu"  value="确定登录"/>
				<p class="zhuce"><a id="zhuce" style="color: red;text-decoration: none;">立即注册</a> </p>
				</form>
			</div>
		</div>
		
		<input type="image" src="<%=request.getContextPath()%>/picture/zuidibu.png" style="margin-left: 10%;"/>
		
		
		
		
		
	</body>
</html>
