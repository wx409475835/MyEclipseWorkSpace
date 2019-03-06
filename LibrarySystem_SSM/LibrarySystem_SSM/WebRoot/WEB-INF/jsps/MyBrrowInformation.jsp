<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>读者的借阅信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		table,font{
			font-family:  Arial, Helvetica, sans-serif;
			text-align: center;
		}
		.tr{
			background: #E5E5E5;
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
	</style>
	<script type="text/javascript">
	  				function var_return(thisform){
						alert("归还成功！\n期待着与您的下次相遇！");
					}
	 </script>
  </head>
  				
  <body>
	<m:if test="${ sessionScope.Login!=null}">
    	<form action="QY.do" method="post" onclick="">
  		<br/>
		  	<div>
			  	<center>
			    	<m:if test="${ sessionScope.brrow !='[]'}">
			    		<table align="center" bgcolor="#FCFCFC" border="1">
			  			<tr style="height: 30px">
			  				<th><strong><font class="d1">I D</font></strong></th>
			  				<th><strong><font class="d1">图书ID</font></strong></th>
				    		<th><strong><font class="d1">图书名称</font></strong></th>
				    		<th><strong><font class="d1">图书类型</font></strong></th>
				    		<th><strong><font class="d1">图书数量</font></strong></th>
				    		<th><strong><font class="d1">出 版 社</font></strong></th>
				    		<th><strong><font class="d1">操 作</font></strong></th>
			  			</tr>
			  			<m:forEach items="${ sessionScope.brrow }" var="bk">
			  				<tr>
			  					<td><strong><font size="4">${bk.read_id }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_id }</font></strong></td>
			  					<td><strong><font size="4"><%="《" %>${bk.book_name }<%="》" %></font></strong></td>
			  					<td><strong><font size="4">${bk.book_type }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_count }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_add }</font></strong></td>
			  					<td>
			  						<button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;" onclick="var_return(this)"><a href="http://localhost:8888/LibrarySystem_SSM/ReturnBooksAction.do?book_id=${bk.book_id }"><font color="#8B0000">归还</font></a></button>
			  						<input type="submit" value="返回" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;"/>
			  					</td>
			  				</tr>
			  			</m:forEach>
			  		</table>
			    	</m:if>
			  		<m:choose>
			  			<m:when test="${ sessionScope.brrow == '[]'}">
				  			<script type="text/javascript">
				  				alert("您还没有借阅过图书哦,暂时没有记录！\n赶快挑选喜欢的图书，尽情地遨游在知识的海洋吧。");
				  				window.location.href="http://localhost:8888/LibrarySystem_SSM/SelectBooks.do";
				  			</script>
			  			</m:when>
			  		</m:choose>
			  		</center>
			</div>
  	<div style="width: 80px;height: 30px;float: right;margin-right: 160px;">
  		
    </div>
    </form>
    </m:if>
    <m:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="http://localhost:8888/LibrarySystem_SSM/Login.do"></jsp:forward>
    </m:if>
	
  </body>
</html>
