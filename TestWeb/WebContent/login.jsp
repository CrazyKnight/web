<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel = "stylesheet" type = "text/css" href = "login.css"/>

  </head>
  
  <body>
     <div id = "main">
     	<div class = "top">
     		<form name = "form1" method = "post" class = "loginForm" action="login.action" >
     			<p><label>用户名</label><input type="text" name = "username" class="name" id="username"></p>
     			<p><label>密 &nbsp;码</label><input type="password" name = "password" class="name" id="password"></p>
     			<br>
       			<input type="submit" name="login" class="dl" value="登陆" id="login"/>
       			&nbsp;&nbsp;&nbsp;
       			<input type="button" name="regis" class="dr"  id="regis" onclick="window.location.href='register.jsp'" value="注册"/>
       			<br>
       			<br>
       			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      			<span style="color:Red">${Tip }</span>
     		</form>
     	</div>
     	<div class = "bottom">
     	</div>
     </div>
  </body>
</html>
