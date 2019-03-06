<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <frameset cols="15%,*">
  	<frame src="${pageContext.request.contextPath}/servlet/ViewTreeServlet" name="left">
  	<frame src="" name="right">
  </frameset>
  
</html>
