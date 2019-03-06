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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<link rel="icon" href="images/htmllogo.png">

  </head>
  <frameset rows="65px,*" border="1">
	  	<frame src="AdministratorMainTop.do" name="MainTop" scrolling="no" noresize="noresize">
	  	<frameset cols="260px,*" border="1">
			<frame src="AdministratorMainIndex.do" name="MainIndex" scrolling="auto" noresize="noresize">
			<frameset rows="*,50px">
				<frame src="Main.do" name="MainCenterTop" scrolling="auto" noresize="noresize">
				<frame src="MainCenterBottom.do" name="MainCenterBottom" scrolling="auto" noresize="noresize">
			</frameset>
		</frameset>
	 	<!--<frame src="" name="MainIndex" scrolling="auto">-->
 	</frameset>
</html>
