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
    
    <title>归还图书</title>
    
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
			alert("归还图书成功！\n期待着与您的下次相遇！");
		}
	</script>
	<style type="text/css">
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		input,font{
			font-family:  Arial, Helvetica, sans-serif;
			text-align: center;
		}
		.tr{
			background: #E5E5E5;
		}
		table{
			text-align: center;
		}
	</style>
  </head>
  <body>
    <m:if test="${ sessionScope.Login!=null}">
    	<center>
	    <form action="SelectBookAsIdInBook_CopyAction.do" method="post">
	    	<div><br/><br/><br/><br/><br/>
	  		<input placeholder="请输入需要归还图书的ID" style="width: 210px;height: 35px;" name="book_id" type="text"/>&nbsp;&nbsp;
	  		<input type="submit" value="查询" style="width: 60px;height: 30px;color:#38B738;"/> 
		  	</div>
		  		<br/>
		    	<div>
		    		<m:if test="${ sessionScope.SelectBookAsIdInBook != null && sessionScope.SelectBookAsIdInBook !='[]'}">
		    		<div>
		    			<m:if test="${sessionScope.brrow !='[]' && sessionScope !=null}">
				    	<table align="center" bgcolor="#FCFCFC" border="1">
				  			<tr style="height: 30px">
				  				<th><strong><font class="d1">记录 Id</font></strong></th>
				  				<th><strong><font class="d1">图书 Id</font></strong></th>
					    		<th><strong><font class="d1">图书名称</font></strong></th>
					    		<th><strong><font class="d1">图书类型</font></strong></th>
					    		<th><strong><font class="d1">图书数量</font></strong></th>
					    		<th><strong><font class="d1">出 版 社</font></strong></th>
					    		<th><strong><font class="d1">执行操作</font></strong></th>
				  			</tr>
				  			<m:forEach items="${ sessionScope.SelectBookAsIdInBook }" var="bk">
				  				<tr>
				  					<td><strong><font size="4">${bk.read_id }</font></strong></td>
				  					<td><strong><font size="4">${bk.book_id }</font></strong></td>
				  					<td><strong><font size="4"><%="《" %>${bk.book_name }<%="》  " %></font></strong></td>
				  					<td><strong><font size="4">${bk.book_type }</font></strong></td>
				  					<td><strong><font size="4">${bk.book_count }</font></strong></td>
				  					<td><strong><font size="4">${bk.book_add }</font></strong></td>
				  					<td><center><button type="button" style="width: 80px;height: 30px;border-radius:5px;color:#6B8E23;" onclick="var_Confirm()"><a href="${basePath }ReturnBooksAction.do?book_id=${bk.book_id }">归还</a></button></center></td>
				  				</tr>
				  			</m:forEach>
				  		</table>
				  		</m:if>
			  		</div>
			  		</m:if>
			  		<m:if test="${ sessionScope.SelectBookAsIdInBook =='NotBook'}">
		    			<script type="text/javascript">
		    				alert("对不起,你没有借阅该图书,不能归还!");
		    			</script>
	    			</m:if>
		    	</div>
	    </form>
    </center> 	
    </m:if>
    <m:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="${basePath }Login.do"></jsp:forward>
    </m:if>
  </body>
</html>
