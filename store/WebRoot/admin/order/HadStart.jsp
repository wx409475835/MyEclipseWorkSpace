<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
		<script type="text/javascript">
			$(function(){
				$("input[value='订单详情']").click(function() {
					console.log($($("input[value='订单详情']")[$("input[value='订单详情']").index(this)]).prop("id"));
					$.post("${pageContext.request.contextPath}/adminOrder", {
						"method":"getDetailByOid",
						"oid" : $($("input[value='订单详情']")[$("input[value='订单详情']").index(this)]).prop("id")
					}, function(data) {
						var i = 1;
						var s = "<div class='container-fluid'><table class='table table-bordered table-hover' text-align='center' style='height:160px;text-align: center'><thead><tr style='text-align:center'><th style='width:20%;text-align: center'>编号</th><th style='width:20%;text-align: center'>商品图片</th><th style='width:20%;text-align: center'>商品名称</th><th style='width:20%;text-align: center'>商品价格</th><th style='width:20%;text-align: center'>商品描述</th></tr></thead><tbody>";
						$(data).each(function() {
							s += "<tr><td style='width:20%;text-align: center;padding:0px;margin:auto;'><strong>" + i++ + "</strong></td><td style='width:20%;text-align: center;padding:0;'><img style='width:60px;height:80px' src=${pageContext.request.contextPath}/" + this.product.pimage + "></img></td><td style='width:20%;text-align: center;padding:0;'><strong>" + this.product.pname + "</strong></td><td style='width:20%;text-align: center;padding:0;'><strong>" + this.product.shop_price + "</strong></td><td style='width:20%;text-align: center;padding:0;'><strong>" + this.product.pdesc + "</strong></td>";
						});
						s += "</tbody></table></div>";
						layer.open({
							type : 1, //0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
							title : "订单详情", //标题
							area : [ '60%', '40%' ], //大小
							shadeClose : false, //点击弹层外区域 遮罩关闭
							content : s //内容
						});
					}, "json");
				});
		
			});
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" style="" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach items="${bean.list }" var="o" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												${o.oid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												${o.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												${o.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												<c:if test="${o.state==0 }">未付款</c:if>
												<c:if test="${o.state==1 }"><a href='${pageContext.request.contextPath }/adminOrder?method=updateState&oid=${o.oid}&state=2'>发货</a></c:if>
												<c:if test="${o.state==2 }">等待确认收货</c:if>
												<c:if test="${o.state==3 }">已完成</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="${o.oid }"/>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
			<!--分页 -->
			<div style="width:380px;margin:0 auto;margin-top:50px;">
				<center>
				<ul class="pagination" style="text-align:center; margin-top:10px;">
					<!--  判断当前页是否为首页 -->
					<c:if test="${bean.currPage==1 }">
						<li class="disabled"><a href="javascript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:if test="${bean.currPage!=1 }">
						<li><a href="${pageContext.request.contextPath}/adminProduct?method=findAll&currPage=${bean.currPage-1 }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<!-- 判断页码 -->
					<c:forEach  begin="${(bean.currPage - 5) > 0?bean.currPage-5:1 }" end="${(bean.currPage+4) > bean.totalPage ? bean.totalPage:(bean.currPage+4)}" var="s">
					
						<!-- 判断是否是当前页 -->
						<c:if test="${bean.currPage ==s }">
							<li class="active"><a href="javascript:void(0)">${s }</a></li>
						</c:if>
					
						<c:if test="${bean.currPage !=s }">
							<li><a href="${pageContext.request.contextPath}/adminProduct?method=findAll&currPage=${s }">${s }</a></li>
						</c:if>
					
					</c:forEach>
					
					<!--  判断当前页是否为最后一页 -->
					<c:if test="${bean.currPage == bean.totalPage }">
						<li class="disabled"><a href="javascript:void(0)" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
					</c:if>
					<c:if test="${bean.currPage != bean.totalPage}">
						<li><a href="${pageContext.request.contextPath}/adminProduct?method=findAll&currPage=${bean.currPage+1 }" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
					</c:if>
				</ul>
				</center>
			</div>
		</form>
	</body>
</HTML>

