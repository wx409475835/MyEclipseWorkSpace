<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>南阳市中心医院病人治疗跟踪管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/DoctorIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style type="text/css"></style>
 	<script type="text/javascript">
 		$(function(){
 			$("#LoginOut").click(function(){
 				$(this).removeAttr("href");
 				var boolean = confirm("您确认要退出登陆吗?");
 				console.log("boolean:"+boolean);
 				if(boolean==true){
 					window.location.href="doctor/DoctorLoginOut.do";
 				}else{
 					$(this).prop("href","javascript:void(0);");
 				}
 			});
 		});
 	</script>
  </head>
  
  <body>
   <div class="index-div">
   	 <div class="index-div1">
    	<ul>
    		<li><img src="images/home.png" alt="MainLogo"/><a target="MainCenter" href="doctor/Main.do">首页</a></li>
    		<li><img src="images/Doctor_PatientLogo.png" alt="PatientLogo"/><a target="MainCenter" href="SelectAllPatientsActions.do">病人信息管理</a></li>
    		<li><img src="images/Doctor_EmrLogo.png" alt="Doctor_EmrLogo"/><a target="MainCenter" href="SelectAllHPatientsEmrAction.do">病人病历管理</a></li>
    		<li><img src="images/Doctor_PatientUseDrugLogo.png" alt="Doctor_PatientUseDrugLogo"/><a target="MainCenter" href="PatientUssDrug.do">病人用药信息管理</a></li>
    		<li><img src="images/Doctor_InformLogo.png" alt="Doctor_InformLogo"/><a target="MainCenter" href="doctor/SelectAllInformsAction.do">通知管理</a></li>
    		<li><img src="images/Doctor_TreateMoneyLogo.png" alt="Doctor_TreateMoneyLogo"/><a target="MainCenter" href="ShowPatientUseDrug.do">费用结算报表统计管理</a></li>
    		<li><img src="images/Doctor_EndMoneyLogo.png" alt="Doctor_EndMoneyLogo"/><a target="MainCenter" href="SelectTreateMoneyAction.do">结算记录管理</a></li>
    		<li><img src="images/Doctor_PasswordLogo.png" alt="Doctor_PasswordLogo"/><a target="MainCenter" href="doctor/SelectHl_usernameByHl_doctoridAction.do">密码管理</a></li>
    		<li><img src="images/Doctor_PersonalLogo.png" alt="Doctor_PersonalLogo"/><a target="MainCenter" href="doctor/DoctorMineInformationsAction.do">个人信息管理</a></li>
    		<li><img src="images/LoginOutLogo.png" alt="Doctor_LoginOutLogo"/><a target="MainCenter" id="LoginOut" href="doctor/DoctorLoginOut.do">退出系统</a><li>
    	</ul>
     </div>
   </div>
  </body>
</html>
