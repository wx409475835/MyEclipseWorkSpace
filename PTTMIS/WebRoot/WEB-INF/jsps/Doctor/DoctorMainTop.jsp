<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>南阳市中心医院病人跟踪治疗信息管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/top.js"></script>
  </head>
  
  <body>
  	<div class="div1">
  		<div class="div2">
  			<a href="javascript:void(0)"><img alt="hospitalLogo" src="images/HospitalLogo.png" border="0px"><span>南阳市中心医院病人治疗跟踪管理系统</span></a>
  		</div>
  		<div class="div3">
  			<img alt="TimeLogo" src="images/14.png">
  			<span id="TimeShow"></span>
  		</div>
  		<div class="div4">
  			<img alt="UserLogo" src="images/3.png">
  			<span id="LoginName"><font color="#698B22">${LoginName}</font></span>
  		</div>
  	</div>
  </body>
</html>
