<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${pageContext.request.contextPath}/userAdmin?method=addUser";
			}
		</script>
	</HEAD>
	<body>
		<br>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用户列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addUser()">添加用户</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="9%">
										序号
									</td>
									<td align="center" width="9%">
										用户名
									</td>
									<td width="9%" align="center">
										用户密码
									</td>
									<td width="9%" align="center">
										姓名
									</td>
									<td width="9%" align="center">
										性别
									</td>
									<td width="9%" align="center">
										生日
									</td>
									<td width="9%" align="center">
										电子邮件
									</td>
									<td width="9%" align="center">
										手机号
									</td>
									<td width="9%" align="center">
										用户状态
									</td>
									<td width="9%" align="center">
										修改
									</td>
									<td width="9%" align="center">
										删除
									</td>	
								</tr>
								<c:forEach var="c" items="${ bean.list }" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.username }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.password }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												<c:if test="${c.sex ==1 }">
													男
												</c:if>
												<c:if test="${c.sex ==0 }">
													女
												</c:if>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.birthday }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.email }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												${c.telephone }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">
												<c:if test="${c.stat==0 }">
													未激活
												</c:if>
												<c:if test="${c.stat==1 }">
													已激活
												</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/userAdmin?method=update&uid=${c.uid}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
														
											<td align="center" style="HEIGHT: 22px">
												<a href="javascript:void(0)" onclick="deleteC('${c.uid}')">
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
			
	</body>
	<script type="text/javascript">
		function deleteC(uid){
			if(confirm("您确定要删除该分类吗?")){
				location.href="${pageContext.request.contextPath}/userAdmin?method=delete&uid="+uid;
				
			}
		}
	</script>
</HTML>

