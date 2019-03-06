<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>南阳理工学院后勤管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    <form action="upload.do" method="post" enctype="multipart/form-data">
    	 <input type="file" name="file"/>
    	<br/>
    	<button type="submit">上传</button>
    </form>
    <%-- <c:if test="${img != null}">
    	<div>
	    	<img alt="asd" src="http://localhost:8888/Images/${img }">
	    </div>
    </c:if>
    <%
    	request.getSession(true).setAttribute("img",null);
     %> --%>
  </body>
</html>
