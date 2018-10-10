<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
 $().ready(function(){
	var selectId = -1;
	 $("#zengjia").click(function(){
	var proId = $("#selectPro").val();
	var i = 0;
			//location.href = ("dep?type=add_project&id=${dep.id}&proId=" +proId);
			$.ajax({
				url:"dep",
				type:"post",
				data:{type:"add_project2",id:${dep.id},proId:proId}, 
				dataType:"text",
				success:function(data){
					if(data=="true"){
						var proName="";
						$("#selectPro").children().each(function(index,element){
							if($(this).val()==proId){
							proName=$(this).text();
							i = index;
							}
						})
						var tr = "<tr><td>"+proId+"</td><td>"+proName+" </td></tr>"
						$("#pro").append(tr);
						$("#selectPro").children().eq(i).remove();
						if($("#selectPro").children().length==0){
							$("#zengjia").unbind("click");
							 $("#zengjia").addClass("disabled"); 
						}
					}
					
				}
				
				
			})
	}) 
	/* <c:if test="${f:length(proList)==0}">
	$("#zengjia").unbind("click");
	$("#zengjia").addClass("disable");
	
	</c:if> */
	
	
	$(document).on("click","tr",function(){
		$(this).toggleClass("select");
		
		selectId = $(".select").children().eq(0).text();
		
	})
	 $("#delete").click(function(){
		
		 if(selectId>-1){
			//var proId =selectId;
			var i = 0;
					//location.href = ("dep?type=add_project&id=${dep.id}&proId=" +proId);
					$.ajax({
						url:"dep",
						type:"post",
						data:{type:"delete_project2",id:${dep.id},proId:selectId}, 
						dataType:"text",
						success:function(data){
							if(data=="true"){
								var proName="";
								$("tr").each(function(index,element){
									if($(this).children().eq(0).text()==selectId){
									proName=$(this).children().eq(1).text();
									i = index;
									}
								})
								var option = "<option value ='"+selectId+"'>"+proName+"</option>";
								$("#selectPro").append(option);
								$("tr").eq(i).remove();
							
							}
							
						}
						
						
					})
		 }
			}) 
	
	
})

 

</script>
<style type="text/css">
#main {
	width: 600px;
	margin: 20px auto;
}

#pro .select {
	background: #ccc;
}
</style>
<title>部门项目管理</title>
</head>
<body>
	<div id="main">

		<div>

			<h3>${dep.name }</h3>
			<table class="table  table-bordered table-hover" id="pro">
				<thead>
					<tr>
						<th>id</th>
						<th>项目名称</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="pro">
						<tr data-id="${pro.id }">
							<td>${pro.id }</td>
							<td>${pro.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- <input type="hidden" name="type" value="add_project" /> -->
		<%-- 		<input type="hidden" name="id" value=${id }   /> --%>
		<div style="float: left; margin-right: 20px">

			<select class="form-control" name="proId" style="width: 180px"
				id="selectPro">
				<c:forEach items="${proList}" var="pro2">
					<option value='${pro2.id}'>${pro2.name}</option>
				</c:forEach>
			</select>
		</div>

		<button id="zengjia" type="button" class="btn btn-default">增加</button>
		<button id="delete" type="button" class="btn btn-default">删除</button>



	</div>
</body>
</html>