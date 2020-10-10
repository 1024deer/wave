<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.User" %>
<%@ page import="vo.Download" %>
<%@ page import="dao.DownloadDao"%>
<%@ page import="dao.UserDao"%>
<%@ page import="tools.JDBCUtil"%>
<%
	if(DownloadDao.dlist.size()==0){
			JDBCUtil downloaddbutil = new JDBCUtil();
			downloaddbutil.getDownloadList();
		}
	session.setAttribute("dlist",dao.DownloadDao.dlist);
	 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dwonload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/download.css">
  </head>
  
  <body style="background-image: url(images/bg.png);">
   <div id="head">
   	<div id="logo">
   		<img src="images/logo.png"/>
   	</div>
   	<div>
   		<div id="userinfo">     
   		<span>欢迎你： ${chrName} 
  	
  		</span><a href="login.html">【安全退出】</a>
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

   <div id="content"> 
  		<ul style="float:left;">
			<c:forEach items="${dlist}" var="Download" varStatus="index">
  			<li>
  				<div class="fileleft"><img class="fileimage" src="images/${Download.image}"/></div>
  				<div class="fileright">
  					<a class="button" href="servlet/download?id=${Download.id}">立即下载</a>
  					<span class="filetitle">&nbsp;&nbsp;${Download.name } </span>
  					<div></div>
  					<span class="smallsize">&nbsp;大小：${Download.size}MB</span>&nbsp;&nbsp;&nbsp;
  					<span class="smallsize">&nbsp;时间：2020-10-01 </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					<span class="smallsize">&nbsp;星级：<img class="smallstar" src="images/${Download.star}star.png"/>
					</span>&nbsp;&nbsp;&nbsp;<br/>
  					<span class="filedescription">${Download.description }</span>
  					
  				</div>
  			<hr style="height:1px;border:none;border-top:2px solid rgb(235,235,235); margin-left: 75px;" width="650px"  /> 
  			</li>
			</c:forEach>
  		</ul>
  		
		
   </div>
  </body>
</html>