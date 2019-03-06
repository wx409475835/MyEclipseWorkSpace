<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>病人相关数据管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		ul li{
			float:left;
			list-style: none;
			margin:0 10px;
		}
		a{
			color: blue;
			text-decoration: none;
		}
		a:hover{
			color:orange;
			text-decoration: underline;
		}
	</style>
  </head>
  
  <body>
     <ul>
     	<li><a href="SelectAllPatientsActions.do">病人信息管理</a></li>
     	<li><a href="SelectAllHPatientsEmrAction.do">电子病历管理</a></li>
     	<li><a href="SelectAllDrugsAction.do">药品管理</a></li>
     	<li><a href="SelectAllTreateRecordsAction.do">诊断记录管理</a></li>
     	<li><a href="PatientUssDrug.do">病人用药信息管理</a></li>
     </ul>
  </body>
</html>
