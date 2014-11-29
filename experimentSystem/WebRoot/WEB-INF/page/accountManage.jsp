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
  			<li  style="cursor:hand;cursor:pointer" onclick="showUser();">查看管理员信息</li>
  			<li  style="cursor:hand;cursor:pointer" onclick="showUpdateUser();">修改管理员信息</li>
  			<li style="cursor:hand;cursor:pointer" onclick="showAddUser();">添加管理员信息</li>
  			<li  style="cursor:hand;cursor:pointer" onclick="showUpdatePWD();">修改用户密码</li>
  			
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
                      <a href="${studentManage}" >学生管理</a>
                      <s:url action="skip_teacherManage" var="teacherManage"/>
                      <a href="${teacherManage}" >教师管理</a>
                      <s:url action="skip_accountManage" var="accountManage"/>
                      <a href="${accountManage}" id="checked">账号管理</a>         
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
               				<td width="300">账号</td>
               				<td  width="200">姓名</td>
               				<td width="145">密码</td>
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
	               				
	               				<s:url action="account_delUser" var="del"/>
                      			<a href="${del}?userid=${i.userid}" onclick="return confirm('确认删除?')">删除</a>  
	               				
	               			</td>
	               		  </tr>
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="updateUsers" class="content">
               		<table align="left" border="1" width="680">
               			<tr>
               				<td width="300">账号</td>
               				<td  width="200">姓名</td>
               				<td width="145">密码</td>
               				<td width="45">操作</td>
               			</tr>
	               		<s:iterator value="listUser" var="i">
	               		
	               		  <tr>
	               			<td>
	               				${i.userno}	               				
	               			</td>
	               			<td>
	               				
	              				<textarea rows="1" cols="23" id="uname${i.userid}">${i.username}</textarea>
	               			</td>
	               			<td>
	               				
	              				<textarea rows="1" cols="23" id="upassword${i.userid}">${i.password}</textarea>
	               			</td>
	               			<td>	               		
	               				
	               				   			
                      			 <a onclick="updateUser(${i.userid})" style="cursor:hand;cursor:pointer">修改</a>		
                      			
	               			</td>
	               		  </tr>
	               		
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="addUser" class="content">
               		账号：<input type="text" id="userno" onblur="checkUserno();"/><span id="tsmsg"></span><br/>
               		用户名：<input type="text" id="username"/><br/>
               		密码：<input type="password" id="userpassword1"/><br/>
               		确认密码：<input type="password" id="userpassword2"/><br/>
               		<input type="button"  value="添加管理员" id="btnAdd" onclick="addUser();"/>
               </div>
              <div id="changPWD" class="content">
               原密码：<input type="password" id="oldpassword"/> <br/>	
                新密码：<input type="password" id="newpassword1"/> <br/>	
                 新密码：<input type="password" id="newpassword2"/> <br/>	
                 <input type="button" value="修改密码" onclick="amChangePassword(${session.user.userid});"/>
    		</div>
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
</html>
