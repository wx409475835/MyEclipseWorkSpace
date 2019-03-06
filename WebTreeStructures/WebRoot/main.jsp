<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>主界面</title>
    
  </head>
  
  <frameset cols="16%,*">
  	<frame src="${pageContext.request.contextPath }/ListTreeServlet" name="left">
  	<frame src="" name="right">
  </frameset>
</html>
