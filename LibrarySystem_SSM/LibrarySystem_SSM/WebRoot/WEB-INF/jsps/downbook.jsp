<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下架图书信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		table{
			text-align: center;
		}
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		input,font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
	</style>
	<script type="text/javascript">
    	function var_down(){
			alert("确定要下架该图书吗 ?");
		}
		
		function var_id(thisform){
     		with(thisform){
     			var en=document.getElementById("id").value;
	     		if(isNaN(en)){
	     			alert("请输入正确的图书ID！");
	     		}
     		}
     	}
    </script>
  </head>
  
  <body>
    <q:if test="${ sessionScope.Login!=null}">
    	<form action="DeleteBooksInformationAction.do" method="post">
    	<br/><br/><br/><br/><br/>
    	<center><font size="4"><b>ID:</b></font>
    	<input id="id" type="text" name="id" style="width: 210px;height: 35px;" placeholder="请输入要下架的图书ID" onblur="var_id(this)"/>&nbsp;&nbsp;
    	
    	<input type="submit" style="width: 60px;height: 30px;color:#38B738;"  value="下架"/>
    	</center>
    	
    	<br/>
    	<q:if test="${sessionScope.DeleteBooks !='[]' && sessionScope.DeleteBooks!=null}">
    		<table align="center" bgcolor="#FCFCFC" border="1px">
  			<tr style="height: 30px" class="tr">
  				<th><strong><font class="d1">图书 Id</font></strong></th>
	    		<th><strong><font class="d1">图书名字</font></strong></th>
	    		<th><strong><font class="d1">图书类型</font></strong></th>
	    		<th><strong><font class="d1">图书价格</font></strong></th>
	    		<th><strong><font class="d1">图书数量</font></strong></th>
	    		<th><strong><font class="d1">出 版 社</font></strong></th>
	    		<th><strong><font class="d1">图书状态</font></strong></th>
	    		<th><strong><font class="d1">执行操作</font></strong></th>
  			</tr>
  			<q:forEach items="${ sessionScope.DeleteBooks }" var="bk">
  				<tr>
  					<td><strong><font size="4">${bk.book_id }</font></strong></td>
  					<td><strong><font size="4"><%="《" %>${bk.book_name }<%="》" %></font></strong></td>
  					<td><strong><font size="4">${bk.book_type }</font></strong></td>
  					<td><strong><font size="4">${bk.book_price }</font></strong></td>
  					<td><strong><font size="4">${bk.book_count }</font></strong></td>
  					<td><strong><font size="4">${bk.book_add }</font></strong></td>
  					<center>
  						<q:if test="${bk.book_count >=1 }">
  							<td><strong><font size="4" color="green">可借阅</font></strong></td>
	  					</q:if>
	  					<q:if test="${bk.book_count==0 }">
  							<td><strong><font size="4" color="red">不可借阅</font></strong></td>
  						</q:if>	
  					</center>
  					<td>
  						<input name="id" value="${bk.book_id }" type="hidden"/>
  						<input type="submit" style="width: 80px;height: 30px;border-radius:5px;color:#8B7355;" onclick="var_down()" name="down" value="下架"></input>
  					</td>
  				</tr>
  			</q:forEach>
  		</table>
    	</q:if>
    </form>
    </q:if>
    <q:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="Login.do"></jsp:forward>
    </q:if>
  </body>
</html>
