<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/manager.css">
	<script type="text/javascript" src="js/manager.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#updateUsers,#addUser,#changPWD").hide();
		});
	</script>
  </head>
  
  <body>
  	<div id="main"> 
  		<div id="head"> 管理员登录成功 <br></div>
  	
  	<div id="left">
  		<ul>
  			<li  style="cursor:hand;cursor:pointer" onclick="showUser();">查看学生信息</li>
  			<li  style="cursor:hand;cursor:pointer" onclick="showUpdateUser();">修改学生信息</li>
  			<li style="cursor:hand;cursor:pointer" onclick="showAddUser();">添加学生信息</li>
  			
  		</ul>
  	</div>
    <div id="right">
    
               <div id="daohang">
               		  <s:url action="skip_relreaseInfo" var="relreaseInfo"/>
                      <a href="${relreaseInfo}" >信息发布</a> 
                      <s:url action="skip_labManager" var="labManger"/>
                      <a href="${labManger}" >实验室管理</a>  
                   	  <s:url action="skip_experimentManger" var="experimentManger"/>
                      <a href="${experimentManger}" >实验管理</a>
                      <s:url action="skip_studentManage" var="studentManage"/>
                      <a href="${studentManage}" id="checked">学生管理</a>
                      <s:url action="skip_teacherManage" var="teacherManage"/>
                      <a href="${teacherManage}" >教师管理</a>
                      <s:url action="skip_accountManage" var="accountManage"/>
                      <a href="${accountManage}" >账号管理</a>         
               </div>
			   <div id="user">
			   	当前用户：
               	<s:property value="#session.user.username"/>
             	&nbsp;&nbsp;
             	<s:url action="user_exit" var="exit"/>
             	<a href="${exit}" onclick="return exit();">退出登录</a>
               </div>   	
               
                <div id="showAllUser" class="content">
               		<table align="left" border="1" width="690">
               			<tr>
               				<td width="150">账号</td>
               				<td  width="150">姓名</td>
               				<td width="145">密码</td>
               				<td width="200">班级</td>
               				<td width="45">操作</td>
               				
               			</tr>
	               		<s:iterator value="listUser" var="i">
	               		  <tr>
	               			<td>
	               				${i.userno}
	               			</td>
	               			<td>
	               				${i.username}
	               			</td>
	               			<td>
	               				${i.password}
	               			</td>
	               			<td>
	               				${i.class_}
	               			</td>	               			
	               			<td>
	               				
	               				<s:url action="account_delStudent" var="del"/>
                      			<a href="${del}?userid=${i.userid}" onclick="return confirm('确认删除?')">删除</a>  
	               				
	               			</td>
	               		  </tr>
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="updateUsers" class="content">
               		<table align="left" border="1" width="680">
               			<tr>
               				<td width="150">账号</td>
               				<td  width="150">姓名</td>
               				<td width="145">密码</td>
               				<td width="200">班级</td>
               				<td width="45">操作</td>
               			</tr>
	               		<s:iterator value="listUser" var="i">
	               		
	               		  <tr>
	               			<td>
	               				${i.userno}	               				
	               			</td>
	               			<td>
	               				
	              				<textarea rows="1" cols="15" id="uname${i.userid}">${i.username}</textarea>
	               			</td>
	               			<td>
	               				
	              				<textarea rows="1" cols="15" id="upassword${i.userid}">${i.password}</textarea>
	               			</td>
	               			<td>
	               				
	              				<textarea rows="1" cols="22" id="userclass${i.userid}">${i.class_}</textarea>
	               			</td>
	               			<td>	               		
	               				
	               				   			
                      			 <a onclick="updateStudent(${i.userid})" style="cursor:hand;cursor:pointer">修改</a>		
                      			
	               			</td>
	               		  </tr>
	               		
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="addUser" class="content">
               		账号：<input type="text" id="userno" onblur="checkUserno();"/><span id="tsmsg"></span><br/>
               		用户名：<input type="text" id="username"/><br/>
               		班级：<input type="text" id="userclass"/><br/>
               		密码：<input type="password" id="userpassword1"/><br/>
               		确认密码：<input type="password" id="userpassword2"/><br/>
               		<input type="button"  value="添加学生" id="btnAdd" onclick="addStudent();"/>
               </div>
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
</html>
