var flag = false;
function exit(){
	 return  window.confirm("确定退出吗？");
}
function addInfo(){
	var informationtitle=$('#informationtitle').val();
	var information=$('#informations').val();
	if(informationtitle!=null&&information!=""){	
			$.ajax({
				'url':  'manage_addInfo',
				'type': 'post',
				'data': {'informationtitle':informationtitle,'information':information},
				'dataType':'text',
				'success':
					function(data,statusText){
					alert(data);
					window.location.reload();
				}
			});			
			

	}else{
		alert("内容不能为空！");
	}
}
function showc(){
			$("#updateNotice,#addNotice").hide();
			$("#showAll").show();		
}
/*账户管理中的显示所有管理员*/
function showUser(){
	$("#updateUsers,#addUser,#changPWD").hide();
	$("#showAllUser").show();		
}
/*账户管理中的显示添加管理员*/
function showAddUser(){
	$("#updateUsers,#showAllUser,#changPWD").hide();
	$("#addUser").show();		
}
/*账户管理中的显示修改管理员*/
function showUpdateUser(){
	$("#showAllUser,#addUser,#changPWD").hide();
	$("#updateUsers").show();		
}
/*账户管理中的显示修改密码*/
function showUpdatePWD(){
	$("#updateUsers,#addUser,#showAllUser").hide();
	$("#changPWD").show();		
}
function showu(){
	$("#showAll,#addNotice").hide();
	$("#updateNotice").show();
	
}
function showa(){
	$("#showAll,#updateNotice").hide();
	$("#addNotice").show();
	
}
//修改公告信息
function update(test){
	var title = $("#infotitle"+test).val();
	var infor = $("#info"+test).val();
	
	$.ajax({
		'url':  'manage_updateInfo',
		'type': 'post',
		'data': {'informationid':test,'informationtitle':title,'information':infor},
		'dataType':'text',
		'success':
			function(data,statusText){
			alert(data);
			window.location.reload();
		}
	});	
}
//账户管理中修改用户
function updateUser(userid){
	var username = $("#uname"+userid).val();
	var password = $("#upassword"+userid).val();
	
	$.ajax({
		'url':  'account_updateUser',
		'type': 'post',
		'data': {'userid':userid,'username':username,'oldpassword':password},
		'dataType':'text',
		'success':
			function(data,statusText){
			alert(data);
			window.location.reload();
		}
	});	
}
/*账户管理中的添加用户验证用户名是否重名*/
function checkUserno(){
	var userno = $("#userno").val();
	if(userno!=null&&userno!=""){
		if(!isNaN(userno)){
			$.ajax({
				'url':  'account_checkUsername',
				'type': 'post',
				'data': {'userno':userno},
				'dataType':'text',
				'success':
					function(data,statusText){			
						$("#tsmsg").text(data);
					if(data=="\"账号可以使用\""){
						$("#tsmsg").css({color:"#FFFFFF"});
						//调用添加方法
						//addUser();
						flag=true;
						
					}else{
						flag=false;
						$("#tsmsg").css({color:"red"});
					}
				}
			
			});	
		}else{
			alert("账号为数字！");
		}
	}else{
		alert("账号不能为空！");
	}
}
//账号管理中添加管理员
function addUser(){
	var userno = $("#userno").val();
	var username = $("#username").val();
	var userpassword1 = $("#userpassword1").val();
	var userpassword2 = $("#userpassword2").val();
	if(flag){
	if(username!=""){
		if(userpassword1!=""){
			if(userpassword2!=""){
				if(userpassword1==userpassword2){
					$.ajax({
						'url':  'account_addUser',
						'type': 'post',
						'data': {'userno':userno,'username':username,'oldpassword':userpassword1},
						'dataType':'text',
						'success':
							function(data,statusText){	
								alert(data);		
								window.location.reload();
						}
					});				
				}else{
					alert("两次密码输入不相同，请重新输入！");
				}
			}else{
				alert("密码框不能为空");
			}
		}else{
			alert("密码框不能为空");
		}
	}else{
		alert("用户名不能为空");
	}
	}
}
//教师管理中的添加教师
function addTeacher(){
	var userno = $("#userno").val();
	var username = $("#username").val();
	var userpassword1 = $("#userpassword1").val();
	var userpassword2 = $("#userpassword2").val();
	if(flag){
	if(username!=""){
		if(userpassword1!=""){
			if(userpassword2!=""){
				if(userpassword1==userpassword2){
					$.ajax({
						'url':  'account_addTeacher',
						'type': 'post',
						'data': {'userno':userno,'username':username,'oldpassword':userpassword1},
						'dataType':'text',
						'success':
							function(data,statusText){	
								alert(data);		
								window.location.reload();
						}
					});				
				}else{
					alert("两次密码输入不相同，请重新输入！");
				}
			}else{
				alert("密码框不能为空");
			}
		}else{
			alert("密码框不能为空");
		}
	}else{
		alert("用户名不能为空");
	}
	}
}


//账号管理中的修改密码
function amChangePassword(userid){
	var oldpassword = $("#oldpassword").val();
	var newpassword1 = $("#newpassword1").val();
	var newpassword2 = $("#newpassword2").val();
	var id = userid;
	if(oldpassword==""||newpassword1==""||newpassword2==""){
		alert("密码框不能为空！");
	}else{
		if(newpassword1==newpassword2){
			$.ajax({
				'url':'account_changePassword',
				'type':'post',
				'data':{'userno':userid,'oldpassword':oldpassword,'newpassword1':newpassword1},
				'dataType':'text',
				'success':
					function(data,statusText){				
					alert(data);
					$("#oldpassword").val("");
					$("#newpassword1").val("");
					$("#newpassword2").val("");
					
				}
				
			});
		}else{
			alert("两次密码输入不相同！");
		}
		
	}
}
/*
 * 管理学生
 * */

//修改学生信息
function updateStudent(userid){
	var username = $("#uname"+userid).val();
	var password = $("#upassword"+userid).val();
	var userclass =  $("#userclass"+userid).val();
	$.ajax({
		'url':  'account_updateStudent',
		'type': 'post',
		'data': {'userid':userid,'username':username,'oldpassword':password,'class_':userclass},
		'dataType':'text',
		'success':
			function(data,statusText){
			alert(data);
			window.location.reload();
		}
	});	
}
//添加学生信息
function addStudent(){	
	var userno = $("#userno").val();
	var username = $("#username").val();
	var userpassword1 = $("#userpassword1").val();
	var userpassword2 = $("#userpassword2").val();
	var userclass =  $("#userclass").val();
	if(flag){
	if(username!=""){
		if(userpassword1!=""){
			if(userpassword2!=""){
				if(userpassword1==userpassword2){
					if(userclass!=""){
						$.ajax({
							'url':  'account_addStudent',
							'type': 'post',
							'data': {'userno':userno,'username':username,'oldpassword':userpassword1,'class_':userclass},
							'dataType':'text',
							'success':
								function(data,statusText){	
									alert(data);		
									window.location.reload();
							}
						});			
					}else{
						alert("班级不能为空！");
					}
				}else{
					alert("两次密码输入不相同，请重新输入！");
				}
			}else{
				alert("密码框不能为空");
			}
		}else{
			alert("密码框不能为空");
		}
	}else{
		alert("用户名不能为空");
	}
	}
}
