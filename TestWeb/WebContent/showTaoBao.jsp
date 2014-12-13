<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>淘宝购物单</title>
</head>
<body >

    <table border="1" cellpadding="2" cellspacing="0">
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download2?tindex=2">下载&nbsp</a>
        <a href="FileInput.jsp?index=2">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <tr>
            <s:iterator value="#request._list2" id="field" status="st">
            <s:if test="#field=='baobeiNames'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete2?_index2=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
				<c:iterator value="#request.list2" id="taobaoTbl" status="st">
		<tr>
		      <s:if test="#taobaoTbl.baobeiNames!=null">
			<td width="400px"><center><c:property value="#taobaoTbl.baobeiNames"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.numItem!=null">
			<td width="120px"><center><c:property value="#taobaoTbl.numItem"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.shops!=null">
			<td width="120px"><center><c:property value="#taobaoTbl.shops"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.Specs!=null">
			<td width="120px"><center><c:property value="#taobaoTbl.Specs"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.qutys!=null">
			<td width="20px"><center><c:property value="#taobaoTbl.qutys"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.prices!=null">
			<td width="20px"><center><c:property value="#taobaoTbl.prices"/></center></td>
			</s:if>
			<s:if test="#taobaoTbl.baobeiNames!=null">
			<td width="20px"><center><a href="delete2?index2=${st.index }">删除</a></center></td>
			</s:if>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>