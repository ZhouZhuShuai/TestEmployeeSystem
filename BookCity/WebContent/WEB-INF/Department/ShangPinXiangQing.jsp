<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
$().ready(function(){
	var shuliang = 1;
	$(".tupian_1").click(function(){
		var photo = $(this).attr("src");
		$(".shangpin_tupian").attr("src",photo);
	})
	$("#jia").click(function(){
		shuliang = shuliang + 1;
		/* $(".jiajian1").val(shuliang); */
		$(".jiajian1").attr("value",shuliang);
		
		
	})
	$("#jian").click(function(){
		shuliang = shuliang - 1;
		/* $(".jiajian1").val(shuliang); */
		$(".jiajian1").attr("value",shuliang);
		
	
	
		
	})
	/*  if(shuliang<=1){ 
		$("#jian").addClass("disabled");
		$("#jian").attr("disabled","disabled");
	}
	
	
if(shuliang>=${product.stock}){
$("#jia").addClass("disabled");
$("#jia").attr("disabled","disabled");
}  */
	$(".hao_wenzi").click(function(){
		var product_id = $(this).data("id");
		var count = $(".jiajian1").val();
		location.href ="../Cart/ShowCart.do?product_id="+product_id+"&count="+count;
	})
	
})

</script>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

.top {
	position: relative;
	height: 30px;
	background: #DCDCDC;
	width: 1800px;
}

.top_ul {
	position: absolute;
	margin-left: 1000px;
	width: 600px;
	line-height: 30px;
}

.top_ul_li {
	float: left;
	margin-left: 25px;
	cursor: pointer;
	list-style: none;
}

.top_ul_li:hover {
	color: red;
}

.form {
	width: 584px;
}

.daohanglan {
	position: relative;
	width: 1510px;
	height: 150px;
	margin-left: 70px;
}

.search {
	width: 520px;
	height: 50px;
	margin-top: 20px;
	float: left;
	margin-left: 450px;
	border: 4px solid red;
}

.search_text {
	width: 450px;
	height: 46px;
	list-style: none;
	float: left;
}

.search_button {
	width: 65px;
	height: 49px;
	background: red;
	list-style: none;
	border: 2px;
	color: #FFFFFF;
}

.gouwuche {
	width: 100px;
	height: 50px;
	margin-left: 50px;
	margin-top: 22px;
	float: left;
	line-height: 50px;
	text-align: center;
	font-weight: 200;
	border: 1px solid #000000;
}

.fenlei {
	width: 1000px;
	height: 50px;
	background: #FFFFFF;
	position: absolute;
	margin-top: 96px;
}

.fenlei_ul_li {
	line-height: 50px;
	list-style: none;
	float: left;
	margin-left: 100px;
	font-size: 20px;
	font-weight: 200;
	cursor: pointer;
}

.zhong_top {
	width: 1510px;
	height: 50px;
	background: #DCDCDC;
	position: relative;
	margin-left: 70px;
}

.zhong_top_ul {
	margin-left: 93px;
}

.zhong_top_ul_li {
	list-style: none;
	float: left;
	line-height: 50px;
	margin-left: 10px;
	font-weight: 200;
	cursor: pointer;
}

.shangpin {
	width: 500px;
	height: 400px;
	margin-left: 70px;
	position: relative;
	float: left;
	border: 1px solid #DCDCDC;
}

.shangpin_tupian {
	width: 300px;
	height: 400px;
	margin-left: 100px;
}

.xiaotupian {
	width: 500px;
	height: 100px;
	margin-top: 400px;
	margin-left: 70px;
	position: relative;
}

#prev, #next {
	line-height: 100px;
	float: left;
	width: 20px;
	font-size: 30px;
	position: absolute;
}

#prev {
	left: 0px;
}

#next {
	right: 0px;
}

#prev:hover, #next:hover {
	cursor: pointer;
}

.butong {
	position: absolute;
	width: 460px;
	height: 100px;
	margin-left: 20px;
}

.tupian_1 {
	margin-top: 20px;
	height: 50px;
	width:50px;
}

.tupian_2 {
	height: 70px;
}

.piliang {
	width: 500px;
	height: 100px;
	margin-left: 70px;
	position: relative;
}

.ziti_li {
	list-style: none;
	float: left;
	margin-left: 20px;
	color: red;
	font-weight: 200;
	cursor: pointer;
}

.ziti2 {
	position: absolute;
	width: 100px;
	height: 20px;
	margin-top: 50px;
	margin-left: 300px;
	border: 1px solid #808080;
}

