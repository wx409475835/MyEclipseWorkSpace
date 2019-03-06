<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询所有病人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
	<script type="text/javascript">
			$(function(){
				$("#showall-sel-btn").click(function(){
					var hp_id = $("input[name='hp_id']").val();
					if(hp_id==null||hp_id==''){
						alert("请输入需要查询的ID或姓名!");
					}else{
						//1.获得tbody 对象,清空tbody 里边得内容
						console.log(hp_id);
						$("tbody").empty();
						//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
						if(!isNaN(hp_id)){
							$.ajax({
								type:"post",
								url:"SelectPatientByIdAction.do",
								data:"hp_id="+hp_id,
								success:function(result){
									//result 是一个json 字符串 我们需要将它转换成js对象
									console.log(result);
									var hp = $.parseJSON(result);
									console.log(hp);	
									console.log($(hp)[0].hp_id);
									var id = $("<td>"+$(hp)[0].hp_id+"</td>");
									var doctorid = $("<td>"+$(hp)[0].hp_doctorid+"</td>");
									var name = $("<td>"+$(hp)[0].hp_name+"</td>");
									var sex = $("<td>"+$(hp)[0].hp_sex+"</td>");
									var birthday = $("<td>"+$(hp)[0].hp_birthday+"</td>");
									var tath = $("<td>"+$(hp)[0].hp_tath+"</td>");
									var tsd = $("<td>"+$(hp)[0].hp_tsd+"</td>");
									var mrid = $("<td>"+$(hp)[0].hp_mrid+"</td>");
									var stat = $("<td>"+$(hp)[0].hp_stat+"</td>");
									var marry = $("<td>"+$(hp)[0].hp_marry+"</td>");
									var a = $("<td><button class='table-btn1'><a href=SelectPatient1ByIdAction.do?hp_id="+$(hp)[0].hp_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteHPatientEmrByPatientidAction.do?hp_id="+$(hp)[0].hp_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
									//创建tr 对象  将td 连在其后面
									var tr = $("<tr></tr>");
									tr.append(id);
									tr.append(doctorid);
									tr.append(name);
									tr.append(sex);
									tr.append(birthday);
									tr.append(tath);
							     	tr.append(tsd);
									tr.append(mrid);
									tr.append(stat);
									tr.append(marry);
									tr.append(a);
									//将 tr 挂在到 tbody上
									$("tbody").append(tr);
								}
							});
						}else{
							$.ajax({
								type:"post",
								url:"SelectHPatientsByHp_nameAction.do",
								data:"hp_name="+hp_id,
								success:function(result){
									//result 是一个json 字符串 我们需要将它转换成js对象
									console.log(result);
									var hp = $.parseJSON(result);
									console.log(hp);	
									console.log($(hp)[0].hp_id);
									for(var i=0;i<$(hp).length;i++){
										var id = $("<td>"+$(hp)[i].hp_id+"</td>");
										var doctorid = $("<td>"+$(hp)[i].hp_doctorid+"</td>");
										var name = $("<td>"+$(hp)[i].hp_name+"</td>");
										var sex = $("<td>"+$(hp)[i].hp_sex+"</td>");
										var birthday = $("<td>"+$(hp)[i].hp_birthday+"</td>");
										var tath = $("<td>"+$(hp)[i].hp_tath+"</td>");
										var tsd = $("<td>"+$(hp)[i].hp_tsd+"</td>");
										var mrid = $("<td>"+$(hp)[i].hp_mrid+"</td>");
										var stat = $("<td>"+$(hp)[i].hp_stat+"</td>");
										var marry = $("<td>"+$(hp)[i].hp_marry+"</td>");
										var a = $("<td><button class='table-btn1'><a href=SelectPatient1ByIdAction.do?hp_id="+$(hp)[i].hp_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteHPatientEmrByPatientidAction.do?hp_id="+$(hp)[i].hp_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
										//创建tr 对象  将td 连在其后面
										var tr = $("<tr></tr>");
										tr.append(id);
										tr.append(doctorid);
										tr.append(name);
										tr.append(sex);
										tr.append(birthday);
										tr.append(tath);
								     	tr.append(tsd);
										tr.append(mrid);
										tr.append(stat);
										tr.append(marry);
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
			$("#show-add-btn").click(function() {
				window.location.href = "AddPatient.do";
			});
		});
	});
	
	$(function(){
		$("a:contains('删除')").click(function(){
			var id =$($(this).parent().parent().parent().children()[0]).text();
			var a = $(this);
			$(this).removeAttr("href");
			$.ajax({
				type:"post",
				url:"SelectHTreateRecordByHtr_patientidAction.do",
				data:"htr_patientid="+id,
				success:function(result){
					console.log(result);
					if(result==0){
						var boolean = confirm("确认删除此病人信息和与此病人相关的所有信息吗？");
						console.log("boolean:"+boolean);
						if(boolean==true){
							window.location.href="DeleteHPatientEmrByPatientidAction.do?hp_id="+id;
						}
					}else if(result==2){
						alert("该病人已经结算,不能删除此病人信息");
					}
				}
			});
		});
	});
  </script>
  </head>
  
  <body>
  	<div class="showallcount-div">
  		ID<input name="hp_id" type="text" placeholder="请输入需要查询的ID或姓名"/>
  		<button class="showallcount-btn" type="button" id="showall-sel-btn"><img src="images/search.png" alt="查询"/>查找</button>&nbsp;
  		<button class="showallcount-btn1" type="button" id="show-add-btn"><img src="images/add.png" alt="添加"/>添加</button>
  	</div>
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
	   		<table border="1px" cellpadding="0" cellspacing="0">
		   		<thead>
		   			<th>ID</th>
		   			<th>主治医生ID</th>
		   			<th>姓名</th>
		   			<th>性别</th>
		   			<th>出生年月</th>
		   			<th>入院时间</th>
		   			<th>症状描述</th>
		   			<th>病历编号</th>
		   			<th>状态</th>
		   			<th>婚否</th>
		   			<th> &nbsp;&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;</th>
		   		</thead>
		    	<tbody>
		    		<c:forEach items="${SelectAllPatients_hPatients.list }" var="hPatients" varStatus="status">
			    		<tr class="${status.count%2==0?'even':'odd' }">
					    	<td>${hPatients.hp_id }</td>
						   	<td>${hPatients.hp_doctorid }</td>
						   	<td>${hPatients.hp_name }</td>
						   	<td>${hPatients.hp_sex }</td>
						   	<td>${hPatients.hp_birthday }</td>
						   	<td>${hPatients.hp_tath }</td>
						   	<td>${hPatients.hp_tsd }</td>
						   	<td>${hPatients.hp_mrid }</td>
						   	<td>${hPatients.hp_stat }</td>
						   	<td>${hPatients.hp_marry }</td>
						   	<td>
						   		<button class="table-btn1"><a href="${basePath }SelectPatient1ByIdAction.do?hp_id=${hPatients.hp_id }"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button> &nbsp;
						   		<button class="table-btn2"><a href="${basePath }DeleteHPatientEmrByPatientidAction.do?hp_id=${hPatients.hp_id }"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
						   	</td>
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
	   					window.location.href='${basePath}SelectAllPatientsActions.do?currentpage='+pagenum;
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
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${ SelectAllPatients_hPatients.previouspage},${ SelectAllPatients_hPatients.totalpage})">上一页</a></li>
				<c:forEach var="pagenum" items="${ SelectAllPatients_hPatients.pagebar }">
					<c:if test="${pagenum ==  SelectAllPatients_hPatients.currentpage }">
						<li class="table-ul-center-li-currentpage"><a href="javascript:void(0)">${pagenum }</a></li>
					</c:if>
					<c:if test="${pagenum !=  SelectAllPatients_hPatients.currentpage }">
						<li class="table-ul-center-li"><a href="javascript:void(0)" onclick="gotopage(${pagenum },${ SelectAllPatients_hPatients.totalpage})">${pagenum }</a></li>
					</c:if>
				</c:forEach>
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${ SelectAllPatients_hPatients.nextpage},${ SelectAllPatients_hPatients.totalpage })">下一页</a></li>
				<li class="table-ul-li-inp"><input type="text" id="page" maxlength="2" style="width: 30;border-radius: -webkit-calc(20px);" /></li>
				<li class="table-ul-li-btn"><button onclick="gotopage(document.getElementById('page').value,${ SelectAllPatients_hPatients.totalpage})">Go</button></li>
			</ul>
		</div>
   	</div>
</html>
