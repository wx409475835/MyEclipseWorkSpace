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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
 			width: 28px;
 			height: 28px;
 			cursor:pointer;
 			border-radius: -webkit-calc(30px);
 			border: solid 1px #D1D1D1;
 			margin:0px 60px;
 			text-align: center;
 		}
 		
 		.DeleteAllInform img{
 			/* border: 1px red solid; */
 			margin: 5px auto;
 			width: 16px;
 			height: 19px;
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
					    		<c:forEach items="${SelectAllInforms_hInforms }" var="hInforms">
					    			<tr>
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
			</div>
  </body>
</html>
