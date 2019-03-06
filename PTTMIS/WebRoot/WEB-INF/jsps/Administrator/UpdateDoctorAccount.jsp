<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新医生用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript" src="js/Submit.js"></script>
	<script type="text/javascript">
		$(function(){
			var options = $("select:first option");			//获得第一个select标签下边的所有option 选项
			var input = $("#sel-inp").prop("value");
			console.log(input);
			for(var i=0;i<options.length;i++){
				console.log($(options[i]).val());
				if($(options[i]).val() == input){
					console.log("==========");
					$(options[i]).prop("selected",true);
				}
			}
			//获取科室ID
			var haotoidval = $("#sele-inp").prop("value");
			console.log(haotoidval);
			$.ajax({
					type:"post",
					url:"SelectAllHaotoidFromHAotoAction.do",
					success:function(result){
						//result 从后台拿到的是一个 json 字符串 我们首先需要将json 转换为js对象使用
						var haoto_ids = $.parseJSON(result);		//haoto_ids 则为 js 数组对象
						for(var i=0;i<haoto_ids.length;i++){
							//首先我们 需要清空当前 select 里边得所有内容
							//$("#aotoid").empty();
							//创建 options 将获得得数据插入到option 里边
							var option = $("<option value='"+haoto_ids[i]+"'>"+haoto_ids[i]+"</option>");
							//创建options 后需要将其挂在 select 标签里边
							$("#aotoid").append(option);
							if(haoto_ids[i] == haotoidval){
								$(option).prop("selected",true);
							}
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
  		<p>修改医生用户信息/UpdateDoctorAccountInformation</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     	<div class="addcount-div2">
	     <form method="post" action="UpdateDoctorAccountAction.do">
	     	<table>
	     		<c:forEach items="${UpdateDcotorAccountSelectDoctorById_hDoctor}" var="hDoctor">
	     			<tr>
	     				<td>&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hd_id" value="${hDoctor.hd_id }" readonly="readonly"/></td>
	     			</tr>
	     			<tr>
	     				<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" name="hd_name" value="${hDoctor.hd_name }"/></td>
		     		</tr>
		     		<tr>
		     			<td>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;龄&nbsp;&nbsp;&nbsp;&nbsp;<input onblur="return CheckAge()" class="addconut-input" type="text" name="hd_age" value="${hDoctor.hd_age }"/>&nbsp;<span id="hd_age"></span></td>
		     		</tr>
		     		<tr>
		     			<c:if test="${hDoctor.hd_sex == '男' }">
		     				<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex" type="radio" name="hd_sex" value="男" checked="checked"/>男 &nbsp;&nbsp; <input class="addconut-input-sex" type="radio" name="hd_sex" value="女"/>女</td>
		     			</c:if>
		     			<c:if test="${hDoctor.hd_sex == '女' }">
		     				<td>&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input-sex" type="radio" name="hd_sex" value="男"/>男 &nbsp;&nbsp; <input class="addconut-input-sex" type="radio" name="hd_sex" value="女" checked="checked"/>女</td>
		     			</c:if>
		     		</tr>
		     		<tr>
		     			<td>&nbsp;&nbsp;&nbsp;&nbsp;特&nbsp;长&nbsp;&nbsp;&nbsp;<input onblur="return CheckSpeciality()" class="addconut-input" type="text" name="hd_speciality" value="${hDoctor.hd_speciality }"/>&nbsp;<span id="hd_speciality"></span></td>
		     		</tr>
		     		<tr>
		     			<td>&nbsp;&nbsp;&nbsp;&nbsp;职&nbsp;称&nbsp;&nbsp;
		     			<select class="addconut-input" name="hd_pt">
		     				<option value="主任医师">主任医师</option>
		     				<option value="副主任医师">副主任医师</option>
		     				<option value="主治医生">主治医生</option>
		     				<option value="医生" selected="selected">医生</option>
		     				<option value="医士">医士</option>
		     			</select>
		     			<input id="sel-inp" type="hidden" value="${hDoctor.hd_pt }"/>
		     			</td>
		     		</tr>
		     		<tr>
		     			<td>科室编号:
							<select class="addconut-input" id="aotoid" name="hd_haotoid"></select>
							<input id="sele-inp" type="hidden" value="${hDoctor.hd_haotoid }"/>     				
		     			</td>
		     		</tr>
		     		<tr>
		     			<td>&nbsp;&nbsp;手机号&nbsp;&nbsp;<input onblur="return CheckPhone()" class="addconut-input" type="text" name="hd_mobile" value="${hDoctor.hd_mobile }"/>&nbsp;<span id="hd_mobile"></span></td>
		     		</tr>
		     		<tr>
		     			<td>预约信息&nbsp;<textarea class="addconut-input" placeholder="请输入预约信息" onblur="return CheckRi()" name="hd_ri">${hDoctor.hd_ri }</textarea>&nbsp;<span id="hd_ri"></span></td>
		     		</tr>
		     		<tr>
		     			<td><input id="submit" onclick="return Checksubmit()" class="submit" type="submit" value="确认修改"/></td>
		     		</tr>
	     		</c:forEach>
	     	</table>
	     </form>
	   </div>
  </body>
</html>
