<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改图书信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.form-signin {
					max-width: 550px;
					padding: 19px 29px 29px;
					margin:0 auto;
					background-color: #fff;
					border: 1px solid #e5e5e5;
					-webkit-border-radius: 5px;
					-moz-border-radius: 5px;
					border-radius: 5px;
					-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
					-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
					box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
				}
	</style>
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
			alert("修改图书信息成功!");
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
	
  </head>
  
  <body>
     <c:if test="${ sessionScope.Login!=null}">
    	<center>
    <form action="AlterBookInformation_ConfirmAction.do" method="post">
  		<br/>
    	<div>
    		<c:if test="${ sessionScope.BookInformations !='[]' and sessionScope.BookInformations !=null}">
	    	   <c:forEach items="${ sessionScope.BookInformations }" var="bk">
	    	<div>
				<table align="center" style="width: 350px;height: 100px;">
	     		<tr>
	     			<td><strong><font color="blue" size="5">图书&nbsp;I&nbsp;D:</font></strong></td><td><input value="${bk.book_id }" type="text" name="book_id" style="width: 210px;height: 35px;font-size:20px;" disabled="disabled"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">图书名称:</font></strong></td><td><input value="${ bk.book_name }" type="text" onblur="return var_null(this)" name="book_name" style="width: 210px;height: 35px;font-size:20px;"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">图书类型:</font></strong></td><td><input value="${bk.book_type }" type="text" id="age" onblur="return var_null(this)" name="book_type" style="width: 210px;height: 35px;font-size:20px;"/></td>
	     		</tr>
	     		
	     		<tr>
	     			<td><strong><font color="blue" size="5">图书价格:</font></strong></td><td><input id="price" value="${bk.book_price }" onblur="return var_null(this) & var_price(this) & var_Scope_price(this)" style="width: 210px;height: 35px;font-size:20px;" name="book_price" type="text"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">图书数量:</font></strong></td><td><input value="${bk.book_count }" onblur="return var_null(this) & var_Scope_count(this)" style="width: 210px;height: 35px;font-size:20px;" name="book_count" type="text"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">出&nbsp;版&nbsp;社:</font></strong></td><td><input value="${bk.book_add }" onblur="return var_null(this)" style="width: 210px;height: 35px;font-size:20px;" name="book_add" type="text"/></td>
	     		</tr>
	     		<tr style="height: 120px;">
		     		<td align="center" colspan="2">
		     			<input type="submit" value="提交" style="width: 110px;background-color:transparent; border-radius: 8px;height:40px;color:#38B738;" onclick="var_login()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     			<input type="submit" value="返回" style="width:110px;background-color:transparent;border-radius: 8px;height:40px;color:#1818D7;"  formaction="${basePath}SelectBooks.do"/>
		     		</td>
	     		</tr>
	     		</table>
			</div>
	    	   </c:forEach>
    		</c:if>
    	</div>
    </form>
    </center>
    </c:if>
    <c:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="${basePath}Login.do"></jsp:forward>
    </c:if>
  </body>
</html>
