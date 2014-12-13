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
<table border="1" cellpadding="2" cellspacing="0">
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download9?tindex=9">下载&nbsp</a>
        <a href="FileInput.jsp?index=9">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <tr>
           <s:iterator value="#request._list9" id="field" status="st">
            <s:if test="#field=='name'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete9?_index9=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
				<c:iterator value="#request.list9" id="movieTbl" status="st">
		<tr>
		<s:if test="#movieTbl.name!=null">
			<td width="420px"><center><c:property value="#movieTbl.name"/></center></td>
			</s:if>
			<s:if test="#movieTbl.actor!=null">
			<td width="520px"><center><c:property value="#movieTbl.actor"/></center></td>
			</s:if>
			<s:if test="#movieTbl.place!=null">
			<td width="120px"><center><c:property value="#movieTbl.place"/></center></td>
			</s:if>
			<s:if test="#movieTbl.type!=null">
			<td width="300px"><center><c:property value="#movieTbl.type"/></center></td>
			</s:if>
			<s:if test="#movieTbl.grade!=null">
			<td width="120px"><center><c:property value="#movieTbl.grade"/></center></td>
			</s:if>
			<td width="120px"><center><a href="delete9?index9=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>