<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝支付记录</title>
</head>
<body >
 <table border="1" cellpadding="2" cellspacing="0">
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download3?tindex=3">下载&nbsp</a>
        <a href="FileInput.jsp?index=3">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <tr>
            <s:iterator value="#request._list3" id="field" status="st">
            <s:if test="#field=='csmBNos'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete3?_index3=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
				<c:iterator value="#request.list3" id="zfbTbl" status="st">
		<tr>
		<s:if test="#zfbTbl.csmBNos!=null">
			<td width="200px"><center><c:property value="#zfbTbl.csmBNos"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.times!=null">
			<td width="120px"><center><c:property value="#zfbTbl.times"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.infos!=null">
			<td width="300px"><center><c:property value="#zfbTbl.infos"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.incomes!=null">
			<td width="20px"><center><c:property value="#zfbTbl.incomes"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.outlays!=null">
			<td width="20px"><center><c:property value="#zfbTbl.outlays"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.balances!=null">
			<td width="20px"><center><c:property value="#zfbTbl.balances"/></center></td>
			</s:if>
			<s:if test="#zfbTbl.froms!=null">
			<td width="20px"><center><c:property value="#zfbTbl.froms"/></center></td>
			</s:if>
			<td width="20px"><center><a href="delete3?index3=${st.index }">删除</a></center></td>
			</tr>
		</c:iterator>		
</table>
</body>
</html>