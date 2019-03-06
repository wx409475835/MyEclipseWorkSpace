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
    
    <title>查询所有诊断记录信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#st-btn-sel").click(function(){
  				var htr_patientid = $("[name='htr_id']").val();	
  				if(htr_patientid==null||htr_patientid==''){
					alert("请输入需要查询的ID!");
				}else{
		  			$.ajax({
		  				type:"post",
		  				url:"SelectTreateRecordByHtr_patientidAction.do",
		  				data:"htr_patientid="+htr_patientid,
		  				success:function(result){
		  				console.log(result);
		  					//清空Tbody
		  					$("tbody").empty();
		  					var TreateRecord = $.parseJSON(result);
		  					for(var i=0;i<$(TreateRecord).length;i++){
		  						console.log(TreateRecord[i].htr_id);
		  						var id = $("<td>"+TreateRecord[i].htr_id+"</td>");
		  						var patientid = $("<td>"+TreateRecord[i].htr_patientid+"</td>");
		  						var doctorid = $("<td>"+TreateRecord[i].htr_doctorid+"</td>");
		  						var aotoid = $("<td>"+TreateRecord[i].htr_aotoid+"</td>");
		  						var treatetime = $("<td>"+TreateRecord[i].htr_treatetime+"</td>");
		  						var treatecase = $("<td>"+TreateRecord[i].htr_treatecase+"</td>");
		  						var a = $("<td><button class='table-btn1'><a href=SelectTreateRecordByHtr_idAction.do?htr_id="+TreateRecord[i].htr_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button>&nbsp;<button class='table-btn2'><a href=DeleteTreateRecordAction.do?htr_id="+TreateRecord[i].htr_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>"); 						
		  						var tr = $("<tr></tr>");
		  						tr.append(id);
		  						tr.append(patientid);
		  						tr.append(doctorid);
		  						tr.append(aotoid);
		  						tr.append(treatetime);
		  						tr.append(treatecase);
		  						tr.append(a);
		  						$("tbody").append(tr);
		  					}
		  					
		  					$.ajax({
			  					type:"post",
			  					url:"SelectTreateRecordsCountByHtr_patientidAction.do",
			  					data:"htr_patientid="+htr_patientid,
			  					success:function(result){
			  						var treatetimes = $("<tr><td colspan='7' align='right'>该病人一共诊断了&nbsp;<font color='green'>"+$.parseJSON(result)+"</font>&nbsp;次</td></tr>");
		  							$("tbody").append(treatetimes);
			  					}
			  				});
		  				}
		  			});
		  		}
  			});
  			
  			$("#st-btn-add").click(function(){
  				window.location.href="AddTreateRecord.do";
  			});
  		});
  	</script>
	
  </head>
  
  <body>
  	<div class="showallcount-div">
  		<input name="htr_id" placeholder="请输入病人ID" type="text"/>
  		<button class="showallcount-btn" type="button" id="st-btn-sel"><img src="images/search.png" alt="查询"/>查找</button>&nbsp;
  		<button class="showallcount-btn1" type="button" id="st-btn-add"><img src="images/add.png" alt="添加"/>添加</button>
  	</div>
  	<div class="table-top-bottom">
	  	<div class="table-top">
	  		<div class="table-top-left">
	  			<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
	  			<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
	  			<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
	  			<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
	  		</div>
	  	</div>
	    <div class="table-bottom">
	    	<div class="showallcount-div1">
		    	<table border="1px" cellpadding="0" cellspacing="0">
			    	<thead>
			    		<tr>
							<th>ID</th>
							<th>病人ID</th>
							<th>医生ID</th>
							<th>科室ID</th>
							<th>诊断时间</th>
							<th>诊断详情</th>
							<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						</tr>
			    	</thead>
			    	<tbody>
			    		<c:forEach items="${SelectAllTreateRecords_SelectAllTreateRecords }" var="hTreateRecord">
			    			<tr>
					    		<td>${hTreateRecord.htr_id }</td>
					    		<td>${hTreateRecord.htr_patientid }</td>
					    		<td>${hTreateRecord.htr_doctorid }</td>
					    		<td>${hTreateRecord.htr_aotoid }</td>
					    		<td>${hTreateRecord.htr_treatetime }</td>
					    		<td>${hTreateRecord.htr_treatecase }</td>
					    		<td>
					    			<button class="table-btn1"><a href="${basePath}SelectTreateRecordByHtr_idAction.do?htr_id=${hTreateRecord.htr_id }"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button> &nbsp;
					    			<button class="table-btn2"><a href="${basePath}DeleteTreateRecordAction.do?htr_id=${hTreateRecord.htr_id }"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
					    		</td>
					    	</tr>
			    		</c:forEach>
			    	</tbody>
		    	</table>
		    </div>
	    </div>
	 </div>
  </body>
</html>
