<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri ="/struts-tags" prefix="s"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="js/signin.js"></script>
	<link rel="stylesheet" type="text/css" href="css/signin.css">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <body>
    	<div id="main">
    		<div id="head"></div>
    		<div id ="signin">
    			<div id="input">		
    					学号:<s:textfield name="userno" id="userno" size="18" cssStyle="border:hidden; size:18px; width:200px;height:30px"  onblur=""/>
    					<s:submit value="签到" cssStyle="font-size:20px;color:#f21ada;" theme="simple" onclick="check();"/>   				
    			 </div>
    		</div>
    	</div>
  </body>
</html>
