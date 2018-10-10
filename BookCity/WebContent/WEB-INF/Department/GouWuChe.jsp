<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
	class=" js canvas canvastext no-touch rgba backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations cssgradients csstransforms csstransforms3d csstransitions fontface"
	lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<meta name="renderer" content="webkit">
<title>我的购物车-云购物商城</title>
<link href="img/icon/favicon.ico" rel="shortcut icon"
	type="image/x-icon">
<link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=request.getContextPath()%>/css/home.css" rel="stylesheet"
	type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery.js"
	type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<script src="js/modernizr-custom-v2.7.1.min.js" type="text/javascript"></script>

</head>
<body>

	<header id="pc-header">
	<div class="pc-header-nav">
		<div class="pc-header-con">
			<div class="fl pc-header-link">
				您好！，欢迎来云购物 <a href="login.html" target="_blank">请登录</a> <a
					href="register.html" target="_blank"> 免费注册</a>
			</div>
			<div class="fr pc-header-list top-nav">
				<ul>
					<li>
						<div class="nav">
							<i class="pc-top-icon"></i><a id="dingdan">我的订单</a>
						</div>
						<div class="con">
							<dl>
								<dt>
									<a href="">批发进货</a>
								</dt>
								<dd>
									<a href="">已买到货品</a>
								</dd>
								<dd>
									<a href="">优惠券</a>
								</dd>
								<dd>
									<a href="">店铺动态</a>
								</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="nav">
							<i class="pc-top-icon"></i><a href="#">我的商城</a>
						</div>
						<div class="con">
							<dl>
								<dt>
									<a href="">批发进货</a>
								</dt>
								<dd>
									<a href="">已买到货品</a>
								</dd>
								<dd>
									<a href="">优惠券</a>
								</dd>
								<dd>
									<a href="">店铺动态</a>
								</dd>
							</dl>
						</div>
					</li>
					<li><a href="#">我的云购</a></li>
					<li><a href="#">我的收藏</a></li>
					<li><a href="#">会员中心</a></li>
					<li><a href="#">客户服务</a></li>
					<li><a href="#">帮助中心</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pc-header-logo clearfix">
		<div class="pc-fl-logo fl">
			<h1>
				<a href="index.html"></a>
			</h1>
		</div>
		<div class="head-form fl">
			<form class="clearfix">
				<input class="search-text" id="key" accesskey="" type="text"
					placeholder="洗衣机" autocomplete="off">
				<button class="button" onclick="search('key');return false;">搜索</button>
			</form>
			<div class="words-text clearfix">
				<a class="red" href="#">1元秒爆</a> <a href="#">低至五折</a> <a href="#">农用物资</a>
				<a href="#">佳能相机</a> <a href="#">服装城</a> <a href="#">买4免1</a> <a
					href="#">家电秒杀</a> <a href="#">农耕机械</a> <a href="#">手机新品季</a>
			</div>
		</div>
		<div class="fr pc-head-car">
			<i class="icon-car"></i> <a href="#">我的购物车</a>
		</div>
	</div>
	<!--  顶部    start-->
	<div class="yHeader">
		<!-- 导航   start  -->
		<div class="yNavIndex">
			<ul class="yMenuIndex" style="margin-left: 0">
				<li style="background: #d1201e"><a href="" target="_blank">云购首页</a></li>
				<li><a href="" target="_blank">女士护肤 </a></li>
				<li><a href="" target="_blank">男士护肤</a></li>
				<li><a href="" target="_blank">洗护染发</a></li>
				<li><a href="" target="_blank">染发</a></li>
				<li><a href="" target="_blank">彩妆</a></li>
				<li><a href="" target="_blank">品牌故事</a></li>
			</ul>
		</div>
		<!-- 导航   end  -->
	</div>

	</header>

	<section id="pc-jie">
	<div class="center ">
		<ul class="pc-shopping-title clearfix">
			<li><a class="cu" href="#">全部商品(10)</a></li>
			<li><a href="#">限时优惠(7)</a></li>
			<li><a href="#">库存紧张(0)</a></li>
		</ul>
	</div>
	<div class="pc-shopping-cart center">
		<div class="pc-shopping-tab">
			<table>
				<thead>
					<tr class="tab-0">
						<th class="tab-1"><input name="s_all"
							class="s_all tr_checkmr" id="s_all_h" type="checkbox"><label
							for=""> 全选</label></th>
						<th class="tab-2">商品</th>
						<th class="tab-3">商品信息</th>
						<th class="tab-4">单价</th>
						<th class="tab-5">数量</th>
						<th class="tab-6">小计</th>
						<th class="tab-7">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="padding-left: 10px; background: #eee" colspan="7">
							<input type="checkbox" checked=""> <label for="">云购物自营</label>
							<a style="position: relative; padding-left: 50px" href="#"><i
								class="icon-kefu"></i>联系客服</a>
							<ul class="clearfix fr" style="padding-right: 20px">
								<li><i class="pc-shop-car-yun"></i>满109元减10</li>
								<li><i class="pc-shop-car-yun"></i>领取3种优惠券, 最高省30元</li>
							</ul>
						</td>
					</tr>
					<c:forEach items="${list}" var="cart2">
						<tr>
							<th><input style="margin-left: 10px; float: left"
								type="checkbox" class="gouxuan"></th>
							<th class="tab-th-1" data-id="${cart2.product.id }"><a
								href="#"><img width="100%" alt=""
									src="<%=request.getContextPath() %>/picture/${cart2.product.photo }"></a>
								<a class="tab-title" href="#">${cart2.product.name }</a></th>
							<th>

								<p>${cart2.product.detail }</p>
							</th>
							<th>
								<p>${cart2.product.price }</p>
								<p class="red">${cart2.product.price*0.79 }</p>
							</th>
							<th class="tab-th-2" data-id="${cart2.id }"><span
								class="jian">-</span> <input class="shul" type="text"
								maxlength="3" placeholder="" value="${cart2.count }"> <span
								class="jia">+</span></th>
							<th class="red2">${cart2.xiaoji }</th>
							<th><a href="#" class="shanchu">删除</a></th>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>
	<div style="height: 10px"></div>
	<div class="center">
		<div class="clearfix pc-shop-go">
			<div class="fl pc-shop-fl">
				<input type="checkbox" placeholder=""> <label for="">全选</label>
				<a href="#" class="shanchu2">删除</a> <a href="#">清楚失效商品</a>
			</div>
			<div class="fr pc-shop-fr">
				<p>
					共有 <em class="red pc-shop-shu">${list.size() }</em> 款商品，总计（不含运费）
				</p>
				<span id="zongji">${cart1.zongji }</span> <a class="fukuan">去下单</a>
			</div>
		</div>
	</div>
	</section>



	<div style="height: 100px"></div>

	<footer>
	<div class="pc-footer-top">
		<div class="center">
			<ul class="clearfix">
				<li><span>关于我们</span> <a href="#">关于我们</a> <a href="#">诚聘英才</a>
					<a href="#">用户服务协议</a> <a href="#">网站服务条款</a> <a href="#">联系我们</a>
				</li>
				<li class="lw"><span>购物指南</span> <a href="#">新手上路</a> <a
					href="#">订单查询</a> <a href="#">会员介绍</a> <a href="#">网站服务条款</a> <a
					href="#">帮助中心</a></li>
				<li class="lw"><span>消费者保障</span> <a href="#">人工验货</a> <a
					href="#">退货退款政策</a> <a href="#">运费补贴卡</a> <a href="#">无忧售后</a> <a
					href="#">先行赔付</a></li>
				<li class="lw"><span>商务合作</span> <a href="#">人工验货</a> <a
					href="#">退货退款政策</a> <a href="#">运费补贴卡</a> <a href="#">无忧售后</a> <a
					href="#">先行赔付</a></li>
				<li class="lss"><span>下载手机版</span>
					<div class="clearfix lss-pa">
						<div class="fl lss-img">
							<img alt="" src="img/icon/code.png">
						</div>
						<div class="fl" style="padding-left: 20px">
							<h4>扫描下载云购APP</h4>
							<p>把优惠握在手心</p>
							<p>把潮流带在身边</p>
							<p></p>
						</div>
					</div></li>
			</ul>
		</div>
		<div class="pc-footer-lin">
			<div class="center">
				<p>友情链接： 卡宝宝信用卡 梦芭莎网上购物 手游交易平台 法律咨询 深圳地图 P2P网贷导航 名鞋库 万表网 叮当音乐网
					114票务网 儿歌视频大全</p>
				<p>京ICP证1900075号 京ICP备20051110号-5 京公网安备110104734773474323
					统一社会信用代码 91113443434371298269B 食品流通许可证SP1101435445645645640352397</p>
				<p style="padding-bottom: 30px">版物经营许可证 新出发京零字第朝160018号
					Copyright©2011-2015 版权所有 ZHE800.COM</p>
			</div>
		</div>
	</div>
	</footer>
	<script type="text/javascript">
		//hover 触发两个事件，鼠标移上去和移走
		//mousehover 只触发移上去事件
		$(".top-nav ul li").hover(function() {
			$(this).addClass("hover").siblings().removeClass("hover");
			$(this).find("li .nav a").addClass("hover");
			$(this).find(".con").show();
		}, function() {
			//$(this).css("background-color","#f5f5f5");
			$(this).find(".con").hide();
			//$(this).find(".nav a").removeClass("hover");
			$(this).removeClass("hover");
			$(this).find(".nav a").removeClass("hover");
		})

		$(".jia").click(
				function() {
					var value = parseInt($(this).prev().val());
					var cart2Id = $(this).parent().data("id");
					var productId = $(this).parent().parent().find(".tab-th-1")
							.data("id");
					value = value + 1;

					$(this).prev().val(value);
					var xiaoji = $(this).parent().parent().find(".red2");
					$.ajax({
						url : "biandong.do",
						type : "post",
						data : {
							cart2Id : cart2Id,
							count : value,
							productId : productId
						},

						dataType : "text",
						success : function(data) {
							xiaoji.html(data);

						}
					})

				})
		$(".jian").click(
				function() {
					var value = parseInt($(this).next().val());
					value = value - 1;
					var cart2Id = $(this).parent().data("id");
					var productId = $(this).parent().parent().find(".tab-th-1")
							.data("id");
					$(this).next().val(value);
					var xiaoji = $(this).parent().parent().find(".red2");
					$.ajax({
						url : "biandong.do",
						type : "post",
						data : {
							cart2Id : cart2Id,
							count : value,
							productId : productId
						},

						dataType : "text",
						success : function(data) {
							xiaoji.html(data);

						}
					})

				})

		/* 		$(".gouxuan").click(function(){
					
					var id = $(this).parent().parent().find(".tab-th-2").data("id");
					$(this).toggleClass("select");
				
					 $(this).find(".gouxuan select").each(function(index,element){
						ids.push(id);
					 }) 
					 var zongji = $("#zongji");
					 $.ajax({
						 url : "biandong2.do",
							type : "post",
							data : {"ids":ids},
							dataType : "text",
							success : function(data) {
								zongji.html(data);

							}
							
					 })
					
				}) */

		$(".gouxuan").click(
				function() {
					var zongji = 0;
					$("#zongji").html(0);
					$(this).toggleClass("select");
					$(".select").each(
							function(index, element) {
								zongji += parseInt($(this).parent().parent()
										.find(".red2").html());

							})
					$("#zongji").html(zongji);
				})
		/* $(".gouxuan").click(function(){
			
			$(this).toggleClass("select");
			 
			 
		}) */

		$(".shanchu").click(function() {
			var id = $(this).parent().parent().find(".tab-th-2").data("id");
			location.href = "shanchu.do?cart2Id=" + id;
		})

		$(".shanchu2").click(
				function() {
					var ids = new Array();

					$(".select").each(
							function(index, element) {
								var id = $(this).parent().parent().find(
										".tab-th-2").data("id");
								ids.push(id);
							})
					location.href = "shanchu2.do?cart2Ids=" + ids;
				})
		$(".fukuan").click(
				function() {
					var ids = new Array();
					var zongji = $("#zongji").html();
					$(".select").each(
							function(index, element) {
								var id = $(this).parent().parent().find(
										".tab-th-2").data("id");
								ids.push(id);
							})
							if(ids.length==0){
								alert("请选中商品！");
							}else{
								location.href = "../Adress/showAdress.do?ids=" + ids+"&zongji="+zongji;
	
							}
				})
				$("#dingdan").click(function(){
		window.location.href ="../Order/zhanshidingdan.do";
	})
	</script>

</body>
</html>