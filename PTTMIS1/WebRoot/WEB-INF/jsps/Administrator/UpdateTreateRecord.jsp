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
    
    <title>更新诊断记录</title>
    
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
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#utr-inp-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			//获取 医生ID
  			$.ajax({
  				type:"post",
  				url:"SelectAllHd_idsAction.do",
  				success:function(result){
  				console.log(result);
  					var hp_ids = $.parseJSON(result);
  					var h_doctorid = $("#htr_doctorid").val();
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htr_doctorid']").append(option);
  					}
  					var doctor_options = $("[name='htr_doctorid'] option");
  					for(var j=0;j<$(doctor_options).length;j++){
  						if($(doctor_options[j]).prop("value") == h_doctorid){
  							$(doctor_options[j]).prop("selected",true);
  						}
  					}
  				}
  			});
  			//获取科室haoto_id
  			$.ajax({
  				type:"post",
  				url:"SelectAllHaotoidFromHAotoAction.do",
  				success:function(result){
  				console.log(result);
  					var hp_ids = $.parseJSON(result);
  					var h_aotoid = $("#htr_aotoid").val();
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htr_aotoid']").append(option);
  					}
  					var aotoid_opstions = $("[name='htr_aotoid'] option");
  					for(var i=0;i<$(aotoid_opstions).length;i++){
  						if($(aotoid_opstions[i]).prop("value") == h_aotoid){
  							$(aotoid_opstions[i]).prop("selected",true);
  						}
  					}
  				}
  			});
  			
  			//设置联动
  			var htr_doctorid;
  			var htr_haotoid ;	
  			$("[name='htr_doctorid']").change(function(){	
  				var doc_ops = $("[name='htr_doctorid'] option");
  				for(var i=0;i<$(doc_ops).length;i++){
  					if($(doc_ops[i]).prop("selected")){
  						htr_doctorid = $(doc_ops[i]).prop("value");
  					}
  				}
  				//发送Ajax请求获得hd_id 
  				$.ajax({
	  				type:"post",
	  				url:"SelectDoctorAccountAction.do",
	  				data:"hd_id="+htr_doctorid,
	  				success:function(result){
	  				console.log(result);
	  					var hp = $.parseJSON(result);
	  					htr_haotoid = hp.hd_haotoid;
	  					var doctors = $("[name='htr_aotoid'] option");
	  					for(var i=0;i<$(doctors).length;i++){
	  						if($(doctors[i]).prop("value") == htr_haotoid){
	  							$(doctors[i]).prop("selected",true);
	  						}
	  					}
	  				}
	  			});
  			});  			
  		});
  	</script>
  </head>
  
  <body>
  <div class="addcount-div1">
  	<p>修改诊断记录信息/Update Treate Records Informations</p>
  	<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  </div>
     	<div class="addcount-div2">
		    <form method="post" action="UpdateTreateRecordAction.do">
		    	<table>
		    		<tr>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;<input class="addconut-input" type="text" name="htr_id" readonly="readonly" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_id}"/></td>
		    		</tr>
		    		<tr>
		    			<td>&nbsp;病&nbsp;人&nbsp;I&nbsp;D&nbsp;<input class="addconut-input" type="text" name="htr_patientid" readonly="readonly" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_patientid}"/></td>
		    		</tr>
		    		<tr>
		    			<td>&nbsp;医&nbsp;生&nbsp;I&nbsp;D
		    				<input type="hidden" id="htr_doctorid" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_doctorid}"/>
							<select class="addconut-input" name="htr_doctorid"></select>
						</td>
		    		</tr>
		    		<tr>
		    			<td>科&nbsp;室&nbsp;I&nbsp;&nbsp;D
		    				<input type="hidden" id="htr_aotoid" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_aotoid}"/>
							<select class="addconut-input" name="htr_aotoid"></select>
						</td>
		    		</tr>
		    		<tr>
		    			<td>诊断时间&nbsp;<input class="addconut-input" type="text" class="Wdate" name="htr_treatetime" id="utr-inp-date" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_treatetime}"/></td>
		    		</tr>
		    		<tr>
		    			<td>诊断详情&nbsp;<input class="addconut-input" type="text" name="htr_treatecase" value="${SelectTreateRecordByHtr_id_hTreaterecord.htr_treatecase}"/></td>
		    		</tr>
		    		<tr>
		    			<td><input onclick="return Checksubmit()" class="submit" type="submit" value="确认修改"/></td>
		    		</tr>
		    	</table>
		    </form>
		 </div>
  </body>
</html>
