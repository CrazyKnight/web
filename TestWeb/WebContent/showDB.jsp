<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>豆瓣小组</title>
</head>
<body>
<table width="80%" border="2" cellpadding="2" cellspacing="0">
		<tr>
		<td width="400px"><center><span style="color:Green"><font size=4 >话题</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >作者</font></span></center></td>
		<td width="100px"><center><span style="color:Green"><font size=4 >回复数</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >最后回复</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4>Delete</font></span></center></td>
		</tr>
				<c:iterator value="#request.douban_list" id="doubanTbl" status="st">
		<tr>
			<td width="400px"><center><c:property value="#doubanTbl.topic"/></center></td>
			<td width="120px"><center><c:property value="#doubanTbl.author"/></center></td>
			<td width="100px"><center><c:property value="#doubanTbl.response"/></center></td>
			<td width="120px"><center><c:property value="#doubanTbl.last_re"/></center></td>
			<td width="20px"><center><a href="DeleteDB?db_index=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>