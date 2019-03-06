<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新药品页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
	<link rel="stylesheet" type="text/css" href="css/table_rightIndex.css">
	<link rel="stylesheet" type="text/css" href="css/right_Index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("[name='hdrug_birthday']").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			
			//设置药品类型的选中状态
			var hdrug_type = $("#ud-inp-type").val();
			var type_op = $("[name='hdrug_type'] option");
			console.log("hdrug_type:"+hdrug_type);
			for(var i=0;i<$(type_op).length;i++){
				if(type_op[i].value == hdrug_type){
					console.log("1:"+type_op[i].value);
					$(type_op[i]).prop("selected",true);
				}
			}
  		});
  		
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
  		<p>修改药品信息/Update Drug Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     	<div class="addcount-div2">
	     <form method="post" action="UpdateDrugAction.do">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;<input class="addconut-input" readonly="readonly" name="hdrug_id" type="text" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_id }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品名称&nbsp;&nbsp;<input class="addconut-input" name="hdrug_name" type="text" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_name }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品价格&nbsp;&nbsp;<input onblur="return CheckPrice()" class="addconut-input" name="hdrug_price" type="text" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_price }"/>&nbsp;<span id="hdrug_price"></span></td>
	    		</tr>
	    		<tr>
	    			<td>药品生产日期<input class="addconut-input" class="Wdate" name="hdrug_birthday" type="text" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_birthday }"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品类型&nbsp;<input  class="addconut-input" type="hidden" id="ud-inp-type" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_type }"/>
	    				<select class="addconut-input" name="hdrug_type">
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
	    			<td>&nbsp;&nbsp;&nbsp;&nbsp;药品介绍&nbsp;&nbsp;<input class="addconut-input" name="hdrug_introduce" type="text" value="${SelectHDrugByHdrug_ids_hDrug.hdrug_introduce }"/></td>
	    		</tr>
	    		<tr>
	    			<td><input id="submit"  class="submit"  onclick="return Checksubmit()"  type="submit" value="确认修改"/></td>
	    		</tr>
	    	</table>
	    </form>
     </div>
  </body>
</html>
