 <%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">

  </head>
  
  <body style="background-image: url(images/bg.png);">
   <div id="head">
   	<div id="logo">
   		<img src="images/logo.png"/>
   	</div>
   	<div>
   		<div id="userinfo">     
   		<span>欢迎你： ${chrName} 
	
		</span><a href="servlet/LogoutController.do">【安全退出】</a>
   		</div>
   		<div id="daohang">
			<ul>
				<li><a class="aaa"  href="user.jsp">个人中心</a></li>
				<li><a class="aaa"  href="downloadManage.jsp">资源管理</a></li>
				<li><a class="aaa"  href="userManage.jsp">用户管理</a></li>
				<li><a class="aaa" href="download.jsp">资源下载</a></li>
				<li><a class="aaa" href="main.jsp">首页</a></li>
			</ul>
   		</div>
   	</div>
   </div>
   </div>
   <div id="content">
			用户管理，开发中。。。
   	
    </div>


		

  </body>
</html>
