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
	<link rel="stylesheet" type="text/css" href="css/experiment.css">
	<script type="text/javascript" src="js/manager.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="js/experiment.js"></script>
	<script type="text/javascript" >
		$(document).ready(function(){
			for(var i=1;i<=4;i++){
				for(var j=1;j<=7;j++){
					$("#root"+i+"_child"+j).hide();
				}
			}
		});
	</script>
  </head>
  
  <body>
  	<div id="main"> 
  		<div id="head"> 管理员登录成功 <br></div>
  	
  	<div id="left">
  		<div id="root1" class="root"><img alt="展开/合并" src="images/plus.png" width="20px" height="18px" onclick="changeShowOrHide(this,show1);"/>信息管理</div>
  			<div id="show1" class="show">
		  		<div class="child" onclick="showOrHide(root1_child1);">实验室利用率</div>
		  		<div class="child" onclick="showOrHide(root1_child2);">实验室运行记录</div>
		  		<div  class="child" onclick="showOrHide(root1_child3);">实验室开放运行记录</div>
  			</div>
  			
  		
  		<div id="root2" class="root"><img alt="展开/合并" src="images/plus.png" width="20px" height="18px" onclick="changeShowOrHide(this,show2);"/>实验设备管理</div>
  			<div id="show2" class="show">
		  		<div  class="child" onclick="showOrHide(root2_child1);">仪器设备</div>
		  		<div  class="child" onclick="showOrHide(root2_child2);">维护申请</div>
		  		<div  class="child" onclick="showOrHide(root2_child3);">仪器设备验收</div>
		  		<div class="child" onclick="showOrHide(root2_child4);">仪器设备损坏报告</div>
  			</div>
  		
  		<div id="root3" class="root"><img alt="展开/合并" src="images/plus.png" width="20px" height="18px" onclick="changeShowOrHide(this,show3);"/>实验系统管理</div>
  			<div id="show3" class="show">
		  		<div class="child" onclick="showOrHide(root3_child1);">规章制度</div>
		  		<div  class="child" onclick="showOrHide(root3_child2);">实验室分布与功能</div>
		  		<div  class="child" onclick="showOrHide(root3_child3);">实验管理人员</div>
		  		<div class="child" onclick="showOrHide(root3_child4);">实验教学人员</div>
  			</div>
  		
  		<div id="root4" class="root">
  			<img alt="展开/合并" src="images/plus.png" width="20px" height="18px" onclick="changeShowOrHide(this,show4);"/>实验教学管理
  		</div>
  			<div id="show4" class="show">
		  		<div  class="child" onclick="showOrHide(root4_child1);">实验课程表</div>
		  		<div  class="child" onclick="showOrHide(root4_child2);">实验教学计划</div>
		  		<div  class="child" onclick="showOrHide(root4_child3);">实验报告</div>
		  		<div  class="child" onclick="showOrHide(root4_child4);">实验开放</div>
		  		<div  class="child" onclick="showOrHide(root4_child5);">实验项目设计</div>
		  		<div  class="child" onclick="showOrHide(root4_child6);">学生管理</div>
		  		<div  class="child" onclick="showOrHide(root4_child7);">科研成果(获奖证书)</div>
  			</div>
  	</div>
    <div id="right">
    
               <div id="daohang">
               		  <s:url action="skip_relreaseInfo" var="relreaseInfo"/>
                      <a href="${relreaseInfo}" >信息发布</a> 
                      <s:url action="skip_labManager" var="labManger"/>
                      <a href="${labManger}">实验室管理</a>  
                   	  <s:url action="skip_experimentManger" var="experimentManger"/>
                      <a href="${experimentManger}" id="checked">实验管理</a>
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
               
               <div id="root1_child1" class="content">1ddd</div>
               <div id="root1_child2" class="content">2ddd</div>
               <div id="root1_child3" class="content">
               	 <a href="download.action?fileName=临沂大学开放实验室预约申请表.doc" style="text-decoration:underline" title="下载">临沂大学开放实验室预约申请表.doc</a> 
               </div>   	
               
               <div id="root2_child1" class="content">21</div>
               <div id="root2_child2" class="content">22</div>
               <div id="root2_child3" class="content">23</div>
               <div id="root2_child4" class="content">24</div>
               
               <div id="root3_child1" class="content">22</div>
               <div id="root3_child2" class="content">33</div>
               <div id="root3_child3" class="content">44</div>
               <div id="root3_child4" class="content">55</div>
               
                <div id="root4_child1" class="content">66</div>
                <div id="root4_child2" class="content">77</div>
                <div id="root4_child3" class="content"></div>
                <div id="root4_child4" class="content"></div>
                <div id="root4_child5" class="content"></div>
                <div id="root4_child5" class="content"></div>
                <div id="root4_child7" class="content"></div>
    </div>
    <div id="buttom"></div>
    </div> 
  </body>
</html>
