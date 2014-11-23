function check(){
	var userno=$('#userno').val();
	if(userno!=null&&userno!=""){
		if(!isNaN(userno)){
			$.ajax({
				'url':  'user_ajax',
				'type': 'post',
				'data': {'userno':userno},
				'dataType':'text',
				'success':
					function(data,statusText){
					alert(data);
				}
			});
		}else{
			alert("学号为数字！");
		}
	}else{
		alert("学号不能为空！");
	}
}