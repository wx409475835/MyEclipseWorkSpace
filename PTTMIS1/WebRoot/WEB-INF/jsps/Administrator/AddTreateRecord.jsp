<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加诊断记录</title>
    
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
  	<script type="text/javascript" src="js/Submit.js"></script>
  <script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#atr-btn-time").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
  			//获病人ID
  			var hp_doctorid ;
  			$.ajax({
  				type:"post",
  				url:"SelectAllHp_idsAction.do",
  				success:function(result){
  				console.log(result);
  					var hp_ids = $.parseJSON(result);
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htr_patientid']").append(option);
  					}
  				}
  			});
  			//获取 医生ID
  			$.ajax({
  				type:"post",
  				url:"SelectAllHd_idsAction.do",
  				success:function(result){
  				console.log(result);
  					var hp_ids = $.parseJSON(result);
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htr_doctorid']").append(option);
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
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htr_aotoid']").append(option);
  					}
  				}
  			});
  			
  			
  			//设置选中状态
  			//拿到病人ID
  			var hp_id ;
  			var hd_id ;
  			$("[name='htr_patientid']").change(function(){
  				var op = $("[name='htr_patientid'] option");
  				for(var i=0;i<$(op).length;i++){
  					if($(op[i]).prop("selected")){
  						hp_id = $(op[i]).prop("value");
  					}
  				}
  				//发送Ajax请求获得doctorid 
  				$.ajax({
	  				type:"post",
	  				url:"SelectPatientByIdAction.do",
	  				data:"hp_id="+hp_id,
	  				success:function(result){
	  				console.log(result);
	  					var hp = $.parseJSON(result);
	  					var doctorid = hp.hp_doctorid;
	  					var doctors = $("[name='htr_doctorid'] option");
	  					for(var i=0;i<$(doctors).length;i++){
	  						if($(doctors[i]).prop("value") == doctorid){
	  							$(doctors[i]).prop("selected",true);
	  							hd_id = $(doctors[i]).prop("value");
	  						}
	  					}
	  					
	  					//再次发送Aajx请求  为了是获得科室ID,设置科室ID选中状态
	  					$.ajax({
			  				type:"post",
			  				url:"SelectDoctorAccountAction.do",
			  				data:"hd_id="+hd_id,
			  				success:function(result){
			  					var hd = $.parseJSON(result);
			  					var hd_haotoid = hd.hd_haotoid;
			  					var hd_doctor = $("[name='htr_aotoid'] option");
			  					for(var i=0;i<$(hd_doctor).length;i++){
			  						if($(hd_doctor[i]).prop("value") == hd_haotoid){
			  							$(hd_doctor[i]).prop("selected",true);
			  						}
			  					}
			  				}
			  			});
	  				}
	  			});
  			
  			});	
  		});
  	</script>
	
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>添加诊断记录信息/Add Treate Records Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     <div class="addcount-div2">
	    <form method="post" action="InsertRecordAction.do" onsubmit="return Checksubmit()">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;病&nbsp;人&nbsp;I&nbsp;D&nbsp;&nbsp;
	    				<select class="addconut-input" name="htr_patientid"></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>主治医生ID
	    				<select class="addconut-input" name="htr_doctorid"></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;科&nbsp;室&nbsp;I&nbsp;D&nbsp;&nbsp;
	    				<select class="addconut-input" name="htr_aotoid"></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;诊治时间&nbsp;&nbsp;<input placeholder="请选择诊治时间" class="addconut-input" type="text" name="htr_treatetime" class="Wdate" id="atr-btn-time"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;诊治次数&nbsp;&nbsp;<input placeholder="请输入诊断次数" class="addconut-input"  type="text" name="htr_treatetimes"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;诊治详情&nbsp;&nbsp;<input placeholder="请输入诊治详情" class="addconut-input"  type="text" name="htr_treatecase"/></td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<input class="submit" onclick="return Checksubmit()" type="submit" value="确认添加"/>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	  </div>
  </body>
</html>
