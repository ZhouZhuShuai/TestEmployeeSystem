<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />

<title>员工绩效</title>


<style type="text/css">
#main {
	width: 1000px;
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


}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	if(${p.ye}<=1){
		$("#pre").addClass("disabled");
		$("#pre").find("a").attr("onclick","return false");
	}
if(${p.ye}>=${p.maxYe}){
$("#next").addClass("disabled");
$("#next").find("a").attr("onclick","return false");
}

$("#emp input").blur(function(){
	var value = $(this).val();
	var empId=$(this).data("empid");
	var proId = $(this).data("proid");
	var scoreId = $(this).data("id");
	var a = $(this);
	$.ajax({
		url:"score",
		type:"post", 
		data:{
			type:"input",
			value:value,
			empId:empId,
			proId:proId,
			scoreId:scoreId
		},
       dataType:"json",
       success:function(data){
    	   a.parent().next().html(data.grade);
    	   a.data("id",data.id);
       }
	
	
		
	})
	
})

/* var id = -1;
$("tr").click(function() {

	$(this).toggleClass("select");
	//id = $(this).children().eq(0).html();
	id = $(this).data("id");

})  

$(".shuangji")
								.dblclick(
										function() {
											$(this).unbind("dblclick");
											$(this).unbind("click");
											$(this).addClass("shuangjitd")
											

											var value = $(this).children().eq(3)
													.text();
											$(this)
													.children()
													.eq(3)
													.html(
															"<input  type='text' style='width:50px' name='value' value='"+value+"'/>")

										})
										$("#baocun").click(function(){
											var emps = "";
											var array = new Array();
											$(".shuangjitd")
											.each(
													function(index,
															element) {
														var id = $(this)
																.data(
																		"id");
														
														var value = $(
																this)
																.find(
																		"[name=value]")
																.val();
														var emp = {
																id : id,
																value:value
																
																
															}
															array.push(emp);
														
													

													})
													var str = JSON.stringify(array);
											str = str.replace(/{/g, "%7b");
											str = str.replace(/}/g, "%7d");
													if(id<=-1){
														alert("请先双击修改员工")
													}else{
														window.location.href = "score?type=manage&type=baocun&score_value="
															+ str;
													}
											
											
										}) */
	
	

										

	
	
})




</script>


</head>
<body>
	<div id="main">
		<div style="text-align: center; margin-bottom: 20px">
			<a style="font-size: 20px">员工绩效</a>
		</div>
 		<div>
			<form action="score" class="form-horizontal" role="form" method="post">
				<div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="name"
							placeholder="请输入名字" value=${c.emp.name }>
					</div>
				</div>
				<div >
		<div class="col-sm-3">
			<select class="form-control" name="depId"><option  value="" selected>请选择部门</option>
			<c:forEach items="${depList}" var="dep">
			<option  value=${dep.id } <c:if test="${dep.id ==c.dep.id}">selected</c:if> >${dep.name}</option>
			</c:forEach> 
			</select>   
		</div>
	</div>
				<div >
		<div class="col-sm-3">
			<select class="form-control" name="proId"><option  value="" selected>请选择项目</option>
			<c:forEach items="${proList}" var="pro">
			<option  value=${pro.id } <c:if test="${pro.id ==c.pro.id}">selected</c:if> >${pro.name}</option>
			</c:forEach> 
			</select>   
		</div>
	</div>
				<div >
		<div class="col-sm-2">
			<input type="text" class="form-control" name="value" style="width:100px"
				   placeholder="请输入成绩"  value=${c.value!=-1?c.value:""}>
		</div>
	</div>
				<div>
					<div class="col-sm-3">
						<select class="form-control" name="grade"><option value=""
								selected>请选择等级</option>

							<option value="优秀" <c:if test="${c.grade =='优秀'}">selected</c:if>>优秀</option>
							<option value="良好" <c:if test="${c.grade =='良好'}">selected</c:if>>良好</option>
							<option value="一般" <c:if test="${c.grade =='一般'}">selected</c:if>>一般</option>
							<option value="及格" <c:if test="${c.grade =='及格'}">selected</c:if>>及格</option>
							<option value="不及格" <c:if test="${c.grade =='不及格'}">selected</c:if>>不及格</option>						
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
					 
					<th>姓名</th>
					<th>部门</th>
					<th>项目</th>
					<th>成绩</th>
					<th>等级</th>



				</tr>
			</thead>
			<tbody>
			 <c:forEach items="${list}" var="sco">

				<tr data-id="${sco.id }" class="shuangji">
				  
					<td>${sco.emp.name }</td>
					<td>${sco.dep.name}</td>
					<td>${sco.pro.name}</td>
					<td><input data-id="${sco.id }" data-empid="${sco.emp.id }"  data-proid="${sco.pro.id }" type = "text" value="${sco.value==0?"":sco.value}"/></td>
					<td>${sco.grade}</td>
				</tr>

				</c:forEach> 
			</tbody>

		</table>
		<ul class="pagination">
	<%-- <li   ><a href="score?type=manage&ye=1&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""} "  >首页</a></li> --%>
			<li   ><a href="score?type=manage&ye=1&name=${c.emp.name}&grade=${c.grade}&depId=${c.dep.id}&proId=${c.pro.id}&value=${c.value!=-1?c.value:""} "  >首页</a></li>
		
			<li  id="pre" ><a href="score?type=manage&ye=${p.ye-1}&name=${c.emp.name}&grade=${c.grade}&depId=${c.dep.id}&proId=${c.pro.id}&value=${c.value!=-1?c.value:""} "  >上一页</a></li>
			<c:forEach begin="${p.beginYe }" end="${p.endYe }" varStatus="status">
			<li <c:if test="${p.ye==status.index}"> class="active"</c:if>><a 
			href="score?type=manage&ye=${status.index}&name=${c.emp.name}&grade=${c.grade}&depId=${c.dep.id}&proId=${c.pro.id}&value=${c.value!=-1?c.value:""}">${status.index}</a></li>
			</c:forEach>
			<li id="next"><a href="score?type=manage&ye=${p.ye+1 }&name=${c.emp.name}&grade=${c.grade}&depId=${c.dep.id}&proId=${c.pro.id}&value=${c.value!=-1?c.value:""}">下一页</a></li>
	<%-- <li   ><a href="score?type=manage&ye=${p.maxYe }&name=${c.name}&sex=${c.sex}&depId=${c.dep.id}&age=${c.age!=-1?c.age:""} "  >尾页</a></li> --%>
			<li ><a href="score?type=manage&ye=${p.maxYe }&name=${c.emp.name}&grade=${c.grade}&depId=${c.dep.id}&proId=${c.pro.id}&value=${c.value!=-1?c.value:""}">尾页</a></li>
		
		</ul>
		
		
		
		<div style="clear:left">
			<button id="baocun" type="button" class="btn btn-default">保存</button>
			
			
		</div>



	</div>



</body>
</html>