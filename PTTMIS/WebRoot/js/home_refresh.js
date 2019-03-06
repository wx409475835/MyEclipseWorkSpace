$(function(){
	$("#div1").click(function(){
		window.parent.location.href="AdministratorMain.do";
	});
	
	$("#div4").click(function(){
		window.location.reload();
	});
	
	$("#div2").click(function(){
		/*window.parent.location.href="AdministratorMain.do";*/
		window.history.go(-1);  
	});
});