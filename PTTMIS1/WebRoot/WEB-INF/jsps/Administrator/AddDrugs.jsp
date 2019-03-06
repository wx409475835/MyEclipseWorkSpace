<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加药品信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/Submit.js"></script>
	<script type="text/javascript" src="js/home_refresh.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#ad-inp-date").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
		});
		
		//设置药品名称非重复
		function JudgeDrugName(){
			var sub = document.getElementById("submit");
			var hdrug_name = $("[name='hdrug_name']").val();
			console.log("hdrug_name:" + hdrug_name);
			$.ajax({
				type:"post",
				url:"JudgeDrugNameAction.do",
				data:"hdrug_name=" + hdrug_name,
				success:function(result) {
					if (result == '药品名称已存在') {
						$("#hdrug_name").text(result);
						$("#hdrug_name").css("color", "red");
						sub.disabled = true;
						return false;
					} else {
						$("#hdrug_name").text(result);
						$("#hdrug_name").css("color", "green");
						sub.disabled = false;
						return true;
					}
				}
			});
		}
		
		function CheckPrice(){
			var sub = document.getElementById("submit");
			var price = $("[name='hdrug_price']").val();
			//456456.45
			var p = /^\d+\.\d{1,2}$/;
			var r = /^\d+$/;
			if((r.test(price)==false)&&(p.test(price)==false)){	
				$("#hdrug_price").text("请输入正确的价格,价格精确到小数点后两位");
				$("#hdrug_price").css("color","red");
				sub.disabled=true;
				return false;
			}else{
				$("#hdrug_price").text("");
				sub.disabled=false;
				return true;
			}
		}
		
	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>添加药品信息/Add Drugs Informations</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     <div class="addcount-div2">
	    <form method="post" action="AddDrugsAction.do" onsubmit="return Checksubmit() & JudgeDrugName()">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品名称&nbsp;&nbsp;&nbsp;<input onchange="return CheckPrice()" class="addconut-input" placeholder="请输入药品名称" type="text" name="hdrug_name" onblur="return JudgeDrugName()"/>&nbsp;<span id="hdrug_name"></span></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品价格&nbsp;&nbsp;&nbsp;<input onblur="return CheckPrice()" class="addconut-input" placeholder="请输入药品价格" type="text" name="hdrug_price"/>&nbsp;<span id="hdrug_price"></span></td>
	    		</tr>
	    		<tr>
	    			<td>药品生产日期<input class="addconut-input" placeholder="请选择药品生产日期" type="text" name="hdrug_birthday" class="Wdate" id="ad-inp-date"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品类型&nbsp;&nbsp;
						<select class="addconut-input" class="addconut-input" name="hdrug_type">
							<option value="OTC药品">OTC药品</option>
							<option value="处方药品">处方药品</option>
							<option value="零售药品">零售药品</option>
							<option value="临床药品">临床药品</option>
							<option value="中药">中药</option>
							<option value="西药">西药</option>
							<option value="血液制品">血液制品</option>
							<option value="诊断实剂">诊断实剂</option>
							<option value="颗粒剂">颗粒剂</option>
							<option value="丸剂">丸剂</option>
							<option value="散剂">散剂</option>
							<option value="酊剂">酊剂</option>
							<option value="片剂">片剂</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品介绍&nbsp;&nbsp;&nbsp;<input class="addconut-input" placeholder="请选择药品药品介绍" type="text" name="hdrug_introduce"/></td>
	    		</tr>
	    		<tr>
	    			<td><input onclick="return Checksubmit()" class="submit" id="submit" type="submit" onclick="return Checksubmit()" value="确认添加"/></td>
	    		</tr>
	    	</table>
	    </form>
	  </div>
  </body>
</html>
