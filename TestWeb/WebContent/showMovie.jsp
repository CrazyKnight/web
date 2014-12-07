<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电影</title>
</head>
<body>
<table width="80%" border="2" cellpadding="2" cellspacing="0">
		<tr>
		<td width="420px"><center><span style="color:Green"><font size=4 >片名</font></span></center></td>
		<td width="520px"><center><span style="color:Green"><font size=4 >主演</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >地区</font></span></center></td>
		<td width="300px"><center><span style="color:Green"><font size=4 >类型</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >评分</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4>Delete</font></span></center></td>
		</tr>
				<c:iterator value="#request.movie_list" id="movieTbl" status="st">
		<tr>
			<td width="420px"><center><c:property value="#movieTbl.name"/></center></td>
			<td width="520px"><center><c:property value="#movieTbl.actor"/></center></td>
			<td width="120px"><center><c:property value="#movieTbl.place"/></center></td>
			<td width="300px"><center><c:property value="#movieTbl.type"/></center></td>
			<td width="120px"><center><c:property value="#movieTbl.grade"/></center></td>
			<td width="120px"><center><a href="DeleteMovie?movie_index=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>