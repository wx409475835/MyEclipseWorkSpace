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
    
    <title>所有药品信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript">
			$(function(){
				$("#sd-btn-sel").click(function(){
					var hdrug_id = $("input[name='hdrug_id']").val();
					if(hdrug_id==null||hdrug_id==''){
						alert("请输入需要查询的药品ID或名称!");
					}else{
						//1.获得tbody 对象,清空tbody 里边得内容
						console.log(hdrug_id);
						$("tbody").empty();
						//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
						if(!isNaN(hdrug_id)){
							$.ajax({
								type:"post",
								url:"SelectHDrugByHdrug_idAction.do",
								data:"hdrug_id="+hdrug_id,
								success:function(result){
									//result 是一个json 字符串 我们需要将它转换成js对象
									console.log(result);
									var drug = $.parseJSON(result);
									console.log(drug);	
									console.log($(drug)[0].hdrug_id);
									var id = $("<td>"+$(drug)[0].hdrug_id+"</td>");
									var name = $("<td>"+$(drug)[0].hdrug_name+"</td>");
									var price = $("<td>"+$(drug)[0].hdrug_price+"</td>");
									var birthday = $("<td>"+$(drug)[0].hdrug_birthday+"</td>");
									var type = $("<td>"+$(drug)[0].hdrug_type+"</td>");
									var introduce = $("<td>"+$(drug)[0].hdrug_introduce+"</td>");
									var a = $("<td><button class='table-btn1'><a href=SelectHDrugByHdrug_idActions.do?hdrug_id="+$(drug)[0].hdrug_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteDrugAction.do?hdrug_id="+$(drug)[0].hdrug_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
									//创建tr 对象  将td 连在其后面
									var tr = $("<tr></tr>");
									tr.append(id);
									tr.append(name);
									tr.append(price);
									tr.append(birthday);
									tr.append(type);
									tr.append(introduce);
									tr.append(a);
									//将 tr 挂在到 tbody上
									$("tbody").append(tr);
								}
							});
						}else{
							$.ajax({
								type:"post",
								url:"SelectDrugByHdrug_nameAction.do",
								data:"hdrug_name="+hdrug_id,
								success:function(result){
									//result 是一个json 字符串 我们需要将它转换成js对象
									console.log(result);
									var drug = $.parseJSON(result);
									console.log(drug);	
									console.log($(drug)[0].hdrug_id);
									for(var i=0;i<$(drug).length;i++){
										var id = $("<td>"+$(drug)[i].hdrug_id+"</td>");
										var name = $("<td>"+$(drug)[i].hdrug_name+"</td>");
										var price = $("<td>"+$(drug)[i].hdrug_price+"</td>");
										var birthday = $("<td>"+$(drug)[i].hdrug_birthday+"</td>");
										var type = $("<td>"+$(drug)[i].hdrug_type+"</td>");
										var introduce = $("<td>"+$(drug)[i].hdrug_introduce+"</td>");
										var a = $("<td><button class='table-btn1'><a href=SelectHDrugByHdrug_idActions.do?hdrug_id="+$(drug)[i].hdrug_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteDrugAction.do?hdrug_id="+$(drug)[i].hdrug_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
										//创建tr 对象  将td 连在其后面
										var tr = $("<tr></tr>");
										tr.append(id);
										tr.append(name);
										tr.append(price);
										tr.append(birthday);
										tr.append(type);
										tr.append(introduce);
										tr.append(a);
										//将 tr 挂在到 tbody上
										$("tbody").append(tr);
									}
								}
							});
						}
					}
				});
	
		// 添加 事件
		$(function() {
			$("#sd-btn-add").click(function() {
				window.location.href = "AddDrugs.do";
			});
		});
	});
	</script>
  </head>
  
	  <body>
	  	 <div class="showallcount-div">
	  	 	<input placeholder="请输入需要查询的ID或名称" name="hdrug_id" type="text"/>
	  	 	<button class="showallcount-btn" type="button" id="sd-btn-sel"><img src="images/search.png" alt="查询"/>查询</button>
	  	 	<button class="showallcount-btn1" type="button" id="sd-btn-add"><img src="images/add.png" alt="添加"/>添加</button>
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
				    		<th>药品名称</th>
				    		<th>药品价格(RMB/元)</th>
				    		<th>药品生产日期</th>
				    		<th>药品类型</th>
				    		<th>药品介绍</th>
				    		<th> &nbsp;&nbsp;&nbsp;&nbsp;操 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;</th>
				    	</tr>
			    	</thead>
		    		<tbody>
		    			<c:forEach items="${SelectAllDrugs_hDrugs }" var="hDrugs">
				    		<tr>
					    		<td>${hDrugs.hdrug_id }</td>
					    		<td>${hDrugs.hdrug_name }</td>
					    		<td>${hDrugs.hdrug_price }</td>
					    		<td>${hDrugs.hdrug_birthday }</td>
					    		<td>${hDrugs.hdrug_type }</td>
					    		<td>${hDrugs.hdrug_introduce }</td>
					    		<td>
					    			<button class="table-btn1"><a href="${basePath }SelectHDrugByHdrug_idActions.do?hdrug_id=${hDrugs.hdrug_id }"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button> &nbsp;
					    			<button class="table-btn2"><a href="${basePath }DeleteDrugAction.do?hdrug_id=${hDrugs.hdrug_id }"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
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
