<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset-grids-min.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/suggest/yahoo-dom-event.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/suggest/suggest.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/sys.js"></script>
	<style type="text/css">
	    #page { padding: 50px 50px 300px; width: 750px; margin: 0 auto; }
	    #h1, h2, h3 { margin: 1em 0 0.3em; }
	    #.section { margin-bottom: 50px; }
	    #.section ol { margin: 5px 20px; }
	    #.section ol li { list-style: decimal inside; margin: 5px 0; }
	    .search-input { width: 300px; height: 20px; padding: 5px 2px 0 4px; }
	    #.search-submit { padding: 4px 10px; margin-left: 5px; }
	    #input.g-submit { padding: 2px 8px; margin-left: 5px; }
	    #html { overflow-y: scroll; }
	</style>
  </head>
  
  <body>
  	<div id="page">
		<div class="section">
	        <form name="search" method="get" action="#">
	            <input name="q" id="q" class="search-input"/>
	            <button type="submit" class="search-submit">搜索用户</button>
	        </form>
	        <script type="text/javascript">
	            (function() {
	                var dataUrl = '${pageContext.request.contextPath}/SearchAction.apex';
	                new KISSY.Suggest('q', dataUrl,
	                    { autoFocus: true,
	                      resultFormat: '共%result%个'
	                    });
	            })();
	        </script>
	    </div>
	</div>
  </body>
</html>
