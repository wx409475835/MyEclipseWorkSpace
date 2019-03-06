<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>图书管理系统注册界面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<script src="./jquery/jquery-2.1.3.min.js"></script>
<!--引入Bootstrap的js文件--> 
<script src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
   $(function(){
	     
	      $("#date").val(formatDate(new Date()))
   });
   
   var formatDate = function (date) {  
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? '0' + m : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    return y + '-' + m + '-' + d;  
  }; 


</script>
</head>

<body>

<div class="signin">
	<div class="signin-head"><img src="images/library.png" width="150px" alt="" class="img-circle"></div>
	<form class="form-signin" role="form" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
		<input name="username" type="text" class="form-control" placeholder="用户名" required autofocus />
		<input name="password" type="password" class="form-control" placeholder="密码" required />
		<input name="email" type="email" class="form-control" placeholder="邮箱" required />
		<input name="phone" type="number" class="form-control" placeholder="电话" required />
		<input id="date" name="date"  class="form-control" type="text" value="" readOnly/>
		<button class="btn btn-lg btn-warning btn-block" type="submit">注册</button>
  </form>
</div>

</body>
</html>