.jieshao {
	width: 700px;
	height: 600px;
	float: left;
	margin-left: 600px;
	margin-top: -595px;
}

.jiage {
	width: 700px;
	height: 100px;
	border: 1px solid #F1F1F1;
	background: #F1F1F1;
}

.jiemian1 {
	width: 500px;
	height: 25px;
	margin-top: 20px;
	float: left;
}

.jiemian1_li {
	list-style: none;
	float: left;
	margin-left: 20px;
}

.jiemian2 {
	height: 40px;
	width: 70px;
	margin-left: 600px;
}

.jiemian3 {
	width: 500px;
	height: 25px;
	margin-top: 20px;
}

.jiemian3_li {
	list-style: none;
	float: left;
	margin-left: 20px;
}

.peisong {
	width: 700px;
	height: 50px;
	margin-top: 20px;
}

.peisong1 {
	height: 25px;
	width: 690px;
}

.peisong1_li {
	list-style: none;
	float: left;
	margin-left: 20px;
}

.peisong2 {
	height: 25px;
	width: 690px;
	margin-left: 20px;
}

.xilie {
	width: 700px;
	height: 60px;
	margin-top: 20px;
}

.xilie_wenzi {
	width: 80px;
	height: 50px;
	margin-left: 20px;
	float: left;
}

.xilie_tupian {
	width: 500px;
	height: 60px;
	float: left;
}

.xilie_tupian_li {
	list-style: none;
	margin-left: 10px;
	float: left;
	border: 1px solid #AEB5AD;
}

.xilie_tupian_li:hover {
	border: 2px solid red;
}

.baitiao {
	width: 700px;
	height: 100px;
	margin-top: 20px;
}

.baitiao_wenzi {
	width: 80px;
	height: 50px;
	margin-left: 20px;
	float: left;
}

.baitiao_fenqi {
	width: 500px;
	height: 100px;
	float: left;
}

.baitiao_fenqi_li {
	float: left;
	list-style: none;
	border: 2px solid #AEB5AD;
	margin-left: 20px;
	line-height: 20px;
	margin-top: 5px;
	padding: 5px 5px 5px 5px;
}

.jiagouwuche {
	width: 700px;
	height: 70px;
	margin-top: 20px;
}

.jiajian {
	width: 100px;
	height: 60px;
	border: 2px solid #AEB5AD;
	margin-left: 20px;
	float: left;
}

.jiajian1 {
	height: 60px;
	width: 70px;
	border: 1px solid #DCDCDC;
	float: left;
}

.jiajian2 {
	float: left;
	width: 28px;
	height: 30px;
}

.jiajian3 {
	width: 28px;
	height: 30px;
}

.hao {
	height: 60px;
	width: 100px;
	float: left;
	margin-left: 20px;
	background: red;
	cursor: pointer;
}

.hao_wenzi {
	line-height: 60px;
	text-align: center;
	color: #FFFFFF;
	font-size: 15px;
	font-weight: 300;
}
</style>
</head>

