<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" ></script>
<script src="js/jquery.js"></script>
<script>
/*  $().ready(function(){
	$("#image").click(function(){
		$(this).attr("src","Login?type=randomImage&"+Math.random())
	})
})  */

</script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<style type="text/css">
#main{
width:500px;
margin:200px auto;




}

</style>

</head>

<body>
<!-- <div style="width: 500px;height: 100px" >
<form action="Login" method="post">
<input type="hidden" name="type" value="doLogin"   />
<p style="float:left; margin-top: 5px"> 账号</p>
<input type="text" name="userName" style="float: left;">
<p style=" margin-top: 23px;float: left;margin-left: -192px"> 密码</p>
<input type="text" name="password" style="margin-top: 24px ; float:left; margin-left: -160px">
<input type="submit" value="登陆" style="float: left;margin-top: 50px ;margin-left: -190px">

</form>


</div> -->


<div id="main">
<form action="Login?type=zhuce2" class="form-horizontal" role="form" method="post">
<!-- <input type="hidden" name="type" value="doLogin"   /> -->
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">用户名</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" name="userName" 
				   placeholder="请输入用户名" >
		</div>
	</div>
	
	
<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" name="password"
				   placeholder="请输入密码">
		</div>
	</div>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" name="password2"
				   placeholder="请重新输入密码">
		</div>
	</div>
	
	<%-- <div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">验证码</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" name="random"
				   placeholder="请输入验证码">
		</div>
		<div calss="col-sm-4">
		<img id="image" src="Login?type=randomImage">
		</div>
	</div>
	
<div id="mes" style="height:40px;" > ${mes}</div> --%>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-10">
			<button type="submit" class="btn btn-primary">注册</button>
		</div>
	</div>
</form>
</div>


</body>
</html>