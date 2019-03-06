<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		table{
			font-family: serif;
			text-align: center;
		}
		
		table tr,th,td{
			width: 80px;
			font-family: 微软雅黑;
			height: 30px;
		}
		
		.div1{
			margin-top:30px;
			/* border: solid red 1px;	 */
		}
		
		a{
			color: gray;
			text-decoration:none; 
		}
		
		a:HOVER{
			color: red;
			text-decoration: underline;
		}
		.even{
			background-color: #D1D1D1;
		}
		.odd{
			background-color: #ececec;
		}
		tr:HOVER {
			background-color: #EDEDED;
		}
	</style>
  </head>
  
  <body>
  	<h1 style="position:relative; color:blue; margin-top: 30px;" align="center">数据库分页技术的实现</h1>
  	<div align="center">
  		<a style="font-size: 20px;" href="${basePath }AddInfo.apex">添加数据</a>
  		<a style="font-size: 20px;" href="${basePath}pageQueryAction.apex">查看数据</a>
  		<a style="font-size: 20px;" href="${basePath}search.apex">搜索</a>
  	</div>
  	<hr/>
    <div class="div1">
    	<table  align="center" border="1" bordercolor="1px"  cellpadding="0" cellspacing="0">
    	<thead>
    		<tr class="tr">
    			<th>ID</th>
    			<th>姓名</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="person" items="${pageBean.list }" varStatus="status">
    			<tr class="${status.count%2==0?'enev':'odd' }">
    				<td>${person.id }</td>
    				<td>${person.name }</td>
    				<td><a href="${basePath }DeleteInfoAction.apex?id=${person.id}">删&nbsp;&nbsp;除</a></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    <br/>
    <script type="text/javascript">
    	function gotopage(currentpage){
    		var pagesize = document.getElementById("pagesize").value;
    		window.location.href="${basePath}pageQueryAction.apex?currentpage="+currentpage+"&pagesize="+pagesize;
    	}
    	
    	function changesize(value,oldvalue){
    		if(value < 0 || value != parseInt(value)){
    				alert("请输入合法值");
    				$("#pagesize").prop("value",oldvalue);
    		}else{
    			window.location.href="${basePath}pageQueryAction.apex?pagesize=" + value;
    		}
    	}
 
    </script>
    <div align="center">
    	共[${pageBean.totalrecord}]条记录,
    	每页<input type="text" value="${pageBean.pagesize }" id="pagesize"  style="width: 25px" maxlength="2" onchange="changesize(this.value,${pageBean.pagesize })"/>条记录,
    	共[${pageBean.totalpage }]页,
    	当前第[${pageBean.currentpage }]页
	    &nbsp;&nbsp;&nbsp;
	    <a href="javascript:void(0)" onclick="gotopage(${pageBean.previouspage})">上一页</a>
	    <c:forEach var="pagenum" items="${pageBean.pagebar }">
	    	<c:if test="${pagenum == pageBean.currentpage }">
	    		<font color="red">${pagenum }</font>
	    	</c:if>
	    	<c:if test="${pagenum != pageBean.currentpage }">
	    		<a href="javascript:void(0)" onclick="gotopage(${pagenum })">${pagenum }</a>
	    	</c:if>
	    </c:forEach>
	   	<a href="javascript:void(0)" onclick="gotopage(${pageBean.nextpage})">下一页</a>
	   	&nbsp;&nbsp;
	 
	   	<input type="text" id="page" style="width: 30"/>
	   	<button onclick="gotopage(document.getElementById('page').value)">Go</button>
   	</div>
    </div>
  </body>
</html>
