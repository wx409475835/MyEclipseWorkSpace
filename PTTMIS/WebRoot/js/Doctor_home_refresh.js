$(function(){
	$("#div5").click(function(){
		window.parent.location.href="doctor/DoctorMain.do";
	});
	
	$("#div8").click(function(){
		window.location.reload();
	});
	
	$("#div6").click(function(){
		/*window.parent.location.href="doctor/DoctorMain.do";*/
		window.history.go(-1);  
	});
});

window.onbeforeunload = closePageForm;  
window.close = closePageForm;  

function closePageForm(){
	window.opener = null;
	window.open('', '_self');
	window.close();
}
