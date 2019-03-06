<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
			background-color: #f5f5f5;
		}
	</style>
	<%
    			Date date=new Date();
    			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss"); 
    %>
    <script language="javascript">
    var t = null;
    t = setTimeout(time,1000);//开始执行
    function time()
    {
       clearTimeout(t);//清除定时器
       dt = new Date();
       var Y=dt.getFullYear();
       var M=dt.getMonth();
       var D=dt.getDate();
       var day=dt.getDay();
       var week;
       var h=dt.getHours();
       var m=dt.getMinutes();
       var s=dt.getSeconds();    
       switch(day){
       		case 0:
       			week="星期日";
       		case 1:
       			week="星期一";
       		case 2:
       			week="星期二";
       		case 3:
       			week="星期三";
       		case 4:
       			week="星期四";
       		case 5:
       			week="星期五";
       		case 6:
       			week="星期六";
       }
       document.getElementById("timeShow").innerHTML ="<font color='red' size='4'>"+Y+"年"+(M+1)+"月"+D+"日"+" "+week+" "+h+":"+m+":"+s+"</font>";
       t = setTimeout(time,1000); //设定定时器，循环执行             
    } 
  </script>
	 <style type="text/css">
			table{
				text-align: center;
			}
			.d1{
				font-family:  Arial, Helvetica, sans-serif;
				color:#A9A9A9;
			}
			a,span,input,font{
				font-family:  Arial, Helvetica, sans-serif;
			}
			.tr{
				background: #E5E5E5;
			}
			a{
				color:#8B7500;
				text-decoration: none;
				cursor:hand;
			}
			a:hover{
				color:#9B30FF;
				text-decoration:underline;
			}
	}
	</style>
  </head>
  <body>
    <c:if test="${ sessionScope.Login!=null}">
    	<div style="width:1500px;height:60px;border:solid 3px none;margin-bottom: 0px;">
    		<div style="width:279px;height:60px;border:solid none;float:left;margin-top:35px;">
    			<img alt="图书管理系统" src="images/Library_bk.png">
    		</div>
    		<div style="margin-left: 50px;float:left;margin-bottom: 0px;margin-top:65px;">
	    		<font size="5" color="#EE9A00">欢迎管理员:</font><font color="red" size="5"><span>${sessionScope.Login}</span></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		<font color="red" size="4"><span id="timeShow"></span></font>
    		</div>
    		
    	</div>
   <br/><br/>
    <hr>
    <div style="background-color:;border-color:#CDC9C9;border-style:inset;height: 30px;">
    	<table class="d1">
    		<tr>
    			<td style="width: 40px;"></td>
    			<td><a href="http://localhost:8888/LibrarySystem_SSM/Main.do"><strong>首页</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectAllBookInformationAction.do"><strong>查询在馆图书信息</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/updatebooks.do"><strong>上架图书</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/downbook.do"><strong>下架图书</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectBooksAsType.do"><strong>按种类搜索图书</strong></a></td>
    			<td  style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectMyBrrowInformationAction.do"><strong>查询借阅记录</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectAllBrrowInformationsAction.do"><strong>总借阅记录</strong></a></td>
    			<td  style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/ReturnBooks.do"><strong>归还图书</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectAllUserAction.do"><strong>管理用户</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/SelectMineInformationAction.do"><strong>查询个人信息</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a target="aa" href="http://localhost:8888/LibrarySystem_SSM/Alterpassword.do"><strong>修改密码</strong></a></td>
    			<td style="width: 40px;"></td>
    			<td><a href="http://localhost:8888/LibrarySystem_SSM/LoginOutAction.do"><strong>退出系统</strong></a></td>
    		</tr>
    	</table>	
    </div>
    <hr>
    <center><iframe src="http://localhost:8888/LibrarySystem_SSM/QY.do" name="aa" style="width: 1500px;height: 600px;border: none;"></iframe></center>
    </c:if>
    <c:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="http://localhost:8888/LibrarySystem_SSM/Login.do"></jsp:forward>
    </c:if>
  </body>
</html>
