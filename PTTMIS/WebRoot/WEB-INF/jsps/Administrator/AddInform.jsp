<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加通知信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript">
		$(function(){
			var date = new Date();
			var today = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			$.ajax({
				type:"post",
				url:"SelectAllByHa_idAction.do",
				success:function(result){
					var hp = $.parseJSON(result);
					var ha_id = hp.ha_id;
					var ha_username = hp.ha_username;
					$("[name='hi_personid']").prop("value",ha_id);
					$("#hi_personname").prop("value",ha_username);
				}
			});
			$("#af-inp-date").prop("value",today);
		});
		function GetHi_personname(){
			var hi_id = $("[name='hi_personid']").val();
			$.ajax({
				type:"post",
				url:"SelectHi_personNameByHi_idAction.do",
				data:"hi_id="+hi_id,
				success:function(result){
					$("#hi_personname").prop("value",result);
				}
			});
		}
		
		function CheckContent(){
			var sub = document.getElementById("submit");
			var content = $("[name='hi_content']").val();
			if(content =='' || content ==null){
				$("#hi_content").text("通知内容不能为空");
				$("#hi_content").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hi_content").text("");
				sub.disabled=false;
				return true;
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>添加通知信息/Add Informs Informations</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     <div class="addcount-div2">
	      <form method="post" action="AddInformsAction.do" onsubmit="return Checksubmit()">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" type="text" placeholder="请输入管理员ID" onblur="return GetHi_personname()" name="hi_personid"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;通&nbsp;知&nbsp;人&nbsp;<input class="addconut-input" type="text" id="hi_personname" readonly="readonly"/></td>
	    		</tr>
	    		<tr>
	    			<td>通知时间&nbsp;<input class="addconut-input" type="text" name="hi_tet" id="af-inp-date" readonly="readonly"/></td>
	    		</tr>
	    		<tr>
	    			<td>通知内容
	    				<textarea onblur="return CheckContent()" class="addconut-input" placeholder="请输入通知内同" rows="2" cols="20" name="hi_content"></textarea>&nbsp;<span id="hi_content"></span>
	    			</td>
	    		</tr>
	    		<tr><td><input id="submit" class="submit" class="submit" onclick="return Checksubmit()" value="确认添加" type="submit"/></td></tr>
	    	</table>
	    </form>
	   </div>
  </body>
</html>
