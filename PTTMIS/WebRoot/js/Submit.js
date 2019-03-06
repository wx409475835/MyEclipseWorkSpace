function Checksubmit(){
	var inps = $("input");
	for(var i=0;i<$(inps).length;i++){
		console.log("inps:"+inps[i]);
		if($(inps[i]).val()==null||$(inps[i]).val()==""){
			alert("提示:请将全部信息输入完毕后，重新提交！");
			return false;
		}
	}
	return true;
}