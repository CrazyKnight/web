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

<title>成绩单</title>

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
	<a href="welcome.jsp">返回主菜单&nbsp</a>
	<a href="download1?tindex=1">下载&nbsp</a>
    <a href="FileInput.jsp?index=1">上传文件&nbsp </a>
	 <p> <span style="color:Red">${download }</span></p>
	<table border="1" cellpadding="2" cellspacing="0">
		<tr>
			<s:iterator value="#request._list1" id="field" status="st">
			<s:if test="#field=='lessonNum'"> <td><center><s:property /></center></td></s:if>
			<s:else> <td><center>
						<a href="_delete1?_index1=${st.index }"><s:property /></a>
					</center></td>
			</s:else>
			</s:iterator>
			<td width="100px"><center>操作</center></td>
		</tr>
		<s:iterator value="#request.list1" id="GradeTbl" status="st">
			<tr>
				<s:if test="#GradeTbl.term!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.term" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.lessonNum!=null">
					<td width="150px"><center>
							<s:property value="#GradeTbl.lessonNum" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.lessonName!=null">
					<td width="200px"><center>
							<s:property value="#GradeTbl.lessonName" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.techerName!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.techerName" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.kind!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.kind" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.grade!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.grade" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.time!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.time" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.myPoint!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.myPoint" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.gradeKind!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.gradeKind" />
						</center></td>
				</s:if>
				<s:if test="#GradeTbl.remark!=null">
					<td width="100px"><center>
							<s:property value="#GradeTbl.remark" />
						</center></td>
				</s:if>
				<td width="100px"><center>
						<a href="delete1?index1=${st.index }">删除</a>
					</center></td>
			</tr>
		</s:iterator>

	</table>
</body>
</html>