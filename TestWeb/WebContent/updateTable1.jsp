<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>教务处成绩单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>


	<form name="f1" id="f1" action="<%=path%>/update1" method="post">
		<table border="0" width="60%">

			<h1>
				<span style="color: Teal">请输入您要更新的成绩信息：</span>
			</h1>
			<h3>
				<span style="color: Red">${tipUpdate}</span>
			</h3>
			<tr>
				<td>课程号*</td>
				<td><input type="text" name="newlessonNum"></td>
			</tr>
			<tr>
				<td>学期*</td>
				<td><input type="text" name="newterm"></td>
			</tr>

			<tr>
				<td>课程名*</td>
				<td><input type="text" name="newlessonName"></td>
			</tr>
			<tr>
				<td>授课教师*</td>
				<td><input type="text" name="newtecherName"></td>
			</tr>
			<tr>
				<td>类别*</td>
				<td><input type="text"></td>
			</tr>

			<tr>
				<td>分数*</td>
				<td><input type="text" name="newgrade"></td>
			</tr>
			<tr>
				<td>学时*</td>
				<td><input type="text" name="newtime"></td>
			</tr>
			<tr>
				<td>成绩*</td>
				<td><input type="text" name="newmyPoint"></td>
			</tr>
			<tr>
				<td>成绩类别</td>
				<td><input type="text" name="newgradeKind"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="newremark"></td>
			</tr>
			<td colspan="2" align="center"><input type="submit" value="提交"></td>
			<br>


		</table>
		<br>
	</form>
	<form action="show1">
		<td colspan="2" align="center"><input type="submit"
			value="跳到成绩单查询界面"></td>
		<td width="200px"><a href="welcome.jsp">返回主界面</a></td>
	</form>
</body>
</html>