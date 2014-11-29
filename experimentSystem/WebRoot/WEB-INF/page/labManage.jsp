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
  </head>
  
  <body>
  	<div id="main"> 
  		<div id="head"> 管理员登录成功 <br></div>
  	
  	<div id="left"></div>
    <div id="right">
    
               <div id="daohang">
               		  <s:url action="skip_relreaseInfo" var="relreaseInfo"/>
                      <a href="${relreaseInfo}" >信息发布</a> 
                      <s:url action="skip_labManager" var="labManger"/>
                      <a href="${labManger}" id="checked">实验室管理</a>  
                   	  <s:url action="skip_experimentManger" var="experimentManger"/>
                      <a href="${experimentManger}" >实验管理</a>
                      <s:url action="skip_studentManage" var="studentManage"/>
                      <a href="${studentManage}" >学生管理</a>
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
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
</html>
