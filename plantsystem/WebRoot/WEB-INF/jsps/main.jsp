<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> 
	<title>南阳理工学院后勤管理系统</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/zzsc.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.alertable.css"> 	
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src='js/velocity.min.js'></script>
	<script src='js/velocity.ui.min.js'></script>
	<script src="js/jquery.alertable.js"></script>
	<script type="text/javascript">
		$(function(){
						$('.prompt-demo').on('click', function() {
							$.alertable.prompt('请输入标题').then(function(data) {
								window.location.href=encodeURI("add1.do?data="+data.value);
								console.log(data);
								/* alert(data);
								$("#btn").click(function(){
								    console.log("data:"+data);
									window.location.href=encodeURI("add1.do?data="+data);
								});  */
							}, function() {
								console.log('Prompt canceled');
							});
						});					
		});
	</script>
	<script type="text/javascript">
		$(function(){
			$("#submit_btn").click(function(){
				var name = document.getElementById("tname").value;
				window.location.href="select.do?name="+name;
			});
			
		});
		
		//jie
		function compileStr(code){ 
			  var c=String.fromCharCode(code.charCodeAt(0)+code.length);
			 for(var i=1;i<code.length;i++)
			  {      
			   c+=String.fromCharCode(code.charCodeAt(i)+code.charCodeAt(i-1));
			 }   
			 return escape(c);   
		 }
		
		//jia
		function uncompileStr(code){      
			 code=unescape(code);      
			 var c=String.fromCharCode(code.charCodeAt(0)-code.length);      
			 for(var i=1;i<code.length;i++)
			 {      
			  c+=String.fromCharCode(code.charCodeAt(i)-c.charCodeAt(i-1));      
			 }      
			 return c;  
		 }
		
		function del(uuidname){
			if(window.confirm("确定删除吗?")){
				var passwd =prompt("请输入删除密码:");
				console.log(passwd);
				if(passwd==uncompileStr("%3Dbai%A6%E7%E2%DC%E7%A2%8D")){
					window.location.href="delete.do?uuidname="+uuidname+"&password="+passwd;
				}else{
					alert("密码输入错误!");
				}
			}
				
		}
		function alter(uuidname){
			window.location.href="alter.do?uuidname="+uuidname+"";
		}
	</script>
	<style>
	* {box-sizing: border-box;}
	body{margin: 0;}
	div.search {padding: 30px 0}
	form {
	  position: relative;
	  width: 500px;
	 /* margin: 0 auto*/
	  padding-left:180px;
	}
	div.search {padding: 30px 0}
	.d1 {background: /*#A3D0C3*/;}
	.d1 input {
	  width: 100%;
	  height: 42px;
	  padding-left: 10px;
	  border: 2px solid #7BA7AB;
	  border-radius: 5px;
	  outline: none;
	  background: /*#F9F0DA;*/
	  color: #9E9C9C;
	}
	.d1 button {
	  position: absolute; 
	  top: 0;
	  right: 0px;
	  width: 42px;
	  height: 42px;
	  border: none;
	  background: #7BA7AB;
	  border-radius: 0 5px 5px 0;
	  cursor: pointer;
	}
	#btn{
	  position: absolute; 
	  top: 80px;
	  right: 300px;
	  width: 80px;
	  height: 42px;
	  border: none;
	  background: #7BA7AB;
	  border-radius: 5px;
	  cursor: pointer;
		
	}
	.d1 button:before {
	  content: "\f002";
	  font-family: FontAwesome;
	  font-size: 16px;
	  color: #F9F0DA;
	}
	.table{
		width: 70%;
		margin: 0 auto;
	}
	#win{
		  display:none; 
		  position:absolute; 
		  left:50%; 
		  top:50%; 
		  width:300px; 
		  height:150px;
		  margin-left:-200px; 
		  margin-top:-150px; 
		  border:1px solid blue; border-radius: 20px; 
		  background-color:snow; text-align:center;
		} 
		.jm1{
		 background-color:#79CDCD;
		 margin-top:40px;
		 float:right;
		 margin-right:15px;
		}
		.jm2{
		 background-color:#79CDCD;
		 margin-top:40px;
		 float:right;
		 margin-right:5px;
		}
	</style>
	<script>
		function openLogin(){
		   document.getElementById("win").style.display="block";
		}
		function closeLogin(){
		   document.getElementById("win").style.display="none";
		}
	</script>
	<script type="text/javascript">
 		$(function(){
 			$("#btn_submit").click(function(){
 				 var obj = document.getElementById("inputfile").files[0];
 				 var formFile = new FormData();
	             formFile.append("action", "upload.do");  
	             formFile.append("file", obj); 				//加入文件对象
	              var data = formFile;
	               $.ajax({
	                   url: "upload.do",
	                   data: data,
	                   type: "Post",
	                   dataType: "json",
	                   cache: false,//上传文件无需缓存
	                   processData: false,//用于对data参数进行序列化处理 这里必须false
	                   contentType: false, //必须
	                   success: function (result) {
	                       alert(result);
	                   }
	               });
 			});
 		});
 	</script>
</head>
<body>
 <div class="top" style="width: 100%; height: 50px; background-color: #7BA7AB; color: white; font-size: 20px;">
 	<div style="padding-left: 60px; padding-top: 8px; float: left;">南阳理工学院后勤管理系统</div>
 	<div  class="btn1" style="padding-right: 100px;float: right; padding-top: 8px;"> 
 		<div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >
      ${username } <span class="caret" ></span></button>
      <ul class="dropdown-menu" role="menu">
       	<li><a href="javascript:openLogin();">选择</a></li>
        <li><a href="exit.do">退出登陆</a></li>
      </ul>
    </div>
 	</div>
 </div>
		<div class="search d1" style="padding-left: 30px;">
		  <form>
			  <input type="text" id="tname" name="name" placeholder="搜索从这里开始...">
			  <button type="button" id="submit_btn"></button>
		  </form>
		  <button type="button" class="prompt-demo" id="btn">添加</button>
		</div>

  
<table class="table table-bordered" style="text-align: center;">
	<!--<caption>悬停表格布局</caption>-->
	<thead>
		<tr>
			<th>植物名称</th>
			<th>时间/操作人</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="map" items="${map }">
			<tr>
				<td>${map.filename }</td>
				<td>${map.dat }</td>
				<td>
					<button type="button" class="btn btn-primary" id="alterbtn" onclick="alter('${map.uuidname }')">修改</button>
					<button type="button" class="btn btn-warning" onclick="del('${map.uuidname }')">删除</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="win">
		<h5>请选择图片</h5>
	    <input type="file" id="inputfile" class="" style="margin-top:25px;margin-left:50px; text-align:center; width:80%"/>
	    <button type="button" class="jm1" onclick="closeLogin();" >取消</button>	
		<button type="button" class="jm2" onclick="closeLogin();" id="btn_submit">确定</button>	
	</div> 
</body>
</html>
