<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SelectAllUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function var_id(thisform){
     		with(thisform){
     			var en=document.getElementById("inpurt_id").value;
	     		if(isNaN(en)){
	     			alert("请输入正确的用户ID！");
	     		}
     		}
     	}
	</script>
	<style type="text/css">
		table{
			text-align: center;
		}
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
		button{
			width: 87px;
			height: 30px;
			border-radius:5px;
			color:#9400D3;
		}
		a{
			color:#8B7500;
			text-decoration: none;
			cursor:hand;
		}
		a:hover{
			color:#9B30FF;
			text-decoration:underline;
		}
		.div{
			width: 350px;
			height: 30px;
			align:center;
			margin-top: 30px;
			margin-bottom: 25px;
			margin-left: 600px;
		}
		.aaa{
			width: 60px;
			height:33px;
			color:#38B738;
			margin-left: 260px;
			margin-top: -33px;
		}
	</style>
  </head>
  
  <body>
     <c:if test="${ sessionScope.Login!=null}">
    	<form method="post" action="SelectUserByIdAction.do">
    		<br/><br/>
    		<div class="div">
		  		<input id="inpurt_id" placeholder="请输入需要的用户ID" name="ID" style="width: 180px;height: 35px;" type="text" onblur="return var_id(this)"/>
		  		<input type="submit" value="查询" style="width: 60px;height: 33px;color:#38B738;"/>
		  		<input class="aaa" type="submit" value="添加" formaction="${basePath }Register.do"/> 
  			</div>
    	
  			<c:if test="${ sessionScope.SelectUser!='[]' && sessionScope.SelectUser !=null }">
  				<table align="center" bgcolor="#FCFCFC" border="1px">
	  			<tr style="height: 30px" class="tr">
		  			<th><strong><font class="d1">用户名ID</font></strong></th>
		  			<th><strong><font class="d1">用户名</font></strong></th>
	  				<th><strong><font class="d1"> 身 份 </font></strong></th>
	  				<th><strong><font class="d1"> 操 作 </font></strong></th>
	  			</tr>
  			<c:forEach items="${ sessionScope.SelectUser }" var="pu">
  				<tr>
  					<td><strong><font size="4">${pu.person_id}</font></strong></td>
  					<td><strong><font size="4">${pu.username}</font></strong></td>
	  				<c:if test="${pu.ident=='u' }">
	  					<td><strong><font size="4"><%="读者" %></font></strong></td>
	  				</c:if>
	  				<c:if test="${pu.ident=='a' }">
	  					<td><strong><font size="4"><%="管理员" %></font></strong></td>
	  				</c:if>
  					<td>
  						<button><a href="${basePath}UpdateUserAction.do?id=${pu.person_id }">修改用户</a></button>
  						<button><a href="${basePath}DeletePerson_UserAction.do?id=${pu.person_id }">删除用户</a></button>
  					</td>
  				</tr>
  			</c:forEach>
  		</table>
  			</c:if>
    	</form>
    </c:if>
    <c:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="${basePath}Login.do"></jsp:forward>
    </c:if>
  </body>
</html>
