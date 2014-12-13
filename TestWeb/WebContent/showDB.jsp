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
<table border="1" cellpadding="2" cellspacing="0">
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download5?tindex=5">下载&nbsp</a>
        <a href="FileInput.jsp?index=5">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <tr>
            <s:iterator value="#request._list5" id="field" status="st">
            <s:if test="#field=='topic'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete5?_index5=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
				<c:iterator value="#request.list5" id="doubanTbl" status="st">
		<tr>
		    <s:if test="#doubanTbl.topic!=null">
			<td width="400px"><center><c:property value="#doubanTbl.topic"/></center></td>
			</s:if>
			<s:if test="#doubanTbl.author!=null">
			<td width="120px"><center><c:property value="#doubanTbl.author"/></center></td>
			</s:if>
			<s:if test="#doubanTbl.response!=null">
			<td width="100px"><center><c:property value="#doubanTbl.response"/></center></td>
			</s:if>
			<s:if test="#doubanTbl.last_re!=null">
			<td width="120px"><center><c:property value="#doubanTbl.last_re"/></center></td>
			</s:if>
			<td width="20px"><center><a href="delete5?index5=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>