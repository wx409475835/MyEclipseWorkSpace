<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册医生用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/Submit.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript">
		function JudgeDoctor(){
				var sub = document.getElementById("submit");
				var hd_name = $("[name='hd_name']").val();
				$.ajax({
					type:"post",
					url:"doctor/JudgeDoctorNameAction.do",
					data:"hd_name="+hd_name,
					success:function(result){
						if(result=="姓名已经存在"){
							$("#hd_name").text(result);
							$("#hd_name").css("color","red");
							sub.disabled=true;
							return false;
						}else{
							$("#hd_name").text(result);
							$("#hd_name").css("color","green");
							sub.disabled=false;
							return true;
						}
					}
				});
			}
			
		$(document).ready(function(){
			//发送Ajax 请求  获得hospital_aoto(科室表)中的所有的科室ID-->haoto_id
			$.ajax({
				type:"post",
				url:"SelectAllHaotoidFromHAotoAction.do",
				success:function(result){
					console.log(result);
					//result 从后台拿到的是一个 json 字符串 我们首先需要将json 转换为js对象使用
					var haoto_ids = $.parseJSON(result);		//haoto_ids 则为 js 数组对象
					for(var i=0;i<$(haoto_ids).length;i++){
						//首先我们 需要清空当前 select 里边得所有内容
						//$("#aotoid").empty();
						//创建 options 将获得得数据插入到option 里边
						var option = $("<option value='"+haoto_ids[i]+"'>"+haoto_ids[i]+"</option>");
						//创建options 后需要将其挂在 select 标签里边
						$("#aotoid").append(option);
					}
				}
			});
		});
		
		function CheckAge(){
			var sub = document.getElementById("submit");
			var age = $("[name='hd_age']").val();
			if(age <0 || age > 130){
				$("#hd_age").text("请输入的年龄在1-130范围内");
				$("#hd_age").css("color","red");
				sub.disabled=true;
				return false;
			}else if(isNaN(age)){
				$("#hd_age").text("请输入正确的年龄格式");
				$("#hd_age").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hd_age").text("");
				sub.disabled=false;
				return true;
			}
		}
		
		function CheckSpeciality(){
			var sub = document.getElementById("submit");
			var speciality = $("[name='hd_speciality']").val();
			if(speciality=="" || speciality==''){
				$("#hd_speciality").text("特长不能为空");
				$("#hd_speciality").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hd_speciality").text("");
				sub.disabled=false;
				return true;
			}
		}
		
		function CheckPhone(){
			var sub = document.getElementById("submit");
			var phone = $("[name='hd_mobile']").val();
			//15487854654654
			var mobile = /^\d{8,11}$/;
			if(mobile.test(phone)==false){
				$("#hd_mobile").text("手机号不是纯数字或位数小于8位或大于11位");
				$("#hd_mobile").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hd_mobile").text("");
				sub.disabled=false;
				return true;
			}
		}
		function CheckRi(){
			var sub = document.getElementById("submit");
			var ri = $("[name='hd_ri']").val();
			if(ri==''||ri==null){
				$("#hd_ri").text("预约信息不能为空");
				$("#hd_ri").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hd_ri").text("");
				sub.disabled=false;
				return true;
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>注册医生用户信息/Register Doctor Account Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     <div class="addcount-div2">
     	<form method="post" action="doctor/AddDoctorAccountAction.do" onsubmit="return JudgeDoctor() & Checksubmit()">
     	<table>
     		<tr>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;<input placeholder="请输入姓名" class="addconut-input" type="text" name="hd_name" onblur="return JudgeDoctor()"/>&nbsp;<span id="hd_name"></span></td>
     		</tr>
     		<tr>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;龄&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" placeholder="请输入年龄" type="text" name="hd_age" onblur="CheckAge()"/>&nbsp;<span id="hd_age"></span></td>
     		</tr>
     		<tr>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex" placeholder="请输入性别" type="radio" name="hd_sex" value="男" checked="checked"/>男 &nbsp;&nbsp; <input class="addconut-input-sex" type="radio" name="hd_sex" value="女"/>女</td>
     		</tr>
     		<tr>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;特&nbsp;长&nbsp;&nbsp;&nbsp;<input class="addconut-input" placeholder="请输入特长" type="text" onblur="return CheckSpeciality()" name="hd_speciality"/>&nbsp;<span id="hd_speciality"></span></td>
     		</tr>
     		<tr>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;职&nbsp;称&nbsp;&nbsp;
     			<select class="addconut-input" name="hd_pt">
     				<!-- <option value="管理员">管理员</option> -->
     				<option value="主任医师">主任医师</option>
     				<option value="副主任医师">副主任医师</option>
     				<option value="主治医生">主治医生</option>
     				<option value="医生" selected="selected">医生</option>
     				<option value="医士">医士</option>
     			</select>
     			</td>
     		</tr>
     		<tr>
     			<td>科室编号
					<select class="addconut-input" id="aotoid" name="hd_haotoid">
						
					</select>     				
     			</td>
     		</tr>
     		<tr>
     			<td>&nbsp;&nbsp;手机号&nbsp;&nbsp;<input class="addconut-input" placeholder="请输入手机号" onblur="return CheckPhone()" type="text" name="hd_mobile"/>&nbsp;<span id="hd_mobile"></span></td>
     		</tr>
     		<tr>
     			<td><span class="ri">预约信息</span>&nbsp;<textarea class="addconut-input"  placeholder="请输入预约信息" onblur="return CheckRi()" name="hd_ri"></textarea>&nbsp;<span id="hd_ri"></span></td>
     		</tr>
     		<tr>
     			<td><input class="submit" id="submit" type="submit" onclick="return Checksubmit()" value="注册用户"/></td>
     		</tr>
     	</table>
     </form>
     </div>
  </body>
</html>
