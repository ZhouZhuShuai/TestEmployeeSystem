<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
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
$(".photo").click(function(){
	var id = $(this).parent().data("id");
	window.location.href ="ShowShangPinXiangQing.do?id="+id;
	 
})
	$(".zhonglei").click(function(){
		var id = $(this).data("id");
		window.location.href ="search.do?category.id="+id;
	})
	$("#quanbu").click(function(){
		window.location.href ="search.do";
	})
	$(".gouwuche").click(function(){
		window.location.href ="../Cart/ShowGoWuChe.do";
	})
	$("#dingdan").click(function(){
		window.location.href ="../Order/zhanshidingdan.do";
	})
	$("#login").click(function(){
		window.location.href ="../User/ShowLogin.do";
	})
	
})
		
		
		</script>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

.b5_top {
	width: 100%;
	height: 30px;
}

.b5_top .b5_top_target {
	width: 1350px;
	height: 30px;
	margin: 0 auto 0;
}

.b5_top .b5_top_target .b5_top_target_left {
	cursor: pointer;
	line-height: 30px;
	float: left;
	user-select: none;
}

.b5_top .b5_top_target .b5_top_target_right {
	float: right;
	margin-right: 65px;
}

.b5_top .b5_top_target .b5_top_target_right .b5_top_target_right_tip {
	line-height: 30px;
	float: left;
	cursor: pointer;
	border-left: 1px;
	border-right: 1px;
	padding: 0 14px 0 14px;
	user-select: none;
}

.b5_top .b5_top_target .b5_top_target_right .b5_top_target_right_tip:hover
	{
	background-color: #F1F1F1;
	color: red;
}

ul {
	margin: 0;
	list-style-type: none;
}

.b5_bottom_search .b5_bottom_search_search {
	border: 2px solid #FF0000;
	margin-top: 30px;
	margin-left: 10%;
	float: left;
	width: 500px;
	height: 35px;
	display: inline;
}

.b5_bottom {
	/*background: #F1F1F1;*/
	margin: auto 140px auto 140px;
	overflow: hidden;
}

.b5_bottom_search {
	overflow: hidden;
	width: 600px;
	margin-left: 400px;
}

.b5_bottom_search_search_search {
	height: 35px;
	width: 454px;
	float: left;
	border: none;
	user-select: none;
	color: #DCDCDC;
}

.b5_bottom_search_search_button {
	float: right;
	width: 46px;
	height: 37px;
	background: #FF0000;
	border: none;
	color: #FFFFFF;
	cursor: pointer;
	text-align: center;
	user-select: none;
}

.b5_bottom_search_search_button:hover {
	font-weight: bold;
}

.b5_bottom_search_note {
	width: 450px;
	height: 20px;
	margin-left: 11%;
}

.b5_bottom_search_note_ul {
	margin-left: auto;
}

.b5_bottom_search_note_li {
	float: left;
	user-select: none;
	padding: 0 14px 0 14px;
	color: #AEB5AD;
	cursor: pointer;
	margin-left: 0px;
}

li {
	margin: 0;
	list-style-type: none;
}

.logo {
	position: absolute;
	height: 80px;
	width: 150px;
}

.gouwuche {
	width: 200px;
	height: 30px;
	margin-top: -55px;
	margin-left: 1000px;
	text-align: center;
	color: red;
	font-size: large;
	border: 1px solid #DCDCDC;
	border-radius: 30px;
	position: absolute;
	background: #F1F1F1;
	cursor: pointer;
	user-select: none;
}

.fenlei {
	height: 55px;
}

.fenlei .fenlei_ul {
	float: left;
	margin-top: 20px;
}

.fenlei_ul_li {
	float: left;
	font-size: 20px;
	list-style: none;
	user-select: none;
	cursor: pointer;
	margin-right: 100px;
	font-weight: bold;
}

.fenlei_ul_li:hover {
	color: red;
}

