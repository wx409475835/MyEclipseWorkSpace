<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示树</title>
    <script src="${pageContext.request.contextPath }/js/xtree.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/xtree.css">
  	
  	<script type="text/javascript">
  		 <c:forEach var="category" items="${list }">
    		<c:if test="${category.depth==1}">
    			var tree = new WebFXTree('${category.name}');
    			tree.action = "${pageContext.request.contextPath}/servlet/ViewCategoryServlet?id=${category.id}";
    			tree.target = "right";
    		</c:if>
    		
    		<c:if test="${category.depth==2}">
    			var node${category.depth} = new WebFXTreeItem('${category.name}');
    			tree.add(node${category.depth});
    			node${category.depth}.action = "${pageContext.request.contextPath}/servlet/ViewCategoryServlet?id=${category.id}";
    			node${category.depth}.target = "right";
    		</c:if>
    		
    		<c:if test="${category.depth>2}">
    			var node${category.depth} = new WebFXTreeItem('${category.name}');  //node3
    			node${category.depth-1}.add(node${category.depth});
    			node${category.depth}.action = "${pageContext.request.contextPath}/servlet/ViewCategoryServlet?id=${category.id}";
    			node${category.depth}.target = "right";
    		</c:if>
   		 </c:forEach>
   		 document.write(tree);
  	</script>
  </head>
  <body>
  </body>
</html>
