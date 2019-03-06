<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function addfile(){
			var files = document.getElementById("files");
			
			var inp = document.createElement("input");
			inp.type="file";
			inp.name="file";
			
			var btn = document.createElement("input");
			btn.type="button";
			btn.name="del";
			btn.value="删除";
			btn.onclick = function(){
				this.parentNode.parentNode.removeChild(this.parentNode);
			}
			
			var div = document.createElement("div");
			div.appendChild(inp);
			div.appendChild(btn);
			
			files.appendChild(div);
		}
	</script>
  </head>
  
  <body>
    <form action="UploadServlet" enctype="multipart/form-data" method="post">
    	<table>
    		<tr>
    			<td>上传用户:<input type="text" name="username"/></td>
    		</tr>
    		<tr>
    			<td>上传文件:<input type="button" value="添加文件" name="add" onclick="addfile()"/></td>
    		</tr>
    		<tr>
    			<td>
    				<div style="margin-left: 72px;" id="files"></div>
    			</td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="上传" style="margin-left: 72px;margin-top: 10px;"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
