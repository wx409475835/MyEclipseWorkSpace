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
    
    <title>所有通知信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script> 
	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
 	<style type="text/css">
 		.DeleteAllInform{
 			position:relative;
 			float:right;
 			width: 35px;
 			height: 35px;
 			cursor:pointer;
 			border-radius: -webkit-calc(30px);
 			border: solid 1px #D1D1D1;
 			margin:2px 60px;
 			text-align: center;
 		}
 		
 		.DeleteAllInform img{
 			/* border: 1px red solid; */
 			margin: 5px auto;
 		}
 		
 		.DeleteAllInform:HOVER {
			background-color: #ffffff;
		}
 	</style>
 	<script type="text/javascript">
 		$(function(){
 			$(".DeleteAllInform").click(function(){
 				var bool = confirm("清空所有通知内容，您将不会再看到这些信息,确定清空吗?");
 				console.log("bool="+bool);
 				if(bool==true){
 					window.location.href="doctor/DeleteAllInformsAction.do";
 				}
 			});
 		});
 	</script>
  </head>
  
  <body>
  <div class="addcount-div1">
  	<p>显示所有通知信息/Show All Informs Information</p>
  	<div class="Right_Index">
		  	<div id="div5"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div6"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div7"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div8"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  </div>
      	<div class="table-top-bottom">
			  <div class="table-top">
			  	<div class="DeleteAllInform">
			  		<img alt="清空所有通知" src="images/DeleteAll.png">
			  	</div>
			  </div>
				<div class="table-bottom">
					<div class="showallcount-div1">
						<table border="1" cellpadding="0" cellspacing="0">
					    	<thead>
					    		<tr>
						    		<th>ID</th>
							    	<th>通知人ID</th>
							    	<th>通知时间</th>
							    	<th>通知内容</th>
						    	</tr>
					    	</thead>
					    	<tbody>
					    		<c:forEach items="${SelectAllInforms_hInforms.list }" var="hInforms" varStatus="status">
					    			<tr class="${status.count%2==0?'even':'odd' }">
						    			<td>${hInforms.hi_id }</td>
							    		<td>${hInforms.hi_personid }</td>
							    		<td>${hInforms.hi_tet }</td>
							    		<td>${hInforms.hi_content }</td>
						    		</tr>
					    		</c:forEach>
					    	</tbody>
					    </table>
					 </div>
				</div>
			<script type="text/javascript">
	   		function gotopage(pagenum,totalrecord){
	   			if(!isNaN(pagenum)){
	   				if(pagenum <= totalrecord){
	   					window.location.href='${basePath}doctor/SelectAllInformsAction.do?currentpage='+pagenum;
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
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllInforms_hInforms.previouspage},${SelectAllInforms_hInforms.totalpage})">上一页</a></li>
				<c:forEach var="pagenum" items="${SelectAllInforms_hInforms.pagebar }">
					<c:if test="${pagenum == SelectAllInforms_hInforms.currentpage }">
						<li class="table-ul-center-li-currentpage"><a href="javascript:void(0)">${pagenum }</a></li>
					</c:if>
					<c:if test="${pagenum != SelectAllInforms_hInforms.currentpage }">
						<li class="table-ul-center-li"><a href="javascript:void(0)" onclick="gotopage(${pagenum },${SelectAllInforms_hInforms.totalpage})">${pagenum }</a></li>
					</c:if>
				</c:forEach>
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllInforms_hInforms.nextpage},${SelectAllInforms_hInforms.totalpage })">下一页</a></li>
				<li class="table-ul-li-inp"><input type="text" id="page" maxlength="2" style="width: 30;border-radius: -webkit-calc(20px);" /></li>
				<li class="table-ul-li-btn"><button onclick="gotopage(document.getElementById('page').value,${SelectAllInforms_hInforms.totalpage})">Go</button></li>
			</ul>
		</div>
	</div>
  </body>
</html>
