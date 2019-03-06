<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加治疗费用</title>
    
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
	<script type="text/javascript" src="js/home_refresh.js"></script>
  	<script type="text/javascript" src="js/Submit.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#atm-inp-consumdate").click(function(){
				WdatePicker(			//主要就是以Json 来展示数据的
					{
						dateFmt:"yyyy-MM-dd HH:mm:ss",
						readOnly:true,
						isShowWeek:true
					}
				);
			});
			
			//获取病人 ID
			$.ajax({
  				type:"post",
  				url:"SelectAllHp_idsAction.do",
  				success:function(result){
  					var hp_ids = $.parseJSON(result);
  					for(var i=0;i<$(hp_ids).length;i++){
  						var option =$("<option>"+hp_ids[i]+"</option>");
  						$("[name='htm_patientid']").append(option);
  					}
  				}
  			});
  		});
  		function CheckIsEndMoney(){
  				var bol;
  				var patientid = $("[name='htm_patientid']").val();
  				console.log("patientid:"+patientid);
  				var bol;
  				$.ajax({
  					type:"post",
  					async:false,
  					url:"doctor/SelectTreateMoneyByHtm_patientidAction.do",
  					data:"patientid="+patientid,
  					success:function(result){
  						var b = $.parseJSON(result);
  						console.log("b:"+b);
  						if(b ==false){
  							bol=b;
  						}else{	
  							bol=true;
  						}
  					}
  				});
  				
  				if(bol==false){
  					console.log("bol:"+bol);
  					alert("该病人已经结算,不能重复结算!");
  					bol= false;
  				}else{
  				bol=true;
  				}
  				return bol;
  		}
  		$(function(){
  			var val =parseFloat($("#inp").val());
  			$("[name='htm_moneyconsum']").prop("value",val.toFixed(2));
  		});
  	</script>
  </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>结算信息/End TreateMoney Information</p>
  		<div class="Right_Index">
		  	<div id="div1"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div2"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div3"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div4"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
  	<div class="addcount-div2">
	     <form method="post" action="InsertTreatMoneyAction.do" onsubmit="return CheckIsEndMoney() && Checksubmit()">
	    	<table>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;病&nbsp;人&nbsp;I&nbsp;D&nbsp;<input class="addconut-input" type="text" name="htm_patientid" readonly="readonly" value="${TreatMoneyEnd_hpt_patientid}"/></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;费用名称
						<select class="addconut-input" name="htm_name">
							<option value="诊断费用">诊断费用</option>
							<option value="检查费用">检查费用</option>
							<option value="住院费用">住院费用</option>
							<option value="其他费用">其他费用</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;费用类型
						<select class="addconut-input" name="htm_treatmoneytype">
							<option value="微信">微信</option>
							<option value="支付宝">支付宝</option>
							<option value="现金">现金</option>
							<option value="其他">其他</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			
	    			<td>&nbsp;&nbsp;&nbsp;消费金额&nbsp;<input type="hidden" id="inp" value="${TreatMoneyEnd_sum }"/><input class="addconut-input" readonly="readonly" type="text" name="htm_moneyconsum"/>&nbsp;<span>(RMB)元</span></td>
	    		</tr>
	    		<tr>
	    			<td>&nbsp;&nbsp;&nbsp;消费日期&nbsp;<input class="addconut-input" type="text" class="Wdate" id="atm-inp-consumdate" name="htm_consumtime"/></td>
	    		</tr>
	    		<tr>
	    			<td>是否已付费
						<select class="addconut-input" name="htm_ispaymoney">
							<option value="是">是</option>
							<option value="否">否</option>		
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td><input onclick="return Checksubmit() && CheckIsEndMoney()" id="submit" class="submit" type="submit" value="结算"/></td>
	    		</tr>
	    	</table>
	    </form>
	  </div>
  </body>
</html>
