<%@page import="org.aspectj.weaver.reflect.Java14GenericSignatureInformationProvider"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>南阳理工学院后勤管理系统</title>
    <link rel="stylesheet" href="css/layui.css" media="all">
    <link rel="stylesheet" href="css/icon.css"  media="all">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
			.left{
		 margin-top:0px;
		 width:200px;
		 height:490px;
		 background-color:#ffffff;
		 margin-left:120px;
		 float: left;
		border-color:#000;
		border-width:1px;
		}
		/* .right{
			position: absolute;
			top: 90px;
			right: 70px;
			 padding-top:90px;
			 padding-right: 70px;
			 width:200px;
			 height:490px;
			 background-color:#ffffff;
			 margin-right:40px;
			 float: right;
			border-color:#000;
			border-width:1px;
		}
		 */
		/*.right{
		  margin-top:20px;
		  width:200px;
		  height:490px;
		  background-color:#F5F5F5;
		  margin-right:135px;
		  float: right;
			
		}*/
		
		.container{
		  width:700px;
		  height: 490px;
		  margin:auto;
		  padding-top: 0px;
		  padding-left: 0px;
		  border-color:#000;
		  background-color:#ffffff;
		border-width:1px;
		  
		}
		
		.button2{
		  
		   position: relative;
		  /*top: 50px;
		  left: 50px;*/
		 /* padding-left: 10px;*/
		  margin-bottom: 30px;
		  padding-bottom: 25px;
		  width: 80px;
		  height: 5px;
		  border: none;
		  background: #44b548;
		  border-radius: 2px;
		  font-size:15px;
		  letter-spacing: 5px;
		  cursor: pointer;
		  color: white;
		  vertical-align:middle ;
		  text-align:center;
		}
		.low{
			width: 100%;
			height: 50px;
			margin-bottom: 0px;
		
		
		}
	</style>
</head>
<body style="background-color: #f6f8f9;">
	
   <div class="top" style="width: 100%; height: 60px;  padding-top:10px;padding-bottom:20px;background-color: #7BA7AB; color: white; font-size: 20px;">
 	<div style="padding-left: 60px; padding-top: 8px; float: left;">  南阳理工学院后勤管理系统</div>
 	<div  class="btn1" style="padding-right: 100px;float: right; padding-top: 8px;"> 
 		<div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >
      ${username } <span class="caret" ></span></button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="exit.do">退出登陆</a></li>
      </ul>
    </div>
 	</div>
   </div>
   <div class="zhongjian"  style="width: 100%; height: 100%; margin-top: 40px;">
	   <div class='left'>
		  <div style='font-size:20px; margin-left:50px;padding-top: 15px; font-size: 25px; font-weight: 500;'> 二维码  </div>
		  <div  style="margin-top:30px; margin-left:25px; width: 150px; height: 150px; border: 2px solid #e7e6eb; background-color: #adadaf;">
	  		<img src='' style="margin-top:0px; margin-left:0px; width: 150px; height: 150px; border: 2px solid #e7e6eb;" id="img"></img>
	   	  	<!-- <img src='' style="margin-top:30px; margin-left:25px; width: 150px; height: 150px; border: 2px solid #e7e6eb;" id="img"></img> -->
	   	    <button type="button" class="button2" style="top: 300px;left: 30px;" id="download">下载</button>
	  	 </div>
	   </div> 
	    <div class="container">
		    <div id="editor" value="^" style="padding-top: 0px; margin-top: 0px;" >
