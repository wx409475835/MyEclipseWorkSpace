$(function() {
	$("#date").click(function() {
		WdatePicker( // 主要就是以Json 来展示数据的
		{
			dateFmt : "yyyy-MM-dd",
			readOnly : true,
			isShowWeek : true
		});
	});
	
	$("#tath-date").click(function() {
		WdatePicker( // 主要就是以Json 来展示数据的
		{
			dateFmt : "yyyy-MM-dd HH:mm:ss",
			readOnly : true,
			isShowWeek : true
		});
	});

	// 发送Ajax 请求获得医生编号ID
	$.ajax({
		type : "post",
		url : "SelectAllHd_idsAction.do",
		success : function(result) {
			console.log("SelectAllHd_idsAction:" + result);
			var sel = $("#hp_doctorid").prop("value");
			var hp_ids = $.parseJSON(result); // json转化成js对象
			for ( var i = 0; i < $(hp_ids).length; i++) {
				var op = $("<option value=" + $(hp_ids)[i] + ">" + $(hp_ids)[i]
						+ "</option>");
				if ($(hp_ids)[i] == sel) {
					$(op).prop("selected", true);
				}
				$("#up-sel-doctodid").append(op);
			}
		}
	});

	var ops = $("#up-sel-marry option");
	var up_inp_marry = $("#up-inp-marry").val();
	for ( var i = 0; i < $(ops).length; i++) {
		if ($(ops)[i].value == up_inp_marry) {
			$(ops[i]).prop("selected", true);
		}
	}

	var options = $("[name='hp_stat'] option");
	var up_inp_stat = $("#up-inp-stat").val();
	for ( var i = 0; i < $(options).length; i++) {
		if ($(options)[i].value == up_inp_stat) {
			$(options[i]).prop("selected", true);
		}
	}
});
