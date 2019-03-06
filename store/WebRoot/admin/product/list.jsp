<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/adminProduct?method=addUI";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">添加商品</button>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="17%">
										商品图片
									</td>
									<td align="center" width="17%">
										商品名称
									</td>
									<td align="center" width="17%">
										商品价格
									</td>
									<td align="center" width="17%">
										是否热门
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<c:forEach items="${bean.list }" var="p" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<c:if test="${bean.currPage==1 }">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
													${vs.count }
												</td>
											</c:if>
											<c:if test="${bean.currPage!=1 }">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
													${vs.count+(bean.pageSize)*(bean.currPage-1) }
												</td>
											</c:if>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<img width="40" height="45" src="${ pageContext.request.contextPath }/${p.pimage}">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												${fn:substring(p.pname,0,10) }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.shop_price }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${p.is_hot==1 }">是</c:if>
												<c:if test="${p.is_hot!=1 }">否</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminProduct?method=update&pid=${p.pid}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminProduct?method=delete&pid=${p.pid}">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
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

