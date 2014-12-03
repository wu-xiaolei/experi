
function getAllSigninStudent(){
		var class_ = $("#s_class").val(); 
		var date =$("#datepicker").val();
		var s_jie =$("#s_jie").val();
		var t_div =$("#signinstu");//控制表格显示的div
		var t_show = document.getElementById("t_show");//表格
		//alert(test1+"日期"+test2+" "+test3);
		$('table tbody').empty();
		var tr = t_show.insertRow();
		var td = tr.insertCell();
		td.innerHTML="学号";
		td.width ="150px";
		var td = tr.insertCell();
		td.innerHTML="姓名";
		td.width ="150px";
		var td = tr.insertCell();
		td.innerHTML="班级";
		td.width ="150px";
		var td = tr.insertCell();
		td.innerHTML="时间";
		td.width ="150px";
		$.ajax({
				'url':'teacher_queryAllSignin',
				'type': 'post',
				'data': {'class_':class_,'date':date,'s_jie':s_jie},
				'dataType':'json',
				'success':
					function(data,statusText){
						
					
					
				 	$.each(data, function (i, item) {  
		         		//alert(item.TSignins);
		         		var tr = t_show.insertRow();
		         		var td = tr.insertCell();
		         		td.innerHTML=item.userno;
		         		var td = tr.insertCell();
		         		td.innerHTML=item.username;
		         		var td = tr.insertCell();
		         		td.innerHTML=item.class_;
		         		var td = tr.insertCell();
		         		
		         		td.innerHTML=item.TSignins[i].indate.replace("T","  ");
					
		        });  
		        //ad();
		     	t_div.show();
				}
			});		
}
function checkboxClass(){

	$.ajax({
				'url':'teacher_getAllClass',
				'type': 'post',
				//'data': {'informationtitle':informationtitle},
				'dataType':'json',
				'success':
					function(data,statusText){
					var dataObj=eval("("+data+")"); 
				 	$.each(dataObj, function (i, item) {  
		         	//动态添加下拉列表  
		         	if(item!=null){       
		         	
		         		var checkboxlist = "<input type='checkbox' name='allclass' value="+item+">"+item;
		         		$("#addCheckbox").append(checkboxlist);
		         	}
		         		       		
		        });  
				}
			});	
}
function realeseExp(){
	
	var allClass="";
	var experimentName = $("#experientname").val();
	 $('input[name="allclass"]:checked').each(function(){    
		allClass+=$(this).val()+",";
		
	});
	//alert(allClass);
	$.ajax({
				'url':'teacher_realeseExp',
				'type': 'post',
				'data': {'class_':allClass,'experimentName':experimentName},
				'dataType':'json',
				'success':
					function(data,statusText){
						alert(data+statusText);
					}
	});
	
}
function showRelease(){
	$("#checkExperi").hide();
	$("#releaseExperi").show();
}
function showCheck(){
	$("#releaseExperi").hide();
	$("#checkExperi").show();
}

