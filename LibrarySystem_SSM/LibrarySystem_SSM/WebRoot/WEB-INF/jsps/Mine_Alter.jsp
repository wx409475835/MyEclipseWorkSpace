<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>读者信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
			function validate_email(field,alerttxt)
			{
				with (field)
				{
					apos=value.indexOf("@");
					dotpos=value.lastIndexOf(".");
					if (apos<1||dotpos-apos<2) 
					  {alert(alerttxt);return false;}
					else {return true;}
					}
				}
			
			function validate_form(thisform)
			{
				with (thisform)
				{
					if (validate_email(email,"请输入正确的邮件格式!")==false)
					  {email.focus();return false;}
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
		input,font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
	</style>
  </head>
  
  <body>
     <p:if test="${ sessionScope.Login!=null}">
    	<div>
	     <form action="AlterMineInformationAction.do" method="post">
	     	<p:forEach items="${ sessionScope.Mine }" var="pd">
	     		<table align="center" style="width: 335px;height: 100px;">
	     		<tr>
	     			<td><strong><font color="blue" size="5">I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D:</font></strong></td><td><input type="text" name="id" value="${ pd.person_id }" style="width: 210px;height: 35px;font-size:20px;" disabled="disabled"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</font></strong></td><td><input type="text" name="name" value="${ pd.person_name }" style="width: 210px;height: 35px;font-size:20px;"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">年&nbsp;&nbsp;&nbsp;&nbsp;龄:</font></strong></td><td><input type="text" name="age" value="${ pd.person_age }" style="width: 210px;height: 35px;font-size:20px;"/></td>
	     		</tr>
	     		<p:if test="${ pd.person_sex =='男'}">
	     			<tr>
		     			<td><strong><font color="blue" size="5">性&nbsp;&nbsp;&nbsp;&nbsp;别:</font></strong></td><td><input name="sex" readonly="readonly"  style="width: 30px;height: 20px;"  type="radio" checked="checked" value="男"/><font color="green" size="4"><strong>男</strong></font>
		     			&nbsp;&nbsp;&nbsp;&nbsp;<input  style="width: 20px;height: 20px;" type="radio" name="sex" value="女" readonly="readonly"/><font color="green" size="4"><strong>女</strong></font></td>
	     			</tr>
	     		</p:if>
	     		<p:if test="${ pd.person_sex =='女'}">
	     			<tr>
		     			<td><strong><font color="blue" size="5">性&nbsp;&nbsp;&nbsp;&nbsp;别:</font></strong></td><td><input value="男" name="sex" readonly="readonly"  style="width: 30px;height: 20px;" type="radio"/><font color="green" size="4"><strong>男</strong></font>
		     			&nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 20px;height: 20px;" checked="checked" value="女" name="sex" readonly="readonly" type="radio"/><font color="green" size="4" ><strong>女</strong></font></td>
	     			</tr>
	     		</p:if>
	     		<tr>
	     			<td><strong><font color="blue" size="5">微&nbsp;&nbsp;&nbsp;&nbsp;信:</font></strong></td><td><input name="we" style="width: 210px;height: 35px;font-size:20px;" value="${ pd.person_we }" type="text"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</font></strong></td><td><input name="com" style="width: 210px;height: 35px;font-size:20px;" value="${ pd.person_com }" onblur="validate_form(this)" type="email"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">手&nbsp;机&nbsp;号:</font></strong></td><td><input name="phone" style="width: 210px;height: 35px;font-size:20px;" value="${ pd.person_mobile }" type="text"/></td>
	     		</tr>
	     		<tr>
	     			<td><strong><font color="blue" size="5">地&nbsp;&nbsp;&nbsp;&nbsp;址:</font></strong></td><td><input name="add" style="width: 210px;height: 30px;font-size:20px;" value="${ pd.person_add }" type="text"/></td>
	     		</tr>
	     		<tr style="height: 120px;">
		     		<td align="center" colspan="2">
		     			<input onclick="var_null()" type="submit" value="提交" style="width: 110px;background-color:transparent; border-radius: 8px;height:40px;color:#38B738;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     			<input type="submit" value="返回" style="width:110px;background-color:transparent;border-radius: 8px;height:40px;color:#1818D7;"  formaction="Mine.do"/>
		     		</td>
	     		</tr>
	     	</table>
	     	</p:forEach>
     	</form>
     </div>
  
    </p:if>
    <p:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="http://localhost:8888/LibrarySystem_SSM/Login.do"></jsp:forward>
    </p:if>
     
     <script type="text/javascript">
     	function var_null(){
				alert("个人信息修改成功!");
		}
     </script>
  </body>
</html>
