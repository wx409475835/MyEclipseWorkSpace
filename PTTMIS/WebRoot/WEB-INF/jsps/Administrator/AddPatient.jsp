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
    
    <title>添加病人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
  	<script type="text/javascript">
		$(document).ready(function(){
			$("#date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			$("#tath-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			
			//发送Ajax 请求获得医生编号ID
			$.ajax({
				type:"post",
				url:"SelectAllHd_idsAction.do",
				success:function(result){
					console.log("SelectAllHd_idsAction:"+result);
					var hp_ids = $.parseJSON(result);			//json转化成js对象
					for(var i=0;i<$(hp_ids).length;i++){
						var op = $("<option value="+$(hp_ids)[i]+">"+$(hp_ids)[i]+"</option>");
						$("#hp_doctorid").append(op);	
					}
				}
			});
			
		});
		
		function JudgePatientName() {
			var sub = document.getElementById("submit");
			var hp_name = $("[name='hp_name']").val();
			console.log("hp_name:" + hp_name);
			$.ajax({
				type : "post",
				url : "doctor/JudgePatientNameAction.do",
				data : "hp_name=" + hp_name,
				success : function(result) {
					console.log("result:" + result);
					if (result == '姓名已经存在') {
						$("#hp_name").text(result);
						$("#hp_name").css("color", "red");
						sub.disabled = true;
						return false;
					} else {
						$("#hp_name").text(result);
						$("#hp_name").css("color", "green");
						sub.disabled = false;
						return true;
					}
				}
			});
		}
	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>添加病人信息/AddPatientInformation</p>
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
	    <form method="post" action="AddPatientAction.do" onsubmit="return JudgePatientName() & Checksubmit()">
	    	<table>
	    		<tr>
	    			<td>医生编号&nbsp;&nbsp;
						<select class="addconut-input" id="hp_doctorid" name="hp_doctorid"></select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;<input placeholder="请输入姓名" class="addconut-input" type="text" name="hp_name" onblur="return JudgePatientName()"/>&nbsp;<span id="hp_name"></span></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex" type="radio" value="男" name="hp_sex" checked="checked"/>男 &nbsp;<input class="addconut-input-sex" type="radio" value="女" name="hp_sex"/>女</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;生&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;<input placeholder="请选择生日" class="addconut-input" style="width: 650px" type="text" name="hp_birthday" class="Wdate" id="date"/></td>
	    		</tr>
	    		<tr>
	    			<td>入院时间&nbsp;&nbsp;<input placeholder="请选择入院时间" class="addconut-input" style="width: 650px;" type="text" class="Wdate" name="hp_tath" id="tath-date"/></td>
	    		</tr>
	    		<tr>
	    			<td>症状描述&nbsp;&nbsp;<input placeholder="请输入症状描述" class="addconut-input" type="text" name="hp_tsd"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;婚&nbsp;否&nbsp;&nbsp;
						<select class="addconut-input" name="hp_marry">
							<option value="是">是</option>
							<option value="否">否</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;状&nbsp;态&nbsp;&nbsp;
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
	    				<input class="submit" id="submit" type="submit" onclick="return Checksubmit()" value="确认添加"/>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	   </div>
  </body>
</html>
