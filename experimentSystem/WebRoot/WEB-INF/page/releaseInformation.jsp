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
	<link rel="stylesheet" type="text/css" href="css/releaseInfo.css">
	<script type="text/javascript" src="js/manager.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">

		$(document).ready(function(){
  		$("#updateNotice,#addNotice").hide();
  		var msg = $("#mesg").val();
  		if(msg!=null&&msg!=""){
  			window.location.reload();
  			alert(msg);
  		}
  		
});
</script>
	
  </head>
  
  <body>
  <!-- 管理公告信息界面- -->
  	<div id="main"> 
  		<div id="head"> 管理员登录成功 <br></div>
  	
  	<div id="left">
  		<ul>
  			<li   onclick="showc();" style="cursor:hand;cursor:pointer" >查看所有公告</li>
  			<li  onclick="showu();" style="cursor:hand;cursor:pointer">修改公告</li>
  			<li  onclick="showa();" style="cursor:hand;cursor:pointer">添加公告</li>
  		</ul>
  	</div>
    <div id="right">
    
               <div id="daohang">
                     <s:url action="skip_relreaseInfo" var="relreaseInfo"/>
                      <a href="${relreaseInfo}" id="checked">信息发布</a>  
                   	  <s:url action="skip_labManager" var="labManger"/>
                      <a href="${labManger}" >实验室管理</a>  
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
               
               
               <div id="showAll">
               		<table align="left" border="1" width="690">
               			<tr>
               				<td width="300">标题</td>
               				<td  width="300">内容</td>
               				<td width="90">操作</td>
               			</tr>
	               		<s:iterator value="list" var="i">
	               		  <tr>
	               			<td>
	               				${i.informationtitle}
	               			</td>
	               			<td>
	               				${i.information}
	               			</td>
	               			<td>	               		
	               				<input type="hidden" id="mesg" value="${message}"/>		
	               				<s:url action="manage_del" var="del"/>
                      			<a href="${del}?informationid=${i.informationid}" onclick="return confirm('确认删除?')">删除</a>  
	               				<!-- 
	               				<s:url action="skip_updateInfo" var="update"/>
                      			<a href="${update}?informationid=${i.informationid}">修改</a>       	
                      			
                      			
                      			 <a onclick="test(${i.informationid})">修改</a>		
                      			 -->
	               			</td>
	               		  </tr>
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="updateNotice">
               		<table align="left" border="1" width="680">
               			<tr>
               				<td width="300">标题</td>
               				<td  width="300">内容</td>
               				<td width="80">操作</td>
               			</tr>
	               		<s:iterator value="list" var="i">
	               		  <tr>
	               			<td>
	               			<!-- 
	               				<input type="text" name="informationtitle" height="50" width="80" value="${i.informationtitle}"> 
	               				 -->
	               				<textarea rows="3" cols="25" id="infotitle${i.informationid}">${i.informationtitle}</textarea>
	               			</td>
	               			<td>
	               				
	              				<textarea rows="3" cols="25" id="info${i.informationid}">${i.information}</textarea>
	               			</td>
	               			<td>	               		
	               				
	               				
                      			
                      			 <a onclick="update(${i.informationid})" style="cursor:hand;cursor:pointer">修改</a>		
                      			
	               			</td>
	               		  </tr>
	               		</s:iterator>
	               		
               		</table>
               </div>
               <div id="addNotice">
               		
               			<s:textfield label="公告标题" name="informationtitle" id="informationtitle"/><br/>
               			<s:textarea label="公告内容" labelposition="top" name="information" id="informations" cols="20" rows="10" />               			
               			<s:submit value="添加" onclick="addInfo();"/>
               			<s:reset value="重置"/>
               			
               	
               </div>
               
               
               
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
 
</html>
