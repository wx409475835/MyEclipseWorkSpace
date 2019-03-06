<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang='en-US'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>400 - 对不起，页面错误了！</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div id="wrapper"><a class="logo"></a>
  <div id="main">
    <header id="header">
      <h1><span class="icon">!</span>400<span class="sub">Bad Request</span></h1>
    </header>
    <div id="content">
      <h2>您打开的这个的页面出现错误！</h2>
      <p>当您看到这个页面,表示您的访问的网页出现了错误,400是一种是HTTP状态码，400 Bad Request。是在打开网页时服务器返回到客户端的一种状态码。显示在客户端的也就是400页面。如果是在本站点击后出现这个页面,请联系站长进行处理,或者请通过下边的搜索重新查找资源,感谢您的支持!</p>
      <div class="utilities">
        <form  name="formsearch" id="formkeyword">
          <div class="input-container">
            <input type="text" class="left" name="q" size="24"  value="在这里搜索..." onfocus="if(this.value=='在这里搜索...'){this.value='';}"  onblur="if(this.value==''){this.value='在这里搜索...';}" id="inputString" onkeyup="lookup(this.value);" onblur="fill();" placeholder="搜索..." />
            <button id="search"></button>
          </div>
        </form>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
</html>