<!-- 			   <input type="text" name="filename" id="123asd" style="border:none;height:50px;width:600px;border-bottom:0px solid #DCDCDC;text-align:center; font-size:18px; "  placeholder="请输入文章标题" max-length="5"/>
			   <input type="text" id="dsa321" style="border:none;height:30px;width:600px;border-bottom:1px solid #DCDCDC;text-align:right;" placeholder="请输入作者"/> -->
		   </div>
		 </div>
  </div>
  
  <div class="low" style="width: 100%; height: 80px; background-color: #ffffff;">
	<input type="hidden" id="uop" value=""/>
  	<button type="button" class="button2" style="top: 30px;left: 700px;"  onclick="getContent()">保存</button>
  	<button type="button" class="button2" style="top: 30px;color:#000000; left: 800px;background-color: #dcdcdc;" onclick="back()">返回</button>
  </div>
  
  <!-- <div class="container">
    <div id="editor" value="^" style="padding-top: 0px; margin-top: 0px;" >
       <input type="text" value="Javaweb" name="filename" style="border: none;width: 100%;height: 35px" placeholder="请在此输入文章标题#"/>
    </div>
 </div> -->
 	<!-- <script type="text/javascript">
 		$(function(){
 			$("#btn_submit").click(function(){
 				 var obj = document.getElementById("inputfile").files[0];
 				 var formFile = new FormData();
	             formFile.append("action", "/upload.do");  
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
 	</script> -->
 	<!-- <div class="right" >
			<div class="form-group">
				<label for="inputfile">文件输入</label>
				<input type="file" id="inputfile">
				
			</div>
			<button type="submit" id="btn_submit" class="btn btn-default">提交</button>
	</div> -->
    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="js/wangEditor.min.js"></script>
    <script type="text/javascript">  
	  var E = window.wangEditor;
      var editor = new E('#editor');
      editor.customConfig.uploadImgShowBase64 = true;
     // editor.customConfig.uploadImgServer = '/upload' 
      editor.create() ;
      
      function downloadpicture(){	
		}
      
      function  getContent(){
      	
      	var text = editor.txt.html();
      	var oldstr = document.body.innerHTML;
      	//alert(oldstr);
      	//alert(text);
      	$(function(){
      		var uuidname = $("#uop").attr("value");		//保存uuid文件名
      		console.log("uuidname-1:"+uuidname);
      		var urlstr;	
      		var ht = "<html><head><title>页面</title><meta charset='UTF-8'></head><body>"+text+"</body></html>";
      		/* $("[name=filedata]").attr("value",ht); */
      		/* var filename = $("[name=filename]").val(); */
      		var url= location.search;
		  	var filename = url.substring(url.lastIndexOf("=")+1);
      		//alert(ht+"------"+filename);
      		if(uuidname==null||uuidname.length==0){
      			$.ajax({
	      			type:"post",
	      			url:"addplant.do",
	      			data:"filename="+filename+"&filedata="+encodeURIComponent(encodeURIComponent(text)),
	      			success:function(result){
	      				uuidname=$.parseJSON(result);
	      				console.log("success:"+uuidname);
	      				urlstr = "download.do?filename="+uuidname+".png";
	      				$("#uop").attr("value",uuidname+".html");
			      		console.log($("#uop").attr("value"));
			      		console.log("urlstr:"+urlstr);
	      				alert("保存成功");
	      				console.log("mous:"+uuidname);
						$("#img").attr('src',encodeURI('createQRCode.do?uuidname='+uuidname));
	      			}
	      		});
      		}else{
      			
      			$.ajax({
	      			type:"post",
	      			url:"addplant1.do",
	      			data:"uuidname="+uuidname+"&filedata="+encodeURIComponent(encodeURIComponent(text)),
	      			success:function(result){
	      				alert("保存成功！");      		
	      			}
	      		});
      		    
      			/* $.ajax({
	      			type:"post",
	      			url:"alters.do",
	      			data:"uuidname="+uuidname,
	      			success:function(result){
	      				alert("修改成功");
	      			}
	      		}); */
      		}
			/* $("#download").mouseover(function(){
			    if(uuidname!=null){
			    	console.log("mous:"+uuidname);
					$("#img").attr('src','createQRCode.do?uuidname='+uuidname);
				}
				console.log("img12323345");
			}); */
			
			$("#download").click(function(){
				//alert("uuidname:"+uuidname);
				if(uuidname!=null){
					console.log("downuuidname:"+uuidname);
					//alert("0:"+uuidname);
					window.location.href=encodeURI("download.do?filename="+uuidname+".png","UTF-8");
				}
				else{
					alert("uda:"+uuidname);
				    window.location.href=encodeURI(urlstr,"UTF-8");  
				}
			});
      	});
      }
      
      function back(){
      		window.location.href="selectAllFiles.do";
      }
    </script>
</body>
</html>