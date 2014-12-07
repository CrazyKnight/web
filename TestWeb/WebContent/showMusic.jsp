<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>音乐排行榜</title>
</head>
<body>
<table width="80%" border="2" cellpadding="2" cellspacing="0">
		<tr>
		<td width="120px"><center><span style="color:Green"><font size=4 >本周名次</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >上周名词</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >进榜周数</font></span></center></td>
		<td width="500px"><center><span style="color:Green"><font size=4 >专辑名称</font></span></center></td>
		<td width="400px"><center><span style="color:Green"><font size=4 >单曲名称</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >歌手</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >发行公司</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >最高名次</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4>Delete</font></span></center></td>
		</tr>
				<c:iterator value="#request.Music_list" id="singTbl" status="st">
		<tr>
			<td width="120px"><center><c:property value="#singTbl.cur_week"/></center></td>
			<td width="120px"><center><c:property value="#singTbl.last_week"/></center></td>
			<td width="120px"><center><c:property value="#singTbl.num_week"/></center></td>
			<td width="500px"><center><c:property value="#singTbl.album"/></center></td>
			<td width="120px"><center><c:property value="#singTbl.song"/></center></td>
			<td width="400px"><center><c:property value="#singTbl.singer"/></center></td>
			<td width="120px"><center><c:property value="#singTbl.company"/></center></td>
			<td width="120px"><center><c:property value="#singTbl.top_his"/></center></td>
			<td width="120px"><center><a href="DeleteMusic?music_index=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>