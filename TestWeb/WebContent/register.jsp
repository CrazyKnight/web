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
     		<form name = "form2" method = "post" class = "loginForm" action="register.action" >
     			<p><label>请输入用户名</label><input type="text" name = "set_username" class="name" id="set_username"></p>
     			<p><label>请输入密码</label>&nbsp;&nbsp;<input type="password" name = "set_password" class="name" id="set_password"></p>
     			<p><label>请验证密码</label>&nbsp;&nbsp;<input type="password" name = "test_password" class="name"id="test_password"></p>
     			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			<input type="submit" name="register" class="dl" value="注册" id="register"/> 
       			<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      			<span style="color:Red">${Tip1 }</span>   					
     		</form>
     	</div>
     	<div class = "bottom">
     	</div>
     </div>
  </body>
</html>
