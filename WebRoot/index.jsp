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
    
    <title>实验室 管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" for="window" event="onload">
			requ();	
	</script>
  </head>
  
  <body>
    <div id="main">
    	<div id="head"></div>
    	<div id="left">
    	<div id="login">
    		<div align="center"> 
    			实验室管理系统 <br/><br/><br/>
    			<s:form action="user_login" method="post" theme="simple" onsubmit="return checkUser();">
    				账     号:<s:textfield label="账号" name="userno" id="userno"/><br/><br/>
    				密     码:<s:password label="密     码" name="password" id="password"/><br/>
    				<s:radio list="#{'1':'管理员','0':'教师','-1':'学生'}" name="grade" id="grade" value="1" cssStyle="align:center" /><br/>
    				<div id="prompt"><s:property value="prompt"/></div>
    				<s:submit value="登录" />
    				<s:reset value="重置"/>
    			</s:form>    		
    		</div>   	
    		<!-- 遍历session中的list集合 -->
    		<div id="gg">
    			<h3 id="title">公告信息</h3><br/>
    		<!-- 
    		
    		<s:iterator value="#session.list" var="t">
    		<a href="manage_toNotice?informationid=${t.informationid}" target="_blank">  
    		 <s:property value="#t.informationtitle"/><br/>  		
    		 </a>
    		  </s:iterator>
    		   -->
    		  </div>
    	</div>
    	</div>
    	<div id="right">
    	<s:url action="user_signin" var="signin"/>
    	<a href="${signin} " target="_blank">签到</a>
    	</div>
    	<div id="buttom">测试</div>
    </div>
  </body>
</html>
