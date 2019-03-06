<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>TestpaseJson.html</title>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				//1.获得文本框中的值
				var username = $("#username").val();
				
				//2.通过Ajax发送异步请求  
				$.ajax({
					type:"post",
					url:"ShowIntermation",
					data:"username="+username,
					success:function(result){
						//响应完毕后 清空当前Div 模块的内容
						$("#msg").empty();
						
						//到这里  传过来的数据为json 字符串 我们先转换成 js对象或数组
						var user = $.parseJSON(result);
						var idDiv = $("<div>"+user.id+"</div>");
						var usernameDiv = $("<div>"+user.username+"</div>");
						var passwordDiv = $("<div>"+user.password+"</div>");
						$("#msg").append(idDiv);
						$("#msg").append(usernameDiv);
						$("#msg").append(passwordDiv);
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    Username:<input type="text" name="username" id="username"/>
    <input type="button" value="click" id="btn"/>
    <div id="msg">
    	
    </div>
  </body>
</html>
