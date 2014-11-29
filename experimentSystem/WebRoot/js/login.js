
  function requ(){
			//$(document).ready(function(){
	  		
	  $.ajax({
			'url':'manage_getInfo',
			'type':'get',		
			'dataType':'json',
			'success':
				function(data,statusText){
				var dataObj=eval("("+data+")"); 
				 $.each(dataObj, function (i, item) {  
		         //alert(item.informationtitle + ","  + item.informationid);  
		       		var content="<br/>"+"<a href=manage_toNotice?informationid="+item.informationid+" target=_blank>"+item.informationtitle+"</a>";
		       		$("#title").append(content);
		        });  
			}
		});	
			
		//});
		}
 



function checkUser(){
	var userid = $('#userno').val();
	var password = $('#password').val();
	
	if(userid==null||userid==""){
		alert("账号不能为空");
		return false;
	}else{
		if(password==null||password==""){
			alert("密码不能为空");
			return false;			
		}else if(isNaN(userid)){
			
			
				alert("账号为数字");
				userid="";
				return false;
			
		}
	}
	
}
	
	