<body>
	<div class="top">
		<ul class="top_ul">
			<li class="top_ul_li">京东会员</li>
			<li class="top_ul_li">我的账户</li>
			<li class="top_ul_li">我的订单</li>
			<li class="top_ul_li">掌上购物</li>
			<li class="top_ul_li">免费注册</li>
			<li class="top_ul_li" style="color: red;">你好，请登录</li>
		</ul>
	</div>
	<div>
		<input type="image" src="img/guangao.png" style="margin-left: 70px;" />
	</div>
	<div class="daohanglan">
		<input type="image" src="img/logo.png"
			style="margin-left: 80px; float: left;" />
		<div class="search">
			<input type="text" class="search_text" />
			<form>

				<input type="submit" value="搜索" class="search_button" />
			</form>
		</div>
		<div class="gouwuche">
			<p style="color: red;">购物车</p>
		</div>
		<div class="fenlei">
			<ul class="fenlei_ul">
				<li class="fenlei_ul_li">全部商品分类</li>
				<li class="fenlei_ul_li">首页</li>
				<li class="fenlei_ul_li">图书首页</li>
				<li class="fenlei_ul_li">小说馆</li>
				<li class="fenlei_ul_li">预售</li>
			</ul>
		</div>
		<div
			style="background: red; height: 2px; width: 1510px; float: left; position: absolute; margin-top: 146px;">

		</div>

	</div>
	<div class="zhong_top">
		<ul class="zhong_top_ul">
			<li class="zhong_top_ul_li">图书</li>
			<li class="zhong_top_ul_li">>${product.category.name }</li>
			
			<li class="zhong_top_ul_li">>${product.name }</li>

		</ul>
	</div>
	<div class="shangpin">
		<input type="image"
			src="<%=request.getContextPath() %>/picture/${product.photo }"
			class="shangpin_tupian" />
	</div>
	<div class="xiaotupian">
		<div id="prev">&lt;</div>
		<div id="next">&gt;</div>
		<div class="butong">
			<c:forEach items="${photoList}" var="photo">
				<c:if test="${photo.top==0 }">
					<input type="image"
						src="<%=request.getContextPath() %>/picture/${photo.main_image }"
						class="tupian_1" />

				</c:if>


			</c:forEach>

		</div>
	</div>
	<div class="piliang">
		<div class="ziti">
			<ul>
				<li class="ziti_li">关注</li>
				<li class="ziti_li">分享</li>
				<li class="ziti_li">举报</li>
			</ul>
		</div>
		<div class="ziti2">
			<p style="color: #666666; font-weight: 200; cursor: pointer;">企业批量购书</p>
		</div>
	</div>

	<div class="jieshao" >
		<p style="color: #666666; font: 宋体; font-size: 25px;">${product.name }</p>
		<p style="color: red; font-size: 15px;">${product.detail }</p>
		<p style="color: #0000FF;">${product.author }著</p>
		<div class="jiage">
			<div class="jiemian1">
				<ul>
					<li class="jiemian1_li">京东价</li>
					<li class="jiemian1_li">￥${product.price*0.79}</li>
					<li class="jiemian1_li">[7.9折]</li>
					<li class="jiemian1_li">[定价 ￥${product.price }]</li>
					<li class="jiemian1_li">（降价通知）</li>

				</ul>
			</div>
			<div class="jiemian2">
				<p>累计评价</p>
				<p>4100+</p>
			</div>


			<div class="jiemian3">
				<ul>
					<li class="jiemian3_li">优惠券</li>
					<li class="jiemian3_li" style="border: 1px dashed red; color: red;">满105减6</li>
					<li class="jiemian3_li" style="border: 1px dashed red; color: red;">满200减16</li>
				</ul>
			</div>
		</div>

		<div class="peisong">
			<div class="peisong1">
				<ul>
					<li class="peisong1_li">配送至</li>
					<li class="peisong1_li"><select><option>北京</option></select></li>
					<li class="peisong1_li"><select><option>北京</option></select></li>
					<li class="peisong1_li"><select><option>北京</option></select></li>
					<li class="peisong1_li">有货</li>
					<li class="peisong1_li">支持</li>
					<li class="peisong1_li" style="color: #0000FF;">49元免基础运费 | 京淮达
						| 自提 | 闪电退款 |</li>

				</ul>
			</div>
			<div class="peisong2">
				<p>由 京东 发货, 并提供售后服务. 23:00前下单,预计明天(08月19日)送达</p>
			</div>


		</div>
		<div class="xilie">
			<div class="xilie_wenzi">
				<p style="line-height: 50px;">选择系列</p>
			</div>
			<div class="xilie_tupian">
				<ul>
					<li class="xilie_tupian_li"><input type="image"
						src="img/xiayin1.png" /></li>
					<li class="xilie_tupian_li"><input type="image"
						src="img/xiayin2.png" /></li>
				</ul>

			</div>
		</div>
		<div class="baitiao">
			<div class="baitiao_wenzi">
				<p style="line-height: 50px;">白条分期</p>
			</div>
			<div class="baitiao_fenqi">
				<ul>
					<li class="baitiao_fenqi_li">不分期</li>
					<li class="baitiao_fenqi_li">￥13.66*3期</li>
					<li class="baitiao_fenqi_li">￥6.95起*6期</li>
					<li class="baitiao_fenqi_li">￥3.59起*12期</li>
					<li class="baitiao_fenqi_li">￥1.88起*24期</li>
					<li class="baitiao_fenqi_li"><input type="image"
						src="img/wehao.png" /></li>
				</ul>
			</div>





		</div>
		<div class="jiagouwuche">
			<div class="jiajian">
				<input type="text" value="1" class="jiajian1" /> <input id="jia"
					type="button" value="+" class="jiajian2" /> <input id="jian" type="button" 
					value="-" class="jiajian3" />
			</div>

			<div class="hao">
				<p class="hao_wenzi" data-id="${product.id }">加入购物车</p>
			</div>

		</div>




	</div>




</body>

</html>