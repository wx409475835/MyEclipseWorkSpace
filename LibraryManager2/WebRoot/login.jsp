<%@page contentType="text/html; charset=UTF-8" import="com.dw.model.*,java.net.*" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>图书管理系统登陆页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

</head>

<body>


<%
	if(request.getAttribute("user")==null){
		String username=null;
		String password=null;
		
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("user")){
				username=URLDecoder.decode(cookies[i].getValue().split("-")[0],"UTF-8");
				password=URLDecoder.decode(cookies[i].getValue().split("-")[1],"UTF-8");
		 }
		if(username==null){
			username="";
		}
		
		if(password==null){
			password="";
		}
		
		pageContext.setAttribute("username", username);
		pageContext.setAttribute("password", password);
	}
	}
%>



<div class="signin">
	<div class="signin-head"><img src="images/library.png" width="130px" alt="" class="img-circle"></div>
	<form class="form-signin" role="form" action="${pageContext.request.contextPath}/login" method="post">
		<input name="username" type="text" class="form-control" placeholder="用户名" required autofocus />
		<input name="password" type="password" class="form-control" placeholder="密码" required />
		<input name="code" type="code" class="form-control" placeholder="验证码" required />
		<img alt="" src="${pageContext.request.contextPath }/code.png">
		<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		  
			<input name="flag" type="radio" value="admin" required="required"> 管理员 &nbsp;&nbsp;&nbsp;
			<input name="flag" type="radio" value="user" required="required"> 普通用户<br/>
			<span  style="font-size:15px;color:red">${requestScope.message}</span>
			<a href="/LibraryManager2/register.jsp" class="pull-right" style="color: red;inherit;font-size: 20px">注册</a>
	</form>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>
