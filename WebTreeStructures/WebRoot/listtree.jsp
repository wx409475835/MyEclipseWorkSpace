<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/xtree.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/xtree.js"></script>	
  </head>
  
  <body>
    <script type="text/javascript">
    		<c:forEach var="c" items="${list}">
	    		<c:if test="${c.depth==1 }">
		  			var tree = new WebFXTree('${c.name}');
		  			tree.action='${pageContext.request.contextPath}/ViewTreeServlet?id=${c.id}';
		  			tree.target='right';
		  		</c:if>
		  		
	    		<c:if test="${c.depth==2}">
	    			var node${c.depth} = new WebFXTreeItem('${c.name}');
	    			tree.add(node${c.depth});
	    			node${c.depth}.action='${pageContext.request.contextPath}/ViewTreeServlet?id=${c.id}';
		  			node${c.depth}.target='right';
	    		</c:if>
	    		
	    		<c:if test="${c.depth>2}">
	    			var node${c.depth} = new WebFXTreeItem('${c.name}');
	    			node${c.depth-1}.add(node${c.depth});
	    			node${c.depth}.action='${pageContext.request.contextPath}/ViewTreeServlet?id=${c.id}';
		  			node${c.depth}.target='right';
	    		</c:if>    		
	    	</c:forEach>
    		document.write(tree);
    </script>
  </body>
</html>
