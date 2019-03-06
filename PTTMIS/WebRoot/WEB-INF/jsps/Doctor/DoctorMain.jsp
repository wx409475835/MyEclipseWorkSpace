<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

  </head>
  
  <frameset rows="70px,30px,*,50px" border="1">
  	<frame src="doctor/DoctorMainTop.do" name="MainTop" scrolling="no" noresize="noresize" frameborder="1">
 	<frame src="doctor/DoctorMainIndex.do" name="MainIndex" scrolling="no" noresize="noresize" frameborder="1">
 	<frame src="doctor/Main.do" scrolling="auto" name="MainCenter" noresize="noresize">
 	<frame src="MainCenterBottom.do" name="MainBottom" scrolling="no" noresize="noresize" frameborder="1">
  </frameset>
</html>
