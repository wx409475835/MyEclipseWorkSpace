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
 	<link href="css/Index.css" rel="stylesheet" type="text/css">
 	<script type="text/javascript" src="js/jquery-1.8.3.js"></script> 
 	<script type="text/javascript">
 		$(function(){
 			$("#LoginOut").click(function(){
 				$(this).removeAttr("href");
 				var boolean = confirm("您确认要退出登陆吗?");
 				console.log("boolean:"+boolean);
 				if(boolean==true){
 					window.location.href="AdministratorLoginOut.do";
 				}else{
 					$(this).prop("href","javascript:void(0);");
 				}
 			});
 		});
 	</script>
 	<style type="text/css">
 		a:ACTIVE {
			font-family: 微软雅黑;
			color:black;
		}
		a:LINK {
			font-family: 微软雅黑;
			color: #551a8b;
		}
 	</style>
  </head>
  
  <body>
   <div class="index-div">
    <ul>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/home.png" alt="MainLogo"/><a class="index-div-li-a shouye" target="MainCenterTop" href="Main.do">首页</a></li>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/AccountLogo.png" alt="AccountLogo"/><a class="index-div-li-a" target="MainCenterTop" href="SelectAllDoctorAccountAction.do">用户管理</a></li>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/HaotoLogo.png" alt="HaotoLogo"/><a class="index-div-li-a" target="MainCenterTop" href="SelectAllHaotoAction.do">医院科室部门管理</a></li>
    	<li class="index-div-li index-div-li-data"><img class="index-div-li-img" src="images/DataLogo.png" alt="DataLogo"/><span class="index-div-li-span">病人相关数据管理</span><img class="index-div-li-img" src="images/DataRightLogo.png" alt="DataRightLogo"/></li>
    	
    	<li class="index-div-li-dataSoutce"><img class="img1" src="images/PatientLogo.png" alt="PatientLogo"/><a target="MainCenterTop" href="SelectAllPatientsActions.do">病人信息管理</a></li>
    	<li class="index-div-li-dataSoutce"><img src="images/EmrLogo.png" alt="EmrLogo"/><a target="MainCenterTop" href="SelectAllHPatientsEmrAction.do">电子病历管理</a></li>
    	<li class="index-div-li-dataSoutce"><img src="images/DrugLogo.png" alt="DrugLogo"/><a target="MainCenterTop" href="SelectAllDrugsAction.do">药品管理</a></li>
    	<li class="index-div-li-dataSoutce"><img src="images/TreateLogo.png" alt="TreateLogo"/><a target="MainCenterTop" href="SelectAllTreateRecordsAction.do">诊断记录管理</a></li>
   		<li class="index-div-li-dataSoutce"><img src="images/PatientUseDrugLogo.png" alt="PatientUseDrugLogo"/><a target="MainCenterTop" href="PatientUssDrug.do">病人用药信息管理</a></li>
    	
    	<li class="index-div-li"><img class="index-div-li-img" src="images/InformLogo.png" alt="InformLogo"/><a class="index-div-li-a" target="MainCenterTop" href="SelectAllInformsAction.do">通知管理</a></li>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/TreateMoneyLogo.png" alt="TreateMoneyLogo"/><a class="index-div-li-a" target="MainCenterTop" href="ShowPatientUseDrug.do">费用结算报表统计管理</a></li>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/EndLogo.png" alt="EndLogo"/><a class="index-div-li-a" target="MainCenterTop" href="SelectTreateMoneyAction.do">结算记录管理</a></li>
    	<li class="index-div-li"><img class="index-div-li-img" src="images/LoginOutLogo.png" alt="LoginOutLogo"><a id="LoginOut" class="index-div-li-a" target="MainCenterTop" href="AdministratorLoginOut.do">退出系统</a></li>
    </ul>
    <div class="index-div-li-div">
    	<div class="index-div1">
	    	<img src="images/GG.png" alt="GGLogo"/>&nbsp;&nbsp;<span>公告</span>
	    	<p>你用价值体现人生,我用科技绽开花朵! —— 南阳中心医院</p>
	    </div>
	    <div class="index-div2">
	    	<img src="images/KiKi.png" alt="KiKiLogo"/>&nbsp;<span>欢迎语</span>
	    	<p>欢迎使用南阳中心医院病人治疗跟踪信息管理系统。</p>
	    </div>
    </div>
   </div>
  </body>
</html>
