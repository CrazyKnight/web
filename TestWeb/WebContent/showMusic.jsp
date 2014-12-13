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
<table border="1" cellpadding="2" cellspacing="0">
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download7?tindex=7">下载&nbsp</a>
        <a href="FileInput.jsp?index=7">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <tr>
            <s:iterator value="#request._list7" id="field" status="st">
            <s:if test="#field=='song'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete7?_index7=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
				<c:iterator value="#request.list7" id="singTbl" status="st">
		<tr>
		    <s:if test="#singTbl.cur_week!=null">
			<td width="120px"><center><c:property value="#singTbl.cur_week"/></center></td>
			</s:if>
			<s:if test="#singTbl.last_week!=null">
			<td width="120px"><center><c:property value="#singTbl.last_week"/></center></td>
			</s:if>
			<s:if test="#singTbl.num_week!=null">
			<td width="120px"><center><c:property value="#singTbl.num_week"/></center></td>
			</s:if>
		     <s:if test="#singTbl.album!=null">
			<td width="500px"><center><c:property value="#singTbl.album"/></center></td>
			</s:if>
			<s:if test="#singTbl.song!=null">
			<td width="120px"><center><c:property value="#singTbl.song"/></center></td>
			</s:if>
			<s:if test="#singTbl.singer!=null">
			<td width="400px"><center><c:property value="#singTbl.singer"/></center></td>
			</s:if>
			<s:if test="#singTbl.company!=null">
			<td width="120px"><center><c:property value="#singTbl.company"/></center></td>
			</s:if>
			<s:if test="#singTbl.top_his!=null">
			<td width="120px"><center><c:property value="#singTbl.top_his"/></center></td>
			</s:if>
			<td width="120px"><center><a href="delete7?index7=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>