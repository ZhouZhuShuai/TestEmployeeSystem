<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加员工</title>

<style type="text/css">
#main{
width:400px;
margin:20px auto;


}

</style>
</head>
<body>

<div id="main">
<form action="emp?type=add" class="form-horizontal" role="form" method="post" enctype="multipart/form-data">

	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">姓名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" 
				   placeholder="请输入名字">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">性别</label>
		<div class="col-sm-10">
			<input type="radio"   name="sex" checked value="男">男
			<input type="radio"   name="sex" value="女">女	   
		</div>
	</div>
	
<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">年龄</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="age"
				   placeholder="请输入年龄">
		</div>
	</div>
	<div class="form-group">
	<label for="firstname" class="col-sm-2 control-label">部门</label>
			<div class="col-sm-10">
			<select class="form-control" name="depId"><option  value="" selected>请选择部门</option>
			<c:forEach items="${depList}" var="dep">
			<option  value=${dep.id }  >${dep.name}</option>
			</c:forEach> 
			</select> 
			</div>
			  
		</div>
		<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">头像</label>
		<div class="col-sm-10">
			<input type="file" class="form-control" name="photo" >
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">保存</button>
		</div>
	</div>
</form>
</div>
</body>
</html>