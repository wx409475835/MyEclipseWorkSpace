<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>展示所有结算记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/table.css">
  	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
  	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
  	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
  	<style type="text/css">
  		.showallcount-div1 tr td{
  			width: 60px;
  			
  		}
  		td{
  			height: 30px;
  		}
  	</style>
  </head>
  
  <body>
  <div class="addcount-div1">
  	<p>所有结算记录信息/All End TreateMoney Informations</p></div>
  <div class="table-top-bottom">
	  <div class="table-top">
	  		<c:if test="${Account ==null || Account==''}">
	  			<div class="table-top-left">
	  			<div id="div5"><img src="images/home.png" alt="homeLogo"/></div>
	  			<div id="div6"><img src="images/sign_out.png" alt="sign_out"/></div>
	  			<div id="div7"><img src="images/sign_in.png" alt="sign_in"/></div>
	  			<div id="div8"><img src="images/refresh.png" alt="refresh"/></div>
	  		</div>
	  		</c:if>
	  		<c:if test="${Account!=null }">
	  			<div class="table-top-left">
	  			<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
	  			<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
	  			<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
	  			<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
	  		</div>
	  		</c:if>
	  </div>
	  <div class="table-bottom">
	   		<div class="showallcount-div1">
			    <table cellpadding="0" cellspacing="0" border="1px">
			    	<tr>
						<th>ID</th>
						<th>病人编号</th>
						<th>费用名称</th>
						<th>支付方式</th>
						<th>消费金额(RMB/元)</th>
						<th>消费时间</th>
						<th>是否支付</th>
					</tr>
			    	<c:forEach items="${SelectTreateMoney_treatemoneys.list }" var="hTreateMoney">
			    		<tr>
				    		<td>${hTreateMoney.htm_id }</td>
				    		<td>${hTreateMoney.htm_patientid }</td>
				    		<td>${hTreateMoney.htm_name }</td>
				    		<td>${hTreateMoney.htm_treatmoneytype }</td>
				    		<td>${hTreateMoney.htm_moneyconsum }</td>
				    		<td>${hTreateMoney.htm_consumtime }</td>
				    		<td>${hTreateMoney.htm_ispaymoney }</td>
				    	</tr>
			    	</c:forEach>
			    </table>
			 </div>
		</div>
		<script type="text/javascript">
	   		function gotopage(pagenum,totalrecord){
	   			if(!isNaN(pagenum)){
	   				if(pagenum <= totalrecord){
	   					window.location.href='${basePath}SelectTreateMoneyAction.do?currentpage='+pagenum;
	   				}else{
	   					alert('请输入合法页码');
	   				}
	   			}else{
	   				alert('请输入合法数字');
	   			}
	   		}
	   	</script>
	   	<div class="table-bottom-bottom">
			<ul class="table-bottom-ul">
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectTreateMoney_treatemoneys.previouspage},${SelectTreateMoney_treatemoneys.totalpage})">上一页</a></li>
				<c:forEach var="pagenum" items="${SelectTreateMoney_treatemoneys.pagebar }">
					<c:if test="${pagenum == SelectTreateMoney_treatemoneys.currentpage }">
						<li class="table-ul-center-li-currentpage"><a href="javascript:void(0)">${pagenum }</a></li>
					</c:if>
					<c:if test="${pagenum != SelectTreateMoney_treatemoneys.currentpage }">
						<li class="table-ul-center-li"><a href="javascript:void(0)" onclick="gotopage(${pagenum },${SelectTreateMoney_treatemoneys.totalpage})">${pagenum }</a></li>
					</c:if>
				</c:forEach>
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectTreateMoney_treatemoneys.nextpage},${SelectTreateMoney_treatemoneys.totalpage })">下一页</a></li>
				<li class="table-ul-li-inp"><input type="text" id="page" maxlength="2" style="width: 30;border-radius: -webkit-calc(20px);" /></li>
				<li class="table-ul-li-btn"><button onclick="gotopage(document.getElementById('page').value,${SelectTreateMoney_treatemoneys.totalpage})">Go</button></li>
			</ul>
		</div>
   </div>
  </body>
</html>
