<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按照图书种类查询图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  	<script type="text/javascript">
		function var_Confirm(){
			alert("借阅成功！\n祝您阅读愉快！");
			window.location.href="http://localhost:8888/LibrarySystem_SSM/SelectBooks.do";
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
  </head>
  
  <body>
  	<c:if test="${ sessionScope.Login!=null}">
    	<center>
    <form action="SelectAsBookTypeAction.do" method="post" onclick="">
    	<div>
  		<input placeholder="请输入需要查询的图书种类" style="width: 210px;height: 35px;" name="book_type" type="text"/>&nbsp;&nbsp;
  		<input type="submit" value="查询" style="width: 60px;height: 30px;color:#38B738;"/> 
  		</div>
  		<br/>
    	<div>
    		<c:if test="${ sessionScope.BookAsType !='[]' and sessionScope.BookAsType !=null}">
    			<div>
			    	<table align="center" bgcolor="#FCFCFC" border="1">
			  			<tr style="height: 30px">
			  				<th><strong><font class="d1">图书 Id</font></strong></th>
				    		<th><strong><font class="d1">图书名称</font></strong></th>
				    		<th><strong><font class="d1">图书类型</font></strong></th>
				    		<th><strong><font class="d1">图书价格</font></strong></th>
				    		<th><strong><font class="d1">图书数量</font></strong></th>
				    		<th><strong><font class="d1">出 版 社</font></strong></th>
				    		<th><strong><font class="d1">图书状态</font></strong></th>
				    		<th><strong><font class="d1">执行操作</font></strong></th>
			  			</tr>
			  			<c:forEach items="${ sessionScope.BookAsType }" var="bk">
			  				<tr>
			  					<td><strong><font size="4">${bk.book_id }</font></strong></td>
			  					<td><strong><font size="4"><%="《" %>${bk.book_name }<%="》" %></font></strong></td>
			  					<td><strong><font size="4">${bk.book_type }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_price }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_count }</font></strong></td>
			  					<td><strong><font size="4">${bk.book_add }</font></strong></td>
			  					<c:if test="${bk.book_count >=1 }">
  									<td><strong><font size="4" color="green">可借阅</font></strong></td>
  								</c:if>
  								<c:if test="${bk.book_count==0 }">
  									<td><strong><font size="4" color="red">不可借阅</font></strong></td>
  								</c:if>
  								<td>
			  					<c:choose>
			  						<c:when test="${bk.book_count >=1 }">
				  						<center>
				  							<button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;" onclick="var_Confirm()"><a href="http://localhost:8888/LibrarySystem_SSM/BrrowBooksAction.do?book_id=${bk.book_id }"><font color="#8B7355">借阅</font></a></button>
				  							<c:if test="${sessionScope.ident=='a' }">
				  								<button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#9400D3;"><a href="http://localhost:8888/LibrarySystem_SSM/AlterBookInformationAction.do?book_id=${bk.book_id }"><font color="#A020F0">修改</font></a></button>
				  							</c:if>
				  						</center>
			  						</c:when>
			  						<c:otherwise>
			  							<center>
				  							<c:if test="${bk.book_count<=0 }">
				  								<button disabled="disabled" type="button" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;" onclick="var_Confirm()"><font color="#8B7355">借阅</font></a></button>
				  							</c:if>
				  							<c:if test="${sessionScope.ident=='a' }">
				  								<button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#9400D3;"><a href="http://localhost:8888/LibrarySystem_SSM/AlterBookInformation?book_id=${bk.book_id }"><font color="#A020F0">修改</font></a></button>
				  							</c:if>
				  						</center>
			  						</c:otherwise>
			  						</c:choose>
			  				   </td>
			  					<%-- <td><center><button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;"><a href="http://localhost:8888/LibrarySystem/BrrowBooks?book_id=${bk.book_id }">借阅</a></button></center></td> --%>
			  				</tr>
			  			</c:forEach>
			  		</table>
		  		</div>
    		</c:if>
    	</div>
    </form>
    </center>
    </c:if>
    <c:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="http://localhost:8888/LibrarySystem_SSM/Login.do"></jsp:forward>
    </c:if>
  </body>
</html>
