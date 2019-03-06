<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加病人病历</title>
    
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
  	<script type="text/javascript">
  		$(document).ready(function(){
			$("#starttime-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			$("#endtime-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			$("#endtime-date").prop("value","");
			$("#hemr_treatisend").change(function(){
				//设置 结束时间问题
				var ops = $("[name='hemr_treatisend'] option");
				 var sel = $("[name='hemr_treatisend']").get(0).selectedIndex;
				 console.log("-=-=-=:"+sel);
				 if(sel == 1){
				 	console.log($(ops[sel]).prop("value"));
				 	$("#endtime-date").parent().hide();
				 }
				 if(sel ==0){
				 	$("#endtime-date").parent().show();
				 }
			});
		});
  	</script>
  </head>
  
  <body>
  <div class="addcount-div1">
  	<p>添加病人病历信息/Add Patients's Electronic Method Record Information</p>
  	<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  </div>
     <div class="addcount-div2">
    <form method="post" action="AddPatientElectronicMedicalRecordAction.do">
    	<table>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病人编号&nbsp;&nbsp;<input class="addconut-input" type="text" readonly="readonly" value="${AddPatient_hp_id }" name="hemr_patientid"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病人姓名&nbsp;&nbsp;<input class="addconut-input" type="text" readonly="readonly" value="${AddPatient_hp_name }"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;医生编号&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_doctorid" readonly="readonly" value="${AddPatient_hp_doctorid }"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;诊&nbsp;断&nbsp;&nbsp;&nbsp;<input placeholder="请输入病人诊断情况" class="addconut-input" type="text" name="hemr_diagnosis"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病&nbsp;状&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_symptom" value="${AddPatient_hp_tsd }"/></td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;处&nbsp;方&nbsp;&nbsp;&nbsp;<input placeholder="请输入治疗处方" class="addconut-input" type="text" name="hemr_method"/></td>
    		</tr>
    		<tr>
    			<td>治疗开始时间&nbsp;<input class="addconut-input" type="text" name="hemr_starttime" value="${AddPatient_hp_tath }" class="Wdate" id="starttime-date"/></td>
    		</tr>
    		<tr>
    			<td>治疗是否结束
					<select class="addconut-input" id="hemr_treatisend" name="hemr_treatisend">
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
				</td>
    		</tr>
    		<tr>
    			<td>治疗结束时间&nbsp;<input placeholder="请选择治疗结束时间" class="addconut-input" type="text" name="hemr_endtime" id="endtime-date" class="Wdate"/></td>
    		</tr>
    		<tr><td><input class="submit" type="submit" value="提交"/></td></tr>
    	</table>
    </form>
    </div>
  </body>
</html>
