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
    
    <title>查询所有医生用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#uda-sel-btn").click(function(){
				var hd_id = $("[name='hd_id']").val();
				if(hd_id==null||hd_id==''){
					alert("请输入需要查询的ID或姓名!");
				}else{
					//1.获得tbody 对象,清空tbody 里边得内容
					$("tbody").empty();
					//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
					if(!isNaN(hd_id)){
						$.ajax({
							type:"post",
							url:"SelectDoctorAccountAction.do",
							data:"hd_id="+hd_id,
							success:function(result){
								//result 是一个json 字符串 我们需要将它转换成js对象
								var doctors = $.parseJSON(result);
								console.log(doctors);
								console.log($(doctors)[0].hd_name);
								var id = $("<td>"+$(doctors)[0].hd_id+"</td>");
								var name = $("<td>"+$(doctors)[0].hd_name+"</td>");
								console.log("id-name:"+id+name);
								var age = $("<td>"+$(doctors)[0].hd_age+"</td>");
								var sex = $("<td>"+$(doctors)[0].hd_sex+"</td>");
								var speciality = $("<td>"+$(doctors)[0].hd_speciality+"</td>");
								var pt = $("<td>"+$(doctors)[0].hd_pt+"</td>");
								var haotoid = $("<td>"+$(doctors)[0].hd_haotoid+"</td>");
								var mobile = $("<td>"+$(doctors)[0].hd_mobile+"</td>");
								var ri = $("<td>"+$(doctors)[0].hd_ri+"</td>");
								/* var a = $("<td href="">更新</td>"); */
								//创建tr 对象  将td 连在其后面
								var a = $("<td><button class='table-btn1'><a href=UpdateDcotorAccountSelectDoctorByIdAction.do?hd_id="+$(doctors)[0].hd_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp;<button class='table-btn2'><a href=DeleteDoctorAccountAction.do?hd_id="+$(doctors)[0].hd_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></td><button>");
								var tr = $("<tr></tr>");
								tr.append(id);
								tr.append(name);
								tr.append(age);
								tr.append(sex);
								tr.append(speciality);
								tr.append(pt);
								tr.append(haotoid);
								tr.append(mobile);
								tr.append(ri);
								tr.append(a);
								//将 tr 挂在到 tbody上
								$("tbody").append(tr);
							}
						});
					}else{
						$.ajax({
							type:"post",
							url:"SelectDoctorByHd_name.do",
							data:"hd_name="+hd_id,
							success:function(result){
								//result 是一个json 字符串 我们需要将它转换成js对象
								var doctors = $.parseJSON(result);
								console.log(doctors);
								console.log($(doctors)[0].hd_name);
								for(var i=0;i<$(doctors).length;i++){
									var id = $("<td>"+$(doctors)[i].hd_id+"</td>");
									var name = $("<td>"+$(doctors)[i].hd_name+"</td>");
									console.log("id-name:"+id+name);
									var age = $("<td>"+$(doctors)[i].hd_age+"</td>");
									var sex = $("<td>"+$(doctors)[i].hd_sex+"</td>");
									var speciality = $("<td>"+$(doctors)[0].hd_speciality+"</td>");
									var pt = $("<td>"+$(doctors)[i].hd_pt+"</td>");
									var haotoid = $("<td>"+$(doctors)[i].hd_haotoid+"</td>");
									var mobile = $("<td>"+$(doctors)[i].hd_mobile+"</td>");
									var ri = $("<td>"+$(doctors)[i].hd_ri+"</td>");
									/* var a = $("<td href="">更新</td>"); */
									//创建tr 对象  将td 连在其后面
									var a = $("<td><button class='table-btn1'><a href=UpdateDcotorAccountSelectDoctorByIdAction.do?hd_id="+$(doctors)[i].hd_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp;<button class='table-btn2'><a href=DeleteDoctorAccountAction.do?hd_id="+$(doctors)[i].hd_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></td><button>");
									var tr = $("<tr></tr>");
									tr.append(id);
									tr.append(name);
									tr.append(age);
									tr.append(sex);
									tr.append(speciality);
									tr.append(pt);
									tr.append(haotoid);
									tr.append(mobile);
									tr.append(ri);
									tr.append(a);
									//将 tr 挂在到 tbody上
									$("tbody").append(tr);
								}
							}
						});
					}
			}
		});
		
		$("#uda-add-btn").click(function(){
			window.location.href="AddDoctorAccount.do";
		});
	});
	
	$(function(){
		$("button a:contains('删除')").click(function(){
			var id =$($(this).parent().parent().parent().children()[0]).text();
			var a = $(this);
			$(this).removeAttr("href");
			$.ajax({
				type:"post",
				url:"SelectHPatientByHp_doctoridAction.do",
				data:"hp_doctorid="+id,
				success:function(result){
					if(result==0){
						alert("该医生信息不能删除,请先删除依赖此医生信息的病人信息!");
					}else{
						window.location.href="DeleteDoctorAccountAction.do?hd_id="+id;
					}
				}
			});
		});
		
	});
	</script>
  </head>
  
  <body>
  	<div class="showallcount-div">
  		ID&nbsp;&nbsp;<input  type="text" name="hd_id" placeholder="请输入需要查询的ID或姓名"/> 
  		<button class="showallcount-btn" type="button" id="uda-sel-btn"><img src="images/search.png" alt="查询"/>查询</button>
  		<button class="showallcount-btn1" type="button" id="uda-add-btn"><img src="images/add.png" alt="查询"/>添加</button>
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
		   		<table cellpadding="0" cellspacing="0">
			   		<thead>
			   			<th>I  D</th>
			   			<th>姓名</th>
			   			<th>年龄</th>
			   			<th>性别</th>
			   			<th>特长</th>
			   			<th>职称</th>
			   			<th>科室编号</th>
			   			<th>手机号</th>
			   			<th>预约信息</th>
			   			<th>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;操 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</th>
			   		</thead>
			   		<tbody>
			   			<c:forEach items="${SelectAllDoctorAccountAction_hDoctor.list}" var="hDoctor" varStatus="status">
			   				<tr class="${status.count%2==0?'even':'odd' }">
				   				<td>${hDoctor.hd_id }</td>
				   				<td>${hDoctor.hd_name }</td>
				   				<td>${hDoctor.hd_age }</td>
				   				<td>${hDoctor.hd_sex }</td>
				   				<td>${hDoctor.hd_speciality }</td>
				   				<td>${hDoctor.hd_pt }</td>
				   				<td>${hDoctor.hd_haotoid }</td>
				   				<td>${hDoctor.hd_mobile }</td>
				   				<td>${hDoctor.hd_ri }</td>
				   				<td>
				   					<button class="table-btn1"><a href="${basePath }UpdateDcotorAccountSelectDoctorByIdAction.do?hd_id=${hDoctor.hd_id}"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button>
				   					<button class="table-btn2"><a href="${basePath }DeleteDoctorAccountAction.do?hd_id=${hDoctor.hd_id}"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
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
	   					window.location.href='${basePath}SelectAllDoctorAccountAction.do?currentpage='+pagenum;
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
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllDoctorAccountAction_hDoctor.previouspage},${SelectAllDoctorAccountAction_hDoctor.totalpage})">上一页</a></li>
				<c:forEach var="pagenum" items="${SelectAllDoctorAccountAction_hDoctor.pagebar }">
					<c:if test="${pagenum == SelectAllDoctorAccountAction_hDoctor.currentpage }">
						<li class="table-ul-center-li-currentpage"><a href="javascript:void(0)">${pagenum }</a></li>
					</c:if>
					<c:if test="${pagenum != SelectAllDoctorAccountAction_hDoctor.currentpage }">
						<li class="table-ul-center-li"><a href="javascript:void(0)" onclick="gotopage(${pagenum },${SelectAllDoctorAccountAction_hDoctor.totalpage})">${pagenum }</a></li>
					</c:if>
				</c:forEach>
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllDoctorAccountAction_hDoctor.nextpage},${SelectAllDoctorAccountAction_hDoctor.totalpage })">下一页</a></li>
				<li class="table-ul-li-inp"><input type="text" id="page" maxlength="2" style="width: 30;border-radius: -webkit-calc(20px);" /></li>
				<li class="table-ul-li-btn"><button onclick="gotopage(document.getElementById('page').value,${SelectAllDoctorAccountAction_hDoctor.totalpage})">Go</button></li>
			</ul>
		</div>
	 </div>
  </body>
</html>
