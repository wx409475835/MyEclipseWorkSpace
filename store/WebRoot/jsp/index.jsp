<%@page import="com.sun.jersey.server.impl.container.servlet.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>图灵工作室商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 静态包含-->
			<%@include file="/jsp/head.jsp"%>
			
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;width: 200px">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				
				<div class="col-md-10" style="height: 406px">
					<div class="col-md-2 col-sm-1 hidden-xs" style="text-align:center;height:200px;padding:0px;width: 516px">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<c:forEach items="${hotProducts }" var="hot">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;width: 131px;margin-left: 45px">
							<a href="${pageContext.request.contextPath}/products?method=show&pid=${hot.pid}">
								<img src="${pageContext.request.contextPath}/${hot.pimage}" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.html" style='color:#666'>${fn:substring(hot.pname,0,10) }...</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${ hot.market_price }</font></p>
						</div>
					</c:forEach>
					
				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：广告部分
            -->
            <div class="container-fluid" style="margin-top: 15px">
				<img src="${pageContext.request.contextPath}/products/hao/ad.jpg" width="100%"/>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div class="container-fluid" >
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;width: 200px">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				
				<div class="col-md-10" style="height: 406px">
					<div class="col-md-2 col-sm-1 hidden-xs" style="text-align:center;height:200px;padding:0px;width: 516px">
						<a href="${pageContext.request.contextPath}/product?method=show&pid=${n.pid}">
							<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<c:forEach items="${newProducts }" var="n">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;width: 131px;margin-left: 45px">
							<a href="${pageContext.request.contextPath}/products?method=show&pid=${n.pid}">
								<img src="${pageContext.request.contextPath}/${n.pimage}" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.html" style='color:#666'>${n.pname }</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${n.market_price }</font></p>
						</div>
					</c:forEach>
					
				</div>
			</div>			
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：页脚部分
            -->
			<div class="container-fluid">
				<div style="margin-top:50px;">
					<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
				</div>
		
				<div style="text-align: center;margin-top: 5px;">
					<ul class="list-inline">
						<li><a href="${pageContext.request.contextPath }/jsp/info.jsp" target="_blank">关于我们</a></li>
						<li><a>联系我们</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>法律声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>支付方式</a></li>
						<li><a>配送方式</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
					</ul>
				</div>
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					Copyright &copy; 2009-2018 图灵商城 版权所有
				</div>
			</div>
		</div>
	</body>

</html>
