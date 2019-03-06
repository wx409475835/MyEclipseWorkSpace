<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="q"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上架图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
    	function var_null(thisform){
			with(thisform){
				if(value==""||value==null){
					alert("该输入框不能为空!");
					return false;
				}
			}
		}
		
		function var_login(){
			alert("添加图书成功!\n试试查看.");
		}
		
		function var_price(thisform){
     		with(thisform){
     			var en=document.getElementById("price").value;
	     		if(isNaN(en)){
	     			alert("请输入正确的图书价格！");
	     		}
     		}
     	}
     	
     	function var_count(thisform){
     		with(thisform){
     			var en=document.getElementById("count").value;
	     		if(isNaN(en)){
	     			alert("请输入正确的图书数量！");
	     		}
     		}
     	}
		
		function var_Scope_price(thisform){
			with(thisform){
				if(value<=0||value>=1000){
					alert("请输入正确的图书价格(0-999.99)");
				}
			}
		}
		function var_Scope_count(thisform){
			with(thisform){
				if(value<0||value>=100){
					alert("请输入正确的图书数量(0-99)");
				}
			}
		}
    </script>
	<style type="text/css">
		table,font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		table{
			text-align: center;
		}
	</style>
  </head>
  
  <body>
    <q:if test="${sessionScope.Login!=null }">
    	<form method="post" action="InsertBooksInformationAction.do">
    	<table align="center" style="width: 350px;height: 100px;">
     		<tr>
     			<td><strong><font color="blue" size="5">图书名称:</font></strong></td><td><input type="text" onblur="return var_null(this)" name="book_name" style="width: 210px;height: 35px;" placeholder="请输入书名"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">图书类型:</font></strong></td><td><input type="text" id="age" onblur="return var_null(this)" name="book_type" style="width: 210px;height: 35px;" placeholder="请输入类型"/></td>
     		</tr>
     		
     		<tr>
     			<td><strong><font color="blue" size="5">图书价格:</font></strong></td><td><input id="price" onblur="return var_null(this) & var_price(this) & var_Scope_price(this)" style="width: 210px;height: 35px;" name="book_price" type="text" placeholder="请输入价格"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">图书数量:</font></strong></td><td><input id="count" onblur="return var_null(this) & var_count(this) & var_Scope_count(this)" style="width: 210px;height: 35px;" name="book_count" type="text" placeholder="请输入数量"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">出&nbsp;版&nbsp;社:</font></strong></td><td><input onblur="return var_null(this)" style="width: 210px;height: 35px;" name="book_add" type="text" placeholder="请输入出版社"/></td>
     		</tr>
     		<tr style="height: 120px;">
	     		<td align="center" colspan="2">
	     			<input type="submit" value="提交" style="width: 110px;background-color:transparent; border-radius: 8px;height:40px;color:#38B738;" onclick="var_login()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     			<input type="reset" value="重置" style="width:110px;background-color:transparent;border-radius: 8px;height:40px;color:#1818D7;"  formaction="${basePath }Main.do"/>
	     		</td>
     		</tr>
     	</table>
    </form>
    </q:if>
    <q:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="${basePath }Login.do"></jsp:forward>
    </q:if>
    
    
  </body>
</html>
