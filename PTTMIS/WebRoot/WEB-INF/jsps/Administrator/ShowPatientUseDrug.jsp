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
    
    <title>结账信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<link rel="stylesheet" type="text/css" href="css/BinaryColour.css">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
	<script type="text/javascript">
		function CheckTreateIsEnd(){
			var treateisend; 
			var bool = true;
			var hpt_id = $("[name='hpt_id']").val();
			console.log("htp_id:"+hpt_id);
			$.ajax({
				type:"post",
				url:"SelectHemrByHemr_patientidAction.do",
				data:"hemr_patientid="+hpt_id,
				async:false,
				success:function(result){
					var emr = $.parseJSON(result);
					treateisend = emr.hemr_treatisend;
					console.log("treateisend:"+treateisend);
				}
			});
			if("否"==treateisend){
				bool = confirm("治疗还未结束,确定要结算吗？");
			}
			return bool;
		}
		$(function(){
			$("#spud-btn-sel").click(function(){
				//将 表格显示出来
				var hdrug_count = 0;
				var patientusedrugs;
					
				$("table").css("display","block");
				var hpt_patientid = $("[name='hpt_id']").val();
				if(hpt_patientid==null||hpt_patientid==''){
					alert("请输入需要查询的ID!");
				}else{
					console.log("hpt_id:"+hpt_patientid);
					
					
					//获取数量 
					$.ajax({
						type:"post",
						url:"SelectDrugCountAction.do",
						data:"hemr_patientid="+hpt_patientid,
						success:function(result){
							 patientusedrugs = $.parseJSON(result);		//拿到后台的js字符串
							 console.log(patientusedrugs);
						}
					});
					
					
					$.ajax({
						type:"post",
						url:"ShowPatientUseDrugAction.do",
						data:"hpt_patientid="+hpt_patientid,
						success:function(result){
						$("tbody").empty();
						var drug = $.parseJSON(result);
						console.log("Drugs:"+drug);
						for(var i=0;i<$(drug).length;i++){
							console.log("aa:"+drug[i].hdrug_id);
							if(drug[i].hdrug_id == patientusedrugs[i].hpt_drugid){
								var id = $("<td>"+patientusedrugs[i].hpt_id+"</td>");
								var patientid = $("<td>"+patientusedrugs[i].hpt_patientid+"</td>");
								var drugid = $("<td>"+drug[i].hdrug_id+"</td>");
								var name = $("<td>"+drug[i].hdrug_name+"</td>");
								var price = $("<td>"+drug[i].hdrug_price+"</td>");
								var birthday = $("<td>"+drug[i].hdrug_birthday+"</td>");
								var type = $("<td>"+drug[i].hdrug_type+"</td>");
								var count = $("<td>"+patientusedrugs[i].hpt_count+"</td>");
								var introduce = $("<td>"+drug[i].hdrug_introduce+"</td>");
								var a = $("<td><button class='table-btn1' onclick='return CheckTreateIsEnd()'><a href=TreatMoneyEndAction.do?hpt_patientid="+patientusedrugs[i].hpt_patientid+"><img src='images/endmoney.png' alt='结算'>结算</a></button></td>");
						        if(i%2==0){
						        	var tr = $("<tr class='odd'></tr>");
						        }else{
						        	var tr = $("<tr class='even'></tr>");
						        }
						        tr.append(id);
						        tr.append(patientid);
						        tr.append(drugid);
						        tr.append(name);
						        tr.append(price);
						        tr.append(birthday);
						        tr.append(type);
						        tr.append(count);
						        tr.append(introduce);
						        tr.append(a);
						        $("tbody").append(tr);
						    }
						}
					}
					
				});
			}
		});
	});
	</script>
	
	<style type="text/css">
		table {
			position:relative;
			margin:0 auto;
			border: 1px red solid;
		}
		
		table th{
			width: 140px;
		}
		
	</style>
	
  </head>
  
  <body>
    <div class="showallcount-div">
    	ID&nbsp;&nbsp;<input placeholder="请输入需要结算病人的ID" type="text" name="hpt_id"/>
    	<button class="showallcount-btn" type="button" id="spud-btn-sel"><img src="images/search.png" alt="查询"/>查询</button>
    </div>
     <%-- <c:if test="${ShowPatientUseDrug_hPatientusedrugs !=null && ShowPatientUseDrug_hPatientusedrugs !='[]' }"> --%>
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
			   	<table style="display: none;"   cellpadding="0" cellspacing="0">
			    	<thead>
			    		<tr>
				    		<th>ID</th>					    		
				    		<th>病人ID</th>
						    <th>药品ID</th>
			     			<th>名称</th>
			     			<th>价格(元)</th>
			     			<th>生产日期</th>
			     			<th>药品类型</th>
			     			<th>数量</th>
			     			<th>简介</th>
							<th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
					   	</tr>
			    	</thead>
			    	<tbody></tbody>
			    </table>
		 	</div>
	    </div>
	</div>
    <%-- </c:if> --%>
  </body>
</html>
