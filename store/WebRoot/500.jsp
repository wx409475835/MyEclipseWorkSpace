<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang='en-US'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>500 - 对不起，页面错误了！</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div id="wrapper"><a class="logo" href="/"></a>
  <div id="main">
    <header id="header">
      <h1><span class="icon">!</span>500<span class="sub">HTTP-Internal Server Error</span></h1>
    </header>
    <div id="content">
      <h2>您打开的这个的页面出现错误！</h2>
      <p>当您看到这个页面,表示您的访问的网页出现了错误,造成500错误常见原因有：ASP语法出错、ACCESS数据库连接语句出错、文件引用与包含路径出错(如未启用父路径)、使用了服务器不支持的组件如FSO等。如果是在本站点击后出现这个页面,请联系站长进行处理,或者请通过下边的搜索重新查找资源,感谢您的支持!</p>
      <div class="utilities">
        <form  name="formsearch" action="/plus/search.php" id="formkeyword">
          <div class="input-container">
            <input type="text" class="left" name="q" size="24"  value="在这里搜索..." onfocus="if(this.value=='在这里搜索...'){this.value='';}"  onblur="if(this.value==''){this.value='在这里搜索...';}" id="inputString" onkeyup="lookup(this.value);" onblur="fill();" placeholder="搜索..." />
            <button id="search"></button>
          </div>
        </form>
        <a class="button right" href="#" onClick="history.go(-1);return true;">返回...</a><a class="button right" href="http://wpa.qq.com/msgrd?v=3&uin=150272354&site=qq&menu=yes">联系站长</a>
        <div class="clear"></div>
      </div>
    </div>
    <div id="footer">
      <ul>
        <li><a href="/">网站首页</a></li>
      	<li><a href='/list-58.html' title='JS代码'>JS代码</a></li>
      	<li><a href='/list-5.html' title='Jquery插件'>Jquery插件</a></li>
      	<li><a href='/list-56.html' title='前端设计'>前端设计</a></li>
      	<li><a href='/list-100.html' title='素材下载'>素材下载</a></li>
      	<li><a href='/list-20.html' title='网页模板'>网页模板</a></li>
      	<li><a href='/list-4.html' title='网页特效'>网页特效</a></li>
      	<li><a href='/list-59.html' title='CMS教程'>CMS教程</a></li>
      	<li><a href='/list-81.html' title='CMS插件'>CMS插件</a></li>
      	<li><a href='/list-57.html' title='网络编程'>网络编程</a></li>
      	<li><a href='/list-60.html' title='电脑教程'>电脑教程</a></li>
      	<li><a href='/list-55.html' title='站长技术'>站长技术</a></li>
      	<li><a href='/list-54.html' title='IT互联网'>IT互联网</a></li>


      </ul>
    </div>
  </div>
</div>
</html>