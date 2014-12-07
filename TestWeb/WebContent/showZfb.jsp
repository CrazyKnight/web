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
<table width="80%" border="2" cellpadding="2" cellspacing="0">
		<tr>
		<td width="200px"><center><span style="color:Green"><font size=4 >流水号</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >日期</font></span></center></td>
		<td width="300px"><center><span style="color:Green"><font size=4 >名称</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >收入</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >支出</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >账户余额</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >详情</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4>Delete</font></span></center></td>
		</tr>
				<c:iterator value="#request.zfb_list" id="zfbTbl" status="st">
		<tr>
			<td width="200px"><center><c:property value="#zfbTbl.csmBNos"/></center></td>
			<td width="120px"><center><c:property value="#zfbTbl.times"/></center></td>
			<td width="300px"><center><c:property value="#zfbTbl.infos"/></center></td>
			<td width="20px"><center><c:property value="#zfbTbl.incomes"/></center></td>
			<td width="20px"><center><c:property value="#zfbTbl.outlays"/></center></td>
			<td width="20px"><center><c:property value="#zfbTbl.balances"/></center></td>
			<td width="20px"><center><c:property value="#zfbTbl.froms"/></center></td>
			<td width="20px"><center><a href="DeleteZfb?zfb_index=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>