.huanhuang {
	height: 3px;
	background: red;
	margin-top: auto;
}

#zhulei {
	background: red;
	color: #F1F1F1;
	width: 180px;
	height: 35px;
	text-align: center;
	line-height: 35px;
	font-weight: 200;
	border-radius: 20px;
}

#jieguo {
	height: 20px;
	margin-top: 20px;
	width: px;
	margin-top: 20px;
	float: left;
}

#shuming {
	margin-top: 20px;
	margin-left: 100px;
}

.xiahuaxian {
	margin-top: 20px;
	color: #000000;
}

.xiaoshuo {
	background: #F8F8FF;
	height: 40px;
	width: 150px;
	line-height: 40px;
	font-weight: bold;
	color: #808080;
	float: left;
	margin-right: 20px;
}

.zhonglei_ul {
	height: 40px;
}

.zhonglei {
	float: left;
	margin-right: 70px;
	margin-top: 10px;
	color: #0000FF;
	font-weight: 100;
}

.zhonglei:hover {
	color: red;
	cursor: pointer;
}

.guanggao {
	margin-top: 15px;
	width: 200px;
	float: left;
	height: 1800px;
	border: 1px solid #AEB5AD;
	border-radius: 30px;
}

.bianjiechaxun_ul {
	margin-top: 15px;
	height: 50px;
	margin-left: 220px;
	background: #F8F8FF;
}

.bianjiechaxun_li {
	float: left;
	margin-left: 10px;
	line-height: 27px;
	padding: 0 16px 0 16px;
	background: #FFFFFF;
	height: 25px;
	margin-top: 10px;
	border: 1px solid #AEB5AD;
	border-radius: 20px;
	font-weight: 100;
}

.shuliang {
	float: left;
	line-height: 50px;
	margin-left: 450px;
	color: #AEB5AD;
}

.qiehuan {
	float: left;
	margin-left: 10px;
	line-height: 27px;
	padding: 0 16px 5px 16px;
	background: #FFFFFF;
	height: 25px;
	margin-top: 10px;
	border: 1px solid #AEB5AD;
	cursor: pointer;
	border-radius: 20px;
}

.peisong {
	height: 50px;
	margin-left: 220px;
	background: #F8F8FF;
}

.peisong2 {
	float: left;
	line-height: 50px;
	margin-left: 8px;
	padding: 0 3px 0 3px;
}

.peisong3 {
	float: left;
	line-height: 50px;
	margin-left: 420px;
}

.peisong4 {
	font-size: 50px;
	font-weight: 100;
}

.tupian {
	width: 280px;
	height: 550px;
	margin-left: 20px;
	margin-top: 10px;
	border-radius: 50px;
}

.tupian:hover {
	border: -2 px solid red;
	box-shadow: 2px 2px 2px #666666;
}

.zuozhe:hover {
	color: red;
}

.guanzhu:hover {
	border: 1px solid red;
}

.jiagouwu:hover {
	border: 1px solid red;
}

.guanzhu1 {
	cursor: pointer;
}

.jiagouwu1 {
	cursor: pointer;
}

.guanggao_tushu {
	width: 190px;
}

.fanye {
	width: 600px;
	height: 50px;
	margin-left: 40%;
	margin-top: 30px;
}

.fanye_li {
	float: left;
	border: 1px solid #AEB5AD;
	background: #F1F1F1;
	line-height: 40px;
	margin-left: 10px;
	cursor: pointer;
	height: 30px;
	margin-top: 5px;
	padding: 0px 14px 10px 14px;
	font-size: 15px;
	user-select: none;
	border-radius: 20px;
}
</style>
</head>

