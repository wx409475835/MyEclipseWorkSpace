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
    
    <title>查询所有科室信息</title>
    
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
			$("#sa-sel-btn").click(function(){
				var haoto_id = $("[name='haoto_id']").val();
				if(haoto_id==null||haoto_id==''){
					alert("请输入需要查询的ID!");
				}else{
					//1.获得tbody 对象,清空tbody 里边得内容
					$("tbody").empty();
					//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
					if(!isNaN(haoto_id)){
						$.ajax({
							type:"post",
							url:"SelectHaotoByIdAction.do",
							data:"haoto_id="+haoto_id,
							success:function(result){
								//result 是一个json 字符串 我们需要将它转换成js对象
								var aotos = $.parseJSON(result);
								console.log(aotos);
								console.log($(aotos)[0].haoto_id);
								var id = $("<td>"+$(aotos)[0].haoto_id+"</td>");
								var name = $("<td>"+$(aotos)[0].haoto_name+"</td>");
								var person = $("<td>"+$(aotos)[0].haoto_person+"</td>");
								var decribe = $("<td>"+$(aotos)[0].haoto_decribe+"</td>");
								var a = $("<td><button class='table-btn1'><a href=SelectHaotoByIdsAction.do?haoto_id="+$(aotos)[0].haoto_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteHaotoAction.do?haoto_id="+$(aotos)[0].haoto_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></td><button>");
								//创建tr 对象  将td 连在其后面
								var tr = $("<tr></tr>");
								tr.append(id);
								tr.append(name);
								tr.append(person);
								tr.append(decribe);
								tr.append(a);
								//将 tr 挂在到 tbody上
								$("tbody").append(tr);
							}
						});
					}else{
						$.ajax({
							type:"post",
							url:"SelectHaotoByNameAction.do",
							data:"haoto_name="+haoto_id,
							success:function(result){
								//result 是一个json 字符串 我们需要将它转换成js对象
								var aotos = $.parseJSON(result);
								console.log(aotos);
								for(var i=0;i<$(aotos).length;i++){
									var id = $("<td>"+$(aotos)[i].haoto_id+"</td>");
									var name = $("<td>"+$(aotos)[i].haoto_name+"</td>");
									var person = $("<td>"+$(aotos)[i].haoto_person+"</td>");
									var decribe = $("<td>"+$(aotos)[i].haoto_decribe+"</td>");
									var a = $("<td><button class='table-btn1'><a href=SelectHaotoByIdsAction.do?haoto_id="+$(aotos)[i].haoto_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteHaotoAction.do?haoto_id="+$(aotos)[i].haoto_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></td><button>");
									//创建tr 对象  将td 连在其后面
									var tr = $("<tr></tr>");
									tr.append(id);
									tr.append(name);
									tr.append(person);
									tr.append(decribe);
									tr.append(a);
									//将 tr 挂在到 tbody上
									$("tbody").append(tr);
								}
							}
						});
					}
			}
		});
		
		$("#sa-add-btn").click(function(){
			window.location.href="AddHaoto.do";
		});
		
	});
	
	$(function(){
		$("a:contains('删除')").click(function(){
			var aotoid =$($(this).parent().parent().parent().children()[0]).text();
			var a = $(this);
			$(this).removeAttr("href");
			$.ajax({
				type:"post",
				url:"SelectHDoctorByHd_HaotoidAction.do",
				data:"hd_haotoid="+aotoid,
				success:function(result){
					if(result==0){
						alert("该科室信息不能删除,请先删除依赖此科室信息的医生信息!");
					}else{
						window.location.href="DeleteHaotoAction.do?haoto_id="+aotoid;
					}
				}
			});
		});
	});
	
	</script>
  </head>
  
  <body>
  	<div class="showallcount-div">
  		<input type="text" name="haoto_id" placeholder="请输入需要查询的ID或名称">
  		<button class="showallcount-btn" type="button" id="sa-sel-btn"><img src="images/search.png" alt="查询"/>查询</button>&nbsp;
  		<button class="showallcount-btn1" type="button" id="sa-add-btn"><img src="images/add.png" alt="添加"/>添加</button>
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
			   			<th>I D</th>
			   			<th>科室名称</th>
			   			<th>科室负责人</th>
			   			<th>科室描述</th>
			   			<th>操作</th>
			   		</thead>
			   		<tbody>
			   			<c:forEach items="${SelectAllHaoto_hAoto }" var="hAoto">
			   				<tr>
				   				<td>${hAoto.haoto_id }</td>
				   				<td>${hAoto.haoto_name }</td>
				   				<td>${hAoto.haoto_person }</td>
				   				<td>${hAoto.haoto_decribe }</td>
				   				<td>
				   					<button class="table-btn1"><a href="${basePath }SelectHaotoByIdsAction.do?haoto_id=${hAoto.haoto_id}"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button>&nbsp;
				   					<button class="table-btn2"><a href="${basePath }DeleteHaotoAction.do?haoto_id=${hAoto.haoto_id}"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
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
