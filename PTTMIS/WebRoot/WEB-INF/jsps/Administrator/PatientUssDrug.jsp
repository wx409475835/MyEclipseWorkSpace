<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>病人用药信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<link rel="stylesheet" type="text/css" href="css/patientusedrug.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript" src="js/patientusedrug.js"></script>
	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
	<style type="text/css"></style>
  </head>
  
  <body>
  	<div class="showallcount-div">
  		ID&nbsp;&nbsp;<input name="hemr_patientid" placeholder="请输入病人ID" type="text"/>
  		<button class="showallcount-btn" type="button" id="pud-btn-sel"><img src="images/search.png" alt="查询"/>查询</button>
  	</div>
     <div class="center-div">
     	<div class="addcount-div1">
	  		<p>病人病历信息/Patiuent Information</p>
	  		<c:if test="${Account ==null || Account==''}">
		  		<div class="Right_Index">
				  	<div id="div5"><img src="images/home.png" alt="homeLogo"/></div>
				  	<div id="div6"><img src="images/sign_out.png" alt="sign_out"/></div>
				  	<div id="div7"><img src="images/sign_in.png" alt="sign_in"/></div>
				  	<div id="div8"><img src="images/refresh.png" alt="refresh"/></div>
				</div>
			</c:if>
			<c:if test="${Account!=null }">
		  			<div class="Right_Index">
		  			<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  			<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  			<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  			<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		  		</div>
	  		</c:if>
	  	</div>
     	<table>	
     		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" type="text" name="hemr_id"/></td></tr>
     		<tr><td>&nbsp;&nbsp;&nbsp;病&nbsp;人&nbsp;I&nbsp;D&nbsp;&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" name="hemr_patientid" type="text"/></td></tr>
     		<tr><td>&nbsp;&nbsp;&nbsp;医&nbsp;生&nbsp;I&nbsp;D&nbsp;&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" type="text" name="hemr_doctorid" /></td></tr>
     		<tr><td>开始治疗时间<input class="center-div-input" readonly="readonly" type="text" name="hemr_starttime"/></td></tr>
     		<tr><td>治疗结束时间<input class="center-div-input" readonly="readonly" type="text" name="hemr_endtime"/></td></tr>
     		<tr><td>治疗是否结束<input class="center-div-input" readonly="readonly" type="text" name="hemr_treatisend"/></td></tr>
     		<tr><td>&nbsp;诊&nbsp;断&nbsp;详&nbsp;情&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" name="hemr_diagnosis" type="text"/></td></tr>
     		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;症&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" name="hemr_symptom" type="text"/></td></tr>
     		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;处&nbsp;&nbsp;&nbsp;方&nbsp;&nbsp;&nbsp;&nbsp;<input class="center-div-input" readonly="readonly" name="hemr_method" type="text" /></td></tr>
     		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;药&nbsp;名&nbsp;称&nbsp;<input class="drug_inp" name="hdrug_name" type="text"/> &nbsp;<button class="showallcount-btn drug-btn" type="button" id="pud-btn-sel-drug"><img src="images/search.png" alt="查询"/>查询</button></td></tr>
     	</table>
     </div>
     <div class="left_div">
     	<table border="1" cellpadding="0" cellspacing="0" align="center">
     		<thead>
     			<tr><th id="patient-left-div" colspan="8" align="center">病人用药信息</th></tr>
     			<tr>
	     			<th>ID</th>
	     			<th>名称</th>
	     			<th>价格(元)</th>
	     			<th>生产日期</th>
	     			<th>药品类型</th>
	     			<th>数量</th>
	     			<th>简介</th>
	     			<th>操作</th>
	     		</tr>
     		</thead>
     		<tbody id="pud-tb1"></tbody>
     	</table>
     </div>
     <div class="right_div">
     	<table border="1" cellpadding="0" cellspacing="0" align="center">
     		<thead>
     			<tr><th id="patient-right-div" colspan="7" align="center">药品信息</th></tr>
     			<tr>
	     			<th>ID</th>
	     			<th>名称</th>
	     			<th>价格(元)</th>
	     			<th>生产日期</th>
	     			<th>药品类型</th>
	     			<th>简介</th>
	     			<th>操作</th>
	     		</tr>
     		</thead>
     		<tbody id="pud-tb2"></tbody>
     	</table>
     </div>
  </body>
</html>
