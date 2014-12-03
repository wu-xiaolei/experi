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
    
    <title>My JSP 'setInformation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/teacher.css">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/manager.css">
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="js/teacher.js"></script>
  </head>
  
  <body>
   <div id="main"> 
  		<div id="head"> 查询签到 <br></div>
  	
  	<div id="left"></div>
    <div id="right">
    
               <div id="daohang">
               		  <s:url action="skip_setInformation" var="setInformation"/>
                      <a href="${setInformation}" >信息设置</a>  
                      <s:url action="skip_controlExperiment" var="controlExperiment"/>
                      <a href="${controlExperiment}" >实验监控</a>  
                   	  <s:url action="skip_labReport" var="labReport"/>
                      <a href="${labReport}" >实验报告</a>
                      
                      <s:url action="skip_querySignin" var="querySignin"/>
                      <a href="${querySignin}" >签到查询</a>      
               </div>
			   <div id="user" style="overflow: auto;">
			   	当前用户：
               	<s:property value="#session.user.username"/>
             	&nbsp;
             	<s:url action="user_exit" var="exit"/>
             	<a href="${exit}" onclick="return exit();">退出登录</a>
               </div> 
               
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
</html>
