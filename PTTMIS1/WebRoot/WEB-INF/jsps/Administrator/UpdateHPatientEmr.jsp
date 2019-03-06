<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新病人电子病历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#uhpe-starttime-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			$("#uhpe-endtime-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
  			
  		
			var hemr_id  = $("#uhpe-inp-hemr_id").val();
			//将治疗结束时间设置为全局变量  为的是方便下一个函数使用
			var uhpe_hemr_endtime ;
			console.log("hemr_id:"+hemr_id);
			$.ajax({
				type:"post",
				url:"SelectHPatientEmrByHemr_IdAction.do",
				data:"hemr_id="+hemr_id,
				success:function(result){
					console.log("hemr_result:"+result);
					var hEmr = $.parseJSON(result);
					uhpe_hemr_endtime = hEmr.hemr_endtime;
					console.log("hEmr:"+hEmr);
					var sel_hemr_treatisend = $("#uhpe-hemr_treatisend option");
					console.log("hEmr_hemr_treatisend:"+hEmr.hemr_treatisend);
					console.log($(sel_hemr_treatisend[0]));
					if(hEmr.hemr_treatisend == "是"){
						$(sel_hemr_treatisend[0]).prop("selected",true);
						$("#uhpe-endtime-date").prop("value",hEmr.hemr_endtime);
					}
					if(hEmr.hemr_treatisend == "否"){
						$(sel_hemr_treatisend[1]).prop("selected",true);
						$("#uhpe-endtime-date").parent().parent().hide();
					}
				}
			});
			//设置 下来列表选中状态
			$("#uhpe-hemr_treatisend").change(function(){
					var uhpe_hemr_ops = $("#uhpe-hemr_treatisend option");
					var uhpe_hemr_index = $("#uhpe-hemr_treatisend").get(0).selectedIndex;
					console.log("ops:"+uhpe_hemr_ops);
					console.log("index:"+uhpe_hemr_index);
					if(uhpe_hemr_index == 0){
						$("#uhpe-endtime-date").parent().parent().show();
						$("#uhpe-endtime-date").prop("value",uhpe_hemr_endtime);
					}
					if(uhpe_hemr_index == 1){
						$("#uhpe-endtime-date").prop("value","");
						$("#uhpe-endtime-date").parent().parent().hide();
					}
			});
			
	});
  	</script>

  </head>
  
  <body>
  <div class="addcount-div1">
  	<p>修改病人病历信息/Update Patients's Electronic Method Record Information</p>
  	<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  </div>
     	<div class="addcount-div2">
	   	<form method="post" action="UpdateHPatientEmrAction.do">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" id="uhpe-inp-hemr_id" name="hemr_id" type="text" readonly="readonly" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_id }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病人编号&nbsp;&nbsp;<input class="addconut-input" class="addconut-input" type="text" readonly="readonly" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_patientid }" name="hemr_patientid"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;医生编号&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_doctorid" readonly="readonly" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_doctorid }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;诊&nbsp;断&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_diagnosis" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_diagnosis }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病&nbsp;状&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_symptom" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_symptom }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;处&nbsp;方&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hemr_method" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_method }"/></td>
	    		</tr>
	    		<tr>
	    			<td>治疗开始时间&nbsp;<input class="addconut-input" type="text" name="hemr_starttime" value="${SelectHPatientEmrByHemr_Ids_hEmr.hemr_starttime }" class="Wdate" id="uhpe-starttime-date"/></td>
	    		</tr>
	    		<tr>
	    			<td>治疗是否结束
						<select class="addconut-input" id="uhpe-hemr_treatisend" name="hemr_treatisend">
							<option value="是">是</option>
							<option value="否">否</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>治疗结束时间&nbsp;<input placeholder="请选择治疗结束时间" class="addconut-input" type="text" name="hemr_endtime" id="uhpe-endtime-date" class="Wdate" /></td>
	    		</tr>
	    		<tr><td><input class="submit" type="submit" value="确认修改"/></td></tr>
	    	</table>
	    </form>
	   </div>
  </body>
</html>
