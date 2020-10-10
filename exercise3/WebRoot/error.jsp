<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/error.css">
  </head>
    <body onload="startTime()">
    	<div id="left">
    		<img src="images/error.png"/>
    		
    	</div>
    	<div id="right">
    		<h2>
				${error_1}
			</h2>
    		<h1><span id="txt"></span>秒后自动返回登录页面</h2>
    		<h1><span>不能跳转，请</span><a style="color: red; " href="login.html">点击这里</a></h1>
    	</div>
		<script type="text/javascript" src="js/error.js"></script>
    </body>
</html>
