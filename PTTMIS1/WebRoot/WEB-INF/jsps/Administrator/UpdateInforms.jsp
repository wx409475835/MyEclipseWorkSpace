<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新通知信息</title>
    
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
  	<script type="text/javascript">
  		$(function(){
  			$("#ui-inp-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
  		});
  		
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
  		<p>修改通知信息/Update Informs Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
      <div class="addcount-div2">
	    <form method="post" action="UpdateInformByIdAction.do">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" name="hi_id" type="text" value="${SelectInformByHi_ids_hInform.hi_id }" readonly="readonly"/></td>
	    		</tr>
	    		<tr>
	    			<td>通知人ID&nbsp;<input class="addconut-input" name="hi_personid" type="text" readonly="readonly" value="${SelectInformByHi_ids_hInform.hi_personid }"/></td>
	    		</tr>
	    		<tr>
	    			<td>通知时间&nbsp;<input class="addconut-input" name="hi_tet" type="text" class="Wdate" id="ui-inp-date" value="${SelectInformByHi_ids_hInform.hi_tet }"/></td>
	    		</tr>
	    		<tr>
	    			<td>通知内容
						<textarea onblur="return CheckContent()" class="addconut-input" name="hi_content" rows="2" cols="20">${SelectInformByHi_ids_hInform.hi_content }</textarea>&nbsp;<span id="hi_content"></span>
					</td>
	    		</tr>
	    		<tr>
	    			<td><input id="submit" onclick="return Checksubmit()" class="submit" type="submit" value="确认修改"/></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	   </div>
  </body>
</html>
