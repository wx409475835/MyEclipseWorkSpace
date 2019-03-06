<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新病人信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/UpdatePatient.js"></script>
 	<script type="text/javascript" src="js/home_refresh.js"></script>
 	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
 	<script type="text/javascript" src="js/Submit.js"></script>
 	<style type="text/css">
 		.Birthday{
 			width: 650px;
			height: 40px; 
 		}
 	</style>
  </head>
 
  <body>
  	<div class="addcount-div1">
  		<p>修改病人信息/Update Patients Informations</p>
  		<c:if test="${Account ==null || Account==''}">
	  		<div class="Right_Index">
			  	<div id="div5"><img src="images/home.png" alt="homeLogo"/></div>
			  	<div id="div6"><img src="images/sign_out.png" alt="sign_out"/></div>
			  	<div id="div7"><img src="images/sign_in.png" alt="sign_in"/></div>
			  	<div id="div8"><img src="images/refresh.png" alt="refresh"/></div>
			</div>
		</c:if>
		<c:if test="${Account !=null}">
			<div class="Right_Index">
			  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
			  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
			  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
			  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
			</div>
		</c:if>
  	</div>
     	<div class="addcount-div2">
	    <form method="post" action="UpdateHPatientAction.do">
	    	<table>
	    			<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hp_id" readonly="readonly" value="${SelectPatientById_hPatient.hp_id }"/></td>
		    		</tr>
		    		<tr>
		    			<td>医生编号
		    				<input type="hidden" id="hp_doctorid" value="${SelectPatientById_hPatient.hp_doctorid }"/>
							<select class="addconut-input" id="up-sel-doctodid" name="hp_doctorid"></select>
						</td>
		    		</tr>
		    		<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hp_name" value="${SelectPatientById_hPatient.hp_name }"/></td>
		    		</tr>
		    		<tr>
		    			<c:if test="${SelectPatientById_hPatient.hp_sex == '男' }">
		    				<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex" type="radio" value="男" name="hp_sex" checked="checked"/>男 &nbsp;<input class="addconut-input-sex" type="radio" value="女" name="hp_sex"/>女</td>
		    			</c:if>
		    			<c:if test="${SelectPatientById_hPatient.hp_sex == '女' }">
		    				<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex"  type="radio" value="男" name="hp_sex"/>男 &nbsp;<input class="addconut-input-sex" type="radio" value="女" name="hp_sex" checked="checked"/>女</td>
		    			</c:if>
		    			
		    		</tr>
		    		<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;生&nbsp;日&nbsp;&nbsp;
		    				<input class="addconut-input" style="width: 400px" type="text" name="hp_birthday" class="Wdate" id="date" value="${SelectPatientById_hPatient.hp_birthday }"/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>入院时间
		    				<input class="addconut-input" style="width: 400px;" type="text" name="hp_tath" class="Wdate"  value="${SelectPatientById_hPatient.hp_tath }" id="tath-date"/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>症状描述<input class="addconut-input" type="text" value="${SelectPatientById_hPatient.hp_tsd }" name="hp_tsd"/></td>
		    		</tr>
		    		<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;婚&nbsp;否
		    				<input type="hidden" id="up-inp-marry" value="${SelectPatientById_hPatient.hp_marry}"/>
							<select class="addconut-input" id="up-sel-marry" name="hp_marry">
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</td>
		    		</tr>
		    		<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;状&nbsp;态
		    				<input type="hidden" id="up-inp-stat" value="${SelectPatientById_hPatient.hp_stat}"/>
							<select class="addconut-input" name="hp_stat">
								<option value="优">优</option>
								<option value="良">良</option>
								<option value="差">差</option>
								<option value="很差">很差</option>
							</select>
						</td>
		    		</tr>
		    		<tr>
		    			<td>
		    				<input type="hidden" name="hp_mrid" value="${SelectPatientById_hPatient.hp_mrid}"/>
		    				<input id="submit" onclick="return Checksubmit()" class="submit" type="submit" value="确认修改"/>
		    			</td>
		    		</tr>
	    	</table>
	    </form>
	  </div>
  </body>
</html>