<body>
	<div>
		<!--最上层标签-->
		<div class="b5_top">
			<div style="background: #F1F1F1; width: 100%;">
				<div class="b5_top_target">
					<div class="b5_top_target_left">
						送至 <select>
							<option>北京</option>
							<option>上海</option>
							<option>广州</option>
							<option>山东</option>
							<option>浙江</option>
						</select>
					</div>
					<div class="b5_top_target_right">
						<ul>
							<li class="b5_top_target_right_tip">京东会员</li>
							<li class="b5_top_target_right_tip">我的账户</li>
							<li class="b5_top_target_right_tip" id="dingdan">我的订单</li>
							<li class="b5_top_target_right_tip">掌上购物</li>
							<li class="b5_top_target_right_tip" onclick="Register();"><a
								href="zhuce.html" style="text-decoration: none;">免费注册</a></li>
							<li class="b5_top_target_right_tip"><a  id="login"
								style="color: red; text-decoration: none;">你好，请登录</a></li>
						</ul>

					</div>

				</div>

			</div>
		</div>

		<!--搜索栏-->
		<div class="b5_bottom">
			<input type="image" src="img/logo.png" class="logo" />
			<div class="b5_bottom_search">
				<form>
					<div class="b5_bottom_search_search">
						<input type="text " value="这也太难了吧 "
							class="b5_bottom_search_search_search " /> <input type="submit"
							value="搜索 " class="b5_bottom_search_search_button " />

					</div>
				</form>
				<div class="b5_bottom_search_note ">
					<ul class="b5_bottom_search_note_ul ">

						<li class="b5_bottom_search_note_li ">家用电器</li>
						<li class="b5_bottom_search_note_li ">七夕好礼</li>
						<li class="b5_bottom_search_note_li ">浪漫鲜花</li>
						<li class="b5_bottom_search_note_li ">华为</li>
						<li class="b5_bottom_search_note_li ">联想</li>

					</ul>

				</div>
			</div>

			<div>
				<input type="text " class="gouwuche " value="我的购物车 " />

			</div>
			<div class="fenlei ">
				<ul class="fenlei_ul ">
					<li class="fenlei_ul_li " id="zhulei">全部商品分类</li>
					<li class="fenlei_ul_li ">京东首饰</li>
					<li class="fenlei_ul_li ">美妆馆</li>
					<li class="fenlei_ul_li ">超市</li>
					<li class="fenlei_ul_li ">生鲜</li>
					<li class="fenlei_ul_li ">全球购</li>
				</ul>

			</div>

			<div class="huanhuang"></div>

			
			<div>
				<div class="xiaoshuo">图书:</div>
				<div>
				<div class="zhonglei" style="color:red" id="quanbu">全部</div>
					<ul class="zhonglei_ul">
					<c:forEach items="${ categoryList}" var = "category">
						<li class="zhonglei" data-id="${category.id }">${category.name }</li>
						
						</c:forEach>
					</ul>
				</div>

				<hr />
			</div>

			<div class="xiaoshuo">其他图书:</div>

			<ul class="zhonglei_ul">
				<li class="zhonglei">小说</li>
				<li class="zhonglei">文学</li>
				<li class="zhonglei">港台图书</li>
				<li class="zhonglei">电视剧</li>
				<li class="zhonglei">青春文学</li>
				<li class="zhonglei">童书</li>
				<li class="zhonglei">社会科学</li>
			</ul>
			<hr />

			<div class="xiaoshuo">出版社 :</div>

			<ul class="zhonglei_ul">
				<li class="zhonglei">上海人民出版社</li>
				<li class="zhonglei">中央编译出版社</li>
				<li class="zhonglei">百花洲文艺出版社</li>
				<li class="zhonglei">吉林大学出版社</li>
				<li class="zhonglei">人民文学出版社</li>
				<!--	<li class="zhonglei">译林出版社</li>-->

			</ul>
			<hr />

			<div class="guanggao">
				<p
					style="float: left; margin-top: 10px; margin-left: 10px; font-weight: bold; color: #808080;">商品精选</p>
				<p style="margin-top: 10px; margin-left: 150px; color: #AEB5AD;">广告</p>
				<div class="guanggao_tushu">
					<input type="image" src="<%=request.getContextPath()%>/picture/wobu.jpg"
						style="cursor: pointer; width: 170px; height: 300px; margin-left: 10px; margin-top: 20px;" />
					<p
						style="color: red; margin-left: 10px; font-size: 20px; font-weight: 400; margin-top: 10px;">￥
						98.10</p>
					<p
						style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; color: red; float: left;">我不
					</p>
					<p
						style="cursor: pointer; margin-left: 60px; font-weight: 200; margin-top: 10px;"
						class="zuozhe">大冰</p>
					<p style="color: steelblue; margin-left: 10px; float: left;">10000+</p>
					<p style="font-size: smaller; font-weight: 500; color: #AEB5AD;">条评价</p>

				</div>
				<div class="guanggao_tushu">
					<input type="image" src="<%=request.getContextPath()%>/picture/amituofo.jpg"
						style="cursor: pointer; width: 170px; height: 300px; margin-left: 10px; margin-top: 20px;" />
					<p
						style="color: red; margin-left: 10px; font-size: 20px; font-weight: 400; margin-top: 10px;">￥
						28.10</p>
					<p
						style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; color: red; float: left;">阿弥陀佛么么哒
					</p>
					<p
						style="cursor: pointer; margin-left: 60px; font-weight: 200; margin-top: 10px;"
						class="zuozhe">大冰</p>
					<p style="color: steelblue; margin-left: 10px; float: left;">1000+</p>
					<p style="font-size: smaller; font-weight: 500; color: #AEB5AD;">条评价</p>

				</div>
				<div class="guanggao_tushu">
					<input type="image" src="<%=request.getContextPath()%>/picture/xingfu.jpg"
						style="cursor: pointer; width: 170px; height: 300px; margin-left: 10px; margin-top: 20px;" />
					<p
						style="color: red; margin-left: 10px; font-size: 20px; font-weight: 400; margin-top: 10px;">￥
						28.10</p>
					<p
						style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; color: red; float: left;">他们最幸福
					</p>
					<p
						style="cursor: pointer; margin-left: 60px; font-weight: 200; margin-top: 10px;"
						class="zuozhe">大冰</p>
					<p style="color: steelblue; margin-left: 10px; float: left;">1000+</p>
					<p style="font-size: smaller; font-weight: 500; color: #AEB5AD;">条评价</p>

				</div>
				<div class="guanggao_tushu">
					<input type="image" src="<%=request.getContextPath()%>/picture/momotou.jpg"
						style="cursor: pointer; width: 170px; height: 300px; margin-left: 10px; margin-top: 20px;" />
					<p
						style="color: red; margin-left: 10px; font-size: 20px; font-weight: 400; margin-top: 10px;">￥
						88.10</p>
					<p
						style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; color: red; float: left;">乖，摸摸头
					</p>
					<p
						style="cursor: pointer; margin-left: 60px; font-weight: 200; margin-top: 10px;"
						class="zuozhe">大冰</p>
					<p style="color: steelblue; margin-left: 10px; float: left;">1000+</p>
					<p style="font-size: smaller; font-weight: 500; color: #AEB5AD;">条评价</p>

				</div>


			</div>
			<div>
				<ul class="bianjiechaxun_ul">
					<li class="bianjiechaxun_li">综合</li>
					<li class="bianjiechaxun_li">销量</li>
					<li class="bianjiechaxun_li">评论数</li>
					<li class="bianjiechaxun_li">出版时间</li>
					<li class="bianjiechaxun_li">价格</li>

					<li class="shuliang">共400+件商品 1/9</li>
					<li class="qiehuan"><</li>
					<li class="qiehuan">></li>

				</ul>
				<div class="peisong">
					<p class="peisong2 " style="font-weight: 100;">配送至</p>
					<div class="peisong2">
						<select style="height: 25px;">
							<option>北京</option>
							<option>上海</option>
							<option>广州</option>
							<option>山东</option>
							<option>浙江</option>
						</select>
					</div>

					<div class="peisong2">
						<input type="checkbox" class="peisong4" />京东物流 <input
							type="checkbox" class="peisong4" />货到付款 <input type="checkbox"
							class="peisong4" />仅显示有货 <input type="checkbox" class="peisong4" />可配送全球
					</div>

					<form>
						<div class="peisong3">
							<input type="text" value="在結果中搜索"
								style="height: 25px; border: 1px solid #AEB5AD; color: #DCDCDC; border-radius: 20px;" />
							<input type="submit" value="确定"
								style="height: 27px; width: 55px; border: 1px solid #AEB5AD; border-radius: 20px; font-weight: 200;" />
						</div>

					</form>

				</div>

			</div>
			<div>
				<c:forEach items="${list}" var="product">
					<div data-id="${product.id }" class="tupian" style="float: left;">
						<input class="photo" type="image"
							src="<%=request.getContextPath() %>/picture/${product.photo }"
							style="cursor: pointer; width: 230px; height: 300px; margin-left: 30px; margin-top: 20px;" />
						<p
							style="color: red; margin-left: 10px; font-size: 20px; font-weight: 400; margin-top: 10px;">￥
							${product.price }</p>
						<p
							style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; color: red; float: left;">${product.name }
						</p>
						<p
							style="cursor: pointer; margin-left: 10px; font-weight: 200; margin-top: 10px; float: left;"
							class="zuozhe">${product.author }</p>
						<p
							style="cursor: pointer; font-weight: 200; margin-top: 10px; color: red;">新华书店正品保障</p>
						<p style="color: steelblue; margin-left: 10px; float: left;">${product.sales_volume}</p>
						<p style="font-size: smaller; font-weight: 500; color: #AEB5AD;">销售量</p>
						<div style="height: 10px; color: #000000; width: 100px;"></div>
						<div
							style="width: 150px; margin-left: 10px; font-weight: 500; color: #AEB5AD;">京东自营</div>
						<div
							style="border-radius: 5px; text-align: center; margin-left: 10px; margin-top: 10px; color: #FFFAFA; width: 48px; height: 20px; background: red;">自营</div>
						<div class="guanzhu"
							style="margin-left: 10px; margin-top: 30px; height: 30px; width: 80px; float: left;">
							<input class="guanzhu1" type="text" value="关注"
								style="width: 78px; font-weight: 500; color: #AEB5AD; text-align: center; height: 28px; line-height: 30px; border: 1px solid #AEB5AD;" />

						</div>
						<div class="jiagouwu"
							style="margin-left: 92px; margin-top: 30px; height: 30px; width: 80px;">
							<input class="jiagouwu1" type="text" value="加入购物车"
								style="width: 78px; font-weight: 500; color: #AEB5AD; text-align: center; height: 28px; line-height: 30px; border: 1px solid #AEB5AD;" />

						</div>
					</div>
				</c:forEach>


			</div>
			<div class="fanye" style="float: left;">

				<ul class="fanye_ul">
					<li id="pre" class="fanye_li"><a href="search.do?ye=${p.ye-1}&category.id=${product.category.id}">上一页</a></li>
					<c:forEach begin="${p.beginYe }" end="${p.endYe }"
						varStatus="status">
						<li class="fanye_li"
							<c:if test="${p.ye==status.index}"> class="active"</c:if>><a
							href="search.do?ye=${status.index}&category.id=${product.category.id}">${status.index}</a></li>
					</c:forEach>
					<li id="next" class="fanye_li"><a
						href="search.do?ye=${p.ye+1 }&category.id=${product.category.id}">下一页</a></li>
				</ul>
			</div>




		</div>
	</div>
</body>

</html>