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
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
	<script type="text/javascript">
			$(function(){
				$("#saf-btn-sel").click(function(){
					var hi_id = $("input[name='hi_id']").val();
					if(hi_id==null||hi_id==''){
						alert("请输入需要查询的ID!");
					}else{
						//1.获得tbody 对象,清空tbody 里边得内容
						console.log(hi_id);
						$("tbody").empty();
						//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
						$.ajax({
							type:"post",
							url:"SelectInformByHi_idAction.do",
							data:"hi_id="+hi_id,
							success:function(result){
								//result 是一个json 字符串 我们需要将它转换成js对象
								console.log(result);
								var hi = $.parseJSON(result);
								console.log(hi);	
								console.log($(hi)[0].hi_id);
								var id = $("<td>"+$(hi)[0].hi_id+"</td>");
								var personid = $("<td>"+$(hi)[0].hi_personid+"</td>");
								var tet = $("<td>"+$(hi)[0].hi_tet+"</td>");
								var content = $("<td>"+$(hi)[0].hi_content+"</td>");
								var a = $("<td><button class='table-btn1'><a href=SelectInformByHi_idsAction.do?hi_id="+$(hi)[0].hi_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button> &nbsp; <button class='table-btn2'><a href=DeleteInformAction.do?hi_id="+$(hi)[0].hi_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
								//创建tr 对象  将td 连在其后面
								var tr = $("<tr></tr>");
								tr.append(id);
								tr.append(personid);
								tr.append(tet);
								tr.append(content);
								tr.append(a);
								//将 tr 挂在到 tbody上
								$("tbody").append(tr);
							}
						});
					}
				});
				
				$("#saf-btn-add").click(function(){
					window.location.href="AddInform.do";
				});
			});
	</script>
  </head>
  
  <body>
	<div class="showallcount-div">
		ID&nbsp;&nbsp;<input placeholder="请输入通知ID查询" type="text" name="hi_id"/>
		<button class="showallcount-btn" type="button" id="saf-btn-sel"><img src="images/search.png" alt="查询"/>查询</button>&nbsp;
		<button class="showallcount-btn1" type="button" id="saf-btn-add"><img src="images/add.png" alt="添加"/>添加</button>
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
				<table border="1" cellpadding="0" cellspacing="0">
			    	<thead>
			    		<tr>
				    		<th>ID</th>
					    	<th>通知人ID</th>
					    	<th>通知时间</th>
					    	<th>通知内容</th>
					    	<th>操 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
				    	</tr>
			    	</thead>
			    	<tbody>
			    		<c:forEach items="${SelectAllInforms_hInforms.list }" var="hInforms" varStatus="status">
			    			<tr class="${status.count%2==0?'even':'odd' }">
				    			<td>${hInforms.hi_id }</td>
					    		<td>${hInforms.hi_personid }</td>
					    		<td>${hInforms.hi_tet }</td>
					    		<td>${hInforms.hi_content }</td>
					    		<td>
					    			<button class="table-btn1"><a href="${basePath }SelectInformByHi_idsAction.do?hi_id=${hInforms.hi_id }">
	
	<img src="images/UpdateLogo.png" alt="更新"/>更新</a></button>&nbsp;
					    			<button class="table-btn2"><a href="${basePath }DeleteInformAction.do?hi_id=${hInforms.hi_id }"><img src="images/DeleteLogo.png" alt="删除"/>删除</a></button>
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
	   					window.location.href='${basePath}SelectAllInformsAction.do?currentpage='+pagenum;
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
