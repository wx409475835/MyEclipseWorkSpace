<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
 
<head>
  <meta charset="utf-8">
  <title>文本编辑器</title>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
  <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
  <script type="text/javascript" src="js/ueditor_custom.js"></script>
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  		
		function downloadpicture(){
			window.location.href="download.do?filename=com.png";	
		}
		$(function(){
			var uuidname;		//保存uuid文件名
			$("#keep").click(function(){
				$.ajax({
					type:"post",
					url:"addplant.do?filename=index",
					//data:"hdrug_id="+hdrug_id,
					success:function(result){
						var aotos = $.parseJSON(result);
						uuidname=aotos;
						console.log(uuidname);
					}
				});
				alert(window.location.href);
				alert(uuidname);
				$.ajax({
					type:"post",
					url:"createQRCode.do",
					data:"uuidname="+uuidname+"&url=http://www.baidu.com",
					success:function(result){
						
					}
				});
				
			});
			
			$("#img").click(function(){
				$.ajax({
					method:"POST",
					url:"ShowImg.do",
					success:function(result){
						
					}
				});
			});
			
			$(function(){
				$("#img").mouseover(function(){
					$("#img").attr('src','createQRCode.do');
				});
			});
		});
		
		function fake_click(obj) {
	        var ev = document.createEvent("MouseEvents");
	        ev.initMouseEvent(
	            "click", true, false, window, 0, 0, 0, 0, 0
	            , false, false, false, false, 0, null
	        );
	        obj.dispatchEvent(ev);
	    }
 
	    function export_raw(name, data) {
	        var urlObject = window.URL || window.webkitURL || window;
	 
	        var export_blob = new Blob([data]);
	 
	        var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a")
	        save_link.href = urlObject.createObjectURL(export_blob);
	        save_link.download = name;
	        fake_click(save_link);
	    }
	    var test=document.getElementsByTagName('html')[0].outerHTML;
	    console.log(test);
	    $('#keep').click(function() {
	        export_raw("test.html", test);
	    });
		
	</script>
	
	<style type="text/css">
		.left{
	 margin-top:20px;
	 width:180px;
	 height:450px;
	 background-color:#F5F5F5;
	 margin-left:140px;
	 float: left;
	 
	}
	.right{
		margin-top:20px;
	  width:180px;
	  height:450px;
	  background-color:#F5F5F5;
	  margin-right:155px;
	  float: right;
		
	}
	
	.container{
	  width:700px;
	  margin:auto;
	  padding-top: 0px;
	  padding-left: 0px;
	}
	
	.button2{
	  
	   position: relative;
	  top: 120px;
	  left: 50px;
	  /*padding-left: 50px;*/
	  margin-bottom: 30px;
	  padding-bottom: 30px;
	  width: 80px;
	  height: 5px;
	  border: none;
	  background: green;
	  border-radius: 5px;
	  cursor: pointer;
	  color: white;
		
	}
	.low{
		width: 100%;
		height: 50px;
		margin-bottom: 0px;
	}
		
	</style>
		
</head>


<body>
  <div class="top" style="width: 100%; height: 60px;  padding-top:10px;padding-bottom:20px;background-color: #7BA7AB; color: white; font-size: 20px;">
 	<div style="padding-left: 60px; padding-top: 8px; float: left;">  南阳理工学院后勤管理系统</div>
 	<div  class="btn1" style="padding-right: 100px;float: right; padding-top: 8px;"> 
 		<div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >
      ${username }<span class="caret" ></span></button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">退出登陆</a></li>
      </ul>
    </div>
 	</div>
   </div>
   
   
   <div class='left'>
  <div style='font-size:20px; margin-left:50px;padding-top: 15px;'> 二维码  </div>
  <img src='images/椭圆1.png' style="margin-top:60px;margin-left:20px;"></img>
  <!--<div class="b1">--><button type="button" class="button2" >下载</button><!--</div>-->
  </div>
  
  <div class="right">
	<div style="width: 150px; height: 50px;padding-top:15px;padding-left: 30px;font-size: 15px;">多媒体</div>

	<div style="height: 40%; width: 80%; margin-left: 15px;">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td id="YES">

						<!--<div style="width: 20%;height: 80%; background-color: #000000;"><img src='search.png' style="margin-top:60px;margin-left:20px;"></img></div>-->
						图片</td>

				</tr>
				<tr>
					<td>视频</td>

				</tr>
				<tr>
					<td>音频</td>

				</tr>
			</tbody>
		</table>
	</div>
</div>

<button id="ok">asda</button>
<div class="low" >
  	
  	<button type="button" class="button2" style="top: 450px;left: 400px;">保存</button>
  	<button type="button" class="button2" style="top: 450px;left: 420px;background-color: #dcdcdc;" >预览</button>
  	<button type="button" class="button2" style="top: 450px;left: 440px;background-color: #dcdcdc;">取消</button>
</div>


   
   
 <div class="container">
 	
 
    <div id="editor" style="padding-top: 0px; margin-top: 0px;" >
       <p>文章标题:<b> <你想要输入的标题></b></p>
    </div>
 </div>
    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="js/wangEditor.min.js"></script>
    <script type="text/javascript">  
	  var E = window.wangEditor
      var editor = new E('#editor')
//    editor.customConfig.uploadImgShowBase64 = true
      editor.customConfig.uploadImgServer = '/upload' 
      editor.create() 
    </script>

  <script type="text/javascript">
    var editorId = "appmsg_editor";

    var editor = UE.getEditor("js_editor", {
      id: editorId,
      wordCount: false,
      elementPathEnabled: false
    });

    editor.addListener("catchremotesuccess", function() {
      tips.success("内容已上传完成");
    });
    editor.addListener("catchremoteerror", function() {
      tips.error("远程图片抓取失败");
    });
    editor.ready(function() {
      var toolbars = editor.ui.toolbars;
      $('#' + editor.ui.toolbars[0].id).addClass("edui-toolbar-primary");
      $('#' + editor.ui.toolbars[1].id).addClass("edui-toobar-secondary");
      $("#" + editorId + "_toolbarbox").addClass("show-edui-more");
      for (var i = 0; i < toolbars.length; i++) {
        var toolbar = toolbars[i];
        var items = toolbar.items;
        for (var j = 0; j < items.length; j++) {
          if (items[j] instanceof UE.ui.Combox || items[j] instanceof UE.ui.SplitButton) {
            $("#" + items[j].id + "_state").tooltip({
              container: 'body'
            });
          } else if (items[j] instanceof UE.ui.Button || items[j] instanceof UE.ui.MenuButton) {
            $("#" + items[j].id + "_body").tooltip({
              container: 'body'
            });
          }
        }
      }
    });

    $("#ok").click(function() {
      var data = editor.getContent();
      console.log(data);
      alert(data);
    });
  </script>
</body>

</html>
