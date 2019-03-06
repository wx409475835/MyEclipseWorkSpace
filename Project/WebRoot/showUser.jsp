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
				var name = $("#name").val();
				$.ajax({
					type:"post",
					url:"showUserServlet",
					data:"name="+name,
					success:function(result){
						//从后台拿到数据(Json字符串)后  首先清空掉当前Div里边的内容
						$("#msg").empty();
						//到这里  result 拿到的是一个 json 字符串
						var user = $.parseJSON(result);	//---->转换成js对象
						var idDiv  = $("<div>"+user.id+"</div>");
						var nameDiv = $("<div>"+user.username+"</div>");
						var passwordDiv = $("<div>"+user.password+"</div>");
						$("#msg").append(idDiv);
						$("#msg").append(nameDiv);
						$("#msg").append(passwordDiv);		
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    Username:<input type="text" name="name" id="name"/>
    <input type="button" value="click" id="btn"/>
    <div id="msg">
    	
    </div>
  </body>
</html>
