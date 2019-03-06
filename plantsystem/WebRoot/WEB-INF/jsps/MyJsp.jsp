<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试Jsp</title>
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  </head>
  
  <body>
  
    <div>
    	<img alt="asd" src="images/椭圆1.png"><br/>
    	
    </div>
    <a>保存到本地</a>
    <script>
	    function fake_click(obj) {
	        var ev = document.createEvent("MouseEvents");
	        ev.initMouseEvent(
	            "click", true, false, window, 0, 0, 0, 0, 0
	            , false, false, false, false, 0, null
	        );
	        obj.dispatchEvent(ev);
	    }
	 
	    function export_raw(name, data) {
	        var urlObject = window.URL || window.webkitURL || window;
	 		alert(urlObject)
	        var export_blob = new Blob([data]);
	 
	        var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a")
	        alert("save_link:"+save_link.toString())
	        save_link.href = urlObject.createObjectURL(export_blob);
	        console.log("save_link.href:"+save_link.href.toString())
	        alert(name);
	        //save_link.download = name;
	        fake_click(save_link);
	    }
	    var test=document.getElementsByTagName('html')[0].outerHTML;
	    console.log(test);
	    $('a').click(function() {
	        export_raw('test.html', test);
	    });
	</script>
  </body>
</html>
