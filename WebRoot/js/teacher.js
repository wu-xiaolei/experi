function getAllSigninStudent(){
		var class_ = $("#s_class").val(); 
		var date =$("#datepicker").val();
		var s_jie =$("#s_jie").val();
		//alert(test1+"日期"+test2+" "+test3);
		$.ajax({
				'url':'teacher_queryAllSignin',
				'type': 'post',
				'data': {'class_':class_,'date':date,'s_jie':s_jie},
				'dataType':'json',
				'success':
					function(data,statusText){
					var dataObj=eval("("+data+")"); 
				 	$.each(dataObj, function (i, item) {  
		         		alert(item.userno);
		         	
					
		        });  
				}
			});		
}