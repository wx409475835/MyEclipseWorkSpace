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
    
    <title>更新科室信息</title>
    
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
	<script type="text/javascript">
		$(function(){
			var options = $("select[name='haoto_name'] option");
			var inputval = $("input[name='ah-inp']").get(0).value;
			for(var i=0;i<$(options).length;i++){
				if($(options[i]).val() == inputval){
					$(options[i]).prop("selected",true);
				}
			}
		});
		
		function CheckPerson(){
			var sub = document.getElementById("submit");
			var person = $("[name='haoto_person']").val();
	
			if(person=="" ||person==''){
				$("#haoto_person").text("科室负责人不能为空");
				$("#haoto_person").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#haoto_person").text("");
				sub.disabled=false;
				return true;
			}
		}
		
		function CheckDecribe(){
			var sub = document.getElementById("submit");
			var decribe = $("[name='haoto_decribe']").val();
	
			if(decribe=="" ||decribe==''){
				$("#haoto_decribe").text("科室描述不能为空");
				$("#haoto_decribe").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#haoto_decribe").text("");
				sub.disabled=false;
				return true;
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>修改医院科室信息/Update HospitalAdministrative or teacjnical offices Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>	
  	</div>
      <div class="addcount-div2">
	     <form action="AlterHaotoAction.do" method="post">
	     	<table>
	     		<c:forEach items="${SelectHaotoById_hAoto }" var="hAoto">
		     		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;<input class="addconut-input" name="haoto_id" value="${hAoto.haoto_id }"/></td></tr>
		     		<tr>
						<td>&nbsp;&nbsp;&nbsp;科室名称
							<input name="ah-inp" type="hidden" value="${hAoto.haoto_name }"/>
							<select class="addconut-input" name="haoto_name">
								<option value="内科">内科</option>
								<option value="外科">外科</option>
								<option value="妇产科">妇产科</option>
								<option value="儿科">儿科</option>
								<option value="耳鼻喉科">耳鼻喉科</option>
								<option value="内分泌科">内分泌科</option>
								<option value="骨科">骨科</option>
								<option value="肝胆外科">肝胆外科</option>
								<option value="泌尿外科">泌尿外科</option>
								<option value="心脑血管科">心脑血管科</option>
								<option value="肛肠外科">肛肠外科</option>
								<option value="神经外科">神经外科</option>
								<option value="乳腺甲状腺外科">乳腺甲状腺外科</option>
								<option value="消化内科">消化内科</option>
								<option value="呼吸内科">呼吸内科</option>
								<option value="中医、中西医结合科">中医、中西医结合科</option>
								<option value="血液、肿瘤科">血液、肿瘤科</option>
								<option value="肾内科">肾内科</option>
								<option value="检验科">检验科</option>
								<option value="B超室 心电图室">B超室 心电图室</option>
							</select>
					</td>
					</tr>
		     		<tr><td>科室负责人<input onblur="return CheckPerson()"  class="addconut-input" name="haoto_person" value="${hAoto.haoto_person }"/>&nbsp;<span id="haoto_person"></span></td></tr>
		     		<tr><td>&nbsp;&nbsp;&nbsp;科室描述<input onblur="return CheckDecribe()" class="addconut-input" name="haoto_decribe" value="${hAoto.haoto_decribe }"/>&nbsp;<span id="haoto_decribe"></span></td></tr>
		     		<tr><td><input id="submit" class="submit" type="submit" value="确认修改"/></td></tr>
	     		</c:forEach>
	     	</table>
	     </form>
	    </div>
  </body>
</html>
