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
    
    <title>所有电子病历信息</title>
    
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
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
  	<script type="text/javascript">
  		$(function(){
		//用于 向后台获得数据 
		$("#sahp-sel-btn").click(function(){
			var hemr_id = $("input[name='hemr_id']").val();
			if(hemr_id==null||hemr_id==''){
				alert("请输入需要查询的ID!");
			}else{
				//1.获得tbody 对象,清空tbody 里边得内容
				console.log(hemr_id);
				$("tbody").empty();
				//2.发送Ajax请求 将在输入框中输入得ID 查询到得记录动态加载到本页面中
				$.ajax({
					type:"post",
					url:"SelectHPatientEmrByHemr_IdAction.do",
					data:"hemr_id="+hemr_id,
					success:function(result){
						//result 是一个json 字符串 我们需要将它转换成js对象
						console.log(result);
						var hp = $.parseJSON(result);
						console.log(hp);	
						console.log($(hp)[0].hemr_id);
						var id = $("<td>"+$(hp)[0].hemr_id+"</td>");
						var patientid = $("<td>"+$(hp)[0].hemr_patientid+"</td>");
						var doctorid = $("<td>"+$(hp)[0].hemr_doctorid+"</td>");
						var diagnosis = $("<td>"+$(hp)[0].hemr_diagnosis+"</td>");
						var symptom = $("<td>"+$(hp)[0].hemr_symptom+"</td>");
						var method = $("<td>"+$(hp)[0].hemr_method+"</td>");
						var starttime = $("<td>"+$(hp)[0].hemr_starttime+"</td>");
						var treatisend = $("<td>"+$(hp)[0].hemr_treatisend+"</td>");
						var endtime = $("<td>"+$(hp)[0].hemr_endtime+"</td>");
						var a = $("<td><button class='table-btn1'><a href=SelectHPatientEmrByHemr_IdsAction.do?hemr_id="+$(hp)[0].hemr_id+"><img src='images/UpdateLogo.png' alt='更新'/>更新</a></button></td>");
						//创建tr 对象  将td 连在其后面
						var tr = $("<tr></tr>");
						tr.append(id);
						tr.append(doctorid);
						tr.append(patientid);
						tr.append(diagnosis);
						tr.append(symptom);
						tr.append(method);
				     	tr.append(starttime);
						tr.append(treatisend);
						tr.append(endtime);
						tr.append(a);
						//将 tr 挂在到 tbody上
						$("tbody").append(tr);
					}
				});
			}
		});
	});
  	</script>
  </head>
  
  <body>
    <div class="showallcount-div">
  		ID&nbsp;&nbsp;<input  name="hemr_id" type="text" placeholder="请输入需要查询的ID号"/>
  		<button class="showallcount-btn" type="button" id="sahp-sel-btn"><img src="images/search.png" alt="查询"/>查询</button>
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
		   			<th>病人ID</th>
		   			<th>主治医生ID</th>
		   			<th>诊断</th>
		   			<th>病状</th>
		   			<th>处方</th>
		   			<th>治疗开始时间</th>
		   			<th>治疗是否结束</th>
		   			<th>治疗结束时间</th>
		   			<th>操 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
		   		</thead>
		    	<tbody>
		    		<c:forEach items="${SelectAllHPatientsEmr_hEmrs.list }" var="hPatients" varStatus="status">
			    		<tr class="${status.count%2==0?'even':'odd' }">
					    	<td>${hPatients.hemr_id}</td>
						   	<td>${hPatients.hemr_patientid}</td>
						   	<td>${hPatients.hemr_doctorid}</td>
						   	<td>${hPatients.hemr_diagnosis}</td>
						   	<td>${hPatients.hemr_symptom}</td>
						   	<td>${hPatients.hemr_method }</td>
						   	<td>${hPatients.hemr_starttime }</td>
						   	<td>${hPatients.hemr_treatisend }</td>
						   	<td>${hPatients.hemr_endtime }</td>
						   	<td>
						   		<button class="table-btn1"><a href="${basePath }SelectHPatientEmrByHemr_IdsAction.do?hemr_id=${hPatients.hemr_id}"><img src="images/UpdateLogo.png" alt="更新"/>更新</a></button>
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
	   					window.location.href='${basePath}SelectAllHPatientsEmrAction.do?currentpage='+pagenum;
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
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllHPatientsEmr_hEmrs.previouspage},${SelectAllHPatientsEmr_hEmrs.totalpage})">上一页</a></li>
				<c:forEach var="pagenum" items="${SelectAllHPatientsEmr_hEmrs.pagebar }">
					<c:if test="${pagenum == SelectAllHPatientsEmr_hEmrs.currentpage }">
						<li class="table-ul-center-li-currentpage"><a href="javascript:void(0)">${pagenum }</a></li>
					</c:if>
					<c:if test="${pagenum != SelectAllHPatientsEmr_hEmrs.currentpage }">
						<li class="table-ul-center-li"><a href="javascript:void(0)" onclick="gotopage(${pagenum },${SelectAllHPatientsEmr_hEmrs.totalpage})">${pagenum }</a></li>
					</c:if>
				</c:forEach>
				<li class="table-ul-li"><a href="javascript:void(0)" onclick="gotopage(${SelectAllHPatientsEmr_hEmrs.nextpage},${SelectAllHPatientsEmr_hEmrs.totalpage })">下一页</a></li>
				<li class="table-ul-li-inp"><input type="text" id="page" maxlength="2" style="width: 30;border-radius: -webkit-calc(20px);" /></li>
				<li class="table-ul-li-btn"><button onclick="gotopage(document.getElementById('page').value,${SelectAllHPatientsEmr_hEmrs.totalpage})">Go</button></li>
			</ul>
		</div>
	 </div>
  </body>
</html>
