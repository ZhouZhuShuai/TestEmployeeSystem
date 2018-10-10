<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批量修改员工</title>
<script type="text/javascript"   src="js/jquery.js"></script>
<script type="text/javascript">
$().ready(function(){
	$("#save").click(function(){
		var emps = "";
		$(".emp").each(function(index,element){
			 var id=$(this).find("[name=id]").val();
			 var name=$(this).find("[name=name]").val();
			 var sex=$(this).find("[name=sex ]:checked ").val();
			 var age=$(this).find("[name=age]").val();
			 emps += id +"," + name + "," + sex + "," + age +";";
		})
		emps = emps.substring(0,emps.length-1);
		window.location.href="emp?type=modifyBatch2&emps="+emps;
		
	})
	

})


</script>
<style type="text/css">
#main {
	width: 900px;
	margin: 20px auto;
	
	

}
.emp{
	width:400px;
	float:left;
	margin-right:50px;
	margin-top:50px;
	border: 1px dashed #ccc;
	padding:20px 20px 10px 0
	
}
 .baocun{
 clear:left; 
		text-align: center;
	
		
		
}  

</style>
</head>
<body>
	
	<div id="main">
	<c:forEach items="${ list}" var="emp">
		<form action="emp" class="form-horizontal emp" role="form" method="post">
			<input type="hidden" name="type" value="modifyBatch1" /> <input
				type="hidden" name="id" value="${emp.id }" />

			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						value="${emp.name }">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
					<input type="radio" name="sex" <c:if test="${emp.sex=='男' }">
						checked </c:if> value="男">男 <input type="radio" name="sex"
						<c:if test="${emp.sex=='女' }"> checked </c:if> value="女">女
				</div>
			</div>

			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="age"
						value="${emp.age }">
				</div>
			</div>

			
		</form>
		
		</c:forEach>
	<div class="baocun" > 
				
					<button id="save" type="submit" class="btn btn-primary">保存</button>
				
		 </div> 
	</div>
</body>
</html>