<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<style type="text/css">
#main {
	width: 800px;
	margin: 20px auto;
}

#emp td {
	width: 200px
}

#emp .select {
	background: #ccc
}

.sousuo_ul_li {
	float: left;
	list-style: none;
	margin-left: 20px
}

.sousuo_ul {
	margin-left: -56px
}

#emp img {
	width: 20px;
	height: 20px;
}

#bigPhoto {
	display: none;
	position: absolute;
}

#bigPhoto img {
	width: 100px;
	height: 100px;
}
</style>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<title>员工信息</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {
						$("tr").click(function() {

							$(this).toggleClass("select");
							//id = $(this).children().eq(0).html();
							id = $(this).data("id");

						})
						var id = -1;

						$("#zengjia").click(function() {
							location.href = "emp?type=zengjia";
						})
						
						$("#zengjia2").click(function() {
							location.href = "emp?type=zengjia2";
						})
						$("#showModify")
								.click(
										function() {
											if (id <= -1) {
												alert("请先选中员工！");
											} else {
												location.href = ("emp?type=showModify&id=" + id);
											}
										})
						$("#delete").click(function() {
							if (id <= -1) {
								alert("请先选中员工！");
							} else {
								location.href = ("emp?type=delete&id=" + id);
							}
						})

						function doBatch(type) {
							var length = $("#emp .select").length;
							//var ids="";
							var ids = new Array();
							if (length <= 0) {
								alert("请先选中员工！");
							} else {
								$("#emp .select").each(
										function(index, element) {
											//ids += $(this).data("id")+",";
											ids.push($(this).data("id"));

										})
								//ids = ids.substring(0,ids.length-1);

								location.href = ("emp?type=" + type + "&ids=" + ids);
							}
						}

						$("#deleteBatch").click(function() {
							doBatch("deleteBatch");
						})

						$("#showModifyBatch1").click(function() {
							doBatch("showModifyBatch1");
						})
						$("#showModifyBatch2").click(function() {
							doBatch("showModifyBatch2");
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

											var sex = $(this).children().eq(1)
													.text();
											if (sex == "男") {
												$(this)
														.children()
														.eq(1)
														.html(
																"<select style='width:50px' name='sex'><option selected value='男'>男</option><option value='女'>女</option></select>")
											} else {
												$(this)
														.children()
														.eq(1)
														.html(
																"<select style='width:50px' name='sex'><option value='男'>男</option><option selected value='女'>女</option></select>")
											}

											var age = $(this).children().eq(2)
													.text();
											$(this)
													.children()
													.eq(2)
													.html(
															"<input  type='text' style='width:50px' name='age' value='"+age+"'/>")

										})
						$("#ModifyBatch3")
								.click(
										function() {
											var emps = "";
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
																var sex = $(
																		this)
																		.find(
																				"[name=sex ]")
																		.val();
																var age = $(
																		this)
																		.find(
																				"[name=age]")
																		.val();

																var emp = {
																	id : id,
																	name : name,
																	sex : sex,
																	age : age
																}
																array.push(emp);

															})

											var str = JSON.stringify(array);
											str = str.replace(/{/g, "%7b");
											str = str.replace(/}/g, "%7d");
											if(array.length<=0){
												alert("请在页面上进行修改");
											}else{
												window.location.href = "emp?type=modifyBatch3&emps="
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
						$("#emp img").hover(function(event){
							var photo = $(this).attr("src");
							$("#bigPhoto img").attr("src",photo);
							$("#bigPhoto ").show();
							$("#bigPhoto ").css({left:event.pageX+20,top:event.pageY+20})
						},function(){
							$("#bigPhoto ").hide();
						})
						/* $("#search").click(function(){
							var array = new Array();

						var name=$(".sousuo_ul_li").find("[name=name]").val();
						var sex=$(".sousuo_ul_li").find("[name=sex]").val();
						var age=$(".sousuo_ul_li").find("[name=age]").val();
						 var emp={
								 name:name,
								 sex:sex,
								 age:age
						 }
						 array.push(emp);
						 var str = JSON.stringify(array);
							str = str.replace(/{/g, "%7b");
							str = str.replace(/}/g, "%7d");

							window.location.href = "emp?type=search&emp="
									+ str;
						
						}) */

					})
</script>
</head>
<body>

	<div id="main">
		<div style="text-align: center; margin-bottom: 20px">
			<a style="font-size: 20px">员工信息</a>
		</div>
		<div style="">
			<form action="emp" class="form-horizontal" role="form" method="post">
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
							value=${c.age!=-1?c.age:""}>
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
					<!-- <th><form action="emp" method="post" enctype="multipart/form-data">
					<input type="file" value ="选择头像" name="userfile"     />
					<input type="submit" value="提交"   />
					
					
					</form>
					</th> -->


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
						<td><c:if test="${not empty emp.photo  }">
								<img src="picture/${emp.photo }" />
							</c:if></td>
					</tr>

				</c:forEach>
			</tbody>

		</table>
		<ul class="pagination">
			<li><a
				href="emp?ye=1&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""} "  >首页</a></li>

			<li id="pre"><a
				href="emp?ye=${p.ye-1}&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""} "  >上一页</a></li>
			<c:forEach begin="${p.beginYe }" end="${p.endYe }" varStatus="status">
				<li <c:if test="${p.ye==status.index}"> class="active"</c:if>><a
					href="emp?ye=${status.index}&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""}">${status.index}</a></li>
			</c:forEach>
			<li id="next"><a
				href="emp?ye=${p.ye+1 }&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""}">下一页</a></li>
			<li><a
				href="emp?ye=${p.maxYe }&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""} "  >尾页</a></li>

		</ul>

		<div style="clear: left">
			<button id="zengjia" type="button" class="btn btn-default">增加</button>
			<button id="zengjia2" type="button" class="btn btn-default">增加2</button>

			<button id="showModify" type="button" class="btn btn-default">修改</button>
			<button id="delete" type="button" class="btn btn-default">删除</button>
			<button id="showModifyBatch1" type="button" class="btn btn-default">批量修改1</button>
			<button id="showModifyBatch2" type="button" class="btn btn-default">批量修改2</button>
			<button id="deleteBatch" type="button" class="btn btn-default">批量删除</button>
			<button id="ModifyBatch3" type="button" class="btn btn-default">当前页面修改</button>

		</div>

	</div>
	<div id="bigPhoto">
		<img src="" />
	</div>


</body>
</html>