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
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		var proLeft = $("#pro").offset().left;
		var proTop = $("#pro").offset().top;
		var proWidth = parseFloat($("#pro").css("width"));
		var proHeight =parseFloat( $("#pro").css("height"));
		var noProLeft = $("#noPro").offset().left;
		var noProTop = $("#noPro").offset().top;
		var noProWidth = parseFloat($("#noPro").css("width"));
		var noProHeight =parseFloat( $("#noPro").css("height"));
		var topStart;
		var leftStart;
		$( ".pro" ).draggable({
		      start: function() {
		       topStart = $(this).offset().top;
		       leftStart =  $(this).offset().left;
		        },
		        drag: function() {
		         
		        },
		        stop: function() {
		        	var stopLeft =  $(this).offset().left;
		        	var stopTop = $(this).offset().top;
		        	if(stopLeft>=proLeft&&stopLeft<=proLeft+proWidth&&stopTop>=proTop&&stopTop<=proTop+proHeight){
		        		var proIds = $(this).data("id");
		        		var pro = $(this);
		        		$.ajax({
		    				url:"dep",
		    				type:"post",
		    				data:{type:"add_project3",id:${dep.id},proIds:proIds}, 
		    				dataType:"text",
		    				success:function(data){
		    					if(data=="true"){
		    						pro.css("position","static");
			    					$("#pro").append(pro);
			    					pro.css("position","relative");
			    					pro.css("left","0");
			    					pro.css("top","0");
		    					}
		    					
		    					

		    					
		    				}
		    			})
		        	}
		        	else if(stopLeft>=noProLeft&&stopLeft<=noProLeft+noProWidth&&stopTop>=noProTop&&stopTop<=noProTop+noProHeight){
		        		var proIds = $(this).data("id");
		        		var pro = $(this);
		        		$.ajax({
		    				url:"dep",
		    				type:"post",
		    				data:{type:"delete_project3",id:${dep.id},proIds:proIds}, 
		    				dataType:"text",
		    				success:function(data){
		    					if(data=="true"){
		    						pro.css("position","static");
			    					$("#noPro").append(pro);
			    					pro.css("position","relative");
			    					pro.css("left","0");
			    					pro.css("top","0");
		    					}
		    					
		    					

		    					
		    				}
		    			})
		        	}
		        	else{
		        		$(this).offset({left:leftStart,top:topStart});
		        	}
		        
		        }
		      });
	/* 	$( "#pro" ).find(".pro").draggable({
		      start: function() {
		       topStart = $(this).offset().top;
		       leftStart =  $(this).offset().left;
		        },
		        drag: function() {
		         
		        },
		        stop: function() {
		        	var stopLeft =  $(this).offset().left;
		        	var stopTop = $(this).offset().top;
		        	if(stopLeft>=noProLeft&&stopLeft<=noProLeft+noProWidth&&stopTop>=noProTop&&stopTop<=noProTop+noProHeight){
		        		var proIds = $(this).data("id");
		        		var pro = $(this);
		        		$.ajax({
		    				url:"dep",
		    				type:"post",
		    				data:{type:"delete_project3",id:${dep.id},proIds:proIds}, 
		    				dataType:"text",
		    				success:function(data){
		    					if(data=="true"){
		    						pro.css("position","static");
			    					$("#noPro").append(pro);
			    					pro.css("position","relative");
			    					pro.css("left","0");
			    					pro.css("top","0");
		    					}
		    					
		    					

		    					
		    				}
		    			})
		        	}else{
		        		$(this).offset({left:leftStart,top:topStart});
		        	}
		        
		        }
		      }); */

		var proId = -1;
	$(".pro").click(function(){
		$(this).toggleClass("select");
		proId = $(".select").data("id");
	})
	$("#zengjia").click(function(){
		
		if($("#noPro").find(".select").length>0){
			var proIds="";
			$("#noPro").find(".select").each(function(index,element){
				proIds += $(this).data("id")+",";
			})
			proIds = proIds.substring(0,proIds.length-1);
			
			
			$.ajax({
				url:"dep",
				type:"post",
				data:{type:"add_project3",id:${dep.id},proIds:proIds}, 
				dataType:"text",
				success:function(data){
					if(data=="true"){
						var pro = $("#noPro").find(".select");
						$("#pro").append(pro);
						pro.removeClass("select");
						
					}
				}
			})
	
		}else{
			alert("请选择数据");
		}
	})
	
	$("#delete").click(function(){
		if($("#pro").find(".select").length>0){
			var proIds="";
			$("#pro").find(".select").each(function(index,element){
				proIds += $(this).data("id")+",";
			})
			proIds = proIds.substring(0,proIds.length-1);
			
			
			$.ajax({
				url:"dep",
				type:"post",
				data:{type:"delete_project3",id:${dep.id},proIds:proIds}, 
				dataType:"text",
				success:function(data){
					if(data=="true"){
						var pro = $("#pro").find(".select");
						$("#noPro").append(pro);
						pro.removeClass("select");
						
					}
				}
			})
			
			
			
			
		}else{
			alert("请选择数据");
		}
	})
	
	
	})
</script>
<style type="text/css">
*{
padding: 0


}
#main {
	width: 800px;
	margin: 20px auto;
	
}

#pro, #noPro {
	width: 700px;
	height: 200px;
	border: 1px solid red;
	border-radius: 10px
}
#btn{
margin:10px	;	
	width: 700px;

	

text-align: center;
}
#zengjia,#delete{
margin-right: 20px;
}
.pro{
border: 1px solid red;
height:30px;
margin-left:20px;
margin-top:20px;
text-align: center;
line-height: 30px;
color:black;
float:left;
border-radius: 10px;
padding: 0 10px;

}
.select{
color:#fff;
background: red;


}
</style>
<title>部门项目管理</title>
</head>
<body>

	<div id="main">
		<h2>${dep.name }</h2>
		<div id="pro">
		<c:forEach items="${list }" var="pro">
		<div class="pro" data-id="${pro.id }">${pro.name }</div>
		
		</c:forEach>
		
		</div>
		
		<div id="btn">
			<button id="zengjia" type="button" class="btn btn-default">上移</button>
			<button id="delete" type="button" class="btn btn-default">下移</button>

		</div>
		<div id="noPro">
		<c:forEach items="${proList }" var="pro">
		<div class="pro" data-id="${pro.id }">${pro.name }</div>
		
		</c:forEach>
		</div>



	</div>
</body>
</html>