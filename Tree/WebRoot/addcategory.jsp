<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加子类别</title>
  </head>
  
  <body>
  	<br/>
  	
  	您当前所在位置：
  	<c:forEach var="category" items="${c.parents}">
  		${category.name }>>>
  	</c:forEach>
  	${c.name }
  	
  
  	<br/><br/>
  
  	分类id: ${c.id }
  	分类名称：${c.name }
    
    <form action="${pageContext.request.contextPath }/servlet/AddCategoryServlet" method="post">
	    <input type="hidden" name="pid" value="${c.id }">
	    <input type="text" name="name">
	    <input type="submit" value="添加子类">
    </form>
  </body>
</html>
