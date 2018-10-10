<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#GouWuChe").click(function(){
			location.href ="ShowGoWuChe.do";
			
			
		})
		
		
	})
	
	
</script>



</script>
</head>
<body>
	添加购物车成功！！
	<div>
		<input type="button " value="我的购物车" id="GouWuChe">
	</div>
</body>
</html>