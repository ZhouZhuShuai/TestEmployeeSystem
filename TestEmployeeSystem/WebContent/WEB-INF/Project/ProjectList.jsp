<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<title>项目信息</title>
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
							location.href = "pro?type=ShowAdd";
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

								location.href = ("pro?type=" + type + "&ids=" + ids);
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
											var name = $(this).children().eq(1)
													.text();
											$(this)
													.children()
													.eq(1)
													.html(
															"<input  type='text' style='width:50px' value='"+name+"' name='name'/>")

											

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
																
																

																var pro = {
																	id : id,
																	name : name,
																	
																}
																array.push(pro);

															})

											var str = JSON.stringify(array);
											str = str.replace(/{/g, "%7b");
											str = str.replace(/}/g, "%7d");
											if(array.length<=0){
												alert("请在页面上进行修改");
											}else{
												window.location.href = "pro?type=modify&pros="
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

					})
</script>
</head>
<body>
	<div id="main">
		<div style="text-align: center; margin-bottom: 20px">
			<a style="font-size: 20px">项目信息</a>
		</div>
		<div style="">
			<form action="pro" class="form-horizontal" role="form" method="post">
				<div>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="name"
							placeholder="请输入项目名称" value=${c.name }>
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
						<th>id</th>
						<th>项目名称</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="pro">
						<tr data-id="${pro.id }" class="shuangji">
							<td>${pro.id}</td>
							<td>${pro.name }</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
			<li  id="pre" ><a href="pro?ye=${p.ye-1}&name=${c.name}"  >上一页</a></li>
			<c:forEach begin="${p.beginYe }" end="${p.endYe }" varStatus="status">
			<li <c:if test="${p.ye==status.index}"> class="active"</c:if>><a 
			href="pro?ye=${status.index}&name=${c.name}">${status.index}</a></li>
			</c:forEach>
			<li id="next"><a href="pro?ye=${p.ye+1 }&name=${c.name}" >下一页</a></li>
		</ul>
		<div style="clear:left">
			<button id="zengjia" type="button" class="btn btn-default">增加</button>
			<button id="modify" type="button" class="btn btn-default">修改</button>
			<button id="delete" type="button" class="btn btn-default">删除</button>
			</div>
		</div>
	</div>
</body>
</html>