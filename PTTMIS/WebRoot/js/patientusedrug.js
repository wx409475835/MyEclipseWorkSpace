function DeletePatientUseDrug(){
	var hemr_patientid = $("[name='hemr_patientid']").prop("value");
	console.log("hemr_patientid:"+hemr_patientid);
	//病人用药信息列表   删除信息触发事件
	var boolea;
	var bol=true;
	$.ajax({
	type:"post",
	url:"SelectHTreateRecordByHtr_patientidAction1.do",
	data:"htr_patientid="+hemr_patientid,
	async: false,
	success:function(result){
		boolea=result;
		console.log("result:"+result);
		if(result==2){
			alert("该病人已经结算,不能删除用药信息！");
			bol = false;
		}
	}
   });
	return bol;
}


$(function(){
			var hemr_patientid;
			$("#pud-btn-sel").click(function(){
				hemr_patientid = $("[name='hemr_patientid']").val();
				if(hemr_patientid==null||hemr_patientid==''){
					alert("请输入需要查询的病人ID!");
				}else{
					//发送Ajax请求获得  病历信息
					$.ajax({
						type:"post",
						url:"SelectHemrByHemr_patientidAction.do",
						data:"hemr_patientid="+hemr_patientid,
						success:function(result){
							var emr = $.parseJSON(result);
							$("[name='hemr_id']").prop("value",emr.hemr_id);
							$("[name='hemr_patientid']").prop("value",emr.hemr_patientid);
							$("[name='hemr_doctorid']").prop("value",emr.hemr_doctorid);
							$("[name='hemr_starttime']").prop("value",emr.hemr_starttime);
							$("[name='hemr_endtime']").prop("value",emr.hemr_endtime);
							$("[name='hemr_treatisend']").prop("value",emr.hemr_treatisend);
							$("[name='hemr_diagnosis']").prop("value",emr.hemr_diagnosis);
							$("[name='hemr_symptom']").prop("value",emr.hemr_symptom);
							$("[name='hemr_method']").prop("value",emr.hemr_method);
						}
					});
					
					var hdrug_count = 0;
					var patientusedrugs;
					
					//获取数量 
					$.ajax({
						type:"post",
						url:"SelectDrugCountAction.do",
						data:"hemr_patientid="+hemr_patientid,
						success:function(result){
							 patientusedrugs = $.parseJSON(result);		//拿到后台的js字符串
							 console.log(patientusedrugs);
						}
					});
					
					//添加完毕 病历信息后 开始展示病人的用药信息
					$.ajax({
						type:"post",
						url:"SelectPatientUseDrugByHpt_patientidAction.do",
						data:"hemr_patientid="+hemr_patientid,
						success:function(result){
							//清空 tbody内容
							$("#pud-tb1").empty();
							 drugs = $.parseJSON(result);		//拿到后台的js字符串
							 console.log(drugs);
							 console.log($(drugs).length);
							for(var i=0;i<$(drugs).length;i++){
									if(drugs[i].hdrug_id == patientusedrugs[i].hpt_drugid){
										//添加到 tbody中
										var id = $("<td>"+drugs[i].hdrug_id+"</td>");
										var name = $("<td>"+drugs[i].hdrug_name+"</td>");
									    var price = $("<td>"+drugs[i].hdrug_price+"</td>");
									    var birthday = $("<td>"+drugs[i].hdrug_birthday+"</td>");
										var type = $("<td>"+drugs[i].hdrug_type+"</td>");
										var introduce = $("<td>"+drugs[i].hdrug_introduce+"</td>");
										var count = $("<td>"+patientusedrugs[i].hpt_count+"</td>");
										var a = $("<td><button class='table-btn2'><input type='hidden' value='"+drugs[i].hdrug_id+"'/><a onclick='return DeletePatientUseDrug()' href=DeletePatientUseDrugAction.do?hpt_id="+drugs[i].hdrug_id+"&hpt_patientid="+hemr_patientid+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
										if(i%2==0){
											var tr = $("<tr class='odd'></tr>");
										}else{
											var tr = $("<tr class='even'></tr>");
										}
										tr.append(id);
										tr.append(name);
										tr.append(price);
									    tr.append(birthday);
										tr.append(type);
										tr.append(count);
										tr.append(introduce);
										tr.append(a);
										$("#pud-tb1").append(tr);
									}
								}
							}
					});
				}
			});
			
			//获取药品名称
			$("#pud-btn-sel-drug").click(function(){
				var hdrug_name = $("[name='hdrug_name']").val();
				var hemr_patientid = $("[name='hemr_patientid']").val();
				console.log("hdrug:"+hdrug_name);
				if(hemr_patientid==null||hemr_patientid==''){
					alert("请在第一个输入框,输入需要查询的病人ID!");
				}else{
					if(hdrug_name==null||hdrug_name==''){
						alert("请输入需要查询的药品名称");
					}else{
						//发送Ajax请求
						$.ajax({
							type:"post",
							url:"SelectHDrugByNameAction.do",
							data:"hdrug_name="+hdrug_name,
							success:function(result){
								$("#pud-tb2").empty();
								var drug = $.parseJSON(result);
								for(var i=0;i<$(drug).length;i++){
									var id = $("<td>"+drug[i].hdrug_id+"</td>");
									var name = $("<td>"+drug[i].hdrug_name+"</td>");
									var price = $("<td>"+drug[i].hdrug_price+"</td>");
									var birthday = $("<td>"+drug[i].hdrug_birthday+"</td>");
									var type = $("<td>"+drug[i].hdrug_type+"</td>");
									var introduce = $("<td>"+drug[i].hdrug_introduce+"</td>");
									var a = $("<td><input type='hidden' value='"+drug[i].hdrug_id+"'/><button class='table-btn1'><a href='javascript:void(0)'><img src='images/add.png' alt='更新'/>添加</a></button></td>");
									var tr = $("<tr></tr>");
									tr.append(id);
									tr.append(name);
									tr.append(price);
									tr.append(birthday);
									tr.append(type);
									tr.append(introduce);
									tr.append(a);
									$("#pud-tb2").append(tr);
								}
								
								//将点击添加的信息   添加到用于用药那一栏
								$("#pud-tb2 button").click(function(){
									var boolea;
									$.ajax({
										type:"post",
										url:"SelectHTreateRecordByHtr_patientidAction1.do",
										data:"htr_patientid="+hemr_patientid,
										async: false,
										success:function(result){
											boolea=result;
											console.log("result:"+result);
											if(result==2){
												alert("该病人已经结算,不能添加用药信息！");
											}
										}
									});
									console.log("result:"+result);
									if(boolea!=2){
										var hdrug_id = $(this).prev().val();
										console.log("hemr_patientid:"+hemr_patientid);
										//发送Ajax请求将 病人ID 和  药品信息插入数据库 返回插入信息
										$.ajax({
											type:"get",
											url:"SelectPatientUseDrugAction.do?hemr_patientid="+hemr_patientid+"&hdrug_id="+hdrug_id,
											success:function(result){
												alert("添加成功!");
												/* //首先清空 tbody 中的内容
												$("#pud-tb1").empty();
												console.log(result);
												var drugs = $.parseJSON(result);
												console.log($(drugs).length);
												for(var i=0;i<$(drugs).length;i++){
													//添加到 tbody中
													var id = $("<td>"+drugs[i].hdrug_id+"</td>");
													var name = $("<td>"+drugs[i].hdrug_name+"</td>");
													var price = $("<td>"+drugs[i].hdrug_price+"</td>");
													var birthday = $("<td>"+drugs[i].hdrug_birthday+"</td>");
													var type = $("<td>"+drugs[i].hdrug_type+"</td>");
													var introduce = $("<td>"+drugs[i].hdrug_introduce+"</td>");
													var count = $("<td>1</td>");
													var a = $("<td><button class='table-btn2'><a href=DeletePatientUseDrugAction.do?hpt_id="+drugs[i].hdrug_id+"><img src='images/DeleteLogo.png' alt='删除'/>删除</a></button></td>");
													var tr = $("<tr></tr>");
													tr.append(id);
													tr.append(name);
													tr.append(price);
													tr.append(birthday);
													tr.append(type);
													tr.append(count);
													tr.append(introduce);
													tr.append(a);
													$("#pud-tb1").append(tr); */
												//}
											}
										});
									}
									
								});
							}
						});
					}
				}
			});
		}); 