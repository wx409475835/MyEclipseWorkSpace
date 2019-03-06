<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>动态表格加载数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/*$.ajax({
				type:"post",
				url:"showTableServlet",
				success:function(result){
					//删除div
					$("#msg").remove();
					$("thead tr:first").css("display","block");
					var users = $.parseJSON(result);
					for(var i=0;i<users.length;i++){
						var idTd = $("<td>"+users[i].id+"</td>");
						var nameTd = $("<td>"+users[i].username+"</td>");
						var passwordTd = $("<td>"+users[i].password+"</td>");
						var tr = $("<tr></tr>");
						tr.append(idTd);
						tr.append(nameTd);
						tr.append(passwordTd);
						$("#tb").append(tr);
					}
				}
			});*/
			/*
			$.post("showTableServlet",function(result){
					//删除div
					$("#msg").remove();
					$("thead tr:first").css("display","block");
					var users = $.parseJSON(result);
					for(var i=0;i<users.length;i++){
						var idTd = $("<td>"+users[i].id+"</td>");
						var nameTd = $("<td>"+users[i].username+"</td>");
						var passwordTd = $("<td>"+users[i].password+"</td>");
						var tr = $("<tr></tr>");
						tr.append(idTd);
						tr.append(nameTd);
						tr.append(passwordTd);
						$("#tb").append(tr);
					}
			});*/
			
			$.getJSON("showTableServlet",function(users){
				//删除div
				$("#msg").remove();
				$("thead tr:first").css("display","block");
				for(var i=0;i<users.length;i++){
					var idTd = $("<td>"+users[i].id+"</td>");
					var nameTd = $("<td>"+users[i].username+"</td>");
					var passwordTd = $("<td>"+users[i].password+"</td>");
					var tr = $("<tr></tr>");
					tr.append(idTd);
					tr.append(nameTd);
					tr.append(passwordTd);
					$("#tb").append(tr);
				}
			});
		});	
		
	</script>
  </head>
  
  <body>
    <table cellpadding="0" cellspacing="0" border="1" align="center">
    	<thead id="th">
    		<tr style="display:none;">
    			<th>ID</th>
	    		<th>用户名</th>
	    		<th>密码</th>
    		</tr>
    	</thead>
    	<tbody id="tb">
    		<div id="msg">Lodding...</div>
    	</tbody>
    </table>
  </body>
</html>