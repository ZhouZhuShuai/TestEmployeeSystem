<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet" />
<style type="text/css">
#main {
	width: 800px;
	margin: 20px auto;
}

#emp .select {
	background: #ccc
}

#emp img {
	width: 20px;
	height: 20px;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("tr").click(function() {

			$(this).toggleClass("select");
			//id = $(this).children().eq(0).html();
			id = $(this).data("id");

		})
		var id = -1;
		$("#zengjia").click(function() {
			location.href = "showadd.do";
		})
		$("#zengjia2").click(function() {
			location.href = "showadd2.do";
		})
		/* $("#zengjia3").click(function() {
			location.href = "showadd3.do";
		}) */
		$("#showModify").click(function() {
			if (id <= -1) {
				alert("请先选中员工！");
			} else {
				location.href = "showModify.do?id=" + id;

			}
		})
		$("#delete").click(function() {
			if (id <= -1) {
				alert("请先选中员工！");
			} else {
				location.href = "delete.do?id=" + id;

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

	})
</script>

</head>

<body>
			<div id="main">
	<div style="">
			<form action="search.do" class="form-horizontal" role="form" method="post">
				<div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="name"
							placeholder="请输入名字" value=${c.name }>
					</div>
				</div>
				<div>
					<div class="col-sm-3">
						<select class="form-control" name="sex"><option value=""
								selected>请选择性别</option>

							<option value="男" <c:if test="${c.sex =='男'}">selected</c:if>>男</option>
							<option value="女" <c:if test="${c.sex =='女'}">selected</c:if>>女</option>
						</select>
					</div>
				</div>

				<div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="age"
							style="width: 100px" placeholder="请输入年龄"
							value=${c.age }>
					</div>
				</div>
				<div>
					<div class="col-sm-3">
						<select class="form-control" name="depId"><option
								value="" selected>请选择部门</option>
							<c:forEach items="${depList}" var="dep">
								<option value=${dep.id }
									<c:if test="${dep.id ==c.dep.id}">selected</c:if>>${dep.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class=" col-sm-2">
						<button type="submit" class="btn btn-primary">搜索</button>
					</div>
				</div>
			</form>
		</div>
	
		<table class="table  table-bordered table-hover" id="emp">
			<thead>
				<tr>
					<!-- <th>id</th> -->
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>所在部门</th>
					<th>头像</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="emp">

					<tr data-id="${emp.id }" class="shuangji">
						<%-- <td><%=list.get(i).getId()%></td>  --%>
						<td>${emp.name }</td>
						<td>${emp.sex}</td>
						<td>${emp.age}</td>
						<td>${emp.dep.name}</td>
						<td><c:if test="${not empty emp.photo }">
								<img src="<%=request.getContextPath() %>/picture/${emp.photo }" />
							</c:if></td>

					</tr>

				</c:forEach>
			</tbody>

		</table>
		<ul class="pagination">
			<li><a
				href="search.do?ye=1&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age} "  >首页</a></li>

			<li id="pre"><a
				href="search.do?ye=${p.ye-1}&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age} "  >上一页</a></li>
			<c:forEach begin="${p.beginYe }" end="${p.endYe }" varStatus="status">
				<li <c:if test="${p.ye==status.index}"> class="active"</c:if>><a
					href="search.do?ye=${status.index}&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age}">${status.index}</a></li>
			</c:forEach>
			<li id="next"><a
				href="search.do?ye=${p.ye+1 }&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age}">下一页</a></li>
			<li><a
				href="search.do?ye=${p.maxYe }&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age} "  >尾页</a></li>

		</ul>
		
		
		<button id="zengjia" type="button" class="btn btn-default">增加</button>
		<button id="zengjia2" type="button" class="btn btn-default">增加2</button>
		<!-- <button id="zengjia3" type="button" class="btn btn-default">增加3</button> -->

		<button id="showModify" type="button" class="btn btn-default">修改</button>
		<button id="delete" type="button" class="btn btn-default">删除</button>

	</div>

</body>
</html>