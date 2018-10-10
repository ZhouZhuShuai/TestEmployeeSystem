<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<title>部门信息</title>
<style type="text/css">
#main {
	width: 600px;
	margin: 20px auto;
}

#dep .select {
	background: #ccc;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {
						var id = -1;
						$("#zengjia").click(function() {
							location.href = "dep?type=ShowAdd";
						})
						$("tr").click(function() {
							$(this).toggleClass("select");
							id = $(this).data("id");
						})
						function xuanID(type) {
							var length = $("#dep .select").length;
							//var ids="";
							var ids = new Array();
							if (length <= 0) {
								alert("请先选中员工！");
							} else {
								$("#dep .select").each(
										function(index, element) {
											//ids += $(this).data("id")+",";
											ids.push($(this).data("id"));

										})
								//ids = ids.substring(0,ids.length-1);

								location.href = ("dep?type=" + type + "&ids=" + ids);
							}
						}

						$("#delete").click(function() {
							xuanID("delete");

						})
						$(".shuangji")
								.dblclick(
										function() {
											$(this).unbind("dblclick");
											$(this).unbind("click");
											$(this).addClass("shuangjitd")
											var name = $(this).children().eq(0)
													.text();
											$(this)
													.children()
													.eq(0)
													.html(
															"<input  type='text' style='width:50px' value='"+name+"' name='name'/>")

											var empCount = $(this).children()
													.eq(1).text();
											$(this)
													.children()
													.eq(1)
													.html(
															"<input  type='text' style='width:50px' name='empCount' value='"+empCount+"'/>")

										})
						$("#modify")
								.click(
										function() {
											
											var array = new Array();
											$(".shuangjitd")
													.each(
															function(index,
																	element) {
																var id = $(this)
																		.data(
																				"id");
																var name = $(
																		this)
																		.find(
																				"[name=name]")
																		.val();
																
																var empCount= $(
																		this)
																		.find(
																				"[name=empCount]")
																		.val();

																var dep = {
																	id : id,
																	name : name,
																	empCount:empCount
																}
																array.push(dep);

															})

											var str = JSON.stringify(array);
											str = str.replace(/{/g, "%7b");
											str = str.replace(/}/g, "%7d");
											if(array.length<=0){
												alert("请在页面上进行修改");
											}else{
												window.location.href = "dep?type=modify&deps="
													+ str;
											}
											

										})
										if(${p.ye}<=1){
											$("#pre").addClass("disabled");
											$("#pre").find("a").attr("onclick","return false");
										}
						if(${p.ye}>=${p.maxYe}){
							$("#next").addClass("disabled");
							$("#next").find("a").attr("onclick","return false");
						}
						$("#project_guanli").click(function(){
							if(id<=-1){
								alert("请先选中部门")
							}else{
								location.href="dep?type=project_guanli&id="+id;

							}
							
						})
							$("#project_guanli2").click(function(){
							if(id<=-1){
								alert("请先选中部门")
							}else{
								location.href="dep?type=project_guanli2&id="+id;

							}
							
						})
								$("#project_guanli3").click(function(){
							if(id<=-1){
								alert("请先选中部门")
							}else{
								location.href="dep?type=project_guanli3&id="+id;

							}
							
						})
						
						

					})
</script>
</head>
<body>
	<div id="main">
		<div style="text-align: center; margin-bottom: 20px">
			<a style="font-size: 20px">部门信息</a>
		</div>
		<div style="">
			<form action="dep" class="form-horizontal" role="form" method="post">
				<div>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="name"
							placeholder="请输入部门名称" value=${c.name }>
					</div>
				</div>


				<div>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="empCount"
							placeholder="请输入部门员工数" value=${c.empCount!=-1?c.empCount:""}>
					</div>
				</div>

				<div class="form-group">
					<div class=" col-sm-4">
						<button type="submit" class="btn btn-primary">搜索</button>
					</div>
				</div>
			</form>
		</div>

		<div>
			<table class="table  table-bordered table-hover" id="dep">
				<thead>
					<tr>
						<th>部门名称</th>
						<th>员工人数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dep">
						<tr data-id="${dep.id }" class="shuangji">
							<td>${dep.name }</td>
							<td><a href="emp?depId=${dep.id }">${dep.empCount }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<li id="pre"><a
					href="dep?ye=${p.ye-1}&name=${c.name}&empCount=${c.empCount!=-1?c.empCount:""}"  >上一页</a></li>
				<c:forEach begin="${p.beginYe }" end="${p.endYe }"
					varStatus="status">
					<li <c:if test="${p.ye==status.index}"> class="active"</c:if>><a
						href="dep?ye=${status.index}&name=${c.name}&empCount=${c.empCount!=-1?c.empCount:""}">${status.index}</a></li>
				</c:forEach>
				<li id="next"><a
					href="dep?ye=${p.ye+1 }&name=${c.name}&empCount=${c.empCount!=-1?c.empCount:""}" >下一页</a></li>
			</ul>
			<div style="clear: left">
				<button id="zengjia" type="button" class="btn btn-default">增加</button>
				<button id="modify" type="button" class="btn btn-default">修改</button>
				<button id="delete" type="button" class="btn btn-default">删除</button>
				<button id="project_guanli" type="button" class="btn btn-default">项目管理</button>
				<button id="project_guanli2" type="button" class="btn btn-default">项目管理2</button>
				<button id="project_guanli3" type="button" class="btn btn-default">项目管理3</button>

			</div>
		</div>
	</div>
</body>
</html>