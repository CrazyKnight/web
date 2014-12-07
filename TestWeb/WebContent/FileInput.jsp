<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>上传文件</title>
</head>
<%
	String index = (String)request.getParameter("index");
	request.getSession().setAttribute("index",index);
%>
<body bgcolor="white" text="#FF0000" background="./image/1.jpg">
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="fileinput" method="post" enctype="multipart/form-data">
		<table width="20%" border="0" cellpadding="20" cellspacing="0" >
			<tr>
				<td width="120px"><input type="file" name="html" ></td>
			</tr>
			<tr>
				<td width="120px"><input type="submit" name="grade" value="提交"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>